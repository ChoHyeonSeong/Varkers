import { user } from "./index";

function signInUser(userData:string){
    return user.post('signin',userData);
}

function signUpUser(userData:string){
    return user.post('signup',userData);
}

export {signInUser,signUpUser};