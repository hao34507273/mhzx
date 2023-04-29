/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PArrangeStorage extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int bagid;
/*    */   
/*    */   public PArrangeStorage(long roleid, int bagid)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.bagid = bagid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 22 */       String logStr = String.format("[item]PArrangeStorage.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 23 */       ItemManager.logger.info(logStr);
/* 24 */       return false;
/*    */     }
/* 26 */     RoleStorageBag bag = ItemManager.getRoleStorageBag(this.roleid, this.bagid);
/*    */     
/* 28 */     if (bag == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     return bag.arrange();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PArrangeStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */