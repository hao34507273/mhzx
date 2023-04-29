/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import mzm.gsp.fabao.event.FabaoDisplayArg;
/*    */ 
/*    */ public class POnFabaoDisplay extends mzm.gsp.fabao.event.FabaoDisplayProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     if (!FabaoArtifactManager.isEnable()) {
/*  9 */       return false;
/*    */     }
/* 11 */     if (((FabaoDisplayArg)this.arg).fabaoid <= 0) {
/* 12 */       return false;
/*    */     }
/* 14 */     xbean.FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(((FabaoDisplayArg)this.arg).roleid, true);
/* 15 */     if (xRecords == null) {
/* 16 */       return false;
/*    */     }
/* 18 */     if (xRecords.getEquipped_artifact_class() == 0) {
/* 19 */       return false;
/*    */     }
/* 21 */     xRecords.setEquipped_artifact_class(0);
/* 22 */     FabaoArtifactEvents.triggerEquipArtifactEvent(((FabaoDisplayArg)this.arg).roleid, false, true);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\POnFabaoDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */