package model;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class RespResult {

	JLabel lblResult;
	Label lblAckSpm, lblAckTxm, lblAckRxm, lblResetTabs;
	Label lblddsTabs, lbltxmTabs, lblrxmTabs, lblLibTabs, lblmodTabs;
	CheckboxGroup ackSpmTabsGroup, ackTxmTabsGroup, ackRxmTabsGroup, txmTabsGroup, rxmTabsGroup;
	Checkbox ackSpmOn, ackSpmOff, ackTxmOn, ackTxmOff, ackRxmOn, ackRxmOff;
	Checkbox ddsTabsOn, ddsTabsOff, txmTabsOn, txmTabsOff, rxmTabsOn, rxmTabsOff;
	Checkbox libTabsOn, libTabsOff, modTabsOn, modTabsOff;
	CheckboxGroup resetbGroup, ddsTabsGroup, libTabsGroup, modTabsGroup;
	Checkbox resetOn, resetOff;
	
	public RespResult() {
		lblResult = new JLabel();
		lblResult.setBorder(BorderFactory.createTitledBorder("설정 결과 정보"));
		lblResult.setBounds(580, 50, 270, 310);
		
		lblAckSpm = new Label("신호처리기 상태 점검");
        lblAckTxm = new Label("송신기 상태 점검");
        lblAckRxm = new Label("수신기 상태 점검");
        lbltxmTabs = new Label("송신기 모듈 설정");
        lblrxmTabs = new Label("수신기 모듈 설정");
        lblResetTabs = new Label("Reset 설정");
        lblddsTabs =new Label("파형모듈 설정");
        lblLibTabs =new Label("라이브러리 모듈 설정");
        lblmodTabs =new Label("자료수집 설정");
        
        // 신호처리기 상태 정보
        Panel ackSpmTabsGen = new Panel(new FlowLayout(FlowLayout.LEFT));
        ackSpmTabsGroup = new CheckboxGroup();
        ackSpmOn = new Checkbox("Success", ackSpmTabsGroup, true);
        ackSpmOff = new Checkbox("Fail", ackSpmTabsGroup, false);
        ackSpmTabsGen.add(ackSpmOn);
        ackSpmTabsGen.add(ackSpmOff);
        
        // 송신기 상태 정보
        Panel ackTxmTabsGen = new Panel(new FlowLayout(FlowLayout.LEFT));
        ackTxmTabsGroup = new CheckboxGroup();
        ackTxmOn = new Checkbox("Success", ackTxmTabsGroup, true);
        ackTxmOff = new Checkbox("Fail", ackTxmTabsGroup, false);
        ackTxmTabsGen.add(ackTxmOn);
        ackTxmTabsGen.add(ackTxmOff);
        
        // 수신기 상태 정보
        Panel ackRxmTabsGen = new Panel(new FlowLayout(FlowLayout.LEFT));
        ackRxmTabsGroup = new CheckboxGroup();
        ackRxmOn = new Checkbox("Success", ackRxmTabsGroup, true);
        ackRxmOff = new Checkbox("Fail", ackRxmTabsGroup, false);
        ackRxmTabsGen.add(ackRxmOn);
        ackRxmTabsGen.add(ackRxmOff);
        
        // 송신기 모듈 점검
        Panel txmTabsGen = new Panel(new FlowLayout(FlowLayout.LEFT));
        txmTabsGroup = new CheckboxGroup();
        txmTabsOn = new Checkbox("Success", txmTabsGroup, true);
        txmTabsOff = new Checkbox("Fail", txmTabsGroup, false);
        txmTabsGen.add(txmTabsOn);
        txmTabsGen.add(txmTabsOff);

        // 수신기 모듈 점검
        Panel rxmTabsGen = new Panel(new FlowLayout(FlowLayout.LEFT));
        rxmTabsGroup = new CheckboxGroup();
        rxmTabsOn = new Checkbox("Success",rxmTabsGroup,true);
        rxmTabsOff = new Checkbox("Fail",rxmTabsGroup,false);
        rxmTabsGen.add(rxmTabsOn);
        rxmTabsGen.add(rxmTabsOff);
        
        // Reset 설정
        Panel resetTabsGen = new Panel(new FlowLayout(FlowLayout.LEFT));
        resetbGroup = new CheckboxGroup();
        resetOn = new Checkbox("Success", resetbGroup, true);
        resetOff = new Checkbox("Fail",resetbGroup, false);
        resetTabsGen.add(resetOn);
        resetTabsGen.add(resetOff);
        
        // 파형 모듈 설정
        Panel ddsTabsGen = new Panel(new FlowLayout(FlowLayout.LEFT));
        ddsTabsGroup = new CheckboxGroup();
        ddsTabsOn = new Checkbox("Success",ddsTabsGroup,true);
        ddsTabsOff = new Checkbox("Fail",ddsTabsGroup,false);
        ddsTabsGen.add(ddsTabsOn);
        ddsTabsGen.add(ddsTabsOff);
        
        // lib 파라미터 설정
        Panel libTabsGen = new Panel(new FlowLayout(FlowLayout.LEFT));
        libTabsGroup = new CheckboxGroup();
        libTabsOn = new Checkbox("Success",libTabsGroup,true);
        libTabsOff = new Checkbox("Fail",libTabsGroup,false);
        libTabsGen.add(libTabsOn);
        libTabsGen.add(libTabsOff);
        
        // 자료 수집 설정
        Panel modTabsGen = new Panel(new FlowLayout(FlowLayout.LEFT));
        modTabsGroup = new CheckboxGroup();
        modTabsOn = new Checkbox("Success", modTabsGroup, true);
        modTabsOff = new Checkbox("Fail", modTabsGroup, false);
        modTabsGen.add(modTabsOn);
        modTabsGen.add(modTabsOff);
        
        int tempY = 30;
        
        lblAckSpm.setBounds(10, tempY, 100, 30);
        lblAckTxm.setBounds(10, tempY*2, 100, 30);
        lblAckRxm.setBounds(10, tempY*3, 100, 30);
        lbltxmTabs.setBounds(10, tempY*4, 100, 30);
        lblrxmTabs.setBounds(10, tempY*5, 100, 30);
        lblResetTabs.setBounds(10, tempY*6, 100, 30);
        lblddsTabs.setBounds(10, tempY*7, 100, 30);
        lblLibTabs.setBounds(10, tempY*8, 100, 30);
        lblmodTabs.setBounds(10, tempY*9, 100, 30);
        ackSpmTabsGen.setBounds(120, tempY, 120, 30);
        ackTxmTabsGen.setBounds(120, tempY*2, 120, 30);
        ackRxmTabsGen.setBounds(120, tempY*3, 120, 30);
        txmTabsGen.setBounds(120, tempY*4, 120, 30);
        rxmTabsGen.setBounds(120, tempY*5, 120, 30);
        resetTabsGen.setBounds(120, tempY*6, 120, 30);
        ddsTabsGen.setBounds(120, tempY*7, 120, 30);
        libTabsGen.setBounds(120, tempY*8, 120, 30);
        modTabsGen.setBounds(120, tempY*9, 120, 30);
        
        lblResult.add(lblAckSpm);
        lblResult.add(lblAckTxm);
        lblResult.add(lblAckRxm);
        lblResult.add(lbltxmTabs);
        lblResult.add(lblrxmTabs);
        lblResult.add(lblResetTabs);
        lblResult.add(lblddsTabs);
        lblResult.add(lblLibTabs);
        lblResult.add(lblmodTabs);
        lblResult.add(ackSpmTabsGen);
        lblResult.add(ackTxmTabsGen);
        lblResult.add(ackRxmTabsGen);
        lblResult.add(txmTabsGen);
        lblResult.add(rxmTabsGen);
        lblResult.add(resetTabsGen);
        lblResult.add(ddsTabsGen);
        lblResult.add(libTabsGen);
        lblResult.add(modTabsGen);
	}

	// 신호처리기 상태 정보
	public CheckboxGroup getAckSpmTabsGroup() {
		return ackSpmTabsGroup;
	}
    // 송신기 상태 정보
	public CheckboxGroup getAckTxmTabsGroup() {
		return ackTxmTabsGroup;
	}
	 // 수신기 상태 정보
	public CheckboxGroup getAckRxmTabsGroup() {
		return ackRxmTabsGroup;
	}
	// 송신기 모듈 점검
	public CheckboxGroup getTxmTabsGroup() {
		return txmTabsGroup;
	}
	// 수신기 모듈 점검
	public CheckboxGroup getRxmTabsGroup() {
		return rxmTabsGroup;
	}
    // Reset 설정
	public CheckboxGroup getResetbGroup() {
		return resetbGroup;
	}
    // 파형 모듈 설정
	public CheckboxGroup getDdsTabsGroup() {
		return ddsTabsGroup;
	}
	// 자료 수집 설정
	public CheckboxGroup getModTabsGroup() {
		return modTabsGroup;
	}
	// lib 파라미터 설정
	public JLabel getLblResult() {
		return lblResult;
	}

	public CheckboxGroup getLibTabsGroup() {
		return libTabsGroup;
	}

}
