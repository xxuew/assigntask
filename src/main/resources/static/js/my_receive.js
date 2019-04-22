$(function () {
    $.ajax({
        type:"get",
        url:"/loginInfo",
        traditional: true,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType:"json",
        success:function (userInfo) {
            // console.log(userInfo);

            var selectObj = document.getElementById("job_status"); //拿到select对象
            var option = selectObj.selectedIndex;//拿到选中项的索引
            var optionText = selectObj.options[option].text;//拿到选中项options中的text
            var tranData = {
                userid:userInfo.userid,
                optionText:optionText
            }
            pageInfos(tranData);

            $("#job_status").change(function () {

                var  optionText =  $("#job_status").find("option:selected").text();
                // alert(optionText);
                // selectObj = document.getElementById("job_status"); //拿到select对象
                // console.log("selectObj" + selectObj);
                // option = selectObj.selectedIndex;//拿到选中项的索引
                // console.log("option" + option);
                // optionText = selectObj.options[option].text;//拿到选中项options中的tex
                // console.log("change" + optionText);
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

                    var userInfo = receiveInfos.userInfo;

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
                        var startJob = "";
                        if (tranData.optionText == "已完成" || tranData.optionText == "不可信"){
                            startJob = "<td>" + "已完成任务" + "</td>";
                        }
                        else {
                            var userId = userInfo.userid;
                            var myReceiveId = myReceiveInfo.id;
                            var href = '/comment?userid='+userId+'&myReceiveId='+myReceiveId;
                            // startJob = "<td>" + "<button onclick='startTask("+userInfo.userid+","+myReceiveInfo.id+")'>开始任务</>" + "</td>";
                           startJob = "<td>" + "<a href='"+href+"'>开始任务</a>" + "</td>";
                        }
                        receive_Infos = receive_Infos +
                            "<tr>" +
                            "<td>" + i + "</td>" +
                            "<td>" + myReceiveInfo.id + "</td>" + startJob +
                            "<td>" + myReceiveInfo.ifcomplete + "</td>" +
                            // "<td>" + "JU-TE-03" + "</td>" +
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

function startTask(userid,myReceiveInfo) {
    var data = {
        userid:userid,
        queryString:myReceiveInfo,
    }
    // alert(userid+"---"+myReceiveInfo);
    $.ajax({
        type:"get",
        url:"/commentInfo",
        dataType:"json",
        data:data,
        success:function (commentInfos) {
            console.log(commentInfos);
            var input = commentInfos.input; //inputname、inputdes
            var subtasks = commentInfos.subtasks;
            console.log("input: " + input);
            console.log("subtasks: " + subtasks);
            var subtaskArr = [];
            for (var i = 0;i<subtasks.length;i++){
                var subtask = subtasks[i];
                var count = i+1;
                subtaskArr.push(subtask);
                var inputnameid = "#"+"inputname"+count;
                $(inputnameid).append( "检索：" + input.inputname);

                var inputdesid = "#"+"inputdes"+count;
                $(inputdesid).append("描述：" + input.inputdes);

                var nameid_a = "#"+"subtaskname"+count+"_a";
                $(nameid_a).append("推荐1：" + subtask.itemname1);

                var desid_a = "#"+"subtaskdes"+count+"_a";
                $(desid_a).append("推荐1描述：" + subtask.itemdes1);

                var nameid_b = "#"+"subtaskname"+count+"_b";
                $(nameid_b).append("推荐2：" + subtask.itemname2);

                var desid_b = "#"+"subtaskdes"+count+"_b";
                $(desid_b).append("推荐2描述：" + subtask.itemdes2);
            }
            // $("#comment_submit").click(function () {
            //     insertCommentRes(subtaskArr);
            // })

            // var comment_html = "";
            //
            // for (var i = 0; i < subtasks.length; i++) {
            //     var count = i+1;
            //     var input_html = "<div class='input'>" +
            //                         "<div class='step-item-header'>" +
            //                         "<span class='current-order'>" + count + "</span>/10</div>" +
            //                         "<li  class='item-name'>" + input.inputname + "</li>" +
            //                         "<li  class='item-des'>" + input.inputdes + "</li>" +
            //                     "</div>"
            //     var subtask = subtasks[i];
            //     console.log("subtask: " + subtask);
            //     //ids
            //     var itemname1 = "itemname1" +i;
            //     var itemname2 = "itemname2" +i;
            //     var range1 = "range1" + i;
            //     var range2 = "range2" + i;
            //     var score1 = "score1" + i;
            //     var score2 = "score2" + i;
            //     var subtask_html = "<div class='comment'>" +
            //                             "<div style='height:180px'>" +
            //                                 "<li  class='item-name'>" + subtask.itemname1 + "</li>" +
            //                                 "<li  class='item-des'>" + subtask.itemdes1 + "</li>" +
            //                                 "<input name = '"+itemname1+"' type='range' min =0 max =10  id='range'>" +
            //                                 "<span id='text'>" + 0 + "</span>" +
            //                         "</div>" +
            //                             "<div style='height:180px'> " +
            //                                 "<li  class='item-name'>" + subtask.itemname2 + "</li>" +
            //                                 "<li  class='item-des'>" + subtask.itemdes2 + "</li>" +
            //                                 "<input name = '"+itemname2+"' type='range' min =0 max =10 value =0 id='range'>" +
            //                                 "<span id='text'>" + 0 + "</span>" +
            //                             "</div>" +
            //                         "</div>"
            //     comment_html = comment_html +
            //                     "<div class='place_holder style='height:12%;width: 100%'>" + "</div>" +
            //                     "<div class='comment-container'>" +
            //                     "<ul border='1' >" +
            //                     input_html + subtask_html +
            //                     "</ul>" + "</div>" ;
            //
            // }
            // $("#commentItem").html(comment_html);
        }
    })
}

