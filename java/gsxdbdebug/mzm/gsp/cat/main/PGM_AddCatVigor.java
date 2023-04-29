/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CatInfo;
/*    */ 
/*    */ public class PGM_AddCatVigor extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int num;
/*    */   
/*    */   public PGM_AddCatVigor(long gmRoleid, long roleid, int num)
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
/* 34 */     int curVigor = xCatInfo.getVigor() + this.num;
/* 35 */     if (curVigor < 0)
/*    */     {
/* 37 */       curVigor = 0;
/*    */     }
/* 39 */     xCatInfo.setVigor(curVigor);
/*    */     
/* 41 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "探险猫设置活力成功");
/* 42 */     GameServer.logger().info(String.format("[gm]PGM_AddCatVigor.processImp@add cat vigor success|gm_roleid=%d|roleid=%d|num=%d|cur_vigor=%d", new Object[] { Long.valueOf(this.gmRoleid), Long.valueOf(this.roleid), Integer.valueOf(this.num), Integer.valueOf(curVigor) }));
/*    */     
/*    */ 
/*    */ 
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PGM_AddCatVigor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */