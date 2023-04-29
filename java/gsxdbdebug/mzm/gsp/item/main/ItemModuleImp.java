/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.bag.confbean.SStorageCfg;
/*    */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*    */ import mzm.gsp.item.main.access.ItemAccessManager;
/*    */ import mzm.gsp.item.main.sift.SiftConditionFac;
/*    */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*    */ import xdb.TTable;
/*    */ import xdb.Tables;
/*    */ import xdb.Xdb;
/*    */ import xtable.Equipbag;
/*    */ import xtable.Role2changemodelcardbag;
/*    */ import xtable.Role2fabaobag;
/*    */ import xtable.Role2petmarkbag;
/*    */ import xtable.Role2treasurebag;
/*    */ import xtable.Superequipmentjewelbag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemModuleImp
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 29 */     ItemConfigManager.getInstance().init();
/* 30 */     ItemManager.registerSpecialItem();
/*    */     try
/*    */     {
/* 33 */       SiftConditionFac.init();
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 37 */       throw new RuntimeException(e);
/*    */     }
/*    */     
/* 40 */     ItemGiveManager.init();
/* 41 */     xtable.Bag.getTable().addListener(new BagChanged(340600000), new String[] { "value", "items" });
/* 42 */     Equipbag.getTable().addListener(new BagChanged(340600001), new String[] { "value", "items" });
/* 43 */     Superequipmentjewelbag.getTable().addListener(new BagChanged(340600005), new String[] { "value", "items" });
/* 44 */     Role2fabaobag.getTable().addListener(new BagChanged(340600006), new String[] { "value", "items" });
/* 45 */     Role2changemodelcardbag.getTable().addListener(new BagChanged(340600007), new String[] { "value", "items" });
/* 46 */     Role2treasurebag.getTable().addListener(new BagChanged(340600008), new String[] { "value", "items" });
/* 47 */     Role2petmarkbag.getTable().addListener(new BagChanged(340600009), new String[] { "value", "items" });
/*    */     
/* 49 */     for (SStorageCfg storageCfg : SStorageCfg.getAll().values())
/*    */     {
/* 51 */       TTable<Long, xbean.Bag> table = (TTable)Xdb.getInstance().getTables().getTable(storageCfg.classname.trim());
/*    */       
/* 53 */       table.addListener(new StorageBagChanged(storageCfg.id), new String[] { "value", "items" });
/*    */     }
/*    */     
/* 56 */     ItemStoreEnum.check();
/*    */     
/* 58 */     ItemBanTrade.TradeTypeEnum.checkTradeType();
/* 59 */     ItemBanTrade.getInstance().initFromXdbOnStartUp();
/* 60 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 67 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 74 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 81 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 88 */     ItemAccessManager.init();
/*    */     
/*    */ 
/*    */ 
/* 92 */     DateObserver.MyDate d = new DateObserver.MyDate(2015, -1, -1, 0);
/* 93 */     new GiveItemCountObserver(d);
/*    */     
/* 95 */     new FlowerPointObserver(ItemCfgConsts.getInstance().FLOWER_POINT_CLEAR_TIME);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemModuleImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */