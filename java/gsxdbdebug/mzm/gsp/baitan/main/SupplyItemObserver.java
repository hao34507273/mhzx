/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.SysSellItem;
/*    */ import xdb.Executor;
/*    */ import xtable.Sysbaitanitem;
/*    */ 
/*    */ class SupplyItemObserver extends Observer
/*    */ {
/*    */   SupplyItemObserver(long intervalSeconds)
/*    */   {
/* 18 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 25 */     xdb.Xdb.executor().execute(new TimeOutRunnable(null));
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   private static class TimeOutRunnable
/*    */     extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 35 */       List<Integer> itemIds = new ArrayList(mzm.gsp.baitan.confbean.SItemId2BaitanItemCfgid.getAll().keySet());
/* 36 */       Iterator<Integer> iterator = itemIds.iterator();
/* 37 */       while (iterator.hasNext())
/*    */       {
/* 39 */         int itemid = ((Integer)iterator.next()).intValue();
/* 40 */         new SupplyItemObserver.SupplyItemPro(itemid).call();
/* 41 */         iterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private static class SupplyItemPro
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private int itemid;
/*    */     
/*    */     public SupplyItemPro(int itemid)
/*    */     {
/* 54 */       this.itemid = itemid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 60 */       long key = GameServerInfoManager.toGlobalId(this.itemid);
/* 61 */       SysSellItem sellItem = Sysbaitanitem.get(Long.valueOf(key));
/* 62 */       int maxsellnum = BaiTanManager.getMaxSysSellNum(this.itemid);
/* 63 */       if (sellItem != null)
/*    */       {
/* 65 */         sellItem.getPrice2num().clear();
/* 66 */         String logStr = String.format("[baitan]SupplyItemPro.processImp@clear sysitem sell num success|itemid=%d|sysmaxsellnum=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(maxsellnum) });
/*    */         
/*    */ 
/* 69 */         BaiTanManager.logger.info(logStr);
/* 70 */         return true;
/*    */       }
/* 72 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\SupplyItemObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */