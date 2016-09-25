package model;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import convertor.ServerConvertor;

public class LibrarySetting extends ServerConvertor{
	
	JLabel lblLibStatus;

	Checkbox lib1, lib2, lib3, lib4, lib5, lib6;
	Checkbox lib1On, lib1Off, lib2On, lib2Off, lib3On, lib3Off, lib4On, lib4Off;
	Checkbox lib5On, lib5Off, lib6On, lib6Off;
	
	Label lbl2Pulse, lbl2Window, lbl2Betha; 
	Label lbl3Cfar, lbl3GuardCell, lbl3ReferenceCell, lbl3Alpha;
	Label lbl4MaxDoppler, lbl4Doppler, lbl4Fft;
	Label lbl5Mti;
	Label lbl6Prf, lbl6DetectTime, lbl6Speed;
	
	TextField txtWindow, txtBetha, txtCfar, txtGuardCell, txtRefereneCell, txtAlpha; 
	TextField txtMaxDoppler, txtDoppler, txtFft, txtMti, txtPrf, txtDetectTime, txtSpeed; 
	
	Choice txtPulse;

	public LibrarySetting() {
		lblLibStatus = new JLabel();
		lblLibStatus.setBorder(BorderFactory.createTitledBorder("라이브러리 설정"));
		lblLibStatus.setBounds(20, 570, 830, 450);
		
		lib1 = new Checkbox("도플러 처리 라이브러리");
		lib2 = new Checkbox("펄스 압축 라이브러리");
		lib3 = new Checkbox("표적 탐지 라이브러리");
		lib4 = new Checkbox("도플러 필터 뱅크 라이브러리");
		lib5 = new Checkbox("클러터 제거 라이브러리");
		lib6 = new Checkbox("거리 도플러 라이브러리");
		
		txtPulse = new Choice();
		txtPulse.add("On");
		txtPulse.add("Off");
	    
		txtWindow = new TextField(10);
		txtBetha = new TextField(10);
		txtCfar = new TextField(10);
		txtGuardCell = new TextField(10);
		txtRefereneCell = new TextField(10);
		txtAlpha = new TextField(10);
		txtMaxDoppler = new TextField(10);
		txtDoppler = new TextField(10);
		txtFft = new TextField(10);
		txtMti = new TextField(10);
		txtPrf = new TextField(10);
		txtDetectTime = new TextField(10);
		txtSpeed = new TextField(10);
		
		int tempY = 30;
		
		lib1.setBounds(10, tempY, 180, 20);
		lib2.setBounds(10, tempY*2, 180, 20);
		lib3.setBounds(10, tempY*4, 180, 20);
		lib4.setBounds(10, tempY*6, 180, 20);
		lib5.setBounds(10, tempY*8, 180, 20);
		lib6.setBounds(10, tempY*10, 180, 20);
        
		lblLibStatus.add(lib1);
		lblLibStatus.add(lib2);
		lblLibStatus.add(lib3);
		lblLibStatus.add(lib4);
		lblLibStatus.add(lib5);
		lblLibStatus.add(lib6);
		
		lbl2Pulse = new Label("펄스 압축 : ");
		lbl2Window = new Label("Window : ");
		lbl2Betha = new Label("Betha : ");
		lbl3Cfar = new Label("CFAR : ");
		lbl3GuardCell = new Label("Number of GuardCell : ");
		lbl3ReferenceCell = new Label("Number of Ref Cell : ");
		lbl3Alpha = new Label("Alpha : ");
		lbl4MaxDoppler = new Label("Max. Doppler 주파수(Hz) : ");
		lbl4Doppler = new Label("도플러 해상도(Hz) : ");
		lbl4Fft = new Label("FFT Size : ");
		lbl5Mti = new Label("MTI Recursive Filter : ");
		lbl6Prf = new Label("PRF(MHz) : ");
		lbl6DetectTime = new Label("관측시간(초) : ");
		lbl6Speed = new Label("속도(Hz) : ");

		lblLibStatus.add(lbl2Pulse);
		lblLibStatus.add(lbl2Window);
		lblLibStatus.add(lbl2Betha);
		lblLibStatus.add(lbl3Cfar);
		lblLibStatus.add(lbl3GuardCell);
		lblLibStatus.add(lbl3ReferenceCell);
		lblLibStatus.add(lbl3Alpha);
		lblLibStatus.add(lbl4MaxDoppler);
		lblLibStatus.add(lbl4Doppler);
		lblLibStatus.add(lbl4Fft);
		lblLibStatus.add(lbl5Mti);
		lblLibStatus.add(lbl6Prf);
		lblLibStatus.add(lbl6DetectTime);
		lblLibStatus.add(lbl6Speed);
		
		lbl2Pulse.setBounds(10, tempY*3, 150, 20);
		txtPulse.setBounds(170, tempY*3, 50, 20);
		lbl2Window.setBounds(250, tempY*3, 120, 20);
		txtWindow.setBounds(380, tempY*3, 50, 20);
		lbl2Betha.setBounds(450, tempY*3, 50, 20);
		txtBetha.setBounds(540, tempY*3, 50, 20);
		lbl3GuardCell.setBounds(10, tempY*5, 150, 20);
		txtGuardCell.setBounds(170, tempY*5, 50, 20);
		lbl3ReferenceCell.setBounds(250, tempY*5, 120, 20);
		txtRefereneCell.setBounds(380, tempY*5, 50, 20);
		lbl3Cfar.setBounds(450, tempY*5, 80, 20);
		txtCfar.setBounds(540, tempY*5, 150, 20);
		lbl3Alpha.setBounds(700, tempY*5, 50, 20);
		txtAlpha.setBounds(760, tempY*5, 50, 20);
		lbl4MaxDoppler.setBounds(10, tempY*7, 150, 20);
		txtMaxDoppler.setBounds(170, tempY*7, 50, 20);
		lbl4Doppler.setBounds(250, tempY*7, 120, 20);
		txtDoppler.setBounds(380, tempY*7, 50, 20);
		lbl4Fft.setBounds(450, tempY*7, 80, 20);
		txtFft.setBounds(540, tempY*7, 50, 20);
		lbl5Mti.setBounds(10, tempY*9, 150, 20);
		txtMti.setBounds(170, tempY*9, 50, 20);
		lbl6Prf.setBounds(10, tempY*11, 150, 20);
		txtPrf.setBounds(170, tempY*11, 50, 20);
		lbl6DetectTime.setBounds(250, tempY*11, 120, 20);
		txtDetectTime.setBounds(380, tempY*11, 50, 20);
		lbl6Speed.setBounds(450, tempY*11, 60, 20);
		txtSpeed.setBounds(540, tempY*11, 50, 20);
		
		lblLibStatus.add(txtPulse);
		lblLibStatus.add(txtWindow);
		lblLibStatus.add(txtBetha);
		lblLibStatus.add(txtCfar);
		lblLibStatus.add(txtGuardCell);
		lblLibStatus.add(txtRefereneCell);
		lblLibStatus.add(txtAlpha);
		lblLibStatus.add(txtMaxDoppler);
		lblLibStatus.add(txtDoppler);
		lblLibStatus.add(txtFft);
		lblLibStatus.add(txtMti);
		lblLibStatus.add(txtPrf);
		lblLibStatus.add(txtDetectTime);
		lblLibStatus.add(txtSpeed);
	        
	}
	
