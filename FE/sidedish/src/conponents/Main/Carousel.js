import React from 'react';
import styled from 'styled-components';
import Slider from 'react-slick';

import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";

const CarouselWrap = styled.section`
  width:100%;
  height: 370px;
  background-color:red;
  /* display:flex; */
  /* justify-content: space-between; */
  /* align-items: center; */
`
function Carousel() {
  const slideSetting = {
    slide: 'li',
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 4,
    slidesToScroll: 4,
    arrows : true
  }

 const Ul = styled.ul`

`
 const Li = styled.li`
  width:90%;
  /* background-color:blue; */
`
const SlideTitle = styled.div`
  text-align: center; 
`

const H2 = styled.h2`
    color: #999;
    font-size: 14px;
    font-weight:bold;
    margin-bottom: 5px;
`

  
  return(
    <CarouselWrap>
      <SlideTitle>
        <H2>밑반찬</H2>
        <p>언제 먹어도 <strong>밑반찬</strong></p>
      </SlideTitle>
    <Slider {...slideSetting}>
     <ul>
       <Li>
         <div class="item__img">
           <img src="https://web.archive.org/web/20190122062652im_/https://cdn.bmf.kr/_data/product/I9E9A/ab4c422855875181ede52f6ac1954fde.jpg" alt="" />
        </div>
        <dl>
           <dt class="item__title">[잡밥의완성]두부시래기조림 300g</dt>
           <dd class="item__desc">칼칼해서 더 좋아요</dd>
           <dd class="item__price">
             <p class="price__selling">3,050<span>원</span></p>
             <p class="price__origin">4,050<span>원</span></p>
           </dd>
         </dl>
      </Li>
  
     </ul>

   </Slider>
  </CarouselWrap>
  )
}

export default Carousel;
