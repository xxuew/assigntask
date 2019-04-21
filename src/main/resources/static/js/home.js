$(function(){
    window.onload=function() {
        var img1 = document.getElementById('img1');
        var img2 = document.getElementById('img2');
        var img3 = document.getElementById('img3');
        var img4 = document.getElementById('img4');
        var img5 = document.getElementById('img5');
        var img6 = document.getElementById('img6');
        var task1_name = $("#task1_name").text();
        var task2_name = $("#task2_name").text();
        var task3_name = $("#task3_name").text();
        var task4_name = $("#task4_name").text();
        var task5_name = $("#task5_name").text();
        var task6_name = $("#task6_name").text();

        if (task1_name == 0){

            img1.src = gray(img1);
        }
        if (task2_name == 0){
            img2.src = gray(img2);
        }
        if (task3_name == 0){
            img3.src = gray(img3);
        }
        if (task4_name == 0){
            img4.src = gray(img4);
        }
        if (task5_name == 0){
            img5.src = gray(img5);
        }
        if (task6_name == 0){
            img6.src = gray(img6);
        }
    }




    $("#task1").click(function () {

        // var task1_name = $("#task1_name").text();
        // console.log(task1_name);
        // if (task1_name > 0){
            location.href = "/comment?id=1";
        // }else{
        //     location.href = "/home";
        // }

    });

    $("#task2").click(function () {
        // var task2_name = $("#task2_name").text();
        // console.log(task2_name);
        // if (task2_name > 0){
            location.href = "/comment?id=2";
        // }else{
        //     location.href = "/home";
        // }

    });

    $("#task3").click(function () {
        // var task3_name = $("#task3_name").text();
        // console.log(task3_name);
        // if (task3_name > 0){
            location.href = "/comment?id=3";
        // }else{
        //     location.href = "/home";
        // }

    });

    $("#task4").click(function () {
        // var task4_name = $("#task4_name").text();
        // console.log(task4_name);
        // if (task4_name > 0){
            location.href = "/comment?id=4";
        // }else{
        //     location.href = "/home";
        // }

    });

    $("#task5").click(function () {
        // var task5_name = $("#task5_name").text();
        // console.log(task5_name);
        // if (task5_name > 0){
            location.href = "/comment?id=5";
        // }else{
        //     location.href = "/home";
        // }

    });

    $("#task6").click(function () {
        // var task6_name = $("#task6_name").text();
        // console.log(task6_name);
        // if (task6_name > 0){
            location.href = "/comment?id=6";
        // }else{
        //     location.href = "/home";
        // }

    });


    function gray(imgObj) {

        var canvas = document.createElement('canvas');
        var canvasContext = canvas.getContext('2d');
        var imgW = imgObj.width;
        var imgH = imgObj.height;
        canvas.width = imgW;
        canvas.height = imgH;
        console.log(imgObj.src);
        console.log(canvas.width);
        console.log(canvas.height);

        canvasContext.drawImage(imgObj, 0, 0);
        var imgPixels = canvasContext.getImageData(0, 0, imgW, imgH);
        console.log(canvasContext.getImageData(0, 0, 500, 500).data);

        for(var i = 0; i < imgPixels.data.length;i+=4){
            imgPixels.data[i] = imgPixels.data[i]/3;
            imgPixels.data[i+1] = imgPixels.data[i+1]/3;
            imgPixels.data[i+2] = imgPixels.data[i+2]/3;
            imgPixels.data[i+3] = imgPixels.data[i+3];
        }
        //put没有问题
        canvasContext.putImageData(imgPixels, 0, 0, 0, 0, imgPixels.width, imgPixels.height);
        return canvas.toDataURL();

    }


});