import React from "react";
import SearchBar from "./SearchBar";
import { Layout } from "../Global";
import styled from "styled-components";

const HeaderWrap = styled.header`
  ${Layout};
  height: 150px;
`;

function Header() {
  return (
    <HeaderWrap>
      <h1 className="logo">
        <img
          src="https://web.archive.org/web/20190122062652im_/https://cdn.bmf.kr/web/common/bmc-logo.png"
          alt="모바일 넘버원 반찬가게-배민프레시"
        />
      </h1>
      <SearchBar />
    </HeaderWrap>
  );
}

export default Header;
