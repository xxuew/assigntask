/**
 * 提示字段要求
 */
$(function  (){

    getSubTask();

    $("#zdRecommends").click(function () {
        $("#mask").css({"display":"block"});
        $("#zdRecommendsTS").css({"display":"block"});
    });
    $("#cancelRecommennd").click(function () {
        $("#mask").css({"display":"none"});
        $("#zdRecommendsTS").css({"display":"none"})
    });
    //

    $("#zdInputs").click(function () {
        $("#mask").css({"display":"block"});
        $("#zdInputsTS").css({"display":"block"});
    });
    $("#cancelInputs").click(function () {
        $("#mask").css({"display":"none"});
        $("#zdInputsTS").css({"display":"none"});
    });

});

/**
 * 判断是否登录
 */
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
                location.href = "/";
            }
        }
    })
})

/**
 * 改变子任务量
 */
$("#release_plan").change(function () {
    getSubTask();
});

function  getSubTask(){
    var selectObj = document.getElementById("release_plan"); //拿到select对象
    // console.log("selectObj" + selectObj);
    var option = selectObj.selectedIndex;//拿到选中项的索引
    // console.log("option：" + option);
    var  optionText = selectObj.options[option].text;//拿到选中项options中的tex
    //  console.log("change：" + optionText);
    var optionData ={
        optionText:optionText
    }
    $.ajax({
        type:"GET",
        url:"/subtaskNum",
        data:optionData,
        dataType:"text",
        success:function (formula) {
            document.getElementById("plan_subtaskNum").innerHTML = formula;
            //alert(formula);
        }
    })
}
// /**
//  * 改变子任务量
//  */
// $("#release_plan").change(function () {
//     var selectObj = document.getElementById("release_plan"); //拿到select对象
//    // console.log("selectObj" + selectObj);
//     var option = selectObj.selectedIndex;//拿到选中项的索引
//    // console.log("option：" + option);
//     var  optionText = selectObj.options[option].text;//拿到选中项options中的tex
//   //  console.log("change：" + optionText);
//     var optionData ={
//         optionText:optionText
//     }
//     $.ajax({
//         type:"GET",
//         url:"/subtaskNum",
//         data:optionData,
//         dataType:"text",
//         success:function (formula) {
//           document.getElementById("plan_subtaskNum").innerHTML = formula;
//           //alert(formula);
//         }
//     })
// });

/**
 * 存入发布项目填写的信息
 */
function addRelease() {
    // $.ajax({
    //     type:"GET",
    //     url:"",
    //     traditional:true,
    //     contentType:"",
    //     dataType:"json",
    //     success:function (userInfo) {
    //         console.log(userInfo);
    //         if (userInfo.userid == -1){
    //             alert("请登录！")
    //         } else {
                var formData = new FormData();
                if ($("#release_name").val() == null || $("#release_name").val() == ""
                    ||$("#release_plan").val() == null || $("#release_plan").val() == ""
                    || $("#input_tablename").val() ==null ||  $("#input_tablename").val() == ""){
                    alert("有信息未填写！");
                } else {
                    formData.append("release_name", $("#release_name").val());//项目名称
                    formData.append("release_plan", $("#release_plan").val());//生成方案
                    formData.append("input_tablename", $("#input_tablename").val());//文本检索数据表名
                    addFile(formData);//存入所有上传文件
                }
   //         }
    //     }
    // })
}

/**
 * 存入上传的所有文件
 * @returns {*}
 */
function addFile(formData){
    var add_file_input = document.getElementById("add_file_input");//文本检索内容数据源文件
    if (add_file_input.value == "" || add_file_input.value == null) {
        alert('请上传文本检索内容数据源文件!');
    } else if (add_file_input.files[0].size > 1024*1024*1){
        alert("请上传小于1M的文件！");
    }else {
        var input_extend = add_file_input.value.substring(add_file_input.value.lastIndexOf(".") + 1);
        if (!(input_extend.toLowerCase() == "sql")){
            console.log(add_file_input.value);
            alert("请上传sql文件");
        }else {
            var add_file_recommands = document.getElementsByName("add_files");//算法推荐结果数据源文件
            if (add_file_recommands.length < 2) {
                alert('至少上传两个推荐结果数据源文件!');
            } else {
               formData.append("mFiles", add_file_input.files[0]); //存入文本检索内容数据源文件
                var fileCount = 0;
                for (var i = 0; i < add_file_recommands.length; i++) {
                    //遍历每一个推荐结果数据源文件
                    var add_file_recommand = add_file_recommands[i];
                    if (add_file_recommand.value == "" || add_file_recommand.value == null) {
                        //文本检索或推荐结果任一文件为空
                        alert('请先选择文件!');
                    } else if (add_file_recommand.files[0].size > 1024*1024*1){
                       // alert("请上传小于1M的文件！");
                        alert("NN文件字段错误！");
                    }
                    else {
                        var recommand_extend = add_file_recommand.value.substring(add_file_recommand.value.lastIndexOf(".") + 1);
                        if (!(recommand_extend.toLowerCase() == "sql")) {
                            alert("请上传SQL文件");
                        } else {
                            formData.append("mFiles",add_file_recommand.files[0]); //存入算法推荐结果数据源文件
                            fileCount = fileCount+1;
                        }
                    }
                }
            }
      }
   }
    if (fileCount == add_file_recommands.length){
        addAlgNames(formData); //存入填写的算法名和算法表名
     }
}

