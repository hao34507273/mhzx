/*    */ package mzm.gsp.jingji.event;
/*    */ 
/*    */ public class JingjiActivityArg
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityId;
/*    */   private final boolean iswin;
/*    */   private final int activityCount;
/*    */   
/*    */   public JingjiActivityArg(long roleid, int activityid, boolean iswin, int activityCount)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.activityId = activityid;
/* 14 */     this.iswin = iswin;
/* 15 */     this.activityCount = activityCount;
/*    */   }
/*    */   
/*    */   public int getActivityId()
/*    */   {
/* 20 */     return this.activityId;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 25 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public boolean isIswin()
/*    */   {
/* 30 */     return this.iswin;
/*    */   }
/*    */   
/*    */   public int getActivityCount()
/*    */   {
/* 35 */     return this.activityCount;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\event\JingjiActivityArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */