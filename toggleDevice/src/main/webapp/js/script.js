$(window).load(function(){
    $('#sendKeyword').bind('click', function(){
        var device = new Object();
        device.keyword = $('#keyword').val();

        $.ajax({
            url: "/device-toggle",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(device),
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data) {
                $('#answer').html(data.text);
            },
            error:function(data,status,er) {
                alert("error: "+data+" status: "+status+" er:"+er);
            }
        });
    })
});