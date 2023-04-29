/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.PCActivityStageEndTime;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.mounts.main.MountsInterface;
/*    */ import mzm.gsp.mounts.main.MountsInterface.RideMountsObj;
/*    */ import mzm.gsp.mounts.main.PCUnRideMounts;
/*    */ import mzm.gsp.pk.main.PKStatusManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.yzdd.confbean.YzddConsts;
/*    */ import mzm.gsp.yzdd.main.YzddManager;
/*    */ import xdb.Procedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnTransferScene extends PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (((MapTransferArg)this.arg).newWorldId == YzddManager.getInstance().getWorldId().longValue()) {
/* 26 */       PKStatusManager.setPKEnabled(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue());
/* 27 */       RoleStatusInterface.setStatus(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), 2275, true);
/* 28 */       YzddManager.getInstance().newRoleRelatedSession(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), 2, new mzm.gsp.util.LogicRunnable()
/*    */       {
/*    */         public void process() {
/* 31 */           YzddManager.getInstance().syncPlayerModel(((Long)((MapTransferArg)POnTransferScene.this.arg).roleList.get(0)).longValue());
/*    */         }
/* 33 */       });
/* 34 */       int stage = ActivityInterface.getActivityStage(YzddConsts.getInstance().ActivityId);
/* 35 */       Procedure.execute(new PCActivityStageEndTime(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), YzddConsts.getInstance().ActivityId, stage));
/* 36 */       if (MountsInterface.getRideMountsObj(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), false).getMountsId() > 0L) {
/* 37 */         Procedure.execute(new PCUnRideMounts(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue()));
/*    */       }
/*    */     }
/*    */     else {
/* 41 */       if (RoleStatusInterface.containsStatus(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), 2275)) {
/* 42 */         RoleStatusInterface.unsetStatus(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), 2275);
/*    */       }
/* 44 */       MapInterface.unSetModelProtocol(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), 12634400);
/*    */       
/* 46 */       RoleInterface.getRoleOutFightObject(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue()).syncClientRoleProperty();
/*    */     }
/* 48 */     if ((!HulaManager.isHulaMap(((MapTransferArg)this.arg).newMapCfgId)) && (HulaManager.isHulaMap(((MapTransferArg)this.arg).oldMapCfgId))) {
/* 49 */       lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/* 50 */       RoleStatusInterface.unsetStatus(((MapTransferArg)this.arg).roleList, 450);
/* 51 */       return true; }
/* 52 */     if ((!HulaManager.isHulaMap(((MapTransferArg)this.arg).newMapCfgId)) || (HulaManager.isHulaMap(((MapTransferArg)this.arg).oldMapCfgId))) {
/* 53 */       return true;
/*    */     }
/* 55 */     lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/* 56 */     RoleStatusInterface.setStatus(((MapTransferArg)this.arg).roleList, 450, false);
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */