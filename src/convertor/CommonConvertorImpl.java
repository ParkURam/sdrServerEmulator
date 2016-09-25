package convertor;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import model.MessageFrame;

public class CommonConvertorImpl implements CommonConvertor{

	@Override
	public String byteArrayToHex(byte[] byteArray) {
		if (byteArray == null || byteArray.length == 0) {
	        return null;
	    }
	 
		StringBuilder sb = new StringBuilder();
	    for(final byte b: byteArray)
	        sb.append(String.format("%02x ", b&0xff));
	    
	    String a = sb.toString().trim();
	    a= a.replaceAll("\\s", "");
	    return a;
	    
	}
	
	@Override
	public int getSubDataLength(String subDataLength) {
		int subDataLengthVal = 0;
		Integer low = Integer.valueOf((subDataLength.substring(2, 4) + subDataLength.substring(0, 2)), 16);
		Integer high = Integer.valueOf((subDataLength.substring(6, 8) + subDataLength.substring(4, 6)), 16);
		
		subDataLengthVal = (low  + (high << 16)) & 0xFFFFFFFF;
		
	    return subDataLengthVal;
	}
	
	public short getChar(String hex){
		 byte[] byteHex = hexToByteArray(hex);
	     ByteBuffer bb = ByteBuffer.wrap(byteHex);
	     bb.order(ByteOrder.LITTLE_ENDIAN);
	     short result = 0;
	     while(bb.hasRemaining()){
	    	 char f = bb.getChar();
	    	 result += f;
	     }
	     return result;
	}
	
	public short getShort(String hex){
		 byte[] byteHex = hexToByteArray(hex);
	     ByteBuffer bb = ByteBuffer.wrap(byteHex);
	     bb.order(ByteOrder.LITTLE_ENDIAN);
	     short result = 0;
	     while(bb.hasRemaining()){
	    	 short f = bb.getShort();
	    	 result += f;
	     }
	     return result;
	}
	
	public int getInt(String hex){
		 byte[] byteHex = hexToByteArray(hex);
	     ByteBuffer bb = ByteBuffer.wrap(byteHex);
	     bb.order(ByteOrder.LITTLE_ENDIAN);
	     int result = 0;
	     while(bb.hasRemaining()){
	    	 float f = bb.getInt();
	    	 result += f;
	     }
	     return result;
	}
	
	public float getFloat(String hex){
		 byte[] byteHex = hexToByteArray(hex);
	     ByteBuffer bb = ByteBuffer.wrap(byteHex);
	     bb.order(ByteOrder.LITTLE_ENDIAN);
	     float result = 0;
	     while(bb.hasRemaining()){
	    	 float f = bb.getFloat();
	    	 result += f;
	     }
	     return result;
	}
	
	public byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() == 0) {
	        return null;
	    }
	    byte[] byteArray = new byte[hex.length() / 2];
	    for (int i = 0; i < byteArray.length; i++) {
	        byteArray[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	    }
	    return byteArray;
	}
	
	public byte[] convertIntUnsignedData(int value, int length) {
		 String str = null;
		byte[] intToByte = new byte[4];
		if(length == 4){
			 intToByte[3] |= (byte)((value&0xFF000000)>>24);   
			 intToByte[2] |= (byte)((value&0xFF0000)>>16);   
			 intToByte[1] |= (byte)((value&0xFF00)>>8);   
			 intToByte[0] |= (byte)(value&0xFF);
			 System.out.println("보낸 길이 :  " + str + " / " + getInt(str));
		}else if(length == 2){
			intToByte = new byte[2];  
			intToByte[1] |= (byte)((value&0xFF00)>>8);   
			intToByte[0] |= (byte)(value&0xFF);
			str = byteArrayToHex(intToByte);
		}else if(length == 1){
			intToByte = new byte[1];  
			intToByte[0] |= (byte)(value&0xFF);
			str = byteArrayToHex(intToByte);
		}else{
			byte[] unsignedIntData =  ByteBuffer.allocate(length).put((byte) value).array();
			ByteBuffer bb = ByteBuffer.allocate(length);
			bb.order(ByteOrder.LITTLE_ENDIAN);
			bb.put(unsignedIntData);
			CommonConvertorImpl  cci = new CommonConvertorImpl();
			str = byteArrayToHex(bb.array());
			return bb.array();
		}
		return intToByte;
	}

	@Override
	public void resultMessage(MessageFrame inputData) {
		// TODO Auto-generated method stub
		
	}
}
