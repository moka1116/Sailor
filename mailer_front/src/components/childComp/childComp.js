import React from "react";

export default class childComp extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tokenValue: Number(props.tokenValue),
            operatedValue: Number(props.tokenValue)
        }
    }

    increment() {
        this.setState({operatedValue: this.state.operatedValue + 1})
    }

    decrement() {
        this.setState({operatedValue: this.state.operatedValue - 1})
    }

    componentWillReceiveProps(nextProps, nextContext) {
        console.log(nextProps);
         if (nextProps != this.state.tokenValue) {
              this.setState({
                  tokeValue: Number(nextProps.tokenValue),
                  operatedValue: Number(nextProps.tokenValue)
              })
          }
    }

    render() {
        return (
            <div>
                <button onClick={this.increment.bind(this)}>+</button>
                <p>{this.state.operatedValue}</p>
                <button onClick={this.decrement.bind(this)}>-</button>
            </div>
        );
    }
}