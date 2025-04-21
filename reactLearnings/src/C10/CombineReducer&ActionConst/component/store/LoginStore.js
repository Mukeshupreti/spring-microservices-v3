import { LOGIN } from "./action";
const initData = {
   users:['admin','manager','end-user'],
  loggedInUser:'None'
};
// this funtion will be called from product component
// when you change selection in product drop down
const loginReducer = (state = initData, action) => {
  
  if(action.type===LOGIN){
    console.log("action.loggedInUser",action.loggedInUser)
    //console.log("action.loggedInUser",action.loggedInUser)

    return{
        ...state,
        loggedInUser:action.loggedInUser
    }
}

  return state;
};


export default loginReducer;
