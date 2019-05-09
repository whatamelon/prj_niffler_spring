package poly.dto;

public class NoticeDTO {

   private String post_seq_no; // 기본키, 순번
   private String title; // 제목
   private String contents; // 글 내용
   private String teacher; // 선생님 이름
   private String subject; // 과목
   private String spec_sub; // 세부과목
   private String usr_nickname; // 작성자 닉네임
   private String reg_usr_seq_no; // 등록자 아이디
   private String reg_dt; // 등록일
   private String chg_usr_seq_no; // 수정자 아이디
   private String chg_dt; // 수정일   
   private String usr_seq_no; // 등록자 시퀀스넘버
   private String like_no; // 좋아요수
   private String dislike_no; // 싫어요수
   private String city; // 도시 이름
   private String like_flag; // 좋아요잉가요

   public String getLike_flag() {
	return like_flag;
}

public void setLike_flag(String like_flag) {
	this.like_flag = like_flag;
}

public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContents() {
      return contents;
   }

   public void setContents(String contents) {
      this.contents = contents;
   }

   public String getReg_dt() {
      return reg_dt;
   }

   public void setReg_dt(String reg_dt) {
      this.reg_dt = reg_dt;
   }

   public String getChg_dt() {
      return chg_dt;
   }

   public void setChg_dt(String chg_dt) {
      this.chg_dt = chg_dt;
   }

public String getTeacher() {
	return teacher;
}

public void setTeacher(String teacher) {
	this.teacher = teacher;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public String getSpec_sub() {
	return spec_sub;
}

public void setSpec_sub(String spec_sub) {
	this.spec_sub = spec_sub;
}

public String getUsr_nickname() {
	return usr_nickname;
}

public void setUsr_nickname(String usr_nickname) {
	this.usr_nickname = usr_nickname;
}

public String getLike_no() {
	return like_no;
}

public void setLike_no(String like_no) {
	this.like_no = like_no;
}

public String getDislike_no() {
	return dislike_no;
}

public void setDislike_no(String dislike_no) {
	this.dislike_no = dislike_no;
}

public String getUsr_seq_no() {
	return usr_seq_no;
}

public void setUsr_seq_no(String usr_seq_no) {
	this.usr_seq_no = usr_seq_no;
}

public String getReg_usr_seq_no() {
	return reg_usr_seq_no;
}

public void setReg_usr_seq_no(String reg_usr_seq_no) {
	this.reg_usr_seq_no = reg_usr_seq_no;
}

public String getChg_usr_seq_no() {
	return chg_usr_seq_no;
}

public void setChg_usr_seq_no(String chg_usr_seq_no) {
	this.chg_usr_seq_no = chg_usr_seq_no;
}

public String getPost_seq_no() {
	return post_seq_no;
}

public void setPost_seq_no(String post_seq_no) {
	this.post_seq_no = post_seq_no;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}



}