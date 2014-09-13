angular.module('players', [
  'players.resources',
  'ngAnimate',
  'ui.router',
  'ui.bootstrap',
  'directives.placeholder',
  'services.localizedMessages',
  'angularCharts'
])

.config(function config($stateProvider) {
  $stateProvider.state('players', {
    url: '/players',
    views: {
      'main': {
        controller: 'PlayersCtrl',
        templateUrl: 'players/players.tpl.html'
      }
    },
    resolve: {
      players: ['Players', function(Players) {
        return Players.query({}, function(response) {
          for (var i = 0, len = response.length; i < len; i++) {
            response[i].name = response[i].firstName + ' ' +response[i].lastName;
          }
          return response;
        });
      }]
    }
  })

  .state('players.detail', {
    url: '/:playerId',
    views: {
      '': {
        controller: 'PlayersDetailCtrl',
        templateUrl: 'players/players.detail.tpl.html'
      }
    },
    resolve: {
      player: ['Players', '$stateParams', function(Players, $stateParams) {
        return Players.get({ playerId: $stateParams.playerId });
      }]
    }
  })

  .state('players.detail.stats', {
    views: {
      '': {
        controller: 'PlayersDetailStatsCtrl',
        templateUrl: 'players/players.detail.stats.tpl.html'
      }
    },
    resolve: {
      stats: ['Players', '$stateParams', function(Players, $stateParams) {
        return Players.stats({ playerId: $stateParams.playerId }).$promise;
      }]
    }
  });
})

.controller('PlayersCtrl', ['$scope', '$state', 'players', function($scope, $state, players) {
  $scope.selected = undefined;
  $scope.players = players;
  $scope.showMini = false;

  $scope.onSelect = function ($item, $model, $label) {
    if ($item !== undefined && $item.eliasId !== undefined) {
      $state.go('players.detail', { playerId: $item.eliasId });
    }
  };
}])

.controller('PlayersDetailCtrl', ['$scope', '$state', '$timeout', 'player', function($scope, $state, $timeout, player) {
  $scope.$parent.showMini = true;
  $scope.player = player;

  $timeout(function() {
    $state.go('players.detail.stats', { playerId: player.eliasId });
  }, 1000);
}])

.controller('PlayersDetailStatsCtrl', ['$scope', '$state', '$timeout', 'stats', function($scope, $state, $timeout, stats) {
    var colors = [
    '#ff235f',
    '#e76700',
    '#ffbc06',
    '#0ade0e',
    '#00aeef',
    '#CC48FF',

    '#1BDAFF',
    '#1BFFBF',
    '#DBFF1B',
    '#FF1BE4',

    '#ff235f',
    '#e76700',
    '#ffbc06',
    '#0ade0e',
    '#00aeef',
    '#CC48FF',
    '#1BDAFF',
    '#1BFFBF',
    '#DBFF1B',
    '#FF1BE4'
  ];

  var pitchNames = {
    'FA': 'Fastball',
    'FF': 'Four-Seam Fastball',
    'FT': 'Two-Seam Fastball',
    'FC': 'Cutter',
    'FS': 'Split-Finger Fastball',
    'FO': 'Forkball',
    'SI': 'Sinker',
    'SF': 'Split-Finger Fastball',
    'SL': 'Slider',
    'CH': 'Changeup',
    'CB': 'Curveball',
    'CU': 'Curveball',
    'KC': 'Knuckle Curve',
    'KN': 'Knuckleball',
    'EP': 'Eephus',
    'SC': 'Screwball'
  };

  var invalidPitches = ['UN', 'XX', 'PO', 'FO', 'IN', 'AB'];
  var len = stats['year'].length;
  var pitchTypes = [];
  var legend = [];
  for (var i = 0; i < len; i++) {
    if (stats['year'][i].pitchType.length && pitchTypes.indexOf(stats['year'][i].pitchType) == -1 && invalidPitches.indexOf(stats['year'][i].pitchType) == -1) {
      pitchTypes.push(stats['year'][i].pitchType);
      legend.push({
        pitchType: stats['year'][i].pitchType,
        name: pitchNames[stats['year'][i].pitchType] !== undefined ? pitchNames[stats['year'][i].pitchType] : stats['year'][i].pitchType,
        color: colors[legend.length],
        enabled: true
      });
    }
  }

  $scope.legend = legend;
  $scope.grouping = 'month';

  $scope.config = {
    title: '',
    tooltips: false,
    labels: false,
    mouseover: function() {},
    mouseout: function() {},
    click: function() {},
    legend: {
      display: false,
      position: 'left'
    },
    colors: colors,
    lineLegend: 'traditional',
    xAxisMaxTicks: 7,
    yAxisTickFormat: 'g'
  };

  $scope.togglePitchType = function(item) {
    item.enabled = !item.enabled;
    setGraphData();
  };

  $scope.toggleGrouping = function(item) {
    $scope.grouping = item;
    setGraphData();
  };

  function setGraphData() {
    var pitchTypes = [];
    var pitchDefault = [];
    var colors = [];
    for (var i = 0, len2 = $scope.legend.length; i < len2; i++) {
      if ($scope.legend[i].enabled) {
        pitchTypes.push($scope.legend[i].pitchType);
        pitchDefault.push(0);
        colors.push($scope.legend[i].color);
      }
    }

    var len = stats[$scope.grouping].length;
    var dates = [];
    var dataDefault = [];
    for (var j = 0; j < len; j++) {
      if (dates.indexOf(stats[$scope.grouping][j].date) == -1) {
        dates.push(stats[$scope.grouping][j].date);
        dataDefault.push({
          x: stats[$scope.grouping][j].date.length > 2 ? stats[$scope.grouping][j].date.substring(2) + '/' + stats[$scope.grouping][j].date.substring(0, 2) : stats[$scope.grouping][j].date,
          y: $.extend(true, [], pitchDefault)
        });
      }
    }

    var graphData = {};

    for (var k = 0; k < len; k++) {
      var dateIndex = dates.indexOf(stats[$scope.grouping][k].date);
      var pitchIndex = pitchTypes.indexOf(stats[$scope.grouping][k].pitchType);

      if (pitchIndex == -1 || dateIndex == -1) {
        continue;
      }

      for (var statKey in stats[$scope.grouping][k]) {
        if (statKey.indexOf("Average") != -1 || statKey.indexOf("Standard") != -1) {
          if (graphData[statKey] === undefined) {
            graphData[statKey] = {
              series: pitchTypes,
              data: $.extend(true, [], dataDefault)
            };
          }

          graphData[statKey].data[dateIndex].y[pitchIndex] = stats[$scope.grouping][k][statKey];
        }
      }
    }

    $scope.graphData = graphData;
    $scope.config.colors = colors;
    $scope.chartRefresh = new Date().getTime();
  }

  setGraphData();
  $timeout(function() {
    $scope.config.isAnimate = false;
  }, 3000);
}])
;
