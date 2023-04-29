/*    */ package mzm.gsp.worldgoal.event;
/*    */ 
/*    */ public class SectionPonitChangeArg
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int sectionid;
/*    */   private final int point;
/*    */   private final long timestamp;
/*    */   
/*    */   public SectionPonitChangeArg(int activityCfgid, int sectionid, int point, long timestamp)
/*    */   {
/* 12 */     this.activityCfgid = activityCfgid;
/* 13 */     this.sectionid = sectionid;
/* 14 */     this.point = point;
/* 15 */     this.timestamp = timestamp;
/*    */   }
/*    */   
/*    */   public int getActivityCfgid()
/*    */   {
/* 20 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */   public int getSectionid()
/*    */   {
/* 25 */     return this.sectionid;
/*    */   }
/*    */   
/*    */   public int getPoint()
/*    */   {
/* 30 */     return this.point;
/*    */   }
/*    */   
/*    */   public long getTimestamp()
/*    */   {
/* 35 */     return this.timestamp;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\event\SectionPonitChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */