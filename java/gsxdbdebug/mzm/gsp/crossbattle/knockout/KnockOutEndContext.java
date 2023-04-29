/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import hub.ExchangeDataHandlerInfo;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KnockOutEndContext
/*     */ {
/*     */   public final int fightType;
/*     */   public final int fightStage;
/*     */   public final int fightIndexId;
/*     */   public final int winOrLose;
/*     */   public final long ownCorpsId;
/*     */   public final String ownCorpsName;
/*     */   public final long opponentCorpsId;
/*     */   public final String opponentCorpsName;
/*     */   public final List<Long> allRoleIdList;
/*     */   public final List<String> allUserIdList;
/*  63 */   private final Set<Long> allOnlineRoles = new HashSet();
/*     */   
/*     */   public final Map<Long, ExchangeDataHandlerInfo> exchangeDataHandlerInfo;
/*     */   
/*     */   public void addOnlineRole(long roleid)
/*     */   {
/*  69 */     this.allOnlineRoles.add(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   public boolean isAllOnline()
/*     */   {
/*  74 */     return this.allOnlineRoles.containsAll(this.allRoleIdList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public KnockOutEndContext(int fightType, int fightStage, int fightIndexId, int winOrLose, long ownCorpsId, String ownCorpsName, long opponentCorpsId, String opponentCorpsName, List<Long> allRoleList, List<String> allUserIdList, Map<Long, ExchangeDataHandlerInfo> exchangeDataHandlerInfo)
/*     */   {
/*  82 */     this.fightType = fightType;
/*  83 */     this.fightStage = fightStage;
/*  84 */     this.fightIndexId = fightIndexId;
/*  85 */     this.winOrLose = winOrLose;
/*  86 */     this.ownCorpsId = ownCorpsId;
/*  87 */     this.ownCorpsName = ownCorpsName;
/*  88 */     this.opponentCorpsId = opponentCorpsId;
/*  89 */     this.opponentCorpsName = opponentCorpsName;
/*  90 */     this.allRoleIdList = allRoleList;
/*  91 */     this.allUserIdList = allUserIdList;
/*  92 */     this.exchangeDataHandlerInfo = exchangeDataHandlerInfo;
/*     */   }
/*     */   
/*     */   public long getLeaderid()
/*     */   {
/*  97 */     return ((Long)this.allRoleIdList.get(0)).longValue();
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 103 */     StringBuilder sb = new StringBuilder();
/* 104 */     sb.append("{");
/* 105 */     sb.append("|fight_type=").append(this.fightType);
/* 106 */     sb.append("|fight_stage=").append(this.fightStage);
/* 107 */     sb.append("|fight_index_id=").append(this.fightIndexId);
/* 108 */     sb.append("|win_or_lose=").append(this.winOrLose);
/* 109 */     sb.append("|own_corps_id=").append(this.ownCorpsId);
/* 110 */     sb.append("|opponent_corps_id=").append(this.opponentCorpsId);
/* 111 */     sb.append("|own_corps_name=").append(this.ownCorpsName);
/* 112 */     sb.append("|opponent_corps_name=").append(this.opponentCorpsName);
/* 113 */     sb.append("|all_role_id_list=").append(this.allRoleIdList.toString());
/*     */     
/* 115 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutEndContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */