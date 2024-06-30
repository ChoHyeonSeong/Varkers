import { account } from "./index";

function readAccount(accountId:number){
    return account.get<ResponseAccount>(`/${accountId}`);
}

function readUserAccounts(userId:number){
    return account.get<ResponseAccount[]>(`/user/${userId}`);
}

function createAccount(accountData : RequestAccount){
    return account.post<ResponseAccount>('',accountData);
}

interface ResponseAccount{
    id:number;
    userId:number;
    profileImage:string;
    name:string;
    nickname:string;
    description:string;
}

interface RequestAccount{
    userId:number;
    profileImage?:string;
    name:string;
    nickname:string;
    description:string;
}

export {readAccount, readUserAccounts, createAccount};

export type{
    ResponseAccount,
    RequestAccount,
}