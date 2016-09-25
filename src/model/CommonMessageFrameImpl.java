package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import convertor.CommonConvertorImpl;

/**
 * <pre>
 * app.sdr.model
 * _CommonMessageFrameImpl.java
 * </pre>
 * 
 * Desc : 
 * @Company : METABUILD CO., LTD.
 * @Date 2016. 2. 3.
 * @Version : 1.0
 */
public class CommonMessageFrameImpl extends CommonConvertorImpl implements MessageFrame {
	
	public String stx;
	public String srcAddr;
	public String desAddr;
	public String cmd;
	public int length;
	public String subString;
	public String etx;
	public HashMap<String, double[]> fftData = new HashMap<String, double[]>();
	public String resultMsg;
	public ArrayList<Integer> subData = new ArrayList<Integer>();
	public HashMap<String, ArrayList<Double>> rxData;

	public CommonMessageFrameImpl(String resultMsg) {
		super();
		this.resultMsg = resultMsg;
	}
	
	public CommonMessageFrameImpl() {
		super();
	}
	
	@Override
	public String definedExeption(Exception e) {
		// TODO Auto-generated method stub
		String msg = ""+e;
		return msg;
	}
	
	@Override
	public int verification() {
		
		int stxIndex;
		stxIndex = resultMsg.indexOf("1616161600a0b");
		// 1. stx 확인
		if (stxIndex == -1) {
			return 1;
		}
		// 
		
		String subDataLength = resultMsg.substring(stxIndex+16, stxIndex+24);
		int subDataLengthVal = getInt(subDataLength);
		//logger.info("subDataLengthVal : " + subDataLengthVal);
		// 2. Msg 길이와 subLangth 길이 확인
		if (resultMsg.length() < subDataLengthVal*2 + stxIndex + 26){
			if (resultMsg.endsWith("f5")){
			}else{
				return 2;
			}
		}
		
		String frame = "";
		try {
			frame = resultMsg.substring(stxIndex, subDataLengthVal*2 + stxIndex+26);
		} catch (Exception e) {
			return 1;
			// TODO: handle exception
		}
		
		
		// 끝 길이 확인
		if (!frame.endsWith("f5")){
			return 3;
		}
		resultMsg = frame;
		this.stx = resultMsg.substring(0, 8);
		this.srcAddr = resultMsg.substring(8, 10);
		this.desAddr = resultMsg.substring(10, 12);
		this.cmd = resultMsg.substring(12, 16);
		this.length = subDataLengthVal;
		this.subString = resultMsg.substring(24, 24 + (subDataLengthVal*2));
		if(!(resultMsg.indexOf("f5") == -1)){
			this.etx = resultMsg.substring(resultMsg.indexOf("f5"), resultMsg.indexOf("f5")+2);
		}
		//logger.info("정상 길이  : " + resultMsg.length() + " / " + subDataLengthVal + " / " + subDataLength);
		return 0;
	}
	
	@Override
	public MessageFrame resultData() {
		return this;
	}
	
	@Override
	public byte[] getSendMsgFrame() {
		return null;
	}
}

