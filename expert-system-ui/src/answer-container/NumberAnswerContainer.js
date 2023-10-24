import React from 'react';

const NumberAnswerContainer = ({handleClick}) => {

	const handleInput = async (e) => {
		if (e.key === 'Enter') {
			const inputValue = e.target.value;
			handleClick(inputValue);
		}
	};

	return (
		<div className='number-answer-container'>
			<input 
				type="number" 
				id="numberInput"  
				onKeyDown={handleInput}
				className='number-input' 
				placeholder={"Введіть кількість тижнів"}
      		/>
		</div>	
	)
}

export default NumberAnswerContainer;