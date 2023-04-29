/*    */ package mzm.gsp.floplottery.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FlopLotteryEntry;
/*    */ import xtable.Role2floplotteryentry;
/*    */ 
/*    */ public class PCFlopLotteryExit
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long uid;
/*    */   private final long roleId;
/*    */   
/*    */   public PCFlopLotteryExit(long uid, long roleId)
/*    */   {
/* 15 */     this.uid = uid;
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     FlopLotteryEntry xFlopLotteryEntry = Role2floplotteryentry.get(Long.valueOf(this.roleId));
/*    */     
/*    */ 
/* 26 */     String errorLogHead = "[floplottery]PCFlopLotteryExit@processImp ";
/* 27 */     String errorLogTail = String.format("|roleid=%d|uid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uid) });
/* 28 */     if (xFlopLotteryEntry == null)
/*    */     {
/* 30 */       String errorLog = "xFlopLotteryEntry not exist";
/* 31 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*    */     }
/*    */     
/* 34 */     if (xFlopLotteryEntry.getUid() != this.uid)
/*    */     {
/* 36 */       String errorLog = "uid error";
/* 37 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*    */     }
/*    */     
/*    */ 
/* 41 */     Role2floplotteryentry.delete(Long.valueOf(this.roleId));
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\main\PCFlopLotteryExit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */