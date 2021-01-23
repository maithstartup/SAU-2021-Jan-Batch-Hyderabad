import { React } from 'react';
const json = {
    data: {
      available: {
        profileOne: {
          a: 14,
          b: 14,
          c: 0,
          d: 0,
          e: 18
        },
        profileTwo: {
          a: 13,
          b: 9,
          c: 0,
          d: 0,
          e: 18
        },
        profileThree: {
            a: 1,
            b: 2,
            c: 3,
            d: 4,
            e: 5
          }
      }
    }
  };
  const header = ["pro", "a", "b", "c", "d", "e"];
  function Sample() {
      return (
        <table>
          <thead>
            <tr>{header.map((h, i) => <th key={i}>{h}</th>)}</tr>
          </thead>
          <tbody>
            {Object.keys(json.data.available).map((k, i) => {
              let data = json.data.available[k];
              return (
                <tr key={i}>
                  <td>{k}</td>
                  <td>{data.a}</td>
                  <td>{data.b}</td>
                  <td>{data.c}</td>
                  <td>{data.d}</td>
                  <td>{data.e}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      );
  }

  export default Sample;