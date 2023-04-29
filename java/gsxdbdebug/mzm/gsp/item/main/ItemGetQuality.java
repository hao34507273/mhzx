/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.item.GetQuality;
/*     */ import mzm.gsp.item.confbean.SBaoshiduItem;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemDrugInFightCfg;
/*     */ import mzm.gsp.item.confbean.SItemDrugOutFightCfg;
/*     */ import mzm.gsp.item.confbean.SPetLifeItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemGetQuality
/*     */ {
/*  21 */   public static Map<Integer, GetQuality> type2GetQuality = new HashMap();
/*     */   
/*     */ 
/*     */   static
/*     */   {
/*  26 */     type2GetQuality.put(Integer.valueOf(5), new GetQuality()
/*     */     {
/*     */ 
/*     */       public int getQuality(int itemCfgId)
/*     */       {
/*  31 */         return getQuality(SItemCfg.get(itemCfgId));
/*     */       }
/*     */       
/*     */ 
/*     */       public int getQuality(SItemCfg itemCfg)
/*     */       {
/*  37 */         if (itemCfg == null)
/*     */         {
/*  39 */           return -1;
/*     */         }
/*     */         
/*  42 */         if ((itemCfg instanceof SItemDrugInFightCfg))
/*     */         {
/*  44 */           return ((SItemDrugInFightCfg)itemCfg).drugPro;
/*     */         }
/*  46 */         return -1;
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*  51 */     });
/*  52 */     type2GetQuality.put(Integer.valueOf(7), new GetQuality()
/*     */     {
/*     */ 
/*     */       public int getQuality(int itemCfgId)
/*     */       {
/*     */ 
/*  58 */         return getQuality(SItemCfg.get(itemCfgId));
/*     */       }
/*     */       
/*     */ 
/*     */       public int getQuality(SItemCfg itemCfg)
/*     */       {
/*  64 */         if (itemCfg == null)
/*     */         {
/*  66 */           return -1;
/*     */         }
/*     */         
/*  69 */         if ((itemCfg instanceof SItemDrugOutFightCfg))
/*     */         {
/*  71 */           return ((SItemDrugOutFightCfg)itemCfg).drugPro;
/*     */         }
/*  73 */         return -1;
/*     */       }
/*     */       
/*     */ 
/*  77 */     });
/*  78 */     type2GetQuality.put(Integer.valueOf(15), new GetQuality()
/*     */     {
/*     */ 
/*     */       public int getQuality(int itemCfgId)
/*     */       {
/*  83 */         return getQuality(SItemCfg.get(itemCfgId));
/*     */       }
/*     */       
/*     */ 
/*     */       public int getQuality(SItemCfg itemCfg)
/*     */       {
/*  89 */         if (itemCfg == null)
/*     */         {
/*  91 */           return -1;
/*     */         }
/*  93 */         if ((itemCfg instanceof SPetLifeItem))
/*     */         {
/*  95 */           return ((SPetLifeItem)itemCfg).itemPro;
/*     */         }
/*     */         
/*  98 */         return -1;
/*     */       }
/*     */       
/*     */ 
/* 102 */     });
/* 103 */     type2GetQuality.put(Integer.valueOf(37), new GetQuality()
/*     */     {
/*     */ 
/*     */       public int getQuality(int itemCfgId)
/*     */       {
/* 108 */         return getQuality(SItemCfg.get(itemCfgId));
/*     */       }
/*     */       
/*     */ 
/*     */       public int getQuality(SItemCfg itemCfg)
/*     */       {
/* 114 */         if (itemCfg == null)
/*     */         {
/* 116 */           return -1;
/*     */         }
/* 118 */         if ((itemCfg instanceof SBaoshiduItem))
/*     */         {
/* 120 */           return ((SBaoshiduItem)itemCfg).drugPro;
/*     */         }
/*     */         
/* 123 */         return -1;
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemGetQuality.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */