/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Sign;
/*    */ import xtable.Role2sign;
/*    */ 
/*    */ public class PGM_AddSignCount extends LogicProcedure
/*    */ {
/*    */   private final int count;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_AddSignCount(long roleid, int count)
/*    */   {
/* 15 */     this.count = count;
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     Sign xSign = Role2sign.get(Long.valueOf(this.roleid));
/* 24 */     if (xSign == null)
/*    */     {
/* 26 */       xSign = xbean.Pod.newSign();
/* 27 */       Role2sign.insert(Long.valueOf(this.roleid), xSign);
/*    */     }
/* 29 */     xSign.setFillincount(xSign.getFillincount() + this.count);
/*    */     
/* 31 */     SignAwardManager.sendSSignInRes(this.roleid, xSign, DateTimeUtils.getCurrTimeInMillis(), 0, 0);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\PGM_AddSignCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */