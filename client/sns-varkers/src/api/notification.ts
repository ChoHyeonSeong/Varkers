import { notification } from "./index";

function subscribe(accountId:number){
    return notification.get(`subscribe/${accountId}`);
}

function cancelSubscribe(accountId:number){
    return notification.get(`cancel/${accountId}`);
}

export {
    cancelSubscribe,
    subscribe
}