/*    */ package mzm.gsp.avatar.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class OwnedAvatarCountChanged extends mzm.event.BasicEvent<OwnedAvatarCountChangedArg>
/*    */ {
/*  7 */   private static EventManager<OwnedAvatarCountChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<OwnedAvatarCountChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnOwnedAvatarCountChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\event\OwnedAvatarCountChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */