// console.log("댓글 모듈입니다....");

var replyService = (function () {
/*
    console.log("모듈내 즉시실행 함수에 접근하였습니다..");
*/
    function add(reply, callback, error) {
        console.log("add 함수에 접근하였습니다.")
        $.ajax({
            type:'post',
            url: '/replies/new',
            data:JSON.stringify(reply),
            contentType : "application/json; charset=utf-8",
            success : function (result, status, xhr) {
                if(callback){
                    callback(result);
                }//if
            },//success
            error : function (xhr, status, er) {
                if(error){
                    error(er);
                }//if
            }//error
        })//ajax
    }//func add

    function getList(param, callback, error){
        var bno = param.bno;
        var page = param.page||1;

        $.getJSON("/replies/pages/"+bno+"/"+page+".json", function (data) {
            if (callback){
                callback(data);
            }//if
        }).fail(function (xht, status, err) {
            if (error){
                error();
            }//if
        })//getJSON
    }//func getList

    function remove(rno, callback, error){
        $.ajax({
            type: 'delete',
            url:'/replies/'+rno,
            success : function (deleteResult, status, xhr) {
                if(callback){
                    callback(deleteResult);
                }//if
            },//success
            error: function (xhr, status, er) {
                if(error){
                    error(er);
                }//if
            }//error

        })//$ajax
    }//func remove

    function update(reply, callback, error) {
        // console.log("reply.js //수정할 댓글 정보 아래에 출력 ");
        // console.log(reply);

        $.ajax({
            type:'put',
            url:'/replies/'+reply.rno,
            data: JSON.stringify(reply), // 넘겨줄 데이터 문자화
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr) {
                if(callback){
                    callback(result);
                }//if
            },//success
            error : function (xhr, status, er) {
                if(error){
                    error(er);
                }//if
            }//error
        })//$ajax
    }//func update

    function get(rno, callback, error) {
        $.get("/replies/"+rno+".json", function (result) {
            if(callback){
                callback(result);
            }//if
        }).fail(function (xhr, status, err) {
            if(error){
                error();
            }//if
        })//$get.fail
    }//get


    //날짜 포맷 UTC -> ISO 8601
    function timeFormat8601(timeValue) {
        var today = new Date();
        var gap = today.getTime() - timeValue;
        var dateObj = new Date(timeValue);
        var str = ""; //선언된 변수는 get.jsp에서 사용됩니다.

        if(gap < (1000 * 60 * 60 * 24)){
            var hour = dateObj.getHours();
            var min = dateObj.getMinutes();
            var sec = dateObj.getSeconds();

            return [(hour > 9 ? '' : '0') + hour, ':',
                (min > 9 ? '':'0') + min, ":",
                (sec > 9 ? '':'0') + sec].join("");
        }else{
            var year = dateObj.getFullYear();
            var month = dateObj.getMonth() + 1; //getMonth는 기본값이 0이므로 1을 더합니다.
            var day = dateObj.getDate();
            return [year,'/',
                (month > 9 ? '':'0') + month, '/',
                (day > 9 ? '' : '0') + day ].join('');
        }//if~else
    }//timeFormat8601


    return {//전자(get.jsp에서 호출되는 함수 이름) : 후자(JSON 으로 리턴 될 함수 이름)
        add:add,
        getList:getList,
        remove:remove,
        update:update,
        get:get,
        timeFormat8601:timeFormat8601
    };//return
    
})();//자체실행함수