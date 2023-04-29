/*      */ package mzm.gsp.team.main;
/*      */ 
/*      */ import gnet.link.Onlines;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import mzm.event.BasicEvent;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*      */ import mzm.gsp.avatar.main.AvatarInterface;
/*      */ import mzm.gsp.fight.main.FightInterface;
/*      */ import mzm.gsp.friend.main.FriendInterface;
/*      */ import mzm.gsp.homeland.main.HomelandInterface;
/*      */ import mzm.gsp.map.main.MapCallback;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.map.main.POnTeamDissolve;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.partner.main.PartnerInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.systemsetting.main.SystemSettingInterface;
/*      */ import mzm.gsp.team.SAppointLeaderBrd;
/*      */ import mzm.gsp.team.SCreateTeamBrd;
/*      */ import mzm.gsp.team.SDismissAllBrd;
/*      */ import mzm.gsp.team.SDispositionChanged;
/*      */ import mzm.gsp.team.SFireMemberBrd;
/*      */ import mzm.gsp.team.SJoinTeamNotify;
/*      */ import mzm.gsp.team.SLeaveTeamBrd;
/*      */ import mzm.gsp.team.SMemberModelChangedBrd;
/*      */ import mzm.gsp.team.SMemberStatusChangedBrd;
/*      */ import mzm.gsp.team.SNewApplicantNotify;
/*      */ import mzm.gsp.team.SNewMemberJoinTeamBrd;
/*      */ import mzm.gsp.team.SReqChangeZhenfa;
/*      */ import mzm.gsp.team.SSyncApplicantList;
/*      */ import mzm.gsp.team.SSyncMemberListBrd;
/*      */ import mzm.gsp.team.SSyncTeam;
/*      */ import mzm.gsp.team.STeamFullBrd;
/*      */ import mzm.gsp.team.STeamMemberInfo;
/*      */ import mzm.gsp.team.STeamNormalResult;
/*      */ import mzm.gsp.team.TeamDispositionMemberInfo;
/*      */ import mzm.gsp.team.TeamMemberInfo;
/*      */ import mzm.gsp.team.confbean.TeamConsts;
/*      */ import mzm.gsp.team.event.JoinTeam;
/*      */ import mzm.gsp.team.event.JoinTeamArg;
/*      */ import mzm.gsp.team.event.LeaveTeam;
/*      */ import mzm.gsp.team.event.LeaveTeamArg;
/*      */ import mzm.gsp.team.event.LeaveTeamArg.LeaveTeamReason;
/*      */ import mzm.gsp.team.event.TeamCreate;
/*      */ import mzm.gsp.team.event.TeamCreateArg;
/*      */ import mzm.gsp.team.event.TeamDissolve;
/*      */ import mzm.gsp.team.event.TeamDissolveArg;
/*      */ import mzm.gsp.team.event.TeamLeaderChanged;
/*      */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*      */ import mzm.gsp.team.event.TeamMemberStatusChanged;
/*      */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*      */ import mzm.gsp.team.event.TeamStableStateChanged;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import mzm.gsp.zhenfa.main.ZhenfaInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.Pod;
/*      */ import xbean.TeamDispositionMember;
/*      */ import xdb.Lockeys;
/*      */ import xdb.Procedure;
/*      */ import xio.Protocol;
/*      */ import xtable.Basic;
/*      */ import xtable.Role2team;
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
/*      */ public class TeamManager
/*      */ {
/*   90 */   static TeamConsts teamConsts = ;
/*   91 */   static final Logger logger = Logger.getLogger(TeamManager.class);
/*      */   
/*      */ 
/*      */   static void init()
/*      */   {
/*   96 */     int buffId = teamConsts.STABLE_TEAM_BUF;
/*      */     
/*   98 */     registerBigWordReturnTeam();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void registerBigWordReturnTeam()
/*      */   {
/*  106 */     TeamInterface.registerReturnTeam(getBigWorldId(), new ReturnTeamCheckHandler()
/*      */     {
/*      */ 
/*      */       public boolean canReturnTeam(long roleId)
/*      */       {
/*      */ 
/*  112 */         return true;
/*      */       }
/*      */       
/*      */ 
/*      */       public boolean canBeReturnTeam(TeamInfo teamInfo, long leaderId, long roleId)
/*      */       {
/*  118 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */   static long getBigWorldId()
/*      */   {
/*  126 */     return MapInterface.getBigWorldid();
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
/*      */   static boolean createTeam(long roleid)
/*      */   {
/*  139 */     if (TeamInterface.isRoleInTeam(roleid, true))
/*      */     {
/*  141 */       GameServer.logger().error(String.format("[team]teamManager.createTeam@ role in team!|roleId=%d", new Object[] { Long.valueOf(roleid) }));
/*  142 */       return false;
/*      */     }
/*  144 */     if (!canCreateTeam(roleid))
/*      */     {
/*  146 */       GameServer.logger().error(String.format("[team]teamManager.createTeam@ can not create team!|roleId=%d", new Object[] { Long.valueOf(roleid) }));
/*  147 */       return false;
/*      */     }
/*  149 */     if (createTeam(Arrays.asList(new Long[] { Long.valueOf(roleid) })) == null)
/*      */     {
/*  151 */       GameServer.logger().error(String.format("[team]teamManager.createTeam@ create team err!|roleId=%d", new Object[] { Long.valueOf(roleid) }));
/*  152 */       return false;
/*      */     }
/*  154 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private static boolean canCreateTeam(long roleId)
/*      */   {
/*  160 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static TeamCreatInfo createTeam(List<Long> roles)
/*      */   {
/*  171 */     xbean.Team xTeam = Pod.newTeam();
/*  172 */     xTeam.setSameteamfightcount(0);
/*  173 */     Long teamid = xtable.Team.insert(xTeam);
/*      */     
/*  175 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  177 */       xbean.TeamMember xMember = joinTeam(teamid.longValue(), xTeam, roleid, null);
/*  178 */       if (xMember == null)
/*      */       {
/*  180 */         return null;
/*      */       }
/*  182 */       if (xMember.getStatus() == 0)
/*      */       {
/*  184 */         joinTeamDisposition(xTeam, roleid);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  189 */     SCreateTeamBrd brd = new SCreateTeamBrd();
/*  190 */     fillTeamBean(teamid.longValue(), xTeam, brd.team);
/*  191 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*      */     
/*      */ 
/*  194 */     TeamCreateArg createArg = new TeamCreateArg(teamid.longValue());
/*  195 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/*  197 */       createArg.members.add(getEventTeamMember(xMember));
/*      */     }
/*  199 */     List<Long> memebers = getMemberListByXTeam(xTeam);
/*  200 */     trigTeamEvent(memebers, new TeamCreate(), createArg);
/*  201 */     GameServer.logger().info(String.format("[team]TeamManager.createTeam@ create team!|teamId=%d|members=%s", new Object[] { teamid, memebers.toString() }));
/*      */     
/*  203 */     return new TeamCreatInfo(teamid.longValue(), xTeam);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean fillDispositionByLeaderPartners(Map<Integer, Integer> leaderPartnerMap, xbean.Team xTeam)
/*      */   {
/*  214 */     if (xTeam == null)
/*      */     {
/*  216 */       return false;
/*      */     }
/*  218 */     Map<Integer, TeamDispositionMember> xTeamDispositionMemberMap = xTeam.getDisposition();
/*  219 */     int index = -1;
/*  220 */     for (int i = 0; i < teamConsts.TEAM_CAPACITY; i++)
/*      */     {
/*  222 */       TeamDispositionMember xTeamDispositionMember = (TeamDispositionMember)xTeamDispositionMemberMap.get(Integer.valueOf(i));
/*  223 */       if ((xTeamDispositionMember == null) || (xTeamDispositionMember.getDispositionmembertype() == 1))
/*      */       {
/*      */ 
/*  226 */         index = i;
/*  227 */         break;
/*      */       }
/*      */     }
/*  230 */     if (index < 0)
/*      */     {
/*  232 */       return true;
/*      */     }
/*  234 */     int i = index; for (int j = 0; i < teamConsts.TEAM_CAPACITY; j++)
/*      */     {
/*  236 */       if (leaderPartnerMap != null)
/*      */       {
/*  238 */         Integer partnerId = (Integer)leaderPartnerMap.get(Integer.valueOf(j));
/*  239 */         if (partnerId != null)
/*      */         {
/*  241 */           TeamDispositionMember xTDMember = Pod.newTeamDispositionMember();
/*  242 */           xTDMember.setDispositionmemberid(partnerId.intValue());
/*  243 */           xTDMember.setDispositionmembertype(1);
/*      */           
/*  245 */           xTeam.getDisposition().put(Integer.valueOf(i), xTDMember);
/*      */           break label208;
/*      */         }
/*      */       }
/*  249 */       if (xTeam.getDisposition().get(Integer.valueOf(i)) == null) {
/*      */         break;
/*      */       }
/*      */       
/*  253 */       xTeam.getDisposition().remove(Integer.valueOf(i));
/*      */       label208:
/*  234 */       i++;
/*      */     }
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
/*  255 */     return true;
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
/*      */   static boolean onRoleJoinTeam(long teamid, xbean.Team xTeam, long roleid, JoinTeamType joinTeamType)
/*      */   {
/*  269 */     List<Long> oldMembers = getMemberListByXTeam(xTeam);
/*  270 */     xbean.TeamMember xMember = joinTeam(teamid, xTeam, roleid, joinTeamType);
/*  271 */     if (xMember == null)
/*      */     {
/*  273 */       GameServer.logger().error(String.format("[team]TeamManager.onRoleJoinTeam@ join team failed!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamid), Long.valueOf(roleid) }));
/*      */       
/*  275 */       return false;
/*      */     }
/*  277 */     return afterGuyJoinTeam(teamid, xTeam, roleid, joinTeamType, oldMembers, xMember);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean afterGuyJoinTeam(long teamid, xbean.Team xTeam, long roleid, JoinTeamType joinTeamType, List<Long> oldMembers, xbean.TeamMember xMember)
/*      */   {
/*  287 */     noticeInviteeTeamFull(teamid, xTeam);
/*      */     
/*  289 */     if (xMember.getStatus() == 0)
/*      */     {
/*  291 */       joinTeamDisposition(xTeam, roleid);
/*      */     }
/*  293 */     if (!noticeOtherNewGuyJoin(teamid, xTeam, roleid, joinTeamType, oldMembers, xMember, getLearder(xTeam)))
/*      */     {
/*  295 */       return false;
/*      */     }
/*  297 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean noticeOtherNewGuyJoin(long teamid, xbean.Team xTeam, long roleid, JoinTeamType joinTeamType, List<Long> oldMembers, xbean.TeamMember xMember, long leaderId)
/*      */   {
/*  306 */     synGuyJoinTeamNotice(teamid, xTeam, roleid, oldMembers, xMember);
/*  307 */     trigNewGuyJoinTeam(teamid, roleid, joinTeamType, xMember, leaderId, xTeam);
/*  308 */     return true;
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
/*      */   private static void trigNewGuyJoinTeam(long teamid, long roleid, JoinTeamType joinTeamType, xbean.TeamMember xMember, long leaderId, xbean.Team xTeam)
/*      */   {
/*  325 */     JoinTeamArg joinArg = new JoinTeamArg(teamid, leaderId, getEventTeamMember(xMember));
/*  326 */     JoinTeam joinTeam = new JoinTeam();
/*  327 */     joinTeam.setSequential(true);
/*      */     
/*  329 */     if (joinTeamType == JoinTeamType.JOIN_TEAM__PLATFORM)
/*      */     {
/*  331 */       joinArg.setComeFromPlatform(true);
/*      */     }
/*      */     
/*  334 */     List<Long> members = getMemberListByXTeam(xTeam);
/*  335 */     trigTeamEvent(members, joinTeam, joinArg);
/*  336 */     GameServer.logger().info(String.format("[team]TeamManager.trigNewGuyJoinTeam@ new guy join team!|teamId=%d|newGuy=%d|leaderId=%d|members=%s|newGuyStatus=%d", new Object[] { Long.valueOf(teamid), Long.valueOf(roleid), Long.valueOf(leaderId), members.toString(), Integer.valueOf(xMember.getStatus()) }));
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
/*      */   static <T> void trigTeamEvent(List<Long> roleIds, BasicEvent<T> event, T arg)
/*      */   {
/*  351 */     if ((roleIds == null) || (roleIds.size() == 0))
/*      */     {
/*  353 */       return;
/*      */     }
/*  355 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, TeamEventOneByOne.getInstance().getOneByOne());
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
/*      */   private static void synGuyJoinTeamNotice(long teamid, xbean.Team xTeam, long roleid, List<Long> oldMembers, xbean.TeamMember xMember)
/*      */   {
/*  371 */     SNewMemberJoinTeamBrd brd = new SNewMemberJoinTeamBrd();
/*  372 */     fillTeamMemberBean(xMember, brd.member);
/*  373 */     OnlineManager.getInstance().sendMulti(brd, oldMembers);
/*      */     
/*      */ 
/*  376 */     SJoinTeamNotify notify = new SJoinTeamNotify();
/*  377 */     fillTeamBean(teamid, xTeam, notify.team);
/*  378 */     OnlineManager.getInstance().send(roleid, notify);
/*      */     
/*      */ 
/*  381 */     SDispositionChanged disBrd = fillPositionChangePro(xTeam);
/*  382 */     broadcast(xTeam, disBrd);
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
/*      */   private static void setNormalAfterJoinTeam(long teamid, xbean.Team xTeam, long roleid, xbean.TeamMember xMember, long leaderId)
/*      */   {
/*  398 */     if (xMember.getStatus() != 1)
/*      */     {
/*  400 */       return;
/*      */     }
/*      */     
/*  403 */     if (!checkCanReturnTeam(roleid, leaderId, teamid, xTeam))
/*      */     {
/*  405 */       sendNormalResult(roleid, 3001, new String[0]);
/*  406 */       return;
/*      */     }
/*      */     
/*  409 */     int res = canBeNormal(roleid, Long.valueOf(teamid), xTeam, leaderId, xMember);
/*  410 */     if (res > 0)
/*      */     {
/*  412 */       xMember.setStatus(0);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void noticeInviteeTeamFull(long teamid, xbean.Team xTeam)
/*      */   {
/*  424 */     if (!isTeamFull(xTeam))
/*      */     {
/*  426 */       return;
/*      */     }
/*  428 */     List<Long> teamInvitees = getTeamInvitees(xTeam);
/*  429 */     if (teamInvitees.size() <= 0)
/*      */     {
/*  431 */       return;
/*      */     }
/*  433 */     STeamFullBrd fullBrd = new STeamFullBrd();
/*  434 */     fullBrd.team = teamid;
/*  435 */     OnlineManager.getInstance().sendMulti(fullBrd, teamInvitees);
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
/*      */   private static TeamDispositionMember joinTeamDisposition(long teamid, xbean.Team xTeam, long roleid)
/*      */   {
/*  452 */     xbean.TeamMember xMember = getXMember(xTeam, roleid);
/*  453 */     if (xMember == null)
/*      */     {
/*  455 */       return null;
/*      */     }
/*  457 */     if (xMember.getStatus() != 0)
/*      */     {
/*  459 */       return null;
/*      */     }
/*  461 */     return joinTeamDisposition(xTeam, roleid);
/*      */   }
/*      */   
/*      */   private static TeamDispositionMember joinTeamDisposition(xbean.Team xTeam, long roleid)
/*      */   {
/*  466 */     TeamDispositionMember xTDMember = Pod.newTeamDispositionMember();
/*  467 */     xTDMember.setDispositionmemberid(roleid);
/*  468 */     xTDMember.setDispositionmembertype(0);
/*      */     
/*  470 */     addDispositionMember(xTeam, xTDMember);
/*  471 */     return xTDMember;
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
/*      */   private static void addDispositionMember(xbean.Team xTeam, TeamDispositionMember xTDMember)
/*      */   {
/*  490 */     if (xTeam.getDisposition().containsValue(xTDMember))
/*      */     {
/*  492 */       return;
/*      */     }
/*  494 */     int local = -1;
/*  495 */     Map<Integer, TeamDispositionMember> xTDMemeberMap = xTeam.getDisposition();
/*  496 */     for (int i = 0; i < teamConsts.TEAM_CAPACITY; i++)
/*      */     {
/*  498 */       if ((xTDMemeberMap.get(Integer.valueOf(i)) == null) || (((TeamDispositionMember)xTDMemeberMap.get(Integer.valueOf(i))).getDispositionmembertype() != 0))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  503 */         local = i;
/*  504 */         break;
/*      */       } }
/*  506 */     if (local < 0)
/*      */     {
/*  508 */       if (logger.isDebugEnabled())
/*      */       {
/*  510 */         logger.debug("队伍站位列表已满！");
/*      */       }
/*  512 */       return;
/*      */     }
/*      */     
/*  515 */     xTeam.getDisposition().put(Integer.valueOf(local), xTDMember);
/*  516 */     Map<Integer, Integer> leaderPartnerMap = PartnerInterface.getFightPartnerListWithoutRole(((xbean.TeamMember)xTeam.getMembers().get(0)).getRoleid(), false);
/*      */     
/*  518 */     fillDispositionByLeaderPartners(leaderPartnerMap, xTeam);
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
/*      */   private static xbean.TeamMember joinTeam(long teamid, xbean.Team xTeam, long roleid, JoinTeamType joinTeamType)
/*      */   {
/*  534 */     long leaderId = getLearder(xTeam);
/*  535 */     if ((leaderId > 0L) && (leaderId != roleid))
/*      */     {
/*  537 */       if (checkLeaderInCross(leaderId, roleid))
/*      */       {
/*      */ 
/*  540 */         GameServer.logger().info(String.format("[team]TeamManager.joinTeam@leader is in cross state!|teamId=%d|leaderId=%d|roleId=%d|joinType=%s", new Object[] { Long.valueOf(teamid), Long.valueOf(roleid), joinTeamType == null ? "" : joinTeamType.toString() }));
/*      */         
/*      */ 
/*      */ 
/*  544 */         return null;
/*      */       }
/*      */     }
/*  547 */     RoleJoinState state = getNewGuyTeamState(roleid, leaderId, joinTeamType);
/*  548 */     if (!changeRoleTeamStatus(roleid, state.getState()))
/*      */     {
/*  550 */       GameServer.logger().info(String.format("[team]TeamManager.joinTeam@can not join team in state|teamId=%d|roleId=%d|joinType=%s", new Object[] { Long.valueOf(teamid), Long.valueOf(roleid), joinTeamType }));
/*      */       
/*      */ 
/*  553 */       return null;
/*      */     }
/*  555 */     if ((leaderId > 0L) && (joinTeamType != null))
/*      */     {
/*  557 */       if (!checkCanJoinTeam(teamid, xTeam, roleid, joinTeamType, state))
/*      */       {
/*  559 */         GameServer.logger().info(String.format("[team]TeamManager.joinTeam@can not join team in handler|teamId=%d|roleId=%d|joinType=%s", new Object[] { Long.valueOf(teamid), Long.valueOf(roleid), joinTeamType.toString() }));
/*      */         
/*      */ 
/*      */ 
/*  563 */         clearJoinGuyTeamData(teamid, roleid);
/*  564 */         return null;
/*      */       }
/*      */     }
/*  567 */     if (state.needTF2Leader())
/*      */     {
/*  569 */       transformToLeader(roleid, leaderId);
/*      */     }
/*  571 */     if (joinTeamType != JoinTeamType.JOIN_TEAM__FORMAT_AS_TMP_LEAVE)
/*      */     {
/*  573 */       checkReturnAfterJoinTeam(leaderId, roleid, state);
/*      */     }
/*  575 */     return addRole2XTeam(teamid, xTeam, roleid, state);
/*      */   }
/*      */   
/*      */   private static boolean checkLeaderInCross(long leaderId, long roleId)
/*      */   {
/*  580 */     if (RoleStatusInterface.containsStatus(leaderId, 41))
/*      */     {
/*  582 */       return true;
/*      */     }
/*  584 */     if (RoleStatusInterface.containsStatus(leaderId, 40))
/*      */     {
/*  586 */       return true;
/*      */     }
/*      */     
/*  589 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void checkReturnAfterJoinTeam(long leaderId, long roleid, RoleJoinState state)
/*      */   {
/*  600 */     if (state.isInHomeLand())
/*      */     {
/*  602 */       ReturnTeamManager.transformIntoHomeland(leaderId, roleid);
/*  603 */       return;
/*      */     }
/*  605 */     Procedure.execute(new LogicProcedure()
/*      */     {
/*      */ 
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/*  611 */         return ReturnTeamManager.onReturnTeam(this.val$roleid);
/*      */       }
/*      */     });
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
/*      */   private static void clearJoinGuyTeamData(long teamid, long planRoleId)
/*      */   {
/*  628 */     new PRmApplicant(planRoleId, teamid).execute();
/*  629 */     new PRmInvite(planRoleId, teamid).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static xbean.TeamMember addRole2XTeam(long teamid, xbean.Team xTeam, long roleid, RoleJoinState state)
/*      */   {
/*  639 */     xbean.TeamMember xMember = Pod.newTeamMember();
/*  640 */     xTeam.getMembers().add(xMember);
/*  641 */     initXMember(roleid, xMember, state);
/*  642 */     Role2team.insert(Long.valueOf(roleid), Long.valueOf(teamid));
/*  643 */     return xMember;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void initXMember(long roleid, xbean.TeamMember xMember, RoleJoinState state)
/*      */   {
/*  651 */     xMember.setRoleid(roleid);
/*  652 */     xMember.setTempstatus(state.getTempState());
/*  653 */     xMember.setIstobefired(false);
/*  654 */     xMember.setStatus(state.getState());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static RoleJoinState getNewGuyTeamState(long roleId, long leaderId, JoinTeamType joinTeamType)
/*      */   {
/*  666 */     RoleJoinState state = new RoleJoinState();
/*  667 */     if ((roleId == leaderId) || (leaderId == -1L))
/*      */     {
/*  669 */       state.setAllState(0, 0);
/*  670 */       return state;
/*      */     }
/*      */     
/*  673 */     if (!OnlineManager.getInstance().isOnline(roleId))
/*      */     {
/*  675 */       state.setAllState(2, 0);
/*  676 */       return state;
/*      */     }
/*      */     
/*  679 */     if (FightInterface.isInObserving(roleId))
/*      */     {
/*  681 */       state.setAllState(1, 0);
/*  682 */       return state;
/*      */     }
/*      */     
/*  685 */     if (FightInterface.isInFight(roleId))
/*      */     {
/*  687 */       state.setAllState(1, 6);
/*  688 */       sendTeamNotice(roleId, true, 41, new String[0]);
/*  689 */       return state;
/*      */     }
/*      */     
/*  692 */     if (FightInterface.isInFight(leaderId))
/*      */     {
/*  694 */       state.setAllState(1, 6);
/*  695 */       state.setNeedTF2Leader(true);
/*  696 */       sendTeamNotice(roleId, true, 42, new String[0]);
/*  697 */       return state;
/*      */     }
/*      */     
/*  700 */     if (isLeaderInHomeLandButNotMember(leaderId, roleId))
/*      */     {
/*  702 */       state.setAllState(1, 0);
/*  703 */       state.setInHomeLand(true);
/*  704 */       return state;
/*      */     }
/*      */     
/*  707 */     if (joinTeamType == JoinTeamType.JOIN_TEAM__FORMAT_AS_TMP_LEAVE)
/*      */     {
/*  709 */       state.setAllState(1, 0);
/*  710 */       return state;
/*      */     }
/*      */     
/*  713 */     state.setAllState(0, 0);
/*  714 */     return state;
/*      */   }
/*      */   
/*      */   static boolean isLeaderInHomeLandButNotMember(long leader, long roleId)
/*      */   {
/*  719 */     int mapId_leader = MapInterface.getRoleMapId(leader);
/*  720 */     if (!HomelandInterface.isHomelandMap(mapId_leader))
/*      */     {
/*      */ 
/*  723 */       return false;
/*      */     }
/*  725 */     long worldId_leader = MapInterface.getRoleWorldInstanceId(leader);
/*  726 */     long worldId_member = MapInterface.getRoleWorldInstanceId(roleId);
/*  727 */     if (worldId_leader == worldId_member)
/*      */     {
/*      */ 
/*  730 */       return false;
/*      */     }
/*  732 */     return true;
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
/*      */   private static boolean canJoinTeamAsNormalState(long roleId, long leaderId)
/*      */   {
/*  746 */     if (!MapInterface.isInSameView(leaderId, roleId))
/*      */     {
/*  748 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  752 */     if (!FightInterface.isInObserving(roleId))
/*      */     {
/*  754 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  758 */     if (!FightInterface.isInFight(roleId))
/*      */     {
/*  760 */       return false;
/*      */     }
/*  762 */     if (!FightInterface.isInFight(leaderId))
/*      */     {
/*  764 */       return false;
/*      */     }
/*      */     
/*  767 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkCanJoinTeam(long teamid, xbean.Team xTeam, long roleid, JoinTeamType joinTeamType, RoleJoinState state)
/*      */   {
/*  779 */     if (joinTeamType == JoinTeamType.JOIN_TEAM__FORMAT_AS_TMP_LEAVE)
/*      */     {
/*  781 */       return true;
/*      */     }
/*  783 */     long leaderId = getLearder(xTeam);
/*  784 */     if (leaderId <= 0L)
/*      */     {
/*  786 */       return false;
/*      */     }
/*  788 */     long leaderWorldId = MapInterface.getRoleWorldInstanceId(leaderId);
/*  789 */     long roleWorldId = MapInterface.getRoleWorldInstanceId(roleid);
/*  790 */     TeamInfo teamInfo = new TeamInfo(teamid, xTeam);
/*      */     
/*  792 */     JoinTeamCheckHandler handler_leader = null;
/*  793 */     JoinTeamCheckHandler handler_member = null;
/*      */     
/*  795 */     handler_leader = (JoinTeamCheckHandler)joinTeamCheckHandlers.get(Long.valueOf(leaderWorldId));
/*  796 */     if (leaderWorldId != roleWorldId)
/*      */     {
/*  798 */       handler_member = (JoinTeamCheckHandler)joinTeamCheckHandlers.get(Long.valueOf(roleWorldId));
/*      */     }
/*  800 */     if ((handler_leader == null) && (handler_member == null))
/*      */     {
/*  802 */       if (leaderWorldId == roleWorldId)
/*      */       {
/*  804 */         return true;
/*      */       }
/*      */       
/*      */ 
/*  808 */       GameServer.logger().info(String.format("[team]TeamManager.checkCanJoinTeam@not same world and not register！|roleId=%d|roleWorldId=%d|leaderId=%d|leaderWorldId=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(roleWorldId), Long.valueOf(leaderId), Long.valueOf(leaderWorldId) }));
/*      */       
/*      */ 
/*      */ 
/*  812 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  816 */     boolean needTF2Leader = needTransform(state);
/*  817 */     if (handler_leader != null)
/*      */     {
/*  819 */       JoinTeamResult res_leader = handler_leader.canJoinTeam(teamInfo, roleid, leaderWorldId, roleWorldId, needTF2Leader, joinTeamType);
/*      */       
/*  821 */       if (!res_leader.isSucceed())
/*      */       {
/*  823 */         return joinWrongPro(roleid, leaderId, res_leader);
/*      */       }
/*      */     }
/*      */     
/*  827 */     if (handler_member != null)
/*      */     {
/*  829 */       JoinTeamResult res_member = handler_member.canJoinTeam(teamInfo, roleid, leaderWorldId, roleWorldId, needTF2Leader, joinTeamType);
/*      */       
/*  831 */       if (!res_member.isSucceed())
/*      */       {
/*  833 */         return joinWrongPro(roleid, leaderId, res_member);
/*      */       }
/*      */     }
/*  836 */     return true;
/*      */   }
/*      */   
/*      */   private static boolean needTransform(RoleJoinState state)
/*      */   {
/*  841 */     if (state.needTF2Leader())
/*      */     {
/*  843 */       return true;
/*      */     }
/*  845 */     if (state.getState() == 0)
/*      */     {
/*  847 */       return true;
/*      */     }
/*  849 */     return false;
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
/*      */   static boolean checkRoleCanReturn(long roleId, long leaderId, long teamId, xbean.Team xTeam)
/*      */   {
/*  863 */     long leaderWorldId = MapInterface.getRoleWorldInstanceId(leaderId);
/*  864 */     long roleWorldId = MapInterface.getRoleWorldInstanceId(roleId);
/*      */     
/*  866 */     JoinTeamCheckHandler handler_leader = null;
/*  867 */     JoinTeamCheckHandler handler_member = null;
/*      */     
/*  869 */     handler_leader = (JoinTeamCheckHandler)joinTeamCheckHandlers.get(Long.valueOf(leaderWorldId));
/*  870 */     if (leaderWorldId != roleWorldId)
/*      */     {
/*  872 */       handler_member = (JoinTeamCheckHandler)joinTeamCheckHandlers.get(Long.valueOf(roleWorldId));
/*      */     }
/*      */     
/*  875 */     if ((handler_leader == null) && (handler_member == null))
/*      */     {
/*  877 */       if (leaderWorldId == roleWorldId)
/*      */       {
/*  879 */         return true;
/*      */       }
/*      */       
/*      */ 
/*  883 */       GameServer.logger().info(String.format("[team]TeamManager.checkRoleCanReturn@not same world and not register！|roleId=%d|roleWorldId=%d|leaderId=%d|leaderWorldId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(roleWorldId), Long.valueOf(leaderId), Long.valueOf(leaderWorldId) }));
/*      */       
/*      */ 
/*      */ 
/*  887 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  891 */     TeamInfo teamInfo = new TeamInfo(teamId, xTeam);
/*  892 */     if (handler_leader != null)
/*      */     {
/*  894 */       ReturnTeamResult res_leader = handler_leader.canReturnTeam(teamInfo, roleId, leaderWorldId, roleWorldId);
/*  895 */       if (!res_leader.isSucceed())
/*      */       {
/*  897 */         returnWrongPro(roleId, res_leader);
/*  898 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  902 */     if (handler_member != null)
/*      */     {
/*  904 */       ReturnTeamResult res_member = handler_member.canReturnTeam(teamInfo, roleId, leaderWorldId, roleWorldId);
/*  905 */       if (!res_member.isSucceed())
/*      */       {
/*  907 */         returnWrongPro(roleId, res_member);
/*  908 */         return false;
/*      */       }
/*      */     }
/*  911 */     return true;
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
/*      */   static boolean checkCanReturnTeam(long roleId, long leaderId, long teamid, xbean.Team xTeam)
/*      */   {
/*  925 */     if (roleId == leaderId)
/*      */     {
/*  927 */       return true;
/*      */     }
/*  929 */     long leaderWorldId = MapInterface.getRoleWorldInstanceId(leaderId);
/*  930 */     long roleWorldId = MapInterface.getRoleWorldInstanceId(roleId);
/*  931 */     TeamInfo teamInfo = new TeamInfo(teamid, xTeam);
/*      */     
/*  933 */     ReturnTeamCheckHandler returnTeamCheckHandler_leader = (ReturnTeamCheckHandler)returnTeamCheckHandlers.get(Long.valueOf(leaderWorldId));
/*  934 */     ReturnTeamCheckHandler returnTeamCheckHandler_member = (ReturnTeamCheckHandler)returnTeamCheckHandlers.get(Long.valueOf(roleWorldId));
/*      */     
/*  936 */     if ((returnTeamCheckHandler_leader == null) || (returnTeamCheckHandler_member == null))
/*      */     {
/*  938 */       if (leaderWorldId == roleWorldId)
/*      */       {
/*  940 */         return true;
/*      */       }
/*      */       
/*      */ 
/*  944 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  948 */     if (!returnTeamCheckHandler_leader.canBeReturnTeam(teamInfo, leaderId, roleId))
/*      */     {
/*  950 */       return false;
/*      */     }
/*      */     
/*  953 */     if (!returnTeamCheckHandler_member.canReturnTeam(roleId))
/*      */     {
/*  955 */       return false;
/*      */     }
/*  957 */     return true;
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
/*      */   static boolean joinWrongPro(long roleid, long leaderId, JoinTeamResult res_member)
/*      */   {
/*  970 */     Map<JoinTeamResult.Receiver, JoinTeamResult.Result> sender2Result = res_member.getSender2Result();
/*  971 */     if ((sender2Result == null) || (sender2Result.size() == 0))
/*      */     {
/*  973 */       return false;
/*      */     }
/*  975 */     Iterator<Map.Entry<JoinTeamResult.Receiver, JoinTeamResult.Result>> it = sender2Result.entrySet().iterator();
/*  976 */     while (it.hasNext())
/*      */     {
/*  978 */       Map.Entry<JoinTeamResult.Receiver, JoinTeamResult.Result> entry = (Map.Entry)it.next();
/*  979 */       switch ((JoinTeamResult.Receiver)entry.getKey())
/*      */       {
/*      */       case Leader: 
/*  982 */         sendNormalResult(leaderId, ((JoinTeamResult.Result)entry.getValue()).res, ((JoinTeamResult.Result)entry.getValue()).args);
/*  983 */         break;
/*      */       case Member: 
/*  985 */         sendNormalResult(roleid, ((JoinTeamResult.Result)entry.getValue()).res, ((JoinTeamResult.Result)entry.getValue()).args);
/*      */       }
/*      */       
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  992 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void returnWrongPro(long roleId, ReturnTeamResult res)
/*      */   {
/* 1003 */     if (res.getResult() == null)
/*      */     {
/* 1005 */       return;
/*      */     }
/* 1007 */     sendNormalResult(roleId, res.getResult().res, res.getResult().args);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean leaveTeam(long teamid, xbean.Team xTeam, long roleid, LeaveTeamArg.LeaveTeamReason reason)
/*      */   {
/* 1013 */     SLeaveTeamBrd brd = new SLeaveTeamBrd();
/* 1014 */     brd.roleid = roleid;
/* 1015 */     List<Long> roleList = getMemberListByXTeam(xTeam);
/* 1016 */     OnlineManager.getInstance().sendMulti(brd, roleList);
/*      */     
/* 1018 */     return removeMember(teamid, xTeam, roleid, reason);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean fireMember(long teamid, xbean.Team xTeam, long roleid)
/*      */   {
/* 1024 */     SFireMemberBrd brd = new SFireMemberBrd();
/* 1025 */     brd.member = roleid;
/*      */     
/* 1027 */     List<Long> roleList = getMemberListByXTeam(xTeam);
/* 1028 */     roleList.add(Long.valueOf(roleid));
/* 1029 */     OnlineManager.getInstance().sendMulti(brd, roleList);
/*      */     
/* 1031 */     return removeMember(teamid, xTeam, roleid, LeaveTeamArg.LeaveTeamReason.BE_FIRED);
/*      */   }
/*      */   
/*      */   private static boolean removeMember(long teamid, xbean.Team xTeam, long roleid, LeaveTeamArg.LeaveTeamReason reason)
/*      */   {
/* 1036 */     Set<Integer> roleStatus = RoleStatusInterface.selectStatusSet(roleid);
/* 1037 */     if (!rmRoleTeamStatus(roleid, roleStatus))
/*      */     {
/* 1039 */       return false;
/*      */     }
/*      */     
/* 1042 */     clearStableState(teamid, xTeam);
/*      */     
/* 1044 */     int memberStatus = rmRoleFrom(xTeam, roleid);
/* 1045 */     if (memberStatus < 0)
/*      */     {
/* 1047 */       return false;
/*      */     }
/*      */     
/* 1050 */     rmRolePosFrom(teamid, xTeam, roleid);
/*      */     
/*      */ 
/*      */ 
/* 1054 */     checkRemoveTeam(teamid, xTeam);
/* 1055 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void rmRolePosFrom(long teamid, xbean.Team xTeam, long roleid)
/*      */   {
/* 1067 */     removeDispositionMember(xTeam, roleid);
/*      */     
/* 1069 */     if (xTeam.getMembers().size() > 0)
/*      */     {
/*      */ 
/* 1072 */       Procedure.execute(new PSynTeamDisposition(teamid));
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
/*      */   static void triggerLeaveTeamEvent(long teamid, long roleid, LeaveTeamArg.LeaveTeamReason reason, int memberStatus, boolean leaderChange, List<mzm.gsp.team.TeamMember> members, List<Long> oldMembers)
/*      */   {
/* 1088 */     LeaveTeamArg leaveArg = new LeaveTeamArg(teamid, roleid, memberStatus, reason, leaderChange, members);
/* 1089 */     LeaveTeam leaveTeam = new LeaveTeam();
/* 1090 */     leaveTeam.setSequential(true);
/* 1091 */     trigTeamEvent(oldMembers, leaveTeam, leaveArg);
/* 1092 */     GameServer.logger().info(String.format("[team]teamManager.triggerLeaveTeamEvent@ role leave team!|teamId=%d|leaveRoleId=%d|reason=%s|status=%d|leaderChange=%s|oldMembers=%s", new Object[] { Long.valueOf(teamid), Long.valueOf(roleid), reason.name(), Integer.valueOf(memberStatus), String.valueOf(leaderChange), oldMembers.toString() }));
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
/*      */   private static int rmRoleFrom(xbean.Team xTeam, long roleid)
/*      */   {
/* 1107 */     int memberStatus = -1;
/* 1108 */     Iterator<xbean.TeamMember> iter = xTeam.getMembers().iterator();
/* 1109 */     while (iter.hasNext())
/*      */     {
/* 1111 */       xbean.TeamMember xMember = (xbean.TeamMember)iter.next();
/* 1112 */       if (xMember.getRoleid() == roleid)
/*      */       {
/* 1114 */         memberStatus = xMember.getStatus();
/* 1115 */         iter.remove();
/* 1116 */         break;
/*      */       }
/*      */     }
/* 1119 */     if (memberStatus >= 0)
/*      */     {
/* 1121 */       Role2team.delete(Long.valueOf(roleid));
/*      */     }
/* 1123 */     return memberStatus;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void clearStableState(long teamId, xbean.Team xTeam)
/*      */   {
/* 1133 */     if (isStableTeam(xTeam).booleanValue())
/*      */     {
/* 1135 */       List<Long> members = getMemberListByXTeam(xTeam);
/* 1136 */       triggerStableTeamChangeEvent(members, teamId, false);
/*      */     }
/* 1138 */     xTeam.setSameteamfightcount(0);
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
/*      */   private static void removeDispositionMember(xbean.Team xTeam, long roleid)
/*      */   {
/* 1153 */     int index = -1;
/* 1154 */     Map<Integer, TeamDispositionMember> xTDMap = xTeam.getDisposition();
/* 1155 */     for (int i = 0; i < teamConsts.TEAM_CAPACITY; i++)
/*      */     {
/* 1157 */       if (xTDMap.get(Integer.valueOf(i)) == null) {
/*      */         break;
/*      */       }
/*      */       
/* 1161 */       if (((TeamDispositionMember)xTDMap.get(Integer.valueOf(i))).getDispositionmembertype() == 0)
/*      */       {
/* 1163 */         if (((TeamDispositionMember)xTDMap.get(Integer.valueOf(i))).getDispositionmemberid() == roleid)
/*      */         {
/* 1165 */           xTDMap.remove(Integer.valueOf(i));
/* 1166 */           index = i;
/* 1167 */           break;
/*      */         }
/*      */       }
/*      */     }
/* 1171 */     if (index <= 0)
/*      */     {
/* 1173 */       return;
/*      */     }
/* 1175 */     for (int i = index; i < teamConsts.TEAM_CAPACITY; i++)
/*      */     {
/* 1177 */       int j = i + 1;
/* 1178 */       TeamDispositionMember xTDmeMember = (TeamDispositionMember)xTDMap.get(Integer.valueOf(j));
/* 1179 */       if (xTDmeMember == null) {
/*      */         break;
/*      */       }
/*      */       
/* 1183 */       if (xTDmeMember.getDispositionmembertype() != 0) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/* 1188 */       xTeam.getDisposition().put(Integer.valueOf(i), xTDmeMember.copy());
/* 1189 */       xTeam.getDisposition().remove(Integer.valueOf(j));
/*      */     }
/* 1191 */     Map<Integer, Integer> leaderPartnerMap = PartnerInterface.getFightPartnerListWithoutRole(((xbean.TeamMember)xTeam.getMembers().get(0)).getRoleid(), false);
/*      */     
/* 1193 */     fillDispositionByLeaderPartners(leaderPartnerMap, xTeam);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkRemoveTeam(long teamid, xbean.Team xTeam)
/*      */   {
/* 1204 */     boolean bRemove = true;
/*      */     
/* 1206 */     if (xTeam.getMembers().size() > 0)
/*      */     {
/* 1208 */       for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */       {
/* 1210 */         if (xMember.getStatus() == 0)
/*      */         {
/* 1212 */           bRemove = false;
/* 1213 */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1218 */     if (bRemove)
/*      */     {
/* 1220 */       disTeam(teamid, xTeam);
/*      */     }
/*      */     
/* 1223 */     return bRemove;
/*      */   }
/*      */   
/*      */   static boolean changeMemberStatus(long teamid, xbean.Team xTeam, long roleid, int status, boolean isReturnBeforeNormal)
/*      */   {
/* 1228 */     xbean.TeamMember xMember = getXMember(xTeam, roleid);
/* 1229 */     if (xMember == null)
/*      */     {
/* 1231 */       return false;
/*      */     }
/*      */     
/* 1234 */     int oldStatus = xMember.getStatus();
/*      */     
/* 1236 */     if (!changeRoleTeamStatus(roleid, status))
/*      */     {
/* 1238 */       GameServer.logger().error(String.format("[team]teamManager.changeMemberStatus@ changeRoleTeamStatus err!|roleId=%d|teamId=%d|status=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(teamid), Integer.valueOf(status) }));
/*      */       
/*      */ 
/*      */ 
/* 1242 */       return false;
/*      */     }
/*      */     
/* 1245 */     if (xMember.getStatus() == status)
/*      */     {
/* 1247 */       return true;
/*      */     }
/* 1249 */     xMember.setStatus(status);
/*      */     
/* 1251 */     boolean bRemove = false;
/* 1252 */     if (status == 2)
/*      */     {
/* 1254 */       bRemove = checkRemoveTeam(teamid, xTeam);
/*      */     }
/*      */     
/* 1257 */     if (!bRemove)
/*      */     {
/*      */ 
/* 1260 */       SMemberStatusChangedBrd brd = new SMemberStatusChangedBrd();
/* 1261 */       brd.member = roleid;
/* 1262 */       brd.status = status;
/* 1263 */       broadcast(xTeam, brd);
/*      */       
/*      */ 
/* 1266 */       if ((isLeader(roleid, xTeam)) && (status != 0))
/*      */       {
/* 1268 */         if (!autoChangeLeader(teamid, xTeam))
/*      */         {
/* 1270 */           GameServer.logger().error(String.format("[team]teamManager.changeMemberStatus@ autoChangeLeader err!|roleId=%d|teamId=%d|status=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(teamid), Integer.valueOf(status) }));
/*      */           
/*      */ 
/*      */ 
/* 1274 */           return false;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 1279 */       if (status != 0)
/*      */       {
/*      */ 
/* 1282 */         if (isInTeamDispositionList(roleid, xTeam))
/*      */         {
/* 1284 */           removeDispositionMember(xTeam, roleid);
/* 1285 */           Procedure.execute(new PSynTeamDisposition(teamid));
/*      */         }
/* 1287 */         checkAndTriggerStableEvent(teamid, xTeam, oldStatus);
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1292 */         joinTeamDisposition(teamid, xTeam, roleid);
/* 1293 */         OnlineManager.getInstance().sendMulti(fillPositionChangePro(xTeam), getMemberListByXTeam(xTeam));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1298 */     return true;
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
/*      */   static void triggerMemberStatusChangeEvent(long teamid, xbean.Team xTeam, long roleid, int oldStatus, int status, boolean leaderChange, boolean isReturnBeforeNormal)
/*      */   {
/* 1312 */     List<Long> members = getMemberListByXTeam(xTeam);
/* 1313 */     triggerMemberStatusChangeEvent(teamid, xTeam, roleid, oldStatus, status, leaderChange, isReturnBeforeNormal, members);
/*      */   }
/*      */   
/*      */ 
/*      */   static void triggerMemberStatusChangeEvent(long teamid, xbean.Team xTeam, long roleid, int oldStatus, int status, boolean leaderChange, boolean isReturnBeforeNormal, List<Long> members)
/*      */   {
/* 1319 */     List<mzm.gsp.team.TeamMember> teamMembers = getPTeamMembers(xTeam);
/* 1320 */     if (teamMembers.size() <= 0)
/*      */     {
/* 1322 */       return;
/*      */     }
/* 1324 */     TeamMemberStatusChangedArg arg = new TeamMemberStatusChangedArg(teamid, roleid, oldStatus, status, teamMembers, leaderChange);
/*      */     
/* 1326 */     TeamMemberStatusChanged teamMemberStatusChanged = new TeamMemberStatusChanged();
/* 1327 */     teamMemberStatusChanged.setSequential(true);
/* 1328 */     trigTeamEvent(members, teamMemberStatusChanged, arg);
/* 1329 */     GameServer.logger().info(String.format("[team]teamManager.triggerMemberStatusChangeEvent@ role status changed!|teamId=%d|roleId=%d|oldStatus=%d|newStatus=%d|leaderChange=%s|members=%s", new Object[] { Long.valueOf(teamid), Long.valueOf(roleid), Integer.valueOf(oldStatus), Integer.valueOf(status), String.valueOf(leaderChange), members.toString() }));
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
/*      */   private static void checkAndTriggerStableEvent(long teamid, xbean.Team xTeam, int oldStatus)
/*      */   {
/* 1344 */     if ((!isStableTeam(xTeam).booleanValue()) || (oldStatus != 0))
/*      */     {
/* 1346 */       return;
/*      */     }
/* 1348 */     List<Long> normaList = getNormalMemberIdList(xTeam);
/* 1349 */     if (normaList.size() != teamConsts.TEAM_CAPACITY - 1)
/*      */     {
/* 1351 */       return;
/*      */     }
/* 1353 */     List<Long> members = getMemberListByXTeam(xTeam);
/* 1354 */     triggerStableTeamChangeEvent(members, teamid, false);
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
/*      */   static void checkAndTriggerStableEvent(long teamid, xbean.Team xTeam, int newStatus, int oldStatus)
/*      */   {
/* 1367 */     if (!isStableTeam(xTeam).booleanValue())
/*      */     {
/* 1369 */       return;
/*      */     }
/* 1371 */     List<Long> normaList = getNormalMemberIdList(xTeam);
/* 1372 */     int normalSize = normaList.size();
/* 1373 */     List<Long> members = getMemberListByXTeam(xTeam);
/* 1374 */     if (oldStatus == 0)
/*      */     {
/* 1376 */       if ((newStatus == 1) || (newStatus == 2))
/*      */       {
/* 1378 */         if (normalSize == teamConsts.TEAM_CAPACITY - 1)
/*      */         {
/* 1380 */           triggerStableTeamChangeEvent(members, teamid, false);
/*      */         }
/*      */       }
/*      */     }
/* 1384 */     if (oldStatus == 1)
/*      */     {
/* 1386 */       if (newStatus == 0)
/*      */       {
/* 1388 */         if (normalSize == teamConsts.TEAM_CAPACITY)
/*      */         {
/* 1390 */           triggerStableTeamChangeEvent(members, teamid, true);
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
/*      */   static boolean changeRoleTeamStatus(long roleid, int status)
/*      */   {
/* 1404 */     Set<Integer> roleStatus = RoleStatusInterface.selectStatusSet(roleid);
/* 1405 */     if (!rmRoleTeamStatus(roleid, roleStatus))
/*      */     {
/* 1407 */       return false;
/*      */     }
/* 1409 */     return addRoleTeamStatus(roleid, status);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addRoleTeamStatus(long roleid, int status)
/*      */   {
/* 1420 */     switch (status)
/*      */     {
/*      */     case 0: 
/* 1423 */       return RoleStatusInterface.setStatus(roleid, 6, true);
/*      */     
/*      */     case 1: 
/* 1426 */       return RoleStatusInterface.setStatus(roleid, 7, true);
/*      */     }
/*      */     
/* 1429 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean rmRoleTeamStatus(long roleid, Set<Integer> roleStatus)
/*      */   {
/* 1441 */     for (Iterator i$ = roleStatus.iterator(); i$.hasNext();) { int state = ((Integer)i$.next()).intValue();
/*      */       
/* 1443 */       switch (state)
/*      */       {
/*      */       case 6: 
/* 1446 */         RoleStatusInterface.unsetStatus(roleid, 6);
/*      */       case 7: 
/* 1448 */         RoleStatusInterface.unsetStatus(roleid, 7);
/*      */       }
/*      */       
/*      */     }
/*      */     
/*      */ 
/* 1454 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean changeLeader(long teamid, xbean.Team xTeam, int newLeaderIndex, int newLeaderDis)
/*      */   {
/* 1462 */     swapXMember(xTeam, 0, newLeaderIndex);
/* 1463 */     swapDispositionMember(xTeam, 0, newLeaderDis);
/*      */     
/*      */ 
/* 1466 */     xbean.TeamMember xNewLeader = (xbean.TeamMember)xTeam.getMembers().get(0);
/*      */     
/*      */ 
/* 1469 */     if (xTeam.getIsfromplatform())
/*      */     {
/* 1471 */       xTeam.setIsfromplatform(false);
/*      */     }
/*      */     
/*      */ 
/* 1475 */     Procedure.execute(new PSyncApplicantsToLeader(teamid));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1480 */     synTeamZhenFaInfo(xTeam, xNewLeader.getRoleid());
/* 1481 */     return true;
/*      */   }
/*      */   
/*      */   static boolean triggerChangeLeaderEvent(long teamid, xbean.Team xTeam, long oldLeaderId, long newLeaderId)
/*      */   {
/* 1486 */     List<Long> members = getMemberListByXTeam(xTeam);
/*      */     
/* 1488 */     List<mzm.gsp.team.TeamMember> teamMembers = getPTeamMembers(xTeam);
/* 1489 */     if (teamMembers.size() <= 0)
/*      */     {
/* 1491 */       return false;
/*      */     }
/*      */     
/* 1494 */     TeamLeaderChangedArg arg = new TeamLeaderChangedArg(teamid, newLeaderId, oldLeaderId, teamMembers);
/* 1495 */     trigTeamEvent(members, new TeamLeaderChanged(), arg);
/* 1496 */     GameServer.logger().info(String.format("[team]teamManager.triggerChangeLeaderEvent@ leader change!|teamId=%d|oldLeader=%d|newLeader=%d|members=%s", new Object[] { Long.valueOf(teamid), Long.valueOf(oldLeaderId), Long.valueOf(newLeaderId), members.toString() }));
/*      */     
/*      */ 
/*      */ 
/* 1500 */     return true;
/*      */   }
/*      */   
/*      */   static List<mzm.gsp.team.TeamMember> getPTeamMembers(xbean.Team xTeam)
/*      */   {
/* 1505 */     List<mzm.gsp.team.TeamMember> teamMembers = new ArrayList();
/* 1506 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/* 1508 */       teamMembers.add(getTeamMemberBean(xMember));
/*      */     }
/* 1510 */     return teamMembers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synTeamZhenFaInfo(xbean.Team xTeam, long leaderId)
/*      */   {
/* 1522 */     int zhenFaId = PartnerInterface.getRolePartnerDefaultZhenFaId(leaderId);
/* 1523 */     int zhenfaLevel = 0;
/* 1524 */     if ((zhenFaId > 0) && (ZhenfaInterface.isZhenfaExists(zhenFaId)))
/*      */     {
/* 1526 */       zhenfaLevel = ZhenfaInterface.getZhenfaLevel(leaderId, zhenFaId);
/*      */     }
/*      */     else
/*      */     {
/* 1530 */       zhenFaId = 0;
/*      */     }
/* 1532 */     synTeamZhenFaInfo(xTeam, zhenFaId, zhenfaLevel);
/*      */   }
/*      */   
/*      */   static void synTeamZhenFaInfo(xbean.Team xTeam, int zhenfaId, int zhenfaLevel)
/*      */   {
/* 1537 */     SReqChangeZhenfa sReqChangeZhenfa = new SReqChangeZhenfa();
/* 1538 */     sReqChangeZhenfa.changedzhenfaid = zhenfaId;
/* 1539 */     sReqChangeZhenfa.zhenfalevel = zhenfaLevel;
/* 1540 */     broadcast(xTeam, sReqChangeZhenfa);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void swapXMember(xbean.Team xTeam, int index1, int index2)
/*      */   {
/* 1546 */     xbean.TeamMember xMember2 = (xbean.TeamMember)xTeam.getMembers().set(index2, ((xbean.TeamMember)xTeam.getMembers().get(index1)).copy());
/*      */     
/* 1548 */     xTeam.getMembers().set(index1, xMember2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean swapDispositionMember(xbean.Team xTeam, int index1, int index2)
/*      */   {
/* 1555 */     TeamDispositionMember xDispositionMember2 = (TeamDispositionMember)xTeam.getDisposition().put(Integer.valueOf(index2), ((TeamDispositionMember)xTeam.getDisposition().get(Integer.valueOf(index1))).copy());
/*      */     
/* 1557 */     if (xDispositionMember2 == null)
/*      */     {
/* 1559 */       logger.error("站位调整：不允许与空位置调换");
/* 1560 */       return false;
/*      */     }
/*      */     
/* 1563 */     xTeam.getDisposition().put(Integer.valueOf(index1), xDispositionMember2);
/* 1564 */     return true;
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
/*      */   static boolean autoChangeLeader(long teamid, xbean.Team xTeam)
/*      */   {
/* 1581 */     int firstNormalIndex = -1;
/*      */     
/*      */ 
/* 1584 */     if (xTeam.getMembers().size() == 1)
/*      */     {
/* 1586 */       return true;
/*      */     }
/*      */     
/* 1589 */     long newLeaderId = -1L;
/* 1590 */     for (int i = 1; i < xTeam.getMembers().size(); i++)
/*      */     {
/* 1592 */       xbean.TeamMember xMember = (xbean.TeamMember)xTeam.getMembers().get(i);
/* 1593 */       if (xMember.getStatus() == 0)
/*      */       {
/* 1595 */         firstNormalIndex = i;
/* 1596 */         newLeaderId = xMember.getRoleid();
/* 1597 */         break;
/*      */       }
/*      */     }
/*      */     
/* 1601 */     if ((newLeaderId < 0L) || (firstNormalIndex < 0))
/*      */     {
/* 1603 */       return false;
/*      */     }
/*      */     
/* 1606 */     int newLeaderDisIndex = getMemberDisp(xTeam, newLeaderId);
/* 1607 */     if (newLeaderDisIndex < 0)
/*      */     {
/* 1609 */       return false;
/*      */     }
/* 1611 */     broadcastNewLeader(xTeam, newLeaderId);
/* 1612 */     if (!changeLeader(teamid, xTeam, firstNormalIndex, newLeaderDisIndex))
/*      */     {
/* 1614 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1618 */     syncMemberList(xTeam);
/*      */     
/* 1620 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static void syncMemberList(xbean.Team xTeam)
/*      */   {
/* 1626 */     SSyncMemberListBrd brd = new SSyncMemberListBrd();
/* 1627 */     brd.members.addAll(getMemberListByXTeam(xTeam));
/*      */     
/* 1629 */     brd.disposition.addAll(getDispositionListByXTeam(xTeam));
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
/* 1641 */     broadcast(xTeam, brd);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addApplyList(long teamid, xbean.Team xTeam, long roleid, long recommender)
/*      */   {
/* 1653 */     if (xTeam.getApplicants().size() > teamConsts.APPLY_CAPACITY)
/*      */     {
/* 1655 */       return false;
/*      */     }
/*      */     
/* 1658 */     if (isInApplyList(roleid, xTeam))
/*      */     {
/* 1660 */       return false;
/*      */     }
/*      */     
/* 1663 */     xbean.TeamApplicant xApplicant = Pod.newTeamApplicant();
/* 1664 */     xApplicant.setRoleid(roleid);
/* 1665 */     xApplicant.setRecommender(recommender);
/* 1666 */     xTeam.getApplicants().add(xApplicant);
/*      */     
/*      */ 
/* 1669 */     new ApplyTeamSession(teamid, roleid);
/*      */     
/* 1671 */     SNewApplicantNotify notify = new SNewApplicantNotify();
/* 1672 */     fillTeamApplicantBean(xApplicant, notify.applicant);
/* 1673 */     broadcast(xTeam, notify);
/*      */     
/* 1675 */     return true;
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
/*      */   static boolean addInInvitee(long roleid, xbean.TeamMember xMember)
/*      */   {
/* 1689 */     if (isInInvitees(roleid, xMember))
/*      */     {
/* 1691 */       return false;
/*      */     }
/* 1693 */     xMember.getInvitees().add(Long.valueOf(roleid));
/* 1694 */     return true;
/*      */   }
/*      */   
/*      */   static void syncTeam(long teamid, xbean.Team xTeam, long roleid)
/*      */   {
/* 1699 */     SSyncTeam sync = new SSyncTeam();
/* 1700 */     fillTeamBean(teamid, xTeam, sync.team);
/* 1701 */     OnlineManager.getInstance().send(roleid, sync);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncTeamApplicantsToLeader(xbean.Team xTeam)
/*      */   {
/* 1713 */     SSyncApplicantList sync = fillSyncTeamApplicants(xTeam);
/* 1714 */     OnlineManager.getInstance().send(getLearder(xTeam), sync);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncTeamApplicantsToAllMembers(xbean.Team xTeam)
/*      */   {
/* 1726 */     SSyncApplicantList sync = fillSyncTeamApplicants(xTeam);
/* 1727 */     broadcast(xTeam, sync);
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
/*      */   public static SSyncApplicantList fillSyncTeamApplicants(xbean.Team xTeam)
/*      */   {
/* 1740 */     SSyncApplicantList sync = new SSyncApplicantList();
/* 1741 */     for (xbean.TeamApplicant xApplicant : xTeam.getApplicants())
/*      */     {
/* 1743 */       mzm.gsp.team.TeamApplicant applicantBean = getApplicantBean(xApplicant);
/* 1744 */       sync.applicants.add(applicantBean);
/*      */     }
/* 1746 */     return sync;
/*      */   }
/*      */   
/*      */   static mzm.gsp.team.TeamApplicant getApplicantBean(xbean.TeamApplicant xApplicant)
/*      */   {
/* 1751 */     mzm.gsp.team.TeamApplicant applicantBean = new mzm.gsp.team.TeamApplicant();
/* 1752 */     fillTeamApplicantBean(xApplicant, applicantBean);
/* 1753 */     return applicantBean;
/*      */   }
/*      */   
/*      */   static void fillTeamApplicantBean(xbean.TeamApplicant xApplicant, mzm.gsp.team.TeamApplicant applicantBean)
/*      */   {
/* 1758 */     Long roleId = Long.valueOf(xApplicant.getRoleid());
/*      */     
/* 1760 */     mzm.gsp.role.main.Role role = RoleInterface.getRole(roleId.longValue(), false);
/* 1761 */     applicantBean.applicant_id = roleId.longValue();
/* 1762 */     applicantBean.applicant_name = role.getName();
/* 1763 */     applicantBean.applicant_level = role.getLevel();
/* 1764 */     applicantBean.applicant_menpai = role.getOccupationId();
/* 1765 */     applicantBean.applicant_gender = role.getGender();
/* 1766 */     applicantBean.avatarid = AvatarInterface.getCurrentAvatar(roleId.longValue(), false);
/* 1767 */     applicantBean.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId.longValue(), false);
/* 1768 */     if (xApplicant.getRecommender() == -1L)
/*      */     {
/* 1770 */       applicantBean.recommender = "";
/*      */     }
/*      */     else
/*      */     {
/* 1774 */       applicantBean.recommender = RoleInterface.getName(xApplicant.getRecommender());
/*      */     }
/*      */   }
/*      */   
/*      */   static mzm.gsp.team.event.TeamMember getEventTeamMember(xbean.TeamMember xMember)
/*      */   {
/* 1780 */     mzm.gsp.team.event.TeamMember eMember = new mzm.gsp.team.event.TeamMember(xMember.getRoleid(), xMember.getStatus());
/* 1781 */     return eMember;
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
/*      */   static void fillTeamBean(long teamid, xbean.Team xTeam, mzm.gsp.team.Team teamBean)
/*      */   {
/* 1797 */     teamBean.teamid = teamid;
/*      */     
/*      */ 
/* 1800 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/* 1802 */       teamBean.members.add(getTeamMemberBean(xMember));
/*      */     }
/*      */     
/* 1805 */     addDispositionMemberBean(xTeam, teamBean);
/* 1806 */     long leaderId = getLearder(xTeam);
/*      */     
/* 1808 */     teamBean.zhenfaid = PartnerInterface.getRolePartnerDefaultZhenFaId(leaderId);
/* 1809 */     teamBean.zhenfalv = ZhenfaInterface.getZhenfaLevel(leaderId, teamBean.zhenfaid);
/*      */   }
/*      */   
/*      */   private static void addDispositionMemberBean(xbean.Team xTeam, mzm.gsp.team.Team teamBean)
/*      */   {
/* 1814 */     Map<Integer, TeamDispositionMember> xTDMemberMap = xTeam.getDisposition();
/* 1815 */     for (int i = 0; i < teamConsts.TEAM_CAPACITY; i++)
/*      */     {
/* 1817 */       if (xTDMemberMap.get(Integer.valueOf(i)) == null) {
/*      */         break;
/*      */       }
/*      */       
/* 1821 */       teamBean.disposition.add(getTeamDispositionMemberBean((TeamDispositionMember)xTDMemberMap.get(Integer.valueOf(i))));
/*      */     }
/*      */   }
/*      */   
/*      */   static mzm.gsp.team.TeamMember getTeamMemberBean(xbean.TeamMember xMember)
/*      */   {
/* 1827 */     mzm.gsp.team.TeamMember memberBean = new mzm.gsp.team.TeamMember();
/* 1828 */     fillTeamMemberBean(xMember, memberBean);
/* 1829 */     return memberBean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getTeamMemberStatus(long roleid, xbean.Team xTeam)
/*      */   {
/* 1841 */     xbean.TeamMember xMember = getXMember(xTeam, roleid);
/* 1842 */     if (xMember == null)
/*      */     {
/* 1844 */       return -1;
/*      */     }
/* 1846 */     return xMember.getStatus();
/*      */   }
/*      */   
/*      */   static TeamDispositionMemberInfo getTeamDispositionMemberBean(TeamDispositionMember tDMember)
/*      */   {
/* 1851 */     TeamDispositionMemberInfo dispositionmemberBean = new TeamDispositionMemberInfo();
/* 1852 */     fillTeamDispositionMemberBean(tDMember, dispositionmemberBean);
/* 1853 */     return dispositionmemberBean;
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
/*      */   static void fillTeamMemberBean(xbean.TeamMember xMember, mzm.gsp.team.TeamMember memberBean)
/*      */   {
/* 1868 */     Long roleId = Long.valueOf(xMember.getRoleid());
/*      */     
/* 1870 */     memberBean.roleid = roleId.longValue();
/* 1871 */     memberBean.status = xMember.getStatus();
/* 1872 */     memberBean.friendsetting = SystemSettingInterface.getSetting(xMember.getRoleid(), 2).intValue();
/*      */     
/* 1874 */     mzm.gsp.role.main.Role roleInfo = RoleInterface.getRole(roleId.longValue(), false);
/* 1875 */     memberBean.name = roleInfo.getName();
/* 1876 */     memberBean.level = roleInfo.getLevel();
/* 1877 */     memberBean.menpai = roleInfo.getOccupationId();
/* 1878 */     memberBean.gender = roleInfo.getGender();
/*      */     
/* 1880 */     RoleInterface.fillModelInfo(xMember.getRoleid(), memberBean.model);
/*      */     
/* 1882 */     memberBean.avatarid = AvatarInterface.getCurrentAvatar(roleId.longValue(), false);
/* 1883 */     memberBean.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId.longValue(), false);
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
/*      */   static void fillTeamDispositionMemberBean(TeamDispositionMember tDMember, TeamDispositionMemberInfo dispositionmemberBean)
/*      */   {
/* 1898 */     dispositionmemberBean.teamdispositionmember_id = tDMember.getDispositionmemberid();
/* 1899 */     dispositionmemberBean.dispositionmembertype = tDMember.getDispositionmembertype();
/*      */     
/* 1901 */     if (dispositionmemberBean.dispositionmembertype == 1)
/*      */     {
/* 1903 */       PartnerInterface.fillPartnerModelInfo((int)dispositionmemberBean.teamdispositionmember_id, dispositionmemberBean.model);
/*      */     }
/*      */     
/*      */ 
/* 1907 */     if (dispositionmemberBean.dispositionmembertype == 0)
/*      */     {
/* 1909 */       RoleInterface.fillModelInfo(dispositionmemberBean.teamdispositionmember_id, dispositionmemberBean.model);
/*      */     }
/*      */   }
/*      */   
/*      */   static List<Long> getMemberListByXTeam(xbean.Team xTeam)
/*      */   {
/* 1915 */     List<Long> memberList = new ArrayList();
/* 1916 */     if (xTeam != null)
/*      */     {
/* 1918 */       for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */       {
/* 1920 */         memberList.add(Long.valueOf(xMember.getRoleid()));
/*      */       }
/*      */     }
/* 1923 */     return memberList;
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
/*      */   static List<TeamDispositionMemberInfo> getDispositionListByXTeam(xbean.Team xTeam)
/*      */   {
/* 1936 */     List<TeamDispositionMemberInfo> memberList = new ArrayList();
/* 1937 */     if (xTeam == null)
/*      */     {
/* 1939 */       return memberList;
/*      */     }
/* 1941 */     for (int i = 0; i < 5; i++)
/*      */     {
/* 1943 */       TeamDispositionMember xMember = (TeamDispositionMember)xTeam.getDisposition().get(Integer.valueOf(i));
/* 1944 */       if (xMember == null) {
/*      */         break;
/*      */       }
/*      */       
/* 1948 */       TeamDispositionMemberInfo teamDispositionMemberInfo = getTeamDispositionMemberBean(xMember);
/* 1949 */       memberList.add(teamDispositionMemberInfo);
/*      */     }
/* 1951 */     return memberList;
/*      */   }
/*      */   
/*      */   static List<Long> getTempLeaveMemberListByXTeam(xbean.Team xTeam)
/*      */   {
/* 1956 */     List<Long> memberList = new ArrayList();
/* 1957 */     if (xTeam != null)
/*      */     {
/* 1959 */       for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */       {
/* 1961 */         if (xMember.getStatus() == 1)
/*      */         {
/* 1963 */           memberList.add(Long.valueOf(xMember.getRoleid()));
/*      */         }
/*      */       }
/*      */     }
/* 1967 */     return memberList;
/*      */   }
/*      */   
/*      */   static List<Long> getNormalMemberListByXTeam(xbean.Team xTeam)
/*      */   {
/* 1972 */     List<Long> memberList = new ArrayList();
/* 1973 */     if (xTeam != null)
/*      */     {
/* 1975 */       for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */       {
/* 1977 */         if (xMember.getStatus() == 0)
/*      */         {
/* 1979 */           memberList.add(Long.valueOf(xMember.getRoleid()));
/*      */         }
/*      */       }
/*      */     }
/* 1983 */     return memberList;
/*      */   }
/*      */   
/*      */   static xbean.Team getXTeam(long teamid, boolean remainLock)
/*      */   {
/* 1988 */     xbean.Team xTeam = null;
/* 1989 */     if (remainLock)
/*      */     {
/* 1991 */       xTeam = xtable.Team.get(Long.valueOf(teamid));
/*      */     }
/*      */     else
/*      */     {
/* 1995 */       xTeam = xtable.Team.select(Long.valueOf(teamid));
/*      */     }
/* 1997 */     return xTeam;
/*      */   }
/*      */   
/*      */   static xbean.Team getXTeamByRoleid(long roleid, boolean remainTeamLock)
/*      */   {
/* 2002 */     Long teamid = Role2team.select(Long.valueOf(roleid));
/* 2003 */     if (teamid == null)
/*      */     {
/* 2005 */       return null;
/*      */     }
/* 2007 */     return getXTeam(teamid.longValue(), remainTeamLock);
/*      */   }
/*      */   
/*      */   static xbean.TeamMember getXMember(xbean.Team xTeam, long roleid)
/*      */   {
/* 2012 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/* 2014 */       if (xMember.getRoleid() == roleid)
/*      */       {
/* 2016 */         return xMember;
/*      */       }
/*      */     }
/* 2019 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getLearder(xbean.Team xTeam)
/*      */   {
/* 2030 */     if (xTeam == null)
/*      */     {
/* 2032 */       return -1L;
/*      */     }
/* 2034 */     if (xTeam.getMembers().size() == 0)
/*      */     {
/* 2036 */       return -1L;
/*      */     }
/* 2038 */     xbean.TeamMember xMember = (xbean.TeamMember)xTeam.getMembers().get(0);
/* 2039 */     if (xMember == null)
/*      */     {
/* 2041 */       return -1L;
/*      */     }
/* 2043 */     return xMember.getRoleid();
/*      */   }
/*      */   
/*      */   static boolean isLeader(long roleid, xbean.Team xTeam)
/*      */   {
/* 2048 */     if ((xTeam == null) || (xTeam.getMembers().isEmpty()))
/*      */     {
/* 2050 */       return false;
/*      */     }
/* 2052 */     return getLearder(xTeam) == roleid;
/*      */   }
/*      */   
/*      */   static boolean isInTeam(long roleid, xbean.Team xTeam)
/*      */   {
/* 2057 */     if (xTeam == null)
/*      */     {
/* 2059 */       return false;
/*      */     }
/* 2061 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/* 2063 */       if (xMember.getRoleid() == roleid)
/*      */       {
/* 2065 */         return true;
/*      */       }
/*      */     }
/* 2068 */     return false;
/*      */   }
/*      */   
/*      */   static boolean isInTeamDispositionList(long roleid, xbean.Team xTeam)
/*      */   {
/* 2073 */     if (xTeam == null)
/*      */     {
/* 2075 */       return false;
/*      */     }
/* 2077 */     for (TeamDispositionMember xTDMember : xTeam.getDisposition().values())
/*      */     {
/* 2079 */       if ((xTDMember.getDispositionmembertype() == 0) && (xTDMember.getDispositionmemberid() == roleid))
/*      */       {
/*      */ 
/* 2082 */         return true;
/*      */       }
/*      */     }
/* 2085 */     return false;
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
/*      */   static boolean isInApplyList(long roleid, xbean.Team xTeam)
/*      */   {
/* 2099 */     if (xTeam == null)
/*      */     {
/* 2101 */       return false;
/*      */     }
/* 2103 */     for (xbean.TeamApplicant xApplicant : xTeam.getApplicants())
/*      */     {
/* 2105 */       if (xApplicant.getRoleid() == roleid)
/*      */       {
/* 2107 */         return true;
/*      */       }
/*      */     }
/* 2110 */     return false;
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
/*      */   static boolean isInInvitees(long roleid, xbean.TeamMember xMember)
/*      */   {
/* 2124 */     if (xMember == null)
/*      */     {
/* 2126 */       return false;
/*      */     }
/* 2128 */     for (Long inviteeId : xMember.getInvitees())
/*      */     {
/* 2130 */       if (inviteeId.longValue() == roleid)
/*      */       {
/* 2132 */         return true;
/*      */       }
/*      */     }
/* 2135 */     return false;
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
/*      */   static List<Long> getTeamInvitees(xbean.Team xTeam)
/*      */   {
/* 2148 */     if (xTeam == null)
/*      */     {
/* 2150 */       return null;
/*      */     }
/* 2152 */     List<Long> teamInvitees = new ArrayList();
/* 2153 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/* 2155 */       teamInvitees.addAll(xMember.getInvitees());
/*      */     }
/* 2157 */     return teamInvitees;
/*      */   }
/*      */   
/*      */   static boolean isTeamFull(xbean.Team xTeam)
/*      */   {
/* 2162 */     return xTeam.getMembers().size() >= teamConsts.TEAM_CAPACITY;
/*      */   }
/*      */   
/*      */   static boolean removeApplicant(long teamid, xbean.Team xTeam, long applicant)
/*      */   {
/* 2167 */     Iterator<xbean.TeamApplicant> iter = xTeam.getApplicants().iterator();
/* 2168 */     boolean ret = false;
/* 2169 */     while (iter.hasNext())
/*      */     {
/* 2171 */       xbean.TeamApplicant xApplicant = (xbean.TeamApplicant)iter.next();
/* 2172 */       if (xApplicant.getRoleid() == applicant)
/*      */       {
/* 2174 */         iter.remove();
/* 2175 */         ret = true;
/* 2176 */         break;
/*      */       }
/*      */     }
/* 2179 */     return ret;
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
/*      */   static boolean removeInvitee(long invitee, xbean.TeamMember xMember)
/*      */   {
/* 2193 */     if (xMember == null)
/*      */     {
/* 2195 */       return false;
/*      */     }
/*      */     
/* 2198 */     Iterator<Long> iter = xMember.getInvitees().iterator();
/* 2199 */     boolean ret = false;
/* 2200 */     while (iter.hasNext())
/*      */     {
/* 2202 */       if (((Long)iter.next()).longValue() == invitee)
/*      */       {
/* 2204 */         iter.remove();
/* 2205 */         ret = true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 2210 */     return ret;
/*      */   }
/*      */   
/*      */   static void sendNormalResult(long roleid, int result, String... args)
/*      */   {
/* 2215 */     sendTeamNotice(roleid, false, result, args);
/*      */   }
/*      */   
/*      */   static void sendTeamNotice(long roleid, boolean afterSuc, int result, String... args)
/*      */   {
/* 2220 */     STeamNormalResult pro = new STeamNormalResult();
/* 2221 */     pro.result = result;
/* 2222 */     for (String arg : args)
/*      */     {
/* 2224 */       pro.args.add(arg);
/*      */     }
/* 2226 */     if (afterSuc)
/*      */     {
/* 2228 */       OnlineManager.getInstance().send(roleid, pro);
/*      */     }
/*      */     else
/*      */     {
/* 2232 */       OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*      */     }
/*      */   }
/*      */   
/*      */   static void sendNormalResult(long roleid, int result, List<String> args)
/*      */   {
/* 2238 */     STeamNormalResult pro = new STeamNormalResult();
/* 2239 */     pro.result = result;
/* 2240 */     pro.args = ((ArrayList)args);
/* 2241 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
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
/*      */   static void broadcast(long teamId, Protocol pro)
/*      */   {
/* 2255 */     xbean.Team xTeam = xtable.Team.get(Long.valueOf(teamId));
/* 2256 */     if (xTeam == null)
/*      */     {
/* 2258 */       return;
/*      */     }
/* 2260 */     broadcast(xTeam, pro);
/*      */   }
/*      */   
/*      */   static void broadcast(xbean.Team xTeam, Protocol pro)
/*      */   {
/* 2265 */     OnlineManager.getInstance().sendMulti(pro, getMemberListByXTeam(xTeam));
/*      */   }
/*      */   
/*      */   static void broadcastNormalResult(List<Long> roleids, int result, String... args)
/*      */   {
/* 2270 */     STeamNormalResult pro = new STeamNormalResult();
/* 2271 */     pro.result = result;
/* 2272 */     for (String arg : args)
/*      */     {
/* 2274 */       pro.args.add(arg);
/*      */     }
/* 2276 */     OnlineManager.getInstance().sendMulti(pro, roleids);
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
/*      */   static Boolean emptyApplicationList(long teamid, xbean.Team xTeam)
/*      */   {
/* 2292 */     if (xTeam == null)
/*      */     {
/* 2294 */       return Boolean.valueOf(false);
/*      */     }
/*      */     
/*      */ 
/* 2298 */     List<Long> teamApplicants = getTeamApplicationIds(xTeam);
/* 2299 */     if (teamApplicants.size() == 0)
/*      */     {
/* 2301 */       return Boolean.valueOf(false);
/*      */     }
/*      */     
/* 2304 */     Procedure.execute(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/* 2309 */         long teamLeadId = TeamInterface.getTeamLeaderByTeamid(this.val$teamid, false);
/*      */         
/* 2311 */         TeamManager.broadcastNormalResult(this.val$teamApplicants, 32, new String[] { RoleInterface.getName(teamLeadId) });
/*      */         
/* 2313 */         return true;
/*      */       }
/*      */       
/* 2316 */     });
/* 2317 */     xTeam.getApplicants().removeAll(xTeam.getApplicants());
/* 2318 */     if (xTeam.getApplicants().size() != 0)
/*      */     {
/* 2320 */       return Boolean.valueOf(false);
/*      */     }
/*      */     
/*      */ 
/* 2324 */     Procedure.execute(new PSyncApplicantsToAll(teamid));
/*      */     
/* 2326 */     return Boolean.valueOf(true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Long> getTeamApplicationIds(xbean.Team xTeam)
/*      */   {
/* 2338 */     List<Long> teamApplicants = new ArrayList();
/*      */     
/* 2340 */     Iterator<xbean.TeamApplicant> itr = xTeam.getApplicants().iterator();
/* 2341 */     while (itr.hasNext())
/*      */     {
/* 2343 */       teamApplicants.add(Long.valueOf(((xbean.TeamApplicant)itr.next()).getRoleid()));
/*      */     }
/* 2345 */     return teamApplicants;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Boolean isInFight(long roleid)
/*      */   {
/* 2357 */     return Boolean.valueOf(FightInterface.isInFight(roleid));
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
/*      */   static boolean changeMemberTempStatus(long teamid, xbean.Team xTeam, long roleid, int status)
/*      */   {
/* 2375 */     xbean.TeamMember xMember = getXMember(xTeam, roleid);
/* 2376 */     if (xMember == null)
/*      */     {
/* 2378 */       return false;
/*      */     }
/* 2380 */     if (xMember.getTempstatus() == status)
/*      */     {
/* 2382 */       return false;
/*      */     }
/* 2384 */     xMember.setTempstatus(status);
/*      */     
/* 2386 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Boolean isStableTeam(xbean.Team xTeam)
/*      */   {
/* 2398 */     return Boolean.valueOf(xTeam.getSameteamfightcount() >= teamConsts.TEAM_STABLE_MIN_FIGHTCOUNT);
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
/*      */   static void fillDispositionChangedBean(xbean.Team xTeam, List<TeamDispositionMemberInfo> disposition)
/*      */   {
/* 2413 */     for (int i = 0; i < disposition.size(); i++)
/*      */     {
/* 2415 */       ((TeamDispositionMember)xTeam.getDisposition().get(Integer.valueOf(i))).setDispositionmemberid(((TeamDispositionMemberInfo)disposition.get(i)).teamdispositionmember_id);
/* 2416 */       ((TeamDispositionMember)xTeam.getDisposition().get(Integer.valueOf(i))).setDispositionmembertype(((TeamDispositionMemberInfo)disposition.get(i)).dispositionmembertype);
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
/*      */   static void changeWhenApplicantListFull(xbean.Team xTeam)
/*      */   {
/* 2431 */     xTeam.getApplicants().remove(0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Boolean isRoleOnline(long roleid)
/*      */   {
/* 2443 */     gnet.link.Role role = Onlines.getInstance().find(Long.valueOf(roleid));
/* 2444 */     return Boolean.valueOf(role != null);
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
/*      */   static Boolean isRoleInSameTeam(long roleid, long invitee, boolean remainLock)
/*      */   {
/* 2458 */     Long inviteeTeamId = TeamInterface.getTeamidByRoleid(invitee, remainLock);
/* 2459 */     Long roleTeamId = TeamInterface.getTeamidByRoleid(roleid, remainLock);
/*      */     
/* 2461 */     if ((inviteeTeamId != null) && (roleTeamId != null) && (inviteeTeamId == roleTeamId))
/*      */     {
/* 2463 */       return Boolean.valueOf(true);
/*      */     }
/*      */     
/*      */ 
/* 2467 */     return Boolean.valueOf(false);
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
/*      */   static Boolean clearBeFired(xbean.Team xTeam)
/*      */   {
/* 2480 */     if (xTeam == null) {
/* 2481 */       return Boolean.valueOf(false);
/*      */     }
/* 2483 */     for (xbean.TeamMember member : xTeam.getMembers())
/*      */     {
/* 2485 */       if (member.getIstobefired())
/*      */       {
/* 2487 */         member.setIstobefired(false);
/*      */       }
/*      */     }
/*      */     
/* 2491 */     return Boolean.valueOf(true);
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
/*      */   static void fillTeamMemberInfo(STeamMemberInfo steamMemberInfo, List<Long> memberIdList)
/*      */   {
/* 2505 */     List<TeamMemberInfo> teamMemberInfos = new ArrayList();
/*      */     
/* 2507 */     for (Long memberId : memberIdList)
/*      */     {
/* 2509 */       fillEachMemberInfo(memberId, teamMemberInfos);
/*      */     }
/*      */     
/* 2512 */     steamMemberInfo.teammemberinfos.addAll(teamMemberInfos);
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
/*      */   static void fillEachMemberInfo(Long memberId, List<TeamMemberInfo> teamMemberInfos)
/*      */   {
/* 2527 */     TeamMemberInfo teamMemberInfo = new TeamMemberInfo();
/* 2528 */     fillTeamMemberInfo(memberId, teamMemberInfo);
/*      */     
/* 2530 */     teamMemberInfos.add(teamMemberInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillTeamMemberInfo(Long memberId, TeamMemberInfo teamMemberInfo)
/*      */   {
/* 2541 */     mzm.gsp.role.main.Role roleInfo = RoleInterface.getRole(memberId.longValue(), false);
/* 2542 */     teamMemberInfo.teammember_id = memberId.longValue();
/* 2543 */     teamMemberInfo.name = roleInfo.getName();
/* 2544 */     teamMemberInfo.level = roleInfo.getLevel();
/* 2545 */     teamMemberInfo.gender = roleInfo.getGender();
/* 2546 */     teamMemberInfo.menpai = roleInfo.getOccupationId();
/* 2547 */     teamMemberInfo.status = TeamInterface.getTeamMemberStatus(memberId.longValue());
/* 2548 */     teamMemberInfo.avatarid = AvatarInterface.getCurrentAvatar(memberId.longValue(), false);
/* 2549 */     teamMemberInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(memberId.longValue(), false);
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
/*      */   static void afterFightProc(Long teamid, xbean.Team xTeam, List<Long> noEscapedRoles)
/*      */   {
/* 2565 */     if (xTeam == null)
/*      */     {
/* 2567 */       GameServer.logger().info(String.format("TeamManager.afterFightProc@ xTeam is null!|teamId=%d|noEscapedRoles=%s", new Object[] { teamid, noEscapedRoles }));
/*      */       
/*      */ 
/* 2570 */       return;
/*      */     }
/*      */     
/* 2573 */     for (xbean.TeamMember member : xTeam.getMembers())
/*      */     {
/* 2575 */       if (member.getTempstatus() == 6)
/*      */       {
/* 2577 */         PReturnTeamReq returnTeam = new PReturnTeamReq(member.getRoleid());
/* 2578 */         returnTeam.call();
/*      */       }
/*      */     }
/*      */     
/* 2582 */     noEscapedRolesProc(teamid, noEscapedRoles, xTeam);
/*      */     
/* 2584 */     stableTeamPrcAfterFight(xTeam, noEscapedRoles, teamid.longValue());
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
/*      */   static boolean stableTeamPrcAfterFight(xbean.Team xTeam, List<Long> noEscapedRoles, long teamId)
/*      */   {
/* 2602 */     if (noEscapedRoles.size() != teamConsts.TEAM_CAPACITY)
/*      */     {
/* 2604 */       return false;
/*      */     }
/* 2606 */     int num = xTeam.getSameteamfightcount();
/* 2607 */     xTeam.setSameteamfightcount(++num);
/*      */     
/* 2609 */     if (xTeam.getSameteamfightcount() != TeamConsts.getInstance().TEAM_STABLE_MIN_FIGHTCOUNT)
/*      */     {
/* 2611 */       return false;
/*      */     }
/* 2613 */     triggerStableTeamChangeEvent(noEscapedRoles, teamId, true);
/* 2614 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerStableTeamChangeEvent(List<Long> members, long teamId, boolean install)
/*      */   {
/* 2625 */     TeamStableStateChangeArg arg = new TeamStableStateChangeArg();
/* 2626 */     arg.setTeamId(teamId);
/* 2627 */     arg.getMembers().addAll(members);
/* 2628 */     arg.setInstall(install);
/* 2629 */     trigTeamEvent(members, new TeamStableStateChanged(), arg);
/*      */     
/* 2631 */     GameServer.logger().info(String.format("[team]TeamManager.triggerStableTeamChangeEvent@ stable change!|teamId=%d|members=%s|install=%s", new Object[] { Long.valueOf(teamId), members.toString(), String.valueOf(install) }));
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
/*      */   static boolean noEscapedRolesProc(Long teamid, List<Long> noEscapedRoles, xbean.Team xTeam)
/*      */   {
/* 2649 */     List<Long> oldMembers = getMemberListByXTeam(xTeam);
/* 2650 */     for (Iterator i$ = noEscapedRoles.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*      */       
/*      */ 
/* 2653 */       xbean.TeamMember xMember = getXMember(xTeam, member);
/* 2654 */       if (xMember != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2660 */         boolean isLeader = isLeader(member, xTeam);
/*      */         
/* 2662 */         int oldStatus = xMember.getStatus();
/*      */         
/* 2664 */         if (xMember.getIstobefired())
/*      */         {
/* 2666 */           fireMemberWithEvent(teamid, xTeam, member, oldStatus, oldMembers);
/*      */ 
/*      */ 
/*      */ 
/*      */         }
/* 2671 */         else if (xMember.getTempstatus() == 5)
/*      */         {
/* 2673 */           Procedure.execute(new PLeaveTeamReq(member));
/*      */         }
/*      */         else
/*      */         {
/* 2677 */           if ((!isLeader) && (xMember.getTempstatus() == 4))
/*      */           {
/* 2679 */             if (!changeMemberStatus(teamid.longValue(), xTeam, member, 1, false))
/*      */             {
/* 2681 */               return false;
/*      */             }
/*      */             
/* 2684 */             triggerMemberStatusChangeEvent(teamid.longValue(), xTeam, member, 0, 1, false, false, oldMembers);
/*      */           }
/*      */           
/*      */ 
/*      */ 
/* 2689 */           if ((xMember.getTempstatus() != 0) && (xMember.getTempstatus() != 6))
/*      */           {
/*      */ 
/* 2692 */             xMember.setTempstatus(0); }
/*      */         }
/*      */       }
/*      */     }
/* 2696 */     long leaderId = ((xbean.TeamMember)xTeam.getMembers().get(0)).getRoleid();
/*      */     
/* 2698 */     for (Iterator i$ = noEscapedRoles.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*      */       
/* 2700 */       xbean.TeamMember xMember = getXMember(xTeam, member);
/* 2701 */       if (xMember != null)
/*      */       {
/*      */ 
/*      */ 
/* 2705 */         boolean isLeader = leaderId == member;
/* 2706 */         int oldStatus = xMember.getStatus();
/* 2707 */         if (xMember.getIstobeoffline())
/*      */         {
/* 2709 */           xMember.setIstobeoffline(false);
/*      */           
/* 2711 */           if (OnlineManager.getInstance().isOfflineAfterProtect(member))
/*      */           {
/*      */ 
/* 2714 */             changeMemberStatus(teamid.longValue(), xTeam, member, 2, false);
/*      */             
/* 2716 */             triggerMemberStatusChangeEvent(teamid.longValue(), xTeam, member, oldStatus, 2, isLeader, false, oldMembers);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 2721 */     return true;
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
/*      */   public static boolean escapedRoleProc(Long teamid, xbean.Team xTeam, long escapedRole)
/*      */   {
/* 2737 */     xbean.TeamMember escapedMember = getXMember(xTeam, escapedRole);
/* 2738 */     if (escapedMember == null)
/*      */     {
/* 2740 */       return false;
/*      */     }
/*      */     
/* 2743 */     if (escapedMember.getStatus() == 0)
/*      */     {
/* 2745 */       List<Long> normalMemberIds = getNormalMemberIdList(xTeam);
/*      */       
/* 2747 */       if (normalMemberIds.size() == 1)
/*      */       {
/* 2749 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 2754 */     if (isLeader(escapedRole, xTeam))
/*      */     {
/* 2756 */       if (!autoChangeLeader(teamid.longValue(), xTeam))
/*      */       {
/* 2758 */         return false;
/*      */       }
/* 2760 */       triggerChangeLeaderEvent(teamid.longValue(), xTeam, escapedRole, ((xbean.TeamMember)xTeam.getMembers().get(0)).getRoleid());
/* 2761 */       clearBeFired(xTeam);
/*      */     }
/*      */     
/* 2764 */     int oldStatus = escapedMember.getStatus();
/*      */     
/* 2766 */     if (escapedMember.getIstobefired())
/*      */     {
/* 2768 */       fireMemberWithEvent(teamid, xTeam, escapedRole, oldStatus);
/* 2769 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 2773 */     if (escapedMember.getTempstatus() == 5)
/*      */     {
/* 2775 */       activeLeaveTeamWithEvent(teamid, xTeam, escapedRole, oldStatus, false);
/* 2776 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 2780 */     if (escapedMember.getStatus() != 2)
/*      */     {
/* 2782 */       if (!changeMemberStatus(teamid.longValue(), xTeam, escapedRole, 1, false))
/*      */       {
/* 2784 */         return false;
/*      */       }
/*      */       
/* 2787 */       triggerMemberStatusChangeEvent(teamid.longValue(), xTeam, escapedRole, 0, 1, false, false);
/*      */     }
/*      */     
/*      */ 
/* 2791 */     if (escapedMember.getTempstatus() == 6)
/*      */     {
/* 2793 */       PReturnTeamReq returnTeam = new PReturnTeamReq(escapedMember.getRoleid());
/* 2794 */       returnTeam.call();
/*      */     }
/*      */     
/* 2797 */     if ((escapedMember.getTempstatus() != 0) && (escapedMember.getTempstatus() != 6))
/*      */     {
/*      */ 
/* 2800 */       escapedMember.setTempstatus(0);
/*      */     }
/* 2802 */     return true;
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
/*      */   static boolean activeLeaveTeamWithEvent(Long teamid, xbean.Team xTeam, long roleToleave, int oldStatus, boolean leaderChange)
/*      */   {
/* 2817 */     List<Long> oldMembers = getMemberListByXTeam(xTeam);
/* 2818 */     if (!leaveTeam(teamid.longValue(), xTeam, roleToleave, LeaveTeamArg.LeaveTeamReason.ACTIVE_LEAVE))
/*      */     {
/* 2820 */       return false;
/*      */     }
/*      */     
/* 2823 */     List<mzm.gsp.team.TeamMember> members = getPTeamMembers(xTeam);
/* 2824 */     if (members.size() <= 0)
/*      */     {
/* 2826 */       return false;
/*      */     }
/* 2828 */     triggerLeaveTeamEvent(teamid.longValue(), roleToleave, LeaveTeamArg.LeaveTeamReason.ACTIVE_LEAVE, oldStatus, leaderChange, members, oldMembers);
/*      */     
/*      */ 
/* 2831 */     syncMemberList(xTeam);
/* 2832 */     return true;
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
/*      */   static boolean fireMemberWithEvent(Long teamid, xbean.Team xTeam, long roleBeFired, int oldStatus)
/*      */   {
/* 2846 */     List<Long> oldMembers = getMemberListByXTeam(xTeam);
/* 2847 */     return fireMemberWithEvent(teamid, xTeam, roleBeFired, oldStatus, oldMembers);
/*      */   }
/*      */   
/*      */   static boolean fireMemberWithEvent(Long teamid, xbean.Team xTeam, long roleBeFired, int oldStatus, List<Long> oldMembers)
/*      */   {
/* 2852 */     if (!fireMember(teamid.longValue(), xTeam, roleBeFired))
/*      */     {
/* 2854 */       return false;
/*      */     }
/* 2856 */     List<mzm.gsp.team.TeamMember> members = getPTeamMembers(xTeam);
/* 2857 */     if (members.size() <= 0)
/*      */     {
/* 2859 */       return false;
/*      */     }
/* 2861 */     triggerLeaveTeamEvent(teamid.longValue(), roleBeFired, LeaveTeamArg.LeaveTeamReason.BE_FIRED, oldStatus, false, members, oldMembers);
/*      */     
/* 2863 */     syncMemberList(xTeam);
/* 2864 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static List<Long> getNormalMemberIdList(xbean.Team xTeam)
/*      */   {
/* 2875 */     List<Long> normalMemberIds = new ArrayList();
/* 2876 */     List<Long> teamMemberList = getMemberListByXTeam(xTeam);
/* 2877 */     for (Iterator i$ = teamMemberList.iterator(); i$.hasNext();) { long teamMemberId = ((Long)i$.next()).longValue();
/*      */       
/* 2879 */       xbean.TeamMember xMember = getXMember(xTeam, teamMemberId);
/* 2880 */       if (xMember == null)
/*      */       {
/* 2882 */         return null;
/*      */       }
/* 2884 */       if (xMember.getStatus() == 0)
/*      */       {
/*      */ 
/*      */ 
/* 2888 */         normalMemberIds.add(Long.valueOf(teamMemberId)); }
/*      */     }
/* 2890 */     return normalMemberIds;
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
/*      */   static boolean applyTeamByTeamId(long roleid, long leaderId, long teamid, xbean.Team xTeam)
/*      */   {
/* 2906 */     if (!canApplyTeam(roleid, leaderId))
/*      */     {
/* 2908 */       return false;
/*      */     }
/*      */     
/* 2911 */     if (xTeam.getMembers().size() >= teamConsts.TEAM_CAPACITY)
/*      */     {
/*      */ 
/* 2914 */       sendNormalResult(roleid, 14, new String[0]);
/* 2915 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 2919 */     if (isInApplyList(roleid, xTeam))
/*      */     {
/* 2921 */       sendNormalResult(roleid, 21, new String[0]);
/* 2922 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 2926 */     if (xTeam.getApplicants().size() >= teamConsts.APPLY_CAPACITY)
/*      */     {
/*      */ 
/* 2929 */       changeWhenApplicantListFull(xTeam);
/*      */     }
/*      */     
/*      */ 
/* 2933 */     addApplyList(teamid, xTeam, roleid, -1L);
/*      */     
/*      */ 
/* 2936 */     sendNormalResult(roleid, 22, new String[0]);
/* 2937 */     return true;
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
/*      */   public static TeamDispositionInfo getTeamDispInfo(long teamid)
/*      */   {
/* 2950 */     TeamDispositionInfo teamDispositionInfo = new TeamDispositionInfo();
/* 2951 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamid));
/* 2952 */     if (xTeam == null)
/*      */     {
/* 2954 */       return null;
/*      */     }
/* 2956 */     List<TeamDpMember> dispositions = new ArrayList();
/* 2957 */     Map<Integer, TeamDispositionMember> teamDisposition = xTeam.getDisposition();
/* 2958 */     if (teamDisposition == null)
/*      */     {
/* 2960 */       return null;
/*      */     }
/*      */     
/* 2963 */     for (int i = 0; i < teamDisposition.size(); i++)
/*      */     {
/* 2965 */       TeamDispositionMember xTeamDpMember = (TeamDispositionMember)teamDisposition.get(Integer.valueOf(i));
/* 2966 */       if (xTeamDpMember == null) {
/*      */         break;
/*      */       }
/*      */       
/* 2970 */       TeamDpMember teamDpMember = new TeamDpMember();
/* 2971 */       teamDpMember.teamdispositionmember_id = xTeamDpMember.getDispositionmemberid();
/* 2972 */       teamDpMember.dispositionmember_type = xTeamDpMember.getDispositionmembertype();
/*      */       
/* 2974 */       dispositions.add(teamDpMember);
/*      */     }
/* 2976 */     teamDispositionInfo.setDisposition(dispositions);
/* 2977 */     return teamDispositionInfo;
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
/*      */   static void refuseInvite(long roleId, long inviter, xbean.Team xTeam)
/*      */   {
/* 2994 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/* 2996 */       if (xMember.getRoleid() == inviter)
/*      */       {
/*      */ 
/*      */ 
/* 3000 */         Iterator<Long> it = xMember.getInvitees().iterator();
/* 3001 */         while (it.hasNext())
/*      */         {
/* 3003 */           Long memberId = (Long)it.next();
/* 3004 */           if (memberId.longValue() == roleId)
/*      */           {
/* 3006 */             it.remove();
/* 3007 */             sendNormalResult(inviter, 12, new String[] { RoleInterface.getName(roleId) });
/*      */             
/* 3009 */             break;
/*      */           }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Long> getXNormalMemberIdsByLeaderId(Long leaderId, boolean remainLock)
/*      */   {
/* 3028 */     List<Long> normalMemberIds = new ArrayList();
/* 3029 */     Long teamId = TeamInterface.getTeamidByRoleid(leaderId.longValue(), remainLock);
/* 3030 */     if (teamId == null)
/*      */     {
/* 3032 */       return normalMemberIds;
/*      */     }
/* 3034 */     if (!TeamInterface.isTeamLeader(teamId.longValue(), leaderId.longValue(), false))
/*      */     {
/* 3036 */       return normalMemberIds;
/*      */     }
/* 3038 */     TeamDispositionInfo teamDispositionInfo = TeamInterface.getTeamDispositionInfo(teamId.longValue());
/* 3039 */     if (teamDispositionInfo == null)
/*      */     {
/* 3041 */       return normalMemberIds;
/*      */     }
/* 3043 */     for (TeamDpMember xMember : teamDispositionInfo.getDisposition())
/*      */     {
/* 3045 */       if (xMember.dispositionmember_type == 0)
/*      */       {
/* 3047 */         normalMemberIds.add(Long.valueOf(xMember.teamdispositionmember_id));
/*      */       }
/*      */     }
/* 3050 */     return normalMemberIds;
/*      */   }
/*      */   
/*      */ 
/*      */   static Map<Integer, TeamDpMember> getZhanWeiInfoImpl(Long leaderId, boolean remainLock)
/*      */   {
/* 3056 */     Map<Integer, TeamDpMember> zhanWeiMap = new HashMap();
/* 3057 */     Long teamId = TeamInterface.getTeamidByRoleid(leaderId.longValue(), remainLock);
/* 3058 */     if (teamId == null)
/*      */     {
/* 3060 */       return zhanWeiMap;
/*      */     }
/* 3062 */     if (!TeamInterface.isTeamLeader(teamId.longValue(), leaderId.longValue(), false))
/*      */     {
/* 3064 */       return zhanWeiMap;
/*      */     }
/* 3066 */     TeamDispositionInfo teamDispositionInfo = TeamInterface.getTeamDispositionInfo(teamId.longValue());
/* 3067 */     if (teamDispositionInfo == null)
/*      */     {
/* 3069 */       return zhanWeiMap;
/*      */     }
/* 3071 */     int index = 0;
/* 3072 */     for (TeamDpMember xMember : teamDispositionInfo.getDisposition())
/*      */     {
/* 3074 */       if ((xMember.dispositionmember_type == 0) || (xMember.dispositionmember_type == 1))
/*      */       {
/*      */ 
/* 3077 */         if (xMember.teamdispositionmember_id > 0L)
/*      */         {
/* 3079 */           zhanWeiMap.put(Integer.valueOf(index), xMember);
/*      */         }
/*      */       }
/* 3082 */       index++;
/*      */     }
/* 3084 */     return zhanWeiMap;
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
/*      */   public static List<Long> getTeamMembersDispositionByMemberId(long roleId)
/*      */   {
/* 3097 */     List<Long> members = new ArrayList();
/*      */     
/* 3099 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/* 3100 */     if (teamId == null)
/*      */     {
/* 3102 */       return members;
/*      */     }
/* 3104 */     xbean.Team xTeam = getXTeam(teamId.longValue(), false);
/* 3105 */     if (xTeam == null)
/*      */     {
/* 3107 */       return members;
/*      */     }
/* 3109 */     getNormalMemberInDIs(members, xTeam);
/*      */     
/* 3111 */     return members;
/*      */   }
/*      */   
/*      */   static void getNormalMemberInDIs(List<Long> members, xbean.Team xTeam)
/*      */   {
/* 3116 */     Map<Integer, TeamDispositionMember> dispMap = xTeam.getDisposition();
/* 3117 */     for (int i = 0; i < dispMap.size(); i++)
/*      */     {
/* 3119 */       TeamDispositionMember xDispositionMember = (TeamDispositionMember)dispMap.get(Integer.valueOf(i));
/* 3120 */       if (xDispositionMember != null)
/*      */       {
/*      */ 
/*      */ 
/* 3124 */         if (xDispositionMember.getDispositionmembertype() == 0)
/*      */         {
/*      */ 
/*      */ 
/* 3128 */           members.add(Long.valueOf(xDispositionMember.getDispositionmemberid())); }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static int getZhenFaIdImpl(long teamLeaderId, boolean remainLock) {
/* 3134 */     Long teamId = TeamInterface.getTeamidByRoleid(teamLeaderId, remainLock);
/* 3135 */     if (teamId == null)
/*      */     {
/* 3137 */       return 0;
/*      */     }
/* 3139 */     if (!TeamInterface.isTeamLeader(teamId.longValue(), teamLeaderId, false))
/*      */     {
/* 3141 */       return 0;
/*      */     }
/*      */     
/* 3144 */     return PartnerInterface.getRolePartnerDefaultZhenFaId(teamLeaderId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SDispositionChanged fillPositionChangePro(xbean.Team xTeam)
/*      */   {
/* 3155 */     SDispositionChanged brd = new SDispositionChanged();
/* 3156 */     for (int i = 0; i < xTeam.getDisposition().size(); i++)
/*      */     {
/* 3158 */       TeamDispositionMember position = (TeamDispositionMember)xTeam.getDisposition().get(Integer.valueOf(i));
/* 3159 */       if (position == null) {
/*      */         break;
/*      */       }
/*      */       
/* 3163 */       TeamDispositionMemberInfo info = new TeamDispositionMemberInfo();
/* 3164 */       fillTeamDispositionMemberBean(position, info);
/* 3165 */       brd.disposition.add(info);
/*      */     }
/*      */     
/* 3168 */     logDisposition(xTeam, brd);
/* 3169 */     return brd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logDisposition(xbean.Team xTeam, SDispositionChanged brd)
/*      */   {
/* 3180 */     long teamLeader = ((xbean.TeamMember)xTeam.getMembers().get(0)).getRoleid();
/* 3181 */     String leaderName = RoleInterface.getName(teamLeader);
/* 3182 */     StringBuffer sb = new StringBuffer();
/* 3183 */     int i = 1;
/* 3184 */     int j = 1;
/* 3185 */     Iterator<TeamDispositionMemberInfo> it = brd.disposition.iterator();
/* 3186 */     while (it.hasNext())
/*      */     {
/* 3188 */       sb.append("[");
/* 3189 */       sb.append(Integer.toString(i));
/* 3190 */       sb.append("]");
/*      */       
/* 3192 */       TeamDispositionMemberInfo info = (TeamDispositionMemberInfo)it.next();
/* 3193 */       if (info.dispositionmembertype == 1)
/*      */       {
/* 3195 */         sb.append(leaderName);
/* 3196 */         sb.append("伙伴");
/* 3197 */         sb.append(Integer.toString(j));
/* 3198 */         j++;
/*      */       }
/* 3200 */       if (info.dispositionmembertype == 0)
/*      */       {
/* 3202 */         sb.append(RoleInterface.getName(info.teamdispositionmember_id));
/*      */       }
/* 3204 */       sb.append("--");
/* 3205 */       i++;
/*      */     }
/* 3207 */     if (logger.isDebugEnabled())
/*      */     {
/* 3209 */       logger.debug("站位：" + sb.toString());
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
/*      */   static List<Long> getNormalRoleListImpl(long teamLeaderId)
/*      */   {
/* 3222 */     List<Long> normalRoleList = new ArrayList();
/* 3223 */     Long teamid = Role2team.select(Long.valueOf(teamLeaderId));
/* 3224 */     if (teamid == null)
/*      */     {
/* 3226 */       return normalRoleList;
/*      */     }
/* 3228 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 3229 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/* 3231 */       if (xMember.getStatus() == 0)
/*      */       {
/*      */ 
/*      */ 
/* 3235 */         normalRoleList.add(Long.valueOf(xMember.getRoleid())); }
/*      */     }
/* 3237 */     return normalRoleList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/* 3243 */   private static Map<Long, JoinTeamCheckHandler> joinTeamCheckHandlers = new ConcurrentHashMap();
/*      */   
/*      */   public static Map<Long, JoinTeamCheckHandler> getJoinTeamCheckHandlers()
/*      */   {
/* 3247 */     return joinTeamCheckHandlers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void registerJoinTeamImpl(long worldId, JoinTeamCheckHandler joinTeamCheckHandler)
/*      */   {
/* 3259 */     if (joinTeamCheckHandlers.containsKey(Long.valueOf(worldId)))
/*      */     {
/* 3261 */       logger.error("加入队伍类已经被注册了，worldId = " + worldId + "；" + joinTeamCheckHandler.getClass().getName());
/*      */     }
/* 3263 */     joinTeamCheckHandlers.put(Long.valueOf(worldId), joinTeamCheckHandler);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean unRegisterJoinTeamImpl(long worldId)
/*      */   {
/* 3274 */     if (!joinTeamCheckHandlers.containsKey(Long.valueOf(worldId)))
/*      */     {
/* 3276 */       logger.error("加入队伍类没有被注册，worldId = " + worldId);
/* 3277 */       return true;
/*      */     }
/* 3279 */     joinTeamCheckHandlers.remove(Long.valueOf(worldId));
/* 3280 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/* 3286 */   private static Map<Long, ReturnTeamCheckHandler> returnTeamCheckHandlers = new ConcurrentHashMap();
/*      */   
/*      */   public static Map<Long, ReturnTeamCheckHandler> getReturnTeamCheckHandlers()
/*      */   {
/* 3290 */     return returnTeamCheckHandlers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void registerReturnTeamImpl(long worldId, ReturnTeamCheckHandler returnTeamCheckHandler)
/*      */   {
/* 3302 */     if (returnTeamCheckHandlers.containsKey(Long.valueOf(worldId)))
/*      */     {
/* 3304 */       logger.error("归队检查类已经被注册了，worldId = " + worldId + "；" + returnTeamCheckHandler.getClass().getName());
/*      */     }
/* 3306 */     returnTeamCheckHandlers.put(Long.valueOf(worldId), returnTeamCheckHandler);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean unRegisterReturnTeamImpl(long worldId)
/*      */   {
/* 3317 */     if (!returnTeamCheckHandlers.containsKey(Long.valueOf(worldId)))
/*      */     {
/* 3319 */       logger.error("归队检查类没有被注册，worldId = " + worldId);
/* 3320 */       return false;
/*      */     }
/* 3322 */     returnTeamCheckHandlers.remove(Long.valueOf(worldId));
/* 3323 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/* 3329 */   private static Map<Long, ActivityTeamHandler> activityTeamHandlers = new ConcurrentHashMap();
/*      */   
/*      */   public static Map<Long, ActivityTeamHandler> getActiveTeamHandlers()
/*      */   {
/* 3333 */     return activityTeamHandlers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void registerActivityTeamImpl(long worldId, ActivityTeamHandler activityTeamHandler)
/*      */   {
/* 3345 */     if (activityTeamHandlers.containsKey(Long.valueOf(worldId)))
/*      */     {
/* 3347 */       logger.error("活动组队处理类已经被注册了，worldId = " + worldId + "；" + activityTeamHandler.getClass().getName());
/*      */     }
/* 3349 */     activityTeamHandlers.put(Long.valueOf(worldId), activityTeamHandler);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean unRegisterActivityTeamImpl(long worldId)
/*      */   {
/* 3360 */     if (!activityTeamHandlers.containsKey(Long.valueOf(worldId)))
/*      */     {
/* 3362 */       logger.error("活动组队处理类没有被注册，worldId = " + worldId);
/* 3363 */       return true;
/*      */     }
/* 3365 */     activityTeamHandlers.remove(Long.valueOf(worldId));
/* 3366 */     return true;
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
/*      */   static int getOccupationNumInTeamImpl(long teamId, int occupation)
/*      */   {
/* 3382 */     xbean.Team xTeam = getXTeam(teamId, false);
/* 3383 */     if ((xTeam != null) && (!xTeam.getMembers().isEmpty()))
/*      */     {
/* 3385 */       return -1;
/*      */     }
/* 3387 */     if (occupation == 0)
/*      */     {
/* 3389 */       return xTeam.getMembers().size();
/*      */     }
/* 3391 */     int count = 0;
/* 3392 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/* 3394 */       int xOccupation = RoleInterface.getOccupationId(xMember.getRoleid());
/* 3395 */       if (xOccupation == occupation)
/*      */       {
/* 3397 */         count++;
/*      */       }
/*      */     }
/* 3400 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMemberDisp(xbean.Team xTeam, long memberId)
/*      */   {
/* 3411 */     int disIndex = -1;
/* 3412 */     Iterator<Map.Entry<Integer, TeamDispositionMember>> it = xTeam.getDisposition().entrySet().iterator();
/* 3413 */     while (it.hasNext())
/*      */     {
/* 3415 */       Map.Entry<Integer, TeamDispositionMember> entry = (Map.Entry)it.next();
/* 3416 */       if (((TeamDispositionMember)entry.getValue()).getDispositionmemberid() == memberId)
/*      */       {
/* 3418 */         disIndex = ((Integer)entry.getKey()).intValue();
/* 3419 */         break;
/*      */       }
/*      */     }
/* 3422 */     return disIndex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void broadcastNewLeader(xbean.Team xTeam, long newLeader)
/*      */   {
/* 3434 */     SAppointLeaderBrd brd = new SAppointLeaderBrd();
/* 3435 */     brd.new_leader = newLeader;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 3445 */     broadcast(xTeam, brd);
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
/*      */   static boolean checkRoleCanChangeStatus(long roleId, xbean.TeamMember xMember, long teamid, int status)
/*      */   {
/* 3461 */     if (xMember.getStatus() != 0)
/*      */     {
/* 3463 */       return true;
/*      */     }
/* 3465 */     boolean isCanleave = true;
/* 3466 */     if (FightInterface.isInFight(roleId))
/*      */     {
/* 3468 */       sendNormalResult(roleId, 41, new String[0]);
/* 3469 */       isCanleave = false;
/*      */     }
/* 3471 */     if (!isCanleave)
/*      */     {
/*      */ 
/* 3474 */       new ChangeMemberTempStatus(roleId, teamid, status).execute();
/* 3475 */       return false;
/*      */     }
/* 3477 */     return true;
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
/*      */   static boolean isFlyIng(long roleId)
/*      */   {
/* 3490 */     return RoleStatusInterface.getStatusSet(roleId).contains(Integer.valueOf(2));
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
/*      */   static boolean isAllTeamMemberNormalImpl(long teamId, boolean remainTeamLock)
/*      */   {
/* 3503 */     xbean.Team xTeam = null;
/* 3504 */     if (remainTeamLock)
/*      */     {
/* 3506 */       xTeam = xtable.Team.get(Long.valueOf(teamId));
/*      */     }
/*      */     else
/*      */     {
/* 3510 */       xTeam = xtable.Team.select(Long.valueOf(teamId));
/*      */     }
/* 3512 */     if (xTeam == null)
/*      */     {
/* 3514 */       return false;
/*      */     }
/* 3516 */     for (xbean.TeamMember xTeamMember : xTeam.getMembers())
/*      */     {
/* 3518 */       if (xTeamMember.getStatus() != 0)
/*      */       {
/* 3520 */         return false;
/*      */       }
/*      */     }
/* 3523 */     return true;
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
/*      */   static TeamInfo getTeamInfoByRoleIdImpl(long roleId)
/*      */   {
/* 3536 */     Long teamId = Role2team.select(Long.valueOf(roleId));
/* 3537 */     if (teamId == null)
/*      */     {
/* 3539 */       return null;
/*      */     }
/* 3541 */     return TeamInterface.getTeamInfo(teamId.longValue(), false);
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
/*      */   static boolean canApplyTeam(long roleId, long leaderId)
/*      */   {
/* 3554 */     Set<Integer> roleStatus = RoleStatusInterface.selectStatusSet(roleId);
/* 3555 */     Set<Integer> leaderStatus = RoleStatusInterface.selectStatusSet(leaderId);
/*      */     
/*      */ 
/* 3558 */     if ((roleStatus.contains(Integer.valueOf(32))) || (roleStatus.contains(Integer.valueOf(33))))
/*      */     {
/* 3560 */       sendNormalResult(roleId, 5002, new String[0]);
/* 3561 */       return false;
/*      */     }
/*      */     
/* 3564 */     if ((leaderStatus.contains(Integer.valueOf(32))) || (leaderStatus.contains(Integer.valueOf(33))))
/*      */     {
/* 3566 */       sendNormalResult(roleId, 5001, new String[] { RoleInterface.getName(leaderId) });
/* 3567 */       return false;
/*      */     }
/*      */     
/* 3570 */     return true;
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
/*      */   static boolean canInviteRole(long roleId, long invitee)
/*      */   {
/* 3585 */     Set<Integer> roleStatus = RoleStatusInterface.selectStatusSet(roleId);
/* 3586 */     Set<Integer> inviteeStatus = RoleStatusInterface.selectStatusSet(invitee);
/*      */     
/*      */ 
/* 3589 */     if ((roleStatus.contains(Integer.valueOf(32))) || (roleStatus.contains(Integer.valueOf(33))))
/*      */     {
/* 3591 */       sendNormalResult(roleId, 6002, new String[0]);
/* 3592 */       return false;
/*      */     }
/*      */     
/* 3595 */     if ((inviteeStatus.contains(Integer.valueOf(32))) || (inviteeStatus.contains(Integer.valueOf(33))))
/*      */     {
/* 3597 */       sendNormalResult(roleId, 6001, new String[] { RoleInterface.getName(invitee) });
/* 3598 */       return false;
/*      */     }
/*      */     
/* 3601 */     if (SystemSettingInterface.getSetting(invitee, 5).intValue() == 1)
/*      */     {
/* 3603 */       if (!FriendInterface.isFriend(roleId, invitee, false))
/*      */       {
/*      */ 
/* 3606 */         sendNormalResult(roleId, 16, new String[] { RoleInterface.getName(invitee) });
/* 3607 */         sendNormalResult(invitee, 17, new String[] { RoleInterface.getName(roleId) });
/* 3608 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 3612 */     return true;
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
/*      */   static boolean canActiveLeaveTeam(long roleId, long leaderId)
/*      */   {
/* 3628 */     return true;
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
/*      */   static boolean canActiveReturnTeam(long roleId, long leaderId)
/*      */   {
/* 3653 */     return true;
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
/*      */   static boolean canActiveTempLeaveTeam(long roleId, long leaderId)
/*      */   {
/* 3677 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synModelChange(xbean.Team xTeam, long roleId)
/*      */   {
/* 3688 */     SMemberModelChangedBrd sMemberModelChangedBrd = new SMemberModelChangedBrd();
/* 3689 */     sMemberModelChangedBrd.roleid = roleId;
/* 3690 */     RoleInterface.fillModelInfo(roleId, sMemberModelChangedBrd.model);
/* 3691 */     broadcast(xTeam, sMemberModelChangedBrd);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void rmApplicantNonSyn(long teamid, long applicant)
/*      */   {
/* 3699 */     Procedure.execute(new LogicProcedure()
/*      */     {
/*      */ 
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/*      */ 
/* 3706 */         xbean.Team xTeam = xtable.Team.get(Long.valueOf(this.val$teamid));
/* 3707 */         if (TeamManager.removeApplicant(this.val$teamid, xTeam, this.val$applicant))
/*      */         {
/* 3709 */           Procedure.execute(new PSyncApplicantsToAll(this.val$teamid));
/*      */         }
/* 3711 */         return true;
/*      */       }
/*      */     });
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
/*      */   static int canBeNormal(long roleid, Long teamid, xbean.Team xTeam, long leaderId, xbean.TeamMember xTeamMember)
/*      */   {
/* 3729 */     if (FightInterface.isInObserving(roleid))
/*      */     {
/* 3731 */       sendNormalResult(roleid, 71, new String[0]);
/* 3732 */       return 0;
/*      */     }
/*      */     
/*      */ 
/* 3736 */     if (FightInterface.isInFight(roleid))
/*      */     {
/* 3738 */       if (xTeamMember.getTempstatus() != 6)
/*      */       {
/* 3740 */         xTeamMember.setTempstatus(6);
/*      */       }
/* 3742 */       sendNormalResult(roleid, 41, new String[0]);
/* 3743 */       return 0;
/*      */     }
/*      */     
/*      */ 
/* 3747 */     if (FightInterface.isInFight(leaderId))
/*      */     {
/* 3749 */       changeMemberTempStatus(teamid.longValue(), xTeam, roleid, 6);
/* 3750 */       sendNormalResult(roleid, 42, new String[0]);
/* 3751 */       if (!transformToLeader(roleid, leaderId))
/*      */       {
/* 3753 */         return -1;
/*      */       }
/* 3755 */       return 0;
/*      */     }
/* 3757 */     return 1;
/*      */   }
/*      */   
/*      */   static RoleJoinState checkRoleReturnState(long roleid, long leaderId)
/*      */   {
/* 3762 */     RoleJoinState state = new RoleJoinState();
/*      */     
/*      */ 
/* 3765 */     if (FightInterface.isInObserving(roleid))
/*      */     {
/* 3767 */       sendNormalResult(roleid, 71, new String[0]);
/* 3768 */       state.setAllState(1, 0);
/* 3769 */       return state;
/*      */     }
/*      */     
/*      */ 
/* 3773 */     if (FightInterface.isInFight(roleid))
/*      */     {
/* 3775 */       sendNormalResult(roleid, 41, new String[0]);
/* 3776 */       state.setAllState(1, 6);
/* 3777 */       return state;
/*      */     }
/*      */     
/*      */ 
/* 3781 */     if (FightInterface.isInFight(leaderId))
/*      */     {
/* 3783 */       sendNormalResult(roleid, 42, new String[0]);
/* 3784 */       state.setAllState(1, 6);
/* 3785 */       state.setNeedTF2Leader(true);
/* 3786 */       return state;
/*      */     }
/*      */     
/* 3789 */     state.setAllState(0, 0);
/* 3790 */     return state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean transformToLeader(long roleId, long leaderId)
/*      */   {
/* 3802 */     MapInterface.transformToRole(roleId, leaderId, new MapCallback()
/*      */     {
/*      */ 
/*      */       public boolean onResult(Boolean result)
/*      */       {
/*      */ 
/* 3808 */         if (result.booleanValue())
/*      */         {
/* 3810 */           FightInterface.observeFight(this.val$roleId, this.val$leaderId);
/*      */         }
/* 3812 */         return true;
/*      */       }
/*      */       
/*      */ 
/*      */       public boolean isCallInProcedure()
/*      */       {
/* 3818 */         return true;
/*      */       }
/* 3820 */     });
/* 3821 */     return true;
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
/*      */   static boolean checkRemoveTeam(long roleIdToLeave, long teamid, xbean.Team xTeam)
/*      */   {
/* 3836 */     for (xbean.TeamMember xMember : xTeam.getMembers())
/*      */     {
/* 3838 */       long member = xMember.getRoleid();
/* 3839 */       if (member != roleIdToLeave)
/*      */       {
/*      */ 
/*      */ 
/* 3843 */         int status = xMember.getStatus();
/* 3844 */         if (status == 0)
/*      */         {
/* 3846 */           return false; }
/*      */       }
/*      */     }
/* 3849 */     return true;
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
/*      */   static void disTeam(long teamid, xbean.Team xTeam)
/*      */   {
/* 3862 */     clearStableState(teamid, xTeam);
/* 3863 */     List<Long> removeMembers = new ArrayList();
/* 3864 */     for (xbean.TeamMember tXMember : xTeam.getMembers())
/*      */     {
/* 3866 */       long roleid = tXMember.getRoleid();
/* 3867 */       removeMembers.add(Long.valueOf(roleid));
/* 3868 */       Role2team.delete(Long.valueOf(roleid));
/* 3869 */       Set<Integer> roleStatus = RoleStatusInterface.selectStatusSet(roleid);
/* 3870 */       rmRoleTeamStatus(roleid, roleStatus);
/*      */     }
/* 3872 */     xtable.Team.delete(Long.valueOf(teamid));
/*      */     
/*      */ 
/* 3875 */     SDismissAllBrd brd = new SDismissAllBrd();
/* 3876 */     OnlineManager.getInstance().sendMulti(brd, removeMembers);
/*      */     
/* 3878 */     TeamDissolveArg dissolveArg = new TeamDissolveArg(teamid, removeMembers);
/* 3879 */     trigTeamEvent(removeMembers, new TeamDissolve(), dissolveArg);
/* 3880 */     mapOnDismiss(dissolveArg);
/* 3881 */     GameServer.logger().info(String.format("[team]TeamManager.disTeam@ team disolved!|teamId=%d|members=%s", new Object[] { Long.valueOf(teamid), removeMembers.toString() }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void mapOnDismiss(TeamDissolveArg dissolveArg)
/*      */   {
/* 3893 */     if (!new POnTeamDissolve(dissolveArg.teamid, dissolveArg.members).call())
/*      */     {
/* 3895 */       logger.error(String.format("[team]TeamManager.disTeam@ map pro fail on team dismiss！|teamId=%d|members=%s", new Object[] { Long.valueOf(dissolveArg.teamid), dissolveArg.members.toString() }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void changeLeaderPartner(long teamid, xbean.Team xTeam)
/*      */   {
/* 3902 */     long leaderId = ((xbean.TeamMember)xTeam.getMembers().get(0)).getRoleid();
/* 3903 */     Map<Integer, Integer> leaderPartnerMap = PartnerInterface.getFightPartnerListWithoutRole(leaderId, false);
/*      */     
/* 3905 */     xTeam = xtable.Team.get(Long.valueOf(teamid));
/*      */     
/*      */ 
/* 3908 */     fillDispositionByLeaderPartners(leaderPartnerMap, xTeam);
/*      */     
/* 3910 */     Procedure.execute(new PSynTeamDisposition(teamid));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void rmFromTeamApplyList(long roleId, long teamid, xbean.Team xTeam)
/*      */   {
/* 3922 */     boolean find = false;
/* 3923 */     Iterator<xbean.TeamApplicant> it = xTeam.getApplicants().iterator();
/* 3924 */     while (it.hasNext())
/*      */     {
/* 3926 */       xbean.TeamApplicant teamApplicant = (xbean.TeamApplicant)it.next();
/* 3927 */       if (teamApplicant.getRoleid() == roleId)
/*      */       {
/* 3929 */         it.remove();
/* 3930 */         find = true;
/* 3931 */         break;
/*      */       }
/*      */     }
/*      */     
/* 3935 */     if (find)
/*      */     {
/*      */ 
/* 3938 */       NoneRealTimeTaskManager.getInstance().addTask(new PSyncApplicantsToAll(teamid));
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean checkLock(xbean.Team xTeam, Collection<Long> lockRoles)
/*      */   {
/* 3944 */     if (xTeam == null)
/*      */     {
/* 3946 */       return false;
/*      */     }
/*      */     
/* 3949 */     List<Long> tmpMembers = getMemberListByXTeam(xTeam);
/* 3950 */     if ((tmpMembers.size() != lockRoles.size()) || (!tmpMembers.containsAll(lockRoles)))
/*      */     {
/* 3952 */       GameServer.logger().warn(String.format("[team]TeamManager.checkLock@ check lock again fail!|lockIds=%s|nowIds=%s", new Object[] { lockRoles.toString(), tmpMembers.toString() }));
/*      */       
/*      */ 
/* 3955 */       return false;
/*      */     }
/* 3957 */     return true;
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
/*      */   static boolean tempLeaveTeam(long roleId, long teamid, xbean.Team xTeam)
/*      */   {
/* 3973 */     if (xTeam == null)
/*      */     {
/* 3975 */       return false;
/*      */     }
/* 3977 */     long leaderId = getLearder(xTeam);
/* 3978 */     if (roleId == leaderId)
/*      */     {
/* 3980 */       return false;
/*      */     }
/*      */     
/* 3983 */     if (!canActiveTempLeaveTeam(roleId, leaderId))
/*      */     {
/* 3985 */       return false;
/*      */     }
/*      */     
/* 3988 */     if (FightInterface.isInFight(roleId))
/*      */     {
/* 3990 */       changeMemberTempStatus(teamid, xTeam, roleId, 4);
/* 3991 */       sendNormalResult(roleId, 41, new String[0]);
/* 3992 */       return true;
/*      */     }
/* 3994 */     if (!changeMemberStatus(teamid, xTeam, roleId, 1, false))
/*      */     {
/* 3996 */       return false;
/*      */     }
/*      */     
/* 3999 */     triggerMemberStatusChangeEvent(teamid, xTeam, roleId, 0, 1, false, false);
/*      */     
/*      */ 
/* 4002 */     return true;
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
/*      */   static boolean forceTmpLeaveTeam(long roleId)
/*      */   {
/* 4015 */     Long teamid = Role2team.select(Long.valueOf(roleId));
/* 4016 */     if (teamid == null)
/*      */     {
/* 4018 */       return false;
/*      */     }
/* 4020 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 4021 */     if (xTeam == null)
/*      */     {
/* 4023 */       return false;
/*      */     }
/*      */     
/* 4026 */     Set<Long> lockRoles = new HashSet();
/* 4027 */     lockRoles.addAll(getMemberListByXTeam(xTeam));
/*      */     
/*      */ 
/* 4030 */     Lockeys.lock(Basic.getTable(), lockRoles);
/*      */     
/* 4032 */     xTeam = xtable.Team.get(teamid);
/*      */     
/* 4034 */     if (!canBeTmpLeave(roleId, xTeam))
/*      */     {
/* 4036 */       return false;
/*      */     }
/* 4038 */     return tempLeaveTeam(roleId, teamid.longValue(), xTeam);
/*      */   }
/*      */   
/*      */   private static boolean canBeTmpLeave(long roleId, xbean.Team xTeam)
/*      */   {
/* 4043 */     xbean.TeamMember xMember = getXMember(xTeam, roleId);
/* 4044 */     if (xMember == null)
/*      */     {
/* 4046 */       GameServer.logger().error(String.format("[team]TeamManager.canBeTmpLeave@ xMember is null!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/* 4047 */       return false;
/*      */     }
/* 4049 */     if (0 != xMember.getStatus())
/*      */     {
/* 4051 */       GameServer.logger().error(String.format("[team]TeamManager.canBeTmpLeave@ xMember state not normal!|roleId=%d|state=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xMember.getStatus()) }));
/*      */       
/*      */ 
/* 4054 */       return false;
/*      */     }
/* 4056 */     return true;
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
/*      */   static boolean appointLeader(long teamid, xbean.Team xTeam, long newLeader, long oldLeader)
/*      */   {
/* 4070 */     int newLeaderIndex = getNormalMemberIndex(xTeam, newLeader, oldLeader);
/* 4071 */     if (newLeaderIndex <= 0)
/*      */     {
/* 4073 */       GameServer.logger().error(String.format("[team]TeamManager.appointLeader@ get new leader index err!|teamId=%d|newLeader=%d|oldLeader=%d", new Object[] { Long.valueOf(teamid), Long.valueOf(newLeader), Long.valueOf(oldLeader) }));
/*      */       
/*      */ 
/*      */ 
/* 4077 */       return false;
/*      */     }
/*      */     
/* 4080 */     int disIndex = getMemberDisp(xTeam, newLeader);
/* 4081 */     if (disIndex <= 0)
/*      */     {
/* 4083 */       GameServer.logger().error(String.format("[team]TeamManager.appointLeader@ get new leader index err!|teamId=%d|newLeader=%d|oldLeader=%d", new Object[] { Long.valueOf(teamid), Long.valueOf(newLeader), Long.valueOf(oldLeader) }));
/*      */       
/*      */ 
/*      */ 
/* 4087 */       return false;
/*      */     }
/* 4089 */     broadcastNewLeader(xTeam, newLeader);
/*      */     
/* 4091 */     if (!changeLeader(teamid, xTeam, newLeaderIndex, disIndex))
/*      */     {
/* 4093 */       return false;
/*      */     }
/* 4095 */     triggerChangeLeaderEvent(teamid, xTeam, oldLeader, newLeader);
/* 4096 */     return true;
/*      */   }
/*      */   
/*      */   private static int getNormalMemberIndex(xbean.Team xTeam, long roleId, long oldLeader)
/*      */   {
/* 4101 */     int newLeaderIndex = -1;
/* 4102 */     for (int i = 1; i < xTeam.getMembers().size(); i++)
/*      */     {
/* 4104 */       xbean.TeamMember xMember = (xbean.TeamMember)xTeam.getMembers().get(i);
/* 4105 */       if (xMember.getRoleid() == roleId)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 4110 */         if (xMember.getStatus() != 0)
/*      */         {
/* 4112 */           if (xMember.getStatus() == 2)
/*      */           {
/* 4114 */             sendNormalResult(oldLeader, 52, new String[] { RoleInterface.getName(xMember.getRoleid()) });
/*      */ 
/*      */           }
/* 4117 */           else if (xMember.getStatus() == 1)
/*      */           {
/* 4119 */             sendNormalResult(oldLeader, 51, new String[] { RoleInterface.getName(xMember.getRoleid()) });
/*      */           }
/*      */           
/* 4122 */           return -1;
/*      */         }
/* 4124 */         newLeaderIndex = i;
/* 4125 */         break;
/*      */       } }
/* 4127 */     return newLeaderIndex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onTeamMemberModelChange(long roleId)
/*      */   {
/* 4139 */     Long teamid = Role2team.select(Long.valueOf(roleId));
/* 4140 */     if (teamid == null)
/*      */     {
/* 4142 */       return false;
/*      */     }
/* 4144 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 4145 */     if (xTeam == null)
/*      */     {
/* 4147 */       return false;
/*      */     }
/* 4149 */     synModelChange(xTeam, roleId);
/* 4150 */     return true;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\TeamManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */