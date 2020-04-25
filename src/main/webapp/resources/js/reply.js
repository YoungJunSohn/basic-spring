console.log("댓글 모듈입니다....");

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
        console.log("reply.js //수정할 댓글 정보 아래에 출력 ");
        console.log(reply);

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

    return {
        add:add,//add 함수 호출,
        getList:getList,//getJson 함수 호출
        remove:remove,
        update:update,
        get:get
    };
})();