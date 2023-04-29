/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PetArenaInfo;
/*    */ 
/*    */ public class PRankPetArenaChart extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int rank;
/*    */   
/*    */   public PRankPetArenaChart(long roleid, int rank)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.rank = rank;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(this.roleid));
/* 22 */     if (xPetArenaInfo == null)
/*    */     {
/* 24 */       GameServer.logger().error(String.format("[petarena]PRankPetArenaChart.processImp@system error|roleid=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank) }));
/*    */       
/*    */ 
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     String name = mzm.gsp.role.main.RoleInterface.getName(this.roleid);
/* 31 */     PetArenaChartObj chartObj = new PetArenaChartObj(this.rank, this.roleid, name, xPetArenaInfo.getWin_num(), xPetArenaInfo.getLose_num(), xPetArenaInfo.getDefend_win_num(), xPetArenaInfo.getDefend_lose_num());
/*    */     
/*    */ 
/* 34 */     PetArenaChartManager.rank(chartObj);
/*    */     
/* 36 */     GameServer.logger().info(String.format("[petarena]PRankPetArenaChart.processImp@add chart|roleid=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank) }));
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PRankPetArenaChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */