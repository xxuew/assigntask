/**
 * login
 */

$(function(){
    if($.cookie("rmbUser")== "true"){
        $("#rmbUser").attr("checked",true);
        $("#username").val($.cookie("username"));
        $("#password1").val($.cookie("password"));
    }
    //注册、忘记密码的验证；
    $("#username").click(function () {
        $("#noteName").css({"display": "none"});
        $("#noteName1").css({"display": "none"});
    });
    $("#password").click(function () {
        $("#notePwd").css({"display": "none"});
    });

    $("#ckpassword").click(function () {
        $("#noteCKPwd").css({"display": "none"});
    });

    $("#email").click(function () {
        $("#noteEmail").css({"display": "none"});
    });


    $("#rmbUser").click(function () {
        var username = $("#username").val();
        var password = $("#password1").val();
        if($(this).prop("checked")){
            if($.cookie("rmbUser") != true){
                $.cookie("rmbUser", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
                $.cookie("username", username, { expires: 7 }); // 存储一个带7天期限的 cookie
                $.cookie("password", password, { expires: 7 }); // 存储一个带7天期限的 cookie
            }else{
                $.cookie("rmbUser", "false", { expires: -1 });
                $.cookie("username", '', { expires: -1 });
                $.cookie("password", '', { expires: -1 });
            }
        }
        else
        {
            $.cookie("rmbUser", "false", { expires: -1 });
            $.cookie("username", '', { expires: -1 });
            $.cookie("password", '', { expires: -1 });
        }
    });

    $("#login_form").click(function () {
        var uusername = $("#username").val();
        var upassword = $("#password1").val();
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
                    location.href = "/myreleasetask";
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

    $('#register-btn').click(function (){
        var username = $("#username").val();
        var password = $("#password").val();
        var ckpassword = $("#ckpassword").val();
        var email = $("#email").val();
        //回填数据；
        fill_back(username,password,ckpassword,email);

        if(!vali_name(username)||! vali_password(password)||!vali_ckpassword(password,ckpassword)||!vali_email(email)){
            return ;
        }
        //判断用户名是否唯一；

        $.ajax({
            url: "/registerInfo",
            type: "post",
            data:{
                username :username,
                password :password,
                ckpassword:ckpassword,
                email:email,
            },
            success:function (res) {
                if(res == "success"){
                    location.href = "/";
                }
                else if(res == "existUserName"){
                    $("#noteName1").css({"display":"block","color":"red"});
                }
                else if(res == "existEmial"){
                    $("#noteEmail1").css({"display":"block","color":"red"});

                }
                else {
                    alert("other error");
                }
            } ,
            error:function (res) {
                alert("res");
            }
        });
    });
    $("#testbt").click(function () {
        $("#mask").css({"display":"block"});
        $("#resetPwd").css({"display":"block"});

    });


    $("#valifg").click(function () {
        var username =  $("#username").val();
        if(!vali_name(username)){
            return;
        }
        $("#mask").css({"display":"block"});
        $("#myModal").css({"display":"block"});
    });

    $("#forgetPwd").click(function () {
        var username =  $("#username").val();
        var email = $("#email").val();
        if(!vali_email(email)){
            return;
        }
        $.ajax({
            url:"/resetPassword",
            type:"post",
            data:{
                username:username,
                email:email,
                type:0
            },
            success:function (res) {
                if(res == "success"){
                    $("#ckEmail").css({"display":"none"});
                    $("#mask").css({"display":"block"});
                    $("#resetPwd").css({"display":"block"});
                }
                else if(res == "notExistUser"){
                    alert("该用户还没有注册!请先注册");
                    location.href = "/register";
                }else if(res == "errorEmail"){
                    $("#noteEmail1").css({"display":"block","color":"red"});
                }
            }

        });

    });
    $("#resetPwdbtn").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var ckpassword = $("#ckpassword").val();

        if(!vali_password(password)){
            return ;
        }
        if(!vali_ckpassword(password,ckpassword)){
            return ;
        }
        $.ajax({
            url:"/resetPassword",
            type:"post",
            data:{
                username:username,
                password:password,
                type:1,
            },
            success:function (res) {
                if(res == "success"){
                    alert("重置密码成功！");
                }else{
                    alert("重置密码失败！");
                }
                $("#mask").css({"display":"none"});
                $("#resetPwd").css({"display":"none"});
                location.href="/";
            }

        })
    });
    $("#cancelResetPwd").click(function () {
        $("#password").val("");
        $("#ckpassword").val("");
        $("#mask").css({"display":"none"});
        $("#resetPwd").css({"display":"none"});
        location.href="/";
    });
    $("#closeResetPwd").click(function () {
        $("#password").val("");
        $("#ckpassword").val("");
        $("#mask").css({"display":"none"});
        $("#resetPwd").css({"display":"none"});
        location.href="/";
    });

    $("#cancelMyModal").click(function () {
        $("#email").val("");
        $("#mask").css({"display":"none"});
        $("#myModal").css({"display":"none"});
        location.href="/";
    });


    $("#closeMyModal").click(function () {
        $("#email").val("");
        $("#mask").css({"display":"none"});
        $("#myModal").css({"display":"none"});
        location.href="/";
    })
});

function vali_name(username) {
    if(username == null || username == ""){
        $("#noteName").css({"display":"block","color":"red"});
        return false;
    }
    return true;
}

function vali_email(email){
    var reg = /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/;

    if(email == null || !reg.test(email)){
        $("#noteEmail").css({"display":"block","color":"red"});
        return false;
    }
    return true;
}

function vali_password(password) {

    if(password == null || password == ""){
        $("#notePwd").css({"display":"block","color":"red"});
        return false;
    }
    return true;
}

function vali_ckpassword(password,ckpassword) {

    if (password != ckpassword|| ckpassword==""){
        $("#noteCKPwd").css({"display":"block","color":"red"});
        return false;
    }
    return true;
}
function fill_back(username,password,ckpassword,email){
    $("#username").val(username);
    $("#password").val(password);
    $("#ckpassword").val(ckpassword);
    $("#email").valueOf(email)

}

// $(function () {
//
//     $.ajax({
//         url:"/loginInfo",
//         type:"get",
//         traditional: true,
//         contentType: "application/x-www-form-urlencoded; charset=UTF-8",
//         dataType:"json",
//         success:function (userInfo) {
//             // console.log(userInfo);
//             $("#userid").append(userInfo.userid);
//             $("#username").append(userInfo.username);
//         },
//         error:function () {
//             console.log("获取用户信息失败");
//         }
//     })
// })




