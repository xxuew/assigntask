$(function(){
    $("#comment_btn").click(function () {
    // var form = document.getElementById('comment_form');
    // form.submit();
    var scorea1 = $("#score_a1").val();
    var scoreb1 = $("#score_b1").val();
    var scorea2 = $("#score_a2").val();
    var scoreb2 = $("#score_b2").val();
    var scorea3 = $("#score_a3").val();
    var scoreb3 = $("#score_b3").val();
    var scorea4 = $("#score_a4").val();
    var scoreb4 = $("#score_b4").val();
    var scorea5 = $("#score_a5").val();
    var scoreb5 = $("#score_b5").val();
    var scorea6 = $("#score_a6").val();
    var scoreb6 = $("#score_b6").val();
    var scorea7 = $("#score_a7").val();
    var scoreb7 = $("#score_b7").val();
    var scorea8 = $("#score_a8").val();
    var scoreb8 = $("#score_b8").val();
    var scorea9 = $("#score_a9").val();
    var scoreb9 = $("#score_b9").val();
    var scorea10 = $("#score_a10").val();
    var scoreb10 = $("#score_b10").val();
    if (scorea1 == 0 || scoreb1 == 0){
        alert("第一个未打分");
        return  false;
    } else if (scorea2 == 0 || scoreb2 == 0){
        alert("第二个未打分");
        return  false;
    }else if (scorea3 == 0 || scoreb3 == 0){
        alert("第三个未打分");
    }else if (scorea4 == 0 || scoreb4 == 0){
        alert("第四个未打分");
    }else if (scorea5 == 0 || scoreb5 == 0){
        alert("第五个未打分");
    }else if (scorea6 == 0 || scoreb6 == 0){
        alert("第六个未打分");
    }else if (scorea7 == 0 || scoreb7 == 0){
        alert("第七个未打分");
    }else if (scorea8 == 0 || scoreb8 == 0){
        alert("第八个未打分");
    }else if (scorea9 == 0 || scoreb9 == 0){
        alert("第九个未打分");
    }else if (scorea10 == 0 || scoreb10 == 0){
        alert("第十个未打分");
    }else{
        $.ajax({
            url: "/get_comment",
            type: "post",
            traditional: true,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "text",
            data: $('#comment_form').serialize(),
            success: function (data) {
                console.log(data);
                if (data == "OK") {
                    location.href = "/home";
                } else {
                    location.href = "/login";
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
                alert("服务发生错误！");
            },


        });
    }
    });


    document.onkeydown = function (event) {
        var e = event || window.event||
            arguments.callee.caller.arguments(0);
        if (e&&e.keyCode == 13) {
            $("#comment_btn").click();
        }
    };
});

