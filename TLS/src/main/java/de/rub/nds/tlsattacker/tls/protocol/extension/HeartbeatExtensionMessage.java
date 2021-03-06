/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS.
 *
 * Copyright (C) 2015 Chair for Network and Data Security,
 *                    Ruhr University Bochum
 *                    (juraj.somorovsky@rub.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.rub.nds.tlsattacker.tls.protocol.extension;

import de.rub.nds.tlsattacker.modifiablevariable.ModifiableVariable;
import de.rub.nds.tlsattacker.modifiablevariable.ModifiableVariableFactory;
import de.rub.nds.tlsattacker.modifiablevariable.ModifiableVariableProperty;
import de.rub.nds.tlsattacker.modifiablevariable.bytearray.ModifiableByteArray;
import de.rub.nds.tlsattacker.tls.constants.ExtensionType;
import de.rub.nds.tlsattacker.tls.constants.HeartbeatMode;
import de.rub.nds.tlsattacker.tls.protocol.extension.ExtensionHandler;
import de.rub.nds.tlsattacker.tls.protocol.extension.HeartbeatExtensionHandler;

/**
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 */
public class HeartbeatExtensionMessage extends ExtensionMessage {

    private HeartbeatMode heartbeatModeConfig;

    @ModifiableVariableProperty(type = ModifiableVariableProperty.Type.TLS_CONSTANT)
    ModifiableByteArray heartbeatMode;

    public HeartbeatExtensionMessage() {
	this.extensionTypeConstant = ExtensionType.HEARTBEAT;
    }

    public ModifiableByteArray getHeartbeatMode() {
	return heartbeatMode;
    }

    public void setHeartbeatMode(ModifiableByteArray heartbeatMode) {
	this.heartbeatMode = heartbeatMode;
    }

    public void setHeartbeatMode(byte[] heartbeatMode) {
	this.heartbeatMode = ModifiableVariableFactory.safelySetValue(this.heartbeatMode, heartbeatMode);
    }

    public HeartbeatMode getHeartbeatModeConfig() {
	return heartbeatModeConfig;
    }

    public void setHeartbeatModeConfig(HeartbeatMode heartbeatModeConfig) {
	this.heartbeatModeConfig = heartbeatModeConfig;
    }

    @Override
    public ExtensionHandler getExtensionHandler() {
	return HeartbeatExtensionHandler.getInstance();
    }

}
