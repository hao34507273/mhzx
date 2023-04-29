/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RCleanRoamFightRecorder
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long recordid;
/*    */   
/*    */   RCleanRoamFightRecorder(long recordid)
/*    */   {
/* 33 */     this.recordid = recordid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 39 */     RoamFightRecorderManager.getInstance().removeRoamFightRecorder(this.recordid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RCleanRoamFightRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */