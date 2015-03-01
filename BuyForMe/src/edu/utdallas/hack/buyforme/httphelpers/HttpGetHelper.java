package edu.utdallas.hack.buyforme.httphelpers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class HttpGetHelper extends AsyncTask<URI, Integer, String> {

	@Override
	protected String doInBackground(URI... params) {
		HttpClient client = new DefaultHttpClient();
		String responseString = null;
		try {
			HttpResponse response = client.execute(new HttpGet(params[0]));
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				response.getEntity().writeTo(outStream);
				responseString = outStream.toString();
				outStream.close();
			}
			else {
				response.getEntity().getContent().close();
				Log.e(getClass().getName(), "HTTP GET failed for "
						+ params[0].toASCIIString());
			}
		} catch (ClientProtocolException e) {
			Log.e(getClass().getName(), e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			Log.e(getClass().getName(), e.getMessage());
			e.printStackTrace();
		}
		return responseString;
	}

}
