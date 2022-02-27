package nayoung.designpattern.app.proxy;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.app.proxy.basedOnInterface.ItemRepositoryV1;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDB2 {

    private final ItemRepositoryV1 itemRepositoryV1;

    @PostConstruct
    public void init() {
        itemRepositoryV1.save("apple", 34L);
        itemRepositoryV1.save("candy", 56L);
    }
}
