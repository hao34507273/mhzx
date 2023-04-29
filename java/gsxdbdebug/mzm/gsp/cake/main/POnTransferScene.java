/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*    */ import mzm.gsp.cake.event.FactionSceneCreateArg;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.confbean.SMapGlobalConfig;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*    */ import mzm.gsp.pk.main.PSetPkStatus;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class POnTransferScene extends PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     for (Long l : ((MapTransferArg)this.arg).roleList) {
/* 20 */       long roleId = l.longValue();
/* 21 */       checkFacitonSceneCreate(((MapTransferArg)this.arg).newWorldId, roleId);
/* 22 */       checkActivityState(roleId);
/*    */     }
/* 24 */     SMapGlobalConfig smap = SMapGlobalConfig.get(1);
/* 25 */     if ((smap.pkFailTrans.containsKey(Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId))) && (((Boolean)smap.pkFailTrans.get(Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId))).booleanValue())) {
/* 26 */       for (Long rid : ((MapTransferArg)this.arg).roleList) {
/* 27 */         Procedure.execute(new PSetPkStatus(rid.longValue(), true));
/*    */       }
/*    */     } else {
/* 30 */       for (Long rid : ((MapTransferArg)this.arg).roleList) {
/* 31 */         Procedure.execute(new PSetPkStatus(rid.longValue(), false));
/*    */       }
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   private void checkActivityState(final long roleId) {
/* 38 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception {
/* 41 */         return POnTransferScene.this.handEachRole(roleId, ((MapTransferArg)POnTransferScene.this.arg).newWorldId, ((MapTransferArg)POnTransferScene.this.arg).oldWorldId);
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */   
/*    */   private void checkFacitonSceneCreate(long newWorldId, final long roleId)
/*    */   {
/* 48 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception {
/* 51 */         long factionId = GangInterface.getGangId(roleId);
/* 52 */         if (factionId == -1L) {
/* 53 */           return false;
/*    */         }
/* 55 */         long ownFactionWorldId = GangInterface.getGangWorldId(factionId);
/* 56 */         if ((ownFactionWorldId == -1L) || (ownFactionWorldId != this.val$newWorldId) || (!CreateSceneFactionCache.getInstance().addFactionId(factionId))) {
/* 57 */           return false;
/*    */         }
/* 59 */         TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.cake.event.FactionSceneCreate(), new FactionSceneCreateArg(factionId));
/* 60 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */   
/*    */   public boolean handEachRole(long roleId, long newWorldId, long oldWorldId) {
/* 66 */     long factionId = GangInterface.getGangId(roleId);
/* 67 */     if (factionId == -1L) {
/* 68 */       return false;
/*    */     }
/* 70 */     long ownFactionWorldId = GangInterface.getGangWorldId(factionId);
/* 71 */     if (ownFactionWorldId == -1L) {
/* 72 */       return false;
/*    */     }
/* 74 */     boolean isInOwnFactionNew = ownFactionWorldId == newWorldId;
/* 75 */     boolean isInOwnFacitonOld = ownFactionWorldId == oldWorldId;
/* 76 */     if (isInOwnFacitonOld) {
/* 77 */       if (isInOwnFactionNew) {
/* 78 */         return true;
/*    */       }
/* 80 */       for (SCakeActivityCfg cfg : SCakeActivityCfg.getAll().values()) {
/* 81 */         mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleId, cfg.stateId);
/*    */       }
/* 83 */       return true; }
/* 84 */     if (!isInOwnFactionNew) {
/* 85 */       return true;
/*    */     }
/* 87 */     POperCookState.checkAndAddCookState(roleId, SCakeActivityCfg.getAll().keySet());
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */