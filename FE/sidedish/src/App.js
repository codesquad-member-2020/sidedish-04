import React, { Component } from "react";
import Header from "./conponents/Header/Header";
import Nav from "./conponents/Nav/Nav";
import Login from "./conponents/Login";
import Main from "./conponents/Main/Main";
import styled from "styled-components";

export const Wrap = styled.div`
  margin: 0 auto;
`;

class App extends Component {
  state = {
    isLogin: true,
    sidedish: [],
  };

  setLogin = () => {
    this.setState({ isLogin: false });
  };

  render() {
    const { isLogin } = this.state;
    if (isLogin) {
      return <Login setLogin={this.setLogin} />;
    } else {
      return (
        <>
          <Wrap>
            <Header />
            <Nav />
            <Main />
          </Wrap>
        </>
      );
    }
  }
}

export default App;
