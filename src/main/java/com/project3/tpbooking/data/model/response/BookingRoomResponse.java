package com.project3.tpbooking.data.model.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project3.tpbooking.utils.time.CustomDateDeSerializer;
import com.project3.tpbooking.utils.time.CustomDateSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class BookingRoomResponse {
    int id;
    int userId;
    String roomId;
    String hotelId;
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeSerializer.class)
    Date startDay;
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeSerializer.class)
    Date endDay;
    int status;
}
