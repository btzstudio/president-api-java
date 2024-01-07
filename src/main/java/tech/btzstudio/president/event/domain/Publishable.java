package tech.btzstudio.president.event.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Publishable {
    private final Object payload;
}
