package ar.edu.unlam.tallerweb1.servicios;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercadopago.MP;


@Service("servicioMercadoPago")
@Transactional
public class ServicioMercadoPagoImpl implements ServicioMercadoPago {

	@Override
	public String createPayPreference(String titulo, String descripcion, int cantidad, double precio) {
      MP mp = new MP("3604674222403682", "XaIGwVACvojuEIggJKmmV6Go1e7T49D8");

      String sandboxInitPoint = "";


      String preferenceData =
              "{'items':"+
                      "[{"+
                          "'title':'" + titulo + "',"+
                          "'description':'" + descripcion + "',"+
                          "'quantity':" + cantidad +","+
                          "'currency_id':'ARS',"+ 
                          "'unit_price':"+ precio +
                      "}]," +
              "'payment_methods': {" +
                  "'excluded_payment_types': [" +
                      "{" +
                          "'id': 'ticket' " +
                      "}," +
                      "{" +
                          "'id': 'atm' " +
                      "}" +
                  "]" +
              "}," +
              "'operation_type': 'regular_payment'" +
              "}" +
              ",'payer':{'date_created':'2017-03-15T12:58:41.425-04:00','name':'Pepe','surname':'Palotes','email':'test_user_19653727@testuser.com'},"+
  			
  			"'identification':{'type':'DNI','number':'28765566'}}";;

      mp.sandboxMode(true);
      try {

          JSONObject preference = mp.createPreference(preferenceData);
          sandboxInitPoint = preference.getJSONObject("response").getString("sandbox_init_point");
          

      } catch(JSONException e) {
          System.out.println(e.getMessage());
      } catch(Exception e) {
      	System.out.println(e.getMessage());
      }

      return sandboxInitPoint;
	}
	
	
	
}
