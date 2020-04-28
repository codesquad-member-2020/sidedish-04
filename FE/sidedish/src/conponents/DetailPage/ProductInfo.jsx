import React from "react";
import styled from "styled-components";
import detailpage from "../../constant/detailpage";

const ProductInfoWrap = styled.div`
  margin: 30px;
  width: 100%;
  text-align: center;
`;

const Title = styled.h2`
  font-size: 26px;
  font-weight: bold;
  margin-bottom: 10px;
`;

const Desc = styled.div``;

function ProductInfo({ info, title }) {
  const getInfo = (target) => {
    if (!info) return;
    return info[target];
  };

  const { point } = detailpage;

  return (
    <ProductInfoWrap>
      <Title>{title}</Title>
      <Desc>{getInfo("desc")}</Desc>
      <table>
        <tbody>
          <tr>
            <th>{point}</th>
            <td>{getInfo("point")}</td>
          </tr>
        </tbody>
      </table>
    </ProductInfoWrap>
  );
}

export default ProductInfo;
