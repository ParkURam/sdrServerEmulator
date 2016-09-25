package model;

import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;

import convertor.ServerConvertor;

public class SpmModuleSetting extends ServerConvertor{
	Label waveForm, cwSwitch, bandWidth, pulseWidth, prf, ifSwitchPreoffsetTime, ifSwitchOnTime, upChirpTime, deChirptime; 
	Label spmBand;
	Choice txtCwSwitch, txtWaveForm;
	TextField txtBandWidth, txtPulseWidth, txtPrf, txtIfSwitchPreoffsetTime, txtIfSwitchOnTime;
	TextField txtUpChirpTime, txtDeChirptime;
	Choice choBand;
	
	public SpmModuleSetting() {
		waveForm = new Label("WaveForm(파형)");
        cwSwitch = new Label("CW On/Off");
        bandWidth = new Label("BandWidth");
        pulseWidth = new Label("PulseWidth");
        prf = new Label("PRF");
        ifSwitchPreoffsetTime = new Label("IF Switch Preoffset Time");
        ifSwitchOnTime= new Label("IF Switch OnTime");
        upChirpTime = new Label("Up-chirp Time");
        deChirptime = new Label("De-chirp Time");
        spmBand = new Label("밴드 설정");
        
        int ddsX = 1200;
        int ddsY = 50;
        
        waveForm.setBounds(ddsX, ddsY, 100, 20);
        cwSwitch.setBounds(ddsX, ddsY+30, 100, 20);
        bandWidth.setBounds(ddsX, ddsY+60, 100 , 20);
        pulseWidth.setBounds(ddsX, ddsY+90, 100, 20);
        prf.setBounds(ddsX, ddsY+120, 100, 20);
        ifSwitchPreoffsetTime.setBounds(ddsX, ddsY+150, 100, 20);
        ifSwitchOnTime.setBounds(ddsX, ddsY+180, 100, 20);
        upChirpTime.setBounds(ddsX, ddsY+210, 100, 20);
        deChirptime.setBounds(ddsX, ddsY+240, 100, 20);
        spmBand.setBounds(ddsX, ddsY+270, 100, 20);
       
        int ddsTxtX = 1330;
        int ddsTxtY = 50;
        int ddsTxtWidth = 80;
        
        txtWaveForm = new Choice();
        txtWaveForm.add("CW");
        txtWaveForm.add("Pulse");
        txtWaveForm.add("LFM");
        txtWaveForm.add("FMCW(삼각파)");
        txtWaveForm.add("FMCW(톱니파)");
        txtWaveForm.setBounds(ddsTxtX, ddsTxtY, ddsTxtWidth+50, 20);
        
        txtCwSwitch = new Choice();
        txtCwSwitch.add("On");
        txtCwSwitch.add("Off");
        txtCwSwitch.setBounds(ddsTxtX, ddsTxtY+30, ddsTxtWidth, 20);
       
        
        txtBandWidth =new TextField(20);
        txtBandWidth.setBounds(ddsTxtX, ddsTxtY+60, ddsTxtWidth, 20);
        txtPulseWidth =new TextField(20);
        txtPulseWidth.setBounds(ddsTxtX, ddsTxtY+90, ddsTxtWidth, 20);
        txtPrf =new TextField(20);
        txtPrf.setBounds(ddsTxtX, ddsTxtY+120, ddsTxtWidth, 20);
        txtIfSwitchPreoffsetTime =new TextField(20);
        txtIfSwitchPreoffsetTime.setBounds(ddsTxtX, ddsTxtY+150, ddsTxtWidth, 20);
        txtIfSwitchOnTime =new TextField(20);
        txtIfSwitchOnTime.setBounds(ddsTxtX, ddsTxtY+180, ddsTxtWidth, 20);
        txtUpChirpTime =new TextField(20);
        txtUpChirpTime.setBounds(ddsTxtX, ddsTxtY+210, ddsTxtWidth, 20);
        txtDeChirptime =new TextField(20);
        txtDeChirptime.setBounds(ddsTxtX, ddsTxtY+240, ddsTxtWidth, 20);
        
        choBand = new Choice();
        choBand.add("S밴드");
        choBand.add("X밴드");
        choBand.add("K밴드");
        choBand.setBounds(ddsTxtX, ddsTxtY+270, ddsTxtWidth, 20);
	}
	
	public void settingsParam(String subString){
		int startIdx = 24;
		txtWaveForm.select(
	    		 Integer.valueOf(byteToInt(subString.substring(startIdx, startIdx+2))));
		// CW 파형 On/Off
	    txtCwSwitch.select(
	    		 Integer.valueOf(byteToInt(subString.substring(startIdx+2, startIdx+4))));
		// Pulse Width
	    txtPulseWidth.setText(getInt(subString.substring(startIdx+4, startIdx+12)));
		// PRF
	    txtPrf.setText(getInt(subString.substring(startIdx+12, startIdx+20)));
		// Up-chirp Time
	    txtUpChirpTime.setText(getInt(subString.substring(startIdx+20, startIdx+28)));
		// De-chirp Time
	    txtDeChirptime.setText(getInt(subString.substring(startIdx+28, startIdx+36)));
		// IF SW PreOffset Time
	    txtIfSwitchPreoffsetTime.setText(getInt(subString.substring(startIdx+36, startIdx+44)));
		// IF SW On Time
	    txtIfSwitchOnTime.setText(getInt(subString.substring(startIdx+44, startIdx+52)));
		// Band Width
		txtBandWidth.setText(getShort(subString.substring(startIdx+52, startIdx+56)));
	}
	
	public void settingsBand(String subString){
		int startIdx = 24;
		choBand.select(
				 Integer.valueOf(byteToInt(subString.substring(startIdx, startIdx+2))));
	}

	public Label getWaveForm() {
		return waveForm;
	}

	public Label getCwSwitch() {
		return cwSwitch;
	}

	public Label getBandWidth() {
		return bandWidth;
	}

	public Label getPulseWidth() {
		return pulseWidth;
	}

	public Label getPrf() {
		return prf;
	}

	public Label getIfSwitchPreoffsetTime() {
		return ifSwitchPreoffsetTime;
	}

	public Label getIfSwitchOnTime() {
		return ifSwitchOnTime;
	}

	public Label getUpChirpTime() {
		return upChirpTime;
	}

	public Label getDeChirptime() {
		return deChirptime;
	}

	public Label getSpmBand() {
		return spmBand;
	}

	public Choice getTxtCwSwitch() {
		return txtCwSwitch;
	}

	public Choice getTxtWaveForm() {
		return txtWaveForm;
	}

	public TextField getTxtBandWidth() {
		return txtBandWidth;
	}

	public TextField getTxtPulseWidth() {
		return txtPulseWidth;
	}

	public TextField getTxtPrf() {
		return txtPrf;
	}

	public TextField getTxtIfSwitchPreoffsetTime() {
		return txtIfSwitchPreoffsetTime;
	}

	public TextField getTxtIfSwitchOnTime() {
		return txtIfSwitchOnTime;
	}

	public TextField getTxtUpChirpTime() {
		return txtUpChirpTime;
	}

	public TextField getTxtDeChirptime() {
		return txtDeChirptime;
	}

	public Choice getChoBand() {
		return choBand;
	}
	
}
