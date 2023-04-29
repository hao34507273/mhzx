/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.task.conParamObj.QuestionParamObj;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskConFinishQuestion;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Con_Question_19
/*     */   extends AbsCondition
/*     */ {
/*     */   public Con_Question_19(int conId, int conType, int sTaskId)
/*     */   {
/*  24 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> xConMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  30 */     STaskConFinishQuestion cfg = STaskConFinishQuestion.get(getConId());
/*  31 */     if (cfg == null)
/*     */     {
/*  33 */       GameServer.logger().error(String.format("[task]Con_Question_19.isComplete@STaskConFinishQuestion is null!|roleId=%d|graphId=%d|taskId=%d|conId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(getTaskId()), Integer.valueOf(getConId()) }));
/*     */       
/*     */ 
/*     */ 
/*  37 */       return false;
/*     */     }
/*  39 */     ConBean conBean = getConBeanIfAbsent(xConMap);
/*  40 */     if (isDBDataFinished(cfg, conBean))
/*     */     {
/*  42 */       return true;
/*     */     }
/*  44 */     Long rightNum = (Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_QUESTION.getParamType()));
/*  45 */     if (rightNum == null)
/*     */     {
/*  47 */       rightNum = new Long(0L);
/*     */     }
/*  49 */     Object obj = params.get(Integer.valueOf(getType()));
/*  50 */     if (obj == null)
/*     */     {
/*  52 */       conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_QUESTION.getParamType()), rightNum);
/*  53 */       if (cfg.contype == 2)
/*     */       {
/*  55 */         RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), rightNum.longValue());
/*     */       }
/*  57 */       return false;
/*     */     }
/*  59 */     if (!(obj instanceof QuestionParamObj))
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[task]Con_Question_19.isComplete@ obj is not QuestionParamObj!|roleId=%d|graphId=%d|taskId=%d|conId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(getTaskId()), Integer.valueOf(getConId()) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*  67 */     QuestionParamObj qObj = (QuestionParamObj)obj;
/*  68 */     int rightNumThisTurn = qObj.getRightNum(roleId);
/*  69 */     if (rightNumThisTurn <= 0)
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     rightNum = Long.valueOf(rightNum.longValue() + rightNumThisTurn);
/*  74 */     long dbNum = rightNum.longValue() > cfg.needRightNum ? cfg.needRightNum : rightNum.longValue();
/*  75 */     conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_QUESTION.getParamType()), Long.valueOf(dbNum));
/*  76 */     if (dbNum < cfg.needRightNum)
/*     */     {
/*  78 */       RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), dbNum);
/*  79 */       return false;
/*     */     }
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ConBean getConBeanIfAbsent(Map<Integer, ConBean> xConMap)
/*     */   {
/*  92 */     ConBean xConBean = (ConBean)xConMap.get(Integer.valueOf(getConId()));
/*  93 */     if (xConBean == null)
/*     */     {
/*  95 */       xConBean = Pod.newConBean();
/*  96 */       xConBean.setType(getType());
/*  97 */       xConMap.put(Integer.valueOf(getConId()), xConBean);
/*     */     }
/*  99 */     return xConBean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isDBDataFinished(STaskConFinishQuestion cfg, ConBean conBean)
/*     */   {
/* 111 */     Long rightnum = (Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_ACTIVITY_FINISH_QUESTION.getParamType()));
/* 112 */     if (rightnum == null)
/*     */     {
/* 114 */       return false;
/*     */     }
/* 116 */     return rightnum.longValue() >= cfg.needRightNum;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 122 */     return 19;
/*     */   }
/*     */   
/*     */   public void checkCfg() {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Question_19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */