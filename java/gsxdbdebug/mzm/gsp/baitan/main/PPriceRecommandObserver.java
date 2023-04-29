/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.baitan.confbean.SItemId2BaitanItemCfgid;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ItemSale;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ import xtable.Item2sales;
/*     */ 
/*     */ public class PPriceRecommandObserver extends Observer
/*     */ {
/*     */   public PPriceRecommandObserver(long intervalSecs)
/*     */   {
/*  20 */     super(intervalSecs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  27 */     Xdb.executor().execute(new PriceRecommendTimeOutPro(null));
/*     */     
/*  29 */     return true;
/*     */   }
/*     */   
/*     */   private static class PriceRecommendTimeOutPro
/*     */     extends mzm.gsp.util.LogicRunnable
/*     */   {
/*     */     public void process() throws Exception
/*     */     {
/*  37 */       List<Integer> itemIds = new ArrayList(SItemId2BaitanItemCfgid.getAll().keySet());
/*  38 */       Iterator<Integer> iterator = itemIds.iterator();
/*  39 */       while (iterator.hasNext())
/*     */       {
/*  41 */         int itemid = ((Integer)iterator.next()).intValue();
/*  42 */         new PPriceRecommandObserver.ItemPriceUpdatePro(itemid).call();
/*  43 */         iterator.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class ItemPriceUpdatePro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private int itemid;
/*     */     
/*     */     public ItemPriceUpdatePro(int itemid)
/*     */     {
/*  56 */       this.itemid = itemid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  62 */       long key = GameServerInfoManager.toGlobalId(this.itemid);
/*     */       
/*  64 */       ItemSale itemSale = Item2sales.get(Long.valueOf(key));
/*     */       
/*  66 */       if ((itemSale == null) || (itemSale.getTotalsellnum() <= 0L))
/*     */       {
/*  68 */         return false;
/*     */       }
/*     */       
/*  71 */       long totalsellnum = itemSale.getTotalsellnum();
/*  72 */       long totalsellprice = itemSale.getTotalsellmoney();
/*     */       
/*  74 */       int curprice = itemSale.getRecommendprice();
/*  75 */       if (curprice > 0)
/*     */       {
/*     */ 
/*  78 */         int recommandPrice = (int)((curprice + itemSale.getTotalsellmoney()) / (itemSale.getTotalsellnum() + 1L));
/*     */         
/*  80 */         if (recommandPrice > 0)
/*     */         {
/*  82 */           itemSale.setRecommendprice(recommandPrice);
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/*  88 */         int recommandPrice = (int)(itemSale.getTotalsellmoney() / itemSale.getTotalsellnum());
/*     */         
/*  90 */         if (recommandPrice > 0)
/*     */         {
/*  92 */           itemSale.setRecommendprice(recommandPrice);
/*     */         }
/*     */       }
/*  95 */       String logStr = String.format("[baitan]ItemPriceUpdatePro.processImp@update item recommend price success|itemid=%d|oldrecprice=%d|newrecprice=%d|totalsellnum=%d|totalsellprice=%d|totalgridnum=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(curprice), Integer.valueOf(itemSale.getRecommendprice()), Long.valueOf(totalsellnum), Long.valueOf(totalsellprice), Integer.valueOf(itemSale.getTotalgridnum()) });
/*     */       
/*     */ 
/*  98 */       BaiTanManager.logger.info(logStr);
/*  99 */       itemSale.setTotalsellmoney(0L);
/* 100 */       itemSale.setTotalsellnum(0L);
/* 101 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PPriceRecommandObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */