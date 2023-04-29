/*    */ package mzm.gsp.qingyunzhi.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class QingFightBean
/*    */ {
/*  7 */   int xType = -1;
/*  8 */   int fixAwardId = -1;
/*  9 */   int xiaValue = -1;
/*    */   QingFightContext context;
/* 11 */   long passTime = -1L;
/*    */   List<Long> roleInProcessing;
/*    */   
/*    */   public QingFightBean() {
/* 15 */     this.roleInProcessing = new java.util.ArrayList();
/*    */   }
/*    */   
/*    */   public int getxType() {
/* 19 */     return this.xType;
/*    */   }
/*    */   
/*    */   public void setxType(int xType) {
/* 23 */     this.xType = xType;
/*    */   }
/*    */   
/*    */   public int getFixAwardId() {
/* 27 */     return this.fixAwardId;
/*    */   }
/*    */   
/*    */   public void setFixAwardId(int fixAwardId) {
/* 31 */     this.fixAwardId = fixAwardId;
/*    */   }
/*    */   
/*    */   public int getXiaValue() {
/* 35 */     return this.xiaValue;
/*    */   }
/*    */   
/*    */   public void setXiaValue(int xiaValue) {
/* 39 */     this.xiaValue = xiaValue;
/*    */   }
/*    */   
/*    */   public QingFightContext getContext() {
/* 43 */     return this.context;
/*    */   }
/*    */   
/*    */   public void setContext(QingFightContext context) {
/* 47 */     this.context = context;
/*    */   }
/*    */   
/*    */   public long getPassTime() {
/* 51 */     return this.passTime;
/*    */   }
/*    */   
/*    */   public void setPassTime(long passTime) {
/* 55 */     this.passTime = passTime;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleInProcessing() {
/* 59 */     return this.roleInProcessing;
/*    */   }
/*    */   
/*    */   public void setRoleInProcessing(List<Long> roleInProcessing) {
/* 63 */     this.roleInProcessing = roleInProcessing;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\main\QingFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */