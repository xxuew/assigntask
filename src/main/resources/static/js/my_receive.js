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
            url:"/my_receive",
            dataType:"json",
            data:userInfo,
            success:function (receiveInfos) {
                console.log(receiveInfos);
                var receive_Infos = "";
                for (var i =0;i<receiveInfos.length;i++) {
                    var receiveInfo = receiveInfos[i];
                    var count = i+1;
                    receive_Infos = receive_Infos +
                                    "<tr>" +
                                    "<td>" + count + "</td>" +
                                    "<td>" + "<a href='/comment'>开始任务</a>" + "</td>" +
                                    "<td>" + receiveInfo.ifcomplete + "</td>" +
                                    "</tr>";
                    // $("#releaseid").append(receiveInfo.releaseid);
                    // $("#releasename").append(receiveInfo.releaseName);
                    // $("#plan").append(receiveInfo.plan);
                }
                console.log("receive_Infos: "+receive_Infos);
                $("#receivedInfo").html(receive_Infos);
            }
        })
        }
    })
})