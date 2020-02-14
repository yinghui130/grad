package cn.edu.ldu.grad.pojo;

public class StuExamCheckInfoKey {
    private String ksbh;

    private String kcdm;

    public String getKsbh() {
        return ksbh;
    }

    public void setKsbh(String ksbh) {
        this.ksbh = ksbh == null ? null : ksbh.trim();
    }

    public String getKcdm() {
        return kcdm;
    }

    public void setKcdm(String kcdm) {
        this.kcdm = kcdm == null ? null : kcdm.trim();
    }
}