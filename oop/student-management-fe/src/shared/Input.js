import React from 'react';
import '../App.css';

const Input = ({ label, name, type, onChange }) => {
  return (
    <div className='between'>
      <label htmlFor={name}>{label}:</label>
      <input type={type} name={name} id={name} onChange={onChange} className="Input" required={true} />
    </div>
  );
};

export default Input;
