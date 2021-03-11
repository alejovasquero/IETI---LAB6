import { withStyles } from '@material-ui/core';
import React from 'react';
import User from './User';

const styles = (theme) =>({

});

class UserList extends React.Component {

    constructor(props) {
        super(props);
        console.log(this.props)
    }


    render() {
        const users = this.props.usersList.map((value, index) => {
            value.key = index;
            return (
                <User data={value}></User>
            );
        })
        return (
            <div>
                {users}
            </div>
        );
    }
}

export default withStyles(styles)(UserList);