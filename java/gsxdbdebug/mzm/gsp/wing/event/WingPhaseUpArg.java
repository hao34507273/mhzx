/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WingPhaseUpArg
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */ 
/*    */   private int oldphase;
/*    */   
/*    */   private int newphase;
/*    */   
/*    */   private int newWingId;
/*    */   
/*    */ 
/*    */   public WingPhaseUpArg(long roleid, int index, int oldphase, int newphase)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.oldphase = oldphase;
/* 21 */     this.newphase = newphase;
/*    */   }
/*    */   
/*    */   public WingPhaseUpArg(long roleid, int oldphase, int newphase)
/*    */   {
/* 26 */     this.roleid = roleid;
/* 27 */     this.oldphase = oldphase;
/* 28 */     this.newphase = newphase;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 38 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getOldphase()
/*    */   {
/* 48 */     return this.oldphase;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getNewphase()
/*    */   {
/* 58 */     return this.newphase;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getIncrement()
/*    */   {
/* 68 */     return this.newphase - this.oldphase;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isGainNewWing()
/*    */   {
/* 78 */     return getNewWingId() > 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getNewWingId()
/*    */   {
/* 88 */     return this.newWingId;
/*    */   }
/*    */   
/*    */   public void setNewWingId(int newWingId)
/*    */   {
/* 93 */     this.newWingId = newWingId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingPhaseUpArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */