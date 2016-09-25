package model;

import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import convertor.ServerConvertor;

public class TxmModuleSetting extends ServerConvertor {
	
	Label txmInputFrequency, txmOutputFrequency, txmOutputGain, txmTransOptions;
	Label txmSwitchControlPreOffset, txmSwitchControlOnTime, txmSwitchControlOffTime;
	TextField txtTxmInputFrequency, txtTxmOutputFrequency, txtTxmOutputGain;
	TextField txtTxmSwitchControlPreOffset, txtTxmSwitchControlOnTime, txtTxmSwitchControlOffTime;
	Choice txtTxmTransOptions;
	
	public TxmModuleSetting() {
		
		txmInputFrequency = new Label("송신기 입력 주파수");
        txmOutputFrequency = new Label("송신기 출력 주파수");
        txmOutputGain = new Label("송신기 출력 이득");
        txmTransOptions = new Label("송신 출력");
        txmSwitchControlPreOffset = new Label("송신 스위치 제어(PreOffset)");
        txmSwitchControlOnTime = new Label("송신 스위치 제어(OnTime)");
        txmSwitchControlOffTime = new Label("송신 스위치 제어(OffTime)");
        
        txmInputFrequency.setBounds(900, 50, 150, 20);
        txmOutputFrequency.setBounds(900, 80, 150, 20);
        txmOutputGain.setBounds(900, 110, 150, 20);
        txmTransOptions.setBounds(900, 140, 150 , 20);
        txmSwitchControlPreOffset.setBounds(900, 170, 150, 20);
        txmSwitchControlOnTime.setBounds(900, 200, 150, 20);
        txmSwitchControlOffTime.setBounds(900, 230, 150, 20);
        int txmTxtWidth = 80;
        
        txtTxmInputFrequency =new TextField(20);
        txtTxmInputFrequency.setBounds(1100, 50, txmTxtWidth, 20);
        txtTxmOutputFrequency = new TextField(20);
        txtTxmOutputFrequency.setBounds(1100, 80, txmTxtWidth, 20);
        txtTxmOutputGain = new TextField(20);
        txtTxmOutputGain.setBounds(1100, 110, txmTxtWidth, 20);
        txtTxmTransOptions = new Choice();
        txtTxmTransOptions.add("On");
        txtTxmTransOptions.add("Off");
        txtTxmTransOptions.setBounds(1100, 140, txmTxtWidth, 20);
        txtTxmSwitchControlPreOffset =new TextField(20);
        txtTxmSwitchControlPreOffset.setBounds(1100, 170, txmTxtWidth, 20);
        txtTxmSwitchControlOnTime =new TextField(20);
        txtTxmSwitchControlOnTime.setBounds(1100, 200, txmTxtWidth, 20);
        txtTxmSwitchControlOffTime =new TextField(20);
        txtTxmSwitchControlOffTime.setBounds(1100, 230, txmTxtWidth, 20);
		
	}

	public Label getTxmInputFrequency() {
		return txmInputFrequency;
	}

	public Label getTxmOutputFrequency() {
		return txmOutputFrequency;
	}

	public Label getTxmOutputGain() {
		return txmOutputGain;
	}

	public Label getTxmTransOptions() {
		return txmTransOptions;
	}

	public Label getTxmSwitchControlPreOffset() {
		return txmSwitchControlPreOffset;
	}

	public Label getTxmSwitchControlOnTime() {
		return txmSwitchControlOnTime;
	}

	public Label getTxmSwitchControlOffTime() {
		return txmSwitchControlOffTime;
	}

	public TextField getTxtTxmInputFrequency() {
		return txtTxmInputFrequency;
	}

	public TextField getTxtTxmOutputFrequency() {
		return txtTxmOutputFrequency;
	}

	public TextField getTxtTxmOutputGain() {
		return txtTxmOutputGain;
	}

	public TextField getTxtTxmSwitchControlPreOffset() {
		return txtTxmSwitchControlPreOffset;
	}

	public TextField getTxtTxmSwitchControlOnTime() {
		return txtTxmSwitchControlOnTime;
	}

	public TextField getTxtTxmSwitchControlOffTime() {
		return txtTxmSwitchControlOffTime;
	}

	public Choice getTxtTxmTransOptions() {
		return txtTxmTransOptions;
	}
	
	public void settingsParam(String subString){
		int startIdx = 24;
		txtTxmInputFrequency.setText(getShort(subString.substring(startIdx, startIdx+4)));
		 // 출력 주파수
		txtTxmOutputFrequency.setText(getShort(subString.substring(startIdx+4, startIdx+8)));
		 // 출력 이득
		String txtTxmOutputGainTemp = byteToInt(subString.substring(startIdx+8, startIdx+10));
		int txmOutputGainInt = Integer.valueOf(txtTxmOutputGainTemp);
		if(txmOutputGainInt > 127){
			txmOutputGainInt -= 256;
		}
		txtTxmOutputGain.setText(String.valueOf(txmOutputGainInt));
		// 송신 출력
		txtTxmTransOptions.select(
				 Integer.valueOf(byteToInt(subString.substring(startIdx+10, startIdx+12))));
		//송신 스위치(Pre Offset)
		txtTxmSwitchControlPreOffset.setText(getInt(subString.substring(startIdx+12, startIdx+20)));
		//송신 스위치(On Time)
		txtTxmSwitchControlOnTime.setText(getInt(subString.substring(startIdx+20, startIdx+28)));
		// 송신 스위치(Off Time)
		txtTxmSwitchControlOffTime.setText(getInt(subString.substring(startIdx+28, startIdx+36)));
	}
	
}
