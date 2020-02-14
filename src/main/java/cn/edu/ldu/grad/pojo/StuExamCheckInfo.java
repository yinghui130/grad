package cn.edu.ldu.grad.pojo;

import java.util.Date;

public class StuExamCheckInfo extends StuExamCheckInfoKey {
    private String xm;

    private String zjhm;

    private String kcmc;

    private Date sumitTime;

    private String originalResult;

    private String checkResult;

    private String telNo;

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm == null ? null : zjhm.trim();
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc == null ? null : kcmc.trim();
    }

    public Date getSumitTime() {
        return sumitTime;
    }

    public void setSumitTime(Date sumitTime) {
        this.sumitTime = sumitTime;
    }

    public String getOriginalResult() {
        return originalResult;
    }

    public void setOriginalResult(String originalResult) {
        this.originalResult = originalResult == null ? null : originalResult.trim();
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }
}