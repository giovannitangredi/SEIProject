package controllertests;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.polito.ezgas.dto.GasStationDto;

public class TestController {
	
	@Test
	public void getGasStationByIdTest() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getGasStation/1");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto gs = mapper.readValue(jsonFromResponse, GasStationDto.class);
		
		assert(gs.getGasStationId() == 1);
	}
	
	@Test
	public void getAllGasStationsTest() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getAllGasStations");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto[] gsArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assert(gsArray.length == 2);
	}
	
	@Test
	public void getGasStationsByGasolineTypeTest() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/searchGasStationByGasolineType/SuperPlus");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto[] gsArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assert(gsArray.length == 2);
	}
	

	@Test
	public void getGasStationsByProximityTest() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/searchGasStationByProximity/45.03789692999072/7.643556857764101/");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto[] gsArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assert(gsArray.length == 2);
	}
	
	@Test
	public void getGasStationsWithCoordinatesTest() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getGasStationsWithCoordinates/45.03789692999072/7.643556857764101/diesel/Enjoy");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto[] gsArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assert(gsArray.length == 1);
	}
	
	@Test
	public void setGasStationReportTest() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpPost("http://localhost:8080/gasstation/setGasStationReport/1/1.5/-1.0/1.4/-1.0/-1.0/1/");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		assert(response.getStatusLine().getStatusCode() == 200);
	}
	
	@Test
	public void deleteGasStationTest() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpDelete("http://localhost:8080/gasstation/deleteGasStation/98/");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		assert(response.getStatusLine().getStatusCode() == 200);
	}
	
	@Test
	public void saveGasStationTest() throws ClientProtocolException, IOException {
		HttpPost request = new HttpPost("http://localhost:8080/gasstation/saveGasStation");

		String JSON_STRING="{\"carSharing\":\"Car2Go\",\"dieselPrice\":-1,\"gasPrice\":-1,\"gasStationAddress\":\"Corso Siracusa Turin Piemont Italy\",\"gasStationId\":null,\"gasStationName\":\"hhhh\",\"hasDiesel\":false,\"hasGas\":true,\"hasMethane\":false,\"hasSuper\":false,\"hasSuperPlus\":false,\"lat\":\"45.0374736\",\"lon\":\"7.6341275\",\"methanePrice\":-1,\"reportTimestamp\":null,\"reportUser\":-1,\"superPlusPrice\":-1,\"superPrice\":-1}";
	    HttpEntity stringEntity = new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON);
		request.setEntity(stringEntity);

		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		assert(response.getStatusLine().getStatusCode() == 200);
	}
}
