/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.SEnablePKFail;
/*     */ import mzm.gsp.pk.SEnablePKSuccess;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
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
/*     */ public class PEnablePK
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int currentMoneyNum;
/*     */   
/*     */   public PEnablePK(long roleId, long currentMoneyNum)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.currentMoneyNum = ((int)currentMoneyNum);
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  44 */     if (PKManager.isNotEnable()) {
/*  45 */       return false;
/*     */     }
/*  47 */     Lockeys.lock(Basic.getTable(), Collections.singleton(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  50 */     if (!MapInterface.isNearByNPC(this.roleId, SPKConsts.getInstance().PK_NPC_ID))
/*     */     {
/*  52 */       PKLogManager.error(String.format("PEnablePK.processImp()@not near npc|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  57 */     if (RoleStatusInterface.containsStatus(this.roleId, 1621))
/*     */     {
/*  59 */       PKLogManager.error(String.format("PEnablePK.processImp()@already enabled pk|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1621, true))
/*     */     {
/*  66 */       PKLogManager.error(String.format("PEnablePK.processImp()@status conflict|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     int level = RoleInterface.getLevel(this.roleId);
/*  72 */     if (level < SPKConsts.getInstance().ENABLE_PK_LEVEL)
/*     */     {
/*  74 */       PKLogManager.error(String.format("PEnablePK.processImp()@level too low|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level) }));
/*  75 */       notifyFail(1);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     int moralValue = (int)MallInterface.getJifen(this.roleId, 7);
/*  81 */     if (moralValue < SPKConsts.getInstance().ENABLE_PK_MORAL_VALUE)
/*     */     {
/*  83 */       PKLogManager.error(String.format("PEnablePK.processImp()@moral value too low|roleid=%d|moral_value=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(moralValue) }));
/*     */       
/*  85 */       notifyFail(2);
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     TLogArg tLogArg = new TLogArg(LogReason.ENABLE_PK);
/*  91 */     Pair<Boolean, Boolean> result = PKManager.chargeMoney(this.roleId, SPKConsts.getInstance().ENABLE_PK_MONEY_TYPE, this.currentMoneyNum, SPKConsts.getInstance().ENABLE_PK_PRICE, CostType.COST_BIND_FIRST_ENABLE_PK, tLogArg);
/*     */     
/*     */ 
/*  94 */     if (!((Boolean)result.first).booleanValue())
/*     */     {
/*  96 */       notifyFail(4);
/*  97 */       PKLogManager.error(String.format("PEnablePK.processImp()@money not matched|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  98 */       return false;
/*     */     }
/* 100 */     if (!((Boolean)result.second).booleanValue())
/*     */     {
/* 102 */       notifyFail(3);
/* 103 */       PKLogManager.error(String.format("PEnablePK.processImp()@insufficient money|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     int expireTime = PKStatusManager.setPKEnabled(this.roleId);
/* 109 */     if (expireTime == 0)
/* 110 */       return false;
/* 111 */     notifySuccess(expireTime);
/* 112 */     PKLogManager.info(String.format("PEnablePK.processImp()@done|roleid=%d|expire_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(expireTime) }));
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   private void notifySuccess(int expireTime)
/*     */   {
/* 118 */     SEnablePKSuccess sEnablePKSuccess = new SEnablePKSuccess();
/* 119 */     sEnablePKSuccess.expire_time = expireTime;
/* 120 */     OnlineManager.getInstance().send(this.roleId, sEnablePKSuccess);
/*     */   }
/*     */   
/*     */   private void notifyFail(int retcode)
/*     */   {
/* 125 */     SEnablePKFail sEnablePKFail = new SEnablePKFail();
/* 126 */     sEnablePKFail.retcode = retcode;
/* 127 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sEnablePKFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PEnablePK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */