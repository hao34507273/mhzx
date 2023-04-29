/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import xbean.MenPaiStarVoteInfo;
/*    */ 
/*    */ public class PAddVoteNum extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PAddVoteNum(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     MenPaiStarVoteInfo xVoteInfo = xtable.Role2menpaistarvote.get(Long.valueOf(this.roleid));
/* 19 */     if (xVoteInfo == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     if (xVoteInfo.getVote() != 1)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     int value = xVoteInfo.getVote_num();
/* 30 */     int newValue = value - 1;
/* 31 */     if (newValue < 0)
/*    */     {
/* 33 */       GameServer.logger().info(String.format("[menpaistar]PAddVoteNum.processImp@add vote num failed|roleid=%d|value=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(value) }));
/*    */       
/*    */ 
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     xVoteInfo.setVote_num(newValue);
/*    */     
/* 42 */     GameServer.logger().info(String.format("[menpaistar]PAddVoteNum.processImp@add vote num|roleid=%d|vote_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xVoteInfo.getVote_num()) }));
/*    */     
/*    */ 
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PAddVoteNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */