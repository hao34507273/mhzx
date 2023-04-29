/*    */ package mzm.gsp.bubblegame.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ClientReportBubbleGameResult extends mzm.event.BasicEvent<ClientReportBubbleGameResultArg>
/*    */ {
/*  7 */   private static EventManager<ClientReportBubbleGameResultArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ClientReportBubbleGameResultArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.preparepregnancy.POnClientReportBubbleGameResult());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\event\ClientReportBubbleGameResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */