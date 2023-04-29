/*    */ package mzm.gsp.task.condition;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.task.conParamObj.UseTaskGoodsObj;
/*    */ import mzm.gsp.task.confbean.STaskConUseTaskGoods;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ConBean;
/*    */ import xbean.Pod;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Con_UseTaskGoods_15
/*    */   extends AbsCondition
/*    */ {
/* 16 */   private static final Logger logger = Logger.getLogger(Con_UseTaskGoods_15.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Con_UseTaskGoods_15(int conId, int conType, int sTaskId)
/*    */   {
/* 28 */     super(conId, conType, sTaskId);
/*    */   }
/*    */   
/*    */   STaskConUseTaskGoods getConUseTaskGoods()
/*    */   {
/* 33 */     return STaskConUseTaskGoods.get(getConId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*    */   {
/* 39 */     STaskConUseTaskGoods useTaskGoods = getConUseTaskGoods();
/* 40 */     if (conMap != null)
/*    */     {
/* 42 */       ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/* 43 */       if (conBean == null)
/*    */       {
/* 45 */         conBean = Pod.newConBean();
/* 46 */         conBean.setType(getType());
/* 47 */         conMap.put(Integer.valueOf(getConId()), conBean);
/*    */       }
/* 49 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_USE_TASK_GOODS.getParamType())))
/*    */       {
/* 51 */         long storeGoodId = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_USE_TASK_GOODS.getParamType()))).longValue();
/* 52 */         if (storeGoodId == useTaskGoods.taskGoodsId)
/*    */         {
/* 54 */           return true;
/*    */         }
/*    */       }
/* 57 */       Object obj = params.get(Integer.valueOf(getType()));
/* 58 */       if (obj == null)
/*    */       {
/* 60 */         return false;
/*    */       }
/* 62 */       if ((obj instanceof UseTaskGoodsObj))
/*    */       {
/* 64 */         UseTaskGoodsObj useTaskGoodsObj = (UseTaskGoodsObj)obj;
/* 65 */         if (useTaskGoodsObj.getTaskGoodsId() == useTaskGoods.taskGoodsId)
/*    */         {
/* 67 */           conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_USE_TASK_GOODS.getParamType()), Long.valueOf(useTaskGoods.taskGoodsId));
/* 68 */           return true;
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 73 */         logger.error("使用任务物品中传递的obj不是" + UseTaskGoodsObj.class.getName()); }
/* 74 */       return false;
/*    */     }
/*    */     
/* 77 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 83 */     return 15;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void checkCfg() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*    */   {
/* 95 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_UseTaskGoods_15.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */