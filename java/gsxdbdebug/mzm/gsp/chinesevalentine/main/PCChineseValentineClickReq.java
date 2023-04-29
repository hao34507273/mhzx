/*     */ package mzm.gsp.chinesevalentine.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chinesevalentine.SChineseValentineClickErrorRep;
/*     */ import mzm.gsp.chinesevalentine.SNotifyChineseValentineClick;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.ChineseValentineCage;
/*     */ import xbean.ChineseValentineGame;
/*     */ import xbean.ChineseValentineRound;
/*     */ import xtable.Basic;
/*     */ import xtable.Chinesevalentine;
/*     */ 
/*     */ public class PCChineseValentineClickReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int index;
/*     */   
/*     */   public PCChineseValentineClickReq(long roleId, int index)
/*     */   {
/*  24 */     this.roleId = roleId;
/*  25 */     this.index = index;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!ChineseValentineManager.isOpen(this.roleId)) {
/*  32 */       sendError(3);
/*  33 */       return false;
/*     */     }
/*  35 */     Long gameId = xtable.Role2chinesevalentine.select(Long.valueOf(this.roleId));
/*  36 */     if (gameId == null) {
/*  37 */       return false;
/*     */     }
/*  39 */     ChineseValentineGame xGameTmp = Chinesevalentine.select(gameId);
/*  40 */     if (xGameTmp == null) {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     List<Long> roleIdList = xGameTmp.getRoleidlist();
/*  45 */     Map<Long, String> roleId2Userid = new HashMap();
/*  46 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*  47 */       roleId2Userid.put(Long.valueOf(tmpRoleId), mzm.gsp.role.main.RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  50 */     lock(xtable.User.getTable(), roleId2Userid.values());
/*  51 */     lock(Basic.getTable(), roleIdList);
/*     */     
/*     */ 
/*  54 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCansetStatus(roleIdList, 1761, true, true)) {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     int roleIdIndex = -1;
/*  60 */     for (int i = 0; i < roleIdList.size(); i++) {
/*  61 */       if (((Long)roleIdList.get(i)).longValue() == this.roleId) {
/*  62 */         roleIdIndex = i;
/*  63 */         break;
/*     */       }
/*     */     }
/*  66 */     if (roleIdIndex == -1) {
/*  67 */       return false;
/*     */     }
/*  69 */     ChineseValentineGame xGame = Chinesevalentine.get(gameId);
/*  70 */     if (xGame == null) {
/*  71 */       return false;
/*     */     }
/*  73 */     ChineseValentineRound xRound = xGame.getRoundinfo();
/*  74 */     if (xRound.getState() != 1)
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     ChineseValentineCage xCageInfo = (ChineseValentineCage)xRound.getCageinfolist().get(roleIdIndex);
/*  80 */     if (xCageInfo.getPressindex() == this.index) {
/*  81 */       return false;
/*     */     }
/*  83 */     if (xCageInfo.getHighlightindex() != this.index) {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     xCageInfo.setPressindex(this.index);
/*  88 */     xCageInfo.setPresstime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*  90 */     GameServer.logger().info(String.format("[chinesevalentine]PCChineseValentineClickReq.processImp@clicked|gameid=%d|roleid=%d|highlight=%d|click=%d", new Object[] { gameId, Long.valueOf(this.roleId), Integer.valueOf(xCageInfo.getHighlightindex()), Integer.valueOf(xCageInfo.getPressindex()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */     SNotifyChineseValentineClick notifyProtocol = new SNotifyChineseValentineClick();
/*  98 */     notifyProtocol.roleid = this.roleId;
/*  99 */     OnlineManager.getInstance().sendMulti(notifyProtocol, roleIdList);
/*     */     
/*     */ 
/* 102 */     List<ChineseValentineCage> xCageList = xRound.getCageinfolist();
/* 103 */     boolean isAllClicked = true;
/* 104 */     for (int i = 0; i < xCageList.size(); i++) {
/* 105 */       ChineseValentineCage xCage = (ChineseValentineCage)xCageList.get(i);
/* 106 */       if (xCage.getPresstime() == 0L) {
/* 107 */         isAllClicked = false;
/* 108 */         break;
/*     */       }
/*     */     }
/*     */     
/* 112 */     if (isAllClicked)
/*     */     {
/* 114 */       long sessionId = xRound.getSessionid();
/* 115 */       xRound.setSessionid(0L);
/* 116 */       if (sessionId != 0L) {
/* 117 */         mzm.gsp.timer.main.MilliSession.removeSession(sessionId);
/*     */       }
/*     */       
/* 120 */       ChineseValentineManager.startSettlement(gameId.longValue());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   protected void sendError(int code) {
/* 129 */     SChineseValentineClickErrorRep protocol = new SChineseValentineClickErrorRep(code);
/* 130 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\PCChineseValentineClickReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */