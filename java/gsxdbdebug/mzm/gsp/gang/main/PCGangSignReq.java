/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.CGangSignReq;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SGangSignReq;
/*     */ import mzm.gsp.gang.SSyncGangSignReq;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangMember;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2gangmember;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGangSignReq extends GangProcedure<CGangSignReq>
/*     */ {
/*  25 */   private Logger LOGGER = Logger.getLogger(PCGangSignReq.class);
/*     */   
/*     */   public PCGangSignReq(CGangSignReq protocol) {
/*  28 */     super(protocol);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean doProcess(long roleId, CGangSignReq protocol)
/*     */   {
/*  34 */     String userid = RoleInterface.getUserId(roleId);
/*  35 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  37 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*  38 */     if (null == xGangMember)
/*     */     {
/*  40 */       SGangNormalResult result = new SGangNormalResult();
/*  41 */       result.result = 45;
/*  42 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*     */       
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/*  48 */     if (null == xGang) {
/*  49 */       SGangNormalResult result = new SGangNormalResult();
/*  50 */       result.result = 46;
/*  51 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!GangManager.isInGang(xGang, roleId)) {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (!GangInterface.getCanGangSign(roleId, xGangMember)) {
/*  60 */       SGangSignReq result = new SGangSignReq();
/*  61 */       result.result = 0;
/*  62 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*  63 */       return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */     AwardModel am = AwardInterface.award(SGangConst.getInstance().SIGN_REWARD_ITEM_ID, userid, roleId, true, true, new AwardReason(LogReason.GANG_SIGN_AWARD, (int)roleId));
/*  84 */     if (am == null) {
/*  85 */       if (this.LOGGER.isDebugEnabled()) {
/*  86 */         this.LOGGER.debug("帮派签到发奖失败 AwardModel为null，奖励类id=" + SGangConst.getInstance().SIGN_REWARD_ITEM_ID + " roleid=" + roleId);
/*     */       }
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     xGangMember.setIssign(1);
/*  92 */     xGangMember.setSigntime(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*  94 */     SGangSignReq result = new SGangSignReq();
/*  95 */     result.result = 1;
/*  96 */     OnlineManager.getInstance().send(roleId, result);
/*     */     
/*  98 */     SSyncGangSignReq syncresult = new SSyncGangSignReq();
/*  99 */     syncresult.roleid = roleId;
/* 100 */     syncresult.signstr = xGangMember.getSignstr();
/* 101 */     GangManager.broadcast(xGang, syncresult);
/*     */     
/* 103 */     StringBuilder tLogStr = new StringBuilder();
/*     */     
/* 105 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(roleId)).append("|").append(roleId).append("|").append(RoleInterface.getLevel(roleId)).append("|").append(xGangMember.getGangid()).append("|").append(xGang.getDisplayid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */     TLogManager.getInstance().addLog(roleId, "GangSign", tLogStr.toString());
/*     */     
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCGangSignReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */