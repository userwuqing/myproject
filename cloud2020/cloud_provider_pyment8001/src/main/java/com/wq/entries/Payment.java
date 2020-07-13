package com.wq.entries;

import java.io.Serializable;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:48
 */
public class Payment implements Serializable {

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
}
