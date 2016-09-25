package model;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RxmModuleStatus {
	
	JLabel lblRxmStatus, rxmPower, rxmAlcVoltage, rxmOverflowAlert;
	JLabel rxmPllAlert, rxmRefAlarm, rxmBand;
	CheckboxGroup rxmPllAlertGroup, rxmRefAlarmGroup, rxmOverflowAlertGroup, txmRefAlarmGroup;
	Checkbox rxmOverflowAlertOn, rxmOverflowAlertOff, rxmPllAlertOn, rxmPllAlertOff;
	Checkbox rxmRefAlarmOn, rxmRefAlarmOff;
	TextField txtRxmAlcVoltage, txtRxmPower; 
	Choice rxmBandCho;
	
	public RxmModuleStatus() {
		lblRxmStatus = new JLabel();
		lblRxmStatus.setBorder(BorderFactory.createTitledBorder("수신기 모듈 정보"));
		lblRxmStatus.setBounds(290, 50, 270, 250);
		
        rxmPower = new JLabel("출력 전력(dBm)");
        rxmAlcVoltage = new JLabel("ALC 경보(dBm)");
        rxmOverflowAlert = new JLabel("출력 과다 경보");
        rxmPllAlert = new JLabel("PLL 경보");
        rxmRefAlarm = new JLabel("Ref Alarm");
        rxmBand = new JLabel("대역 타입");
        
        txtRxmPower =new TextField(20);

        JPanel rxmPllAlertGen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rxmPllAlertGroup = new CheckboxGroup();
        rxmPllAlertOn = new Checkbox("Operating",rxmPllAlertGroup,true);
        rxmPllAlertOff = new Checkbox("Danger",rxmPllAlertGroup,false);
        
        rxmPllAlertGen.add(rxmPllAlertOn);
        rxmPllAlertGen.add(rxmPllAlertOff);
       
        JPanel rxmRefAlarmGen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rxmRefAlarmGroup = new CheckboxGroup();
        rxmRefAlarmOn = new Checkbox("Operating",rxmRefAlarmGroup,true);
        rxmRefAlarmOff = new Checkbox("Danger",rxmRefAlarmGroup,false);
        
        rxmRefAlarmGen.add(rxmRefAlarmOn);
        rxmRefAlarmGen.add(rxmRefAlarmOff);
       
        rxmBandCho = new Choice();
        rxmBandCho.add("S밴드");
        rxmBandCho.add("X밴드");
        rxmBandCho.add("K밴드");
        
        JPanel rxmOverflowAlertGen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rxmOverflowAlertGroup = new CheckboxGroup();
        rxmOverflowAlertOn = new Checkbox("Operating",rxmOverflowAlertGroup,true);
        rxmOverflowAlertOff = new Checkbox("Danger",rxmOverflowAlertGroup,false);
        
        rxmOverflowAlertGen.add(rxmOverflowAlertOn);
        rxmOverflowAlertGen.add(rxmOverflowAlertOff);
        
        txtRxmAlcVoltage =new TextField(20);
        int tempY = 35;
        rxmPower.setBounds(10, tempY, 100, 20);
        rxmAlcVoltage.setBounds(10, tempY*2, 100, 20);
        rxmOverflowAlert.setBounds(10, tempY*3, 100 , 30);
        rxmPllAlert.setBounds(10, tempY*4, 100, 30);
        rxmRefAlarm.setBounds(10, tempY*5, 100, 30);
        rxmBand.setBounds(10, tempY*6, 100, 30);
        
        txtRxmPower.setBounds(110, tempY, 150, 20);
        txtRxmAlcVoltage.setBounds(110, tempY*2, 150, 20);
        rxmOverflowAlertGen.setBounds(110, tempY*3, 150, 30);
        rxmPllAlertGen.setBounds(110, tempY*4, 150, 30);
        rxmRefAlarmGen.setBounds(110, tempY*5, 150, 30);
        rxmBandCho.setBounds(110, tempY*6, 150, 30);
        
        lblRxmStatus.add(rxmPower);
        lblRxmStatus.add(rxmAlcVoltage);
        lblRxmStatus.add(rxmOverflowAlert);
        lblRxmStatus.add(rxmPllAlert);
        lblRxmStatus.add(rxmRefAlarm);
        lblRxmStatus.add(rxmBand);
        
        lblRxmStatus.add(txtRxmPower);
        lblRxmStatus.add(txtRxmAlcVoltage);
        lblRxmStatus.add(rxmOverflowAlertGen);
        lblRxmStatus.add(rxmPllAlertGen);
        lblRxmStatus.add(rxmRefAlarmGen);
        lblRxmStatus.add(rxmBandCho);
        
        txtRxmPower.setText("5");
		txtRxmAlcVoltage.setText("10");
		rxmBandCho.select(1);
		
	}
	
	public JLabel getRxmPower() {
		return rxmPower;
	}

	public JLabel getRxmAlcVoltage() {
		return rxmAlcVoltage;
	}

	public JLabel getRxmOverflowAlert() {
		return rxmOverflowAlert;
	}

	public JLabel getRxmPllAlert() {
		return rxmPllAlert;
	}

	public JLabel getRxmRefAlarm() {
		return rxmRefAlarm;
	}

	public JLabel getRxmBand() {
		return rxmBand;
	}

	public CheckboxGroup getRxmPllAlertGroup() {
		return rxmPllAlertGroup;
	}

	public CheckboxGroup getRxmRefAlarmGroup() {
		return rxmRefAlarmGroup;
	}

	public CheckboxGroup getRxmOverflowAlertGroup() {
		return rxmOverflowAlertGroup;
	}

	public CheckboxGroup getTxmRefAlarmGroup() {
		return txmRefAlarmGroup;
	}

	public Checkbox getRxmOverflowAlertOn() {
		return rxmOverflowAlertOn;
	}

	public Checkbox getRxmOverflowAlertOff() {
		return rxmOverflowAlertOff;
	}

	public Checkbox getRxmPllAlertOn() {
		return rxmPllAlertOn;
	}

	public Checkbox getRxmPllAlertOff() {
		return rxmPllAlertOff;
	}

	public Checkbox getRxmRefAlarmOn() {
		return rxmRefAlarmOn;
	}

	public Checkbox getRxmRefAlarmOff() {
		return rxmRefAlarmOff;
	}

	public TextField getTxtRxmAlcVoltage() {
		return txtRxmAlcVoltage;
	}

	public TextField getTxtRxmPower() {
		return txtRxmPower;
	}

	public Choice getRxmBandCho() {
		return rxmBandCho;
	}

	public JLabel getLblRxmStatus(){
		return lblRxmStatus;
	}
}
