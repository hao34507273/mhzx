/*     */ package mzm.gsp.alllotto.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoTurnInfo;
/*     */ import mzm.gsp.alllotto.event.RoleGetALLLottoAward;
/*     */ import mzm.gsp.alllotto.event.RoleGetALLLottoAwardArg;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllLottoAwardRoleInfo;
/*     */ import xbean.AllLottoInfo;
/*     */ import xbean.AllLottoTurnInfo;
/*     */ import xtable.All_lotto_infos;
/*     */ 
/*     */ public class PCheckAndGetAwardRoleInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCheckAndGetAwardRoleInfo(int activityCfgid)
/*     */   {
/*  30 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     SAllLottoCfg cfg = SAllLottoCfg.get(this.activityCfgid);
/*  37 */     if (cfg == null)
/*     */     {
/*     */ 
/*  40 */       return false;
/*     */     }
/*  42 */     List<Integer> turns = new ArrayList();
/*  43 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  45 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  46 */     lock(All_lotto_infos.getTable(), Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*  47 */     AllLottoInfo xAllLottoInfo = All_lotto_infos.get(Long.valueOf(globalActivityCfgid));
/*  48 */     if (xAllLottoInfo == null)
/*     */     {
/*  50 */       xAllLottoInfo = xbean.Pod.newAllLottoInfo();
/*  51 */       All_lotto_infos.insert(Long.valueOf(globalActivityCfgid), xAllLottoInfo);
/*     */     }
/*  53 */     for (Map.Entry<Integer, SAllLottoTurnInfo> entry : cfg.turn_infos.entrySet())
/*     */     {
/*  55 */       int turn = ((Integer)entry.getKey()).intValue();
/*  56 */       SAllLottoTurnInfo turnInfo = (SAllLottoTurnInfo)entry.getValue();
/*  57 */       AllLottoTurnInfo xAllLottoTurnInfo = (AllLottoTurnInfo)xAllLottoInfo.getTurn_infos().get(Integer.valueOf(turn));
/*  58 */       if (xAllLottoTurnInfo != null)
/*     */       {
/*  60 */         for (AllLottoAwardRoleInfo xAllLottoAwardRoleInfo : xAllLottoTurnInfo.getAward_role_infos())
/*     */         {
/*  62 */           if (GameServerInfoManager.isRoleInOwnServer(xAllLottoAwardRoleInfo.getRoleid()))
/*     */           {
/*  64 */             TriggerEventsManger.getInstance().triggerEvent(new RoleGetALLLottoAward(), new RoleGetALLLottoAwardArg(this.activityCfgid, turn, xAllLottoAwardRoleInfo.getRoleid()));
/*     */ 
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       }
/*  71 */       else if (currTimeInMillis - turnInfo.timestamp * 1000L > AllLottoManager.TURN_PROTECT_DURATION_IN_SECOND * 1000L)
/*     */       {
/*     */ 
/*     */ 
/*  75 */         turns.add(Integer.valueOf(turn));
/*     */       }
/*     */     }
/*     */     
/*  79 */     new Session(AllLottoManager.GRC_MIN_DELAY_IN_SECOND + xdb.Xdb.random().nextInt(AllLottoManager.GRC_MAX_DELAY_IN_SECOND - AllLottoManager.GRC_MIN_DELAY_IN_SECOND), 0L)
/*     */     {
/*     */ 
/*     */ 
/*     */       protected void onTimeOut()
/*     */       {
/*     */ 
/*  86 */         if (!GrcInterface.getAllLottoAwardRoleInfo(PCheckAndGetAwardRoleInfo.this.activityCfgid, this.val$turns))
/*     */         {
/*  88 */           GameServer.logger().info(String.format("[alllotto]PCheckAndGetAwardRoleInfo.Session.onTimeOut@communication error|activity_cfg_id=%d|turns=%s", new Object[] { Integer.valueOf(PCheckAndGetAwardRoleInfo.this.activityCfgid), this.val$turns.toString() }));
/*     */ 
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */ 
/*  95 */     };
/*  96 */     GameServer.logger().info(String.format("[alllotto]PCheckAndGetAwardRoleInfo.processImp@check and get award role info success|activity_cfg_id=%d|turns=%s", new Object[] { Integer.valueOf(this.activityCfgid), turns.toString() }));
/*     */     
/*     */ 
/*     */ 
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\PCheckAndGetAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */