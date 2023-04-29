/*    */ package mzm.gsp.fabaolingqi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UpgradeArtifactEvent extends mzm.event.BasicEvent<UpgradeArtifactArg>
/*    */ {
/*  7 */   private static EventManager<UpgradeArtifactArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UpgradeArtifactArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnUpgradeArtifact());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnUpgradeArtifact());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\event\UpgradeArtifactEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */