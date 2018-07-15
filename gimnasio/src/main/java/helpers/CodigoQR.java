package helpers;

import java.awt.Desktop;
import java.io.File;

import com.barcodelib.barcode.QRCode;



@SuppressWarnings("serial")
public class CodigoQR extends javax.swing.JFrame {


	
	Integer udm=0, resolucion=300, rotacion=0; 
	float mizq=0.000f, mder=0.000f, msup=0.000f, minf=0.00f, tam=15.00f;
	
	public void generarQR(String dato){
		try{
			QRCode cod = new QRCode();
			cod.setData(dato);
			cod.setDataMode(QRCode.MODE_BYTE);
			cod.setUOM(udm);
			cod.setLeftMargin(mizq);
			cod.setRightMargin(mder);
			cod.setTopMargin(msup);
			cod.setBottomMargin(minf);
			cod.setResolution(resolucion);
			cod.setRotate(rotacion);
			cod.setModuleSize(tam);
			
			String archivo = System.getProperty("user.home")+"/qrgimnasio.gif";
			cod.renderBarcode(archivo); 
			Desktop d= Desktop.getDesktop();
			d.open(new File(archivo));
			
			} 
		
		
		catch(Exception e) {
			System.out.println("Error"+e);
		}
	}

}
