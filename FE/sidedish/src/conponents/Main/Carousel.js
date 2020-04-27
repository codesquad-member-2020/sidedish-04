import React from "react";
import styled, { ThemeProvider } from "styled-components";
import Slider from "react-slick";
import theme from "../theme";
import "./Carousel.css";

import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

function Carousel({ sidedishes }) {
  console.log(sidedishes);
  const ArrowLeft = styled.button`
    /* width: 28px;
    height: 52px; */
    background-color: #666;
  `;
  const ArrowRight = styled.button`
    /* width: 28px;
    height: 52px; */
    background-color: #666;
  `;
  //   const ArrowLeft = (props) => (
  //     <button
  //         {...props}
  //         className={'s.prev'}/>
  // );
  // const ArrowRight = (props) => (
  //     <button
  //         {...props}
  //         className={'s.next'}/>
  // );
  const setting = {
    infinite: true,
    speed: 500,
    slidesToShow: 4,
    slidesToScroll: 4,
    arrows: true,
    prevArrow: <ArrowLeft />,
    nextArrow: <ArrowRight />,
  };

  const SliderWrap = styled.div`
    width: 960px;
    margin: 60px auto;
  `;
  const Itme = styled.div`
    width: 215px;
    padding: 0px 15px 8px;
    min-height: 360px;
    text-align: center;
  `;

  const ImgArea = styled.div`
    height: 215px;
    background: #f2f2f2;
    border-radius: 50%;
    overflow: hidden;
  `;

  const Img = styled.img`
    height: 100%;
    width: 100%;
  `;

  const ItemContent = styled.dl`
    padding: 16px 10px 12px 10px;
    text-align: center;
    overflow: hidden;
  `;
  const ItemTitle = styled.dt`
    /* text-overflow:hidden; */
    margin-bottom: 5px;
    font-size: 16px;
    font-weight: bold;
    letter-spacing: -0.07em;
    overflow: hidden;
    line-height: 1.5em;
  `;

  const ItemDesc = styled.dd`
    margin-bottom: 4px;
    font-size: 14px;
    color: #666;
    min-height: 16px;
    overflow: hidden;
    line-height: 1.2em;
  `;

  const SellingPrice = styled.p`
    color: ${(props) => props.theme.sellingColor};
    font-weight: bold;
    font-size: 26px;
    line-height: 1;
    margin-right: 10px;
    span {
      color: ${(props) => props.theme.sellingColor};
      font-size: 14px;
    }
  `;
  const OriginPrice = styled.p`
    color: ${(props) => props.theme.originColor};
    text-decoration: line-through;
  `;

  const Price = styled.dd`
    display: flex;
    justify-content: center;
    align-items: center;
  `;

  const selectButton = (n_price, s_price) => {
    if (n_price !== null) {
      return (
        <>
          <SellingPrice>
            {n_price}
            <span>원</span>
          </SellingPrice>
          <OriginPrice>{s_price}</OriginPrice>
        </>
      );
    } else {
      return (
        <SellingPrice>
          {s_price} <span>원</span>
        </SellingPrice>
      );
    }
  };

  return (
    <ThemeProvider theme={theme}>
      {/* <CarouselWrap> */}
      <SliderWrap>
        <Slider {...setting}>
          {sidedishes.map((sidedish) => {
            const {
              image,
              alt,
              title,
              description,
              n_price,
              s_price,
            } = sidedish;

            return (
              <Itme>
                <ImgArea>
                  <Img src={image} alt={alt} />
                </ImgArea>
                <ItemContent>
                  <ItemTitle>{title}</ItemTitle>
                  <ItemDesc>{description}</ItemDesc>
                  <Price>{selectButton(n_price, s_price)}</Price>
                </ItemContent>
              </Itme>
            );
          })}
        </Slider>
      </SliderWrap>
      {/* </CarouselWrap> */}
    </ThemeProvider>
  );
}

export default Carousel;
