package convertor;

import model.MessageFrame;

public interface CommonConvertor {
	String byteArrayToHex(byte[] byteArray);
	void resultMessage(MessageFrame inputData);
	int getSubDataLength(String subDataLength);
}
