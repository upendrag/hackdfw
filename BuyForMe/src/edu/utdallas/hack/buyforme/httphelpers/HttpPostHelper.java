package edu.utdallas.hack.buyforme.httphelpers;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import edu.utdallas.hack.buyforme.entities.HttpPostEntity;
import android.os.AsyncTask;
import android.util.Log;

public class HttpPostHelper extends AsyncTask<HttpPostEntity, Integer, Boolean> {

	@Override
	protected Boolean doInBackground(HttpPostEntity... params) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(params[0].getHttpUrl());
		httpPost.setEntity(params[0].getHttpFormEntity());
		try {
			HttpResponse response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return true;
			}
			else {
				response.getEntity().getContent().close();
				Log.e(getClass().getName(), "HTTP POST failed for "
						+ params[0].getHttpUrl().toASCIIString());
			}
		} catch (ClientProtocolException e) {
			Log.e(getClass().getName(), e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			Log.e(getClass().getName(), e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

}
