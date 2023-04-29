/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskContimeLimit;
/*     */ import mzm.gsp.task.main.RoleTask;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import mzm.gsp.task.main.TaskTimeLimitSession;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ import xbean.TaskBean;
/*     */ 
/*     */ public class Con_TimeLimit_12 extends AbsCondition
/*     */ {
/*     */   public Con_TimeLimit_12(int conId, int conType, int sTaskId)
/*     */   {
/*  23 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */   STaskContimeLimit getContimeLimit()
/*     */   {
/*  28 */     return STaskContimeLimit.get(getConId());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  34 */     STaskContimeLimit contimeLimit = getContimeLimit();
/*  35 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, true);
/*  36 */     TaskBean taskBean = roleTask.getTaskBean(graphId, getSTask().id);
/*  37 */     if (taskBean == null)
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     ConBean conBean = (ConBean)conMap.get(Integer.valueOf(contimeLimit.id));
/*  42 */     if ((conBean == null) || (!conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType()))))
/*     */     {
/*     */ 
/*     */ 
/*  46 */       new CheckTimeLimitProcedure(roleId, graphId).execute();
/*  47 */       return false;
/*     */     }
/*  49 */     Long leftTime = (Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType()));
/*  50 */     int timeEndType = getContimeLimit().timeOutHandleTask;
/*  51 */     if (leftTime.longValue() > 0L)
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     if (timeEndType == 1)
/*     */     {
/*  57 */       return true;
/*     */     }
/*  59 */     if (timeEndType == 2)
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     GameServer.logger().error(String.format("[task]Con_TimeLimit_12.isComplete@ unsupport type!|roleId=%d|graphId=%d|taskId=%d|conId=%d|type=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(getTaskId()), Integer.valueOf(contimeLimit.id), Integer.valueOf(timeEndType) }));
/*     */     
/*     */ 
/*     */ 
/*  67 */     return false;
/*     */   }
/*     */   
/*     */   private long getEndTime(ConBean xConBean)
/*     */   {
/*  72 */     if (xConBean == null)
/*     */     {
/*  74 */       return -1L;
/*     */     }
/*  76 */     Long leftTime = (Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType()));
/*  77 */     Long startTime = (Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_START_TIME.getParamType()));
/*  78 */     if ((leftTime == null) || (startTime == null))
/*     */     {
/*  80 */       GameServer.logger().error(String.format("[task]Con_TimeLimit_12.isComplete@ leftTime == null或startTime == null!|leftTime=%s|startTime=%s", new Object[] { leftTime, startTime }));
/*     */       
/*     */ 
/*     */ 
/*  84 */       return -1L;
/*     */     }
/*  86 */     if ((leftTime.longValue() <= 0L) || (startTime.longValue() <= 0L))
/*     */     {
/*  88 */       return -1L;
/*     */     }
/*  90 */     long endSec = TimeUnit.MILLISECONDS.toSeconds(startTime.longValue() + leftTime.longValue());
/*  91 */     return endSec;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/*  97 */     return 12;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void checkCfg() {}
/*     */   
/*     */ 
/*     */   private final class CheckTimeLimitProcedure
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int graphId;
/*     */     
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */     public CheckTimeLimitProcedure(long roleId, int graphId)
/*     */     {
/* 115 */       this.roleId = roleId;
/* 116 */       this.graphId = graphId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 122 */       STaskContimeLimit contimeLimit = Con_TimeLimit_12.this.getContimeLimit();
/* 123 */       RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, true);
/* 124 */       TaskBean taskBean = roleTask.getTaskBean(this.graphId, Con_TimeLimit_12.this.getSTask().id);
/* 125 */       if (taskBean == null)
/*     */       {
/* 127 */         return false;
/*     */       }
/* 129 */       if (taskBean.getTaskstate() != 2)
/*     */       {
/* 131 */         return false;
/*     */       }
/* 133 */       ConBean conBean = (ConBean)taskBean.getConmap().get(Integer.valueOf(contimeLimit.id));
/* 134 */       if (conBean == null)
/*     */       {
/* 136 */         conBean = Pod.newConBean();
/* 137 */         taskBean.getConmap().put(Integer.valueOf(contimeLimit.id), conBean);
/*     */       }
/* 139 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType())))
/*     */       {
/* 141 */         return false;
/*     */       }
/* 143 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 144 */       long leftTime = TimeUnit.SECONDS.toMillis(contimeLimit.timeLimit);
/* 145 */       Session session = new TaskTimeLimitSession(contimeLimit.timeLimit, this.roleId, this.graphId, Con_TimeLimit_12.this.getSTask().id, contimeLimit);
/*     */       
/* 147 */       conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType()), Long.valueOf(leftTime));
/* 148 */       conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_END_SESSIONID.getParamType()), Long.valueOf(session.getSessionId()));
/* 149 */       conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_START_TIME.getParamType()), Long.valueOf(curTime));
/*     */       
/* 151 */       long endSec = TimeUnit.MILLISECONDS.toSeconds(curTime + leftTime);
/* 152 */       RoleTaskManager.sendConChangeMsg(this.roleId, this.graphId, Con_TimeLimit_12.this.getSTask().id, contimeLimit.id, endSec);
/*     */       
/* 154 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 156 */         GameServer.logger().debug(String.format("[task]CheckTimeLimitProcedure.processImp@ new time limit task info:|roleId=%d|graphId=%d|taskId=%d|conId=%d|leftTime=%d|curTime=%s|endTime=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.graphId), Integer.valueOf(Con_TimeLimit_12.this.getSTask().id), Integer.valueOf(contimeLimit.id), Long.valueOf(leftTime), DateTimeUtils.formatTimestamp(curTime), DateTimeUtils.formatTimestamp(TimeUnit.SECONDS.toMillis(endSec)) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*     */   {
/* 172 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ConParam getSendParam(ConBean xConBean)
/*     */   {
/* 184 */     ConParam p = new ConParam();
/* 185 */     if (xConBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType())))
/*     */     {
/* 187 */       p.setParam(getEndTime(xConBean));
/*     */     }
/* 189 */     return p;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_TimeLimit_12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */