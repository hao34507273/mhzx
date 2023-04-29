/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.idip.main.IdipInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 18 */     if ((((OpenChangeComplexArg)this.arg).getType() != 567) && (((OpenChangeComplexArg)this.arg).getType() != 568))
/*    */     {
/*    */ 
/* 21 */       return;
/*    */     }
/*    */     
/* 24 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 25 */     Iterator i$; if (((OpenChangeComplexArg)this.arg).getType() == 568)
/*    */     {
/* 27 */       if (isOpen)
/*    */       {
/* 29 */         List<Long> onLineRoleIdList = OnlineManager.getInstance().getAllRolesInWorld();
/* 30 */         for (i$ = onLineRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */           
/* 32 */           NoneRealTimeTaskManager.getInstance().addTask(new POnSelectionRoleLogin.PSendFinalSeverMailAward(roleId));
/*    */         }
/*    */       }
/*    */     }
/*    */     Iterator i$;
/* 37 */     if (((OpenChangeComplexArg)this.arg).getType() == 567)
/*    */     {
/* 39 */       List<Long> onLineRoleIdList = OnlineManager.getInstance().getAllRolesInWorld();
/* 40 */       Iterator i$; if (isOpen)
/*    */       {
/* 42 */         for (i$ = onLineRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */           
/* 44 */           NoneRealTimeTaskManager.getInstance().addTask(new PGlobalNTimesFinalServerAwardInstall(roleId));
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 49 */         for (i$ = onLineRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */           
/* 51 */           NoneRealTimeTaskManager.getInstance().addTask(new PGlobalNTimesFinalServerAwardUnInstall(roleId));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private static class PGlobalNTimesFinalServerAwardUnInstall extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     public PGlobalNTimesFinalServerAwardUnInstall(long roleId)
/*    */     {
/* 63 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 69 */       IdipInterface.globalNTimesFinalServerAwardUnInstall(this.roleId);
/* 70 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */   private static class PGlobalNTimesFinalServerAwardInstall extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     public PGlobalNTimesFinalServerAwardInstall(long roleId)
/*    */     {
/* 80 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 86 */       IdipInterface.globalNTimesFinalServerAwardInstall(this.roleId);
/* 87 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */