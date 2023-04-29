/*    */ package mzm.gsp.circletask.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ public class PGMAddCircleTaskItem
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PGMAddCircleTaskItem(long roleId)
/*    */   {
/* 21 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     int taskId = TaskInterface.findTaskInGraph(this.roleId, CircleTaskConsts.getInstance().TASK_GRAPHIC_ID);
/* 27 */     if (taskId == 0) {
/* 28 */       return false;
/*    */     }
/* 30 */     List<Integer> itemIdList = TaskInterface.getTaskNeedItem(this.roleId, CircleTaskConsts.getInstance().TASK_GRAPHIC_ID, taskId);
/* 31 */     if (itemIdList.isEmpty()) {
/* 32 */       return false;
/*    */     }
/* 34 */     int id = ((Integer)itemIdList.get(Xdb.random().nextInt(itemIdList.size()))).intValue();
/* 35 */     ItemInterface.addItem(this.roleId, id, 1, new TLogArg(LogReason.GM_ADD, id));
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\PGMAddCircleTaskItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */