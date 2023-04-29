/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenFailArg;
/*    */ import mzm.gsp.crossserver.main.KnockOutProcessContext;
/*    */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KnockOutGenRoamTokenFailArg
/*    */   extends GenRoamTokenFailArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long leaderid;
/*    */   private final KnockOutTeamInfo selectionFinalTeamInfo;
/*    */   private final KnockOutProcessContext selectionFinalPhaseContext;
/*    */   private final int fightIndexId;
/*    */   private final long createTime;
/*    */   
/*    */   public KnockOutGenRoamTokenFailArg(RoamType roamType, long contextid, long leaderid, KnockOutTeamInfo selectionFinalTeamInfo, KnockOutProcessContext selectionFinalPhaseContext, int fightIndexId, long createTime)
/*    */   {
/* 22 */     super(roamType);
/*    */     
/* 24 */     this.contextid = contextid;
/* 25 */     this.leaderid = leaderid;
/* 26 */     this.selectionFinalTeamInfo = selectionFinalTeamInfo;
/* 27 */     this.selectionFinalPhaseContext = selectionFinalPhaseContext;
/* 28 */     this.fightIndexId = fightIndexId;
/* 29 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getContextid()
/*    */   {
/* 39 */     return this.contextid;
/*    */   }
/*    */   
/*    */   public KnockOutProcessContext getSelectionFinalPhaseContext()
/*    */   {
/* 44 */     return this.selectionFinalPhaseContext;
/*    */   }
/*    */   
/*    */   public int getFightIndexId()
/*    */   {
/* 49 */     return this.fightIndexId;
/*    */   }
/*    */   
/*    */   public long getCreateTime()
/*    */   {
/* 54 */     return this.createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 64 */     return this.leaderid;
/*    */   }
/*    */   
/*    */   public KnockOutTeamInfo getSelectionFinalTeamInfo()
/*    */   {
/* 69 */     return this.selectionFinalTeamInfo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getMatchStartTime()
/*    */   {
/* 79 */     return this.createTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutGenRoamTokenFailArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */