import React from 'react';
import styled from 'styled-components';

const TitleWrap = styled.div`
  margin: 20px 0;
  text-align: center; 
`

const H2 = styled.h2`
    color: #999;
    font-size: 18px;
    font-weight:bold;
    margin-bottom: 5px;
`
const P = styled.p`
    font-size: 34px;
`

function Title (){
    return(
          <TitleWrap>
            <H2>밑반찬</H2>
            <P>언제 먹어도 <strong>밑반찬</strong></P>
          </TitleWrap>
          )
}

export default Title;