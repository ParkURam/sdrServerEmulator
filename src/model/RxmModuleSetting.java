package model;

import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;

import convertor.ServerConvertor;

public class RxmModuleSetting extends ServerConvertor{
	Label rxmOutputFrequency, rxmInputFrequency, rxmOutputGain, rxmTransOptions, rxmAlcOptions, rxmReceptionBand;
	Label rxmSwitchControlPreOffset, rxmSwitchControlOnTime, rxmSwitchControlOffTime;
	Label rxmStcControlPreOffset, rxmStcControlOnTime, rxmStcControlOffTime;
	Label rxmAnstenaSwControll, rxmStcOptions;
	TextField txtRxmOutputFrequency, txtRxmInputFrequency, txtRxmOutputGain;
	TextField txtRxmSwitchControlPreOffset, txtRxmSwitchControlOnTime, txtRxmSwitchControlOffTime;
	TextField txtRxmStcControlPreOffset, txtRxmStcControlOnTime, txtRxmStcControlOffTime;
	Choice txtRxmTransOptions, txtRxmAlcOptions, txtRxmReceptionBand, txtRxmAnstenaSwControll, txtRxmStcOptions;
	
    public RxmModuleSetting() {
    	rxmOutputFrequency = new Label("수신기 출력 주파수");
        rxmInputFrequency = new Label("수신기 입력 주파수");
        rxmOutputGain = new Label("수신기 출력 이득");
        rxmTransOptions = new Label("수신 출력");
        rxmAlcOptions = new Label("ALC On/Off");
        rxmReceptionBand = new Label("수신부 수신 대역");
        
        rxmSwitchControlPreOffset = new Label("수신 스위치 제어(PreOffset)");
        rxmSwitchControlOnTime = new Label("수신 스위치 제어(OnTime)");
        rxmSwitchControlOffTime = new Label("수신 스위치 제어(OffTime)");
        
        rxmStcControlPreOffset = new Label("STC 제어(PreOffset)");
        rxmStcControlOnTime = new Label("STC 제어(OnTime)");
        rxmStcControlOffTime = new Label("STC 제어(OffTime)");
        
        rxmAnstenaSwControll = new Label("수신 안테나 SW 제어");
        rxmStcOptions = new Label("STC On/Off");
        
        rxmOutputFrequency.setBounds(900, 290, 150, 20);
        rxmInputFrequency.setBounds(900, 320, 150, 20);
        rxmOutputGain.setBounds(900, 350, 150, 20);
        rxmTransOptions.setBounds(900, 380, 150 , 20);
        rxmAlcOptions.setBounds(900, 410, 150, 20);
        rxmReceptionBand.setBounds(900, 440, 150, 20);
        
        rxmSwitchControlPreOffset.setBounds(900, 470, 150, 20);
        rxmSwitchControlOnTime.setBounds(900, 500, 150, 20);
        rxmSwitchControlOffTime.setBounds(900, 530, 150, 20);
        rxmStcControlPreOffset.setBounds(900, 560, 150 , 20);
        rxmStcControlOnTime.setBounds(900, 590, 150, 20);
        rxmStcControlOffTime.setBounds(900, 620, 150, 20);

        rxmAnstenaSwControll.setBounds(900, 650, 150, 20);
        rxmStcOptions.setBounds(900, 680, 150, 20);
        
        int rxmSettingX = 290;
        int rxmTxtWidth = 80;
        txtRxmOutputFrequency =new TextField(20);
        txtRxmOutputFrequency.setBounds(1100, rxmSettingX, rxmTxtWidth, 20);
        txtRxmInputFrequency =new TextField(20);
        txtRxmInputFrequency.setBounds(1100, rxmSettingX+30, rxmTxtWidth, 20);
        txtRxmOutputGain =new TextField(20);
        txtRxmOutputGain.setBounds(1100, rxmSettingX+60, rxmTxtWidth, 20);
        
        txtRxmTransOptions = new Choice();
        txtRxmTransOptions.add("On");
        txtRxmTransOptions.add("Off");
        txtRxmTransOptions.setBounds(1100, rxmSettingX+90, rxmTxtWidth, 20);
        
        txtRxmAlcOptions = new Choice();
        txtRxmAlcOptions.add("On");
        txtRxmAlcOptions.add("Off");
        txtRxmAlcOptions.setBounds(1100, rxmSettingX+120, rxmTxtWidth, 20);
        
        txtRxmReceptionBand = new Choice();
        txtRxmReceptionBand.add("Wide");
        txtRxmReceptionBand.add("Narrow");
        txtRxmReceptionBand.setBounds(1100, rxmSettingX+150, rxmTxtWidth, 20);
        
        txtRxmSwitchControlPreOffset =new TextField(20);
        txtRxmSwitchControlPreOffset.setBounds(1100, rxmSettingX+180, rxmTxtWidth, 20);
        txtRxmSwitchControlOnTime =new TextField(20);
        txtRxmSwitchControlOnTime.setBounds(1100, rxmSettingX+210, rxmTxtWidth, 20);
        txtRxmSwitchControlOffTime =new TextField(20);
        txtRxmSwitchControlOffTime.setBounds(1100, rxmSettingX+240, rxmTxtWidth, 20);
        txtRxmStcControlPreOffset =new TextField(20);
        txtRxmStcControlPreOffset.setBounds(1100, rxmSettingX+270, rxmTxtWidth, 20);
        txtRxmStcControlOnTime =new TextField(20);
        txtRxmStcControlOnTime.setBounds(1100, rxmSettingX+300, rxmTxtWidth, 20);
        txtRxmStcControlOffTime =new TextField(20);
        txtRxmStcControlOffTime.setBounds(1100, rxmSettingX+330, rxmTxtWidth, 20);
        
        txtRxmAnstenaSwControll = new Choice();
        txtRxmAnstenaSwControll.add("독립 2 안테나");
        txtRxmAnstenaSwControll.add("단일 안테나");
        txtRxmAnstenaSwControll.setBounds(1100, rxmSettingX+360, rxmTxtWidth+30, 20);
        
        txtRxmStcOptions = new Choice();
        txtRxmStcOptions.add("On");
        txtRxmStcOptions.add("Off");
        txtRxmStcOptions.setBounds(1100, rxmSettingX+390, rxmTxtWidth, 20);
	}
    
