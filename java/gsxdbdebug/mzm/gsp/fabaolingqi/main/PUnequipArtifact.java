/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import xbean.FabaoArtifactRecords;
/*    */ 
/*    */ public class PUnequipArtifact extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PUnequipArtifact(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!FabaoArtifactManager.isEnable())
/* 19 */       return false;
/* 20 */     if (GameServerInfoManager.isRoamServer()) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(this.roleId, true);
/* 25 */     if (xRecords == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     if (xRecords.getEquipped_artifact_class() == 0) {
/* 29 */       return false;
/*    */     }
/* 31 */     int unequippedArtifactClassId = xRecords.getEquipped_artifact_class();
/* 32 */     xRecords.setEquipped_artifact_class(0);
/* 33 */     FabaoArtifactProtocols.notifyUnequipArtifactSuccess(this.roleId);
/* 34 */     FabaoArtifactManager.tlogUnequip(this.roleId, unequippedArtifactClassId);
/* 35 */     FabaoArtifactEvents.triggerEquipArtifactEvent(this.roleId, false, false);
/* 36 */     FabaoArtifactManager.info("PUnequipArtifact.processImp()@done|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\PUnequipArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */