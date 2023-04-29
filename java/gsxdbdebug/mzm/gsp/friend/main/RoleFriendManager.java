/*      */ package mzm.gsp.friend.main;
/*      */ 
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*      */ import mzm.gsp.avatar.main.AvatarInterface;
/*      */ import mzm.gsp.friend.SAddNewFriendRes;
/*      */ import mzm.gsp.friend.SApplyFriendRes;
/*      */ import mzm.gsp.friend.SDisAgreeRes;
/*      */ import mzm.gsp.friend.SFindPlayerRes;
/*      */ import mzm.gsp.friend.SFriendNormalResult;
/*      */ import mzm.gsp.friend.SSynApplyList;
/*      */ import mzm.gsp.friend.SSynFriendAvatarFrame;
/*      */ import mzm.gsp.friend.SSynFriendList;
/*      */ import mzm.gsp.friend.SSyncGRCFriends;
/*      */ import mzm.gsp.friend.SUpdateRelationValue;
/*      */ import mzm.gsp.friend.StrangerInfo;
/*      */ import mzm.gsp.friend.confbean.SFriendConsts;
/*      */ import mzm.gsp.friend.confbean.SFriendValueLimitCfg;
/*      */ import mzm.gsp.friend.event.FriendAddArg;
/*      */ import mzm.gsp.friend.event.FriendDeleteArg;
/*      */ import mzm.gsp.idip.main.IdipManager;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.systemsetting.main.SystemSettingInterface;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.confbean.SServerTextCfg;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.ApplyInfo;
/*      */ import xbean.ApplyInfoMap;
/*      */ import xbean.FriendTotalInfo;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleGrcFriendInfo;
/*      */ import xbean.UserGrcFriendInfo;
/*      */ import xio.Protocol;
/*      */ import xtable.Role2apply;
/*      */ import xtable.Role2friend;
/*      */ 
/*      */ class RoleFriendManager
/*      */ {
/*      */   static final int FRIEND_ADD = 0;
/*      */   static final int FRIEND_DEL = 1;
/*      */   static final int FRIEND_INTIMATE = 2;
/*      */   static final int SAME = 0;
/*      */   static final int NOT_SAME = 1;
/*      */   static final String TLOG_REFUSE_BAN = "AddFriendRefuseBan";
/*      */   
/*      */   static boolean onRolelogin(RoleApply roleApply, RoleFriend roleFriend)
/*      */   {
/*   61 */     int currentSec = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*   62 */     if (roleApply.applySize() > 0)
/*      */     {
/*   64 */       Iterator<Map.Entry<Long, ApplyInfo>> iterator = roleApply.getApplyInfoMap().getApplymap().entrySet().iterator();
/*   65 */       while (iterator.hasNext())
/*      */       {
/*   67 */         Map.Entry<Long, ApplyInfo> entry = (Map.Entry)iterator.next();
/*   68 */         if (((ApplyInfo)entry.getValue()).getApplysec() + getApplyStoreSec() <= currentSec)
/*      */         {
/*   70 */           iterator.remove();
/*      */         }
/*      */         else
/*      */         {
/*   74 */           long interval = ((ApplyInfo)entry.getValue()).getApplysec() + getApplyStoreSec() - currentSec;
/*   75 */           RemApplyInfoSession.addRemApplyInfoSession(interval, roleFriend.getRoleId(), ((Long)entry.getKey()).longValue());
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*   80 */     checkAndclearDayData(roleFriend);
/*   81 */     long roleId = roleFriend.getRoleId();
/*      */     
/*   83 */     mzm.gsp.Role.addRoleProcedure(roleId, new mzm.gsp.util.LogicProcedure()
/*      */     {
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/*   88 */         RoleApply roleApply = RoleFriendManager.getRoleApply(this.val$roleId, false);
/*   89 */         RoleFriend roleFriend = RoleFriendManager.getRoleFriend(this.val$roleId, false);
/*      */         
/*   91 */         RoleFriendManager.sendInitMsg(roleApply, roleFriend);
/*   92 */         return true;
/*      */       }
/*   94 */     });
/*   95 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkAndclearDayData(RoleFriend roleFriend)
/*      */   {
/*  104 */     if (roleFriend.friendSize() > 0)
/*      */     {
/*  106 */       long currentTime = DateTimeUtils.getCurrTimeInMillis() + 1000L;
/*  107 */       long lastClearTime = roleFriend.getFriendTotalInfo().getCleardatatime();
/*  108 */       if (!DateTimeUtils.isInSameDay(lastClearTime, currentTime))
/*      */       {
/*  110 */         for (xbean.FriendInfo friendInfo : roleFriend.getFriendTotalInfo().getFriendinfomap().values())
/*      */         {
/*  112 */           friendInfo.getValuelimitmap().clear();
/*      */         }
/*  114 */         roleFriend.getFriendTotalInfo().setCleardatatime(currentTime);
/*      */       }
/*      */     }
/*      */     
/*  118 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void sendInitMsg(RoleApply roleApply, RoleFriend roleFriend)
/*      */   {
/*  128 */     SSynApplyList synApplyList = new SSynApplyList();
/*  129 */     if (roleApply.applySize() > 0)
/*      */     {
/*  131 */       for (Map.Entry<Long, ApplyInfo> entry : roleApply.getApplyInfoMap().getApplymap().entrySet())
/*      */       {
/*  133 */         StrangerInfo strangerInfo = new StrangerInfo();
/*  134 */         mzm.gsp.role.main.Role strangerRole = RoleInterface.getRole(((Long)entry.getKey()).longValue(), false);
/*  135 */         fillStrangerInfo(strangerRole, ((ApplyInfo)entry.getValue()).getContent(), ((ApplyInfo)entry.getValue()).getApplysec(), strangerInfo);
/*  136 */         synApplyList.applylist.add(strangerInfo);
/*      */       }
/*      */     }
/*  139 */     OnlineManager.getInstance().send(roleApply.getRoleId(), synApplyList);
/*      */     
/*      */ 
/*  142 */     SSynFriendList synFriendList = new SSynFriendList();
/*  143 */     if (roleFriend.friendSize() > 0)
/*      */     {
/*  145 */       for (Map.Entry<Long, xbean.FriendInfo> entry : roleFriend.getFriendTotalInfo().getFriendinfomap().entrySet())
/*      */       {
/*  147 */         mzm.gsp.friend.FriendInfo friendInfo = new mzm.gsp.friend.FriendInfo();
/*  148 */         long friendRoleId = ((Long)entry.getKey()).longValue();
/*      */         int status;
/*  150 */         int status; if (OnlineManager.getInstance().isOnlineOrInProtect(friendRoleId))
/*      */         {
/*  152 */           status = 1;
/*      */         }
/*      */         else
/*      */         {
/*  156 */           status = 2;
/*      */         }
/*  158 */         mzm.gsp.role.main.Role friendRole = RoleInterface.getRole(friendRoleId, false);
/*  159 */         int teamMemCount = 0;
/*  160 */         Long teamid = TeamInterface.getTeamidByRoleid(friendRole.getId(), false);
/*  161 */         if (teamid != null)
/*      */         {
/*  163 */           teamMemCount = TeamInterface.getTeamMemberList(teamid.longValue(), false).size();
/*      */         }
/*  165 */         xbean.FriendInfo xFriendInfo = (xbean.FriendInfo)entry.getValue();
/*  166 */         fillInFriendInfo(friendRole, friendInfo, xFriendInfo.getRelationvalue(), status, teamMemCount, xFriendInfo.getRemarkname());
/*      */         
/*  168 */         synFriendList.friendlist.add(friendInfo);
/*      */       }
/*      */     }
/*  171 */     OnlineManager.getInstance().send(roleFriend.getRoleId(), synFriendList);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendLoginMsgToFriend(RoleFriend roleFriend)
/*      */   {
/*  179 */     mzm.gsp.friend.SSynFriendStatus synFriendStatus = new mzm.gsp.friend.SSynFriendStatus();
/*  180 */     synFriendStatus.friendid = roleFriend.getRoleId();
/*  181 */     synFriendStatus.status = 1;
/*  182 */     if (RoleStatusInterface.containsStatus(roleFriend.getRoleId(), 411))
/*      */     {
/*  184 */       synFriendStatus.reason = 2;
/*      */     }
/*      */     else
/*      */     {
/*  188 */       synFriendStatus.reason = 1;
/*      */     }
/*  190 */     broadCastMsgToFriend(synFriendStatus, roleFriend);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendFriendNameChangeMsg(String newName, RoleFriend roleFriend)
/*      */   {
/*  198 */     mzm.gsp.friend.SSynFriendName synFriendName = new mzm.gsp.friend.SSynFriendName();
/*  199 */     synFriendName.friendid = roleFriend.getRoleId();
/*  200 */     synFriendName.name = newName;
/*  201 */     broadCastMsgToFriend(synFriendName, roleFriend);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendFriendAvatarChangeMsg(int avatarId, RoleFriend friends)
/*      */   {
/*  209 */     mzm.gsp.friend.SSynFriendAvatar msg = new mzm.gsp.friend.SSynFriendAvatar();
/*  210 */     msg.friendid = friends.getRoleId();
/*  211 */     msg.avatarid = avatarId;
/*  212 */     broadCastMsgToFriend(msg, friends);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendFriendAvatarFrameChangeMsg(RoleFriend friend, int avatarFrameId)
/*      */   {
/*  220 */     SSynFriendAvatarFrame msg = new SSynFriendAvatarFrame();
/*  221 */     msg.friendid = friend.getRoleId();
/*  222 */     msg.avatarframeid = avatarFrameId;
/*  223 */     broadCastMsgToFriend(msg, friend);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendError(long roleId, int errorId, String... args)
/*      */   {
/*  231 */     SFriendNormalResult sFriendNormalResult = new SFriendNormalResult();
/*  232 */     sFriendNormalResult.result = errorId;
/*  233 */     for (String arg : args)
/*      */     {
/*  235 */       sFriendNormalResult.args.add(arg);
/*      */     }
/*      */     
/*  238 */     OnlineManager.getInstance().sendAtOnce(roleId, sFriendNormalResult);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendFindPlayerRes(long roleId, mzm.gsp.role.main.Role findRole)
/*      */   {
/*  246 */     boolean isOnline = OnlineManager.getInstance().isOnline(findRole.getId());
/*  247 */     SFindPlayerRes sFindPlayerRes = new SFindPlayerRes();
/*  248 */     sFindPlayerRes.roleid = findRole.getId();
/*  249 */     sFindPlayerRes.rolename = findRole.getName();
/*  250 */     sFindPlayerRes.rolelevel = findRole.getLevel();
/*  251 */     sFindPlayerRes.occupationid = findRole.getOccupationId();
/*  252 */     sFindPlayerRes.sex = findRole.getGender();
/*  253 */     if (isOnline)
/*      */     {
/*  255 */       sFindPlayerRes.onlinestatus = 1;
/*      */     }
/*      */     else
/*      */     {
/*  259 */       sFindPlayerRes.onlinestatus = 2;
/*      */     }
/*  261 */     sFindPlayerRes.friendset = SystemSettingInterface.getSetting(findRole.getId(), 2).intValue();
/*  262 */     sFindPlayerRes.avatarid = AvatarInterface.getCurrentAvatar(findRole.getId(), false);
/*  263 */     sFindPlayerRes.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(findRole.getId(), false);
/*  264 */     OnlineManager.getInstance().sendAtOnce(roleId, sFindPlayerRes);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getFriendSet(long roleid)
/*      */   {
/*  289 */     int friendSetValue = SystemSettingInterface.getSetting(roleid, 2).intValue();
/*  290 */     return friendSetValue == 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isAddFriendLvSet(long roleid)
/*      */   {
/*  298 */     int addFriendLvSet = SystemSettingInterface.getSetting(roleid, 4).intValue();
/*  299 */     return addFriendLvSet == 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getAddFriendRequiredLevel(long roleId)
/*      */   {
/*  307 */     return SystemSettingInterface.getSetting(roleId, 6).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean meetLevelRequirementToAddFriend(long currentRoleId, long targetRoleId)
/*      */   {
/*  316 */     return (!isAddFriendLvSet(targetRoleId)) || (RoleInterface.getLevel(currentRoleId) >= getAddFriendRequiredLevel(targetRoleId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean applyAddFriend(RoleFriend roleFriend0, RoleApply roleApply0, RoleFriend targetFriend, RoleApply targetRoleApply, String content)
/*      */   {
/*  326 */     long applyerId = roleFriend0.getRoleId();
/*  327 */     long targetPlayerId = targetFriend.getRoleId();
/*  328 */     if (content == null)
/*      */     {
/*  330 */       content = "";
/*      */     }
/*  332 */     if (Math.ceil(mzm.gsp.util.CommonUtils.getUTF16Length(content) / 2.0D) > SFriendConsts.getInstance().validateWordsMax)
/*      */     {
/*      */ 
/*  335 */       sendError(applyerId, 21, new String[0]);
/*  336 */       return false;
/*      */     }
/*      */     
/*  339 */     if (mzm.gsp.sensitive.main.SensitiveInterface.isContentSensitive(content))
/*      */     {
/*  341 */       sendError(applyerId, 23, new String[0]);
/*  342 */       return false;
/*      */     }
/*      */     
/*  345 */     if (applyerId == targetPlayerId)
/*      */     {
/*  347 */       return false;
/*      */     }
/*  349 */     int timeSec = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*      */     
/*  351 */     if (roleFriend0.containsRole(targetPlayerId))
/*      */     {
/*      */ 
/*  354 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  358 */     if (roleApply0.containsRole(targetPlayerId))
/*      */     {
/*      */ 
/*  361 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */     try
/*      */     {
/*  367 */       String applyName = RoleInterface.getName(applyerId);
/*  368 */       String headImageURL = mzm.gsp.personal.main.PersonalInterface.getHeadImageURL(applyerId, false);
/*  369 */       if (headImageURL.isEmpty())
/*      */       {
/*  371 */         headImageURL = "0";
/*      */       }
/*  373 */       String targetUserid = RoleInterface.getUserId(targetPlayerId);
/*  374 */       String targetOpenid = mzm.gsp.util.CommonUtils.getOpenId(targetUserid);
/*  375 */       int targetLevel = RoleInterface.getLevel(targetPlayerId);
/*  376 */       String targetName = RoleInterface.getName(targetPlayerId);
/*  377 */       String info = content;
/*  378 */       IdipManager.addFriendTLogAsync(applyerId, applyName, headImageURL, info, targetOpenid, targetPlayerId, targetLevel, targetName);
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */ 
/*  384 */       GameServer.logger().error(String.format("[Friend]RoleFriendManager.applyAddFriend@error happen|roleid=%d", new Object[] { Long.valueOf(applyerId) }), e);
/*      */     }
/*      */     
/*      */ 
/*  388 */     boolean friendVal = getFriendSet(targetPlayerId);
/*  389 */     if (!friendVal)
/*      */     {
/*      */ 
/*  392 */       addApplyOthersCount(roleApply0, targetPlayerId, content);
/*      */       
/*  394 */       if (!checkToBeFriend(roleFriend0, targetFriend))
/*      */       {
/*  396 */         return false;
/*      */       }
/*  398 */       boolean ret = beFriendTOEachOther(roleFriend0, targetFriend);
/*  399 */       if (ret)
/*      */       {
/*  401 */         mzm.gsp.chat.main.ChatInterface.chatToSbNoneRealTime(applyerId, targetPlayerId, SFriendConsts.getInstance().addFriendChatId);
/*      */       }
/*  403 */       return ret;
/*      */     }
/*      */     
/*  406 */     if (targetRoleApply.containsRole(applyerId))
/*      */     {
/*      */ 
/*  409 */       return false;
/*      */     }
/*      */     
/*  412 */     addApplyOthersCount(roleApply0, targetPlayerId, content);
/*      */     
/*  414 */     if (targetRoleApply.getApplyInfoMap() == null)
/*      */     {
/*  416 */       ApplyInfoMap applyInfoMap = Pod.newApplyInfoMap();
/*  417 */       targetRoleApply.setApplyInfoMap(applyInfoMap);
/*  418 */       Role2apply.insert(Long.valueOf(targetPlayerId), applyInfoMap);
/*      */     }
/*      */     
/*  421 */     ApplyInfo applyInfo = Pod.newApplyInfo();
/*  422 */     applyInfo.setApplysec(timeSec);
/*  423 */     applyInfo.setContent(content);
/*  424 */     targetRoleApply.getApplyInfoMap().getApplymap().put(Long.valueOf(applyerId), applyInfo);
/*      */     
/*      */ 
/*  427 */     SApplyFriendRes sApplyFriendRes = new SApplyFriendRes();
/*      */     
/*  429 */     mzm.gsp.role.main.Role applyRole = RoleInterface.getRole(applyerId, false);
/*  430 */     fillStrangerInfo(applyRole, content, timeSec, sApplyFriendRes.strangerinfo);
/*  431 */     OnlineManager.getInstance().send(targetPlayerId, sApplyFriendRes);
/*      */     
/*  433 */     if (targetRoleApply.applySize() > getMaxApplyCount())
/*      */     {
/*  435 */       long remRoleId = applyerId;
/*  436 */       int sec = timeSec;
/*  437 */       for (Map.Entry<Long, ApplyInfo> entry : targetRoleApply.getApplyInfoMap().getApplymap().entrySet())
/*      */       {
/*  439 */         if (((ApplyInfo)entry.getValue()).getApplysec() < sec)
/*      */         {
/*  441 */           remRoleId = ((Long)entry.getKey()).longValue();
/*  442 */           sec = ((ApplyInfo)entry.getValue()).getApplysec();
/*      */         }
/*      */       }
/*  445 */       targetRoleApply.getApplyInfoMap().getApplymap().remove(Long.valueOf(remRoleId));
/*      */       
/*  447 */       SDisAgreeRes sDisAgreeRes = new SDisAgreeRes();
/*  448 */       sDisAgreeRes.strangerid = remRoleId;
/*  449 */       OnlineManager.getInstance().send(targetRoleApply.getRoleId(), sDisAgreeRes);
/*      */     }
/*  451 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void addApplyOthersCount(RoleApply roleApply0, long targetPlayerId, String content)
/*      */   {
/*  460 */     ApplyInfoMap applyInfoMap = roleApply0.getApplyInfoMap();
/*  461 */     if (applyInfoMap == null)
/*      */     {
/*  463 */       applyInfoMap = Pod.newApplyInfoMap();
/*  464 */       roleApply0.setApplyInfoMap(applyInfoMap);
/*  465 */       Role2apply.insert(Long.valueOf(roleApply0.getRoleId()), applyInfoMap);
/*      */     }
/*  467 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  468 */     if (DateTimeUtils.isInSameDay(applyInfoMap.getCleardatatime(), curTime))
/*      */     {
/*  470 */       applyInfoMap.setApplyaddcount(applyInfoMap.getApplyaddcount() + 1);
/*      */     }
/*      */     else
/*      */     {
/*  474 */       clearApplyDayData(curTime, applyInfoMap);
/*  475 */       applyInfoMap.setApplyaddcount(1);
/*      */     }
/*  477 */     Octets contentOctets = null;
/*  478 */     if ((content != null) && (!content.isEmpty()))
/*      */     {
/*  480 */       contentOctets = new Octets();
/*      */       try
/*      */       {
/*  483 */         contentOctets.setString(content, "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  487 */         GameServer.logger().error("[Friend]RoleFriendManage.addApplyOthersCount@transfor string error", e);
/*      */       }
/*      */     }
/*  490 */     IdipManager.chatTLog(roleApply0.getRoleId(), 0L, 0L, targetPlayerId, 101, null, contentOctets);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void clearApplyDayData(long curTime, ApplyInfoMap xApplyInfoMap)
/*      */   {
/*  496 */     xApplyInfoMap.setCleardatatime(curTime);
/*  497 */     xApplyInfoMap.setApplyaddcount(0);
/*  498 */     xApplyInfoMap.setApplyaddrefusecount(0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMaxApplyCount()
/*      */   {
/*  506 */     return SFriendConsts.getInstance().applyCountMax;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMaxFriendCount()
/*      */   {
/*  514 */     return SFriendConsts.getInstance().friendCountMax;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getApplyStoreSec()
/*      */   {
/*  522 */     return SFriendConsts.getInstance().applyTimeMax * 3600;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static RoleApply getRoleApply(long roleId, boolean retainLock)
/*      */   {
/*  530 */     return new RoleApply(roleId, retainLock);
/*      */   }
/*      */   
/*      */   private static void fillStrangerInfo(mzm.gsp.role.main.Role role, String content, int applyTime, StrangerInfo strangerInfo)
/*      */   {
/*  535 */     strangerInfo.applytime = applyTime;
/*  536 */     strangerInfo.rolelevel = role.getLevel();
/*  537 */     strangerInfo.occupationid = role.getOccupationId();
/*  538 */     strangerInfo.sex = role.getGender();
/*  539 */     strangerInfo.rolename = role.getName();
/*  540 */     strangerInfo.roleid = role.getId();
/*  541 */     strangerInfo.content = content;
/*  542 */     strangerInfo.avatarid = AvatarInterface.getCurrentAvatar(role.getId(), false);
/*  543 */     strangerInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(role.getId(), false);
/*      */   }
/*      */   
/*      */   static RoleFriend getRoleFriend(long roleId, boolean retainLock)
/*      */   {
/*  548 */     return new RoleFriend(roleId, retainLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean agreeApply(RoleApply roleApply, RoleFriend roleFriend, RoleFriend otherRoleFriend)
/*      */   {
/*  557 */     if (!roleApply.containsRole(otherRoleFriend.getRoleId()))
/*      */     {
/*  559 */       return false;
/*      */     }
/*      */     
/*  562 */     if (!checkToBeFriend(roleFriend, otherRoleFriend))
/*      */     {
/*  564 */       return false;
/*      */     }
/*      */     
/*  567 */     boolean suc = beFriendTOEachOther(roleFriend, otherRoleFriend);
/*  568 */     mzm.gsp.friend.SAgreeApplyRes sAgreeApplyRes = new mzm.gsp.friend.SAgreeApplyRes();
/*  569 */     sAgreeApplyRes.strangerid = otherRoleFriend.getRoleId();
/*  570 */     OnlineManager.getInstance().send(roleFriend.getRoleId(), sAgreeApplyRes);
/*  571 */     return suc;
/*      */   }
/*      */   
/*      */ 
/*      */   private static boolean beFriendTOEachOther(RoleFriend roleFriend, RoleFriend otherRoleFriend)
/*      */   {
/*  577 */     RoleApply roleApply = getRoleApply(roleFriend.getRoleId(), true);
/*  578 */     if (roleApply.containsRole(otherRoleFriend.getRoleId()))
/*      */     {
/*  580 */       roleApply.getApplyInfoMap().getApplymap().remove(Long.valueOf(otherRoleFriend.getRoleId()));
/*      */     }
/*      */     
/*  583 */     RoleApply roleOtherApply = getRoleApply(otherRoleFriend.getRoleId(), true);
/*  584 */     if (roleOtherApply.containsRole(roleFriend.getRoleId()))
/*      */     {
/*  586 */       roleOtherApply.getApplyInfoMap().getApplymap().remove(Long.valueOf(roleFriend.getRoleId()));
/*      */     }
/*  588 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  589 */     beFriend(roleFriend, otherRoleFriend, curTime);
/*  590 */     beFriend(otherRoleFriend, roleFriend, curTime);
/*  591 */     long roleid = roleFriend.getRoleId();
/*  592 */     long roleid1 = otherRoleFriend.getRoleId();
/*  593 */     String userid = RoleInterface.getUserId(roleid);
/*  594 */     String userid1 = RoleInterface.getUserId(roleid1);
/*  595 */     int relationValue = roleFriend.getRelationValue(roleid1);
/*  596 */     tlogFriend(userid, roleid, userid1, roleid1, 0, relationValue);
/*  597 */     logFriend(userid, roleid, userid1, roleid1, 0);
/*  598 */     tlogFriend(userid1, roleid1, userid, roleid, 0, relationValue);
/*  599 */     logFriend(userid1, roleid1, userid, roleid, 0);
/*      */     
/*  601 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void beFriend(RoleFriend roleFriend, RoleFriend otherRoleFriend, long curTime)
/*      */   {
/*  609 */     if (roleFriend.getFriendTotalInfo() == null)
/*      */     {
/*  611 */       FriendTotalInfo friendTotalInfo = Pod.newFriendTotalInfo();
/*  612 */       Role2friend.insert(Long.valueOf(roleFriend.getRoleId()), friendTotalInfo);
/*  613 */       roleFriend.setFriendTotalInfo(friendTotalInfo);
/*      */     }
/*  615 */     xbean.FriendInfo friendInfoBean = Pod.newFriendInfo();
/*  616 */     friendInfoBean.setRelationvalue(0);
/*  617 */     friendInfoBean.setBefriendtime(curTime);
/*  618 */     long otherRoleId = otherRoleFriend.getRoleId();
/*  619 */     roleFriend.getFriendTotalInfo().getFriendinfomap().put(Long.valueOf(otherRoleId), friendInfoBean);
/*      */     
/*  621 */     mzm.gsp.role.main.Role strangerRole = RoleInterface.getRole(otherRoleId, false);
/*  622 */     int status = 0;
/*  623 */     if (OnlineManager.getInstance().isOnline(otherRoleId))
/*      */     {
/*  625 */       status = 1;
/*      */     }
/*      */     else
/*      */     {
/*  629 */       status = 2;
/*      */     }
/*  631 */     SAddNewFriendRes sAddNewFriendRes = new SAddNewFriendRes();
/*  632 */     int teamMemCount = 0;
/*  633 */     Long teamId = TeamInterface.getTeamidByRoleid(strangerRole.getId(), false);
/*  634 */     if (teamId != null)
/*      */     {
/*  636 */       teamMemCount = TeamInterface.getTeamMemberList(teamId.longValue(), false).size();
/*      */     }
/*  638 */     fillInFriendInfo(strangerRole, sAddNewFriendRes.friendinfo, 0, status, teamMemCount, "");
/*  639 */     OnlineManager.getInstance().send(roleFriend.getRoleId(), sAddNewFriendRes);
/*      */     
/*      */ 
/*  642 */     FriendAddArg friendAddArg = new FriendAddArg(roleFriend.getRoleId(), otherRoleId);
/*  643 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.friend.event.FriendAddEvent(), friendAddArg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean checkToBeFriend(RoleFriend roleFriend, RoleFriend otherRoleFriend)
/*      */   {
/*  651 */     if (roleFriend.containsRole(otherRoleFriend.getRoleId()))
/*      */     {
/*      */ 
/*  654 */       return false;
/*      */     }
/*  656 */     if (roleFriend.friendSize() >= getMaxFriendCount())
/*      */     {
/*      */ 
/*  659 */       return false;
/*      */     }
/*  661 */     if (otherRoleFriend.friendSize() >= getMaxFriendCount())
/*      */     {
/*      */ 
/*  664 */       sendError(roleFriend.getRoleId(), 11, new String[0]);
/*  665 */       return false;
/*      */     }
/*  667 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void fillInFriendInfo(mzm.gsp.role.main.Role role, mzm.gsp.friend.FriendInfo friendInfo, int relationValue, int status, int teamMemCount, String remarkName)
/*      */   {
/*  673 */     friendInfo.sex = role.getGender();
/*  674 */     friendInfo.occupationid = role.getOccupationId();
/*  675 */     friendInfo.relationvalue = relationValue;
/*  676 */     friendInfo.roleid = role.getId();
/*  677 */     friendInfo.rolelevel = role.getLevel();
/*  678 */     friendInfo.rolename = role.getName();
/*  679 */     friendInfo.onlinestatus = status;
/*  680 */     friendInfo.teammemcount = teamMemCount;
/*  681 */     friendInfo.delstatus = RoleInterface.getDeleteState(role.getId(), false);
/*  682 */     friendInfo.avatarid = AvatarInterface.getCurrentAvatar(role.getId(), false);
/*  683 */     friendInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(role.getId(), false);
/*  684 */     friendInfo.remarkname = remarkName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void remOutTimeApply(RoleApply roleApply, long applyId)
/*      */   {
/*  693 */     if (roleApply.containsRole(applyId))
/*      */     {
/*  695 */       ApplyInfo applyInfo = (ApplyInfo)roleApply.getApplyInfoMap().getApplymap().get(Long.valueOf(applyId));
/*  696 */       long curSec = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  697 */       if (curSec >= applyInfo.getApplysec() + getApplyStoreSec() - 1)
/*      */       {
/*  699 */         roleApply.getApplyInfoMap().getApplymap().remove(Long.valueOf(applyId));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean disAgreeApply(RoleApply roleApply, long strangerId)
/*      */   {
/*  710 */     SDisAgreeRes res = new SDisAgreeRes();
/*  711 */     res.strangerid = strangerId;
/*      */     
/*  713 */     if (!roleApply.containsRole(strangerId))
/*      */     {
/*  715 */       return false;
/*      */     }
/*  717 */     roleApply.getApplyInfoMap().getApplymap().remove(Long.valueOf(strangerId));
/*  718 */     OnlineManager.getInstance().send(roleApply.getRoleId(), res);
/*      */     
/*  720 */     RoleApply targetRoleApply = getRoleApply(strangerId, true);
/*  721 */     addApplyRefuseCount(targetRoleApply, roleApply.getRoleId());
/*  722 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void addApplyRefuseCount(RoleApply targetRoleApply, long refuseRoleid)
/*      */   {
/*  730 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  731 */     ApplyInfoMap xApplyInfoMap = targetRoleApply.getApplyInfoMap();
/*  732 */     if (xApplyInfoMap == null)
/*      */     {
/*  734 */       xApplyInfoMap = Pod.newApplyInfoMap();
/*  735 */       targetRoleApply.setApplyInfoMap(xApplyInfoMap);
/*  736 */       Role2apply.insert(Long.valueOf(targetRoleApply.getRoleId()), xApplyInfoMap);
/*      */     }
/*  738 */     if (DateTimeUtils.isInSameDay(curTime, xApplyInfoMap.getCleardatatime()))
/*      */     {
/*  740 */       xApplyInfoMap.setApplyaddrefusecount(xApplyInfoMap.getApplyaddrefusecount() + 1);
/*      */     }
/*      */     else
/*      */     {
/*  744 */       clearApplyDayData(curTime, xApplyInfoMap);
/*  745 */       xApplyInfoMap.setApplyaddrefusecount(1);
/*      */     }
/*  747 */     IdipManager.chatTLog(targetRoleApply.getRoleId(), 0L, 0L, refuseRoleid, 104, null, null);
/*      */     
/*      */ 
/*  750 */     if (DateTimeUtils.diffDays(curTime, xApplyInfoMap.getRefusebanchecktime()) >= SFriendConsts.getInstance().refuseBanDetermineDay)
/*      */     {
/*      */ 
/*  753 */       xApplyInfoMap.setRefusebanchecktime(curTime);
/*  754 */       xApplyInfoMap.getRefusecountmap().clear();
/*      */     }
/*  756 */     Integer refuseCount = (Integer)xApplyInfoMap.getRefusecountmap().get(Long.valueOf(refuseRoleid));
/*  757 */     Integer localInteger1; if (refuseCount == null)
/*      */     {
/*  759 */       refuseCount = Integer.valueOf(1);
/*      */     }
/*      */     else
/*      */     {
/*  763 */       localInteger1 = refuseCount;Integer localInteger2 = refuseCount = Integer.valueOf(refuseCount.intValue() + 1);
/*      */     }
/*  765 */     xApplyInfoMap.getRefusecountmap().put(Long.valueOf(refuseRoleid), refuseCount);
/*  766 */     if (GameServer.logger().isDebugEnabled())
/*      */     {
/*  768 */       GameServer.logger().debug(String.format("[friend]RoleFriendManager.addApplyRefuseCount@be refused|roleId=%d|refuseRoleId=%d|refuseCount=%d|banCheckTime=%d", new Object[] { Long.valueOf(targetRoleApply.getRoleId()), Long.valueOf(refuseRoleid), refuseCount, Long.valueOf(xApplyInfoMap.getRefusebanchecktime()) }));
/*      */     }
/*      */     
/*      */ 
/*  772 */     if (mzm.gsp.open.main.OpenInterface.getOpenStatus(324))
/*      */     {
/*  774 */       if (refuseCount.intValue() >= SFriendConsts.getInstance().refuseBanThreshold)
/*      */       {
/*  776 */         int banSeconds = SFriendConsts.getInstance().refuseBanHour * 60 * 60;
/*  777 */         int banExpireTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L + banSeconds);
/*  778 */         String reason = SServerTextCfg.get(SFriendConsts.getInstance().refuseBanDescriptionId).text;
/*  779 */         mzm.gsp.online.main.ForbidInfoManager.forbidRole(targetRoleApply.getRoleId(), banSeconds, reason);
/*  780 */         String userId = RoleInterface.getUserId(targetRoleApply.getRoleId());
/*  781 */         if (userId != null)
/*      */         {
/*  783 */           TLogManager.getInstance().addLog(userId, "AddFriendRefuseBan", new Object[] { mzm.gsp.GameServerInfoManager.getHostIP(), userId, Long.valueOf(targetRoleApply.getRoleId()), Integer.valueOf(RoleInterface.getLevel(targetRoleApply.getRoleId())), Integer.valueOf(banExpireTime), Long.valueOf(refuseRoleid), Integer.valueOf(xApplyInfoMap.getApplyaddcount()), Integer.valueOf(xApplyInfoMap.getApplyaddrefusecount()) });
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean delFriend(RoleFriend roleFriend0, RoleFriend roleFriend1)
/*      */   {
/*  797 */     long roleid = roleFriend0.getRoleId();
/*  798 */     long roleid1 = roleFriend1.getRoleId();
/*  799 */     if (!roleFriend0.containsRole(roleFriend1.getRoleId()))
/*      */     {
/*  801 */       GameServer.logger().error(String.format("[Friend]PCDelFriend.processImp@not friend|roleid=%d|friendid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(roleid1) }));
/*      */       
/*  803 */       return false;
/*      */     }
/*  805 */     int relationValue = roleFriend0.getRelationValue(roleid1);
/*  806 */     delFriend(roleFriend0, roleid1);
/*  807 */     delFriend(roleFriend1, roleid);
/*      */     
/*  809 */     mzm.gsp.friend.event.FriendPointChangeArg friendPointChangeArg = new mzm.gsp.friend.event.FriendPointChangeArg(roleid, roleid1, 0, -relationValue);
/*  810 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.friend.event.FriendPointChange(), friendPointChangeArg);
/*      */     
/*      */ 
/*  813 */     String userid = RoleInterface.getUserId(roleid);
/*  814 */     String userid1 = RoleInterface.getUserId(roleid1);
/*  815 */     tlogFriend(userid, roleid, userid1, roleid1, 1, 0);
/*  816 */     logFriend(userid, roleid, userid1, roleid1, 1);
/*  817 */     tlogFriend(userid1, roleid1, userid, roleid, 1, 0);
/*  818 */     logFriend(userid1, roleid1, userid, roleid, 1);
/*  819 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void delFriend(RoleFriend roleFriend, long friendId)
/*      */   {
/*  830 */     roleFriend.getFriendTotalInfo().getFriendinfomap().remove(Long.valueOf(friendId));
/*      */     
/*      */ 
/*  833 */     FriendDeleteArg friendDeleteArg = new FriendDeleteArg(roleFriend.getRoleId(), friendId);
/*  834 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.friend.event.FriendDeleteEvent(), friendDeleteArg);
/*      */     
/*  836 */     mzm.gsp.friend.SDelFriendRes sDelFriendRes = new mzm.gsp.friend.SDelFriendRes();
/*  837 */     sDelFriendRes.friendid = friendId;
/*  838 */     OnlineManager.getInstance().send(roleFriend.getRoleId(), sDelFriendRes);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int addFriendValue(RoleFriend roleFriend, long roleId1, int friendValue, int limitType)
/*      */   {
/*  848 */     if (friendValue <= 0)
/*      */     {
/*  850 */       return 0;
/*      */     }
/*  852 */     SFriendValueLimitCfg friendValueLimitCfg = FriendCfgManager.getFriendValueLimitCfg(limitType);
/*  853 */     if (friendValueLimitCfg == null)
/*      */     {
/*  855 */       return 0;
/*      */     }
/*  857 */     int canAdd = friendValue;
/*  858 */     if (roleFriend.containsRole(roleId1))
/*      */     {
/*  860 */       xbean.FriendInfo friendInfo = (xbean.FriendInfo)roleFriend.getFriendTotalInfo().getFriendinfomap().get(Long.valueOf(roleId1));
/*      */       
/*      */ 
/*  863 */       int toMax = SFriendConsts.getInstance().maxQinMiDu - friendInfo.getRelationvalue();
/*  864 */       canAdd = Math.min(toMax, canAdd);
/*      */       
/*      */ 
/*  867 */       int curDayValue = 0;
/*  868 */       if (friendValueLimitCfg.dayLimit > 0)
/*      */       {
/*  870 */         if (friendInfo.getValuelimitmap().containsKey(Integer.valueOf(limitType)))
/*      */         {
/*  872 */           curDayValue = ((Integer)friendInfo.getValuelimitmap().get(Integer.valueOf(limitType))).intValue();
/*  873 */           canAdd = Math.min(canAdd, friendValueLimitCfg.dayLimit - curDayValue);
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  878 */           canAdd = Math.min(canAdd, friendValueLimitCfg.dayLimit);
/*      */         }
/*      */       }
/*      */       
/*  882 */       if (friendValueLimitCfg.totalLimit > 0)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  892 */         canAdd = Math.min(canAdd, friendValueLimitCfg.totalLimit - friendInfo.getRelationvalue());
/*      */       }
/*      */       
/*  895 */       if (canAdd > 0)
/*      */       {
/*      */ 
/*  898 */         friendInfo.getValuelimitmap().put(Integer.valueOf(limitType), Integer.valueOf(curDayValue + canAdd));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  903 */         friendInfo.setRelationvalue(friendInfo.getRelationvalue() + canAdd);
/*      */         
/*      */ 
/*  906 */         SUpdateRelationValue sUpdateRelationValue = new SUpdateRelationValue();
/*  907 */         sUpdateRelationValue.friendid = roleId1;
/*  908 */         sUpdateRelationValue.relationvalue = friendInfo.getRelationvalue();
/*  909 */         OnlineManager.getInstance().send(roleFriend.getRoleId(), sUpdateRelationValue);
/*      */         
/*  911 */         long roleid = roleFriend.getRoleId();
/*  912 */         String userid = RoleInterface.getUserId(roleid);
/*  913 */         String userid1 = RoleInterface.getUserId(roleId1);
/*      */         
/*  915 */         tlogFriend(userid, roleid, userid1, roleId1, 2, friendInfo.getRelationvalue());
/*      */       }
/*      */       
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  922 */       canAdd = 0;
/*      */     }
/*      */     
/*  925 */     return canAdd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static int cutFriendValue(RoleFriend roleFriend, long roleId1, int friendValue)
/*      */   {
/*  933 */     if (friendValue <= 0)
/*      */     {
/*  935 */       return 0;
/*      */     }
/*  937 */     int canCut = friendValue;
/*  938 */     if (roleFriend.containsRole(roleId1))
/*      */     {
/*  940 */       xbean.FriendInfo friendInfo = (xbean.FriendInfo)roleFriend.getFriendTotalInfo().getFriendinfomap().get(Long.valueOf(roleId1));
/*  941 */       canCut = Math.min(canCut, friendInfo.getRelationvalue());
/*  942 */       if (canCut > 0)
/*      */       {
/*      */ 
/*  945 */         friendInfo.setRelationvalue(friendInfo.getRelationvalue() - canCut);
/*      */         
/*  947 */         SUpdateRelationValue sUpdateRelationValue = new SUpdateRelationValue();
/*  948 */         sUpdateRelationValue.friendid = roleId1;
/*  949 */         sUpdateRelationValue.relationvalue = friendInfo.getRelationvalue();
/*  950 */         OnlineManager.getInstance().send(roleFriend.getRoleId(), sUpdateRelationValue);
/*      */       }
/*      */       
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  957 */       canCut = 0;
/*      */     }
/*      */     
/*  960 */     return canCut;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void setFriendValue(RoleFriend roleFriend0, RoleFriend roleFriend1, int friendValue)
/*      */   {
/*  969 */     if (roleFriend0.containsRole(roleFriend1.getRoleId()))
/*      */     {
/*  971 */       xbean.FriendInfo friendInfo = (xbean.FriendInfo)roleFriend0.getFriendTotalInfo().getFriendinfomap().get(Long.valueOf(roleFriend1.getRoleId()));
/*  972 */       friendInfo.setRelationvalue(friendValue);
/*  973 */       SUpdateRelationValue sUpdateRelationValue = new SUpdateRelationValue();
/*  974 */       sUpdateRelationValue.friendid = roleFriend1.getRoleId();
/*  975 */       sUpdateRelationValue.relationvalue = friendInfo.getRelationvalue();
/*  976 */       OnlineManager.getInstance().send(roleFriend0.getRoleId(), sUpdateRelationValue);
/*      */     }
/*  978 */     if (roleFriend1.containsRole(roleFriend0.getRoleId()))
/*      */     {
/*  980 */       xbean.FriendInfo friendInfo = (xbean.FriendInfo)roleFriend1.getFriendTotalInfo().getFriendinfomap().get(Long.valueOf(roleFriend0.getRoleId()));
/*  981 */       friendInfo.setRelationvalue(friendValue);
/*  982 */       SUpdateRelationValue sUpdateRelationValue = new SUpdateRelationValue();
/*  983 */       sUpdateRelationValue.friendid = roleFriend0.getRoleId();
/*  984 */       sUpdateRelationValue.relationvalue = friendInfo.getRelationvalue();
/*  985 */       OnlineManager.getInstance().send(roleFriend1.getRoleId(), sUpdateRelationValue);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onPlayerTrueDelete(RoleFriend roleFriend)
/*      */   {
/*  994 */     if (roleFriend.friendSize() <= 0)
/*      */     {
/*  996 */       return;
/*      */     }
/*  998 */     long roleid = roleFriend.getRoleId();
/*  999 */     for (Iterator i$ = roleFriend.getFriendTotalInfo().getFriendinfomap().keySet().iterator(); i$.hasNext();) { long friendid = ((Long)i$.next()).longValue();
/*      */       
/* 1001 */       xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*      */       {
/*      */ 
/*      */         protected boolean processImp()
/*      */           throws Exception
/*      */         {
/* 1007 */           lock(Role2friend.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.val$roleid), Long.valueOf(this.val$friendid) }));
/* 1008 */           RoleFriend roleFriend0 = RoleFriendManager.getRoleFriend(this.val$roleid, true);
/* 1009 */           RoleFriendManager.delFriend(roleFriend0, this.val$friendid);
/* 1010 */           RoleFriend roleFriend1 = RoleFriendManager.getRoleFriend(this.val$friendid, true);
/* 1011 */           RoleFriendManager.delFriend(roleFriend1, this.val$roleid);
/*      */           
/* 1013 */           long roleid = roleFriend0.getRoleId();
/* 1014 */           long roleid1 = roleFriend1.getRoleId();
/* 1015 */           String userid = RoleInterface.getUserId(roleid);
/* 1016 */           String userid1 = RoleInterface.getUserId(roleid1);
/* 1017 */           RoleFriendManager.tlogFriend(userid, roleid, userid1, roleid1, 1, 0);
/* 1018 */           RoleFriendManager.logFriend(userid, roleid, userid1, roleid1, 1);
/* 1019 */           RoleFriendManager.tlogFriend(userid1, roleid1, userid, roleid, 1, 0);
/* 1020 */           RoleFriendManager.logFriend(userid1, roleid1, userid, roleid, 1);
/* 1021 */           return true;
/*      */         }
/*      */       });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected static void broadCastMsgToFriend(Protocol protocol, RoleFriend roleFriend)
/*      */   {
/* 1032 */     if (roleFriend.friendSize() > 0)
/*      */     {
/* 1034 */       List<Long> friendIdsList = new ArrayList();
/* 1035 */       friendIdsList.addAll(roleFriend.getFriendTotalInfo().getFriendinfomap().keySet());
/* 1036 */       OnlineManager.getInstance().sendMulti(protocol, friendIdsList);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogFriend(String userid, long roleid, String userid1, long roleid1, int type, int intimate)
/*      */   {
/* 1045 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 1046 */     int rolelevel1 = RoleInterface.getLevel(roleid1);
/* 1047 */     String openid1 = gnet.link.Onlines.getInstance().findOpenid(userid1);
/* 1048 */     int sameornot = 0;
/* 1049 */     int gender = RoleInterface.getGender(roleid);
/* 1050 */     int gender1 = RoleInterface.getGender(roleid1);
/* 1051 */     if (gender == gender1)
/*      */     {
/* 1053 */       sameornot = 0;
/*      */     }
/*      */     else
/*      */     {
/* 1057 */       sameornot = 1;
/*      */     }
/*      */     
/*      */ 
/* 1061 */     String logStr = String.format("%s|%d|%d|%s|%d|%d|%d|%s|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), userid1, Long.valueOf(roleid1), Integer.valueOf(rolelevel1), Integer.valueOf(type), openid1, Integer.valueOf(sameornot), Integer.valueOf(intimate) });
/*      */     
/* 1063 */     TLogManager.getInstance().addLog(userid, "Friend", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logFriend(String userid, long roleid, String userid1, long roleid1, int type)
/*      */   {
/* 1071 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 1072 */     int rolelevel1 = RoleInterface.getLevel(roleid1);
/*      */     
/*      */ 
/* 1075 */     String logStr = String.format("%s|%d|%d|%s|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), userid1, Long.valueOf(roleid1), Integer.valueOf(rolelevel1), Integer.valueOf(type) });
/* 1076 */     mzm.gsp.util.LogManager.getInstance().addLog("friend", logStr);
/*      */   }
/*      */   
/*      */   protected static void broadCastMsgToFriendExcept(Protocol protocol, RoleFriend roleFriend, long exceptRoleid)
/*      */   {
/* 1081 */     if (roleFriend.friendSize() > 0)
/*      */     {
/* 1083 */       Set<Long> friendIdsSet = new java.util.HashSet();
/* 1084 */       friendIdsSet.addAll(roleFriend.getFriendTotalInfo().getFriendinfomap().keySet());
/* 1085 */       friendIdsSet.remove(Long.valueOf(exceptRoleid));
/* 1086 */       OnlineManager.getInstance().sendMulti(protocol, friendIdsSet);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean checkInCross(long roleid)
/*      */   {
/* 1095 */     if (RoleStatusInterface.containsStatus(roleid, 41))
/*      */     {
/* 1097 */       sendError(roleid, 200, new String[0]);
/* 1098 */       return true;
/*      */     }
/* 1100 */     if (RoleStatusInterface.containsStatus(roleid, 44))
/*      */     {
/* 1102 */       sendError(roleid, 200, new String[0]);
/* 1103 */       return true;
/*      */     }
/* 1105 */     return false;
/*      */   }
/*      */   
/*      */   public static void onRoleOccupChange(RoleFriend roleFriend, int newOccup)
/*      */   {
/* 1110 */     mzm.gsp.friend.SSynFriendOccupation synFriendOccupation = new mzm.gsp.friend.SSynFriendOccupation();
/* 1111 */     synFriendOccupation.friendid = roleFriend.getRoleId();
/* 1112 */     synFriendOccupation.occupationid = newOccup;
/* 1113 */     broadCastMsgToFriend(synFriendOccupation, roleFriend);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void notifyGrcFriendRecommend(long roleId, UserGrcFriendInfo xUserGrcFriendInfo, RoleFriend roleFriend)
/*      */   {
/* 1122 */     if (xUserGrcFriendInfo == null)
/* 1123 */       return;
/* 1124 */     RoleGrcFriendInfo xRoleGrcFriendInfo = (RoleGrcFriendInfo)xUserGrcFriendInfo.getZone2ids().get(Integer.valueOf(mzm.gsp.GameServerInfoManager.getZoneId()));
/*      */     
/* 1126 */     if (xRoleGrcFriendInfo == null) {
/* 1127 */       return;
/*      */     }
/* 1129 */     SSyncGRCFriends sync2Self = new SSyncGRCFriends();
/* 1130 */     SSyncGRCFriends sync2Friend = new SSyncGRCFriends();
/* 1131 */     sync2Friend.roleids.add(Long.valueOf(roleId));
/* 1132 */     for (Long friendRoleId : xRoleGrcFriendInfo.getIds())
/*      */     {
/* 1134 */       if (friendRoleId.longValue() != roleId)
/*      */       {
/* 1136 */         if ((OnlineManager.getInstance().isOnline(friendRoleId.longValue())) && (!roleFriend.containsRole(friendRoleId.longValue())))
/*      */         {
/* 1138 */           sync2Self.roleids.add(friendRoleId);
/* 1139 */           OnlineManager.getInstance().send(friendRoleId.longValue(), sync2Friend);
/*      */         } }
/*      */     }
/* 1142 */     if (!sync2Self.roleids.isEmpty()) {
/* 1143 */       OnlineManager.getInstance().send(roleId, sync2Self);
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\RoleFriendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */