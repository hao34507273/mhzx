/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import xbean.JingjiPvp;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class Pgm_JoinPvp extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public Pgm_JoinPvp(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     long s = JingjiManager.getSeasonStarttime();
/* 20 */     JingjiPvp jingjiData = JingjiManager.getJingjiData(this.roleid);
/* 21 */     if (jingjiData == null)
/*    */     {
/* 23 */       int winpoint = JingjiActivityCfgConsts.getInstance().INIT_WING_POINT_NUM + Xdb.random().nextInt(JingjiManager.getMaxWingPoint() - JingjiActivityCfgConsts.getInstance().INIT_WING_POINT_NUM);
/*    */       
/*    */ 
/* 26 */       boolean ret = JingjiManager.insertJingjiData(this.roleid, JingjiActivityCfgConsts.getInstance().DAY_OFFER_CHALLENGE_COUNT, 0, winpoint, 0, s);
/*    */       
/* 28 */       if (ret)
/*    */       {
/* 30 */         RoleJingjiChartInterface.rank(this.roleid, winpoint);
/* 31 */         JingjiManager.asynAddTotalCount(1);
/*    */       }
/*    */     }
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\Pgm_JoinPvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */