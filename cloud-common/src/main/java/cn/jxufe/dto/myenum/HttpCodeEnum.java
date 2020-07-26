package cn.jxufe.dto.myenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hsw
 * @date 2020/1/18 14:15
 */
@AllArgsConstructor
@Getter
public enum HttpCodeEnum {
    // 官方
    /**
     * GET：资源已被提取并在消息正文中传输。
     * HEAD：实体标头位于消息正文中。
     * POST：描述动作结果的资源在消息体中传输。
     * TRACE：消息正文包含服务器收到的请求消息
     */
    OK_CODE(200),
    /**
     * 通常是post或put请求的操作成功
     */
    CREATE_CODE(201),
    /**
     * 服务器成功处理了请求，但不需要返回任何实体内容
     */
    NO_CONTENT_CODE(204),
    /**
     * 重定向码
     */
    REDIRECT_CODE(302),
    /**
     * 服务器端发生错误
     */
    SERVER_ERROR_CODE(500),

    //自定义
    /**
     * 请求是正确的，但是获取数据或操作失败（比较笼统），与上面的200对应
     * 当然后后面还可以添加更具体的错误状态码。
     */
    FAILED_CODE(208);


    private int code;
}
