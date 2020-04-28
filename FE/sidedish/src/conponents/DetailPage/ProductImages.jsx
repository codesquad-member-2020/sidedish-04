import React from "react";
import styled from "styled-components";

const Wrap = styled.div`
  width: 51%;
`;

const MainImgWrap = styled.div`
  background-size: contain;
  margin: 5px;
  width: 100%;
  height: 100%;

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
  height: 70px;
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
          <img src={subImage} />
        </Item>
      );
    });
    return subImagesList;
  };

  return (
    <Wrap>
      <MainImgWrap>
        <img src={mainImage} />
      </MainImgWrap>
      <ItemList>{getSubImages(subImages)}</ItemList>
    </Wrap>
  );
}

export default ProductImages;
