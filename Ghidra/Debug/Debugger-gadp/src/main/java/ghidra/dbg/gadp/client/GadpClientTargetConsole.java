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
package ghidra.dbg.gadp.client;

import java.util.concurrent.CompletableFuture;

import com.google.protobuf.ByteString;

import ghidra.dbg.gadp.protocol.Gadp;
import ghidra.dbg.gadp.util.GadpValueUtils;
import ghidra.dbg.target.TargetConsole;

public interface GadpClientTargetConsole
		extends GadpClientTargetObject, TargetConsole<GadpClientTargetConsole> {

	@Override
	default CompletableFuture<Void> write(byte[] data) {
		getDelegate().assertValid();
		return getModel().sendChecked(Gadp.ConsoleWriteRequest.newBuilder()
				.setPath(GadpValueUtils.makePath(getPath()))
				.setData(ByteString.copyFrom(data)),
			Gadp.ConsoleWriteReply.getDefaultInstance())
				.thenApply(rep -> null);
	}
}
