import React, { useState } from 'react';
import Input from './Input';
import Submit from './Submit';
import '../App.css';

export default function InsertForm({ onSubmit, hide }) {
    const [formData, setFormData] = useState({
        studentId: '',
        name: '',
        faculty: '',
        class: 'unknown',
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

      return hide ? <></> : (
        <form id="insert-form" style={{ width: '310px', height: 'fit-content', position: 'relative', border: '1px solid', borderRadius: '4px', padding: '5px', marginLeft: '50px' }} onSubmit={handleSubmit}>
            <Input label="Student ID" name="studentId" type="number" value={formData.studentId} onChange={handleInputChange} />
            <Input label="Name" name="name" type="text" value={formData.name} onChange={handleInputChange} />
            <Input label="Faculty" name="faculty" type="text" value={formData.faculty} onChange={handleInputChange} />
            <Input label="Class" name="class" type="text" value={formData.class} onChange={handleInputChange} />
            <Input label="Is Primary" name="isPrimary" type="checkbox" value={formData.isPrimary} onChange={handleInputChange} />
            <Input label="Training Point" name="trainingPoint" type="number" value={formData.trainingPoint} onChange={handleInputChange} />
            <Input label="Accumulate Number" name="accumulateNumber" type="number" value={formData.accumulateNumber} onChange={handleInputChange} />
            <Input label="Citizen ID" name="citizenId" type="text" value={formData.citizenId} onChange={handleInputChange} />
            <Input label="Number" name="number" type="text" value={formData.number} onChange={handleInputChange} />
            <Input label="Born" name="born" type="date" value={formData.born} onChange={handleInputChange} />
            <Input label="Address" name="address" type="text" value={formData.address} onChange={handleInputChange} />
            <div className='middlePos'>
                <Submit onClick={onSubmit}/>
            </div>
        </form>
      );
};
