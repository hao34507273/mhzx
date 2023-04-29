/*    */ package mzm.gsp.task.operation;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.task.confbean.STaskOperControler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Oper_Controler
/*    */   extends AbsOperation
/*    */ {
/*    */   public Oper_Controler(int operId, STaskOperControler sTaskOperControler, int taskId)
/*    */   {
/* 22 */     super(operId, sTaskOperControler.operType, sTaskOperControler.teamType, taskId);
/*    */   }
/*    */   
/*    */   STaskOperControler getSTaskOperControler()
/*    */   {
/* 27 */     return STaskOperControler.get(getOperId());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*    */   {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*    */   {
/* 40 */     STaskOperControler sTaskOperControler = getSTaskOperControler();
/* 41 */     for (Iterator i$ = sTaskOperControler.controlerIds.iterator(); i$.hasNext();) { int controllerId = ((Integer)i$.next()).intValue();
/* 42 */       ControllerInterface.triggerController(roleId, controllerId); }
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void checkCfg()
/*    */   {
/* 49 */     STaskOperControler sTaskOperControler = getSTaskOperControler();
/* 50 */     for (Iterator i$ = sTaskOperControler.controlerIds.iterator(); i$.hasNext();) { int controlerId = ((Integer)i$.next()).intValue();
/*    */       
/* 52 */       if (!ControllerInterface.isControllerExist(controlerId))
/*    */       {
/* 54 */         throw new RuntimeException("任务配置的控制器id不存在id:" + controlerId + ",taskId:" + getTaskId());
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_Controler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */