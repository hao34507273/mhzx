/*    */ package mzm.gsp.chess.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChessGameFinish extends mzm.event.BasicEvent<ChessGameFinishArg>
/*    */ {
/*  7 */   private static EventManager<ChessGameFinishArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChessGameFinishArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chess.main.POnChessGameFinish());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\event\ChessGameFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */