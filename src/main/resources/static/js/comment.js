window.onload = function (){
    var windowWidth = document.body.clientWidth; //window 宽度;
    var wrap = document.getElementById('wrap');
    var tabClick = wrap.querySelectorAll('.tabClick')[0];
    var tabLi = tabClick.getElementsByTagName('li');

    var tabBox =  wrap.querySelectorAll('.tabBox')[0];
    var tabList = tabBox.querySelectorAll('.tabList');

    var lineBorder = wrap.querySelectorAll('.lineBorder')[0];
    var lineDiv = lineBorder.querySelectorAll('.lineDiv')[0];

    var tar = 0;
    var endX = 0;
    var dist = 0;

    tabBox.style.overflow='hidden';
    tabBox.style.position='relative';
    tabBox.style.width=windowWidth*tabList.length+"px";

    for(var i = 0 ;i<tabLi.length; i++ ){
        tabList[i].style.width=windowWidth+"px";
        tabList[i].style.float='left';
        tabList[i].style.float='left';
        tabList[i].style.padding='0';
        tabList[i].style.margin='0';
        tabList[i].style.verticalAlign='top';
        tabList[i].style.display='table-cell';
    }

    for(var i = 0 ;i<tabLi.length; i++ ){
        tabLi[i].start = i;
        tabLi[i].onclick = function(){
            var star = this.start;
            for(var i = 0 ;i<tabLi.length; i++ ){
                tabLi[i].className='';
            };
            tabLi[star].className='active';
            init.lineAnme(lineDiv,windowWidth/tabLi.length*star)
            init.translate(tabBox,windowWidth,star);
            endX= -star*windowWidth;
        }
    }

    function OnTab(star){
        if(star<0){
            star=0;
        }else if(star>=tabLi.length){
            star=tabLi.length-1
        }
        for(var i = 0 ;i<tabLi.length; i++ ){
            tabLi[i].className='';
        };

        tabLi[star].className='active';
        init.translate(tabBox,windowWidth,star);
        endX= -star*windowWidth;
    };

    tabBox.addEventListener('touchstart',chstart,false);
    tabBox.addEventListener('touchmove',chmove,false);
    tabBox.addEventListener('touchend',chend,false);
    //按下
    function chstart(ev){
        ev.preventDefault;
        var touch = ev.touches[0];
        tar=touch.pageX;
        tabBox.style.webkitTransition='all 0s ease-in-out';
        tabBox.style.transition='all 0s ease-in-out';
    };
    //滑动
    function chmove(ev){
        var stars = wrap.querySelector('.active').start;
        ev.preventDefault;
        var touch = ev.touches[0];
        var distance = touch.pageX-tar;
        dist = distance;
        init.touchs(tabBox,windowWidth,tar,distance,endX);
        init.lineAnme(lineDiv,-dist/tabLi.length-endX/4);
    };
    //离开
    function chend(ev){
        var str= tabBox.style.transform;
        var strs = JSON.stringify(str.split(",",1));
        endX = Number(strs.substr(14,strs.length-18));

        if(endX>0){
            init.back(tabBox,windowWidth,tar,0,0,0.3);
            endX=0
        }else if(endX<-windowWidth*tabList.length+windowWidth){
            endX=-windowWidth*tabList.length+windowWidth
            init.back(tabBox,windowWidth,tar,0,endX,0.3);
        }else if(dist<-windowWidth/3){
            OnTab(tabClick.querySelector('.active').start+1);
            init.back(tabBox,windowWidth,tar,0,endX,0.3);
        }else if(dist>windowWidth/3){
            OnTab(tabClick.querySelector('.active').start-1);
        }else{
            OnTab(tabClick.querySelector('.active').start);
        }
        var stars = wrap.querySelector('.active').start;
        init.lineAnme(lineDiv,stars*windowWidth/4);

    };
//    --------------------

};


var init={
    translate:function(obj,windowWidth,star){
        obj.style.webkitTransform='translate3d('+-star*windowWidth+'px,0,0)';
        obj.style.transform='translate3d('+-star*windowWidth+',0,0)px';
        obj.style.webkitTransition='all 0.3s ease-in-out';
        obj.style.transition='all 0.3s ease-in-out';
    },
    touchs:function(obj,windowWidth,tar,distance,endX){
        obj.style.webkitTransform='translate3d('+(distance+endX)+'px,0,0)';
        obj.style.transform='translate3d('+(distance+endX)+',0,0)px';
    },
    lineAnme:function(obj,stance){
        obj.style.webkitTransform='translate3d('+stance+'px,0,0)';
        obj.style.transform='translate3d('+stance+'px,0,0)';
        obj.style.webkitTransition='all 0.1s ease-in-out';
        obj.style.transition='all 0.1s ease-in-out';
    },
    back:function(obj,windowWidth,tar,distance,endX,time){
        obj.style.webkitTransform='translate3d('+(distance+endX)+'px,0,0)';
        obj.style.transform='translate3d('+(distance+endX)+',0,0)px';
        obj.style.webkitTransition='all '+time+'s ease-in-out';
        obj.style.transition='all '+time+'s ease-in-out';
    },

}

$(function () {
    $.ajax({
        type:"get",
        url:"/loginInfo",
        traditional: true,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType:"json",
        success:function (userInfo) {
            var data = {
                userid:userInfo.userid,
                queryString:location.search
            }
            console.log(userInfo);
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
                        $(inputnameid).append(input.inputname);

                        var inputdesid = "#"+"inputdes"+count;
                        $(inputdesid).append(input.inputdes);

                        var nameid_a = "#"+"subtaskname"+count+"_a";
                        $(nameid_a).append(subtask.itemname1);

                        var desid_a = "#"+"subtaskdes"+count+"_a";
                        $(desid_a).append(subtask.itemdes1);

                        var nameid_b = "#"+"subtaskname"+count+"_b";
                        $(nameid_b).append(subtask.itemname2);

                        var desid_b = "#"+"subtaskdes"+count+"_b";
                        $(desid_b).append(subtask.itemdes2);
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
    })
})

//js方法：序列化表单
function serializeForm(form){
    var obj = {};
    $.each(form.serializeArray(),function(index){
        if(obj[this['name']]){
            obj[this['name']] = obj[this['name']] + ','+this['value'];
        } else {
            obj[this['name']] =this['value'];
        }
    });
    return obj;
}

function insertCommentRes(){

        var formData = $("#comment_form").serializeArray();


        var formName=new Array();
        var formValue=new Array();
        for(var i=0;i<formData.length;i++){
            console.log(formData[i]);
            console.log(formData[i].name);
            formName[i]=formData[i].name;
            formValue[i]=formData[i].value;
        }
        var tranData = {
            formNames:formName,
            formValues:formValue,
            queryString:location.search
        };
    console.log(tranData);
       $.ajax({
           type:"post",
           url:"/comment_result",
           contentType: "application/x-www-form-urlencoded; charset=UTF-8",
           traditional:true,
           dataType:"text",
           data:tranData,
           success:function (data) {
               console.log(data);
               if (data == "OK"){
                   alert("提交成功");
                   location.href = "/myreceivedtask";
               }
               else alert(data);
           },
           error:function (XMLHttpRequest, textStatus, errorThrown) {
               console.log("任务完成提交失败");
               console.log(XMLHttpRequest.status);
               console.log(XMLHttpRequest.readyState);
               console.log(textStatus);

           }
       })


    // var data = {
    //     queryString:location.search
    // };
    // console.log("queryString"+data);


    // $.ajax({
    //     url:"/comment_result",
    //     type:"post",
    //     dataType: "text",
    //     contentType: "application/x-www-form-urlencoded; charset=UTF-8",
    //     data: data,


}
