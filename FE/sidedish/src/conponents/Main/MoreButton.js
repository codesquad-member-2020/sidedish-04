import React, { Component } from "react";
import styled from "styled-components";
import Carousel from "./Carousel";
import { title } from "../../constant/title";
import { MAIN_URL, SIDE_URL } from "../../constant/url";

const MoreBtn = styled.button`
  margin: 20px auto 50px;
  padding: 17px 0 15px;
  width: 958px;
  text-align: center;
  font-size: 16px;
  color: #444;
  border: 1px solid #d7d7d7;
`;

function MoreButton() {
  return (
    <MoreBtn>
      <span>반찬 전체보기</span>
      <i class="fas fa-chevron-right"></i>
    </MoreBtn>
  );
}

export default MoreButton;
