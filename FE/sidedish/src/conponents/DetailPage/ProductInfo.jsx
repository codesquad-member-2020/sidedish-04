import React from "react";
import styled from "styled-components";
import detailpage from "../../constant/detailpage";

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

const Th = styled.th`
  color: #777;
  font-size: 14px;
  width: 100px;
  padding: 5px 10px 5px 0;
  text-align: left;
  vertical-align: middle;
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
  strong {
    font-size: 26px;
  }
`;

function ProductInfo({ info, title }) {
  const getInfo = (target) => {
    if (!info) return;
    return info[target];
  };

  const { point, deliveryInfo, deliveryFee } = detailpage;

  return (
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
      <Price>
        <strong>{getInfo("prices")}</strong>원
      </Price>
    </ProductInfoWrap>
  );
}

export default ProductInfo;
