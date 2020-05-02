import React from "react";
import styled from "styled-components";

const TitleWrap = styled.div`
  margin: 50px 0;
  text-align: center;
`;

const H2 = styled.h2`
  color: #999;
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 5px;
  line-height: 1.5em;
`;
const P = styled.p`
  font-size: 34px;
  strong {
    font-weight: bold;
  }
`;

function Title({ title, desc }) {
  return (
    <TitleWrap>
      <H2>{title}</H2>
      <P>
        {desc} <strong>{title}</strong>
      </P>
    </TitleWrap>
  );
}

export default Title;
