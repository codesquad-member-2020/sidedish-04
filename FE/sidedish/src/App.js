import React, {Component,Fragment} from 'react';
import Header from './conponents/Header/Header'
import Nav from './conponents/Nav'
import Main from './conponents/Main/Main'
import {URL} from '../src/constant/url'
import  styled  from 'styled-components';
// import {createGlobalStyle} from 'styled-components';


// export const GlobalStyled = createGlobalStyle`
// body{
// }`

export const Wrap = styled.div`
  margin: 0 auto;
  `

class App extends Component {
  state = {
    isLogin : true
  }

  getMenu = () =>{
    fetch(URL)
    .then(res => console.log(res))
    // .then(data => console.log(data))
  }

  componentDidMount() {
    this.getMenu();
  }
  render(){
    return(
      // <Fragment>
        <>
       <Wrap>
          <Header />
          <Nav/>
          <Main/>
        </Wrap>
        </>
    // </Fragment>
    )
  }
}


  
  // return (
  //   <div className="App">
  //     <header className="App-header">
        
  
  //     </header>
  //   </div>
  // );

export default App;
