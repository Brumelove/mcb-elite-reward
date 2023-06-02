package mu.mcb.reward.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "${mcb-workflow-messaging.service.base-url}", url = "${mcb-workflow-messaging.service.base-url}")
public interface WorkflowMqClient {

    @PostMapping(value = "{versionNumber}/{domain}/{serviceName}", produces = {"application/json"})
    ResponseEntity<Object> postProcessMqReq(@PathVariable("versionNumber") String versionNumber,@PathVariable("domain")
    String domain, @PathVariable("serviceName") String serviceName, Object processMqReqPostRequestBody);

    @PostMapping(value = "{versionNumber}/{domain}/{serviceName}", produces = {"application/json"})
    ResponseEntity<Object> postProcessMqReqV2(@PathVariable("versionNumber") String versionNumber,
                                              @PathVariable("domain") String domain, @PathVariable("serviceName")
                                              String serviceName, Object processMqReqPostRequestBody);
}