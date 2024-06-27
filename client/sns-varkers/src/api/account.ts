import { account } from "./index";

function readAccount(accountId:number){
    return account.get(`/${accountId}`);
}


export {readAccount};