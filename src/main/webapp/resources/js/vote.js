var wsocket;
function connect() {
	wsocket = new WebSocket("ws://192.168.1.97:8080/StudentLink/vote/"+$_GET("nom"));
	wsocket.onmessage = onMessage;
}
function onMessage(evt) {
	var resp = JSON.parse(evt.data);
	traitement(resp);
}
function $_GET(param) {
	var vars = {};
	window.location.href.replace(location.hash, '').replace(
			/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
			function(m, key, value) { // callback
				vars[key] = value !== undefined ? value : '';
			});

	if (param) {
		return vars[param] ? vars[param] : null;
	}
	return vars;
}
window.addEventListener("load", connect, false);