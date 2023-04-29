/*     */ package mzm.gsp.group.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.group.GroupMemberBasicInfo;
/*     */ import mzm.gsp.group.GroupMemberInfo;
/*     */ import mzm.gsp.group.SCreateGroupSuccess;
/*     */ import mzm.gsp.group.SDissolveGroupSuccessBrd;
/*     */ import mzm.gsp.group.SInviteJoinGroupSuccessBrd;
/*     */ import mzm.gsp.group.SQuitGroupSuccessBrd;
/*     */ import mzm.gsp.group.confbean.GroupConsts;
/*     */ import mzm.gsp.group.confbean.SCreateGroupNumLimitCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Group;
/*     */ import xbean.GroupMember;
/*     */ import xbean.GroupSetting;
/*     */ import xbean.Pod;
/*     */ import xtable.Groups;
/*     */ import xtable.Role2groupinfo;
/*     */ 
/*     */ public class GroupManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*  39 */   static Logger logger = null;
/*     */   
/*     */   static void init()
/*     */   {
/*  43 */     logger = Logger.getLogger("group");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isGroupSwitchOpenForRole(long roleid, boolean isSendProtocol)
/*     */   {
/*  55 */     if (!OpenInterface.getOpenStatus(159))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     if (OpenInterface.isBanPlay(roleid, 159))
/*     */     {
/*  61 */       if (isSendProtocol)
/*     */       {
/*  63 */         OpenInterface.sendBanPlayMsg(roleid, 159);
/*     */       }
/*  65 */       return false;
/*     */     }
/*  67 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkRoleStatus(long roleid, int status)
/*     */   {
/*  78 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, status, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getCreateGroupNumLimit(int level)
/*     */   {
/*  90 */     if (level < GroupConsts.getInstance().CREATE_GROUP_LEVEL) {
/*  91 */       return -1;
/*     */     }
/*  93 */     TreeMap<Integer, SCreateGroupNumLimitCfg> cfgs = (TreeMap)SCreateGroupNumLimitCfg.getAll();
/*  94 */     if (cfgs.isEmpty())
/*  95 */       return -2;
/*  96 */     Map.Entry<Integer, SCreateGroupNumLimitCfg> entry = cfgs.floorEntry(Integer.valueOf(level));
/*  97 */     if (entry == null)
/*  98 */       return -3;
/*  99 */     return ((SCreateGroupNumLimitCfg)entry.getValue()).create_group_max_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkGroupType(int groupType)
/*     */   {
/* 110 */     if ((groupType != 1) && (groupType != 2))
/* 111 */       return false;
/* 112 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkMessageState(int messageState)
/*     */   {
/* 123 */     if ((messageState != 1) && (messageState != 2))
/*     */     {
/* 125 */       return false; }
/* 126 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkGroupName(String groupName)
/*     */   {
/* 137 */     if ((groupName.isEmpty()) || (Math.ceil(CommonUtils.getUTF16Length(groupName) / 2.0D) > GroupConsts.getInstance().GROUP_NAME_MAX_LENGTH))
/*     */     {
/*     */ 
/* 140 */       return false;
/*     */     }
/* 142 */     if (!AvailableStringArgs.getInstance().isStringUsable(groupName))
/*     */     {
/* 144 */       return false;
/*     */     }
/* 146 */     if (SensitiveInterface.isNameSensitive(groupName))
/*     */     {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkGroupAnnouncement(String announcement)
/*     */   {
/* 161 */     if ((announcement.isEmpty()) || (Math.ceil(CommonUtils.getUTF16Length(announcement) / 2.0D) > GroupConsts.getInstance().GROUP_ANNOUNCEMENT_MAX_LENGTH))
/*     */     {
/*     */ 
/* 164 */       return false;
/*     */     }
/* 166 */     if (SensitiveInterface.isNameSensitive(announcement))
/*     */     {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int createGroup(long roleid, int groupType, String groupName, int createGroupNumLimit, int reason)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 191 */     xbean.GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(roleid));
/* 192 */     if (xGroupInfo == null)
/*     */     {
/* 194 */       xGroupInfo = Pod.newGroupInfo();
/* 195 */       Role2groupinfo.insert(Long.valueOf(roleid), xGroupInfo);
/*     */     }
/*     */     
/* 198 */     if (xGroupInfo.getCreate_same_zone_groupids().size() > createGroupNumLimit)
/*     */     {
/*     */ 
/* 201 */       return 2;
/*     */     }
/*     */     
/* 204 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 205 */     Group xGroup = Pod.newGroup();
/* 206 */     xGroup.setGroup_type(groupType);
/* 207 */     xGroup.setMasterid(roleid);
/* 208 */     xGroup.setCreate_time(now);
/* 209 */     xGroup.setGroup_name(groupName);
/* 210 */     GroupMember xGroupMember = Pod.newGroupMember();
/* 211 */     xGroupMember.setRoleid(roleid);
/* 212 */     xGroupMember.setJoin_time(now);
/* 213 */     xGroupMember.setGroup_basic_info_version(xGroup.getInfo_version());
/* 214 */     xGroupMember.setGroup_info_version(xGroup.getInfo_version());
/* 215 */     xGroup.getGroupmembers().put(Long.valueOf(roleid), xGroupMember);
/* 216 */     xGroup.getMemberlist().add(Long.valueOf(roleid));
/* 217 */     long groupid = Groups.insert(xGroup).longValue();
/*     */     
/* 219 */     GroupSetting xGroupSetting = Pod.newGroupSetting();
/* 220 */     xGroupSetting.setMessage_state(1);
/* 221 */     xGroupInfo.getCreate_same_zone_groupids().put(Long.valueOf(groupid), xGroupSetting);
/*     */     
/* 223 */     SCreateGroupSuccess protocol = new SCreateGroupSuccess();
/* 224 */     fillGroupInfoOnCreateGroup(protocol.group_info, groupid, xGroup);
/* 225 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */     
/* 227 */     GroupTlogManager.addGroupTlog(roleid, 1, reason, groupType, groupid, groupName, -1L, -1);
/*     */     
/* 229 */     return 0;
/*     */   }
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
/*     */ 
/*     */   private static void fillGroupInfoOnCreateGroup(mzm.gsp.group.GroupInfo groupInfo, long groupid, Group xGroup)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 246 */     long masterid = xGroup.getMasterid();
/* 247 */     groupInfo.groupid = groupid;
/* 248 */     groupInfo.group_type = ((byte)xGroup.getGroup_type());
/* 249 */     groupInfo.masterid = masterid;
/* 250 */     groupInfo.create_time = ((int)(xGroup.getCreate_time() / 1000L));
/* 251 */     groupInfo.group_name.setString(xGroup.getGroup_name(), "UTF-8");
/* 252 */     groupInfo.announcement.setString(xGroup.getAnnouncement(), "UTF-8");
/* 253 */     groupInfo.member_num = xGroup.getMemberlist().size();
/* 254 */     groupInfo.info_version = xGroup.getInfo_version();
/*     */     
/* 256 */     GroupMemberBasicInfo groupMemberBasicInfo = new GroupMemberBasicInfo();
/* 257 */     groupMemberBasicInfo.menpai = RoleInterface.getOccupationId(masterid);
/* 258 */     groupMemberBasicInfo.gender = ((byte)RoleInterface.getGender(masterid));
/* 259 */     groupMemberBasicInfo.avatarid = AvatarInterface.getCurrentAvatar(masterid, false);
/* 260 */     groupMemberBasicInfo.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(masterid, false);
/* 261 */     groupInfo.image_member_list.add(groupMemberBasicInfo);
/*     */     
/* 263 */     GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
/* 264 */     groupMemberInfo.roleid = masterid;
/* 265 */     groupMemberInfo.name.setString(RoleInterface.getName(masterid), "UTF-8");
/* 266 */     groupMemberInfo.level = RoleInterface.getLevel(masterid);
/* 267 */     groupMemberInfo.menpai = RoleInterface.getOccupationId(masterid);
/* 268 */     groupMemberInfo.gender = ((byte)RoleInterface.getGender(masterid));
/* 269 */     groupMemberInfo.avatarid = AvatarInterface.getCurrentAvatar(masterid, false);
/* 270 */     groupMemberInfo.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(masterid, false);
/* 271 */     groupMemberInfo.online_state = ((byte)(OnlineManager.getInstance().isOnline(masterid) ? 1 : 2));
/*     */     
/* 273 */     groupMemberInfo.join_time = ((int)(((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(masterid))).getJoin_time() / 1000L));
/* 274 */     groupInfo.member_list.add(groupMemberInfo);
/*     */   }
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
/*     */ 
/*     */ 
/*     */   static void fillGroupInfo(mzm.gsp.group.GroupInfo groupInfo, Group xGroup, long groupid, boolean isBasicInfo)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 292 */     groupInfo.groupid = groupid;
/* 293 */     groupInfo.group_type = ((byte)xGroup.getGroup_type());
/* 294 */     groupInfo.masterid = xGroup.getMasterid();
/* 295 */     groupInfo.create_time = ((int)(xGroup.getCreate_time() / 1000L));
/* 296 */     groupInfo.group_name.setString(xGroup.getGroup_name(), "UTF-8");
/* 297 */     if (!isBasicInfo)
/*     */     {
/* 299 */       groupInfo.announcement.setString(xGroup.getAnnouncement(), "UTF-8");
/*     */     }
/* 301 */     groupInfo.member_num = xGroup.getMemberlist().size();
/* 302 */     groupInfo.info_version = xGroup.getInfo_version();
/*     */     
/* 304 */     int count = 0;
/* 305 */     for (Iterator i$ = xGroup.getMemberlist().iterator(); i$.hasNext(); 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 313 */         count >= GroupConsts.getInstance().MEMBER_NUM_IN_GROUP_IMAGE)
/*     */     {
/* 305 */       long memberid = ((Long)i$.next()).longValue();
/*     */       
/* 307 */       GroupMemberBasicInfo groupMemberBasicInfo = new GroupMemberBasicInfo();
/* 308 */       groupMemberBasicInfo.menpai = RoleInterface.getOccupationId(memberid);
/* 309 */       groupMemberBasicInfo.gender = ((byte)RoleInterface.getGender(memberid));
/* 310 */       groupMemberBasicInfo.avatarid = AvatarInterface.getCurrentAvatar(memberid, false);
/* 311 */       groupMemberBasicInfo.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(memberid, false);
/* 312 */       groupInfo.image_member_list.add(groupMemberBasicInfo);
/* 313 */       count++;
/*     */     }
/*     */     
/*     */ 
/*     */     Iterator i$;
/*     */     
/* 319 */     if (!isBasicInfo)
/*     */     {
/* 321 */       for (i$ = xGroup.getMemberlist().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*     */         
/* 323 */         GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
/* 324 */         groupMemberInfo.roleid = memberid;
/* 325 */         groupMemberInfo.name.setString(RoleInterface.getName(memberid), "UTF-8");
/* 326 */         groupMemberInfo.level = RoleInterface.getLevel(memberid);
/* 327 */         groupMemberInfo.menpai = RoleInterface.getOccupationId(memberid);
/* 328 */         groupMemberInfo.gender = ((byte)RoleInterface.getGender(memberid));
/* 329 */         groupMemberInfo.avatarid = AvatarInterface.getCurrentAvatar(memberid, false);
/* 330 */         groupMemberInfo.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(memberid, false);
/* 331 */         groupMemberInfo.online_state = ((byte)(OnlineManager.getInstance().isOnline(memberid) ? 1 : 2));
/*     */         
/* 333 */         groupMemberInfo.join_time = ((int)(((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getJoin_time() / 1000L));
/* 334 */         groupInfo.member_list.add(groupMemberInfo);
/*     */       }
/*     */     }
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int inviteJoinGroup(long inviter, long invitee, long groupid, int reason)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 356 */     xbean.GroupInfo xInviterGroupInfo = Role2groupinfo.get(Long.valueOf(inviter));
/* 357 */     xbean.GroupInfo xInviteeGroupInfo = Role2groupinfo.get(Long.valueOf(invitee));
/*     */     
/*     */ 
/* 360 */     Group xGroup = Groups.get(Long.valueOf(groupid));
/* 361 */     if (xGroup == null)
/*     */     {
/*     */ 
/* 364 */       return 1;
/*     */     }
/*     */     
/* 367 */     if ((xInviterGroupInfo == null) || ((!xInviterGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(groupid))) && (!xInviterGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(groupid)))) || (!xGroup.getMemberlist().contains(Long.valueOf(inviter))))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 372 */       return 2;
/*     */     }
/*     */     
/* 375 */     if (((xInviteeGroupInfo != null) && ((xInviteeGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(groupid))) || (xInviteeGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(groupid))))) || (xGroup.getMemberlist().contains(Long.valueOf(invitee))))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 380 */       return 5;
/*     */     }
/*     */     
/* 383 */     if (xGroup.getMemberlist().size() >= GroupConsts.getInstance().GROUP_MEMBER_MAX_NUM)
/*     */     {
/*     */ 
/* 386 */       return 3;
/*     */     }
/* 388 */     if ((xInviteeGroupInfo != null) && (xInviteeGroupInfo.getJoin_same_zone_groupids().size() >= GroupConsts.getInstance().JOIN_GROUP_MAX_NUM))
/*     */     {
/*     */ 
/*     */ 
/* 392 */       return 6;
/*     */     }
/*     */     
/*     */ 
/* 396 */     ArrayList<Long> concernMemberList = new ArrayList(xGroup.getMemberlist());
/* 397 */     Iterator<Long> iterator = concernMemberList.iterator();
/* 398 */     while (iterator.hasNext())
/*     */     {
/* 400 */       long memberid = ((Long)iterator.next()).longValue();
/* 401 */       if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_info_version() != xGroup.getInfo_version())
/*     */       {
/* 403 */         iterator.remove();
/*     */       }
/*     */       else
/*     */       {
/* 407 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_basic_info_version(xGroup.getInfo_version() + 1L);
/* 408 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_info_version(xGroup.getInfo_version() + 1L);
/*     */       }
/*     */     }
/* 411 */     if (!concernMemberList.contains(Long.valueOf(inviter))) {
/* 412 */       concernMemberList.add(Long.valueOf(inviter));
/*     */     }
/*     */     
/* 415 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 416 */     GroupMember xGroupMember = Pod.newGroupMember();
/* 417 */     xGroupMember.setRoleid(invitee);
/* 418 */     xGroupMember.setJoin_time(now);
/* 419 */     xGroup.getMemberlist().add(Long.valueOf(invitee));
/* 420 */     xGroup.getGroupmembers().put(Long.valueOf(invitee), xGroupMember);
/* 421 */     xGroup.setInfo_version(xGroup.getInfo_version() + 1L);
/*     */     
/* 423 */     if (xInviteeGroupInfo == null)
/*     */     {
/* 425 */       xInviteeGroupInfo = Pod.newGroupInfo();
/* 426 */       Role2groupinfo.insert(Long.valueOf(invitee), xInviteeGroupInfo);
/*     */     }
/* 428 */     GroupSetting xGroupSetting = Pod.newGroupSetting();
/* 429 */     xGroupSetting.setMessage_state(1);
/* 430 */     xInviteeGroupInfo.getJoin_same_zone_groupids().put(Long.valueOf(groupid), xGroupSetting);
/*     */     
/*     */ 
/* 433 */     SInviteJoinGroupSuccessBrd protocol = new SInviteJoinGroupSuccessBrd();
/* 434 */     protocol.groupid = groupid;
/* 435 */     protocol.inviter = inviter;
/* 436 */     protocol.info_version = xGroup.getInfo_version();
/* 437 */     protocol.newmember.roleid = invitee;
/* 438 */     protocol.newmember.name.setString(RoleInterface.getName(invitee), "UTF-8");
/* 439 */     protocol.newmember.level = RoleInterface.getLevel(invitee);
/* 440 */     protocol.newmember.menpai = RoleInterface.getOccupationId(invitee);
/* 441 */     protocol.newmember.gender = ((byte)RoleInterface.getGender(invitee));
/* 442 */     protocol.newmember.avatarid = AvatarInterface.getCurrentAvatar(invitee);
/* 443 */     protocol.newmember.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(invitee, false);
/* 444 */     protocol.newmember.online_state = ((byte)(OnlineManager.getInstance().isOnline(invitee) ? 1 : 2));
/*     */     
/* 446 */     protocol.newmember.join_time = ((int)(((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(invitee))).getJoin_time() / 1000L));
/* 447 */     OnlineManager.getInstance().sendMulti(protocol, concernMemberList);
/*     */     
/*     */ 
/* 450 */     GroupAsynTaskManager.getInstance().addTask(new PJoinGroupNotify(inviter, invitee, groupid));
/* 451 */     GroupTlogManager.addGroupTlog(inviter, 2, reason, xGroup.getGroup_type(), groupid, xGroup.getGroup_name(), invitee, -1);
/*     */     
/* 453 */     return 0;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   static int quitGroup(long roleid, long groupid, int reason)
/*     */   {
/* 470 */     xbean.GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(roleid));
/* 471 */     if ((xGroupInfo == null) || (!xGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(groupid))))
/*     */     {
/*     */ 
/* 474 */       return 2;
/*     */     }
/* 476 */     if (xGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(groupid)))
/*     */     {
/*     */ 
/* 479 */       return 3;
/*     */     }
/*     */     
/*     */ 
/* 483 */     Group xGroup = Groups.get(Long.valueOf(groupid));
/* 484 */     if (xGroup == null)
/*     */     {
/*     */ 
/* 487 */       return 1;
/*     */     }
/*     */     
/* 490 */     if (!xGroup.getMemberlist().contains(Long.valueOf(roleid)))
/*     */     {
/*     */ 
/* 493 */       logger.error(String.format("[group]GroupManager.quitGroup@role is not in group|roleid=%d|groupid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(groupid) }));
/*     */       
/* 495 */       return 2;
/*     */     }
/*     */     
/* 498 */     if (roleid == xGroup.getMasterid())
/*     */     {
/*     */ 
/* 501 */       logger.error(String.format("[group]GroupManager.quitGroup@master cannot quit group|roleid=%d|groupid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(groupid) }));
/*     */       
/* 503 */       return 3;
/*     */     }
/*     */     
/*     */ 
/* 507 */     ArrayList<Long> concernMemberList = new ArrayList(xGroup.getMemberlist());
/* 508 */     Iterator<Long> iteratorConcern = concernMemberList.iterator();
/* 509 */     while (iteratorConcern.hasNext())
/*     */     {
/* 511 */       long memberid = ((Long)iteratorConcern.next()).longValue();
/* 512 */       if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_info_version() != xGroup.getInfo_version())
/*     */       {
/* 514 */         iteratorConcern.remove();
/*     */       }
/*     */       else
/*     */       {
/* 518 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_basic_info_version(xGroup.getInfo_version() + 1L);
/* 519 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_info_version(xGroup.getInfo_version() + 1L);
/*     */       }
/*     */     }
/* 522 */     if (!concernMemberList.contains(Long.valueOf(roleid))) {
/* 523 */       concernMemberList.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/* 526 */     Iterator<Long> iterator = xGroup.getMemberlist().iterator();
/* 527 */     while (iterator.hasNext())
/*     */     {
/* 529 */       long memberid = ((Long)iterator.next()).longValue();
/* 530 */       if (memberid == roleid)
/*     */       {
/* 532 */         iterator.remove();
/* 533 */         break;
/*     */       }
/*     */     }
/* 536 */     xGroup.getGroupmembers().remove(Long.valueOf(roleid));
/* 537 */     xGroup.setInfo_version(xGroup.getInfo_version() + 1L);
/* 538 */     xGroupInfo.getJoin_same_zone_groupids().remove(Long.valueOf(groupid));
/*     */     
/*     */ 
/* 541 */     SQuitGroupSuccessBrd protocol = new SQuitGroupSuccessBrd();
/* 542 */     protocol.groupid = groupid;
/* 543 */     protocol.memberid = roleid;
/* 544 */     protocol.info_version = xGroup.getInfo_version();
/* 545 */     OnlineManager.getInstance().sendMulti(protocol, concernMemberList);
/*     */     
/* 547 */     GroupTlogManager.addGroupTlog(roleid, 3, reason, xGroup.getGroup_type(), groupid, xGroup.getGroup_name(), -1L, -1);
/*     */     
/* 549 */     return 0;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   static int dissolveGroup(long roleid, long groupid, int reason)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 567 */     xbean.GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(roleid));
/* 568 */     if ((xGroupInfo == null) || (!xGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(groupid))))
/*     */     {
/*     */ 
/* 571 */       return 2;
/*     */     }
/*     */     
/*     */ 
/* 575 */     Group xGroup = Groups.get(Long.valueOf(groupid));
/* 576 */     if (xGroup == null)
/*     */     {
/*     */ 
/* 579 */       logger.error(String.format("[group]GroupManager.dissolveGroup@group not exist|roleid=%d|groupid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(groupid) }));
/*     */       
/* 581 */       return 1;
/*     */     }
/* 583 */     if (roleid != xGroup.getMasterid())
/*     */     {
/*     */ 
/* 586 */       logger.error(String.format("[group]GroupManager.dissolveGroup@only master can dissolve group|roleid=%d|groupid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(groupid) }));
/*     */       
/* 588 */       return 2;
/*     */     }
/*     */     
/*     */ 
/* 592 */     String groupName = xGroup.getGroup_name();
/* 593 */     ArrayList<Long> memberList = new ArrayList(xGroup.getMemberlist());
/* 594 */     ArrayList<Long> onlineMemberList = new ArrayList(xGroup.getMemberlist());
/* 595 */     Iterator<Long> iteratorOnline = onlineMemberList.iterator();
/* 596 */     while (iteratorOnline.hasNext())
/*     */     {
/* 598 */       long memberid = ((Long)iteratorOnline.next()).longValue();
/* 599 */       if (!OnlineManager.getInstance().isOnline(memberid))
/* 600 */         iteratorOnline.remove();
/*     */     }
/* 602 */     if (!onlineMemberList.contains(Long.valueOf(roleid))) {
/* 603 */       onlineMemberList.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/* 606 */     Groups.remove(Long.valueOf(groupid));
/* 607 */     xGroupInfo.getCreate_same_zone_groupids().remove(Long.valueOf(groupid));
/*     */     
/* 609 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*     */       
/* 611 */       if (memberid != roleid)
/*     */       {
/* 613 */         GroupAsynTaskManager.getInstance().addTask(new PRemoveRoleGroupInfo(memberid, groupid));
/* 614 */         if (!onlineMemberList.contains(Long.valueOf(memberid))) {
/* 615 */           GroupAsynTaskManager.getInstance().addTask(new PAddOfflineGroupDissolveInfo(memberid, groupid, groupName));
/*     */         }
/*     */       }
/*     */     }
/* 619 */     SDissolveGroupSuccessBrd protocol = new SDissolveGroupSuccessBrd();
/* 620 */     protocol.groupid = groupid;
/* 621 */     protocol.group_name.setString(groupName, "UTF-8");
/* 622 */     OnlineManager.getInstance().sendMulti(protocol, onlineMemberList);
/*     */     
/* 624 */     GroupTlogManager.addGroupTlog(roleid, 5, reason, xGroup.getGroup_type(), groupid, xGroup.getGroup_name(), -1L, -1);
/*     */     
/* 626 */     return 0;
/*     */   }
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
/*     */ 
/*     */   static boolean isRoleInGroup(long roleid, long groupid, boolean remainLock)
/*     */   {
/* 642 */     Group xGroup = null;
/* 643 */     if (remainLock)
/*     */     {
/* 645 */       xGroup = Groups.get(Long.valueOf(groupid));
/*     */     }
/*     */     else
/*     */     {
/* 649 */       xGroup = Groups.select(Long.valueOf(groupid));
/*     */     }
/* 651 */     if ((xGroup == null) || (!xGroup.getMemberlist().contains(Long.valueOf(roleid)))) {
/* 652 */       return false;
/*     */     }
/* 654 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\GroupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */