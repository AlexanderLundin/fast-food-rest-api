import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

import Logo from './logo.svg';

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            speed: 50
        }
    }

    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <Button color="link"><Link to="/orders">Orders View</Link></Button>
                    <img style={{animation: `App-logo-spin ${this.state.speed}s linear infinite`}} src={Logo} alt="logo.svg"/>
                </Container>

            </div>
        );
    }
}

export default Home;