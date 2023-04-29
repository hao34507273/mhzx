/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.task.conParamObj.ActivityFinishParamObj;
/*     */ import mzm.gsp.task.confbean.SActivityFinishCount;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Con_ActivityFinishCount_17
/*     */   extends AbsCondition
/*     */ {
/*     */   public SActivityFinishCount getConActivity()
/*     */   {
/*  25 */     return SActivityFinishCount.get(getConId());
/*     */   }
/*     */   
/*     */   public Con_ActivityFinishCount_17(int conId, int conType, int sTaskId)
/*     */   {
/*  30 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  36 */     if (conMap != null)
/*     */     {
/*  38 */       ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/*  39 */       if (conBean == null)
/*     */       {
/*  41 */         conBean = Pod.newConBean();
/*  42 */         conBean.setType(getType());
/*  43 */         conMap.put(Integer.valueOf(getConId()), conBean);
/*     */       }
/*  45 */       long count = 0L;
/*  46 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_COUNT.getParamType())))
/*     */       {
/*  48 */         count = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_COUNT.getParamType()))).longValue();
/*     */       }
/*  50 */       if (count >= getNeedFinishCount())
/*     */       {
/*  52 */         return true;
/*     */       }
/*     */       
/*  55 */       Object obj = params.get(Integer.valueOf(getType()));
/*  56 */       if (obj == null)
/*     */       {
/*  58 */         conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_COUNT.getParamType()), Long.valueOf(count));
/*     */         
/*  60 */         if (getConType() == 2)
/*     */         {
/*  62 */           RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */         }
/*  64 */         return false;
/*     */       }
/*  66 */       if ((obj instanceof ActivityFinishParamObj))
/*     */       {
/*  68 */         ActivityFinishParamObj activityFinishParamObj = (ActivityFinishParamObj)obj;
/*  69 */         if (isNeedGraphId(activityFinishParamObj.getGraphId()))
/*     */         {
/*  71 */           count += activityFinishParamObj.getFinishCount();
/*  72 */           count = Math.min(count, getNeedFinishCount());
/*  73 */           conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_COUNT.getParamType()), Long.valueOf(count));
/*     */           
/*  75 */           if (getConType() == 2)
/*     */           {
/*  77 */             RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */           }
/*  79 */           if (count >= getNeedFinishCount())
/*     */           {
/*  81 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  87 */         GameServer.logger().error("活动完成次数传递的对象不是" + ActivityFinishParamObj.class.getName());
/*  88 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  93 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getNeedFinishCount()
/*     */   {
/* 103 */     return getConActivity().circleCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isNeedGraphId(int graphId)
/*     */   {
/* 113 */     return getConActivity().graphIds.contains(Integer.valueOf(graphId));
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 119 */     return 17;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 126 */     for (Iterator i$ = getConActivity().graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 128 */       if (!TaskInterface.isHaveGraphId(graphId))
/*     */       {
/*     */ 
/*     */ 
/* 132 */         throw new RuntimeException("任务图任务完成次数条件，配置的任务图不存在，任务id=" + getSTask().id + "；任务图id=" + graphId); }
/*     */     }
/* 134 */     if (getConActivity().circleCount < 0)
/*     */     {
/* 136 */       throw new RuntimeException("任务图任务完成次数条件，配置的完成次数小于0，任务id=" + getSTask().id);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ConParam getSendParam(ConBean xConBean)
/*     */   {
/* 148 */     ConParam p = new ConParam();
/* 149 */     if (xConBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_COUNT.getParamType())))
/*     */     {
/* 151 */       p.setParam(((Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_COUNT.getParamType()))).longValue());
/*     */     }
/* 153 */     return p;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_ActivityFinishCount_17.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */