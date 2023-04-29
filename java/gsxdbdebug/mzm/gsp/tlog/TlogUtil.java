/*     */ package mzm.gsp.tlog;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import java.text.SimpleDateFormat;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.UuidUtils;
/*     */ import mzm.gsp.util.UuidUtils.UuidType;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TlogUtil
/*     */ {
/*     */   private static final String SnsFlow = "SnsFlow";
/*     */   private static final String GameSvrState = "GameSvrState";
/*     */   
/*     */   public static CurrencyType getCurrencyTypeByTokentype(int tokentype)
/*     */   {
/*  26 */     switch (tokentype)
/*     */     {
/*     */     case 2: 
/*  29 */       return CurrencyType.CURRENCY_JINJI;
/*     */     case 4: 
/*  31 */       return CurrencyType.CURRENCY_SHENGWANG;
/*     */     case 1: 
/*  33 */       return CurrencyType.CURRENCY_XIAYI;
/*     */     case 3: 
/*  35 */       return CurrencyType.CURRENCY_SHIMEN;
/*     */     case 5: 
/*  37 */       return CurrencyType.CURRENCY_LADDER_JIFEN;
/*     */     case 6: 
/*  39 */       return CurrencyType.CURRENCY_SINGLE_CROSS_FIELD_SCORE;
/*     */     case 7: 
/*  41 */       return CurrencyType.CURRENCY_MORAL_VALUE;
/*     */     case 8: 
/*  43 */       return CurrencyType.CURRENCY_XIAO_HUI_KUAI_PAO_POINT;
/*     */     case 9: 
/*  45 */       return CurrencyType.CURRENCY_CARD_ESSENCE;
/*     */     case 10: 
/*  47 */       return CurrencyType.CURRENCY_CARD_SCORE;
/*     */     case 11: 
/*  49 */       return CurrencyType.CURRENCY_BACK_GAME_ACTIVITY_POINT;
/*     */     case 12: 
/*  51 */       return CurrencyType.CURRENCY_XIAO_HUI_KUAI_PAO_COMPENSATE_POINT;
/*     */     case 13: 
/*  53 */       return CurrencyType.CURRENCY_BANDSTAND_SCORE;
/*     */     case 14: 
/*  55 */       return CurrencyType.CURRENCY_PET_FIGHT_SCORE;
/*     */     case 15: 
/*  57 */       return CurrencyType.CURRENCY_PET_MARK_SCORE1;
/*     */     case 16: 
/*  59 */       return CurrencyType.CURRENCY_PET_MARK_SCORE2;
/*     */     case 17: 
/*  61 */       return CurrencyType.CURRENCY_DRAW_CARNIVAL_POINT;
/*     */     }
/*  63 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long generateSequence()
/*     */   {
/*  74 */     return UuidUtils.generateUuid(UuidUtils.UuidType.TLOG_SEQUENCE);
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
/*     */ 
/*     */   public static void tlogSnsFlow(long roleid, int RecNum, int count, SnsFlowArg snsFlowArg)
/*     */   {
/*  92 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/*  94 */     tlogSnsFlow(userid, roleid, RecNum, count, snsFlowArg);
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
/*     */   public static void tlogSnsFlow(String userid, long roleid, int RecNum, int count, SnsFlowArg snsFlowArg)
/*     */   {
/* 111 */     String GameSvrId = GameServerInfoManager.getZoneId() + "";
/*     */     
/* 113 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */     
/* 115 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 116 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 118 */     String vGameAppid = Onlines.getInstance().findGameAppid(userid);
/* 119 */     int PlatID = Onlines.getInstance().findPlatid(userid);
/* 120 */     int iZoneAreaID = GameServerInfoManager.getZoneidFromUserid(userid);
/*     */     
/* 122 */     String ActorOpenID = roleid + "";
/*     */     
/* 124 */     Object[] columnns = { GameSvrId, dtEventTime, vGameAppid, Integer.valueOf(PlatID), Integer.valueOf(iZoneAreaID), ActorOpenID, Integer.valueOf(RecNum), Integer.valueOf(count), Integer.valueOf(snsFlowArg.type.value), Integer.valueOf(snsFlowArg.subtype) };
/*     */     
/*     */ 
/* 127 */     TLogManager.getInstance().addLog("SnsFlow", columnns);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogGameSvrState()
/*     */   {
/* 138 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 139 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 140 */     String dtEventTime = sdf.format(Long.valueOf(time));
/* 141 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 142 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*     */     
/* 144 */     Object[] columns = { dtEventTime, vGameIP, Integer.valueOf(iZoneAreaID) };
/*     */     
/* 146 */     TLogManager.getInstance().addLogAtOnce("GameSvrState", columns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tlog\TlogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */