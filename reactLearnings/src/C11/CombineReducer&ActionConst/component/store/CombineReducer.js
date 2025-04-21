
import { configureStore } from '@reduxjs/toolkit';
import loginReducer  from './LoginSlice';
import productReducer from './ProductSlice';
// and thunk and applyMiddleware

/// combined Reducer takes reducer function

  
  // ADD midddle ware
  //const combineStore = createStore(rootReducer,applyMiddleware(thunk));


  const reduxStore=configureStore(

     {

      reducer :{
       pr: productReducer,
       lr:loginReducer

      }

     }

  )

  export{reduxStore}


  