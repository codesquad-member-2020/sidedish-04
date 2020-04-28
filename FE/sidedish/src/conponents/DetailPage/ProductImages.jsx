import React from "react";
import styled from "styled-components";
import { FlexCenter } from "../Global";

const Wrap = styled.div`
  width: 25%;
`;

const MainImgWrap = styled.div`
  margin: 5px;
  width: 100%;
  img {
    width: 100%;
    height: 100%;
  }
`;

const ItemList = styled.ul`
  margin-left: 5px;
  display: flex;
  justify-content: space-between;
`;

const Item = styled.li`
  width: 23%;
  img {
    width: 100%;
    height: 100%;
  }
`;

function ProductImages({ images: { mainImage, subImages } }) {
  const getSubImages = (currentSubImages) => {
    if (!currentSubImages) return;
    const subImagesList = currentSubImages.map((subImage, index) => {
      return (
        <Item key={index}>
          <img src={subImage} alt="" />
        </Item>
      );
    });
    return subImagesList;
  };

  return (
    <Wrap>
      <MainImgWrap>
        <img src={mainImage} alt="" />
      </MainImgWrap>
      <ItemList>{getSubImages(subImages)}</ItemList>
    </Wrap>
  );
}

export default ProductImages;
