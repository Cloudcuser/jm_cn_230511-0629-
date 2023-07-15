create table cafememberInfo(
	id varchar(20) not null primary key,
	pw varchar(20) not null,
	nickname varchar(30) not null unique,
	hobby varchar(30) not null,
	regDate date default current_timestamp not null,
	lastComeDate timestamp current_timestamp not null,
	acntFindQuestion varchar(100),
	acntFindAnswer varchar(100),
	profile_image blob,
	isStaff set('none', 'manager', 'submanager', 'event', 'table', 'design') default 'none' not null
	visitCnt int()
	<!-- 1,2,4,8,16,32 -->
	--	freezeAcnt date 
	
);

create table menutableInfo(
	contentNo int auto_increment,
	writer varchar(30) not null,
	title varchar(50) not null,
	writtenDate timestamp default current_timestamp not null,
	texts varchar(200) not null,
	readCnt int default 0 not null,
	hitCnt int default 0,
	hitList varchar(50),
	comment int default 0,	
	isNoticeThisOrAll int default 0 not null,
	subTableTag varchar(40) not null,
	mainTableTag varchar(40),
	subNum int default 0,
	indentNum int default 0,
	extraTag varchar(20),
	table_id varchar(20) not null,
	isHit int default 0,
	groupNo int;
--	uploadedfile
)

create table cafeBasicInfo(
	infoNo int auto_increment primary key,
	cafeAddress varchar(50) not null,
    cafeName varchar(30) not null,
    managersNickname varchar(30) not null,
    isCafeOpen boolean not null default true,
    isConfirmSignMember boolean not null default false,
    cafeIntroduce varchar(100),
    isOpenMemberListInfo  boolean not null default false,
    cafeTheme varchar(30),
    cafeArea varchar(100),
    cafeWordForSearch varchar(40),
    cafeGrade varchar(20),
    visitedCafeCount int,
    editCafeInfoDate timestamp default current_timestamp 
					on update current_timestamp not null
);

create table commentBox(no int auto_increment primary key,
	tableNo int not null,
	comment_writer varchar(40) not null,
	commnet_image blob,
	comment_texts varchar(100) not null,
	comment_date timestamp default current_timestamp,
	comment_groupNo int not null default 0,
	comment_subNo int not null default 0,
	commnet_indentNo int not null default 0
);