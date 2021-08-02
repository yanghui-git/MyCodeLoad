package com.yh.test.duty;

import org.junit.Test;

/**
 * Java 责任链模式
 * 
 */
public class DutyTest {

    @Test
    public void testOne() {
        AbstractClerk clerk = new Clerk();
        AbstractClerk leader = new Leader();
        AbstractClerk manager = new Manager();

        clerk.setSuperior(leader);
        leader.setSuperior(manager);

        // clerk.approveRequest(new BorrowRequest(500));
          clerk.approveRequest(new BorrowRequest(700));
      //  clerk.approveRequest(new BorrowRequest(2300));
    }
}
