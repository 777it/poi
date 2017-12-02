function confirmDelete ( obj ) {
    if(!confirm('Do you really want to delete this?')){
        /* キャンセルの時の処理 */
        return false;
    }else{
    	/* OKの時の処理 */
    	var deleteUrl = obj.getAttribute('name');
    	location.href =　deleteUrl;
    }
}
function confirmLogout ( obj ) {
    if(!confirm('Do you really want to log out?')){
        /* キャンセルの時の処理 */
        return false;
    }else{
    	/* OKの時の処理 */
    	var logoutUrl = obj.getAttribute('name');
    	location.href =　logoutUrl;
    }	
}
function selectArticle ( obj ) {
	var formname = obj.getAttribute('name');
	document.forms[formname].submit();
}

function addCategory(obj){
	// 入力ダイアログを表示
	newCategory = window.prompt("Please enter category", "");
	if (newCategory != "" && newCategory != null) {
		$(".category").append("<option>" + newCategory + "</option>");
	}
	else{
        /* キャンセルの時の処理 */
        return false;
	}
}
function picSize(){
	var size = {
			  isSp: function() {
			    return $('#js-check-sp').is(':visible');
			  },
			  isTablet: function() {
			    return $('#js-check-tablet').is(':visible');
			  },
			  isPc: function() {
			    return $('#js-check-pc').is(':visible');
			  },
			};
			console.log('sp: ' + size.isSp());
			console.log('tablet: ' + size.isTablet());
			console.log('pc: ' + size.isPc());
  };
  
//変数textareaがtextarea要素のjQueryオブジェクト。
//変数targetがtextarea内の要素を設定する要素のjQueryオブジェクト。
 txtarea.change(function() {
   var txt = txtarea.val(); // textareaの値
   target.contents().remove();
 
   // まず改行らしき文字を\nに統一。\r、\r\n → \n
   txt = txt.replace(/\r\n/g, '\n');
   txt = txt.replace(/\r/g, '\n');
 
   // 改行を区切りにして入力されたテキストを分割して配列に保存する。
   var lines = txt.split('\n');
 
   // 配列中の各テキストからテキストノードを生成して、<br />を挟みながら、元の要素に追加する。
   for (var i = 0; i < lines.length; i++) {
     if (0 < i) {
       target.append('<br />');
     };
     target.append(document.createTextNode(lines[i]));  // ここで特殊な文字は実体参照に置き換わる。
   };
 });