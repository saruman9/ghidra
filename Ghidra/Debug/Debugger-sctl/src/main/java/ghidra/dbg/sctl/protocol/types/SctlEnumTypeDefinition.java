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
package ghidra.dbg.sctl.protocol.types;

import java.util.List;

import ghidra.comm.packet.annot.CountedByField;
import ghidra.comm.packet.annot.RepeatedField;
import ghidra.comm.packet.fields.PacketField;
import ghidra.dbg.sctl.protocol.common.SctlString;
import ghidra.dbg.sctl.protocol.consts.Rkind;

/**
 * The format for enumerate type definitions in SCTL
 */
public class SctlEnumTypeDefinition extends AbstractSctlTypeDefinition {
	@PacketField
	public SctlString tag;

	@PacketField
	public Rkind rep;

	@PacketField
	public long nconst;

	@PacketField
	@RepeatedField
	@CountedByField("nconst")
	public List<SctlEnumConstant> consts;

	@Override
	public AbstractSctlTypeName getTypeName() {
		return new SctlEnumTypeName(tag);
	}
}
