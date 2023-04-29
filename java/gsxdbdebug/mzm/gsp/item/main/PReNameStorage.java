/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.item.SReNameStorageSuccess;
/*    */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PReNameStorage
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private String name;
/*    */   private int storageid;
/*    */   
/*    */   public PReNameStorage(long roleid, String name, int storageid)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.name = name;
/* 21 */     this.storageid = storageid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if ((this.name == null) || (this.name.length() == 0) || ("".equals(this.name.trim())))
/*    */     {
/* 29 */       ItemManager.sendWrongInfo(this.roleid, 1002, new String[0]);
/* 30 */       return false;
/*    */     }
/* 32 */     int length = this.name.length();
/* 33 */     if (length > ItemCfgConsts.getInstance().STORAGE_NAME_LENGTH)
/*    */     {
/* 35 */       String logStr = String.format("[item]PReNameStorage.processImp@name is too long|roleid=%d|name=%s|length=%d|conf_length=%d", new Object[] { Long.valueOf(this.roleid), this.name, Integer.valueOf(length), Integer.valueOf(ItemCfgConsts.getInstance().STORAGE_NAME_LENGTH) });
/*    */       
/*    */ 
/* 38 */       ItemManager.logger.info(logStr);
/* 39 */       return false;
/*    */     }
/* 41 */     if (SensitiveInterface.isNameSensitive(this.name))
/*    */     {
/* 43 */       String logStr = String.format("[item]PReNameStorage.processImp@name is sensitive|roleid=%d|name=%s", new Object[] { Long.valueOf(this.roleid), this.name });
/* 44 */       ItemManager.logger.info(logStr);
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 50 */       String logStr = String.format("[item]PReNameStorage.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 51 */       ItemManager.logger.info(logStr);
/* 52 */       return false;
/*    */     }
/* 54 */     RoleStorageBag storageBag = ItemManager.getRoleStorageBag(this.roleid, this.storageid);
/*    */     
/* 56 */     SReNameStorageSuccess res = new SReNameStorageSuccess();
/* 57 */     res.name = this.name;
/* 58 */     res.storageid = this.storageid;
/* 59 */     OnlineManager.getInstance().send(this.roleid, res);
/* 60 */     return storageBag.setBagName(this.name);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PReNameStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */