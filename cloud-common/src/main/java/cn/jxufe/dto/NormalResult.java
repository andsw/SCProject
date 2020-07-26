package cn.jxufe.dto;

import cn.jxufe.dto.myenum.HttpCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author hsw
 * @date 2020/1/12 11:21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class NormalResult<T> {

    private Integer code;
    private String message;
    private T data;

    public static <T> NormalResult<T> success() {
        return new NormalResult<T>().setCode(HttpCodeEnum.OK_CODE.getCode());
    }

    public static NormalResult<?> failure() {
        //比如 请求的userId对应用户不存在，不返回任何内容，只返回message告知原因
        return new NormalResult<>().setCode(HttpCodeEnum.FAILED_CODE.getCode());
    }

    public static <T> NormalResult<T> successWithData(T data) {
        return new NormalResult<>(HttpCodeEnum.OK_CODE.getCode(), null, data);
    }

    public static <T> NormalResult<T> failureWithMessage(String message) {
        //比如 请求的userId对应用户不存在，不返回任何内容，只返回message告知原因
        return new NormalResult<T>().setCode(HttpCodeEnum.FAILED_CODE.getCode()).setMessage(message);
    }
}

