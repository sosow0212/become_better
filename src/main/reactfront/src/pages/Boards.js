import React from "react";
import { Table } from "react-bootstrap";
import { useState, useEffect } from "react";
import { axios } from "axios";

const config = {
  headers: {
    Authorization: "Bearer " + localStorage.getItem("Authorization"),
  },
};


function Boards(Authorization) {
  const [boards, setBoards] = useState({});

 
  useEffect(() => {
    localStorage.setItem("Authorization", Authorization);

    fetch('http://localhost:8080/board')
      .then((res) => res.json())
      .then((res) => {
        setBoards(res);
      });
  }, []);


  const click = async () => {
    fetch('http://localhost:8080/board')
      .then((res) => res.json())
      .then((res) => {
        setBoards(res);
      });
      console.log(boards);
  }


  return (
    <div className="mt-5">
      <button onClick={click}>ddd</button>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일자</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>제목입니다</td>
            <td>작성자입니다</td>
            <td>2022-02-02</td>
          </tr>
        </tbody>
      </Table>
    </div>
  );
}

export default Boards;
