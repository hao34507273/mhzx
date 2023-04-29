/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.crossfield.SSynCrossFieldSeasonInfo;
/*    */ import mzm.gsp.crossfield.confbean.SCrossFieldConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.RoleSingleCrossFieldInfo;
/*    */ import xbean.RoleSingleCrossFieldSeasonInfo;
/*    */ import xtable.Role_single_cross_field_infos;
/*    */ 
/*    */ public class PGM_SetSingleCrossFieldWinPoint extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int winPoint;
/*    */   
/*    */   public PGM_SetSingleCrossFieldWinPoint(long gmRoleid, long roleid, int winPoint)
/*    */   {
/* 22 */     this.gmRoleid = gmRoleid;
/* 23 */     this.roleid = roleid;
/* 24 */     this.winPoint = winPoint;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     int currentSeason = CrossFieldManager.getCurrentSeason(DateTimeUtils.getCurrTimeInMillis());
/* 31 */     if (currentSeason <= 0)
/*    */     {
/*    */ 
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("无开启赛季", new Object[0]));
/* 35 */       return false;
/*    */     }
/* 37 */     if ((this.winPoint < 0) || (this.winPoint >= SCrossFieldConsts.getInstance().WIN_POINT_NUM_UPPER_LIMIT))
/*    */     {
/*    */ 
/* 40 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("胜点值错误", new Object[0]));
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*    */     
/* 46 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 48 */     lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 50 */     RoleSingleCrossFieldInfo xRoleSingleCrossFieldInfo = Role_single_cross_field_infos.get(Long.valueOf(this.roleid));
/* 51 */     if (xRoleSingleCrossFieldInfo == null)
/*    */     {
/* 53 */       xRoleSingleCrossFieldInfo = xbean.Pod.newRoleSingleCrossFieldInfo();
/* 54 */       xRoleSingleCrossFieldInfo.setWeekly_point_sum_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 55 */       xRoleSingleCrossFieldInfo.setDaily_award_times_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 56 */       Role_single_cross_field_infos.insert(Long.valueOf(this.roleid), xRoleSingleCrossFieldInfo);
/*    */     }
/* 58 */     RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = (RoleSingleCrossFieldSeasonInfo)xRoleSingleCrossFieldInfo.getSeason_infos().get(Integer.valueOf(currentSeason));
/*    */     
/* 60 */     if (xRoleSingleCrossFieldSeasonInfo == null)
/*    */     {
/* 62 */       xRoleSingleCrossFieldSeasonInfo = xbean.Pod.newRoleSingleCrossFieldSeasonInfo();
/* 63 */       xRoleSingleCrossFieldSeasonInfo.setStar_num_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 64 */       xRoleSingleCrossFieldInfo.getSeason_infos().put(Integer.valueOf(currentSeason), xRoleSingleCrossFieldSeasonInfo);
/*    */     }
/* 66 */     xRoleSingleCrossFieldSeasonInfo.setWin_point(this.winPoint);
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
/* 82 */     CrossFieldManager.logger.info(String.format("[crossfield]PGM_SetSingleCrossFieldStarNum.processImp@send win point success|roleid=%d|season=%d|win_point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(currentSeason), Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getWin_point()) }));
/*    */     
/*    */ 
/* 85 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置星级成功|角色ID=%d|赛季=%d|胜点=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(currentSeason), Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getWin_point()) }));
/*    */     
/*    */ 
/*    */ 
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\PGM_SetSingleCrossFieldWinPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */