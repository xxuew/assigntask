
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
    // var mfiles = document.getElementById("addfile_1").files[0];
    // for (var i = 0;i<mfiles.length;i++){
    //     formData.append("files[]",mfiles[i]);//存入文件
    // }
    var mfiles = $('.add_file')//.files;
    console.log("files:" + mfiles.file);
    for (var i = 0;i<mfiles.length;i++){
        console.log("文件名："+ mfiles[i][0].files[0]);
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

/**
 * 增加算法
 */
function addAlg() {
  var table = $('.table');
  var addtr = $( "<tr>" +
      "<th>项目包含的算法名</th> " +
      "<td> <input type='text' name='releasename' placeholder='任务包含的算法名' id='release_algs'> </td>" +
      "<th>数据源SQL脚本文件 </th>" +
      "<td> <input type='file' name='fileUpload' id='add_file' style='display: inline-block'/>" +
      "<span><button type='button'  onclick='deleteAlg(this)'>删除算法</button> </span> " +
      "</td>" +
      "</tr>");
  addtr.appendTo(table);
}

/**
 * 删除算法
 */
function deleteAlg(obj) {
    //多以parent就代表向前一个标签
    //本删除 范围为<span><td><tr>
    //如果多一个parent就会删除整个table
    $(obj).parent().parent().parent().remove();
}


/**
 * 生成任务
 * @param formdata
 */
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

