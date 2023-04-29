/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class RemoveItemeArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final ItemOperateResult itemOperateResult;
/*    */   public final TLogArg logArg;
/*    */   
/*    */   public RemoveItemeArg(long roleId, ItemOperateResult itemOperateResult, TLogArg logArg)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.itemOperateResult = itemOperateResult;
/* 16 */     this.logArg = logArg;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\RemoveItemeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */