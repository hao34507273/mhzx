/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PMoveItemIntoStorage extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int srckey;
/*    */   private int storageid;
/*    */   
/*    */   public PMoveItemIntoStorage(long roleid, int srckey, int storageid)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.srckey = srckey;
/* 16 */     this.storageid = storageid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!ItemModuleSwitchInterface.isMoveItemIntoStorageSwitchOpenForRole(this.roleid))
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 28 */       String logStr = String.format("[item]PMoveItemIntoStorage.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 30 */       ItemManager.logger.info(logStr);
/* 31 */       return false;
/*    */     }
/* 33 */     String logstr = String.format("[item]PMoveItemIntoStorage.processImp@receive move item into storage req|roleid=%d|srckey=%d|storageid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.srckey), Integer.valueOf(this.storageid) });
/*    */     
/*    */ 
/* 36 */     ItemManager.logger.info(logstr);
/* 37 */     return ItemInterface.moveItemIntoStorage(this.roleid, this.srckey, this.storageid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PMoveItemIntoStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */