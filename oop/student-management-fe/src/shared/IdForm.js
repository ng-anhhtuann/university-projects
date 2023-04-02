import React from "react";
import Input from "./Input";
import '../App.css';
import Submit from "./Submit";

export default function IdForm({title,onChange, onSubmit, hide, type, name}){
    return hide ? <></> : (
        <div className="inputWidth">
            <Input label={title} name={name} type={type} onChange={onChange} />
            <div className='middlePos'>
                <Submit onClick={onSubmit}/>
            </div>
        </div>
    )
}