	public void settingsParam(String subString){
		int startIdx = 24;
		String selectLib = byteToInt(subString.substring(startIdx, startIdx+2));
		int intSelectLib= Integer.valueOf(selectLib);
		selectLib = Integer.toBinaryString(intSelectLib);
		selectLib = String.format("%06d", Integer.valueOf(selectLib));
		int[] libSelect = new int[6];
		for(int i = 0; i < libSelect.length ; i++){
			libSelect[libSelect.length-i-1] = Integer.valueOf(selectLib.substring(i, i+1));
		}
		lib1.setState(libSelect[0] == 1 ? true : false);
		lib2.setState(libSelect[1] == 1 ? true : false);
		lib3.setState(libSelect[2] == 1 ? true : false);
		lib4.setState(libSelect[3] == 1 ? true : false);
		lib5.setState(libSelect[4] == 1 ? true : false);
		lib6.setState(libSelect[5] == 1 ? true : false);
		
		
		String libCount = byteToInt(subString.substring(startIdx+2, startIdx+4));
		String txtWindowTemp = byteToInt(subString.substring(startIdx+4, startIdx+6));
		int txtWindowInt = Integer.valueOf(txtWindowTemp);
		if(txtWindowInt > 127){
			txtWindowInt -= 256;
		}
		if(txtWindowInt == 0){
			txtWindow.setText(String.valueOf("Kaiser"));
		}else if(txtWindowInt == 1){
			txtWindow.setText(String.valueOf("Hamming"));
		}else{
			txtWindow.setText(String.valueOf("Hanning"));
		}
		txtPulse.select(
	    		 Integer.valueOf(byteToInt(subString.substring(startIdx+6, startIdx+8))));
		float txtBethaFloat = getFloat(subString.substring(startIdx+8, startIdx+16));
		txtBetha.setText(String.valueOf(txtBethaFloat));
		
		String cfarConverter = byteToInt(subString.substring(startIdx+16, startIdx+18));
		if(cfarConverter.equals("0")){
			txtCfar.setText("CA CFAR");
		}else if(cfarConverter.equals("1")){
			txtCfar.setText("GO CFAR");
		}else if(cfarConverter.equals("16")){
			txtCfar.setText("SO CFAR");
		}else{
			txtCfar.setText("Two Parameter CFAR");
		}
		
		txtGuardCell.setText(byteToInt(subString.substring(startIdx+18, startIdx+20)));
		txtRefereneCell.setText(byteToInt(subString.substring(startIdx+20, startIdx+22)));
		txtAlpha.setText(getInt(subString.substring(startIdx+24, startIdx+32)));
		txtMaxDoppler.setText(getShort(subString.substring(startIdx+32, startIdx+36)));
		txtDoppler.setText(byteToInt(subString.substring(startIdx+36, startIdx+38)));
		txtFft.setText(byteToInt(subString.substring(startIdx+38, startIdx+40)));
		float txtMtiFloat = getFloat(subString.substring(startIdx+40, startIdx+48));
		txtMti.setText(String.valueOf(txtMtiFloat));
		txtPrf.setText(getInt(subString.substring(startIdx+48, startIdx+56)));
		txtDetectTime.setText(getInt(subString.substring(startIdx+56, startIdx+64)));
		txtSpeed.setText(getInt(subString.substring(startIdx+64, startIdx+72)));
		
	}
	
	public JLabel getLblLibStatus() {
		return lblLibStatus;
	}
}
