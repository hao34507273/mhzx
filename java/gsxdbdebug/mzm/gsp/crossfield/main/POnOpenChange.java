/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ 
/*    */ public class POnOpenChange extends mzm.gsp.open.event.OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!CrossFieldManager.postInitFlag)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     if ((((OpenChangeComplexArg)this.arg).getType() != 398) || (!((OpenChangeComplexArg)this.arg).isOpen()))
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     SingleCrossFieldChartManager.getInstance().checkAndGetRemoteRank();
/* 26 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 28 */       SingleCrossFieldChartManager.getInstance().checkAndSendAward(roleid);
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */