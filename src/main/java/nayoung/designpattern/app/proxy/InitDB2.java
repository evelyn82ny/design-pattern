package nayoung.designpattern.app.proxy;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.ItemRepositoryV2;
import nayoung.designpattern.app.proxy.basedOnInterface.ItemRepositoryV1;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDB2 {

    private final ItemRepositoryV2 itemRepository;

    @PostConstruct
    public void init() {
        itemRepository.save("apple", 34L);
        itemRepository.save("candy", 56L);
    }
}
