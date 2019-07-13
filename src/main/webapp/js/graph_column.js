var app = angular.module("sampleApp", ['ui.bootstrap'], function(){});

app.service("graphColumnService", ['$http',
	function($http) {
		var getGraphColumns = function() {
			return $http({
				method: 'GET',
				url: "api/graphcolumns"
			});
		};

		var searchGraphColumns = function(str) {
			return $http({
				method: 'GET',
				url: "api/graphcolumns/search/" + str
			});
		};

		var saveGraphColumn = function(graphColumn) {
			return $http({
				method: "POST",
				url: "api/graphcolumns",
				data: graphColumn
			});
		};

		var updateGraphColumn = function(graphColumn) {
			return $http({
				method : "PUT",
				url : "api/graphcolumns",
				data : graphColumn
			});
		};

		var deleteGraphColumn = function(id) {
			return $http({
				method: 'DELETE',
				url: "api/graphcolumns/" + id
			});
		};

		return {
			getGraphColumns : getGraphColumns,
			searchGraphColumns : searchGraphColumns,
			saveGraphColumn : saveGraphColumn,
			updateGraphColumn : updateGraphColumn,
			deleteGraphColumn : deleteGraphColumn
		};
	}
]);

app.controller("sampleController", ["$scope","graphColumnService", "$modal", function($scope, graphColumnService, $modal) {
	$scope.searchGraphColumn = "";
	$scope.graphColumns = [];
	$scope.selectedGraphColumn = {};

	$scope.searchGraphColumns = function() {
		graphColumnService.searchGraphColumns($scope.searchGraphColumn).then(function(result) {
			if (result) {
				$scope.graphColumns = result.data;
			}
		});
	};
	$scope.getGraphColumns = function() {
		graphColumnService.getGraphColumns().then(function(result) {
			if (result) {
				$scope.graphColumns = result.data;
			}
		});
	};

	$scope.showGraphColumnModal = function (graphColumn) {
		$scope.selectedGraphColumn = graphColumn;

		var modalInstance = $modal.open({
			templateUrl: 'editGraphColumnModal.html',
			controller: 'editGraphColumnModalController',
			backdrop: 'static',
			resolve: {
				selectedGraphColumn: function () {
					return $scope.selectedGraphColumn;
				}
			}
		});

		modalInstance.result.then(function (data) {
			if (data) {
				$scope.selectedGraphColumn = data.selectedGraphColumn;

				if (!data.isExistingGraphColumn) {
					if ($scope.graphColumns) {
						$scope.graphColumns.push(data.selectedGraphColumn);
					} else {
						$scope.graphColumns = [ data.selectedGraphColumn ];
					}
					//mlSetFocus(data.selectedGraphColumn.id);
				}
			}
		}, function () {
			//$log.info('Modal dismissed at: ' + new Date());
		});
	};

	$scope.deleteGraphColumnModal = function (graphColumn) {
		$scope.selectedGraphColumn = graphColumn;

		var modalInstance = $modal.open({
			templateUrl: 'deleteGraphColumnModal.html',
			controller: 'deleteGraphColumnModalController',
			backdrop: 'static',
			resolve: {
				selectedGraphColumn: function () {
					return $scope.selectedGraphColumn;
				}
			}
		});

		modalInstance.result.then(function (data) {
			if (data.result != -1) {
				var ix = $scope.graphColumns.indexOf($scope.selectedGraphColumn);
				if (ix >= 0) {
					$scope.graphColumns.splice(ix, 1);
				}
			}
		}, function () {
			//$log.info('Modal dismissed at: ' + new Date());
		});
	};

	$scope.newGraphColumnModal = function() {
		$scope.showGraphColumnModal({});
	};

}]);

app.controller("editGraphColumnModalController", ['$scope', '$modalInstance', 'graphColumnService', 'selectedGraphColumn',
	function($scope, $modalInstance, graphColumnService, selectedGraphColumn) {

		$scope.selectedGraphColumn = selectedGraphColumn;
		if ($scope.selectedGraphColumn.id > 0) {
			$scope.isExistingGraphColumn = true;
		} else {
			$scope.isExistingGraphColumn = false;
		};

		$scope.ok = function() {
			graphColumnService.saveGraphColumn($scope.selectedGraphColumn).then(function(result) {
				if (result) {
					$scope.selectedGraphColumn = result.data;
				}
				$modalInstance.close({
					"selectedGraphColumn" : $scope.selectedGraphColumn,
					"isExistingGraphColumn" : $scope.isExistingGraphColumn
				});
			});
		};

		$scope.cancel = function() {
			$modalInstance.dismiss("cancel");
		}
	}
]);

app.controller("deleteGraphColumnModalController", ['$scope', '$modalInstance', 'graphColumnService', 'selectedGraphColumn',
	function($scope, $modalInstance, graphColumnService, selectedGraphColumn) {

		$scope.selectedGraphColumn = selectedGraphColumn;
		$scope.result = 1;
		$scope.ok = function() {
			graphColumnService.deleteGraphColumn($scope.selectedGraphColumn.id)
				 .error(function(data, status, headers, config) {
					 $scope.result = -1;
				 })
				 .then(function(result) {
					 if (result) {
						 $scope.result = 1;
					 };

					 $modalInstance.close({
						 "result" : $scope.result
					 });
				 });
		};

		$scope.cancel = function() {
			$modalInstance.dismiss("cancel");
		}
	}
]);
