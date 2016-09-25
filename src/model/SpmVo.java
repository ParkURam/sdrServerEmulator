package model;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import spm.SpmContext;
import spm.SpmCw;
import spm.SpmState;

public class SpmVo implements SpmContext{
	SpmState spmState = SpmCw.getInstance();
	CommonMessageFrameImpl spmCmfi = new CommonMessageFrameImpl();
	public int txFrequency = 200;
	public boolean rawMode = true;
	public int ddsMode = 0;
	public int modData = 2048;
	public String resultMsg = "";
	byte[] byteArrayTemp = new byte[1024*2];
	byte[] byteArray = new byte[1024*2];
	ByteBuffer buffer = ByteBuffer.allocate(1024*2);
	private HashMap<String, Integer> mapData = new HashMap<>();
	
	private static SpmVo spmVo = new SpmVo();
	public static SpmVo getInstance(){
		return spmVo;
	}
	
	private SpmVo() {
		
	}

	@Override
	public void setDds(int ddsMode) {
		spmState.setDds(this, ddsMode);
	}

	@Override
	public void changeState(SpmState state) {
		this.spmState = state;
	}

	@Override
	public void recordingLog(String msg) {
		// DB 저장
	}
	
	@Override
	public CommonMessageFrameImpl receiveMsg(CommonMessageFrameImpl cmfi) {
		spmCmfi = cmfi;
		String cmd = spmCmfi.cmd;
		if(cmd.equals("b414")){ // 검지 데이터
			//System.out.println("Detect : " + spmCmfi.resultMsg);
			spmCmfi = spmState.doDetConvertor(this, spmCmfi);
		}else if(cmd.equals("b415")){ // I,Q data
			//System.out.println("I Q : " + cmfi.resultMsg);
			spmCmfi = spmState.doRawConvertor(this, spmCmfi);
		}else if(cmd.equals("b416")){ // FFT 데이터
			//System.out.println("fft : " + cmfi.resultMsg);
			spmCmfi = spmState.doFftConvertor(this, spmCmfi);
		}else if(cmd.equals("b418")){ // FFT 데이터
			//System.out.println("fft : " + cmfi.resultMsg);
			spmCmfi = spmState.doGvdsConvertor(this, spmCmfi);
		}else{
			//System.out.println("Other : " + cmfi.resultMsg);
			spmCmfi = spmState.doOtherConvertor(this, spmCmfi);
		}
		return spmCmfi;
	}
	

	@Override
	public void setRaw(boolean rawMode) {
		this.rawMode = rawMode;
	}

	@Override
	public CommonMessageFrameImpl getCmfi() {
		return spmCmfi;
	}
	
	public HashMap<String, Integer> getMapData() {
		return this.mapData;
	}
	
	public void hashMapConvertor(HashMap<String, String> dataMap){
		Set key = dataMap.keySet();
		String keyName;
        String valueName;
        for (Iterator iterator = key.iterator(); iterator.hasNext();) {
        	keyName = (String) iterator.next();
            valueName = dataMap.get(keyName);
            spmVo.mapData.put(keyName, Integer.valueOf(valueName));
        }
	}
	
}
