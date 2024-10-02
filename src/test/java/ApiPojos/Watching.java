package ApiPojos;

import java.util.ArrayList;
import java.util.List;

public class Watching {
	
	private Content content;
	private int lastWatchPosition;
	private String watchSessionId;
	private String user_id;
	private String DeviceId;
	
	
	
	

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public int getLastWatchPosition() {
		return lastWatchPosition;
	}

	public void setLastWatchPosition(int lastWatchPosition) {
		this.lastWatchPosition = lastWatchPosition;
	}

	public String getWatchSessionId() {
		return watchSessionId;
	}

	public void setWatchSessionId(String watchSessionId) {
		this.watchSessionId = watchSessionId;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}
	
	
}
