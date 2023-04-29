/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.task.conParamObj.GatherItemParamObj;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskCongatherItem;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Con_GatherItem_14
/*     */   extends AbsCondition
/*     */ {
/*  19 */   private static final Logger logger = Logger.getLogger(Con_GatherItem_14.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Con_GatherItem_14(int conId, int conType, int sTaskId)
/*     */   {
/*  31 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */   STaskCongatherItem getSCongatherItem()
/*     */   {
/*  36 */     return STaskCongatherItem.get(getConId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  45 */     STaskCongatherItem congatherItem = getSCongatherItem();
/*  46 */     if (conMap != null)
/*     */     {
/*  48 */       ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/*  49 */       if (conBean == null)
/*     */       {
/*  51 */         conBean = Pod.newConBean();
/*  52 */         conBean.setType(getType());
/*  53 */         conMap.put(Integer.valueOf(getConId()), conBean);
/*     */       }
/*  55 */       long count = 0L;
/*  56 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_GATHER_ITEM_COUNT.getParamType())))
/*     */       {
/*  58 */         count = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_GATHER_ITEM_COUNT.getParamType()))).longValue();
/*     */       }
/*  60 */       if (count >= congatherItem.gatherCount)
/*     */       {
/*  62 */         return true;
/*     */       }
/*     */       
/*  65 */       Object obj = params.get(Integer.valueOf(getType()));
/*  66 */       if (obj == null)
/*     */       {
/*  68 */         conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_GATHER_ITEM_COUNT.getParamType()), Long.valueOf(count));
/*     */         
/*  70 */         if (getConType() == 2)
/*     */         {
/*  72 */           RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */         }
/*  74 */         return false;
/*     */       }
/*  76 */       if ((obj instanceof GatherItemParamObj))
/*     */       {
/*  78 */         GatherItemParamObj gatherItemParamObj = (GatherItemParamObj)obj;
/*  79 */         if (gatherItemParamObj.getGatherId() == congatherItem.gatherId)
/*     */         {
/*  81 */           count += gatherItemParamObj.getGatherCount();
/*  82 */           count = Math.min(count, congatherItem.gatherCount);
/*  83 */           conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_GATHER_ITEM_COUNT.getParamType()), Long.valueOf(count));
/*  84 */           if (count >= congatherItem.gatherCount)
/*     */           {
/*  86 */             return true;
/*     */           }
/*     */           
/*  89 */           if (getConType() == 2)
/*     */           {
/*  91 */             RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  97 */         logger.error("胜利次数传递的对象不是" + GatherItemParamObj.class.getName());
/*  98 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 103 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 109 */     return 14;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 115 */     if (!MapInterface.isMapItemExist(getSCongatherItem().gatherId)) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*     */   {
/* 124 */     return false;
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
/* 135 */     ConParam p = new ConParam();
/* 136 */     if (xConBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_GATHER_ITEM_COUNT.getParamType())))
/*     */     {
/* 138 */       p.setParam(((Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_GATHER_ITEM_COUNT.getParamType()))).longValue());
/*     */     }
/* 140 */     return p;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_GatherItem_14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */