/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ class RoamFightRecorderCleanObserver extends MilliObserver
/*    */ {
/*    */   private final long recordid;
/*    */   
/*    */   public RoamFightRecorderCleanObserver(long recordid)
/*    */   {
/* 13 */     super(7200000L);
/*    */     
/* 15 */     this.recordid = recordid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 21 */     Xdb.executor().execute(new RCleanRoamFightRecorder(this.recordid));
/*    */     
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RoamFightRecorderCleanObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */