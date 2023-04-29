/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PArrange
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int bagid;
/*    */   
/*    */   public PArrange(long roleid, int bagid)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.bagid = bagid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 24 */       String logStr = String.format("[item]PArrange.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 25 */       ItemManager.logger.info(logStr);
/* 26 */       return false;
/*    */     }
/* 28 */     if (this.bagid == 340600001)
/* 29 */       return false;
/* 30 */     RoleItemBag bag = ItemManager.getBag(this.roleid, this.bagid);
/*    */     
/* 32 */     if (bag == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     return bag.arrange();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PArrange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */