import { account,defaultInst } from "./index";

function readAccount(accountId:number){
    return account.get<ResponseAccount>(`${accountId}`);
}

function readUserAccounts(userId:number){
    return account.get<ResponseAccount[]>(`user/${userId}`);
}

function readAccounts(accountIds:number[]){
    let queryString='account?accounts='+accountIds[0];
    for(let i = 1; i<accountIds.length;i++)
        queryString+=','+accountIds[i];
    return defaultInst.get<ResponseAccount[]>(queryString);
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

export {readAccount, readAccounts, readUserAccounts, createAccount};

export type{
    ResponseAccount,
    RequestAccount,
}