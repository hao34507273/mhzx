/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import hub.RoleSelectionFinalInfo;
/*     */ import hub.SelectionFinalTeamInfo;
/*     */ 
/*     */ public class RoamedKnockOutTeamInfo
/*     */ {
/*     */   private long corpsId;
/*   9 */   private String corpsName = new String();
/*     */   private int corpsBadgeId;
/*     */   private int physZoneId;
/*     */   private int fightZoneId;
/*     */   
/*     */   public int getFightZoneId()
/*     */   {
/*  16 */     return this.fightZoneId;
/*     */   }
/*     */   
/*     */   public void setFightZoneId(int fightZoneId)
/*     */   {
/*  21 */     this.fightZoneId = fightZoneId;
/*     */   }
/*     */   
/*  24 */   private java.util.List<RoamedKnockOutRoleInfo> crossBattleRoleInfoList = new java.util.ArrayList();
/*     */   
/*     */   public RoamedKnockOutTeamInfo(SelectionFinalTeamInfo selectionFinalTeamInfo)
/*     */   {
/*  28 */     this.corpsId = selectionFinalTeamInfo.corps_id;
/*  29 */     this.corpsName = selectionFinalTeamInfo.corps_name.getString("UTF-8");
/*  30 */     this.corpsBadgeId = selectionFinalTeamInfo.corps_badge_id;
/*  31 */     this.physZoneId = selectionFinalTeamInfo.phys_zone_id;
/*  32 */     for (RoleSelectionFinalInfo hubRoleCrossBattleInfo : selectionFinalTeamInfo.cross_battle_role_info_list)
/*     */     {
/*  34 */       RoamedKnockOutRoleInfo roleCrossBattleInfo = new RoamedKnockOutRoleInfo();
/*  35 */       roleCrossBattleInfo.setGender(hubRoleCrossBattleInfo.gender);
/*  36 */       roleCrossBattleInfo.setLevel(hubRoleCrossBattleInfo.level);
/*  37 */       roleCrossBattleInfo.setOccupation(hubRoleCrossBattleInfo.occupation);
/*  38 */       roleCrossBattleInfo.setRoleid(hubRoleCrossBattleInfo.roleid);
/*  39 */       roleCrossBattleInfo.setRoleName(hubRoleCrossBattleInfo.rolename.getString("UTF-8"));
/*  40 */       roleCrossBattleInfo.setUserid(hubRoleCrossBattleInfo.userid.getString("UTF-8"));
/*  41 */       this.crossBattleRoleInfoList.add(roleCrossBattleInfo);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getPhysZoneId()
/*     */   {
/*  47 */     return this.physZoneId;
/*     */   }
/*     */   
/*     */   public void setPhysZoneId(int physZoneId)
/*     */   {
/*  52 */     this.physZoneId = physZoneId;
/*     */   }
/*     */   
/*     */   public void setCrossBattleRoleInfoList(java.util.List<RoamedKnockOutRoleInfo> crossBattleRoleInfoList)
/*     */   {
/*  57 */     this.crossBattleRoleInfoList = crossBattleRoleInfoList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public RoamedKnockOutTeamInfo() {}
/*     */   
/*     */ 
/*     */   public RoamedKnockOutTeamInfo(RoamedKnockOutTeamInfo crossBattleTeamInfo)
/*     */   {
/*  67 */     this.corpsId = crossBattleTeamInfo.corpsId;
/*  68 */     this.corpsName = crossBattleTeamInfo.corpsName;
/*  69 */     this.corpsBadgeId = crossBattleTeamInfo.corpsBadgeId;
/*     */     
/*  71 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : crossBattleTeamInfo.crossBattleRoleInfoList)
/*     */     {
/*  73 */       RoamedKnockOutRoleInfo tempRoleCrossBattleInfo = new RoamedKnockOutRoleInfo(roamedRoleCrossBattleInfo);
/*  74 */       crossBattleTeamInfo.crossBattleRoleInfoList.add(tempRoleCrossBattleInfo);
/*     */     }
/*     */   }
/*     */   
/*     */   public long getCorpsId()
/*     */   {
/*  80 */     return this.corpsId;
/*     */   }
/*     */   
/*     */   public void setCorpsId(long corpsId)
/*     */   {
/*  85 */     this.corpsId = corpsId;
/*     */   }
/*     */   
/*     */   public String getCorpsName()
/*     */   {
/*  90 */     return this.corpsName;
/*     */   }
/*     */   
/*     */   public void setCorpsName(String corpsName)
/*     */   {
/*  95 */     this.corpsName = corpsName;
/*     */   }
/*     */   
/*     */   public int getCorpsBadgeId()
/*     */   {
/* 100 */     return this.corpsBadgeId;
/*     */   }
/*     */   
/*     */   public void setCorpsBadgeId(int corpsBadgeId)
/*     */   {
/* 105 */     this.corpsBadgeId = corpsBadgeId;
/*     */   }
/*     */   
/*     */   public java.util.List<RoamedKnockOutRoleInfo> getCrossBattleRoleInfoList()
/*     */   {
/* 110 */     return this.crossBattleRoleInfoList;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 116 */     StringBuilder sBuilder = new StringBuilder();
/* 117 */     sBuilder.append("RoamedKnockOutTeamInfo={");
/* 118 */     sBuilder.append("|corps_id=").append(this.corpsId);
/* 119 */     sBuilder.append("|corps_name=").append(this.corpsName);
/* 120 */     sBuilder.append("|corps_badge_id=").append(this.corpsBadgeId);
/* 121 */     sBuilder.append("|phys_zone_id=").append(this.physZoneId);
/* 122 */     sBuilder.append("|fight_zone_id=").append(this.fightZoneId);
/*     */     
/* 124 */     return sBuilder.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamedKnockOutTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */