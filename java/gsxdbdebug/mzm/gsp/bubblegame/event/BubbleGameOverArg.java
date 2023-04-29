/*    */ package mzm.gsp.bubblegame.event;
/*    */ 
/*    */ 
/*    */ public class BubbleGameOverArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final int gameid;
/*    */   public final int completeTrunIndex;
/*    */   public final int rightTurnNum;
/*    */   public final long gameStartTimeStamp;
/*    */   public final BubbleGameContext context;
/*    */   
/*    */   public BubbleGameOverArg(long roleid, int gameid, int completeTrunIndex, int rightTurnNum, long gameStartTimeStamp, BubbleGameContext context)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.gameid = gameid;
/* 17 */     this.completeTrunIndex = completeTrunIndex;
/* 18 */     this.rightTurnNum = rightTurnNum;
/* 19 */     this.gameStartTimeStamp = gameStartTimeStamp;
/* 20 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\event\BubbleGameOverArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */