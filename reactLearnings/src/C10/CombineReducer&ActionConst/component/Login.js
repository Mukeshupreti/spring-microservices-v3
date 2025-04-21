import { useSelector,useDispatch, } from "react-redux";
import { validateUser } from "./store/action";
const Login=()=>{
    const users = useSelector(state=>state.lr.users);
    console.log(users);
     const dispatch = useDispatch();
    const loginHandler=(e)=>{
        let loginDet = e.target.options[e.target.selectedIndex].text;
        
        console.log(" hello :" + loginDet);
        // here below line its you can rename  payload to  loggedInUser
       /// dispatch({type:LOGIN,loggedInUser:loginDet});
       // call API call for impure funtions

       dispatch(()=>validateUser(loginDet));
    }

    return(
        <div className="customDiv">
        <h3>Login Component</h3>
        <hr/>
            <select onChange={(e)=>loginHandler(e)}>
                {
                    users.map((user,index)=>{
                     return(
                         <option key={index}>
                             {user}
                         </option>
                     )
                    })
                }
                </select>
        </div>
    )
}
export  {Login};
