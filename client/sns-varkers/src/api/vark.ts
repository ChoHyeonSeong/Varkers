import { vark } from "./index";

function readVarkOfAccount(accountId:bigint){
    return vark.get(`account/${accountId}`);
}

function createVark(varkData:string){
    return vark.post('/',varkData);
}

function deleteVark(varkId:bigint){
    return vark.delete(`${varkId}`);
}

export {readVarkOfAccount,createVark,deleteVark};