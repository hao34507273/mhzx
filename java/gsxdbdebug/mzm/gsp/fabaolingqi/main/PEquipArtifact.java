/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FabaoArtifactRecords;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PEquipArtifact
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int artifactClassId;
/*    */   
/*    */   public PEquipArtifact(long roleId, int artifactClassId)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.artifactClassId = artifactClassId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!FabaoArtifactManager.isEnable())
/* 26 */       return false;
/* 27 */     if (GameServerInfoManager.isRoamServer()) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(this.roleId, true);
/* 32 */     if (xRecords == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     if (!FabaoArtifactManager.hasArtifact(xRecords, this.artifactClassId))
/*    */     {
/* 37 */       FabaoArtifactProtocols.notifyEquipArtifactFail(this.roleId, 1, this.artifactClassId);
/* 38 */       FabaoArtifactManager.info("PEquipArtifact.processImp()@not own|roleid=%d|artifact_classid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId) });
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     xRecords.setEquipped_artifact_class(this.artifactClassId);
/* 43 */     FabaoArtifactProtocols.notifyEquipArtifactSuccess(this.roleId, this.artifactClassId);
/* 44 */     FabaoArtifactManager.tlogEquip(this.roleId, this.artifactClassId);
/* 45 */     FabaoArtifactEvents.triggerEquipArtifactEvent(this.roleId, true, false);
/* 46 */     FabaoArtifactManager.info("PEquipArtifact.processImp()@done|roleid=%d|artifact_classid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId) });
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\PEquipArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */