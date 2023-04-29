/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.SGetDailyGiftFailed;
/*     */ import mzm.gsp.qingfu.SGetDailyGiftSuccess;
/*     */ import mzm.gsp.qingfu.confbean.SDailyGiftConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DailyGiftInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ import xtable.User2dailygift;
/*     */ 
/*     */ public class PCGetDailyGift extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private String userid;
/*     */   
/*     */   public PCGetDailyGift(long roleid)
/*     */   {
/*  33 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!DailyGiftManager.isFunOpen(this.roleid))
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!DailyGiftManager.canDoAction(this.roleid, 511))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     this.userid = RoleInterface.getUserId(this.roleid);
/*  50 */     if (this.userid == null)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     lock(Lockeys.get(User.getTable(), this.userid));
/*  57 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  59 */     if (ItemInterface.isBagFull(this.roleid, 340600000, true))
/*     */     {
/*  61 */       onFailed(-2);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     DailyGiftInfo xDailyGiftInfo = User2dailygift.get(this.userid);
/*  66 */     if (xDailyGiftInfo == null)
/*     */     {
/*  68 */       GameServer.logger().error(String.format("[qingfu]PCGetDailyGift.processImp@xbean is null|userid=%s|roleid=%d", new Object[] { this.userid, Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     long receiveTime = xDailyGiftInfo.getReceive_time();
/*  75 */     if (!DailyGiftManager.canReceive(receiveTime))
/*     */     {
/*  77 */       Map<String, Object> extras = new HashMap();
/*  78 */       extras.put("receive_time", Long.valueOf(receiveTime));
/*     */       
/*  80 */       onFailed(-1);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     xDailyGiftInfo.setReceive_time(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*     */ 
/*  88 */     int awardCfgid = SDailyGiftConsts.getInstance().DAYLY_GIFT_AWARD_CFG_ID;
/*  89 */     LogReason logReason = LogReason.DAILY_GIFT_AWARD_ADD;
/*  90 */     AwardReason awardReason = new AwardReason(logReason, awardCfgid);
/*  91 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(awardCfgid, this.userid, this.roleid, true, true, awardReason);
/*  92 */     if (awardModel == null)
/*     */     {
/*  94 */       GameServer.logger().error(String.format("[qingfu]PCGetDailyGift.processImp@award model is null|userid=%s|roleid=%d|award_cfgid=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(awardCfgid) }));
/*     */       
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     addTlog(this.userid, this.roleid, awardCfgid);
/*     */     
/* 102 */     SGetDailyGiftSuccess resp = new SGetDailyGiftSuccess();
/* 103 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 105 */     GameServer.logger().info(String.format("[qingfu]PCGetDailyGift.processImp@get daily gift success|userid=%s|roleid=%d", new Object[] { this.userid, Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   private void addTlog(String userid, long roleid, int awardCfgid)
/*     */   {
/* 113 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 114 */     int roleLevel = RoleInterface.getLevel(roleid);
/*     */     
/* 116 */     TLogManager.getInstance().addLog(userid, "DailyGiftForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Integer.valueOf(awardCfgid) });
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 121 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 126 */     if (retcode < 0)
/*     */     {
/* 128 */       SGetDailyGiftFailed resp = new SGetDailyGiftFailed();
/* 129 */       resp.retcode = retcode;
/* 130 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 133 */     StringBuffer logBuilder = new StringBuffer();
/* 134 */     logBuilder.append("[qingfu]PCGetDailyGift.onFailed@get daily gift failed");
/* 135 */     logBuilder.append('|').append("userid=").append(this.userid);
/* 136 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 137 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 139 */     if (extraParams != null)
/*     */     {
/* 141 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 143 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 147 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCGetDailyGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */