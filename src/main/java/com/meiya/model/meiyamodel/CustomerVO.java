package com.meiya.model.meiyamodel;

import java.util.List;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2018/1/31 下午5:52
 */
public class CustomerVO extends Customer {
    List<Ticket> tickets;


    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
