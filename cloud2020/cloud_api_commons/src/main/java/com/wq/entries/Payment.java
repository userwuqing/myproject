package com.wq.entries;

import java.io.Serializable;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月14日 11:30
 */
public class Payment implements Serializable {
    private final static long serialVersionUID = 1L;

    private Long id;

    private String serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
