import { Card, CardContent, Grid, Typography, withStyles } from '@material-ui/core';
import React from 'react';

const styles = (theme) => ({
    root: {
        height: "100%",
    }
});

class User extends React.Component {

    constructor(props) {
        super(props);
    }


    render() {
        const { classes } = this.props;
        return (
            
            <div>
                <Card variant="outlined" className={classes.root}>
                    <CardContent>
                        <Grid item direction="column" justify="center">
                            <Typography>{this.props.data.name}</Typography>
                            <Typography>{this.props.data.email}</Typography>
                        </Grid>
                    </CardContent>
                </Card>
            </div>
        );
    }
}

export default withStyles(styles)(User);