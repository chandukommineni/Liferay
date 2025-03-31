import React, { useState } from 'react';

const Form = ({ student = "", type,setShowForm,fetchStudents }) => {
  const [formData, setFormData] = useState({
    studentName: student.studentName || "",
    studentEmail: student.studentEmail || "",
    studentGPA: student.studentGPA || "",
    studentERP: student.studentERP || ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  const addStudent = async () => {
    try {
      const response = await fetch("http://localhost:8081/students", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
      });

      if (!response.ok) {
        throw new Error("Failed to add student");
      }

      alert("Student added successfully!");
    } catch (error) {
      console.error("Error adding student:", error);
      alert("Failed to add student");
    }
    fetchStudents()
    handleBack()
  };

  const editStudent = async () => {
    try {
      const response = await fetch(`http://localhost:8081/students/${student.studentId}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
      });

      if (!response.ok) {
        throw new Error("Failed to edit student");
      }

      alert("Student updated successfully!");
    } catch (error) {
      console.error("Error editing student:", error);
      alert("Failed to edit student");
    }
    fetchStudents()
    handleBack()
   
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (type === "add") {
      addStudent();
    } else if (type === "edit") {
      editStudent();
    }
  };
  const handleBack=()=>{
    setShowForm({edit:false,add:false})
  }

  return (
    <div className="student-form">
  <h2 className="heading-title">{type === "add" ? "Add Student" : "Edit Student"}</h2>
  <form onSubmit={handleSubmit}>
    <div>
      <label className="form-label">Name:</label>
      <input
        className="form-input"
        type="text"
        name="studentName"
        value={formData.studentName}
        onChange={handleChange}
        required
      />
    </div>
    <div>
      <label className="form-label">Email:</label>
      <input
        className="form-input"
        type="email"
        name="studentEmail"
        value={formData.studentEmail}
        onChange={handleChange}
        required
      />
    </div>
    <div>
      <label className="form-label">ERP:</label>
      <input
        className="form-input"
        type="text"
        name="studentERP"
        value={formData.studentERP}
        onChange={handleChange}
        required
      />
    </div>
    <div>
      <label className="form-label">GPA:</label>
      <input
        className="form-input"
        type="number"
        step="0.1"
        name="studentGPA"
        value={formData.studentGPA}
        onChange={handleChange}
        required
      />
    </div>
    <button className="button " type="submit">
      {type === "add" ? "Add Student" : "Edit Student"}
    </button>
  </form>
   <button className="button button-back" onClick={handleBack}>Back</button>
</div>
  );
};

export default Form;
