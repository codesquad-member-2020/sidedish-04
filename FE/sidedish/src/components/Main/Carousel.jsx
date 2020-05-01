import React from "react";
import styled, { ThemeProvider } from "styled-components";
import Slider from "react-slick";
import { FlexCenter } from "../Global";
import theme from "../theme";

import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

function Carousel({ sidedishes, setDetailPageId, setDetailPageTitle }) {
  const ArrowLeft = styled.button`
    ::before {
      content: "◀";
      color: #ffb6b9;
      font-size: 38px;
      position: relative;
      left: -15px;
    }
  `;
  const ArrowRight = styled.button`
    ::before {
      content: "▶";
      color: #ffb6b9;
      font-size: 38px;
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
    width: 960px;
    margin: 30px auto;
  `;
  const Item = styled.div`
    width: 215px;
    padding: 0px 15px 8px;
    min-height: 360px;
  `;

  const DetailPageButton = styled.button`
    width: inherit;
    min-height: inherit;
    text-align: center;
  `;

  const ImgShadow = styled.div`
    ${FlexCenter};
    visibility: hidden;
    flex-direction: column;
    position: absolute;
    top: 0;
    left: 0;
    background-color: #000;
    width: inherit;
    height: inherit;
    opacity: 0.7;
    span {
      padding: 8px 0;
      color: #fff;
    }
  `;

  const ImgArea = styled.div`
    position: relative;
    height: 215px;
    width: 210px;
    background: #f2f2f2;
    border-radius: 50%;
    overflow: hidden;
    &:hover {
      ${ImgShadow} {
        visibility: visible;
      }
    }
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
    margin-bottom: 5px;
    font-size: 16px;
    font-weight: bold;
    letter-spacing: -0.07em;
    overflow: hidden;
    line-height: 1.5em;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
  `;

  const ItemDesc = styled.dd`
    margin-bottom: 13px;
    font-size: 13px;
    color: #666;
    min-height: 16px;
    overflow: hidden;
    line-height: 1.2em;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
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
    ${FlexCenter}
    margin-bottom: 13px;
  `;

  const EventBadgeBox = styled.div`
    width: 100%;
    height: 30px;
    text-align: center;
    margin: 5px;
  `;

  const EventBadge = styled.span`
    padding: 5px;
    margin: 5px;
    background-color: ${(props) => {
      const event = props.children;
      if (event === "이벤트특가") {
        return props.theme.eventColor;
      } else {
        return props.theme.launchingColor;
      }
    }};
    font-size: 11px;
    font-weight: bold;
    color: #fff;
  `;

  const priceRender = (n_price, s_price, badges) => {
    let _price = null;
    if (n_price) {
      _price = (
        <>
          <Price>
            <SellingPrice>
              {n_price}
              <span>원</span>
            </SellingPrice>
            <OriginPrice>{s_price}</OriginPrice>
          </Price>
          <EventBadgeBox>
            {badges.map((badge, index) => (
              <EventBadge key={index}>{badge}</EventBadge>
            ))}
          </EventBadgeBox>
        </>
      );
    } else {
      _price = (
        <Price>
          <SellingPrice>
            {s_price}
            <span>원</span>
          </SellingPrice>
        </Price>
      );
    }

    return _price;
  };

  return (
    <ThemeProvider theme={theme}>
      <SliderWrap>
        <Slider {...setting}>
          {sidedishes.map((sidedish) => {
            const {
              detail_hash,
              image,
              alt,
              title,
              description,
              n_price,
              s_price,
              delivery_type,
              badge,
            } = sidedish;

            return (
              <Item key={detail_hash}>
                <DetailPageButton
                  onClick={() => {
                    setDetailPageId(detail_hash);
                    setDetailPageTitle(title);
                    console.log(title, setDetailPageTitle);
                  }}
                >
                  <ImgArea>
                    <Img src={image} alt={alt} />
                    <ImgShadow>
                      {delivery_type.map((deliveryType, index) => (
                        <span key={index}>{deliveryType}</span>
                      ))}
                    </ImgShadow>
                  </ImgArea>
                  <ItemContent>
                    <ItemTitle>{title}</ItemTitle>
                    <ItemDesc>{description}</ItemDesc>
                    {priceRender(n_price, s_price, badge)}
                  </ItemContent>
                </DetailPageButton>
              </Item>
            );
          })}
        </Slider>
      </SliderWrap>
    </ThemeProvider>
  );
}

export default Carousel;
