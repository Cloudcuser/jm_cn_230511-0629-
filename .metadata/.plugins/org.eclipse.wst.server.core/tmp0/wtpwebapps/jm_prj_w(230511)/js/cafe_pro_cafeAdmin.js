function header_windowPos(event, menu){
    if(menu=="main"){  
        let eventValue=event.target.value;
        let title=`카페 관리 - 메인 - ${eventValue}`;
        document.getElementById("admin_headerPos").innerText=title;
    }
    else if(menu=="infoConfig"){
        let eventValue=event.target.value;
        let title=`카페 관리 - 메인 - 카페 정보 편집 - ${eventValue}`;
        document.getElementById("admin_headerPos").innerText=title;
    }
    else if(menu=="editSub")
    {
        let eventValue=event.target.value;
        let title=`카페 관리 - 메인 - 게시판 편집 - ${eventValue}`;
        document.getElementById("admin_headerPos").innerText=title;
    }
    else if(menu=="memberSub"){
        let eventValue=event.target.value;
        let title=`카페 관리 - 메인 - 회원 관리 - ${eventValue}`;
        document.getElementById("admin_headerPos").innerText=title;
    }
    else if(menu=="staffSub"){
        let eventValue=event.target.value;
        let title=`카페 관리 - 메인 - 스태프 관리 - ${eventValue}`;
        document.getElementById("admin_headerPos").innerText=title;
    }
    else if(menu=="layoutSub"){
        let eventValue=event.target.value;
        let title=`카페 관리 - 메인 - 카페 메인 레이아웃 - ${eventValue}`;
        document.getElementById("admin_headerPos").innerText=title;
    }
    else if(menu=="eventConfigSub"){
        let eventValue=event.target.value;
        let title=`카페 관리 - 메인 - 이벤트 관리 - ${eventValue}`;
        document.getElementById("admin_headerPos").innerText=title;
    }
    else if(menu=="showPerformance"){
        let eventValue=event.target.value;
        let title=`카페 관리 - 메인 - 카페 활동 조회 - ${eventValue}`;
        document.getElementById("admin_headerPos").innerText=title;
    }
}
