/*    */ package mzm.gsp.fabaolingqi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UnlockArtifactEvent extends mzm.event.BasicEvent<UnlockArtifactArg>
/*    */ {
/*  7 */   private static EventManager<UnlockArtifactArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UnlockArtifactArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnUnlockArtifact());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnUnlockArtifact());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\event\UnlockArtifactEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */