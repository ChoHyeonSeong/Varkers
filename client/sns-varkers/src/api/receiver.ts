import { receiver } from "./index";

function createReceiver(receiverData:RequestRecevier){
    return receiver.post(``,receiverData);
}

function readReceiver(varkId:number){
    return receiver.get(`${varkId}`);
}

interface RequestRecevier{
    varkId:number;
    accountIds:number[];
}

export {
    createReceiver,
    readReceiver
}