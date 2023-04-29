/*    */ package mzm.gsp.musicgame.event;
/*    */ 
/*    */ 
/*    */ public class ClientReportMusicGameResultArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final int gameid;
/*    */   public final boolean isAnswerRight;
/*    */   public final MusicGameContext context;
/*    */   
/*    */   public ClientReportMusicGameResultArg(long roleid, int gameid, boolean isAnswerRight, MusicGameContext context)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.gameid = gameid;
/* 15 */     this.isAnswerRight = isAnswerRight;
/* 16 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\event\ClientReportMusicGameResultArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */