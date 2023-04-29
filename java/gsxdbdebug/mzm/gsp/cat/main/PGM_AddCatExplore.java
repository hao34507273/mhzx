/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CatInfo;
/*    */ 
/*    */ public class PGM_AddCatExplore extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int num;
/*    */   
/*    */   public PGM_AddCatExplore(long gmRoleid, long roleid, int num)
/*    */   {
/* 16 */     this.gmRoleid = gmRoleid;
/* 17 */     this.roleid = roleid;
/* 18 */     this.num = num;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     lock(xdb.Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 27 */     CatInfo xCatInfo = CatManager.getHomelandCat(this.roleid, true);
/* 28 */     if (xCatInfo == null)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "探险猫不存在");
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     int totalExploreNum = xCatInfo.getTotal_explore_num() + this.num;
/* 35 */     if (totalExploreNum < 0)
/*    */     {
/* 37 */       totalExploreNum = 0;
/*    */     }
/*    */     
/* 40 */     xCatInfo.setTotal_explore_num(totalExploreNum);
/*    */     
/* 42 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "设置总探险次数成功");
/*    */     
/* 44 */     GameServer.logger().info(String.format("[gm]PGM_AddCatExplore.processImp@add cat explore success|gm_roleid=%d|roleid=%d|num=%d", new Object[] { Long.valueOf(this.gmRoleid), Long.valueOf(this.roleid), Integer.valueOf(this.num) }));
/*    */     
/*    */ 
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PGM_AddCatExplore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */