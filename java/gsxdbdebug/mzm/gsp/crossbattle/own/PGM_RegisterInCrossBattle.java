/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.corps.main.CorpsInfo;
/*    */ import mzm.gsp.corps.main.CorpsInterface;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.AttendCorpsInfo;
/*    */ import xbean.CrossBattleOwn;
/*    */ import xtable.Corps;
/*    */ 
/*    */ public class PGM_RegisterInCrossBattle extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PGM_RegisterInCrossBattle(long gmRoleid, long roleid, int activityCfgid)
/*    */   {
/* 23 */     this.gmRoleid = gmRoleid;
/* 24 */     this.roleid = roleid;
/* 25 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/* 32 */     if (cfg == null)
/*    */     {
/*    */ 
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("跨服战报名失败|%s", new Object[] { "参数错误" }));
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*    */     
/* 41 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 43 */     lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 45 */     CorpsInfo selectCorpsInfo = CorpsInterface.getCorpsInfoByRoleId(this.roleid, false, false);
/* 46 */     if (selectCorpsInfo == null)
/*    */     {
/*    */ 
/* 49 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("跨服战报名失败|%s", new Object[] { "玩家不在战队中" }));
/* 50 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 54 */     lock(Corps.getTable(), Arrays.asList(new Long[] { Long.valueOf(selectCorpsInfo.getCorpsId()) }));
/* 55 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(selectCorpsInfo.getCorpsId(), true);
/* 56 */     if (corpsInfo == null)
/*    */     {
/*    */ 
/* 59 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("跨服战报名失败|%s", new Object[] { "玩家不在战队中" }));
/* 60 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 64 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 65 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 66 */     if (xCrossBattleOwn == null)
/*    */     {
/*    */ 
/* 69 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("跨服战报名失败|%s", new Object[] { "活动未开启" }));
/* 70 */       return false;
/*    */     }
/*    */     
/* 73 */     if (xCrossBattleOwn.getStage() == -1)
/*    */     {
/* 75 */       xCrossBattleOwn.setStage(0);
/*    */     }
/*    */     
/* 78 */     if (xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsInfo.getCorpsId())))
/*    */     {
/*    */ 
/* 81 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("跨服战报名失败|%s", new Object[] { "战队已经报名" }));
/* 82 */       return false;
/*    */     }
/*    */     
/* 85 */     AttendCorpsInfo xAttendCorpsInfo = xbean.Pod.newAttendCorpsInfo();
/* 86 */     xCrossBattleOwn.getAttend_corps_infos().put(Long.valueOf(corpsInfo.getCorpsId()), xAttendCorpsInfo);
/* 87 */     xAttendCorpsInfo.setZoneid(((Integer)GameServerInfoManager.getZoneIds().get(0)).intValue());
/* 88 */     xAttendCorpsInfo.getMembers().clear();
/* 89 */     xAttendCorpsInfo.getMembers().add(Long.valueOf(corpsInfo.getCaptain()));
/* 90 */     xAttendCorpsInfo.getMembers().addAll(corpsInfo.getNormalMemberIds());
/* 91 */     xAttendCorpsInfo.setVote_num(0);
/* 92 */     xAttendCorpsInfo.setVote_num_timestamp(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 93 */     xAttendCorpsInfo.setVote_stage_start_average_fight_value(0.0F);
/* 94 */     xAttendCorpsInfo.setName(corpsInfo.getCorpsName());
/* 95 */     xAttendCorpsInfo.setBadge(corpsInfo.getCorpsBadgeId());
/* 96 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("跨服战报名成功|corpsid=%d", new Object[] { Long.valueOf(corpsInfo.getCorpsId()) }));
/* 97 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PGM_RegisterInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */