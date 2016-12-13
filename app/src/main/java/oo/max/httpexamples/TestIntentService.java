package oo.max.httpexamples;

import android.app.IntentService;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

public class TestIntentService extends IntentService {

    public TestIntentService() {
        super("TestIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {

            ServerApiClient serverApiClient = new ServerApiClient();

//            String result = serverApiClient.callServerApi();
//
//            postResult(result);

        } catch (Exception e) {
            e.printStackTrace();
            postResult(null);
        }
    }

    private void postResult(String result) {
        OperationCompletedEvent event = new OperationCompletedEvent(result);

        EventBus.getDefault().post(event);
    }

}