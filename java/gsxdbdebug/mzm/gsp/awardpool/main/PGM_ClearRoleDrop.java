/*     */ package mzm.gsp.awardpool.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.awardpool.confbean.SAwardTypeId2PreciousItemSubId;
/*     */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*     */ import mzm.gsp.awardpool.confbean.SRandomTextTableCfg;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import xbean.IdCounter;
/*     */ import xbean.ItemSubid2Count;
/*     */ 
/*     */ public class PGM_ClearRoleDrop extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long gmRoleid;
/*     */   private final long roleid;
/*     */   private final int itemsubid;
/*     */   private int unHitCount;
/*     */   private int dropCount;
/*     */   private int historyDropCount;
/*     */   
/*     */   public PGM_ClearRoleDrop(long gmRoleid, long roleid, int itemsubid, int unHitCount, int dropCount, int historyDropCount)
/*     */   {
/*  24 */     this.gmRoleid = gmRoleid;
/*  25 */     this.roleid = roleid;
/*  26 */     this.itemsubid = itemsubid;
/*  27 */     this.unHitCount = unHitCount;
/*  28 */     this.dropCount = dropCount;
/*  29 */     this.historyDropCount = historyDropCount;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (this.unHitCount < 0)
/*     */     {
/*  37 */       if (this.gmRoleid != -1L)
/*     */       {
/*  39 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("角色[%d]的物品子表%d 设置稀有掉落相关次数失败，未命中次数不能小于0", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemsubid) }));
/*     */       }
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*  45 */     if (this.itemsubid > 0)
/*     */     {
/*  47 */       new SetCountPro(this.gmRoleid, this.roleid, this.itemsubid, this.unHitCount, this.dropCount, this.historyDropCount).execute();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  52 */       for (SAwardTypeId2PreciousItemSubId cfg : SAwardTypeId2PreciousItemSubId.getAll().values())
/*     */       {
/*  54 */         for (i$ = cfg.itemSubIds.iterator(); i$.hasNext();) { int itemSubId = ((Integer)i$.next()).intValue();
/*     */           
/*  56 */           new SetCountPro(this.gmRoleid, this.roleid, itemSubId, this.unHitCount, this.dropCount, this.historyDropCount).execute();
/*     */         }
/*     */       }
/*     */       
/*     */       Iterator i$;
/*     */       
/*  62 */       for (SRandomTextTableCfg randomTextTableCfg : SRandomTextTableCfg.getAll().values())
/*     */       {
/*     */ 
/*  65 */         SPreciousDropCfg preciousDropCfg = SPreciousDropCfg.get(randomTextTableCfg.preciousCfgId);
/*  66 */         if (preciousDropCfg != null)
/*     */         {
/*  68 */           new SetCountPro(this.gmRoleid, this.roleid, randomTextTableCfg.id, this.unHitCount, this.dropCount, this.historyDropCount).execute();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  77 */     return true;
/*     */   }
/*     */   
/*     */   private static class SetCountPro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long gmRoleid;
/*     */     private final long roleid;
/*     */     private final int itemsubid;
/*     */     private int unHitCount;
/*     */     private int dropCount;
/*     */     private int historyDropCount;
/*     */     
/*     */     public SetCountPro(long gmRoleid, long roleid, int itemsubid, int unHitCount, int dropCount, int historyDropCount)
/*     */     {
/*  92 */       this.gmRoleid = gmRoleid;
/*  93 */       this.roleid = roleid;
/*  94 */       this.itemsubid = itemsubid;
/*  95 */       this.unHitCount = unHitCount;
/*  96 */       this.dropCount = dropCount;
/*  97 */       this.historyDropCount = historyDropCount;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 103 */       int precoiusId = AwardPoolManager.getPreciousCfgId(this.itemsubid);
/* 104 */       if (precoiusId == -1)
/*     */       {
/* 106 */         if (this.gmRoleid != -1L)
/*     */         {
/* 108 */           GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("角色[%d] 物品子表%d 错误，没有稀有掉落", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemsubid) }));
/*     */         }
/*     */         
/* 111 */         return false;
/*     */       }
/* 113 */       String itemName = "";
/* 114 */       SItemPoolSub sItemPoolSub = SItemPoolSub.get(this.itemsubid);
/* 115 */       if (sItemPoolSub != null)
/*     */       {
/* 117 */         itemName = mzm.gsp.item.main.ItemInterface.getItemName(sItemPoolSub.itemId);
/*     */       }
/*     */       else
/*     */       {
/* 121 */         SRandomTextTableCfg sRandomTextTableCfg = SRandomTextTableCfg.get(this.itemsubid);
/* 122 */         itemName = mzm.gsp.item.main.ItemInterface.getItemName(sRandomTextTableCfg.itemId);
/*     */       }
/* 124 */       ItemSubid2Count xItemSubid2Count = xtable.Role2itemsubid.get(Long.valueOf(this.roleid));
/* 125 */       if (xItemSubid2Count == null)
/*     */       {
/* 127 */         xItemSubid2Count = xbean.Pod.newItemSubid2Count();
/* 128 */         xtable.Role2itemsubid.insert(Long.valueOf(this.roleid), xItemSubid2Count);
/*     */       }
/*     */       
/*     */ 
/* 132 */       IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(this.itemsubid));
/* 133 */       if (xIdCounter == null)
/*     */       {
/* 135 */         xIdCounter = xbean.Pod.newIdCounter();
/* 136 */         xItemSubid2Count.getItemsubid2count().put(Integer.valueOf(this.itemsubid), xIdCounter);
/*     */       }
/*     */       
/* 139 */       if (this.historyDropCount < this.dropCount)
/*     */       {
/* 141 */         if (this.gmRoleid != -1L)
/*     */         {
/* 143 */           GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("角色[%d] 物品子表%d 设置稀有掉落相关次数失败，历史掉落次数应该大于等于本阶段掉落次数", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemsubid) }));
/*     */         }
/*     */         
/* 146 */         return false;
/*     */       }
/*     */       
/* 149 */       if (this.dropCount == -1)
/*     */       {
/* 151 */         this.dropCount = xIdCounter.getDropcount();
/*     */       }
/* 153 */       if (this.historyDropCount == -1)
/*     */       {
/* 155 */         this.historyDropCount = xIdCounter.getHistorydropcount();
/*     */       }
/*     */       
/* 158 */       xIdCounter.setUnhitcount(this.unHitCount);
/* 159 */       xIdCounter.setDropcount(this.dropCount);
/* 160 */       xIdCounter.setHistorydropcount(this.historyDropCount);
/*     */       
/* 162 */       if (this.gmRoleid != -1L)
/*     */       {
/* 164 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("角色[%d] 物品子表%d[%s]设置稀有掉落相关次数成功: 未命中次数 %d 已经掉落次数 %d、历史累计掉落次数%d、稀有配置Id %d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemsubid), itemName, Integer.valueOf(this.unHitCount), Integer.valueOf(this.dropCount), Integer.valueOf(this.historyDropCount), Integer.valueOf(precoiusId) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 169 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\PGM_ClearRoleDrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */