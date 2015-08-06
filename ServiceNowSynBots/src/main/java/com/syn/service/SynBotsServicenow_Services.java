package com.syn.service;
import java.math.BigInteger;
import org.apache.axis2.transport.http.HttpTransportProperties;
import com.service_now.www.incident.ServiceNow_incidentStub;
import com.service_now.www.incident.ServiceNow_incidentStub.GetRecordsResult_type0;


public class SynBotsServicenow_Services{

	public static String InsertService(String username,String password,String Assigned_to,String Assignment_group,String Category,BigInteger Priority,String Description,String Caller_id,BigInteger Incident_state)
	{
		String sys_id= null;
				  try {
					   HttpTransportProperties.Authenticator basicAuthentication = new HttpTransportProperties.Authenticator();
					   basicAuthentication.setUsername(username);
					   basicAuthentication.setPassword(password);
					   ServiceNow_incidentStub proxy = new ServiceNow_incidentStub();
					   proxy._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
					   proxy._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, basicAuthentication);			   
					   ServiceNow_incidentStub.Insert inc = new ServiceNow_incidentStub.Insert();
					   ServiceNow_incidentStub.InsertResponse resp = new ServiceNow_incidentStub.InsertResponse();			 
					   inc.setAssigned_to(Assigned_to);
					   inc.setAssignment_group(Assignment_group);
					   inc.setCategory(Category);
					   inc.setPriority(Priority);
					   inc.setDescription(Description);
					   inc.setCaller_id(Caller_id);	
					   inc.setIncident_state(Incident_state);					  
					   resp = proxy.insert(inc);
					   sys_id=resp.getSys_id();
					   System.out.println("New Incident Sys Id: " + resp.getSys_id());
					  } catch (Exception e) 
						  {
						   System.out.println(e.toString());
				  }
				return sys_id;			 
			 }


	public static Incident_Details GetTicketDetails(String username,String password,String sys_id)
	{
		Incident_Details id = new Incident_Details();
		try {
			  ServiceNow_incidentStub proxy = new ServiceNow_incidentStub();
			  ServiceNow_incidentStub.GetRecords incidents = new ServiceNow_incidentStub.GetRecords();
			  ServiceNow_incidentStub.GetRecordsResponse result = new ServiceNow_incidentStub.GetRecordsResponse();
			  incidents.setSys_id("");
			  proxy._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
			  result = proxy.getRecords(incidents);			 
			  GetRecordsResult_type0[] keys = result.getGetRecordsResult();
			  for (int key = 0; key < keys.length; key++) {			
			   System.out.println("Key: " + keys[0].getSys_id()); 
			   id.setAssigned_to(keys[0].getAssigned_to());			   
			   id.setAssignment_group(keys[0].getAssignment_group());
			   id.setCategory(keys[0].getCategory());
			   id.setPriority(keys[0].getPriority());
			   id.setDescription(keys[0].getDescription());
			   id.setCaller_id(keys[0].getCaller_id());
			   id.setAssigned_to(keys[0].getAssigned_to());
			   id.setIncident_state(keys[0].getIncident_state());
			   id.setComments_and_work_notes(keys[0].getComments_and_work_notes());
			  }
			 } catch (Exception e) {
			  System.out.println(e.toString());
			 }
		return id;
	}
	
	public static String DeleteService(String username,String password,String sys_id)
	{
		String response=null;
				  try {
					   HttpTransportProperties.Authenticator basicAuthentication = new HttpTransportProperties.Authenticator();
					   basicAuthentication.setUsername(username);
					   basicAuthentication.setPassword(password);
					   ServiceNow_incidentStub proxy = new ServiceNow_incidentStub();
					   proxy._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
					   proxy._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, basicAuthentication);			   			  
					   ServiceNow_incidentStub.DeleteRecord del = new ServiceNow_incidentStub.DeleteRecord();
					   ServiceNow_incidentStub.DeleteRecordResponse resp1 = new ServiceNow_incidentStub.DeleteRecordResponse(); 			   
					   del.setSys_id(sys_id);		 						   
					   resp1= proxy.deleteRecord(del);
					   response= resp1.getCount();
					   System.out.println("Incident Delete Response: " + resp1.getCount());
						  } catch (Exception e) {
				   System.out.println(e.toString());
				  }
			return response;
			 
			 }
	
	public static String UpdateServiceString(String username,String password,String Assigned_to,String Assignment_group,String Commnets,BigInteger Priority,String resolved_by,String Description,String Caller_id,BigInteger Incident_state)
		{
			String sys_id= null;
			try {
				   HttpTransportProperties.Authenticator basicAuthentication = new HttpTransportProperties.Authenticator();
				   basicAuthentication.setUsername(username);
				   basicAuthentication.setPassword(password);
				   ServiceNow_incidentStub proxy = new ServiceNow_incidentStub();
				   proxy._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
				   proxy._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, basicAuthentication);			   
				   ServiceNow_incidentStub.Update update = new ServiceNow_incidentStub.Update();
				   ServiceNow_incidentStub.UpdateResponse updateresp = new ServiceNow_incidentStub.UpdateResponse();				  
				   update.setAssignment_group(Assignment_group);
				   update.setAssigned_to(Assigned_to);
				   update.setComments(Commnets);
				   update.setIncident_state(Incident_state);
				   update.setDescription(Description);
				   update.setResolved_by(resolved_by);
				   update.setPriority(Priority);
				   updateresp = proxy.update(update);
				   sys_id = updateresp.getSys_id();
				   System.out.println("Updated Incident: " + updateresp.getSys_id());
							  } catch (Exception e) {
				   System.out.println(e.toString());
				  }
				return sys_id;			 			
				 }	 
}