import React, { useEffect, useState } from 'react';
import axios from 'axios';
import "./Question.css"
import Result from '../result/Result';
import AnswerContainer from '../answer-container/AnswerContainer';
import AnswerButton from '../answer-button/AnswerButton';

const Question= () => {

	const [currentQuestion, setCurrentQuestion] = useState();
	const [data, setData] = useState([]);
	const [inProgress, setInProgress] = useState(true);

	useEffect(() => {
        axios.get('http://localhost:8080/expertSystem/currentQuestion')
            .then((res) => {
                setCurrentQuestion(res.data);
            });
    }, []);

	const handleClick = async (index) => {
		try {
            const response = await axios.post(`http://localhost:8080/expertSystem/nextQuestion?index=${index}`);
			console.log(response);
			if (response.data === '') {
				processResult();
			} else {
				setCurrentQuestion(response.data);
			}
        } catch (error) {
            console.error("Error fetching data:", error);
        }
	}

	const processResult = () => {
		axios.get('http://localhost:8080/expertSystem/result')
            .then((res) => {
				const result = res.data;
				const data = Object.entries(result).map(([name, value]) => ({name, value}));
                setData(data);
            });
		
		setInProgress(false);
	}

	const handleNewButtonCLick = async () => {
		try {
            const response = await axios.get(`http://localhost:8080/expertSystem/newTree`);
			setCurrentQuestion(response.data);
			setInProgress(true);
        } catch (error) {
            console.error("Error fetching data:", error);
        }
	}

	return (
		<div>
			{inProgress ? (
				<div className='cont'>
				<div className="loading"></div>
				<div className='q-content'>
				<div className='q-text-container'>{currentQuestion?.questionText}</div>
				<AnswerContainer questionType={currentQuestion?.questionType} answers={currentQuestion?.textAnswers} handleClick={handleClick}></AnswerContainer>
			</div>
			</div>
			) : (
				<div className='cont'>
				<Result data={data}></Result>
				<div className='q-content'>
				<div className='result-content'>
					<div className='result-component' style={{backgroundColor: "#5296D5"}}>{data[0]?.name}</div>
					<div className='result-component' style={{backgroundColor: "#D65745"}}>{data[1]?.name}</div>
					<div className='result-component' style={{backgroundColor: "#F8BF70"}}>{data[2]?.name}</div>
				</div>
				<div className="button">
					<AnswerButton text={"Test again"} onClick={handleNewButtonCLick}></AnswerButton>
				</div>				
			</div>
			</div>
			)}
		</div>
	)

}

export default Question;