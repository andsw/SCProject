package cn.jxufe.dto;

import cn.jxufe.dto.myenum.HttpCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hsw
 * @date 2020/2/28 11:13 下午
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class RedirectResult {
    private Integer code;
    private String redirectUrl;
    private String message;

    public static RedirectResult redirect(String redirectUrl) {
        return new RedirectResult(HttpCodeEnum.REDIRECT_CODE.getCode(), redirectUrl, "");
    }

    public static RedirectResult redirectWithMsg(String redirectUrl, String  message) {
        return new RedirectResult(HttpCodeEnum.REDIRECT_CODE.getCode(), redirectUrl, message);
    }
}
