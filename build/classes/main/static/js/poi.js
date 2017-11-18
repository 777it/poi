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
