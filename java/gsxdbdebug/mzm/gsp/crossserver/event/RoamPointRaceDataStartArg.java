/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.point.RolePointRaceMarkingInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoamPointRaceDataStartArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long corpsid;
/*    */   private final long leaderid;
/*    */   private final List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos;
/*    */   private final int activityCfgid;
/*    */   private final int timePointCfgid;
/*    */   
/*    */   public RoamPointRaceDataStartArg(long contextid, long corpsid, long leaderid, List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos, int activityCfgid, int timePointCfgid)
/*    */   {
/* 19 */     this.contextid = contextid;
/* 20 */     this.corpsid = corpsid;
/* 21 */     this.leaderid = leaderid;
/* 22 */     this.rolePointRaceMarkingInfos = rolePointRaceMarkingInfos;
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.timePointCfgid = timePointCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getContextid()
/*    */   {
/* 34 */     return this.contextid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsid()
/*    */   {
/* 44 */     return this.corpsid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 54 */     return this.leaderid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getActivityCfgid()
/*    */   {
/* 64 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<RolePointRaceMarkingInfo> getRolePointRaceMarkingInfos()
/*    */   {
/* 74 */     return this.rolePointRaceMarkingInfos;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getTimePointCfgid()
/*    */   {
/* 84 */     return this.timePointCfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RoamPointRaceDataStartArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */