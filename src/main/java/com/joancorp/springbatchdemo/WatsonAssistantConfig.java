package com.joancorp.springbatchdemo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "ibm.watson.assistant")
@Validated //Validación de la configuración
public class WatsonAssistantConfig {
	
	@NotNull(message = "La clave de api es obligatoria")
	@NotBlank(message = "La clave de api es obligatoria")
	@Pattern(regexp = "[a-z-A-Z0-9-]*", message = "El id de asistente tiene caracteres no válidos")
	private String apikey;
	
	@NotNull(message = "El id de api es obligatoria")
	@NotBlank(message = "El id de api es obligatoria")
	private String id;
	
	@NotNull(message = "Laclave de api es obligatoria")
	@NotBlank(message = "Laclave de api es obligatoria")
	private String url;
	
	@NotNull(message = "Laclave de api es obligatoria")
	@NotBlank(message = "Laclave de api es obligatoria")
	private String versionDate;
	
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getVersionDate() {
		return versionDate;
	}
	public void setVersionDate(String versionDate) {
		this.versionDate = versionDate;
	}
	
}
