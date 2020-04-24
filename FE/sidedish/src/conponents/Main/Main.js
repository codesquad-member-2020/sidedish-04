import React from 'react';
import styled from 'styled-components';
import Carousel from './Carousel';

const MainWrap = styled.main`
    margin: 0 auto;
    width: 960px;
`

function Main (){
    
    return(
        <MainWrap>
           <Carousel/>
        </MainWrap>

    )
}

export default Main