/*    */ package mzm.gsp.bubblegame.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ForceStopBubbleGameSession
/*    */   extends Session
/*    */ {
/*    */   private final int gameid;
/*    */   
/*    */   public ForceStopBubbleGameSession(long interval, long roleid, int gameid)
/*    */   {
/* 17 */     super(interval, roleid);
/* 18 */     this.gameid = gameid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 24 */     StringBuilder sb = new StringBuilder();
/* 25 */     sb.append(String.format("[bubblegame]ForceStopBubbleGameSession.onTimeOut@force stop bubble game session timeout|roleid=%d|gameid=%d", new Object[] { Long.valueOf(getOwerId()), Integer.valueOf(this.gameid) }));
/*    */     
/*    */ 
/* 28 */     BubbleGameManager.logger.info(sb.toString());
/* 29 */     new PStopBubbleGame(getOwerId(), this.gameid, false).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\main\ForceStopBubbleGameSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */