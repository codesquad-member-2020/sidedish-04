import React, { useState, useRef } from "react";
import styled, { ThemeProvider, css } from "styled-components";
import detailpage from "../../constant/detailpage";
import { FlexSpaceBetween } from "../Global";

import theme from "../theme";

const ProductInfoWrap = styled.div`
  padding-left: 50px;
  width: 100%;
  text-align: left;
`;

const Title = styled.h2`
  font-size: 26px;
  font-weight: bold;
`;

const Desc = styled.div`
  font-size: 14px;
  margin: 30px 0;
`;

const SmallTitle = css`
  color: #888;
  font-size: 14px;
  width: 100px;
  padding: 5px 10px 5px 0;
  text-align: left;
  vertical-align: middle;
`;

const Th = styled.th`
  ${SmallTitle}
`;

const CountLabel = styled.label`
  ${SmallTitle};
`;

const SmallTitleSpan = styled.span`
  ${SmallTitle};
  font-weight: bold;
`;

const Td = styled.td`
  padding: 6px 0;
  font-size: 14px;
  vertical-align: middle;
  line-height: 1.3em;
`;

const Price = styled.div`
  font-weight: bold;
  font-size: 14px;
  text-align: right;
`;

const CurrentPrice = styled.span`
  strong {
    font-size: 26px;
  }
`;

const CountForm = styled.form`
  ${FlexSpaceBetween}
  margin: 30px 0;
  border-top: 1px solid #bbb;
  border-bottom: 1px solid #bbb;
`;

const PrevPrice = styled.span`
  margin-left: 7px;
  color: ${(props) => props.theme.originColor};
  text-decoration: line-through;
`;

const NumberInput = styled.input`
  ::-webkit-inner-spin-button {
    opacity: 1;
  }
  margin: 15px 0;
  width: 50px;
  border: 1px solid #bbb;

  font-size: 14px;
`;
const TotalPriceWrap = styled.div`
  text-align: right;
`;

const TotalPrice = styled.span`
  font-size: 14px;
  color: ${(props) => props.theme.sellingColor};
  font-weight: bold;
  strong {
    color: ${(props) => props.theme.sellingColor};
    font-size: 26px;
  }
`;

function ProductInfo({ info, title }) {
  const [totalPriceValue, setTotalPriceValue] = useState("0");
  //   const [currentPrice, setCurrentPrice] = useState("");
  const inputRef = useRef(null);
  let currentPrice = null;

  const getInfo = (target) => {
    if (!info) return;
    return info[target];
  };

  const calculateTotalPrice = () => {
    const currentCount = parseInt(inputRef.current.value);
    const thousandWon = 1000;
    const currentNumberPrice = parseInt(currentPrice) * thousandWon;
    console.log(currentCount, currentNumberPrice);

    const currentTotalPrice = numberFormat(currentCount * currentNumberPrice);

    setTotalPriceValue(currentTotalPrice);
  };

  const numberFormat = (inputNumber) => {
    return inputNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  };

  const getPrice = () => {
    const prices = getInfo("prices");
    if (!prices) return;
    if (prices.length > 1) {
      const [normalPrice, salePrice] = prices;
      currentPrice = salePrice;
      return (
        <>
          <CurrentPrice>
            <strong>{salePrice}</strong>원
          </CurrentPrice>
          <PrevPrice>{normalPrice}</PrevPrice>
        </>
      );
    } else {
      const [normalPrice] = prices;
      currentPrice = normalPrice;
      return (
        <CurrentPrice>
          <strong>{normalPrice}</strong>원
        </CurrentPrice>
      );
    }
  };

  const { point, deliveryInfo, deliveryFee, conut, totalPrice } = detailpage;

  return (
    <ThemeProvider theme={theme}>
      <ProductInfoWrap>
        <Title>{title}</Title>
        <Desc>{getInfo("desc")}</Desc>
        <table>
          <tbody>
            <tr>
              <Th scope="row">{point}</Th>
              <Td>{getInfo("point")}</Td>
            </tr>
            <tr>
              <Th scope="row">{deliveryInfo}</Th>
              <Td>{getInfo("deliveryInfo")}</Td>
            </tr>
            <tr>
              <Th scope="row">{deliveryFee}</Th>
              <Td>{getInfo("deliveryFee")}</Td>
            </tr>
          </tbody>
        </table>
        <Price>{getPrice()}</Price>
        <CountForm>
          <CountLabel for="count-production">{conut}</CountLabel>
          <NumberInput
            ref={inputRef}
            type="number"
            min="0"
            name="count-production"
            id="count-production"
            onChange={calculateTotalPrice}
          />
        </CountForm>
        <TotalPriceWrap>
          <SmallTitleSpan>{totalPrice}</SmallTitleSpan>
          <TotalPrice>
            <strong>{totalPriceValue}</strong> 원
          </TotalPrice>
        </TotalPriceWrap>
      </ProductInfoWrap>
    </ThemeProvider>
  );
}

export default ProductInfo;
