angular.module('players.resources', [
  'ngResource'
])

.factory('Players', ['$resource', function($resource) {
  return $resource('/api/players/:playerId', {playerId: '@playerId'}, {
    'stats': {
      method: 'GET',
      params: {playerId: '@playerId'},
      url: '/api/players/:playerId/stats'
    }
  });
}])
;