package spm;

import model.CommonMessageFrameImpl;

public interface SpmContext {
	public abstract void setRaw(boolean rawMode); // raw Data 와 검지 데이터 설정 true : raw, false = det
	public abstract void setDds(int ddsMode); // cw, fmcw, lfm , pulse 파형 context 설정
	public abstract void changeState(SpmState state); 
	public abstract void recordingLog(String msg);
	public abstract CommonMessageFrameImpl getCmfi();
	public abstract CommonMessageFrameImpl receiveMsg(CommonMessageFrameImpl cmfi);
}
