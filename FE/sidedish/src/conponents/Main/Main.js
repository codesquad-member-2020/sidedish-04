import React, { Component } from "react";
import styled from "styled-components";
import Carousel from "./Carousel";
import MoreButton from "./MoreButton";
import { title } from "../../constant/title";
import { MAIN_URL, SIDE_URL, SOUP_URL } from "../../constant/url";

import Title from "./Title";

const MainWrap = styled.main`
  display: flex;
  flex-direction: column;
`;

class Main extends Component {
  state = {
    maindishes: [],
    sidedishes: [],
    moreSidedishes: [],
  };

  getMaindishes = () => {
    fetch(MAIN_URL)
      .then((res) => res.json())
      .then((maindishes) => {
        this.setState({ maindishes: maindishes.body });
      });
  };

  getSidedishes = () => {
    fetch(SIDE_URL)
      .then((res) => res.json())
      .then((sidedishes) => {
        this.setState({ sidedishes: sidedishes.body });
      });
  };

  getMoreSidedishes = () => {
    fetch(SOUP_URL)
      .then((res) => res.json())
      .then((moreSidedishes) => {
        this.setState({ moreSidedishes: moreSidedishes.body });
      });
  };

  componentDidMount() {
    this.getMaindishes();
    this.getSidedishes();
    this.getMoreSidedishes();
  }

  // showMoreSidedishes() {
  //   if (this.state.soup.length === 0) console.log(1);
  // }

  // showMore() {
  //   console.log(2);
  //   this.getSoup();
  // }

  render() {
    const { maindishes, sidedishes, moreSidedishes } = this.state;
    const { main, side } = title;
    return (
      <MainWrap>
        <Title title={main.title} desc={main.desc} />
        <Carousel sidedishes={maindishes} />
        <Title title={side.title} desc={side.desc} />
        <Carousel sidedishes={sidedishes} />
        <MoreButton moreSidedishes={moreSidedishes} />
      </MainWrap>
    );
  }
}

export default Main;
