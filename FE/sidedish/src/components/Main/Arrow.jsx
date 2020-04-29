import React from "react";
import styled from "styled-components";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
const Arrow = (props) => {
  const Arrow = styled.img`
    width: 30px;

    margin: 15px;
  `;
  let className = props.type === "next" ? "nextArrow" : "prevArrow";
  const ArrowBtn =
    props.type === "next" ? (
      <Arrow src="https://image.flaticon.com/icons/svg/271/271228.svg" />
    ) : (
      <Arrow src="https://image.flaticon.com/icons/svg/271/271220.svg" />
    );
  return (
    <React.Fragment>
      <span className={className} onClick={props.onClick}>
        {ArrowBtn}
      </span>
    </React.Fragment>
  );
};
export default Arrow;
