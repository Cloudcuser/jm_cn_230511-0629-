function eventRegQuitBtn(){
	let btn = document.querySelector("#QuitToCafe");
	btn.addEventListener('click',quitToCafe_member);
}
function eventRegTableMenuBtn(){
	let btns = document.querySelectorAll('.tableMenuBtn');
	for(let i=0; i<btns.length; i++){
		btns[i].addEventListener('click',function(){
			let kind = btns[i].parentNode.getAttribute('value');
			moveKindTable(kind);
		})
	}
}


function eventRegPageLimit(){
	let selectPos= document.getElementById("limitPostPrint").value;
	console.log("표시 수 변경:"+selectPos.value);
	callPagePos();
	changePageLimit(selectPos);
}

function eventRegPageBtn(){
	let btn = document.querySelectorAll("#movePageBtn");
	for(let i=0; i<btn.length; i++){
		btn[i].addEventListener("click", function(){
		console.log(btn[i].value);
		movePageExcute(btn[i].value);
		})
	}
}
window.onload=eventRegTableMenuBtn;
window.onload=eventRegQuitBtn;

window.onload = eventRegPageLimit;
window.onload = eventRegPageBtn;