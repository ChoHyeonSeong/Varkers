import { notify } from "./index";

function subscribe(accountId:number){
    return notify.get(`subscribe/${accountId}`);
}

function sendVark(varkId:number){
    return notify.get(`vark/${varkId}`);
}

export {
    sendVark,
    subscribe
}