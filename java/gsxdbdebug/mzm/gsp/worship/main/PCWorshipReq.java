/*     */ package mzm.gsp.worship.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SWorShipCfg;
/*     */ import mzm.gsp.activity.confbean.WorShipConst;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.ModMoneyResult.ErrorResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.worship.SWorshipSucBro;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FactionWorshipInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleWorshipInfo;
/*     */ import xbean.SingleWorshipInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Basic;
/*     */ import xtable.Faction2worship;
/*     */ import xtable.Gang;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCWorshipReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int worshipId;
/*     */   private SWorShipCfg cfg;
/*  41 */   private int addValue = 0;
/*  42 */   private int contentIndex = 0;
/*     */   
/*     */   public PCWorshipReq(long roleId, int worshipId)
/*     */   {
/*  46 */     this.roleId = roleId;
/*  47 */     this.worshipId = worshipId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     if (!preCheck())
/*     */     {
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     long factionId = GangInterface.getGangId(this.roleId);
/*  60 */     if (factionId <= 0L)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.processImp@ not have faction!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     String userid = RoleInterface.getUserId(this.roleId);
/*  67 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  69 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  71 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(factionId) }));
/*     */     
/*  73 */     if (factionId != GangInterface.getGangId(this.roleId))
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.processImp@ gang id changed!|roleId=%d|worshipId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId) }));
/*     */       
/*     */ 
/*  78 */       return false;
/*     */     }
/*  80 */     long factionWorldId = GangInterface.getGangWorldId(factionId);
/*  81 */     long roleWorldeId = MapInterface.getRoleWorldInstanceId(this.roleId);
/*  82 */     if (factionWorldId != roleWorldeId)
/*     */     {
/*  84 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.processImp@ not in role's faction world!|roleId=%d|worshipId=%d|factionWorldId=%d|roleWorldeId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId), Long.valueOf(factionWorldId), Long.valueOf(roleWorldeId) }));
/*     */       
/*     */ 
/*     */ 
/*  88 */       return false;
/*     */     }
/*  90 */     if (!MapInterface.isNearByNPC(this.roleId, WorShipConst.getInstance().npcId))
/*     */     {
/*  92 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.processImp@ not near npc!|roleId=%d|worshipId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId) }));
/*     */       
/*  94 */       return false;
/*     */     }
/*  96 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleId, WorShipConst.getInstance().activityId);
/*     */     
/*  98 */     if ((!res.isCanJoin()) && (!WorshipManager.isDebugMode()))
/*     */     {
/* 100 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.processImp@ can not join activity!|roleId=%d|worshipId=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/* 103 */       return false;
/*     */     }
/* 105 */     RoleWorshipInfo xRoleWorshipInfo = WorshipManager.getXRoleWorshipDataIfAbsent(this.roleId, factionId);
/*     */     
/* 107 */     if (xRoleWorshipInfo.getWorshipid() > 0)
/*     */     {
/* 109 */       WorshipManager.sendWorshipNotice(Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), false, 1, new String[0]);
/* 110 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.processImp@ already worshiped!|roleId=%d|worshipId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId) }));
/*     */       
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     if (!doAward(userid, (Integer)xRoleWorshipInfo.getLastcycledata().get(Long.valueOf(factionId))))
/*     */     {
/* 118 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.processImp@ do award err!|roleId=%d|worshipId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId) }));
/*     */       
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     xRoleWorshipInfo.setWorshipid(this.worshipId);
/*     */     
/* 125 */     modFactionData(factionId);
/*     */     
/* 127 */     ActivityInterface.addActivityCount(userid, this.roleId, WorShipConst.getInstance().activityId);
/*     */     
/* 129 */     OnlineManager.getInstance().send(this.roleId, new mzm.gsp.worship.SWorshipSuc(this.worshipId, this.addValue));
/*     */     
/* 131 */     worshipSucBro(factionId);
/*     */     
/* 133 */     WorshipManager.tlogWorship(userid, this.roleId, this.worshipId, factionId, GangInterface.getBangGong(this.roleId));
/* 134 */     return true;
/*     */   }
/*     */   
/*     */   private void worshipSucBro(long factionId)
/*     */   {
/* 139 */     SWorshipSucBro bro = new SWorshipSucBro();
/* 140 */     bro.contentindex = this.contentIndex;
/* 141 */     bro.goldnum = this.addValue;
/* 142 */     bro.roleid = this.roleId;
/* 143 */     bro.worshipid = this.worshipId;
/* 144 */     bro.rolename = RoleInterface.getName(this.roleId);
/* 145 */     GangInterface.brocastInGang(bro, factionId);
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
/*     */   private void modFactionData(long factionId)
/*     */   {
/* 159 */     FactionWorshipInfo xFactionData = Faction2worship.get(Long.valueOf(factionId));
/* 160 */     if (xFactionData == null)
/*     */     {
/* 162 */       xFactionData = Pod.newFactionWorshipInfo();
/* 163 */       Faction2worship.insert(Long.valueOf(factionId), xFactionData);
/*     */     }
/* 165 */     Map<Integer, Integer> xFWorshipDatas = xFactionData.getWorshipdata();
/* 166 */     Integer oldCount = (Integer)xFWorshipDatas.get(Integer.valueOf(this.worshipId));
/* 167 */     if (oldCount == null)
/*     */     {
/* 169 */       oldCount = new Integer(0);
/*     */     }
/* 171 */     xFWorshipDatas.put(Integer.valueOf(this.worshipId), Integer.valueOf(oldCount.intValue() + 1));
/*     */     
/*     */ 
/* 174 */     List<SingleWorshipInfo> xRecord = xFactionData.getWorshiprecord();
/* 175 */     if (xRecord.size() == WorShipConst.getInstance().recordMax)
/*     */     {
/* 177 */       xRecord.remove(0);
/*     */     }
/* 179 */     SingleWorshipInfo xSingleWorshipInfo = Pod.newSingleWorshipInfo();
/* 180 */     xSingleWorshipInfo.setRoleid(this.roleId);
/* 181 */     xSingleWorshipInfo.setWorshipid(this.worshipId);
/* 182 */     xSingleWorshipInfo.setContentindex(this.contentIndex);
/* 183 */     xRecord.add(xSingleWorshipInfo);
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
/*     */   private boolean doAward(String userid, Integer fileNum)
/*     */   {
/* 196 */     if (fileNum != null)
/*     */     {
/* 198 */       this.addValue = WorshipManager.getSalary(this.roleId, fileNum.intValue());
/* 199 */       if (this.addValue > 0)
/*     */       {
/* 201 */         ModMoneyResult res = RoleInterface.addGoldWithinMax(this.roleId, this.addValue, new TLogArg(LogReason.WORSHIP_ADD_FILE));
/* 202 */         if (!res.isSucceed())
/*     */         {
/* 204 */           GameServer.logger().error(String.format("[worship]PCWorshipReq.processImp@ add gold err!|roleId=%d|fileNum=%d|addValue=%d|reason=%s", new Object[] { Long.valueOf(this.roleId), fileNum, Integer.valueOf(this.addValue), res.getRes().toString() }));
/*     */           
/*     */ 
/*     */ 
/* 208 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 213 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(WorShipConst.getInstance().awardId, userid, this.roleId, true, true, new AwardReason(LogReason.WORSHIP_ADD_MIN));
/*     */     
/* 215 */     if (awardModel == null)
/*     */     {
/* 217 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.processImp@ add min award err!|roleId=%d|awardId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(WorShipConst.getInstance().awardId) }));
/*     */       
/*     */ 
/* 220 */       return false;
/*     */     }
/* 222 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean preCheck()
/*     */   {
/* 232 */     if (!WorshipManager.isWorshipOpen())
/*     */     {
/* 234 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.preCheck@ not open!|roleId=%d|worshipId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId) }));
/*     */       
/* 236 */       return false;
/*     */     }
/* 238 */     this.cfg = SWorShipCfg.get(this.worshipId);
/* 239 */     if (this.cfg == null)
/*     */     {
/* 241 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.preCheck@ not have worshipid's cfg!|roleId=%d|worshipId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId) }));
/*     */       
/*     */ 
/* 244 */       return false;
/*     */     }
/* 246 */     if (!MapInterface.isNearByNPC(this.roleId, WorShipConst.getInstance().npcId))
/*     */     {
/* 248 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.preCheck@ not near by faction master's NPC!|roleId=%d|worshipId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId) }));
/*     */       
/*     */ 
/* 251 */       return false;
/*     */     }
/* 253 */     int size = this.cfg.contentList.size();
/* 254 */     if (size == 0)
/*     */     {
/* 256 */       GameServer.logger().error(String.format("[worship]PCWorshipReq.preCheck@ cfg.contentList is null!|roleId=%d|worshipId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.worshipId) }));
/*     */       
/*     */ 
/* 259 */       return false;
/*     */     }
/* 261 */     this.contentIndex = (Xdb.random().nextInt(this.cfg.contentList.size()) + 1);
/* 262 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\PCWorshipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */