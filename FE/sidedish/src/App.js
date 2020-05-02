import React, { Component } from "react";
import Header from "./components/Header/Header";
import Nav from "./components/Nav/Nav";
import Login from "./components/Login";
import Main from "./components/Main/Main";
import styled from "styled-components";

export const Wrap = styled.div`
  margin: 0 auto;
`;

class App extends Component {
  state = {
    sidedish: [],
  };

  render() {
    return (
      <>
        <Wrap>
          <Login />
          <Header />
          <Nav />
          <Main />
        </Wrap>
      </>
    );
  }
}

export default App;
