import React, { useState } from 'react';
import '../App.css';

export default function Button({ title, onClick, color = '#11ab1b', fadeColor = `${color}50` }) {
  const [clicked, setClicked] = useState(false);

  const handleClick = () => {
    setClicked(true);
    onClick();
    setTimeout(() => {
      setClicked(false);
    }, 100);
  };

  const buttonClassName = clicked ? 'ButtonClicked' : 'Button';
  const buttonStyle = { backgroundColor: color };
  const clickedButtonStyle = { backgroundColor: fadeColor };

  return (
    <button
      className={buttonClassName}
      onClick={handleClick}
      style={clicked ? clickedButtonStyle : buttonStyle}
    >
      <span className="ButtonTitle">{title.toUpperCase()}</span>
    </button>
  );
};
