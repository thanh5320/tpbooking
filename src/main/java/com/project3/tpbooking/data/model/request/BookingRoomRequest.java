package com.project3.tpbooking.data.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project3.tpbooking.utils.time.CustomDateDeSerializer;
import com.project3.tpbooking.utils.time.CustomDateSerializer;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BookingRoomRequest {
    int userId;
    String roomId;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeSerializer.class)
    Date startDay;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeSerializer.class)
    Date endDay;
}
