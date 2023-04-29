/*     */ package mzm.gsp.xiaohuikuaipao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg;
/*     */ import xbean.XiaoHuiKuaiPaoActivityInfo;
/*     */ import xbean.XiaoHuiKuaiPaoGlobalInfo;
/*     */ import xbean.XiaoHuiKuaiPaoInfo;
/*     */ import xtable.Activityid2xiaohuikuaipaoglobalinfo;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  26 */     new POuterTurnToPointActivity(roleId).execute();
/*     */     
/*     */ 
/*  29 */     XiaoHuiKuaiPaoActivityInfo xXiaoHuiKuaiPaoActivityInfo = xtable.Role2xiaohuikuaipaoactivityinfo.get(Long.valueOf(roleId));
/*  30 */     if (xXiaoHuiKuaiPaoActivityInfo == null)
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     Map<Integer, XiaoHuiKuaiPaoInfo> xXiaoHuiKuaiPaoInfoMap = xXiaoHuiKuaiPaoActivityInfo.getActivityid2xiaohuikuaipaoinfo();
/*     */     
/*  37 */     long currentTimeStamp = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  43 */     for (Map.Entry<Integer, XiaoHuiKuaiPaoInfo> entry : xXiaoHuiKuaiPaoInfoMap.entrySet())
/*     */     {
/*  45 */       int activityId = ((Integer)entry.getKey()).intValue();
/*  46 */       XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo = (XiaoHuiKuaiPaoInfo)entry.getValue();
/*  47 */       if (!ActivityInterface.isActivityOpen(activityId))
/*     */       {
/*     */ 
/*     */ 
/*  51 */         XiaoHuiKuaiPaoActivityCfg xiaoHuiKuaiPaoActivityCfg = XiaoHuiKuaiPaoActivityCfg.get(activityId);
/*  52 */         if ((xiaoHuiKuaiPaoActivityCfg != null) && 
/*     */         
/*     */ 
/*     */ 
/*  56 */           (xXiaoHuiKuaiPaoInfo.getTicketcount() >= xiaoHuiKuaiPaoActivityCfg.ticketCount) && 
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  61 */           (currentTimeStamp <= xXiaoHuiKuaiPaoInfo.getEndtimestamp()))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  66 */           long globalTableKeyId = mzm.gsp.GameServerInfoManager.toGlobalId(activityId);
/*  67 */           XiaoHuiKuaiPaoGlobalInfo xXiaoHuiKuaiPaoGlobalInfo = Activityid2xiaohuikuaipaoglobalinfo.get(Long.valueOf(globalTableKeyId));
/*     */           
/*  69 */           if (xXiaoHuiKuaiPaoGlobalInfo == null)
/*     */           {
/*  71 */             return false;
/*     */           }
/*  73 */           if (xXiaoHuiKuaiPaoGlobalInfo.getIsautodraw())
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  79 */             while (xXiaoHuiKuaiPaoInfo.getTicketcount() >= xiaoHuiKuaiPaoActivityCfg.ticketCount)
/*     */             {
/*  81 */               MailAttachment mailAttachment = new MailAttachment();
/*  82 */               SLotteryViewRandomCfg lotteryViewRandomCfg = SLotteryViewRandomCfg.get(xiaoHuiKuaiPaoActivityCfg.lotteryViewCfgId);
/*  83 */               if (lotteryViewRandomCfg != null)
/*     */               {
/*     */ 
/*     */ 
/*  87 */                 int tLog_lastTicketCount = xXiaoHuiKuaiPaoInfo.getTicketcount();
/*  88 */                 Collection<Integer> tLog_lastHitIndexList = new ArrayList(xXiaoHuiKuaiPaoInfo.getHitindexes().size());
/*  89 */                 tLog_lastHitIndexList.addAll(xXiaoHuiKuaiPaoInfo.getHitindexes());
/*     */                 
/*  91 */                 Collection<Integer> tLog_lastHitRandomTextTableTypeIdList = new ArrayList(xXiaoHuiKuaiPaoInfo.getHitrandomtexttabletypeids().size());
/*     */                 
/*  93 */                 tLog_lastHitRandomTextTableTypeIdList.addAll(xXiaoHuiKuaiPaoInfo.getHitrandomtexttabletypeids());
/*     */                 
/*  95 */                 AwardPoolResultData awardPoolResultData = XiaoHuiKuaiPaoManager.getInnerDrawAwardPoolResultData(roleId, xXiaoHuiKuaiPaoInfo, xiaoHuiKuaiPaoActivityCfg, lotteryViewRandomCfg);
/*     */                 
/*     */ 
/*  98 */                 mailAttachment.addItemMap(awardPoolResultData.getItemMap());
/*     */                 
/* 100 */                 mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(roleId, xiaoHuiKuaiPaoActivityCfg.systemDrawMailId, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(mzm.gsp.tlog.LogReason.XIAO_HUI_KUAI_PAO_INNER_SYSTEM_DRAW));
/*     */                 
/*     */ 
/*     */ 
/* 104 */                 XiaoHuiKuaiPaoTLogManager.tLogInnerDraw(roleId, activityId, awardPoolResultData.getIndex(), awardPoolResultData.getTypeId(), awardPoolResultData.getItemMap(), tLog_lastTicketCount, xXiaoHuiKuaiPaoInfo.getTicketcount(), tLog_lastHitIndexList, xXiaoHuiKuaiPaoInfo.getHitindexes(), tLog_lastHitRandomTextTableTypeIdList, xXiaoHuiKuaiPaoInfo.getHitrandomtexttabletypeids());
/*     */               }
/*     */             } }
/*     */         }
/*     */       }
/*     */     }
/* 110 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */