import React from 'react'
import styled from 'styled-components'
import { faSearch } from "@fortawesome/free-solid-svg-icons"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"

const Input = styled.input`

    margin:0 20px 0 60px;
    padding: 12px;
    width: 650px;
    height: 45px;
    border: 1px solid #cfd0d2;
`

const Button = styled.button`
    position:relative;
    top: 5px;
    right: 63px;
    color: #cfd0d2
`

function SearchBar(){
    return(
        <form>
           <label htmlFor="search-input"/>
           <Input name="search-input" id="search-input" type="text"/>
           <Button>
                 <FontAwesomeIcon icon={faSearch} size="2x"/>
           </Button>
        </form>
  )
}

export default SearchBar