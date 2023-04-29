/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginClearItemBuyCount
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     long cleartime = MallManager.getItemBuycountCleartime(((Long)this.arg).longValue());
/*    */     
/* 20 */     long mallcleartime = MallManager.getMallRefreshTime(2);
/* 21 */     if (mallcleartime == 0L)
/*    */     {
/*    */ 
/* 24 */       return false;
/*    */     }
/* 26 */     if (cleartime < mallcleartime)
/*    */     {
/* 28 */       MallManager.clearItemBuyCount(((Long)this.arg).longValue(), mallcleartime);
/*    */     }
/*    */     
/*    */ 
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\POnRoleLoginClearItemBuyCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */