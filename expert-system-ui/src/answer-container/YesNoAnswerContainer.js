import React from 'react';
import AnswerButton from '../answer-button/AnswerButton';


const YesNoAnswerContainer = ({answers, handleClick}) => {

	return (
		<div className='yes-no-answer-container'>
			{answers.map((answer, index) => (
				<AnswerButton text={answer} onClick={() => handleClick(index)}></AnswerButton>
      		))}
		</div>	
	)
}

export default YesNoAnswerContainer;