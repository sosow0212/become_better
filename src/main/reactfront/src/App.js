import React from 'react';
import {Routes, Route} from "react-router-dom";
import Home from './pages/Home';
import Register from './pages/Register';
import Header from './components/Header';




function App() {
  return (
    <Routes>
      <Route path="/" element={<Header/>} />
        <Route path="/home" element={<Home/>} />
        <Route path="/register" element={<Register/>}/>
    </Routes>
  );
}

export default App;