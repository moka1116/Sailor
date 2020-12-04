import React from "react";
import EventEmitter from "eventemitter3";

export default function brandList(filteredBrandsObject) {
    const filteredBrands = Array.from(filteredBrandsObject.filteredBrands);
    this.eventEmitter = new EventEmitter();
    if (filteredBrands.length > 0) {
        return (
            <div>
                <ul>
                    {filteredBrands.map(brand => <li key={brand}>{brand} </li>)}
                </ul>
            </div>
        );
    } else {
        return (
            <p>no Result!</p>
        );
    }

}