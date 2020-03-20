import React, {Component} from 'react';
 import Employee from './Employee';

class EmployeeTable extends Component {
// eslint-disable-next-line
  constructor(props) {
    super(props);
    this.state = {

    }
  }

  render() {
    var rows= [];
	   console.log(this.props.employees);
     for (var i = 0; i < this.props.employees.length; i++) {
       console.log('i: '+i+" : "+this.props.employees[i]);
       rows.push(<Employee employee={this.props.employees[i]} />);
       console.log(rows[i]);
     }
     
    return (
      <div className="container">
			     <h2>Employee Details</h2>
  			<table className="table table-striped">
    		<thead>
      			<tr>
      			<th>Id</th>
        			<th>Name</th>
        			<th>Age</th>
        			<th>Years</th>
      			</tr>
    		</thead>
    		<tbody>{rows}</tbody>
  			</table>
		  </div>
    )
  }
}


export default EmployeeTable;
