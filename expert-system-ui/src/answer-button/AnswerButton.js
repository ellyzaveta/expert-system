import React, { useState } from 'react';
import './AnswerButton.css'

const AnswerButton = ({ onClick, text, color }) => {
    const [isHovered, setIsHovered] = useState(false);
  
    const buttonStyle = {
        backgroundColor: isHovered ? 'rgba(248, 191, 112, 1)' : color,
        color: isHovered ? 'white' : "rgba(47, 51, 60, 1)",
        transition: '0.3s all', 
    };
  
    return (
        <button
            style={buttonStyle}
            onClick={onClick}
            onMouseEnter={() => setIsHovered(true)}
            onMouseLeave={() => setIsHovered(false)}
        >
            {text}
        </button>
    );
};
  
export default AnswerButton;
