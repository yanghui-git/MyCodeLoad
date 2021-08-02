package com.yh.test.duty;

import lombok.Data;

@Data
public class BorrowRequest {

    private int requestMoney;

    public BorrowRequest(int money) {
        System.out.println("有新请求，需要借款 " + money + " 元");
        requestMoney = money;
    }

}
