/*    */ package mzm.gsp.award.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MultiRoleSelectAwardEnd extends mzm.event.BasicEvent<MultiRoleSelectArg>
/*    */ {
/*  7 */   private static EventManager<MultiRoleSelectArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MultiRoleSelectArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.jiuxiao.main.PJiuXiaoMultiAwardEnd());
/* 16 */     manager.register(new mzm.gsp.paraselene.main.POnFinishFanpaiEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\event\MultiRoleSelectAwardEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */