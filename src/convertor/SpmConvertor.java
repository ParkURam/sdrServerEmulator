package convertor;

public interface SpmConvertor {
	byte[] intToUnsigned(int value, int length );
	byte[] hexToByteArray(String hex);
}
