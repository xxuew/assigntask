$(function () {
    $.ajax({
        type:"get",
        url:"/loginInfo",
        traditional: true,
        contentType: "application/json; charset=UTF-8",
        dataType:"json",
        success:function (userInfo) {
             console.log(userInfo);
             if (userInfo.userid == -1){
                 alert("请登录！")
                 window.location = "/";
             } else {
                 loadReleaseInfos(userInfo);
             }
        }
    })
})

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
                    "<td id='release_id'>" + releaseInfo.releaseid + "</td>" +
                    "<td id='release_name'>" + "<a>" + releaseInfo.releasename + "</a>"+"</td>" +
                    "<td id='release_plan'>" + releaseInfo.plan + "</td>" +
                    "<td id='release_algs'>" + releaseInfo.algnames + "</td>" +
                    // "<td id='status'>" + "LSTM字段错误"+"<button>重新上传</button>" + "</td>" +
                    "<td id='status'>" + releaseInfo.status+ "</td>" +
                    "<td>" + "<button id='release_judge'>" + "评价" + "</button>" + "</td>" +
                    "</tr>";
            }
            console.log("release_Infos: "+release_Infos);
            //   console.log("字段错误");
            $("#releasedInfo").html(release_Infos);
        }
    })
}