package cn.edu.ldu.grad.pojo;

import java.util.Date;

public class StudentDocInfo {
  private String zjhm;

  private String xhtxm;

  private String xh;

  private String xm;

  private String lqzymc;

  private String lqyxsmc;

  private String lqxxfsmc;

  private String xz;

  private String daszdw;

  private String lqlbm;

  public String getLqlbm() {
    return lqlbm;
  }

  public void setLqlbm(String lqlbm) {
    this.lqlbm = lqlbm;
  }

  private Date downloadDate;

  public String getZjhm() {
    return zjhm;
  }

  public void setZjhm(String zjhm) {
    this.zjhm = zjhm == null ? null : zjhm.trim();
  }

  public String getXhtxm() {
    return xhtxm;
  }

  public void setXhtxm(String xhtxm) {
    this.xhtxm = xhtxm == null ? null : xhtxm.trim();
  }

  public String getXh() {
    return xh;
  }

  public void setXh(String xh) {
    this.xh = xh == null ? null : xh.trim();
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm == null ? null : xm.trim();
  }

  public String getLqzymc() {
    return lqzymc;
  }

  public void setLqzymc(String lqzymc) {
    this.lqzymc = lqzymc == null ? null : lqzymc.trim();
  }

  public String getLqyxsmc() {
    return lqyxsmc;
  }

  public void setLqyxsmc(String lqyxsmc) {
    this.lqyxsmc = lqyxsmc == null ? null : lqyxsmc.trim();
  }

  public String getLqxxfsmc() {
    return lqxxfsmc;
  }

  public void setLqxxfsmc(String lqxxfsmc) {
    this.lqxxfsmc = lqxxfsmc == null ? null : lqxxfsmc.trim();
  }

  public String getXz() {
    return xz;
  }

  public void setXz(String xz) {
    this.xz = xz == null ? null : xz.trim();
  }

  public String getDaszdw() {
    return daszdw;
  }

  public void setDaszdw(String daszdw) {
    this.daszdw = daszdw == null ? null : daszdw.trim();
  }

  public Date getDownloadDate() {
    return downloadDate;
  }

  public void setDownloadDate(Date downloadDate) {
    this.downloadDate = downloadDate;
  }
}
