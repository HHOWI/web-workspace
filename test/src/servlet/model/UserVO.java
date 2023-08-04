package servlet.model;

import java.util.Date;

public class UserVO {
	private String userId;
	private String userPwd;
	private String userName;
	private String userNickname;
	private int age;
	private char gender;
	private String place;
	private String phone;
	private String email;
	private String profileImg;
	private String statusMessage;
	private char lover;
	private String bloodType;
	private String mbti;
	private String birthday;
	private Date userSubscription;
	private int userLike;
	private char userAddmin;
	private char withdrawal;
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	public UserVO(String userId, String userPwd, String userName, String userNickname, int age, char gender,
			String place, String phone, String email, String profileImg, String statusMessage, char lover,
			String bloodType, String mbti, String birthday, Date userSubscription, int userLike, char userAddmin,
			char withdrawal) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNickname = userNickname;
		this.age = age;
		this.gender = gender;
		this.place = place;
		this.phone = phone;
		this.email = email;
		this.profileImg = profileImg;
		this.statusMessage = statusMessage;
		this.lover = lover;
		this.bloodType = bloodType;
		this.mbti = mbti;
		this.birthday = birthday;
		this.userSubscription = userSubscription;
		this.userLike = userLike;
		this.userAddmin = userAddmin;
		this.withdrawal = withdrawal;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public char getLover() {
		return lover;
	}
	public void setLover(char lover) {
		this.lover = lover;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Date getUserSubscription() {
		return userSubscription;
	}
	public void setUserSubscription(Date userSubscription) {
		this.userSubscription = userSubscription;
	}
	public int getUserLike() {
		return userLike;
	}
	public void setUserLike(int userLike) {
		this.userLike = userLike;
	}
	public char getUserAddmin() {
		return userAddmin;
	}
	public void setUserAddmin(char userAddmin) {
		this.userAddmin = userAddmin;
	}
	public char getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(char withdrawal) {
		this.withdrawal = withdrawal;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userNickname="
				+ userNickname + ", age=" + age + ", gender=" + gender + ", place=" + place + ", phone=" + phone
				+ ", email=" + email + ", profileImg=" + profileImg + ", statusMessage=" + statusMessage + ", lover="
				+ lover + ", bloodType=" + bloodType + ", mbti=" + mbti + ", birthday=" + birthday
				+ ", userSubscription=" + userSubscription + ", userLike=" + userLike + ", userAddmin=" + userAddmin
				+ ", withdrawal=" + withdrawal + "]";
	}
}
