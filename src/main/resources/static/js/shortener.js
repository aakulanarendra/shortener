var urlPattern = /^(https?|ftp):\/\/[.A-Za-z0-9]+/;

$(document).ready(function () {
    $("#shortener-form").submit(function (event) {
        event.preventDefault();
        shortenUrl();
    });
});

function shortenUrl() {
    var reqObj = {};
    $('#shortener-url').html("");
    reqObj['longUrl'] = $("#long-url").val();
    if(validateURLValue(reqObj.longUrl)){
        $("#shortener-btn").prop("disabled", true);
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/shortenerUrl",
            data: JSON.stringify(reqObj),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                var urlGen = window.location.href+JSON.stringify(data, null, 4);
                var json = "<h4>Success: </h4><pre><a href="+urlGen+" target='_blank'>"+urlGen+"</a></pre>";
                $('#shortener-url').html(json);
                $("#shortener-btn").prop("disabled", false);

            },
            error: function (e) {
                var json = "<h4>Failure: </h4><pre>" + e.responseText + "</pre>";
                $('#shortener-url').html(json);
                $("#shortener-btn").prop("disabled", false);

            }
        });
    }else{
        $('#shortener-url').html("<h4>Validation Error: </h4><pre> Please use proper url pattern, for ex: http://www.apple.com/phone/</pre>");
    }

}

function validateURLValue(url) {
   return  urlPattern.test(url);
}