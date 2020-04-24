import React from 'react';
import styled from 'styled-components';
import Slider from 'react-slick';

import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";

const CarouselWrap = styled.section`
  width:300px;
  background-color:red;
`

const Page = styled.div`
   width:30px;
  height:150px;
`

function Carousel() {
  const slideSetting = {
    slide: 'div',
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 4,
    slidesToScroll: 4,
    arrows : true
  }
  
  return(
    <CarouselWrap>
    <Slider {...slideSetting}>
      <div>
        <h3>1</h3>
      </div>
      <div>
        <h3>2</h3>
      </div>
      <div>
        <h3>3</h3>
      </div>
      <div>
        <h3>4</h3>
      </div>
      <div>
        <h3>5</h3>
      </div>
      <div>
        <h3>6</h3>
      </div>
    </Slider>
  </CarouselWrap>
  )
}

export default Carousel;
