import React from "react";
import Input from "./Input";
import '../App.css';
import Submit from "./Submit";

export default function IdForm({title,onChange, onSubmit, hide, type, name, value}){
    return hide ? <></> : (
        <div className="inputWidth">
            <Input label={title} name={name} type={type} value={value} onChange={onChange} />
            <div className='middlePos'>
                <Submit onClick={onSubmit}/>
            </div>
        </div>
    )
}