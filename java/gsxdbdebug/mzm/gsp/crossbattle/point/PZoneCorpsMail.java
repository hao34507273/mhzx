/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.main.CorpsInfo;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleZoneCfg;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.mail.main.SendMailRet;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PZoneCorpsMail extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final long corpsid;
/*    */   private final int zone;
/*    */   
/*    */   public PZoneCorpsMail(int activityCfgid, long corpsid, int zone)
/*    */   {
/* 27 */     this.activityCfgid = activityCfgid;
/* 28 */     this.corpsid = corpsid;
/* 29 */     this.zone = zone;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 36 */     SCrossBattleZoneCfg cfg = SCrossBattleZoneCfg.get(this.zone);
/* 37 */     if (cfg == null)
/*    */     {
/* 39 */       GameServer.logger().error(String.format("[crossbattlepoint]PZoneCorpsMail.processImp@cfg is null|corpsid=%d|zone=%d", new Object[] { Long.valueOf(this.corpsid), Integer.valueOf(this.zone) }));
/*    */       
/*    */ 
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     SCrossBattleDrawLotsCfg crossBattleDrawLotsCfg = SCrossBattleDrawLotsCfg.get(this.activityCfgid);
/* 46 */     if (crossBattleDrawLotsCfg == null)
/*    */     {
/* 48 */       GameServer.logger().error(String.format("[crossbattlepoint]PZoneCorpsMail.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */       
/* 50 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 54 */     if (!CrossBattlePointManager.isFunOpen(crossBattleDrawLotsCfg.activitySwitch, crossBattleDrawLotsCfg.funSwitch))
/*    */     {
/* 56 */       GameServer.logger().error(String.format("[crossbattlepoint]PZoneCorpsMail.processImp@fun not open|corpsid=%d", new Object[] { Long.valueOf(this.corpsid) }));
/*    */       
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByCorpsId(this.corpsid, false);
/* 62 */     if (corpsInfo == null)
/*    */     {
/* 64 */       GameServer.logger().error(String.format("[crossbattlepoint]PZoneCorpsMail.processImp@corps info is null|corpsid=%d", new Object[] { Long.valueOf(this.corpsid) }));
/*    */       
/* 66 */       return false;
/*    */     }
/*    */     
/* 69 */     Set<Long> memebers = corpsInfo.getAllMemberIds();
/* 70 */     lock(Lockeys.get(Basic.getTable(), memebers));
/*    */     
/* 72 */     int mailCfgid = crossBattleDrawLotsCfg.zoneMailCfgid;
/* 73 */     TLogArg tLogArg = new TLogArg(LogReason.CROSS_BATTLE_POINT_ZONE_MAIL);
/* 74 */     List<String> contentArgs = new ArrayList();
/* 75 */     contentArgs.add(cfg.name);
/* 76 */     for (Iterator i$ = memebers.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 78 */       SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, mailCfgid, null, contentArgs, tLogArg);
/* 79 */       if (!sendMailRet.isOK())
/*    */       {
/* 81 */         GameServer.logger().error(String.format("[crossbattlepoint]PZoneCorpsMail.processImp@send mail fail|corpsid=%d|roleid=%d|mail_cfgid=%d|zone=%d", new Object[] { Long.valueOf(this.corpsid), Long.valueOf(roleid), Integer.valueOf(mailCfgid), Integer.valueOf(this.zone) }));
/*    */         
/*    */ 
/*    */ 
/* 85 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 90 */     CrossBattlePointManager.syncPointRaceStage(memebers, this.zone, 1, (byte)0, -1, 0L);
/*    */     
/* 92 */     GameServer.logger().info(String.format("[crossbattlepoint]PZoneCorpsMail.processImp@send mail success|corpsid=%d|mail_cfgid=%d|zone=%d", new Object[] { Long.valueOf(this.corpsid), Integer.valueOf(mailCfgid), Integer.valueOf(this.zone) }));
/*    */     
/*    */ 
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PZoneCorpsMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */