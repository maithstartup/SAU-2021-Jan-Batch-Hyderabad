import React, { useState } from 'react';

// useState ==> hook
// state management

function Bootle() {
  const [val1, setVal1] = useState("");
  const [val2, setVal2] = useState("");
  const [res, setRes] = useState("");

  const sumTwo = ()=>{
      setRes(parseInt( val1)+parseInt(val2))
  }
  return (
    <div>
      <input value={val1} onChange= {(e)=>setVal1(e.target.value)}></input>
      <input value={val2} onChange={(e)=>setVal2(e.target.value)}></input>
      <input value={res}></input>
      <button onClick={sumTwo}>ADD</button>
      

    </div>
  );
}

export default Bootle;