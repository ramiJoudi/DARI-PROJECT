package VORTEX.DARIPROJECT.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.PushNotificationRequest;

@Service
public class PushNotificationService {

	@Autowired
	FCMService fcmService;

	private String token="AAAATL1Pz_U:APA91bEf10fyM5aA5a7jci3RRYBoDJheFyCkh1Ra2gCGDCaL0U0TimxWaZVhp1WS5UIIrHI7P7IZtlD-9NQcg26P4PurAqm7WPw9itn3WozP1Rsflq-qCL10Hey1F5L2zEizrrbk7PpU";

	//@Scheduled(cron="0 0/2 * 1/1 * ?")
	public void sendPushNotificationWithData() {
		PushNotificationRequest pushNotificationRequest=new PushNotificationRequest();
			pushNotificationRequest.setMessage("Send push notifications from Spring Boot server");
			pushNotificationRequest.setTitle("test Push Notification");
			pushNotificationRequest.setToken(token);
			Map<String, String> appData= new HashMap<>();
				appData.put("name", "PushNotification");
			try {
				fcmService.sendMessage(appData, pushNotificationRequest);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
	}
}
