/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PMoveItemIntoBag extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int srckey;
/*    */   private int storageid;
/*    */   
/*    */   public PMoveItemIntoBag(long roleid, int srckey, int storageid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */     
/* 16 */     this.srckey = srckey;
/* 17 */     this.storageid = storageid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!ItemModuleSwitchInterface.isMoveItemIntoBagSwitchOpenForRole(this.roleid))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 29 */       String logStr = String.format("[item]PMoveItemIntoBag.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 30 */       ItemManager.logger.info(logStr);
/* 31 */       return false;
/*    */     }
/* 33 */     String logstr = String.format("[item]PMoveItemIntoBag.processImp@receive move item into bag req|roleid=%d|srckey=%d|storageid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.srckey), Integer.valueOf(this.storageid) });
/*    */     
/*    */ 
/* 36 */     ItemManager.logger.info(logstr);
/* 37 */     return ItemInterface.moveItemIntoBag(this.roleid, this.srckey, this.storageid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PMoveItemIntoBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */