import { createStore } from "redux";

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
// this funtion will be called from product component 
// when you change selection in product drop down
const reducerFuntion = (state = initData, action) => {
  if (action.type === 'PURCHASE') {
    // this will return new updated state
    return {
      ...state, // keep old state value
      cart: [...state.cart, action.payload], // keep previous card and update with selected payload
      total: state.total + parseInt(action.payload.price), // add payload price to existing total price
    }
  
   
  }

  if(action.type==='DELETE'){
    return{
        ...state,
        cart:state.cart.filter((i,index)=>index!=action.payLoad.index),
        total:state.total - action.payLoad.price
        
    }

  }



  return state;
};
const fruitStore = createStore(reducerFuntion);

export { fruitStore };
