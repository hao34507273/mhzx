/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*     */ import mzm.gsp.map.main.message.MMH_PreCheckStartMonsterFight;
/*     */ import mzm.gsp.map.main.message.MMH_StartMonsterFight;
/*     */ import mzm.gsp.monster.confbean.SBaseBrightMonster;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ 
/*     */ public class PStartMonsterFight
/*     */   extends LogicProcedure
/*     */   implements MapCallback<SMapVisibleMonster>
/*     */ {
/*     */   private final long roleId;
/*     */   private final int instanceId;
/*     */   
/*     */   public PStartMonsterFight(long roleId, int instanceId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.instanceId = instanceId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!MapManager.canDoAction(this.roleId, 163))
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  38 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 0, true))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     new MMH_PreCheckStartMonsterFight(this.roleId, this.instanceId, this).execute();
/*     */     
/*  45 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onResult(SMapVisibleMonster mapVisibleMonster)
/*     */   {
/*  57 */     if (mapVisibleMonster == null)
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (!MapManager.canDoAction(this.roleId, 163))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 0, true))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     SBaseBrightMonster cfg = MapManager.getBaseBrightMonster(mapVisibleMonster);
/*  74 */     if (checkCanFight(this.roleId, cfg) != 0)
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     new MMH_StartMonsterFight(this.roleId, this.instanceId).execute();
/*     */     
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   private static int checkCanFight(long roleId, SBaseBrightMonster cfg)
/*     */   {
/*  86 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/*  87 */     Set<Long> memberSet = new HashSet();
/*  88 */     if (teamId != null)
/*     */     {
/*  90 */       TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), false);
/*  91 */       if (teamInfo != null)
/*     */       {
/*  93 */         if (teamInfo.getLeaderId() != roleId)
/*     */         {
/*  95 */           return -1;
/*     */         }
/*  97 */         memberSet.addAll(teamInfo.getTeamNormalList());
/*     */       }
/*     */     }
/* 100 */     memberSet.add(Long.valueOf(roleId));
/* 101 */     int memberSize = memberSet.size();
/* 102 */     if ((cfg.enterFightMaxRoleNum < memberSize) || (cfg.enterFightMinRoleNum > memberSize))
/*     */     {
/* 104 */       return -1; }
/*     */     int lv;
/* 106 */     switch (cfg.enterFightLevelType)
/*     */     {
/*     */     case 1: 
/* 109 */       lv = RoleInterface.getLevel(roleId);
/* 110 */       if ((lv > cfg.enterFightMaxLevel) || (lv < cfg.enterFightMinLevel))
/*     */       {
/* 112 */         return -1;
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 116 */       int totalLevel = 0;
/* 117 */       for (Long memberId : memberSet)
/*     */       {
/* 119 */         totalLevel += RoleInterface.getLevel(memberId.longValue());
/*     */       }
/* 121 */       lv = totalLevel / memberSize;
/* 122 */       if ((lv > cfg.enterFightMaxLevel) || (lv < cfg.enterFightMinLevel))
/*     */       {
/* 124 */         return -1;
/*     */       }
/*     */       break;
/*     */     case 3: 
/* 128 */       int maxLevel = 0;
/* 129 */       for (Long memberId : memberSet)
/*     */       {
/* 131 */         maxLevel = Math.max(maxLevel, RoleInterface.getLevel(memberId.longValue()));
/*     */       }
/* 133 */       if ((maxLevel > cfg.enterFightMaxLevel) || (maxLevel < cfg.enterFightMinLevel))
/*     */       {
/* 135 */         return -1;
/*     */       }
/*     */       break;
/*     */     case 4: 
/* 139 */       int minLevel = RoleInterface.getLevel(roleId);
/* 140 */       for (Long memberId : memberSet)
/*     */       {
/* 142 */         minLevel = Math.min(minLevel, RoleInterface.getLevel(memberId.longValue()));
/*     */       }
/* 144 */       if ((minLevel > cfg.enterFightMaxLevel) || (minLevel < cfg.enterFightMinLevel))
/*     */       {
/* 146 */         return -1;
/*     */       }
/*     */       break;
/*     */     default: 
/* 150 */       return -1;
/*     */     }
/* 152 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PStartMonsterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */