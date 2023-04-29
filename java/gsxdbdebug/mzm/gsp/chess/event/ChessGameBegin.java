/*    */ package mzm.gsp.chess.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChessGameBegin extends mzm.event.BasicEvent<ChessGameBeginArg>
/*    */ {
/*  7 */   private static EventManager<ChessGameBeginArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChessGameBeginArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\event\ChessGameBegin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */