import React from "react";
import AppHeader from "./components/appHeader/appHeader"
import ContactsList from "./components/contactList/contctList"
import './App.css';

export default class App extends React.Component {
    constructor(props) {
        super(props);
        this.reloadComp = this.reloadComp.bind(this);
    }

    state = {
        contacts: []
    };

    componentDidMount() {
        fetch("https://randomuser.me/api/?format=json&results=10")
            .then(res => res.json())
            .then(json => this.setState({contacts: json.results}));
    }

    reloadComp() {
        window.location.reload(false);
    }

    render() {
        return (
            <div>
                <link rel="stylesheet"
                      href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css"/>
                <AppHeader/>
                <main className="ui main text container">
                    <ContactsList contacts={this.state.contacts}/>
                    <button class="ui primary button" onClick={this.reloadComp}>Odśwież</button>
                </main>

            </div>
        );
    }
}