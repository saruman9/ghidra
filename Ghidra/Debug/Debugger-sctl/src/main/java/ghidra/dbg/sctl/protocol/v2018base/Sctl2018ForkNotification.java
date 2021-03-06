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
package ghidra.dbg.sctl.protocol.v2018base;

import ghidra.comm.packet.fields.PacketField;
import ghidra.dbg.sctl.protocol.common.AbstractSctlContext;
import ghidra.dbg.sctl.protocol.common.notify.AbstractSctlForkNotification;

public class Sctl2018ForkNotification extends AbstractSctlForkNotification {
	public Sctl2018ForkNotification() {
		super();
	}

	public Sctl2018ForkNotification(long spwnid, AbstractSctlContext ctx,
			AbstractSctlContext spwnctx) {
		super(spwnid, ctx, spwnctx);
	}

	@Override
	public boolean supportsProcessID() {
		return true;
	}

	@Override
	public long getProcessID() {
		return pid;
	}

	@Override
	public void setProcessID(long pid) {
		this.pid = pid;
	}

	@PacketField(after = "spwnid", before = "ctx")
	public long pid;
}
