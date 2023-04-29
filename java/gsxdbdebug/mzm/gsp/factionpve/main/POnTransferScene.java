/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.event.MapTransferArg;
/*     */ import xbean.FactionPVETmp;
/*     */ import xbean.RoleFactionPVE;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class POnTransferScene extends mzm.gsp.map.event.PlayerTransferSceneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  17 */     if (!FactionPVEConfigManager.isActivityMap(((MapTransferArg)this.arg).oldMapCfgId)) {
/*  18 */       if (!FactionPVEConfigManager.isActivityMap(((MapTransferArg)this.arg).newMapCfgId)) {
/*  19 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  25 */       lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*     */       
/*  27 */       Gang faction = GangInterface.getGangByRoleId(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), true);
/*     */       
/*  29 */       if (faction == null) {
/*  30 */         FactionPVEManager.logError("POnTransferScene.processImp@enter pve map|roles=%s|src_world=%d|src_mapid=%d|dst_world=%d|dst_mapid=%d", new Object[] { ((MapTransferArg)this.arg).roleList, Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */         
/*     */ 
/*  33 */         return false;
/*     */       }
/*     */       
/*  36 */       FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(faction.getGangId());
/*     */       Iterator i$;
/*  38 */       if (xFactionPVETmp.getStage() > 1) {
/*  39 */         for (i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  40 */           RoleFactionPVE xRolePVE = FactionPVEManager.getXRoleFactionPVEIfNotExist(r);
/*     */           
/*  42 */           FactionPVEManager.syncSelfKillMonster(r, xRolePVE);
/*     */           
/*  44 */           if (xFactionPVETmp.getStage() == 2)
/*     */           {
/*  46 */             FactionPVEManager.syncFactionKillMonster(r, xFactionPVETmp);
/*     */           }
/*  48 */           else if (xFactionPVETmp.getStage() >= 4)
/*     */           {
/*     */ 
/*  51 */             FactionPVEManager.sendKillBossCount(r, xFactionPVETmp);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  57 */       FactionPVEManager.logInfo("POnTransferScene.processImp@enter|roles=%s|src_world=%d|src_map=%d|dst_world=%d|dst_map=%d", new Object[] { ((MapTransferArg)this.arg).roleList, Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */       
/*     */ 
/*     */ 
/*  61 */       FactionPVEManager.broadcastPlayCount(((MapTransferArg)this.arg).newWorldId);
/*     */ 
/*     */     }
/*  64 */     else if (FactionPVEConfigManager.isActivityMap(((MapTransferArg)this.arg).newMapCfgId)) {
/*  65 */       if ((((MapTransferArg)this.arg).oldMapCfgId != SFactionPVEConsts.getInstance().FightMap) && (((MapTransferArg)this.arg).newMapCfgId == SFactionPVEConsts.getInstance().FightMap))
/*     */       {
/*  67 */         FactionPVEManager.logInfo("POnTransferScene.processImp@enter fight map from prepare map|roles=%s|src_world=%d|src_map=%d|dst_world=%d|dst_map=%d", new Object[] { ((MapTransferArg)this.arg).roleList, Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  74 */       lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*     */       
/*     */ 
/*  77 */       for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  78 */         FactionPVEManager.clearActivityStatus(r);
/*     */       }
/*     */       
/*  81 */       FactionPVEManager.logInfo("POnTransferScene.processImp@leave|roles=%s|src_world=%d|src_map=%d|dst_world=%d|dst_map=%d", new Object[] { ((MapTransferArg)this.arg).roleList, Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  86 */       Gang faction = GangInterface.getGangByRoleId(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), true);
/*  87 */       if (faction == null) {
/*  88 */         FactionPVEManager.logInfo("POnTransferScene.processImp@leave err, faction null|roles=%s|src_world=%d|src_map=%d|dst_world=%d|dst_map=%d", new Object[] { ((MapTransferArg)this.arg).roleList, Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */         
/*     */ 
/*  91 */         return false;
/*     */       }
/*     */       
/*  94 */       FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(faction.getGangId());
/*  95 */       if (xFactionPVETmp.getStage() != 6) {
/*  96 */         FactionPVEManager.broadcastPlayCount(((MapTransferArg)this.arg).oldWorldId);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 101 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */