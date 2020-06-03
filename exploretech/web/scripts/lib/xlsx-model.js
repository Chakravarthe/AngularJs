//
// xlsx-model
// ==========
//
// Directive that reads excel file(s) from '<input type="file" [multiple]>'
// via HTML5 FileReader and assigns tabular excel data to the $scope model.  
//
(function () {
    'use strict';

    angular.module('xlsx-model', [])
        .directive('xlsxModel', ['$parse', function ($parse) {
            return {
                restrict: 'A',
                link: function (scope, el, attrs) {
                    var model = $parse(attrs.xlsxModel);
                    var modelSetter = model.assign;
                    var readOpts = {
                        type: 'binary'
                    };

                    el.bind('change', function () {
                            var reader = new FileReader();
                            reader.onload = function (file) {
                                var wb = XLSX.read(file.target.result, readOpts);
                                var data;
                                angular.forEach(wb.SheetNames, function (name) {

                                    data = XLSX.utils.sheet_to_json(wb.Sheets[name]);});
                                modelSetter(scope, data);
                                scope.$apply();
                            }
                            reader.readAsBinaryString(el[0].files[0]);
                    });
                }
            };
        }
        ]);
})();