/*    */ package mzm.gsp.award.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleSelectAward extends mzm.event.BasicEvent<RoleSelectAwardArg>
/*    */ {
/*  7 */   private static EventManager<RoleSelectAwardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleSelectAwardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.jiuxiao.main.PJiuXiaoRoleSelectAward());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\event\RoleSelectAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */