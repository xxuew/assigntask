package com.nju.assigntask.entity;

import java.io.Serializable;

public class Algresult implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column algresult.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column algresult.releaseId
     *
     * @mbg.generated
     */
    private Integer releaseid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column algresult.algName1
     *
     * @mbg.generated
     */
    private String algname1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column algresult.algName2
     *
     * @mbg.generated
     */
    private String algname2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column algresult.score1
     *
     * @mbg.generated
     */
    private double score1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column algresult.score2
     *
     * @mbg.generated
     */
    private double score2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column algresult.winAlgname
     *
     * @mbg.generated
     */
    private String winalgname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column algresult.iffinal
     *
     * @mbg.generated
     */
    private String iffinal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table algresult
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column algresult.id
     *
     * @return the value of algresult.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column algresult.id
     *
     * @param id the value for algresult.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column algresult.releaseId
     *
     * @return the value of algresult.releaseId
     *
     * @mbg.generated
     */
    public Integer getReleaseid() {
        return releaseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column algresult.releaseId
     *
     * @param releaseid the value for algresult.releaseId
     *
     * @mbg.generated
     */
    public void setReleaseid(Integer releaseid) {
        this.releaseid = releaseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column algresult.algName1
     *
     * @return the value of algresult.algName1
     *
     * @mbg.generated
     */
    public String getAlgname1() {
        return algname1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column algresult.algName1
     *
     * @param algname1 the value for algresult.algName1
     *
     * @mbg.generated
     */
    public void setAlgname1(String algname1) {
        this.algname1 = algname1 == null ? null : algname1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column algresult.algName2
     *
     * @return the value of algresult.algName2
     *
     * @mbg.generated
     */
    public String getAlgname2() {
        return algname2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column algresult.algName2
     *
     * @param algname2 the value for algresult.algName2
     *
     * @mbg.generated
     */
    public void setAlgname2(String algname2) {
        this.algname2 = algname2 == null ? null : algname2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column algresult.score1
     *
     * @return the value of algresult.score1
     *
     * @mbg.generated
     */
    public double getScore1() {
        return score1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column algresult.score1
     *
     * @param score1 the value for algresult.score1
     *
     * @mbg.generated
     */
    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column algresult.score2
     *
     * @return the value of algresult.score2
     *
     * @mbg.generated
     */
    public double getScore2() {
        return score2;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column algresult.winAlgname
     *
     * @return the value of algresult.winAlgname
     *
     * @mbg.generated
     */
    public String getWinalgname() {
        return winalgname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column algresult.winAlgname
     *
     * @param winalgname the value for algresult.winAlgname
     *
     * @mbg.generated
     */
    public void setWinalgname(String winalgname) {
        this.winalgname = winalgname == null ? null : winalgname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column algresult.iffinal
     *
     * @return the value of algresult.iffinal
     *
     * @mbg.generated
     */
    public String getIffinal() {
        return iffinal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column algresult.iffinal
     *
     * @param iffinal the value for algresult.iffinal
     *
     * @mbg.generated
     */
    public void setIffinal(String iffinal) {
        this.iffinal = iffinal == null ? null : iffinal.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table algresult
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", releaseid=").append(releaseid);
        sb.append(", algname1=").append(algname1);
        sb.append(", algname2=").append(algname2);
        sb.append(", score1=").append(score1);
        sb.append(", score2=").append(score2);
        sb.append(", winalgname=").append(winalgname);
        sb.append(", iffinal=").append(iffinal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}