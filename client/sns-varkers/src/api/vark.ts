import { vark } from "./index";

function readVarkOfAccount(accountId:bigint){
    return vark.get(`account/${accountId}`);
}


function readVarkRoad(accountId:bigint){
    return vark.get(`road/${accountId}`);
}

function createVark(varkData:RequestVark){
    return vark.post('',varkData);
}

function deleteVark(varkId:bigint){
    return vark.delete(`${varkId}`);
}

interface RequestVark{
  accountId:number;
  content:string;
}



export {readVarkOfAccount,readVarkRoad,createVark,deleteVark};