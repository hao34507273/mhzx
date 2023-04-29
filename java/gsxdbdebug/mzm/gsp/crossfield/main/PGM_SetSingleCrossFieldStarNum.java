/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.crossfield.SSynCrossFieldSeasonInfo;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.RoleSingleCrossFieldInfo;
/*    */ import xbean.RoleSingleCrossFieldSeasonInfo;
/*    */ import xtable.Role_single_cross_field_infos;
/*    */ 
/*    */ public class PGM_SetSingleCrossFieldStarNum extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int starNum;
/*    */   
/*    */   public PGM_SetSingleCrossFieldStarNum(long gmRoleid, long roleid, int starNum)
/*    */   {
/* 21 */     this.gmRoleid = gmRoleid;
/* 22 */     this.roleid = roleid;
/* 23 */     this.starNum = starNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     int currentSeason = CrossFieldManager.getCurrentSeason(DateTimeUtils.getCurrTimeInMillis());
/* 30 */     if (currentSeason <= 0)
/*    */     {
/*    */ 
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("无开启赛季", new Object[0]));
/* 34 */       return false;
/*    */     }
/* 36 */     if (this.starNum < 0)
/*    */     {
/*    */ 
/* 39 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("星级不能小于0", new Object[0]));
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 45 */     lock(xtable.User.getTable(), java.util.Arrays.asList(new String[] { userid }));
/*    */     
/* 47 */     lock(xtable.Basic.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 49 */     RoleSingleCrossFieldInfo xRoleSingleCrossFieldInfo = Role_single_cross_field_infos.get(Long.valueOf(this.roleid));
/* 50 */     if (xRoleSingleCrossFieldInfo == null)
/*    */     {
/* 52 */       xRoleSingleCrossFieldInfo = xbean.Pod.newRoleSingleCrossFieldInfo();
/* 53 */       xRoleSingleCrossFieldInfo.setWeekly_point_sum_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 54 */       xRoleSingleCrossFieldInfo.setDaily_award_times_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 55 */       Role_single_cross_field_infos.insert(Long.valueOf(this.roleid), xRoleSingleCrossFieldInfo);
/*    */     }
/* 57 */     RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = (RoleSingleCrossFieldSeasonInfo)xRoleSingleCrossFieldInfo.getSeason_infos().get(Integer.valueOf(currentSeason));
/*    */     
/* 59 */     if (xRoleSingleCrossFieldSeasonInfo == null)
/*    */     {
/* 61 */       xRoleSingleCrossFieldSeasonInfo = xbean.Pod.newRoleSingleCrossFieldSeasonInfo();
/* 62 */       xRoleSingleCrossFieldSeasonInfo.setStar_num_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 63 */       xRoleSingleCrossFieldInfo.getSeason_infos().put(Integer.valueOf(currentSeason), xRoleSingleCrossFieldSeasonInfo);
/*    */     }
/* 65 */     xRoleSingleCrossFieldSeasonInfo.setStar_num(this.starNum);
/* 66 */     xRoleSingleCrossFieldSeasonInfo.setStar_num_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*    */     
/* 68 */     SSynCrossFieldSeasonInfo protocol = new SSynCrossFieldSeasonInfo();
/* 69 */     protocol.season = currentSeason;
/* 70 */     protocol.star_num = xRoleSingleCrossFieldSeasonInfo.getStar_num();
/* 71 */     protocol.win_point = xRoleSingleCrossFieldSeasonInfo.getWin_point();
/* 72 */     protocol.straight_win_num = xRoleSingleCrossFieldSeasonInfo.getStraight_win_num();
/* 73 */     protocol.star_num_timestamp = ((int)(xRoleSingleCrossFieldSeasonInfo.getStar_num_timestamp() / 1000L));
/*    */     
/* 75 */     protocol.current_week_point = (DateTimeUtils.needWeeklyReset(xRoleSingleCrossFieldInfo.getWeekly_point_sum_timestamp(), DateTimeUtils.getCurrTimeInMillis(), 1, 0) ? 0 : xRoleSingleCrossFieldInfo.getWeekly_point_sum());
/*    */     
/*    */ 
/* 78 */     protocol.last_get_point_time = TimeUnit.MILLISECONDS.toSeconds(xRoleSingleCrossFieldInfo.getWeekly_point_sum_timestamp());
/*    */     
/* 80 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     
/* 82 */     SingleCrossFieldChartManager.getInstance().rank(this.roleid, currentSeason);
/* 83 */     CrossFieldManager.reportRoleSingleCrossFieldRankInfo(currentSeason, this.roleid, RoleInterface.getName(this.roleid), RoleInterface.getOccupationId(this.roleid), xRoleSingleCrossFieldSeasonInfo.getStar_num(), xRoleSingleCrossFieldSeasonInfo.getStar_num_timestamp());
/*    */     
/*    */ 
/* 86 */     CrossFieldManager.logger.info(String.format("[crossfield]PGM_SetSingleCrossFieldStarNum.processImp@send star num success|roleid=%d|season=%d|star_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(currentSeason), Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getStar_num()) }));
/*    */     
/*    */ 
/* 89 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置星级成功|角色ID=%d|赛季=%d|星级=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(currentSeason), Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getStar_num()) }));
/*    */     
/*    */ 
/*    */ 
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\PGM_SetSingleCrossFieldStarNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */