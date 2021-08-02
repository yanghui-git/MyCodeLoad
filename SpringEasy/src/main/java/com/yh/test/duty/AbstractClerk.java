package com.yh.test.duty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
abstract class AbstractClerk {

    /**
     * 表示
     */
    private AbstractClerk superior = null;

    /**
     *
     */
    protected String type;

    public abstract int getLimit();

    public void approveRequest(BorrowRequest request) {
        if (getLimit() >= request.getRequestMoney()) {
            System.out.println(getType() + "同意借款请求");
            return;
        }
        if (this.superior != null) {
            this.superior.approveRequest(request);
            return;
        }
        System.out.println("没有人能够同意借款请求");

    }

}
