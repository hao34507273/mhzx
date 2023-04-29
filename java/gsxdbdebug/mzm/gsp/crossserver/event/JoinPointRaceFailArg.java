/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.point.RolePointRaceMarkingInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinPointRaceFailArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long corpsid;
/*    */   private final long leaderid;
/*    */   private final List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public JoinPointRaceFailArg(long contextid, long corpsid, long leaderid, List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos, int activityCfgid)
/*    */   {
/* 18 */     this.contextid = contextid;
/* 19 */     this.corpsid = contextid;
/* 20 */     this.leaderid = leaderid;
/* 21 */     this.rolePointRaceMarkingInfos = rolePointRaceMarkingInfos;
/* 22 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getContextid()
/*    */   {
/* 32 */     return this.contextid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsid()
/*    */   {
/* 42 */     return this.corpsid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 52 */     return this.leaderid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getActivityCfgid()
/*    */   {
/* 62 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<RolePointRaceMarkingInfo> getRolePointRaceMarkingInfos()
/*    */   {
/* 72 */     return this.rolePointRaceMarkingInfos;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\JoinPointRaceFailArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */