package si.fri.prpo.skupina59.servlet.v1;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;

@SecurityScheme(securitySchemeName = "openid-connect", type = SecuritySchemeType.OPENIDCONNECT,
        openIdConnectUrl = "http://auth-server-url/.well-known/openid-configuration")
@ApplicationPath("v1")
@OpenAPIDefinition(info = @Info(title = "ApiApplication", version = "v2.0.0", contact = @Contact(), license = @License(name="something")), servers = @Server(url = "http://127.0.0.1:8080"), security
        = @SecurityRequirement(name = "openid-connect"))
public class ApiApplication extends javax.ws.rs.core.Application{

}
