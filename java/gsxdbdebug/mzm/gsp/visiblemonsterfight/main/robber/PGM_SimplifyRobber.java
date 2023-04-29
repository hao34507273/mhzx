/*    */ package mzm.gsp.visiblemonsterfight.main.robber;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SGangRobberRefreshCfg;
/*    */ 
/*    */ public class PGM_SimplifyRobber extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_SimplifyRobber(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     for (SGangRobberRefreshCfg gangRobberRefreshCfg : SGangRobberRefreshCfg.getAll().values()) {
/* 18 */       gangRobberRefreshCfg.rate = 10000;
/*    */     }
/* 20 */     GmManager.getInstance().sendResultToGM(this.roleid, "简化帮派强盗刷出指令成功!!");
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\robber\PGM_SimplifyRobber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */