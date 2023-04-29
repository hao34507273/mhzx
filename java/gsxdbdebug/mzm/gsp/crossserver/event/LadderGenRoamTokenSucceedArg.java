/*     */ package mzm.gsp.crossserver.event;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.crossserver.main.MatchActivityContext;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LadderGenRoamTokenSucceedArg
/*     */   extends GenRoamTokenSucceedArg
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
/*     */   public LadderGenRoamTokenSucceedArg(RoamType roamType, long contextid, long leaderid, List<RoleMatchMarkingInfo> roleMatchMarkingInfos, long opponetLeaderid, List<RoleMatchMarkingInfo> opponetRoleMatchMarkingInfos, MatchActivityContext activityContext, int roamZoneid, long roamContextid, long createTime)
/*     */   {
/*  29 */     super(roamType);
/*     */     
/*  31 */     this.contextid = contextid;
/*  32 */     this.leaderid = leaderid;
/*  33 */     this.roleMatchMarkingInfos = roleMatchMarkingInfos;
/*  34 */     this.opponetLeaderid = opponetLeaderid;
/*  35 */     this.opponetRoleMatchMarkingInfos = opponetRoleMatchMarkingInfos;
/*  36 */     this.activityContext = activityContext;
/*  37 */     this.roamZoneid = roamZoneid;
/*  38 */     this.roamContextid = roamContextid;
/*  39 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getContextid()
/*     */   {
/*  49 */     return this.contextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getLeaderid()
/*     */   {
/*  59 */     return this.leaderid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<RoleMatchMarkingInfo> getRoleMatchMarkingInfos()
/*     */   {
/*  69 */     return this.roleMatchMarkingInfos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getOpponentLeaderid()
/*     */   {
/*  79 */     return this.opponetLeaderid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<RoleMatchMarkingInfo> getOpponentRoleMatchMarkingInfos()
/*     */   {
/*  89 */     return this.opponetRoleMatchMarkingInfos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MatchActivityContext getActivityContext()
/*     */   {
/*  99 */     return this.activityContext;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRoamZoneid()
/*     */   {
/* 109 */     return this.roamZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoamContextid()
/*     */   {
/* 119 */     return this.roamContextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getMatchStartTime()
/*     */   {
/* 129 */     return this.createTime;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\LadderGenRoamTokenSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */