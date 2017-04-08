/**
 * Created by PANNA on 08.04.2017.
 */
(function(exports){
    exports.parse = function(url){
        if(!url)
            return {};
        var index = url.indexOf('?');
        if(index > -1){
            var result = {};
            var query = url.substr(index + 1);

            query.split('&').forEach(function(param){
                var array = param.split('=');

                result[array[0]] = array[1];
            });

            return result;
        }
        return {};
    };


})(window.UrlUtil = {});