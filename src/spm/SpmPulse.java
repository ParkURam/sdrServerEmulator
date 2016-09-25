package spm;

import java.util.ArrayList;
import java.util.HashMap;

import convertor.CommonConvertorImpl;
import model.CommonMessageFrameImpl;

public class SpmPulse extends SpmState {
	
	private static SpmPulse spmPulse = new SpmPulse();
	public CommonConvertorImpl cci = new CommonConvertorImpl();
	
	private SpmPulse(){
		
	}
	
	public static SpmState getInstance() {
		return spmPulse;
	}
	@Override
	public void doRecive(SpmContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommonMessageFrameImpl doRawConvertor(SpmContext context,
			CommonMessageFrameImpl cmfi) {
		
		int subDataLength = cmfi.getInt(String.valueOf(cmfi.length));
		ArrayList<Double> realT = new ArrayList<Double>();
		ArrayList<Double> realTx = new ArrayList<Double>();
		
		int i=0;
		int j=0;
		try {
			// 변경 예정
			for(i=0; i < subDataLength; i+=8){
				realTx.add((double)cmfi.getFloat(cmfi.subString.substring(i, i+8)));
			}

			for(j=0; j < realTx.size()/8; j++){
				realT.add((double)j);
				realT.add((double)j);
			}
			
			cmfi.rxData = new HashMap<String, ArrayList<Double>>();
			cmfi.rxData.put("realTx", realTx);
			cmfi.rxData.put("realT", realT);
			
		} catch (Exception e) {
		}
		
		return cmfi;
	}

	@Override
	public CommonMessageFrameImpl doFftConvertor(SpmContext context,
			CommonMessageFrameImpl cmfi) {
		int subDataLength = cmfi.length;
		System.out.println("receiveMsg / 원래 길이 : " + " / " + subDataLength);
		int fs = 224;
		double[] fftA = new double[subDataLength/4];
		double[] fftF = new double[subDataLength/4];
		try {
			// 변경 예정
			for(int i=0, j=0; i < (subDataLength*2); i+=8, j++){
				// signed float 가져와서 데이터 추가
				fftA[j] = cmfi.getFloat(cmfi.subString.substring(i, i+8));
				fftF[j] = ((double)(j+1)/(subDataLength/4)-0.5)*fs;
					
			}
		} catch (Exception e) {
		}
		
		cmfi.fftData.put("fftA", fftA);
		cmfi.fftData.put("fftF", fftF);
		
		return cmfi;
	}

	@Override
	public CommonMessageFrameImpl doDetConvertor(SpmContext context,
			CommonMessageFrameImpl cmfi) {
		int i = 0;
		int subDataLengthVal = 0;
		String subDataString = cmfi.subString;
		
		subDataLengthVal =cmfi.length;
		// 변경 예정
		int pointCtn = cmfi.getShort(subDataString.substring(0, 4));
		
		double[] distanceValue = new double[pointCtn];
		double[] speedValue = new double[pointCtn];
		int j = 0;
		for(i=0; i < pointCtn*28; i+=28){
			short distance = cmfi.getShort(subDataString.substring(i+4, i+8));
			distanceValue[j] = Double.valueOf(String.valueOf(distance));
			cmfi.fftData.put("distance", distanceValue);
			
			float speedFloat = cmfi.getFloat(subDataString.substring(i+8, i+16));
			speedValue[j] = Double.valueOf(String.valueOf(speedFloat));
			cmfi.fftData.put("speed", speedValue);
			
			j++;
		}
		
		return cmfi;
	}
	
	@Override
	public CommonMessageFrameImpl doGvdsConvertor(SpmContext context, CommonMessageFrameImpl cmfi) {
		int i = 0;
		String subDataString = cmfi.subString;
		// 변경 예정
		int pointCtn = (int) cci.getFloat(subDataString.substring(0, 8));
		double[] pointId = new double[pointCtn];
		double[] distanceValue = new double[pointCtn];
		double[] speedValue = new double[pointCtn];
		double[] xPoint = new double[pointCtn];
		double[] yPoint = new double[pointCtn];
		System.out.println("subDataString(" + subDataString.length() + ") : " + subDataString);
		int j = 0;
		for(i=0; i < pointCtn*40; i+=40){
			float pointIdVlaue = cci.getFloat(subDataString.substring(i+8, i+16));
			pointId[j] = Double.valueOf(String.valueOf(pointIdVlaue));
			cmfi.fftData.put("carId", pointId);
			
			float distanceFloat = cci.getFloat(subDataString.substring(i+16, i+24));
			distanceValue[j] = Double.valueOf(String.valueOf(distanceFloat));
			cmfi.fftData.put("distance", distanceValue);
			
			float speedFloat = cci.getFloat(subDataString.substring(i+24, i+32));
			speedValue[j] = Double.valueOf(String.valueOf(speedFloat));
			cmfi.fftData.put("speed", speedValue);
			
			float xPointFloat = cci.getFloat(subDataString.substring(i+32, i+40));
			xPoint[j] = Double.valueOf(String.valueOf(xPointFloat));
			cmfi.fftData.put("locX", xPoint);
			
			float yPointFloat = cci.getFloat(subDataString.substring(i+40, i+48));
			yPoint[j] = Double.valueOf(String.valueOf(yPointFloat));
			cmfi.fftData.put("locY", yPoint);
			j++;
		}
		
		if(pointCtn == 0){
			pointId = new double[1];
			distanceValue = new double[1];
			speedValue = new double[1];
			xPoint = new double[1];
			yPoint = new double[1];
			
			pointId[0] = 0;
			distanceValue[0] = 0;
			speedValue[0] = 0;
			xPoint[0] = 0;
			yPoint[0] = 0;
			
			cmfi.fftData.put("carId", pointId);
			cmfi.fftData.put("distance", distanceValue);
			cmfi.fftData.put("speed", speedValue);
			cmfi.fftData.put("locX", xPoint);
			cmfi.fftData.put("locY", yPoint);
		}
		
		return cmfi;
	}

	@Override
	public CommonMessageFrameImpl doMakeFrame(SpmContext context) {
		
		return null;
	}

	@Override
	public void setDds(SpmContext context, int ddsMode) {
		if(ddsMode == 0){
			context.changeState(SpmCw.getInstance());
		}else if(ddsMode == 1){
			context.changeState(SpmPulse.getInstance());
		}else if(ddsMode == 2){
			context.changeState(SpmLfm.getInstance());
		}else if(ddsMode == 3){
			context.changeState(SpmFmcw.getInstance());
		}
	}

}
