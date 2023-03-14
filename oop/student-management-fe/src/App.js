import React, { useCallback, useMemo, useState } from 'react';
import './App.css';
import Text from './shared/Text';
import Button from 'shared/Button';
import IdForm from 'shared/IdForm';
import UpdateForm from 'shared/UpdateForm';
import Input from 'shared/Input';
import Submit from 'shared/Submit';
import { createStudent, deleteStudent, updateNumber, updatePrimary, updateTrainingPoint } from 'data';

function App() {
  // show/hide form
  const [showInsertForm, setShowInsertForm] = useState(true);
  const [formData, setFormData] = useState({
    studentId: '',
    name: '',
    faculty: '',
    className: 'unknown',
    isPrimary: true,
    trainingPoint: 0,
    accumulateNumber: 0,
    citizenId: '',
    number: '',
    born: '',
    address: 'HCM city'
  });
  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(formData);
  };
  const handleInputChange = (event) => {
    const { name, value, type, checked } = event.target;
    setFormData((prevState) => {
      if (type === 'checkbox') {
        return {
          ...prevState,
          [name]: checked
        };
      } else {
        return {
          ...prevState,
          [name]: value
        };
      }
    });
  };
  const addNewStudent = async () => {
    var dataFetch = await createStudent(formData);
    console.log({dataFetch});
    alert(dataFetch.info);
  }
  const [showDeleteForm, setShowDeleteForm] = useState(true);
  const [studentIdDelete, setStudentIdDelete] = useState(0);
  const deleteStudentById = async () => {
    var dataFetch = await deleteStudent({studentId: studentIdDelete});
    console.log({dataFetch});
    alert(dataFetch.info);
  }

  const [showClassGet, setShowClassGet] = useState(true);
  const [showFacultyGet, setShowFacultyGet] = useState(true);
  const [showStudentGet, setShowStudentGet] = useState(true);

  const [showPointUpdate, setShowPointUpdate] = useState(true);
  const [studentIdPointUpdate, setStudentIdPointUpdate] = useState(0);
  const [newPointUpdate, setNewPointUpdate] = useState(0);
  const updatePointByStudentId = async () => {
    var dataFetch = await updateTrainingPoint({studentId: studentIdPointUpdate, trainingPoint: newPointUpdate});
    console.log({dataFetch});
    alert(dataFetch.info);
  }

  const [showPrimaryUpdate, setShowPrimaryUpdate] = useState(true);
  const [studentIdPrimaryUpdate, setStudentIdPrimaryUpdate] = useState(0);
  const updatePrimaryByStudentId = async () => {
    var dataFetch = await updatePrimary({studentId: studentIdPrimaryUpdate});
    console.log({dataFetch});
    alert(dataFetch.info);
  }

  const [showNumberUpdate, setShowNumberUpdate] = useState(true);
  const [studentIdNumberUpdate, setStudentIdNumberUpdate] = useState(0);
  const [numberUpdate, setNumberUpdate] = useState('');
  const updateNumberById = async () => {
    var dataFetch = await updateNumber(studentIdNumberUpdate, numberUpdate);
    console.log({dataFetch});
    alert(dataFetch.info);
  }

  const [showFacultyUpdate, setShowFacultyUpdate] = useState(true);
  const [showClassUpdate, setShowClassUpdate] = useState(true);
  const [showAddressUpdate, setShowAddressUpdate] = useState(true);
  const [showAccumulateUpdate, setShowAccumulateUpdate] = useState(true);

  const title = useMemo(() => {
    return <Text title="Student Management" />
  }, []);

  const postButton = useMemo(() => {
    return <Button title={"add student"} onClick={()=>{setShowInsertForm(!showInsertForm)}}/>
  }, [showInsertForm]);

  const insertForm = useMemo(() => {
    return showInsertForm ? <></> : (
      <form id="insert-form" style={{ width: '310px', height: 'fit-content', position: 'relative', border: '1px solid', borderRadius: '4px', padding: '5px', marginLeft: '50px' }} onSubmit={handleSubmit}>
          <Input label="Student ID" name="studentId" type="number" value={formData.studentId} onChange={handleInputChange} />
          <Input label="Name" name="name" type="text" value={formData.name} onChange={handleInputChange} />
          <Input label="Faculty" name="faculty" type="text" value={formData.faculty} onChange={handleInputChange} />
          <Input label="Class" name="className" type="text" value={formData.className} onChange={handleInputChange} />
          <Input label="Is Primary" name="isPrimary" type="checkbox" value={formData.isPrimary} onChange={handleInputChange} />
          <Input label="Training Point" name="trainingPoint" type="number" value={formData.trainingPoint} onChange={handleInputChange} />
          <Input label="Accumulate Number" name="accumulateNumber" type="number" value={formData.accumulateNumber} onChange={handleInputChange} />
          <Input label="Citizen ID" name="citizenId" type="number" value={formData.citizenId} onChange={handleInputChange} />
          <Input label="Number" name="number" type="text" value={formData.number} onChange={handleInputChange} />
          <Input label="Born" name="born" type="date" value={formData.born} onChange={handleInputChange} />
          <Input label="Address" name="address" type="text" value={formData.address} onChange={handleInputChange} />
          <div className='middlePos'>
              <Submit onClick={() => {addNewStudent()}}/>
          </div>
      </form>
    )
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [formData.accumulateNumber, formData.address, formData.born, formData.citizenId, formData.className, formData.faculty, formData.isPrimary, formData.name, formData.number, formData.studentId, formData.trainingPoint, showInsertForm])

  const getAllButton = useMemo(() => {
    return <Button title={"show all students"} color={"#cc23bb"} onClick={()=>{}}/>
  }, []);

  const deleteButton = useMemo(() => {
    return <Button title={"Delete student"} color={"#d63522"} onClick={()=>{setShowDeleteForm(!showDeleteForm)}}/>
  }, [showDeleteForm]);
  
  const getStudentByIdButton = useMemo(() => {
    return <Button title={"Student by id"} color={"#34abeb"} onClick={()=>{setShowStudentGet(!showStudentGet)}}/>
  }, [showStudentGet]);
  
  const getPrimaryButton = useMemo(() => {
    return <Button title={"Show All Primary Students"} color={"#34abeb"} onClick={()=>{}}/>
  }, []);
  
  const getLowPointButton = useMemo(() => {
    return <Button title={"show low point students"} color={"#34abeb"} onClick={()=>{}}/>
  }, []);
  
  const getClassButton = useMemo(() => {
    return <Button title={"show students in same class"} color={"#34abeb"} onClick={()=>{setShowClassGet(!showClassGet)}}/>
  }, [showClassGet]);
  
  const getFacultyButton = useMemo(() => {
    return <Button title={"show students in same faculty"} color={"#34abeb"} onClick={()=>{setShowFacultyGet(!showFacultyGet)}}/>
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
        
        <div className='mapContainer'>
          {getAllButton}
          {postButton}
          {insertForm}
          
          {deleteButton}
          <IdForm title={"Student ID"} onChange={useCallback((event) => {setStudentIdDelete(event?.target?.value)},[]) } onSubmit={() => {deleteStudentById()} } hide={showDeleteForm} type={"number"} name={"studentId"} value={undefined}/>
        </div>

        <div className='mapContainer'>
          {getClassButton}
          <IdForm title={"Class Room"} onChange={() => { } } onSubmit={() => { } } hide={showClassGet} type={"text"} name={"classRoom"} value={undefined}/>
          
          {getFacultyButton}
          <IdForm title={"Faculty"} onChange={() => { } } onSubmit={() => { } } hide={showFacultyGet} type={"text"} name={"faculty"} value={undefined}/>
       
          {getStudentByIdButton}
          <IdForm title={"Student ID"} onChange={() => { } } onSubmit={() => { } } hide={showStudentGet} type={"number"} name={"studentId"} value={undefined}/>     
          
          {getLowPointButton}
          {getPrimaryButton}
          
        </div>

        <div className='mapContainer'>
          {updatePointButton}
          <UpdateForm title={"New Point"} onChange={useCallback((e)=> {setNewPointUpdate(e?.target?.value)}, []) } onSubmit={() => updatePointByStudentId()} hide={showPointUpdate} type={"number"} name={"trainingPoint"} value={undefined} onChangeId={useCallback((e) => {setStudentIdPointUpdate(e?.target?.value)}, [])}/>
          
          {updatePrimaryButton}
          <IdForm title={"Student ID"} onChange={useCallback((e) => {setStudentIdPrimaryUpdate(e?.target?.value)},[])} onSubmit={() => updatePrimaryByStudentId()} hide={showPrimaryUpdate} type={"number"} name={"studentId"} value={undefined}/>
          
          {updateNumberButton}
          <UpdateForm title={"New Number"} onChange={useCallback((e) => {setNumberUpdate(e?.target?.value)},[])} onSubmit={() => updateNumberById()} hide={showNumberUpdate} type={"text"} name={"number"} value={undefined} onChangeId={useCallback((e) => setStudentIdNumberUpdate(e?.target?.value),[])}/>
          
          {updateFacultyButton}
          <UpdateForm title={"New Faculty"} onChange={() => {}} onSubmit={() => {}} hide={showFacultyUpdate} type={"text"} name={"faculty"} value={undefined} onChangeId={() => {}}/>
          
          {updateClassButton}
          <UpdateForm title={"New Class"} onChange={() => {}} onSubmit={() => {}} hide={showClassUpdate} type={"text"} name={"classRoom"} value={undefined} onChangeId={() => {}}/>

          {updateAddressButton}
          <UpdateForm title={"New Address"} onChange={() => {}} onSubmit={() => {}} hide={showAddressUpdate} type={"text"} name={"address"} value={undefined} onChangeId={() => {}}/>
          
          {updateAccumulateButton}
          <UpdateForm title={"New Accumulate Number"} onChange={() => {}} onSubmit={() => {}} hide={showAccumulateUpdate} type={"number"} name={"accumulateNumber"} value={undefined} onChangeId={() => {}}/>
        </div>

      </div>
    </div>
  );
}

export default App;
