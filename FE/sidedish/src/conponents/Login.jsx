import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../conponents/theme";
import { LOGIN_URL } from "../constant/url";

const LoginWrap = styled.div`
  position: absolute;
  top: 13px;
  right: 72px;
  height: 30px;
  cursor: pointer;
`;

const LoginLink = styled.a`
  span {
    color: #777;
    text-decoration: underline;
    font-size: 18px;
  }
`;
function Login(props) {
  const fetchLogin = () => {
    props.setLogin();
  };

  return (
    <ThemeProvider theme={theme}>
      <LoginWrap>
        <LoginLink href={LOGIN_URL} onClick={fetchLogin}>
          <span>로그인</span>
        </LoginLink>
      </LoginWrap>
      ;
    </ThemeProvider>
  );
}

export default Login;
