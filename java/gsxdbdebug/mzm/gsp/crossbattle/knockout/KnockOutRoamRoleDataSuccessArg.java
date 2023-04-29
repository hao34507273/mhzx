/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedArg;
/*    */ import mzm.gsp.crossserver.main.KnockOutProcessContext;
/*    */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*    */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KnockOutRoamRoleDataSuccessArg
/*    */   extends RoamRoleDataSucceedArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long leaderid;
/*    */   private final KnockOutTeamInfo selectionFinalTeamInfo;
/*    */   private final KnockOutProcessContext selectionFinalPhaseContext;
/*    */   private final int fightIndexId;
/*    */   public final int fightType;
/*    */   private final long createTime;
/*    */   private final int roamZoneId;
/*    */   
/*    */   public KnockOutRoamRoleDataSuccessArg(RoamType roamType, long contextid, long leaderid, KnockOutTeamInfo selectionFinalTeamInfo, KnockOutProcessContext selectionFinalPhaseContext, int fightIndexId, int fightType, long createTime, int roamZoneId)
/*    */   {
/* 27 */     super(roamType);
/*    */     
/* 29 */     this.contextid = contextid;
/* 30 */     this.leaderid = leaderid;
/* 31 */     this.selectionFinalTeamInfo = selectionFinalTeamInfo;
/* 32 */     this.selectionFinalPhaseContext = selectionFinalPhaseContext;
/* 33 */     this.fightIndexId = fightIndexId;
/* 34 */     this.fightType = fightType;
/* 35 */     this.createTime = createTime;
/* 36 */     this.roamZoneId = roamZoneId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getContextid()
/*    */   {
/* 46 */     return this.contextid;
/*    */   }
/*    */   
/*    */   public KnockOutProcessContext getSelectionFinalPhaseContext()
/*    */   {
/* 51 */     return this.selectionFinalPhaseContext;
/*    */   }
/*    */   
/*    */   public int getFightIndexId()
/*    */   {
/* 56 */     return this.fightIndexId;
/*    */   }
/*    */   
/*    */   public long getCreateTime()
/*    */   {
/* 61 */     return this.createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 71 */     return this.leaderid;
/*    */   }
/*    */   
/*    */   public KnockOutTeamInfo getSelectionFinalTeamInfo()
/*    */   {
/* 76 */     return this.selectionFinalTeamInfo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getMatchStartTime()
/*    */   {
/* 86 */     return this.createTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRoamZoneid()
/*    */   {
/* 92 */     return this.roamZoneId;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<RoamRoleInfo> getRoamRoleInfos()
/*    */   {
/* 98 */     return new ArrayList(this.selectionFinalTeamInfo.getCrossBattleRoleInfoList());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutRoamRoleDataSuccessArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */