/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Table;
/*     */ import xtable.Role2equipstate;
/*     */ import xtable.Role2storage2;
/*     */ import xtable.Systemaward;
/*     */ import xtable.Tradetype2banitems;
/*     */ 
/*     */ public class ItemMerger implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  20 */     List<Table> tables = new ArrayList();
/*  21 */     tables.add(xtable.Bag.getTable());
/*  22 */     tables.add(xtable.Equipbag.getTable());
/*  23 */     tables.add(xtable.Role2storage1.getTable());
/*  24 */     tables.add(Role2storage2.getTable());
/*  25 */     tables.add(xtable.Role2storage3.getTable());
/*  26 */     tables.add(xtable.Role2storage4.getTable());
/*  27 */     tables.add(xtable.Role2storage5.getTable());
/*  28 */     tables.add(xtable.Role2storage6.getTable());
/*  29 */     tables.add(xtable.Role2storage7.getTable());
/*  30 */     tables.add(xtable.Role2storage8.getTable());
/*  31 */     tables.add(xtable.Role2storage9.getTable());
/*  32 */     tables.add(xtable.Role2storage10.getTable());
/*  33 */     tables.add(xtable.Role2storage11.getTable());
/*  34 */     tables.add(xtable.Role2storage12.getTable());
/*  35 */     tables.add(xtable.Role2storage13.getTable());
/*  36 */     tables.add(xtable.Role2storage14.getTable());
/*  37 */     tables.add(xtable.Role2storage15.getTable());
/*  38 */     tables.add(xtable.Role2storage16.getTable());
/*  39 */     tables.add(xtable.Role2itemusecount.getTable());
/*  40 */     tables.add(Role2equipstate.getTable());
/*  41 */     tables.add(xtable.Role2giveitemcount.getTable());
/*  42 */     tables.add(xtable.Role2giveyuanbaocount.getTable());
/*  43 */     tables.add(Tradetype2banitems.getTable());
/*  44 */     tables.add(xtable.Role2sysaward.getTable());
/*  45 */     tables.add(Systemaward.getTable());
/*  46 */     tables.add(xtable.Role2lottery.getTable());
/*  47 */     tables.add(xtable.Role2ocpequipbag.getTable());
/*  48 */     tables.add(xtable.Role2equipmode.getTable());
/*  49 */     tables.add(xtable.Role2doubleitem.getTable());
/*  50 */     tables.add(xtable.Superequipmentjewelbag.getTable());
/*  51 */     tables.add(xtable.Role2fabaobag.getTable());
/*  52 */     tables.add(xtable.Role2changemodelcardbag.getTable());
/*  53 */     tables.add(xtable.Role2treasurebag.getTable());
/*  54 */     tables.add(xtable.Role2petmarkbag.getTable());
/*  55 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  61 */     boolean ret = new Merge_Tradetype2banitems_Pro(null).call();
/*  62 */     if (!ret)
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     ret = new Merge_Systemaward_Pro(null).call();
/*     */     
/*  68 */     return ret;
/*     */   }
/*     */   
/*     */   private static class Merge_Tradetype2banitems_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  76 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/*  78 */       List<Long> viceKeys = new ArrayList();
/*     */       
/*  80 */       for (Iterator i$ = ItemBanTrade.TradeTypeEnum.getTradeTypeSet().iterator(); i$.hasNext();) { int tradeType = ((Integer)i$.next()).intValue();
/*     */         
/*  82 */         long viceKey = mzm.gsp.GameServerInfoManager.toGlobalId(tradeType, viceZoneId);
/*  83 */         viceKeys.add(Long.valueOf(viceKey));
/*     */       }
/*  85 */       lock(Tradetype2banitems.getTable(), viceKeys);
/*  86 */       for (Iterator i$ = viceKeys.iterator(); i$.hasNext();) { long key = ((Long)i$.next()).longValue();
/*     */         
/*  88 */         Tradetype2banitems.remove(Long.valueOf(key));
/*     */       }
/*  90 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class Merge_Systemaward_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 102 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/* 104 */       lock(Systemaward.getTable(), Arrays.asList(new Long[] { Long.valueOf(viceZoneId) }));
/*     */       
/* 106 */       Systemaward.remove(Long.valueOf(viceZoneId));
/*     */       
/* 108 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */