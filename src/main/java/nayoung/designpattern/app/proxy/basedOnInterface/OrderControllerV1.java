package nayoung.designpattern.app.proxy.basedOnInterface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping
@ResponseBody
public interface OrderControllerV1 {

    @GetMapping("/v1/order")
    String order(@RequestParam("itemId") String itemId);
}
