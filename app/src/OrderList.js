import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class OrderList extends Component {

    constructor(props) {
        super(props);
        this.state = {orders: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/orders')
            .then(response => response.json())
            .then(data => this.setState({orders: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/api/orders/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedOrders = [...this.state.orders].filter(i => i.id !== id);
            this.setState({orders: updatedOrders});
        });
    }

    render() {
        const {orders, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const orderList = orders.map(order => {

            return <tr key={order.id}>
                <td style={{whiteSpace: 'nowrap'}}>{order.id}</td>
                <td>{order.customerName}</td>
                <td>{order.createdAt}</td>
                <td>{order.status}</td>
                <td>{order.description}</td>
                <td>{order.note}</td>
                <td>{order.lastUpdated}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/api/orders/" + order.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(order.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/orders">Add Order</Button>
                    </div>
                    <h3>My JUG Tour</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="20%">Name</th>
                            <th width="20%">Location</th>
                            <th>Events</th>
                            <th width="10%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {orderList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default OrderList;