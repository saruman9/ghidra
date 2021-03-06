/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.dbg.sctl.protocol.common.request;

import ghidra.comm.packet.fields.PacketField;
import ghidra.dbg.sctl.protocol.AbstractSctlRequest;

/**
 * Format for the {@code Tclrtrap} SCTL message
 */
public class SctlClearTrapRequest extends AbstractSctlRequest {
	public SctlClearTrapRequest() {
	}

	public SctlClearTrapRequest(long ctlid, long trpid) {
		this.ctlid = ctlid;
		this.trpid = trpid;
	}

	@PacketField
	public long ctlid;

	@PacketField
	public long trpid;
}
