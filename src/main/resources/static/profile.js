$(document).ready(function() {
    var id = getParameterByName('id');
    callUserInfo();

    function callUserInfo() {
        $.ajax({
            url: "/api/v1/user/getid/"+id
        }).then(function(datatwitt) {
            $('#twitterprofile').html("Your Profle "+'<a href="data.html?id='+id+'">Twitter Profile</a>');
            $('#title').html("Name : "+datatwitt.title+"<br><br>");
            $('#description').html("Job Info : "+datatwitt.description+"<br><br>");
            $('#imagedData').html("Image Url : "+datatwitt.imageUrl+"<br><br>");
            $('#twitter').html("Twitter : @"+datatwitt.twitterUserName+"<br><br>");
        });
    }
    $("#send").click(
        function(event){
            event.preventDefault();
            var portfolio = {
                "title": $("input[name=title]").val(),
                "description": $('textarea[name="description"]').val(),
                "imageUrl": $("input[name=imageUrl]").val(),
                "twitterUserName": $("input[name=twitterUserName]").val()
            }
            console.log("portfolio"+ portfolio);

            $.ajax({
                url:  "/api/v1/user/update/"+id,
                type:'put',
                data: JSON.stringify(portfolio),
                headers: {
                    "Content-Type": "application/json"
                },
                dataType:"json"
            }).then(function(datatwitt) {
                callUserInfo();
            });
        }
    );
});

function getParameterByName(name, url = window.location.href) {
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}