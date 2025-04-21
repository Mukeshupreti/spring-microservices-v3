import React from "react";
import { OneHandlerwithFunctionalUpdateBestway,EventHandleV1, MultistateWay1, MultistateWayManageInOneObject, OneHandlerForMultiState, PreventDefaultEx, SyntheticEvent, TextBoxEvent } from "./EventHandlingV1";

const C4 = () => {
  return (
    <>
      <h1 className="chapter"> Chapter 4 
      Handling Events</h1>
   
      <EventHandleV1></EventHandleV1>
      <SyntheticEvent></SyntheticEvent>
      <TextBoxEvent></TextBoxEvent>
      <PreventDefaultEx></PreventDefaultEx>
      <MultistateWay1></MultistateWay1>
      <MultistateWayManageInOneObject></MultistateWayManageInOneObject>
      <OneHandlerForMultiState></OneHandlerForMultiState>
      <OneHandlerwithFunctionalUpdateBestway></OneHandlerwithFunctionalUpdateBestway>
    </>
  );
};


export default C4;
