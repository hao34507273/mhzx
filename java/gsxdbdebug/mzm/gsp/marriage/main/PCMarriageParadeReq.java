/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.SMarrigeParadeSuc;
/*     */ import mzm.gsp.marriage.SSynFriendParadeMsg;
/*     */ import mzm.gsp.marriage.confbean.ParadeNumCfg;
/*     */ import mzm.gsp.marriage.confbean.SMarriageParadeCfg;
/*     */ import mzm.gsp.marriage.confbean.SMarriageParadeConsts;
/*     */ import mzm.gsp.marriage.confbean.SParadeControlCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarriageParade;
/*     */ import xbean.MarriageParades;
/*     */ import xbean.Pod;
/*     */ import xdb.Executor;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Marriageparade;
/*     */ import xtable.Role2team;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMarriageParadeReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int paradeCfgid;
/*     */   
/*     */   public PCMarriageParadeReq(long roleid, int paradecfgid)
/*     */   {
/*  47 */     this.roleid = roleid;
/*  48 */     this.paradeCfgid = paradecfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  53 */     if ((!OpenInterface.getOpenStatus(128)) || (OpenInterface.isBanPlay(this.roleid, 128)))
/*     */     {
/*  55 */       OpenInterface.sendBanPlayMsg(this.roleid, 128);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (!MapInterface.isNearByNPC(this.roleid, SMarriageParadeConsts.getInstance().paradeNPC)) {
/*  60 */       GameServer.logger().info(String.format("[Marriage]PCMarriageParadeReq.processImp@far from npc|roleid=%d|npcid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SMarriageParadeConsts.getInstance().paradeNPC) }));
/*     */       
/*     */ 
/*  63 */       return false;
/*     */     }
/*  65 */     SMarriageParadeCfg marriageParadeCfg = SMarriageParadeCfg.get(this.paradeCfgid);
/*  66 */     if (marriageParadeCfg == null) {
/*  67 */       GameServer.logger().info(String.format("[Marriage]PCMarriageParadeReq.processImp@do not exist SMarriageParadeCfg|id=%d", new Object[] { Integer.valueOf(this.paradeCfgid) }));
/*     */       
/*     */ 
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     List<Long> normalList = TeamInterface.getNormalRoleList(this.roleid);
/*  74 */     if (normalList.size() != 2) {
/*  75 */       MarriageManager.sendNormalResult(this.roleid, 120, new String[0]);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     List<String> userids = new ArrayList();
/*  80 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  81 */       userids.add(RoleInterface.getUserId(roleid));
/*     */     }
/*     */     
/*  84 */     lock(User.getTable(), userids);
/*     */     
/*  86 */     lock(Role2team.getTable(), normalList);
/*  87 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleid, true);
/*     */     
/*  89 */     lock(Team.getTable(), Arrays.asList(new Long[] { teamId }));
/*     */     
/*  91 */     long localId = GameServerInfoManager.getLocalId();
/*     */     
/*  93 */     MarriageParades xMarriageParades = Marriageparade.get(Long.valueOf(localId));
/*  94 */     boolean ret = checkCanParade(this.roleid, teamId, userids, normalList, xMarriageParades, marriageParadeCfg);
/*  95 */     if (!ret) {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     SParadeControlCfg sparadeControlCfg = SParadeControlCfg.get(this.paradeCfgid);
/* 100 */     ParadeNumCfg paradeNumCfg = (ParadeNumCfg)sparadeControlCfg.num2CfgMap.get(Integer.valueOf(1));
/* 101 */     MapInterface.transferToScene(this.roleid, marriageParadeCfg.paradeMapid, paradeNumCfg.x, paradeNumCfg.y, new MarriageParadeTransforCallBack(this.roleid, this.paradeCfgid));
/*     */     
/* 103 */     return true;
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
/*     */   static boolean checkCanParade(long roleid, Long teamId, List<String> userids, List<Long> normalList, MarriageParades xMarriageParades, SMarriageParadeCfg marriageParadeCfg)
/*     */   {
/* 118 */     if (teamId == null) {
/* 119 */       MarriageManager.sendNormalResult(roleid, 120, new String[0]);
/* 120 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 124 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 125 */     if ((teamInfo == null) || (teamInfo.getTeamMemberList().size() != normalList.size()) || (!teamInfo.getTeamMemberList().containsAll(normalList)))
/*     */     {
/* 127 */       MarriageManager.sendNormalResult(roleid, 120, new String[0]);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     long roleid1 = ((Long)normalList.get(0)).longValue();
/* 132 */     long roleid2 = ((Long)normalList.get(1)).longValue();
/* 133 */     if (roleid1 != roleid) {
/* 134 */       MarriageManager.sendNormalResult(roleid, 120, new String[0]);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     if (!MarriageInterface.isMarriageRelation(roleid1, roleid2)) {
/* 139 */       GameServer.logger().info(String.format("[Marriage]PCMarriageParadeReq.processImp@role1 and role2  are not married|roleid1=%d|roleid2=%d", new Object[] { Long.valueOf(roleid1), Long.valueOf(roleid2) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 146 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 150 */     if (RoleStatusInterface.getStatusSet(roleid1).contains(Integer.valueOf(29))) {
/* 151 */       GameServer.logger().info(String.format("[Marriage]PCMarriageParadeReq.processImp@role is in marriage parade status|roleid=%d", new Object[] { Long.valueOf(roleid1) }));
/*     */       
/*     */ 
/*     */ 
/* 155 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 159 */     if (RoleStatusInterface.getStatusSet(roleid2).contains(Integer.valueOf(29))) {
/* 160 */       GameServer.logger().info(String.format("[Marriage]PCMarriageParadeReq.processImp@role is in marriage parade status|roleid=%d", new Object[] { Long.valueOf(roleid2) }));
/*     */       
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     if (!RoleStatusInterface.checkCansetStatus(normalList, 29, false)) {
/* 168 */       MarriageManager.sendNormalResult(roleid, 120, new String[0]);
/* 169 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 173 */     if ((xMarriageParades != null) && (xMarriageParades.getMarriageparades().size() > 0)) {
/* 174 */       MarriageManager.sendNormalResult(roleid, 121, new String[0]);
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     long yuanbao = QingfuInterface.getBalance((String)userids.get(0), true);
/* 179 */     if (yuanbao < marriageParadeCfg.yuanBaoNum) {
/* 180 */       GameServer.logger().info(String.format("[Marriage]PCMarriageParadeReq.processImp@yuanbao not enough|roleid=%d|yuanbao=%d|needYuanbao=%d", new Object[] { Long.valueOf(roleid1), Long.valueOf(yuanbao), Integer.valueOf(marriageParadeCfg.yuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 187 */       return false;
/*     */     }
/* 189 */     return true;
/*     */   }
/*     */   
/*     */   private static final class MarriageParadeTransforCallBack implements mzm.gsp.map.main.MapCallback<Boolean>
/*     */   {
/*     */     private final long roleid;
/*     */     private final int paradeCfgid;
/*     */     
/*     */     public MarriageParadeTransforCallBack(long roleid, int paradeCfgid) {
/* 198 */       this.roleid = roleid;
/* 199 */       this.paradeCfgid = paradeCfgid;
/*     */     }
/*     */     
/*     */     public boolean isCallInProcedure()
/*     */     {
/* 204 */       return true;
/*     */     }
/*     */     
/*     */     public boolean onResult(Boolean result)
/*     */     {
/* 209 */       if ((result == null) || (!result.booleanValue())) {
/* 210 */         return false;
/*     */       }
/* 212 */       final SMarriageParadeCfg marriageParadeCfg = SMarriageParadeCfg.get(this.paradeCfgid);
/* 213 */       if (marriageParadeCfg == null) {
/* 214 */         GameServer.logger().info(String.format("[Marriage]PCMarriageParadeReq.processImp@do not exist SMarriageParadeCfg|id=%d", new Object[] { Integer.valueOf(this.paradeCfgid) }));
/*     */         
/*     */ 
/* 217 */         return false;
/*     */       }
/*     */       
/* 220 */       List<Long> normalList = TeamInterface.getNormalRoleList(this.roleid);
/* 221 */       if (normalList.size() != 2) {
/* 222 */         MarriageManager.sendNormalResult(this.roleid, 120, new String[0]);
/* 223 */         return false;
/*     */       }
/*     */       
/* 226 */       final long roleid1 = ((Long)normalList.get(0)).longValue();
/* 227 */       long roleid2 = ((Long)normalList.get(1)).longValue();
/*     */       
/* 229 */       List<String> userids = new ArrayList();
/* 230 */       for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 231 */         userids.add(RoleInterface.getUserId(roleid));
/*     */       }
/*     */       
/* 234 */       Lockeys.lock(User.getTable(), userids);
/*     */       
/* 236 */       Lockeys.lock(Role2team.getTable(), normalList);
/* 237 */       Long teamId = TeamInterface.getTeamidByRoleid(this.roleid, true);
/*     */       
/* 239 */       Lockeys.lock(Team.getTable(), Arrays.asList(new Long[] { teamId }));
/*     */       
/* 241 */       long localId = GameServerInfoManager.getLocalId();
/*     */       
/* 243 */       MarriageParades xMarriageParades = Marriageparade.get(Long.valueOf(localId));
/* 244 */       boolean ret = PCMarriageParadeReq.checkCanParade(this.roleid, teamId, userids, normalList, xMarriageParades, marriageParadeCfg);
/* 245 */       if (!ret) {
/* 246 */         return false;
/*     */       }
/*     */       
/* 249 */       boolean suc = QingfuInterface.costYuanbao((String)userids.get(0), this.roleid, marriageParadeCfg.yuanBaoNum, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_MARRIAGE_PARADE, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.MARRIAGE_PARADE_COST, this.paradeCfgid)) == mzm.gsp.qingfu.main.CostResult.Success;
/*     */       
/*     */ 
/* 252 */       if (!suc) {
/* 253 */         return false;
/*     */       }
/*     */       
/* 256 */       if (!RoleStatusInterface.setStatus(normalList, 29, false)) {
/* 257 */         MarriageManager.sendNormalResult(this.roleid, 120, new String[0]);
/* 258 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 262 */       boolean dismissTeam = TeamInterface.activeDismissTeamSyn(teamId.longValue());
/* 263 */       if (!dismissTeam) {
/* 264 */         GameServer.logger().info(String.format("[Marriage]PCMarriageParadeReq.processImp@dismissTeam false |roleid=%d|teamid=%d", new Object[] { Long.valueOf(roleid1), teamId }));
/*     */         
/*     */ 
/*     */ 
/* 268 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 272 */       if (xMarriageParades == null) {
/* 273 */         xMarriageParades = Pod.newMarriageParades();
/* 274 */         Marriageparade.insert(Long.valueOf(localId), xMarriageParades);
/*     */       }
/* 276 */       MarriageParade xMarriageParade = Pod.newMarriageParade();
/* 277 */       xMarriageParade.setRoleid1(roleid1);
/* 278 */       xMarriageParade.setRoleid2(roleid2);
/* 279 */       xMarriageParade.setLevel(this.paradeCfgid);
/* 280 */       xMarriageParade.setTimemil(DateTimeUtils.getCurrTimeInMillis());
/* 281 */       xMarriageParades.getMarriageparades().add(xMarriageParade);
/* 282 */       SMarrigeParadeSuc sMarrigeParadeSuc = new SMarrigeParadeSuc();
/* 283 */       sMarrigeParadeSuc.paradecfgid = this.paradeCfgid;
/* 284 */       OnlineManager.getInstance().sendMulti(sMarrigeParadeSuc, normalList);
/*     */       
/* 286 */       List<Integer> stopSeqs = MarriageManager.randomParadeControlCfg(this.paradeCfgid, marriageParadeCfg.stopMapItemCount, 1);
/*     */       
/* 288 */       xMarriageParade.getStoppointseqs().addAll(stopSeqs);
/*     */       
/* 290 */       List<Integer> giveMoneySeqs = MarriageManager.randomParadeControlCfg(this.paradeCfgid, marriageParadeCfg.giveMoneyCount, 1);
/*     */       
/* 292 */       xMarriageParade.getGivemoneypointseqs().addAll(giveMoneySeqs);
/*     */       
/* 294 */       List<Integer> robStops = MarriageManager.randomRobSeqsParadeControlCfg(this.paradeCfgid, 1, 1);
/* 295 */       xMarriageParade.getRobseqs().addAll(robStops);
/*     */       
/*     */ 
/* 298 */       SSynFriendParadeMsg synFriendParadeMsg = new SSynFriendParadeMsg();
/* 299 */       MarriageManager.fillInParadeRoleInfo(synFriendParadeMsg.myinfo, roleid1);
/* 300 */       MarriageManager.fillInParadeRoleInfo(synFriendParadeMsg.coupleinfo, roleid2);
/* 301 */       synFriendParadeMsg.paradecfgid = this.paradeCfgid;
/* 302 */       FriendInterface.broadCastMsgToFriendExceptRole(synFriendParadeMsg, roleid1, roleid2);
/*     */       
/* 304 */       SSynFriendParadeMsg synFriendParadeMsg2 = new SSynFriendParadeMsg();
/* 305 */       MarriageManager.fillInParadeRoleInfo(synFriendParadeMsg2.myinfo, roleid2);
/* 306 */       MarriageManager.fillInParadeRoleInfo(synFriendParadeMsg2.coupleinfo, roleid1);
/* 307 */       synFriendParadeMsg2.paradecfgid = this.paradeCfgid;
/* 308 */       FriendInterface.broadCastMsgToFriendExceptRole(synFriendParadeMsg2, roleid2, roleid1);
/*     */       
/* 310 */       boolean paradeRet = MarriageManager.startMarriageParade(xMarriageParade);
/* 311 */       if (paradeRet) {
/* 312 */         final long timeMil = xMarriageParade.getTimemil();
/*     */         
/* 314 */         if (marriageParadeCfg.notifyInGang > 0) {
/* 315 */           Xdb.executor().execute(new LogicRunnable()
/*     */           {
/*     */             public void process() throws Exception
/*     */             {
/* 319 */               new GangNotifySession(marriageParadeCfg.notifyInGang, PCMarriageParadeReq.MarriageParadeTransforCallBack.this.paradeCfgid, roleid1, timeMil, this.val$timeMil).notifyMsg();
/*     */             }
/*     */           });
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 326 */         if (marriageParadeCfg.notifyInWorld > 0) {
/* 327 */           Xdb.executor().execute(new LogicRunnable()
/*     */           {
/*     */             public void process() throws Exception
/*     */             {
/* 331 */               new WorldNotifyObserver(marriageParadeCfg.notifyInWorld, PCMarriageParadeReq.MarriageParadeTransforCallBack.this.paradeCfgid, roleid1, timeMil, this.val$timeMil).notifyMsg();
/*     */             }
/*     */           });
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 339 */         TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.marriage.event.MarryParade(), new mzm.gsp.marriage.event.MarryParadeArg(roleid1, roleid2));
/*     */       }
/* 341 */       return paradeRet;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCMarriageParadeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */