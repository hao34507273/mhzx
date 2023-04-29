/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.event.EventProcedure;
/*    */ import mzm.gsp.map.main.GatherItemEventArg;
/*    */ import mzm.gsp.task.conParamObj.GatherItemParamObj;
/*    */ 
/*    */ 
/*    */ public class POnGatherMine
/*    */   extends EventProcedure<GatherItemEventArg>
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     GatherItemParamObj gatherItemParamObj = new GatherItemParamObj();
/* 15 */     gatherItemParamObj.setGatherId(((GatherItemEventArg)this.arg).gatherItemCfgId);
/* 16 */     gatherItemParamObj.setGatherCount(1);
/* 17 */     TaskInterface.updateTaskCondition(((GatherItemEventArg)this.arg).roleId, 14, gatherItemParamObj);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnGatherMine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */