import React from "react";
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
  color: #777;
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
  margin: 30px 0;
  width: 50px;
  border: 1px solid #bbb;

  font-size: 14px;
`;

function ProductInfo({ info, title }) {
  const getInfo = (target) => {
    if (!info) return;
    return info[target];
  };

  const getPrice = () => {
    const prices = getInfo("prices");
    if (!prices) return;
    if (prices.length > 1) {
      const [normalPrice, salePrice] = prices;
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
      return (
        <CurrentPrice>
          <strong>{normalPrice}</strong>원
        </CurrentPrice>
      );
    }
  };

  const { point, deliveryInfo, deliveryFee, conut } = detailpage;

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
            type="number"
            name="count-production"
            id="count-production"
          />
        </CountForm>
      </ProductInfoWrap>
    </ThemeProvider>
  );
}

export default ProductInfo;
