package com.epam.chat.client;

import java.util.Random;
import java.util.UUID;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtChat implements EntryPoint {

	private final ChatServiceAsync chatService = GWT
			.create(ChatService.class);

	
	private TextBox messageField;
	private TextArea chatArea;

	private long uuid;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		Random rand = new Random();
		
		uuid = rand.nextLong();
		
		messageField = new TextBox();
		messageField.setText("enter your message");
		
		chatArea = new TextArea();
		chatArea.setSize("600px", "400px");
		
		VerticalPanel panel = new VerticalPanel();
		
		panel.add(chatArea);
		panel.add(messageField);
		
		
		RootPanel.get().add(panel);

		// Focus the cursor on the name field when the app loads
		messageField.setFocus(true);
		messageField.selectAll();

		messageField.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendMessageToServer(messageField.getText());
					messageField.setEnabled(false);
				}

			}
		});
	}

	protected void sendMessageToServer(String message) {
		chatService.sendMessage(uuid, message, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				chatArea.setText(chatArea.getText() + "\n" + messageField.getText());
				messageField.setText("");
				messageField.setEnabled(true);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO ???
			}
		});
		
	}
}
