package nayoung.designpattern.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        itemRepository.save("apple", 34L);
        itemRepository.save("candy", 56L);
    }
}
