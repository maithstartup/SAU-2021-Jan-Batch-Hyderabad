import { React } from 'react';

function SampleRow(data) {

    return (
        <tr key>
          <td>{data.a}</td>
          <td>{data.b}</td>
          <td>{data.c}</td>
          <td>{data.d}</td>
          <td>{data.e}</td>
        </tr>
      );
    
}