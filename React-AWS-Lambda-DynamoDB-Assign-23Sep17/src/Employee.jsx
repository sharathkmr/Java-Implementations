import React, {Component} from 'react';
import $ from 'jquery';


class Employee extends Component {
  // eslint-disable-next-line
  constructor(props) {
    super(props);
    this.state = {
      display: true,
      employee: this.props.employee
    }
  }

	handleDelete() {
    var self = this;
	    $.ajax({
	      url: "https://3o11quu7y5.execute-api.us-east-2.amazonaws.com/RestDemoAssign/employees",
	      type: 'DELETE',
        dataType: 'json',
        contentType: "application/json",
        body: {
          "id": this.state.employee.id
        },
	      success: function(result) {
	        self.setState({display: false});
	      },
	      error: function(xhr, ajaxOptions, thrownError) {

	      }
	    });
  }
  handleEdit() {
  	console.log(this.props.employee);
  }
  render() {
    if (this.state.display===false) return null;
    else return (
		    <tr>
		      <td>{this.props.employee.id}</td>
          <td>{this.props.employee.name}</td>
          <td>{this.state.employee.salary}</td>
          <td><button className="btn btn-sm btn-primary btn-success" onClick={this.handleEdit}>Edit</button></td>
          <td><button className="btn btn-sm btn-primary btn-warning" onClick={this.handleDelete}>Delete</button></td>
      	</tr>
	     );
  }
}


export default Employee;
