import React from 'react';
import { shallow } from 'enzyme';
import App from './App';
import BrandList from "./components/brandList/brandList";

it('renders without crashing', () => {
  shallow(<App />);
});

it('includes input', () => {
  const app = shallow(<App />);
  expect(app.containsMatchingElement(<input />)).toEqual(true)
});

it('includes BrandList', () => {
  const app = shallow(<App />);
  expect(app.containsMatchingElement( <BrandList />)).toEqual(true)
});



