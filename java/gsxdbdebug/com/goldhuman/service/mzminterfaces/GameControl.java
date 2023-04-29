/*     */ package com.goldhuman.service.mzminterfaces;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.PGMOnStartActivity;
/*     */ import mzm.gsp.activity.main.PGM_GetActivityState;
/*     */ import mzm.gsp.chart.main.PGM_SetSaveDBIntervalSec;
/*     */ import mzm.gsp.children.childhood.PGM_ClearChildCourse;
/*     */ import mzm.gsp.children.childhood.PGM_FullCourse;
/*     */ import mzm.gsp.config.main.ReloadCfgThread;
/*     */ import mzm.gsp.equipmentbless.main.PGM_SetBlessLevel;
/*     */ import mzm.gsp.feisheng.main.PGM_FeiShengOK;
/*     */ import mzm.gsp.fight.main.PGM_closeRoleFight;
/*     */ import mzm.gsp.gang.main.PGMAddGongXun;
/*     */ import mzm.gsp.gang.main.PGM_kickoutgang;
/*     */ import mzm.gsp.genius.main.PGM_AddGeniusPoint;
/*     */ import mzm.gsp.idip.main.PGMUnforbidRole;
/*     */ import mzm.gsp.idip.main.PGMUnforbidTalk;
/*     */ import mzm.gsp.item.main.PGM_ClearBag;
/*     */ import mzm.gsp.item.main.PGM_DeleteItem;
/*     */ import mzm.gsp.item.main.PGM_UseAllToken;
/*     */ import mzm.gsp.item.main.Pgm_Equipqilin;
/*     */ import mzm.gsp.item.main.Pgm_Lottery;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.main.PGM_Divorce;
/*     */ import mzm.gsp.multioccupation.main.PGM_ResetMultiOccupCoolDown;
/*     */ import mzm.gsp.online.main.LoginAssistManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.online.main.PGMForbidRole;
/*     */ import mzm.gsp.online.main.PGMForbidTalk;
/*     */ import mzm.gsp.online.main.PGM_ClearExtuteLoginQueue;
/*     */ import mzm.gsp.online.main.PGM_SetAccountNum;
/*     */ import mzm.gsp.online.main.PGM_SetAccountNumlimit;
/*     */ import mzm.gsp.online.main.PGM_SetIntervalLoginNum;
/*     */ import mzm.gsp.online.main.PGM_ShutDownServer;
/*     */ import mzm.gsp.partner.main.PGM_Apartner;
/*     */ import mzm.gsp.partner.main.PGM_RmAllOwnPartners;
/*     */ import mzm.gsp.partneryuanshen.main.PGM_SetYuanshen;
/*     */ import mzm.gsp.pet.main.PGM_AddSkillNumPet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.pet.main.a94f8e2038e9a01aae9f413cc841c65e;
/*     */ import mzm.gsp.pk.main.PGM_ResetPKTimes;
/*     */ import mzm.gsp.prison.main.PGM_Jail;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.PGMAddGold;
/*     */ import mzm.gsp.role.main.PGMAddSilver;
/*     */ import mzm.gsp.role.main.PGMSetBaoShiDu;
/*     */ import mzm.gsp.role.main.PGMSetRoleLevel;
/*     */ import mzm.gsp.role.main.PGM_AddExp;
/*     */ import mzm.gsp.role.main.PGM_CutExp;
/*     */ import mzm.gsp.role.main.PGM_addPoint;
/*     */ import mzm.gsp.role.main.PGMaddpoint;
/*     */ import mzm.gsp.role.main.PMGM_setfightvalue;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.Pgm_SetLevel;
/*     */ import mzm.gsp.task.surprise.PRestServerLevelTime;
/*     */ import mzm.gsp.title.main.PGM_AddAppellation;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import mzm.gsp.wing.main2.PGM_WingLevelTo;
/*     */ import mzm.gsp.yuanbao.main.PGM_AddBuyYuanBao;
/*     */ import mzm.gsp.yuanbao.main.PGM_CostBuyYuanBao;
/*     */ import mzm.gsp.zoo.main.PGM_ClearHatchDays;
/*     */ import xdb.Procedure;
/*     */ 
/*     */ public class GameControl extends GameControlMBeanRegister implements GameControlMBean
/*     */ {
/*     */   public void shutdownGs(Integer var1)
/*     */   {
/*  78 */     Procedure.execute(new PGM_ShutDownServer(var1.intValue()));
/*     */   }
/*     */   
/*     */   public void sendNotice(String var1) {
/*  82 */     mzm.gsp.bulletin.main.BulletinInterface.sendNotice(var1);
/*     */   }
/*     */   
/*     */   public void mailCompensate(String var1, String var2, int var3, int var4) {
/*  86 */     NoneRealTimeTaskManager.getInstance().addTask(new GameControl.1(this, var1, var2, var3, var4));
/*     */   }
/*     */   
/*     */   public void addPetSkill(long var1, int var3, int var4) {
/*  90 */     Procedure.execute(new a94f8e2038e9a01aae9f413cc841c65e(var1, var3, var4));
/*     */   }
/*     */   
/*     */   public long getRoleidByName(String var1) {
/*     */     try {
/*  95 */       var1 = URLDecoder.decode(var1, "UTF-8");
/*  96 */       return RoleInterface.getRoleIdByName(var1);
/*     */     } catch (UnsupportedEncodingException var3) {}
/*  98 */     return -1L;
/*     */   }
/*     */   
/*     */   public String getRoleName(long var1)
/*     */   {
/* 103 */     return RoleInterface.getName(var1);
/*     */   }
/*     */   
/*     */   public void wrnmmpkbdlb1(int var1) {
/* 107 */     ActivityInterface.forceOpenActivityForIDIP(var1);
/*     */   }
/*     */   
/*     */   public void wrnmmpkbdlb11(int var1) {
/* 111 */     ActivityInterface.closeActivityForIDIP(var1);
/*     */   }
/*     */   
/*     */   public int changeRoleName(long var1, String var3) {
/* 115 */     Integer[] var4 = new Integer[1];
/* 116 */     new GameControl.2(this, var4, var1).call();
/* 117 */     return var4[0].intValue();
/*     */   }
/*     */   
/*     */   public long directBufferSize() {
/*     */     try {
/* 122 */       Class var1 = Class.forName("java.nio.Bits");
/* 123 */       Field var2 = var1.getDeclaredField("reservedMemory");
/* 124 */       var2.setAccessible(true);
/* 125 */       return ((Long)var2.get(null)).longValue();
/*     */     } catch (Exception var3) {}
/* 127 */     return -1L;
/*     */   }
/*     */   
/*     */   public long outputDirectAllocation()
/*     */   {
/* 132 */     return Onlines.getInstance().getOutputAllocation();
/*     */   }
/*     */   
/*     */   public int noneRealTimeTaskNumber() {
/* 136 */     return NoneRealTimeTaskManager.getInstance().taskSize();
/*     */   }
/*     */   
/*     */   public void mailItemAward(long var1, String var3, String var4, int var5, int var6) {
/* 140 */     MailAttachment var7 = new MailAttachment();
/* 141 */     var7.addItem(var5, var6);
/* 142 */     MailInterface.asynBuildAndSendMail(var1, 1, var3, var4, var7, new TLogArg(LogReason.GM_ADD));
/*     */   }
/*     */   
/*     */   public void mailItemAward(long var1, String var3, String var4, Map<Integer, Integer> var5) {
/* 146 */     MailAttachment var6 = new MailAttachment();
/* 147 */     var6.addItemMap(var5);
/* 148 */     MailInterface.asynBuildAndSendMail(var1, 1, var3, var4, var6, new TLogArg(LogReason.GM_ADD));
/*     */   }
/*     */   
/*     */   public void loginThreshold(int var1) {
/* 152 */     Procedure.execute(new PGM_SetIntervalLoginNum(var1));
/*     */   }
/*     */   
/*     */   public void Divorce(long var1) {
/* 156 */     Procedure.execute(new PGM_Divorce(var1));
/*     */   }
/*     */   
/*     */   public void maxOnline(int var1) {
/* 160 */     Procedure.execute(new mzm.gsp.online.main.PGM_SetMaxPalyerNum(var1));
/*     */   }
/*     */   
/*     */   public void accountLimit(boolean var1) {
/* 164 */     Procedure.execute(new PGM_SetAccountNumlimit(var1));
/*     */   }
/*     */   
/*     */   public void GmAddGoldIngot(long var1, int var3) {
/* 168 */     Procedure.execute(new mzm.gsp.yuanbao.main.PGM_AddAwardYuanBao(var1, var3));
/*     */   }
/*     */   
/*     */   public long getPetId(long var1) {
/* 172 */     return PetInterface.getFightPetId(var1);
/*     */   }
/*     */   
/*     */   public void GmAddyb(long var1, long var3) {
/* 176 */     Procedure.execute(new PGM_AddBuyYuanBao(var1, var3));
/* 177 */     Procedure.execute(new mzm.gsp.qingfu.main.PGM_AddInnerSaveAmt(var1, var1, (int)var3));
/*     */   }
/*     */   
/*     */   public void setPetPoint(int var1, long var2, long var4, int var6) {
/* 181 */     Procedure.execute(new mzm.gsp.pet.main.f254b7737c623287802c4a4a8108c7e9(var1, var2, var4, var6));
/*     */   }
/*     */   
/*     */   public String GMsetzs(long var1, String var3) {
/* 185 */     String var4 = RoleInterface.getUserId(var1);
/* 186 */     String var5 = var4.substring(0, var4.indexOf("$"));
/* 187 */     if (var5.equals(var3)) {
/* 188 */       Procedure.execute(new PGMSetRoleLevel(var1, 1));
/* 189 */       return "ok";
/*     */     }
/* 191 */     return var5;
/*     */   }
/*     */   
/*     */   public void maxAccount(int var1)
/*     */   {
/* 196 */     Procedure.execute(new PGM_SetAccountNum(var1));
/*     */   }
/*     */   
/*     */   public void reLoadAllXml() {
/* 200 */     new ReloadCfgThread(true).start();
/*     */   }
/*     */   
/*     */   public void reLoadAllBny() {
/* 204 */     new ReloadCfgThread(true).start();
/*     */   }
/*     */   
/*     */   public void maxTaskPerRole(int var1) {
/* 208 */     OnlineManager.getInstance().setMaxTaskPerRole(var1);
/*     */   }
/*     */   
/*     */   public void setRankDBTimer(int var1) {
/* 212 */     Procedure.execute(new PGM_SetSaveDBIntervalSec(var1));
/*     */   }
/*     */   
/*     */   public int getMapMsgQueueSize() {
/* 216 */     return MapInterface.getMapMsgQueueSize();
/*     */   }
/*     */   
/*     */   public int getMapProtocolSendQueueSize() {
/* 220 */     return MapInterface.getMapProtocolSendQueueSize();
/*     */   }
/*     */   
/*     */   public void clearExcuteLoginQueue() {
/* 224 */     new PGM_ClearExtuteLoginQueue().execute();
/*     */   }
/*     */   
/*     */   public int getExcuteLoginQueueSize() {
/* 228 */     return LoginAssistManager.getInstance().getExcuteLoginSize();
/*     */   }
/*     */   
/*     */   public void setOpenActivityGm(int var1, long var2) {
/* 232 */     Procedure.execute(new PGMOnStartActivity(var1, var2));
/*     */   }
/*     */   
/*     */   public void setyinbi(long var1, long var3) {
/* 236 */     Procedure.execute(new mzm.gsp.role.main.PGM_SetSilver(var1, var3));
/*     */   }
/*     */   
/*     */   public void closeRoleFight(long var1, boolean var3) {
/* 240 */     Procedure.execute(new PGM_closeRoleFight(var1, var3));
/*     */   }
/*     */   
/*     */   public void bidtalk(long var1, long var3, int var5, int var6) {
/* 244 */     Procedure.execute(new PGMForbidTalk(var1, var3, var5, var6));
/*     */   }
/*     */   
/*     */   public void GmAddExp(long var1, int var3) {
/* 248 */     Procedure.execute(new PGM_AddExp(var1, var3));
/*     */   }
/*     */   
/*     */   public void GmSetBlessLevel(long var1, long var3, int var5, int var6, int var7) {
/* 252 */     Procedure.execute(new PGM_SetBlessLevel(var1, var3, var5, var6, var7));
/*     */   }
/*     */   
/*     */   public void setganglevel(long var1, int var3) {
/* 256 */     Procedure.execute(new mzm.gsp.gang.main.PGMSetGangLevel(var1, var3));
/*     */   }
/*     */   
/*     */   public void addgangmoney(long var1, int var3) {
/* 260 */     Procedure.execute(new mzm.gsp.gang.main.PGMAddGangMoney(var1, var3));
/*     */   }
/*     */   
/*     */   public void addgangvit(long var1, int var3) {
/* 264 */     Procedure.execute(new mzm.gsp.gang.main.PGMAddGangVitality(var1, var3));
/*     */   }
/*     */   
/*     */   public void addganggongxun(long var1, long var3, int var5) {
/* 268 */     Procedure.execute(new PGMAddGongXun(var1, var3, var5));
/*     */   }
/*     */   
/*     */   public void GmAddGold(long var1, int var3) {
/* 272 */     Procedure.execute(new PGMAddGold(var1, var3));
/*     */   }
/*     */   
/*     */   public void resetmultioccupcd(long var1, long var3) {
/* 276 */     Procedure.execute(new PGM_ResetMultiOccupCoolDown(var1, var3));
/*     */   }
/*     */   
/*     */   public void GmAddSilver(long var1, int var3) {
/* 280 */     Procedure.execute(new PGMAddSilver(var1, var3));
/*     */   }
/*     */   
/*     */   public void Gmsetlevel(long var1, int var3) {
/* 284 */     Procedure.execute(new PGMSetRoleLevel(var1, var3));
/*     */   }
/*     */   
/*     */   public void Gmcutexp(long var1, int var3) {
/* 288 */     Procedure.execute(new PGM_CutExp(var1, var3));
/*     */   }
/*     */   
/*     */   public void ClearHatchDays(long var1, long var3) {
/* 292 */     Procedure.execute(new PGM_ClearHatchDays(var1, var3));
/*     */   }
/*     */   
/*     */   public void clearbag(long var1, long var3, int var5) {
/* 296 */     Procedure.execute(new PGM_ClearBag(var1, var3, var5));
/*     */   }
/*     */   
/*     */   public void AddSkillNumPet(long var1, int var3, int var4) {
/* 300 */     Procedure.execute(new PGM_AddSkillNumPet(var1, var3, var4));
/*     */   }
/*     */   
/*     */   public void AddGeniusPoint(long var1, long var3, int var5) {
/* 304 */     Procedure.execute(new PGM_AddGeniusPoint(var1, var3, var5));
/*     */   }
/*     */   
/*     */   public void setsedata(long var1, long var3, int var5, int var6, int var7, int var8) {
/* 308 */     Procedure.execute(new mzm.gsp.superequipment.main.PGMSetSuperEquipmentData(var1, var3, var5, var6, var7, var8));
/*     */   }
/*     */   
/*     */   public void ResetPKTimes(long var1, long var3) {
/* 312 */     Procedure.execute(new PGM_ResetPKTimes(var1, var3));
/*     */   }
/*     */   
/*     */   public void Equipqilin(long var1, long var3, int var5, int var6, int var7) {
/* 316 */     Procedure.execute(new Pgm_Equipqilin(var1, var3, var5, var6, var7));
/*     */   }
/*     */   
/*     */   public void AddEquip(long var1, long var3, int var5, int var6) {
/* 320 */     Procedure.execute(new mzm.gsp.item.main.PGM_AddEquip(var1, var3, var5, var6));
/*     */   }
/*     */   
/*     */   public void setfightvalue(long var1, int var3) {
/* 324 */     Procedure.execute(new PMGM_setfightvalue(var1, var3));
/*     */   }
/*     */   
/*     */   public void initserverlevelinfo(long var1, String var3) {
/* 328 */     Procedure.execute(new PRestServerLevelTime(var1, var3));
/*     */   }
/*     */   
/*     */   public void GmSetYuanshen(long var1, long var3, int var5, int var6, int var7) {
/* 332 */     Procedure.execute(new PGM_SetYuanshen(var1, var3, var5, var6, var7));
/*     */   }
/*     */   
/*     */   public void GmJail(long var1, long var3) {
/* 336 */     Procedure.execute(new PGM_Jail(var1, var3));
/*     */   }
/*     */   
/*     */   public void GmUnJail(long var1, long var3) {
/* 340 */     Procedure.execute(new mzm.gsp.prison.main.PGM_UnJail(var1, var3));
/*     */   }
/*     */   
/*     */   public void AddChildren(long var1, int var3) {
/* 344 */     Procedure.execute(new mzm.gsp.children.main.PGM_AddChildren(var1, var3));
/*     */   }
/*     */   
/*     */   public void Apartner(long var1, int var3) {
/* 348 */     Procedure.execute(new PGM_Apartner(var1, var3));
/*     */   }
/*     */   
/*     */   public void addpoint(long var1, int var3) {
/* 352 */     Procedure.execute(new PGMaddpoint(var1, var3));
/*     */   }
/*     */   
/*     */   public void AddChildHealth(long var1, long var3, int var5) {
/* 356 */     Procedure.execute(new mzm.gsp.children.main.PGM_AddChildHealth(var1, var3, var5));
/*     */   }
/*     */   
/*     */   public void rmallpartner(long var1) {
/* 360 */     Procedure.execute(new PGM_RmAllOwnPartners(var1));
/*     */   }
/*     */   
/*     */   public void FullCourse(long var1, long var3, long var5) {
/* 364 */     Procedure.execute(new PGM_FullCourse(var1, var3, var5));
/*     */   }
/*     */   
/*     */   public void ClearChildTired(long var1, long var3) {
/* 368 */     Procedure.execute(new mzm.gsp.children.main.PGM_ClearChildTired(var1, var3));
/*     */   }
/*     */   
/*     */   public void cleardailycourse(long var1, long var3, long var5) {
/* 372 */     Procedure.execute(new PGM_ClearChildCourse(var1, var3, var5));
/*     */   }
/*     */   
/*     */   public void GetActivityState(long var1, int var3) {
/* 376 */     Procedure.execute(new PGM_GetActivityState(var1, var3));
/*     */   }
/*     */   
/*     */   public void Lottery(long var1, int var3) {
/* 380 */     Procedure.execute(new Pgm_Lottery(var1, var3));
/*     */   }
/*     */   
/*     */   public void addchengwei(long var1, int var3) {
/* 384 */     Procedure.execute(new PGM_AddAppellation(var1, var3));
/*     */   }
/*     */   
/*     */   public void setbaoshidu(long var1, int var3) {
/* 388 */     Procedure.execute(new PGMSetBaoShiDu(var1, var3));
/*     */   }
/*     */   
/*     */   public void atitle(long var1, int var3) {
/* 392 */     Procedure.execute(new mzm.gsp.title.main.PGM_AddTitle(var1, var3));
/*     */   }
/*     */   
/*     */   public void SetServerLevel(int var1, String var2) {
/* 396 */     Procedure.execute(new Pgm_SetLevel(var1, var2));
/*     */   }
/*     */   
/*     */   public void SetFeiSheng(long var1, long var3, int var5) {
/* 400 */     Procedure.execute(new PGM_FeiShengOK(var1, var3, var5));
/*     */   }
/*     */   
/*     */   public void winglevelto(long var1, long var3, int var5) {
/* 404 */     Procedure.execute(new PGM_WingLevelTo(var1, var3, var5));
/*     */   }
/*     */   
/*     */   public void SetServerDate(String var1, long var2) {
/* 408 */     GameServerInfoManager.setDateForGM(var1, var2);
/*     */   }
/*     */   
/*     */   public void KickOutUser(long var1, long var3, long var5) {
/* 412 */     Procedure.execute(new PGM_kickoutgang(var1, var3, var5));
/*     */   }
/*     */   
/*     */   public void ResetMultiOccup(long var1, long var3) {
/* 416 */     Procedure.execute(new PGM_ResetMultiOccupCoolDown(var1, var3));
/*     */   }
/*     */   
/*     */   public void ForbidRole(long var1, int var3, String var4) {
/* 420 */     Procedure.execute(new PGMForbidRole(var1, var3, var4));
/*     */   }
/*     */   
/*     */   public void UnforbidRole(long var1, long var3) {
/* 424 */     Procedure.execute(new PGMUnforbidRole(var1, var3));
/*     */   }
/*     */   
/*     */   public void forbiduser(long var1, int var3, String var4) {
/* 428 */     Procedure.execute(new mzm.gsp.idip.main.PGMForbidUser(var1, var3, var4));
/*     */   }
/*     */   
/*     */   public void unforbiduser(long var1, long var3) {
/* 432 */     Procedure.execute(new mzm.gsp.idip.main.PGMUnforbidUser(var1, var3));
/*     */   }
/*     */   
/*     */   public void unbidtalk(long var1, long var3) {
/* 436 */     Procedure.execute(new PGMUnforbidTalk(var1, var3));
/*     */   }
/*     */   
/*     */   public long getLevel(long var1) {
/* 440 */     return RoleInterface.getLevel(var1);
/*     */   }
/*     */   
/*     */   public long getMoney(long var1) {
/* 444 */     String var3 = RoleInterface.getUserId(var1);
/* 445 */     long var4 = QingfuInterface.getYuanbao(var3, false);
/* 446 */     long var6 = QingfuInterface.getBindYuanbao(var3, false);
/* 447 */     return var4 + var6;
/*     */   }
/*     */   
/*     */   public void CostBuyYuanBao(long var1, long var3) {
/* 451 */     Procedure.execute(new PGM_CostBuyYuanBao(var1, var3));
/*     */   }
/*     */   
/*     */   public void setOnlineTime(int var1) {
/* 455 */     mzm.gsp.online.main.OnlineUsers.time = var1;
/*     */   }
/*     */   
/*     */   public void setOnlineItem(int var1, int var2) {
/* 459 */     mzm.gsp.online.main.OnlineUsers.itemid = var1;
/* 460 */     mzm.gsp.online.main.OnlineUsers.count = var2;
/*     */   }
/*     */   
/*     */   public void setOnlineYuanbao(int var1) {
/* 464 */     mzm.gsp.online.main.OnlineUsers.yuanbao = var1;
/*     */   }
/*     */   
/*     */   public void deleteItem(long var1, int var3, int var4, int var5, int var6) {
/* 468 */     Procedure.execute(new PGM_DeleteItem(var1, var3, var4, var5, var6));
/*     */   }
/*     */   
/*     */   public void chuansong(long roleid, int mapCfgid, int targetPosX, int targetPosY) {
/* 472 */     Procedure.execute(new mzm.gsp.map.main.PTransformMapReq(roleid, mapCfgid, targetPosX, targetPosY));
/*     */   }
/*     */   
/* 475 */   public void qxcs(long roleid, int mapCfgid) { Procedure.execute(new mzm.gsp.paraselene.main.Pgm_Transferto(roleid, mapCfgid)); }
/*     */   
/*     */   public void addrolepoint(long roleId, int point) {
/* 478 */     Procedure.execute(new PGM_addPoint(roleId, point));
/*     */   }
/*     */   
/*     */   public void Quickuseitems(long roleId, int ItemId, int num, int TokenType, int Token) {
/* 482 */     Procedure.execute(new PGM_UseAllToken(roleId, ItemId, num, TokenType, Token));
/*     */   }
/*     */   
/* 485 */   public void addzcjf(long targetRoleId, long gmRoleId, int tokenType, int count) { Procedure.execute(new mzm.gsp.activitypointexchange.main.PGM_ModifyDaiBi(targetRoleId, gmRoleId, tokenType, count)); }
/*     */   
/*     */ 
/*     */ 
/* 489 */   public String getUserId(long roleid) { return RoleInterface.getUserId(roleid); }
/*     */   
/*     */   public String getUserRoleList(long roleid) {
/* 492 */     String userId = RoleInterface.getUserId(roleid);
/* 493 */     return RoleInterface.getRoleList(userId);
/*     */   }
/*     */   
/* 496 */   public String GetRoleList(String id) { return RoleInterface.getRoleList(id); }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\com\goldhuman\service\mzminterfaces\GameControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */