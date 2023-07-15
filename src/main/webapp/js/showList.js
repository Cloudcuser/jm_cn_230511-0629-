
function eventRegQuitBtn(){
	let btn = document.querySelector("#QuitToCafe");
	btn.addEventListener('click',quitToCafe_member);
}
function eventRegPageLimit(){
	let selectPos= document.getElementById("limitPostPrint").value;
	console.log("표시 수 변경:"+selectPos.value);
	callPagePos();
	changePageLimit(selectPos);
}



window.onload = eventRegPageLimit;

