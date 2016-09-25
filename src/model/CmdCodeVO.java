package model;

import convertor.SpmConvertorImpl;

public class CmdCodeVO {
	
	private static SpmConvertorImpl spmConvertorImpl = new SpmConvertorImpl();
	/**
	 * @hex  0xB101
	 * @context 신호처리기 상태 정보 요청 (HPC > SPM)
	 */
	public static final byte[] HOST = spmConvertorImpl.hexToByteArray("A0"); 
	
	/**
	 * @hex  0xB101
	 * @context 신호처리기 상태 정보 요청 (HPC > SPM)
	 */
	public static final byte[] SPM = spmConvertorImpl.hexToByteArray("00");   
	
	/**
	 * @hex  0xB101
	 * @context 신호처리기 상태 정보 요청 (HPC > SPM)
	 */
	public static final byte[] I_SEND_SPM_STATUS = spmConvertorImpl.hexToByteArray("B101");    

	/**
	 * @hex  0xB111
	 * @context 신호처리기 상태 정보 응답 (SPM > HPC)
	 */
	public static final byte[] I_RESP_ACK_SPM_STATUS = spmConvertorImpl.hexToByteArray("B111");  

	/**
	 * @hex  0x102
	 * @context 송신기 상태 정보 요청
	 */
	public static final byte[] I_SEND_TXM_STATUS = spmConvertorImpl.hexToByteArray("B102");
	//public static final byte[] I_SEND_TXM_STATUS = new BigInteger("0xB102", 16).toByteArray();  
	
	/**
	 * @hex  0xB112
	 * @context 송신기 상태 정보 응답
	 */
	public static final byte[] I_RESP_ACK_TXM_STATUS = spmConvertorImpl.hexToByteArray("B112");
	
	/** 
	 * @hex  0xB103
	 * @context 수신기 상태 정보 요청
	 */
	public static final byte[] I_SEND_RXM_STATUS = spmConvertorImpl.hexToByteArray("B103");
	
	/**
	 * @hex  0xB113
	 * @context 수신기 상태 정보 응답
	 */
	public static final byte[] I_RESP_ACK_RXM_STATUS = spmConvertorImpl.hexToByteArray("B113");
	
	/**
	 * @hex  0xB201
	 * @context 송신기 모듈 점검 요청
	 */
	public static final byte[] I_SEND_TXM_CHECK = spmConvertorImpl.hexToByteArray("B201");
	
	/**
	 * @hex  0xB211
	 * @context 송신기 모듈 점검 응답
	 */
	public static final byte[] I_RESP_TXM_CHECK = spmConvertorImpl.hexToByteArray("B211");
	
	/**
	 * @hex  0xB202
	 * @context 수신기 모듈 점검 요청
	 */
	public static final byte[] I_SEND_RXM_CHECK = spmConvertorImpl.hexToByteArray("B202");
	
	/**
	 * @hex  0xB212
	 * @context 수신기 모듈 점검 요청
	 */
	public static final byte[] I_RESP_RXM_CHECK = spmConvertorImpl.hexToByteArray("B212");
	
	/**
	 * @hex  0xB301
	 * @context 송신기 모듈 설정 요청
	 */
	public static final byte[] I_SEND_TXM_SET = spmConvertorImpl.hexToByteArray("B301");
	//ByteBuffer.allocate(2).put((byte)0xB301).array();
	
	/**
	 * @hex  0xB311
	 * @context 송신기 모듈 설정 응답
	 */
	public static final byte[] I_RESP_TXM_SET_OK = spmConvertorImpl.hexToByteArray("B311");
	
	/**
	 * @hex  0xB302
	 * @context 수신기 모듈 설정 요청
	 */
	public static final byte[] I_SEND_RXM_SET =spmConvertorImpl.hexToByteArray("B302");
	
	/**
	 * @hex  0xB312
	 * @context 수신기 모듈 설정 응답
	 */
	public static final byte[] I_RESP_RXM_SET_OK = spmConvertorImpl.hexToByteArray("B312");
	
	/**
	 * @hex  0xB303
	 * @context Reset 설정 요청
	 */
	public static final byte[] I_SEND_RESET_SET = spmConvertorImpl.hexToByteArray("B303");
	
	/**
	 * @hex  0xB313
	 * @context Reset 설정 응답
	 */
	public static final byte[] I_RESP_RESET_SET_OK =spmConvertorImpl.hexToByteArray("B313");
	
	/**
	 * @hex  0xB304
	 * @context 파형발생모듈 설정 요청
	 */
	public static final byte[] I_SEND_DDS_SET = spmConvertorImpl.hexToByteArray("B304");
	
	/**
	 * @hex  0xB314
	 * @context 파형발생모듈 설정 응답
	 */
	public static final byte[] I_RESP_DDS_SET_OK = spmConvertorImpl.hexToByteArray("B314");  
	
	/**
	 * @hex  0xB305
	 * @context lib 파라미터 설정 요청
	 */
	public static final byte[] I_SEND_LIB_PARAM_SET = spmConvertorImpl.hexToByteArray("B305");
	
	/**
	 * @hex  0xB315
	 * @context lib 파라미터 설정 응답
	 */
	public static final byte[] I_RESP_LIB_PARAM_SET_OK = spmConvertorImpl.hexToByteArray("B315");
	
