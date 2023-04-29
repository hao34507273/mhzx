/*    */ package mzm.gsp.baotu.main;
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
/*    */ 
/*    */ public class POnBaotuSwitchChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (((OpenChangeComplexArg)this.arg).getType() != 2)
/*    */     {
/* 21 */       return false; }
/*    */     Iterator i$;
/* 23 */     if (!((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 29 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/*    */ 
/* 32 */         NoneRealTimeTaskManager.getInstance().addTask(new BaotuSwitchClosedPro(roleId));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\POnBaotuSwitchChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */