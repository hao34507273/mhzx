/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.fabaolingqi.event.ArtifactExpireArg;
/*    */ import mzm.gsp.fabaolingqi.event.EquipArtifactArg;
/*    */ import mzm.gsp.fabaolingqi.event.EquipArtifactEvent;
/*    */ import mzm.gsp.fabaolingqi.event.ImproveArtifactArg;
/*    */ import mzm.gsp.fabaolingqi.event.ImproveArtifactEvent;
/*    */ import mzm.gsp.fabaolingqi.event.UnlockArtifactArg;
/*    */ import mzm.gsp.fabaolingqi.event.UnlockArtifactEvent;
/*    */ import mzm.gsp.fabaolingqi.event.UpgradeArtifactEvent;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ 
/*    */ class FabaoArtifactEvents
/*    */ {
/*    */   static void triggerUnlockArtifactEvent(long roleId, int artifactClassId)
/*    */   {
/* 19 */     UnlockArtifactEvent event = new UnlockArtifactEvent();
/* 20 */     UnlockArtifactArg arg = new UnlockArtifactArg();
/* 21 */     arg.roleId = roleId;
/* 22 */     arg.artifactClassId = artifactClassId;
/* 23 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void triggerArtifactExpireEvent(long roleId, Set<Integer> artifactClassIds)
/*    */   {
/* 31 */     mzm.gsp.fabaolingqi.event.ArtifactExpireEvent event = new mzm.gsp.fabaolingqi.event.ArtifactExpireEvent();
/* 32 */     ArtifactExpireArg arg = new ArtifactExpireArg();
/* 33 */     arg.roleId = roleId;
/* 34 */     arg.artifactClassIds = artifactClassIds;
/* 35 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void triggerEquipArtifactEvent(long roleId, boolean isEquipping, boolean passiveChanged)
/*    */   {
/* 43 */     EquipArtifactEvent event = new EquipArtifactEvent();
/* 44 */     EquipArtifactArg arg = new EquipArtifactArg();
/* 45 */     arg.roleId = roleId;
/* 46 */     arg.isEquipping = isEquipping;
/* 47 */     arg.passiveChanged = passiveChanged;
/* 48 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void triggerImproveArtifactEvent(long roleId, int artifactClassId, int propertyType, int oldValue, int newValue)
/*    */   {
/* 57 */     ImproveArtifactEvent event = new ImproveArtifactEvent();
/* 58 */     ImproveArtifactArg arg = new ImproveArtifactArg();
/* 59 */     arg.roleId = roleId;
/* 60 */     arg.artifactClassId = artifactClassId;
/* 61 */     arg.propertyType = propertyType;
/* 62 */     arg.oldValue = oldValue;
/* 63 */     arg.newValue = newValue;
/* 64 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void triggerUpgradeArtifactEvent(long roleId, int artifactClassId, int oldLevel, int newLevel)
/*    */   {
/* 72 */     UpgradeArtifactEvent event = new UpgradeArtifactEvent();
/* 73 */     mzm.gsp.fabaolingqi.event.UpgradeArtifactArg arg = new mzm.gsp.fabaolingqi.event.UpgradeArtifactArg();
/* 74 */     arg.roleId = roleId;
/* 75 */     arg.artifactClassId = artifactClassId;
/* 76 */     arg.oldLevel = oldLevel;
/* 77 */     arg.newLevel = newLevel;
/* 78 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\FabaoArtifactEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */