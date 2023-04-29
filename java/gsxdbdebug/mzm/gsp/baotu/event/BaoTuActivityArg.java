/*    */ package mzm.gsp.baotu.event;
/*    */ 
/*    */ public class BaoTuActivityArg {
/*    */   private long roleid;
/*    */   private int activityId;
/*    */   private int oldcount;
/*    */   private int newcount;
/*    */   
/*    */   public BaoTuActivityArg(long roleid, int activityid, int oldcount, int newcount) {
/* 10 */     this.roleid = roleid;
/* 11 */     this.activityId = activityid;
/* 12 */     this.oldcount = oldcount;
/* 13 */     this.newcount = newcount;
/*    */   }
/*    */   
/* 16 */   public int getActivityId() { return this.activityId; }
/*    */   
/*    */   public int getOldcount() {
/* 19 */     return this.oldcount;
/*    */   }
/*    */   
/* 22 */   public int getNewcount() { return this.newcount; }
/*    */   
/*    */   public long getRoleid() {
/* 25 */     return this.roleid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\event\BaoTuActivityArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */