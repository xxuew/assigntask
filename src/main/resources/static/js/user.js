/**
 * login
 */
$(function(){
    $("#login_btn").click(function () {
        var uusername = $("#UserName").val();
        var upassword = $("#Password").val();
        console.log(uusername);
        var user = {
            username: uusername,
            password: upassword
        };
        console.log(user);
        $.ajax({
            url: "/login",
            type: "post",
            traditional: true,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "text",
            data: user,
            success: function (data) {
                console.log(data);
                if(data=="OK"){
                    location.href = "/home";
                }else{
                    alert(data);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
                alert("服务发生错误！");

            },
        });
    });

    $("#signup_btn").click(function () {
        var username = $("#Name").val();
        var password = $("#Password").val();
        console.log(username);
        var user = {
            username: username,
            password: password
        };
        console.log(user);
        $.ajax({
            url: "/add_user",
            type: "post",
            traditional: true,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "text",
            data: user,
            success: function (data) {
                console.log(data);
                if(data=="OK"){
                    alert("注册成功");
                    location.href = "/login";
                }else{
                    alert(data);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
                alert("服务发生错误！");
            },
        });
    });

    $("#sign_up").click(function () {
        location.href = "/signup";
    });

});




