/*     */ package mzm.gsp.awardpool.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.awardpool.confbean.SAwardTypeId2PreciousItemSubId;
/*     */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*     */ import mzm.gsp.awardpool.confbean.SRandomTextTableCfg;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ public class PGM_ClearServerDrop extends LogicProcedure
/*     */ {
/*     */   private final long gmRoleid;
/*     */   private final int itemsubid;
/*     */   private int unHitCount;
/*     */   private int dropCount;
/*     */   private int historyDropCount;
/*     */   
/*     */   public PGM_ClearServerDrop(long gmRoleid, int itemsubid, int unHitCount, int dropCount, int historyDropCount)
/*     */   {
/*  23 */     this.gmRoleid = gmRoleid;
/*  24 */     this.itemsubid = itemsubid;
/*  25 */     this.unHitCount = unHitCount;
/*  26 */     this.dropCount = dropCount;
/*  27 */     this.historyDropCount = historyDropCount;
/*     */   }
/*     */   
/*     */   public PGM_ClearServerDrop(int itemsubid, int unHitCount)
/*     */   {
/*  32 */     this.gmRoleid = -1L;
/*  33 */     this.itemsubid = itemsubid;
/*  34 */     this.unHitCount = unHitCount;
/*  35 */     this.dropCount = -1;
/*  36 */     this.historyDropCount = -1;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (this.unHitCount < 0)
/*     */     {
/*  44 */       if (this.gmRoleid != -1L)
/*     */       {
/*  46 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("物品子表%d 设置稀有掉落相关次数失败，未命中次数不能小于0", new Object[] { Integer.valueOf(this.itemsubid) }));
/*     */       }
/*     */       
/*     */ 
/*  50 */       return false;
/*     */     }
/*  52 */     if (this.itemsubid > 0)
/*     */     {
/*  54 */       new SetCountPro(this.gmRoleid, this.itemsubid, this.unHitCount, this.dropCount, this.historyDropCount).execute();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  59 */       for (SAwardTypeId2PreciousItemSubId cfg : SAwardTypeId2PreciousItemSubId.getAll().values())
/*     */       {
/*  61 */         for (i$ = cfg.itemSubIds.iterator(); i$.hasNext();) { int itemSubId = ((Integer)i$.next()).intValue();
/*     */           
/*  63 */           new SetCountPro(this.gmRoleid, itemSubId, this.unHitCount, this.dropCount, this.historyDropCount).execute();
/*     */         }
/*     */       }
/*     */       
/*     */       Iterator i$;
/*  68 */       for (SRandomTextTableCfg randomTextTableCfg : SRandomTextTableCfg.getAll().values())
/*     */       {
/*     */ 
/*  71 */         SPreciousDropCfg preciousDropCfg = SPreciousDropCfg.get(randomTextTableCfg.preciousCfgId);
/*  72 */         if (preciousDropCfg != null)
/*     */         {
/*  74 */           new SetCountPro(this.gmRoleid, randomTextTableCfg.id, this.unHitCount, this.dropCount, this.historyDropCount).execute();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */     return true;
/*     */   }
/*     */   
/*     */   private static class SetCountPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long gmRoleid;
/*     */     private final int itemsubid;
/*     */     private int unHitCount;
/*     */     private int dropCount;
/*     */     private int historyDropCount;
/*     */     
/*     */     public SetCountPro(long gmRoleid, int itemsubid, int unHitCount, int dropCount, int historyDropCount)
/*     */     {
/*  97 */       this.gmRoleid = gmRoleid;
/*  98 */       this.itemsubid = itemsubid;
/*  99 */       this.unHitCount = unHitCount;
/* 100 */       this.dropCount = dropCount;
/* 101 */       this.historyDropCount = historyDropCount;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 107 */       int precoiusId = AwardPoolManager.getPreciousCfgId(this.itemsubid);
/* 108 */       if (precoiusId == -1)
/*     */       {
/* 110 */         if (this.gmRoleid != -1L)
/*     */         {
/* 112 */           GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("物品子表%d 错误，没有稀有掉落", new Object[] { Integer.valueOf(this.itemsubid) }));
/*     */         }
/* 114 */         return false;
/*     */       }
/* 116 */       String itemName = "";
/* 117 */       SItemPoolSub sItemPoolSub = SItemPoolSub.get(this.itemsubid);
/* 118 */       if (sItemPoolSub != null)
/*     */       {
/* 120 */         itemName = ItemInterface.getItemName(sItemPoolSub.itemId);
/*     */       }
/*     */       else
/*     */       {
/* 124 */         SRandomTextTableCfg sRandomTextTableCfg = SRandomTextTableCfg.get(this.itemsubid);
/* 125 */         itemName = ItemInterface.getItemName(sRandomTextTableCfg.itemId);
/*     */       }
/*     */       
/* 128 */       ItemSubidObject itemSubidObject = ItemSubIdDropcCounter.getInstance().getItemSubidObject(this.itemsubid);
/*     */       
/* 130 */       if (this.dropCount == -1)
/*     */       {
/* 132 */         this.dropCount = itemSubidObject.getDropCount();
/*     */       }
/* 134 */       if (this.historyDropCount == -1)
/*     */       {
/* 136 */         this.historyDropCount = itemSubidObject.getHistoryDropCount();
/*     */       }
/*     */       
/* 139 */       if (this.historyDropCount < this.dropCount)
/*     */       {
/* 141 */         if (this.gmRoleid != -1L)
/*     */         {
/* 143 */           GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("物品子表%d 设置稀有掉落相关次数失败，历史掉落次数应该大于等于本阶段掉落次数", new Object[] { Integer.valueOf(this.itemsubid) }));
/*     */         }
/*     */         
/* 146 */         return false;
/*     */       }
/* 148 */       itemSubidObject.resetItemSubIdObject(this.unHitCount, this.dropCount, this.historyDropCount);
/* 149 */       if (this.gmRoleid != -1L)
/*     */       {
/* 151 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("物品子表%d[%s]设置稀有掉落相关次数成功: 未命中次数 %d 已经掉落次数 %d、历史累计掉落次数%d、稀有配置Id %d", new Object[] { Integer.valueOf(this.itemsubid), itemName, Integer.valueOf(this.unHitCount), Integer.valueOf(this.dropCount), Integer.valueOf(this.historyDropCount), Integer.valueOf(precoiusId) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 156 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\PGM_ClearServerDrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */