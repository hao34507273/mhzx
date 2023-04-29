/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class ExploreObserver extends Observer
/*    */ {
/*    */   private final long roleid;
/*    */   private final long catid;
/*    */   
/*    */   public ExploreObserver(long intervalSeconds, long roleid, long catid)
/*    */   {
/* 12 */     super(intervalSeconds);
/*    */     
/* 14 */     this.roleid = roleid;
/* 15 */     this.catid = catid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 21 */     new PHandleOnExploreEnd(this.roleid, this.catid).execute();
/*    */     
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\ExploreObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */