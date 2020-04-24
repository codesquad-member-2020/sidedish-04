import React from 'react'
import {navList} from '../../constant/nav'
import Nav from './Nav'

// import styled from 'styled-components'

function Header(){
    return (
        <header>
              <h1 className='logo'>
               <img src="https://web.archive.org/web/20190122062652im_/https://cdn.bmf.kr/web/common/bmc-logo.png" alt="모바일 넘버원 반찬가게-배민프레시" />
             </h1>
             <Nav/>
        </header>
    )
}

export default Header;