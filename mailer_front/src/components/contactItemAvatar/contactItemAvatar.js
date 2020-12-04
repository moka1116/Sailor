import React from "react";

export default class contactItemAvatar extends React.Component {

    render() {
        const {name} = this.props;
        let imgUrl;
            imgUrl = `https://avatars.dicebear.com/api/male/${name}.svg`;
            console.log(name);
        return (
            <img src={imgUrl} className="ui mini rounded image" alt=""/>
        );
    }
}