package VORTEX.DARIPROJECT.service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import VORTEX.DARIPROJECT.ENTITY.PushNotificationRequest;

@Service
public class FCMService {
	Logger logger = LoggerFactory.getLogger(FCMService.class);
	public void sendMessage(Map<String, String> data, PushNotificationRequest request)
			throws InterruptedException, ExecutionException {
		Message message = getPreconfiguredMessageWithData(data, request);
		String response = sendAndGetResponse(message);
		logger.info("Sent Notification. Title: " + request.getTitle() + ", " + response);
	}

	private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
		return FirebaseMessaging.getInstance().sendAsync(message).get();
	}

	private AndroidConfig getAndroidConfig() {
		return AndroidConfig.builder()
			.setTtl(Duration.ofMinutes(60).toMillis())
			.setPriority(AndroidConfig.Priority.HIGH)
			.setNotification(AndroidNotification.builder().setSound("default").setColor("#FFFF00").build())
			.build();
	}

	private ApnsConfig getApnsConfig() {
		return ApnsConfig.builder().setAps(Aps.builder().setSound("default").build()).build();
	}

	private Message getPreconfiguredMessageWithData(Map<String, String> data, PushNotificationRequest request) {
		return getPreconfiguredMessageBuilder(request).putAllData(data).setToken(request.getToken()).build();
	}

	private Message.Builder getPreconfiguredMessageBuilder(PushNotificationRequest request) {
		AndroidConfig androidConfig = getAndroidConfig();
		ApnsConfig apnsConfig = getApnsConfig();
		return Message.builder()
			.setApnsConfig(apnsConfig)
			.setAndroidConfig(androidConfig)
			.setNotification(new Notification(request.getTitle(), request.getMessage()));
	}
}
