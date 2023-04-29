/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HunNeedItemData
/*     */ {
/*     */   private Map<Integer, Integer> normalItemIds;
/*     */   private Map<Integer, Integer> equalItemIds;
/*     */   
/*     */   public HunNeedItemData()
/*     */   {
/*  21 */     this.normalItemIds = new HashMap();
/*  22 */     this.equalItemIds = new HashMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getNeedNormalItemIds()
/*     */   {
/*  32 */     return this.normalItemIds.keySet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getNeedEqualItemIds()
/*     */   {
/*  42 */     return this.equalItemIds.keySet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getNeedNormalItemNum(int normalItemId)
/*     */   {
/*  53 */     Integer num = (Integer)this.normalItemIds.get(Integer.valueOf(normalItemId));
/*  54 */     return num == null ? 0 : num.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEqualItemNum(int equalItemId)
/*     */   {
/*  65 */     Integer num = (Integer)this.equalItemIds.get(Integer.valueOf(equalItemId));
/*  66 */     return num == null ? 0 : num.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addNormalItems(Map<Integer, Integer> normalItems)
/*     */   {
/*  76 */     addItems(normalItems, this.normalItemIds);
/*     */   }
/*     */   
/*     */   public void addNormalItem(int itemId, int totalNum)
/*     */   {
/*  81 */     addItemTo(itemId, totalNum, this.normalItemIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addEqualItems(Map<Integer, Integer> equalItems)
/*     */   {
/*  91 */     addItems(equalItems, this.equalItemIds);
/*     */   }
/*     */   
/*     */   public void addEqualItem(int itemId, int totalNum)
/*     */   {
/*  96 */     addItemTo(itemId, totalNum, this.equalItemIds);
/*     */   }
/*     */   
/*     */   private void addItems(Map<Integer, Integer> fromItems, Map<Integer, Integer> toItems)
/*     */   {
/* 101 */     for (Map.Entry<Integer, Integer> entry : fromItems.entrySet())
/*     */     {
/* 103 */       addItemTo(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue(), toItems);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addItemTo(int itemId, int totalNum, Map<Integer, Integer> normalItemIds)
/*     */   {
/* 109 */     if (totalNum <= 0)
/*     */     {
/* 111 */       return;
/*     */     }
/* 113 */     Integer ownNum = (Integer)normalItemIds.get(Integer.valueOf(itemId));
/* 114 */     if (ownNum != null)
/*     */     {
/* 116 */       totalNum += ownNum.intValue();
/*     */     }
/* 118 */     normalItemIds.put(Integer.valueOf(itemId), Integer.valueOf(totalNum));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\HunNeedItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */