import { user } from "./index";

function signInUser(userData:RequestUser){
    return user.post<ResponseUser>('signin',userData);
}

function signUpUser(userData:RequestUser){
    return user.post('signup',userData);
}

interface RequestUser{
    email:string;
    password:string;
    birth?:Date;
}

interface ResponseUser{
    id:number;
    email:string;
    password:string;
    maxAccountCount:number;
    currentAccountId:number;
    birth:Date;
}

export {signInUser,signUpUser, type RequestUser, type ResponseUser};