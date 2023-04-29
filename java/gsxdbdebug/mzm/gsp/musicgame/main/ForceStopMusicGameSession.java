/*    */ package mzm.gsp.musicgame.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ForceStopMusicGameSession
/*    */   extends Session
/*    */ {
/*    */   private final int gameid;
/*    */   
/*    */   public ForceStopMusicGameSession(long interval, long roleid, int gameid)
/*    */   {
/* 17 */     super(interval, roleid);
/* 18 */     this.gameid = gameid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 24 */     StringBuilder sb = new StringBuilder();
/* 25 */     sb.append(String.format("[musicgame]ForceStopMusicGameSession.onTimeOut@force stop music game session timeout|roleid=%d|gameid=%d", new Object[] { Long.valueOf(getOwerId()), Integer.valueOf(this.gameid) }));
/*    */     
/*    */ 
/* 28 */     MusicGameManager.logger.info(sb.toString());
/* 29 */     new PStopMusicGame(getOwerId(), this.gameid, false, false).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\main\ForceStopMusicGameSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */