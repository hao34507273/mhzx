/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.WingContent;
/*     */ import xbean.WingPlan;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WingTLogManager
/*     */ {
/*     */   private static final String TLOG_WING_PLAN_OPEN = "WingPlanOpenInfo";
/*     */   private static final String TLOG_WING_EXP_ADD = "WingExpAddInfo";
/*     */   private static final String TLOG_WING_RANK_UP = "WingRankUpInfo";
/*     */   private static final String TLOG_WING_OWN = "WingOwnInfo";
/*     */   private static final String TLOG_WING_RESET = "WingResetInfo";
/*     */   private static final String TLOG_WING_RP = "WingRPInfo";
/*     */   private static final String TLOG_WING_DRESS = "WingDressInfo";
/*     */   private static final String TLOG_WING_COLOR = "WingColorInfo";
/*     */   private static final String TLOG_WING_SET_TARGET_SKILL = "WingTargetSkillInfo";
/*     */   
/*     */   public static void tlogOpenWing(long roleId, WingPlan xWingPlan, int newWingId, int effectOccId)
/*     */   {
/*  37 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  38 */     String userid = RoleInterface.getUserId(roleId);
/*  39 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  41 */     int curRank = xWingPlan.getCurrank();
/*  42 */     int curLv = xWingPlan.getCurlv();
/*  43 */     int curExp = xWingPlan.getCurexp();
/*  44 */     int curWing = xWingPlan.getCurwing();
/*     */     
/*  46 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(curRank), Integer.valueOf(curLv), Integer.valueOf(curExp), Integer.valueOf(curWing), Integer.valueOf(effectOccId) });
/*     */     
/*  48 */     TLogManager.getInstance().addLog(roleId, "WingPlanOpenInfo", logStr);
/*     */     
/*  50 */     tlogGetNewWing(roleId, xWingPlan, newWingId, 1, effectOccId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogAddExp(long roleId, int oldLv, int addExp, WingPlan xWingPlan, int effectOccId)
/*     */   {
/*  67 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  68 */     String userid = RoleInterface.getUserId(roleId);
/*  69 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  71 */     int curRank = xWingPlan.getCurrank();
/*  72 */     int curLv = xWingPlan.getCurlv();
/*  73 */     int curExp = xWingPlan.getCurexp();
/*  74 */     int curWing = xWingPlan.getCurwing();
/*     */     
/*  76 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(curRank), Integer.valueOf(curLv), Integer.valueOf(curExp), Integer.valueOf(curWing), Integer.valueOf(oldLv), Integer.valueOf(addExp), Integer.valueOf(effectOccId) });
/*     */     
/*  78 */     TLogManager.getInstance().addLog(roleId, "WingExpAddInfo", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogAddRank(long roleId, WingPlan xWingPlan, int wingId, int effectOccId)
/*     */   {
/*  91 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  92 */     String userid = RoleInterface.getUserId(roleId);
/*  93 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  95 */     int curRank = xWingPlan.getCurrank();
/*  96 */     int curLv = xWingPlan.getCurlv();
/*  97 */     int curExp = xWingPlan.getCurexp();
/*  98 */     int curWing = xWingPlan.getCurwing();
/*  99 */     int oldRank = curRank - 1;
/*     */     
/* 101 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(curRank), Integer.valueOf(curLv), Integer.valueOf(curExp), Integer.valueOf(curWing), Integer.valueOf(oldRank), Integer.valueOf(effectOccId) });
/*     */     
/* 103 */     TLogManager.getInstance().addLog(roleId, "WingRankUpInfo", logStr);
/*     */     
/* 105 */     tlogGetNewWing(roleId, xWingPlan, wingId, 1, effectOccId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogGetNewWing(long roleId, WingPlan xWingPlan, int newWingId, int type, int effectOccId)
/*     */   {
/* 119 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 120 */     String userid = RoleInterface.getUserId(roleId);
/* 121 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 123 */     WingContent xWing = (WingContent)xWingPlan.getWings().get(Integer.valueOf(newWingId));
/* 124 */     int colorId = xWing.getColorid();
/* 125 */     String skills = xWing.getSkills().toString();
/* 126 */     String pros = xWing.getProids().toString();
/*     */     
/* 128 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%s|%s|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(newWingId), Integer.valueOf(colorId), skills, pros, Integer.valueOf(type), Integer.valueOf(effectOccId) });
/*     */     
/* 130 */     TLogManager.getInstance().addLog(roleId, "WingOwnInfo", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogReset(long roleId, int type, int wingId, List<Integer> retIds, int effectOccId)
/*     */   {
/* 145 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 146 */     String userid = RoleInterface.getUserId(roleId);
/* 147 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 149 */     String logStr = String.format("%s|%s|%d|%d|%d|%s|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(type), retIds.toString(), Integer.valueOf(effectOccId) });
/*     */     
/*     */ 
/* 152 */     TLogManager.getInstance().addLog(roleId, "WingResetInfo", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogRp(long roleId, int type, int wingId, List<Integer> rpIds, int effectOccId)
/*     */   {
/* 166 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 167 */     String userid = RoleInterface.getUserId(roleId);
/* 168 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 170 */     String logStr = String.format("%s|%s|%d|%d|%d|%s|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(type), rpIds.toString(), Integer.valueOf(effectOccId) });
/*     */     
/*     */ 
/* 173 */     TLogManager.getInstance().addLog(roleId, "WingRPInfo", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogChangeWing(long roleId, int newWingId, int effectOccId)
/*     */   {
/* 188 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 189 */     String userid = RoleInterface.getUserId(roleId);
/* 190 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 192 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(newWingId), Integer.valueOf(effectOccId) });
/*     */     
/* 194 */     TLogManager.getInstance().addLog(roleId, "WingDressInfo", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogWingChangeColor(long roleId, int wingId, int colorId, int effectOccId)
/*     */   {
/* 209 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 210 */     String userid = RoleInterface.getUserId(roleId);
/* 211 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 213 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(wingId), Integer.valueOf(colorId), Integer.valueOf(effectOccId) });
/*     */     
/* 215 */     TLogManager.getInstance().addLog(roleId, "WingColorInfo", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogSetTargetSkill(long roleId, int wingId, int position, int skill_id, int effectOccId)
/*     */   {
/* 228 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 229 */     String userid = RoleInterface.getUserId(roleId);
/* 230 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 232 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(wingId), Integer.valueOf(position), Integer.valueOf(skill_id), Integer.valueOf(effectOccId) });
/*     */     
/*     */ 
/* 235 */     TLogManager.getInstance().addLog(roleId, "WingTargetSkillInfo", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\WingTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */