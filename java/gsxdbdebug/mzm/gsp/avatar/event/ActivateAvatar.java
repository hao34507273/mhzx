/*    */ package mzm.gsp.avatar.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ActivateAvatar extends mzm.event.BasicEvent<ActivateAvatarArg>
/*    */ {
/*  7 */   private static EventManager<ActivateAvatarArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ActivateAvatarArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnActivateAvatar());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\event\ActivateAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */