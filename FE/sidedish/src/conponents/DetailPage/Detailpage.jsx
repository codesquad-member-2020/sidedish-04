import React, { Component } from "react";
import styled from "styled-components";
import ProductImages from "./ProductImages";
import { DETAIL_URL } from "../../constant/url";

class DetailPage extends Component {
  state = {
    isClick: false,
    productImages: {},
  };

  saveData = (data) => {
    this.setState({
      productImages: {
        mainImage: data.top_image,
        subImages: data.thumb_images,
      },
    });
  };

  getDetailPage = () => {
    const { detailPageId } = this.props;
    const detailUrl = DETAIL_URL.replace("{id}", detailPageId);
    fetch(detailUrl)
      .then((res) => res.json())
      .then((detailPage) => {
        this.saveData(detailPage.data);
        // this.setState({ detailPage: detailPage.data });
      });
  };

  componentDidMount() {
    this.getDetailPage();
  }

  render() {
    const { productImages } = this.state;
    return (
      <this.detailPageWrap>
        <div>
          <ProductImages images={productImages} />

          {/* <productInfo/>  */}
        </div>
        {/* <Carousel
          sidedishes={sidedishes}
          setDetailPageId={this.setDetailPageId}
        />
        <CloseButton/> */}
      </this.detailPageWrap>
    );
  }

  detailPageWrap = styled.div`
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    /* div::-webkit-scrollbar {
      display: none;
    } */

    /* margin: -50% 0 0 -50%; */

    background-color: #fff;
  `;
}

export default DetailPage;
