$(function () {
    $.ajax({
        type:"get",
        url:"/loginInfo",
        traditional: true,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType:"json",
        success:function (userInfo) {
            console.log(userInfo);
            var selectObj = document.getElementById("job_status"); //拿到select对象
            var option = selectObj.selectedIndex;//拿到选中项的索引
            var optionText = selectObj.options[option].text;//拿到选中项options中的text
            var tranData = {
                userid:userInfo.userid,
                optionText:optionText
            }
            pageInfos(tranData);

            $("#job_status").change(function () {
                selectObj = document.getElementById("job_status"); //拿到select对象
                console.log("selectObj" + selectObj);
                option = selectObj.selectedIndex;//拿到选中项的索引
                console.log("option" + option);
                optionText = selectObj.options[option].text;//拿到选中项options中的tex
                console.log("change" + optionText);
                tranData = {
                    userid:userInfo.userid,
                    optionText:optionText
                }
                pageInfos(tranData);
            });
        },
    })
})

function pageInfos(tranData) {
            $.ajax({
                type:"get",
                url:"/my_receive",
                dataType:"json",
                data:tranData,
                success:function (receiveInfos) {
                    console.log(receiveInfos);

                   // receiveInfos = JSON.stringify(receiveInfos);
                    var myReceives = receiveInfos.myreceives;
                    var releases = receiveInfos.releases;
                    var receive_Infos = "";
                    console.log("myReceives:"+receiveInfos.myreceives);
                    console.log("releases+:" + receiveInfos.releases);
                    for (var i =0;i<myReceives.length;i++) {
                        var myReceiveInfo = myReceives[i];
                        var releaseInfo = releases[i];
                        console.log("myReceiveInfo" + myReceiveInfo);
                        console.log("releaseInfo" +releaseInfo);
                        var count = i+1;
                        var href = '/comment?'+ count;
                        var startJob = "";
                        if (tranData.optionText == "已完成"){
                            startJob = "<td>" + "已完成任务" + "</td>";
                        }
                        else {
                            startJob = "<td>" + "<a href='"+href+"'>开始任务</a>" + "</td>";
                        }
                        receive_Infos = receive_Infos +
                            "<tr>" +
                            "<td>" + count + "</td>" + startJob +
                            "<td>" + myReceiveInfo.ifcomplete + "</td>" +
                            "<td>" + releaseInfo.releasename + "</td>" +
                            "</tr>";
                    }
                    console.log("receive_Infos: "+receive_Infos);
                    $("#receivedInfo").html(receive_Infos);
                }
            })
        }

// function changeSele() {
//     // $("#job_status").change(function () {
//     //     selectObj = document.getElementById("job_status"); //拿到select对象
//     //     console.log("selectObj" + selectObj);
//     //     option = selectObj.selectedIndex;//拿到选中项的索引
//     //     console.log("option" + option);
//     //     optionText = selectObj.options[option].text;//拿到选中项options中的tex
//     //     console.log("change" + optionText);
//     //     return optionText;
//     // })
// }

