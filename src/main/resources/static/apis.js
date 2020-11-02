$(document).ready(function() {
    var id = getParameterByName('id');
    var twitterUserName="";
    $.ajax({
        url: "/api/v1/user/getid/"+id
    }).then(function(data) {
            $('#title').append(data.title);
            $('#profile').append('<a href="profile.html?id='+id+'">Change Profile</a>');

            $('#imagedata').append('<img src="'+data.imageUrl+'" width="100px" height="100px">');

            $('#twitterUserName').append("@"+data.twitterUserName+" TimesLine");
            twitterUserName = data.twitterUserName;
            $('#description').append(data.description);

        $.ajax({
            url: "/api/v1/twitter/getwitter/"+twitterUserName
        }).then(function(datatwitt) {

            for (i = 0; i < datatwitt.length; i++) {
                $('#twitts').append("<ul><li>"+datatwitt[i].text+"</li></ul>");
            }

        });
    });


});

function getParameterByName(name, url = window.location.href) {
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}