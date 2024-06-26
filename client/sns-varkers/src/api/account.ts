import { account } from "./index";

function readAccount(accountId:bigint){
    return account.get(`/${accountId}`);
}


export {readAccount};