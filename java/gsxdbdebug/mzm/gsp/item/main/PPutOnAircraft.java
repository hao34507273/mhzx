/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PPutOnAircraft
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private long uuid;
/*    */   
/*    */   public PPutOnAircraft(long roleid, long uuid)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.uuid = uuid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!ItemModuleSwitchInterface.isPutOnAirCraftSwitchOpenForRole(this.roleid))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 29 */       String logStr = String.format("[item]PPutOnAircraft.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 30 */       ItemManager.logger.info(logStr);
/* 31 */       return false;
/*    */     }
/* 33 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/* 34 */     if (basicItem == null)
/*    */     {
/* 36 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     BasicItem toUn = ItemInterface.getItem(this.roleid, 340600001, 8);
/* 41 */     if (ItemInterface.isEquiped(this.roleid, 8))
/*    */     {
/*    */ 
/* 44 */       int grid = ItemInterface.getGridByUuid(this.roleid, 340600000, this.uuid);
/* 45 */       if (grid == -1)
/*    */       {
/* 47 */         ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 48 */         return false;
/*    */       }
/* 50 */       boolean ret = ItemInterface.exchangeItem(this.roleid, grid, 8);
/* 51 */       if (!ret)
/*    */       {
/* 53 */         ItemManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 54 */         return false;
/*    */       }
/*    */       
/*    */     }
/*    */     else
/*    */     {
/* 60 */       boolean ret = ItemInterface.moveItemIntoEquipBag(this.roleid, this.uuid);
/* 61 */       if (!ret)
/*    */       {
/* 63 */         ItemManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 64 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 68 */     ItemManager.tlogEquipOn(this.roleid, basicItem, 8, toUn == null ? 0 : toUn.getCfgId(), toUn == null ? 0L : toUn.getTlogUuid(), 0, null);
/*    */     
/*    */ 
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PPutOnAircraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */