/*    */ package mzm.gsp.fabaolingqi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ArtifactExpireEvent extends mzm.event.BasicEvent<ArtifactExpireArg>
/*    */ {
/*  7 */   private static EventManager<ArtifactExpireArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ArtifactExpireArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnArtifactExpire());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnArtifactExpire());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\event\ArtifactExpireEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */