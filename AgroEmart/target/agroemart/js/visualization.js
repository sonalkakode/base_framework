$( document ).ready(function() {
    var taClient = null;
    console.log( "ready!" );
    var path = 'problems/tadata.json';
    var problemJson;
    $.getJSON(path, function(data) {
      problemJson=data;
      console.log("DATA:",data);
    });
    function loadTradeoffAnalytics(profile, themeName, callback, errCallback) {
    	console.log("loadTradeoffAnalytics");
    	console.log("profile",profile," themeName",themeName," callback",callback," errCallback",errCallback);
        taClient = new TA.TradeoffAnalytics({
            dilemmaServiceUrl: 'demo/analytics/dilemmas',
            customCssUrl: 'http://ta-cdn.mybluemix.net/modmt/styles/' + themeName + '.css',
            profile: profile,
            errCallback: errCallback
        },'taWidgetContainer');
        taClient.start(callback);
        
    }
    function onError(error) {
    	console.log("Error:",error);
        var errorMsg = 'Error processing the request.';
        $('.errorMsg').text(error ? JSON.stringify(error, null, 4) : errorMsg);
        $('.errorArea').show();
        onPageReady();
    }
    function onPageReady() {
        $('.analyze').show();
        $('.loading').hide();
        console.log("problemJson:",problemJson);
        taClient.show(problemJson);
    }
    function onResultsReady() {
        $('.analyze').show();
        $('.loading').hide();
    }
    loadTradeoffAnalytics('basic', 'watson', onPageReady, onError);
    
    
});