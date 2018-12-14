/**
 * login
 */
$(function(){
    $("#login_form").click(function () {
        var uusername = $("#username").val();
        var upassword = $("#password").val();
        console.log(uusername);
        var user = {
            username: uusername,
            password: upassword
        };
        console.log(user);
        $.ajax({
            url: "/loginjudge",
            type: "post",
            traditional: true,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "text",
            data: user,
            success: function (data) {
                console.log(data);
                if(data=="OK"){
                    location.href = "/home";
                }else{
                    alert(data);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);

            },
        });
    });
});

/**
 * 发布任务
 */
window.onload = function addRelease() {
    var btn = document.getElementById("addReleaseTask");
    btn.onclick = function () {
        $("body").append("<div id='dlg_lost' style='padding:20px;'></div>");
        $('#dlg_lost').dialog({
            href:path+'/user/login.html',
            modal:true,
            closed:false,
            title:'信息发布',
            width:580,
            height:380,
            buttons:[{
                text:'提交',
                iconCls:'icon-ok',
                handler:function(){
                    $('#form_lost').form('submit',{
                        url:path+'/LostServlet',
                        onSubmit:function(){
                            return $(this).form('validate');
                        },
                        success:function(data){
                            if(data == "-1"){
                                $.messager.alert('系统消息','请登录后发布信息！','error');
                            }else{
                                $.messager.alert('系统消息','发布成功！','info',function(){
                                    $('#dlg_lost').dialog('refresh');
                                    $('#dlg_lost').dialog('close');
                                    location.href = path+'/users/lost_list.jsp';
                                },false);
                            }
                        }
                    });
                }
            },{
                text:'重置',
                iconCls:'icon-reload',
                handler:function(){
                    $('#dlg_lost').dialog('refresh');
                }
            }]
        });
    }



}




