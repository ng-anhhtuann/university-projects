import React, { useCallback, useEffect, useMemo, useState } from 'react';
import './App.css';
import Text from './shared/Text';
import Button from 'shared/Button';
import IdForm from 'shared/IdForm';
import UpdateForm from 'shared/UpdateForm';
import Input from 'shared/Input';
import Submit from 'shared/Submit';
import { createStudent, deleteStudent, getAllStudent, getStudentFromClass, getStudentFromStudentId, getStudentLowAvgPoint, updateAddress, updateClass, updateNumber, updateAvgPoint } from 'data';
import StudentListTable from 'shared/StudentListTable';
import StudentTable from 'shared/StudentTable';

function App() {
  const [listStudentShow, setListStudentShow] = useState(false);
  const [listStudent, setListStudent] = useState([]);
  const getAll = async () => {
    const dataFetch = await getAllStudent();
    if (dataFetch.length === 0) {
      alert("No student in list, please add one more.")
    } else {
      setListStudentShow(true);
      setListStudent(dataFetch ?? []);
    } 
  }

  const [showInsertForm, setShowInsertForm] = useState(true);
  const [studentIdForm, setStudentIdForm] = useState(0);
  const [nameForm, setNameForm] = useState('');
  const [classNameForm, setClassNameForm] = useState('');
  const [pointForm, setPointForm] = useState(0);
  const [citizenIdForm, setCitizenIdForm] = useState(0);
  const [numberForm, setNumberForm] = useState('')
  const [bornForm, setBornForm] = useState('')
  const [addressForm, setAddressForm] = useState('');

  const addNewStudent = async () => {
    const formData = {
      studentId: Number(studentIdForm),
      name: nameForm,
      className: classNameForm+"",
      avgPoint: Number(pointForm),
      citizenId: Number(citizenIdForm),
      number: numberForm+"",        
      born: bornForm+"",
      address: addressForm
    }
    var dataFetch = await createStudent(formData);
    alert(dataFetch.info);
  }
  const insertForm = () => {
    return (
      <div className="formContainer">
        <Input label="Student ID" name="studentId" type="number" onChange={(e) => setStudentIdForm(e?.target?.value)} />
        <Input label="Name" name="name" type="text" onChange={(e) => setNameForm(e?.target?.value)} />
        <Input label="Class" name="className" type="text" onChange={(e) => setClassNameForm(e?.target?.value)} />
        <Input label="Average Point" name="avgPoint" type="number" onChange={(e) => setPointForm(e?.target?.value)} />
        <Input label="Citizen ID" name="citizenId" type="number" onChange={(e) => setCitizenIdForm(e?.target?.value)} />
        <Input label="Number" name="number" type="number" onChange={(e) => setNumberForm(e?.target?.value)} />
        <Input label="Born" name="born" type="date" onChange={(e) => setBornForm(e?.target?.value)} />
        <Input label="Address" name="address" type="text" onChange={(e) => setAddressForm(e?.target?.value)} />
        <div className='middlePos'>
          <Submit onClick={() => addNewStudent()} />
        </div>
      </div>
    )
  }

  const [showDeleteForm, setShowDeleteForm] = useState(true);
  const [studentIdDelete, setStudentIdDelete] = useState(0);
  const deleteStudentById = async () => {
    var dataFetch = await deleteStudent({studentId: studentIdDelete});
    alert(dataFetch.info);
  }

  const [showClassGet, setShowClassGet] = useState(true);
  const [showTableClass, setShowTableClass] = useState(false);
  const [listStudentSameClass, setListStudentSameClass] = useState([]);
  const [classNameFind, setClassNameFind] = useState('');
  const getStudentSameClass = async () => {
    const data = await getStudentFromClass(classNameFind);
    if (data.length === 0){
      alert("No student return.")
    } else {
      setListStudentSameClass(data ?? []);
      setShowTableClass(true);
    }
  }

  const [showStudentGet, setShowStudentGet] = useState(true);
  const [showStudentInfo, setShowStudentInfo] = useState(true);
  const [studentIdFind, setStudentIdFind] = useState(0);
  const [studentFind, setStudentFind] = useState({
    studentId: -1,
    name: "",
    className: "",
    avgPoint: -1,
    citizenId: -1,
    number: "",        
    born: "",
    address: ""
  });
  const getStudentById = async () => {
    const data = await getStudentFromStudentId(studentIdFind);
    if (!data.status){
      alert("No student with id "+ studentIdFind)
      setStudentFind(data.student);
      setShowStudentInfo(true);
    } else {
      setStudentFind(data.student);
      setShowStudentInfo(false);
    }
  }

  const [showListLowPoint, setShowListLowPoint] = useState(true);
  const [listLowPoint, setListLowPoint] = useState([]);
  const getStudentLowPoint = async () => {
    const data = await getStudentLowAvgPoint();
    if (data.length === 0){
      alert("No student return.")
    } else {
      setListLowPoint(data ?? []);
      setShowListLowPoint(false);
    }
  }

  const [showPointUpdate, setShowPointUpdate] = useState(true);
  const [studentIdPointUpdate, setStudentIdPointUpdate] = useState(0);
  const [newPointUpdate, setNewPointUpdate] = useState(0.0);
  const updatePointByStudentId = async () => {
    var dataFetch = await updateAvgPoint({studentId: studentIdPointUpdate, avgPoint: newPointUpdate});
    alert(dataFetch.info);
  }

  const [showNumberUpdate, setShowNumberUpdate] = useState(true);
  const [studentIdNumberUpdate, setStudentIdNumberUpdate] = useState(0);
  const [numberUpdate, setNumberUpdate] = useState('');
  const updateNumberById = async () => {
    var dataFetch = await updateNumber(studentIdNumberUpdate, numberUpdate);
    alert(dataFetch.info);
  }

  const [showClassUpdate, setShowClassUpdate] = useState(true);
  const [studentIdClassUpdate, setStudentIdClassUpdate] = useState(0);
  const [classUpdate, setClassUpdate] = useState('');
  const updateClassById = async () => {
    var dataFetch = await updateClass(studentIdClassUpdate, classUpdate);
    alert(dataFetch.info);
  }

  const [showAddressUpdate, setShowAddressUpdate] = useState(true);
  const [studentIdAddressUpdate, setStudentIdAddressUpdate] = useState(0);
  const [addressUpdate, setAddressUpdate] = useState('');
  const updateAddressById = async () => {
    var dataFetch = await updateAddress(studentIdAddressUpdate, addressUpdate);
    alert(dataFetch.info);
  }

  const title = useMemo(() => {
    return <Text title="Student Management" />
  }, []);

  const postButton = useMemo(() => {
    return <Button title={"add student"} onClick={() => {setShowInsertForm(!showInsertForm)}}/>
  }, [showInsertForm]);

  const getAllButton = useMemo(() => {
    return <Button title={"show all students"} color={"#cc23bb"} onClick={()=>getAll()}/>
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const deleteButton = useMemo(() => {
    return <Button title={"Delete student"} color={"#d63522"} onClick={()=>{setShowDeleteForm(!showDeleteForm)}}/>
  }, [showDeleteForm]);
  
  const getStudentByIdButton = useMemo(() => {
    return <Button title={"Student by id"} color={"#34abeb"} onClick={()=>{setShowStudentGet(!showStudentGet)}}/>
  }, [showStudentGet]);
  
  useEffect(() => {
    if (showStudentGet){
      setShowStudentInfo(true);
    }
  }, [showStudentGet])
  
  const getLowPointButton = useMemo(() => {
    return <Button title={"show low point students"} color={"#34abeb"} onClick={()=>getStudentLowPoint()}/>
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  
  const getClassButton = useMemo(() => {
    return <Button title={"show students in same class"} color={"#34abeb"} onClick={()=>{setShowClassGet(!showClassGet)}}/>
  }, [showClassGet]);

  const updatePointButton = useMemo(() => {
    return <Button title={"update average point"} color={"#e68c25"} onClick={()=>{setShowPointUpdate(!showPointUpdate)}}/>
  }, [showPointUpdate]);

  const updateNumberButton = useMemo(() => {
    return <Button title={"update number"} color={"#e68c25"} onClick={()=>{setShowNumberUpdate(!showNumberUpdate)}}/>
  }, [showNumberUpdate]);

  const updateClassButton = useMemo(() => {
    return <Button title={"update class name"} color={"#e68c25"} onClick={()=>{setShowClassUpdate(!showClassUpdate)}}/>
  }, [showClassUpdate]);

  const updateAddressButton = useMemo(() => {
    return <Button title={"update address"} color={"#e68c25"} onClick={()=>{setShowAddressUpdate(!showAddressUpdate)}}/>
  }, [showAddressUpdate]);

  return (
    <div className='App'>
      <div className="titleWrap">
        {title}
      </div>
      <StudentListTable students={listStudent} hide={!listStudentShow}/>
      <div className="buttonContainer">
        
        <div className='mapContainer'>
          {getAllButton}

          <div className='inLine'>
            {postButton}
            {showInsertForm ? <></> : insertForm()}
          </div>

          <div className='inLine'>
            {deleteButton}
            <IdForm title={"Student ID"} onChange={useCallback((event) => {setStudentIdDelete(event?.target?.value)},[]) } onSubmit={() => {deleteStudentById()} } hide={showDeleteForm} type={"number"} name={"studentId"} value={undefined}/>
          </div>
        </div>

        <div className='mapContainer'>
          <div className='inLine'>
            {getClassButton}
            <IdForm title={"Class Room"} onChange={(e) => setClassNameFind(e?.target?.value)} onSubmit={() => getStudentSameClass()} hide={showClassGet} type={"text"} name={"classRoom"} value={undefined}/>
          </div>
          <StudentListTable students={listStudentSameClass} hide={!showTableClass}/>

          <div className='inLine'>
            {getStudentByIdButton}
            <IdForm title={"Student ID"} onChange={(e) => setStudentIdFind(e?.target?.value)} onSubmit={() => getStudentById()} hide={showStudentGet} type={"number"} name={"studentId"} value={undefined}/>     
          </div>
          <StudentTable student={studentFind} hide={showStudentInfo}/>

          {getLowPointButton}
          <StudentListTable students={listLowPoint} hide={showListLowPoint}/>

        </div>

        <div className='mapContainer'>
          <div className='inLine'> 
            {updatePointButton}
            <UpdateForm title={"New Point"} onChange={useCallback((e)=> {setNewPointUpdate(e?.target?.value)}, []) } onSubmit={() => updatePointByStudentId()} hide={showPointUpdate} type={"number"} name={"avgPoint"} value={undefined} onChangeId={useCallback((e) => {setStudentIdPointUpdate(e?.target?.value)}, [])}/>
          </div>

          <div className='inLine'>
            {updateNumberButton}
            <UpdateForm title={"New Number"} onChange={useCallback((e) => {setNumberUpdate(e?.target?.value)},[])} onSubmit={() => updateNumberById()} hide={showNumberUpdate} type={"text"} name={"number"} value={undefined} onChangeId={useCallback((e) => setStudentIdNumberUpdate(e?.target?.value),[])}/>
          </div>
          
          <div className='inLine'>
            {updateClassButton}
            <UpdateForm title={"New Class"} onChange={useCallback((e) => {setClassUpdate(e?.target?.value)},[])} onSubmit={() => updateClassById()} hide={showClassUpdate} type={"text"} name={"classRoom"} value={undefined} onChangeId={useCallback((e) => setStudentIdClassUpdate(e?.target?.value),[])}/>
          </div>
          
          <div className='inLine'>
            {updateAddressButton}
            <UpdateForm title={"New Address"} onChange={useCallback((e) => {setAddressUpdate(e?.target?.value)},[])} onSubmit={() => updateAddressById()} hide={showAddressUpdate} type={"text"} name={"address"} value={undefined} onChangeId={useCallback((e) => setStudentIdAddressUpdate(e?.target?.value),[])}/>
          </div>
          
        </div>

      </div>
    </div>
  );
}

export default App;
