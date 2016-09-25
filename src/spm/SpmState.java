package spm;

import java.util.ArrayList;

import model.CommonMessageFrameImpl;
public abstract class SpmState {
	public abstract void setDds(SpmContext context, int ddsMode);
	public abstract void doRecive(SpmContext context);
	public abstract CommonMessageFrameImpl doRawConvertor(SpmContext context, CommonMessageFrameImpl cmfi);
	public abstract CommonMessageFrameImpl doFftConvertor(SpmContext context, CommonMessageFrameImpl cmfi);
	public abstract CommonMessageFrameImpl doDetConvertor(SpmContext context, CommonMessageFrameImpl cmfi);
	public abstract CommonMessageFrameImpl doGvdsConvertor(SpmContext context, CommonMessageFrameImpl cmfi);
	public abstract CommonMessageFrameImpl doMakeFrame(SpmContext context);
	
	public CommonMessageFrameImpl doOtherConvertor(SpmContext context, CommonMessageFrameImpl cmfi){
		
		String receiveMsg = cmfi.resultMsg;
		int subLength = cmfi.length;
		String subDataString = receiveMsg.substring(24, 24 + (subLength*2));
		ArrayList<Integer> parseSubData = new ArrayList<Integer>();
		
		for(int i=0; i < subDataString.length(); i+=2){
			Integer lowData = Integer.parseInt(subDataString.substring(i, i+2), 16);
			int value = lowData & 0xFFFF;
			parseSubData.add(value);
		}
		cmfi.subData = parseSubData;
		
		return cmfi;
	};
}
