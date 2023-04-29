/*     */ package mzm.gsp.crossserver.event;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.crossserver.main.MatchActivityContext;
/*     */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MatchSucceedArg
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
/*     */   public MatchSucceedArg(long contextid, long leaderid, List<RoleMatchMarkingInfo> roleMatchMarkingInfos, long opponetLeaderid, List<RoleMatchMarkingInfo> opponetRoleMatchMarkingInfos, MatchActivityContext activityContext, int roamZoneid, long roamContextid, long createTime)
/*     */   {
/*  26 */     this.contextid = contextid;
/*  27 */     this.leaderid = leaderid;
/*  28 */     this.roleMatchMarkingInfos = roleMatchMarkingInfos;
/*  29 */     this.opponetLeaderid = opponetLeaderid;
/*  30 */     this.opponetRoleMatchMarkingInfos = opponetRoleMatchMarkingInfos;
/*  31 */     this.roamZoneid = roamZoneid;
/*  32 */     this.activityContext = activityContext;
/*  33 */     this.roamContextid = roamContextid;
/*  34 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getContextid()
/*     */   {
/*  44 */     return this.contextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getLeaderid()
/*     */   {
/*  54 */     return this.leaderid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<RoleMatchMarkingInfo> getRoleMatchMarkingInfos()
/*     */   {
/*  64 */     return this.roleMatchMarkingInfos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getOpponentLeaderid()
/*     */   {
/*  74 */     return this.opponetLeaderid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<RoleMatchMarkingInfo> getOpponentRoleMatchMarkingInfos()
/*     */   {
/*  84 */     return this.opponetRoleMatchMarkingInfos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MatchActivityContext getActivityContext()
/*     */   {
/*  94 */     return this.activityContext;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRoamZoneid()
/*     */   {
/* 104 */     return this.roamZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoamContextid()
/*     */   {
/* 114 */     return this.roamContextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getMatchStartTime()
/*     */   {
/* 124 */     return this.createTime;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\MatchSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */