package model;

import java.nio.ByteBuffer;

import convertor.SpmConvertorImpl;

public class MsgHeaderVO extends SpmConvertorImpl {
	
	private final byte[] stx = ByteBuffer.allocate(4).put(hexToByteArray("16161616")).array();
	private final byte[] srcAddr = CmdCodeVO.SPM;
	private final byte[] desAddr = CmdCodeVO.HOST;
	public byte[] cmd;
	private byte[] length = intToUnsigned(0, 4);
	private byte[] subData = intToUnsigned(0, 30);
	private final byte[] etx = ByteBuffer.allocate(1).put(hexToByteArray("F5")).array();
	public byte[] msgByteArr;
	
	
	public MsgHeaderVO( byte[] cmd, byte[] length,	byte[] subData) {
		super();
		this.cmd = cmd;
		this.length = length;
		this.subData = subData;
		
		int arrayLength = 
				( stx != null ? stx.length : 0 )
			+ (srcAddr != null ? srcAddr.length :0)
			+ (desAddr != null ? desAddr.length : 0)
			+ (this.cmd != null ? this.cmd.length : 0) 
			+  (this.length !=null ? this.length.length : 0)
			+ (this.subData !=null ? this.subData.length : 0)
			+ (etx !=null ? etx.length : 0);
		
		ByteBuffer bb = ByteBuffer.allocate(arrayLength);
		bb.clear();
		bb.put(stx);
		bb.put(srcAddr);
		bb.put(desAddr);
		bb.put(this.cmd);
		bb.put(intToUnsigned((subData.length),4));
		bb.put(this.subData);
		bb.put(etx);
		
		msgByteArr = bb.array();
		int temp  = msgByteArr.length;
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		byte[] byteArray = new byte[1024*2];
		buffer = ByteBuffer.allocate(temp);
		for(int i=0; i < temp; i++){
			buffer.put(msgByteArr[i]);
		}
		byteArray = buffer.array();
		
	}
	
	public byte[] convertorByteArray(){
		
		int arrayLength = 
				( stx != null ? stx.length : 0 )
			+ (srcAddr != null ? srcAddr.length :0)
			+ (desAddr != null ? desAddr.length : 0)
			+ (this.cmd != null ? this.cmd.length : 0) 
			+  (this.length !=null ? this.length.length : 0)
			+ (this.subData !=null ? this.subData.length : 0)
			+ (etx !=null ? etx.length : 0);
		
		ByteBuffer bb = ByteBuffer.allocate(arrayLength);
		bb.clear();
		bb.put(stx);
		bb.put(srcAddr);
		bb.put(desAddr);
		bb.put(this.cmd);
		bb.put(intToUnsigned((subData.length),4));
		bb.put(this.subData);
		bb.put(etx);
		
		msgByteArr = bb.array();
		int temp  = msgByteArr.length;
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		byte[] byteArray = new byte[1024*2];
		buffer = ByteBuffer.allocate(temp);
		for(int i=0; i < temp; i++){
			buffer.put(msgByteArr[i]);
		}
		return byteArray = buffer.array();
		//String resultMsg = commonConvertorImpl.byteArrayToHex(byteArray);
		
	}
	
}
