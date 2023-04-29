/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import mzm.gsp.idip.event.BanPlayArg;
/*    */ import mzm.gsp.idip.event.BanPlayProcedure;
/*    */ 
/*    */ public class POnBanPlay
/*    */   extends BanPlayProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     if (((BanPlayArg)this.arg).playType == 2)
/*    */     {
/* 14 */       long roleId = ((BanPlayArg)this.arg).roleId;
/*    */       
/* 16 */       return new BaotuSwitchClosedPro(roleId).call();
/*    */     }
/* 18 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\POnBanPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */