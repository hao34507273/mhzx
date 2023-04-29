/*     */ package mzm.gsp.task.operation;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.itembulletin.main.ItemBulletinInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.ban.BanGraphInterface;
/*     */ import mzm.gsp.task.confbean.STaskOpergiveAward;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Oper_GiveAward
/*     */   extends AbsOperation
/*     */ {
/*     */   public Oper_GiveAward(int operId, STaskOpergiveAward giveAward, int taskId)
/*     */   {
/*  37 */     super(operId, giveAward.operType, giveAward.teamType, taskId);
/*     */   }
/*     */   
/*     */   STaskOpergiveAward getSTaskOpergiveAward()
/*     */   {
/*  42 */     return STaskOpergiveAward.get(getOperId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*     */   {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*     */   {
/*  55 */     STaskOpergiveAward giveAward = getSTaskOpergiveAward();
/*  56 */     List<Long> allRoleIds = new ArrayList();
/*  57 */     AwardModel awardModel = null;
/*  58 */     if (!allRoleIds.contains(Long.valueOf(roleId)))
/*     */     {
/*  60 */       allRoleIds.add(Long.valueOf(roleId));
/*     */     }
/*  62 */     if (BanGraphInterface.isGraphBan(graphId, 1))
/*     */     {
/*     */ 
/*  65 */       GameServer.logger().info(String.format("[task]Oper_GiveAward.execute@ award is baned!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(super.getTaskId()) }));
/*     */       
/*     */ 
/*  68 */       RoleTaskManager.sendTaskNotice(Arrays.asList(new Long[] { Long.valueOf(roleId) }), false, 6, new String[0]);
/*  69 */       return true;
/*     */     }
/*  71 */     AwardReason awardReason = new AwardReason(LogReason.TASK_OPER_ADD, getTaskId());
/*  72 */     awardModel = AwardInterface.award(giveAward.rewardId, RoleInterface.getUserId(roleId), roleId, -1, allRoleIds, allRoleIds, false, true, awardReason);
/*     */     
/*  74 */     if (awardModel == null)
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[task]Oper_GiveAward.execute@give award error!|roleId=%d|graphId=%d|taskId=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(getTaskId()), Integer.valueOf(giveAward.rewardId) }));
/*     */       
/*     */ 
/*  79 */       return false;
/*     */     }
/*  81 */     bulltin(awardModel, roleId, graphId);
/*  82 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/*  88 */     STaskOpergiveAward giveAward = getSTaskOpergiveAward();
/*  89 */     if (!AwardInterface.hasAwardId(giveAward.rewardId))
/*     */     {
/*  91 */       throw new RuntimeException("任务配置的奖励id不存在：taskID:" + getTaskId());
/*     */     }
/*     */   }
/*     */   
/*     */   void bulltin(AwardModel awardModel, long roleId, int graphId)
/*     */   {
/*  97 */     GetTaskAwardHandler handler = (GetTaskAwardHandler)ownAwardHandlers.get(Integer.valueOf(graphId));
/*  98 */     if (handler == null)
/*     */     {
/* 100 */       return;
/*     */     }
/* 102 */     Map<Integer, Integer> itemMap = awardModel.getItemMap();
/* 103 */     if ((itemMap == null) || (itemMap.size() == 0))
/*     */     {
/* 105 */       return;
/*     */     }
/* 107 */     Map<Integer, Integer> treasureItemMap = new HashMap();
/* 108 */     fillTreasure(itemMap, treasureItemMap);
/* 109 */     if (treasureItemMap.size() == 0)
/*     */     {
/* 111 */       return;
/*     */     }
/* 113 */     handler.bulletinTreasure(roleId, graphId, getTaskId(), treasureItemMap);
/*     */   }
/*     */   
/*     */   private void fillTreasure(Map<Integer, Integer> itemMap, Map<Integer, Integer> treasureItemMap)
/*     */   {
/* 118 */     Iterator<Map.Entry<Integer, Integer>> it = itemMap.entrySet().iterator();
/* 119 */     while (it.hasNext())
/*     */     {
/* 121 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 122 */       int itemId = ((Integer)entry.getKey()).intValue();
/* 123 */       if (ItemBulletinInterface.needBulletin(itemId))
/*     */       {
/*     */ 
/*     */ 
/* 127 */         treasureItemMap.put(Integer.valueOf(itemId), entry.getValue());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 134 */   private static Map<Integer, GetTaskAwardHandler> ownAwardHandlers = new ConcurrentHashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerOwnAwardImpl(int graphId, GetTaskAwardHandler ownAwardHandler)
/*     */   {
/* 145 */     if (ownAwardHandlers.containsKey(Integer.valueOf(graphId)))
/*     */     {
/* 147 */       GameServer.logger().error("[task]任务奖励检查类已经被注册了，graphId = " + graphId + "；" + ownAwardHandler.getClass().getName());
/*     */     }
/* 149 */     ownAwardHandlers.put(Integer.valueOf(graphId), ownAwardHandler);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_GiveAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */