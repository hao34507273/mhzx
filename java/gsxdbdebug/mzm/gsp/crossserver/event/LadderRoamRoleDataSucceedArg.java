/*     */ package mzm.gsp.crossserver.event;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.crossserver.main.MatchActivityContext;
/*     */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LadderRoamRoleDataSucceedArg
/*     */   extends RoamRoleDataSucceedArg
/*     */ {
/*     */   private final long contextid;
/*     */   private final long leaderid;
/*     */   private final List<RoleMatchMarkingInfo> roleMatchMarkingInfos;
/*     */   private final long opponetLeaderid;
/*     */   private final List<RoleMatchMarkingInfo> opponetRoleMatchMarkingInfos;
/*     */   private final MatchActivityContext activityContext;
/*     */   private final int roamZoneid;
/*     */   private final long roamContextid;
/*     */   private final long createTime;
/*     */   
/*     */   public LadderRoamRoleDataSucceedArg(RoamType roamType, long contextid, long leaderid, List<RoleMatchMarkingInfo> roleMatchMarkingInfos, long opponetLeaderid, List<RoleMatchMarkingInfo> opponetRoleMatchMarkingInfos, MatchActivityContext activityContext, int roamZoneid, long roamContextid, long createTime)
/*     */   {
/*  30 */     super(roamType);
/*     */     
/*  32 */     this.contextid = contextid;
/*  33 */     this.leaderid = leaderid;
/*  34 */     this.roleMatchMarkingInfos = roleMatchMarkingInfos;
/*  35 */     this.opponetLeaderid = opponetLeaderid;
/*  36 */     this.opponetRoleMatchMarkingInfos = opponetRoleMatchMarkingInfos;
/*  37 */     this.roamZoneid = roamZoneid;
/*  38 */     this.activityContext = activityContext;
/*  39 */     this.roamContextid = roamContextid;
/*  40 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getContextid()
/*     */   {
/*  50 */     return this.contextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getLeaderid()
/*     */   {
/*  60 */     return this.leaderid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<RoleMatchMarkingInfo> getRoleMatchMarkingInfos()
/*     */   {
/*  70 */     return this.roleMatchMarkingInfos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getOpponentLeaderid()
/*     */   {
/*  80 */     return this.opponetLeaderid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<RoleMatchMarkingInfo> getOpponentRoleMatchMarkingInfos()
/*     */   {
/*  90 */     return this.opponetRoleMatchMarkingInfos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MatchActivityContext getActivityContext()
/*     */   {
/* 100 */     return this.activityContext;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRoamZoneid()
/*     */   {
/* 111 */     return this.roamZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoamContextid()
/*     */   {
/* 121 */     return this.roamContextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getMatchStartTime()
/*     */   {
/* 131 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<RoamRoleInfo> getRoamRoleInfos()
/*     */   {
/* 137 */     return new ArrayList(this.roleMatchMarkingInfos);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\LadderRoamRoleDataSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */