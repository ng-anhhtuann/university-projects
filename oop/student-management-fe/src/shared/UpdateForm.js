import React from "react";
import Input from "./Input";
import '../App.css';
import Submit from "./Submit";

export default function UpdateForm({title,onChangeId,onChange, onSubmit, hide, type, name, value}){
    return hide ? <></> : (
        <div className="inputWidth">
            <Input label={"Student ID"} name={"studentId"} type={"number"} value={undefined} onChange={onChangeId} />
            <Input label={title} name={name} type={type} value={value} onChange={onChange} />
            <div className='middlePos'>
                <Submit onClick={onSubmit}/>
            </div>
        </div>
    )
}