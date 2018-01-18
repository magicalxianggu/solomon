package com.magical.score.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询结果
 * Created by asus on 2017/8/1.
 */
@AllArgsConstructor
@ToString
public class PagingResult<T> implements Serializable {

    private static final long serialVersionUID = 3739432000715879711L;
    /**
     * 当前页码
     */
    @Getter
    @Setter
    private int page;
    /**
     * 总记录数
     */
    @Getter @Setter
    private long total;
    /**
     * 每页记录数
     */
    @Getter @Setter
    private int pageSize;
    /**
     * 每页数据记录
     */
    @Getter @Setter
    private List<T> rows;


}