import React, { useMemo, useState } from 'react';
import './App.css';
import Text from './shared/Text';
import Button from 'shared/Button';
// import Submit from 'shared/Submit';
import InsertForm from 'shared/InsertForm';
import IdForm from 'shared/IdForm';

function App() {
  const [showInsertForm, setShowInsertForm] = useState(false);
  const [showIdForm, setShowIdForm] = useState(false);
  const [showClassGet, setShowClassGet] = useState(false);
  const [showFacultyGet, setShowFacultyGet] = useState(false);
  const [showStudentGet, setShowStudentGet] = useState(false);
  const [showPointUpdate, setShowPointUpdate] = useState(false);
  const [showPrimaryUpdate, setShowPrimaryUpdate] = useState(false);
  const [showNumberUpdate, setShowNumberUpdate] = useState(false);
  const [showFacultyUpdate, setShowFacultyUpdate] = useState(false);
  const [showClassUpdate, setShowClassUpdate] = useState(false);
  const [showAddressUpdate, setShowAddressUpdate] = useState(false);
  const [showAccumulateUpdate, setShowAccumulateUpdate] = useState(false);
  
  const title = useMemo(() => {
    return <Text title="Student Management" />
  }, []);

  const postButton = useMemo(() => {
    return <Button title={"add student"} onClick={()=>{setShowInsertForm(!showInsertForm)}}/>
  }, [showInsertForm]);

  const getAllButton = useMemo(() => {
    return <Button title={"show all students"} color={"#cc23bb"} onClick={()=>{}}/>
  }, []);

  const deleteButton = useMemo(() => {
    return <Button title={"Delete student"} color={"#d63522"} onClick={()=>{setShowIdForm(!showIdForm)}}/>
  }, [showIdForm]);
  
  const getStudentByIdButton = useMemo(() => {
    return <Button title={"Student by id"} color={"#34abeb"} onClick={()=>{setShowStudentGet(!showStudentGet)}}/>
  }, [showStudentGet]);
  
  const getPrimaryButton = useMemo(() => {
    return <Button title={"Primary Students"} color={"#34abeb"} onClick={()=>{}}/>
  }, []);
  
  const getLowPointButton = useMemo(() => {
    return <Button title={"low point student"} color={"#34abeb"} onClick={()=>{}}/>
  }, []);
  
  const getClassButton = useMemo(() => {
    return <Button title={"student in same class"} color={"#34abeb"} onClick={()=>{setShowClassGet(!showClassGet)}}/>
  }, [showClassGet]);
  
  const getFacultyButton = useMemo(() => {
    return <Button title={"student in same faculty"} color={"#34abeb"} onClick={()=>{setShowFacultyGet(!showFacultyGet)}}/>
  }, [showFacultyGet]);

  const updatePointButton = useMemo(() => {
    return <Button title={"update training point"} color={"#e68c25"} onClick={()=>{setShowPointUpdate(!showPointUpdate)}}/>
  }, [showPointUpdate]);

  const updatePrimaryButton = useMemo(() => {
    return <Button title={"update primary"} color={"#e68c25"} onClick={()=>{setShowPrimaryUpdate(!showPrimaryUpdate)}}/>
  }, [showPrimaryUpdate]);

  const updateNumberButton = useMemo(() => {
    return <Button title={"update number"} color={"#e68c25"} onClick={()=>{setShowNumberUpdate(!showNumberUpdate)}}/>
  }, [showNumberUpdate]);

  const updateFacultyButton = useMemo(() => {
    return <Button title={"update faculty"} color={"#e68c25"} onClick={()=>{setShowFacultyUpdate(!showFacultyUpdate)}}/>
  }, [showFacultyUpdate]);

  const updateClassButton = useMemo(() => {
    return <Button title={"update class name"} color={"#e68c25"} onClick={()=>{setShowClassUpdate(!showClassUpdate)}}/>
  }, [showClassUpdate]);

  const updateAddressButton = useMemo(() => {
    return <Button title={"update address"} color={"#e68c25"} onClick={()=>{setShowAddressUpdate(!showAddressUpdate)}}/>
  }, [showAddressUpdate]);

  const updateAccumulateButton = useMemo(() => {
    return <Button title={"update accumulate"} color={"#e68c25"} onClick={()=>{setShowAccumulateUpdate(!showAccumulateUpdate)}}/>
  }, [showAccumulateUpdate]);

  return (
    <div className='App'>
      <div className="titleWrap">
        {title}
      </div>

      <table className="student-table">
        <thead>
          <tr>
          <th>Student ID</th>
          <th>Name</th>
          <th>Faculty</th>
          <th>Class</th>
          <th>Primary</th>
          <th>Training Point</th>
          <th>Accumulate Number</th>
          <th>Citizen ID</th>
          <th>Contact Number</th>
          <th>Date of Birth</th>
          <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>John Smith</td>
            <td>Science</td>
            <td>Class A</td>
            <td>true</td>
            <td>90</td>
            <td>10</td>
            <td>1234567890</td>
            <td>555-1234</td>
            <td>01/01/2000</td>
            <td>123 Main St</td>
        </tr>
        </tbody>
      </table>

      <div className="buttonContainer">
        <div>
          {getAllButton}
        </div> 

        <div>
          {postButton}
          <InsertForm hide={showInsertForm} onSubmit={()=>{}}/>
        </div>
        
        <div>
          {deleteButton}
          <IdForm title={"Student ID"} onChange={() => { } } onSubmit={() => { } } hide={showIdForm} type={"number"} name={"studentId"} value={undefined}/>
        </div>

        <div>
          {getClassButton}
          <IdForm title={"Class Room"} onChange={() => { } } onSubmit={() => { } } hide={showClassGet} type={"text"} name={"classRoom"} value={undefined}/>
          
          {getFacultyButton}
          <IdForm title={"Faculty"} onChange={() => { } } onSubmit={() => { } } hide={showFacultyGet} type={"text"} name={"faculty"} value={undefined}/>
          
          {getLowPointButton}
          
          {getStudentByIdButton}
          <IdForm title={"Student ID"} onChange={() => { } } onSubmit={() => { } } hide={showStudentGet} type={"number"} name={"studentId"} value={undefined}/>
          
          {getPrimaryButton}
        </div>

        <div>
          {updatePointButton}
          {updatePrimaryButton}
          <IdForm title={"Student ID"} onChange={() => { } } onSubmit={() => { } } hide={showPrimaryUpdate} type={"number"} name={"studentId"} value={undefined}/>
          {updateNumberButton}
          {updateFacultyButton}
          {updateClassButton}
          {updateAddressButton}
          {updateAccumulateButton}
        </div>

      </div>
    </div>
  );
}

export default App;
