/**
 * login
 */
$(function () {
    $("#logout").click(function () {
        $.ajax({
            url:"/logout",
            type:"post",
            success:function (success) {
                location.href="/";
            }
        })
    });
})






