/*
 * ------------------------------------------------------------------------------
 * @Project       : SDR Framework Project
 * @Source        : SdrServer.java
 * @Description   : 
 * @Author        : Uram Park
 * @Version       : v1.0
 * Copyright(c) 2013 HUBTREE All rights reserved
 *------------------------------------------------------------------------------
 *                  변         경         사         항                       
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------  --------------------------------------------------------- 
 * 2016. 3. 3.   박우람    신규생성                                     
 *------------------------------------------------------------------------------
 */
package serverMain;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import convertor.CommonConvertorImpl;
import model.CommonMessageFrameImpl;
import model.DetStatus;
import model.KnockKnockProtocol;
import model.LibrarySetting;
import model.RespResult;
import model.RxmModuleSetting;
import model.RxmModuleStatus;
import model.SpmModuleSetting;
import model.SpmVo;
import model.TxmModuleSetting;
import model.TxmModuleStatus;

public class SdrServer extends JFrame {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTextArea jtxtArea;
	private Socket client;
	private boolean threadFlag = true;
	private DataInputStream dis = null;
    private DataOutputStream dos = null;
	static Runtime r = Runtime.getRuntime();
	ServerSocket server = new ServerSocket(1000);
	KnockKnockProtocol kkp = new KnockKnockProtocol();
	public SpmVo spmVo = SpmVo.getInstance();
	
	JLabel lblRxmStatus;
	
    Checkbox rxmPllAlertOn, rxmPllAlertOff;
    Checkbox rxmRefAlarmOn, rxmRefAlarmOff;
    TextField txtAddr,txtAge;
    JButton btnSubmit, btnCancel, btnEx;

    Label lblx1Id, lblx2Id, lblx3Id, lblx4Id, lblx5Id;
    Label lbly1Id, lbly2Id, lbly3Id, lbly4Id, lbly5Id;
    TextField txtx1Id, txtx2Id, txtx3Id, txtx4Id, txtx5Id;
    TextField txty1Id, txty2Id, txty3Id, txty4Id, txty5Id;
    
    JTabbedPane jtp = new JTabbedPane();
    JPanel jp1, jp2, jp3;
    
    TxmModuleStatus tms;
    RxmModuleStatus rms;
    TxmModuleSetting tmst;
    RxmModuleSetting rmst;
    DetStatus ds;
    RespResult rr;
    SpmModuleSetting sms;
    LibrarySetting ls;
    public static void main(String[] args) {
			try {
				SdrServer frame = new SdrServer();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public SdrServer() throws IOException {
		
	    super("SDR Emulator");
        setLayout(null);
        
        jtp = new JTabbedPane();
        getContentPane().add(jtp);
        jp1 = new JPanel();
        jp1.setLayout(new GridLayout(14, 2));
        jp2 = new JPanel();
        jp2.setLayout(new GridLayout(13, 2));
        jp3 = new JPanel();
        jp3.setLayout(new GridLayout(14, 2));
        jtp.addTab("파형 모듈 설정", jp1);
        jtp.addTab("송신기모듈 설정", jp2);
        jtp.addTab("수신기 모듈 설정", jp3);
        jtp.setBounds(900, 50, 400, 500);
        add(jtp);
        // txmStatus();

        tms = new TxmModuleStatus();
        rms = new RxmModuleStatus();
        add(tms.getLblTxmStatus());
        add(rms.getLblRxmStatus());
        
        txmModule();
        rxmModule();
        respResult();
        detStatus();
        spmModule();
        
        ls = new LibrarySetting();
        
        add(ls.getLblLibStatus());
        
        txtAddr = new TextField();
        txtAge = new TextField();
       
        btnCancel = new JButton("취소");       
        btnSubmit = new JButton("설정 적용");
        btnEx = new JButton("예제 입력");
       
        txtAddr.setBounds(120, 260, 150, 20);
        txtAge.setBounds(120, 290, 150, 20);
        
        Panel paButton = new Panel();
        paButton.add(btnSubmit);
        paButton.add(btnCancel);
        paButton.add(btnEx);
        paButton.setBounds(680, 5, 300, 50);
        
        add(paButton);
       
        jtxtArea = new JTextArea(100, 150);
		scrollPane = new JScrollPane(jtxtArea);
		scrollPane.setBounds(900, 600, 400, 400);
		add(scrollPane);
		
		final JButton btnStartServer = new JButton("Start Server");
		final JButton btnDisConnServer = new JButton("DisConnection Clinet");
		final JButton btnStopServer = new JButton("Stop Server");
		final JButton btnClearLog = new JButton("Clear Log");
		
		btnStartServer.setBounds(20, 5, 150, 20);
		btnDisConnServer.setBounds(200, 5, 200, 20);
		btnStopServer.setBounds(420, 5, 120, 20);
		btnClearLog.setBounds(560, 5, 100, 20);
		
		
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStartServer.setEnabled(false);
				btnDisConnServer.setEnabled(true);
				btnStopServer.setEnabled(true);
				
				startServer();
			}
		});
		
		btnDisConnServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disConn();
				startServer();
			}
		});
		
		btnStopServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStartServer.setEnabled(true);
				btnDisConnServer.setEnabled(false);
				btnStopServer.setEnabled(false);
				stopServer();
			}
		});
		
		btnClearLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtxtArea.setText("");
			}
		});
		
		btnEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ds.exSettings();
				// x좌표는 0 ~ 99
				// y좌표는 0, 60, 270, 340
				/*for(int i=0; i < 100; i++){
					txtx1Id.setText(String.valueOf(i));
			        txty1Id.setText("0");
			        
			        txtx2Id.setText(String.valueOf(i));
			        txty2Id.setText("60");
			        
			        txtx3Id.setText(String.valueOf(99-i));
			        txty3Id.setText("270");
			        
			        txtx4Id.setText(String.valueOf(99-i));
			        txty4Id.setText("340");
			        if((i+20) < 100){
			        	txtx5Id.setText(String.valueOf(i+20));
			        	txty5Id.setText("60");
			        }
				}*/
		        
				System.out.println("libTabsGroup: " + rr.getLibTabsGroup().getSelectedCheckbox().getLabel());
				
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kkp.setTxmPower(tms.getTxtTxmPower().getText());
				kkp.setTxmOverflowAlert(groupConvertor(tms.getTxmOverflowAlertGroup()));
				kkp.setTxmLowflowAlert(groupConvertor(tms.getTxmLowflowAlertGroup()));
				kkp.setTxmPllAlert(groupConvertor(tms.getTxmPllAlertGroup()));
				kkp.setTxmRefAlarm(groupConvertor(tms.getTxmRefAlarmGroup()));
				
				kkp.setRxmPower(rms.getTxtRxmPower().getText());
				kkp.setRxmOverflowAlert(groupConvertor(rms.getRxmOverflowAlertGroup()));
				kkp.setRxmAlcVoltage(rms.getTxtRxmAlcVoltage().getText());
				kkp.setRxmPllAlert(groupConvertor(rms.getRxmPllAlertGroup()));
				kkp.setRxmRefAlarm(groupConvertor(rms.getRxmRefAlarmGroup()));
				
				kkp.setTxmBand(String.valueOf(tms.getTxmBandCho().getSelectedIndex()));
				kkp.setRxmBand(String.valueOf(rms.getRxmBandCho().getSelectedIndex()));
				
				kkp.setTxmTabs(groupConvertor(rr.getTxmTabsGroup()));
				kkp.setRxmTabs(groupConvertor(rr.getRxmTabsGroup()));
				kkp.setLibTabs(groupConvertor(rr.getLibTabsGroup()));
				
				kkp.setResetTabs(groupConvertor(rr.getResetbGroup()));
				
				kkp.setAckSpmTabs(groupConvertor(rr.getAckSpmTabsGroup()));
				kkp.setAckTxmTabs(groupConvertor(rr.getAckTxmTabsGroup()));
				kkp.setAckRxmTabs(groupConvertor(rr.getAckRxmTabsGroup()));
				
				kkp.setDdsTabs(groupConvertor(rr.getDdsTabsGroup()));
				
				kkp.setDet1Id(ds.getTxtDet1Id().getText());
				kkp.setDet2Id(ds.getTxtDet2Id().getText());
				kkp.setDet3Id(ds.getTxtDet3Id().getText());
				kkp.setDet4Id(ds.getTxtDet4Id().getText());
				kkp.setDet5Id(ds.getTxtDet5Id().getText());
				
				kkp.setSpeed1Id(ds.getTxtSpeed1Id().getText());
				kkp.setSpeed2Id(ds.getTxtSpeed2Id().getText());
				kkp.setSpeed3Id(ds.getTxtSpeed3Id().getText());
				kkp.setSpeed4Id(ds.getTxtSpeed4Id().getText());
				kkp.setSpeed5Id(ds.getTxtSpeed5Id().getText());
				
				kkp.setDistance1Id(ds.getTxtDistance1Id().getText());
				kkp.setDistance2Id(ds.getTxtDistance2Id().getText());
				kkp.setDistance3Id(ds.getTxtDistance3Id().getText());
				kkp.setDistance4Id(ds.getTxtDistance4Id().getText());
				kkp.setDistance5Id(ds.getTxtDistance5Id().getText());
				
				kkp.setDegree1Id(ds.getTxtDegree1Id().getText());
				kkp.setDegree2Id(ds.getTxtDegree2Id().getText());
				kkp.setDegree3Id(ds.getTxtDegree3Id().getText());
				kkp.setDegree4Id(ds.getTxtDegree4Id().getText());
				kkp.setDegree5Id(ds.getTxtDegree5Id().getText());
				
				kkp.setModTabs(groupConvertor(rr.getModTabsGroup()));
				
				kkp.setDetectNumber(ds.getDetectNumberCho().getSelectedIndex());
				
				addLog("송신기 출력전력 : "  + tms.getTxmPower().getText());
				addLog("송신기 출력  과다 경보 : "  + tms.getTxmOverflowAlertGroup().getSelectedCheckbox().getLabel());
				addLog("송신기 저출력 경보: " + tms.getTxmLowflowAlertGroup().getSelectedCheckbox().getLabel());
				addLog("송신기 PLL 경보: " + tms.getTxmPllAlertGroup().getSelectedCheckbox().getLabel());
				addLog("송신기 Ref Alarm: " + tms.getTxmRefAlarmGroup().getSelectedCheckbox().getLabel());
				addLog("송신기 대역타입 : " + tms.getTxmBandCho().getSelectedIndex());
				

				addLog("수신기 출력전력 : "  + rms.getTxtRxmPower().getText());
				addLog("수신기 ALC 경보 : " + rms.getTxtRxmAlcVoltage().getText());
				addLog("출력 과다 경보 : " + rms.getRxmOverflowAlertGroup().getSelectedCheckbox().getLabel());
				addLog("수신기 PLL 경보: " + rms.getRxmPllAlertGroup().getSelectedCheckbox().getLabel());
				addLog("수신기 Ref Alarm : " + rms.getRxmRefAlarmGroup().getSelectedCheckbox().getLabel());
				addLog("수신기 대역타입 : " + rms.getRxmBandCho().getSelectedIndex());
				
				addLog("신호처리기 상태  : " + rr.getAckSpmTabsGroup().getSelectedCheckbox().getLabel());
				addLog("송신기 상태 정보 : " + rr.getAckTxmTabsGroup().getSelectedCheckbox().getLabel());
				addLog("수신기 상태 정보  : " + rr.getAckRxmTabsGroup().getSelectedCheckbox().getLabel());
				addLog("송신기 모듈 점검 : " + rr.getTxmTabsGroup().getSelectedCheckbox().getLabel());
				addLog("수신기 모듈 점검 : " + rr.getRxmTabsGroup().getSelectedCheckbox().getLabel());
				addLog("Reset 설정  : " + rr.getResetbGroup().getSelectedCheckbox().getLabel());
				addLog("파형모듈 설정 : " + rr.getDdsTabsGroup().getSelectedCheckbox().getLabel());
				addLog("라이브러리 모듈 : " + rr.getLibTabsGroup().getSelectedCheckbox().getLabel());
				addLog("자료수집 설정 : " + rr.getModTabsGroup().getSelectedCheckbox().getLabel());
				
				addLog("ID-1 : " + ds.getTxtDet1Id().getText() + " / 속도 : " + ds.getTxtSpeed1Id().getText()
						+ " / 거리 : " + ds.getTxtDistance1Id().getText() + " / 각도 : " + ds.getTxtDegree1Id().getText());
				addLog("ID-2 : " + ds.getTxtDet2Id().getText() + " / 속도 : " + ds.getTxtSpeed2Id().getText()
						+ " / 거리 : " + ds.getTxtDistance2Id().getText() + " / 각도 : " + ds.getTxtDegree2Id().getText());
				addLog("ID-3 : " + ds.getTxtDet3Id().getText() + " / 속도 : " + ds.getTxtSpeed3Id().getText()
						+ " / 거리 : " + ds.getTxtDistance3Id().getText() + " / 각도 : " + ds.getTxtDegree3Id().getText());
				addLog("ID-4 : " + ds.getTxtDet4Id().getText() + " / 속도 : " + ds.getTxtSpeed4Id().getText()
						+ " / 거리 : " + ds.getTxtDistance4Id().getText() + " / 각도 : " + ds.getTxtDegree4Id().getText());
				addLog("ID-5 : " + ds.getTxtDet5Id().getText() + " / 속도 : " + ds.getTxtSpeed5Id().getText()
						+ " / 거리 : " + ds.getTxtDistance5Id().getText() + " / 각도 : " + ds.getTxtDegree5Id().getText());
				addLog("설정 완료");
				
			}
		});
		
		add(btnStartServer);
		add(btnDisConnServer);
		add(btnStopServer);
		add(btnClearLog);
		btnDisConnServer.setEnabled(false);
		btnStopServer.setEnabled(false);
		
        setSize(1500, 900);
        setVisible(true);

	}
	
	public void disConn(){
		try {
			threadFlag = false;
			dis.close();
			dos.close();
			client.close();
			addLog("소켓 클라이언트 접속 해제");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopServer(){
		try {
			threadFlag = false;
			dis.close();
			dos.close();
			client.close();
			server.close();
			addLog("Stop Server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startServer(){
		if(server.isClosed())
			try {
				server = new ServerSocket(1000);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		threadFlag = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
		        showMemory();
		        try {
		        	while(threadFlag){
		        		addLog("클라이언트 접속 대기");
		        		client = server.accept();
		        		addLog("소켓 클라이언트 접속");
			            while(true){
			                dis = new DataInputStream(client.getInputStream());
			                dos = new DataOutputStream(client.getOutputStream());
			                ByteArrayOutputStream baos = new ByteArrayOutputStream();
			                byte[] outputLine;
			    			byte[] content = new byte[ 1024 ];  
			    			int bytesRead = 0; 
			                while ((bytesRead = dis.read(content)) != -1) {
			                	byte[] receiveContent = new byte[bytesRead];
			                	for(int i=0; i < bytesRead; i++){
			                		receiveContent[i] = content[i];
			                	}
			                	CommonConvertorImpl cci = new CommonConvertorImpl();
			    				String msg = cci.byteArrayToHex(receiveContent);
			    				settingsParam(msg);
			    				addLog("Client Request("+ msg.length()+") : "  + msg);
			    				outputLine = kkp.processInput("", receiveContent);
			    				msg = cci.byteArrayToHex(outputLine);
			    				addLog("Client Response("+ msg.length()+") : "  + msg);
			    				if(msg.length() > 8192){
			    					addLog("Client Request("+ msg.substring(26, 8192+26).length()+") : "  + msg.substring(26, 8192+26));
			    				}
			    				CommonMessageFrameImpl cmf = new CommonMessageFrameImpl(msg);
			    				
			    				
			                    dos.write(outputLine);
			                }
			                /*System.out.println("dis : " + dis);
			                System.out.println("dos : " + dos);*/
			                showMemory();
			                break;
			                
			            }
		        	}
		        } catch (IOException e) {
		        	 System.out.println("socket close");
		            e.printStackTrace();
		        }
		        finally {
		        	
		        }
		        
			}
		}).start();
	}
	
	 public static void showMemory() {
	        DecimalFormat format = new DecimalFormat("###,###,###.##");
	        //JVM이 현재 시스템에 요구 가능한 최대 메모리량, 이 값을 넘으면 OutOfMemory 오류가 발생 합니다.               
	        long max = r.maxMemory() / (1024*1024);
	        //JVM이 현재 시스템에 얻어 쓴 메모리의 총량
	        long total = r.totalMemory() / (1024*1024);
	        //JVM이 현재 시스템에 청구하여 사용중인 최대 메모리(total)중에서 사용 가능한 메모리
	        long free = r.freeMemory() / (1024*1024);
	        System.out.println("sdrserver Thread Max:" + format.format(max) + " MB, Total:" + format.format(total) + " MB, Free:"+format.format(free) + " MB");
		 }
	 
	 public void addLog(String log)
	 {
		 jtxtArea.append(log + "\n");  // 로그 내용을 JTextArea 위에 붙여주고
		 jtxtArea.setCaretPosition(jtxtArea.getDocument().getLength());  // 맨아래로 스크롤한다.
	 }
	 
	 public String groupConvertor(CheckboxGroup groupTab){
		 if(groupTab.getSelectedCheckbox().getLabel().equals("Success")
				 || groupTab.getSelectedCheckbox().getLabel().equals("Operating")){
			 return "0";
		 }else{
			 return "1";
		 }
	 }
	 
	 public void settingsParam(String subString){
		 String cmd = subString.substring(12, 16);
		 addLog("cmd : "+ subString.substring(12, 16));
		 if(cmd.equals("b301")){ // 송신기 모듈 설정
			 // 입력 주파수
			 tmst.settingsParam(subString);
		 }else if(cmd.equals("b302")){ // 수신기 모듈 설정
			 // 출력 주파수
			 rmst.settingsParam(subString);
		 }else if(cmd.equals("b304")){ //파형 모듈 설정
			 // 파형 타입
			 sms.settingsParam(subString);
		 }else if(cmd.equals("b407")){ // 밴드 설정
			 sms.settingsBand(subString);
			addLog(subString);
		 }else if(cmd.equals("b305")){ // 라이브러리 설정
			 ls.settingsParam(subString);
		 }
	 }
	 
	public void spmModule(){
		sms = new SpmModuleSetting();
		jp1.add(sms.getWaveForm());
		jp1.add(sms.getTxtWaveForm());
		jp1.add(sms.getCwSwitch());
	    jp1.add(sms.getTxtCwSwitch());
	    jp1.add(sms.getBandWidth());
	    jp1.add(sms.getTxtBandWidth());
	    jp1.add(sms.getPulseWidth());
	    jp1.add(sms.getTxtPulseWidth());
	    jp1.add(sms.getPrf());
	    jp1.add(sms.getTxtPrf());
	    jp1.add(sms.getIfSwitchPreoffsetTime());
	    jp1.add(sms.getTxtIfSwitchPreoffsetTime());
	    jp1.add(sms.getIfSwitchOnTime());
	    jp1.add(sms.getTxtIfSwitchOnTime());
	    jp1.add(sms.getUpChirpTime());
	    jp1.add(sms.getTxtUpChirpTime());
	    jp1.add(sms.getDeChirptime());
	    jp1.add(sms.getTxtDeChirptime());
	    jp1.add(sms.getSpmBand());
	    jp1.add(sms.getChoBand());
		
	}
	 
	public void txmModule(){
		tmst = new TxmModuleSetting();
		 
        jp2.add(tmst.getTxmInputFrequency());
        jp2.add(tmst.getTxtTxmInputFrequency());
        jp2.add(tmst.getTxmOutputFrequency());
        jp2.add(tmst.getTxtTxmOutputFrequency());
        jp2.add(tmst.getTxmOutputGain());
        jp2.add(tmst.getTxtTxmOutputGain());
        jp2.add(tmst.getTxmTransOptions());
        jp2.add(tmst.getTxtTxmTransOptions());
        jp2.add(tmst.getTxmSwitchControlPreOffset());
        jp2.add(tmst.getTxtTxmSwitchControlPreOffset());
        jp2.add(tmst.getTxmSwitchControlOnTime());
        jp2.add(tmst.getTxtTxmSwitchControlOnTime());
        jp2.add(tmst.getTxmSwitchControlOffTime());
        jp2.add(tmst.getTxtTxmSwitchControlOffTime());
       
	}
	
	public void rxmModule(){
		rmst = new RxmModuleSetting();
		
        jp3.add(rmst.getRxmOutputFrequency());
        jp3.add(rmst.getTxtRxmOutputFrequency());
        jp3.add(rmst.getRxmInputFrequency());
        jp3.add(rmst.getTxtRxmInputFrequency());
        jp3.add(rmst.getRxmOutputGain());
        jp3.add(rmst.getTxtRxmOutputGain());
        jp3.add(rmst.getRxmTransOptions());
        jp3.add(rmst.getTxtRxmTransOptions());
        jp3.add(rmst.getRxmAlcOptions());
        jp3.add(rmst.getTxtRxmAlcOptions());
        jp3.add(rmst.getRxmReceptionBand());
        jp3.add(rmst.getTxtRxmReceptionBand());
        jp3.add(rmst.getRxmSwitchControlPreOffset());
        jp3.add(rmst.getTxtRxmSwitchControlPreOffset());
        jp3.add(rmst.getRxmSwitchControlOnTime());
        jp3.add(rmst.getTxtRxmSwitchControlOnTime());
        jp3.add(rmst.getRxmSwitchControlOffTime());
        jp3.add(rmst.getTxtRxmSwitchControlOffTime());
        jp3.add(rmst.getRxmStcControlPreOffset());
        jp3.add(rmst.getTxtRxmStcControlPreOffset());
        jp3.add(rmst.getRxmStcControlOnTime());
        jp3.add(rmst.getTxtRxmStcControlOnTime());
        jp3.add(rmst.getRxmStcControlOffTime());
        jp3.add(rmst.getTxtRxmStcControlOffTime());
        jp3.add(rmst.getRxmAnstenaSwControll());
        jp3.add(rmst.getTxtRxmAnstenaSwControll());
        jp3.add(rmst.getRxmStcOptions());
        jp3.add(rmst.getTxtRxmStcOptions());
	}
	
	public void respResult(){
		rr = new RespResult();
        add(rr.getLblResult());
        
	}
	
	public void detStatus(){
		ds = new DetStatus();
		add(ds.getLblDetectData());
        
	}
}

