package com.jiangfeixiang.mpdemo.springboot.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author 姜飞祥
* @since 2019-05-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Password implements Serializable {

    private static final long serialVersionUID = 1L;

    private String password;


}
