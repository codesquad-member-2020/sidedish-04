import React from 'react';
import styled from 'styled-components';
import Slider from 'react-slick';

import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";

const CarouselWrap = styled.section`
  width:100%;
  height: 370px;
  /* padding:20px 0; */
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


const ItemArea = styled.div`
    height: 215px;
    background: #f2f2f2;
    border-radius: 50%;
    overflow:hidden;

`

const Img = styled.img`
  height:100%;
  width:100%;
 
`

  
  return(
    <CarouselWrap>
    <Slider {...slideSetting}>
     <ul>
       <Li>
         <ItemArea>
           <Img src="https://web.archive.org/web/20190122062652im_/https://cdn.bmf.kr/_data/product/I9E9A/ab4c422855875181ede52f6ac1954fde.jpg" alt="" />
        </ItemArea>
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
