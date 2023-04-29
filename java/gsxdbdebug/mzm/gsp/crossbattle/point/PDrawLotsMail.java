/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleStageDurationCfg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossbattleDrawLots;
/*     */ import xbean.DrawLotsZoneInfo;
/*     */ 
/*     */ public class PDrawLotsMail extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long corpsid;
/*     */   private final int activityCfgid;
/*     */   private final int mailCfgid;
/*     */   
/*     */   public PDrawLotsMail(long corpsid, int activityCfgid, int mailCfgid)
/*     */   {
/*  25 */     this.corpsid = corpsid;
/*  26 */     this.activityCfgid = activityCfgid;
/*  27 */     this.mailCfgid = mailCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     SCrossBattleDrawLotsCfg cfg = SCrossBattleDrawLotsCfg.get(this.activityCfgid);
/*  34 */     if (cfg == null)
/*     */     {
/*  36 */       GameServer.logger().error(String.format("[crossbattlepoint]PDrawLotsMail.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     SCrossBattleStageDurationCfg stageDurationCfg = SCrossBattleStageDurationCfg.get(this.activityCfgid);
/*  43 */     if (stageDurationCfg == null)
/*     */     {
/*  45 */       GameServer.logger().error(String.format("[crossbattlepoint]PDrawLotsMail.processImp@stage duration cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     if (!CrossBattlePointManager.isFunOpen(cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  54 */       GameServer.logger().error(String.format("[crossbattlepoint]PDrawLotsMail.processImp@fun not open|corps=%d", new Object[] { Long.valueOf(this.corpsid) }));
/*     */       
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByCorpsId(this.corpsid, false);
/*  60 */     if (corpsInfo == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[crossbattlepoint]PDrawLotsMail.processImp@corps info is null|corps=%d", new Object[] { Long.valueOf(this.corpsid) }));
/*     */       
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     long roleid = corpsInfo.getCaptain();
/*     */     
/*  69 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.CROSS_BATTLE_POINT_DRAW_LOTS_MAIL);
/*     */     
/*  71 */     List<String> contentArgs = new ArrayList();
/*  72 */     int days = stageDurationCfg.zoneDivideStageDurationInDay;
/*  73 */     contentArgs.add(String.valueOf(days));
/*     */     
/*  75 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, this.mailCfgid, null, contentArgs, tLogArg);
/*  76 */     if (!sendMailRet.isOK())
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[crossbattlepoint]PDrawLotsMail.processImp@send mail fail|corps=%d|activity_cfgid=%d|mail_cfgid=%d|roleid=%d", new Object[] { Long.valueOf(this.corpsid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.mailCfgid), Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     CrossbattleDrawLots xCrossbattleDrawLots = CrossBattlePointManager.getAndInitCrossbattleDrawLots(this.activityCfgid);
/*  86 */     if (xCrossbattleDrawLots == null)
/*     */     {
/*  88 */       GameServer.logger().error(String.format("[crossbattlepoint]PDrawLotsMail.processImp@system error|corps=%d|activity_cfgid=%d|roleid=%d", new Object[] { Long.valueOf(this.corpsid), Integer.valueOf(this.activityCfgid), Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xCrossbattleDrawLots.getCorps().get(Long.valueOf(this.corpsid));
/*  97 */     if (xDrawLotsZoneInfo == null)
/*     */     {
/*  99 */       xDrawLotsZoneInfo = xbean.Pod.newDrawLotsZoneInfo();
/* 100 */       xCrossbattleDrawLots.getCorps().put(Long.valueOf(this.corpsid), xDrawLotsZoneInfo);
/*     */     }
/* 102 */     xDrawLotsZoneInfo.setMailed(1);
/*     */     
/* 104 */     GameServer.logger().info(String.format("[crossbattlepoint]PDrawLotsMail.processImp@send mail success|corps=%d|activity_cfgid=%d|mail_cfgid=%d|roleid=%d", new Object[] { Long.valueOf(this.corpsid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.mailCfgid), Long.valueOf(roleid) }));
/*     */     
/*     */ 
/*     */ 
/* 108 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PDrawLotsMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */