angular.module('app.controllers', []).controller('EmployeeListController', function($scope, $state, popupService, $window, Employee) {
  $scope.employee = Employee.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks

  $scope.deleteEmployee = function(employee) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Really delete this?')) {
      employee.$delete(function() {
        $scope.employee = Employee.query(); 
        $state.go('employee');
      });
    }
  };
}).controller('EmployeeViewController', function($scope, $stateParams, Employee) {
	
  $scope.employee = Employee.get({ id: $stateParams.id }); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
}).controller('EmployeeCreateController', function($scope, $state, $stateParams, Employee) {
  $scope.employee = new Employee();  //create new shipwreck instance. Properties will be set via ng-model on UI

  $scope.addEmployee = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
	  alert(' createEmployees '+$scope.employee.name);
    $scope.employee.$save(function() {
      $state.go('employee'); // on success go back to the list i.e. shipwrecks state.
    });
  };
}).controller('EmployeeEditController', function($scope, $state, $stateParams, Employee) {
  $scope.updateEmployee = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $scope.employee.$update(function() {
      $state.go('employee'); // on success go back to the list i.e. shipwrecks state.
    });
  };

  $scope.loadEmployee = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
    $scope.employee = Employee.get({ id: $stateParams.id });
  };

  $scope.loadEmployee(); // Load a shipwreck which can be edited on UI
});
