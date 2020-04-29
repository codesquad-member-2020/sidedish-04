import React from "react";
import styled from "styled-components";

const Button = styled.button`
  position: absolute;
  top: 18px;
  right: 68px;
  span {
    font-weight: bold;
    font-size: 22px;
    color: #666;
  }
`;

function CloseButton({ removeDetailPage }) {
  console.log(removeDetailPage);
  return (
    <Button onClick={removeDetailPage}>
      <span>X</span>
    </Button>
  );
}

export default CloseButton;
