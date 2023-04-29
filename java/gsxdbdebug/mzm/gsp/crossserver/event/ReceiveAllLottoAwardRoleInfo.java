/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReceiveAllLottoAwardRoleInfo extends mzm.event.BasicEvent<ReceiveAllLottoAwardRoleInfoArg>
/*    */ {
/*  7 */   private static EventManager<ReceiveAllLottoAwardRoleInfoArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReceiveAllLottoAwardRoleInfoArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.alllotto.main.POnReceiveAllLottoAwardRoleInfo());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReceiveAllLottoAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */