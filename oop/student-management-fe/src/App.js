import React, { useCallback, useEffect, useMemo, useState } from 'react';
import './App.css';
import Text from './shared/Text';
import Button from 'shared/Button';
import IdForm from 'shared/IdForm';
import UpdateForm from 'shared/UpdateForm';
import Input from 'shared/Input';
import Submit from 'shared/Submit';
import { createStudent, deleteStudent, getAllStudent, getPrimary, getStudentFromClass, getStudentFromFaculty, getStudentFromStudentId, getStudentLowTrainingPoint, updateAccumulate, updateAddress, updateClass, updateFaculty, updateNumber, updatePrimary, updateTrainingPoint } from 'data';
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
  const [facultyForm, setFacultyForm] = useState('');
  const [classNameForm, setClassNameForm] = useState('');
  const [isPrimaryForm, setIsPrimaryForm] = useState(false);
  const [pointForm, setPointForm] = useState(0);
  const [accumulateForm, setAccumulateForm] = useState(0);
  const [citizenIdForm, setCitizenIdForm] = useState(0);
  const [numberForm, setNumberForm] = useState('')
  const [bornForm, setBornForm] = useState('')
  const [addressForm, setAddressForm] = useState('');

  const addNewStudent = async () => {
    const formData = {
      studentId: Number(studentIdForm),
      name: nameForm,
      faculty: facultyForm,
      className: classNameForm+"",
      isPrimary: isPrimaryForm,
      trainingPoint: Number(pointForm),
      accumulateNumber: Number(accumulateForm),
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
        <Input label="Faculty" name="faculty" type="text" onChange={(e) => setFacultyForm(e?.target?.value)} />
        <Input label="Class" name="className" type="text" onChange={(e) => setClassNameForm(e?.target?.value)} />
        <Input label="Is Primary" name="isPrimary" type="checkbox" onChange={(e) => setIsPrimaryForm(e?.target?.checked)} />
        <Input label="Training Point" name="trainingPoint" type="number" onChange={(e) => setPointForm(e?.target?.value)} />
        <Input label="Accumulate Number" name="accumulateNumber" type="number" onChange={(e) => setAccumulateForm(e?.target?.value)} />
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
    setListStudentSameClass(data ?? []);
  }

  const [showFacultyGet, setShowFacultyGet] = useState(true);
  const [showTableFaculty, setShowTableFaculty] = useState(false);
  const [listStudentSameFaculty, setListStudentSameFaculty] = useState([]);
  const [facultyFind, setFacultyFind] = useState('');
  const getStudentSameFaculty = async () => {
    const data = await getStudentFromFaculty(facultyFind);
    setListStudentSameFaculty(data ?? []);
  }

  const [showStudentGet, setShowStudentGet] = useState(true);
  const [showStudentInfo, setShowStudentInfo] = useState(true);
  const [studentIdFind, setStudentIdFind] = useState(0);
  const [studentFind, setStudentFind] = useState({
    studentId: -1,
    name: "",
    faculty: "",
    className: "",
    isPrimary: false,
    trainingPoint: -1,
    accumulateNumber: -1,
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
    const data = await getStudentLowTrainingPoint();
    if (data.length === 0){
      alert("No student return.")
    } else {
      setListLowPoint(data ?? []);
      setShowListLowPoint(false);
    }
  }

  const [showPrimaryList, setShowPrimaryList] = useState(true);
  const [listPrimary, setListPrimary] = useState([])
  const getStudentPrimary = async () => {
    const data = await getPrimary();
    if (data.length === 0){
      alert("No student in primary system.");
    } else {
      setListPrimary(data ?? []);
      setShowPrimaryList(false);
    }
  }

  const [showPointUpdate, setShowPointUpdate] = useState(true);
  const [studentIdPointUpdate, setStudentIdPointUpdate] = useState(0);
  const [newPointUpdate, setNewPointUpdate] = useState(0);
  const updatePointByStudentId = async () => {
    var dataFetch = await updateTrainingPoint({studentId: studentIdPointUpdate, trainingPoint: newPointUpdate});
    alert(dataFetch.info);
  }

  const [showPrimaryUpdate, setShowPrimaryUpdate] = useState(true);
  const [studentIdPrimaryUpdate, setStudentIdPrimaryUpdate] = useState(0);
  const updatePrimaryByStudentId = async () => {
    var dataFetch = await updatePrimary({studentId: studentIdPrimaryUpdate});
    alert(dataFetch.info);
  }

  const [showNumberUpdate, setShowNumberUpdate] = useState(true);
  const [studentIdNumberUpdate, setStudentIdNumberUpdate] = useState(0);
  const [numberUpdate, setNumberUpdate] = useState('');
  const updateNumberById = async () => {
    var dataFetch = await updateNumber(studentIdNumberUpdate, numberUpdate);
    alert(dataFetch.info);
  }

  const [showFacultyUpdate, setShowFacultyUpdate] = useState(true);
  const [studentIdFacultyUpdate, setStudentIdFacultyUpdate] = useState(0);
  const [facultyUpdate, setFacultyUpdate] = useState('');
  const updateFacultyById = async () => {
    var dataFetch = await updateFaculty(studentIdFacultyUpdate, facultyUpdate);
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

  const [showAccumulateUpdate, setShowAccumulateUpdate] = useState(true);
  const [studentIdAccumulateUpdate, setStudentIdAccumulateUpdate] = useState(0);
  const [accumulateUpdate, setAccumulateUpdate] = useState('');
  const updateAccumulateById = async () => {
    var dataFetch = await updateAccumulate(studentIdAccumulateUpdate, accumulateUpdate);
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

  const getPrimaryButton = useMemo(() => {
    return <Button title={"Show All Primary Students"} color={"#34abeb"} onClick={()=> getStudentPrimary()}/>
  }, []);
  
  const getLowPointButton = useMemo(() => {
    return <Button title={"show low point students"} color={"#34abeb"} onClick={()=>getStudentLowPoint()}/>
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  
  const getClassButton = useMemo(() => {
    return <Button title={"show students in same class"} color={"#34abeb"} onClick={()=>{setShowClassGet(!showClassGet); setShowTableClass(!showTableClass);}}/>
  }, [showClassGet, showTableClass]);
  
  const getFacultyButton = useMemo(() => {
    return <Button title={"show students in same faculty"} color={"#34abeb"} onClick={()=>{setShowFacultyGet(!showFacultyGet); setShowTableFaculty(!showTableFaculty)}}/>
  }, [showFacultyGet, showTableFaculty]);

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
            {getFacultyButton}
            <IdForm title={"Faculty"} onChange={(e) => setFacultyFind(e?.target?.value)} onSubmit={() => getStudentSameFaculty()} hide={showFacultyGet} type={"text"} name={"faculty"} value={undefined}/>
          </div>
          <StudentListTable students={listStudentSameFaculty} hide={!showTableFaculty}/>

          <div className='inLine'>
            {getStudentByIdButton}
            <IdForm title={"Student ID"} onChange={(e) => setStudentIdFind(e?.target?.value)} onSubmit={() => getStudentById()} hide={showStudentGet} type={"number"} name={"studentId"} value={undefined}/>     
          </div>
          <StudentTable student={studentFind} hide={showStudentInfo}/>

          {getLowPointButton}
          <StudentListTable students={listLowPoint} hide={showListLowPoint}/>

          {getPrimaryButton}
          <StudentListTable students={listPrimary} hide={showPrimaryList}/>
        </div>

        <div className='mapContainer'>
          <div className='inLine'> 
            {updatePointButton}
            <UpdateForm title={"New Point"} onChange={useCallback((e)=> {setNewPointUpdate(e?.target?.value)}, []) } onSubmit={() => updatePointByStudentId()} hide={showPointUpdate} type={"number"} name={"trainingPoint"} value={undefined} onChangeId={useCallback((e) => {setStudentIdPointUpdate(e?.target?.value)}, [])}/>
          </div>
          
          <div className='inLine'>
            {updatePrimaryButton}
            <IdForm title={"Student ID"} onChange={useCallback((e) => {setStudentIdPrimaryUpdate(e?.target?.value)},[])} onSubmit={() => updatePrimaryByStudentId()} hide={showPrimaryUpdate} type={"number"} name={"studentId"} value={undefined}/>
          </div>

          <div className='inLine'>
            {updateNumberButton}
            <UpdateForm title={"New Number"} onChange={useCallback((e) => {setNumberUpdate(e?.target?.value)},[])} onSubmit={() => updateNumberById()} hide={showNumberUpdate} type={"text"} name={"number"} value={undefined} onChangeId={useCallback((e) => setStudentIdNumberUpdate(e?.target?.value),[])}/>
          </div>

          <div className='inLine'>
            {updateFacultyButton}
            <UpdateForm title={"New Faculty"} onChange={useCallback((e) => {setFacultyUpdate(e?.target?.value)},[])} onSubmit={() => updateFacultyById()} hide={showFacultyUpdate} type={"text"} name={"faculty"} value={undefined} onChangeId={useCallback((e) => setStudentIdFacultyUpdate(e?.target?.value),[])}/>
          </div>
          
          <div className='inLine'>
            {updateClassButton}
            <UpdateForm title={"New Class"} onChange={useCallback((e) => {setClassUpdate(e?.target?.value)},[])} onSubmit={() => updateClassById()} hide={showClassUpdate} type={"text"} name={"classRoom"} value={undefined} onChangeId={useCallback((e) => setStudentIdClassUpdate(e?.target?.value),[])}/>
          </div>
          
          <div className='inLine'>
            {updateAddressButton}
            <UpdateForm title={"New Address"} onChange={useCallback((e) => {setAddressUpdate(e?.target?.value)},[])} onSubmit={() => updateAddressById()} hide={showAddressUpdate} type={"text"} name={"address"} value={undefined} onChangeId={useCallback((e) => setStudentIdAddressUpdate(e?.target?.value),[])}/>
          </div>
          
          <div className='inLine'>
            {updateAccumulateButton}
            <UpdateForm title={"New Accumulate Number"} onChange={useCallback((e) => {setAccumulateUpdate(e?.target?.value)},[])} onSubmit={() => updateAccumulateById()} hide={showAccumulateUpdate} type={"number"} name={"accumulateNumber"} value={undefined} onChangeId={useCallback((e) => setStudentIdAccumulateUpdate(e?.target?.value),[])}/>
          </div>
        </div>

      </div>
    </div>
  );
}

export default App;
