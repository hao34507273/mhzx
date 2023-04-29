/*    */ package mzm.gsp.avatar.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class OwnedAvatarFrameCountChanged extends mzm.event.BasicEvent<OwnedAvatarFrameCountChangedArg>
/*    */ {
/*  7 */   private static EventManager<OwnedAvatarFrameCountChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<OwnedAvatarFrameCountChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnOwnedAvatarFrameCountChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\event\OwnedAvatarFrameCountChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */