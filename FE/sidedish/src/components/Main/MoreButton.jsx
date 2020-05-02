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
    isClick: false,
  };

  clickMoreBtn = () => {
    this.setState({ isClick: true });
  };

  showMoreSidedish = () => {
    const { soup } = title;
    const { isClick } = this.state;
    const { moreSidedishes } = this.props;
    let _content = null;
    if (isClick) {
      _content = (
        <>
          <Title title={soup.title} desc={soup.desc} />
          <Carousel
            sidedishes={moreSidedishes}
            setDetailPageId={this.props.setDetailPageId}
            setDetailPageTitle={this.props.setDetailPageTitle}
          />
        </>
      );
    } else {
      _content = (
        <MoreBtn onClick={this.clickMoreBtn}>
          <span>반찬 전체보기 ></span>
        </MoreBtn>
      );
    }
    return _content;
  };

  render() {
    return <>{this.showMoreSidedish()}</>;
  }
}

export default MoreButton;
