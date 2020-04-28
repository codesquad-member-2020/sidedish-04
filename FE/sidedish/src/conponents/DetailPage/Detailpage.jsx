import React, { Component } from "react";
import styled from "styled-components";
import ProductImages from "./ProductImages";
import { Layout } from "../Global";
import ProductInfo from "./ProductInfo";
import { DETAIL_URL } from "../../constant/url";

class DetailPage extends Component {
  state = {
    isClick: false,
    productImages: {},
    title: "",
  };

  saveData = (data) => {
    this.setState({
      productImages: {
        mainImage: data.top_image,
        subImages: data.thumb_images,
      },
      productInfo: {
        desc: data.product_description,
        point: data.point,
        deliveryInfo: data.delivery_info,
        deliveryFee: data.delivery_fee,
        prices: data.prices,
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

  //   getTitle = () => {
  //     if (!this.props.detailPageTitle) return;
  //     this.setState({ title: this.props.detailPageTitle });
  //   };

  componentDidMount() {
    this.getDetailPage();
  }

  render() {
    const { productImages, productInfo } = this.state;
    const { detailPageTitle } = this.props;

    console.log(detailPageTitle);
    return (
      <this.detailPageWrap>
        <this.productContainer>
          <ProductImages images={productImages} />
          <ProductInfo info={productInfo} title={detailPageTitle} />
        </this.productContainer>
        {/* <Carousel
          sidedishes={sidedishes}
          setDetailPageId={this.setDetailPageId}
        />
        <CloseButton/> */}
      </this.detailPageWrap>
    );
  }

  productContainer = styled.div`
    /* display: flex; */
    ${Layout};
  `;

  detailPageWrap = styled.div`
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    padding: 0 30px;

    background-color: #fff;
  `;
}

export default DetailPage;
