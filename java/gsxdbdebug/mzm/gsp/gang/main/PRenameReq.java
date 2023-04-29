/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.gang.CRenameReq;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SSyncRename;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.gang.event.GangRename;
/*     */ import mzm.gsp.gang.event.GangRenameArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.GangMember;
/*     */ import xdb.Lockeys;
/*     */ import xdb.util.UniqName;
/*     */ import xtable.Role2gangmember;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PRenameReq extends GangProcedure<CRenameReq>
/*     */ {
/*     */   public PRenameReq(CRenameReq protocol)
/*     */   {
/*  30 */     super(protocol);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean doProcess(long roleId, CRenameReq protocol)
/*     */   {
/*  36 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  37 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  39 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*  40 */     if (xGangMember == null) {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/*  45 */     if (xGang == null) {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!GangManager.isInGang(xGang, roleId)) {
/*  49 */       return false;
/*     */     }
/*  51 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/*  52 */     if (!dutyCfg.isCanModifyName) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     String newName = protocol.newname.trim();
/*  57 */     if (newName.isEmpty()) {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if ((newName.matches("\\d+")) || (Math.ceil(CommonUtils.getUTF16Length(newName) / 2.0D) > SGangConst.getInstance().GANG_NAME_MAX_LENGTH) || (!AvailableStringArgs.getInstance().isStringUsable(newName))) {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (SensitiveInterface.isNameSensitive(newName)) {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (xGang.getLevel() < SGangConst.getInstance().MODIFY_NAME_MIN_GANG_LV) {
/*  70 */       return false;
/*     */     }
/*  72 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  73 */     long difTime = curTime - xGang.getLastrename();
/*  74 */     if (difTime < SGangConst.getInstance().MODIFY_NAME_COOLDOWN_H * 60 * 60 * 1000) {
/*  75 */       SGangNormalResult result = new SGangNormalResult();
/*  76 */       result.result = 17;
/*  77 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (!UniqName.allocate("faction", newName))
/*     */     {
/*  83 */       SGangNormalResult result = new SGangNormalResult();
/*  84 */       result.result = 19;
/*  85 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (QingfuInterface.costYuanbao(userid, roleId, SGangConst.getInstance().MODIFY_NAME_NEED_YUANBAO, CostType.COST_BIND_FIRST_GANG_RENAME, new TLogArg(mzm.gsp.tlog.LogReason.GANG_RENAME_YUANBAO_REM)) != CostResult.Success) {
/*  90 */       return false;
/*     */     }
/*  92 */     UniqName.release("faction", xGang.getName());
/*  93 */     String oldName = xGang.getName();
/*  94 */     xGang.setName(newName);
/*  95 */     xGang.setLastrename(curTime);
/*  96 */     SSyncRename sSyncRename = new SSyncRename();
/*  97 */     sSyncRename.newname = newName;
/*  98 */     GangManager.broadcast(xGang, sSyncRename);
/*  99 */     SGangNormalResult result = new SGangNormalResult();
/* 100 */     result.result = 16;
/* 101 */     OnlineManager.getInstance().send(roleId, result);
/*     */     
/*     */ 
/* 104 */     GangRenameArg gangArg = new GangRenameArg();
/* 105 */     gangArg.gangId = xGangMember.getGangid();
/* 106 */     gangArg.oldName = oldName;
/* 107 */     gangArg.newName = newName;
/* 108 */     TriggerEventsManger.getInstance().triggerEvent(new GangRename(), gangArg);
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PRenameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */