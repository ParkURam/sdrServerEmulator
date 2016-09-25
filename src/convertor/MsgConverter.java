package convertor;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

public class MsgConverter {
	
	// unsigned 를 int 로
	public int convertUnsignedIntData(byte bytes){
		int unsignedIntData = (int)bytes & 0xFF;
		
		return unsignedIntData;
	}
	// int 를 unsigned byte 로	
	public static byte[] convertIntUnsignedData(int value, int length ){
		byte[] unsignedIntData =  ByteBuffer.allocate(length).put((byte) value).array();
		
		return unsignedIntData;
	}
	
	public static byte[] hexToByteArray(String hex) {
	    if (hex == null || hex.length() == 0) {
	        return null;
	    }
	 
	    byte[] ba = new byte[hex.length() / 2];
	    for (int i = 0; i < ba.length; i++) {
	        ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	    }
	    return ba;
	}
	 
	// byte[] to hex
	public static String byteArrayToHex(byte[] ba) {
	    if (ba == null || ba.length == 0) {
	        return null;
	    }
	 
	    StringBuffer sb = new StringBuffer(ba.length * 2);
	    String hexNumber;
	    for (int x = 0; x < ba.length; x++) {
	        hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
	        sb.append(hexNumber.substring(hexNumber.length() - 2));
	    }
	    
	    //System.out.println("MSG convorter 변환 후 : " + ArrayUtils.toString(sb) );
	    return ArrayUtils.toString(sb); 
	} 
	
	// hex to double
	public static int parseUnsignedHex(String inputHex) {
		Integer outputDecimal = Integer.parseInt(inputHex, 16);
        return outputDecimal;
    }
	
	// rx 변환 데이터 메소드
	public static  ArrayList<String> parseRxDataArray(String resultMsg) {
		 ArrayList<String> arr = new ArrayList<String>();
		 String result = null;
		 int i = 0;
		try {
			for(i=12; i < resultMsg.length()-1; i+=4){
				Integer low = Integer.parseInt(resultMsg.substring(i, i+2), 16);
				Integer high = Integer.parseInt(resultMsg.substring(i+2, i+4), 16);
				
				
//				int value = (low << 8 + high) & 0xFFFF;
				int value = (low + high) & 0xFFFF;
				
				//result = resultMsg.substring(i, i+3);
				//Integer outputDecimal = Integer.parseInt(result, 16);
				arr.add(String.valueOf(value));
			}
			
		} catch (StringIndexOutOfBoundsException e) {
			result = resultMsg.substring(i, resultMsg.length());
			Integer outputDecimal = Integer.parseInt(result, 16);
			arr.add(outputDecimal.toString());
		}
		return arr;
    }
	
	// 공통 응답 데이터
	public static  ArrayList<String> parseDataArray(String resultMsg) {
		ArrayList<String> subData = new ArrayList<String>();
		String con = resultMsg.substring(16, 24);
		
		// indexData => sub_data 길이  (value) Byte  => String 으로 가져올 때는 *2
		int indexData = (Integer.parseInt(con.substring(0, 2), 16)
				+ Integer.parseInt(con.substring(2, 4), 16)) & 0xFFFF;
		
		String subDataString = resultMsg.substring(24, 24+ indexData*2);
		int i = 0;
		
		try {
			for(i=0; i < subDataString.length()-1; i+=2){
				Integer lowData = Integer.parseInt(subDataString.substring(i, i+2), 16);
				int value = (lowData) & 0xFFFF;
				subData.add(String.valueOf(value));
			}
			
		} catch (StringIndexOutOfBoundsException e) {
			Integer outputDecimal = Integer.parseInt(resultMsg.substring(i, subDataString.length()), 16);
			subData.add(outputDecimal.toString());
		}

		return subData;
   }
	
}
