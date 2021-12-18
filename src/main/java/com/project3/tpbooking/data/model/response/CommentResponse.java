package com.project3.tpbooking.data.model.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project3.tpbooking.model.User;
import com.project3.tpbooking.utils.time.CustomDateDeSerializer;
import com.project3.tpbooking.utils.time.CustomDateSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class CommentResponse {
    private Integer id;
    private User user;
    private String hotelId;
    private String title;
    private String content;
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeSerializer.class)
    private Date time;
}
