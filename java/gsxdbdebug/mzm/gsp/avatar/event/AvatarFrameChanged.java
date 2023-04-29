/*    */ package mzm.gsp.avatar.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AvatarFrameChanged extends mzm.event.BasicEvent<AvatarFrameChangedArg>
/*    */ {
/*  7 */   private static EventManager<AvatarFrameChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AvatarFrameChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.friend.main.POnAvatarFrameChanged());
/* 16 */     manager.register(new mzm.gsp.gang.main.POnAvatarFrameChanged());
/* 17 */     manager.register(new mzm.gsp.personal.main.POnAvatarFrameChanged());
/* 18 */     manager.register(new mzm.gsp.team.main.POnAvatarFrameChanged());
/* 19 */     manager.register(new mzm.gsp.shitu.main.POnAvatarFrameChanged());
/* 20 */     manager.register(new mzm.gsp.friendscircle.main.POnAvatarFrameChanged());
/* 21 */     manager.register(new mzm.gsp.petarena.main.POnAvatarFrameChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\event\AvatarFrameChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */