package com.web.automation.scripts;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;



public class dsfsdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s1="2017-12-12T10:40:50+00:00";
		//String s2="2017-12-12T10:40:50+00:00";
		
		/*Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);*/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string1  = dateFormat.format(new Date());
        //System.out.println(string);
        
        String[] words1=string1.split("\\s");
        		
        
        //18-12-2017 12:30:50
        String stTIme = words1[0]+"T"+words1[1]+"+00:00";
        
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string2  = dateFormat2.format(new Date());
        String[] words2=string2.split("\\s");
        
        String endTIme = words2[0]+"T"+words2[1]+"+00:00";
        DefaultHttpClient httpClient3 = new DefaultHttpClient();
		HttpPost postReq = new HttpPost(
				"https://venugopalkadiri.qtestnet.com/api/v3/projects/65179/test-runs/29753882/test-logs");
		//HttpPost postReq = new HttpPost(config_prop.getProperty("qTest_API")+ "projects/" + config_prop.getProperty("qTest_Project")+ "/test-runs/" +config_prop.getProperty("qTest_TestRunId") + "/test-logs");
		postReq.addHeader("accept", "application/json");
		postReq.addHeader("Content-Type", "application/json");
		postReq.addHeader("Authorization", "dmVudWdvcGFsa2FkaXJpfHZlbnVnb3BhbC5rYWRpcmlAY2lnbml0aS5jb206MTU0NDYyNjgxNTEyNjplNThkNDYzZmFiMzI3ZTRhOGNiZTkzOGU5YTExMDAwNQ=");
		
		
		//using JSON object to send body data
		String s1;
		
			s1 = "602";	
		
					
		JSONObject jj = new JSONObject();
		jj.put("exe_start_date",stTIme);
		jj.put("exe_end_date",endTIme);		
		jj.put("test_case_version_id","19996682");
		jj.put("status",Integer.parseInt(s1.trim()));				
		StringEntity entityForPost;
		try {
			entityForPost = new StringEntity(jj.toString());
			
			postReq.setEntity(entityForPost);
			
			HttpResponse response3;
			try {
				response3 = httpClient3.execute(postReq);
				
				if (response3.getStatusLine().getStatusCode() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response3.getStatusLine().getStatusCode());
				}	
				
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
						
			
			httpClient3.getConnectionManager().shutdown();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		
        
        
        
	}

}
