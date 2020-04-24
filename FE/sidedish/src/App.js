import React from 'react';
import Header from './conponents/Header/Header'
import {URL} from '../src/constant/url'



class App extends React.Component {
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
      <Header />

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
