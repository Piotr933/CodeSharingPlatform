package com.piotrzawada.CodeSharingPlatform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Code {

    @JsonIgnore
    @Id
    protected String id;

    @JsonProperty("code")
    private String content;

    @JsonIgnore
    protected LocalDateTime localDateTime ;

    @JsonProperty("date")
    private String date;

    @JsonProperty("time")
    protected long time;

    @JsonProperty("views")
    protected long views;

    @JsonIgnore
    protected boolean restrictedByTime;

    @JsonIgnore
    protected boolean restrictedByViews;

    public Code(String content, String formatted, int time, int views) {
        this.content = content;
        this.date = formatted;
        this.time = time;
        this.views = views;
    }
}