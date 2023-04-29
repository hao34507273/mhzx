/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.RankAwardBuffBean;
/*     */ import mzm.gsp.crossbattle.confbean.RankAwardBuffList;
/*     */ import mzm.gsp.crossbattle.confbean.RankAwardMailItemBean;
/*     */ import mzm.gsp.crossbattle.confbean.RankAwardMailItemList;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardCfg;
/*     */ import mzm.gsp.idip.main.PIDIPCmd_NTimesAwardReq.PIDIPAddGlobalNTimesAward;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleFinalAwardInfo;
/*     */ import xbean.CrossBattleKnockoutActivityLocalInfo;
/*     */ import xbean.CrossBattleKnockoutLocalRankInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossBattleFinalAwardInfo;
/*     */ import xtable.Cross_battle_knockout_local;
/*     */ import xtable.Role2crossbattlefinalaward;
/*     */ 
/*     */ public class FinalServerDelayAwardObserver extends MilliObserver
/*     */ {
/*     */   private final int activityCfgId;
/*     */   private final int realRank;
/*     */   private final long endTimeMillis;
/*     */   private final boolean isNeedMailAwardItem;
/*     */   private final int recordRank;
/*     */   
/*     */   public FinalServerDelayAwardObserver(long intervalMillSeconds, int activityCfgId, int realRank, long endTimeMillis, boolean isNeedMailAwardItem, int recordRank)
/*     */   {
/*  45 */     super(intervalMillSeconds);
/*  46 */     this.activityCfgId = activityCfgId;
/*  47 */     this.realRank = realRank;
/*  48 */     this.endTimeMillis = endTimeMillis;
/*  49 */     this.recordRank = recordRank;
/*  50 */     this.isNeedMailAwardItem = isNeedMailAwardItem;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  56 */     new POnFinalServerDelayAward(this.activityCfgId, this.realRank, this.endTimeMillis, this.recordRank, this.isNeedMailAwardItem).execute();
/*     */     
/*     */ 
/*  59 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class POnFinalServerDelayAward
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     
/*     */     private final int realRank;
/*     */     
/*     */     private final long endTimeMillis;
/*     */     
/*     */     private final int recordRank;
/*     */     private final boolean isNeedMailAwardItem;
/*     */     
/*     */     public POnFinalServerDelayAward(int activityCfgId, int realRank, long endTimeMillis, int recordRank, boolean isNeedMailAwardItem)
/*     */     {
/*  77 */       this.activityCfgId = activityCfgId;
/*  78 */       this.realRank = realRank;
/*  79 */       this.endTimeMillis = endTimeMillis;
/*  80 */       this.recordRank = recordRank;
/*  81 */       this.isNeedMailAwardItem = isNeedMailAwardItem;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  87 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */       
/*  89 */       CrossBattleKnockoutActivityLocalInfo xCrossBattleKnockoutActivityLocalInfo = Cross_battle_knockout_local.get(Long.valueOf(globalActivityCfgid));
/*  90 */       if (xCrossBattleKnockoutActivityLocalInfo == null)
/*     */       {
/*  92 */         onFinalServerDelayAwardFail(-1);
/*  93 */         return false;
/*     */       }
/*     */       
/*  96 */       if (this.isNeedMailAwardItem)
/*     */       {
/*  98 */         mailAwardItem(xCrossBattleKnockoutActivityLocalInfo);
/*     */       }
/*     */       
/* 101 */       SCrossBattleFinalServerAwardCfg sCrossBattleFinalServerAwardCfg = SCrossBattleFinalServerAwardCfg.get(this.activityCfgId);
/* 102 */       if (sCrossBattleFinalServerAwardCfg == null)
/*     */       {
/* 104 */         onFinalServerDelayAwardFail(-2);
/* 105 */         return false;
/*     */       }
/*     */       
/* 108 */       CrossBattleKnockoutLocalRankInfo xCrossBattleKnockoutLocalRankInfo = (CrossBattleKnockoutLocalRankInfo)xCrossBattleKnockoutActivityLocalInfo.getAward_server_info_map().get(Integer.valueOf(this.recordRank));
/*     */       
/* 110 */       if (xCrossBattleKnockoutLocalRankInfo == null)
/*     */       {
/* 112 */         onFinalServerDelayAwardFail(-3);
/* 113 */         return false;
/*     */       }
/*     */       
/* 116 */       if (xCrossBattleKnockoutLocalRankInfo.getIs_server_buff_install())
/*     */       {
/* 118 */         onFinalServerDelayAwardFail(-4);
/* 119 */         return false;
/*     */       }
/*     */       
/* 122 */       RankAwardBuffList rankAwardBuffList = (RankAwardBuffList)sCrossBattleFinalServerAwardCfg.rank_2_award_buff_map.get(Integer.valueOf(this.realRank));
/* 123 */       if (rankAwardBuffList == null)
/*     */       {
/* 125 */         onFinalServerDelayAwardFail(-5);
/* 126 */         return false;
/*     */       }
/*     */       
/* 129 */       long currentTimeMillis = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */       
/* 131 */       for (RankAwardBuffBean rankAwardBuffBean : rankAwardBuffList.buff_list)
/*     */       {
/* 133 */         int buffId = rankAwardBuffBean.buff_id;
/* 134 */         int nTimes = rankAwardBuffBean.buff_ratio - CommonUtils.WAN_PERCENT;
/*     */         
/* 136 */         Set<Integer> validZoneIdSet = xCrossBattleKnockoutLocalRankInfo.getValid_zone_id_set();
/*     */         
/* 138 */         new PIDIPCmd_NTimesAwardReq.PIDIPAddGlobalNTimesAward(java.util.Arrays.asList(new Integer[] { Integer.valueOf(buffId) }), nTimes, currentTimeMillis, this.endTimeMillis, new HashSet(validZoneIdSet)).execute();
/*     */       }
/*     */       
/*     */ 
/* 142 */       xCrossBattleKnockoutLocalRankInfo.setIs_server_buff_install(true);
/*     */       
/* 144 */       StringBuilder sBuilder = new StringBuilder();
/* 145 */       sBuilder.append("[crossbattle_knockout]FinalServerDelayAwardObserver.POnFinalServerDelayAward.installBuff@install buff");
/* 146 */       sBuilder.append("|current_time_millis=").append(currentTimeMillis);
/* 147 */       sBuilder.append("|end_time_millis=").append(this.endTimeMillis);
/* 148 */       sBuilder.append("|rank_award_buff_day=").append(rankAwardBuffList.buff_last_day);
/* 149 */       sBuilder.append("|rank_award_buff_list=").append(rankAwardBuffList.buff_list);
/* 150 */       sBuilder.append("|real_rank=").append(this.realRank);
/* 151 */       sBuilder.append("|record_rank=").append(this.recordRank);
/*     */       
/* 153 */       GameServer.logger().info(sBuilder.toString());
/*     */       
/* 155 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void mailAwardItem(CrossBattleKnockoutActivityLocalInfo xCrossBattleKnockoutActivityLocalInfo)
/*     */     {
/* 166 */       SCrossBattleFinalServerAwardCfg sCrossBattleFinalServerAwardCfg = SCrossBattleFinalServerAwardCfg.get(this.activityCfgId);
/* 167 */       if (sCrossBattleFinalServerAwardCfg == null)
/*     */       {
/* 169 */         return;
/*     */       }
/*     */       
/* 172 */       for (int recordRank = 1; recordRank <= 4; recordRank++)
/*     */       {
/* 174 */         CrossBattleKnockoutLocalRankInfo xCrossBattleKnockoutLocalRankInfo = (CrossBattleKnockoutLocalRankInfo)xCrossBattleKnockoutActivityLocalInfo.getAward_server_info_map().get(Integer.valueOf(recordRank));
/*     */         
/* 176 */         if (xCrossBattleKnockoutLocalRankInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 181 */           Set<Integer> xValidZoneIdSet = xCrossBattleKnockoutLocalRankInfo.getValid_zone_id_set();
/*     */           
/* 183 */           int realRank = recordRank >= 3 ? recordRank - 1 : recordRank;
/*     */           
/*     */ 
/* 186 */           sendOnlineRoleItem(sCrossBattleFinalServerAwardCfg, realRank, recordRank, new HashSet(xValidZoneIdSet));
/*     */         }
/*     */       }
/*     */     }
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
/*     */     private void sendOnlineRoleItem(SCrossBattleFinalServerAwardCfg sFinalServerAwardCfg, int realRank, int recordRank, Set<Integer> validZoneIdSet)
/*     */     {
/* 203 */       RankAwardMailItemList rankAwardMailItemList = (RankAwardMailItemList)sFinalServerAwardCfg.rank_2_award_item_map.get(Integer.valueOf(realRank));
/* 204 */       if (rankAwardMailItemList == null)
/*     */       {
/* 206 */         return;
/*     */       }
/* 208 */       List<Long> onlineRoleIdList = OnlineManager.getInstance().getOnlineHigherRoleidList(sFinalServerAwardCfg.gift_item_min_level - 1);
/*     */       
/*     */ 
/* 211 */       for (Iterator i$ = onlineRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 213 */         MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 214 */         for (RankAwardMailItemBean rankAwardMailItemBean : rankAwardMailItemList.award_item_list)
/*     */         {
/* 216 */           mailAttachment.addItem(rankAwardMailItemBean.award_item_id, rankAwardMailItemBean.award_item_num);
/*     */         }
/* 218 */         NoneRealTimeTaskManager.getInstance().addTask(new PSendServerAwardMailItem(this.activityCfgId, mailAttachment, roleId, rankAwardMailItemList.award_item_mail_cfg_id, realRank, validZoneIdSet, recordRank));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     private static class PSendServerAwardMailItem
/*     */       extends LogicProcedure
/*     */     {
/*     */       private final int activityCfgId;
/*     */       
/*     */       private final MailAttachment mailAttachment;
/*     */       
/*     */       private final long roleId;
/*     */       private final int mailCfgId;
/*     */       private final int realRank;
/*     */       private final Set<Integer> validZoneIdSet;
/*     */       private final int recordRank;
/*     */       private String userId;
/*     */       
/*     */       public PSendServerAwardMailItem(int activityCfgId, MailAttachment mailAttachment, long roleId, int mailCfgId, int awardRank, Set<Integer> validZoneIdSet, int recordRank)
/*     */       {
/* 239 */         this.activityCfgId = activityCfgId;
/* 240 */         this.mailAttachment = mailAttachment;
/* 241 */         this.roleId = roleId;
/* 242 */         this.mailCfgId = mailCfgId;
/* 243 */         this.realRank = awardRank;
/* 244 */         this.validZoneIdSet = validZoneIdSet;
/* 245 */         this.recordRank = recordRank;
/*     */       }
/*     */       
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 251 */         this.userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 252 */         if (this.userId == null)
/*     */         {
/* 254 */           onSendServerAwardMailItemFail(-1);
/* 255 */           return false;
/*     */         }
/*     */         
/* 258 */         if (!CrossBattleKnockoutManager.isCrossBattleServerMailAwardSwitchOpen(this.roleId))
/*     */         {
/* 260 */           onSendServerAwardMailItemFail(-2);
/* 261 */           return false;
/*     */         }
/*     */         
/* 264 */         RoleCrossBattleFinalAwardInfo xRoleCrossBattleFinalAwardInfo = Role2crossbattlefinalaward.get(Long.valueOf(this.roleId));
/* 265 */         int roleZoneId = GameServerInfoManager.getZoneidFromRoleid(this.roleId);
/* 266 */         if (!this.validZoneIdSet.contains(Integer.valueOf(roleZoneId)))
/*     */         {
/* 268 */           onSendServerAwardMailItemFail(-3);
/* 269 */           return false;
/*     */         }
/*     */         
/* 272 */         if (xRoleCrossBattleFinalAwardInfo == null)
/*     */         {
/* 274 */           xRoleCrossBattleFinalAwardInfo = Pod.newRoleCrossBattleFinalAwardInfo();
/* 275 */           Role2crossbattlefinalaward.add(Long.valueOf(this.roleId), xRoleCrossBattleFinalAwardInfo);
/*     */         }
/*     */         
/* 278 */         CrossBattleFinalAwardInfo xCrossBattleFinalAwardInfo = (CrossBattleFinalAwardInfo)xRoleCrossBattleFinalAwardInfo.getActivity_award_map().get(Integer.valueOf(this.activityCfgId));
/*     */         
/* 280 */         if (xCrossBattleFinalAwardInfo == null)
/*     */         {
/* 282 */           xCrossBattleFinalAwardInfo = Pod.newCrossBattleFinalAwardInfo();
/* 283 */           xRoleCrossBattleFinalAwardInfo.getActivity_award_map().put(Integer.valueOf(this.activityCfgId), xCrossBattleFinalAwardInfo);
/*     */         }
/*     */         
/* 286 */         if (!xCrossBattleFinalAwardInfo.getChecked_award_rank_set().add(Integer.valueOf(this.recordRank)))
/*     */         {
/* 288 */           onSendServerAwardMailItemFail(-4);
/* 289 */           return false;
/*     */         }
/*     */         
/* 292 */         SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleId, this.mailCfgId, new ArrayList(), new ArrayList(), this.mailAttachment, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.CROSS_SERVER_FINAL_SERVER_AWARD, this.mailCfgId));
/*     */         
/*     */ 
/* 295 */         if (!sendMailRet.isOK())
/*     */         {
/* 297 */           onSendServerAwardMailItemFail(-5);
/* 298 */           return false;
/*     */         }
/*     */         
/* 301 */         CrossBattleKnockoutManager.tlogAwardFinalServerRank(this.userId, this.roleId, this.recordRank, this.activityCfgId);
/*     */         
/*     */ 
/* 304 */         onSendServerAwardMailItemFail(0);
/* 305 */         return true;
/*     */       }
/*     */       
/*     */       private void onSendServerAwardMailItemFail(int ret)
/*     */       {
/* 310 */         StringBuilder sBuilder = new StringBuilder();
/* 311 */         sBuilder.append("[crossbattle_knockout]PSendServerAwardMailItem.processImp@fail");
/* 312 */         sBuilder.append("|ret=").append(ret);
/* 313 */         sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 314 */         sBuilder.append("|role_id=").append(this.roleId);
/* 315 */         sBuilder.append("|mail_cfg_id=").append(this.mailCfgId);
/* 316 */         sBuilder.append("|award_rank=").append(this.realRank);
/* 317 */         sBuilder.append("|valid_zone_id_set=").append(this.validZoneIdSet);
/*     */         
/* 319 */         GameServer.logger().error(sBuilder.toString());
/*     */       }
/*     */     }
/*     */     
/*     */     private void onFinalServerDelayAwardFail(int ret)
/*     */     {
/* 325 */       StringBuilder sb = new StringBuilder();
/* 326 */       sb.append("[crossbattle_knockout]POnFinalServerDelayAward.processImp@fail");
/* 327 */       sb.append("|ret=").append(ret);
/* 328 */       sb.append("|activity_cfg_id=").append(this.activityCfgId);
/* 329 */       sb.append("|is_need_mail_award_item=").append(this.isNeedMailAwardItem);
/* 330 */       sb.append("|real_rank=").append(this.realRank);
/* 331 */       sb.append("|record_rank=").append(this.recordRank);
/*     */       
/* 333 */       GameServer.logger().error(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\FinalServerDelayAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */