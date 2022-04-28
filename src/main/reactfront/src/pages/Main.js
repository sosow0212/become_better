import React, { useState } from 'react'
import { Form, Button } from 'react-bootstrap'

const Main = () => {

  const [height, setHeight] = useState(0);
  const [weight, setWeight] = useState(0);
  const [bmi, setBmi] = useState(0);

  const heightHandler = (e) => {
    setHeight(e.target.value)
  }

  const weightHandler = (e) => {
    setWeight(e.target.value)
  }

  const submitHandler = (e) => {
    e.preventDefault();
    console.log(height, weight)

    setBmi(weight / (height/100) ** 2)
    console.log(bmi)
  }

  const bmiCal = () => {
    console.log(bmi)
  }

  return (
    <div>
      <Form className='mt-3' onSubmit={submitHandler}>
        <Form.Label>키</Form.Label>
        <Form.Control type="text" placeholder="키를 입력하세요." onChange={heightHandler}/>
        
        <Form.Label className='mt-3'>체중</Form.Label>
        <Form.Control type="text" placeholder="체중을 입력하세요." name='weight' id='weight' onChange={weightHandler}/>
        
        <Form.Label className='mt-3'>BMI</Form.Label>
        <Form.Control type="text" value={bmi} name='bmi' id='bmi' readOnly/>
        <Button variant="outline-dark" type='submit' className='mt-3'>BMI확인하기</Button>
        <Button variant="outline-dark" type='submit' className='mt-3'>정보 저장하기</Button>
      </Form>
    </div>

    
  )
}

export default Main