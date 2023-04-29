/*    */ package mzm.gsp.status.main;
/*    */ 
/*    */ class StatusResult
/*    */ {
/*    */   public final boolean oK;
/*    */   private int singleTipid;
/*    */   private int multiTipid;
/*  8 */   private long roleid = -1L;
/*    */   
/*    */   public StatusResult(boolean oK) {
/* 11 */     this.oK = oK;
/*    */   }
/*    */   
/*    */   void setSingleTipId(int tipId) {
/* 15 */     this.singleTipid = tipId;
/*    */   }
/*    */   
/*    */   public int getSingleTip() {
/* 19 */     return this.singleTipid;
/*    */   }
/*    */   
/*    */   void setMultiTipid(int multiTipid) {
/* 23 */     this.multiTipid = multiTipid;
/*    */   }
/*    */   
/*    */   public int getMultiTipid() {
/* 27 */     return this.multiTipid;
/*    */   }
/*    */   
/*    */   void setWrongRoleid(long roleid) {
/* 31 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public long getWrongRoleid() {
/* 35 */     return this.roleid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\main\StatusResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */