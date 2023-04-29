/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskConBag;
/*     */ import mzm.gsp.task.confbean.TaskConsts;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import xbean.ConBean;
/*     */ 
/*     */ public class Con_Bag_9 extends AbsCondition
/*     */ {
/*     */   public STaskConBag getConBag()
/*     */   {
/*  21 */     return STaskConBag.get(getConId());
/*     */   }
/*     */   
/*     */   public Con_Bag_9(int conId, int conType, int sTaskId)
/*     */   {
/*  26 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  32 */     if (conMap == null)
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/*  37 */     if (conBean == null)
/*     */     {
/*  39 */       conBean = xbean.Pod.newConBean();
/*  40 */       conBean.setType(getType());
/*  41 */       conMap.put(Integer.valueOf(getConId()), conBean);
/*     */     }
/*  43 */     STaskConBag conBag = getConBag();
/*  44 */     if (conBag.takeCfgId > 0)
/*     */     {
/*  46 */       if (conBag.takeItemType == 1)
/*     */       {
/*  48 */         long count = getTaskConItemCount(roleId, Arrays.asList(new Integer[] { Integer.valueOf(conBag.takeCfgId) }));
/*  49 */         setConData(roleId, graphId, conBean, Math.min(count, conBag.takeCfgCount));
/*  50 */         if (count < conBag.takeCfgCount)
/*     */         {
/*  52 */           return false;
/*     */         }
/*     */       }
/*  55 */       else if (conBag.takeItemType == 2)
/*     */       {
/*  57 */         long count = getTaskConItemCount(roleId, ItemInterface.getSamePriceItems(conBag.takeCfgId));
/*  58 */         setConData(roleId, graphId, conBean, Math.min(count, conBag.takeCfgCount));
/*  59 */         if (count < conBag.takeCfgCount)
/*     */         {
/*  61 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*  65 */     if (conBag.notHaveCfgId > 0)
/*     */     {
/*  67 */       if (conBag.notHaveItemType == 1)
/*     */       {
/*  69 */         if (ItemInterface.getItemNumberById(roleId, conBag.notHaveCfgId) >= conBag.notHaveCfgCount)
/*     */         {
/*  71 */           return false;
/*     */         }
/*     */       }
/*  74 */       else if (conBag.notHaveItemType == 2)
/*     */       {
/*  76 */         List<Integer> itemList = ItemInterface.getSamePriceItems(conBag.notHaveCfgId);
/*  77 */         int count = 0;
/*  78 */         for (Iterator i$ = itemList.iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */           
/*  80 */           count += ItemInterface.getItemNumberById(roleId, itemId);
/*     */         }
/*  82 */         if (count >= conBag.notHaveCfgCount)
/*     */         {
/*  84 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   void setConData(long roleId, int graphId, ConBean conBean, long count)
/*     */   {
/*  94 */     conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_BAG.getParamType()), Long.valueOf(count));
/*  95 */     if (getConType() == 2)
/*     */     {
/*  97 */       RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 104 */     return 9;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 110 */     STaskConBag conBag = getConBag();
/* 111 */     if (conBag.takeCfgId > 0)
/*     */     {
/* 113 */       if (conBag.takeItemType == 1)
/*     */       {
/* 115 */         if (!ItemInterface.isItemExist(conBag.takeCfgId))
/*     */         {
/* 117 */           throw new RuntimeException("任务配置的物品不存在:taskId:" + getSTask().id + " itemId:" + conBag.takeCfgId + " 包裹条件");
/*     */         }
/*     */       }
/* 120 */       else if (conBag.takeItemType == 2)
/*     */       {
/* 122 */         if (ItemInterface.getSamePriceItems(conBag.takeCfgId).size() == 0)
/*     */         {
/* 124 */           throw new RuntimeException("任务配置的等价表id不存在或等价表没有配置物品:taskId:" + getSTask().id + " 等价表Id:" + conBag.takeCfgId + "包裹条件");
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 129 */     if (conBag.notHaveCfgId > 0)
/*     */     {
/* 131 */       if (conBag.notHaveItemType == 1)
/*     */       {
/* 133 */         if (!ItemInterface.isItemExist(conBag.notHaveCfgId))
/*     */         {
/* 135 */           throw new RuntimeException("任务配置的物品不存在:taskId:" + getSTask().id + " itemId:" + conBag.notHaveCfgId + " 包裹条件");
/*     */         }
/*     */         
/*     */       }
/* 139 */       else if (conBag.notHaveItemType == 2)
/*     */       {
/* 141 */         if (ItemInterface.getSamePriceItems(conBag.notHaveCfgId).size() == 0)
/*     */         {
/* 143 */           throw new RuntimeException("任务配置的等价表id不存在或等价表没有配置物品:taskId:" + getSTask().id + " 等价表Id:" + conBag.notHaveCfgId + "包裹条件");
/*     */         }
/*     */       }
/*     */     }
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
/*     */   int getTaskConItemCount(long roleId, Collection<Integer> itemIds)
/*     */   {
/* 159 */     if ((itemIds == null) || (itemIds.size() == 0))
/*     */     {
/* 161 */       return 0;
/*     */     }
/* 163 */     int num = 0;
/* 164 */     for (Iterator i$ = itemIds.iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */       
/* 166 */       num += getNeedUuidsNum(roleId, itemId);
/*     */     }
/* 168 */     return num;
/*     */   }
/*     */   
/*     */   private int getNeedUuidsNum(long roleId, int itemId)
/*     */   {
/* 173 */     int qilingLvMax = TaskConsts.getInstance().HAND_UP_ITEM__QILING_LV_MAX;
/* 174 */     Map<Integer, BasicItem> basicItems = ItemInterface.getItemByItemId(roleId, itemId, true);
/* 175 */     if ((basicItems == null) || (basicItems.size() == 0))
/*     */     {
/* 177 */       return 0;
/*     */     }
/* 179 */     int totalNum = 0;
/* 180 */     for (BasicItem basicItem : basicItems.values())
/*     */     {
/* 182 */       Integer qilingLv = basicItem.getExtra(ItemStoreEnum.STRENGTH_LEVEL);
/* 183 */       if ((qilingLv == null) || (qilingLvMax >= qilingLv.intValue()))
/*     */       {
/* 185 */         totalNum += basicItem.getNumber();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 192 */     return totalNum;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Bag_9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */