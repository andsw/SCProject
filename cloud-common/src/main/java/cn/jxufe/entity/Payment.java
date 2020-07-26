package cn.jxufe.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @author hsw
 * @date 2020/3/21 11:26
 */
@Data
public class Payment implements Serializable {
    private Integer id;
    private String serial;
    private static final long serialVersionUID = 1L;
}
