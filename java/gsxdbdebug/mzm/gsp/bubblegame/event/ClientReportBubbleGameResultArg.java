/*    */ package mzm.gsp.bubblegame.event;
/*    */ 
/*    */ 
/*    */ public class ClientReportBubbleGameResultArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final int gameid;
/*    */   public final boolean isAnswerRight;
/*    */   public final BubbleGameContext context;
/*    */   
/*    */   public ClientReportBubbleGameResultArg(long roleid, int gameid, boolean isAnswerRight, BubbleGameContext context)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.gameid = gameid;
/* 15 */     this.isAnswerRight = isAnswerRight;
/* 16 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\event\ClientReportBubbleGameResultArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */