/*    */ package mzm.gsp.multioccupation.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SwitchOccup extends mzm.event.BasicEvent<SwitchOccupArg>
/*    */ {
/*  7 */   private static EventManager<SwitchOccupArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SwitchOccupArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnRoleSwitchOccup());
/* 16 */     manager.register(new mzm.gsp.friend.main.POnRoleSwitchOccup());
/* 17 */     manager.register(new mzm.gsp.menpaistar.main.POnRoleSwitchOccup());
/* 18 */     manager.register(new mzm.gsp.corps.main.POnRoleSwitchOccup());
/* 19 */     manager.register(new mzm.gsp.friendscircle.main.POnRoleSwitchOccup());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\event\SwitchOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */