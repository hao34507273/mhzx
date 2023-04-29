/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class FloorFightContext implements FightContext
/*    */ {
/*    */   private final int activityId;
/*    */   private final int floor;
/*    */   private final long startTime;
/*    */   
/*    */   public FloorFightContext(int activityId, int floor, long startTime)
/*    */   {
/* 13 */     this.activityId = activityId;
/* 14 */     this.floor = floor;
/* 15 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public int getActivityId()
/*    */   {
/* 26 */     return this.activityId;
/*    */   }
/*    */   
/*    */   public int getFloor()
/*    */   {
/* 31 */     return this.floor;
/*    */   }
/*    */   
/*    */   public long getStartTime()
/*    */   {
/* 36 */     return this.startTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 42 */     return String.format("[activityId=%d|floor=%d|startTime=%d]", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.floor), Long.valueOf(this.startTime) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\FloorFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */