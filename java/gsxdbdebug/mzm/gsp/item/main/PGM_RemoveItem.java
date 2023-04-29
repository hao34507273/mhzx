/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemoveItem
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int itemid;
/*    */   private int num;
/*    */   
/*    */   public PGM_RemoveItem(long roleid, int num, int itemid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.num = num;
/* 20 */     this.itemid = itemid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (ItemInterface.isItemExist(this.itemid))
/*    */     {
/* 27 */       ItemInterface.removeItemById(this.roleid, 340600000, this.itemid, this.num, new TLogArg(LogReason.GM_REM));
/*    */     }
/*    */     else {
/* 30 */       ItemInterface.removeItemByGrid(this.roleid, 340600000, this.itemid, this.num, new TLogArg(LogReason.GM_REM));
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_RemoveItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */