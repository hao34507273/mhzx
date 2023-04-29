/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SGetFuLiRes;
/*     */ import mzm.gsp.gang.SSyncFuLiInfo;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CangKu;
/*     */ import xbean.GangMember;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2gangmember;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PGetFuLiReq
/*     */   extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   
/*  29 */   public PGetFuLiReq(long roleId) { this.roleId = roleId; }
/*     */   
/*  31 */   private Logger LOGGER = Logger.getLogger(PGetFuLiReq.class);
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  35 */     String userId = RoleInterface.getUserId(this.roleId);
/*  36 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  38 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*  39 */     if (xGangMember == null) {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/*  44 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleId))) {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (GangManager.getDiffDays(xGangMember.getJointime()) < SGangConst.getInstance().GET_FENGLU_MIN_DAYS) {
/*  49 */       sendError(42);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     CangKu xCangKu = xGang.getCangku();
/*  54 */     if (xCangKu.getAvaliablefulinum() <= 0) {
/*  55 */       sendError(41);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (xGangMember.getLastgetfulitime() >= xGang.getCangku().getLastupdatefulitime())
/*     */     {
/*  61 */       sendError(44);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (!GangInterface.cutBangGong(this.roleId, SGangConst.getInstance().GET_FENGLU_NEED_BANGGONG, new TLogArg(LogReason.GANG_GET_FENGLU_ADD))) {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     AwardModel am = mzm.gsp.award.main.AwardInterface.award(SGangConst.getInstance().FENGLU_REWARD_ID, userId, this.roleId, true, true, new AwardReason(LogReason.GANG_GET_FENGLU_ADD, SGangConst.getInstance().FENGLU_REWARD_ID));
/*  70 */     if (am == null) {
/*  71 */       if (this.LOGGER.isDebugEnabled()) {
/*  72 */         this.LOGGER.debug("帮派福利发奖失败 AwardModel为null，奖励类id=" + SGangConst.getInstance().FENGLU_REWARD_ID + " roleid=" + this.roleId);
/*     */       }
/*  74 */       return false;
/*     */     }
/*  76 */     xCangKu.setAvaliablefulinum(xCangKu.getAvaliablefulinum() - 1);
/*  77 */     xGangMember.setLastgetfulitime(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*  79 */     SGetFuLiRes sGetFuLiRes = new SGetFuLiRes();
/*  80 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sGetFuLiRes);
/*     */     
/*  82 */     SSyncFuLiInfo sSyncFuLiInfo = new SSyncFuLiInfo();
/*  83 */     sSyncFuLiInfo.leftcount = xCangKu.getAvaliablefulinum();
/*  84 */     sSyncFuLiInfo.totalcount = xCangKu.getFulinumtotal();
/*  85 */     GangManager.broadcast(xGang, sSyncFuLiInfo);
/*     */     
/*  87 */     StringBuilder tLogStr = new StringBuilder();
/*     */     
/*  89 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(this.roleId)).append("|").append(this.roleId).append("|").append(RoleInterface.getLevel(this.roleId)).append("|").append(xGangMember.getGangid()).append("|").append(am.getSilver()).append("|").append(xGang.getDisplayid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */     TLogManager.getInstance().addLog(this.roleId, "GangMemberSalary", tLogStr.toString());
/*     */     
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int code) {
/* 102 */     SGangNormalResult result = new SGangNormalResult();
/* 103 */     result.result = code;
/* 104 */     OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGetFuLiReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */