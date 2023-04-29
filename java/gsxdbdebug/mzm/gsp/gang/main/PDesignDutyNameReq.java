/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SSyncDesignDutyName;
/*     */ import mzm.gsp.gang.confbean.SDesignDutyNameCfg;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.gang.event.AssignDutyName;
/*     */ import mzm.gsp.gang.event.GangArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GangMember;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2gangmember;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PDesignDutyNameReq extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int designcaseid;
/*     */   
/*     */   public PDesignDutyNameReq(long roleId, int designcaseid)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.designcaseid = designcaseid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  38 */     SDesignDutyNameCfg sDesignDutyNameCfg = SDesignDutyNameCfg.get(this.designcaseid);
/*  39 */     if (sDesignDutyNameCfg == null) {
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     String userid = RoleInterface.getUserId(this.roleId);
/*  45 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  47 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*  48 */     if (xGangMember == null) {
/*  49 */       return false;
/*     */     }
/*  51 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/*  52 */     if (!dutyCfg.isCanDesignDutyName) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     long gangId = xGangMember.getGangid();
/*     */     
/*  58 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  59 */     if (xGang == null) {
/*  60 */       return false;
/*     */     }
/*  62 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (xGang.getDesigntitlecaseid() == this.designcaseid) {
/*  67 */       SGangNormalResult result = new SGangNormalResult();
/*  68 */       result.result = 56;
/*  69 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if ((sDesignDutyNameCfg.costYuanBao > 0) && (QingfuInterface.costYuanbao(userid, this.roleId, sDesignDutyNameCfg.costYuanBao, CostType.COST_BIND_FIRST_GANG_DESIGN_DUTY_NAME, new TLogArg(LogReason.GANG_DESIGN_DUTY_YUANBAO_REM)) != CostResult.Success))
/*     */     {
/*     */ 
/*     */ 
/*  77 */       return false;
/*     */     }
/*  79 */     xGang.setDesigntitlecaseid(this.designcaseid);
/*     */     
/*  81 */     SSyncDesignDutyName sSyncDesignDutyName = new SSyncDesignDutyName();
/*  82 */     sSyncDesignDutyName.designcaseid = this.designcaseid;
/*  83 */     GangManager.broadcast(xGang, sSyncDesignDutyName);
/*     */     
/*  85 */     SGangNormalResult result = new SGangNormalResult();
/*  86 */     result.result = 28;
/*  87 */     OnlineManager.getInstance().send(this.roleId, result);
/*     */     
/*  89 */     GangArg gangArg = new GangArg();
/*  90 */     gangArg.gangId = gangId;
/*  91 */     gangArg.extraMemberList.addAll(GangManager.getMembers(xGang));
/*  92 */     TriggerEventsManger.getInstance().triggerEvent(new AssignDutyName(), gangArg);
/*     */     
/*  94 */     StringBuilder tLogStr = new StringBuilder();
/*     */     
/*  96 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(this.roleId)).append("|").append(this.roleId).append("|").append(xGangMember.getDuty()).append("|").append(xGangMember.getGangid()).append("|").append(this.designcaseid).append("|").append(xGang.getDisplayid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 103 */     TLogManager.getInstance().addLog(this.roleId, "GangChangeChengwei", tLogStr.toString());
/*     */     
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PDesignDutyNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */