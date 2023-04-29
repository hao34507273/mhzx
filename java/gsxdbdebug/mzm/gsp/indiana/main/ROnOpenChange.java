/*    */ package mzm.gsp.indiana.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 17 */     if (!IndianaManager.postInitFlag)
/*    */     {
/* 19 */       return;
/*    */     }
/* 21 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     if ((((OpenChangeComplexArg)this.arg).getType() != 522) || (!((OpenChangeComplexArg)this.arg).isOpen()))
/*    */     {
/* 27 */       return;
/*    */     }
/* 29 */     for (Iterator i$ = SIndianaCfg.getAll().keySet().iterator(); i$.hasNext();) { final int activityCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 31 */       new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 36 */           IndianaManager.tryGetAwardNumberAndSendAward(activityCfgid);
/* 37 */           return true;
/*    */         }
/*    */       }.call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */