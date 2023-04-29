/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.point.RolePointRaceMarkingInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinPointRaceSuccessArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long corpsid;
/*    */   private final long leaderid;
/*    */   private final List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public JoinPointRaceSuccessArg(long contextid, long corpsid, long leaderid, List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos, int activityCfgid)
/*    */   {
/* 18 */     this.contextid = contextid;
/* 19 */     this.corpsid = corpsid;
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
/*    */   public List<RolePointRaceMarkingInfo> getRolePointRaceMarkingInfos()
/*    */   {
/* 62 */     return this.rolePointRaceMarkingInfos;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getActivityCfgid()
/*    */   {
/* 72 */     return this.activityCfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\JoinPointRaceSuccessArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */