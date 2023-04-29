/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.task.conParamObj.LeitaiParamObj;
/*     */ import mzm.gsp.task.confbean.SLeiTaiWinCount;
/*     */ import mzm.gsp.task.confbean.STask;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Con_Leitai_16
/*     */   extends AbsCondition
/*     */ {
/*  24 */   private static final Logger logger = Logger.getLogger(Con_Leitai_16.class);
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
/*     */   public Con_Leitai_16(int conId, int conType, int sTaskId)
/*     */   {
/*  41 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */   SLeiTaiWinCount getConLeitai()
/*     */   {
/*  46 */     return SLeiTaiWinCount.get(getConId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  53 */     if (conMap != null)
/*     */     {
/*  55 */       ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/*  56 */       if (conBean == null)
/*     */       {
/*  58 */         conBean = Pod.newConBean();
/*  59 */         conBean.setType(getType());
/*  60 */         conMap.put(Integer.valueOf(getConId()), conBean);
/*     */       }
/*  62 */       long count = 0L;
/*  63 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_LETTAI_WIN_COUNT.getParamType())))
/*     */       {
/*  65 */         count = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_LETTAI_WIN_COUNT.getParamType()))).longValue();
/*     */       }
/*  67 */       if (count >= getNeedWinCount())
/*     */       {
/*  69 */         return true;
/*     */       }
/*     */       
/*  72 */       Object obj = params.get(Integer.valueOf(getType()));
/*  73 */       if (obj == null)
/*     */       {
/*  75 */         conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_LETTAI_WIN_COUNT.getParamType()), Long.valueOf(count));
/*  76 */         if (getConType() == 2)
/*     */         {
/*  78 */           RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */         }
/*  80 */         return false;
/*     */       }
/*  82 */       if ((obj instanceof LeitaiParamObj))
/*     */       {
/*  84 */         LeitaiParamObj leitaiParamObj = (LeitaiParamObj)obj;
/*  85 */         count += leitaiParamObj.getWinCount();
/*  86 */         count = Math.min(count, getNeedWinCount());
/*  87 */         conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_LETTAI_WIN_COUNT.getParamType()), Long.valueOf(count));
/*  88 */         if (getConType() == 2)
/*     */         {
/*  90 */           RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */         }
/*  92 */         if (count >= getNeedWinCount())
/*     */         {
/*  94 */           return true;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  99 */         logger.error("擂台获胜次数次数传递的对象不是" + LeitaiParamObj.class.getName());
/* 100 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 105 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getNeedWinCount()
/*     */   {
/* 115 */     return getConLeitai().winCount;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 121 */     return 16;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 127 */     if (getConLeitai().winCount < 0)
/*     */     {
/* 129 */       throw new RuntimeException("擂台胜利次数条件，配置的完成次数小于0，任务id=" + getSTask().id);
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
/*     */   public ConParam getSendParam(ConBean xConBean)
/*     */   {
/* 142 */     ConParam p = new ConParam();
/* 143 */     if (xConBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_LETTAI_WIN_COUNT.getParamType())))
/*     */     {
/* 145 */       p.setParam(((Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_LETTAI_WIN_COUNT.getParamType()))).longValue());
/*     */     }
/* 147 */     return p;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Leitai_16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */