import React from 'react';
import './App.css';
import { getUsers,deleteUser } from './Api';
import userEvent from '@testing-library/user-event';

const App = () => {
  const [users, setUsers] = React.useState(null);

  const doGetUsers = React.useCallback(async () => {
    try {
      const result = await getUsers();
      setUsers(result);
    } catch (error) {
      console.log(error);
    }
  }, []);

  React.useEffect(() => {
    doGetUsers();
  }, [doGetUsers]);

  const refetchUsers = async () => {
    await doGetUsers();
  };
  if(!users){
    return null;
  }

  const handleRemove = async (id) => {
    try {
      await deleteUser(id);
      await refetchUsers();
    } catch (error) {
      console.log(error);
    }
  };

  const divStyle = {
    color: 'grey',
    alignContent:"center",
    display: 'flexbox',
    textAlign:'Center',
  justifyContent: 'center',
  

  alignItems: 'center'
  };

  const tableStyle = {
    marginLeft: 600  ,
    color: 'blue',
    backgroundColor:'grey',
  };


  return (
    <div style={divStyle} >
      <h2 >
        Database
      </h2>
    <table style= {tableStyle}>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
      { users.map((user) => {
        return(
          <tr>
            <td>{ user.firstName }</td>
            <td>{ user.lastName }</td>
            <td>{ user.email }</td>
            <td>
              <button type="button" onClick={() => handleRemove(user.id)}>
                X
              </button>
            </td>
          </tr>
        )
      })}
    </table>
    </div>
  );
}

export default App;
