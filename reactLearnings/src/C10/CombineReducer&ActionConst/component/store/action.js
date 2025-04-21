export const PURCHASE = "PURCHASE";
export const DELETE = "DELETE";
export const LOGIN = "LOGIN";


//this for impure function i.e which are asncy such as API calls
export const validateUser = (loginDet) => {
  //Thunk fuction 
  
  return (dispatch)=>{ //API call fetecting some user and then validate.
  setTimeout(() => {
    dispatch({ type: LOGIN, loggedInUser: loginDet });
  }, 2000);} 
};
