/*     */ package mzm.gsp.task.operation;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ItemResultEnum;
/*     */ import mzm.gsp.task.GiveoutItemBean;
/*     */ import mzm.gsp.task.confbean.STaskOpertakeGoods;
/*     */ import mzm.gsp.task.confbean.TaskConsts;
/*     */ import mzm.gsp.task.main.RoleTask;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import mzm.gsp.task.main.Task;
/*     */ import mzm.gsp.task.main.TaskManager;
/*     */ import mzm.gsp.task.operParamObj.TakeGoodsParamObj;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TaskBean;
/*     */ 
/*     */ public class Oper_TakeGoods extends AbsOperation
/*     */ {
/*     */   public Oper_TakeGoods(int operId, STaskOpertakeGoods taskGoods, int taskId)
/*     */   {
/*  32 */     super(operId, taskGoods.operType, taskGoods.teamType, taskId);
/*     */   }
/*     */   
/*     */   STaskOpertakeGoods getSTaskOpertakeGoods()
/*     */   {
/*  37 */     return STaskOpertakeGoods.get(getOperId());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*     */   {
/*  43 */     Map<Long, Integer> uuid2Qlv = ItemInterface.getUuid2QiLinLevel(roleId, TaskConsts.getInstance().HAND_UP_ITEM__QILING_LV_MAX + 1, false);
/*     */     
/*  45 */     STaskOpertakeGoods taskGoods = getSTaskOpertakeGoods();
/*  46 */     List<GiveoutItemBean> giveItemBeans = new ArrayList();
/*  47 */     if (operParamsMap.get(Integer.valueOf(this.operId)) != null)
/*     */     {
/*  49 */       if (!(operParamsMap.get(Integer.valueOf(this.operId)) instanceof TakeGoodsParamObj))
/*     */       {
/*  51 */         return false;
/*     */       }
/*  53 */       TakeGoodsParamObj giveGoodUuids = (TakeGoodsParamObj)operParamsMap.get(Integer.valueOf(this.operId));
/*  54 */       if (giveGoodUuids.getGiveItemUuids() != null)
/*     */       {
/*  56 */         giveItemBeans = giveGoodUuids.getGiveItemUuids();
/*     */       }
/*     */     }
/*  59 */     if (taskGoods.cfgType == 1)
/*     */     {
/*  61 */       if (SItemCfg.get(taskGoods.cfgId).pilemax > 1)
/*     */       {
/*  63 */         if (ItemInterface.getItemNumberById(roleId, taskGoods.cfgId) >= taskGoods.cfgCount)
/*     */         {
/*  65 */           return true;
/*     */         }
/*     */       }
/*  68 */       int itemCount = 0;
/*     */       
/*  70 */       for (GiveoutItemBean giveItemBean : giveItemBeans)
/*     */       {
/*  72 */         if (giveItemBean != null)
/*     */         {
/*     */ 
/*     */ 
/*  76 */           BasicItem basicItem = ItemInterface.getItemByUuid(roleId, giveItemBean.uuid);
/*  77 */           if (basicItem == null)
/*     */           {
/*  79 */             GameServer.logger().error(String.format("[task]Oper_TakeGoods.check@ basicItem is null!|roleId=%d|uuid=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(giveItemBean.uuid), Integer.valueOf(getTaskId()) }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*  84 */             Integer qLv = (Integer)uuid2Qlv.get(Long.valueOf(giveItemBean.uuid));
/*  85 */             if (qLv != null)
/*     */             {
/*  87 */               GameServer.logger().error(String.format("[task]Oper_TakeGoods.check@ give item Qlv illegal!|roleId=%d|uuid=%d|taskId=%d|qLv=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(giveItemBean.uuid), Integer.valueOf(getTaskId()), Integer.valueOf(qLv.intValue()) }));
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*  93 */               int giveItemCfgId = basicItem.getCfgId();
/*  94 */               if (giveItemCfgId == taskGoods.cfgId)
/*     */               {
/*  96 */                 itemCount += giveItemBean.num; }
/*     */             }
/*     */           } } }
/*  99 */       if (itemCount < taskGoods.cfgCount)
/*     */       {
/* 101 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/* 103 */           GameServer.logger().debug(String.format("[task]Oper_TakeGoods.check@玩家身上物品携带数量未满足条件需求!|roleId=%d|taskId=%d|itemType=%d|itemId=%d|needNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(getTaskId()), Integer.valueOf(taskGoods.cfgType), Integer.valueOf(taskGoods.cfgId), Integer.valueOf(taskGoods.cfgCount) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 108 */         return false;
/*     */       }
/*     */     }
/* 111 */     if (taskGoods.cfgType == 2)
/*     */     {
/* 113 */       if (giveItemBeans.size() == 0)
/*     */       {
/* 115 */         return false;
/*     */       }
/* 117 */       int count = 0;
/* 118 */       List<Integer> itemIds = ItemInterface.getSamePriceItems(taskGoods.cfgId);
/*     */       
/* 120 */       for (GiveoutItemBean giveItemBean : giveItemBeans)
/*     */       {
/* 122 */         BasicItem basicItem = ItemInterface.getItemByUuid(roleId, giveItemBean.uuid);
/* 123 */         if (basicItem != null)
/*     */         {
/*     */ 
/*     */ 
/* 127 */           int giveItemCfgId = basicItem.getCfgId();
/* 128 */           if (!itemIds.contains(Integer.valueOf(giveItemCfgId)))
/*     */           {
/* 130 */             if (GameServer.logger().isDebugEnabled())
/*     */             {
/* 132 */               GameServer.logger().debug(String.format("[task]Oper_TakeGoods.check@玩家身上物品携带物品id不满足条件！|roleId=%d|taskId=%d|itemType=%d|itemId=%d|needNum=%d|giveItemCfgId", new Object[] { Long.valueOf(roleId), Integer.valueOf(getTaskId()), Integer.valueOf(taskGoods.cfgType), Integer.valueOf(taskGoods.cfgId), Integer.valueOf(taskGoods.cfgCount), Integer.valueOf(giveItemCfgId) }));
/*     */             }
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 138 */             return false;
/*     */           }
/* 140 */           Integer qLv = (Integer)uuid2Qlv.get(Long.valueOf(giveItemBean.uuid));
/* 141 */           if (qLv != null)
/*     */           {
/* 143 */             GameServer.logger().error(String.format("[task]Oper_TakeGoods.check@ give item Qlv illegal!|roleId=%d|uuid=%d|taskId=%d|qLv=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(giveItemBean.uuid), Integer.valueOf(getTaskId()), Integer.valueOf(qLv.intValue()) }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 149 */             count += giveItemBean.num;
/* 150 */             if (count >= taskGoods.cfgCount)
/*     */               break;
/*     */           }
/*     */         }
/*     */       }
/* 155 */       if (count < taskGoods.cfgCount)
/*     */       {
/* 157 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/* 159 */           GameServer.logger().debug(String.format("[task]Oper_TakeGoods.check@玩家身上物品携带数量未满足条件需求！|roleId=%d|taskId=%d|itemType=%d|itemId=%d|needNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(getTaskId()), Integer.valueOf(taskGoods.cfgType), Integer.valueOf(taskGoods.cfgId), Integer.valueOf(taskGoods.cfgCount) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 164 */         return false;
/*     */       }
/*     */     }
/* 167 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*     */   {
/* 173 */     Map<Long, Integer> uuid2Qlv = ItemInterface.getUuid2QiLinLevel(roleId, TaskConsts.getInstance().HAND_UP_ITEM__QILING_LV_MAX + 1, false);
/*     */     
/* 175 */     STaskOpertakeGoods taskGoods = getSTaskOpertakeGoods();
/* 176 */     if (isTaskGiveGood(roleId))
/*     */     {
/* 178 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 182 */     if ((taskGoods.cfgType == 1) && (SItemCfg.get(taskGoods.cfgId).pilemax > 1))
/*     */     {
/* 184 */       return ItemInterface.removeItemById(roleId, 340600000, taskGoods.cfgId, taskGoods.cfgCount, new TLogArg(LogReason.TASK_OPER_REM, getTaskId()));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 190 */     List<GiveoutItemBean> giveItemBeans = new ArrayList();
/* 191 */     if (operParamsMap.get(Integer.valueOf(this.operId)) != null)
/*     */     {
/* 193 */       if (!(operParamsMap.get(Integer.valueOf(this.operId)) instanceof TakeGoodsParamObj))
/*     */       {
/* 195 */         return false;
/*     */       }
/* 197 */       TakeGoodsParamObj giveGoodUuids = (TakeGoodsParamObj)operParamsMap.get(Integer.valueOf(this.operId));
/* 198 */       if (giveGoodUuids.getGiveItemUuids() != null)
/*     */       {
/* 200 */         giveItemBeans = giveGoodUuids.getGiveItemUuids();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 205 */     Set<Long> itemUuids = new HashSet();
/* 206 */     Map<Long, Integer> uuidMap = new HashMap();
/* 207 */     int count = 0;
/* 208 */     if (taskGoods.cfgType == 1)
/*     */     {
/*     */ 
/* 211 */       for (GiveoutItemBean giveItemBean : giveItemBeans)
/*     */       {
/* 213 */         BasicItem basicItem = ItemInterface.getItemByUuid(roleId, giveItemBean.uuid);
/* 214 */         if (basicItem == null)
/*     */         {
/* 216 */           GameServer.logger().error(String.format("[task]Oper_TakeGoods.check@ basicItem is null!|roleId=%d|uuid=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(giveItemBean.uuid) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 221 */           int giveItemCfgId = basicItem.getCfgId();
/* 222 */           if (giveItemCfgId == taskGoods.cfgId)
/*     */           {
/* 224 */             Integer qLv = (Integer)uuid2Qlv.get(Long.valueOf(giveItemBean.uuid));
/* 225 */             if (qLv != null)
/*     */             {
/* 227 */               GameServer.logger().error(String.format("[task]Oper_TakeGoods.execute@ give item Qlv illegal!|roleId=%d|uuid=%d|taskId=%d|qLv=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(giveItemBean.uuid), Integer.valueOf(getTaskId()), Integer.valueOf(qLv.intValue()) }));
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/* 233 */               uuidMap.put(Long.valueOf(giveItemBean.uuid), Integer.valueOf(giveItemBean.num));
/* 234 */               count += giveItemBean.num;
/*     */             }
/* 236 */           } else { if (count >= taskGoods.cfgCount)
/*     */               break;
/*     */           }
/*     */         }
/*     */       } }
/*     */     List<Integer> itemIds;
/* 242 */     if (taskGoods.cfgType == 2)
/*     */     {
/* 244 */       itemIds = ItemInterface.getSamePriceItems(taskGoods.cfgId);
/*     */       
/* 246 */       for (GiveoutItemBean giveItemBean : giveItemBeans)
/*     */       {
/* 248 */         BasicItem basicItem = ItemInterface.getItemByUuid(roleId, giveItemBean.uuid);
/* 249 */         if (basicItem == null)
/*     */         {
/* 251 */           GameServer.logger().error(String.format("[task]Oper_TakeGoods.check@ basicItem is null!|roleId=%d|uuid=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(giveItemBean.uuid) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 256 */         else if (itemIds.contains(Integer.valueOf(basicItem.getCfgId())))
/*     */         {
/* 258 */           Integer qLv = (Integer)uuid2Qlv.get(Long.valueOf(giveItemBean.uuid));
/* 259 */           if (qLv != null)
/*     */           {
/* 261 */             GameServer.logger().error(String.format("[task]Oper_TakeGoods.execute@ give item Qlv illegal!|roleId=%d|uuid=%d|taskId=%d|qLv=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(giveItemBean.uuid), Integer.valueOf(getTaskId()), Integer.valueOf(qLv.intValue()) }));
/*     */ 
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 268 */             uuidMap.put(Long.valueOf(giveItemBean.uuid), Integer.valueOf(giveItemBean.num));
/* 269 */             count += giveItemBean.num;
/*     */           }
/* 271 */         } else { if (count >= taskGoods.cfgCount) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 277 */     if (count < taskGoods.cfgCount)
/*     */     {
/* 279 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 281 */         GameServer.logger().debug(String.format("[task]Oper_TakeGoods.execute@ con not enough！|roleId=%d|taskId=%d|itemType=%d|itemId=%d|needNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(getTaskId()), Integer.valueOf(taskGoods.cfgType), Integer.valueOf(taskGoods.cfgId), Integer.valueOf(taskGoods.cfgCount) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 286 */       return false;
/*     */     }
/*     */     
/* 289 */     ItemOperateResult ret = ItemInterface.removeItemByUuid(roleId, uuidMap, new TLogArg(LogReason.TASK_OPER_REM, getTaskId()));
/*     */     
/* 291 */     if (ret.success())
/*     */     {
/* 293 */       return true;
/*     */     }
/* 295 */     GameServer.logger().error(String.format("[task]Oper_TakeGoods.execute@rm item err！|roleId=%d|taskId=%d|itemType=%d|itemId=%d|needNum=%d|ret=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(getTaskId()), Integer.valueOf(taskGoods.cfgType), Integer.valueOf(taskGoods.cfgId), Integer.valueOf(taskGoods.cfgCount), Integer.valueOf(ret.getResultEnum().ret) }));
/*     */     
/*     */ 
/*     */ 
/* 299 */     return false;
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
/*     */   private boolean isTaskGiveGood(long roleId)
/*     */   {
/* 312 */     STaskOpertakeGoods taskGoods = getSTaskOpertakeGoods();
/* 313 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, false);
/* 314 */     List<TaskBean> taskBeans = roleTask.getAllTaskBean();
/* 315 */     for (TaskBean taskBean : taskBeans)
/*     */     {
/* 317 */       if (taskBean.getTaskstate() == 3)
/*     */       {
/*     */ 
/*     */ 
/* 321 */         Task task = TaskManager.getTaskById(taskBean.getTaskid());
/* 322 */         List<AbsOperation> absOperations = task.getOperation(1, taskGoods.teamType);
/* 323 */         for (AbsOperation absOperation : absOperations)
/*     */         {
/* 325 */           if ((absOperation instanceof Oper_GiveTaskGoods))
/*     */           {
/*     */ 
/*     */ 
/* 329 */             Oper_GiveTaskGoods oper_GiveTaskGoods = (Oper_GiveTaskGoods)absOperation;
/* 330 */             if (oper_GiveTaskGoods.getGiveTaskGoods().taskGoodsId == taskGoods.cfgId)
/*     */             {
/* 332 */               return true; }
/*     */           } }
/*     */       }
/*     */     }
/* 336 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 342 */     STaskOpertakeGoods taskGoods = getSTaskOpertakeGoods();
/* 343 */     if (taskGoods.cfgType == 1)
/*     */     {
/* 345 */       if (!ItemInterface.isItemExist(taskGoods.cfgId))
/*     */       {
/* 347 */         throw new RuntimeException("任务配置的物品不存在:taskId:" + getTaskId() + " itemId:" + taskGoods.cfgId + " 包裹条件");
/*     */       }
/*     */     }
/* 350 */     else if (taskGoods.cfgType == 2)
/*     */     {
/* 352 */       if (ItemInterface.getSamePriceItems(taskGoods.cfgId).size() == 0)
/*     */       {
/* 354 */         throw new RuntimeException("任务配置的等价表id不存在或等价表没有配置物品:taskId:" + getTaskId() + " 等价表Id:" + taskGoods.cfgId + "包裹条件");
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_TakeGoods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */