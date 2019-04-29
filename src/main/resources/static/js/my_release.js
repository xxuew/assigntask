
$(function () {
    $.ajax({
        type:"get",
        url:"/loginInfo",
        async:false,
        traditional: true,
        contentType: "application/json; charset=UTF-8",
        dataType:"json",
        success:function (userInfo) {
            console.log(userInfo);
            if (userInfo.userid == -1){

                tsInfo =' <span  style="margin-left: 100px;width: 300px;">请登录！</span>';;
                $("#tsnr").html(tsInfo);
                $("#mask").css({"display":"block"});
                $("#ts").css({"display":"block"});
                $("#cancelTs").click(function () {
                    location.href="/";
                });
                // alert("请登录！")
            } else {
                loadReleaseInfos(userInfo);
            }
        }
    });


    $("#test").click(function () {

        alert("!!!!");
        $("#mask").css({"display":"block"});
        $("#pjmb").css({"display":"block"});
    });


    $("#cancelPj").click(function () {

        $("#mask").css({"display":"none"});
        $("#pjmb").css({"display":"none"});
        location.href="/myreleasetask";
    });

    $("#close").click(function () {
        $("#mask").css({"display":"none"});
        $("#pjmb").css({"display":"none"});
        location.href="/myreleasetask";
    });

    $("#closeTaskDetail").click(function () {
        $("#mask").css({"display":"none"});
        $("#taskDetail").css({"display":"none"});
        location.href="/myreleasetask";
    })

});

function loadReleaseInfos(userInfo) {
    $.ajax({
        type:"get",
        url:"/my_release",
        dataType:"json",
        data:userInfo,
        success:function (releaseInfos) {
            console.log(releaseInfos);
            var release_Infos = "";
            //var release_Infos = new FormData();
            for (var i =0;i<releaseInfos.length;i++) {
                var releaseInfo = releaseInfos[i];

                release_Infos = release_Infos +
                    "<tr>" +
                    "<td class='release_id'>" + releaseInfo.releaseid + "</td>" +
                    "<td class='release_name'>" + "<a onclick=detail("+releaseInfo.releaseid+")>" + releaseInfo.releasename + "</a>"+"</td>" +
                    "<td class='release_plan'>" + releaseInfo.plan + "</td>" +
                    "<td class='release_algs'>" + releaseInfo.algnames + "</td>" +
                    // "<td id='status'>" + "LSTM字段错误"+"<button>重新上传</button>" + "</td>" +
                    "<td class='status'>" + releaseInfo.status+ "</td>" ;
                if(releaseInfo.satisfaction == null || releaseInfo.satisfaction == "" ){
                    release_Infos += "<td><button id='judge' onclick= pf("+releaseInfo.releaseid+")>" + "评分" + "</button></td></tr>";
                }else{
                    release_Infos += "<td>" + releaseInfo.satisfaction + "</td></tr>";
                }


            }
            console.log("release_Infos: "+release_Infos);
            //   console.log("字段错误");
            $("#releasedInfo").html(release_Infos);
        }
    });
}

function detail(releaseId) {
    $("#mask").css({"display":"block"});
    $("#taskDetail").css({"display":"block"});

}

function pf(releaseId) {

    $("#mask").css({"display":"block"});
    $("#pjmb").css({"display":"block"});

    $("#submitPj").click(function () {
        $("#mask").css({"display":"none"});
        $("#pjmb").css({"display":"none"});

        var selectVal = $("#score option:selected").val();
        // alert(selectVal);

        var optionData ={
            optionText:selectVal,
            releaseId:releaseId,
        }
        $.ajax({
            url:"/addPj",
            data:optionData,
            type:"get",
            success:function (res) {
                if(res == "success"){
                    tsInfo =' <span  style="margin-left: 100px;width: 300px;">评价成功！</span>';;
                    // alert("评价成功");
                }else{
                    // alert("评价失败");
                    tsInfo =' <span  style="margin-left: 100px;width: 300px;">评价失败！</span>';;
                }
                $("#tsnr").html(tsInfo);
                $("#mask").css({"display":"block"});
                $("#ts").css({"display":"block"});
            }
        });
        $("#cancelTs").click(function () {
            location.href="/myreleasetask";
        })

    });
}



