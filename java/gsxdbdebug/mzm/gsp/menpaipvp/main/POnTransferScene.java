/*     */ package mzm.gsp.menpaipvp.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.event.MapTransferArg;
/*     */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import xbean.MenpaiPVP;
/*     */ import xbean.MenpaiPVPScore;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class POnTransferScene extends PlayerTransferSceneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  17 */     if ((((MapTransferArg)this.arg).roleList == null) || (((MapTransferArg)this.arg).roleList.isEmpty())) {
/*  18 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  22 */     lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*     */     
/*     */ 
/*     */ 
/*  26 */     if (mzm.gsp.activity.main.ActivityInterface.isActivityOpen(MenpaiPVPConfigManager.getInstance().getActivityID()))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  31 */       MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVP(false);
/*  32 */       if (xMenpaiPVP != null)
/*     */       {
/*     */ 
/*     */ 
/*  36 */         Set<Long> worlds = MenpaiPVPManager.getActivityWorlds(xMenpaiPVP);
/*  37 */         if ((worlds.contains(Long.valueOf(((MapTransferArg)this.arg).newWorldId))) && (!worlds.contains(Long.valueOf(((MapTransferArg)this.arg).oldWorldId))))
/*     */         {
/*     */ 
/*  40 */           for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  41 */             MenpaiPVPManager.syncStage(r);
/*  42 */             MenpaiPVPScore xScore = MenpaiPVPManager.getXScore(r, true);
/*  43 */             MenpaiPVPManager.syncScore(r, xScore);
/*     */           }
/*     */           
/*     */ 
/*  47 */           MenpaiPVPManager.broadcastMatchCountDown(((MapTransferArg)this.arg).roleList);
/*     */           
/*     */ 
/*  50 */           MenpaiPVPManager.logInfo("POnTransferScene.processImp@enter menpaipvp map|roles=%s|oldworld=%d|oldmapid=%d|newworld=%d|newmapid=%d", new Object[] { ((MapTransferArg)this.arg).roleList.toString(), Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  60 */           if ((!worlds.contains(Long.valueOf(((MapTransferArg)this.arg).oldWorldId))) || (worlds.contains(Long.valueOf(((MapTransferArg)this.arg).newWorldId)))) {
/*     */             break label477;
/*     */           }
/*     */           
/*  64 */           for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  65 */             RoleStatusInterface.unsetStatus(r, 5);
/*     */           }
/*     */           
/*     */ 
/*  69 */           MenpaiPVPManager.logInfo("POnTransferScene.processImp@leave menpaipvp map|roles=%s|oldworld=%d|oldmapid=%d|newworld=%d|newmapid=%d", new Object[] { ((MapTransferArg)this.arg).roleList.toString(), Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */         }
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
/*  83 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */     label477:
/*  88 */     for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  89 */       boolean ret = RoleStatusInterface.unsetStatus(r, 5);
/*  90 */       if (ret) {
/*  91 */         MenpaiPVPManager.logInfo("POnTransferScene.processImp@clear menpaipvp status by default|roleid=%d|roles=%s|oldworld=%d|oldmapid=%d|newworld=%d|newmapid=%d", new Object[] { Long.valueOf(r), ((MapTransferArg)this.arg).roleList.toString(), Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */