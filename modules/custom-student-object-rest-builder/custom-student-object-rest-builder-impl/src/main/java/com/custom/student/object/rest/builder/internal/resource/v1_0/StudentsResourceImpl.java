package com.custom.student.object.rest.builder.internal.resource.v1_0;

import com.custom.student.object.rest.builder.dto.v1_0.StudentObject;
import com.custom.student.object.rest.builder.resource.v1_0.StudentsResource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.Http.Method;
import com.liferay.portal.kernel.util.Http.Options;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author kommineni.chandu
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/students.properties",
	scope = ServiceScope.PROTOTYPE, service = StudentsResource.class
)
public class StudentsResourceImpl extends BaseStudentsResourceImpl {

	
	
	 private static Log _log=LogFactoryUtil.getLog(StudentsResourceImpl.class);

		@Override
		public Page<StudentObject> getAllStudents(Pagination pagination) throws Exception {

			_log.info("----- request received for studentslist ------");

	        // Define the API URL
	        String apiURL = "http://localhost:8080/o/c/students/";

	      
	        Options options=AuthConfiugrationProvide(apiURL, Http.Method.GET);
	       
	        // Make API request
	        String apiResponse = HttpUtil.URLtoString(options);
	        int statusCode = options.getResponse().getResponseCode();

             
	        // Parse the JSON response
	        List<StudentObject> studentObjects = new ArrayList<>();
	        if (statusCode == 200) {
	            JSONObject jsonResponse = JSONFactoryUtil.createJSONObject(apiResponse);
	            JSONArray itemsArray = jsonResponse.getJSONArray("items");
	           

	            if (itemsArray != null) {
	                for (int i = 0; i < itemsArray.length(); i++) {
	                    JSONObject studenObjectJson = itemsArray.getJSONObject(i);
	                    StudentObject queryObject = convertToStudentObject(studenObjectJson);
	                    studentObjects.add(queryObject);
	                }
	            }
	        }

	        // Return results as a Page of QueryObjects
	        return Page.of(studentObjects);
		}
	
		@Override
		public StudentObject addStudent(StudentObject studentObject) throws Exception {
			
			_log.info("------- request received for adding student ------");
			 String apiURL = "http://localhost:8080/o/c/students/";
			 
			 Options options=AuthConfiugrationProvide(apiURL,Http.Method.POST);
			 JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			 jsonObject.put("studentId", studentObject.getStudentId());
			 jsonObject.put("studentName", studentObject.getStudentName());
			 jsonObject.put("studentEnrollementNo", studentObject.getEnrollmentNo());
			 jsonObject.put("studentDepartment", studentObject.getStudentDepartment());
			 jsonObject.put("studentGPA", studentObject.getStudentGPA());
			 
			 String requestBody = jsonObject.toString(); 
			 
              
		      options.setBody(requestBody, "application/json", "UTF-8");
		      
		      try {
		            String response = HttpUtil.URLtoString(options);
		            
		            JSONObject responseObject = JSONFactoryUtil.createJSONObject(response);
		            return convertToStudentObject(responseObject);
		        } catch (Exception e) {
		            _log.error("Error in API Call", e);
		            return null;
		        }
		}
		
		


	   @Override
		public StudentObject updateStudent(Long studentId,StudentObject studentObject) throws Exception {
		    
		   _log.info("------ request received for updating student ------");
		   
		     String apiURL = "http://localhost:8080/o/c/students/"+studentId;
		     Options options =AuthConfiugrationProvide(apiURL, Http.Method.PUT);
		     JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			 jsonObject.put("studentId", studentObject.getStudentId());
			 jsonObject.put("studentName", studentObject.getStudentName());
			 jsonObject.put("studentEnrollementNo", studentObject.getEnrollmentNo());
			 jsonObject.put("studentDepartment", studentObject.getStudentDepartment());
			 jsonObject.put("studentGPA", studentObject.getStudentGPA());
			 String requestBody = jsonObject.toString(); 
		     _log.info("requestBody:=="+requestBody);
		       
		      options.setBody(requestBody, "application/json", "UTF-8");
		      try {
		            String response = HttpUtil.URLtoString(options);
		            _log.info("Response: " + response);
		            JSONObject responseObject = JSONFactoryUtil.createJSONObject(response);
		            return convertToStudentObject(responseObject);
		        } catch (Exception e) {
		            _log.error("Error in API Call", e);
		            return null;
		        }
			
		}
	    



	@Override
	public StudentObject deleteStudent( Long studentId) throws Exception {
		_log.info("-------- request received for deleting student -----");
		String apiURL = "http://localhost:8080/o/c/students/"+studentId;
	    Options options =AuthConfiugrationProvide(apiURL, Http.Method.DELETE);
	    try {
	        String response = HttpUtil.URLtoString(options);
	       _log.info("-------- Student Deleted successfully ------");
	        
	    } catch (Exception e) {
	        _log.error("Error in API Call", e);
	       
	    }
	    return null;
		
	}

	
	
	
	
	
	
	private static Options AuthConfiugrationProvide(String URL,Method method) {
		   // Create HTTP Options
	       Http.Options options = new Http.Options();
	       options.setLocation(URL);
	       options.setMethod(method);

	       // Add Basic Authentication
	       String username = "test@gmail.com";
	       String password = "1234";
	       String auth = username + ":" + password;
	       String encodedAuth = "Basic " + Base64.encode(auth.getBytes());

	       options.addHeader("Authorization", encodedAuth);
	       options.addHeader("Accept", "application/json");
	       options.addHeader("Content-Type", "application/json");
		   return options;
	   }
	
	private StudentObject convertToStudentObject(JSONObject json) {
        StudentObject studentObject = new StudentObject();

        // Extract values and set them in the QueryObject
        studentObject.setStudentName(json.getString("studentName"));
        studentObject.setStudentDepartment(json.getString("studentDepartment"));
        studentObject.setEnrollmentNo(json.getString("studentEnrollementNo"));
        studentObject.setStudentId(json.getLong("studentId"));
        studentObject.setStudentGPA(json.getDouble("studentGPA"));
        
        return studentObject;
    }
	
}