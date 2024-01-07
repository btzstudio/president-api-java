package tech.btzstudio.president.room.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {
    private UUID id;
    private String name;
    private Collection<RoomPlayerResponse> players;
    private Date createdAt;
}
