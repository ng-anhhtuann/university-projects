import React from 'react';
import '../App.css'

export default function Submit({ onClick }){
  return (
    <button className="Submit" onClick={onClick}>
      <span className="ButtonTitle">Submit</span>
    </button>
  );
  };