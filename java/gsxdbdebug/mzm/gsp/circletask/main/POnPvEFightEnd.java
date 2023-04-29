/*     */ package mzm.gsp.circletask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.activity.SSyncLegendTimeReward;
/*     */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.main.MapDarkMonsterFightContext;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.main.TaskFinishNeedItem;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.CircleTask;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2circletask;
/*     */ 
/*     */ public class POnPvEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   private static final int BASE_PROP = 10000;
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     if (!((PVEFightEndArg)this.arg).isPlayerWin) {
/*  31 */       return false;
/*     */     }
/*  33 */     if ((((PVEFightEndArg)this.arg).context == null) || (!(((PVEFightEndArg)this.arg).context instanceof MapDarkMonsterFightContext))) {
/*  34 */       return false;
/*     */     }
/*  36 */     MapDarkMonsterFightContext mfc = (MapDarkMonsterFightContext)((PVEFightEndArg)this.arg).context;
/*  37 */     Set<Long> aliveRoleList = new java.util.HashSet();
/*  38 */     for (Long roleId : ((PVEFightEndArg)this.arg).alivedRoles) {
/*  39 */       aliveRoleList.add(roleId);
/*     */     }
/*  41 */     for (Long roleId : ((PVEFightEndArg)this.arg).diedRoles) {
/*  42 */       aliveRoleList.add(roleId);
/*     */     }
/*  44 */     for (Iterator i$ = aliveRoleList.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*  45 */       Role.addRoleProcedure(roleId, new mzm.gsp.util.LogicProcedure() {
/*     */         protected boolean processImp() throws Exception {
/*  47 */           CircleTask xCircleTask = Role2circletask.get(Long.valueOf(roleId));
/*  48 */           if (xCircleTask == null) {
/*  49 */             return false;
/*     */           }
/*  51 */           if (xCircleTask.getLegendendtime() < mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()) {
/*  52 */             return false;
/*     */           }
/*  54 */           if (!mzm.gsp.guaji.main.GuajiInterface.isRightLevelGuaJiMap(roleId, this.val$mfc.mapId)) {
/*  55 */             return false;
/*     */           }
/*  57 */           int taskId = TaskInterface.findTaskInGraph(roleId, CircleTaskConsts.getInstance().TASK_GRAPHIC_ID);
/*     */           
/*  59 */           TaskFinishNeedItem needItem = TaskInterface.getFinishTaskItem(taskId);
/*  60 */           if (POnPvEFightEnd.this.notHasItem(needItem)) {
/*  61 */             POnPvEFightEnd.this.updateLengendTime(roleId, xCircleTask, taskId, 0L);
/*  62 */             return true;
/*     */           }
/*     */           
/*  65 */           if (POnPvEFightEnd.this.isDropItem()) {
/*  66 */             return false;
/*     */           }
/*     */           
/*  69 */           int id = POnPvEFightEnd.this.randomItem(needItem);
/*     */           
/*  71 */           ItemInterface.addItem(roleId, id, 1, new TLogArg(mzm.gsp.tlog.LogReason.PAOHUAN_LEGEND_DROP_ADD, id));
/*  72 */           POnPvEFightEnd.this.updateLengendTime(roleId, xCircleTask, taskId, 0L);
/*  73 */           SSyncLegendTimeReward sSyncLegendTimeReward = new SSyncLegendTimeReward();
/*  74 */           sSyncLegendTimeReward.itemid = id;
/*  75 */           sSyncLegendTimeReward.itemnum = 1;
/*  76 */           OnlineManager.getInstance().send(roleId, sSyncLegendTimeReward);
/*  77 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   private void updateLengendTime(long roleId, CircleTask xCircleTask, int taskId, long endTime) {
/*  85 */     xCircleTask.setLegendendtime(endTime);
/*  86 */     CircleTaskManager.synLegendTime(roleId, endTime, taskId);
/*     */   }
/*     */   
/*     */   private boolean notHasItem(TaskFinishNeedItem needItem) {
/*  90 */     return (needItem.getItemConMap().isEmpty()) && (needItem.getItemMap().isEmpty());
/*     */   }
/*     */   
/*     */   private int randomItem(TaskFinishNeedItem needItem) {
/*  94 */     int itemId = randomSamePriceItem(needItem);
/*  95 */     if (itemId == -1) {
/*  96 */       itemId = randomFromItemList(needItem);
/*     */     }
/*  98 */     return itemId;
/*     */   }
/*     */   
/*     */   private int randomFromItemList(TaskFinishNeedItem needItem) {
/* 102 */     Map<Integer, Integer> map = needItem.getItemMap();
/* 103 */     if (map.isEmpty()) return -1;
/* 104 */     Iterator<Integer> it = map.keySet().iterator();
/* 105 */     List<Integer> idList = new ArrayList();
/* 106 */     while (it.hasNext()) {
/* 107 */       int id = ((Integer)it.next()).intValue();
/* 108 */       idList.add(Integer.valueOf(id));
/*     */     }
/* 110 */     return ((Integer)idList.get(Xdb.random().nextInt(idList.size()))).intValue();
/*     */   }
/*     */   
/*     */   private int randomSamePriceItem(TaskFinishNeedItem needItem) {
/* 114 */     Map<Integer, Integer> map = needItem.getItemConMap();
/* 115 */     if (map.isEmpty()) return -1;
/* 116 */     Iterator<Integer> it = map.keySet().iterator();
/* 117 */     List<Integer> idList = new ArrayList();
/* 118 */     while (it.hasNext()) {
/* 119 */       int id = ((Integer)it.next()).intValue();
/* 120 */       idList.add(Integer.valueOf(CircleTaskManager.getInstance().getSamePriceReplaceId(id)));
/*     */     }
/* 122 */     int i = Xdb.random().nextInt(idList.size());
/* 123 */     int priceItemId = ((Integer)idList.get(i)).intValue();
/* 124 */     List<Integer> items = ItemInterface.getSamePriceItems(priceItemId);
/* 125 */     if ((items == null) || (items.isEmpty())) {
/* 126 */       return -1;
/*     */     }
/* 128 */     return ((Integer)items.get(Xdb.random().nextInt(items.size()))).intValue();
/*     */   }
/*     */   
/*     */   private boolean isDropItem() {
/* 132 */     return Xdb.random().nextInt(10000) > CircleTaskConsts.getInstance().LEGEND_DROP_PROP;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */