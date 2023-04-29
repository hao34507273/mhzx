/*    */ package mzm.gsp.task.operation;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.task.confbean.STaskOperCloseControler;
/*    */ 
/*    */ public class Oper_CloseControler extends AbsOperation
/*    */ {
/*    */   public Oper_CloseControler(int operId, STaskOperCloseControler sTaskOperCloseControler, int taskId)
/*    */   {
/* 12 */     super(operId, sTaskOperCloseControler.operType, sTaskOperCloseControler.teamType, taskId);
/*    */   }
/*    */   
/*    */   STaskOperCloseControler getSTaskOperCloseControler()
/*    */   {
/* 17 */     return STaskOperCloseControler.get(getOperId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*    */   {
/* 29 */     STaskOperCloseControler sTaskOperCloseControler = getSTaskOperCloseControler();
/* 30 */     for (Iterator i$ = sTaskOperCloseControler.controlerIds.iterator(); i$.hasNext();) { int controllerId = ((Integer)i$.next()).intValue();
/*    */       
/* 32 */       mzm.gsp.map.main.ControllerInterface.collectController(roleId, controllerId);
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_CloseControler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */