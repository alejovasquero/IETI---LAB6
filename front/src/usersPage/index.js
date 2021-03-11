import { withStyles } from '@material-ui/core';
import React from 'react';
import UserList from './UserList.js';

const styles = (theme) =>({
    root: {
        backgroundColor: "#ADE4DF",
        padding: theme.spacing(2),
    }
});

class index extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            userList: [],
        };
    }

    componentDidMount() {
        fetch('http://ieti-lab6.southcentralus.azurecontainer.io:8080/users')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                this.setState({userList: data});
            });
    }

    render() {
        const { classes } = this.props;
        return (
            <div className={classes.root}>
                <UserList usersList={this.state.userList}/>
            </div>
        );
    }
}

export default withStyles(styles)(index);
export { default as UsersPage } from './index.js';