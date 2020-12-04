import React from 'react'
import ChildComp from "../childComp/childComp"

export default class contactItem extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            input: null,
            tokenValue: null
        }
    }

    handleChange(event) {
        this.setState({
            input: event.target.value,
            tokenValue: event.target.value
        });
    }


    render() {
        return (
            <div>
                <p>Input</p>
                <input type="text" id="lname" name="lname" label="inpy" onChange={this.handleChange.bind(this)}/>
                {this.state.tokenValue && <ChildComp tokenValue={this.state.tokenValue}/>}
            </div>
        );
    }
}