/*     */ package mzm.gsp.crossserver.event;
/*     */ 
/*     */ import mzm.gsp.crossserver.main.KnockOutProcessContext;
/*     */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SelectionOrFinalMatchSucceedArg
/*     */ {
/*     */   private final long contextid;
/*     */   private final long leaderid;
/*     */   private final KnockOutTeamInfo ownCrossBattleTeamInfo;
/*     */   private final long opponetLeaderid;
/*     */   private final KnockOutTeamInfo opponentCrossBattleTeamInfo;
/*     */   private final int fightStage;
/*     */   private final int fightType;
/*     */   private final KnockOutProcessContext selectionFinalProcessContext;
/*     */   private final int roamZoneid;
/*     */   private final long roamContextid;
/*     */   private final long createTime;
/*     */   
/*     */   public SelectionOrFinalMatchSucceedArg(long contextid, long leaderid, KnockOutTeamInfo ownCrossBattleTeamInfo, long opponetLeaderid, KnockOutTeamInfo opponentCrossBattleTeamInfo, int roamZoneid, long roamContextid, long createTime, int fightStage, int fightType, KnockOutProcessContext selectionFinalProcessContext)
/*     */   {
/*  29 */     this.contextid = contextid;
/*  30 */     this.leaderid = leaderid;
/*  31 */     this.ownCrossBattleTeamInfo = ownCrossBattleTeamInfo;
/*  32 */     this.opponetLeaderid = opponetLeaderid;
/*  33 */     this.opponentCrossBattleTeamInfo = opponentCrossBattleTeamInfo;
/*  34 */     this.roamZoneid = roamZoneid;
/*  35 */     this.roamContextid = roamContextid;
/*  36 */     this.createTime = createTime;
/*  37 */     this.fightStage = fightStage;
/*  38 */     this.fightType = fightType;
/*  39 */     this.selectionFinalProcessContext = selectionFinalProcessContext;
/*     */   }
/*     */   
/*     */   public KnockOutProcessContext getSelectionFinalProcessContext()
/*     */   {
/*  44 */     return this.selectionFinalProcessContext;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getContextid()
/*     */   {
/*  54 */     return this.contextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getLeaderid()
/*     */   {
/*  64 */     return this.leaderid;
/*     */   }
/*     */   
/*     */   public int getFightStage()
/*     */   {
/*  69 */     return this.fightStage;
/*     */   }
/*     */   
/*     */   public int getFightType()
/*     */   {
/*  74 */     return this.fightType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getOpponentLeaderid()
/*     */   {
/*  83 */     return this.opponetLeaderid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRoamZoneid()
/*     */   {
/*  93 */     return this.roamZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoamContextid()
/*     */   {
/* 103 */     return this.roamContextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getMatchStartTime()
/*     */   {
/* 113 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public KnockOutTeamInfo getOwnCrossBattleTeamInfo()
/*     */   {
/* 118 */     return this.ownCrossBattleTeamInfo;
/*     */   }
/*     */   
/*     */   public long getOpponetLeaderid()
/*     */   {
/* 123 */     return this.opponetLeaderid;
/*     */   }
/*     */   
/*     */   public KnockOutTeamInfo getOpponentCrossBattleTeamInfo()
/*     */   {
/* 128 */     return this.opponentCrossBattleTeamInfo;
/*     */   }
/*     */   
/*     */   public long getCreateTime()
/*     */   {
/* 133 */     return this.createTime;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SelectionOrFinalMatchSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */