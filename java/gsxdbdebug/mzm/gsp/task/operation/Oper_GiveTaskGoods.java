/*    */ package mzm.gsp.task.operation;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.confbean.STaskGoodsCfg;
/*    */ import mzm.gsp.task.confbean.STaskOperGiveTaskGoods;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Oper_GiveTaskGoods
/*    */   extends AbsOperation
/*    */ {
/*    */   public Oper_GiveTaskGoods(int operId, STaskOperGiveTaskGoods sTaskOperGiveTaskGoods, int taskId)
/*    */   {
/* 21 */     super(operId, sTaskOperGiveTaskGoods.operType, sTaskOperGiveTaskGoods.teamType, taskId);
/*    */   }
/*    */   
/*    */   STaskOperGiveTaskGoods getGiveTaskGoods()
/*    */   {
/* 26 */     return STaskOperGiveTaskGoods.get(getOperId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*    */   {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void checkCfg()
/*    */   {
/* 45 */     STaskOperGiveTaskGoods giveTaskGoods = getGiveTaskGoods();
/* 46 */     if (!STaskGoodsCfg.getAll().containsKey(Integer.valueOf(giveTaskGoods.taskGoodsId)))
/*    */     {
/* 48 */       throw new RuntimeException("任务配置的任务物品不存在:taskid:" + getTaskId() + " goodsId:" + giveTaskGoods.taskGoodsId);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_GiveTaskGoods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */