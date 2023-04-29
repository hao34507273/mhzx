/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.grc.SGetRecallFriendSignAwardInfoSuccess;
/*     */ import mzm.gsp.grc.SRecallFriendNormalFail;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BeRecalledBackGameInfo;
/*     */ import xbean.RecallFriendBackGame;
/*     */ import xdb.Lockeys;
/*     */ 
/*     */ public class PCGetRecallFriendSignAwardInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetRecallFriendSignAwardInfo(long roleId)
/*     */   {
/*  24 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!RecallFriendManager.checkMutexStatus(this.roleId))
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     if (!RecallFriendManager.isRecallFriendSwitchOpen(this.roleId, true))
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     String userId = RoleInterface.getUserId(this.roleId);
/*  41 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  43 */     xbean.User xUser = xtable.User.get(userId);
/*     */     
/*  45 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/*  46 */     BeRecalledBackGameInfo xBeRecallBackGameInfo = xRecallFriendBackGame.getBe_recalled_back_game();
/*     */     
/*  48 */     long xBackGameTime = xBeRecallBackGameInfo.getBack_game_time();
/*  49 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*  52 */     long deltaDay = (currentTimeMillis - DateTimeUtils.getBeginTimeOfCurrDay(xBackGameTime)) / 86400000L;
/*     */     
/*     */ 
/*  55 */     if (deltaDay >= SRecallFriendSignAwardCfg.getAll().size())
/*     */     {
/*  57 */       GameServer.logger().info(String.format("[recall]PCGetRecallFriendSignAwardInfo.processImp@recall sign award expired|user_id=%s|role_id=%d|delta_day=%d", new Object[] { userId, Long.valueOf(this.roleId), Long.valueOf(deltaDay) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  62 */       SRecallFriendNormalFail sRecallFriendNormalFail = new SRecallFriendNormalFail();
/*  63 */       sRecallFriendNormalFail.result = 8;
/*     */       
/*  65 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sRecallFriendNormalFail);
/*     */       
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     SGetRecallFriendSignAwardInfoSuccess getSignAwardInfoSuccess = new SGetRecallFriendSignAwardInfoSuccess();
/*  71 */     Map<Integer, Integer> signAwardInfoMap = getSignAwardInfoSuccess.sign_award_state_map;
/*     */     
/*  73 */     Set<Integer> xSignAwardedDaySet = xBeRecallBackGameInfo.getSign_awarded_day_set();
/*  74 */     for (Iterator i$ = SRecallFriendSignAwardCfg.getAll().keySet().iterator(); i$.hasNext();) { int signDay = ((Integer)i$.next()).intValue();
/*     */       
/*  76 */       if (xSignAwardedDaySet.contains(Integer.valueOf(signDay)))
/*     */       {
/*  78 */         signAwardInfoMap.put(Integer.valueOf(signDay), Integer.valueOf(3));
/*     */ 
/*     */ 
/*     */       }
/*  82 */       else if (signDay <= deltaDay)
/*     */       {
/*  84 */         signAwardInfoMap.put(Integer.valueOf(signDay), Integer.valueOf(1));
/*     */ 
/*     */ 
/*     */       }
/*  88 */       else if (signDay == deltaDay + 1L)
/*     */       {
/*  90 */         signAwardInfoMap.put(Integer.valueOf(signDay), Integer.valueOf(0));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  95 */         signAwardInfoMap.put(Integer.valueOf(signDay), Integer.valueOf(2));
/*     */       }
/*     */     }
/*  98 */     OnlineManager.getInstance().send(this.roleId, getSignAwardInfoSuccess);
/*     */     
/* 100 */     GameServer.logger().info(String.format("[recall]PCGetRecallFriendSignAwardInfo.processImp|role_id=%d|sign_info=%s", new Object[] { Long.valueOf(this.roleId), signAwardInfoMap.toString() }));
/*     */     
/*     */ 
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetRecallFriendSignAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */