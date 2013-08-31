package util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 

public class RestfulClient {
	 
	  public static final String ROOT_URL="http://localhost:8080/bizwise";
	  public static String getJSON(String url) throws Exception{
			Client client = Client.create();
	 
			WebResource webResource = client
			   .resource(ROOT_URL+url);
	 
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
	 
			if (response.getStatus() != 200) {
			   throw new Exception("Failed to get JSON : HTTP error code : "
				+ response.getStatus());
			}
	 
			String output = response.getEntity(String.class);
	 
			return output;
	 
		}
	}

