package model;

import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class DetStatus {
	JLabel lblDetectData;
	Label lblDetectNumber;
	Choice detectNumberCho;
	Label lblDet1Id, lblDet2Id, lblDet3Id, lblDet4Id, lblDet5Id;
	TextField txtDet1Id, txtDet2Id, txtDet3Id, txtDet4Id, txtDet5Id;
	Label lblSpeed1Id, lblSpeed2Id, lblSpeed3Id, lblSpeed4Id,lblSpeed5Id;
	TextField txtSpeed1Id, txtSpeed2Id, txtSpeed3Id, txtSpeed4Id, txtSpeed5Id;
	Label lblDistance1Id, lblDistance2Id, lblDistance3Id, lblDistance4Id, lblDistance5Id;
    Label lblDegree1Id, lblDegree2Id, lblDegree3Id, lblDegree4Id, lblDegree5Id;
	TextField txtDistance1Id, txtDistance2Id, txtDistance3Id, txtDistance4Id, txtDistance5Id;
    TextField txtDegree1Id, txtDegree2Id, txtDegree3Id, txtDegree4Id, txtDegree5Id;
    
	public DetStatus() {
		lblDetectData = new JLabel();
		lblDetectData.setBorder(BorderFactory.createTitledBorder("검지 데이터"));
		lblDetectData.setBounds(20, 360, 830, 200);

		lblDetectNumber = new Label("검지 대수");
		lblDetectNumber.setBounds(20, 20, 100, 20);
        
        detectNumberCho = new Choice();
        detectNumberCho.setBounds(120, 20, 80, 20);
        detectNumberCho.add("0");
        detectNumberCho.add("1");
        detectNumberCho.add("2");
        detectNumberCho.add("3");
        detectNumberCho.add("4");
        detectNumberCho.add("5");
        
        lblDet1Id = new Label("ID-1");
        lblDet1Id.setBounds(20, 50, 50, 20);
        txtDet1Id = new TextField(10);
        txtDet1Id.setBounds(70, 50, 50, 20);
        
        lblDet2Id = new Label("ID-2");
        lblDet2Id.setBounds(20, 80, 50, 20);
        txtDet2Id = new TextField(10);
        txtDet2Id.setBounds(70, 80, 50, 20);
        
        lblDet3Id = new Label("ID-3");
        lblDet3Id.setBounds(20, 110, 50, 20);
        txtDet3Id = new TextField(10);
        txtDet3Id.setBounds(70, 110, 50, 20);
        lblDet4Id = new Label("ID-4");
        lblDet4Id.setBounds(20, 140, 50, 20);
        txtDet4Id = new TextField(10);
        txtDet4Id.setBounds(70, 140, 50, 20);
        lblDet5Id = new Label("ID-5");
        lblDet5Id.setBounds(20, 170, 50, 20);
        txtDet5Id = new TextField(10);
        txtDet5Id.setBounds(70, 170, 50, 20);
        
        lblSpeed1Id = new Label("속도(Km/h)");
        lblSpeed1Id.setBounds(150, 50, 80, 20);
        txtSpeed1Id = new TextField(10);
        txtSpeed1Id.setBounds(230, 50, 80, 20);
        lblSpeed2Id = new Label("속도(Km/h)");
        lblSpeed2Id.setBounds(150, 80, 80, 20);
        txtSpeed2Id = new TextField(10);
        txtSpeed2Id.setBounds(230, 80, 80, 20);
        lblSpeed3Id = new Label("속도(Km/h)");
        lblSpeed3Id.setBounds(150, 110, 80, 20);
        txtSpeed3Id = new TextField(10);
        txtSpeed3Id.setBounds(230, 110, 80, 20);
        lblSpeed4Id = new Label("속도(Km/h)");
        lblSpeed4Id.setBounds(150, 140, 80, 20);
        txtSpeed4Id =new TextField(10);
        txtSpeed4Id.setBounds(230, 140, 80, 20);
        lblSpeed5Id = new Label("속도(Km/h)");
        lblSpeed5Id.setBounds(150, 170, 80, 20);
        txtSpeed5Id = new TextField(10);
        txtSpeed5Id.setBounds(230, 170, 80, 20);
        
        lblDistance1Id = new Label("거리(m)");
        lblDistance1Id.setBounds(330, 50, 80, 20);
        txtDistance1Id = new TextField(10);
        txtDistance1Id.setBounds(410, 50, 80, 20);
        lblDistance2Id = new Label("거리(m)");
        lblDistance2Id.setBounds(330, 80, 80, 20);
        txtDistance2Id = new TextField(10);
        txtDistance2Id.setBounds(410, 80, 80, 20);
        lblDistance3Id = new Label("거리(m)");
        lblDistance3Id.setBounds(330, 110, 80, 20);
        txtDistance3Id = new TextField(10);
        txtDistance3Id.setBounds(410, 110, 80, 20);
        lblDistance4Id = new Label("거리(m)");
        lblDistance4Id.setBounds(330, 140, 80, 20);
        txtDistance4Id = new TextField(10);
        txtDistance4Id.setBounds(410, 140, 80, 20);
        lblDistance5Id = new Label("거리(m)");
        lblDistance5Id.setBounds(330, 170, 80, 20);
        txtDistance5Id = new TextField(10);
        txtDistance5Id.setBounds(410, 170, 80, 20);

        lblDegree1Id = new Label("각도(º)");
        lblDegree1Id.setBounds(520, 50, 80, 20);
        txtDegree1Id =new TextField(10);
        txtDegree1Id.setBounds(600, 50, 80, 20);
        lblDegree2Id = new Label("각도(º)");
        lblDegree2Id.setBounds(520, 80, 80, 20);
        txtDegree2Id =new TextField(10);
        txtDegree2Id.setBounds(600, 80, 80, 20);
        lblDegree3Id = new Label("각도(º)");
        lblDegree3Id.setBounds(520, 110, 80, 20);
        txtDegree3Id =new TextField(10);
        txtDegree3Id.setBounds(600, 110, 80, 20);
        lblDegree4Id = new Label("각도(º)");
        lblDegree4Id.setBounds(520, 140, 80, 20);
        txtDegree4Id =new TextField(10);
        txtDegree4Id.setBounds(600, 140, 80, 20);
        lblDegree5Id = new Label("각도(º)");
        lblDegree5Id.setBounds(520, 170, 80, 20);
        txtDegree5Id =new TextField(10);
        txtDegree5Id.setBounds(600, 170, 80, 20);
        
        detectNumberCho.select(4);
		txtDet1Id.setText("1000");
		txtDet2Id.setText("2000");
		txtDet3Id.setText("3000");
		txtDet4Id.setText("4000");
		
		txtSpeed1Id.setText("20.33");
		txtSpeed2Id.setText("40.41");
		txtSpeed3Id.setText("60.9");
		txtSpeed4Id.setText("65.1");
		
		txtDistance1Id.setText("50");
		txtDistance2Id.setText("10");
		txtDistance3Id.setText("25");
		txtDistance4Id.setText("80");
		
		txtDegree1Id.setText("50");
		txtDegree2Id.setText("10");
		txtDegree3Id.setText("25");
		txtDegree4Id.setText("80");
		
        lblDetectData.add(lblDetectNumber);
        lblDetectData.add(detectNumberCho);
        lblDetectData.add(lblDet1Id);
        lblDetectData.add(txtDet1Id);
        lblDetectData.add(lblDet2Id);
        lblDetectData.add(txtDet2Id);
        lblDetectData.add(lblDet3Id);
        lblDetectData.add(txtDet3Id);
        lblDetectData.add(lblDet4Id);
        lblDetectData.add(txtDet4Id);
        lblDetectData.add(lblDet5Id);
        lblDetectData.add(txtDet5Id);
        lblDetectData.add(lblSpeed1Id);
        lblDetectData.add(txtSpeed1Id);
        lblDetectData.add(lblSpeed2Id);
        lblDetectData.add(txtSpeed2Id);
        lblDetectData.add(lblSpeed3Id);
        lblDetectData.add(txtSpeed3Id);
        lblDetectData.add(lblSpeed4Id);
        lblDetectData.add(txtSpeed4Id);
        lblDetectData.add(lblSpeed5Id);
        lblDetectData.add(txtSpeed5Id);
        lblDetectData.add(lblDistance1Id);
        lblDetectData.add(txtDistance1Id);
        lblDetectData.add(lblDistance2Id);
        lblDetectData.add(txtDistance2Id);
        lblDetectData.add(lblDistance3Id);
        lblDetectData.add(txtDistance3Id);
        lblDetectData.add(lblDistance4Id);
        lblDetectData.add(txtDistance4Id);
        lblDetectData.add(lblDistance5Id);
        lblDetectData.add(txtDistance5Id);
        lblDetectData.add(lblDegree1Id);
        lblDetectData.add(txtDegree1Id);
        lblDetectData.add(lblDegree2Id);
        lblDetectData.add(txtDegree2Id);
        lblDetectData.add(lblDegree3Id);
        lblDetectData.add(txtDegree3Id);
        lblDetectData.add(lblDegree4Id);
        lblDetectData.add(txtDegree4Id);
        lblDetectData.add(lblDegree5Id);
        lblDetectData.add(txtDegree5Id);
	}
	
	public void exSettings(){
		txtDet1Id.setText("1000");
		txtDet2Id.setText("2000");
		txtDet3Id.setText("3000");
		txtDet4Id.setText("4000");
		txtDet5Id.setText("5000");
		
		txtSpeed1Id.setText("20.33");
		txtSpeed2Id.setText("40.41");
		txtSpeed3Id.setText("60.9");
		txtSpeed4Id.setText("65.1");
		txtSpeed5Id.setText("55.6");
		
		txtDistance1Id.setText("50");
		txtDistance2Id.setText("10");
		txtDistance3Id.setText("25");
		txtDistance4Id.setText("80");
		txtDistance5Id.setText("40");
		
		txtDegree1Id.setText("50");
		txtDegree2Id.setText("10");
		txtDegree3Id.setText("25");
		txtDegree4Id.setText("80");
		txtDegree5Id.setText("100");
	}
	
	public JLabel getLblDetectData() {
		return lblDetectData;
	}

	public Label getLblDetectNumber() {
		return lblDetectNumber;
	}

	public Choice getDetectNumberCho() {
		return detectNumberCho;
	}

	public Label getLblDet1Id() {
		return lblDet1Id;
	}

	public Label getLblDet2Id() {
		return lblDet2Id;
	}

	public Label getLblDet3Id() {
		return lblDet3Id;
	}

	public Label getLblDet4Id() {
		return lblDet4Id;
	}

	public Label getLblDet5Id() {
		return lblDet5Id;
	}

	public TextField getTxtDet1Id() {
		return txtDet1Id;
	}

	public TextField getTxtDet2Id() {
		return txtDet2Id;
	}

	public TextField getTxtDet3Id() {
		return txtDet3Id;
	}

	public TextField getTxtDet4Id() {
		return txtDet4Id;
	}

	public TextField getTxtDet5Id() {
		return txtDet5Id;
	}

	public Label getLblSpeed1Id() {
		return lblSpeed1Id;
	}

	public Label getLblSpeed2Id() {
		return lblSpeed2Id;
	}

	public Label getLblSpeed3Id() {
		return lblSpeed3Id;
	}

	public Label getLblSpeed4Id() {
		return lblSpeed4Id;
	}

	public Label getLblSpeed5Id() {
		return lblSpeed5Id;
	}

	public TextField getTxtSpeed1Id() {
		return txtSpeed1Id;
	}

	public TextField getTxtSpeed2Id() {
		return txtSpeed2Id;
	}

	public TextField getTxtSpeed3Id() {
		return txtSpeed3Id;
	}

	public TextField getTxtSpeed4Id() {
		return txtSpeed4Id;
	}

	public TextField getTxtSpeed5Id() {
		return txtSpeed5Id;
	}

	public Label getLblDistance1Id() {
		return lblDistance1Id;
	}

	public Label getLblDistance2Id() {
		return lblDistance2Id;
	}

	public Label getLblDistance3Id() {
		return lblDistance3Id;
	}

	public Label getLblDistance4Id() {
		return lblDistance4Id;
	}

	public Label getLblDistance5Id() {
		return lblDistance5Id;
	}

	public Label getLblDegree1Id() {
		return lblDegree1Id;
	}

	public Label getLblDegree2Id() {
		return lblDegree2Id;
	}

	public Label getLblDegree3Id() {
		return lblDegree3Id;
	}

	public Label getLblDegree4Id() {
		return lblDegree4Id;
	}

	public Label getLblDegree5Id() {
		return lblDegree5Id;
	}

	public TextField getTxtDistance1Id() {
		return txtDistance1Id;
	}

	public TextField getTxtDistance2Id() {
		return txtDistance2Id;
	}

	public TextField getTxtDistance3Id() {
		return txtDistance3Id;
	}

	public TextField getTxtDistance4Id() {
		return txtDistance4Id;
	}

	public TextField getTxtDistance5Id() {
		return txtDistance5Id;
	}

	public TextField getTxtDegree1Id() {
		return txtDegree1Id;
	}

	public TextField getTxtDegree2Id() {
		return txtDegree2Id;
	}

	public TextField getTxtDegree3Id() {
		return txtDegree3Id;
	}

	public TextField getTxtDegree4Id() {
		return txtDegree4Id;
	}

	public TextField getTxtDegree5Id() {
		return txtDegree5Id;
	}
}
