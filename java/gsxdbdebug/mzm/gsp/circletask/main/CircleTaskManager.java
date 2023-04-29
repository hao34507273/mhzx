/*     */ package mzm.gsp.circletask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.SCircleTaskNormalResult;
/*     */ import mzm.gsp.activity.SSyncLegendTime;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*     */ import mzm.gsp.circletask.confbean.SCircleTaskCostConf;
/*     */ import mzm.gsp.circletask.confbean.SCircleTaskLengendDropCfg;
/*     */ import mzm.gsp.circletask.confbean.SCircleTaskModify;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import xbean.CircleTask;
/*     */ import xtable.Role2circletask;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CircleTaskManager
/*     */ {
/*  28 */   private static CircleTaskManager instance = new CircleTaskManager();
/*  29 */   private Map<Integer, Integer> costCfgMap = new HashMap();
/*     */   
/*  31 */   private Map<Integer, Integer> circleModify = new HashMap();
/*     */   
/*  33 */   private Map<Integer, Integer> replaceSamePriceIdMap = new HashMap();
/*     */   
/*  35 */   private static AtomicBoolean isopen = new AtomicBoolean(true);
/*     */   
/*     */   static final int ASK_FOR_HELP = 1;
/*     */   
/*     */   static final int HELP_OTHER = 2;
/*     */   
/*     */   public static CircleTaskManager getInstance()
/*     */   {
/*  43 */     return instance;
/*     */   }
/*     */   
/*     */   public void init()
/*     */     throws Exception
/*     */   {
/*  49 */     ActivityInterface.registerActivityByLogicType(6, new CircleTaskActivityInit());
/*  50 */     ItemAccessManager.registerActivityReward(CircleTaskConsts.getInstance().TASK_ACTIVITY_ID, CircleTaskConsts.getInstance().AWARD_TYPE_ID);
/*     */     
/*  52 */     for (SCircleTaskCostConf conf : SCircleTaskCostConf.getAll().values())
/*     */     {
/*  54 */       this.costCfgMap.put(Integer.valueOf(conf.renXingCount), Integer.valueOf(conf.id));
/*     */     }
/*  56 */     for (SCircleTaskModify sCircleTaskModify : SCircleTaskModify.getAll().values())
/*     */     {
/*  58 */       this.circleModify.put(Integer.valueOf(sCircleTaskModify.circleCount), Integer.valueOf(sCircleTaskModify.modifyTableId));
/*     */     }
/*  60 */     for (SCircleTaskLengendDropCfg cfg : SCircleTaskLengendDropCfg.getAll().values())
/*     */     {
/*  62 */       this.replaceSamePriceIdMap.put(Integer.valueOf(cfg.finishNeedSamePriceId), Integer.valueOf(cfg.dropNeedSamePriceId));
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRenXingByCount(int count)
/*     */   {
/*  68 */     return (Integer)this.costCfgMap.get(Integer.valueOf(count));
/*     */   }
/*     */   
/*     */   public Integer getModify(int taskNo)
/*     */   {
/*  73 */     return (Integer)this.circleModify.get(Integer.valueOf(taskNo));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void postInit() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onEndCircleTask(long roleId)
/*     */   {
/*  87 */     CircleTask xCircleTask = Role2circletask.get(Long.valueOf(roleId));
/*     */     
/*  89 */     xCircleTask.setLegendendtime(0L);
/*  90 */     xCircleTask.setTaskid(0);
/*     */   }
/*     */   
/*     */   int getSamePriceReplaceId(int id)
/*     */   {
/*  95 */     Integer repId = (Integer)this.replaceSamePriceIdMap.get(Integer.valueOf(id));
/*  96 */     if (repId == null)
/*  97 */       return id;
/*  98 */     return repId.intValue();
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
/*     */   static void tlogAskCircleTaskHelp(long roleId, int taskid)
/*     */   {
/* 113 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 114 */     String userid = RoleInterface.getUserId(roleId);
/* 115 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*     */ 
/* 118 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%s|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(taskid), Integer.valueOf(1), Integer.valueOf(taskid), "", Integer.valueOf(0) });
/*     */     
/* 120 */     TLogManager.getInstance().addLog(userid, "CircleTaskhelp", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static void logAskCircleTaskHelp(long roleId, int taskid)
/*     */   {
/* 126 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 127 */     String userid = RoleInterface.getUserId(roleId);
/* 128 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*     */ 
/* 131 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%s|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(taskid), Integer.valueOf(1), Integer.valueOf(taskid), "", Integer.valueOf(0) });
/*     */     
/* 133 */     LogManager.getInstance().addLog("circleTaskhelp", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static void setShilianOpenState(boolean value)
/*     */   {
/* 139 */     isopen.set(value);
/*     */   }
/*     */   
/*     */   static boolean isShilianOpen()
/*     */   {
/* 144 */     return isopen.get();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synLegendTime(long roleId, long endTime, int taskId)
/*     */   {
/* 156 */     if (taskId <= 0)
/*     */     {
/* 158 */       return;
/*     */     }
/* 160 */     SSyncLegendTime pro = new SSyncLegendTime();
/* 161 */     pro.endtime = endTime;
/* 162 */     pro.taskid = taskId;
/* 163 */     pro.graphid = CircleTaskConsts.getInstance().TASK_GRAPHIC_ID;
/* 164 */     OnlineManager.getInstance().send(roleId, pro);
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
/*     */   static void sendCircleNotice(long roleId, boolean afterSuc, int result, String... args)
/*     */   {
/* 177 */     SCircleTaskNormalResult pro = new SCircleTaskNormalResult();
/* 178 */     pro.result = result;
/* 179 */     for (String arg : args)
/*     */     {
/* 181 */       pro.args.add(arg);
/*     */     }
/* 183 */     if (afterSuc)
/*     */     {
/* 185 */       OnlineManager.getInstance().send(roleId, pro);
/*     */     }
/*     */     else
/*     */     {
/* 189 */       OnlineManager.getInstance().sendAtOnce(roleId, pro);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\CircleTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */