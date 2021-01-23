import React from 'react';


function Tabledata()
{
    return(
        <div>
            <table style={{"borderWidth":"1px", 'borderColor':"#aaaaaa", 'borderStyle':'solid'}} >
                <tr style={{"borderWidth":"1px", 'borderColor':"#aaaaaa", 'borderStyle':'solid'}}>
                <th>Name</th>
                <th>Age</th>
                <th>Clg</th>
                </tr>
                <tr style={{"borderWidth":"1px", 'borderColor':"#aaaaaa", 'borderStyle':'solid'}}>
                    <td>Maith</td>
                    <td>20</td>
                    <td>Cit</td>
                </tr>
                <tr style={{"borderWidth":"1px", 'borderColor':"#aaaaaa", 'borderStyle':'solid'}}>
                    <td>ashwin</td>
                    <td>20</td>
                    <td>Ceg</td>
                </tr>
            </table>
        </div>
    );
}

export default Tabledata;