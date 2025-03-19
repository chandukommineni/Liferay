<%@ include file="./init.jsp" %>

<portlet:defineObjects />

<portlet:renderURL var="addStudentFormURL">
    <portlet:param name="mvcRenderCommandName" value="/add_student_form"/>
</portlet:renderURL>

<portlet:renderURL var="searchByErpURL">
    <portlet:param name="mvcRenderCommandName" value="/search_by_ERP"/>
</portlet:renderURL>

<portlet:renderURL var="defaultViewURL">
    <portlet:param name="mvcRenderCommandName" value="/"/>
</portlet:renderURL>

<portlet:renderURL var="findStudentGPAGreaterThan">
    <portlet:param name="mvcRenderCommandName" value="/find_by_gpa_greater_than"/>
</portlet:renderURL>

<div class="container mt-4">
    <h2 class="text-center mb-4">Student List</h2>
   <div class="row">
	   <div class="col-md-6">
		   <form method="post" action="${searchByErpURL}" class="mb-3 w-75 mx-auto">
		        <div class="input-group">
		            <input type="text" name="<portlet:namespace/>enrollmentNo" 
		                   class="form-control" placeholder="Enter Enrollment No" required/>
		            <button type="submit" class="btn btn-primary">Search</button>
		        </div>
		    </form>
	   </div>
	   <div class="col-md-6">
		    <form method="post" action="${findStudentGPAGreaterThan}" class="mb-3 w-75 mx-auto">
	        	<div class="input-group">
		            <input type="number" name="<portlet:namespace/>studentGPA" 
		                   class="form-control" placeholder="Enter GPA" required/>
		            <button type="submit" class="btn btn-primary">Search</button>
		        </div>
		    </form>
	   </div>
   </div>
    
    
    
    <!-- Table with Bootstrap styling -->
    <table class="table table-striped table-bordered table-hover" id="studentTable">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>GPA</th>
                <th>Enrollment No</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${studentsList}">
                <tr>
                    <td>${student.studentId}</td>
                    <td>${student.studentName}</td>
                    <td>${student.studentDepartment}</td>
                    <td>${student.studentGPA}</td>
                    <td>${student.studentEnrollmentNo}</td>
                    
                    <td>
                     <portlet:renderURL var="editStudentURL">
						<portlet:param name="mvcRenderCommandName" value="/edit_student_form" />
						<portlet:param name="studentId" value="${student.studentId}" />
					</portlet:renderURL> 
					
					<a href="${editStudentURL}" class="btn btn-success btn-sm">Edit</a>
					
					<portlet:actionURL name="/delete_student" var="deleteStudentURL">
					</portlet:actionURL>
					<form action="${deleteStudentURL}" method="post"
						style="display: inline;">
						<input type="hidden" name="<portlet:namespace/>studentId"
							value="${student.studentId}" />
						<button type="submit" class="btn btn-danger btn-sm">Delete</button>
					</form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>



<c:if test="${empty requestScope.back}">
    <div class="text-center mt-2">
        <a class="btn btn-primary" href="${addStudentFormURL}">Add New Student</a>
    </div>
</c:if>


<c:if test="${requestScope.back == true}" >
    <div class="m-3">
        <a href="${defaultViewURL}" class="btn btn-primary btn-lg px-4 py-2">Back</a>
    </div>
</c:if>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function() {
        $('#studentTable').DataTable({
            "paging": true,
            "searching": true,
            "ordering": true,
            "info": true
        });
    });
</script>