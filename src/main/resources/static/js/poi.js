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
	category = window.prompt("Please enter category", "");
	if (category != "" && category != null) {
		var addCategoryUrl = obj.getAttribute('name');
		location.href =　addCategoryUrl + "/" + category;		
	}
	else{
        /* キャンセルの時の処理 */
        return false;
	}

}