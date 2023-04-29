/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginClearGiveItem
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/* 16 */     long cleartime = ItemGiveManager.getGiveItemCleartime(((Long)this.arg).longValue());
/* 17 */     if (!isSameDay(cur, cleartime)) {
/* 18 */       ItemGiveManager.clearGiveItemCount(((Long)this.arg).longValue(), cur);
/*    */     }
/* 20 */     cleartime = ItemGiveManager.getGiveYuanbaoCleartime(((Long)this.arg).longValue());
/* 21 */     if (!isSameDay(cur, cleartime)) {
/* 22 */       ItemGiveManager.clearGiveYuanbaoCount(((Long)this.arg).longValue(), cur);
/*    */     }
/* 24 */     ItemGiveManager.synGiveItemInfo(((Long)this.arg).longValue());
/* 25 */     return true;
/*    */   }
/*    */   
/* 28 */   private boolean isSameDay(long t1, long t2) { return DateTimeUtils.isInSameDay(t1, t2); }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginClearGiveItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */