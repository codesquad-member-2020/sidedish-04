import React, { useState } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../components/theme";
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
  const [isLogin, setIsLogin] = useState("로그인");

  return (
    <ThemeProvider theme={theme}>
      <LoginWrap>
        <LoginLink href={LOGIN_URL}>
          <span>{isLogin}</span>
        </LoginLink>
      </LoginWrap>
      ;
    </ThemeProvider>
  );
}

export default Login;
