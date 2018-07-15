package ar.edu.unlam.tallerweb1.servicios;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.QrDao;
import ar.edu.unlam.tallerweb1.modelo.Token;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;




@Service("servicioQr")
@Transactional
public class ServicioQrImpl implements ServicioQr {
	@Inject 
	QrDao qrDao;
	
	@Override
	public void generarQr(Long idSocio, Date fechaVencimiento) {
		Integer random = (int) (Math.random() * (100000000-1))+1;
    	String uri = "localhost:8080/gimnasio/verificarQr?token=" + random + "&idSocio=" + idSocio;
		File file = QRCode.from(uri).to(ImageType.GIF).withSize(250, 250).file();
		qrDao.guardarToken(idSocio, fechaVencimiento, random); 
		Desktop d= Desktop.getDesktop();
		try {
			d.open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   	
		
	}

	@Override
	public Boolean validarToken(Integer numero, Long idSocio) {
		Token token = qrDao.buscarToken(numero,idSocio);
		if (token != null){
			if(token.getFechaVencimiento().before(Calendar.getInstance().getTime())){
				return false;
			}
			return true;
		}
		else
			return false;
		
		
	}

	
	
}
