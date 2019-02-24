/**
 * login
 */
$(function(){
    $("#login_form").click(function () {
        var uusername = $("#username").val();
        var upassword = $("#password").val();
        console.log(uusername);
        var user = {
            username: uusername,
            password: upassword
        };
        console.log(user);
        $.ajax({
            url: "/loginjudge",
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

            },
        });
    });
});

$(function () {

    $.ajax({
        url:"/loginInfo",
        type:"get",
        traditional: true,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType:"json",
        success:function (userInfo) {
            console.log(userInfo);
            $("#userid").append(userInfo.userid);
            $("#username").append(userInfo.username);
        },
        error:function () {
            console.log("获取用户信息失败");
        }
    })
})




