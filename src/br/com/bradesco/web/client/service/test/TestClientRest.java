package br.com.bradesco.web.client.service.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.core.util.MultivaluedMapImpl;

import br.com.bradesco.web.client.service.RestClientResource;

public class TestClientRest {

	public static void main(String[] args) {
//		testGet();
//		testPostHeaders();
//		testPost();
//		testGetHeader();
		testCreateJson();
	}

	public static void testGet() {
		String url = "http://192.168.245.212:8080/v1/previdencia/ofertaPlanoPrevidencia";

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("canal", "3");
		headers.put("origem", "0");
		headers.put("usuario", "0");
		headers.put("identificaFuncionario", "N");
		headers.put("codigoCorretor", "0");
		headers.put("identificaRepresentante", "N");
		headers.put("access-token", "a38b9763-0a66-4b00-baac-126d2916baa6");
		headers.put("Content-Type", "application/json");

		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("cpf", "00000000001");
		params.add("perfil", "00");
		params.add("agencia", "00000");
		params.add("conta", "0000000");
		params.add("segmento", "000");
		params.add("modalidade", "0");
		params.add("tipoContribuicao", "0");
		params.add("valorContribuicao", "50000");
		params.add("regimeTributario", "00");

		String json = null;
		try {
			json = RestClientResource.getJSONHeadersRequestParams(url, params, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json = e.getMessage();
		}
		System.out.println(json);
	}
	
	public static void testPostHeaders() {
		String url = "http://192.168.245.212:8080/v1/previdencia/validarPropostaInscricao";
		String json = "{\"planoPagamento\":310,\"dtInicioPlano\":\"01.01.2017\",\"dtInicioBeneficio\":\"01.01.2017\",\"serie\":55,\"numeroProposta\":110846,\"codProdutoNegociado\":\"00079\",\"dtVenda\":\"25.01.2019\",\"dtAgendamento\":\"25.02.2019\",\"indAgendamento\":\"S\",\"codTipoProduto\":1,\"codModalidade\":2,\"codIdentProduto\":\"PFPPP\",\"codIndTributacao\":1,\"codFinalidade\":1,\"dtConcessao\":\"01.02.2050\",\"codBloco\":84,\"codIndicie\":0,\"taxaCarregamento\":0,\"vlrTotalContrib\":5000,\"codOrigemRecurso\":0,\"observacaoOrigem\":\"\",\"cpfCnpjParticipante\":342108328,\"filialCnpj\":0,\"controleCpfCnpj\":20,\"dtNascimento\":\"16.01.1985\",\"sexo\":\"M\",\"nome\":\"EDIVANI PORTILHO DE CARVALHO\",\"idade\":33,\"estadoCivil\":2,\"email\":\"EDIVANICARVALHOSISCONSULTORIA.COM.BR\",\"codBanco\":237,\"agencia\":3977,\"nrConta\":43000,\"tpConta\":1,\"formaEnvio\":3,\"dtExpedicao\":\"01.01.0001\",\"vlrRendaMensal\":100,\"vlrPatrimonio\":200,\"codOcupacao\":126,\"telefones\":[{\"tpTelefone\":1,\"codArea\":11,\"nrTelefone\":47846426,\"nrRamal\":0},{\"tpTelefone\":2,\"codArea\":11,\"nrTelefone\":37116530,\"nrRamal\":6931},{\"tpTelefone\":3,\"codArea\":0,\"nrTelefone\":0,\"nrRamal\":0}],\"codIdentTipoDoc\":0,\"codParticipante\":\"\",\"codPais\":46,\"cep\":18133,\"complemento\":330,\"cpfCnpjJovem\":0,\"filialCnpjJovem\":0,\"controleCpfCnpjJovemPatrocinado\":0,\"dtNascimentoJovem\":\"01.01.0001\",\"sexoJovem\":\"\",\"nomeJovem\":\"\",\"idadeJovem\":0,\"estadoCivilJovem\":0,\"emailJovem\":\"\",\"telefonesJovem\":[{\"tpTelefone\":0,\"codArea\":0,\"nrTelefone\":0,\"nrRamal\":0},{\"tpTelefone\":0,\"codArea\":0,\"nrTelefone\":0,\"nrRamal\":0},{\"tpTelefone\":0,\"codArea\":0,\"nrTelefone\":0,\"nrRamal\":0}],\"codGrauParentesco\":0,\"codIdentDependencia\":0,\"cepJovem\":0,\"complementoJovem\":0,\"codConcessao\":9384006,\"codRecurso\":35,\"codRegistro\":0,\"codAgente\":9911348,\"codConvenio\":884,\"codSucursal\":9039,\"codSuperintencia\":9806,\"codExecutiva\":371,\"codBancoVenda\":237,\"codAgenciaVenda\":2,\"perfilUsuario\":\"B\",\"codIndCargoPublico\":1,\"orgaoContratante\":\"PREFEITURA MUNICIPAL DA CIDADE\",\"cpfCnpjEmpregador\":342108328,\"filialEmpregador\":0,\"controleCpfCnpjEmpregador\":20,\"dsCargo\":\"PREFEITO\",\"dtInicio\":\"01.01.2012\",\"dtFim\":\"31.12.2016\",\"vlrPatrimonioDeclarado\":200,\"vlrRendaMensalContratante\":200,\"codRelacionamento\":1,\"nmAgente\":\"CONCEIÁ„O APARECIDA PORTILHO DE CARVALHO\",\"cpfCnpjAgente\":20945318,\"filialAgente\":0,\"controleCpfCnpjAg\":48,\"dsCargoAgente\":\"VEREADORA\",\"dsRelacionamentoAgente\":\"M„E\",\"indNascionalidadeFatca\":1,\"indResidenciaFatca\":1,\"indVistoFatca\":1,\"qtdeFatca\":3,\"fatcas\":[{\"identSituacao\":1,\"codPaisEstrangeiro\":\"00025\",\"codDocFiscal\":\"123456/78\",\"codEmissaoFiscal\":1,\"codIndicadorObr\":2,\"codIndicadorDis\":2,\"codIndicadorRenuncia\":1,\"codDocRenuncia\":1},{\"identSituacao\":\"2\",\"codPaisEstrangeiro\":\"00020\",\"codDocFiscal\":\"987654/32 \",\"codEmissaoFiscal\":2,\"codIndicadorObr\":1,\"codIndicadorDis\":2,\"codIndicadorRenuncia\":2,\"codDocRenuncia\":2},{\"identSituacao\":3,\"codPaisEstrangeiro\":\"00035\",\"codDocFiscal\":\"567890/12\",\"codEmissaoFiscal\":2,\"codIndicadorObr\":2,\"codIndicadorDis\":1,\"codIndicadorRenuncia\":1,\"codDocRenuncia\":2},{\"identSituacao\":0,\"codPaisEstrangeiro\":\"\",\"codDocFiscal\":\"\",\"codEmissaoFiscal\":0,\"codIndicadorObr\":0,\"codIndicadorDis\":0,\"codIndicadorRenuncia\":0,\"codDocRenuncia\":0}],\"qtdeBeneficio\":1,\"beneficios\":[{\"nrBeneficio\":1,\"codBeneficio\":22205,\"vlrContribRisco\":1009990000000,\"vlrRendaBenRisco\":5000000000000,\"tpRecRisco\":0,\"tpCobertura\":0,\"qtdeBeneficiario\":4,\"beneficiarios\":[{\"nrBeneficiario\":1,\"nmBeneficiario\":\"BENEFICI·RIO 1\",\"dtNasimentoBeneficiario\":\"12.02.2014\",\"sexoBeneficiario\":\"M\",\"grauParentescoBeneficiario\":5,\"percentualBeneficiario\":2000},{\"nrBeneficiario\":2,\"nmBeneficiario\":\"BENEFICI·RIO 2\",\"dtNasimentoBeneficiario\":\"27.03.2017\",\"sexoBeneficiario\":\"F\",\"grauParentescoBeneficiario\":5,\"percentualBeneficiario\":2100},{\"nrBeneficiario\":3,\"nmBeneficiario\":\"BENEFICI·RIO 3 \",\"dtNasimentoBeneficiario\":\"09.05.1985\",\"sexoBeneficiario\":\"F\",\"grauParentescoBeneficiario\":4,\"percentualBeneficiario\":2200},{\"nrBeneficiario\":4,\"nmBeneficiario\":\"BENEFICI·RIO 4 \",\"dtNasimentoBeneficiario\":\"23.09.1957\",\"sexoBeneficiario\":\"F\",\"grauParentescoBeneficiario\":4,\"percentualBeneficiario\":3700}]}]}";

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("canal", "2");
		headers.put("origem", "0");
		headers.put("usuario", "0");
		headers.put("identificaFuncionario", "N");
		headers.put("codigoCorretor", "0");
		headers.put("identificaRepresentante", "N");
		headers.put("access-token", "a38b9763-0a66-4b00-baac-126d2916baa6");
		headers.put("Content-Type", "application/json");
		
		try {
			String retJson = RestClientResource.postJSONHeaders(url, headers, json);
			System.out.println(retJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testPost() {
		String url = "http://bvpvida.dsv.bradseg.com.br/be/oauth/api/v1/account/system-oauth";
		String json = "{\"chaveAcesso\":\"26a6d30474164404bb6e856f8e3d1c28\",\"codigoGrupo\":999}";
		
		try {
			String retorno = RestClientResource.postJson(url, json);
			System.out.println(retorno);
			
			JSONObject jo = new JSONObject(retorno);
			JSONObject j = jo.getJSONObject("data");
			System.out.println(j.get("access_token"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void testGetHeader() {
		String url = "http://bvpvida.dsv.bradseg.com.br/be/oauth/api/v1/account/system-oauth";
		String json = "{\"chaveAcesso\":\"26a6d30474164404bb6e856f8e3d1c28\",\"codigoGrupo\":999}";
		
		String retorno;
		try {
			retorno = RestClientResource.postJson(url, json);
			JSONObject jo = new JSONObject(retorno);
			JSONObject j = jo.getJSONObject("data");
			
			String accessToken = (String) j.get("access_token");
			System.out.println(accessToken);
			
			Map<String, String> headers = new HashMap<String, String>();
			String key = "Authorization";
			String value = "Bearer " + accessToken;
			headers.put(key, value);
			
			url = "http://bvpvida.dsv.bradseg.com.br/be/aceite-digital/api/v1/aceite-digital/correntista";
			String cpf = "77935754304";
			String codigo = "B71B5767-3DF1-46EE-B1BA-B91BA3008623";
			
			retorno = RestClientResource.getStringJsonHeadersURLParams(url, headers, cpf, codigo);
			System.out.println(retorno);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testCreateJson() {
		String accessTokenChaveAcesso = "abcdefghijklmnopqrstuvwxyz";
		Integer accessTokenCodigoGrupo = 999;
		
		try {
			JSONObject jo = new JSONObject();
			jo.put("chaveAcesso", accessTokenChaveAcesso);
			jo.put("codigoGrupo", accessTokenCodigoGrupo);
			
			String jsonAuthorization = jo.toString();
			
			System.out.println(jsonAuthorization);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
