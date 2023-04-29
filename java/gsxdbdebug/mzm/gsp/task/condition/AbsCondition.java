/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import xbean.ConBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbsCondition
/*     */ {
/*     */   private int conId;
/*     */   private int conType;
/*     */   private int sTaskId;
/*     */   
/*     */   public AbsCondition(int conId, int conType, int sTaskId)
/*     */   {
/*  20 */     this.conId = conId;
/*  21 */     this.conType = conType;
/*  22 */     this.sTaskId = sTaskId;
/*     */   }
/*     */   
/*     */   public int getConId()
/*     */   {
/*  27 */     return this.conId;
/*     */   }
/*     */   
/*     */   public int getConType()
/*     */   {
/*  32 */     return this.conType;
/*     */   }
/*     */   
/*     */   public STask getSTask()
/*     */   {
/*  37 */     return STask.get(this.sTaskId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract boolean isComplete(long paramLong, Map<Integer, ConBean> paramMap, Map<Integer, Object> paramMap1, int paramInt);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract int getType();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void checkCfg();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*     */   {
/*  74 */     return true;
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
/*  85 */     ConParam p = new ConParam();
/*  86 */     Long param = (Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_BAG.getParamType()));
/*  87 */     if (param == null)
/*     */     {
/*  89 */       return p;
/*     */     }
/*  91 */     p.setParam(param.longValue());
/*  92 */     return p;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void asynSendConParam(long roleId, int graphId, ConBean xConBean) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTaskId()
/*     */   {
/* 107 */     return this.sTaskId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\AbsCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */