import React, { useState, useEffect } from 'react'
import axios from 'axios'

const Register = () => {

  const [data, setData] = useState({
    data : ''
  });

  useEffect(() => {
      getData();
  }, []);


  const getData = async() => {
    const dataFromServer = await axios
      .get("http://localhost:8080/register");
    setData(dataFromServer);
  }
  

  return (
    <div>{data.data}</div>
  )
}
export default Register