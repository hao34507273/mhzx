/*    */ package mzm.gsp.factiontask.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnFactiontaskChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (((OpenChangeComplexArg)this.arg).getType() != 18)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     if (!((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/*    */ 
/* 25 */       return true;
/*    */     }
/*    */     
/* 28 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 30 */       NoneRealTimeTaskManager.getInstance().addTask(new PFactionOpen(roleId));
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\POnFactiontaskChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */