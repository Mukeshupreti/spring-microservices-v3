import { createSlice } from "@reduxjs/toolkit";

//import { LOGIN } from "./action";

const initialState = {
  users: ["admin", "manager", "end-user"],
  loggedInUser: "None",
};

export const loginSlice = createSlice({
  name: "login",
  initialState, //ES6 automatically iniitilize initialState from initialState object at line number 6 //other variation without Es6
  // you can see in productSlice.js where   initialState: initData, //
 // so if initialState name(in slice) is same as intialState(const Name) so you dont need initialState:initialState
  reducers: {
    userLogin: (state, action) => {
      //state.loggedInUser = action.loggedInUser;
      state.loggedInUser = action.payload;
    },
  },
});

//const {loginReducer}=loginSlice.reducer;

export const {userLogin} =loginSlice.actions;
export default  loginSlice.reducer;
//export {loginReducer};

/* // this funtion will be called from product component
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


export { loginReducer }; */
