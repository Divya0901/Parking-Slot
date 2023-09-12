package com.dg.PrakingSlot.DTO;

public class CountResponseDto {

    private Integer count;
    private String message;

    public CountResponseDto(Integer count, String message) {
        this.count = count;
        this.message = message;
    }

    public CountResponseDto() {
    }

    @Override
    public String toString() {
        return "CountResponseDto{" +
                "count=" + count +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
