/*    */ package mzm.gsp.avatar.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SetAvatar extends mzm.event.BasicEvent<SetAvatarArg>
/*    */ {
/*  7 */   private static EventManager<SetAvatarArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SetAvatarArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.team.main.POnSetAvatar());
/* 16 */     manager.register(new mzm.gsp.friend.main.POnRoleSetAvatar());
/* 17 */     manager.register(new mzm.gsp.gang.main.POnSetAvatar());
/* 18 */     manager.register(new mzm.gsp.personal.main.POnSetAvatar());
/* 19 */     manager.register(new mzm.gsp.shitu.main.POnSetAvatar());
/* 20 */     manager.register(new mzm.gsp.friendscircle.main.POnSetAvatar());
/* 21 */     manager.register(new mzm.gsp.petarena.main.POnSetAvatar());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\event\SetAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */