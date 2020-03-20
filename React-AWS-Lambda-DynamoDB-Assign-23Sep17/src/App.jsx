import React, {Component} from 'react';
import EmployeeTable from './EmployeeTable';
import $ from 'jquery';
// export for others scripts to use
// window.$ = $;
// window.jQuery = jQuery;


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: ''
    };
  }
  loadEmployeesFromServer() {
    var self = this;
    $.ajax({
      url: "https://3o11quu7y5.execute-api.us-east-2.amazonaws.com/RestDemoAssign/employees",
      crossDomain: true,
      dataType: 'json',
      contentType: "application/json",
    }).then(function (data) {
    	console.log('rest data');
    	console.log(data);
    	console.log('total employees');
    	console.log(data.totalEmployees);
    	console.log('employees');
    	console.log(data.employees);
      self.setState({employees: data});
    });
  }

  getInitialState() {
    return {employees: []};
  }

  componentDidMount() {
    this.loadEmployeesFromServer();
  }

  render() {
    return ( <EmployeeTable employees={this.state.employees}/> );
  }
}


export default App;
