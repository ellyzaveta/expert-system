import React from 'react';
import ListAnswerContainer from './ListAnswerContainer';
import NumberAnswerContainer from './NumberAnswerContainer';
import YesNoAnswerContainer from './YesNoAnswerContainer';

import "./AnswerContainer.css"

const AnswerContainer = ({questionType, answers, handleClick}) => {

	if (questionType == "LIST") {
		return (
			<ListAnswerContainer answers={answers} handleClick={handleClick}></ListAnswerContainer>
		)
	} else if (questionType == "YES_NO") {
		return (
			<YesNoAnswerContainer answers={answers} handleClick={handleClick}></YesNoAnswerContainer>
		)
	} else if (questionType == "NUMBER") {
		return (
			<NumberAnswerContainer handleClick={handleClick}></NumberAnswerContainer>
		)
	} else {
		return null;
	}
}

export default AnswerContainer;