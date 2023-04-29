/*      */ package mzm.gsp.grc.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import gnet.GDeliveryManager;
/*      */ import grc.DataBetweenGameAndGrc;
/*      */ import grc.DataBetweenGameAndGrcArg;
/*      */ import grc.DataBetweenGameAndGrcRes;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.award.main.AwardModel;
/*      */ import mzm.gsp.award.main.AwardReason;
/*      */ import mzm.gsp.grc.SGetInviteFriendsGiftResp;
/*      */ import mzm.gsp.grc.SGetInviteFriendsInfoResp;
/*      */ import mzm.gsp.grc.SGetInviteFriendsRebateBindYuanbaoResp;
/*      */ import mzm.gsp.grc.confbean.SInviteFriendsConsts;
/*      */ import mzm.gsp.mail.main.MailAttachment;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.mail.main.SendMailRet;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.qingfu.main.PresentResult;
/*      */ import mzm.gsp.qingfu.main.PresentType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.shimen.main.ShimenInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class InviteFriendsManager
/*      */ {
/*      */   private static final String ENCODING = "UTF-8";
/*      */   
/*      */   static void init() {}
/*      */   
/*      */   static boolean isOpenInviteFriends(long roleid)
/*      */   {
/*   52 */     if (!OpenInterface.getOpenStatus(155))
/*      */     {
/*   54 */       return false;
/*      */     }
/*      */     
/*   57 */     if (OpenInterface.isBanPlay(roleid, 155))
/*      */     {
/*   59 */       OpenInterface.sendBanPlayMsg(roleid, 155);
/*   60 */       return false;
/*      */     }
/*      */     
/*   63 */     return true;
/*      */   }
/*      */   
/*      */   static boolean checkInviterRoleLevel(long roleid)
/*      */   {
/*   68 */     int level = RoleInterface.getLevel(roleid);
/*   69 */     return checkInviterRoleLevel(roleid, level);
/*      */   }
/*      */   
/*      */   static boolean checkInviterRoleLevel(long roleid, int level)
/*      */   {
/*   74 */     if ((level < SInviteFriendsConsts.getInstance().OPEN_NEED_ROLE_LEVEL) || (level < SInviteFriendsConsts.getInstance().INVITER_MIN_ROLE_LEVEL))
/*      */     {
/*      */ 
/*   77 */       return false;
/*      */     }
/*      */     
/*   80 */     return true;
/*      */   }
/*      */   
/*      */   static boolean checkInviterStatus(String userid, long roleid, xbean.User xUser)
/*      */   {
/*   85 */     if (!isOpenInviteFriends(roleid))
/*      */     {
/*   87 */       return false;
/*      */     }
/*      */     
/*   90 */     if (!checkInviterRoleLevel(roleid))
/*      */     {
/*   92 */       return false;
/*      */     }
/*      */     
/*   95 */     String inviteCode = xUser.getInviter_code();
/*   96 */     if (inviteCode.isEmpty())
/*      */     {
/*   98 */       return false;
/*      */     }
/*      */     
/*  101 */     return true;
/*      */   }
/*      */   
/*      */   static boolean tryGenInviteCode(String userid, long roleid)
/*      */   {
/*  106 */     xbean.User xUser = xtable.User.get(userid);
/*  107 */     if (xUser == null)
/*      */     {
/*  109 */       return false;
/*      */     }
/*      */     
/*  112 */     if (!isOpenInviteFriends(roleid))
/*      */     {
/*  114 */       return false;
/*      */     }
/*      */     
/*  117 */     if (!checkInviterRoleLevel(roleid))
/*      */     {
/*  119 */       return false;
/*      */     }
/*      */     
/*  122 */     String inviteCode = xUser.getInviter_code();
/*  123 */     if ((inviteCode == null) || (inviteCode.isEmpty()))
/*      */     {
/*  125 */       return sendGenInviteCode(userid, roleid);
/*      */     }
/*      */     
/*      */ 
/*  129 */     return sendGetInviteFriendsInfo(userid, roleid);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean tryUseInviteCode(String userid, long roleid)
/*      */   {
/*  135 */     if (!isOpenInviteFriends(roleid))
/*      */     {
/*  137 */       return false;
/*      */     }
/*      */     
/*  140 */     xbean.User xUser = xtable.User.get(userid);
/*  141 */     if (xUser == null)
/*      */     {
/*  143 */       return false;
/*      */     }
/*      */     
/*  146 */     String inviteCode = xUser.getInvitee_code();
/*  147 */     if ((inviteCode == null) || (inviteCode.isEmpty()))
/*      */     {
/*  149 */       return true;
/*      */     }
/*      */     
/*  152 */     int status = xUser.getInvitee_status();
/*  153 */     if (status == 0)
/*      */     {
/*  155 */       return sendUseInviteCode(userid, roleid, inviteCode);
/*      */     }
/*      */     
/*  158 */     return false;
/*      */   }
/*      */   
/*      */   static void statisInviteeDoneShimenTotalTimes(String userid, long roleid, xbean.User xUser)
/*      */   {
/*  163 */     int doneRingNum = ShimenInterface.getShimenFinishCount(userid, roleid, true);
/*  164 */     if (doneRingNum < SInviteFriendsConsts.getInstance().AWARD_INVITER_INVITEE_DONE_SHIMEN_RING_NUM)
/*      */     {
/*  166 */       return;
/*      */     }
/*      */     
/*      */ 
/*  170 */     if (xUser.getInvitee_code().isEmpty())
/*      */     {
/*  172 */       return;
/*      */     }
/*      */     
/*  175 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  176 */     long originTimeOfToday = DateTimeUtils.getTimeInToday(currTime, 0);
/*  177 */     long registerTime = xUser.getRegister_time();
/*  178 */     long originTimeOfRegister = DateTimeUtils.getTimeInToday(registerTime, 0);
/*  179 */     long deltaDays = (originTimeOfToday - originTimeOfRegister) / 86400000L;
/*  180 */     if (deltaDays > SInviteFriendsConsts.getInstance().AWARD_INVITER_INVITEE_USER_CREATE_MAX_DAYS)
/*      */     {
/*  182 */       if (xUser.getInvitee_done_shimen_total_days() < SInviteFriendsConsts.getInstance().AWARD_INVITER_INVITEE_DONE_SHIMEN_TOTAL_DAYS)
/*      */       {
/*  184 */         xUser.setInvitee_status(1);
/*      */       }
/*      */       
/*  187 */       return;
/*      */     }
/*      */     
/*  190 */     long inviteeDoneShimenTimestamp = xUser.getInvitee_done_shimen_timestamp();
/*  191 */     if (inviteeDoneShimenTimestamp > 0L)
/*      */     {
/*  193 */       long originTimeOfDoneShimen = DateTimeUtils.getTimeInToday(inviteeDoneShimenTimestamp, 0);
/*  194 */       if (originTimeOfDoneShimen == originTimeOfToday)
/*      */       {
/*      */ 
/*  197 */         return;
/*      */       }
/*      */     }
/*      */     
/*  201 */     xUser.setInvitee_done_shimen_total_days(xUser.getInvitee_done_shimen_total_days() + 1);
/*  202 */     xUser.setInvitee_done_shimen_timestamp(currTime);
/*      */   }
/*      */   
/*      */   static boolean checkInviteePresentGiftTimes(String userid, long roleid, xbean.User xUser)
/*      */   {
/*  207 */     if (!isOpenInviteFriends(roleid))
/*      */     {
/*  209 */       return false;
/*      */     }
/*      */     
/*  212 */     int level = RoleInterface.getLevel(roleid);
/*  213 */     if (level < SInviteFriendsConsts.getInstance().AWARD_INVITER_NEED_INVITEE_ROLE_LEVEL)
/*      */     {
/*  215 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  219 */     if (xUser.getInvitee_code().isEmpty())
/*      */     {
/*  221 */       return false;
/*      */     }
/*      */     
/*  224 */     int status = xUser.getInvitee_status();
/*      */     
/*  226 */     if ((status == 0) || (status == 1))
/*      */     {
/*  228 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  232 */     if ((status & 0x4) == 4)
/*      */     {
/*  234 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  238 */     if ((status & 0x2) != 2)
/*      */     {
/*  240 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  244 */     if (xUser.getInvitee_done_shimen_total_days() < SInviteFriendsConsts.getInstance().AWARD_INVITER_INVITEE_DONE_SHIMEN_TOTAL_DAYS)
/*      */     {
/*  246 */       return false;
/*      */     }
/*      */     
/*  249 */     return true;
/*      */   }
/*      */   
/*      */   static boolean checkInviteePresentRebateBindYuanbao(String userid, long roleid, xbean.User xUser)
/*      */   {
/*  254 */     if (!isOpenInviteFriends(roleid))
/*      */     {
/*  256 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  260 */     if (xUser.getInvitee_code().isEmpty())
/*      */     {
/*  262 */       return false;
/*      */     }
/*      */     
/*  265 */     int status = xUser.getInvitee_status();
/*      */     
/*  267 */     if ((status == 0) || (status == 1))
/*      */     {
/*  269 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  273 */     if ((status & 0x2) != 2)
/*      */     {
/*  275 */       return false;
/*      */     }
/*      */     
/*  278 */     return true;
/*      */   }
/*      */   
/*      */   static boolean tryAddInviteFriendsGiftTimes(String userid, long roleid, xbean.User xUser)
/*      */   {
/*  283 */     if (!checkInviteePresentGiftTimes(userid, roleid, xUser))
/*      */     {
/*  285 */       return false;
/*      */     }
/*      */     
/*  288 */     return sendAddInviteFriendsGiftTimes(userid, roleid, xUser);
/*      */   }
/*      */   
/*      */   static boolean tryAddInviteFriendsRebateBindYuanbao(String userid, long roleid, xbean.User xUser)
/*      */   {
/*  293 */     if (!checkInviteePresentRebateBindYuanbao(userid, roleid, xUser))
/*      */     {
/*  295 */       return false;
/*      */     }
/*      */     
/*  298 */     int diffDays = DateTimeUtils.diffDaysFromNow(xUser.getRegister_time());
/*  299 */     if (diffDays > SInviteFriendsConsts.getInstance().PRESENT_BIND_YUANBAO_DAYS_ON_INVITEE_CASH)
/*      */     {
/*  301 */       return false;
/*      */     }
/*  303 */     long rebateBindYuanbao = xUser.getInvitee_total_present_rebate_bind_yuanbao();
/*  304 */     long rebateLimit = SInviteFriendsConsts.getInstance().INVITEE_PRESENT_BIND_YUANBAO_MAX_NUM;
/*  305 */     if (rebateBindYuanbao >= rebateLimit)
/*      */     {
/*  307 */       return false;
/*      */     }
/*      */     
/*  310 */     long saveAmt = QingfuInterface.getSaveAmt(userid, true);
/*  311 */     long oldSaveAmt = xUser.getInvitee_save_amt();
/*  312 */     long deltaSaveAmt = saveAmt - oldSaveAmt;
/*  313 */     if (deltaSaveAmt > 0L)
/*      */     {
/*  315 */       xUser.setInvitee_save_amt(saveAmt);
/*  316 */       long deltaRebateBindYuanbao = ((float)(deltaSaveAmt * SInviteFriendsConsts.getInstance().PRESENT_BIND_YUANBAO_RATIO_ON_INVITEE_CASH) / 10000.0F);
/*      */       
/*  318 */       long newRebateBindYuanbao = Math.min(rebateBindYuanbao + deltaRebateBindYuanbao, rebateLimit);
/*  319 */       xUser.setInvitee_total_present_rebate_bind_yuanbao(newRebateBindYuanbao);
/*      */ 
/*      */ 
/*      */     }
/*  323 */     else if (xUser.getInvitee_confirm_total_present_rebate_bind_yuanbao() >= xUser.getInvitee_total_present_rebate_bind_yuanbao())
/*      */     {
/*  325 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  329 */     sendAddInviteFriendsRebateBindYuanbao(userid, roleid, xUser);
/*      */     
/*  331 */     return true;
/*      */   }
/*      */   
/*      */   static boolean sendGenInviteCode(String userid, long roleid)
/*      */   {
/*      */     try
/*      */     {
/*  338 */       String openId = CommonUtils.getOpenId(userid);
/*  339 */       String channel = CommonUtils.getPlatName(userid);
/*  340 */       int zoneid = CommonUtils.getZoneId(userid);
/*  341 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/*  342 */       arg.openid.setString(openId, "UTF-8");
/*  343 */       arg.channel.setString(channel, "UTF-8");
/*  344 */       arg.qtype = 5;
/*  345 */       arg.data_direction = 1;
/*  346 */       OctetsStream os = new OctetsStream();
/*  347 */       os.marshal(zoneid);
/*  348 */       os.marshal(Octets.wrap(OnlineManager.getInstance().getDeviceIdentifier(userid), "UTF-8"));
/*  349 */       os.marshal(roleid);
/*  350 */       os.marshal(0);
/*  351 */       os.marshal(0);
/*  352 */       arg.info.replace(os);
/*      */       
/*  354 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*  355 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*  360 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onGenInviteCodeResp(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/*  368 */       String openId = arg.openid.getString("UTF-8");
/*  369 */       String channel = arg.channel.getString("UTF-8");
/*  370 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/*  371 */       int zoneid = osArgInfo.unmarshal_int();
/*  372 */       String userid = CommonUtils.getUserId(openId, channel, zoneid);
/*  373 */       Octets deviceidOctets = osArgInfo.unmarshal_Octets();
/*  374 */       String deviceid = deviceidOctets.getString("UTF-8");
/*  375 */       long roleid = osArgInfo.unmarshal_long();
/*  376 */       xbean.User xUser = xtable.User.get(userid);
/*  377 */       if ((xUser == null) || (!xUser.getInviter_code().isEmpty()))
/*      */       {
/*  379 */         return false;
/*      */       }
/*      */       
/*  382 */       if ((res.retcode != 0) && (res.retcode != 400))
/*      */       {
/*  384 */         GameServer.logger().info(String.format("[grc]InviteFriendsManager.onGenInviteCodeResp@gen invite code error|retcode=%d|inviter_userid=%s|deviceid=%s|roleid=%d", new Object[] { Integer.valueOf(res.retcode), userid, deviceid, Long.valueOf(roleid) }));
/*      */         
/*      */ 
/*      */ 
/*  388 */         return false;
/*      */       }
/*      */       
/*  391 */       OctetsStream osResInfo = new OctetsStream(res.info);
/*  392 */       Octets inviteCodeOctets = osResInfo.unmarshal_Octets();
/*  393 */       String inviteCode = inviteCodeOctets.getString("UTF-8");
/*      */       
/*  395 */       xUser.setInviter_code(inviteCode);
/*      */       
/*  397 */       GameServer.logger().info(String.format("[grc]InviteFriendsManager.onGenInviteCodeResp@gen invite code success|retcode=%d|inviter_userid=%s|roleid=%d|invite_code=%s", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  403 */       int level = RoleInterface.getLevel(roleid);
/*  404 */       TLogManager.getInstance().addLog(userid, roleid, "GenInviteCode", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(level), inviteCode, deviceid });
/*      */       
/*      */ 
/*  407 */       return true;
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  414 */     return false;
/*      */   }
/*      */   
/*      */   static boolean sendUseInviteCode(String userid, long roleid, String inviteCode)
/*      */   {
/*      */     try
/*      */     {
/*  421 */       String openId = CommonUtils.getOpenId(userid);
/*  422 */       String channel = CommonUtils.getPlatName(userid);
/*  423 */       int zoneid = CommonUtils.getZoneId(userid);
/*  424 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/*  425 */       arg.openid.setString(openId, "UTF-8");
/*  426 */       arg.channel.setString(channel, "UTF-8");
/*  427 */       arg.qtype = 6;
/*  428 */       arg.data_direction = 1;
/*  429 */       OctetsStream os = new OctetsStream();
/*  430 */       os.marshal(zoneid);
/*  431 */       os.marshal(Octets.wrap(inviteCode, "UTF-8"));
/*  432 */       os.marshal(Octets.wrap(OnlineManager.getInstance().getDeviceIdentifier(userid), "UTF-8"));
/*  433 */       os.marshal(roleid);
/*  434 */       os.marshal(0);
/*  435 */       os.marshal(0);
/*  436 */       arg.info.replace(os);
/*      */       
/*  438 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*  439 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*  444 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onUseInviteCodeResp(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/*  452 */       String openId = arg.openid.getString("UTF-8");
/*  453 */       String channel = arg.channel.getString("UTF-8");
/*  454 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/*  455 */       int zoneid = osArgInfo.unmarshal_int();
/*  456 */       String userid = CommonUtils.getUserId(openId, channel, zoneid);
/*  457 */       Octets inviteCodeOctets = osArgInfo.unmarshal_Octets();
/*  458 */       String inviteCode = inviteCodeOctets.getString("UTF-8");
/*  459 */       Octets deviceidOctets = osArgInfo.unmarshal_Octets();
/*  460 */       String deviceid = deviceidOctets.getString("UTF-8");
/*  461 */       long roleid = osArgInfo.unmarshal_long();
/*      */       
/*  463 */       xbean.User xUser = xtable.User.get(userid);
/*  464 */       if ((xUser == null) || (xUser.getInvitee_code().isEmpty()) || (xUser.getInvitee_status() != 0))
/*      */       {
/*      */ 
/*  467 */         return false;
/*      */       }
/*      */       
/*  470 */       if ((res.retcode != 0) && (res.retcode != 406))
/*      */       {
/*  472 */         if ((res.retcode == 402) || (res.retcode == 404) || (res.retcode == 407) || (res.retcode == 403) || (res.retcode == 405))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  478 */           xUser.setInvitee_status(1);
/*      */         }
/*      */         
/*  481 */         GameServer.logger().info(String.format("[grc]InviteFriendsManager.onUseInviteCodeResp@use invite code error|retcode=%d|invitee_userid=%s|roleid=%d|invite_code=%s|deviceid=%s", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, deviceid }));
/*      */         
/*      */ 
/*      */ 
/*  485 */         return true;
/*      */       }
/*      */       
/*  488 */       OctetsStream osResInfo = new OctetsStream(res.info);
/*  489 */       Octets inviterUseridOctets = osResInfo.unmarshal_Octets();
/*  490 */       String inviterUserid = inviterUseridOctets.getString("UTF-8");
/*      */       
/*      */ 
/*  493 */       int awardCfgid = SInviteFriendsConsts.getInstance().AWARD_INVITEE_CFG_ID;
/*  494 */       AwardReason inviteeFreshmanAwardReason = new AwardReason(LogReason.GRC_INVITEE_FRESHMAN_AWARD_ADD, awardCfgid, PresentType.PRESENT_BIND_GRC_INVITEE_FRESHMAN_AWARD);
/*      */       
/*      */ 
/*  497 */       inviteeFreshmanAwardReason.setAwardItemBind(true);
/*  498 */       AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgid, roleid, inviteeFreshmanAwardReason);
/*      */       
/*  500 */       if (awardModel == null)
/*      */       {
/*  502 */         return false;
/*      */       }
/*  504 */       int mailCfgid = SInviteFriendsConsts.getInstance().AWARD_INVITEE_MAIL_CFG_ID;
/*  505 */       TLogArg tLogArg = new TLogArg(LogReason.GRC_INVITEE_FRESHMAN_AWARD_ADD, awardCfgid);
/*  506 */       MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, true);
/*  507 */       List<String> emptyStrings = Collections.emptyList();
/*  508 */       SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, mailCfgid, emptyStrings, emptyStrings, attachment, tLogArg);
/*      */       
/*      */ 
/*  511 */       if (!ret.isOK())
/*      */       {
/*  513 */         return false;
/*      */       }
/*      */       
/*  516 */       xUser.setInvitee_status(2);
/*      */       
/*  518 */       GameServer.logger().info(String.format("[grc]InviteFriendsManager.onUseInviteCodeResp@use invite code success|retcode=%d|invitee_userid=%s|roleid=%d|invite_code=%s|deviceid=%s|inviter_userid=%s|award_cfgid=%d|mail_cfgid=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, deviceid, inviterUserid, Integer.valueOf(awardCfgid), Integer.valueOf(mailCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  524 */       int level = RoleInterface.getLevel(roleid);
/*  525 */       TLogManager.getInstance().addLog(userid, roleid, "UseInviteCode", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(level), deviceid, Integer.valueOf(awardCfgid), Integer.valueOf(mailCfgid), inviteCode, inviterUserid });
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  532 */       return true;
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  539 */     return false;
/*      */   }
/*      */   
/*      */   static boolean sendAddInviteFriendsRebateBindYuanbao(String userid, long roleid, xbean.User xUser)
/*      */   {
/*      */     try
/*      */     {
/*  546 */       String openId = CommonUtils.getOpenId(userid);
/*  547 */       String channel = CommonUtils.getPlatName(userid);
/*  548 */       int zoneid = CommonUtils.getZoneId(userid);
/*  549 */       String inviteCode = xUser.getInvitee_code();
/*  550 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/*  551 */       arg.openid.setString(openId, "UTF-8");
/*  552 */       arg.channel.setString(channel, "UTF-8");
/*  553 */       arg.qtype = 7;
/*  554 */       arg.data_direction = 1;
/*  555 */       OctetsStream os = new OctetsStream();
/*  556 */       os.marshal(zoneid);
/*  557 */       os.marshal(Octets.wrap(inviteCode, "UTF-8"));
/*  558 */       os.marshal(xUser.getInvitee_total_present_rebate_bind_yuanbao());
/*  559 */       os.marshal(SInviteFriendsConsts.getInstance().INVITEE_PRESENT_BIND_YUANBAO_MAX_NUM);
/*  560 */       os.marshal(roleid);
/*  561 */       os.marshal(0);
/*  562 */       os.marshal(0);
/*  563 */       arg.info.replace(os);
/*      */       
/*  565 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*  566 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*  571 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean onAddInviteFriendsRebateBindYuanbaoResp(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/*  580 */       String openId = arg.openid.getString("UTF-8");
/*  581 */       String channel = arg.channel.getString("UTF-8");
/*  582 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/*  583 */       int zoneid = osArgInfo.unmarshal_int();
/*  584 */       String userid = CommonUtils.getUserId(openId, channel, zoneid);
/*  585 */       Octets inviteCodeOctets = osArgInfo.unmarshal_Octets();
/*  586 */       String inviteCode = inviteCodeOctets.getString("UTF-8");
/*  587 */       long totalRebateBindYuanbao = osArgInfo.unmarshal_long();
/*  588 */       long rebateBindYuanbaoLimit = osArgInfo.unmarshal_long();
/*  589 */       long roleid = osArgInfo.unmarshal_long();
/*      */       
/*  591 */       xbean.User xUser = xtable.User.get(userid);
/*  592 */       if (xUser == null)
/*      */       {
/*  594 */         return false;
/*      */       }
/*      */       
/*  597 */       if (!checkInviteePresentRebateBindYuanbao(userid, roleid, xUser))
/*      */       {
/*  599 */         return false;
/*      */       }
/*      */       
/*  602 */       if ((res.retcode != 0) && (res.retcode != 414))
/*      */       {
/*      */ 
/*  605 */         GameServer.logger().info(String.format("[grc]InviteFriendsManager.onAddInviteFriendsRebateBindYuanbaoResp@add invite friends rebate bind yuanbao error|retcode=%d|invitee_userid=%s|roleid=%d|invite_code=%s|total_rebate_bind_yuanbao=%d|rebate_bind_yuanbao_limit=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalRebateBindYuanbao), Long.valueOf(rebateBindYuanbaoLimit) }));
/*      */         
/*      */ 
/*      */ 
/*  609 */         return false;
/*      */       }
/*      */       
/*  612 */       long oldConfirmTotalRebateBindYuanbao = xUser.getInvitee_confirm_total_present_rebate_bind_yuanbao();
/*  613 */       if (totalRebateBindYuanbao > oldConfirmTotalRebateBindYuanbao)
/*      */       {
/*  615 */         xUser.setInvitee_confirm_total_present_rebate_bind_yuanbao(totalRebateBindYuanbao);
/*      */       }
/*      */       
/*  618 */       GameServer.logger().info(String.format("[grc]InviteFriendsManager.onAddInviteFriendsRebateBindYuanbaoResp@add invite friends rebate bind yuanbao success|retcode=%d|invitee_userid=%s|roleid=%d|invite_code=%s|total_rebate_bind_yuanbao=%d|rebate_bind_yuanbao_limit=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalRebateBindYuanbao), Long.valueOf(rebateBindYuanbaoLimit) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  624 */       int level = RoleInterface.getLevel(roleid);
/*  625 */       TLogManager.getInstance().addLog(userid, roleid, "AddInviteFriendsRebateBindYuanbao", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(totalRebateBindYuanbao), Long.valueOf(rebateBindYuanbaoLimit), inviteCode });
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  632 */       return true;
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  639 */     return false;
/*      */   }
/*      */   
/*      */   static boolean sendAddInviteFriendsGiftTimes(String userid, long roleid, xbean.User xUser)
/*      */   {
/*      */     try
/*      */     {
/*  646 */       String openId = CommonUtils.getOpenId(userid);
/*  647 */       String channel = CommonUtils.getPlatName(userid);
/*  648 */       int zoneid = CommonUtils.getZoneId(userid);
/*  649 */       String inviteCode = xUser.getInvitee_code();
/*      */       
/*  651 */       long totalGiftTimes = 1L;
/*  652 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/*  653 */       arg.openid.setString(openId, "UTF-8");
/*  654 */       arg.channel.setString(channel, "UTF-8");
/*  655 */       arg.qtype = 8;
/*  656 */       arg.data_direction = 1;
/*  657 */       OctetsStream os = new OctetsStream();
/*  658 */       os.marshal(zoneid);
/*  659 */       os.marshal(Octets.wrap(inviteCode, "UTF-8"));
/*  660 */       os.marshal(1L);
/*  661 */       os.marshal(Long.valueOf(SInviteFriendsConsts.getInstance().AWARD_INVITER_GIFT_MAX_TIMES).longValue());
/*  662 */       os.marshal(roleid);
/*  663 */       os.marshal(0);
/*  664 */       os.marshal(0);
/*  665 */       arg.info.replace(os);
/*      */       
/*  667 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*  668 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*  673 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onAddInviteFriendsGiftTimesResp(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/*  681 */       String openId = arg.openid.getString("UTF-8");
/*  682 */       String channel = arg.channel.getString("UTF-8");
/*  683 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/*  684 */       int zoneid = osArgInfo.unmarshal_int();
/*  685 */       String userid = CommonUtils.getUserId(openId, channel, zoneid);
/*  686 */       Octets inviteCodeOctets = osArgInfo.unmarshal_Octets();
/*  687 */       String inviteCode = inviteCodeOctets.getString("UTF-8");
/*  688 */       long totalGiftTimes = osArgInfo.unmarshal_long();
/*  689 */       long awardInviterGiftMaxTimes = osArgInfo.unmarshal_long();
/*  690 */       long roleid = osArgInfo.unmarshal_long();
/*      */       
/*  692 */       xbean.User xUser = xtable.User.get(userid);
/*  693 */       if (xUser == null)
/*      */       {
/*  695 */         return false;
/*      */       }
/*      */       
/*  698 */       if (!checkInviteePresentGiftTimes(userid, roleid, xUser))
/*      */       {
/*  700 */         return false;
/*      */       }
/*      */       
/*  703 */       if ((res.retcode != 0) && (res.retcode != 421) && (res.retcode != 441))
/*      */       {
/*      */ 
/*  706 */         GameServer.logger().info(String.format("[grc]InviteFriendsManager.onAddInviteFriendsGiftTimesResp@add invite friends gift times error|retcode=%d|invitee_userid=%s|roleid=%d|invite_code=%s|total_gift_times=%d|award_inviter_gift_max_times=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalGiftTimes), Long.valueOf(awardInviterGiftMaxTimes) }));
/*      */         
/*      */ 
/*      */ 
/*  710 */         return false;
/*      */       }
/*      */       
/*  713 */       xUser.setInvitee_status(xUser.getInvitee_status() | 0x4);
/*      */       
/*  715 */       GameServer.logger().info(String.format("[grc]InviteFriendsManager.onAddInviteFriendsGiftTimesResp@add invite friends gift times success|retcode=%d|invitee_userid=%s|roleid=%d|invite_code=%s|total_gift_times=%d|award_inviter_gift_max_times=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalGiftTimes), Long.valueOf(awardInviterGiftMaxTimes) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  721 */       int level = RoleInterface.getLevel(roleid);
/*  722 */       TLogManager.getInstance().addLog(userid, roleid, "AddInviteFriendsGiftTimes", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(totalGiftTimes), Long.valueOf(awardInviterGiftMaxTimes), inviteCode });
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  729 */       return true;
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  736 */     return false;
/*      */   }
/*      */   
/*      */   static boolean sendGetInviteFriendsRebateBindYuanbao(String userid, long roleid, xbean.User xUser)
/*      */   {
/*      */     try
/*      */     {
/*  743 */       String openId = CommonUtils.getOpenId(userid);
/*  744 */       String channel = CommonUtils.getPlatName(userid);
/*  745 */       int zoneid = CommonUtils.getZoneId(userid);
/*      */       
/*  747 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/*  748 */       arg.openid.setString(openId, "UTF-8");
/*  749 */       arg.channel.setString(channel, "UTF-8");
/*  750 */       arg.qtype = 9;
/*  751 */       arg.data_direction = 1;
/*  752 */       OctetsStream os = new OctetsStream();
/*  753 */       os.marshal(zoneid);
/*  754 */       os.marshal(xUser.getInviter_total_rebate_bind_yuanbao());
/*  755 */       os.marshal(SInviteFriendsConsts.getInstance().WITHDRAW_BIND_YUANBAO_DAILY_MAX_NUM);
/*  756 */       os.marshal(roleid);
/*  757 */       os.marshal(0);
/*  758 */       os.marshal(0);
/*  759 */       arg.info.replace(os);
/*      */       
/*  761 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*  762 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*  767 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean onGetInviteFriendsRebateBindYuanbaoResp(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/*  776 */       String openId = arg.openid.getString("UTF-8");
/*  777 */       String channel = arg.channel.getString("UTF-8");
/*  778 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/*  779 */       int zoneid = osArgInfo.unmarshal_int();
/*  780 */       String userid = CommonUtils.getUserId(openId, channel, zoneid);
/*  781 */       long totalCostRebateBindYuanbao = osArgInfo.unmarshal_long();
/*  782 */       osArgInfo.unmarshal_long();
/*  783 */       long roleid = osArgInfo.unmarshal_long();
/*      */       
/*  785 */       xbean.User xUser = xtable.User.get(userid);
/*  786 */       if (xUser == null)
/*      */       {
/*  788 */         return false;
/*      */       }
/*      */       
/*  791 */       if (!checkInviterStatus(userid, roleid, xUser))
/*      */       {
/*  793 */         return false;
/*      */       }
/*      */       
/*  796 */       if (totalCostRebateBindYuanbao != xUser.getInviter_total_rebate_bind_yuanbao())
/*      */       {
/*  798 */         return false;
/*      */       }
/*      */       
/*  801 */       String inviteCode = xUser.getInviter_code();
/*  802 */       if (res.retcode != 0)
/*      */       {
/*  804 */         SGetInviteFriendsRebateBindYuanbaoResp resp = new SGetInviteFriendsRebateBindYuanbaoResp();
/*  805 */         resp.retcode = res.retcode;
/*  806 */         OnlineManager.getInstance().sendAtOnce(roleid, resp);
/*      */         
/*  808 */         GameServer.logger().info(String.format("[grc]InviteFriendsManager.onGetInviteFriendsRebateBindYuanbaoResp@get invite friends rebate bind yuanbao error|retcode=%d|inviter_userid=%s|roleid=%d|invite_code=%s|total_cost_rebate_bind_yuanbao=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalCostRebateBindYuanbao) }));
/*      */         
/*      */ 
/*      */ 
/*  812 */         return false;
/*      */       }
/*      */       
/*  815 */       OctetsStream osResInfo = new OctetsStream(res.info);
/*  816 */       int deltaCostRebateBindYuanbao = (int)osResInfo.unmarshal_long();
/*  817 */       long totalRebateBindYuanbao = osResInfo.unmarshal_long();
/*  818 */       xUser.setInviter_total_rebate_bind_yuanbao(totalCostRebateBindYuanbao + deltaCostRebateBindYuanbao);
/*      */       
/*  820 */       TLogArg tLogArg = new TLogArg(LogReason.GRC_INVITER_REBATE_BIND_YUANBAO_AWARD_ADD);
/*  821 */       if (QingfuInterface.presentYuanbao(userid, roleid, deltaCostRebateBindYuanbao, PresentType.PRESENT_BIND_GRC_INVITER_REBATE_BIND_YUANBAO_AWARD, tLogArg) != PresentResult.Success)
/*      */       {
/*      */ 
/*  824 */         GameServer.logger().info(String.format("[grc]InviteFriendsManager.onGetInviteFriendsRebateBindYuanbaoResp@award invite friends rebate bind yuanbao error|retcode=%d|inviter_userid=%s|roleid=%d|invite_code=%s|total_cost_rebate_bind_yuanbao=%d|total_rebate_bind_yuanbao=%d|delta_cost_rebate_bind_yuanbao=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalCostRebateBindYuanbao), Long.valueOf(totalRebateBindYuanbao), Integer.valueOf(deltaCostRebateBindYuanbao) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  829 */         return false;
/*      */       }
/*      */       
/*  832 */       SGetInviteFriendsRebateBindYuanbaoResp resp = new SGetInviteFriendsRebateBindYuanbaoResp();
/*  833 */       resp.retcode = 0;
/*  834 */       resp.rebate_bind_yuanbao = (totalRebateBindYuanbao - xUser.getInviter_total_rebate_bind_yuanbao());
/*  835 */       OnlineManager.getInstance().send(roleid, resp);
/*      */       
/*  837 */       GameServer.logger().info(String.format("[grc]InviteFriendsManager.onGetInviteFriendsRebateBindYuanbaoResp@get invite friends rebate bind yuanbao success|retcode=%d|inviter_userid=%s|roleid=%d|invite_code=%s|total_cost_rebate_bind_yuanbao=%d|total_rebate_bind_yuanbao=%d|delta_cost_rebate_bind_yuanbao=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalCostRebateBindYuanbao), Long.valueOf(totalRebateBindYuanbao), Integer.valueOf(deltaCostRebateBindYuanbao) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  844 */       int level = RoleInterface.getLevel(roleid);
/*  845 */       TLogManager.getInstance().addLog(userid, roleid, "GetInviteFriendsRebateBindYuanbao", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(totalCostRebateBindYuanbao), Long.valueOf(totalRebateBindYuanbao), Integer.valueOf(deltaCostRebateBindYuanbao), inviteCode });
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  851 */       return true;
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  858 */     return false;
/*      */   }
/*      */   
/*      */   static boolean sendGetInviteFriendsGiftTimes(String userid, long roleid, xbean.User xUser)
/*      */   {
/*      */     try
/*      */     {
/*  865 */       String openId = CommonUtils.getOpenId(userid);
/*  866 */       String channel = CommonUtils.getPlatName(userid);
/*  867 */       int zoneid = CommonUtils.getZoneId(userid);
/*  868 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/*  869 */       arg.openid.setString(openId, "UTF-8");
/*  870 */       arg.channel.setString(channel, "UTF-8");
/*  871 */       arg.qtype = 10;
/*  872 */       arg.data_direction = 1;
/*  873 */       OctetsStream os = new OctetsStream();
/*  874 */       os.marshal(zoneid);
/*  875 */       os.marshal(xUser.getInviter_total_gift_times());
/*  876 */       os.marshal(Long.valueOf(SInviteFriendsConsts.getInstance().AWARD_INVITER_GIFT_MAX_TIMES).longValue());
/*  877 */       os.marshal(roleid);
/*  878 */       os.marshal(0);
/*  879 */       os.marshal(0);
/*  880 */       arg.info.replace(os);
/*      */       
/*  882 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*  883 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*  888 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onGetInviteFriendsGiftTimesResp(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/*  896 */       String openId = arg.openid.getString("UTF-8");
/*  897 */       String channel = arg.channel.getString("UTF-8");
/*  898 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/*  899 */       int zoneid = osArgInfo.unmarshal_int();
/*  900 */       String userid = CommonUtils.getUserId(openId, channel, zoneid);
/*  901 */       long totalCostGiftTimes = osArgInfo.unmarshal_long();
/*  902 */       long awardInviterGiftMaxTimes = osArgInfo.unmarshal_long();
/*  903 */       long roleid = osArgInfo.unmarshal_long();
/*      */       
/*  905 */       xbean.User xUser = xtable.User.get(userid);
/*  906 */       if (xUser == null)
/*      */       {
/*  908 */         return false;
/*      */       }
/*      */       
/*  911 */       if (!checkInviterStatus(userid, roleid, xUser))
/*      */       {
/*  913 */         return false;
/*      */       }
/*      */       
/*  916 */       if (totalCostGiftTimes != xUser.getInviter_total_gift_times())
/*      */       {
/*  918 */         return false;
/*      */       }
/*      */       
/*  921 */       String inviteCode = xUser.getInviter_code();
/*      */       
/*  923 */       if (res.retcode != 0)
/*      */       {
/*  925 */         SGetInviteFriendsGiftResp resp = new SGetInviteFriendsGiftResp();
/*  926 */         resp.retcode = res.retcode;
/*  927 */         OnlineManager.getInstance().sendAtOnce(roleid, resp);
/*      */         
/*  929 */         GameServer.logger().info(String.format("[grc]InviteFriendsManager.onGetInviteFriendsGiftTimesResp@get invite friends gift times error|retcode=%d|inviter_userid=%s|roleid=%d|invite_code=%s|total_cost_gift_times=%d|award_inviter_gift_max_times=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalCostGiftTimes), Long.valueOf(awardInviterGiftMaxTimes) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  934 */         return false;
/*      */       }
/*      */       
/*  937 */       OctetsStream osRespInfo = new OctetsStream(res.info);
/*  938 */       int deltaCostGiftTimes = (int)osRespInfo.unmarshal_long();
/*  939 */       long totalGiftTimes = osRespInfo.unmarshal_long();
/*      */       
/*  941 */       xUser.setInviter_total_gift_times(totalCostGiftTimes + deltaCostGiftTimes);
/*  942 */       for (int i = 0; i < deltaCostGiftTimes; i++)
/*      */       {
/*      */ 
/*  945 */         int awardCfgid = SInviteFriendsConsts.getInstance().AWARD_INVITER_CFG_ID;
/*  946 */         AwardReason inviterGiftAwardReason = new AwardReason(LogReason.GRC_INVITER_GIFT_AWARD_ADD, awardCfgid, PresentType.PRESENT_BIND_GRC_INVITER_GIFT_AWARD);
/*      */         
/*  948 */         inviterGiftAwardReason.setAwardItemBind(true);
/*  949 */         AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userid, roleid, true, true, inviterGiftAwardReason);
/*      */         
/*  951 */         if (awardModel == null)
/*      */         {
/*      */ 
/*  954 */           GameServer.logger().info(String.format("[grc]InviteFriendsManager.onGetInviteFriendsGiftTimesResp@award invite friends gift times error|retcode=%d|inviter_userid=%s|roleid=%d|invite_code=%s|total_cost_gift_times=%d|total_gift_times=%d|delta_cost_gift_times=%d|award_inviter_gift_max_times=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalCostGiftTimes), Long.valueOf(totalGiftTimes), Integer.valueOf(deltaCostGiftTimes), Long.valueOf(awardInviterGiftMaxTimes) }));
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*  959 */           return false;
/*      */         }
/*      */       }
/*      */       
/*  963 */       SGetInviteFriendsGiftResp resp = new SGetInviteFriendsGiftResp();
/*  964 */       resp.retcode = 0;
/*  965 */       resp.award_gift_times = ((int)(totalGiftTimes - xUser.getInviter_total_gift_times()));
/*  966 */       OnlineManager.getInstance().send(roleid, resp);
/*      */       
/*  968 */       GameServer.logger().info(String.format("[grc]InviteFriendsManager.onGetInviteFriendsGiftTimesResp@get invite friends gift times success|retcode=%d|inviter_userid=%s|roleid=%d|invite_code=%s|total_cost_gift_times=%d|total_gift_times=%d|delta_cost_gift_times=%d|award_inviter_gift_max_times=%d", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode, Long.valueOf(totalCostGiftTimes), Long.valueOf(totalGiftTimes), Integer.valueOf(deltaCostGiftTimes), Long.valueOf(awardInviterGiftMaxTimes) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  975 */       int level = RoleInterface.getLevel(roleid);
/*  976 */       TLogManager.getInstance().addLog(userid, roleid, "GetInviteFriendsGiftTimes", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(totalCostGiftTimes), Long.valueOf(totalGiftTimes), Integer.valueOf(deltaCostGiftTimes), Long.valueOf(awardInviterGiftMaxTimes), inviteCode });
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  983 */       return true;
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  990 */     return false;
/*      */   }
/*      */   
/*      */   static boolean sendGetInviteFriendsInfo(String userid, long roleid)
/*      */   {
/*      */     try
/*      */     {
/*  997 */       String openId = CommonUtils.getOpenId(userid);
/*  998 */       String channel = CommonUtils.getPlatName(userid);
/*  999 */       int zoneid = CommonUtils.getZoneId(userid);
/* 1000 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1001 */       arg.openid.setString(openId, "UTF-8");
/* 1002 */       arg.channel.setString(channel, "UTF-8");
/* 1003 */       arg.qtype = 11;
/* 1004 */       arg.data_direction = 1;
/* 1005 */       OctetsStream os = new OctetsStream();
/* 1006 */       os.marshal(zoneid);
/* 1007 */       os.marshal(roleid);
/* 1008 */       os.marshal(0);
/* 1009 */       os.marshal(0);
/* 1010 */       arg.info.replace(os);
/*      */       
/* 1012 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*      */       
/* 1014 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/* 1019 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onGetInviteFriendsInfoResp(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1027 */       String openId = arg.openid.getString("UTF-8");
/* 1028 */       String channel = arg.channel.getString("UTF-8");
/* 1029 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 1030 */       int zoneid = osArgInfo.unmarshal_int();
/* 1031 */       String userid = CommonUtils.getUserId(openId, channel, zoneid);
/* 1032 */       long roleid = osArgInfo.unmarshal_long();
/*      */       
/* 1034 */       xbean.User xUser = xtable.User.get(userid);
/* 1035 */       if ((xUser == null) || (xUser.getInviter_code().isEmpty()))
/*      */       {
/* 1037 */         return false;
/*      */       }
/*      */       
/* 1040 */       String inviteCode = xUser.getInviter_code();
/* 1041 */       if (res.retcode != 0)
/*      */       {
/* 1043 */         GameServer.logger().info(String.format("[grc]InviteFriendsManager.onGetInviteFriendsInfoResp@get invite friends info error|retcode=%d|inviter_userid=%s|roleid=%d|invite_code=%s", new Object[] { Integer.valueOf(res.retcode), userid, Long.valueOf(roleid), inviteCode }));
/*      */         
/*      */ 
/*      */ 
/* 1047 */         return false;
/*      */       }
/*      */       
/* 1050 */       OctetsStream osResInfo = new OctetsStream(res.info);
/* 1051 */       int inviteeSize = (int)osResInfo.unmarshal_long();
/* 1052 */       long totalRebateBindYuanbao = osResInfo.unmarshal_long();
/* 1053 */       long oldTotalCostRebateBindYuanbao = osResInfo.unmarshal_long();
/* 1054 */       long totalGiftTimes = osResInfo.unmarshal_long();
/* 1055 */       long oldTotalCostGiftTimes = osResInfo.unmarshal_long();
/* 1056 */       long totalCostRebateBindYuanbao = xUser.getInviter_total_rebate_bind_yuanbao();
/* 1057 */       long totalCostGiftTimes = xUser.getInviter_total_gift_times();
/*      */       
/*      */ 
/* 1060 */       SGetInviteFriendsInfoResp resp = new SGetInviteFriendsInfoResp();
/* 1061 */       resp.invite_code.setString(inviteCode, "UTF-8");
/* 1062 */       resp.invitee_num = inviteeSize;
/* 1063 */       resp.rebate_bind_yuanbao = (totalRebateBindYuanbao - oldTotalCostRebateBindYuanbao + (oldTotalCostRebateBindYuanbao - totalCostRebateBindYuanbao));
/*      */       
/* 1065 */       resp.award_gift_times = ((int)(totalGiftTimes - oldTotalCostGiftTimes + (oldTotalCostGiftTimes - totalCostGiftTimes)));
/* 1066 */       OnlineManager.getInstance().send(roleid, resp);
/*      */       
/*      */ 
/* 1069 */       StringBuilder sbLog = new StringBuilder();
/* 1070 */       sbLog.append("[grc]InviteFriendsManager.onGetInviteFriendsInfoResp@get invite friends info success");
/* 1071 */       sbLog.append("|retcode=").append(res.retcode);
/* 1072 */       sbLog.append("|inviter_userid=").append(userid);
/* 1073 */       sbLog.append("|roleid=").append(roleid);
/* 1074 */       sbLog.append("|invite_code=").append(inviteCode);
/* 1075 */       sbLog.append("|invitee_size=").append(inviteeSize);
/* 1076 */       sbLog.append("|total_rebate_bind_yuanbao=").append(totalRebateBindYuanbao);
/* 1077 */       sbLog.append("|old_total_cost_rebate_bind_yuanbao=").append(oldTotalCostRebateBindYuanbao);
/* 1078 */       sbLog.append("|total_cost_rebate_bind_yuanbao=").append(totalCostRebateBindYuanbao);
/* 1079 */       sbLog.append("|total_gift_times=").append(totalGiftTimes);
/* 1080 */       sbLog.append("|old_total_cost_gift_times=").append(oldTotalCostGiftTimes);
/* 1081 */       sbLog.append("|total_cost_gift_times=").append(totalCostGiftTimes);
/* 1082 */       GameServer.logger().info(sbLog.toString());
/*      */       
/* 1084 */       return true;
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}catch (MarshalException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1095 */     return false;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\InviteFriendsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */