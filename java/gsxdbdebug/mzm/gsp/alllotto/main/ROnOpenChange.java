/*    */ package mzm.gsp.alllotto.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!AllLottoManager.postInitFlag)
/*    */     {
/* 19 */       return;
/*    */     }
/* 21 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     if ((((OpenChangeComplexArg)this.arg).getType() != 537) || (!((OpenChangeComplexArg)this.arg).isOpen()))
/*    */     {
/* 27 */       return;
/*    */     }
/* 29 */     for (Iterator i$ = SAllLottoCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 31 */       new PCheckAndGetAwardRoleInfo(activityCfgid).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */