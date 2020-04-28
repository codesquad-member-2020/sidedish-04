import React from "react";
import styled from "styled-components";
import detailpage from "../../constant/detailpage";

const ProductInfoWrap = styled.div`
  padding: 35px 50px 0 100px;
  width: 100%;
  text-align: center;
`;

const Title = styled.h2`
  font-size: 26px;
  font-weight: bold;
  margin-bottom: 10px;
`;

const Desc = styled.div``;

const Th = styled.th`
  color: #666;
  width: 100px;
  padding: 5px 10px 5px 0;
  text-align: left;
  vertical-align: middle;
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
            <td>{getInfo("point")}</td>
          </tr>
          <tr>
            <Th scope="row">{deliveryInfo}</Th>
            <td>{getInfo("deliveryInfo")}</td>
          </tr>
          <tr>
            <Th scope="row">{deliveryFee}</Th>
            <td>{getInfo("deliveryFee")}</td>
          </tr>
        </tbody>
      </table>
    </ProductInfoWrap>
  );
}

export default ProductInfo;