/**
 * 存入填写的算法名称和算法表名
 * @param formData
 */
function addAlgNames(formData){
    var recommandAlgNames = document.getElementsByName("recommand_algname");
    var recommandAlgTableNames = document.getElementsByName("recommand_tablename");
    var count = 0;
    for (var i = 0; i < recommandAlgNames.length; i++) { //遍历算法名和表名
        var algNameValue = recommandAlgNames[i].value;
        var algTableNameValue = recommandAlgTableNames[i].value;
        if (algNameValue == null || algTableNameValue == null || algNameValue == "" || algTableNameValue == "") {
            alert("有信息未填写！");
            break;
        }else {
            formData.append("recommandAlgNames",algNameValue );
            formData.append("recommandAlgTableNames", algTableNameValue);
            count = count+1;
        }
    }
    if (count == recommandAlgNames.length) {
        submitRelease(formData);
    }
}

function submitRelease(formdata) {

    $.ajax({
        type: 'POST',
        url:"/submitrelease",
        data:formdata,
        contentType:false,
        processData:false,
        dataType:"json",
        mimeType:"multipart/form-data",
        success: function (result) {
             console.log("releaseid: "+result.releaseid);
             if (result.releaseid > 0){
          //       formdata.append("releaseid",result.releaseid);
                 generSubTask();
                 alert(result.msg);
             }else {
                 alert(result.msg);
             }
            $.ajax({
                url:"/setSession",
                type:"post",
                async:false,
                data:result.user,
                success:function f(res) {
                    if(res == "success"){
                        location.href = "/myreleasetask";
                    }else{
                        location.href = "/";
                    }
                }
            });
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("发布失败")
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}

/**
 * 增加算法
 */
function addAlg() {

//    var add_file_recommends = document.getElementsByName("add_files");//算法推荐结果数据源文件
//    var count = add_file_recommends.length + 1;
    var recommmend_num = document.getElementsByName("recommand_num"); //所有的推荐算法名
    var last_recommend_num = recommmend_num[recommmend_num.length - 1].innerText; //最后一个推荐算法名
    var count = parseInt(last_recommend_num.replace(/[^0-9]/ig, "")) + 1;

    var table = $('.table');
    var addtr = $("<tr>" +
        "<th name='recommand_num'>推荐算法" + count + "</th> " +
        "<td> <input type='text' class='form-control' name='recommand_algname' placeholder='任务包含的算法名' id='recommand_algname'> </td>" +
        "<th>推荐结果表名</th>" +
        "<td><input type='text' class='form-control' name='recommand_tablename' placeholder='推荐结果表名' id='recommand_tablename'></td>" +
        "<th>推荐结果数据源 </th>" +
        "<td> <input type='file' name='add_files' id='add_file' style='display: inline-block'/>" +
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


// /**
//  * 生成任务
//  * @param formdata
//  */
// function generSubTask(formdata) {
//     $.ajax({
//         type: 'POST',
//         url:"/gensubtask",
//         data:formdata,
//         contentType:false,
//         processData:false,
//         dataType:"text",
//         mimeType:"multipart/form-data",
//         success: function () {
//             console.log("genersubtask success");
//         },
//         error: function (XMLHttpRequest, textStatus, errorThrown) {
//             console.log(XMLHttpRequest.status);
//             console.log(XMLHttpRequest.readyState);
//             console.log(textStatus);
//             alert("genersubtask failed")
//         }
//     })
// }

/**
 * 生成任务
 * @param formdata
 */
function generSubTask() {
    $.ajax({
        type: 'POST',
        url:"/gensubtask",
        async:false,
        //  data:formdata,
//        contentType:false,
//        processData:false,
        dataType:"json",
//        mimeType:"multipart/form-data",
        success: function (result) {
            console.log(result);
            // console.log("genersubtask success");
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
            console.log("genersubtask failed")
        }
    })
}

/**
 * TODO
 * 调用bootstrap的模态框
 */
// $(function  (){
//     $(".btn").click(function () {
//         console.log("c:\\fakepath\\JU-TE-01.docx");
//         $("#myModal").modal();
//     })
//
// });
