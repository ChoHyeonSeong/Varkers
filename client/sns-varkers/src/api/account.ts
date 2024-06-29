import { account } from "./index";

function readAccount(accountId:number){
    return account.get<ResponseAccount>(`/${accountId}`);
}

function readUserAccounts(userId:number){
    return account.get<ResponseAccount[]>(`/user/${userId}`);
}

interface ResponseAccount{
    id:number;
    userId:number;
    profileImage:string;
    name:string;
    nickname:string;
    description:string;
}

export {readAccount, readUserAccounts};

export type{
    ResponseAccount,
}