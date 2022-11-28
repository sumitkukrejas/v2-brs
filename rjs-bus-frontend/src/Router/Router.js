import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import HomePage from '../Pages/HomePage/HomePage'
import LoginForm from '../Pages/LandingPage/Features/LoginForm'
import SignUpForm from '../Pages/LandingPage/Features/SignUpForm'
import LandingPage from '../Pages/LandingPage/LandingPage'

const Router = () => {
  return (
    <div>
        
        <BrowserRouter>
        <Routes>
            <Route  exact path='/' element={<LandingPage/>}>
              <Route exact path='/login' element={<LoginForm/>}/> 
              <Route exact path='/register' element={<SignUpForm/>}/>
            </Route>
            <Route exact path='/home' element={<HomePage/>}>
              {/* user home page */}
              </Route> 
        </Routes>
        </BrowserRouter>
    </div>
  )
}

export default Router