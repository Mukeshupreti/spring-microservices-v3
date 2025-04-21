//bulk action import

import { createSlice } from "@reduxjs/toolkit";

const initData = {
  products: [
    { pName: "Apple", price: 20 },
    { pName: "Banana", price: 3 },
    { pName: "Orange", price: 10 },
    { pName: "Grapes", price: 8 },
  ],
  cart: [],
  total: 0,
};

const productSlice = createSlice({
  name: "product",
  initialState: initData,
  reducers: {
    purchase: (state, action) => {
      // this is function not object literanl so change  cart':' [ to ==> state.cart '='
      state.cart = [...state.cart, action.payload];
      state.total = state.total + parseInt(action.payload.price);
    },
    deleteItem: (state, action) => {
      // change pay'L'oad  to pay'l'oad
      state.cart = state.cart.filter(
        (i, index) => index != action.payload.index
      ),
        state.total = state.total - action.payload.price;
    },
  },
});
//const {productReducer}=productSlice.reducer;
// exporting action i.e is purchase and deleteItem action
export const { purchase, deleteItem } = productSlice.actions;

export default productSlice.reducer;

/* /* // this funtion will be called from product component
// when you change selection in product drop down
const productReducer = (state = initData, action) => {
  // here PURCHASE is action imported
  if (action.type === actions.PURCHASE) {
    // this will return new updated state
    return {
      ...state, // keep old state value
      cart: [...state.cart, action.payload], // keep previous card and update with selected payload
      total: state.total + parseInt(action.payload.price), // add payload price to existing total price
    };
  }

  if (action.type === actions.DELETE) {
    return {
      ...state,
      cart: state.cart.filter((i, index) => index != action.payLoad.index),
      total: state.total - action.payLoad.price,
    };
  } */

// return state;
//};

//export { productReducer };
