/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xtable.Gang2hunhelp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRmAllGangHelp
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     for (Iterator i$ = GangInterface.getAllGangIdSet().iterator(); i$.hasNext();) { final long gangId = ((Long)i$.next()).longValue();
/*    */       
/* 22 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */       {
/*    */ 
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 28 */           Gang2hunhelp.remove(Long.valueOf(gangId));
/* 29 */           return true;
/*    */         }
/*    */       });
/*    */     }
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PRmAllGangHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */