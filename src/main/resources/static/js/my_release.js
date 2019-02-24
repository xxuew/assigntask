$(function () {
    $.ajax({
        type:"get",
        url:"/loginInfo",
        traditional: true,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType:"json",
        success:function (userInfo) {
            console.log(userInfo);
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
                                   "<td>" + releaseInfo.releaseid + "</td>" +
                                   "<td>" + releaseInfo.releasename + "</td>" +
                                   "<td>" + releaseInfo.plan + "</td>" +
                                   "</tr>";
                    // $("#releaseid").append(releaseInfo.releaseid);
                    // $("#releasename").append(releaseInfo.releaseName);
                    // $("#plan").append(releaseInfo.plan);

                }
                console.log("release_Infos: "+release_Infos);
                $("#releasedInfo").html(release_Infos);
            }
        })
        }
    })
})