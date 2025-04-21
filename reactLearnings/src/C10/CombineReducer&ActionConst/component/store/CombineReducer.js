
import { loginReducer } from './LoginStore';
import { productReducer } from './Productstore';
// and thunk and applyMiddleware
import {thunk} from 'react-thunk'
import { combineReducers,createStore ,applyMiddleware} from 'redux';
/// combined Reducer takes reducer function
const rootReducer = combineReducers({
    pr:productReducer,
    lr:loginReducer
  })
  
  // ADD midddle ware
  const combineStore = createStore(rootReducer,applyMiddleware(thunk));

  export{combineStore}


  