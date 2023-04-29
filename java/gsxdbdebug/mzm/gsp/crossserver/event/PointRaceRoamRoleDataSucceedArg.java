/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.point.RolePointRaceMarkingInfo;
/*    */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PointRaceRoamRoleDataSucceedArg
/*    */   extends RoamRoleDataSucceedArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long corpsid;
/*    */   private final long leaderid;
/*    */   private final List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos;
/*    */   private final int roamZoneid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PointRaceRoamRoleDataSucceedArg(RoamType roamType, long contextid, long corpsid, long leaderid, List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos, int roamZoneid, int activityCfgid)
/*    */   {
/* 23 */     super(roamType);
/*    */     
/* 25 */     this.contextid = contextid;
/* 26 */     this.corpsid = corpsid;
/* 27 */     this.leaderid = leaderid;
/* 28 */     this.rolePointRaceMarkingInfos = rolePointRaceMarkingInfos;
/* 29 */     this.roamZoneid = roamZoneid;
/* 30 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getContextid()
/*    */   {
/* 40 */     return this.contextid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsid()
/*    */   {
/* 50 */     return this.corpsid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 60 */     return this.leaderid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<RolePointRaceMarkingInfo> getRolePointRaceMarkingInfos()
/*    */   {
/* 70 */     return this.rolePointRaceMarkingInfos;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getActivityCfgid()
/*    */   {
/* 80 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<RoamRoleInfo> getRoamRoleInfos()
/*    */   {
/* 86 */     return new ArrayList(this.rolePointRaceMarkingInfos);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRoamZoneid()
/*    */   {
/* 97 */     return this.roamZoneid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\PointRaceRoamRoleDataSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */