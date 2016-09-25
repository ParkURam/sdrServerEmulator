package model;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TxmModuleStatus {
	
	JLabel lblTxmStatus, txmPower, txmOverflowAlert, txmLowflowAlert;
	JLabel txmPllAlert, txmRefAlarm, txmBand;
	CheckboxGroup txmOverflowAlertGroup, txmLowflowAlertGroup, txmPllAlertGroup, txmRefAlarmGroup;
	Checkbox txmOverflowAlertGroupOn, txmOverflowAlertGroupOff, txmLowflowAlertOn, txmLowflowAlertOff;
	Checkbox txmPllAlertOn, txmPllAlertOff, txmRefAlarmOn, txmRefAlarmOff;
	TextField txtTxmPower, txtTxmBan, txtTxmBand; 
	Choice txmBandCho;
	public TxmModuleStatus() {
		lblTxmStatus =new JLabel();
		lblTxmStatus.setBorder(BorderFactory.createTitledBorder("송신기 모듈 정보"));
		lblTxmStatus.setBounds(20, 50, 270, 250);
		
        txmPower = new JLabel("출력 전력(dBm)");
        txmOverflowAlert = new JLabel("출력 과다 경보");
        txmLowflowAlert = new JLabel("저출력 경보");
        txmPllAlert = new JLabel("PLL 경보");
        txmRefAlarm = new JLabel("Ref Alarm");
        txmBand = new JLabel("대역 타입");
        
        txtTxmPower =new TextField(20);
        txtTxmBand =new TextField(20);
        
        JPanel txmOverflowAlertGen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txmOverflowAlertGroup = new CheckboxGroup();
        txmOverflowAlertGroupOn = new Checkbox("Operating", txmOverflowAlertGroup, true);
        txmOverflowAlertGroupOff = new Checkbox("Danger", txmOverflowAlertGroup, false);
        
        txmOverflowAlertGen.add(txmOverflowAlertGroupOn);
        txmOverflowAlertGen.add(txmOverflowAlertGroupOff);
        
        JPanel txmLowflowAlertGen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txmLowflowAlertGroup = new CheckboxGroup();
        txmLowflowAlertOn = new Checkbox("Operating", txmLowflowAlertGroup, true);
        txmLowflowAlertOff = new Checkbox("Danger", txmLowflowAlertGroup, false);
        
        txmLowflowAlertGen.add(txmLowflowAlertOn);
        txmLowflowAlertGen.add(txmLowflowAlertOff);
        
        JPanel txmPllAlertGen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txmPllAlertGroup = new CheckboxGroup();
        txmPllAlertOn = new Checkbox("Operating",txmPllAlertGroup,true);
        txmPllAlertOff = new Checkbox("Danger",txmPllAlertGroup,false);
        
        txmPllAlertGen.add(txmPllAlertOn);
        txmPllAlertGen.add(txmPllAlertOff);
        
        JPanel txmRefAlarmGen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txmRefAlarmGroup = new CheckboxGroup();
        txmRefAlarmOn = new Checkbox("Operating",txmRefAlarmGroup,true);
        txmRefAlarmOff = new Checkbox("Danger",txmRefAlarmGroup,false);
        
        txmRefAlarmGen.add(txmRefAlarmOn);
        txmRefAlarmGen.add(txmRefAlarmOff);
        
        txmBandCho = new Choice();
        txmBandCho.add("S밴드");
        txmBandCho.add("X밴드");
        txmBandCho.add("K밴드");
        
        int tempY = 35;
        txmPower.setBounds(10, tempY, 100, 20);
        txmOverflowAlert.setBounds(10, tempY*2, 100, 30);
        txmLowflowAlert.setBounds(10, tempY*3, 100 , 30);
        txmPllAlert.setBounds(10, tempY*4, 100, 30);
        txmRefAlarm.setBounds(10, tempY*5, 100, 30);
        txmBand.setBounds(10, tempY*6, 100, 20);
        
        txtTxmPower.setBounds(110, tempY, 150, 25);
        txmOverflowAlertGen.setBounds(110, tempY*2, 150, 30);
        txmLowflowAlertGen.setBounds(110, tempY*3, 150, 30);
        txmPllAlertGen.setBounds(110, tempY*4, 150, 30);
        txmRefAlarmGen.setBounds(110, tempY*5, 150, 30);
        txmBandCho.setBounds(110, tempY*6, 150, 25);
		
        lblTxmStatus.add(txmPower);
        lblTxmStatus.add(txmOverflowAlert);
        lblTxmStatus.add(txmLowflowAlert);
        lblTxmStatus.add(txmPllAlert);
        lblTxmStatus.add(txmRefAlarm);
        lblTxmStatus.add(txmBand);
        
        lblTxmStatus.add(txtTxmPower);
        lblTxmStatus.add(txtTxmBand);
        lblTxmStatus.add(txmOverflowAlertGen);
        lblTxmStatus.add(txmLowflowAlertGen);
        lblTxmStatus.add(txmPllAlertGen);
        lblTxmStatus.add(txmRefAlarmGen);
        lblTxmStatus.add(txmBandCho);
        
        txtTxmPower.setText("10");
		txmBandCho.select(1);
	}
	
	public JLabel getLblTxmStatus(){
		return lblTxmStatus;
	}

	public JLabel getTxmPower() {
		return txmPower;
	}

	public JLabel getTxmOverflowAlert() {
		return txmOverflowAlert;
	}

	public JLabel getTxmLowflowAlert() {
		return txmLowflowAlert;
	}

	public JLabel getTxmPllAlert() {
		return txmPllAlert;
	}

	public JLabel getTxmRefAlarm() {
		return txmRefAlarm;
	}

	public JLabel getTxmBand() {
		return txmBand;
	}

	public CheckboxGroup getTxmOverflowAlertGroup() {
		return txmOverflowAlertGroup;
	}

	public CheckboxGroup getTxmLowflowAlertGroup() {
		return txmLowflowAlertGroup;
	}

	public CheckboxGroup getTxmPllAlertGroup() {
		return txmPllAlertGroup;
	}

	public CheckboxGroup getTxmRefAlarmGroup() {
		return txmRefAlarmGroup;
	}

	public Checkbox getTxmOverflowAlertGroupOn() {
		return txmOverflowAlertGroupOn;
	}

	public Checkbox getTxmOverflowAlertGroupOff() {
		return txmOverflowAlertGroupOff;
	}

	public Checkbox getTxmLowflowAlertOn() {
		return txmLowflowAlertOn;
	}

	public Checkbox getTxmLowflowAlertOff() {
		return txmLowflowAlertOff;
	}

	public Checkbox getTxmPllAlertOn() {
		return txmPllAlertOn;
	}

	public Checkbox getTxmPllAlertOff() {
		return txmPllAlertOff;
	}

	public Checkbox getTxmRefAlarmOn() {
		return txmRefAlarmOn;
	}

	public Checkbox getTxmRefAlarmOff() {
		return txmRefAlarmOff;
	}

	public TextField getTxtTxmPower() {
		return txtTxmPower;
	}

	public TextField getTxtTxmBan() {
		return txtTxmBan;
	}

	public TextField getTxtTxmBand() {
		return txtTxmBand;
	}

	public Choice getTxmBandCho() {
		return txmBandCho;
	}
	
}
