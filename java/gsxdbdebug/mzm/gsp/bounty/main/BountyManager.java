/*     */ package mzm.gsp.bounty.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.BountyConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bounty.SBountyNormalResult;
/*     */ import mzm.gsp.bounty.SSynBTaskStatus;
/*     */ import mzm.gsp.bounty.SSynBountyInfo;
/*     */ import mzm.gsp.function.confbean.SBountyTaskCfg;
/*     */ import mzm.gsp.function.confbean.STRank2taskIds;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.task.operation.Oper_GiveAward;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BTaskData;
/*     */ import xbean.BountyInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2bounty;
/*     */ 
/*     */ public class BountyManager
/*     */ {
/*  45 */   private static List<Integer> graphIds = new ArrayList();
/*     */   
/*     */ 
/*  48 */   private static List<Integer> awardIds = new ArrayList();
/*     */   
/*  50 */   private static int WAN = 10000;
/*     */   
/*     */   public static List<Integer> getGraphIds()
/*     */   {
/*  54 */     return graphIds;
/*     */   }
/*     */   
/*     */   static BountyConsts getBountyConsts()
/*     */   {
/*  59 */     return BountyConsts.getInstance();
/*     */   }
/*     */   
/*     */   static boolean addGraphId(int graphId)
/*     */   {
/*  64 */     if (graphIds.contains(Integer.valueOf(graphId)))
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     graphIds.add(Integer.valueOf(graphId));
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   static boolean addAwardId(int awardId)
/*     */   {
/*  74 */     if (awardIds.contains(Integer.valueOf(awardId)))
/*     */     {
/*  76 */       return true;
/*     */     }
/*  78 */     awardIds.add(Integer.valueOf(awardId));
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   static boolean initCfg() throws Exception
/*     */   {
/*  84 */     ActivityInterface.registerActivityByLogicType(3, new BountyActivityInit());
/*     */     
/*  86 */     if (!addGraphId(getBountyConsts().TASK_GRAPH_ID_1))
/*     */     {
/*  88 */       throw new RuntimeException("赏金常量表,配置了相同的任务图ID:" + getBountyConsts().TASK_GRAPH_ID_1);
/*     */     }
/*  90 */     if (!addGraphId(getBountyConsts().TASK_GRAPH_ID_2))
/*     */     {
/*  92 */       throw new RuntimeException("赏金常量表,配置了相同的任务图ID:" + getBountyConsts().TASK_GRAPH_ID_2);
/*     */     }
/*  94 */     if (!addGraphId(getBountyConsts().TASK_GRAPH_ID_3))
/*     */     {
/*  96 */       throw new RuntimeException("赏金常量表,配置了相同的任务图ID:" + getBountyConsts().TASK_GRAPH_ID_3);
/*     */     }
/*  98 */     if (!addGraphId(getBountyConsts().TASK_GRAPH_ID_4))
/*     */     {
/* 100 */       throw new RuntimeException("赏金常量表,配置了相同的任务图ID:" + getBountyConsts().TASK_GRAPH_ID_4);
/*     */     }
/*     */     
/* 103 */     addAwardId(getBountyConsts().ONE_AWARD_ID);
/* 104 */     addAwardId(getBountyConsts().TWO_AWARD_ID);
/* 105 */     addAwardId(getBountyConsts().THREE_AWARD_ID);
/* 106 */     addAwardId(getBountyConsts().FOUR_AWARD_ID);
/*     */     
/* 108 */     for (Iterator i$ = awardIds.iterator(); i$.hasNext();) { int awardId = ((Integer)i$.next()).intValue();
/*     */       
/* 110 */       ItemAccessManager.registerActivityReward(BountyConsts.getInstance().ACTIVITYID, awardId);
/*     */     }
/* 112 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 114 */       Oper_GiveAward.registerOwnAwardImpl(graphId, BountyGetAwardHandler.getInstance());
/*     */     }
/*     */     
/* 117 */     return true;
/*     */   }
/*     */   
/*     */   static boolean check()
/*     */   {
/* 122 */     for (Iterator i$ = getGraphIds().iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 124 */       if (!TaskInterface.isHaveGraphId(graphId))
/*     */       {
/* 126 */         throw new RuntimeException("赏金常量表,配置的任务图ID不存在，ID=:" + graphId);
/*     */       }
/*     */     }
/*     */     
/* 130 */     if (!AwardInterface.hasAwardId(BountyConsts.getInstance().BASE_AWARD_ID))
/*     */     {
/* 132 */       throw new RuntimeException("赏金常量表,配置的基础奖励ID不存在，ID=:" + BountyConsts.getInstance().BASE_AWARD_ID);
/*     */     }
/*     */     
/* 135 */     for (Iterator i$ = awardIds.iterator(); i$.hasNext();) { int awardId = ((Integer)i$.next()).intValue();
/*     */       
/* 137 */       if (!AwardInterface.hasAwardId(awardId))
/*     */       {
/* 139 */         throw new RuntimeException("赏金常量表,配置的奖励ID不存在，ID=:" + awardId);
/*     */       }
/*     */     }
/*     */     
/* 143 */     int graphId = BountyConsts.getInstance().GUIDE_GRAPH_ID;
/* 144 */     if (graphId > 0)
/*     */     {
/* 146 */       if (!TaskInterface.isHaveGraphId(graphId))
/*     */       {
/* 148 */         throw new RuntimeException("赏金常量表,配置的指引任务图ID不存在，ID=:" + graphId);
/*     */       }
/*     */     }
/*     */     
/* 152 */     return true;
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
/*     */   static BountyInfo createBountyXTable(long roleId)
/*     */   {
/* 165 */     BountyInfo xBountyInfo = Pod.newBountyInfo();
/* 166 */     xBountyInfo.setBountycount(0);
/* 167 */     Role2bounty.insert(Long.valueOf(roleId), xBountyInfo);
/* 168 */     return xBountyInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean refreshNewBountyTasks(long roleId, BountyInfo xBountyInfo, boolean needGetOneSpecialTask)
/*     */   {
/* 180 */     if (xBountyInfo == null)
/*     */     {
/* 182 */       return false;
/*     */     }
/*     */     
/* 185 */     xBountyInfo.getTaskinfos().clear();
/*     */     
/* 187 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 189 */       int taskId = flushNewBTaskByGraphId(roleId, graphId);
/* 190 */       if (taskId < 0)
/*     */       {
/* 192 */         GameServer.logger().error(String.format("[bounty]BountyManager.flushNewBountyTasks@ refresh tasks err!|graphId=%d|roleId=%d", new Object[] { Integer.valueOf(graphId), Long.valueOf(roleId) }));
/*     */         
/*     */ 
/* 195 */         return false;
/*     */       }
/* 197 */       createBountyTask(xBountyInfo, graphId, taskId);
/*     */     }
/* 199 */     checkRefreshedTasks(roleId, xBountyInfo, needGetOneSpecialTask);
/* 200 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void createBountyTask(BountyInfo xBountyInfo, int graphId, int taskId)
/*     */   {
/* 212 */     xbean.BTaskInfo xBTaskInfo = Pod.newBTaskInfo();
/* 213 */     xBTaskInfo.setTaskid(taskId);
/* 214 */     xBTaskInfo.setTaskstate(0);
/* 215 */     xBountyInfo.getTaskinfos().put(Integer.valueOf(graphId), xBTaskInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   static void checkRefreshedTasks(long roleId, BountyInfo xBountyInfo, boolean needGetOneSpecialTask)
/*     */   {
/* 221 */     if (!OpenInterface.getOpenStatus(308))
/*     */     {
/* 223 */       return;
/*     */     }
/* 225 */     STRank2taskIds specialCfg = STRank2taskIds.get(5);
/* 226 */     if (specialCfg == null)
/*     */     {
/* 228 */       GameServer.logger().error(String.format("[bounty]BountyManager.checkRefreshedTasks@ no specialCfg!|roleId=%d|rank=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(5) }));
/*     */       
/*     */ 
/* 231 */       return;
/*     */     }
/* 233 */     List<Integer> specialTaskIds = specialCfg.taskIds;
/* 234 */     Pair<Boolean, Integer> pair = getNeedChangeGraphId(xBountyInfo.getTaskinfos(), specialTaskIds);
/* 235 */     boolean ownSpecialTask = ((Boolean)pair.first).booleanValue();
/* 236 */     if (ownSpecialTask)
/*     */     {
/*     */ 
/* 239 */       clearSpecialCount(roleId, xBountyInfo);
/* 240 */       return;
/*     */     }
/* 242 */     if (!needGetOneSpecialTask)
/*     */     {
/* 244 */       return;
/*     */     }
/* 246 */     int targetGraphId = ((Integer)pair.second).intValue();
/* 247 */     if (targetGraphId <= 0)
/*     */     {
/* 249 */       return;
/*     */     }
/* 251 */     int targetTaskId = ranOneTaskId(specialTaskIds);
/* 252 */     if (targetTaskId <= 0)
/*     */     {
/* 254 */       return;
/*     */     }
/*     */     
/* 257 */     createBountyTask(xBountyInfo, targetGraphId, targetTaskId);
/*     */     
/* 259 */     clearSpecialCount(roleId, xBountyInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int ranOneTaskId(List<Integer> taskIds)
/*     */   {
/* 270 */     if ((taskIds == null) || (taskIds.size() == 0))
/*     */     {
/* 272 */       return 0;
/*     */     }
/* 274 */     List<Integer> targetTaskIds = new ArrayList();
/* 275 */     CommonUtils.regionRandom(taskIds, 1, targetTaskIds);
/* 276 */     return targetTaskIds.size() != 1 ? 0 : ((Integer)targetTaskIds.get(0)).intValue();
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
/*     */   private static Pair<Boolean, Integer> getNeedChangeGraphId(Map<Integer, xbean.BTaskInfo> ownTaskInfos, List<Integer> specialTaskIds)
/*     */   {
/* 289 */     Pair<Boolean, Integer> pair = new Pair(Boolean.valueOf(false), Integer.valueOf(0));
/* 290 */     if ((specialTaskIds == null) || (specialTaskIds.size() == 0))
/*     */     {
/* 292 */       return pair;
/*     */     }
/* 294 */     int needChangeGraphId = 0;
/* 295 */     int index = 0;
/* 296 */     int ran = Xdb.random().nextInt(ownTaskInfos.size());
/* 297 */     boolean ownSpecialTask = false;
/* 298 */     for (Map.Entry<Integer, xbean.BTaskInfo> entry : ownTaskInfos.entrySet())
/*     */     {
/* 300 */       int graphId = ((Integer)entry.getKey()).intValue();
/* 301 */       int taskId = ((xbean.BTaskInfo)entry.getValue()).getTaskid();
/* 302 */       if (index == ran)
/*     */       {
/* 304 */         needChangeGraphId = graphId;
/*     */       }
/* 306 */       if (specialTaskIds.contains(Integer.valueOf(taskId)))
/*     */       {
/* 308 */         ownSpecialTask = true;
/* 309 */         break;
/*     */       }
/* 311 */       index++;
/*     */     }
/* 313 */     pair.first = Boolean.valueOf(ownSpecialTask);
/* 314 */     pair.second = Integer.valueOf(ownSpecialTask ? 0 : needChangeGraphId);
/* 315 */     return pair;
/*     */   }
/*     */   
/*     */   static void clearSpecialCount(long roleId, BountyInfo xBountyInfo)
/*     */   {
/* 320 */     if (xBountyInfo == null)
/*     */     {
/* 322 */       return;
/*     */     }
/*     */     
/* 325 */     xBountyInfo.setUsedbirdnum(0);
/*     */     
/* 327 */     xBountyInfo.setFreerefreshcount(0);
/*     */     
/* 329 */     int preGuaranteeCount = xBountyInfo.getPreguaranteecount();
/* 330 */     if (preGuaranteeCount < BountyConsts.getInstance().FRIST_BAO_DI_COUNT)
/*     */     {
/* 332 */       xBountyInfo.setPreguaranteecount(preGuaranteeCount + 1);
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
/*     */   static int flushNewBTaskByGraphId(long roleId, int graphId)
/*     */   {
/* 345 */     return TaskInterface.randomOneTaskInGraph(roleId, graphId);
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
/*     */   static int rmGoldBird(String userId, long roleId, BountyInfo xBountyInfo, boolean isFrist, boolean useYuan, long cCurYuan, long cNeedYuan)
/*     */   {
/* 368 */     if (isFrist)
/*     */     {
/*     */ 
/* 371 */       return 0;
/*     */     }
/* 373 */     int num = getNeedBirdNum(xBountyInfo);
/* 374 */     if (num <= 0)
/*     */     {
/* 376 */       return 0;
/*     */     }
/* 378 */     int itemId = BountyConsts.getInstance().FLUSH_ITEM_ID;
/*     */     
/* 380 */     if (useYuan ? rmItemWithYuan(userId, roleId, cCurYuan, cNeedYuan, num, itemId) : rmItemWithoutYuan(roleId, num, itemId))
/*     */     {
/* 382 */       return num;
/*     */     }
/*     */     
/* 385 */     return -1;
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
/*     */ 
/*     */ 
/*     */   private static boolean rmItemWithoutYuan(long roleId, int num, int itemId)
/*     */   {
/* 400 */     int numInbag = ItemInterface.getItemNumberById(roleId, itemId);
/* 401 */     if (numInbag < num)
/*     */     {
/* 403 */       GameServer.logger().error(String.format("[bounty]BountyManager.rmItemWithoutYuan@ item not enough!|roleId=%d|num=%d|numInbag=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(num), Integer.valueOf(numInbag) }));
/*     */       
/*     */ 
/* 406 */       return false;
/*     */     }
/* 408 */     if (!ItemInterface.removeItemById(roleId, 340600000, itemId, num, new TLogArg(LogReason.BOUNTY_FLUSH_REM)))
/*     */     {
/* 410 */       GameServer.logger().error(String.format("[bounty]BountyManager.rmItemWithoutYuan@ rm item err!|roleId=%d|num=%d|itemId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(num), Integer.valueOf(itemId) }));
/*     */       
/*     */ 
/* 413 */       return false;
/*     */     }
/* 415 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean rmItemWithYuan(String userId, long roleId, long cCurYuan, long cNeedYuan, int num, int itemId)
/*     */   {
/* 433 */     long sCurYuan = QingfuInterface.getBalance(userId, true);
/* 434 */     if (sCurYuan != cCurYuan)
/*     */     {
/* 436 */       GameServer.logger().error(String.format("[bounty]BountyManager.rmItemWithYuan@ S-C cur yuanbao num not same!|roleId=%d|sCurYuan=%d|cCurYuan=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(sCurYuan), Long.valueOf(cCurYuan) }));
/*     */       
/*     */ 
/*     */ 
/* 440 */       return false;
/*     */     }
/* 442 */     Map<Integer, Integer> itemId2num = new HashMap();
/* 443 */     itemId2num.put(Integer.valueOf(itemId), Integer.valueOf(num));
/* 444 */     boolean ret = ItemInterface.removeItemsWithCutYuanbao(userId, roleId, CostType.COST_BIND_FIRST_REFRESH_BOUNTY, itemId2num, (int)cNeedYuan, new TLogArg(LogReason.BOUNTY_FLUSH_REM));
/*     */     
/* 446 */     if (!ret)
/*     */     {
/* 448 */       GameServer.logger().error(String.format("[bounty]BountyManager.rmItemWithYuan@ removeItemsWithCutYuanbao err!|roleId=%d|itemId2num=%s|cNeedYuan=%d", new Object[] { Long.valueOf(roleId), itemId2num.toString(), Long.valueOf(cNeedYuan) }));
/*     */       
/*     */ 
/*     */ 
/* 452 */       return false;
/*     */     }
/* 454 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getNeedBirdNum(BountyInfo xBountyInfo)
/*     */   {
/* 465 */     int num = 0;
/* 466 */     for (xbean.BTaskInfo xBTaskInfo : xBountyInfo.getTaskinfos().values())
/*     */     {
/* 468 */       if (xBTaskInfo.getTaskstate() == 0)
/*     */       {
/* 470 */         num++;
/*     */       }
/*     */     }
/* 473 */     int needNum = num - 1;
/* 474 */     if (needNum > 0)
/*     */     {
/* 476 */       num = needNum;
/*     */     }
/*     */     else
/*     */     {
/* 480 */       num = 0;
/*     */     }
/* 482 */     return num;
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
/*     */   static void synBountyInfo(long roleId, BountyInfo xBountyInfo)
/*     */   {
/* 495 */     SSynBountyInfo pro = new SSynBountyInfo();
/* 496 */     pro.bountycount = xBountyInfo.getBountycount();
/* 497 */     Iterator<Map.Entry<Integer, xbean.BTaskInfo>> it = xBountyInfo.getTaskinfos().entrySet().iterator();
/* 498 */     while (it.hasNext())
/*     */     {
/* 500 */       Map.Entry<Integer, xbean.BTaskInfo> btaskInfo = (Map.Entry)it.next();
/* 501 */       xbean.BTaskInfo xBTaskInfo = (xbean.BTaskInfo)btaskInfo.getValue();
/* 502 */       mzm.gsp.bounty.BTaskInfo pBTaskInfo = new mzm.gsp.bounty.BTaskInfo();
/* 503 */       pBTaskInfo.taskid = xBTaskInfo.getTaskid();
/* 504 */       pBTaskInfo.taskstate = xBTaskInfo.getTaskstate();
/* 505 */       pro.taskinfos.put(btaskInfo.getKey(), pBTaskInfo);
/*     */     }
/* 507 */     OnlineManager.getInstance().send(roleId, pro);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean tryGetTask(long roleId, int graphId, int taskId)
/*     */   {
/* 523 */     TaskInterface.acceptGraphXTask(roleId, graphId, taskId);
/* 524 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isHaveBGraph(long roleId)
/*     */   {
/* 536 */     List<Integer> graphIds = TaskInterface.getRoleAllGraphIds(roleId, false);
/* 537 */     for (Iterator i$ = getGraphIds().iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 539 */       if (graphIds.contains(Integer.valueOf(graphId)))
/*     */       {
/* 541 */         return true;
/*     */       }
/*     */     }
/* 544 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean hasMoreThanXBGraph(long roleId, int count)
/*     */   {
/* 560 */     List<Integer> graphIds = TaskInterface.getRoleAllGraphIds(roleId, false);
/* 561 */     int num = 0;
/* 562 */     for (Iterator i$ = getGraphIds().iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 564 */       if (graphIds.contains(Integer.valueOf(graphId)))
/*     */       {
/* 566 */         num++;
/*     */       }
/*     */     }
/* 569 */     return num > count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBGraph(int graphId)
/*     */   {
/* 581 */     return graphIds.contains(Integer.valueOf(graphId));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCanGiveUp(long roleId, int graphId, int taskId)
/*     */   {
/* 598 */     int state = TaskInterface.getTaskState(roleId, graphId, taskId);
/* 599 */     if (state == 2)
/*     */     {
/* 601 */       return true;
/*     */     }
/* 603 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getFinishTaskNum(BountyInfo xBountyInfo)
/*     */   {
/* 615 */     int num = 0;
/* 616 */     for (xbean.BTaskInfo info : xBountyInfo.getTaskinfos().values())
/*     */     {
/* 618 */       if ((info.getTaskstate() == 2) || (info.getTaskstate() == 3))
/*     */       {
/* 620 */         num++;
/*     */       }
/*     */     }
/* 623 */     return num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBountyTaskNum()
/*     */   {
/* 633 */     return graphIds.size();
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
/*     */ 
/*     */ 
/*     */   static void changeBTaskState(long roleId, int graphid, xbean.BTaskInfo xBTaskInfo, int state, int count)
/*     */   {
/* 648 */     if (xBTaskInfo == null)
/*     */     {
/* 650 */       return;
/*     */     }
/* 652 */     if (xBTaskInfo.getTaskstate() == state)
/*     */     {
/* 654 */       return;
/*     */     }
/* 656 */     xBTaskInfo.setTaskstate(state);
/*     */     
/* 658 */     SSynBTaskStatus pro = new SSynBTaskStatus();
/* 659 */     pro.graphid = graphid;
/* 660 */     pro.taskid = xBTaskInfo.getTaskid();
/* 661 */     pro.taskstate = state;
/* 662 */     pro.bountycount = count;
/*     */     
/* 664 */     OnlineManager.getInstance().send(roleId, pro);
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
/*     */   static void sendNormalResult(long roleid, int result, String... args)
/*     */   {
/* 677 */     SBountyNormalResult pro = new SBountyNormalResult();
/* 678 */     pro.result = result;
/* 679 */     for (String arg : args)
/*     */     {
/* 681 */       pro.args.add(arg);
/*     */     }
/* 683 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
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
/*     */   static void awardStore(long roleId, int finishCount)
/*     */   {
/* 696 */     int leftNum = BountyConsts.getInstance().DAY_UPPER_LIMIT - finishCount;
/* 697 */     if (leftNum <= 0)
/*     */     {
/* 699 */       return;
/*     */     }
/* 701 */     AwardReason reason = new AwardReason(LogReason.BOUNTY_CHECK_AWARD_CONTENT);
/* 702 */     reason.setJustQuery(true);
/* 703 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(BountyConsts.getInstance().BASE_AWARD_ID, roleId, -1, reason);
/* 704 */     if (awardModel == null)
/*     */     {
/* 706 */       return;
/*     */     }
/* 708 */     int roleExp = awardModel.getRoleExp();
/* 709 */     if (roleExp <= 0)
/*     */     {
/* 711 */       return;
/*     */     }
/* 713 */     int storeExp = roleExp * leftNum * BountyConsts.getInstance().STORE_EXCHANGE_RATE / WAN;
/* 714 */     StorageExpInterface.addStorageExp(roleId, storeExp);
/*     */   }
/*     */   
/*     */ 
/*     */   static int getSingleCircleCanGetStorageExp(long roleId)
/*     */   {
/* 720 */     int roleExp = getOneBountyCanGetExp(roleId);
/* 721 */     return roleExp * BountyConsts.getInstance().DAY_UPPER_LIMIT * BountyConsts.getInstance().STORE_EXCHANGE_RATE / WAN;
/*     */   }
/*     */   
/*     */   static int getOneBountyCanGetStorageExp(long roleId, int ring)
/*     */   {
/* 726 */     if ((ring <= 0) || (ring > BountyConsts.getInstance().DAY_UPPER_LIMIT))
/*     */     {
/* 728 */       return 0;
/*     */     }
/* 730 */     int roleExp = getOneBountyCanGetExp(roleId);
/* 731 */     return roleExp * BountyConsts.getInstance().STORE_EXCHANGE_RATE / WAN;
/*     */   }
/*     */   
/*     */   private static int getOneBountyCanGetExp(long roleId)
/*     */   {
/* 736 */     String userid = RoleInterface.getUserId(roleId);
/* 737 */     if (!ActivityInterface.isInActivityLevel(userid, roleId, getBountyConsts().ACTIVITYID))
/*     */     {
/* 739 */       return 0;
/*     */     }
/* 741 */     AwardReason reason = new AwardReason(LogReason.BOUNTY_CHECK_AWARD_CONTENT);
/* 742 */     reason.setJustQuery(true);
/* 743 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(BountyConsts.getInstance().BASE_AWARD_ID, roleId, -1, reason);
/* 744 */     if (awardModel == null)
/*     */     {
/* 746 */       return 0;
/*     */     }
/* 748 */     int roleExp = awardModel.getRoleExp();
/* 749 */     return roleExp > 0 ? roleExp : 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBountyOpen(long roleId)
/*     */   {
/* 759 */     if (!OpenInterface.getOpenStatus(3))
/*     */     {
/* 761 */       return false;
/*     */     }
/* 763 */     if (OpenInterface.isBanPlay(roleId, 3))
/*     */     {
/* 765 */       OpenInterface.sendBanPlayMsg(roleId, 3);
/* 766 */       return false;
/*     */     }
/* 768 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getTaskRank(int taskId)
/*     */   {
/* 779 */     SBountyTaskCfg cfg = SBountyTaskCfg.get(taskId);
/* 780 */     if (cfg == null)
/*     */     {
/* 782 */       return -1;
/*     */     }
/* 784 */     return cfg.rank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getRankDoneTaskIds(BountyInfo xBountyInfo, int rank)
/*     */   {
/* 796 */     List<Integer> doneTaskIds = new ArrayList();
/* 797 */     if (xBountyInfo == null)
/*     */     {
/* 799 */       return doneTaskIds;
/*     */     }
/* 801 */     BTaskData xBTaskData = (BTaskData)xBountyInfo.getDonetaskinfo().get(Integer.valueOf(rank));
/* 802 */     if (xBTaskData == null)
/*     */     {
/* 804 */       return doneTaskIds;
/*     */     }
/* 806 */     doneTaskIds.addAll(xBTaskData.getTaskids());
/* 807 */     return doneTaskIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRankDoneTaskIdsNum(BountyInfo xBountyInfo, int rank)
/*     */   {
/* 819 */     return getRankDoneTaskIds(xBountyInfo, rank).size();
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
/*     */ 
/*     */ 
/*     */   static boolean needGetSpecialTask(BountyInfo xBountyInfo, int useBirdNum, int freeCount)
/*     */   {
/* 834 */     int preGuarateeCount = xBountyInfo.getPreguaranteecount();
/* 835 */     if (preGuarateeCount >= BountyConsts.getInstance().FRIST_BAO_DI_COUNT)
/*     */     {
/* 837 */       return (freeCount >= BountyConsts.getInstance().FREE_COUNT_MAX) || (useBirdNum >= BountyConsts.getInstance().REFRESH_ITEM_MAX);
/*     */     }
/*     */     
/* 840 */     return (freeCount >= BountyConsts.getInstance().FRIST_FREE_COUNT_MAX) || (useBirdNum >= BountyConsts.getInstance().FRIST_REFRESH_ITEM_MAX);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\BountyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */