/*    */ package mzm.gsp.fabaolingqi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ImproveArtifactEvent extends mzm.event.BasicEvent<ImproveArtifactArg>
/*    */ {
/*  7 */   private static EventManager<ImproveArtifactArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ImproveArtifactArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnImproveArtifact());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\event\ImproveArtifactEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */