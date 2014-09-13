angular.module('directives.placeholder', [])

.directive('myPlaceholder', function() {
  return {
    link: function(scope, element, attrs) {
      var label = element.closest(".form-group")
          .css({'position':'relative'})
          .prepend('<span class="placeholder">' + element.attr('my-placeholder') + '</span>')
          .find('span.placeholder')
          .bind('click', function(){
            element[0].focus();
          });

      element.focus(function() {
        label.addClass("placeholder-focus");
      }).blur(function() {
        label.removeClass("placeholder-focus");
      });

      element.bind('keyup keydown', function(){
        if (element.val() !== '') {
          label.hide();
        } else {
          label.show();
        }
      });
    }
  };
});