import {navList} from '../../constant/nav'
import React from 'react'


function Nav(){
   return (
       <nav>
         <ul>
             {navList.map(nav => 
             <li key={nav.id}>
                 <span>{nav.name}</span>
            </li>)}
         </ul>
       </nav>
   )
}

export default Nav;