/*     */ package mzm.gsp.msdkprofile.main.qq;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.msdkprofile.main.Reporter;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ public class ReporterImp
/*     */   implements Reporter
/*     */ {
/*     */   private static final String NOT_EXPIRE = "0";
/*     */   
/*     */   private void addParam(ReportScoreParams params, ParamType paramType, String data, String expires, boolean isCover)
/*     */   {
/*  23 */     ReportParam param = new ReportParam();
/*  24 */     param.type = paramType.type;
/*  25 */     param.data = data;
/*  26 */     param.expires = expires;
/*  27 */     param.bcover = (isCover ? 1 : 0);
/*  28 */     params.addParam(param);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportScore(String userid, long roleid, String param)
/*     */   {
/*  34 */     return GrcInterface.reportProfileScore(userid, roleid, param);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillRoleNecessary(String userid, long roleid, ReportScoreParams params)
/*     */   {
/*  46 */     addParam(params, ParamType.PLATID, String.valueOf(Onlines.getInstance().findPlatid(userid)), "0", true);
/*     */     
/*  48 */     addParam(params, ParamType.GAME_TYPE, "1", "0", true);
/*  49 */     addParam(params, ParamType.AREAID, String.valueOf(getAreaId(userid)), "0", true);
/*  50 */     addParam(params, ParamType.PARTITION, String.valueOf(GameServerInfoManager.getZoneidFromUserid(userid)), "0", true);
/*     */     
/*  52 */     addParam(params, ParamType.ROLEID, String.valueOf(roleid), "0", true);
/*  53 */     addParam(params, ParamType.NAME, RoleInterface.getName(roleid), "0", true);
/*     */   }
/*     */   
/*     */   private int getAreaId(String userid)
/*     */   {
/*  58 */     String GameAppid = Onlines.getInstance().findGameAppid(userid);
/*  59 */     int areaId = 0;
/*  60 */     if ((GameAppid != null) && (GameAppid.startsWith("G_")))
/*     */     {
/*  62 */       areaId = 3;
/*     */     }
/*     */     else
/*     */     {
/*  66 */       String platName = CommonUtils.getPlatName(userid);
/*  67 */       if ("qq".equals(platName))
/*     */       {
/*  69 */         areaId = 2;
/*     */       }
/*  71 */       else if ("wechat".equals(platName))
/*     */       {
/*  73 */         areaId = 1;
/*     */       }
/*     */     }
/*  76 */     return areaId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillGangNecessary(long gangId, ReportScoreParams params)
/*     */   {
/*  88 */     addParam(params, ParamType.GANGID, String.valueOf(gangId), "0", true);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportRoleLevel(String userid, long roleid, int level)
/*     */   {
/*  94 */     ReportScoreParams params = new ReportScoreParams();
/*  95 */     fillRoleNecessary(userid, roleid, params);
/*  96 */     addParam(params, ParamType.LEVEL, String.valueOf(level), "0", true);
/*  97 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportRoleCash(String userid, long roleid, long cash)
/*     */   {
/* 104 */     ReportScoreParams params = new ReportScoreParams();
/* 105 */     fillRoleNecessary(userid, roleid, params);
/* 106 */     addParam(params, ParamType.CASH, String.valueOf(cash), "0", true);
/* 107 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportRoleRankScore(String userid, long roleid, int rankScore, long expire)
/*     */   {
/* 114 */     ReportScoreParams params = new ReportScoreParams();
/* 115 */     fillRoleNecessary(userid, roleid, params);
/* 116 */     addParam(params, ParamType.RANK_SCORE, String.valueOf(rankScore), String.valueOf(expire), true);
/* 117 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportRoleLogin(String userid, long roleid)
/*     */   {
/* 124 */     ReportScoreParams params = new ReportScoreParams();
/* 125 */     fillRoleNecessary(userid, roleid, params);
/*     */     
/* 127 */     long gangId = GangInterface.getGangId(roleid);
/* 128 */     if (gangId != 0L)
/*     */     {
/* 130 */       fillGangNecessary(gangId, params);
/*     */       
/*     */ 
/* 133 */       Gang gang = GangInterface.getGang(gangId, false);
/* 134 */       addParam(params, ParamType.GANG_NAME, gang.getName(), "0", true);
/* 135 */       addParam(params, ParamType.GANG_LEVEL, String.valueOf(gang.getLevel()), "0", true);
/*     */       
/* 137 */       addParam(params, ParamType.GANG_MEMBER_CHANGE, String.valueOf(1), "0", true);
/* 138 */       addParam(params, ParamType.GANG_DUTY, String.valueOf(gang.getGangDuty(roleid)), "0", true);
/*     */       
/* 140 */       addParam(params, ParamType.GANG_MEMBER_ABILITY, String.valueOf(RoleInterface.getRoleMFValue(roleid)), "0", true);
/*     */       
/*     */ 
/* 143 */       if (gang.getBangZhuId() == roleid)
/*     */       {
/*     */ 
/* 146 */         String qqGroupId = GangInterface.getQQGroupId(gangId);
/* 147 */         if ((qqGroupId != null) && (!qqGroupId.isEmpty()))
/*     */         {
/* 149 */           addParam(params, ParamType.GANG_QQ, qqGroupId, "0", true);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 154 */     addParam(params, ParamType.CREATE_TIME, Utils.formatTimestamp(RoleInterface.getRoleCreateTime(roleid)), "0", true);
/*     */     
/* 156 */     addParam(params, ParamType.OCCUPATIONID, String.valueOf(RoleInterface.getOccupationId(roleid)), "0", true);
/*     */     
/* 158 */     addParam(params, ParamType.LAST_LOGIN, Utils.formatTimestamp(RoleInterface.getLastLoginTime(roleid)), "0", true);
/* 159 */     addParam(params, ParamType.FIGHT_VALUE, String.valueOf(RoleInterface.getFightValue(roleid)), "0", true);
/*     */     
/* 161 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportRoleFightValue(String userid, long roleid, int fightValue)
/*     */   {
/* 167 */     ReportScoreParams params = new ReportScoreParams();
/* 168 */     fillRoleNecessary(userid, roleid, params);
/* 169 */     addParam(params, ParamType.FIGHT_VALUE, String.valueOf(fightValue), "0", true);
/* 170 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportRoleCreate(String userid, long roleid)
/*     */   {
/* 176 */     ReportScoreParams params = new ReportScoreParams();
/* 177 */     fillRoleNecessary(userid, roleid, params);
/*     */     
/* 179 */     addParam(params, ParamType.LEVEL, String.valueOf(RoleInterface.getLevel(roleid)), "0", true);
/*     */     
/* 181 */     long balance = QingfuInterface.getBalance(userid, false);
/* 182 */     if (balance == -1L)
/*     */     {
/* 184 */       balance = 0L;
/*     */     }
/* 186 */     addParam(params, ParamType.CASH, String.valueOf(balance), "0", true);
/*     */     
/* 188 */     addParam(params, ParamType.RANK_SCORE, "0", "0", true);
/* 189 */     addParam(params, ParamType.LAST_LOGIN, Utils.formatTimestamp(RoleInterface.getLastLoginTime(roleid)), "0", true);
/* 190 */     addParam(params, ParamType.FIGHT_VALUE, String.valueOf(RoleInterface.getFightValue(roleid)), "0", true);
/*     */     
/* 192 */     Role role = RoleInterface.getRole(roleid, false);
/* 193 */     addParam(params, ParamType.CREATE_TIME, Utils.formatTimestamp(role.getCreateTime()), "0", true);
/*     */     
/* 195 */     addParam(params, ParamType.OCCUPATIONID, String.valueOf(RoleInterface.getOccupationId(roleid)), "0", true);
/*     */     
/* 197 */     long saveAmt = QingfuInterface.getSaveAmt(userid, false);
/* 198 */     if (saveAmt == -1L)
/*     */     {
/* 200 */       saveAmt = 0L;
/*     */     }
/* 202 */     addParam(params, ParamType.RECHARGE_SUM, String.valueOf(saveAmt), "0", true);
/* 203 */     addParam(params, ParamType.RECHARGE_NUM, "0", "0", true);
/*     */     
/* 205 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportRoleName(String userid, long roleid)
/*     */   {
/* 211 */     ReportScoreParams params = new ReportScoreParams();
/* 212 */     fillRoleNecessary(userid, roleid, params);
/* 213 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportRoleRecharge(String userid, long roleid, long oldSaveAmt, long currSaveAmt)
/*     */   {
/* 219 */     ReportScoreParams params = new ReportScoreParams();
/* 220 */     fillRoleNecessary(userid, roleid, params);
/*     */     
/* 222 */     addParam(params, ParamType.RECHARGE_NUM, String.valueOf(currSaveAmt - oldSaveAmt), "0", true);
/* 223 */     addParam(params, ParamType.RECHARGE_SUM, String.valueOf(currSaveAmt), "0", true);
/*     */     
/* 225 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportGangName(String userid, long roleid, long gangId, String gangName)
/*     */   {
/* 231 */     ReportScoreParams params = new ReportScoreParams();
/* 232 */     fillRoleNecessary(userid, roleid, params);
/* 233 */     fillGangNecessary(gangId, params);
/*     */     
/* 235 */     addParam(params, ParamType.GANG_NAME, gangName, "0", true);
/* 236 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportGangLevel(String userid, long roleid, long gangId, int gangLevel)
/*     */   {
/* 242 */     ReportScoreParams params = new ReportScoreParams();
/* 243 */     fillRoleNecessary(userid, roleid, params);
/* 244 */     fillGangNecessary(gangId, params);
/*     */     
/* 246 */     addParam(params, ParamType.GANG_LEVEL, String.valueOf(gangLevel), "0", true);
/* 247 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportGangCreate(String userid, long bangZhuRoleId, long gangId)
/*     */   {
/* 253 */     ReportScoreParams params = new ReportScoreParams();
/* 254 */     fillRoleNecessary(userid, bangZhuRoleId, params);
/* 255 */     fillGangNecessary(gangId, params);
/*     */     
/* 257 */     Gang gang = GangInterface.getGang(gangId, false);
/* 258 */     addParam(params, ParamType.GANG_CREATE_TIME, Utils.formatTimestamp(gang.getCreateTime()), "0", true);
/*     */     
/* 260 */     return reportScore(userid, bangZhuRoleId, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangDestory(String userid, long bangZhuRoleId, long gangId)
/*     */   {
/* 267 */     ReportScoreParams params = new ReportScoreParams();
/* 268 */     fillRoleNecessary(userid, bangZhuRoleId, params);
/*     */     
/*     */ 
/* 271 */     addParam(params, ParamType.GANGID, "0", "0", true);
/* 272 */     addParam(params, ParamType.GANG_DESTORY_TIME, Utils.formatTimestamp(DateTimeUtils.getCurrTimeInMillis()), "0", true);
/*     */     
/*     */ 
/* 275 */     return reportScore(userid, bangZhuRoleId, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportGangMemberJoin(String userid, long roleid, long gangId)
/*     */   {
/* 281 */     ReportScoreParams params = new ReportScoreParams();
/* 282 */     fillRoleNecessary(userid, roleid, params);
/* 283 */     fillGangNecessary(gangId, params);
/*     */     
/*     */ 
/* 286 */     Gang gang = GangInterface.getGang(gangId, false);
/* 287 */     addParam(params, ParamType.GANG_NAME, gang.getName(), "0", true);
/* 288 */     addParam(params, ParamType.GANG_LEVEL, String.valueOf(gang.getLevel()), "0", true);
/*     */     
/* 290 */     addParam(params, ParamType.GANG_MEMBER_CHANGE, String.valueOf(1), "0", true);
/* 291 */     addParam(params, ParamType.GANG_DUTY, String.valueOf(gang.getGangDuty(roleid)), "0", true);
/* 292 */     addParam(params, ParamType.GANG_MEMBER_ABILITY, String.valueOf(RoleInterface.getRoleMFValue(roleid)), "0", true);
/*     */     
/* 294 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportGangMemberExit(String userid, long roleid, long gangId)
/*     */   {
/* 300 */     ReportScoreParams params = new ReportScoreParams();
/* 301 */     fillRoleNecessary(userid, roleid, params);
/*     */     
/*     */ 
/* 304 */     addParam(params, ParamType.GANGID, "0", "0", true);
/*     */     
/*     */ 
/* 307 */     addParam(params, ParamType.GANG_NAME, "0", "0", true);
/* 308 */     addParam(params, ParamType.GANG_LEVEL, "0", "0", true);
/*     */     
/*     */ 
/* 311 */     addParam(params, ParamType.GANG_MEMBER_CHANGE, String.valueOf(2), "0", true);
/*     */     
/* 313 */     addParam(params, ParamType.GANG_DUTY, "0", "0", true);
/* 314 */     addParam(params, ParamType.GANG_MEMBER_ABILITY, "0", "0", true);
/*     */     
/* 316 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportGangPositionChange(String userid, long roleid, long gangId, int duty)
/*     */   {
/* 322 */     ReportScoreParams params = new ReportScoreParams();
/* 323 */     fillRoleNecessary(userid, roleid, params);
/* 324 */     fillGangNecessary(gangId, params);
/*     */     
/* 326 */     addParam(params, ParamType.GANG_DUTY, String.valueOf(duty), "0", true);
/* 327 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangBindQQ(String userid, long bangZhuRoleId, long gangId, String qq)
/*     */   {
/* 334 */     ReportScoreParams params = new ReportScoreParams();
/* 335 */     fillRoleNecessary(userid, bangZhuRoleId, params);
/* 336 */     fillGangNecessary(gangId, params);
/* 337 */     addParam(params, ParamType.GANG_QQ, qq, "0", true);
/* 338 */     addParam(params, ParamType.GANG_BING_QQ_TIME, Utils.formatTimestamp(DateTimeUtils.getCurrTimeInMillis()), "0", true);
/*     */     
/* 340 */     return reportScore(userid, bangZhuRoleId, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangMemberAbility(String userid, long roleid, long gangId, int value)
/*     */   {
/* 347 */     ReportScoreParams params = new ReportScoreParams();
/* 348 */     fillRoleNecessary(userid, roleid, params);
/* 349 */     fillGangNecessary(gangId, params);
/* 350 */     addParam(params, ParamType.GANG_MEMBER_ABILITY, String.valueOf(value), "0", true);
/* 351 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportRoleOnlineSeconds(String userid, long roleid, int seconds)
/*     */   {
/* 357 */     ReportScoreParams params = new ReportScoreParams();
/* 358 */     fillRoleNecessary(userid, roleid, params);
/* 359 */     addParam(params, ParamType.ONLINE_SECONDS, String.valueOf(seconds), "0", true);
/*     */     
/*     */ 
/* 362 */     addParam(params, ParamType.FIGHT_VALUE, String.valueOf(RoleInterface.getFightValue(roleid)), "0", true);
/* 363 */     long gangId = GangInterface.getGangId(roleid);
/* 364 */     if (gangId != 0L)
/*     */     {
/* 366 */       fillGangNecessary(gangId, params);
/* 367 */       addParam(params, ParamType.GANG_MEMBER_ABILITY, String.valueOf(RoleInterface.getRoleMFValue(roleid)), "0", true);
/*     */     }
/*     */     
/*     */ 
/* 371 */     return reportScore(userid, roleid, params.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\qq\ReporterImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */