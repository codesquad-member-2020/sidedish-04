import {navList} from '../constant/nav'
import styled from 'styled-components';
import React from 'react'

const NavWrap = styled.nav`
  /* width: 100%; */
  height: 52px;
  background-color:#483f35;
`

const Ul = styled.ul`
  display:flex;
  justify-content: space-between;
    align-items: center;
    margin: 0 auto;
  height:inherit;
  width: 960px;
  `

const Li = styled.li`
  span{
    color: #fff;
    font-size:14px;
    font-weight: bold;
    cursor:pointer;
    &:hover {
      color: rgb(42 193 188);
    }
  }
`


function Nav(){
   return (
       <NavWrap>
         <Ul>
             {navList.map(nav => 
             <Li key={nav.id}>
                 <span>{nav.name}</span>
            </Li>)}
         </Ul>
       </NavWrap>
   )
}

export default Nav;