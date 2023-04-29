/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointConst;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RGM_SetPointRaceZoneNum extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int num;
/*    */   
/*    */   public RGM_SetPointRaceZoneNum(long gmRoleid, int num)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.num = num;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     if (this.num < 1)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("数量不能小于1", new Object[0]));
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     SCrossBattlePointConst.getInstance().ZONE_NUM = this.num;
/*    */     
/* 29 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置积分赛赛区数量成功|数量=%d", new Object[] { Integer.valueOf(this.num) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\RGM_SetPointRaceZoneNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */