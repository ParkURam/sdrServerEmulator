package convertor;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SpmConvertorImpl implements SpmConvertor{
	CommonConvertorImpl  cci = new CommonConvertorImpl ();
	@Override
	public byte[] intToUnsigned(int value, int length) {
		 String str = null;
		byte[] intToByte = new byte[4];
		if(length == 4){
			 intToByte[3] |= (byte)((value&0xFF000000)>>24);   
			 intToByte[2] |= (byte)((value&0xFF0000)>>16);   
			 intToByte[1] |= (byte)((value&0xFF00)>>8);   
			 intToByte[0] |= (byte)(value&0xFF);
			 str = cci.byteArrayToHex(intToByte);
		}else if(length == 2){
			intToByte = new byte[2];  
			intToByte[1] |= (byte)((value&0xFF00)>>8);   
			intToByte[0] |= (byte)(value&0xFF);
			str = cci.byteArrayToHex(intToByte);
		}else if(length == 1){
			intToByte = new byte[1];  
			intToByte[0] |= (byte)(value&0xFF);
			str = cci.byteArrayToHex(intToByte);
		}else{
			byte[] unsignedIntData =  ByteBuffer.allocate(length).put((byte) value).array();
			ByteBuffer bb = ByteBuffer.allocate(length);
			bb.order(ByteOrder.LITTLE_ENDIAN);
			bb.put(unsignedIntData);
			CommonConvertorImpl  cci = new CommonConvertorImpl();
			str = cci.byteArrayToHex(bb.array());
			return bb.array();
		}
		return intToByte;
	}

	@Override
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
	
}
