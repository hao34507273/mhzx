/*      */ package mzm.gsp.chat.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*      */ import mzm.gsp.avatar.main.AvatarInterface;
/*      */ import mzm.gsp.badge.main.BadgeInterface;
/*      */ import mzm.gsp.chat.ChatContent;
/*      */ import mzm.gsp.chat.SChatInAllMap;
/*      */ import mzm.gsp.chat.SChatInFaction;
/*      */ import mzm.gsp.chat.SChatInGroup;
/*      */ import mzm.gsp.chat.SChatInTrumpet;
/*      */ import mzm.gsp.chat.SChatNormalResult;
/*      */ import mzm.gsp.chat.SSendFail;
/*      */ import mzm.gsp.chat.confbean.ChatConsts;
/*      */ import mzm.gsp.chat.confbean.SChatDefaultMsg;
/*      */ import mzm.gsp.chat.confbean.SChatEachChannelCfg;
/*      */ import mzm.gsp.chat.confbean.STrumpetCfg;
/*      */ import mzm.gsp.chat.crossserver.CrossServerChatExtraInfoType;
/*      */ import mzm.gsp.chat.crossserver.CrossServerChatHandler;
/*      */ import mzm.gsp.chat.crossserver.CrossServerChatInterface;
/*      */ import mzm.gsp.chat.crossserver.CrossServerChatOneByOneManager;
/*      */ import mzm.gsp.chat.event.ChatInChannel;
/*      */ import mzm.gsp.chat.event.ChatInChannelArg;
/*      */ import mzm.gsp.chatbubble.main.ChatBubbleInterface;
/*      */ import mzm.gsp.gang.main.GangInterface;
/*      */ import mzm.gsp.group.main.GroupInterface;
/*      */ import mzm.gsp.idip.main.IdipManager;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.online.main.ForbidInfoManager;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.CostType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleChatInfo;
/*      */ import xtable.Role2chat;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class RoleChatManager
/*      */ {
/*   69 */   private static Map<Integer, ChatChannelCfg> chatCfgMap = new HashMap();
/*      */   
/*      */   public static Map<Integer, ChatChannelCfg> getChatCfgMap()
/*      */   {
/*   73 */     return chatCfgMap;
/*      */   }
/*      */   
/*   76 */   static Logger logger = Logger.getLogger("chat");
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static ChatChannelCfg getChatChannelCfgByChannelType(int channelType)
/*      */   {
/*   84 */     return (ChatChannelCfg)getChatCfgMap().get(Integer.valueOf(channelType));
/*      */   }
/*      */   
/*      */   static void init()
/*      */   {
/*   89 */     BroadCastToAllTimer.init(ChatArgs.getInstance().cacheSize);
/*      */     
/*      */ 
/*   92 */     Map<Integer, SChatEachChannelCfg> confMap = SChatEachChannelCfg.getAll();
/*   93 */     for (SChatEachChannelCfg conf : confMap.values())
/*      */     {
/*   95 */       ChatChannelCfg cfg = new ChatChannelCfg();
/*   96 */       cfg.init(conf);
/*   97 */       chatCfgMap.put(Integer.valueOf(cfg.getChannelType()), cfg);
/*      */     }
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
/*      */   static boolean canRoleSpk(int type, Octets content, long roleId, int channel)
/*      */   {
/*  114 */     if (!canSpkInCross(roleId, channel))
/*      */     {
/*  116 */       GameServer.logger().error(String.format("[chat]RoleChatManager.canRoleSpk@can not spk in cross!|roleId=%d|channel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channel) }));
/*      */       
/*      */ 
/*  119 */       return false;
/*      */     }
/*  121 */     if ((content == null) || (content.getBytes().length < 1) || (content.getBytes().length > ChatArgs.getInstance().contentMaxLength))
/*      */     {
/*      */ 
/*  124 */       GameServer.logger().error(String.format("[chat]RoleChatManager.canRoleSpk@ content illegal!|roleId=%d|channel=%d|type=%d|content.length=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channel), Integer.valueOf(type), Integer.valueOf(content == null ? 0 : content.getBytes().length) }));
/*      */       
/*      */ 
/*      */ 
/*  128 */       return false;
/*      */     }
/*  130 */     if (type == 3)
/*      */     {
/*  132 */       return checkSecretChannels(roleId, channel);
/*      */     }
/*      */     
/*  135 */     if (!isLevelToChat(roleId, channel))
/*      */     {
/*  137 */       GameServer.logger().error(String.format("[chat]RoleChatManager.canRoleSpk@level not enough!|roleId=%d|channel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channel) }));
/*      */       
/*  139 */       return false;
/*      */     }
/*      */     
/*  142 */     if (isForbidden(roleId, channel))
/*      */     {
/*  144 */       GameServer.logger().error(String.format("[chat]RoleChatManager.canRoleSpk@chat forbiden!|roleId=%d|channel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channel) }));
/*      */       
/*  146 */       return false;
/*      */     }
/*      */     
/*  149 */     if (!checkAndSetChatInterval(roleId, channel))
/*      */     {
/*  151 */       GameServer.logger().error(String.format("[chat]RoleChatManager.canRoleSpk@chat interval not enough!|roleId=%d|channel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channel) }));
/*      */       
/*      */ 
/*  154 */       return false;
/*      */     }
/*      */     
/*  157 */     if (!checkAndCostEnergy(roleId, channel))
/*      */     {
/*  159 */       GameServer.logger().error(String.format("[chat]RoleChatManager.canRoleSpk@cost energy err!|roleId=%d|channel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channel) }));
/*      */       
/*  161 */       return false;
/*      */     }
/*  163 */     return true;
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
/*      */   static boolean checkSecretChannels(long roleId, int channel)
/*      */   {
/*  177 */     ChatChannelCfg cfg = getChatCfgByChannelType(channel);
/*  178 */     if (cfg == null)
/*      */     {
/*  180 */       GameServer.logger().error(String.format("[chat]RoleChatManager.checkSecretChannels@ ChatChannelCfg is null!|roleId=%d|channel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channel) }));
/*      */       
/*      */ 
/*  183 */       return false;
/*      */     }
/*  185 */     int secretTimeLag = cfg.getSecretTimeLag();
/*  186 */     if (secretTimeLag <= 0)
/*      */     {
/*      */ 
/*  189 */       return true;
/*      */     }
/*  191 */     RoleChatInfo roleChatInfo = Role2chat.get(Long.valueOf(roleId));
/*  192 */     if (roleChatInfo == null)
/*      */     {
/*  194 */       roleChatInfo = Pod.newRoleChatInfo();
/*  195 */       Role2chat.insert(Long.valueOf(roleId), roleChatInfo);
/*      */     }
/*  197 */     Long lastChatTime = (Long)roleChatInfo.getSecretchannels().get(Integer.valueOf(channel));
/*  198 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  199 */     if ((lastChatTime != null) && ((currTime - lastChatTime.longValue()) / 1000L < secretTimeLag))
/*      */     {
/*  201 */       GameServer.logger().error(String.format("[chat]RoleChatManager.checkSecretChannels@ secret channels time limit!|roleId=%d|channel=%d|secretTimeLag=%d|lastChatTime=%d|currTime=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channel), Integer.valueOf(secretTimeLag), lastChatTime, Long.valueOf(currTime) }));
/*      */       
/*      */ 
/*      */ 
/*  205 */       return false;
/*      */     }
/*  207 */     roleChatInfo.getSecretchannels().put(Integer.valueOf(channel), Long.valueOf(currTime));
/*  208 */     return true;
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
/*      */   static boolean isForbidden(long roleId, int channel)
/*      */   {
/*  223 */     return false;
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
/*      */   static boolean isLevelToChat(long roleId, int channel)
/*      */   {
/*  238 */     if (RoleInterface.getLevel(roleId) >= getChatMinLevel(channel))
/*      */     {
/*  240 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  244 */     sendFailProc(roleId, channel, 25);
/*  245 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChatMinLevel(int channel)
/*      */   {
/*  257 */     ChatChannelCfg cfg = getChatCfgByChannelType(channel);
/*  258 */     if (cfg == null)
/*      */     {
/*  260 */       return 0;
/*      */     }
/*  262 */     return cfg.getLevelMin();
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
/*      */   static void sendFailProc(long roleId, int channel, int reason)
/*      */   {
/*  275 */     SSendFail sendFail = new SSendFail();
/*  276 */     sendFail.reason = reason;
/*  277 */     sendFail.senderid = roleId;
/*  278 */     sendFail.channeltype = channel;
/*      */     
/*  280 */     OnlineManager.getInstance().sendAtOnce(roleId, sendFail);
/*      */   }
/*      */   
/*      */   static void sendToStangerOfflineProc(long roleId, long listener, int channel, int reason)
/*      */   {
/*  285 */     SSendFail sendFail = new SSendFail();
/*  286 */     sendFail.reason = reason;
/*  287 */     sendFail.senderid = roleId;
/*  288 */     sendFail.listenerid = listener;
/*  289 */     sendFail.channeltype = channel;
/*      */     
/*  291 */     OnlineManager.getInstance().sendAtOnce(roleId, sendFail);
/*      */   }
/*      */   
/*      */   static void sendFailMoreProc(long roleId, int channel, int reason, Octets content, int contenttype)
/*      */   {
/*  296 */     SSendFail sendFail = new SSendFail();
/*  297 */     sendFail.reason = reason;
/*  298 */     sendFail.senderid = roleId;
/*  299 */     sendFail.channeltype = channel;
/*  300 */     sendFail.chatcontent.content = content;
/*  301 */     sendFail.chatcontent.contenttype = contenttype;
/*      */     
/*  303 */     OnlineManager.getInstance().sendAtOnce(roleId, sendFail);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ChatChannelCfg getChatCfgByChannelType(int channelType)
/*      */   {
/*  314 */     return (ChatChannelCfg)chatCfgMap.get(Integer.valueOf(channelType));
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
/*      */   static boolean checkAndSetChatInterval(long roleId, int channel)
/*      */   {
/*  328 */     int intervalSec = getChatIntervalSec(channel);
/*  329 */     if (intervalSec <= 0)
/*      */     {
/*  331 */       return true;
/*      */     }
/*  333 */     RoleChatInfo roleChatInfo = Role2chat.get(Long.valueOf(roleId));
/*  334 */     if (roleChatInfo == null)
/*      */     {
/*  336 */       roleChatInfo = Pod.newRoleChatInfo();
/*  337 */       Role2chat.insert(Long.valueOf(roleId), roleChatInfo);
/*      */     }
/*  339 */     Long lastChatTime = (Long)roleChatInfo.getChannels().get(Integer.valueOf(channel));
/*  340 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  341 */     if ((lastChatTime != null) && ((currTime - lastChatTime.longValue()) / 1000L < intervalSec))
/*      */     {
/*  343 */       sendFailProc(roleId, channel, 22);
/*  344 */       return false;
/*      */     }
/*      */     
/*  347 */     roleChatInfo.getChannels().put(Integer.valueOf(channel), Long.valueOf(currTime));
/*  348 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChatIntervalSec(int channel)
/*      */   {
/*  359 */     ChatChannelCfg cfg = getChatCfgByChannelType(channel);
/*  360 */     if (cfg == null)
/*      */     {
/*  362 */       return 0;
/*      */     }
/*  364 */     return cfg.getTimeLag();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkAndCostEnergy(long roleId, int channel)
/*      */   {
/*  376 */     int energy = getCostEnergyNum(channel);
/*  377 */     if (energy <= 0)
/*      */     {
/*  379 */       return true;
/*      */     }
/*  381 */     TLogArg tLogArg = new TLogArg(LogReason.VIGOR_CUT__DAGONG, 0);
/*  382 */     if (!RoleInterface.cutVigor(roleId, energy, tLogArg))
/*      */     {
/*  384 */       sendFailProc(roleId, channel, 23);
/*  385 */       return false;
/*      */     }
/*  387 */     sendNormalResult(roleId, 1, new String[] { String.valueOf(energy) });
/*  388 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCostEnergyNum(int channel)
/*      */   {
/*  399 */     ChatChannelCfg cfg = getChatCfgByChannelType(channel);
/*  400 */     if (cfg == null)
/*      */     {
/*  402 */       return 0;
/*      */     }
/*  404 */     return cfg.getEnergyConsume();
/*      */   }
/*      */   
/*      */   static void postInit()
/*      */   {
/*  409 */     new BroadCastToAllTimer(ChatArgs.getInstance().intervalMil);
/*  410 */     new MergeNewerTimer(TimeUnit.MINUTES.toSeconds(ChatConsts.getInstance().newChannelCheckTime));
/*      */   }
/*      */   
/*      */ 
/*      */   static ChatContent fillRoleInfoInChatContent(long roleId, ChatContent chatcontent, Octets content, int contentType)
/*      */   {
/*  416 */     if (contentType == 3)
/*      */     {
/*      */ 
/*  419 */       chatcontent.contenttype = contentType;
/*  420 */       chatcontent.content = content;
/*  421 */       return chatcontent;
/*      */     }
/*  423 */     Role role = RoleInterface.getRole(roleId, false);
/*  424 */     chatcontent.roleid = roleId;
/*  425 */     chatcontent.gender = role.getGender();
/*  426 */     chatcontent.rolename = role.getName();
/*  427 */     chatcontent.modelid = role.getModelId();
/*  428 */     chatcontent.level = role.getLevel();
/*  429 */     chatcontent.occupationid = role.getOccupationId();
/*  430 */     chatcontent.avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/*  431 */     chatcontent.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/*  432 */     chatcontent.content = content;
/*  433 */     chatcontent.contenttype = contentType;
/*  434 */     chatcontent.chatbubblecfgid = ChatBubbleInterface.getRoleChatBubbleCfgId(roleId, false);
/*  435 */     Set<Integer> badges = BadgeInterface.selectRoleBadgeIds(roleId);
/*  436 */     if ((badges != null) && (badges.size() > 0))
/*      */     {
/*  438 */       chatcontent.badge.addAll(badges);
/*      */     }
/*  440 */     chatcontent.timestamp = DateTimeUtils.getCurrTimeInMillis();
/*  441 */     return chatcontent;
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
/*      */   static boolean triggerChatInChannelEvent(long roleId, int channelType)
/*      */   {
/*  455 */     ChatInChannelArg arg = new ChatInChannelArg();
/*  456 */     arg.setChannel(channelType);
/*  457 */     arg.setRoleId(roleId);
/*  458 */     TriggerEventsManger.getInstance().triggerEvent(new ChatInChannel(), arg);
/*  459 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getPrivateChatCountLimit()
/*      */   {
/*  469 */     return ChatConsts.getInstance().SumOfflineWhisperRecordMax;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean sendNormalResult(long roleid, int res, String... args)
/*      */   {
/*  479 */     SChatNormalResult pro = new SChatNormalResult();
/*  480 */     pro.result = res;
/*  481 */     for (String arg : args)
/*      */     {
/*  483 */       pro.args.add(arg);
/*      */     }
/*  485 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*  486 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isPlatformTalkForbid(long roleId)
/*      */   {
/*  496 */     boolean isFb = ForbidInfoManager.isForbidTalk(roleId);
/*  497 */     if (isFb)
/*      */     {
/*  499 */       GameServer.logger().info(String.format("[chat]RoleChatManager.isPlatformTalkForbid@ role forbid!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*      */     }
/*      */     
/*  502 */     return isFb;
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
/*      */   static void chatToSbNoneRealTimeImpl(long sender, long receiver, String _msg)
/*      */   {
/*  539 */     Octets content = Octets.wrap(_msg, "UTF-8");
/*  540 */     NoneRealTimeTaskManager.getInstance().addTask(new PCChatToSomeOne(sender, receiver, 2, content));
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
/*      */   static void chatToSbNoneRealTimeImpl(long sender, long receiver, int _msgId)
/*      */   {
/*  557 */     SChatDefaultMsg scfg = SChatDefaultMsg.get(_msgId);
/*  558 */     if (scfg == null)
/*      */     {
/*  560 */       return;
/*      */     }
/*  562 */     String _msg = scfg.msg;
/*      */     
/*  564 */     Octets content = Octets.wrap(_msg, "UTF-8");
/*  565 */     NoneRealTimeTaskManager.getInstance().addTask(new PCChatToSomeOne(sender, receiver, 2, content));
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
/*      */   static boolean afterChat(long roleId, int channelType)
/*      */   {
/*  580 */     if (channelType == 3)
/*      */     {
/*  582 */       return true;
/*      */     }
/*  584 */     if (!triggerChatInChannelEvent(roleId, channelType))
/*      */     {
/*  586 */       return false;
/*      */     }
/*  588 */     TlogChatInChannel(roleId, channelType);
/*  589 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void TlogChatInChannel(long roleId, int channelType)
/*      */   {
/*  600 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  601 */     String userid = RoleInterface.getUserId(roleId);
/*  602 */     int rolelevel = RoleInterface.getLevel(roleId);
/*      */     
/*  604 */     String logStr = String.format("%s|%s|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(channelType) });
/*  605 */     TLogManager.getInstance().addLog(roleId, "ChatInChannel", logStr);
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
/*      */   static boolean chatInFaction(long roleId, int contenttype, Octets content)
/*      */   {
/*  620 */     if ((content == null) || (content.getBytes().length < 1))
/*      */     {
/*  622 */       return false;
/*      */     }
/*      */     
/*  625 */     if (!canRoleSpk(contenttype, content, roleId, 2))
/*      */     {
/*  627 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  631 */     if (GangInterface.isForbiddenTalk(roleId))
/*      */     {
/*  633 */       sendFailProc(roleId, 2, 21);
/*  634 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  638 */     long gangId = GangInterface.getGangId(roleId);
/*  639 */     if (gangId < 0L)
/*      */     {
/*  641 */       sendFailMoreProc(roleId, 2, 20, content, contenttype);
/*      */       
/*  643 */       return false;
/*      */     }
/*  645 */     Set<Long> gangMemberList = GangInterface.getGangMemberList(gangId);
/*      */     
/*      */ 
/*  648 */     SChatInFaction sChatInFaction = new SChatInFaction();
/*  649 */     fillRoleInfoInChatContent(roleId, sChatInFaction.chatcontent, content, contenttype);
/*  650 */     sChatInFaction.position = GangInterface.getGangDuty(roleId);
/*      */     
/*  652 */     if (isPlatformTalkForbid(roleId))
/*      */     {
/*  654 */       OnlineManager.getInstance().send(roleId, sChatInFaction);
/*      */     }
/*      */     else
/*      */     {
/*  658 */       OnlineManager.getInstance().sendMulti(sChatInFaction, gangMemberList);
/*  659 */       if (isFactionChatContentBufferOpenForRole(roleId))
/*      */       {
/*  661 */         FactionChatContentBufferManager.getInstance().addChatContent(gangId, sChatInFaction.marshal(new OctetsStream()));
/*      */       }
/*  663 */       if (isFactionCrossServerChatOpenForRole(roleId))
/*      */       {
/*  665 */         CrossServerChatOneByOneManager.getInstance().addLogicRunnable(Integer.valueOf(2), new RTransferChatContent(roleId, 2, gangId, sChatInFaction, CrossServerChatInterface.getHandlers(2)));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  672 */     afterChat(roleId, 2);
/*      */     
/*      */ 
/*  675 */     IdipManager.chatTLog(roleId, gangId, 0L, 0L, 2, null, content);
/*      */     
/*  677 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean chatInFactionInRoamServer(long roleid, int contentType, Octets content, CrossServerChatHandler handler)
/*      */   {
/*  683 */     if (handler == null)
/*      */     {
/*  685 */       GameServer.logger().info(String.format("[chat]RoleChatManager.chatInFactionInRoamServer@handler is null|roleid=%d|content_type=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(contentType) }));
/*      */       
/*      */ 
/*  688 */       return false;
/*      */     }
/*  690 */     if (handler.isForbiddenTalkInRoamServer(roleid))
/*      */     {
/*  692 */       GameServer.logger().error(String.format("[chat]RoleChatManager.chatInFactionInRoamServer@role is forbidden talk|roleid=%d|content_type=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(contentType) }));
/*      */       
/*      */ 
/*      */ 
/*  696 */       return false;
/*      */     }
/*  698 */     List<Long> receiveRoleList = handler.getReceiveRoleListByRoleidInRoamServer(roleid);
/*  699 */     if ((receiveRoleList == null) || (receiveRoleList.isEmpty()))
/*      */     {
/*  701 */       GameServer.logger().error(String.format("[chat]RoleChatManager.chatInFactionInRoamServer@receive role list is null or empty|roleid=%d|content_type=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(contentType) }));
/*      */       
/*      */ 
/*      */ 
/*  705 */       return false;
/*      */     }
/*  707 */     Map<CrossServerChatExtraInfoType, Integer> extraInfo = handler.getExtraInfoInRoamServer(roleid);
/*  708 */     if ((extraInfo == null) || (!extraInfo.containsKey(CrossServerChatExtraInfoType.FactionDuty)) || (!extraInfo.containsKey(CrossServerChatExtraInfoType.FactionidHigh)) || (!extraInfo.containsKey(CrossServerChatExtraInfoType.FactionidLow)))
/*      */     {
/*      */ 
/*      */ 
/*  712 */       GameServer.logger().error(String.format("[chat]RoleChatManager.chatInFactionInRoamServer@extra info is null or not contain all types|roleid=%d|content_type=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(contentType) }));
/*      */       
/*      */ 
/*      */ 
/*  716 */       return false;
/*      */     }
/*  718 */     int duty = ((Integer)extraInfo.get(CrossServerChatExtraInfoType.FactionDuty)).intValue();
/*  719 */     long factionid = CommonUtils.getLong(((Integer)extraInfo.get(CrossServerChatExtraInfoType.FactionidHigh)).intValue(), ((Integer)extraInfo.get(CrossServerChatExtraInfoType.FactionidLow)).intValue());
/*      */     
/*      */ 
/*  722 */     if (!canRoleSpk(contentType, content, roleid, 2))
/*      */     {
/*  724 */       return false;
/*      */     }
/*      */     
/*  727 */     SChatInFaction protocol = new SChatInFaction();
/*  728 */     fillRoleInfoInChatContent(roleid, protocol.chatcontent, content, contentType);
/*  729 */     protocol.position = duty;
/*      */     
/*  731 */     if (isPlatformTalkForbid(roleid))
/*      */     {
/*  733 */       OnlineManager.getInstance().send(roleid, protocol);
/*      */     }
/*      */     else
/*      */     {
/*  737 */       OnlineManager.getInstance().sendMulti(protocol, receiveRoleList);
/*  738 */       if (isFactionCrossServerChatOpenForRole(roleid))
/*      */       {
/*  740 */         CrossServerChatOneByOneManager.getInstance().addLogicRunnable(Integer.valueOf(2), new RTransferChatContent(roleid, 2, factionid, protocol, Arrays.asList(new CrossServerChatHandler[] { handler })));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  745 */     afterChat(roleid, 2);
/*      */     
/*  747 */     IdipManager.chatTLog(roleid, factionid, 0L, 0L, 2, null, content);
/*  748 */     return true;
/*      */   }
/*      */   
/*      */   static boolean onReceiveFactionChatContent(long roleid, long factionid, SChatInFaction protocol)
/*      */   {
/*  753 */     if (!isFactionCrossServerChatOpenForRole(roleid))
/*      */     {
/*  755 */       GameServer.logger().error(String.format("[chat]RoleChatManager.onReceiveFactionChatContent@module close or role forbidden|roleid=%d|faction_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(factionid) }));
/*      */       
/*      */ 
/*      */ 
/*  759 */       return false;
/*      */     }
/*  761 */     if (!GameServerInfoManager.isRoamServer())
/*      */     {
/*      */ 
/*      */ 
/*  765 */       if (GangInterface.isForbiddenTalk(roleid))
/*      */       {
/*  767 */         GameServer.logger().error(String.format("[chat]RoleChatManager.onReceiveFactionChatContent@role is forbidden talk by faction in own server|roleid=%d|faction_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(factionid) }));
/*      */         
/*      */ 
/*      */ 
/*  771 */         return false;
/*      */       }
/*  773 */       Set<Long> memberList = GangInterface.getGangMemberList(factionid);
/*  774 */       if (memberList.isEmpty())
/*      */       {
/*  776 */         GameServer.logger().error(String.format("[chat]RoleChatManager.onReceiveFactionChatContent@receive role list is empty in own server|roleid=%d|faction_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(factionid) }));
/*      */         
/*      */ 
/*      */ 
/*  780 */         return false;
/*      */       }
/*  782 */       if (isPlatformTalkForbid(roleid))
/*      */       {
/*  784 */         OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  785 */         GameServer.logger().error(String.format("[chat]RoleChatManager.onReceiveFactionChatContent@role is forbidden talk by platform in own server|roleid=%d|faction_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(factionid) }));
/*      */         
/*      */ 
/*      */ 
/*  789 */         return false;
/*      */       }
/*  791 */       OnlineManager.getInstance().sendMulti(protocol, memberList);
/*  792 */       if (isFactionChatContentBufferOpenForRole(roleid))
/*      */       {
/*  794 */         FactionChatContentBufferManager.getInstance().addChatContent(factionid, protocol.marshal(new OctetsStream()));
/*      */       }
/*  796 */       GameServer.logger().info(String.format("[chat]RoleChatManager.onReceiveFactionChatContent@receive faction chat content in own server|roleid=%d|faction_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(factionid) }));
/*      */       
/*      */ 
/*      */ 
/*  800 */       return true;
/*      */     }
/*      */     
/*  803 */     Set<Long> receiveRoleList = new HashSet();
/*  804 */     for (CrossServerChatHandler handler : CrossServerChatInterface.getHandlers(2))
/*      */     {
/*  806 */       List<Long> roleList = handler.getReceiveRoleByOrgKeyListInRoamServer(factionid);
/*  807 */       if (roleList != null)
/*      */       {
/*  809 */         receiveRoleList.addAll(roleList);
/*      */       }
/*      */     }
/*  812 */     if (receiveRoleList.isEmpty())
/*      */     {
/*  814 */       GameServer.logger().error(String.format("[chat]RoleChatManager.onReceiveFactionChatContent@receive role list is empty in roam server|roleid=%d|faction_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(factionid) }));
/*      */       
/*      */ 
/*      */ 
/*  818 */       return false;
/*      */     }
/*  820 */     OnlineManager.getInstance().sendMulti(protocol, receiveRoleList);
/*  821 */     GameServer.logger().info(String.format("[chat]RoleChatManager.onReceiveFactionChatContent@receive faction chat content in roam server|roleid=%d|faction_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(factionid) }));
/*      */     
/*      */ 
/*      */ 
/*  825 */     return true;
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
/*      */   static boolean sendBullet(long roleid, Octets content)
/*      */   {
/*  838 */     SChatInAllMap protocol = new SChatInAllMap();
/*  839 */     fillRoleInfoInChatContent(roleid, protocol.content, content, 5);
/*  840 */     protocol.map_cfg_id = MapInterface.getRoleMapId(roleid);
/*  841 */     if (isPlatformTalkForbid(roleid))
/*      */     {
/*  843 */       OnlineManager.getInstance().send(roleid, protocol);
/*      */     }
/*      */     else
/*      */     {
/*  847 */       MapInterface.brocadCastInWorldMap(MapInterface.getRoleWorldInstanceId(roleid), MapInterface.getRoleMapId(roleid), protocol, false);
/*      */     }
/*      */     
/*  850 */     return true;
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
/*      */   static boolean chatInGroup(long roleid, long groupid, int contentType, Octets content)
/*      */   {
/*  866 */     if (groupid < 0L)
/*      */     {
/*  868 */       return false;
/*      */     }
/*  870 */     if ((content == null) || (content.array().length < 1))
/*      */     {
/*  872 */       return false;
/*      */     }
/*  874 */     if (!canRoleSpk(contentType, content, roleid, 10))
/*      */     {
/*  876 */       return false;
/*      */     }
/*  878 */     if (!GroupInterface.isRoleInGroup(roleid, groupid))
/*      */     {
/*  880 */       return false;
/*      */     }
/*  882 */     SChatInGroup protocol = new SChatInGroup();
/*  883 */     fillRoleInfoInChatContent(roleid, protocol.content, content, contentType);
/*  884 */     protocol.groupid = groupid;
/*  885 */     if (isPlatformTalkForbid(roleid))
/*      */     {
/*  887 */       OnlineManager.getInstance().send(roleid, protocol);
/*      */     }
/*      */     else
/*      */     {
/*  891 */       List<Long> memberList = GroupInterface.getGroupMemberList(groupid, true);
/*  892 */       OnlineManager.getInstance().sendMulti(protocol, memberList);
/*      */     }
/*  894 */     afterChat(roleid, 10);
/*  895 */     return true;
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
/*      */   static boolean canSpkInCross(long roleid, int channel)
/*      */   {
/*  909 */     if (!isInCross(roleid))
/*      */     {
/*  911 */       return true;
/*      */     }
/*  913 */     ChatChannelCfg cfg = getChatCfgByChannelType(channel);
/*  914 */     if (cfg == null)
/*      */     {
/*  916 */       GameServer.logger().error(String.format("[chat]RoleChatManager.canSpkInCross@ ChatChannelCfg not exist!|roleId=%d|channel=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(channel) }));
/*      */       
/*      */ 
/*  919 */       return false;
/*      */     }
/*  921 */     return cfg.canChatInCross();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean isInCross(long roleid)
/*      */   {
/*  933 */     if (RoleStatusInterface.containsStatus(roleid, 41))
/*      */     {
/*  935 */       return true;
/*      */     }
/*  937 */     if (RoleStatusInterface.containsStatus(roleid, 44))
/*      */     {
/*  939 */       return true;
/*      */     }
/*  941 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isTrumpetSwitchOpenForRole(long roleid)
/*      */   {
/*  952 */     if (!OpenInterface.getOpenStatus(268))
/*      */     {
/*  954 */       return false;
/*      */     }
/*  956 */     if (OpenInterface.isBanPlay(roleid, 268))
/*      */     {
/*  958 */       OpenInterface.sendBanPlayMsg(roleid, 268);
/*  959 */       return false;
/*      */     }
/*  961 */     return true;
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
/*      */   static boolean chatInTrumpet(String userid, long roleid, int trumpetCfgid, int contentType, Octets content)
/*      */   {
/*  978 */     if (!isTrumpetSwitchOpenForRole(roleid))
/*      */     {
/*      */ 
/*  981 */       onChatInTrumpetFail(roleid, trumpetCfgid, contentType, -1, null);
/*  982 */       return false;
/*      */     }
/*  984 */     STrumpetCfg cfg = STrumpetCfg.get(trumpetCfgid);
/*  985 */     if (cfg == null)
/*      */     {
/*      */ 
/*  988 */       onChatInTrumpetFail(roleid, trumpetCfgid, contentType, -3, null);
/*  989 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  993 */     if (!ItemInterface.removeItemById(roleid, cfg.itemid, 1, new TLogArg(LogReason.TRUMPET_COST_ITEM)))
/*      */     {
/*  995 */       long yuanbao = QingfuInterface.getYuanbao(userid, true) + QingfuInterface.getBindYuanbao(userid, true);
/*  996 */       if (yuanbao < cfg.yuanbao_num)
/*      */       {
/*      */ 
/*  999 */         onChatInTrumpetFail(roleid, trumpetCfgid, contentType, 2, null);
/* 1000 */         return false;
/*      */       }
/* 1002 */       if (QingfuInterface.costYuanbao(userid, roleid, cfg.yuanbao_num, CostType.COST_BIND_FIRST_TRUMPET, new TLogArg(LogReason.TRUMPET_COST_YUANBAO)) != CostResult.Success)
/*      */       {
/*      */ 
/*      */ 
/* 1006 */         onChatInTrumpetFail(roleid, trumpetCfgid, contentType, 2, null);
/* 1007 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 1011 */     if (!canRoleSpk(contentType, content, roleid, 12))
/*      */     {
/*      */ 
/* 1014 */       onChatInTrumpetFail(roleid, trumpetCfgid, contentType, 3, null);
/* 1015 */       return false;
/*      */     }
/*      */     
/* 1018 */     SChatInTrumpet protocol = new SChatInTrumpet();
/* 1019 */     fillRoleInfoInChatContent(roleid, protocol.chatcontent, content, contentType);
/* 1020 */     protocol.trumpet_cfg_id = trumpetCfgid;
/* 1021 */     if (isPlatformTalkForbid(roleid))
/*      */     {
/* 1023 */       OnlineManager.getInstance().send(roleid, protocol);
/*      */     }
/*      */     else
/*      */     {
/* 1027 */       OnlineManager.getInstance().sendAll(protocol);
/*      */     }
/* 1029 */     afterChat(roleid, 12);
/*      */     
/*      */ 
/* 1032 */     IdipManager.chatTLog(roleid, 0L, 0L, 0L, 8, null, content);
/* 1033 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void onChatInTrumpetFail(long roleid, int trumpetCfgid, int contentType, int res, Map<String, Object> extraInfo)
/*      */   {
/* 1039 */     StringBuilder sb = new StringBuilder();
/* 1040 */     sb.append(String.format("[chat]RoleChatManager.chatInTrumpet@chat in trumpet fail|roleid=%d|trumpet_cfg_id=%d|content_type=%d|res=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(trumpetCfgid), Integer.valueOf(contentType), Integer.valueOf(res) }));
/*      */     
/*      */ 
/* 1043 */     if (extraInfo != null)
/*      */     {
/* 1045 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*      */       {
/* 1047 */         sb.append("|").append((String)entry.getKey());
/* 1048 */         sb.append("=").append(entry.getValue().toString());
/*      */       }
/*      */     }
/* 1051 */     GameServer.logger().info(sb.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getBufferSize(int channelType)
/*      */   {
/* 1062 */     switch (channelType)
/*      */     {
/*      */     case 2: 
/* 1065 */       return ChatArgs.getInstance().factionChatBufferSize;
/*      */     }
/* 1067 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isFactionChatContentBufferOpenForRole(long roleid)
/*      */   {
/* 1079 */     if (!OpenInterface.getOpenStatus(321))
/*      */     {
/* 1081 */       return false;
/*      */     }
/* 1083 */     if (OpenInterface.isBanPlay(roleid, 321))
/*      */     {
/* 1085 */       OpenInterface.sendBanPlayMsg(roleid, 321);
/* 1086 */       return false;
/*      */     }
/* 1088 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isFactionCrossServerChatOpenForRole(long roleid)
/*      */   {
/* 1099 */     if (!OpenInterface.getOpenStatus(444))
/*      */     {
/* 1101 */       return false;
/*      */     }
/* 1103 */     if (OpenInterface.isBanPlay(roleid, 444))
/*      */     {
/* 1105 */       OpenInterface.sendBanPlayMsg(roleid, 444);
/* 1106 */       return false;
/*      */     }
/* 1108 */     return true;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\RoleChatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */