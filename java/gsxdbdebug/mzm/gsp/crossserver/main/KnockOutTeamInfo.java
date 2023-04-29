/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import hub.RoleSelectionFinalInfo;
/*     */ import hub.SelectionFinalTeamInfo;
/*     */ import java.util.List;
/*     */ 
/*     */ public class KnockOutTeamInfo
/*     */ {
/*     */   private final long corpsId;
/*     */   private final String corpsName;
/*     */   private final int corpsBadgeId;
/*     */   private final int zoneId;
/*     */   private final long opponentCorpsId;
/*     */   private String opponentCorpsName;
/*  15 */   private List<KnockOutRoleInfo> knockOutRoleInfoList = new java.util.ArrayList();
/*     */   
/*  17 */   private volatile String basicCache = null;
/*     */   
/*     */ 
/*     */   public KnockOutTeamInfo(long corpsId, String corpsName, int corpsBadgeId, int zoneId, long opponentCorpsId, String opponentCorpsName)
/*     */   {
/*  22 */     this.corpsId = corpsId;
/*  23 */     this.corpsName = corpsName;
/*  24 */     this.corpsBadgeId = corpsBadgeId;
/*  25 */     this.zoneId = zoneId;
/*  26 */     this.opponentCorpsId = opponentCorpsId;
/*  27 */     this.opponentCorpsName = opponentCorpsName;
/*     */   }
/*     */   
/*     */   public KnockOutTeamInfo(SelectionFinalTeamInfo selectionFinalTeamInfo)
/*     */   {
/*  32 */     this.corpsId = selectionFinalTeamInfo.corps_id;
/*  33 */     this.corpsName = selectionFinalTeamInfo.corps_name.getString("UTF-8");
/*  34 */     this.corpsBadgeId = selectionFinalTeamInfo.corps_badge_id;
/*  35 */     this.opponentCorpsId = selectionFinalTeamInfo.opponent_corps_id;
/*  36 */     this.zoneId = selectionFinalTeamInfo.phys_zone_id;
/*  37 */     for (RoleSelectionFinalInfo hubRoleCrossBattleInfo : selectionFinalTeamInfo.cross_battle_role_info_list)
/*     */     {
/*  39 */       String userId = hubRoleCrossBattleInfo.userid.getString("UTF-8");
/*  40 */       String roleName = hubRoleCrossBattleInfo.rolename.getString("UTF-8");
/*  41 */       KnockOutRoleInfo roleCrossBattleInfo = new KnockOutRoleInfo(userId, hubRoleCrossBattleInfo.roleid, roleName, hubRoleCrossBattleInfo.level, hubRoleCrossBattleInfo.gender, hubRoleCrossBattleInfo.occupation, hubRoleCrossBattleInfo.avatarid);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  47 */       this.knockOutRoleInfoList.add(roleCrossBattleInfo);
/*     */     }
/*     */   }
/*     */   
/*     */   public KnockOutTeamInfo(KnockOutTeamInfo crossBattleTeamInfo)
/*     */   {
/*  53 */     this.corpsId = crossBattleTeamInfo.corpsId;
/*  54 */     this.corpsName = crossBattleTeamInfo.corpsName;
/*  55 */     this.corpsBadgeId = crossBattleTeamInfo.corpsBadgeId;
/*  56 */     this.opponentCorpsId = crossBattleTeamInfo.opponentCorpsId;
/*  57 */     this.opponentCorpsName = crossBattleTeamInfo.opponentCorpsName;
/*  58 */     this.zoneId = crossBattleTeamInfo.zoneId;
/*  59 */     for (KnockOutRoleInfo roleCrossBattleInfo : crossBattleTeamInfo.knockOutRoleInfoList)
/*     */     {
/*  61 */       KnockOutRoleInfo tempRoleCrossBattleInfo = new KnockOutRoleInfo(roleCrossBattleInfo);
/*  62 */       this.knockOutRoleInfoList.add(tempRoleCrossBattleInfo);
/*     */     }
/*     */   }
/*     */   
/*     */   public long getOpponentCorpsId()
/*     */   {
/*  68 */     return this.opponentCorpsId;
/*     */   }
/*     */   
/*     */   public int getZoneId()
/*     */   {
/*  73 */     return this.zoneId;
/*     */   }
/*     */   
/*     */   public String getOpponentCorpsName()
/*     */   {
/*  78 */     return this.opponentCorpsName;
/*     */   }
/*     */   
/*     */   public long getCorpsId()
/*     */   {
/*  83 */     return this.corpsId;
/*     */   }
/*     */   
/*     */   public String getCorpsName()
/*     */   {
/*  88 */     return this.corpsName;
/*     */   }
/*     */   
/*     */   public int getCorpsBadgeId()
/*     */   {
/*  93 */     return this.corpsBadgeId;
/*     */   }
/*     */   
/*     */   public List<KnockOutRoleInfo> getCrossBattleRoleInfoList()
/*     */   {
/*  98 */     return this.knockOutRoleInfoList;
/*     */   }
/*     */   
/*     */   public void setCrossBattleRoleInfoList(List<KnockOutRoleInfo> crossBattleRoleInfoList)
/*     */   {
/* 103 */     this.knockOutRoleInfoList = crossBattleRoleInfoList;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 109 */     if (this.basicCache != null)
/*     */     {
/* 111 */       return this.basicCache;
/*     */     }
/*     */     
/* 114 */     StringBuilder sb = new StringBuilder();
/* 115 */     sb.append("corpsId=").append(this.corpsId);
/* 116 */     sb.append("corpsName=").append(this.corpsName);
/* 117 */     sb.append("corpsBadgeId=").append(this.corpsBadgeId);
/* 118 */     sb.append("zoneId=").append(this.zoneId);
/* 119 */     sb.append("opponentCorpsId=").append(this.opponentCorpsId);
/* 120 */     sb.append("opponentCorpsName=").append(this.opponentCorpsName);
/*     */     
/* 122 */     for (KnockOutRoleInfo knockOutRoleInfo : this.knockOutRoleInfoList)
/*     */     {
/* 124 */       sb.append(knockOutRoleInfo);
/*     */     }
/*     */     
/* 127 */     this.basicCache = sb.toString();
/* 128 */     return this.basicCache;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\KnockOutTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */