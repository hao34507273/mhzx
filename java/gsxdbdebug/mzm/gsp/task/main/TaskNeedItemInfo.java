/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskNeedItemInfo
/*     */ {
/*     */   private Map<Integer, Map<Integer, Set<Integer>>> task2itemInfo;
/*     */   private Set<Integer> normalItemIds;
/*     */   private Set<Integer> equalItemIds;
/*     */   
/*     */   public TaskNeedItemInfo()
/*     */   {
/*  26 */     this.task2itemInfo = new HashMap();
/*  27 */     this.normalItemIds = new HashSet();
/*  28 */     this.equalItemIds = new HashSet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, Map<Integer, Set<Integer>>> getTask2itemInfo()
/*     */   {
/*  39 */     return this.task2itemInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getNormalItemIds()
/*     */   {
/*  49 */     return this.normalItemIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getEqualItemIds()
/*     */   {
/*  59 */     return this.equalItemIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean addItemInfoTo(int taskId, int type, Set<Integer> itemIds)
/*     */   {
/*  72 */     if ((itemIds == null) || (itemIds.size() == 0))
/*     */     {
/*  74 */       return true;
/*     */     }
/*  76 */     Map<Integer, Set<Integer>> singleTaskItemInfo = (Map)this.task2itemInfo.get(Integer.valueOf(taskId));
/*  77 */     if (singleTaskItemInfo == null)
/*     */     {
/*  79 */       this.task2itemInfo.put(Integer.valueOf(taskId), new HashMap());
/*  80 */       singleTaskItemInfo = (Map)this.task2itemInfo.get(Integer.valueOf(taskId));
/*     */     }
/*  82 */     Set<Integer> items = (Set)singleTaskItemInfo.get(Integer.valueOf(type));
/*  83 */     if (items == null)
/*     */     {
/*  85 */       singleTaskItemInfo.put(Integer.valueOf(type), new HashSet());
/*  86 */       items = (Set)singleTaskItemInfo.get(Integer.valueOf(type));
/*     */     }
/*  88 */     items.addAll(itemIds);
/*     */     
/*  90 */     switch (type)
/*     */     {
/*     */     case 1: 
/*  93 */       this.normalItemIds.addAll(itemIds);
/*  94 */       break;
/*     */     case 2: 
/*  96 */       this.equalItemIds.addAll(itemIds);
/*  97 */       break;
/*     */     }
/*     */     
/*     */     
/* 101 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskNeedItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */