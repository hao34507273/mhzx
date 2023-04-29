/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import xdb.Procedure;
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
/*    */ public class BuffMilliObserver
/*    */   extends MilliObserver
/*    */ {
/*    */   private final long roleId;
/*    */   private final int buffId;
/*    */   private final long installTime;
/*    */   
/*    */   public BuffMilliObserver(long intervalMilliSeconds, long roleId, int buffId, long installTime)
/*    */   {
/* 25 */     super(intervalMilliSeconds);
/* 26 */     this.roleId = roleId;
/* 27 */     this.buffId = buffId;
/* 28 */     this.installTime = installTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 34 */     Procedure.execute(new PBuffTimeEnded(this.roleId, this.buffId, this.installTime));
/* 35 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\BuffMilliObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */