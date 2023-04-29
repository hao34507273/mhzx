/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.util.Pair;
/*     */ import mzm.gsp.wing.confbean.SWingLvUpCfg;
/*     */ import mzm.gsp.wing.confbean.SWingRankCfg;
/*     */ import xbean.AllWingPlans;
/*     */ import xbean.TransferOccupationWing;
/*     */ import xbean.WingPlan;
/*     */ 
/*     */ public class PGM_WingLevelTo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long gmRoleId;
/*     */   private final long roleId;
/*     */   private final int level;
/*     */   
/*     */   public PGM_WingLevelTo(long gmRoleId, long roleId, int level)
/*     */   {
/*  24 */     this.gmRoleId = gmRoleId;
/*  25 */     this.roleId = roleId;
/*  26 */     this.level = level;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  33 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  34 */     if (xWingPlan == null)
/*     */     {
/*     */ 
/*  37 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "该玩家没有羽翼，请先开启羽翼功能！");
/*  38 */       return false;
/*     */     }
/*  40 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  42 */     Pair<Integer, Map<Integer, Integer>> maxRankInfo = getRoleCanTouchLevel(mzm.gsp.role.main.RoleInterface.getLevel(this.roleId));
/*  43 */     if ((maxRankInfo == null) || (((Integer)maxRankInfo.first).intValue() < 0))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     int maxWingLevel = getMaxWingLevel(((Integer)maxRankInfo.first).intValue());
/*  48 */     if (maxWingLevel < 0)
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     int realWingLevel = Math.min(maxWingLevel, this.level);
/*     */     
/*  54 */     SWingLvUpCfg levelUpCfg = SWingLvUpCfg.get(realWingLevel);
/*  55 */     int realRank = levelUpCfg.needrank;
/*     */     
/*  57 */     if (xPlan.getxWingPlan().getCurlv() >= realWingLevel)
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     if (xPlan.getxWingPlan().getCurrank() > realRank)
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     for (Iterator i$ = getCanAddWingId(realRank, xPlan.getxWingPlan().getCurrank()).iterator(); i$.hasNext();) { int wingInfoId = ((Integer)i$.next()).intValue();
/*     */       
/*  69 */       if (!WingManager.getNewWing(xPlan, wingInfoId))
/*     */       {
/*  71 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  75 */     if (!updateOccData(realWingLevel, realRank, roleWingInfo.getxWingPlans()))
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     xWingPlan.setCurlv(realWingLevel);
/*  80 */     xWingPlan.setCurrank(realRank);
/*     */     
/*  82 */     mzm.gsp.online.main.OnlineManager.getInstance().forceReconnect(this.roleId);
/*  83 */     return true;
/*     */   }
/*     */   
/*     */   private boolean updateOccData(int realWingLevel, int realRank, AllWingPlans xAllWingPlans)
/*     */   {
/*  88 */     Map<Integer, TransferOccupationWing> xTransferOccupationWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/*  89 */     for (Map.Entry<Integer, TransferOccupationWing> entry : xTransferOccupationWingMap.entrySet())
/*     */     {
/*  91 */       if (((Integer)entry.getKey()).intValue() != xAllWingPlans.getEffectwingoccid())
/*     */       {
/*     */ 
/*     */ 
/*  95 */         WingPlan xWingPlan = (WingPlan)((TransferOccupationWing)entry.getValue()).getWings().get(Integer.valueOf(1));
/*  96 */         if (xWingPlan == null)
/*     */         {
/*  98 */           return false;
/*     */         }
/* 100 */         xWingPlan.setCurrank(realRank);
/* 101 */         xWingPlan.setCurlv(realWingLevel);
/*     */       } }
/* 103 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Integer> getCanAddWingId(int endRank, int fromRank)
/*     */   {
/* 115 */     Set<Integer> canAddWingIds = new java.util.HashSet();
/* 116 */     for (SWingRankCfg cfg : SWingRankCfg.getAll().values())
/*     */     {
/* 118 */       if ((cfg.rank <= endRank) && (cfg.rank > fromRank))
/*     */       {
/* 120 */         canAddWingIds.add(Integer.valueOf(cfg.wingInfoId));
/*     */       }
/*     */     }
/* 123 */     return canAddWingIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Pair<Integer, Map<Integer, Integer>> getRoleCanTouchLevel(int roleLevel)
/*     */   {
/* 134 */     Map<Integer, Integer> canAddRanks = new HashMap();
/* 135 */     int rankMax = -1;
/* 136 */     for (SWingRankCfg cfg : SWingRankCfg.getAll().values())
/*     */     {
/* 138 */       int needRoleLv = cfg.upNeedRoleLv;
/* 139 */       if (needRoleLv <= roleLevel)
/*     */       {
/*     */ 
/*     */ 
/* 143 */         if (rankMax <= cfg.rank)
/*     */         {
/* 145 */           rankMax = cfg.rank;
/*     */         }
/* 147 */         canAddRanks.put(Integer.valueOf(needRoleLv), Integer.valueOf(cfg.rank));
/*     */       } }
/* 149 */     if (rankMax < 0)
/*     */     {
/* 151 */       return null;
/*     */     }
/* 153 */     return new Pair(Integer.valueOf(rankMax), new HashMap(canAddRanks));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getMaxWingLevel(int rank)
/*     */   {
/* 164 */     if (rank < 0)
/*     */     {
/* 166 */       return -1;
/*     */     }
/* 168 */     int maxlevel = -1;
/* 169 */     for (SWingLvUpCfg cfg : SWingLvUpCfg.getAll().values())
/*     */     {
/* 171 */       if (cfg.needrank == rank)
/*     */       {
/*     */ 
/*     */ 
/* 175 */         if (cfg.level >= maxlevel)
/*     */         {
/* 177 */           maxlevel = cfg.level; }
/*     */       }
/*     */     }
/* 180 */     return maxlevel;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PGM_WingLevelTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */