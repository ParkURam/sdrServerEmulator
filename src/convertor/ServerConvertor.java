package convertor;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ServerConvertor {
	public String getInt(String hex){
		byte[] byteHex = hexToByteArray(hex);
		ByteBuffer bb = ByteBuffer.wrap(byteHex);
		bb.order(ByteOrder.LITTLE_ENDIAN);
		int result = 0;
		while(bb.hasRemaining()){
			float f = bb.getInt();
			result += f;
		}
		return String.valueOf(result);
	}

	public String byteToInt(String str){
		Integer lowData = Integer.parseInt(str, 16);
		Integer value = lowData & 0xFFFF;
		return value.toString();
	}

	public String getShort(String hex){
		byte[] byteHex = hexToByteArray(hex);
		ByteBuffer bb = ByteBuffer.wrap(byteHex);
		bb.order(ByteOrder.LITTLE_ENDIAN);
		short result = 0;
		while(bb.hasRemaining()){
			short f = bb.getShort();
			result += f;
		}

		return String.valueOf(result);
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
}
