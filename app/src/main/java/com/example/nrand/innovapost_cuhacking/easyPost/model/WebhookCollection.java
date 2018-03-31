package com.example.nrand.innovapost_cuhacking.easyPost.model;

import java.util.List;
import com.example.nrand.innovapost_cuhacking.easyPost.net.EasyPostResource;

public class WebhookCollection extends EasyPostResource {
    List<Webhook> webhooks;

    public List<Webhook> getWebhooks() {
        return webhooks;
    }
    public void setWebhooks(List<Webhook> webhooks) {
        this.webhooks = webhooks;
    }
}
