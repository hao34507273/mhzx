/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetAllLottoAwardRoleInfoDone extends mzm.event.BasicEvent<GetAllLottoAwardRoleInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetAllLottoAwardRoleInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetAllLottoAwardRoleInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.alllotto.main.POnGetAllLottoAwardRoleInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetAllLottoAwardRoleInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */