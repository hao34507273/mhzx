/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.SBrocastPauseParade;
/*     */ import mzm.gsp.marriage.SBrocastRobMarriageParade;
/*     */ import mzm.gsp.marriage.SBrocastRobMarriageParadeEnd;
/*     */ import mzm.gsp.marriage.SMarrigeParadeGetMoney;
/*     */ import mzm.gsp.marriage.SParadeRobStageRes;
/*     */ import mzm.gsp.marriage.confbean.ParadeNumCfg;
/*     */ import mzm.gsp.marriage.confbean.SMarriageParadeCfg;
/*     */ import mzm.gsp.marriage.confbean.SParadeControlCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarriageParade;
/*     */ import xbean.MarriageParades;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ import xtable.Marriageparade;
/*     */ 
/*     */ public class PonArrivalPointSeq extends LogicProcedure
/*     */ {
/*     */   private static final int RANDOM_RATE = 10000;
/*     */   private final int seq;
/*     */   private final long roleid;
/*     */   private final long paradeMil;
/*     */   
/*     */   public PonArrivalPointSeq(int seq, long paradeMil, long roleid)
/*     */   {
/*  41 */     this.seq = seq;
/*  42 */     this.roleid = roleid;
/*  43 */     this.paradeMil = paradeMil;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  48 */     MarriageParades xMarriageParades = Marriageparade.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  49 */     if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/*  50 */       GameServer.logger().info(String.format("[Marriage]PonArrivalPointSeq.processImp@arrive point seq,but marriage parade do not has data", new Object[0]));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*  57 */     MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/*     */     
/*  59 */     GameServer.logger().info(String.format("cur seq|seq=%d|groupid=%d", new Object[] { Integer.valueOf(this.seq), Long.valueOf(xMarriageParade.getTimemil()) }));
/*     */     
/*  61 */     final long roleid1 = xMarriageParade.getRoleid1();
/*  62 */     long roleid2 = xMarriageParade.getRoleid2();
/*  63 */     long storeMil = xMarriageParade.getTimemil();
/*  64 */     if (((this.roleid != roleid1) && (this.roleid != roleid2)) || (this.paradeMil != storeMil)) {
/*  65 */       GameServer.logger().info(String.format("[Marriage]PonArrivalPointSeq.processImp@arrive point seq,but is not marriage parade roles|arrivalRoleid=%d|seq=%d|roleid1=%d|roleid2=%d|paradeMil=%d|storeParadeMil=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.seq), Long.valueOf(roleid1), Long.valueOf(roleid2), Long.valueOf(this.paradeMil), Long.valueOf(storeMil) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     boolean needStop = false;
/*     */     
/*  77 */     final int levelCfgid = xMarriageParade.getLevel();
/*  78 */     if (xMarriageParade.getArriveseqs().contains(Integer.valueOf(this.seq))) {
/*  79 */       GameServer.logger().error(String.format("[Marriage]PonArrivalPointSeq.processImp@already arrived point seq|seq=%d", new Object[] { Integer.valueOf(this.seq) }));
/*     */       
/*  81 */       return false;
/*     */     }
/*  83 */     xMarriageParade.getArriveseqs().add(Integer.valueOf(this.seq));
/*  84 */     SParadeControlCfg paradeControlCfg = SParadeControlCfg.get(levelCfgid);
/*  85 */     if (paradeControlCfg == null) {
/*  86 */       GameServer.logger().error(String.format("[Marriage]PonArrivalPointSeq.processImp@marriage parade level cfg not exist|level=%d|MarriageParade=%s", new Object[] { Integer.valueOf(levelCfgid), xMarriageParade.toString() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */       MarriageManager.stopAndDoNextTurn(xMarriageParades, xMarriageParade);
/*  94 */       return true;
/*     */     }
/*  96 */     ParadeNumCfg paradeNumCfg = (ParadeNumCfg)paradeControlCfg.num2CfgMap.get(Integer.valueOf(this.seq));
/*  97 */     if (xMarriageParade.getStoppointseqs().contains(Integer.valueOf(this.seq))) {
/*  98 */       needStop = true;
/*  99 */       if (paradeNumCfg != null) {
/* 100 */         ControllerInterface.triggerWorldControllerWithMaxSpawnNum(MapInterface.getBigWorldid(), paradeNumCfg.controlid, paradeNumCfg.controlNum);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 105 */       Xdb.executor().execute(new LogicRunnable()
/*     */       {
/*     */         public void process() throws Exception
/*     */         {
/* 109 */           SBrocastPauseParade brocastPauseParade = new SBrocastPauseParade();
/* 110 */           brocastPauseParade.role1info.roleid = roleid1;
/* 111 */           brocastPauseParade.role1info.rolename = RoleInterface.getName(roleid1);
/* 112 */           brocastPauseParade.role2info.roleid = levelCfgid;
/* 113 */           brocastPauseParade.role2info.rolename = RoleInterface.getName(levelCfgid);
/* 114 */           brocastPauseParade.paradecfgid = this.val$levelCfgid;
/* 115 */           OnlineManager.getInstance().sendAllAtOnce(brocastPauseParade);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/* 120 */     final SMarriageParadeCfg marriageParadeCfg = SMarriageParadeCfg.get(levelCfgid);
/* 121 */     if ((xMarriageParade.getGivemoneypointseqs().contains(Integer.valueOf(this.seq))) && 
/* 122 */       (marriageParadeCfg != null))
/*     */     {
/* 124 */       MapInterface.getRolesNearBySomebody(roleid1, marriageParadeCfg.benefitScacle, new mzm.gsp.map.main.MapCallback()
/*     */       {
/*     */ 
/*     */         public boolean onResult(List<Long> result)
/*     */         {
/* 129 */           int randomNum = 0;
/* 130 */           for (Iterator i$ = result.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 131 */             if ((roleid != roleid1) && (roleid != marriageParadeCfg))
/*     */             {
/*     */ 
/* 134 */               if (randomNum >= this.val$marriageParadeCfg.maxRoleNum) {
/*     */                 break;
/*     */               }
/* 137 */               int rate = Xdb.random().nextInt(10000);
/* 138 */               if (this.val$marriageParadeCfg.rate > rate) {
/* 139 */                 randomNum++;
/* 140 */                 NoneRealTimeTaskManager.getInstance().addTask(new PonArrivalPointSeq.AwardProcedure(PonArrivalPointSeq.this, roleid1, marriageParadeCfg, roleid, this.val$marriageParadeCfg.awardid));
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 147 */           return true;
/*     */         }
/*     */         
/*     */         public boolean isCallInProcedure()
/*     */         {
/* 152 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */ 
/* 158 */     int stopSec = 0;
/* 159 */     if ((xMarriageParade.getRobseqs().contains(Integer.valueOf(this.seq))) && 
/* 160 */       (mzm.gsp.open.main.OpenInterface.getOpenStatus(129))) {
/* 161 */       needStop = true;
/* 162 */       stopSec = mzm.gsp.marriage.confbean.SMarriageParadeRobConsts.getInstance().robParadeSec;
/* 163 */       xMarriageParade.setCanrob(true);
/* 164 */       if (paradeNumCfg != null) {
/* 165 */         ControllerInterface.triggerController(paradeNumCfg.protectControlid);
/*     */       }
/* 167 */       Xdb.executor().execute(new LogicRunnable()
/*     */       {
/*     */         public void process() throws Exception
/*     */         {
/* 171 */           SBrocastRobMarriageParade sBrocastRobMarriageParade = new SBrocastRobMarriageParade();
/* 172 */           MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParade.role1info, roleid1);
/* 173 */           MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParade.role2info, this.val$roleid2);
/* 174 */           OnlineManager.getInstance().sendAll(sBrocastRobMarriageParade);
/*     */           
/* 176 */           SParadeRobStageRes paradeRobStageRes = new SParadeRobStageRes();
/* 177 */           paradeRobStageRes.result = 1;
/* 178 */           MapInterface.asyncBroadcastInSight(roleid1, paradeRobStageRes, true);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */ 
/* 184 */     if ((needStop) && (marriageParadeCfg != null)) {
/* 185 */       if (stopSec <= 0) {
/* 186 */         stopSec = marriageParadeCfg.stopSec;
/*     */       }
/* 188 */       new PauseSession(stopSec, this.seq);
/*     */     }
/* 190 */     else if (!MarriageManager.nextSeq(this.seq, xMarriageParade))
/*     */     {
/* 192 */       MarriageManager.stopAndDoNextTurn(xMarriageParades, xMarriageParade);
/*     */     }
/*     */     
/* 195 */     return true;
/*     */   }
/*     */   
/*     */   static class PauseSession extends Session
/*     */   {
/*     */     public PauseSession(long interval, long seq) {
/* 201 */       super(seq);
/*     */     }
/*     */     
/*     */     int getSeq() {
/* 205 */       return (int)getOwerId();
/*     */     }
/*     */     
/*     */     protected void onTimeOut()
/*     */     {
/* 210 */       final int stopSeq = getSeq();
/* 211 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 215 */           MarriageParades xMarriageParades = Marriageparade.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*     */           
/* 217 */           if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/* 218 */             GameServer.logger().info(String.format("[Marriage]PonArrivalPointSeq.processImp@arrive point seq,but marriage parade do not has data", new Object[0]));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 223 */             return false;
/*     */           }
/* 225 */           MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/* 226 */           if (xMarriageParade.getRobseqs().contains(Integer.valueOf(stopSeq))) {
/* 227 */             xMarriageParade.setCanrob(false);
/* 228 */             MarriageManager.paradeCheckAndMoveOn(xMarriageParades, xMarriageParade);
/* 229 */             final boolean hasRobRole = (xMarriageParade.getGroomfightstatus() > 0) || (xMarriageParade.getBridefightstatus() > 0);
/*     */             
/* 231 */             final long roleid1 = xMarriageParade.getRoleid1();
/* 232 */             long roleid2 = xMarriageParade.getRoleid2();
/* 233 */             xdb.Procedure.execute(new LogicProcedure()
/*     */             {
/*     */               protected boolean processImp()
/*     */                 throws Exception
/*     */               {
/* 238 */                 SBrocastRobMarriageParadeEnd sBrocastRobMarriageParadeEnd = new SBrocastRobMarriageParadeEnd();
/* 239 */                 MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParadeEnd.role1info, roleid1);
/* 240 */                 MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParadeEnd.role2info, hasRobRole);
/* 241 */                 if (this.val$hasRobRole) {
/* 242 */                   sBrocastRobMarriageParadeEnd.result = 1;
/*     */                 } else {
/* 244 */                   sBrocastRobMarriageParadeEnd.result = 2;
/*     */                 }
/* 246 */                 OnlineManager.getInstance().sendAll(sBrocastRobMarriageParadeEnd);
/* 247 */                 return true;
/*     */               }
/*     */             });
/*     */           }
/* 251 */           else if (!MarriageManager.nextSeq(stopSeq, xMarriageParade)) {
/* 252 */             MarriageManager.stopAndDoNextTurn(xMarriageParades, xMarriageParade);
/*     */           }
/* 254 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   class AwardProcedure extends LogicProcedure
/*     */   {
/*     */     private final long paradeRole1;
/*     */     private final long paradeRole2;
/*     */     private final long awardRoleid;
/*     */     private final int awardId;
/*     */     
/*     */     public AwardProcedure(long paradeRole1, long paradeRole2, long awardRoleid, int awardId) {
/* 268 */       this.paradeRole1 = paradeRole1;
/* 269 */       this.paradeRole2 = paradeRole2;
/* 270 */       this.awardRoleid = awardRoleid;
/* 271 */       this.awardId = awardId;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 276 */       String role1Name = RoleInterface.getName(this.paradeRole1);
/* 277 */       String role2Name = RoleInterface.getName(this.paradeRole2);
/* 278 */       String userid = RoleInterface.getUserId(this.awardRoleid);
/* 279 */       lock(xtable.User.getTable(), java.util.Arrays.asList(new String[] { userid }));
/* 280 */       mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(this.awardId, userid, this.awardRoleid, false, false, new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.MARRIAGE_PARADE_PATH_POINT_AWARD));
/*     */       
/* 282 */       if (awardModel != null) {
/* 283 */         SMarrigeParadeGetMoney marrigeParadeGetMoney = new SMarrigeParadeGetMoney();
/* 284 */         AwardInterface.fillAwardBean(marrigeParadeGetMoney.awardbean, awardModel);
/* 285 */         marrigeParadeGetMoney.role1info.roleid = this.paradeRole1;
/* 286 */         marrigeParadeGetMoney.role1info.rolename = role1Name;
/* 287 */         marrigeParadeGetMoney.role2info.roleid = this.paradeRole2;
/* 288 */         marrigeParadeGetMoney.role2info.rolename = role2Name;
/* 289 */         OnlineManager.getInstance().send(this.awardRoleid, marrigeParadeGetMoney);
/* 290 */         return true;
/*     */       }
/* 292 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PonArrivalPointSeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */