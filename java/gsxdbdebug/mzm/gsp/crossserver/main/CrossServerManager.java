/*      */ package mzm.gsp.crossserver.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import hub.AllLottoReportCandidateInfoReq;
/*      */ import hub.CrossCompeteRoamServersReq;
/*      */ import hub.CrossCompeteRoleDataBackReq;
/*      */ import hub.CrossCompeteTeamBackReq;
/*      */ import hub.CrossCompeteUserDataBack;
/*      */ import hub.DataBroadcast;
/*      */ import hub.DataTransferReq;
/*      */ import hub.DataTransferReqXidWrapper;
/*      */ import hub.EnterCrossCompeteMapReq;
/*      */ import hub.FriendsCircleDeleteGiveGiftHistoryReq;
/*      */ import hub.FriendsCircleGiveGiftReq;
/*      */ import hub.FriendsCircleTreadReq;
/*      */ import hub.GHubHelper;
/*      */ import hub.GenRoamTokenReq;
/*      */ import hub.HubCorpsCVCInfo;
/*      */ import hub.JoinCrossBattleSelectionOrFinalReq;
/*      */ import hub.JoinMatchReq;
/*      */ import hub.ModifyRoamServerDateReq;
/*      */ import hub.NotifyCrossCompeteResultReq;
/*      */ import hub.NotifyIndianaAwardRoleInfo;
/*      */ import hub.NotifyModifyRoamServerDate;
/*      */ import hub.NotifyModifyServerDate;
/*      */ import hub.PointRaceCorpsCVCInfo;
/*      */ import hub.PointRaceCorpsInfo;
/*      */ import hub.PointRaceEndReq;
/*      */ import hub.RecallNotifyBindFriendReq;
/*      */ import hub.ReportCorpsFightValueReq;
/*      */ import hub.ReportCrossCompeteFactionInfoReq;
/*      */ import hub.ReportCrossCompeteSignUpReq;
/*      */ import hub.ReportPointRaceCorpsCVCReq;
/*      */ import hub.RoamMatchContextReq;
/*      */ import hub.RoamPointRaceDataReq;
/*      */ import hub.SelectionFinalTeamInfo;
/*      */ import hub.SelectionOrFinalFightBeginReq;
/*      */ import hub.SingleCrossFieldJoinMatchReq;
/*      */ import hub.TransferChatContentReq;
/*      */ import hub.UpdatePointRaceCorpsReq;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.crossbattle.point.CorpsPointRaceInfo;
/*      */ import mzm.gsp.crossbattle.point.RolePointRaceMarkingInfo;
/*      */ import mzm.gsp.crossserver.event.ClearCrossBattleOwnResultDone;
/*      */ import mzm.gsp.crossserver.event.GetBigBossRankRangeDoneArg;
/*      */ import mzm.gsp.crossserver.event.GetCorpsZoneDoneArg;
/*      */ import mzm.gsp.crossserver.event.GetLadderRankRangeDone;
/*      */ import mzm.gsp.crossserver.event.GetLadderRankRangeDoneArg;
/*      */ import mzm.gsp.crossserver.event.GetLadderRoleRankDoneArg;
/*      */ import mzm.gsp.crossserver.event.GetRoleCrossBattleBetLoseRankInfoDoneArg;
/*      */ import mzm.gsp.crossserver.event.GetRoleCrossBattleBetWinRankInfoDoneArg;
/*      */ import mzm.gsp.crossserver.event.GetRoleSingleCrossFieldRankInfoDoneArg;
/*      */ import mzm.gsp.crossserver.event.RemovePointRaceDone;
/*      */ import mzm.gsp.crossserver.event.ReportCorpsPointRaceDone;
/*      */ import mzm.gsp.crossserver.event.ReportCorpsPointRaceDoneArg;
/*      */ import mzm.gsp.crossserver.event.ReportRoleBigBossRankInfoDone;
/*      */ import mzm.gsp.crossserver.event.ReportRoleCrossBattleBetLoseRankInfoDone;
/*      */ import mzm.gsp.crossserver.event.ReportRoleCrossBattleBetWinRankInfoDone;
/*      */ import mzm.gsp.crossserver.top.BigBossTopChartObj;
/*      */ import mzm.gsp.crossserver.top.CrossBattleBetLoseTopChartObj;
/*      */ import mzm.gsp.crossserver.top.CrossBattleBetWinTopChartObj;
/*      */ import mzm.gsp.crossserver.top.CrossLadderTopChartObj;
/*      */ import mzm.gsp.crossserver.top.SingleCrossFieldTopChartObj;
/*      */ import mzm.gsp.crossserver.top.TopChartObjType;
/*      */ import mzm.gsp.grc.main.GrcInterface;
/*      */ import mzm.gsp.map.main.scene.Position;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.util.CommonHandlerManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.OctetsInputStream;
/*      */ import ppbio.OctetsOutputStream;
/*      */ import xbean.AllWingPlans;
/*      */ import xbean.ChildInfo;
/*      */ import xbean.FabaoArtifactRecords;
/*      */ import xbean.FightCommand;
/*      */ import xbean.GeniusInfo;
/*      */ import xbean.Location;
/*      */ import xbean.MagicMarkSys;
/*      */ import xbean.PartnerBag;
/*      */ import xbean.PartnerYuanshenInfo;
/*      */ import xbean.PetBag;
/*      */ import xbean.PetDepot;
/*      */ import xbean.Pod;
/*      */ import xbean.Properties;
/*      */ import xbean.Role2AircraftInfo;
/*      */ import xbean.Role2ChangeModelCardInfo;
/*      */ import xbean.Role2ChildrenInfo;
/*      */ import xbean.Role2FashionDressInfo;
/*      */ import xbean.Role2MountsInfo;
/*      */ import xbean.Role2PetMarkInfo;
/*      */ import xbean.RoleAvatar;
/*      */ import xbean.RoleAvatarFrame;
/*      */ import xbean.RoleChatBubbleInfo;
/*      */ import xbean.RoleClothes;
/*      */ import xbean.RoleFabaoSysInfo;
/*      */ import xbean.RoleGangSkill;
/*      */ import xbean.RoleLifeSkill;
/*      */ import xbean.RoleSkillBags;
/*      */ import xbean.RoleXiuLian;
/*      */ import xbean.TitleAppellation;
/*      */ import xbean.UserRoamedInfo;
/*      */ import xbean.WuShiInfoMap;
/*      */ import xbean.ZhenfaInfo;
/*      */ import xdb.Executor;
/*      */ import xdb.Lockeys;
/*      */ import xdb.Xdb;
/*      */ import xtable.Children;
/*      */ import xtable.Equipbag;
/*      */ import xtable.Role2aircraft;
/*      */ import xtable.Role2avatar;
/*      */ import xtable.Role2avatar_frame;
/*      */ import xtable.Role2changemodelcard;
/*      */ import xtable.Role2chatbubbleinfo;
/*      */ import xtable.Role2children;
/*      */ import xtable.Role2fabao_artifact;
/*      */ import xtable.Role2fabaosys;
/*      */ import xtable.Role2fashiondress;
/*      */ import xtable.Role2fightcmd;
/*      */ import xtable.Role2gangskill;
/*      */ import xtable.Role2genius;
/*      */ import xtable.Role2lifeskill;
/*      */ import xtable.Role2magicmark;
/*      */ import xtable.Role2mounts;
/*      */ import xtable.Role2partner_yuanshen;
/*      */ import xtable.Role2partnerbag;
/*      */ import xtable.Role2petbag;
/*      */ import xtable.Role2petdepot;
/*      */ import xtable.Role2petmark;
/*      */ import xtable.Role2properties;
/*      */ import xtable.Role2skillbag;
/*      */ import xtable.Role2titleappellation;
/*      */ import xtable.Role2treasurebag;
/*      */ import xtable.Role2wingplans;
/*      */ import xtable.Role2wushiinfo;
/*      */ import xtable.Role2xiulianskill;
/*      */ import xtable.Role2zhenfa;
/*      */ import xtable.Roleclothes;
/*      */ import xtable.User2roamedinfo;
/*      */ 
/*      */ class CrossServerManager
/*      */ {
/*      */   static final int MATCH_RANKING_CORRECT_VALUE = 50;
/*      */   static final String ENCODING = "UTF-8";
/*  159 */   static final List<RoamRoleXtableDataHandler<String>> userXtables = new ArrayList();
/*  160 */   static final List<RoamRoleXtableDataHandler<Long>> roleXtables = new ArrayList();
/*  161 */   static final CommonHandlerManager<RoamType, CollectServerBalanceInfoHandler> handlerMgr = new CommonHandlerManager();
/*      */   
/*  163 */   static int roamServerDefaultMapCfgid = 330000001;
/*  164 */   static int ladderMatcherid = 1;
/*  165 */   static int crossCompeteMatcherid = 2;
/*  166 */   static int crossBattlePointMatcherid = 3;
/*  167 */   static int crossBattleKnockoutMatcherid = 4;
/*  168 */   static int singleCrossFieldMatcherid = 5;
/*  169 */   static int allLottoMatcherid = 1;
/*  170 */   static Set<Integer> matcherids = new java.util.HashSet();
/*      */   
/*      */   static void init()
/*      */   {
/*  174 */     matcherids.add(Integer.valueOf(ladderMatcherid));
/*  175 */     matcherids.add(Integer.valueOf(crossCompeteMatcherid));
/*  176 */     matcherids.add(Integer.valueOf(crossBattlePointMatcherid));
/*  177 */     matcherids.add(Integer.valueOf(crossBattleKnockoutMatcherid));
/*  178 */     matcherids.add(Integer.valueOf(singleCrossFieldMatcherid));
/*      */     
/*  180 */     handlerMgr.addHandler(RoamType.CROSS_BATTLE_POINT, new mzm.gsp.crossbattle.point.PointRaceBalanceInfo());
/*  181 */     handlerMgr.addHandler(RoamType.CROSS_COMPETE, mzm.gsp.crosscompete.roam.RoamLoadManager.instance);
/*  182 */     handlerMgr.addHandler(RoamType.SINGLE_CROSS_FIELD, new SingleCrossFieldBalanceInfoHandler());
/*      */     
/*  184 */     MatchActivityContextType.check();
/*      */     
/*  186 */     initRoamRoleXtableDataHandlers();
/*      */     
/*  188 */     DataTransferHandlerManager.getInstance().regisHandler(6, new DTH_JoinMatch());
/*  189 */     DataTransferHandlerManager.getInstance().regisHandler(8, new DTH_CancelMatch());
/*  190 */     DataTransferHandlerManager.getInstance().regisHandler(7, new DTH_NotifyMatchResult());
/*  191 */     DataTransferHandlerManager.getInstance().regisHandler(5, new DTH_RoamMatchContext());
/*  192 */     DataTransferHandlerManager.getInstance().regisHandler(1, new DTH_GenRoamToken());
/*  193 */     DataTransferHandlerManager.getInstance().regisHandler(2, new DTH_RoamRoleData());
/*  194 */     DataTransferHandlerManager.getInstance().regisHandler(3, new DTH_ValidateRoamToken());
/*  195 */     DataTransferHandlerManager.getInstance().regisHandler(4, new DTH_LadderDataBack());
/*  196 */     DataTransferHandlerManager.getInstance().regisHandler(9, new DTH_WaitNextRoundMatch());
/*      */     
/*  198 */     DataTransferHandlerManager.getInstance().regisHandler(10, new DTH_ConfirmJoinMatch());
/*  199 */     DataTransferHandlerManager.getInstance().regisHandler(11, new DTH_ReportGameServerBalanceInfo());
/*      */     
/*  201 */     DataTransferHandlerManager.getInstance().regisHandler(15, new DTH_ModifyRoamServerDate());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  206 */     DataTransferHandlerManager.getInstance().regisHandler(100, new DTH_ReportCrossCompeteSignUp());
/*      */     
/*      */ 
/*  209 */     DataTransferHandlerManager.getInstance().regisHandler(101, new DTH_CrossCompeteRoamServers());
/*      */     
/*      */ 
/*  212 */     DataTransferHandlerManager.getInstance().regisHandler(102, new DTH_NotifyCrossCompeteAgainst());
/*      */     
/*      */ 
/*  215 */     DataTransferHandlerManager.getInstance().regisHandler(103, new DTH_ReportCrossCompeteFactionInfo());
/*      */     
/*      */ 
/*  218 */     DataTransferHandlerManager.getInstance().regisHandler(104, new DTH_EnterCrossCompeteMap());
/*      */     
/*      */ 
/*  221 */     DataTransferHandlerManager.getInstance().regisHandler(105, new DTH_CrossCompeteRoleDataBack());
/*      */     
/*      */ 
/*  224 */     DataTransferHandlerManager.getInstance().regisHandler(106, new DTH_NotifyCrossCompeteResult());
/*      */     
/*      */ 
/*  227 */     DataTransferHandlerManager.getInstance().regisHandler(107, new DTH_CrossCompeteTeamBack());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  232 */     DataTransferHandlerManager.getInstance().regisHandler(300, new DTH_ReportCorpsFightValue());
/*      */     
/*  234 */     DataTransferHandlerManager.getInstance().regisHandler(301, new DTH_JoinPointRace());
/*  235 */     DataTransferHandlerManager.getInstance().regisHandler(302, new DTH_ConfirmJoinPointRace());
/*      */     
/*  237 */     DataTransferHandlerManager.getInstance().regisHandler(303, new DTH_RoamPointRaceContext());
/*      */     
/*  239 */     DataTransferHandlerManager.getInstance().regisHandler(304, new DTH_NotifyPointRaceResult());
/*      */     
/*  241 */     DataTransferHandlerManager.getInstance().regisHandler(305, new DTH_NotifyPointRacePending());
/*      */     
/*  243 */     DataTransferHandlerManager.getInstance().regisHandler(306, new DTH_RoamPointRaceData());
/*      */     
/*  245 */     DataTransferHandlerManager.getInstance().regisHandler(307, new DTH_PointRaceDataBack());
/*      */     
/*  247 */     DataTransferHandlerManager.getInstance().regisHandler(308, new DTH_UpdatePointRaceCorps());
/*      */     
/*  249 */     DataTransferHandlerManager.getInstance().regisHandler(309, new DTH_ReportPointRaceCorpsCVC());
/*      */     
/*  251 */     DataTransferHandlerManager.getInstance().regisHandler(310, new DTH_PointRaceEnd());
/*  252 */     DataTransferHandlerManager.getInstance().regisHandler(311, new DTH_PointRaceQuery());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  257 */     DataTransferHandlerManager.getInstance().regisHandler(200, new DTH_JoinKnockOut());
/*      */     
/*  259 */     DataTransferHandlerManager.getInstance().regisHandler(201, new DTH_ConfirmJoinKnockOutMatch());
/*      */     
/*      */ 
/*  262 */     DataTransferHandlerManager.getInstance().regisHandler(202, new DTH_KnockOutWaitNextRoundMatch());
/*      */     
/*      */ 
/*  265 */     DataTransferHandlerManager.getInstance().regisHandler(203, new DTH_KnockOutRoamContext());
/*      */     
/*      */ 
/*  268 */     DataTransferHandlerManager.getInstance().regisHandler(204, new DTH_NotifyKnockOutMatchResult());
/*      */     
/*      */ 
/*  271 */     DataTransferHandlerManager.getInstance().regisHandler(205, new DTH_KnockOutDataBack());
/*      */     
/*      */ 
/*  274 */     DataTransferHandlerManager.getInstance().regisHandler(206, new DTH_NotifyKnockOutBye());
/*      */     
/*      */ 
/*  277 */     DataTransferHandlerManager.getInstance().regisHandler(207, new DTH_KnockOutFightBeginReq());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  282 */     DataBroadcastHandlerManager.getInstance().regisHandler(1, new DBH_NotifyFightRecordStartInfo());
/*      */     
/*  284 */     DataBroadcastHandlerManager.getInstance().regisHandler(2, new DBH_NotifyFightRecordEndInfo());
/*      */     
/*  286 */     DataBroadcastHandlerManager.getInstance().regisHandler(3, new DBH_NotifyFightRecordRoundInfo());
/*      */     
/*  288 */     DataBroadcastHandlerManager.getInstance().regisHandler(4, new DBH_NotifyCrossBattleFinalBulletin());
/*      */     
/*  290 */     DataBroadcastHandlerManager.getInstance().regisHandler(5, new DBH_NotifyModifyRoamServerDate());
/*      */     
/*  292 */     DataBroadcastHandlerManager.getInstance().regisHandler(8, new DBH_NotifyModifyServerDate());
/*      */     
/*      */ 
/*      */ 
/*  296 */     DataBroadcastHandlerManager.getInstance().regisHandler(6, new DBH_NotifyIndianaAwardRoleInfo());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  301 */     DataBroadcastHandlerManager.getInstance().regisHandler(7, new DBH_AllLottoBrdAwardRoleInfo());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  306 */     DataTransferHandlerManager.getInstance().regisHandler(400, new DTH_SingleCrossFieldJoinMatch());
/*      */     
/*  308 */     DataTransferHandlerManager.getInstance().regisHandler(401, new DTH_SingleCrossFieldConfirmJoinMatch());
/*      */     
/*  310 */     DataTransferHandlerManager.getInstance().regisHandler(402, new DTH_SingleCrossFieldRoamMatchContext());
/*      */     
/*  312 */     DataTransferHandlerManager.getInstance().regisHandler(403, new DTH_SingleCrossFieldNotifyMatchResult());
/*      */     
/*  314 */     DataTransferHandlerManager.getInstance().regisHandler(404, new DTH_SingleCrossFieldCancelMatch());
/*      */     
/*  316 */     DataTransferHandlerManager.getInstance().regisHandler(405, new DTH_SingleCrossFieldWaitNextRoundMatch());
/*      */     
/*  318 */     DataTransferHandlerManager.getInstance().regisHandler(406, new DTH_SingleCrossFieldDataBack());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  323 */     DataTransferHandlerManager.getInstance().regisHandler(700, new DTH_AllLottoReportCandidateInfo());
/*      */     
/*  325 */     DataTransferHandlerManager.getInstance().regisHandler(701, new DTH_AllLottoNotifyAwardRoleInfo());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  330 */     DataTransferHandlerManager.getInstance().regisHandler(16, new DTH_TransferChatContent());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  336 */     DataTransferHandlerManager.getInstance().regisHandler(500, new DTH_FriendsCircleGiveGift());
/*      */     
/*      */ 
/*  339 */     DataTransferHandlerManager.getInstance().regisHandler(501, new DTH_FriendsCircleTread());
/*      */     
/*      */ 
/*  342 */     DataTransferHandlerManager.getInstance().regisHandler(502, new DTH_FriendsCircleDeleteTread());
/*      */     
/*      */ 
/*  345 */     DataTransferHandlerManager.getInstance().regisHandler(503, new DTH_FriendsCircleDeleteGiveGift());
/*      */     
/*      */ 
/*  348 */     DataTransferHandlerManager.getInstance().regisHandler(504, new DTH_FriendsCircleOperatorBlacklist());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  353 */     DataTransferHandlerManager.getInstance().regisHandler(600, new DTH_NotifyBindFriend());
/*      */     
/*      */ 
/*  356 */     hub.PingPongManager.getInstance().init();
/*      */   }
/*      */   
/*      */ 
/*      */   private static void initRoamRoleXtableDataHandlers()
/*      */   {
/*  362 */     userXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(String userid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  367 */         xbean.User xUser = xtable.User.get(userid);
/*  368 */         if (xUser != null)
/*      */         {
/*  370 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  371 */           xUser.marshal(cos);
/*  372 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(String userid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  379 */         xbean.User xUser = Pod.newUser();
/*  380 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  381 */         xUser.unmarshal(cis);
/*  382 */         xtable.User.add(userid, xUser);
/*      */       }
/*      */       
/*      */       public void cleanData(String userid)
/*      */         throws Exception
/*      */       {
/*  388 */         xtable.User.remove(userid);
/*      */       }
/*      */       
/*      */ 
/*  392 */     });
/*  393 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  398 */         xbean.Basic xBasic = xtable.Basic.get(roleid);
/*  399 */         if (xBasic != null)
/*      */         {
/*  401 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  402 */           xBasic.marshal(cos);
/*  403 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  410 */         xbean.Basic xBasic = Pod.newBasic();
/*  411 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  412 */         xBasic.unmarshal(cis);
/*  413 */         xtable.Basic.add(roleid, xBasic);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  419 */         xtable.Basic.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  423 */     });
/*  424 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  429 */         Properties xProperties = Role2properties.select(roleid);
/*  430 */         if (xProperties != null)
/*      */         {
/*  432 */           Position pos = mzm.gsp.map.main.MapInterface.randomPos(CrossServerManager.roamServerDefaultMapCfgid);
/*  433 */           if (pos != null)
/*      */           {
/*  435 */             Location xLocation = xProperties.getLocation();
/*  436 */             xLocation.setSceneid(CrossServerManager.roamServerDefaultMapCfgid);
/*  437 */             xLocation.setX(pos.getX());
/*  438 */             xLocation.setY(pos.getY());
/*  439 */             xLocation.setZ(pos.getZ());
/*      */           }
/*      */           
/*  442 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  443 */           xProperties.marshal(cos);
/*  444 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  451 */         Properties xProperties = Pod.newProperties();
/*  452 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  453 */         xProperties.unmarshal(cis);
/*  454 */         Role2properties.add(roleid, xProperties);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  460 */         Role2properties.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  464 */     });
/*  465 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  470 */         xbean.Bag xBag = xtable.Bag.get(roleid);
/*  471 */         if (xBag != null)
/*      */         {
/*  473 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  474 */           xBag.marshal(cos);
/*  475 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  482 */         xbean.Bag xBag = Pod.newBag();
/*  483 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  484 */         xBag.unmarshal(cis);
/*  485 */         xtable.Bag.add(roleid, xBag);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  491 */         xtable.Bag.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  495 */     });
/*  496 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  501 */         xbean.Bag xBag = Equipbag.get(roleid);
/*  502 */         if (xBag != null)
/*      */         {
/*  504 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  505 */           xBag.marshal(cos);
/*  506 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  513 */         xbean.Bag xBag = Pod.newBag();
/*  514 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  515 */         xBag.unmarshal(cis);
/*  516 */         Equipbag.add(roleid, xBag);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  522 */         Equipbag.remove(roleid);
/*      */ 
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  528 */     });
/*  529 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  534 */         AllWingPlans xAllWingPlans = Role2wingplans.get(roleid);
/*  535 */         if (xAllWingPlans != null)
/*      */         {
/*  537 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  538 */           xAllWingPlans.marshal(cos);
/*  539 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  546 */         AllWingPlans xAllWingPlans = Pod.newAllWingPlans();
/*  547 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  548 */         xAllWingPlans.unmarshal(cis);
/*  549 */         Role2wingplans.add(roleid, xAllWingPlans);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  555 */         Role2wingplans.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  559 */     });
/*  560 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  565 */         RoleFabaoSysInfo xRoleFabaoSysInfo = Role2fabaosys.get(roleid);
/*  566 */         if (xRoleFabaoSysInfo != null)
/*      */         {
/*  568 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  569 */           xRoleFabaoSysInfo.marshal(cos);
/*  570 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  577 */         RoleFabaoSysInfo xRoleFabaoSysInfo = Pod.newRoleFabaoSysInfo();
/*  578 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  579 */         xRoleFabaoSysInfo.unmarshal(cis);
/*  580 */         Role2fabaosys.add(roleid, xRoleFabaoSysInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  586 */         Role2fabaosys.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  590 */     });
/*  591 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  596 */         Role2MountsInfo xRole2MountsInfo = Role2mounts.get(roleid);
/*  597 */         if (xRole2MountsInfo != null)
/*      */         {
/*  599 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  600 */           xRole2MountsInfo.marshal(cos);
/*  601 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  608 */         Role2MountsInfo xRole2MountsInfo = Pod.newRole2MountsInfo();
/*  609 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  610 */         xRole2MountsInfo.unmarshal(cis);
/*  611 */         Role2mounts.add(roleid, xRole2MountsInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  617 */         Role2mounts.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  621 */     });
/*  622 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  627 */         TitleAppellation xTitleAppellation = Role2titleappellation.get(roleid);
/*  628 */         if (xTitleAppellation != null)
/*      */         {
/*  630 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  631 */           xTitleAppellation.marshal(cos);
/*  632 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  639 */         TitleAppellation xTitleAppellation = Pod.newTitleAppellation();
/*  640 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  641 */         xTitleAppellation.unmarshal(cis);
/*  642 */         Role2titleappellation.add(roleid, xTitleAppellation);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  648 */         Role2titleappellation.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  652 */     });
/*  653 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  658 */         ZhenfaInfo xZhenfaInfo = Role2zhenfa.get(roleid);
/*  659 */         if (xZhenfaInfo != null)
/*      */         {
/*  661 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  662 */           xZhenfaInfo.marshal(cos);
/*  663 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  670 */         ZhenfaInfo xZhenfaInfo = Pod.newZhenfaInfo();
/*  671 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  672 */         xZhenfaInfo.unmarshal(cis);
/*  673 */         Role2zhenfa.add(roleid, xZhenfaInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  679 */         Role2zhenfa.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  683 */     });
/*  684 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  689 */         Role2FashionDressInfo xRole2FashionDressInfo = Role2fashiondress.get(roleid);
/*  690 */         if (xRole2FashionDressInfo != null)
/*      */         {
/*  692 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  693 */           xRole2FashionDressInfo.marshal(cos);
/*  694 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  701 */         Role2FashionDressInfo xRole2FashionDressInfo = Pod.newRole2FashionDressInfo();
/*  702 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  703 */         xRole2FashionDressInfo.unmarshal(cis);
/*  704 */         Role2fashiondress.add(roleid, xRole2FashionDressInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  710 */         Role2fashiondress.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  714 */     });
/*  715 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  720 */         PartnerBag xPartnerBag = Role2partnerbag.get(roleid);
/*  721 */         if (xPartnerBag != null)
/*      */         {
/*  723 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  724 */           xPartnerBag.marshal(cos);
/*  725 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  732 */         PartnerBag xPartnerBag = Pod.newPartnerBag();
/*  733 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  734 */         xPartnerBag.unmarshal(cis);
/*  735 */         Role2partnerbag.add(roleid, xPartnerBag);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  741 */         Role2partnerbag.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  745 */     });
/*  746 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  751 */         RoleSkillBags xRoleSkillBags = Role2skillbag.get(roleid);
/*  752 */         if (xRoleSkillBags != null)
/*      */         {
/*  754 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  755 */           xRoleSkillBags.marshal(cos);
/*  756 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  763 */         RoleSkillBags xRoleSkillBags = Pod.newRoleSkillBags();
/*  764 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  765 */         xRoleSkillBags.unmarshal(cis);
/*  766 */         Role2skillbag.add(roleid, xRoleSkillBags);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  772 */         Role2skillbag.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  776 */     });
/*  777 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  782 */         RoleLifeSkill xRoleLifeSkill = Role2lifeskill.get(roleid);
/*  783 */         if (xRoleLifeSkill != null)
/*      */         {
/*  785 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  786 */           xRoleLifeSkill.marshal(cos);
/*  787 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  794 */         RoleLifeSkill xRoleLifeSkill = Pod.newRoleLifeSkill();
/*  795 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  796 */         xRoleLifeSkill.unmarshal(cis);
/*  797 */         Role2lifeskill.add(roleid, xRoleLifeSkill);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  803 */         Role2lifeskill.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  807 */     });
/*  808 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  813 */         RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(roleid);
/*  814 */         if (xRoleXiuLian != null)
/*      */         {
/*  816 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  817 */           xRoleXiuLian.marshal(cos);
/*  818 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  825 */         RoleXiuLian xRoleXiuLian = Pod.newRoleXiuLian();
/*  826 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  827 */         xRoleXiuLian.unmarshal(cis);
/*  828 */         Role2xiulianskill.add(roleid, xRoleXiuLian);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  834 */         Role2xiulianskill.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  838 */     });
/*  839 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  844 */         RoleGangSkill xRoleGangSkill = Role2gangskill.get(roleid);
/*  845 */         if (xRoleGangSkill != null)
/*      */         {
/*  847 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  848 */           xRoleGangSkill.marshal(cos);
/*  849 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  856 */         RoleGangSkill xRoleGangSkill = Pod.newRoleGangSkill();
/*  857 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  858 */         xRoleGangSkill.unmarshal(cis);
/*  859 */         Role2gangskill.add(roleid, xRoleGangSkill);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  865 */         Role2gangskill.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  869 */     });
/*  870 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  875 */         FightCommand xFightCommand = Role2fightcmd.get(roleid);
/*  876 */         if (xFightCommand != null)
/*      */         {
/*  878 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  879 */           xFightCommand.marshal(cos);
/*  880 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  887 */         FightCommand xFightCommand = Pod.newFightCommand();
/*  888 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  889 */         xFightCommand.unmarshal(cis);
/*  890 */         Role2fightcmd.add(roleid, xFightCommand);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  896 */         Role2fightcmd.remove(roleid);
/*      */ 
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  902 */     });
/*  903 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  908 */         PetBag xPetBag = Role2petbag.get(roleid);
/*  909 */         if (xPetBag != null)
/*      */         {
/*  911 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  912 */           xPetBag.marshal(cos);
/*  913 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  920 */         PetBag xPetBag = Pod.newPetBag();
/*  921 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  922 */         xPetBag.unmarshal(cis);
/*  923 */         Role2petbag.add(roleid, xPetBag);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  929 */         Role2petbag.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  933 */     });
/*  934 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  939 */         PetDepot xPetDepot = Role2petdepot.get(roleid);
/*  940 */         if (xPetDepot != null)
/*      */         {
/*  942 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  943 */           xPetDepot.marshal(cos);
/*  944 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  951 */         PetDepot xPetDepot = Pod.newPetDepot();
/*  952 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  953 */         xPetDepot.unmarshal(cis);
/*  954 */         Role2petdepot.add(roleid, xPetDepot);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  960 */         Role2petdepot.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  964 */     });
/*  965 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/*  970 */         RoleClothes xRoleClothes = Roleclothes.get(roleid);
/*  971 */         if (xRoleClothes != null)
/*      */         {
/*  973 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/*  974 */           xRoleClothes.marshal(cos);
/*  975 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/*  982 */         RoleClothes xRoleClothes = Pod.newRoleClothes();
/*  983 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/*  984 */         xRoleClothes.unmarshal(cis);
/*  985 */         Roleclothes.add(roleid, xRoleClothes);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/*  991 */         Roleclothes.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/*  995 */     });
/*  996 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1001 */         MagicMarkSys xMagicMarkSys = Role2magicmark.get(roleid);
/* 1002 */         if (xMagicMarkSys != null)
/*      */         {
/* 1004 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1005 */           xMagicMarkSys.marshal(cos);
/* 1006 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1013 */         MagicMarkSys xMagicMarkSys = Pod.newMagicMarkSys();
/* 1014 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1015 */         xMagicMarkSys.unmarshal(cis);
/* 1016 */         Role2magicmark.add(roleid, xMagicMarkSys);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1022 */         Role2magicmark.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1026 */     });
/* 1027 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1032 */         Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(roleid);
/* 1033 */         if (xRole2ChildrenInfo == null)
/*      */         {
/* 1035 */           return;
/*      */         }
/*      */         
/*      */ 
/* 1039 */         OctetsStream tmpos = new OctetsStream();
/* 1040 */         CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(tmpos));
/* 1041 */         xRole2ChildrenInfo.marshal(cos);
/* 1042 */         cos.flush();
/*      */         
/* 1044 */         os.marshal(tmpos);
/*      */         
/*      */ 
/* 1047 */         List<Long> children = xRole2ChildrenInfo.getChild_id_list();
/* 1048 */         Iterator i$; if (!children.isEmpty())
/*      */         {
/* 1050 */           Lockeys.lock(Children.getTable(), children);
/* 1051 */           for (i$ = children.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/*      */             
/* 1053 */             ChildInfo xChildInfo = Children.get(Long.valueOf(childid));
/* 1054 */             if (xChildInfo == null)
/*      */             {
/* 1056 */               os.marshal(false);
/*      */ 
/*      */             }
/*      */             else
/*      */             {
/* 1061 */               OctetsStream tmpos = new OctetsStream();
/* 1062 */               CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(tmpos));
/* 1063 */               xChildInfo.marshal(cos);
/* 1064 */               cos.flush();
/*      */               
/* 1066 */               os.marshal(true);
/* 1067 */               os.marshal(tmpos);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1076 */         OctetsStream os = OctetsStream.wrap(orginData);
/*      */         
/* 1078 */         Role2ChildrenInfo xRole2ChildrenInfo = Pod.newRole2ChildrenInfo();
/*      */         
/* 1080 */         Octets octets = os.unmarshal_Octets();
/* 1081 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(octets));
/* 1082 */         xRole2ChildrenInfo.unmarshal(cis);
/*      */         
/* 1084 */         Role2children.add(roleid, xRole2ChildrenInfo);
/*      */         
/* 1086 */         List<Long> children = xRole2ChildrenInfo.getChild_id_list();
/* 1087 */         if (children.isEmpty())
/*      */         {
/* 1089 */           return;
/*      */         }
/*      */         
/* 1092 */         Lockeys.lock(Children.getTable(), children);
/* 1093 */         for (Iterator i$ = children.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/*      */           
/* 1095 */           boolean exist = os.unmarshal_boolean();
/* 1096 */           if (exist)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 1101 */             ChildInfo xChildInfo = Pod.newChildInfo();
/* 1102 */             Octets octets = os.unmarshal_Octets();
/* 1103 */             CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(octets));
/* 1104 */             xChildInfo.unmarshal(cis);
/* 1105 */             Children.add(Long.valueOf(childid), xChildInfo);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid) throws Exception
/*      */       {
/* 1112 */         Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(roleid);
/* 1113 */         if (xRole2ChildrenInfo == null)
/*      */         {
/* 1115 */           return;
/*      */         }
/*      */         
/* 1118 */         Role2children.remove(roleid);
/*      */         
/* 1120 */         List<Long> children = xRole2ChildrenInfo.getChild_id_list();
/* 1121 */         if (children.isEmpty())
/*      */         {
/* 1123 */           return;
/*      */         }
/*      */         
/* 1126 */         Lockeys.lock(Children.getTable(), children);
/* 1127 */         for (Iterator i$ = children.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/*      */           
/* 1129 */           Children.remove(Long.valueOf(childid));
/*      */         }
/*      */         
/*      */       }
/*      */       
/* 1134 */     });
/* 1135 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1140 */         GeniusInfo xGeniusInfo = Role2genius.get(roleid);
/* 1141 */         if (xGeniusInfo != null)
/*      */         {
/* 1143 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1144 */           xGeniusInfo.marshal(cos);
/* 1145 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1152 */         GeniusInfo xGeniusInfo = Pod.newGeniusInfo();
/* 1153 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1154 */         xGeniusInfo.unmarshal(cis);
/* 1155 */         Role2genius.add(roleid, xGeniusInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1161 */         Role2genius.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1165 */     });
/* 1166 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1171 */         FabaoArtifactRecords xFabaoArtifactRecords = Role2fabao_artifact.get(roleid);
/* 1172 */         if (xFabaoArtifactRecords != null)
/*      */         {
/* 1174 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1175 */           xFabaoArtifactRecords.marshal(cos);
/* 1176 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1183 */         FabaoArtifactRecords xFabaoArtifactRecords = Pod.newFabaoArtifactRecords();
/* 1184 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1185 */         xFabaoArtifactRecords.unmarshal(cis);
/* 1186 */         Role2fabao_artifact.add(roleid, xFabaoArtifactRecords);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1192 */         Role2fabao_artifact.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1196 */     });
/* 1197 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1202 */         RoleAvatar xRoleAvatar = Role2avatar.get(roleid);
/* 1203 */         if (xRoleAvatar != null)
/*      */         {
/* 1205 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1206 */           xRoleAvatar.marshal(cos);
/* 1207 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1214 */         RoleAvatar xRoleAvatar = Pod.newRoleAvatar();
/* 1215 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1216 */         xRoleAvatar.unmarshal(cis);
/* 1217 */         Role2avatar.add(roleid, xRoleAvatar);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1223 */         Role2avatar.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1227 */     });
/* 1228 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1233 */         WuShiInfoMap xWuShiInfoMap = Role2wushiinfo.get(roleid);
/* 1234 */         if (xWuShiInfoMap != null)
/*      */         {
/* 1236 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1237 */           xWuShiInfoMap.marshal(cos);
/* 1238 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1245 */         WuShiInfoMap xWuShiInfoMap = Pod.newWuShiInfoMap();
/* 1246 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1247 */         xWuShiInfoMap.unmarshal(cis);
/* 1248 */         Role2wushiinfo.add(roleid, xWuShiInfoMap);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1254 */         Role2wushiinfo.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1258 */     });
/* 1259 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1264 */         PartnerYuanshenInfo xPartnerYuanshenInfo = Role2partner_yuanshen.get(roleid);
/* 1265 */         if (xPartnerYuanshenInfo != null)
/*      */         {
/* 1267 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1268 */           xPartnerYuanshenInfo.marshal(cos);
/* 1269 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1276 */         PartnerYuanshenInfo xPartnerYuanshenInfo = Pod.newPartnerYuanshenInfo();
/* 1277 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1278 */         xPartnerYuanshenInfo.unmarshal(cis);
/* 1279 */         Role2partner_yuanshen.add(roleid, xPartnerYuanshenInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1285 */         Role2partner_yuanshen.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1289 */     });
/* 1290 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1295 */         RoleChatBubbleInfo xRoleChatBubbleInfo = Role2chatbubbleinfo.get(roleid);
/* 1296 */         if (xRoleChatBubbleInfo != null)
/*      */         {
/* 1298 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1299 */           xRoleChatBubbleInfo.marshal(cos);
/* 1300 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1307 */         RoleChatBubbleInfo xRoleChatBubbleInfo = Pod.newRoleChatBubbleInfo();
/* 1308 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1309 */         xRoleChatBubbleInfo.unmarshal(cis);
/* 1310 */         Role2chatbubbleinfo.add(roleid, xRoleChatBubbleInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1316 */         Role2chatbubbleinfo.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1320 */     });
/* 1321 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1326 */         RoleAvatarFrame xRoleAvatarFrame = Role2avatar_frame.get(roleid);
/* 1327 */         if (xRoleAvatarFrame != null)
/*      */         {
/* 1329 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1330 */           xRoleAvatarFrame.marshal(cos);
/* 1331 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1338 */         RoleAvatarFrame xRoleAvatarFrame = Pod.newRoleAvatarFrame();
/* 1339 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1340 */         xRoleAvatarFrame.unmarshal(cis);
/* 1341 */         Role2avatar_frame.add(roleid, xRoleAvatarFrame);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1347 */         Role2avatar_frame.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1351 */     });
/* 1352 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1357 */         Role2ChangeModelCardInfo xRole2ChangeModelCardInfo = Role2changemodelcard.get(roleid);
/* 1358 */         if (xRole2ChangeModelCardInfo != null)
/*      */         {
/* 1360 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1361 */           xRole2ChangeModelCardInfo.marshal(cos);
/* 1362 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1369 */         Role2ChangeModelCardInfo xRole2ChangeModelCardInfo = Pod.newRole2ChangeModelCardInfo();
/* 1370 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1371 */         xRole2ChangeModelCardInfo.unmarshal(cis);
/* 1372 */         Role2changemodelcard.add(roleid, xRole2ChangeModelCardInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1378 */         Role2changemodelcard.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1382 */     });
/* 1383 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1388 */         Role2AircraftInfo xRole2AircraftInfo = Role2aircraft.get(roleid);
/* 1389 */         if (xRole2AircraftInfo != null)
/*      */         {
/* 1391 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1392 */           xRole2AircraftInfo.marshal(cos);
/* 1393 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1400 */         Role2AircraftInfo xRole2AircraftInfo = Pod.newRole2AircraftInfo();
/* 1401 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1402 */         xRole2AircraftInfo.unmarshal(cis);
/* 1403 */         Role2aircraft.add(roleid, xRole2AircraftInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1409 */         Role2aircraft.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1413 */     });
/* 1414 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1419 */         xbean.Bag xBag = Role2treasurebag.get(roleid);
/* 1420 */         if (xBag != null)
/*      */         {
/* 1422 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1423 */           xBag.marshal(cos);
/* 1424 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1431 */         xbean.Bag xBag = Pod.newBag();
/* 1432 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1433 */         xBag.unmarshal(cis);
/* 1434 */         Role2treasurebag.add(roleid, xBag);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1440 */         Role2treasurebag.remove(roleid);
/*      */       }
/*      */       
/*      */ 
/* 1444 */     });
/* 1445 */     roleXtables.add(new RoamRoleXtableDataHandler()
/*      */     {
/*      */       public void boxData(Long roleid, OctetsStream os)
/*      */         throws Exception
/*      */       {
/* 1450 */         Role2PetMarkInfo xRole2PetMarkInfo = Role2petmark.get(roleid);
/* 1451 */         if (xRole2PetMarkInfo != null)
/*      */         {
/* 1453 */           CodedOutputStream cos = CodedOutputStream.newInstance(OctetsOutputStream.wrap(os));
/* 1454 */           xRole2PetMarkInfo.marshal(cos);
/* 1455 */           cos.flush();
/*      */         }
/*      */       }
/*      */       
/*      */       public void unboxData(Long roleid, Octets orginData)
/*      */         throws Exception
/*      */       {
/* 1462 */         Role2PetMarkInfo xRole2PetMarkInfo = Pod.newRole2PetMarkInfo();
/* 1463 */         CodedInputStream cis = CodedInputStream.newInstance(OctetsInputStream.wrap(orginData));
/* 1464 */         xRole2PetMarkInfo.unmarshal(cis);
/* 1465 */         Role2petmark.add(roleid, xRole2PetMarkInfo);
/*      */       }
/*      */       
/*      */       public void cleanData(Long roleid)
/*      */         throws Exception
/*      */       {
/* 1471 */         Role2petmark.remove(roleid);
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */   static void genRoamToken(RoamContext context)
/*      */   {
/* 1478 */     if (!doGenRoamToken(context))
/*      */     {
/* 1480 */       mzm.gsp.crossserver.event.GenRoamTokenFail event = new mzm.gsp.crossserver.event.GenRoamTokenFail();
/* 1481 */       mzm.gsp.crossserver.event.GenRoamTokenFailArg arg = GenRoamTokenEventArgCreator.createGenRoamTokenFailArg(context);
/* 1482 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean doGenRoamToken(RoamContext context)
/*      */   {
/*      */     try
/*      */     {
/* 1490 */       for (RoamRoleInfo roamRoleInfo : context.getRoamRoleInfos())
/*      */       {
/* 1492 */         int localZoneid = GameServerInfoManager.getZoneidFromUserid(roamRoleInfo.getUserid());
/* 1493 */         if (GameServerInfoManager.isValidZone(localZoneid))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1498 */           DataTransferReq req = new DataTransferReq();
/* 1499 */           req.direction = 3;
/* 1500 */           req.data_type = 1;
/* 1501 */           req.src_id = localZoneid;
/* 1502 */           req.dst_id = context.getRoamZoneid();
/* 1503 */           GenRoamTokenReq genRoamTokenReq = new GenRoamTokenReq();
/* 1504 */           genRoamTokenReq.userid.setString(roamRoleInfo.getUserid(), "UTF-8");
/* 1505 */           genRoamTokenReq.roleid = roamRoleInfo.getRoleid();
/*      */           
/* 1507 */           OctetsStream os = new OctetsStream();
/* 1508 */           os.marshal(genRoamTokenReq);
/* 1509 */           req.data = os;
/*      */           
/* 1511 */           GenRoamTokenTransferReqXidWrapper reqXidWrapper = new GenRoamTokenTransferReqXidWrapper(req, context);
/* 1512 */           if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */           {
/* 1514 */             GameServer.logger().error(String.format("[crossserver]CrossServerManager.genRoamToken@send gen roam token request failed|userid=%s|roleid=%d|roam_context=%s", new Object[] { roamRoleInfo.getUserid(), Long.valueOf(roamRoleInfo.getRoleid()), context }));
/*      */             
/*      */ 
/*      */ 
/* 1518 */             return false;
/*      */           }
/*      */         }
/*      */       }
/* 1522 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1526 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.genRoamToken@send gen roam token request error|roam_context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 1530 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean roamRole(RoamContext context)
/*      */   {
/* 1536 */     for (RoamRoleInfo roamRoleInfo : context.getRoamRoleInfos())
/*      */     {
/* 1538 */       String userid = roamRoleInfo.getUserid();
/* 1539 */       int localZoneid = GameServerInfoManager.getZoneidFromUserid(userid);
/* 1540 */       if (GameServerInfoManager.isValidZone(localZoneid))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1545 */         long roleid = roamRoleInfo.getRoleid();
/*      */         
/* 1547 */         if (!new PSendRoamRole(userid, roleid, context).call())
/*      */         {
/* 1549 */           GameServer.logger().error(String.format("[crossserver]CrossServerManager.roamRole@send roam role request failed|userid=%s|roleid=%d|roam_context=%s", new Object[] { userid, Long.valueOf(roleid), context }));
/*      */           
/*      */ 
/*      */ 
/*      */ 
/* 1554 */           return false;
/*      */         }
/*      */       }
/*      */     }
/* 1558 */     return true;
/*      */   }
/*      */   
/*      */   static boolean joinMatch(MatchContext context)
/*      */   {
/*      */     try
/*      */     {
/* 1565 */       DataTransferReq req = new DataTransferReq();
/* 1566 */       req.direction = 5;
/* 1567 */       req.data_type = 6;
/* 1568 */       req.src_id = GameServerInfoManager.getZoneId();
/* 1569 */       req.dst_id = ladderMatcherid;
/* 1570 */       JoinMatchReq reqData = new JoinMatchReq();
/* 1571 */       reqData.game_server_contextid = context.contextid;
/* 1572 */       reqData.activity_context_typeid = context.activityContext.getMatchActivityContextType().typeid;
/* 1573 */       reqData.level_range = context.levelRange;
/* 1574 */       for (RoleMatchMarkingInfo roleMatchMarkingInfo : context.roleMatchMarkingInfos)
/*      */       {
/* 1576 */         reqData.role_infos.add(roleMatchMarkingInfo.getHubRoleMatchMarkingInfo());
/*      */       }
/*      */       
/* 1579 */       OctetsStream os = new OctetsStream();
/* 1580 */       os.marshal(reqData);
/* 1581 */       req.data = os;
/*      */       
/* 1583 */       JoinMatchTransferReqXidWrapper reqXidWrapper = new JoinMatchTransferReqXidWrapper(req, context);
/* 1584 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 1586 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.joinMatch@send join match request failed|match_context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 1590 */         return false;
/*      */       }
/*      */       
/* 1593 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1597 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.joinMatch@send join match request error|match_context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 1601 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean confirmJoinMatch(MatchContext context)
/*      */   {
/*      */     try
/*      */     {
/* 1609 */       DataTransferReq req = new DataTransferReq();
/* 1610 */       req.direction = 5;
/* 1611 */       req.data_type = 10;
/* 1612 */       req.src_id = GameServerInfoManager.getZoneId();
/* 1613 */       req.dst_id = ladderMatcherid;
/* 1614 */       hub.ConfirmJoinMatchReq reqData = new hub.ConfirmJoinMatchReq();
/* 1615 */       reqData.matcher_server_contextid = context.getMatcherServerContextid();
/* 1616 */       reqData.game_server_contextid = context.contextid;
/* 1617 */       reqData.activity_context_typeid = context.activityContext.getMatchActivityContextType().typeid;
/* 1618 */       reqData.level_range = context.levelRange;
/*      */       
/* 1620 */       OctetsStream os = new OctetsStream();
/* 1621 */       os.marshal(reqData);
/* 1622 */       req.data = os;
/*      */       
/* 1624 */       ConfirmJoinMatchTransferReqXidWrapper reqXidWrapper = new ConfirmJoinMatchTransferReqXidWrapper(req, context);
/* 1625 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 1627 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.confirmJoinMatch@send confirm join match request failed|match_context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 1631 */         return false;
/*      */       }
/*      */       
/* 1634 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1638 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.confirmJoinMatch@send confirm join match request error|match_context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 1642 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean cancelMatch(MatchContext context)
/*      */   {
/*      */     try
/*      */     {
/* 1650 */       DataTransferReq req = new DataTransferReq();
/* 1651 */       req.direction = 5;
/* 1652 */       req.data_type = 8;
/* 1653 */       req.src_id = GameServerInfoManager.getZoneId();
/* 1654 */       req.dst_id = ladderMatcherid;
/* 1655 */       hub.CancelMatchReq reqData = new hub.CancelMatchReq();
/* 1656 */       reqData.matcher_server_contextid = context.getMatcherServerContextid();
/* 1657 */       reqData.game_server_contextid = context.contextid;
/* 1658 */       reqData.activity_context_typeid = context.activityContext.getMatchActivityContextType().typeid;
/*      */       
/* 1660 */       OctetsStream os = new OctetsStream();
/* 1661 */       os.marshal(reqData);
/* 1662 */       req.data = os;
/*      */       
/* 1664 */       CancelMatchTransferReqXidWrapper reqXidWrapper = new CancelMatchTransferReqXidWrapper(req, context);
/* 1665 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 1667 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.cancelMatch@send cancel join match request failed|match_context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 1671 */         return false;
/*      */       }
/*      */       
/* 1674 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1678 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.cancelMatch@send cancel join match request error|match_context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 1682 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean setRoleRoamServerStatus(String userid, long roleid)
/*      */   {
/* 1688 */     RoleStatusInterface.setStatus(roleid, 44, false);
/*      */     
/* 1690 */     RoamType roamType = getRoamType(userid);
/* 1691 */     if (roamType == null)
/*      */     {
/* 1693 */       return false;
/*      */     }
/*      */     
/* 1696 */     int status = roamType.getStatus();
/* 1697 */     if (status < 0)
/*      */     {
/* 1699 */       return false;
/*      */     }
/*      */     
/* 1702 */     return RoleStatusInterface.setStatus(roleid, status, false);
/*      */   }
/*      */   
/*      */   static void unsetRoleRoamServerStatus(String userid, long roleid)
/*      */   {
/* 1707 */     RoleStatusInterface.unsetStatus(roleid, 44);
/*      */     
/* 1709 */     int status = -1;
/* 1710 */     for (RoamType roamType : RoamType.values())
/*      */     {
/* 1712 */       status = roamType.getStatus();
/* 1713 */       if (status >= 0)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1718 */         RoleStatusInterface.unsetStatus(roleid, status);
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
/*      */   static void setUserRoamedInfo(String userid, RoamType roamType, long roamedRoomInstanceid)
/*      */   {
/* 1731 */     UserRoamedInfo xUserRoamedInfo = User2roamedinfo.get(userid);
/* 1732 */     if (xUserRoamedInfo == null)
/*      */     {
/* 1734 */       xUserRoamedInfo = Pod.newUserRoamedInfo();
/* 1735 */       User2roamedinfo.add(userid, xUserRoamedInfo);
/*      */     }
/* 1737 */     xUserRoamedInfo.setRoam_type(roamType.ordinal());
/* 1738 */     xUserRoamedInfo.setInstanceid(roamedRoomInstanceid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeUserRoamedInfo(String userid, RoamType roamType)
/*      */   {
/* 1749 */     UserRoamedInfo xUserRoamedInfo = User2roamedinfo.get(userid);
/*      */     
/* 1751 */     if ((xUserRoamedInfo == null) || (xUserRoamedInfo.getRoam_type() != roamType.ordinal()))
/*      */     {
/* 1753 */       return;
/*      */     }
/*      */     
/* 1756 */     User2roamedinfo.remove(userid);
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
/*      */   static boolean removeUserRoamedInfo(String userid, RoamType roamType, long roamedRoomInstanceid)
/*      */   {
/* 1770 */     UserRoamedInfo xUserRoamedInfo = User2roamedinfo.get(userid);
/*      */     
/*      */ 
/* 1773 */     if ((xUserRoamedInfo == null) || (xUserRoamedInfo.getRoam_type() != roamType.ordinal()) || (xUserRoamedInfo.getInstanceid() != roamedRoomInstanceid))
/*      */     {
/*      */ 
/* 1776 */       return false;
/*      */     }
/*      */     
/* 1779 */     User2roamedinfo.remove(userid);
/*      */     
/* 1781 */     return true;
/*      */   }
/*      */   
/*      */   static void boxRoleXtableData(String userid, long roleid, List<Octets> xtables) throws Exception
/*      */   {
/* 1786 */     for (RoamRoleXtableDataHandler<String> handler : userXtables)
/*      */     {
/* 1788 */       OctetsStream os = new OctetsStream();
/* 1789 */       handler.boxData(userid, os);
/* 1790 */       xtables.add(os);
/*      */     }
/*      */     
/* 1793 */     for (RoamRoleXtableDataHandler<Long> handler : roleXtables)
/*      */     {
/* 1795 */       OctetsStream os = new OctetsStream();
/* 1796 */       handler.boxData(Long.valueOf(roleid), os);
/* 1797 */       xtables.add(os);
/*      */     }
/*      */   }
/*      */   
/*      */   static void unboxRoleXtableData(String userid, long roleid, List<Octets> xtables) throws Exception
/*      */   {
/* 1803 */     int index = 0;
/*      */     
/* 1805 */     for (RoamRoleXtableDataHandler<String> handler : userXtables)
/*      */     {
/* 1807 */       Octets originData = (Octets)xtables.get(index++);
/* 1808 */       if (originData.size() > 0)
/*      */       {
/* 1810 */         handler.unboxData(userid, originData);
/*      */       }
/*      */     }
/*      */     
/* 1814 */     for (RoamRoleXtableDataHandler<Long> handler : roleXtables)
/*      */     {
/* 1816 */       Octets originData = (Octets)xtables.get(index++);
/* 1817 */       if (originData.size() > 0)
/*      */       {
/* 1819 */         handler.unboxData(Long.valueOf(roleid), originData);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void cleanRoleXtableData(String userid, long roleid) throws Exception
/*      */   {
/* 1826 */     for (RoamRoleXtableDataHandler<String> handler : userXtables)
/*      */     {
/* 1828 */       handler.cleanData(userid);
/*      */     }
/*      */     
/* 1831 */     for (RoamRoleXtableDataHandler<Long> handler : roleXtables)
/*      */     {
/* 1833 */       handler.cleanData(Long.valueOf(roleid));
/*      */     }
/*      */   }
/*      */   
/*      */   static Long getRoamedRoomInstanceid(String userid)
/*      */   {
/* 1839 */     UserRoamedInfo xUserRoamedInfo = User2roamedinfo.select(userid);
/* 1840 */     if (xUserRoamedInfo == null)
/*      */     {
/* 1842 */       return null;
/*      */     }
/*      */     
/* 1845 */     long roamedRoomInstanceid = xUserRoamedInfo.getInstanceid();
/* 1846 */     if (roamedRoomInstanceid < 0L)
/*      */     {
/* 1848 */       return null;
/*      */     }
/*      */     
/* 1851 */     return Long.valueOf(roamedRoomInstanceid);
/*      */   }
/*      */   
/*      */   static RoamType getRoamType(String userid)
/*      */   {
/* 1856 */     UserRoamedInfo xUserRoamedInfo = User2roamedinfo.select(userid);
/* 1857 */     if (xUserRoamedInfo == null)
/*      */     {
/* 1859 */       return null;
/*      */     }
/*      */     
/* 1862 */     int roamTypeOrdinal = xUserRoamedInfo.getRoam_type();
/* 1863 */     if (roamTypeOrdinal < 0)
/*      */     {
/* 1865 */       return null;
/*      */     }
/*      */     
/* 1868 */     RoamType[] roamTypes = RoamType.values();
/* 1869 */     if (roamTypeOrdinal >= roamTypes.length)
/*      */     {
/* 1871 */       return null;
/*      */     }
/*      */     
/* 1874 */     return roamTypes[roamTypeOrdinal];
/*      */   }
/*      */   
/*      */   static boolean roamMatchContext(MatchContext context, MatchContext opponentContext)
/*      */   {
/*      */     try
/*      */     {
/* 1881 */       DataTransferReq req = new DataTransferReq();
/* 1882 */       req.direction = 0;
/* 1883 */       req.data_type = 5;
/* 1884 */       req.src_id = GameServerInfoManager.getZoneId();
/* 1885 */       req.dst_id = context.getRoamZoneid();
/* 1886 */       RoamMatchContextReq reqData = new RoamMatchContextReq();
/* 1887 */       reqData.activity_context_typeid = context.activityContext.getMatchActivityContextType().typeid;
/* 1888 */       for (RoleMatchMarkingInfo roleMatchMarkingInfo : context.roleMatchMarkingInfos)
/*      */       {
/* 1890 */         reqData.role_infos.add(roleMatchMarkingInfo.getHubRoleMatchMarkingInfo());
/*      */       }
/* 1892 */       for (RoleMatchMarkingInfo roleMatchMarkingInfo : context.getOpponentRoleMatchMarkingInfos())
/*      */       {
/* 1894 */         reqData.opponent_role_infos.add(roleMatchMarkingInfo.getHubRoleMatchMarkingInfo());
/*      */       }
/*      */       
/* 1897 */       OctetsStream os = new OctetsStream();
/* 1898 */       os.marshal(reqData);
/* 1899 */       req.data = os;
/*      */       
/* 1901 */       RoamMatchContextTransferReqXidWrapper reqXidWrapper = new RoamMatchContextTransferReqXidWrapper(req, context, opponentContext);
/*      */       
/* 1903 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 1905 */         return false;
/*      */       }
/*      */       
/* 1908 */       return true;
/*      */     }
/*      */     catch (Exception e) {}
/*      */     
/* 1912 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static <T extends MatchMarkingRanking> int getMatchRanking(List<T> matchMarkingRankings)
/*      */   {
/* 1918 */     int num = 0;
/* 1919 */     int maxRanking = 0;
/* 1920 */     long sumRanking = 0L;
/* 1921 */     for (MatchMarkingRanking markingRanking : matchMarkingRankings)
/*      */     {
/* 1923 */       num++;
/*      */       
/* 1925 */       int ranking = markingRanking.getRanking();
/* 1926 */       if (ranking > 0)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1931 */         if (ranking > maxRanking)
/*      */         {
/* 1933 */           maxRanking = ranking;
/*      */         }
/* 1935 */         sumRanking += ranking;
/*      */       }
/*      */     }
/* 1938 */     return Math.max(maxRanking - 50, (int)Math.ceil(sumRanking / num));
/*      */   }
/*      */   
/*      */   static void removeMatchContext(long contextid)
/*      */   {
/* 1943 */     MatchContextManager.getInstance().removeContext(contextid);
/*      */   }
/*      */   
/*      */   static boolean reportGameServerBalanceInfo(int onlineNum)
/*      */   {
/*      */     try
/*      */     {
/* 1950 */       int roamOnlineNumSum = 0;
/* 1951 */       int roamReservedNumSum = 0;
/* 1952 */       for (RoamType roamType : RoamType.values())
/*      */       {
/* 1954 */         CollectServerBalanceInfoHandler handler = (CollectServerBalanceInfoHandler)handlerMgr.getHandler(roamType);
/* 1955 */         if (handler != null)
/*      */         {
/*      */ 
/*      */ 
/* 1959 */           int roamOnlineNum = handler.getOnlineNum();
/* 1960 */           int roamReservedNum = handler.getReservedNum();
/*      */           
/* 1962 */           roamOnlineNumSum += roamOnlineNum;
/* 1963 */           roamReservedNumSum += roamReservedNum;
/*      */         }
/*      */       }
/* 1966 */       int onlineRoleNum = onlineNum + roamReservedNumSum - roamOnlineNumSum;
/* 1967 */       hub.ReportGameServerBalanceInfoReq reqData = new hub.ReportGameServerBalanceInfoReq();
/* 1968 */       reqData.roam_type_mask = -1;
/* 1969 */       reqData.online_role_num = onlineRoleNum;
/* 1970 */       OctetsStream reqDataOctets = new OctetsStream();
/* 1971 */       reqDataOctets.marshal(reqData);
/* 1972 */       for (Integer matcherid : matcherids)
/*      */       {
/* 1974 */         DataTransferReq req = new DataTransferReq();
/* 1975 */         req.direction = 5;
/* 1976 */         req.data_type = 11;
/* 1977 */         req.src_id = GameServerInfoManager.getZoneId();
/* 1978 */         req.dst_id = matcherid.intValue();
/* 1979 */         req.data = reqDataOctets;
/* 1980 */         if (!GHubHelper.sendDataTransferReq(req, false))
/*      */         {
/* 1982 */           GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportGameServerBalanceInfo@send report game server balance info failed|online_num=%d|matcherid=%d", new Object[] { Integer.valueOf(onlineRoleNum), matcherid }));
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1990 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1994 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportGameServerBalanceInfo@send report game server balance info error|online_num=%d", new Object[] { Integer.valueOf(onlineNum) }), e);
/*      */     }
/*      */     
/*      */ 
/* 1998 */     return false;
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
/*      */   static boolean asyncCleanLadderRank(long rankid, Octets context)
/*      */   {
/* 2014 */     return GrcInterface.asyncCleanRankInfo(TopChartObjType.CrossLadderTopChartObj.getType(), rankid, context);
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
/*      */   static boolean asyncReportLadderRankInfo(long rankid, long roleid, String roleName, int occupation, int displayRanking, int ranking, Octets context)
/*      */   {
/* 2040 */     CrossLadderTopChartObj chartObj = new CrossLadderTopChartObj(roleid, roleName, occupation, displayRanking, ranking);
/*      */     
/* 2042 */     OctetsStream osChartObj = new OctetsStream();
/* 2043 */     chartObj.marshal(osChartObj);
/* 2044 */     return GrcInterface.asyncReportRankInfo(TopChartObjType.CrossLadderTopChartObj.getType(), rankid, roleid, chartObj.getScore(), osChartObj, context);
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
/*      */   static boolean asyncRemoveLadderRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 2063 */     return GrcInterface.asyncRemoveRankInfo(TopChartObjType.CrossLadderTopChartObj.getType(), rankid, roleid, context);
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
/*      */   static boolean asyncGetLadderRoleRank(long rankid, long roleid, Octets context)
/*      */   {
/* 2079 */     return GrcInterface.asyncGetRank(TopChartObjType.CrossLadderTopChartObj.getType(), rankid, roleid, context);
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
/*      */   static boolean asyncGetLadderRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/* 2097 */     return GrcInterface.asyncGetRankRange(TopChartObjType.CrossLadderTopChartObj.getType(), rankid, from, to, context);
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
/*      */   static boolean reportRoleSingleCrossFieldRankInfo(long rankid, long roleid, String name, int occupation, int starNum, long timestamp, Octets context)
/*      */   {
/* 2124 */     SingleCrossFieldTopChartObj chartObj = new SingleCrossFieldTopChartObj(roleid, name, occupation, starNum, timestamp);
/*      */     
/* 2126 */     OctetsStream osChartObj = new OctetsStream();
/* 2127 */     chartObj.marshal(osChartObj);
/* 2128 */     return GrcInterface.asyncReportRankInfo(TopChartObjType.SingleCrossFieldTopChartObj.getType(), rankid, roleid, chartObj.getScore(), osChartObj, context);
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
/*      */   static boolean getRoleSingleCrossFieldRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 2146 */     return GrcInterface.asyncGetRank(TopChartObjType.SingleCrossFieldTopChartObj.getType(), rankid, roleid, context);
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
/*      */   static boolean getSingleCrossFieldRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/* 2165 */     return GrcInterface.asyncGetRankRange(TopChartObjType.SingleCrossFieldTopChartObj.getType(), rankid, from, to, context);
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
/*      */   static boolean reportRoleCrossBattleBetWinRankInfo(long rankid, long roleid, String name, int occupation, long profit, long timestamp, Octets context)
/*      */   {
/* 2192 */     CrossBattleBetWinTopChartObj chartObj = new CrossBattleBetWinTopChartObj(roleid, name, occupation, profit, timestamp);
/*      */     
/* 2194 */     OctetsStream osChartObj = new OctetsStream();
/* 2195 */     chartObj.marshal(osChartObj);
/* 2196 */     return GrcInterface.asyncReportRankInfo(TopChartObjType.CrossBattleBetWinTopChartObj.getType(), rankid, roleid, chartObj.getScore(), osChartObj, context);
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
/*      */   static boolean removeRoleCrossBattleBetWinRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 2215 */     return GrcInterface.asyncRemoveRankInfo(TopChartObjType.CrossBattleBetWinTopChartObj.getType(), rankid, roleid, context);
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
/*      */   static boolean getRoleCrossBattleBetWinRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 2232 */     return GrcInterface.asyncGetRank(TopChartObjType.CrossBattleBetWinTopChartObj.getType(), rankid, roleid, context);
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
/*      */   static boolean getCrossBattleBetWinRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/* 2251 */     return GrcInterface.asyncGetRankRange(TopChartObjType.CrossBattleBetWinTopChartObj.getType(), rankid, from, to, context);
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
/*      */   static boolean reportRoleCrossBattleBetLoseRankInfo(long rankid, long roleid, String name, int occupation, long profit, long timestamp, Octets context)
/*      */   {
/* 2278 */     CrossBattleBetLoseTopChartObj chartObj = new CrossBattleBetLoseTopChartObj(roleid, name, occupation, profit, timestamp);
/*      */     
/* 2280 */     OctetsStream osChartObj = new OctetsStream();
/* 2281 */     chartObj.marshal(osChartObj);
/* 2282 */     return GrcInterface.asyncReportRankInfo(TopChartObjType.CrossBattleBetLoseTopChartObj.getType(), rankid, roleid, chartObj.getScore(), osChartObj, context);
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
/*      */   static boolean removeRoleCrossBattleBetLoseRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 2301 */     return GrcInterface.asyncRemoveRankInfo(TopChartObjType.CrossBattleBetLoseTopChartObj.getType(), rankid, roleid, context);
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
/*      */   static boolean getRoleCrossBattleBetLoseRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 2319 */     return GrcInterface.asyncGetRank(TopChartObjType.CrossBattleBetLoseTopChartObj.getType(), rankid, roleid, context);
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
/*      */   static boolean getCrossBattleBetLoseRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/* 2338 */     return GrcInterface.asyncGetRankRange(TopChartObjType.CrossBattleBetLoseTopChartObj.getType(), rankid, from, to, context);
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
/*      */   static boolean reportRoleBigBossRankInfo(long rankid, long roleid, String name, int occupation, int damagePoint, Octets context)
/*      */   {
/* 2364 */     BigBossTopChartObj chartObj = new BigBossTopChartObj(roleid, name, occupation, damagePoint);
/* 2365 */     OctetsStream osChartObj = new OctetsStream();
/* 2366 */     chartObj.marshal(osChartObj);
/* 2367 */     return GrcInterface.asyncReportRankInfo(TopChartObjType.BigBossTopChartObj.getType(), rankid, roleid, chartObj.getScore(), osChartObj, context);
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
/*      */   static boolean removeRoleBigBossRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 2386 */     return GrcInterface.asyncRemoveRankInfo(TopChartObjType.BigBossTopChartObj.getType(), rankid, roleid, context);
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
/*      */   static boolean getRoleBigBossRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 2403 */     return GrcInterface.asyncGetRank(TopChartObjType.BigBossTopChartObj.getType(), rankid, roleid, context);
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
/*      */   static boolean getBigBossRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/* 2422 */     return GrcInterface.asyncGetRankRange(TopChartObjType.BigBossTopChartObj.getType(), rankid, from, to, context);
/*      */   }
/*      */   
/*      */   static void onCleanRankInfoDone(int retcode, int rankType, long rankid, Octets context)
/*      */   {
/* 2427 */     if (TopChartObjType.CrossLadderTopChartObj.getType() == rankType)
/*      */     {
/* 2429 */       mzm.gsp.crossserver.event.CleanLadderRankDone event = new mzm.gsp.crossserver.event.CleanLadderRankDone();
/* 2430 */       mzm.gsp.crossserver.event.CleanLadderRankDoneArg arg = new mzm.gsp.crossserver.event.CleanLadderRankDoneArg(retcode, rankid, context);
/* 2431 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void onRemoveRankInfoDone(int retcode, int rankType, long rankid, long chartObjid, Octets context)
/*      */   {
/* 2438 */     if (TopChartObjType.CrossBattleBetWinTopChartObj.getType() == rankType)
/*      */     {
/* 2440 */       mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetWinRankInfoDone event = new mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetWinRankInfoDone();
/* 2441 */       mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetWinRankInfoDoneArg arg = new mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetWinRankInfoDoneArg(retcode, rankid, chartObjid, context);
/*      */       
/*      */ 
/*      */ 
/* 2445 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2447 */     else if (TopChartObjType.CrossBattleBetLoseTopChartObj.getType() == rankType)
/*      */     {
/* 2449 */       mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetLoseRankInfoDone event = new mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetLoseRankInfoDone();
/* 2450 */       mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetLoseRankInfoDoneArg arg = new mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetLoseRankInfoDoneArg(retcode, rankid, chartObjid, context);
/*      */       
/*      */ 
/*      */ 
/* 2454 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2456 */     else if (TopChartObjType.CrossLadderTopChartObj.getType() == rankType)
/*      */     {
/* 2458 */       mzm.gsp.crossserver.event.RemoveLadderRankInfoDone event = new mzm.gsp.crossserver.event.RemoveLadderRankInfoDone();
/* 2459 */       mzm.gsp.crossserver.event.RemoveLadderRankInfoDoneArg arg = new mzm.gsp.crossserver.event.RemoveLadderRankInfoDoneArg(retcode, rankid, chartObjid, context);
/* 2460 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2462 */     else if (TopChartObjType.BigBossTopChartObj.getType() == rankType)
/*      */     {
/* 2464 */       mzm.gsp.crossserver.event.RemoveRoleBigBossRankInfoDone event = new mzm.gsp.crossserver.event.RemoveRoleBigBossRankInfoDone();
/* 2465 */       mzm.gsp.crossserver.event.RemoveRoleBigBossRankInfoDoneArg arg = new mzm.gsp.crossserver.event.RemoveRoleBigBossRankInfoDoneArg(retcode, rankid, chartObjid, context);
/* 2466 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void onReportRankInfoDone(int retcode, int rankType, long rankid, long chartObjid, Octets chartObjInfo, Octets context)
/*      */   {
/* 2473 */     if (TopChartObjType.CrossLadderTopChartObj.getType() == rankType)
/*      */     {
/* 2475 */       CrossLadderTopChartObj chartObj = new CrossLadderTopChartObj();
/* 2476 */       OctetsStream os = new OctetsStream(chartObjInfo);
/*      */       try
/*      */       {
/* 2479 */         chartObj.unmarshal(os);
/*      */       }
/*      */       catch (Exception e) {}
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 2486 */       mzm.gsp.crossserver.event.ReportLadderRankInfoDone event = new mzm.gsp.crossserver.event.ReportLadderRankInfoDone();
/* 2487 */       mzm.gsp.crossserver.event.ReportLadderRankInfoDoneArg arg = new mzm.gsp.crossserver.event.ReportLadderRankInfoDoneArg(retcode, rankid, chartObjid, chartObj.getOccupation(), chartObj.getRoleName(), chartObj.getDisplayRanking(), chartObj.getRanking(), context);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 2492 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2494 */     else if (TopChartObjType.SingleCrossFieldTopChartObj.getType() == rankType)
/*      */     {
/* 2496 */       SingleCrossFieldTopChartObj chartObj = new SingleCrossFieldTopChartObj();
/* 2497 */       OctetsStream os = new OctetsStream(chartObjInfo);
/*      */       try
/*      */       {
/* 2500 */         chartObj.unmarshal(os);
/*      */       }
/*      */       catch (Exception e) {}
/*      */       
/*      */ 
/*      */ 
/* 2506 */       mzm.gsp.crossserver.event.ReportRoleSingleCrossFieldRankInfoDone event = new mzm.gsp.crossserver.event.ReportRoleSingleCrossFieldRankInfoDone();
/* 2507 */       mzm.gsp.crossserver.event.ReportRoleSingleCrossFieldRankInfoDoneArg arg = new mzm.gsp.crossserver.event.ReportRoleSingleCrossFieldRankInfoDoneArg(retcode, rankid, chartObj, context);
/*      */       
/*      */ 
/*      */ 
/* 2511 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2513 */     else if (TopChartObjType.CrossBattleBetWinTopChartObj.getType() == rankType)
/*      */     {
/* 2515 */       CrossBattleBetWinTopChartObj chartObj = new CrossBattleBetWinTopChartObj();
/* 2516 */       OctetsStream os = new OctetsStream(chartObjInfo);
/*      */       try
/*      */       {
/* 2519 */         chartObj.unmarshal(os);
/*      */       }
/*      */       catch (Exception e) {}
/*      */       
/*      */ 
/*      */ 
/* 2525 */       ReportRoleCrossBattleBetWinRankInfoDone event = new ReportRoleCrossBattleBetWinRankInfoDone();
/* 2526 */       mzm.gsp.crossserver.event.ReportRoleCrossBattleBetWinRankInfoDoneArg arg = new mzm.gsp.crossserver.event.ReportRoleCrossBattleBetWinRankInfoDoneArg(retcode, rankid, chartObj, context);
/*      */       
/*      */ 
/*      */ 
/* 2530 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2532 */     else if (TopChartObjType.CrossBattleBetLoseTopChartObj.getType() == rankType)
/*      */     {
/* 2534 */       CrossBattleBetLoseTopChartObj chartObj = new CrossBattleBetLoseTopChartObj();
/* 2535 */       OctetsStream os = new OctetsStream(chartObjInfo);
/*      */       try
/*      */       {
/* 2538 */         chartObj.unmarshal(os);
/*      */       }
/*      */       catch (Exception e) {}
/*      */       
/*      */ 
/*      */ 
/* 2544 */       ReportRoleCrossBattleBetLoseRankInfoDone event = new ReportRoleCrossBattleBetLoseRankInfoDone();
/* 2545 */       mzm.gsp.crossserver.event.ReportRoleCrossBattleBetLoseRankInfoDoneArg arg = new mzm.gsp.crossserver.event.ReportRoleCrossBattleBetLoseRankInfoDoneArg(retcode, rankid, chartObj, context);
/*      */       
/*      */ 
/*      */ 
/* 2549 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2551 */     else if (TopChartObjType.BigBossTopChartObj.getType() == rankType)
/*      */     {
/* 2553 */       BigBossTopChartObj chartObj = new BigBossTopChartObj();
/* 2554 */       OctetsStream os = new OctetsStream(chartObjInfo);
/*      */       try
/*      */       {
/* 2557 */         chartObj.unmarshal(os);
/*      */       }
/*      */       catch (Exception e) {}
/*      */       
/*      */ 
/*      */ 
/* 2563 */       ReportRoleBigBossRankInfoDone event = new ReportRoleBigBossRankInfoDone();
/* 2564 */       mzm.gsp.crossserver.event.ReportRoleBigBossRankInfoDoneArg arg = new mzm.gsp.crossserver.event.ReportRoleBigBossRankInfoDoneArg(retcode, rankid, chartObj, context);
/*      */       
/* 2566 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetRankDone(int retcode, int rankType, long rankid, long chartObjid, Octets context, int rank)
/*      */   {
/* 2573 */     if (TopChartObjType.CrossLadderTopChartObj.getType() == rankType)
/*      */     {
/* 2575 */       mzm.gsp.crossserver.event.GetLadderRoleRankDone event = new mzm.gsp.crossserver.event.GetLadderRoleRankDone();
/* 2576 */       GetLadderRoleRankDoneArg arg = new GetLadderRoleRankDoneArg(retcode, rankid, chartObjid, context, rank);
/* 2577 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2579 */     else if (TopChartObjType.SingleCrossFieldTopChartObj.getType() == rankType)
/*      */     {
/* 2581 */       mzm.gsp.crossserver.event.GetRoleSingleCrossFieldRankInfoDone event = new mzm.gsp.crossserver.event.GetRoleSingleCrossFieldRankInfoDone();
/* 2582 */       GetRoleSingleCrossFieldRankInfoDoneArg arg = new GetRoleSingleCrossFieldRankInfoDoneArg(retcode, rankid, chartObjid, rank, context);
/*      */       
/*      */ 
/* 2585 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2587 */     else if (TopChartObjType.CrossBattleBetWinTopChartObj.getType() == rankType)
/*      */     {
/* 2589 */       mzm.gsp.crossserver.event.GetRoleCrossBattleBetWinRankInfoDone event = new mzm.gsp.crossserver.event.GetRoleCrossBattleBetWinRankInfoDone();
/* 2590 */       GetRoleCrossBattleBetWinRankInfoDoneArg arg = new GetRoleCrossBattleBetWinRankInfoDoneArg(retcode, rankid, chartObjid, rank, context);
/*      */       
/*      */ 
/* 2593 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2595 */     else if (TopChartObjType.CrossBattleBetLoseTopChartObj.getType() == rankType)
/*      */     {
/* 2597 */       mzm.gsp.crossserver.event.GetRoleCrossBattleBetLoseRankInfoDone event = new mzm.gsp.crossserver.event.GetRoleCrossBattleBetLoseRankInfoDone();
/* 2598 */       GetRoleCrossBattleBetLoseRankInfoDoneArg arg = new GetRoleCrossBattleBetLoseRankInfoDoneArg(retcode, rankid, chartObjid, rank, context);
/*      */       
/*      */ 
/* 2601 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2603 */     else if (TopChartObjType.BigBossTopChartObj.getType() == rankType)
/*      */     {
/* 2605 */       mzm.gsp.crossserver.event.GetRoleBigBossRankInfoDone event = new mzm.gsp.crossserver.event.GetRoleBigBossRankInfoDone();
/* 2606 */       mzm.gsp.crossserver.event.GetRoleBigBossRankInfoDoneArg arg = new mzm.gsp.crossserver.event.GetRoleBigBossRankInfoDoneArg(retcode, rankid, chartObjid, rank, context);
/*      */       
/* 2608 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetRankRangeDone(int retcode, int rankType, long rankid, int from, int to, Octets context, int cardinality, List<byte[]> rankRangeInfos)
/*      */   {
/* 2615 */     if (TopChartObjType.CrossLadderTopChartObj.getType() == rankType)
/*      */     {
/* 2617 */       ArrayList<mzm.gsp.ladder.LadderRankRoleData> rankRange = rankRangeInfos == null ? null : new ArrayList();
/* 2618 */       if (rankRangeInfos != null)
/*      */       {
/*      */         try
/*      */         {
/* 2622 */           for (byte[] bytes : rankRangeInfos)
/*      */           {
/* 2624 */             CrossLadderTopChartObj chartObj = new CrossLadderTopChartObj();
/* 2625 */             if (bytes.length > 0)
/*      */             {
/* 2627 */               OctetsStream os = new OctetsStream(Octets.wrap(bytes));
/* 2628 */               chartObj.unmarshal(os);
/*      */             }
/* 2630 */             rankRange.add(chartObj.getRankRoleData());
/*      */           }
/*      */         }
/*      */         catch (MarshalException e) {}
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2638 */       GetLadderRankRangeDone event = new GetLadderRankRangeDone();
/* 2639 */       GetLadderRankRangeDoneArg arg = new GetLadderRankRangeDoneArg(retcode, rankid, from, to, context, cardinality, rankRange);
/*      */       
/* 2641 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2643 */     else if (TopChartObjType.SingleCrossFieldTopChartObj.getType() == rankType)
/*      */     {
/* 2645 */       ArrayList<mzm.gsp.crossfield.CrossFieldRankData> rankRange = new ArrayList();
/* 2646 */       if (rankRangeInfos != null)
/*      */       {
/*      */         try
/*      */         {
/* 2650 */           for (byte[] bytes : rankRangeInfos)
/*      */           {
/* 2652 */             SingleCrossFieldTopChartObj chartObj = new SingleCrossFieldTopChartObj();
/* 2653 */             if (bytes.length > 0)
/*      */             {
/* 2655 */               OctetsStream os = new OctetsStream(Octets.wrap(bytes));
/* 2656 */               chartObj.unmarshal(os);
/*      */             }
/* 2658 */             rankRange.add(chartObj.getRankData());
/*      */           }
/*      */         }
/*      */         catch (MarshalException e) {}
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2666 */       mzm.gsp.crossserver.event.GetSingleCrossFieldRankRangeDone event = new mzm.gsp.crossserver.event.GetSingleCrossFieldRankRangeDone();
/* 2667 */       mzm.gsp.crossserver.event.GetSingleCrossFieldRankRangeDoneArg arg = new mzm.gsp.crossserver.event.GetSingleCrossFieldRankRangeDoneArg(retcode, rankid, from, to, cardinality, rankRange, context);
/*      */       
/*      */ 
/* 2670 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2672 */     else if (TopChartObjType.CrossBattleBetWinTopChartObj.getType() == rankType)
/*      */     {
/* 2674 */       ArrayList<mzm.gsp.crossbattle.CrossBattleBetRankData> rankRange = new ArrayList();
/* 2675 */       if (rankRangeInfos != null)
/*      */       {
/*      */         try
/*      */         {
/* 2679 */           for (byte[] bytes : rankRangeInfos)
/*      */           {
/* 2681 */             CrossBattleBetWinTopChartObj chartObj = new CrossBattleBetWinTopChartObj();
/* 2682 */             if (bytes.length > 0)
/*      */             {
/* 2684 */               OctetsStream os = new OctetsStream(Octets.wrap(bytes));
/* 2685 */               chartObj.unmarshal(os);
/*      */             }
/* 2687 */             rankRange.add(chartObj.getRankData());
/*      */           }
/*      */         }
/*      */         catch (MarshalException e) {}
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2695 */       mzm.gsp.crossserver.event.GetCrossBattleBetWinRankRangeDone event = new mzm.gsp.crossserver.event.GetCrossBattleBetWinRankRangeDone();
/* 2696 */       mzm.gsp.crossserver.event.GetCrossBattleBetWinRankRangeDoneArg arg = new mzm.gsp.crossserver.event.GetCrossBattleBetWinRankRangeDoneArg(retcode, rankid, from, to, cardinality, rankRange, context);
/*      */       
/*      */ 
/* 2699 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2701 */     else if (TopChartObjType.CrossBattleBetLoseTopChartObj.getType() == rankType)
/*      */     {
/* 2703 */       ArrayList<mzm.gsp.crossbattle.CrossBattleBetRankData> rankRange = new ArrayList();
/* 2704 */       if (rankRangeInfos != null)
/*      */       {
/*      */         try
/*      */         {
/* 2708 */           for (byte[] bytes : rankRangeInfos)
/*      */           {
/* 2710 */             CrossBattleBetLoseTopChartObj chartObj = new CrossBattleBetLoseTopChartObj();
/* 2711 */             if (bytes.length > 0)
/*      */             {
/* 2713 */               OctetsStream os = new OctetsStream(Octets.wrap(bytes));
/* 2714 */               chartObj.unmarshal(os);
/*      */             }
/* 2716 */             rankRange.add(chartObj.getRankData());
/*      */           }
/*      */         }
/*      */         catch (MarshalException e) {}
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2724 */       mzm.gsp.crossserver.event.GetCrossBattleBetLoseRankRangeDone event = new mzm.gsp.crossserver.event.GetCrossBattleBetLoseRankRangeDone();
/* 2725 */       mzm.gsp.crossserver.event.GetCrossBattleBetLoseRankRangeDoneArg arg = new mzm.gsp.crossserver.event.GetCrossBattleBetLoseRankRangeDoneArg(retcode, rankid, from, to, cardinality, rankRange, context);
/*      */       
/*      */ 
/* 2728 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/* 2730 */     else if (TopChartObjType.BigBossTopChartObj.getType() == rankType)
/*      */     {
/* 2732 */       ArrayList<mzm.gsp.bigboss.BigbossRankData> rankRange = new ArrayList();
/* 2733 */       if (rankRangeInfos != null)
/*      */       {
/*      */         try
/*      */         {
/* 2737 */           for (byte[] bytes : rankRangeInfos)
/*      */           {
/* 2739 */             BigBossTopChartObj chartObj = new BigBossTopChartObj();
/* 2740 */             if (bytes.length > 0)
/*      */             {
/* 2742 */               OctetsStream os = new OctetsStream(Octets.wrap(bytes));
/* 2743 */               chartObj.unmarshal(os);
/*      */             }
/* 2745 */             rankRange.add(chartObj.getRankData());
/*      */           }
/*      */         }
/*      */         catch (MarshalException e) {}
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2753 */       mzm.gsp.crossserver.event.GetBigBossRankRangeDone event = new mzm.gsp.crossserver.event.GetBigBossRankRangeDone();
/* 2754 */       GetBigBossRankRangeDoneArg arg = new GetBigBossRankRangeDoneArg(retcode, rankid, from, to, cardinality, rankRange, context);
/*      */       
/* 2756 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean reportCrossCompeteSignUp(long startTime, List<hub.CrossCompeteSignUpFaction> factions, boolean bForce)
/*      */   {
/*      */     try
/*      */     {
/* 2764 */       DataTransferReq req = new DataTransferReq();
/* 2765 */       req.direction = 5;
/* 2766 */       req.data_type = 100;
/* 2767 */       req.src_id = GameServerInfoManager.getZoneId();
/* 2768 */       req.dst_id = crossCompeteMatcherid;
/*      */       
/* 2770 */       ReportCrossCompeteSignUpReq reqData = new ReportCrossCompeteSignUpReq();
/* 2771 */       reqData.start_millis = startTime;
/* 2772 */       reqData.server_level = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/* 2773 */       reqData.zoneid = GameServerInfoManager.getZoneId();
/* 2774 */       reqData.factions.addAll(factions);
/* 2775 */       if (bForce)
/*      */       {
/* 2777 */         reqData.match_type = 1;
/*      */       }
/*      */       else
/*      */       {
/* 2781 */         reqData.match_type = 0;
/*      */       }
/*      */       
/* 2784 */       OctetsStream os = new OctetsStream();
/* 2785 */       os.marshal(reqData);
/* 2786 */       req.data = os;
/*      */       
/* 2788 */       if (!GHubHelper.sendDataTransferReq(req, true))
/*      */       {
/* 2790 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportCrossCompeteSignUp@send sign up request failed", new Object[0]));
/*      */         
/* 2792 */         return false;
/*      */       }
/*      */       
/* 2795 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 2799 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.joinMatch@send join match request error", new Object[0]), e);
/*      */     }
/*      */     
/* 2802 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean requireCrossCompeteRoamServers(long startTime, List<Integer> competes)
/*      */   {
/*      */     try
/*      */     {
/* 2810 */       DataTransferReq req = new DataTransferReq();
/* 2811 */       req.direction = 5;
/* 2812 */       req.data_type = 101;
/* 2813 */       req.src_id = GameServerInfoManager.getZoneId();
/* 2814 */       req.dst_id = crossCompeteMatcherid;
/*      */       
/* 2816 */       CrossCompeteRoamServersReq reqData = new CrossCompeteRoamServersReq();
/* 2817 */       reqData.start_millis = startTime;
/* 2818 */       reqData.compete_list.addAll(competes);
/*      */       
/* 2820 */       OctetsStream os = new OctetsStream();
/* 2821 */       os.marshal(reqData);
/* 2822 */       req.data = os;
/*      */       
/* 2824 */       if (!GHubHelper.sendDataTransferReq(req, true))
/*      */       {
/* 2826 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportCrossCompeteSignUp@send sign up request failed", new Object[0]));
/*      */         
/* 2828 */         return false;
/*      */       }
/*      */       
/* 2831 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 2835 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.joinMatch@send join match request error", new Object[0]), e);
/*      */     }
/* 2837 */     return false;
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
/*      */   static boolean reportCrossCompeteFactionInfo(long factionid, String factionName, List<hub.CrossCompeteFactionDutyMembers> dutyMembers, int designTitleid, int participateCount, int roamServerid)
/*      */   {
/*      */     try
/*      */     {
/* 2856 */       DataTransferReq req = new DataTransferReq();
/* 2857 */       req.direction = 0;
/* 2858 */       req.data_type = 103;
/* 2859 */       req.src_id = GameServerInfoManager.getZoneId();
/* 2860 */       req.dst_id = roamServerid;
/*      */       
/* 2862 */       ReportCrossCompeteFactionInfoReq reqData = new ReportCrossCompeteFactionInfoReq();
/* 2863 */       reqData.factionid = factionid;
/* 2864 */       reqData.name = factionName;
/* 2865 */       reqData.members.addAll(dutyMembers);
/* 2866 */       reqData.design_titleid = designTitleid;
/* 2867 */       reqData.partcipate_count = participateCount;
/*      */       
/* 2869 */       OctetsStream os = new OctetsStream();
/* 2870 */       os.marshal(reqData);
/* 2871 */       req.data = os;
/*      */       
/* 2873 */       if (!GHubHelper.sendDataTransferReq(req, true))
/*      */       {
/* 2875 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportCrossCompeteFactionInfo@send cross compete faction info failed", new Object[0]));
/*      */         
/* 2877 */         return false;
/*      */       }
/*      */       
/* 2880 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 2884 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportCrossCompeteFactionInfo@send cross compete faction info error", new Object[0]), e);
/*      */     }
/*      */     
/* 2887 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean enterCrossCompeteMap(long factionid, List<hub.CrossCompeteEnterRole> roles, int roamServerid, boolean isTeam)
/*      */   {
/*      */     try
/*      */     {
/* 2895 */       DataTransferReq req = new DataTransferReq();
/* 2896 */       req.direction = 0;
/* 2897 */       req.data_type = 104;
/* 2898 */       req.src_id = GameServerInfoManager.getZoneId();
/* 2899 */       req.dst_id = roamServerid;
/*      */       
/* 2901 */       EnterCrossCompeteMapReq reqData = new EnterCrossCompeteMapReq();
/* 2902 */       reqData.factionid = factionid;
/* 2903 */       reqData.roles.addAll(roles);
/* 2904 */       if (isTeam)
/*      */       {
/* 2906 */         reqData.team_type = 0;
/*      */       }
/*      */       else
/*      */       {
/* 2910 */         reqData.team_type = 1;
/*      */       }
/*      */       
/* 2913 */       OctetsStream os = new OctetsStream();
/* 2914 */       os.marshal(reqData);
/* 2915 */       req.data = os;
/*      */       
/* 2917 */       if (!GHubHelper.sendDataTransferReq(req, false))
/*      */       {
/* 2919 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.enterCrossCompeteMap@send enter cross compete map failed", new Object[0]));
/*      */         
/* 2921 */         return false;
/*      */       }
/*      */       
/* 2924 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 2928 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.enterCrossCompeteMap@send enter cross compete map error", new Object[0]), e);
/*      */     }
/* 2930 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean crossCompeteRoleDataBack(long roleid, String userid, Octets userToken, int winTimes, int loseTimes, int escapeTimes, int winStreakAwardTimes, int treasureAward, int reason)
/*      */   {
/*      */     try
/*      */     {
/* 2939 */       DataTransferReq req = new DataTransferReq();
/* 2940 */       req.direction = 0;
/* 2941 */       req.data_type = 105;
/* 2942 */       req.src_id = GameServerInfoManager.getZoneId();
/* 2943 */       req.dst_id = GameServerInfoManager.getZoneidFromRoleid(roleid);
/*      */       
/* 2945 */       CrossCompeteRoleDataBackReq reqData = new CrossCompeteRoleDataBackReq();
/* 2946 */       reqData.roleid = roleid;
/* 2947 */       reqData.userid = userid;
/* 2948 */       reqData.user_token = userToken;
/* 2949 */       reqData.win_times = winTimes;
/* 2950 */       reqData.lose_times = loseTimes;
/* 2951 */       reqData.escape_times = escapeTimes;
/* 2952 */       reqData.win_streak_award_times = winStreakAwardTimes;
/* 2953 */       reqData.treasure_award = treasureAward;
/* 2954 */       reqData.reason = reason;
/* 2955 */       hub.ExchangeDataHandlerInfo handlerInfo = new hub.ExchangeDataHandlerInfo();
/* 2956 */       if (ReturnFromRoamServerHandlerManager.boxData(userid, roleid, handlerInfo))
/*      */       {
/* 2958 */         reqData.exchange_data_handler_info.add(handlerInfo);
/*      */       }
/*      */       
/* 2961 */       OctetsStream os = new OctetsStream();
/* 2962 */       os.marshal(reqData);
/* 2963 */       req.data = os;
/*      */       
/* 2965 */       if (!GHubHelper.sendDataTransferReq(req, true, 5))
/*      */       {
/* 2967 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.crossCompeteRoleDataBack@send role data back failed|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*      */         
/*      */ 
/*      */ 
/* 2971 */         return false;
/*      */       }
/*      */       
/* 2974 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 2978 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.enterCrossCompeteMap@send role data back error|roleid=%d", new Object[] { Long.valueOf(roleid) }), e);
/*      */     }
/*      */     
/* 2981 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean notifyCrossCompeteResult(long factionid, long winFactionid, long loseFactionid)
/*      */   {
/*      */     try
/*      */     {
/* 2989 */       DataTransferReq req = new DataTransferReq();
/* 2990 */       req.direction = 0;
/* 2991 */       req.data_type = 106;
/* 2992 */       req.src_id = GameServerInfoManager.getZoneId();
/* 2993 */       req.dst_id = GameServerInfoManager.getZoneidFromGangid(factionid);
/*      */       
/* 2995 */       NotifyCrossCompeteResultReq reqData = new NotifyCrossCompeteResultReq();
/* 2996 */       reqData.win_factionid = winFactionid;
/* 2997 */       reqData.lose_factionid = loseFactionid;
/*      */       
/* 2999 */       OctetsStream os = new OctetsStream();
/* 3000 */       os.marshal(reqData);
/* 3001 */       req.data = os;
/*      */       
/* 3003 */       if (!GHubHelper.sendDataTransferReq(req, true, 5))
/*      */       {
/* 3005 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.notifyCrossCompeteResult@notify result failed|factionid=%d|win_factionid=%d|lose_factionid=%d", new Object[] { Long.valueOf(factionid), Long.valueOf(winFactionid), Long.valueOf(loseFactionid) }));
/*      */         
/*      */ 
/*      */ 
/* 3009 */         return false;
/*      */       }
/*      */       
/* 3012 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3016 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.notifyCrossCompeteResult@notify result error|factionid=%d|win_factionid=%d|lose_factionid=%d", new Object[] { Long.valueOf(factionid), Long.valueOf(winFactionid), Long.valueOf(loseFactionid) }));
/*      */     }
/*      */     
/*      */ 
/* 3020 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean crossCompeteTeamBack(List<CrossCompeteUserDataBack> userList)
/*      */   {
/*      */     try
/*      */     {
/* 3028 */       DataTransferReq req = new DataTransferReq();
/* 3029 */       req.direction = 0;
/* 3030 */       req.data_type = 107;
/* 3031 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3032 */       req.dst_id = GameServerInfoManager.getZoneidFromGangid(((CrossCompeteUserDataBack)userList.get(0)).roleid);
/*      */       
/* 3034 */       CrossCompeteTeamBackReq reqData = new CrossCompeteTeamBackReq();
/* 3035 */       reqData.users.addAll(userList);
/*      */       
/* 3037 */       OctetsStream os = new OctetsStream();
/* 3038 */       os.marshal(reqData);
/* 3039 */       req.data = os;
/*      */       
/* 3041 */       if (!GHubHelper.sendDataTransferReq(req, true, 5))
/*      */       {
/* 3043 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.crossCompeteTeamBack@team back failed|users=%s", new Object[] { userList }));
/*      */         
/*      */ 
/* 3046 */         return false;
/*      */       }
/*      */       
/* 3049 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3053 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.crossCompeteTeamBack@team back error|users=%s", new Object[] { userList }));
/*      */     }
/* 3055 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean reportCrossBattleOwnResult(int activityCfgid, Map<Long, Octets> result)
/*      */   {
/* 3061 */     return GrcInterface.reportCrossBattleOwnResult(activityCfgid, result);
/*      */   }
/*      */   
/*      */   static void onReportCrossBattleOwnResultDone(int retcode, int activityCfgid)
/*      */   {
/* 3066 */     mzm.gsp.crossserver.event.ReportCrossBattleOwnResultDone event = new mzm.gsp.crossserver.event.ReportCrossBattleOwnResultDone();
/* 3067 */     mzm.gsp.crossserver.event.ReportCrossBattleOwnResultDoneArg arg = new mzm.gsp.crossserver.event.ReportCrossBattleOwnResultDoneArg(retcode, activityCfgid);
/* 3068 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */   }
/*      */   
/*      */   static boolean clearCrossBattleOwnResult(int activityCfgid, Map<Long, Octets> result)
/*      */   {
/* 3073 */     return GrcInterface.clearCrossBattleOwnResult(activityCfgid, result);
/*      */   }
/*      */   
/*      */   static void onClearCrossBattleOwnResultDone(int retcode, int activityCfgid)
/*      */   {
/* 3078 */     ClearCrossBattleOwnResultDone event = new ClearCrossBattleOwnResultDone();
/* 3079 */     mzm.gsp.crossserver.event.ClearCrossBattleOwnResultDoneArg arg = new mzm.gsp.crossserver.event.ClearCrossBattleOwnResultDoneArg(retcode, activityCfgid);
/* 3080 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
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
/*      */   static boolean reportCorpsFightValue(int activityCfgid, int zoneNum, boolean force, Map<Long, Float> corpsFightValues)
/*      */   {
/*      */     try
/*      */     {
/* 3095 */       DataTransferReq req = new DataTransferReq();
/* 3096 */       req.direction = 5;
/* 3097 */       req.data_type = 300;
/* 3098 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3099 */       req.dst_id = crossBattlePointMatcherid;
/* 3100 */       ReportCorpsFightValueReq reqData = new ReportCorpsFightValueReq();
/* 3101 */       reqData.activity_cfgid = activityCfgid;
/* 3102 */       reqData.zone_num = zoneNum;
/* 3103 */       reqData.force = (force ? 1 : 0);
/* 3104 */       reqData.corps.putAll(corpsFightValues);
/*      */       
/* 3106 */       OctetsStream os = new OctetsStream();
/* 3107 */       os.marshal(reqData);
/* 3108 */       req.data = os;
/*      */       
/*      */ 
/* 3111 */       if (!GHubHelper.sendDataTransferReq(req, true))
/*      */       {
/* 3113 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportCorpsFightValue@send report corps fight value failed|activity_cfgid=%d|corps_info=%s", new Object[] { Integer.valueOf(activityCfgid), corpsFightValues.toString() }));
/*      */         
/*      */ 
/*      */ 
/* 3117 */         return false;
/*      */       }
/*      */       
/* 3120 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3124 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportCorpsFightValue@send report corps fight value error|activity_cfgid=%d|corps_info=%s", new Object[] { Integer.valueOf(activityCfgid), corpsFightValues.toString() }), e);
/*      */     }
/*      */     
/*      */ 
/* 3128 */     return false;
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
/*      */   static boolean asyncGetCorpsZone(Octets context)
/*      */   {
/* 3141 */     return GrcInterface.asyncGetCorpsZone(context);
/*      */   }
/*      */   
/*      */   static void onGetCorpsZoneDone(int retcode, Octets context, Map<Long, Integer> data)
/*      */   {
/* 3146 */     mzm.gsp.crossserver.event.GetCorpsZoneDone event = new mzm.gsp.crossserver.event.GetCorpsZoneDone();
/* 3147 */     GetCorpsZoneDoneArg arg = new GetCorpsZoneDoneArg(retcode, context, data);
/* 3148 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean joinPointRace(PointRaceContext context)
/*      */   {
/*      */     try
/*      */     {
/* 3161 */       int zoneid = GameServerInfoManager.getZoneId();
/* 3162 */       DataTransferReq req = new DataTransferReq();
/* 3163 */       req.direction = 5;
/* 3164 */       req.data_type = 301;
/* 3165 */       req.src_id = zoneid;
/* 3166 */       req.dst_id = crossBattlePointMatcherid;
/*      */       
/* 3168 */       hub.JoinPointRaceReq reqData = new hub.JoinPointRaceReq();
/* 3169 */       reqData.zoneid = zoneid;
/* 3170 */       reqData.game_server_contextid = context.contextid;
/* 3171 */       reqData.point_race_info = context.pointRaceInfo.getHubPointRaceInfo();
/*      */       
/* 3173 */       OctetsStream os = new OctetsStream();
/* 3174 */       os.marshal(reqData);
/* 3175 */       req.data = os;
/*      */       
/* 3177 */       JoinPointRaceTransferReqXidWrapper reqXidWrapper = new JoinPointRaceTransferReqXidWrapper(req, context);
/* 3178 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 3180 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.joinPointRace@send join point race request failed|context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 3184 */         return false;
/*      */       }
/*      */       
/* 3187 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3191 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.joinPointRace@send join point race request error|context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 3196 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean confirmJoinPointRace(PointRaceContext context)
/*      */   {
/*      */     try
/*      */     {
/* 3210 */       DataTransferReq req = new DataTransferReq();
/* 3211 */       req.direction = 5;
/* 3212 */       req.data_type = 302;
/* 3213 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3214 */       req.dst_id = crossBattlePointMatcherid;
/*      */       
/* 3216 */       hub.ConfirmJoinPointRaceReq reqData = new hub.ConfirmJoinPointRaceReq();
/* 3217 */       reqData.matcher_server_contextid = context.getMatcherServerContextid();
/* 3218 */       reqData.game_server_contextid = context.contextid;
/*      */       
/* 3220 */       OctetsStream os = new OctetsStream();
/* 3221 */       os.marshal(reqData);
/* 3222 */       req.data = os;
/*      */       
/*      */ 
/* 3225 */       ConfirmJoinPointRaceTransferReqXidWrapper reqXidWrapper = new ConfirmJoinPointRaceTransferReqXidWrapper(req, context);
/*      */       
/* 3227 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 3229 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.confirmJoinPointRace@send confirm join point race request failed|context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 3233 */         return false;
/*      */       }
/*      */       
/* 3236 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3240 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.confirmJoinPointRace@send confirm join point race request error|context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 3244 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean roamPointRaceData(PointRaceContext context, PointRaceCorpsInfo corpsInfo)
/*      */   {
/*      */     try
/*      */     {
/* 3252 */       DataTransferReq req = new DataTransferReq();
/* 3253 */       req.direction = 0;
/* 3254 */       req.data_type = 306;
/* 3255 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3256 */       req.dst_id = context.getRoamZoneid();
/*      */       
/* 3258 */       RoamPointRaceDataReq reqData = new RoamPointRaceDataReq();
/* 3259 */       reqData.roam_room_instanceid = context.getRoamRoomInstanceid();
/* 3260 */       reqData.corps_info = corpsInfo;
/* 3261 */       for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : context.rolePointRaceMarkingInfos)
/*      */       {
/* 3263 */         reqData.role_infos.add(rolePointRaceMarkingInfo.getHubRolePointRaceMarkingInfo());
/*      */       }
/*      */       
/* 3266 */       OctetsStream os = new OctetsStream();
/* 3267 */       os.marshal(reqData);
/* 3268 */       req.data = os;
/*      */       
/*      */ 
/* 3271 */       RoamPointRaceDataTransferReqXidWrapper reqXidWrapper = new RoamPointRaceDataTransferReqXidWrapper(req, context);
/*      */       
/* 3273 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 3275 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.roamPointRaceData@send point race data request failed|context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 3279 */         return false;
/*      */       }
/*      */       
/* 3282 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3286 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.roamPointRaceData@send point race data request error|context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 3290 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static void removePointRaceContext(long contextid)
/*      */   {
/* 3296 */     PointRaceContextManager.getInstance().removeContext(contextid);
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
/*      */   static boolean updatePointRaceCorps(int dstZoneid, int activityCfgid, int timePointCfgid, long corpsid, int win, int lose, int point, long updateTime)
/*      */   {
/*      */     try
/*      */     {
/* 3317 */       UpdatePointRaceCorpsReq updatePointRaceCorpsReq = new UpdatePointRaceCorpsReq();
/* 3318 */       updatePointRaceCorpsReq.activity_cfgid = activityCfgid;
/* 3319 */       updatePointRaceCorpsReq.time_point_cfgid = timePointCfgid;
/*      */       
/* 3321 */       PointRaceCorpsInfo pointRaceCorpsInfo = new PointRaceCorpsInfo();
/* 3322 */       pointRaceCorpsInfo.corpsid = corpsid;
/* 3323 */       pointRaceCorpsInfo.lose = lose;
/* 3324 */       pointRaceCorpsInfo.win = win;
/* 3325 */       pointRaceCorpsInfo.point = point;
/* 3326 */       pointRaceCorpsInfo.update_time = updateTime;
/* 3327 */       updatePointRaceCorpsReq.corps_info = pointRaceCorpsInfo;
/*      */       
/* 3329 */       DataTransferReq req = new DataTransferReq();
/* 3330 */       req.direction = 0;
/* 3331 */       req.data_type = 308;
/* 3332 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3333 */       req.dst_id = dstZoneid;
/* 3334 */       OctetsStream os = new OctetsStream();
/* 3335 */       os.marshal(updatePointRaceCorpsReq);
/* 3336 */       req.data = os;
/* 3337 */       if (!GHubHelper.sendDataTransferReq(req, true, 3))
/*      */       {
/* 3339 */         GameServer.logger().error(String.format("[crossbattlepoint]CrossServerManager.updatePointRaceCorps@can not transfor data|data=%s", new Object[] { updatePointRaceCorpsReq.toString() }));
/*      */         
/*      */ 
/*      */ 
/* 3343 */         return false;
/*      */       }
/* 3345 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3349 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.updatePointRaceCorps@send update corps point race error|activity_cfgid=%d|time_point_cfgid=%d|corpsid=%d|win=%d|lose=%d|point=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(timePointCfgid), Long.valueOf(corpsid), Integer.valueOf(win), Integer.valueOf(lose), Integer.valueOf(point) }), e);
/*      */     }
/*      */     
/*      */ 
/* 3353 */     return false;
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
/*      */   static boolean reportPointRaceCorpsCVC(int activityCfgid, int zone, int timePointCfgid, Map<Long, Map<Long, HubCorpsCVCInfo>> corpsCVCInfos)
/*      */   {
/*      */     try
/*      */     {
/* 3370 */       DataTransferReq req = new DataTransferReq();
/* 3371 */       req.direction = 5;
/* 3372 */       req.data_type = 309;
/* 3373 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3374 */       req.dst_id = crossBattlePointMatcherid;
/*      */       
/* 3376 */       ReportPointRaceCorpsCVCReq reqData = new ReportPointRaceCorpsCVCReq();
/* 3377 */       reqData.activity_cfgid = activityCfgid;
/* 3378 */       reqData.zone = zone;
/* 3379 */       reqData.time_point_cfgid = timePointCfgid;
/* 3380 */       for (Map.Entry<Long, Map<Long, HubCorpsCVCInfo>> entry : corpsCVCInfos.entrySet())
/*      */       {
/* 3382 */         PointRaceCorpsCVCInfo pointRaceCorpsCVCInfo = new PointRaceCorpsCVCInfo();
/* 3383 */         pointRaceCorpsCVCInfo.cvc_infos.putAll((Map)entry.getValue());
/* 3384 */         reqData.corps_cvc_infos.put(entry.getKey(), pointRaceCorpsCVCInfo);
/*      */       }
/*      */       
/*      */ 
/* 3388 */       OctetsStream os = new OctetsStream();
/* 3389 */       os.marshal(reqData);
/* 3390 */       req.data = os;
/*      */       
/*      */ 
/* 3393 */       if (!GHubHelper.sendDataTransferReq(req, true, 3))
/*      */       {
/* 3395 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportPointRaceCorpsCVC@send report point race corps cvc failed|activity_cfgid=%d|zone=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone) }));
/*      */         
/*      */ 
/*      */ 
/* 3399 */         return false;
/*      */       }
/*      */       
/* 3402 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3406 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportPointRaceCorpsCVC@send report corps fight value error|activity_cfgid=%d|zone=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone) }), e);
/*      */     }
/*      */     
/*      */ 
/* 3410 */     return false;
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
/*      */   static boolean asyncReportCorpsPointRace(Octets context)
/*      */   {
/* 3423 */     return GrcInterface.asyncReportCorpsPointRace(context);
/*      */   }
/*      */   
/*      */   static void onReportCorpsPointRaceDone(int retcode, Octets context)
/*      */   {
/* 3428 */     ReportCorpsPointRaceDone event = new ReportCorpsPointRaceDone();
/* 3429 */     ReportCorpsPointRaceDoneArg arg = new ReportCorpsPointRaceDoneArg(retcode, context);
/* 3430 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*      */   }
/*      */   
/*      */   static boolean notifyPointRaceEnd(int activityCfgid, int zone, int timePointCfgid)
/*      */   {
/*      */     try
/*      */     {
/* 3437 */       DataTransferReq req = new DataTransferReq();
/* 3438 */       req.direction = 5;
/* 3439 */       req.data_type = 310;
/* 3440 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3441 */       req.dst_id = crossBattlePointMatcherid;
/*      */       
/* 3443 */       PointRaceEndReq reqData = new PointRaceEndReq();
/* 3444 */       reqData.activity_cfgid = activityCfgid;
/* 3445 */       reqData.zone = zone;
/* 3446 */       reqData.time_point_cfgid = timePointCfgid;
/*      */       
/* 3448 */       OctetsStream os = new OctetsStream();
/* 3449 */       os.marshal(reqData);
/* 3450 */       req.data = os;
/*      */       
/*      */ 
/* 3453 */       if (!GHubHelper.sendDataTransferReq(req, true, 3))
/*      */       {
/* 3455 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.notifyPointRaceEnd@notify point race end failed|activity_cfgid=%d|zone=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone), Integer.valueOf(timePointCfgid) }));
/*      */         
/*      */ 
/*      */ 
/* 3459 */         return false;
/*      */       }
/*      */       
/* 3462 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3466 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.notifyPointRaceEnd@notify point race end error|activity_cfgid=%d|zone=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone), Integer.valueOf(timePointCfgid) }), e);
/*      */     }
/*      */     
/*      */ 
/* 3470 */     return false;
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
/*      */   static boolean asyncGetZonePointRace(int activityCfgid, int zone, Octets context)
/*      */   {
/* 3484 */     return GrcInterface.asyncGetZonePointRace(activityCfgid, zone, context);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetZonePointRaceDone(int retcode, int activityCfgid, int zone, Octets context, List<CorpsPointRaceInfo> corpsPointRaceInfos)
/*      */   {
/* 3490 */     List<CorpsPointRaceInfo> data = corpsPointRaceInfos == null ? null : new ArrayList(corpsPointRaceInfos);
/*      */     
/*      */ 
/* 3493 */     mzm.gsp.crossserver.event.GetZonePointRaceDone event = new mzm.gsp.crossserver.event.GetZonePointRaceDone();
/* 3494 */     mzm.gsp.crossserver.event.GetZonePointRaceDoneArg arg = new mzm.gsp.crossserver.event.GetZonePointRaceDoneArg(retcode, activityCfgid, zone, context, data);
/* 3495 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
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
/*      */   static boolean asyncRemovePointRace(int activityCfgid, int zone, int timePointCfgid, Octets context)
/*      */   {
/* 3509 */     return GrcInterface.asyncRemovePointRace(activityCfgid, zone, timePointCfgid, context);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onRemovePointRaceDone(int retcode, int activityCfgid, int zone, int timePointCfgid, Octets context)
/*      */   {
/* 3515 */     mzm.gsp.crossserver.event.RemovePointRaceDoneArg arg = new mzm.gsp.crossserver.event.RemovePointRaceDoneArg(retcode, activityCfgid, zone, timePointCfgid, context);
/* 3516 */     RemovePointRaceDone event = new RemovePointRaceDone();
/* 3517 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
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
/*      */   static void removeSelectionFinalContext(long contextid)
/*      */   {
/* 3530 */     KnockOutContextManager.getInstance().removeContext(contextid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean notifyKnockOutFightBegin(long corpsId, int ownZoneId, int fightType, int fightStage, int fightIndexId, long fightRecordId)
/*      */   {
/* 3539 */     StringBuilder contextBuilder = new StringBuilder();
/* 3540 */     contextBuilder.append("|own_zone_id=").append(ownZoneId);
/* 3541 */     contextBuilder.append("|fight_type=").append(fightType);
/* 3542 */     contextBuilder.append("|fight_stage=").append(fightStage);
/* 3543 */     contextBuilder.append("|fight_index_id=").append(fightIndexId);
/* 3544 */     contextBuilder.append("|corps_id=").append(corpsId);
/* 3545 */     contextBuilder.append("|fight_record_id=").append(fightRecordId);
/*      */     
/* 3547 */     DataTransferReq req = new DataTransferReq();
/* 3548 */     req.direction = 0;
/* 3549 */     req.data_type = 207;
/* 3550 */     req.src_id = GameServerInfoManager.getZoneId();
/* 3551 */     req.dst_id = ownZoneId;
/*      */     
/* 3553 */     SelectionOrFinalFightBeginReq reqData = new SelectionOrFinalFightBeginReq();
/*      */     
/* 3555 */     reqData.fight_type = fightType;
/* 3556 */     reqData.fight_index_id = fightIndexId;
/* 3557 */     reqData.fight_stage = fightStage;
/* 3558 */     reqData.corps_id = corpsId;
/* 3559 */     reqData.fight_record_id = fightRecordId;
/*      */     
/*      */ 
/* 3562 */     OctetsStream os = new OctetsStream();
/* 3563 */     os.marshal(reqData);
/* 3564 */     req.data = os;
/*      */     
/*      */ 
/* 3567 */     if (!GHubHelper.sendDataTransferReq(req, true, 20))
/*      */     {
/* 3569 */       StringBuilder sBuilder = new StringBuilder();
/* 3570 */       sBuilder.append("[crossserver_knockout]CrossServerManager.notifyKnockOutFightBegin@notify knock out fight begin failed");
/* 3571 */       sBuilder.append("|context_builder=").append(contextBuilder);
/*      */       
/* 3573 */       GameServer.logger().info(sBuilder.toString());
/*      */       
/* 3575 */       Xdb.executor().schedule(new RReportFightKnockOutBeginRepeat(ownZoneId, fightType, fightStage, fightIndexId, corpsId, fightRecordId, 1), 60000L, TimeUnit.MILLISECONDS);
/*      */       
/*      */ 
/*      */ 
/* 3579 */       return false;
/*      */     }
/*      */     
/* 3582 */     StringBuilder sBuilder = new StringBuilder();
/* 3583 */     sBuilder.append("[crossserver_knockout]CrossServerManager.notifyKnockOutFightBegin@notify knock out fight begin success");
/* 3584 */     sBuilder.append("|context_builder=").append(contextBuilder.toString());
/*      */     
/* 3586 */     GameServer.logger().info(sBuilder.toString());
/*      */     
/* 3588 */     return true;
/*      */   }
/*      */   
/*      */   private static class RReportFightKnockOutBeginRepeat
/*      */     implements Runnable
/*      */   {
/*      */     private final int ownZoneId;
/*      */     private final int fightType;
/*      */     private final int fightStage;
/*      */     private final int fightIndexId;
/*      */     private final long corpsId;
/*      */     private final long fightRecordId;
/*      */     private int repeatTimes;
/*      */     
/*      */     public RReportFightKnockOutBeginRepeat(int ownZoneId, int fightType, int fightStage, int fightIndexId, long corpsId, long fightRecordId, int repeatTimes)
/*      */     {
/* 3604 */       this.ownZoneId = ownZoneId;
/* 3605 */       this.fightType = fightType;
/* 3606 */       this.fightStage = fightStage;
/* 3607 */       this.fightIndexId = fightIndexId;
/* 3608 */       this.corpsId = corpsId;
/* 3609 */       this.fightRecordId = fightRecordId;
/* 3610 */       this.repeatTimes = repeatTimes;
/*      */     }
/*      */     
/*      */ 
/*      */     public void run()
/*      */     {
/* 3616 */       StringBuilder contextBuilder = new StringBuilder();
/* 3617 */       contextBuilder.append("|own_zone_id=").append(this.ownZoneId);
/* 3618 */       contextBuilder.append("|fight_type=").append(this.fightType);
/* 3619 */       contextBuilder.append("|fight_stage=").append(this.fightStage);
/* 3620 */       contextBuilder.append("|fight_index_id=").append(this.fightIndexId);
/* 3621 */       contextBuilder.append("|corps_id=").append(this.corpsId);
/* 3622 */       contextBuilder.append("|fight_record_id=").append(this.fightRecordId);
/* 3623 */       contextBuilder.append("|repeat_times=").append(this.repeatTimes);
/*      */       
/* 3625 */       DataTransferReq req = new DataTransferReq();
/* 3626 */       req.direction = 0;
/* 3627 */       req.data_type = 207;
/* 3628 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3629 */       req.dst_id = this.ownZoneId;
/*      */       
/* 3631 */       SelectionOrFinalFightBeginReq reqData = new SelectionOrFinalFightBeginReq();
/*      */       
/* 3633 */       reqData.fight_type = this.fightType;
/* 3634 */       reqData.fight_index_id = this.fightIndexId;
/* 3635 */       reqData.fight_stage = this.fightStage;
/* 3636 */       reqData.corps_id = this.corpsId;
/* 3637 */       reqData.fight_record_id = this.fightRecordId;
/*      */       
/* 3639 */       if (!GHubHelper.sendDataTransferReq(req, true, 20))
/*      */       {
/* 3641 */         StringBuilder sBuilder = new StringBuilder();
/* 3642 */         sBuilder.append("[crossbattle_knockout]CrossServerManager.RReportFightKnockOutBeginRepeat@send fail");
/* 3643 */         sBuilder.append("|context_builder=").append(contextBuilder.toString());
/*      */         
/* 3645 */         GameServer.logger().info(sBuilder.toString());
/*      */         
/* 3647 */         this.repeatTimes += 1;
/* 3648 */         Xdb.executor().schedule(this, 60000L, TimeUnit.MILLISECONDS);
/* 3649 */         return;
/*      */       }
/*      */       
/* 3652 */       StringBuilder sBuilder = new StringBuilder();
/* 3653 */       sBuilder.append("[crossbattle_knockout]CrossServerManager.RReportFightKnockOutBeginRepeat@send success");
/* 3654 */       sBuilder.append("|context_builder=").append(contextBuilder.toString());
/*      */       
/* 3656 */       GameServer.logger().info(sBuilder.toString());
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
/*      */   public static boolean confirmJoinSelectionFinalMatch(KnockOutContext context)
/*      */   {
/*      */     try
/*      */     {
/* 3673 */       DataTransferReq req = new DataTransferReq();
/* 3674 */       req.direction = 5;
/* 3675 */       req.data_type = 201;
/* 3676 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3677 */       req.dst_id = crossBattleKnockoutMatcherid;
/*      */       
/* 3679 */       hub.ConfirmJoinSelectionOrFinalMatchReq reqData = new hub.ConfirmJoinSelectionOrFinalMatchReq();
/* 3680 */       reqData.matcher_server_contextid = context.getMatcherServerContextid();
/* 3681 */       reqData.game_server_contextid = context.gameServerContextId;
/* 3682 */       reqData.fight_type = context.fightType;
/* 3683 */       reqData.fight_stage = context.fightStage;
/*      */       
/* 3685 */       OctetsStream os = new OctetsStream();
/* 3686 */       os.marshal(reqData);
/* 3687 */       req.data = os;
/*      */       
/* 3689 */       KnockOutConfirmJoinMatchTransferReqXidWrapper reqXidWrapper = new KnockOutConfirmJoinMatchTransferReqXidWrapper(req, context);
/*      */       
/*      */ 
/* 3692 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 3694 */         GameServer.logger().error(String.format("[crossserver_knockout]SelectionFinalManager.confirmJoinMatch@send confirm join match request failed|match_context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 3698 */         return false;
/*      */       }
/*      */       
/* 3701 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3705 */       GameServer.logger().error(String.format("[crossserver_knockout]SelectionFinalManager.confirmJoinMatch@send confirm join match request error|match_context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 3709 */     return false;
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
/*      */   static boolean joinSelectionFinalMatch(KnockOutContext context)
/*      */   {
/*      */     try
/*      */     {
/* 3725 */       DataTransferReq req = new DataTransferReq();
/* 3726 */       req.direction = 5;
/* 3727 */       req.data_type = 200;
/* 3728 */       req.src_id = GameServerInfoManager.getZoneId();
/* 3729 */       req.dst_id = crossBattleKnockoutMatcherid;
/*      */       
/* 3731 */       JoinCrossBattleSelectionOrFinalReq reqData = new JoinCrossBattleSelectionOrFinalReq();
/* 3732 */       reqData.game_server_contextid = context.gameServerContextId;
/* 3733 */       reqData.fight_type = context.fightType;
/* 3734 */       reqData.fight_index_id = context.fightIndexId;
/* 3735 */       reqData.fight_stage = context.fightStage;
/*      */       
/* 3737 */       for (KnockOutRoleInfo roleCrossBattleInfo : context.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*      */       {
/* 3739 */         reqData.cross_battle_team_info.cross_battle_role_info_list.add(roleCrossBattleInfo.getHubRoleCrossBattleInfo());
/*      */       }
/* 3741 */       reqData.cross_battle_team_info.corps_badge_id = context.crossBattleTeamInfo.getCorpsBadgeId();
/* 3742 */       reqData.cross_battle_team_info.corps_id = context.crossBattleTeamInfo.getCorpsId();
/* 3743 */       reqData.cross_battle_team_info.corps_name.setString(context.crossBattleTeamInfo.getCorpsName(), "UTF-8");
/* 3744 */       reqData.cross_battle_team_info.opponent_corps_id = context.crossBattleTeamInfo.getOpponentCorpsId();
/* 3745 */       reqData.cross_battle_team_info.phys_zone_id = GameServerInfoManager.getZoneId();
/*      */       
/* 3747 */       OctetsStream os = new OctetsStream();
/* 3748 */       os.marshal(reqData);
/* 3749 */       req.data = os;
/*      */       
/*      */ 
/* 3752 */       KnockOutJoinReqXidWrapper reqXidWrapper = new KnockOutJoinReqXidWrapper(req, context);
/* 3753 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 3755 */         GameServer.logger().error(String.format("[crossserver_knockout]CrossServerManager.joinSelectionFinalMatch@send join match request failed|match_context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 3759 */         return false;
/*      */       }
/*      */       
/* 3762 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 3766 */       GameServer.logger().error(String.format("[crossserver_knockout]CrossServerManager.joinSelectionFinalMatch@send join match request error|match_context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 3771 */     return false;
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
/*      */   static boolean treadFriendsCircle(long activeTreadRoleId, long beTrodRoleId, int beTrodRoleZoneId, boolean isCanGetMoreTreasureBox, boolean isAutoTread, long treadSerialId)
/*      */   {
/* 3793 */     FriendsCircleTreadReq reqData = new FriendsCircleTreadReq();
/* 3794 */     reqData.active_tread_role_id = activeTreadRoleId;
/* 3795 */     reqData.be_trod_role_id = beTrodRoleId;
/* 3796 */     reqData.is_can_get_more_treasure_box = (isCanGetMoreTreasureBox ? 1 : 0);
/* 3797 */     reqData.tread_serial_id = treadSerialId;
/* 3798 */     reqData.is_auto_tread = (isAutoTread ? 1 : 0);
/*      */     
/* 3800 */     DataTransferReq req = new DataTransferReq();
/* 3801 */     req.data_type = 501;
/* 3802 */     req.direction = 0;
/* 3803 */     req.dst_id = beTrodRoleZoneId;
/* 3804 */     req.src_id = GameServerInfoManager.getZoneId();
/* 3805 */     req.data = new OctetsStream().marshal(reqData);
/*      */     
/* 3807 */     FriendsCircleTreadTransferReqXidWrapper reqXidWrapper = new FriendsCircleTreadTransferReqXidWrapper(req);
/* 3808 */     if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */     {
/* 3810 */       new mzm.gsp.friendscircle.main.PCTreadFriendsCircle.PUnSetCrossServerTread(activeTreadRoleId).execute();
/*      */       
/* 3812 */       StringBuilder sBuilder = new StringBuilder();
/* 3813 */       sBuilder.append("[crosserver_firendscircle]CrossServerManager.treadFriendsCircle@send tread friends failed");
/* 3814 */       sBuilder.append("|be_troe_role_id=").append(beTrodRoleId);
/* 3815 */       sBuilder.append("|be_trod_zone_id=").append(beTrodRoleZoneId);
/* 3816 */       sBuilder.append("|active_tread_role_id=").append(activeTreadRoleId);
/* 3817 */       sBuilder.append("|tread_serial_id=").append(treadSerialId);
/*      */       
/* 3819 */       GameServer.logger().error(sBuilder.toString());
/*      */       
/* 3821 */       return false;
/*      */     }
/*      */     
/* 3824 */     return true;
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
/*      */   static boolean giveFriendsCircleGfit(long activeGiveRoleId, String activeGiveRoleName, long receiveRoleId, int receiveRoleZoneId, int giftItemCfgId, int giftGrade, int giftItemNum, int addPopularity, String giveGiftMessage, long giftSerialId)
/*      */     throws UnsupportedEncodingException
/*      */   {
/* 3849 */     FriendsCircleGiveGiftReq reqData = new FriendsCircleGiveGiftReq();
/* 3850 */     reqData.active_give_role_id = activeGiveRoleId;
/* 3851 */     reqData.active_give_role_name.setString(activeGiveRoleName, "UTF-8");
/* 3852 */     reqData.gift_grade = giftGrade;
/* 3853 */     reqData.gift_item_cfg_id = giftItemCfgId;
/* 3854 */     reqData.gift_item_num = giftItemNum;
/* 3855 */     reqData.give_gift_serial_id = giftSerialId;
/* 3856 */     reqData.receive_role_id = receiveRoleId;
/* 3857 */     reqData.add_popularity_value = addPopularity;
/* 3858 */     reqData.give_gift_message.setString(giveGiftMessage, "UTF-8");
/*      */     
/* 3860 */     DataTransferReq req = new DataTransferReq();
/* 3861 */     req.data_type = 500;
/* 3862 */     req.direction = 0;
/* 3863 */     req.dst_id = receiveRoleZoneId;
/* 3864 */     req.src_id = GameServerInfoManager.getZoneId();
/* 3865 */     req.data = new OctetsStream().marshal(reqData);
/*      */     
/* 3867 */     FriendsCircleGiveGiftTransferReqXidWrapper reqXidWrapper = new FriendsCircleGiveGiftTransferReqXidWrapper(req);
/* 3868 */     if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */     {
/* 3870 */       GameServer.logger().error(String.format("|", new Object[0]));
/*      */       
/* 3872 */       StringBuilder sBuilder = new StringBuilder();
/* 3873 */       sBuilder.append("[crosserver_firendscircle]CrossServerManager.treadFriendsCircle@send give gift friends failed");
/* 3874 */       sBuilder.append("|gift_grade=").append(giftGrade);
/* 3875 */       sBuilder.append("|gift_item_cfg_id=").append(giftItemCfgId);
/* 3876 */       sBuilder.append("|gift_item_num=").append(giftItemNum);
/* 3877 */       sBuilder.append("|gift_serial_id=").append(giftSerialId);
/* 3878 */       sBuilder.append("|receive_role_id=").append(receiveRoleId);
/*      */       
/* 3880 */       GameServer.logger().error(sBuilder.toString());
/*      */       
/* 3882 */       return false;
/*      */     }
/*      */     
/* 3885 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean deleteFriendsCircleGfitHistory(long activeGiveRoleId, long receiveRoleId, long giftSerialId, int receiveRoleZoneId)
/*      */   {
/* 3894 */     FriendsCircleDeleteGiveGiftHistoryReq reqData = new FriendsCircleDeleteGiveGiftHistoryReq(activeGiveRoleId, receiveRoleId, giftSerialId);
/*      */     
/*      */ 
/*      */ 
/* 3898 */     DataTransferReq req = new DataTransferReq();
/* 3899 */     req.data_type = 503;
/* 3900 */     req.direction = 0;
/* 3901 */     req.dst_id = receiveRoleZoneId;
/* 3902 */     req.src_id = GameServerInfoManager.getZoneId();
/* 3903 */     req.data = new OctetsStream().marshal(reqData);
/*      */     
/* 3905 */     FriendsCircleDeleteGiftHistoryTransferReqXidWrapper reqXidWrapper = new FriendsCircleDeleteGiftHistoryTransferReqXidWrapper(req);
/*      */     
/* 3907 */     if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */     {
/* 3909 */       GameServer.logger().error(String.format("|", new Object[0]));
/*      */       
/* 3911 */       StringBuilder sBuilder = new StringBuilder();
/* 3912 */       sBuilder.append("[crosserver_firendscircle]CrossServerManager.deleteFriendsCircleGfitHistory@send delete give gift history failed");
/* 3913 */       sBuilder.append("|active_give_role_id=").append(activeGiveRoleId);
/* 3914 */       sBuilder.append("|gift_serial_id=").append(giftSerialId);
/* 3915 */       sBuilder.append("|receive_role_id=").append(receiveRoleId);
/* 3916 */       sBuilder.append("|receive_role_zone_id=").append(receiveRoleZoneId);
/*      */       
/* 3918 */       GameServer.logger().error(sBuilder.toString());
/*      */       
/* 3920 */       return false;
/*      */     }
/*      */     
/* 3923 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean deleteFriendsCircleTreadHistory(long activeTreadRoleId, long beTrodRoleId, long treadSerialId, int receiveRoleZoneId)
/*      */   {
/* 3932 */     hub.FriendsCircleDeleteTreadHistoryReq reqData = new hub.FriendsCircleDeleteTreadHistoryReq(activeTreadRoleId, beTrodRoleId, treadSerialId);
/*      */     
/*      */ 
/* 3935 */     DataTransferReq req = new DataTransferReq();
/* 3936 */     req.data_type = 502;
/* 3937 */     req.direction = 0;
/* 3938 */     req.dst_id = receiveRoleZoneId;
/* 3939 */     req.src_id = GameServerInfoManager.getZoneId();
/* 3940 */     req.data = new OctetsStream().marshal(reqData);
/*      */     
/* 3942 */     FriendsCircleDeleteTreadHistoryTransferReqXidWrapper reqXidWrapper = new FriendsCircleDeleteTreadHistoryTransferReqXidWrapper(req);
/*      */     
/* 3944 */     if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */     {
/* 3946 */       GameServer.logger().error(String.format("|", new Object[0]));
/*      */       
/* 3948 */       StringBuilder sBuilder = new StringBuilder();
/* 3949 */       sBuilder.append("[crosserver_firendscircle]CrossServerManager.deleteFriendsCircleTreadHistory@send delete tread history failed");
/* 3950 */       sBuilder.append("|active_tread_role_id=").append(activeTreadRoleId);
/* 3951 */       sBuilder.append("|be_trod_role_id=").append(beTrodRoleId);
/* 3952 */       sBuilder.append("|tread_serial_id=").append(treadSerialId);
/* 3953 */       sBuilder.append("|receive_role_zone_id=").append(receiveRoleZoneId);
/*      */       
/* 3955 */       GameServer.logger().error(sBuilder.toString());
/*      */       
/* 3957 */       return false;
/*      */     }
/*      */     
/* 3960 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean operatorFriendsCircleBlacklist(long activeRoleId, long blackRoleId, int blackRoleZoneId, int operator)
/*      */   {
/* 3966 */     hub.FriendsCircleOperatorBlackReq reqData = new hub.FriendsCircleOperatorBlackReq(activeRoleId, blackRoleId, operator);
/*      */     
/* 3968 */     DataTransferReq req = new DataTransferReq();
/* 3969 */     req.data_type = 504;
/* 3970 */     req.direction = 0;
/* 3971 */     req.dst_id = blackRoleZoneId;
/* 3972 */     req.src_id = GameServerInfoManager.getZoneId();
/* 3973 */     req.data = new OctetsStream().marshal(reqData);
/*      */     
/* 3975 */     FriendsCircleOperatorBlacklistTransferReqXidWrapper reqXidWrapper = new FriendsCircleOperatorBlacklistTransferReqXidWrapper(req);
/*      */     
/* 3977 */     if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */     {
/* 3979 */       GameServer.logger().error(String.format("|", new Object[0]));
/*      */       
/* 3981 */       StringBuilder sBuilder = new StringBuilder();
/* 3982 */       sBuilder.append("[crosserver_firendscircle]CrossServerManager.operatorFriendsCircleBlacklist@send operator friends circle black list failed");
/* 3983 */       sBuilder.append("|active_role_id=").append(activeRoleId);
/* 3984 */       sBuilder.append("|black_role_id=").append(blackRoleId);
/* 3985 */       sBuilder.append("|black_role_zone_id=").append(blackRoleZoneId);
/* 3986 */       sBuilder.append("|operator=").append(operator);
/*      */       
/* 3988 */       GameServer.logger().error(sBuilder.toString());
/*      */       
/* 3990 */       return false;
/*      */     }
/*      */     
/* 3993 */     return true;
/*      */   }
/*      */   
/*      */   static class RRepeateFriendsCircle
/*      */     extends mzm.gsp.util.LogicRunnable
/*      */   {
/*      */     private final DataTransferReqXidWrapper reqXidWrapper;
/* 4000 */     private int repeatTimes = 0;
/*      */     
/*      */     public RRepeateFriendsCircle(DataTransferReqXidWrapper reqXidWrapper)
/*      */     {
/* 4004 */       this.reqXidWrapper = reqXidWrapper;
/*      */     }
/*      */     
/*      */     public void process()
/*      */       throws Exception
/*      */     {
/* 4010 */       if (!GHubHelper.sendDataTransferReq(this.reqXidWrapper, false))
/*      */       {
/* 4012 */         StringBuilder sBuilder = new StringBuilder();
/* 4013 */         sBuilder.append("[crosserver_firendscircle]CrossServerManager.RRepeateFriendsCircle.process@send send friends circle cross server message failed");
/* 4014 */         sBuilder.append("|repeat_times=").append(this.repeatTimes);
/* 4015 */         sBuilder.append("|req_type=").append(this.reqXidWrapper.getProtocol().data_type);
/*      */         
/* 4017 */         GameServer.logger().error(sBuilder.toString());
/* 4018 */         this.repeatTimes += 1;
/* 4019 */         if (this.repeatTimes < 2)
/*      */         {
/* 4021 */           Xdb.executor().schedule(this, 60000L, TimeUnit.MILLISECONDS);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setRoamServerDateForGM(int roamZoneid, String dateValue)
/*      */   {
/* 4032 */     if (roamZoneid <= 0)
/*      */     {
/* 4034 */       DataBroadcast broadcast = new DataBroadcast();
/* 4035 */       broadcast.direction = 0;
/* 4036 */       broadcast.src_id = GameServerInfoManager.getZoneId();
/* 4037 */       broadcast.data_type = 5;
/*      */       
/* 4039 */       NotifyModifyRoamServerDate modifyRoamServerDate = new NotifyModifyRoamServerDate();
/*      */       try
/*      */       {
/* 4042 */         modifyRoamServerDate.date_args.setString(dateValue, "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e) {}
/*      */       
/*      */ 
/*      */ 
/* 4048 */       broadcast.data = new OctetsStream().marshal(modifyRoamServerDate);
/* 4049 */       GHubHelper.broadcast(broadcast);
/*      */       
/* 4051 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 4055 */     DataTransferReq req = new DataTransferReq();
/* 4056 */     req.direction = 0;
/* 4057 */     req.data_type = 15;
/* 4058 */     req.src_id = GameServerInfoManager.getZoneId();
/* 4059 */     req.dst_id = roamZoneid;
/* 4060 */     ModifyRoamServerDateReq reqData = new ModifyRoamServerDateReq();
/*      */     try
/*      */     {
/* 4063 */       reqData.date_args.setString(dateValue, "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/* 4069 */     req.data = new OctetsStream().marshal(reqData);
/* 4070 */     if (!GHubHelper.sendDataTransferReq(req, false))
/*      */     {
/* 4072 */       GameServer.logger().error(String.format("[crossserver]CrossServerInterface.setRoamServerDateForGM@send modify roam server date failed|date_value=%s|roam_zoneid=%d", new Object[] { dateValue, Integer.valueOf(roamZoneid) }));
/*      */       
/*      */ 
/*      */ 
/* 4076 */       return false;
/*      */     }
/*      */     
/* 4079 */     return true;
/*      */   }
/*      */   
/*      */   static boolean setServerDateForGM(String dateValue)
/*      */   {
/* 4084 */     DataBroadcast broadcast = new DataBroadcast();
/* 4085 */     broadcast.direction = 0;
/* 4086 */     broadcast.src_id = GameServerInfoManager.getZoneId();
/* 4087 */     broadcast.data_type = 8;
/*      */     
/* 4089 */     NotifyModifyServerDate modifyServerDate = new NotifyModifyServerDate();
/*      */     try
/*      */     {
/* 4092 */       modifyServerDate.date_args.setString(dateValue, "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/* 4098 */     broadcast.data = new OctetsStream().marshal(modifyServerDate);
/* 4099 */     GHubHelper.broadcast(broadcast);
/*      */     
/* 4101 */     return true;
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
/*      */   static boolean joinSingleCrossFieldMatch(SingleCrossFieldContext context)
/*      */   {
/*      */     try
/*      */     {
/* 4116 */       DataTransferReq req = new DataTransferReq();
/* 4117 */       req.direction = 5;
/* 4118 */       req.data_type = 400;
/* 4119 */       req.src_id = GameServerInfoManager.getZoneId();
/* 4120 */       req.dst_id = singleCrossFieldMatcherid;
/*      */       
/* 4122 */       SingleCrossFieldJoinMatchReq reqData = new SingleCrossFieldJoinMatchReq();
/* 4123 */       reqData.game_server_contextid = context.getContextid();
/* 4124 */       reqData.activity_cfg_id = context.getActivityCfgid();
/* 4125 */       reqData.field_role_num = context.getFieldRoleNum();
/* 4126 */       context.getCrossFieldRoamRoleInfo().fillHubSingleCrossFieldRoleMatchInfo(reqData.role_info);
/* 4127 */       OctetsStream os = new OctetsStream();
/* 4128 */       os.marshal(reqData);
/* 4129 */       req.data.replace(os);
/*      */       
/* 4131 */       SingleCrossFieldJoinMatchReqXidWrapper reqXidWrapper = new SingleCrossFieldJoinMatchReqXidWrapper(req, context);
/*      */       
/* 4133 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 4135 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.joinSingleCrossFieldMatch@send single cross field join match req fail|context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 4139 */         return false;
/*      */       }
/* 4141 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 4145 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.joinSingleCrossFieldMatch@send single cross field join match req error|context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 4149 */     return false;
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
/*      */   static boolean confirmJoinSingleCrossFieldMatch(SingleCrossFieldContext context)
/*      */   {
/*      */     try
/*      */     {
/* 4165 */       DataTransferReq req = new DataTransferReq();
/* 4166 */       req.direction = 5;
/* 4167 */       req.data_type = 401;
/* 4168 */       req.src_id = GameServerInfoManager.getZoneId();
/* 4169 */       req.dst_id = singleCrossFieldMatcherid;
/*      */       
/* 4171 */       hub.SingleCrossFieldConfirmJoinMatchReq reqData = new hub.SingleCrossFieldConfirmJoinMatchReq();
/* 4172 */       reqData.game_server_contextid = context.getContextid();
/* 4173 */       reqData.activity_cfg_id = context.getActivityCfgid();
/* 4174 */       reqData.field_role_num = context.getFieldRoleNum();
/* 4175 */       reqData.matcher_server_contextid = context.getMatcherServerContextid();
/* 4176 */       OctetsStream os = new OctetsStream();
/* 4177 */       os.marshal(reqData);
/* 4178 */       req.data.replace(os);
/*      */       
/* 4180 */       SingleCrossFieldComfirmJoinMatchReqXidWrapper reqXidWrapper = new SingleCrossFieldComfirmJoinMatchReqXidWrapper(req, context);
/*      */       
/*      */ 
/* 4183 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 4185 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.confirmJoinSingleCrossFieldMatch@send single cross field confirm join match req fail|context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 4189 */         return false;
/*      */       }
/* 4191 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 4195 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.confirmJoinCrossFieldMatch@send single cross field confirm join match req error|context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 4199 */     return false;
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
/*      */   static boolean cancelSingleCrossFieldMatch(SingleCrossFieldContext context)
/*      */   {
/*      */     try
/*      */     {
/* 4215 */       DataTransferReq req = new DataTransferReq();
/* 4216 */       req.direction = 5;
/* 4217 */       req.data_type = 404;
/* 4218 */       req.src_id = GameServerInfoManager.getZoneId();
/* 4219 */       req.dst_id = singleCrossFieldMatcherid;
/*      */       
/* 4221 */       hub.SingleCrossFieldCancelMatchReq reqData = new hub.SingleCrossFieldCancelMatchReq();
/* 4222 */       reqData.game_server_contextid = context.getContextid();
/* 4223 */       reqData.matcher_server_contextid = context.getMatcherServerContextid();
/* 4224 */       OctetsStream os = new OctetsStream();
/* 4225 */       os.marshal(reqData);
/* 4226 */       req.data.replace(os);
/*      */       
/* 4228 */       SingleCrossFieldCancelMatchReqXidWrapper reqXidWrapper = new SingleCrossFieldCancelMatchReqXidWrapper(req, context);
/*      */       
/* 4230 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 4232 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.cancelSingleCrossFieldMatch@send single cross field cancel match req fail|context=%s", new Object[] { context }));
/*      */         
/*      */ 
/*      */ 
/* 4236 */         return false;
/*      */       }
/* 4238 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 4242 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.cancelSingleCrossFieldMatch@send single cross field cancel match req error|context=%s", new Object[] { context }), e);
/*      */     }
/*      */     
/*      */ 
/* 4246 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeSingleCrossFieldContext(long contextid)
/*      */   {
/* 4257 */     SingleCrossFieldContextManager.getInstance().removeContext(contextid);
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
/*      */   static boolean transferChatContent(int destZoneid, long roleid, int channel, long orgKey, Octets chatContent)
/*      */   {
/*      */     try
/*      */     {
/* 4275 */       DataTransferReq req = new DataTransferReq();
/* 4276 */       req.direction = 0;
/* 4277 */       req.data_type = 16;
/* 4278 */       req.src_id = GameServerInfoManager.getZoneId();
/* 4279 */       req.dst_id = destZoneid;
/*      */       
/* 4281 */       TransferChatContentReq reqData = new TransferChatContentReq();
/* 4282 */       reqData.roleid = roleid;
/* 4283 */       reqData.channel = channel;
/* 4284 */       reqData.org_key = orgKey;
/* 4285 */       reqData.chat_content.replace(chatContent);
/* 4286 */       OctetsStream os = new OctetsStream();
/* 4287 */       os.marshal(reqData);
/* 4288 */       req.data.replace(os);
/*      */       
/* 4290 */       TransferChatContentReqXidWrapper reqXidWrapper = new TransferChatContentReqXidWrapper(req, roleid, channel, orgKey, chatContent);
/*      */       
/* 4292 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*      */       {
/* 4294 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.transferChatContent@send transfer chat content req fail|roleid=%d|channel=%d|org_key=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(channel), Long.valueOf(orgKey) }));
/*      */         
/*      */ 
/*      */ 
/* 4298 */         return false;
/*      */       }
/* 4300 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 4304 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.transferChatContent@send transfer chat content req error|roleid=%d|channel=%d|org_key=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(channel), Long.valueOf(orgKey) }), e);
/*      */     }
/*      */     
/*      */ 
/* 4308 */     return false;
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
/*      */   static boolean notifyBindFriend(int destZoneid, String userid, long roleid, RecallNotifyBindFriendReq reqData)
/*      */   {
/*      */     try
/*      */     {
/* 4326 */       int zoneid = GameServerInfoManager.getZoneId();
/* 4327 */       DataTransferReq req = new DataTransferReq();
/* 4328 */       req.direction = 0;
/* 4329 */       req.data_type = 600;
/* 4330 */       req.src_id = zoneid;
/* 4331 */       req.dst_id = destZoneid;
/*      */       
/* 4333 */       OctetsStream os = new OctetsStream();
/* 4334 */       os.marshal(reqData);
/* 4335 */       req.data = os;
/*      */       
/* 4337 */       NotifyBindFriendTransferReqXidWrapper reqXidWrapper = new NotifyBindFriendTransferReqXidWrapper(req, userid, roleid);
/*      */       
/* 4339 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, true, 3))
/*      */       {
/* 4341 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.notifyBindFriend@send request failed|userid=%s|roleid=%d|friend_roleid=%d|friend_zoneid=%d", new Object[] { userid, Long.valueOf(roleid), Long.valueOf(reqData.roleid), Integer.valueOf(destZoneid) }));
/*      */         
/*      */ 
/*      */ 
/* 4345 */         return false;
/*      */       }
/*      */       
/* 4348 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 4352 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.notifyBindFriend@send request error|userid=%s|roleid=%d|friend_roleid=%d|friend_zoneid=%d", new Object[] { userid, Long.valueOf(roleid), Long.valueOf(reqData.roleid), Integer.valueOf(destZoneid) }), e);
/*      */     }
/*      */     
/*      */ 
/* 4356 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void broadcastIndianaAwardRoleInfo(NotifyIndianaAwardRoleInfo data)
/*      */   {
/* 4367 */     DataBroadcast dataBroadcast = new DataBroadcast();
/* 4368 */     dataBroadcast.direction = 0;
/* 4369 */     dataBroadcast.src_id = GameServerInfoManager.getZoneId();
/* 4370 */     dataBroadcast.data_type = 6;
/* 4371 */     dataBroadcast.data.replace(data.marshal(new OctetsStream()));
/* 4372 */     GHubHelper.broadcast(dataBroadcast);
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
/*      */   static boolean reportAllLottoCandidateInfo(int activityCfgid, int turn, long roleid, String roleName, int occupation, int gender, int level, int avatarid, int avatarFrameid)
/*      */   {
/*      */     try
/*      */     {
/* 4404 */       DataTransferReq req = new DataTransferReq();
/* 4405 */       req.direction = 5;
/* 4406 */       req.data_type = 700;
/* 4407 */       req.src_id = GameServerInfoManager.getZoneId();
/* 4408 */       req.dst_id = allLottoMatcherid;
/*      */       
/* 4410 */       AllLottoReportCandidateInfoReq reqData = new AllLottoReportCandidateInfoReq();
/* 4411 */       reqData.zoneids.addAll(GameServerInfoManager.getZoneIds());
/* 4412 */       reqData.activity_cfg_id = activityCfgid;
/* 4413 */       reqData.turn = turn;
/* 4414 */       reqData.candidate_info.roleid = roleid;
/* 4415 */       reqData.candidate_info.role_name.setString(roleName, "UTF-8");
/* 4416 */       reqData.candidate_info.occupation = occupation;
/* 4417 */       reqData.candidate_info.gender = gender;
/* 4418 */       reqData.candidate_info.level = level;
/* 4419 */       reqData.candidate_info.avatarid = avatarid;
/* 4420 */       reqData.candidate_info.avatar_frameid = avatarFrameid;
/* 4421 */       OctetsStream os = new OctetsStream();
/* 4422 */       os.marshal(reqData);
/* 4423 */       req.data.replace(os);
/*      */       
/* 4425 */       AllLottoReportCandidateInfoReqXidWrapper reqXidWrapper = new AllLottoReportCandidateInfoReqXidWrapper(req, activityCfgid, turn, roleid, roleName, occupation, gender, level, avatarid, avatarFrameid);
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
/* 4436 */       if (!GHubHelper.sendDataTransferReq(reqXidWrapper, true, 5))
/*      */       {
/* 4438 */         GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportAllLottoCandidateInfo@report all lotto candidate info req fail|activity_cfg_id=%d|turn=%d|roleid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(turn), Long.valueOf(roleid) }));
/*      */         
/*      */ 
/*      */ 
/* 4442 */         return false;
/*      */       }
/* 4444 */       return true;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 4448 */       GameServer.logger().error(String.format("[crossserver]CrossServerManager.reportAllLottoCandidateInfo@report all lotto candidate info req error|activity_cfg_id=%d|turn=%d|roleid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(turn), Long.valueOf(roleid) }), e);
/*      */     }
/*      */     
/*      */ 
/* 4452 */     return false;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\CrossServerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */