import React, { Component } from "react";
import styled from "styled-components";
import Carousel from "./Carousel";
import MoreButton from "./MoreButton";
import DetailPage from "../DetailPage/Detailpage";
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
    detailPageId: "",
    detailPageTitle: "",
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

  showDetailPage = () => {
    const { detailPageId, detailPageTitle } = this.state;
    if (detailPageId) {
      return (
        <DetailPage
          removeDetailPage={this.removeDetailPage}
          detailPageId={detailPageId}
          detailPageTitle={detailPageTitle}
        />
      );
    }
  };

  setDetailPageId = (id) => {
    this.setState({ detailPageId: id });
  };

  setDetailPageTitle = (title) => {
    this.setState({ detailPageTitle: title });
    console.log(this.state);
  };

  removeDetailPage = () => {
    this.setState({ detailPageId: null });
  };

  render() {
    const { maindishes, sidedishes, moreSidedishes } = this.state;
    const { main, side } = title;

    return (
      <MainWrap>
        <Title title={main.title} desc={main.desc} />
        <Carousel
          sidedishes={maindishes}
          setDetailPageId={this.setDetailPageId}
          setDetailPageTitle={this.setDetailPageTitle}
        />
        <Title title={side.title} desc={side.desc} />
        <Carousel
          sidedishes={sidedishes}
          setDetailPageId={this.setDetailPageId}
          setDetailPageTitle={this.setDetailPageTitle}
        />
        <MoreButton
          moreSidedishes={moreSidedishes}
          setDetailPageId={this.setDetailPageId}
          setDetailPageTitle={this.setDetailPageTitle}
        />
        {this.showDetailPage()}
      </MainWrap>
    );
  }
}

export default Main;
