package com.liyang.book.entity;

import java.util.Date;

public class Bookpic {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SCOTT.BOOKPIC.ID
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SCOTT.BOOKPIC.SAVEPATH
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    private String savepath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SCOTT.BOOKPIC.SHOWNAME
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    private String showname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SCOTT.BOOKPIC.UPLOADTIME
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    private Date uploadtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SCOTT.BOOKPIC.FM
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    private Short fm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SCOTT.BOOKPIC.BOOKID
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    private String bookid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SCOTT.BOOKPIC.ID
     *
     * @return the value of SCOTT.BOOKPIC.ID
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SCOTT.BOOKPIC.ID
     *
     * @param id the value for SCOTT.BOOKPIC.ID
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SCOTT.BOOKPIC.SAVEPATH
     *
     * @return the value of SCOTT.BOOKPIC.SAVEPATH
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public String getSavepath() {
        return savepath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SCOTT.BOOKPIC.SAVEPATH
     *
     * @param savepath the value for SCOTT.BOOKPIC.SAVEPATH
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public void setSavepath(String savepath) {
        this.savepath = savepath == null ? null : savepath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SCOTT.BOOKPIC.SHOWNAME
     *
     * @return the value of SCOTT.BOOKPIC.SHOWNAME
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public String getShowname() {
        return showname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SCOTT.BOOKPIC.SHOWNAME
     *
     * @param showname the value for SCOTT.BOOKPIC.SHOWNAME
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public void setShowname(String showname) {
        this.showname = showname == null ? null : showname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SCOTT.BOOKPIC.UPLOADTIME
     *
     * @return the value of SCOTT.BOOKPIC.UPLOADTIME
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public Date getUploadtime() {
        return uploadtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SCOTT.BOOKPIC.UPLOADTIME
     *
     * @param uploadtime the value for SCOTT.BOOKPIC.UPLOADTIME
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SCOTT.BOOKPIC.FM
     *
     * @return the value of SCOTT.BOOKPIC.FM
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public Short getFm() {
        return fm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SCOTT.BOOKPIC.FM
     *
     * @param fm the value for SCOTT.BOOKPIC.FM
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public void setFm(Short fm) {
        this.fm = fm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SCOTT.BOOKPIC.BOOKID
     *
     * @return the value of SCOTT.BOOKPIC.BOOKID
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public String getBookid() {
        return bookid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SCOTT.BOOKPIC.BOOKID
     *
     * @param bookid the value for SCOTT.BOOKPIC.BOOKID
     *
     * @mbggenerated Sun Jul 28 17:37:35 CST 2019
     */
    public void setBookid(String bookid) {
        this.bookid = bookid == null ? null : bookid.trim();
    }
}