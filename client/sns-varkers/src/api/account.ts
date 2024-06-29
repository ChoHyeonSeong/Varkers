import { account } from "./index";

function readAccount(accountId:number){
    return account.get<ResponseAccount>(`/${accountId}`);
}

interface ResponseAccount{
    id:number;
    userId:number;
    profileImage:string;
    name:string;
    nickname:string;
    description:string;
    createdAt:Date;
    updatedAt:Date;
    deletedAt:Date;
}

export {readAccount};

export type{
    ResponseAccount,
}