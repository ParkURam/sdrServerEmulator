package convertor;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

public class CommonConvertorImplTest {

	@Test
	public void testByteArrayToHex() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSubDataLength() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShort() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFloat() {
		CommonConvertorImpl cci = new CommonConvertorImpl();
		Float value = new Float("10.32");
		byte[] array = new byte[4];
	       
        int intBits=Float.floatToIntBits(value);
        array[0]=(byte)((intBits&0x000000ff)>>0);
        array[1]=(byte)((intBits&0x0000ff00)>>8);
        array[2]=(byte)((intBits&0x00ff0000)>>16);
        array[3]=(byte)((intBits&0xff000000)>>24);
       
        String str = cci.byteArrayToHex(array);
        System.out.println(str);
		Float fVal = cci.getFloat("d7a3a241");
		System.out.println(fVal);
		
	}

	@Test
	public void testHexToByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertIntUnsignedData() {
		fail("Not yet implemented");
	}

	@Test
	public void testResultMessage() {
		fail("Not yet implemented");
	}

}
