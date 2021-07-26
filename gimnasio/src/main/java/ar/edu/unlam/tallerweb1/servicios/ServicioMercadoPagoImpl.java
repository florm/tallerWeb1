package ar.edu.unlam.tallerweb1.servicios;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import helpers.JsonConverter;
import helpers.MercadoPagoMetadata;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercadopago.*;


@Service("servicioMercadoPago")
@Transactional
public class ServicioMercadoPagoImpl implements ServicioMercadoPago {

    private final String FAILURE = "http://localhost:8080/gimnasio/error";
     private final String PENDING = "http://localhost:8080/gimnasio/pending";
    private final String SUCCESS = "http://localhost:8080/gimnasio/success";

	@Override
	public String createPayPreference(String titulo, String descripcion, int cantidad, double precio, Long idSocio, Long idPase, Long idDescuento) throws MPException {
      //new MercadoPago.SDK.configure("3604674222403682", "XaIGwVACvojuEIggJKmmV6Go1e7T49D8");

       MercadoPago.SDK.setAccessToken("TEST-8067984971125747-062020-3547155db7bf679321483f39bc1d2123-19971890");
        // Crea un objeto de preferencia
        Preference preference = new Preference();
        // Crea un ítem en la preferencia
        Item item = new Item();
        item.setTitle(titulo)
                .setQuantity(cantidad)
                .setUnitPrice((float) precio);
        preference.appendItem(item);
        preference.setBackUrls(new BackUrls().setFailure(FAILURE)
                .setPending(PENDING)
                .setSuccess(SUCCESS));

        try{
            MercadoPagoMetadata mp = new MercadoPagoMetadata();
            mp.setId_pase(idPase);
            mp.setId_socio(idSocio);
            mp.setId_descuento(idDescuento);
            preference.setMetadata(new JsonConverter<helpers.MercadoPagoMetadata>().classToJsonObject(mp));
        } catch (Exception e) {
            e.printStackTrace();
        }
        preference.save();

        return preference.getId();
	}

    @Override
    public MercadoPagoMetadata getMetadata(String collectionId) {
        try{
            Payment payment = Payment.findById(collectionId);
            JsonObject jo = payment.getMetadata();
            MercadoPagoMetadata a = new JsonConverter<MercadoPagoMetadata>().JsonObjectToClass(payment.getMetadata(), MercadoPagoMetadata.class);
            return new JsonConverter<MercadoPagoMetadata>().JsonObjectToClass(payment.getMetadata(), MercadoPagoMetadata.class);
        }catch (MPException e) {
            e.printStackTrace();
        }
        return null;
    }

}
