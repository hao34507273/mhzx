/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.petarena.PetArenaChartData;
/*    */ import mzm.gsp.petarena.SGetChartSuccess;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCGetChart extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int startRank;
/*    */   private final int num;
/*    */   
/*    */   public PCGetChart(long roleid, int startRank, int num)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.startRank = startRank;
/* 25 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if ((this.startRank < 0) || (this.num <= 0))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (!PetArenaManager.canDoAction(this.roleid, 2116))
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (!PetArenaManager.isChartFunOpen(this.roleid))
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     int point = (int)MallInterface.getJifen(this.roleid, 14);
/*    */     
/* 48 */     List<PetArenaChartObj> chartObjs = PetArenaChartManager.getChartObjs(this.startRank, this.num);
/* 49 */     if (chartObjs == null)
/*    */     {
/* 51 */       GameServer.logger().error(String.format("[petarena]PCGetChart.processImp@chat objs is null|roleid=%d|start_rank=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.startRank), Integer.valueOf(this.num) }));
/*    */       
/*    */ 
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     SGetChartSuccess rsp = new SGetChartSuccess();
/* 58 */     for (PetArenaChartObj chartObj : chartObjs)
/*    */     {
/* 60 */       rsp.rank_datas.add(buildPetArenaChartData(chartObj));
/*    */     }
/* 62 */     int rank = PetArenaRankManager.getInstance().getRank(this.roleid);
/* 63 */     if ((rank < 0) || (rank > PetArenaChartManager.capacity()))
/*    */     {
/* 65 */       rank = 0;
/*    */     }
/* 67 */     rsp.my_rank = rank;
/* 68 */     rsp.my_point = point;
/* 69 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/* 71 */     GameServer.logger().info(String.format("[petarena]PCGetChart.processImp@get success|roleid=%d|start_rank=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.startRank), Integer.valueOf(this.num) }));
/*    */     
/*    */ 
/* 74 */     return true;
/*    */   }
/*    */   
/*    */   private PetArenaChartData buildPetArenaChartData(PetArenaChartObj chartObj)
/*    */   {
/* 79 */     PetArenaChartData data = new PetArenaChartData();
/* 80 */     data.rank = chartObj.getRank();
/*    */     
/* 82 */     long roleid = chartObj.getRoleid();
/* 83 */     if (roleid > 0L)
/*    */     {
/* 85 */       data.roleid = roleid;
/* 86 */       data.defend_lose_num = chartObj.getDefendLoseNum();
/* 87 */       data.defend_win_num = chartObj.getDefendWinNum();
/* 88 */       data.lose_num = chartObj.getLoseNum();
/* 89 */       data.win_num = chartObj.getWinNum();
/*    */       try
/*    */       {
/* 92 */         data.name.setString(chartObj.getName(), "UTF-8");
/*    */       }
/*    */       catch (UnsupportedEncodingException e) {}
/*    */     }
/*    */     
/*    */ 
/* 98 */     return data;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCGetChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */