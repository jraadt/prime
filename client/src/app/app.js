angular.module('app', [
  'templates-app',
  'templates-common',
  'players',
  'services.i18nNotifications',
  'ui.router'
])

.constant('I18N.MESSAGES', {
  'errors.route.changeError':'Route change error'
})

.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise('/players');
}])

.controller('AppCtrl', ['$scope', 'i18nNotifications', 'localizedMessages', function ( $scope, i18nNotifications ) {
  $scope.notifications = i18nNotifications;

  $scope.removeNotification = function (notification) {
    i18nNotifications.remove(notification);
  };

  $scope.$on('$stateChangeError', function(event, toState, toParams, fromState, fromParams, error){
    i18nNotifications.pushForCurrentRoute('errors.route.changeError', 'error', {}, {rejection: error});
  });
}])
;
