/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ 
/*    */ public class GainItemeArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final ItemOperateResult itemOperateResult;
/*    */   public final TLogArg logArg;
/*    */   
/*    */   public GainItemeArg(long roleId, ItemOperateResult itemOperateResult, TLogArg logArg)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.itemOperateResult = itemOperateResult;
/* 17 */     this.logArg = logArg;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\GainItemeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */