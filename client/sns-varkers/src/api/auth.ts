import { instance } from "./index";

function signInUser(userData:string){
    return instance.post('signin',userData);
}

function signUpUser(userData:string){
    return instance.post('signup',userData);
}

export {signInUser,signUpUser};