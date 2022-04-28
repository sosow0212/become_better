import React from 'react'
import { Link, Outlet } from 'react-router-dom'


const Header = () => {
  return (
    <div>
      <ul>
        <li>
          <Link to="/home">Home</Link>
        </li>
        <li>
          <Link to="/register">Register</Link>
        </li>
      </ul>

      <Outlet/>
    </div>
  )
}

export default Header