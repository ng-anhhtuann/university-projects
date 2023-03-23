import React from 'react';
import '../App.css';

export default function StudentListTable(props) {
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
        {props.students.map((student) => (
          <tr key={student.studentId}>
            <td>{student.studentId}</td>
            <td>{student.name}</td>
            <td>{student.className}</td>
            <td>{student.avgPoint}</td>
            <td>{student.citizenId}</td>
            <td>{student.number}</td>
            <td>{student.born}</td>
            <td>{student.address}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
