/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.confbean.SJingjiPointRankAward;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.JingJiDailyRank;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleJingJiBean;
/*    */ import xtable.Jingjidailytrankbackup;
/*    */ 
/*    */ public class PDailyRankAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final List<RoleJingjiChart> roleJingjiCharts;
/*    */   private final long time;
/*    */   
/*    */   public PDailyRankAward(List<RoleJingjiChart> roleJingjiCharts, long time)
/*    */   {
/* 21 */     this.roleJingjiCharts = roleJingjiCharts;
/* 22 */     this.time = time;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     long key = GameServerInfoManager.getLocalId();
/* 30 */     JingJiDailyRank xJingJiDailyRank = Jingjidailytrankbackup.get(Long.valueOf(key));
/* 31 */     if (xJingJiDailyRank == null)
/*    */     {
/* 33 */       xJingJiDailyRank = Pod.newJingJiDailyRank();
/* 34 */       Jingjidailytrankbackup.insert(Long.valueOf(key), xJingJiDailyRank);
/*    */     }
/*    */     
/* 37 */     long lastTime = xJingJiDailyRank.getTime();
/* 38 */     if (mzm.gsp.util.DateTimeUtils.isInSameDay(this.time, xJingJiDailyRank.getTime()))
/*    */     {
/* 40 */       JingjiManager.logger.info(String.format("[jingji]PDailyRankAward.processImp@last backup time is in same day|last_time=%d|time=%d", new Object[] { Long.valueOf(lastTime), Long.valueOf(this.time) }));
/*    */       
/*    */ 
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     xJingJiDailyRank.getRank_datas().clear();
/* 47 */     for (RoleJingjiChart r : this.roleJingjiCharts)
/*    */     {
/* 49 */       RoleJingJiBean xRoleJingJiBean = Pod.newRoleJingJiBean();
/* 50 */       xRoleJingJiBean.setPoint(r.getWinPoint());
/* 51 */       xRoleJingJiBean.setRoleid(r.getRoleid());
/* 52 */       xJingJiDailyRank.getRank_datas().add(xRoleJingJiBean);
/*    */     }
/* 54 */     xJingJiDailyRank.setTime(this.time);
/*    */     
/* 56 */     List<Integer> ranks = new java.util.ArrayList(SJingjiPointRankAward.getAll().keySet());
/* 57 */     java.util.Collections.sort(ranks);
/* 58 */     for (int i = 0; i < this.roleJingjiCharts.size(); i++)
/*    */     {
/* 60 */       int rank = i + 1;
/* 61 */       long roleid = ((RoleJingjiChart)this.roleJingjiCharts.get(i)).getRoleid();
/* 62 */       boolean isfound = false;
/* 63 */       for (int j = 0; j < ranks.size(); j++)
/*    */       {
/* 65 */         int maxRank = ((Integer)ranks.get(j)).intValue();
/* 66 */         if (rank <= maxRank)
/*    */         {
/* 68 */           xJingJiDailyRank.getRole_ranks().put(Long.valueOf(roleid), Integer.valueOf(rank));
/* 69 */           int rewardid = SJingjiPointRankAward.get(maxRank).rewardid;
/* 70 */           NoneRealTimeTaskManager.getInstance().addTask(new PRoleDailyAward(roleid, rewardid, rank));
/* 71 */           isfound = true;
/* 72 */           break;
/*    */         }
/*    */       }
/* 75 */       if (!isfound) {
/*    */         break;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 81 */     mzm.gsp.GameServer.logger().info(String.format("[jingji]PDailyRankAward.processImp@backup success|time=%d", new Object[] { Long.valueOf(this.time) }));
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PDailyRankAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */