package com.web.automation.scripts;

import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import com.fasterxml.jackson.core.JsonFactory;
import com.gargoylesoftware.htmlunit.javascript.host.Map;
import com.google.gson.Gson;

import groovy.json.JsonParser;
import io.appium.java_client.pagefactory.utils.ProxyFactory;
import net.minidev.json.JSONObject;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;

public class API {

	public API() {
		// TODO Auto-generated constructor stub
		

		  try {

				
				
				
				/*//POST
			  DefaultHttpClient httpClient1 = new DefaultHttpClient();
				HttpPost postReq = new HttpPost(
						"https://app.qacomplete.smartbear.com/rest-api/service/api/v2/projects/106798/testruns");
				postReq.addHeader("accept", "application/json");
				postReq.addHeader("Authorization", "Basic c3lhbWt1bWFyLmJtQGNpZ25pdGkuY29tOkNpZ25pdGkxMjM=");
				
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				pairs.add(new BasicNameValuePair("TestId", "5120088"));
				postReq.setEntity(new UrlEncodedFormEntity(pairs ));			
				HttpResponse response1 = httpClient1.execute(postReq);
				
				
				if (response1.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response1.getStatusLine().getStatusCode());
				}

				BufferedReader br1 = new BufferedReader(
		                         new InputStreamReader((response1.getEntity().getContent())));

				String output1;
				StringBuilder stringBuilder = new StringBuilder();
				System.out.println("Output from Server .... \n");
				while ((output1 = br1.readLine()) != null) {
					System.out.println(output1);
					stringBuilder.append(output1);
				}
				
				String result1 = stringBuilder.toString();
				System.out.println("Hello");
				
				httpClient1.getConnectionManager().shutdown();*/
				
				//GET
				DefaultHttpClient httpClient2 = new DefaultHttpClient();
				
				HttpGet getRequest = new HttpGet(
				"https://app.qacomplete.smartbear.com/rest-api/service/api/v2/projects/106798/testruns/916823/items");
				getRequest.addHeader("accept", "application/json");
				getRequest.addHeader("Authorization", "Basic c3lhbWt1bWFyLmJtQGNpZ25pdGkuY29tOkNpZ25pdGkxMjM=");
				HttpResponse response2 = httpClient2.execute(getRequest);
				
				if (response2.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response2.getStatusLine().getStatusCode());
				}

				BufferedReader br2 = new BufferedReader(
		                         new InputStreamReader((response2.getEntity().getContent())));

				String output2;
				StringBuilder stringBuilder = new StringBuilder();
				System.out.println("Output from Server .... \n");
				while ((output2 = br2.readLine()) != null) {
					System.out.println(output2);
					stringBuilder.append(output2);
				}
				String result1 = stringBuilder.toString();
				
				
			
				
				
			/*	JSONParser parse1 = JSONParser();
				JSONObject jobj = (JSONObject)parse1.parse(result1);
				JSONArray jarray = (JSONArray)jobj.get("results");
				JSONObject jobj_1 = (JSONObject)jobj_1.get(0);
				String TestId = (String) jobj_1.get("id");
				*/
				
				httpClient2.getConnectionManager().shutdown();
				
				/*//PATCH
				DefaultHttpClient httpClient3 = new DefaultHttpClient();
				HttpPatch patchReq = new HttpPatch(
						"https://app.qacomplete.smartbear.com/rest-api/service/api/v2/projects/106798/testruns/916616/items/5191504");
				patchReq.addHeader("accept", "application/json");
				patchReq.addHeader("Authorization", "Basic c3lhbWt1bWFyLmJtQGNpZ25pdGkuY29tOkNpZ25pdGkxMjM=");
				
				List<NameValuePair> pairs1 = new ArrayList<NameValuePair>();
				pairs1.add(new BasicNameValuePair("StatusCode", "Passed"));
				patchReq.setEntity(new UrlEncodedFormEntity(pairs1));
				HttpResponse response3 = httpClient3.execute(patchReq);
				
				

				if (response3.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response3.getStatusLine().getStatusCode());
				}

				BufferedReader br3 = new BufferedReader(
		                         new InputStreamReader((response3.getEntity().getContent())));

				String output3;
				System.out.println("Output from Server .... \n");
				while ((output3 = br3.readLine()) != null) {
					System.out.println(output3);
				}

				httpClient3.getConnectionManager().shutdown();*/

			  } catch (ClientProtocolException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();
			  }

			}

	

}


		
		

	
	/*public String sendJSONData(String message) throws Exception {

        //creating map object to create JSON object from it
		Map< String, Object >jsonValues = new HashMap< String, Object >();
		jsonValues.put("param1", message);
		
		JSONObjectjson = new JSONObject(jsonValues);
		String url = "http://Yout_URL";
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("Accept", "application/json");
		post.setHeader("headerValue", "HeaderInformation");
		//setting json object to post request.
		StringEntity entity = new StringEntity(json.toString(), "UTF8");
		entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		post.setEntity(entity);
		//this is your response:
		HttpResponse response = client.execute(post);
		System.out.println("Response: " + response.getStatusLine());
		        return response.getStatusLine().toString();
		    }*/
	
		
		
				
		
	



