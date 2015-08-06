package com.service_now.www.incident;

import java.math.BigInteger;

import org.apache.axis2.transport.http.HttpTransportProperties;

	public class Insert {
		 
		 public static void main(String args[]) {
		  try {
			  
			  
		   HttpTransportProperties.Authenticator basicAuthentication = new HttpTransportProperties.Authenticator();
		   basicAuthentication.setUsername("PN5007796");
		   basicAuthentication.setPassword("password");
		 
		   ServiceNow_incidentStub proxy = new ServiceNow_incidentStub();
		 
		   proxy._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
		   proxy._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, basicAuthentication);
		   
		   
		   
		    ServiceNow_incidentStub.Insert inc = new ServiceNow_incidentStub.Insert();
		   ServiceNow_incidentStub.InsertResponse resp = new ServiceNow_incidentStub.InsertResponse();
		 
		   inc.setAssigned_to("Pramod Nelavalli1");
		   inc.setAssignment_group("L1 Team");
		   inc.setCategory("hardware");
		   inc.setPriority(BigInteger.ZERO);
		   inc.setDescription("The Prouction server is down");
		   inc.setCaller_id("Pramod Nelavalli");
		 
		   resp = proxy.insert(inc);
		   
		   System.out.println("New Incident: " + resp.getSys_id());
		   
		   ServiceNow_incidentStub.DeleteRecord del = new ServiceNow_incidentStub.DeleteRecord();
		   ServiceNow_incidentStub.DeleteRecordResponse resp1 = new ServiceNow_incidentStub.DeleteRecordResponse();
		   
		   
		   
		   del.setSys_id("dcafbfc937048600e4aaa6d2b3990e39");
		 
		
		   
		   resp1= proxy.deleteRecord(del);
		 
		   System.out.println("New Incident: " + resp1.getCount());
		  } catch (Exception e) {
		   System.out.println(e.toString());
		  }
		 
		 }
		}

