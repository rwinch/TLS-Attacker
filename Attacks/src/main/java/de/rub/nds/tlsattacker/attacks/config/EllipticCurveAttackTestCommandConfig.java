package de.rub.nds.tlsattacker.attacks.config;

import com.beust.jcommander.Parameter;
import de.rub.nds.tlsattacker.tls.config.ClientCommandConfig;
import de.rub.nds.tlsattacker.tls.config.converters.BigIntegerConverter;
import de.rub.nds.tlsattacker.tls.protocol.handshake.constants.CipherSuite;
import de.rub.nds.tlsattacker.tls.protocol.handshake.constants.NamedCurve;
import de.rub.nds.tlsattacker.tls.workflow.WorkflowTraceType;
import java.math.BigInteger;

/**
 * 
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 */
public class EllipticCurveAttackTestCommandConfig extends ClientCommandConfig {

    public static final String ATTACK_COMMAND = "elliptic_test";

    @Parameter(names = "-premaster_secret", description = "Premaster Secret String (use 0x at the beginning for a hex value)", converter = BigIntegerConverter.class, required = true)
    BigInteger premasterSecret;

    @Parameter(names = "-public_point_base_x", description = "Public key point coordinate X sent to the server (use 0x at the beginning for a hex value)", converter = BigIntegerConverter.class, required = true)
    BigInteger publicPointBaseX;

    @Parameter(names = "-public_point_base_y", description = "Public key point coordinate Y sent to the server (use 0x at the beginning for a hex value)", converter = BigIntegerConverter.class, required = true)
    BigInteger publicPointBaseY;

    public EllipticCurveAttackTestCommandConfig() {
	cipherSuites.clear();
	cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
	cipherSuites.add(CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
	namedCurves.clear();
	namedCurves.add(NamedCurve.SECP256R1);
	workflowTraceType = WorkflowTraceType.HANDSHAKE;
    }

    public BigInteger getPremasterSecret() {
	return premasterSecret;
    }

    public void setPremasterSecret(BigInteger premasterSecret) {
	this.premasterSecret = premasterSecret;
    }

    public BigInteger getPublicPointBaseX() {
	return publicPointBaseX;
    }

    public void setPublicPointBaseX(BigInteger publicPointBaseX) {
	this.publicPointBaseX = publicPointBaseX;
    }

    public BigInteger getPublicPointBaseY() {
	return publicPointBaseY;
    }

    public void setPublicPointBaseY(BigInteger publicPointBaseY) {
	this.publicPointBaseY = publicPointBaseY;
    }

}