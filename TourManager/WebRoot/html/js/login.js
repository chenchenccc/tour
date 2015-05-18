function getPath() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return projectName;
}

function login() {
	/*if ($("#login").form('validate') == false) {
		return;
	}*/
	$('#login').submit();

};
function cancel() {
	$('#login').form('clear');
};
