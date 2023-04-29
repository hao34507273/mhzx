/*    */ package mzm.gsp.musicgame.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.musicgame.confbean.SMusicGameCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_StartMusicGame
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int gameid;
/*    */   private final boolean isRestartGame;
/*    */   
/*    */   public PGM_StartMusicGame(long roleid, int gameid, boolean isRestartGame)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.gameid = gameid;
/* 21 */     this.isRestartGame = isRestartGame;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     SMusicGameCfg cfg = SMusicGameCfg.get(this.gameid);
/* 28 */     if (cfg == null)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.roleid, String.format("无效的游戏id|gameid=%d", new Object[] { Integer.valueOf(this.gameid) }));
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     return new PStartMusicGame(this.roleid, this.gameid, this.isRestartGame, 0, new GMMusicGameContext()).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\main\PGM_StartMusicGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */