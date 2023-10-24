import React from 'react';
import AnswerButton from '../answer-button/AnswerButton';


const ListAnswerContainer = ({answers, handleClick}) => {

	return (
		<div className='list-answer-container'>
			{answers.map((answer, index) => (
				<AnswerButton text={answer} onClick={() => handleClick(index)}></AnswerButton>
      		))}
		</div>	
	)
}

export default ListAnswerContainer;