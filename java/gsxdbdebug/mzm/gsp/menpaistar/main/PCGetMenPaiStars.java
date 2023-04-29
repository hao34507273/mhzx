/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.menpaistar.MenPaiStarChampionInfo;
/*    */ import mzm.gsp.menpaistar.SGetMenPaiStarsSuccess;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGetMenPaiStars
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetMenPaiStars(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1011))
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     List<MenPaiStarChartObj> all = MenPaiStarChartManager.getAll();
/* 29 */     SGetMenPaiStarsSuccess rsp = new SGetMenPaiStarsSuccess();
/* 30 */     for (MenPaiStarChartObj chartObj : all)
/*    */     {
/* 32 */       MenPaiStarChampionInfo starInfo = MenPaiStarChartManager.trans(chartObj);
/* 33 */       rsp.champions.add(starInfo);
/*    */     }
/* 35 */     OnlineManager.getInstance().send(this.roleid, rsp);
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCGetMenPaiStars.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */