<%@ include file="./init.jsp" %>

<portlet:defineObjects />

<portlet:actionURL name="/add_student" var="addStudentURL"  />

<!-- Bootstrap Container -->
<div class="container mt-4">
    <h2 class="text-center mb-4">Add a New Student</h2>

    <!-- Centered Form with 50% Width -->
    <div class="row justify-content-center">
        <div class="col-md-6"> <!-- This makes the width 50% on medium and larger screens -->
            <div class="card shadow-sm">
                <div class="card-body">
                    <form method="post" action="${addStudentURL}">
                        <!-- Name Field -->
                        <div class="mb-3">
                            <label for="studentName" class="form-label">Name:</label>
                            <input type="text" id="studentName" name="<portlet:namespace/>studentName" class="form-control" required placeholder="Enter Student Name" />
                        </div>

                        <!-- Department Field -->
                        <div class="mb-3">
                            <label for="studentDepartment" class="form-label">Department:</label>
                            <input type="text" id="studentDepartment" name="<portlet:namespace/>studentDepartment" class="form-control" required placeholder="Enter Department" />
                        </div>

                        <!-- GPA Field -->
                        <div class="mb-3">
                            <label for="studentGPA" class="form-label">GPA:</label>
                            <input type="number" step="0.01" id="studentGPA" name="<portlet:namespace/>studentGPA" class="form-control" required placeholder="Enter GPA" />
                        </div>

                        <!-- Enrollment No Field -->
                        <div class="mb-3">
                            <label for="enrollmentNo" class="form-label">Enrollment No:</label>
                            <input type="text" id="enrollmentNo" name="<portlet:namespace/>studentEnrollmentNo" class="form-control" required placeholder="Enter Enrollment No" />
                        </div>

                       

                        <!-- Submit Button -->
                        <button type="submit" class="btn btn-primary btn-lg">Add Student</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


