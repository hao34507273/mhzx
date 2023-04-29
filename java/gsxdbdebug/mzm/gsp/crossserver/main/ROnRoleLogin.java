/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.point.PointRaceManager;
/*     */ import mzm.gsp.crossbattle.point.PointRaceZoneManager;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.crosscompete.roam.PTransfer2ActivityMap;
/*     */ import mzm.gsp.crosscompete.roam.RoamEnterContext;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ 
/*     */ public class ROnRoleLogin extends PlayerLoginRunnable
/*     */ {
/*     */   public void process() throws Exception
/*     */   {
/*  18 */     long roleid = ((Long)this.arg).longValue();
/*  19 */     POnRoleLogin proc = new POnRoleLogin(roleid);
/*  20 */     proc.call();
/*     */     
/*  22 */     RoamType roamType = proc.getRoamType();
/*  23 */     if (roamType == null)
/*     */     {
/*  25 */       return;
/*     */     }
/*     */     
/*  28 */     switch (roamType)
/*     */     {
/*     */     case LADDER: 
/*  31 */       RoamedMatchContext roamedMatchContext = proc.getRoamedMatchContext();
/*  32 */       if (roamedMatchContext == null)
/*     */       {
/*  34 */         return;
/*     */       }
/*     */       
/*     */ 
/*  38 */       roamedMatchContext.tryRestoreTeam(roleid);
/*     */       
/*  40 */       if (!roamedMatchContext.isTeamRestore())
/*     */       {
/*  42 */         return;
/*     */       }
/*     */       
/*  45 */       roamedMatchContext.onAllRoleLogined();
/*     */       
/*  47 */       break;
/*     */     case CROSS_COMPETE: 
/*  49 */       RoamEnterContext crossCompeteContext = proc.getCrossCompeteContext();
/*  50 */       if (crossCompeteContext == null)
/*     */       {
/*  52 */         return;
/*     */       }
/*     */       
/*     */ 
/*  56 */       boolean ret = new PTransfer2ActivityMap(roleid, crossCompeteContext.factionid).call();
/*  57 */       if (!ret)
/*     */       {
/*     */ 
/*  60 */         crossCompeteContext.returnOriginalServer();
/*  61 */         CrossCompeteManager.logError("ROnRoleLogin.process@cannot transfer, return original server|roleid=%d", new Object[] { Long.valueOf(roleid) });
/*     */         
/*  63 */         return;
/*     */       }
/*     */       
/*  66 */       if (crossCompeteContext.needRestoreTeam())
/*     */       {
/*     */ 
/*  69 */         crossCompeteContext.tryRestoreTeam(roleid);
/*     */         
/*  71 */         if (!crossCompeteContext.isTeamRestore())
/*     */         {
/*  73 */           return;
/*     */         }
/*     */       }
/*     */       
/*  77 */       crossCompeteContext.onAllRoleLogined();
/*     */       
/*  79 */       break;
/*     */     case CROSS_BATTLE_POINT: 
/*  81 */       RoamedPointRaceContext roamedPointRaceContext = proc.getRoamedPointRaceContext();
/*  82 */       if (roamedPointRaceContext == null)
/*     */       {
/*  84 */         return;
/*     */       }
/*     */       
/*  87 */       long worldid = roamedPointRaceContext.worldid;
/*  88 */       PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/*  89 */       if (zoneManager == null)
/*     */       {
/*  91 */         return;
/*     */       }
/*     */       
/*  94 */       SCrossBattlePointCfg cfg = zoneManager.crossBattlePointCfg;
/*  95 */       MapInterface.transferToScene(roleid, worldid, cfg.remoteMapCfgid, cfg.remoteMapX, cfg.remoteMapY);
/*     */       
/*     */ 
/*  98 */       roamedPointRaceContext.tryRestoreTeam(roleid);
/*  99 */       if (!roamedPointRaceContext.isTeamRestore())
/*     */       {
/* 101 */         return;
/*     */       }
/* 103 */       roamedPointRaceContext.onAllRoleLogined();
/*     */       
/* 105 */       break;
/*     */     case CROSS_BATTLE_SELECTION_FINAL: 
/* 107 */       RoamedKnockOutContext roamedSelectionFinalContext = proc.getRoamedSelectionFinalContext();
/* 108 */       if (roamedSelectionFinalContext == null)
/*     */       {
/* 110 */         return;
/*     */       }
/*     */       
/* 113 */       KnockOutCfg knockOutCfg = roamedSelectionFinalContext.knockOutCfg;
/* 114 */       if (roamedSelectionFinalContext.knockOutCfg != null)
/*     */       {
/* 116 */         MapInterface.transferToScene(roleid, MapInterface.getBigWorldid(), knockOutCfg.out_map_cfg_id, knockOutCfg.out_map_transfer_x, knockOutCfg.out_map_transfer_y);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 121 */       roamedSelectionFinalContext.tryRestoreTeam(roleid);
/* 122 */       if (!roamedSelectionFinalContext.isTeamRestore())
/*     */       {
/* 124 */         return;
/*     */       }
/*     */       
/* 127 */       roamedSelectionFinalContext.onAllRoleLogined();
/* 128 */       break;
/*     */     case SINGLE_CROSS_FIELD: 
/* 130 */       SingleCrossFieldRoamedContext singleCrossFieldRoamedContext = proc.getSingleCrossFieldRoamedContext();
/* 131 */       if (singleCrossFieldRoamedContext == null)
/*     */       {
/* 133 */         return;
/*     */       }
/* 135 */       SingleBattleInterface.joinBattle(singleCrossFieldRoamedContext.getSingleBattleid(), roleid);
/* 136 */       if (!singleCrossFieldRoamedContext.isAllLogined())
/*     */       {
/* 138 */         return;
/*     */       }
/* 140 */       singleCrossFieldRoamedContext.onAllRoleLogined();
/* 141 */       break;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */