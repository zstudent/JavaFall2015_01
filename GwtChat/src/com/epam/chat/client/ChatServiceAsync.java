
package com.epam.chat.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ChatServiceAsync {
	void sendMessage(long uuid, String message,
			AsyncCallback<List<String>> callback);
}
