import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../conponents/theme";
import { LOGIN_URL } from "../constant/url";

const LoginWrap = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: ${(props) => props.theme.sellingColor};
  display: flex;
  justify-content: center;
  align-items: center;
`;

const LoginButton = styled.button`
  height: 200px;
  span {
    color: #fff;
    font-weight: bold;
    font-size: 100px;
  }
`;

function Login(props) {
  const fetchLogin = () => {
    fetch(LOGIN_URL).then((res) => props.setLogin());
  };

  return (
    <ThemeProvider theme={theme}>
      <LoginWrap>
        <LoginButton onClick={fetchLogin}>
          <span>Hello! </span>
          <span>Login👀</span>
        </LoginButton>
      </LoginWrap>
      ;
    </ThemeProvider>
  );
}

export default Login;