	/**
	 * @hex  0xB306
	 * @context 자료 수집 설정 요청
	 */
	public static final byte[] I_SEND_MOD_SET =spmConvertorImpl.hexToByteArray("B306");
	
	/**
	 * @hex  0xB316
	 * @context 자료 수집 설정 응답
	 */
	public static final byte[] I_RESP_MOD_SET_OK =spmConvertorImpl.hexToByteArray("B316");
	
	/**
	 * @hex  0xB307
	 * @context 중간 단계 데이터 설정 요청
	 */
	public static final byte[] I_SEND_DAQ_SET =spmConvertorImpl.hexToByteArray("B307");
	
	/**
	 * @hex  0xB317
	 * @context 중간 단계 데이터 설정 응답
	 */
	public static final byte[] I_RESP_DAQ_SET_OK =  spmConvertorImpl.hexToByteArray("B317");
	
	/**
	 * @hex  0xB308
	 * @context 중간 단계 출력 데이터 요청
	 */
	public static final byte[] I_SEND_DETECT_SET =spmConvertorImpl.hexToByteArray("B308");
	
	/**
	 * @hex  0xB318
	 * @context 중간 단계 출력 데이터 요청
	 */
	public static final byte[] I_RESP_DETECT_SET_OK =spmConvertorImpl.hexToByteArray("B308");
	
	/**
	 * @hex  0xB309
	 * @context Calibration 설정 요청
	 */
	public static final byte[] I_SEND_CAL_SET = spmConvertorImpl.hexToByteArray("B309");
	
	/**
	 * @hex  0xB319
	 * @context Calibration 설정 응답 
	 */
	public static final byte[] I_RESP_CAL_SET_OK =spmConvertorImpl.hexToByteArray("B319");

	/**
	 * @hex  0xB401
	 * @context 시험 시작 요청  
	 */
	public static final byte[] I_SEND_RUN =spmConvertorImpl.hexToByteArray("B401");
	
	/**
	 * @hex  0xB411
	 * @context 시험 시작 요청 응답
	 */
	public static final byte[] I_RESP_RUN_OK =spmConvertorImpl.hexToByteArray("B411");
	
	/**
	 * @hex  0xB402
	 * @context 시험 정지 요청
	 */
	public static final byte[] I_SEND_STOP = spmConvertorImpl.hexToByteArray("B402");
	
	/**
	 * @hex  0xB412
	 * @context 시험 정지 요청 응답
	 */
	public static final byte[] I_RESP_STOP_OK = spmConvertorImpl.hexToByteArray("B412");
	
	/**
	 * @hex  0xB413
	 * @context 중간 단계 출력 데이터 응답
	 */
	public static final byte[] I_RESP_OPER_SET_OK = spmConvertorImpl.hexToByteArray("B413");
	
	/**
	 * @hex  0xB404
	 * @context 검지 데이터 요청 
	 */
	public static final byte[] I_SEND_DET_DATA_OK = spmConvertorImpl.hexToByteArray("B404");
	
	/**
	 * @hex  0xB414
	 * @context 검지 데이터 전송 
	 */
	public static final byte[] I_RESP_DET_DATA_OK = spmConvertorImpl.hexToByteArray("B414");
	
	/**
	 * @hex  0xB405
	 * @context I,Q 데이터 전송 
	 */
	public static final byte[] I_SEND_IQ_DATA_OK = spmConvertorImpl.hexToByteArray("B405");
	
	/**
	 * @hex  0xB415
	 * @context I,Q 데이터 전송 
	 */
	public static final byte[] I_RESP_IQ_DATA_OK = spmConvertorImpl.hexToByteArray("B415");
	
	/**
	 * @hex  0xB406
	 * @context 주파수 테이블 요청 
	 */
	public static final byte[] I_SEND_FREQ_DATA_OK = spmConvertorImpl.hexToByteArray("B406");
	
	/**
	 * @hex  0xB416
	 * @context 주파수 테이블 데이터 전송 
	 */
	public static final byte[] I_RESP_FREQ_DATA_OK = spmConvertorImpl.hexToByteArray("B416");	
	
	/**
	 * @hex  0xB407
	 * @context 밴드 설정 요청
	 */
	public static final byte[] I_SEND_SET_BAND = spmConvertorImpl.hexToByteArray("B407");
	
	
	/**
	 * @hex  0xB417
	 * @context 밴드 설정
	 */
	public static final byte[] I_RESP_SET_BAND_OK = spmConvertorImpl.hexToByteArray("B417");
	
	/**
	 * @hex  0xB408
	 * @context GVDS 데이터 요청 
	 */
	public static final byte[] I_SEND_GVDS_DATA = spmConvertorImpl.hexToByteArray("B408");
	
	
	/**
	 * @hex  0xB418
	 * @context GVDS 데이터 전송
	 */
	public static final byte[] I_RESP_GVDS_DATA = spmConvertorImpl.hexToByteArray("B418");

	/**
	 * @hex  0xB409
	 * @context GVDS 데이터 요청 
	 */
	public static final byte[] I_SEND_AVDS_DATA = spmConvertorImpl.hexToByteArray("B409");
	
	
	/**
	 * @hex  0xB419
	 * @context GVDS 데이터 전송
	 */
	public static final byte[] I_RESP_AVDS_DATA = spmConvertorImpl.hexToByteArray("B419");

}
