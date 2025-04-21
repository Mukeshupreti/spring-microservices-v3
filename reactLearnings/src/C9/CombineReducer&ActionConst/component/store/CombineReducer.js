
import { loginReducer } from './LoginStore';
import { productReducer } from './Productstore';

import { combineReducers,createStore } from 'redux';
/// combined Reducer takes reducer function
const rootReducer = combineReducers({
    pr:productReducer,
    lr:loginReducer
  })
  
  
  const combineStore = createStore(rootReducer);

  export{combineStore}


  