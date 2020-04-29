import styled, { css } from "styled-components";

const Layout = css`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 0 auto;
  width: 960px;
`;

const FlexCenter = css`
  display: flex;
  align-items: center;
  justify-content: center;
`;

const FlexSpaceBetween = css`
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export { Layout, FlexCenter, FlexSpaceBetween };
