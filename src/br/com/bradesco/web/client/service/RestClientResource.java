package br.com.bradesco.web.client.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.bradesco.web.client.service.constants.Constants;

/**
 * Classe que implementa os m�todos da interface IRestClient
 * para serializa��o, deserializa��o de arquivos JSON e para
 * utiliza��o de m�todos GET e POST via Webservice Rest
 * 
 * @author Ricardo Vanni - Scopus
 * @version 22/01/2019
 */
public class RestClientResource {
	
	/**
	 * 
	 * @param tipo
	 * @param resultadoJSON
	 * @return Converte uma String JSON no objeto especificado
	 * @throws JSONException
	 */
	@SuppressWarnings("unchecked")
	public static <T> Object deserializeJSONToObject(Object tipo, String resultadoJSON) {
		try {
			if (resultadoJSON != null && !"".equals(resultadoJSON)) {
				return new Gson().fromJson(resultadoJSON, (Class<T>) tipo.getClass());
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	/**
	 * 
	 * @param tipo
	 * @return Converte o Objeto recebido em JSON
	 * @throws JSONException
	 */
	public static String serializeObjectToJSON(Object tipo) {
		try {
			if (tipo != null) {
				return new Gson().toJson(tipo);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	/**
	 * M�todo sem par�metros que obt�m um response no formato JSON 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static String getStringJson(String url) throws IOException {
		return getStringJsonURLParams(url, "");
	}

	/**
	 * M�todo sem par�metros que obt�m um response no formato JSON 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static String getStringJsonURLParams(String url, String... params) throws IOException {
		return getStringJsonHeadersURLParams(url, null, params);
	}
	
	/**
	 * M�todo que consome um servi�o REST do tipo GET passando Headers na requisi��o e Parametros na URL.
	 * @param url - informar a url do servi�o
	 * @param headers - informar um Map com os headers do servi�o
	 * @param params - informar um ou mais parametros
	 * @return - Retorna uma String JSON
	 * @throws Exception
	 */
	public static String getStringJsonHeadersURLParams(String url, Map<String, String> headers, String...params) throws IOException{
		String jsonResponse = null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		String parametroFormatado = "";
		for(String param : params) {
			parametroFormatado += "/" + param;
		}
		
		HttpGet getRequest = new HttpGet(url + ("".equals(parametroFormatado) ? "" : parametroFormatado));
		getRequest.addHeader("accept", "application/json");
		
		for(Entry<String, String> item : headers.entrySet()) {
			getRequest.addHeader(item.getKey(), item.getValue());
		}
				
		HttpResponse response = null;
		
		try {
			response = httpClient.execute(getRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) 
			{
				throw new RuntimeException("Falha com HTTP, c�digo do erro : " + statusCode);
			}
			
			HttpEntity httpEntity = response.getEntity();
			jsonResponse = EntityUtils.toString(httpEntity, HTTP.UTF_8);
			
			return jsonResponse;
			
		} catch (RuntimeException e) {
			throw new RuntimeException("Falha no webservice - " + e.getMessage(), e.getCause());
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedEncodingException("Falha no webservice - " + e.getMessage());
		} catch (ClientProtocolException e) {
			throw new ClientProtocolException("Falha no webservice - " + e.getMessage(), e.getCause());
		} catch (IOException e) {
			throw new IOException("Falha no webservice - " + e.getMessage());
		}
	}
	
	/**
	 * M�todo que consome um servi�o REST passando par�metros e headers.
	 * @param url - informar a url do servi�o
	 * @param params - informar um Map com os parametros do servi�o
	 * @param headers - informar um Map com os headers do servi�o
	 * @return
	 * @throws Exception
	 */
	public static String getJSONHeadersRequestParams(String url, MultivaluedMap<String, String> params, Map<String, String> headers) throws Exception {
		
		String stringJson = "";
		Integer cont = headers.size();

		List<String> key = new ArrayList<String>();
		List<String> value = new ArrayList<String>();
		
		for(Entry<String, String> item : headers.entrySet()) {
			key.add(item.getKey());
			value.add(item.getValue());
		}

		int i = 0;
				
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.queryParams(params)
											.accept("application/json")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.header(i < cont ? key.get(i) : "", i < cont ? value.get(i++) : "")
											.get(ClientResponse.class); 
		
		if(resp.getStatus() != 200) {
			throw new RuntimeException("Falha com HTTP, c�digo do erro : " + resp.getStatus() + " - " + resp.getResponseStatus());
		}
		
		stringJson = resp.getEntity(String.class);
		
		return stringJson;
	}
	
	/**
	 * M�todo que faz um POST passando a URL e o Objeto
	 * @param url
	 * @param objectJson
	 * @return 
	 * @throws IOException
	 */
	public static String postJsonObject(String url, Object objectJson) throws IOException {
		String json = serializeObjectToJSON(objectJson);
		return postJson(url, json);
	}

	/**
	 * M�todo que envia um POST no formato JSON
	 * @param url
	 * @param dadosConfirmacao
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	public static String postJson(String url, String json) throws IOException {
		return postJSONHeaders(url, null, json);
	}

	/**
	 * M�todo que faz um POST passando Headers e um Objeto como Par�metro
	 * @param url
	 * @param headers
	 * @param objectJson
	 * @return
	 * @throws IOException
	 */
	public static String postJsonObjectHeaders(String url, Map<String, String> headers, Object objectJson) throws IOException {
		String json = serializeObjectToJSON(objectJson);
		return postJSONHeaders(url, headers, json);
	}
	
	/**
	 * M�todo que envia um POST no formato JSON, passando headers na requisi��o
	 * @param url - par�metro com a URL
	 * @param headers - par�metro com Map de headers
	 * @param json - par�metro com o JSON
	 * @return
	 * @throws IOException
	 */
	public static String postJSONHeaders(String url, Map<String, String> headers, String json) throws IOException {
		String jsonResponse = null;
		
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			
			StringEntity sEntity = new StringEntity(json, "UTF-8");
			sEntity.setContentType("application/json");
			
			HttpPost postRequest = new HttpPost(url);
			postRequest.setEntity(sEntity);
			if(headers != null) {
				for(Entry<String, String> item : headers.entrySet()) {
					postRequest.addHeader(item.getKey(), item.getValue());
				}
			}
			
			HttpResponse response = null;
			response = httpClient.execute(postRequest);
			
			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity httpEntity = response.getEntity();
			jsonResponse = EntityUtils.toString(httpEntity, HTTP.UTF_8);
			
			return statusCode == 200 ? 
					jsonResponse != null && !"".equals(jsonResponse) ?
							jsonResponse
							: Constants.POST_SUCESSO 
					: jsonResponse;
			
		} catch (RuntimeException e) {
			throw new RuntimeException("Falha no webservice - " + e.getMessage(), e.getCause());
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedEncodingException("Falha no webservice - " + e.getMessage());
		} catch (ClientProtocolException e) {
			throw new ClientProtocolException("Falha no webservice - " + e.getMessage(), e.getCause());
		} catch (IOException e) {
			throw new IOException("Falha no webservice - " + e.getMessage());
		}
	}
	
}
