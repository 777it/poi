$(function() {
    $(".level").change(function(){
    	var categoryValue = $(".category option:selected").val();
        var levelValue = $(".level option:selected").val();
        var value = categoryValue + "&" + levelValue;
       
        $.get(UrlConstant.Controller.Member.SEARCH ,function(data){
            $(".main").empty();
            for(var i=0;i<data.length;i++){
                $(".main").append('<div class="post" id="post-'+obj[i].no+'"><h2 class="entry-title">'+obj[i].title+'</h2><p>'+obj[i].body+'</p></div>');
            }
        });
    });
//		$.ajax(
//		    // リクエストメソッド
//		    type: 'get',
//		    // リクエストURL
//		    url: '/member/search-category/{selectVal}',
//		    // サーバに送信するデータ(name: value)
//		    data: selectVal,
//		    // レスポンスを受け取る際のMIMEタイプ(html,json,jsonp,text,xml,script)
//		    // レスポンスが適切なContentTypeを返していれば自動判別
//		    dataType: 'json',
//		    // Ajax通信前処理
//		    beforeSend: function(jqXHR) {
//		      // falseを返すと処理を中断
//		      return true;
//		    },
//		    // コールバックにthisで参照させる要素(DOMなど)
//		    context: domobject
//		  }).done(function(response, textStatus, jqXHR) {
//		    // 成功時処理
//			  alert("成功"); 
//			  alert(response); 
//		  }).fail(function(jqXHR, textStatus, errorThrown ) {
//			  alert("失敗"); 
//		    // 失敗時処理
//		  }).always(function(data_or_jqXHR, textStatus, jqXHR_or_errorThrown) {
//			  alert("always"); 
//		    // doneまたはfail実行後の共通処理
//		  });
//	});
});