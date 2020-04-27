import React, { Component } from "react";
import styled from "styled-components";
import Carousel from "./Carousel";
import { URL } from "../../constant/url";

import Title from "./Title";

const MainWrap = styled.main`
  /* margin: 0 auto;
    width: 960px; */
`;

class Main extends Component {
  state = {
    sidedishes: [],
  };

  getMenu = () => {
    fetch(URL)
      .then((res) => res.json())
      .then((sidedishes) => {
        this.setState({ sidedishes: sidedishes.body });
      });
  };

  componentDidMount() {
    this.getMenu();
  }

  render() {
    const { sidedishes } = this.state;
    return (
      <MainWrap>
        <Title />
        {/* {sidedishes.map((sidedish) => {
          return (
            <Carousel
              detail_hash={sidedish.detail_hash}
              image={sidedish.image}
              alt={sidedish.alt}
              delivery_type={sidedish.delivery_type}
              title={sidedish.title}
              description={sidedish.description}
              n_price={sidedish.n_price}
              s_price={sidedish.s_price}
              badge={sidedish.badge}
            />
          );
        })} */}

        <Carousel />
        <Title />
        <Carousel />
      </MainWrap>
    );
  }
}

export default Main;
