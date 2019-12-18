package com.imooc.sell.utils;

import com.imooc.sell.vo.ResultVO;

/**
 * @author Louis
 * @date Create in 2019/11/4 21:08
 */
public class ResultVOUtil {

    /**
     * 成功，并返回数据
     * @param object
     * @return
     */
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    /**
     * 成功，返回null
     * @return
     */
    public static ResultVO success() {
        return success(null);
    }

    /**
     * 失败，返回错误信息
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
