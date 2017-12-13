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
//import net.minidev.json.JSONObject;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
//import org.json.JSONArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class API {

	public API() {
		// TODO Auto-generated constructor stub
		

	}

	public static void main(String[] args) {
		
	
		
		 try {
			 
			 
			 	/*DefaultHttpClient httpClient1 = new DefaultHttpClient();
				
				HttpGet getRequest = new HttpGet(
				"https://venugopalkadiri.qtestnet.com/api/v3/projects/64875/test-cases/17011735");
				getRequest.addHeader("accept", "application/json");
				getRequest.addHeader("Authorization", "dmVudWdvcGFsa2FkaXJpfHZlbnVnb3BhbC5rYWRpcmlAY2lnbml0aS5jb206MTU0NDYyNjgxNTEyNjplNThkNDYzZmFiMzI3ZTRhOGNiZTkzOGU5YTExMDAwNQ=");
				HttpResponse response1 = httpClient1.execute(getRequest);
				
				if (response1.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response1.getStatusLine().getStatusCode());
				}

				BufferedReader br1 = new BufferedReader(
		                         new InputStreamReader((response1.getEntity().getContent())));

				String output1;
				StringBuilder stringBuilder1 = new StringBuilder();
				System.out.println("Output from Server .... \n");
				while ((output1 = br1.readLine()) != null) {
					System.out.println(output1);
					stringBuilder1.append(output1);
				}
				String result1 = stringBuilder1.toString();
				
				
				
					
				JSONParser parse = new JSONParser();
				JSONObject jobj = (JSONObject)parse.parse(result1);
				Long TestId1 = (Long) jobj.get("test_case_version_id");
				
				
				System.out.println(TestId1);
				
				httpClient1.getConnectionManager().shutdown();*/
			 
			 
				
				
				/*DefaultHttpClient httpClient2 = new DefaultHttpClient();
				
				HttpGet getRequest = new HttpGet(
				"https://venugopalkadiri.qtestnet.com/api/v3/projects/64875/test-cases/17011735/versions/19960954/test-steps?expand=");
				getRequest.addHeader("accept", "application/json");
				getRequest.addHeader("Authorization", "dmVudWdvcGFsa2FkaXJpfHZlbnVnb3BhbC5rYWRpcmlAY2lnbml0aS5jb206MTU0NDYyNjgxNTEyNjplNThkNDYzZmFiMzI3ZTRhOGNiZTkzOGU5YTExMDAwNQ=");
				HttpResponse response2 = httpClient2.execute(getRequest);
				
				if (response2.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response2.getStatusLine().getStatusCode());
				}

				BufferedReader br2 = new BufferedReader(
		                         new InputStreamReader((response2.getEntity().getContent())));

				String output2;
				StringBuilder stringBuilder2 = new StringBuilder();
				System.out.println("Output from Server .... \n");
				while ((output2 = br2.readLine()) != null) {
					System.out.println(output2);
					stringBuilder2.append(output2);
				}
				String result2 = stringBuilder2.toString();
				
				
				
					
				JSONParser parse = new JSONParser();
				JSONArray jobj = (JSONArray)parse.parse(result2);
				JSONObject s1 = (JSONObject)jobj.get(0);
				Long TestId2 = (Long) s1.get("id");
				
				System.out.println(TestId2);
				httpClient2.getConnectionManager().shutdown();*/
				
				
			 	/*DefaultHttpClient httpClient3 = new DefaultHttpClient();
				HttpPost postReq = new HttpPost(
						"https://venugopalkadiri.qtestnet.com/api/v3/projects/64875/test-runs/29562565/test-logs");
				postReq.addHeader("accept", "application/json");
				postReq.addHeader("Content-Type", "application/json");
				postReq.addHeader("Authorization", "dmVudWdvcGFsa2FkaXJpfHZlbnVnb3BhbC5rYWRpcmlAY2lnbml0aS5jb206MTU0NDYyNjgxNTEyNjplNThkNDYzZmFiMzI3ZTRhOGNiZTkzOGU5YTExMDAwNQ=");
				
				//using NameValuePairt to send body data
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				pairs.add(new BasicNameValuePair("exe_start_date", "2017-12-12T10:40:50+00:00"));
				pairs.add(new BasicNameValuePair("exe_end_date", "2017-12-12T10:40:50+00:00"));
				pairs.add(new BasicNameValuePair("test_case_version_id", "19960954"));
				pairs.add(new BasicNameValuePair("status", Integer.toString(601)));
				postReq.setEntity(new UrlEncodedFormEntity(pairs));
				
				//using JSON object to send body data
				Integer s = 601;
				String s1 = "601";				
				JSONObject jj = new JSONObject();
				jj.put("exe_start_date","2017-12-12T10:40:50+00:00");
				jj.put("exe_end_date","2017-12-12T10:40:50+00:00");
				jj.put("test_case_version_id","19960954");
				jj.put("status",Integer.parseInt(s1.trim()));				
				StringEntity entityForPost = new StringEntity(jj.toString());				
				postReq.setEntity(entityForPost);
				
				HttpResponse response3 = httpClient3.execute(postReq);
							
				if (response3.getStatusLine().getStatusCode() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response3.getStatusLine().getStatusCode());
				}				
				
				httpClient3.getConnectionManager().shutdown();*/
			 
			 
			 
			//QA Complete
			 
			//POST
			 DefaultHttpClient httpClient1 = new DefaultHttpClient();
			HttpPost postReq = new HttpPost(
					"https://app.qacomplete.smartbear.com/rest-api/service/api/v2/projects/106798/testruns");
			postReq.addHeader("accept", "application/json");
			postReq.addHeader("Authorization", "Basic c3lhbWt1bWFyLmJtQGNpZ25pdGkuY29tOkNpZ25pdGkxMjM=");
			
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("TestId", "5120088"));
			postReq.setEntity(new UrlEncodedFormEntity(pairs ));	
			
			/*//JSON
			JSONObject jj1 = new JSONObject();
			jj1.put("TestId","5120088");							
			StringEntity entityForPost = new StringEntity(jj1.toString());				
			postReq.setEntity(entityForPost);*/
			
			HttpResponse response1 = httpClient1.execute(postReq);
						
			if (response1.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response1.getStatusLine().getStatusCode());
			}

			BufferedReader br1 = new BufferedReader(
	                         new InputStreamReader((response1.getEntity().getContent())));

			String output1;
			StringBuilder stringBuilder1 = new StringBuilder();
			System.out.println("Output from Server .... \n");
			while ((output1 = br1.readLine()) != null) {
				System.out.println(output1);
				stringBuilder1.append(output1);
			}
			
			String result1 = stringBuilder1.toString();
			
			
			JSONParser parse1 = new JSONParser();
			JSONObject jobj1 = (JSONObject)parse1.parse(result1);
			//JSONArray jarray1 = (JSONArray)jobj1.get("id");
			
			//JSONObject jobj1_1 = (JSONObject)jarray1.get(0);
			Long TestId1 = (Long) jobj1.get("id");
			
			
			System.out.println(TestId1);
			
			
			httpClient1.getConnectionManager().shutdown();
			
			 
			 
			//GET
			DefaultHttpClient httpClient2 = new DefaultHttpClient();
			
			HttpGet getRequest = new HttpGet(
			"https://app.qacomplete.smartbear.com/rest-api/service/api/v2/projects/106798/testruns/" + TestId1 + "/items");
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
			StringBuilder stringBuilder2 = new StringBuilder();
			System.out.println("Output from Server .... \n");
			while ((output2 = br2.readLine()) != null) {
				System.out.println(output2);
				stringBuilder2.append(output2);
			}
			String result2 = stringBuilder2.toString();
			
			
			
				
			JSONParser parse = new JSONParser();
			JSONObject jobj = (JSONObject)parse.parse(result2);
			JSONArray jarray = (JSONArray)jobj.get("results");
			
			JSONObject jobj_1 = (JSONObject)jarray.get(0);
			Long TestId2 = (Long) jobj_1.get("id");
			
			
			System.out.println(TestId2);
			
			httpClient2.getConnectionManager().shutdown();
			
			//PATCH
			DefaultHttpClient httpClient3 = new DefaultHttpClient();
			HttpPatch patchReq = new HttpPatch(
					"https://app.qacomplete.smartbear.com/rest-api/service/api/v2/projects/106798/testruns/"+TestId1+"/items/"+TestId2);
			patchReq.addHeader("accept", "application/json");
			patchReq.addHeader("Content-Type", "application/json");
			patchReq.addHeader("Authorization", "Basic c3lhbWt1bWFyLmJtQGNpZ25pdGkuY29tOkNpZ25pdGkxMjM=");
			
			List<NameValuePair> pairs1 = new ArrayList<NameValuePair>();
			pairs1.add(new BasicNameValuePair("StatusCode", "Passed"));
			
			/*List<NameValuePair> pairs2 = new ArrayList<NameValuePair>();
			pairs2.add(new BasicNameValuePair("StepName", "step1"));
			pairs2.add(new BasicNameValuePair("StatusCode", "Failed"))*/;
			
			
			//JSON
			JSONObject jj = new JSONObject();
			jj.put("StatusCode","Passed");							
			StringEntity entityForPost1 = new StringEntity(jj.toString());				
			patchReq.setEntity(entityForPost1);
			
			//patchReq.setEntity(new UrlEncodedFormEntity(pairs1));
			//patchReq.setEntity(new UrlEncodedFormEntity(pairs2));
			HttpResponse response3 = httpClient3.execute(patchReq);
			
			
			if (response3.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response3.getStatusLine().getStatusCode());
			}

			BufferedReader br3 = new BufferedReader(
	                         new InputStreamReader((response3.getEntity().getContent())));
			
			String output3;
			StringBuilder stringBuilder3 = new StringBuilder();
			System.out.println("Output from Server .... \n");
			while ((output3 = br3.readLine()) != null) {
				System.out.println(output3);
				stringBuilder3.append(output3);
			}
			String result3 = stringBuilder3.toString();
			
			httpClient3.getConnectionManager().shutdown();
			
			
			
			

		  } catch (ClientProtocolException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();
		  
		  } catch (ParseException e) {
			// TODO Auto-generated catch block
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
	
		
		
				
		
	



