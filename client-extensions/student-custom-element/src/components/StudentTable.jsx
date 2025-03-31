import React, { useEffect, useState } from "react";
import Form from "./Form";

const StudentTable = () => {
  const [studentData, setStudentData] = useState({
    students: [],
    loading: true,
    error: false,
  });

  const [showForm, setShowForm] = useState({
    editForm: false,
    addForm: false,
  });

  const [studentEdit, setStudentEdit] = useState({});

  const fetchStudents = async () => {
    try {
      const response = await fetch("http://localhost:8081/students");

      if (!response.ok) {
        throw new Error("Failed to fetch students");
      }

      const data = await response.json();
      console.log(data);
      setStudentData({
        students: data,
        loading: false,
        error: false,
      });
    } catch (error) {
      console.error("Error fetching students:", error);
      setStudentData({
        students: [],
        loading: false,
        error: true,
      });
    }
  };

  const handleEdit = (student) => {
    setStudentEdit(student);
    setShowForm({ editForm: true, addForm: false });
  };

  const handleAdd = () => {
    setShowForm({ editForm: false, addForm: true });
  };

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`http://localhost:8081/students/${id}`, {
        method: "DELETE",
      });

      if (!response.ok) {
        throw new Error("Failed to Delete Student");
      }

      alert("Student Deleted Successfully");
      fetchStudents();
    } catch (error) {
      alert("Failed to Delete Student with ID " + id);
    }
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  return (
    <>
      {showForm.addForm ? (
        <Form
          type="add"
          setShowForm={setShowForm}
          fetchStudents={fetchStudents}
        />
      ) : showForm.editForm ? (
        <Form
          type="edit"
          student={studentEdit}
          setShowForm={setShowForm}
          fetchStudents={fetchStudents}
        />
      ) : (
        <div className="student-container">
          <h2 className="heading-title">Student Table</h2>

          {studentData.loading ? (
            <p className="loading-text">Loading...</p>
          ) : studentData.error ? (
            <p className="error-text">Error fetching students</p>
          ) : (
            <table className="student-table">
              <thead className="table-header">
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>ERP</th>
                  <th>GPA</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {studentData.students.map((student) => (
                  <tr className="table-row" key={student.studentId}>
                    <td className="table-cell">{student.studentId}</td>
                    <td className="table-cell">{student.studentName}</td>
                    <td className="table-cell">{student.studentEmail}</td>
                    <td className="table-cell">{student.studentERP}</td>
                    <td className="table-cell">{student.studentGPA}</td>
                    <td className="table-cell table-button-group">
                      <button
                        className="button button-edit"
                        onClick={() => handleEdit(student)}
                      >
                        Edit
                      </button>
                      <button
                        className="button button-delete"
                        onClick={() => handleDelete(student.studentId)}
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
          <button className="button" onClick={handleAdd}>
            Add Student
          </button>
        </div>
      )}
    </>
  );
};

export default StudentTable;
