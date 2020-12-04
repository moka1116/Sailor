import React from "react";
import ContactItemAvatar from '../contactItemAvatar/contactItemAvatar';

export default class contactItem extends React.Component {
    render() {
        const {name, department } = this.props
        return (
            <li className="item">
                <ContactItemAvatar name={name} class="ui mini rounded image" alt="" />
                <div className="content">
                    <h4 className="header">{name}</h4>
                    <div className="description">{department}</div>
                </div>
            </li>
        );
    }
}
