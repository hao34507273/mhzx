/*     */ package mzm.gsp.mourn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity2.confbean.MournConsts;
/*     */ import mzm.gsp.activity2.confbean.SMournCfg;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.XMTaskInfo;
/*     */ import xbean.XMournInfo;
/*     */ import xtable.Role2mourn;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MournActivityInit
/*     */   implements ActivityHandler
/*     */ {
/*     */   public void initData(String userId, long roleId, int turn, int activityid)
/*     */   {
/*  33 */     if (activityid != MournConsts.getInstance().activityId)
/*     */     {
/*  35 */       return;
/*     */     }
/*  37 */     XMournInfo xMournInfo = Role2mourn.get(Long.valueOf(roleId));
/*  38 */     if (xMournInfo == null)
/*     */     {
/*  40 */       xMournInfo = Pod.newXMournInfo();
/*  41 */       xMournInfo.getLastmourndata().setState(1);
/*  42 */       Role2mourn.insert(Long.valueOf(roleId), xMournInfo);
/*     */     }
/*  44 */     Set<Integer> ownIds = getOwnMournIds(roleId, xMournInfo);
/*  45 */     List<Integer> newIds = MournManager.getNewMournIds(ownIds);
/*  46 */     if (newIds.size() + ownIds.size() != MournConsts.getInstance().countMax)
/*     */     {
/*  48 */       GameServer.logger().error(String.format("[mourn]MournActivityInit.initData@ ran num err!|roleId=%d|ownIds=%d|newIds=%d", new Object[] { Long.valueOf(roleId), ownIds, newIds }));
/*     */       
/*     */ 
/*  51 */       return;
/*     */     }
/*  53 */     for (Iterator i$ = newIds.iterator(); i$.hasNext();) { int mournId = ((Integer)i$.next()).intValue();
/*     */       
/*  55 */       XMTaskInfo xmTaskInfo = Pod.newXMTaskInfo();
/*  56 */       xmTaskInfo.setState(1);
/*     */       
/*  58 */       xMournInfo.getMourndatas().put(Integer.valueOf(mournId), xmTaskInfo);
/*     */     }
/*  60 */     xMournInfo.getLastmourndata().setState(1);
/*  61 */     TaskInterface.closeActivityGraphWithoutEvent(roleId, MournConsts.getInstance().questionGraphId);
/*     */     
/*  63 */     List<Integer> sort = new ArrayList();
/*  64 */     Collections.shuffle(newIds);
/*  65 */     sort.addAll(ownIds);
/*  66 */     sort.addAll(newIds);
/*  67 */     xMournInfo.getSort().clear();
/*  68 */     xMournInfo.getSort().addAll(sort);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Set<Integer> getOwnMournIds(long roleId, XMournInfo xMournInfo)
/*     */   {
/*  80 */     Set<Integer> ownIds = new HashSet();
/*  81 */     Iterator<Map.Entry<Integer, XMTaskInfo>> it = xMournInfo.getMourndatas().entrySet().iterator();
/*  82 */     while (it.hasNext())
/*     */     {
/*  84 */       Map.Entry<Integer, XMTaskInfo> entry = (Map.Entry)it.next();
/*  85 */       int mournId = ((Integer)entry.getKey()).intValue();
/*  86 */       XMTaskInfo xmTaskInfo = (XMTaskInfo)entry.getValue();
/*  87 */       if (needRemove(roleId, mournId, xmTaskInfo))
/*     */       {
/*  89 */         it.remove();
/*     */       }
/*     */       else
/*  92 */         ownIds.add(Integer.valueOf(mournId));
/*     */     }
/*  94 */     return ownIds;
/*     */   }
/*     */   
/*     */   private boolean needRemove(long roleId, int mournId, XMTaskInfo xmTaskInfo)
/*     */   {
/*  99 */     if (xmTaskInfo.getState() != 2)
/*     */     {
/* 101 */       return true;
/*     */     }
/* 103 */     if (!TaskInterface.isHaveGraphId(roleId, SMournCfg.get(mournId).graphId))
/*     */     {
/* 105 */       GameServer.logger().error(String.format("[mourn]MournActivityInit.needRemove@ already accept mourn task, but not own graphId! remove it and random another one!|roleId=%d|mournId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(mournId) }));
/*     */       
/*     */ 
/*     */ 
/* 109 */       return true;
/*     */     }
/* 111 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/* 117 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/* 123 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/* 129 */     if (activityid == MournConsts.getInstance().activityId)
/*     */     {
/* 131 */       ControllerInterface.triggerController(MournConsts.getInstance().controller);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 144 */     if (activityid == MournConsts.getInstance().activityId)
/*     */     {
/* 146 */       ControllerInterface.collectController(MournConsts.getInstance().controller);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\main\MournActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */