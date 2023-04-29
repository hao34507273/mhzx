/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ public class IDIP_ActivieGraphRes
/*    */ {
/*    */   private boolean activeSuc;
/*    */   private ActiveGraphErrReason reason;
/*    */   private StringBuffer sb;
/*    */   
/*    */   public IDIP_ActivieGraphRes() {
/* 10 */     this.sb = new StringBuffer();
/*    */   }
/*    */   
/*    */   void fillSucRes() {
/* 14 */     this.activeSuc = true;
/*    */   }
/*    */   
/*    */   void fillErrRes(ActiveGraphErrReason reason)
/*    */   {
/* 19 */     this.activeSuc = false;
/* 20 */     setReason(reason);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isActiveSuc()
/*    */   {
/* 30 */     return this.activeSuc;
/*    */   }
/*    */   
/*    */   public int getReasonValue()
/*    */   {
/* 35 */     return this.reason.ordinal();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setReason(ActiveGraphErrReason reason)
/*    */   {
/* 45 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   public ActiveGraphErrReason getReason()
/*    */   {
/* 50 */     return this.reason;
/*    */   }
/*    */   
/*    */   public String getTipStr()
/*    */   {
/* 55 */     return this.sb.toString();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static enum ActiveGraphErrReason
/*    */   {
/* 66 */     GRAPH_NULL, 
/* 67 */     GRAPH_NOT_SINGLE, 
/* 68 */     ROLE_TASK_DB_NULL, 
/* 69 */     ROLE_NOT_EXIST;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     private ActiveGraphErrReason() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   void addTip(String str)
/*    */   {
/* 82 */     this.sb.append("\r\n").append(str);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\IDIP_ActivieGraphRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */