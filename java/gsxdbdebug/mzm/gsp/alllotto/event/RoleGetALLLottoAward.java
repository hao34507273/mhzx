/*    */ package mzm.gsp.alllotto.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleGetALLLottoAward extends mzm.event.BasicEvent<RoleGetALLLottoAwardArg>
/*    */ {
/*  7 */   private static EventManager<RoleGetALLLottoAwardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleGetALLLottoAwardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.alllotto.main.POnRoleGetALLLottoAward());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\event\RoleGetALLLottoAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */