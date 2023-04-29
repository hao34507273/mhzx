/*    */ package mzm.gsp.zhenfa.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import xbean.ZhenfaBean;
/*    */ import xbean.ZhenfaInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleZhenfaInfo
/*    */ {
/*    */   private final long roleId;
/*    */   private final ZhenfaInfo zhenfaInfo;
/*    */   
/*    */   RoleZhenfaInfo(long roleId, ZhenfaInfo zhenfaInfo)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.zhenfaInfo = zhenfaInfo;
/*    */   }
/*    */   
/*    */ 
/* 23 */   public long getRoleID() { return this.roleId; }
/*    */   
/*    */   public ZhenfaBeanInfo getZhenfaBeanInfo(int zhenfaId) {
/* 26 */     if (this.zhenfaInfo == null) {
/* 27 */       return null;
/*    */     }
/* 29 */     for (ZhenfaBean zhenfaBean : this.zhenfaInfo.getZhenfas()) {
/* 30 */       if (zhenfaId == zhenfaBean.getZhenfaid()) {
/* 31 */         return new ZhenfaBeanInfo(zhenfaBean);
/*    */       }
/*    */     }
/* 34 */     return null;
/*    */   }
/*    */   
/*    */   public List<ZhenfaBeanInfo> getAllZhenfaBeans() {
/* 38 */     List<ZhenfaBeanInfo> zhenfaBeans = new ArrayList();
/* 39 */     for (ZhenfaBean zhenfaBean : this.zhenfaInfo.getZhenfas()) {
/* 40 */       zhenfaBeans.add(new ZhenfaBeanInfo(zhenfaBean));
/*    */     }
/* 42 */     return zhenfaBeans;
/*    */   }
/*    */   
/*    */   public int getZhenfaExp(int zhenfaId) {
/* 46 */     return getZhenfaBeanInfo(zhenfaId).getZhenfaexp();
/*    */   }
/*    */   
/* 49 */   public int getZhenfaLevel(int zhenfaId) { return getZhenfaBeanInfo(zhenfaId).getZhenfalevel(); }
/*    */   
/*    */   public static class ZhenfaBeanInfo {
/*    */     private final int zhenfaId;
/*    */     private final int zhenfaexp;
/*    */     private final int zhenfalevel;
/*    */     
/* 56 */     ZhenfaBeanInfo(ZhenfaBean zhenfaBean) { this.zhenfaId = zhenfaBean.getZhenfaid();
/* 57 */       this.zhenfaexp = zhenfaBean.getZhenfaexp();
/* 58 */       this.zhenfalevel = zhenfaBean.getZhenfalevel();
/*    */     }
/*    */     
/* 61 */     public int getZhenfaId() { return this.zhenfaId; }
/*    */     
/*    */     public int getZhenfaexp() {
/* 64 */       return this.zhenfaexp;
/*    */     }
/*    */     
/* 67 */     public int getZhenfalevel() { return this.zhenfalevel; }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\main\RoleZhenfaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */