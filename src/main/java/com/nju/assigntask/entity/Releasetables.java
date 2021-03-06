package com.nju.assigntask.entity;

import java.io.Serializable;

public class Releasetables implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column releasetables.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column releasetables.releaseId
     *
     * @mbg.generated
     */
    private Integer releaseid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column releasetables.inputtable
     *
     * @mbg.generated
     */
    private String inputtable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column releasetables.recommandtable
     *
     * @mbg.generated
     */
    private String recommandtable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column releasetables.algname
     *
     * @mbg.generated
     */
    private String algname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table releasetables
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column releasetables.id
     *
     * @return the value of releasetables.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column releasetables.id
     *
     * @param id the value for releasetables.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column releasetables.releaseId
     *
     * @return the value of releasetables.releaseId
     *
     * @mbg.generated
     */
    public Integer getReleaseid() {
        return releaseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column releasetables.releaseId
     *
     * @param releaseid the value for releasetables.releaseId
     *
     * @mbg.generated
     */
    public void setReleaseid(Integer releaseid) {
        this.releaseid = releaseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column releasetables.inputtable
     *
     * @return the value of releasetables.inputtable
     *
     * @mbg.generated
     */
    public String getInputtable() {
        return inputtable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column releasetables.inputtable
     *
     * @param inputtable the value for releasetables.inputtable
     *
     * @mbg.generated
     */
    public void setInputtable(String inputtable) {
        this.inputtable = inputtable == null ? null : inputtable.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column releasetables.recommandtable
     *
     * @return the value of releasetables.recommandtable
     *
     * @mbg.generated
     */
    public String getRecommandtable() {
        return recommandtable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column releasetables.recommandtable
     *
     * @param recommandtable the value for releasetables.recommandtable
     *
     * @mbg.generated
     */
    public void setRecommandtable(String recommandtable) {
        this.recommandtable = recommandtable == null ? null : recommandtable.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column releasetables.algname
     *
     * @return the value of releasetables.algname
     *
     * @mbg.generated
     */
    public String getAlgname() {
        return algname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column releasetables.algname
     *
     * @param algname the value for releasetables.algname
     *
     * @mbg.generated
     */
    public void setAlgname(String algname) {
        this.algname = algname == null ? null : algname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table releasetables
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
        sb.append(", inputtable=").append(inputtable);
        sb.append(", recommandtable=").append(recommandtable);
        sb.append(", algname=").append(algname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}