    public void settingsParam(String subString){
		int startIdx = 24;
		txtRxmOutputFrequency.setText(getShort(subString.substring(startIdx, startIdx+4)));
		 // 입력 주파수
		 txtRxmInputFrequency.setText(getShort(subString.substring(startIdx+4, startIdx+8)));
		 // 이득 설정
		 String txtRxmOutputGainTemp = byteToInt(subString.substring(startIdx+8, startIdx+10));
		 int rxmOutputGainInt = Integer.valueOf(txtRxmOutputGainTemp);
		 if(rxmOutputGainInt > 127){
			 rxmOutputGainInt -= 256;
		 }
		 txtRxmOutputGain.setText(String.valueOf(rxmOutputGainInt));
		 // 수신 출력 On/Off
		 txtRxmTransOptions.select(
				 Integer.valueOf(byteToInt(subString.substring(startIdx+10, startIdx+12))));
		 // ALC On/Off
		 txtRxmAlcOptions.select(
				 Integer.valueOf(byteToInt(subString.substring(startIdx+12, startIdx+14))));
		 // 수신부 수신 대역 
		 txtRxmReceptionBand.select(
				 Integer.valueOf(byteToInt(subString.substring(startIdx+14, startIdx+16))));
		 // 수신 스위치(Pre Offset)
		 txtRxmSwitchControlPreOffset.setText(getInt(subString.substring(startIdx+16, startIdx+24)));
		 // 수신 스위치(On Time)
		 txtRxmSwitchControlOnTime.setText(getInt(subString.substring(startIdx+24, startIdx+32)));
		 // 수신 스위치(Off Time)
		 txtRxmSwitchControlOffTime.setText(getInt(subString.substring(startIdx+32, startIdx+40)));
		 // STC 제어(Pre Offset)
		 txtRxmStcControlPreOffset.setText(getInt(subString.substring(startIdx+40, startIdx+48)));
		 // STC 제어(On Time)
		 txtRxmStcControlOnTime.setText(getInt(subString.substring(startIdx+48, startIdx+56)));
		 // STC 제어(Off Time)
		 txtRxmStcControlOffTime.setText(getInt(subString.substring(startIdx+56, startIdx+64)));
		 // 안테나 SW
		 txtRxmAnstenaSwControll.select(
				 Integer.valueOf(byteToInt(subString.substring(startIdx+64, startIdx+66))));
		 // STC On/Off
		 txtRxmStcOptions.select(
				 Integer.valueOf(byteToInt(subString.substring(startIdx+66, startIdx+68))));
	}
    
	
	public Label getRxmOutputFrequency() {
		return rxmOutputFrequency;
	}
	public Label getRxmInputFrequency() {
		return rxmInputFrequency;
	}
	public Label getRxmOutputGain() {
		return rxmOutputGain;
	}
	public Label getRxmTransOptions() {
		return rxmTransOptions;
	}
	public Label getRxmAlcOptions() {
		return rxmAlcOptions;
	}
	public Label getRxmReceptionBand() {
		return rxmReceptionBand;
	}
	public Label getRxmSwitchControlPreOffset() {
		return rxmSwitchControlPreOffset;
	}
	public Label getRxmSwitchControlOnTime() {
		return rxmSwitchControlOnTime;
	}
	public Label getRxmSwitchControlOffTime() {
		return rxmSwitchControlOffTime;
	}
	public Label getRxmStcControlPreOffset() {
		return rxmStcControlPreOffset;
	}
	public Label getRxmStcControlOnTime() {
		return rxmStcControlOnTime;
	}
	public Label getRxmStcControlOffTime() {
		return rxmStcControlOffTime;
	}
	public Label getRxmAnstenaSwControll() {
		return rxmAnstenaSwControll;
	}
	public Label getRxmStcOptions() {
		return rxmStcOptions;
	}
	public TextField getTxtRxmOutputFrequency() {
		return txtRxmOutputFrequency;
	}
	public TextField getTxtRxmInputFrequency() {
		return txtRxmInputFrequency;
	}
	public TextField getTxtRxmOutputGain() {
		return txtRxmOutputGain;
	}
	public TextField getTxtRxmSwitchControlPreOffset() {
		return txtRxmSwitchControlPreOffset;
	}
	public TextField getTxtRxmSwitchControlOnTime() {
		return txtRxmSwitchControlOnTime;
	}
	public TextField getTxtRxmSwitchControlOffTime() {
		return txtRxmSwitchControlOffTime;
	}
	public TextField getTxtRxmStcControlPreOffset() {
		return txtRxmStcControlPreOffset;
	}
	public TextField getTxtRxmStcControlOnTime() {
		return txtRxmStcControlOnTime;
	}
	public TextField getTxtRxmStcControlOffTime() {
		return txtRxmStcControlOffTime;
	}
	public Choice getTxtRxmTransOptions() {
		return txtRxmTransOptions;
	}
	public Choice getTxtRxmAlcOptions() {
		return txtRxmAlcOptions;
	}
	public Choice getTxtRxmReceptionBand() {
		return txtRxmReceptionBand;
	}
	public Choice getTxtRxmAnstenaSwControll() {
		return txtRxmAnstenaSwControll;
	}
	public Choice getTxtRxmStcOptions() {
		return txtRxmStcOptions;
	}

}
