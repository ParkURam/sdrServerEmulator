package model;

public interface MessageFrame {
	
	/**
	  * @Method Name : definedExeption
	  * @작성일 : 2016. 2. 3.
	  * @작성자 : 메타빌드
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param e
	  * @return
	  */
	String definedExeption(Exception e);
	/**
	  * @Method Name : resultData
	  * @작성일 : 2016. 2. 3.
	  * @작성자 : 메타빌드
	  * @변경이력 : 
	  * @Method 설명 : 수신 데이터 
	  * @return
	  */
	MessageFrame resultData();
	/**
	  * @Method Name : getSendMsgFrame
	  * @작성일 : 2016. 2. 3.
	  * @작성자 : 메타빌드
	  * @변경이력 : 
	  * @Method 설명 : 송신 메시지 프레임
	  * @return
	  */
	byte[] getSendMsgFrame();
	/**
	  * @Method Name : verification
	  * @작성일 : 2016. 2. 3.
	  * @작성자 : 메타빌드
	  * @변경이력 : 
	  * @Method 설명 : 수신 프레임 포맷 점검
	  * @return
	  */
	int verification();
	
}
