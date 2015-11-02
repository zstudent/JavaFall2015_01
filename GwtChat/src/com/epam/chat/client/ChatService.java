package com.epam.chat.client;

import java.util.UUID;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("chat")
public interface ChatService extends RemoteService {
	void sendMessage(long uuid, String message) throws IllegalArgumentException;
}
