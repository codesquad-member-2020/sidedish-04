import {navList} from '../../constant/nav'
import React from 'react'


function Nav(){
   return (
       <nav>
         <ul>
             {navList.map(nav => <li>{nav.name}</li>)}
         </ul>
       </nav>
   )
}

export default Nav;