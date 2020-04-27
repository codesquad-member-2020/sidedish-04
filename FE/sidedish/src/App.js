import React, { Component } from "react";
import Header from "./conponents/Header/Header";
import Nav from "./conponents/Nav";
import Main from "./conponents/Main/Main";
import { URL } from "../src/constant/url";
import styled from "styled-components";
// import {createGlobalStyle} from 'styled-components';

// export const GlobalStyled = createGlobalStyle`
// body{
// }`

export const Wrap = styled.div`
  margin: 0 auto;
`;

class App extends Component {
  state = {
    isLogin: true,
    sidedish: [],
  };

  // getMenu = () => {
  //   fetch(URL)
  //     .then((res) => res.json())
  //     .then((data) => this.setState({ data }));
  // };

  // componentDidMount() {
  //   this.getMenu();
  // }
  render() {
    return (
      // <Fragment>
      <>
        <Wrap>
          <Header />
          <Nav />
          <Main />
        </Wrap>
      </>
      // </Fragment>
    );
  }
}

// return (
//   <div className="App">
//     <header className="App-header">

//     </header>
//   </div>
// );

export default App;
