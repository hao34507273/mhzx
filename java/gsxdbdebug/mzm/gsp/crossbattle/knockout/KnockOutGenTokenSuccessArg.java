/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenSucceedArg;
/*    */ import mzm.gsp.crossserver.main.KnockOutProcessContext;
/*    */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ 
/*    */ 
/*    */ public class KnockOutGenTokenSuccessArg
/*    */   extends GenRoamTokenSucceedArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long leaderid;
/*    */   private final KnockOutTeamInfo selectionFinalTeamInfo;
/*    */   private final KnockOutProcessContext selectionFinalPhaseContext;
/*    */   private final int fightIndexId;
/*    */   public final int fightType;
/*    */   private final long createTime;
/*    */   
/*    */   public KnockOutGenTokenSuccessArg(RoamType roamType, long contextid, long leaderid, KnockOutTeamInfo selectionFinalTeamInfo, KnockOutProcessContext selectionFinalPhaseContext, int fightIndexId, int fightType, long createTime)
/*    */   {
/* 22 */     super(roamType);
/*    */     
/* 24 */     this.contextid = contextid;
/* 25 */     this.leaderid = leaderid;
/* 26 */     this.selectionFinalTeamInfo = selectionFinalTeamInfo;
/* 27 */     this.selectionFinalPhaseContext = selectionFinalPhaseContext;
/* 28 */     this.fightIndexId = fightIndexId;
/* 29 */     this.fightType = fightType;
/* 30 */     this.createTime = createTime;
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
/*    */   public KnockOutProcessContext getSelectionFinalPhaseContext()
/*    */   {
/* 45 */     return this.selectionFinalPhaseContext;
/*    */   }
/*    */   
/*    */   public int getFightIndexId()
/*    */   {
/* 50 */     return this.fightIndexId;
/*    */   }
/*    */   
/*    */   public long getCreateTime()
/*    */   {
/* 55 */     return this.createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 65 */     return this.leaderid;
/*    */   }
/*    */   
/*    */   public KnockOutTeamInfo getSelectionFinalTeamInfo()
/*    */   {
/* 70 */     return this.selectionFinalTeamInfo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getMatchStartTime()
/*    */   {
/* 80 */     return this.createTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutGenTokenSuccessArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */