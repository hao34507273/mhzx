/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import xbean.HomeOwners;
/*     */ import xtable.Homeworld2roles;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class HomeWorldTeamHandler
/*     */   implements JoinTeamCheckHandler
/*     */ {
/*     */   private final int homeLevel;
/*     */   
/*     */   public HomeWorldTeamHandler(int homeLevel)
/*     */   {
/*  25 */     this.homeLevel = homeLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  32 */     if (roleWorldId == leaderWorldId)
/*     */     {
/*  34 */       JoinTeamResult result = new JoinTeamResult();
/*  35 */       result.setSucceed(true);
/*  36 */       return result;
/*     */     }
/*  38 */     long key = GameServerInfoManager.toGlobalId(leaderWorldId);
/*     */     
/*  40 */     HomeOwners xHomeOwners = Homeworld2roles.select(Long.valueOf(key));
/*  41 */     if (xHomeOwners != null)
/*     */     {
/*  43 */       JoinTeamResult result = new JoinTeamResult();
/*  44 */       result.setSucceed(false);
/*     */       
/*  46 */       if (!HomelandManager.canTransferToHome(leaderWorldId, this.homeLevel, 1))
/*     */       {
/*  48 */         switch (joinTeamType)
/*     */         {
/*     */ 
/*     */         case JOIN_TEAM__INVITE: 
/*  52 */           HomelandManager.sendSCommonResultRes(roleId, 19);
/*     */           
/*     */ 
/*  55 */           break;
/*     */         
/*     */         case JOIN_TEAM__APPLY: 
/*  58 */           HomelandManager.sendSCommonResultRes(teamInfo.getLeaderId(), 19);
/*     */           
/*     */ 
/*  61 */           break;
/*     */         case JOIN_TEAM__PLATFORM: 
/*     */           break;
/*     */         }
/*     */         
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  71 */         result.setSucceed(false);
/*     */ 
/*     */ 
/*     */       }
/*  75 */       else if ((RoleStatusInterface.checkCanSetStatus(roleId, 34, true)) && (RoleStatusInterface.setStatus(roleId, 34, true)))
/*     */       {
/*     */ 
/*  78 */         result.setSucceed(true);
/*     */       }
/*     */       
/*     */ 
/*  82 */       return result;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  87 */     JoinTeamResult result = new JoinTeamResult();
/*  88 */     result.setSucceed(true);
/*  89 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/*  97 */     if (roleWorldId == leaderWorldId)
/*     */     {
/*  99 */       ReturnTeamResult result = new ReturnTeamResult();
/* 100 */       result.setSucceed(true);
/* 101 */       return result;
/*     */     }
/* 103 */     long key = GameServerInfoManager.toGlobalId(leaderWorldId);
/*     */     
/* 105 */     HomeOwners xHomeOwners = Homeworld2roles.select(Long.valueOf(key));
/* 106 */     if (xHomeOwners != null)
/*     */     {
/* 108 */       ReturnTeamResult result = new ReturnTeamResult();
/*     */       
/* 110 */       if (!HomelandManager.canTransferToHome(leaderWorldId, this.homeLevel, 1))
/*     */       {
/* 112 */         HomelandManager.sendSCommonResultRes(roleId, 19);
/* 113 */         result.setSucceed(false);
/*     */ 
/*     */ 
/*     */       }
/* 117 */       else if ((RoleStatusInterface.checkCanSetStatus(roleId, 34, true)) && (RoleStatusInterface.setStatus(roleId, 34, true)))
/*     */       {
/*     */ 
/* 120 */         result.setSucceed(true);
/*     */       }
/*     */       else
/*     */       {
/* 124 */         result.setSucceed(false);
/*     */       }
/*     */       
/*     */ 
/* 128 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 132 */     ReturnTeamResult result = new ReturnTeamResult();
/*     */     
/* 134 */     long k = GameServerInfoManager.toGlobalId(roleWorldId);
/*     */     
/* 136 */     HomeOwners h = Homeworld2roles.select(Long.valueOf(k));
/* 137 */     if (h != null)
/*     */     {
/* 139 */       boolean r = RoleStatusInterface.unsetStatus(roleId, 34);
/* 140 */       result.setSucceed(r);
/*     */     }
/*     */     else
/*     */     {
/* 144 */       result.setSucceed(true);
/*     */     }
/* 146 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\HomeWorldTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */