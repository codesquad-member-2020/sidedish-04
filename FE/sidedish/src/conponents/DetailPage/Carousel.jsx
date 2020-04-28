import React from "react";
import styled, { ThemeProvider } from "styled-components";
// import Arrow from "./Arrow";
import Slider from "react-slick";
import { Layout } from "../Global";
import theme from "../theme";

import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

function Carousel({ sidedishes }) {
  const ArrowLeft = styled.button`
    ::before {
      content: "◀";
      color: #ffb6b9;
      font-size: 34px;
      position: relative;
      left: -15px;
    }
  `;
  const ArrowRight = styled.button`
    ::before {
      content: "▶";
      color: #ffb6b9;
      font-size: 34px;
    }
  `;

  const setting = {
    infinite: true,
    speed: 500,
    slidesToShow: 4,
    slidesToScroll: 4,
    arrows: true,
    prevArrow: <ArrowLeft />,
    nextArrow: <ArrowRight />,
    // nextArrow: <Arrow type="next" />,
    // prevArrow: <Arrow type="prev" />,
  };

  const SliderWrap = styled.div`
    margin: 60px auto;
    width: 300px;
    width: 950px;
    height: 100%;
  `;

  const ImgArea = styled.div`
    padding: 20px;
    height: 200px;
    width: 100%;
    /* border-radius: 50%; */
    overflow: hidden;
  `;

  const Img = styled.img`
    height: 100%;
    width: 100%;
  `;
  const getImages = (sidedishes) => {
    if (!sidedishes) return;

    const slides = sidedishes.map((sidedish, index) => {
      return (
        <ImgArea key={index}>
          <Img src={sidedish} />
        </ImgArea>
      );
    });

    return slides;
  };

  return (
    <ThemeProvider theme={theme}>
      <SliderWrap>
        <Slider {...setting}>{getImages(sidedishes)}</Slider>
      </SliderWrap>
    </ThemeProvider>
  );
}

export default Carousel;
