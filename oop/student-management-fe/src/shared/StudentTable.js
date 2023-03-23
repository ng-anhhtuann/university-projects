import React from 'react';
import '../App.css';

function StudentTable(props) {
  const student = props.student;
  return props.hide ? <></> : (
    <table className="student-table">
      <thead>
        <tr>
          <th>Student ID</th>
          <th>Name</th>
          <th>Class</th>
          <th>Average Point</th>
          <th>Citizen ID</th>
          <th>Contact Number</th>
          <th>Date of Birth</th>
          <th>Address</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{student.studentId}</td>
          <td>{student.name}</td>
          <td>{student.className}</td>
          <td>{student.avgPoint}</td>
          <td>{student.citizenId}</td>
          <td>{student.number}</td>
          <td>{student.born}</td>
          <td>{student.address}</td>
        </tr>
      </tbody>
    </table>
  );
}

export default StudentTable;
