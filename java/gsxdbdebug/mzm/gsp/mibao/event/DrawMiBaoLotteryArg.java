/*    */ package mzm.gsp.mibao.event;
/*    */ 
/*    */ 
/*    */ public class DrawMiBaoLotteryArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int drawTimes;
/*    */   
/*    */   public final int addMiBaoScore;
/*    */   public final int nowMiBaoScore;
/*    */   
/*    */   public DrawMiBaoLotteryArg(long roleId, int drawTimes, int addMiBaoScore, int nowMiBaoScore)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.drawTimes = drawTimes;
/* 17 */     this.addMiBaoScore = addMiBaoScore;
/* 18 */     this.nowMiBaoScore = nowMiBaoScore;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\event\DrawMiBaoLotteryArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */