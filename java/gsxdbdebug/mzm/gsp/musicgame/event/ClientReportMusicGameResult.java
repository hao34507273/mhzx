/*    */ package mzm.gsp.musicgame.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ClientReportMusicGameResult extends mzm.event.BasicEvent<ClientReportMusicGameResultArg>
/*    */ {
/*  7 */   private static EventManager<ClientReportMusicGameResultArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ClientReportMusicGameResultArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.fetuseducationmusic.POnClientReportMusicGameResult());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\event\ClientReportMusicGameResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */