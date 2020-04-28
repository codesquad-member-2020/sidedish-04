import React, { Component } from "react";
import styled from "styled-components";
import Carousel from "./Carousel";
import { title } from "../../constant/title";
import Title from "./Title";
import { SOUP_URL } from "../../constant/url";

const MoreBtn = styled.button`
  margin: 20px auto 50px;
  padding: 17px 0 15px;
  width: 958px;
  text-align: center;
  font-size: 16px;
  color: #444;
  border: 1px solid #d7d7d7;
`;

class MoreButton extends Component {
  state = {
    moreSidedishes: [],
    isClick: false,
  };

  // getMoreSidedishes = () => {
  //   fetch(SOUP_URL)
  //     .then((res) => res.json())
  //     .then((soup) => {
  //       this.setState({ moreSidedishes: moreSidedishes.body });
  //     });
  // };

  showMoreSidedishes = () => {
    this.setState({ isClick: true });
  };

  render() {
    const { soup } = title;
    const { isClick } = this.state;
    const moreSidedishes = this.props.moreSidedishes;
    console.log(moreSidedishes);
    let _content = null;
    if (isClick) {
      _content = (
        <>
          <Title title={soup.title} desc={soup.desc} />
          <Carousel sidedishes={moreSidedishes} />
        </>
      );
      console.log();
    } else {
      _content = (
        <MoreBtn onClick={this.showMoreSidedishes}>
          <span>반찬 전체보기 ></span>
        </MoreBtn>
      );
    }
    return <>{_content}</>;
  }
}

export default MoreButton;
