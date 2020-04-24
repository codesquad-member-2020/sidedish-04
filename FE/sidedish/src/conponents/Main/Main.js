import React from 'react';
import styled from 'styled-components';
import Carousel from './Carousel';
import Title from './Title';

const MainWrap = styled.main`
    margin: 0 auto;
    width: 960px;
`

function Main (){
    
    return(
        <MainWrap>
            <Title/>
           <Carousel/>
        </MainWrap>

    )
}

export default Main