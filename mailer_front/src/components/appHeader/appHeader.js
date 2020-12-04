import React from "react";

export default class appHeader extends React.Component {
    render() {
        return (
            <header className="ui fixed menu">
                <nav className="ui container">
                    <a href="./" className="header item">
                        <img
                            className="logo"
                            src="https://typeofweb.com/wp-content/uploads/2017/08/cropped-typeofweb_logo-04-white-smaller-1-e1504359870362.png"
                            alt=""
                        />
                        Lista kontaktów
                    </a>
                    <div className="header item">
                        <button onClick={() => {this.handleClick()} } className="ui button"> Dodaj </button>
                    </div>
                </nav>
            </header>
        );
    }

    handleClick() {
        alert("Clicked!");
    }
}


