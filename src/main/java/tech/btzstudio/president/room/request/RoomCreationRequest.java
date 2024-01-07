package tech.btzstudio.president.room.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomCreationRequest {
    private String name;
    private String password;
}
