package com.liyang.book.mapper;

import com.liyang.book.entity.Book;
import com.liyang.book.entity.BookExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    int countByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    int deleteByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    int insert(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    int insertSelective(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    List<Book> selectByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    Book selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    int updateByPrimaryKeySelective(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SCOTT.BOOK
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    int updateByPrimaryKey(Book record);

    List<Book> querySome(Map<String, Object> map);

    Book queryByIdWithPics(@Param("id") String id);

    int queryCount(Map<String, Object> tj);

    int queryCountById(@Param("bid") String bid);

    int queryCountToCustomer();

    List<Book> showToCustomer(Map<String, Object> map);
}