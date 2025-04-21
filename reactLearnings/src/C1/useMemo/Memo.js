import React, { useState, useCallback } from "react";
import Header from "./Header";
import Footer from "./Footer";
import DisplayCounter from "./DisplayCounter";
import DisplayFlag from "./DisplayFlag";
import ChangeState from "./ChangeState";

export default function Memo() {
  const [counter, setCounter] = useState(0);
  const [flag, setFlag] = useState(false);

  let changeCounter = useCallback(() => {
    setCounter(counter + 1);
  }, [counter]);

  let changeFlag = useCallback(() => {
    setFlag(!flag);
  }, [flag]);

  return (
    <>
      <h1>Memo demo</h1>
      <Header></Header>
      <DisplayCounter counter={counter}></DisplayCounter>
      <DisplayFlag flag={flag}></DisplayFlag>
      <ChangeState
        caption="change counter "
        log="clicked change counter"
        click={changeCounter}
      ></ChangeState>
      <ChangeState
        caption="change Flag "
        log="clicked change flag"
        click={changeFlag}
      ></ChangeState>

      <Footer></Footer>
    </>
  );
}
