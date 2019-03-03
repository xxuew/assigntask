
/**
 * 发布任务
 */
// window.onload = function addRelease() {
//     var btn = document.getElementById("addReleaseTask");
//     btn.onclick = function () {
//         // $("body").append("<div id='dlg_lost' style='padding:20px;'></div>");
//         // $('#dlg_lost').dialog({
//         //     href:path+'/user/login.html',
//         //     modal:true,
//         //     closed:false,
//         //     title:'信息发布',
//         //     width:580,
//         //     height:380,
//         //     buttons:[{
//         //         text:'提交',
//         //         iconCls:'icon-ok',
//         //         handler:function(){
//         //             $('#form_lost').form('submit',{
//         //                 url:path+'/LostServlet',
//         //                 onSubmit:function(){
//         //                     return $(this).form('validate');
//         //                 },
//         //                 success:function(data){
//         //                     if(data == "-1"){
//         //                         $.messager.alert('系统消息','请登录后发布信息！','error');
//         //                     }else{
//         //                         $.messager.alert('系统消息','发布成功！','info',function(){
//         //                             $('#dlg_lost').dialog('refresh');
//         //                             $('#dlg_lost').dialog('close');
//         //                             location.href = path+'/users/lost_list.jsp';
//         //                         },false);
//         //                     }
//         //                 }
//         //             });
//         //         }
//         //     },{
//         //         text:'重置',
//         //         iconCls:'icon-reload',
//         //         handler:function(){
//         //             $('#dlg_lost').dialog('refresh');
//         //         }
//         //     }]
//         // });
//         //   var release=$("addReleaseTask").val();
//         $.ajax({
//             url: "/home",
//             type: "post",
//             traditional: true,
//             contentType: "application/x-www-form-urlencoded; charset=UTF-8",
//             dataType: "text",
//             //     data: release,
//             success: function (data) {
//                 // console.log(data);
//                 // if(data=="OK"){
//                 //     location.href = "/home";
//                 // }else{
//                 alert(data);
//                 alert($(this).form('validate')) ;
//                 //  }
//             },
//             error: function (XMLHttpRequest, textStatus, errorThrown) {
//                 console.log(XMLHttpRequest.status);
//                 console.log(XMLHttpRequest.readyState);
//                 console.log(textStatus);
//
//             },
//         });
//     }
// }

/**
 * 多文件上传监听
 */
function showmfnames() {
    var  mfiles = document.getElementById("choosefile").files;
   // alert("test");
    var  filename_html = "";
    for (var i=0;i<mfiles.length;i++){
        var filename = mfiles[i].name;
            var count = i+1;
            filename_html = "<div>"+filename_html+count+"."+filename+"</div>";
    }

    $("#file-ul").html(filename_html);
}

/**
 * 发布任务
 */
function submitRelease(){
    var formData = new FormData();
    var mfiles = document.getElementById("addfile_1").files[0];
    for (var i = 0;i<mfiles.length;i++){
        formData.append("files[]",mfiles[i]);//存入文件
    }
    formData.append("release_name",$("#release_name").val());
    formData.append("release_plan",$("#release_plan").val());
    formData.append("release_algs",$("#release_algs").val());

    addRelease(formData);
}

function addRelease(formdata) {

    $.ajax({
        type: 'POST',
        url:"/submitrelease",
        data:formdata,
        contentType:false,
        processData:false,
        dataType:"text",
        mimeType:"multipart/form-data",
        success: function (releaseid) {
            console.log("releaseid: "+releaseid);
            alert("发布成功");
            location.href = "/myreleasetask";
            formdata.append("releaseid",releaseid);
            generSubTask(formdata);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("发布失败")
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
        }
    })

}

function generSubTask(formdata) {
    $.ajax({
        type: 'POST',
        url:"/gensubtask",
        data:formdata,
        contentType:false,
        processData:false,
        dataType:"text",
        mimeType:"multipart/form-data",
        success: function () {
            console.log("genersubtask success");
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("genersubtask failed")
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
        }
    })
}

