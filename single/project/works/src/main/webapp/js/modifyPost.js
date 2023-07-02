function eventRegQuitBtn(){
	let btn = document.querySelector("#QuitToCafe");
	btn.addEventListener('click',quitToCafe_member);
}
function logCheck(){	
				let check=confirm('로그인이 필요한 메뉴입니다. 로그인 해주세요. 확인을 누르면 로그인 화면으로 이동합니다.');
				if(check) {location.href="cafe_pro_logIn.html"}
				else{window.history.go(-1)}
			}
function findTagOption(exTag){
	let tagBox = document.querySelectorAll("#extraTagValue");	
	for(let i=0; i<tagBox.length; i++){
		if(tagBox[i].value==exTag){
			console.log(tagBox[i].value);
			tagBox[i].setAttribute('selected','selected');
		}
	}
}
function findTableOption(subTag){
	let tagBox = document.querySelectorAll("#subTableTagValue");
	for(let i=0; i<tagBox.length; i++){
		if(tagBox[i].value==subTag){
			tagBox[i].setAttribute('selected','selected');
		}
	}
}
