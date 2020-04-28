import React, { Component } from "react";
import styled from "styled-components";
import { DETAIL_URL } from "../../constant/url";

const DetailPageButton = styled.button`
  width: inherit;
  min-height: inherit;
  text-align: center;
  cursor: pointer;
`;

class DetailPage extends Component {
  state = {
    isClick: false,
    detailPage: null,
  };

  getDetailPage = () => {
    const { detailPageId } = this.props;
    const detailUrl = DETAIL_URL.replace("{id}", detailPageId);
    fetch(detailUrl)
      .then((res) => res.json())
      .then((detailPage) => {
        this.setState({ detailPage: detailPage.data });
        console.log(this.state.detailPage);
      });
  };

  componentDidMount() {
    this.getDetailPage();
  }

  render() {
    return (
      <div>
        <div>
          {/* <productImages /> */}
          {/* <productInfo/>  */}
        </div>
        {/* <Carousel
          sidedishes={sidedishes}
          setDetailPageId={this.setDetailPageId}
        />
        <CloseButton/> */}
      </div>
    );
  }
}

export default DetailPage;
