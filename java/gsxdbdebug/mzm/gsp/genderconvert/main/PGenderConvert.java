/*     */ package mzm.gsp.genderconvert.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.genderconvert.event.ActivateGenderConvert;
/*     */ import mzm.gsp.genderconvert.event.ActivateGenderConvertArg;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MultiGender;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGenderConvert extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PGenderConvert(long paramLong)
/*     */   {
/*  31 */     this.roleid = paramLong;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     int i = RoleInterface.getGender(this.roleid);
/*  38 */     int j = i == 1 ? 2 : 1;
/*     */     
/*  40 */     String str = RoleInterface.getUserId(this.roleid);
/*  41 */     if (str == null) {
/*  42 */       return false;
/*     */     }
/*  44 */     lock(User.getTable(), Arrays.asList(new String[] { str }));
/*     */     
/*  46 */     int k = RoleInterface.getLevel(this.roleid);
/*  47 */     if (k < 70)
/*     */     {
/*  49 */       GenderConvertManager.sendFailedResult(this.roleid, -1);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     boolean bool1 = TeamInterface.isRoleInTeam(this.roleid, false);
/*  54 */     if (bool1)
/*     */     {
/*  56 */       GenderConvertManager.logError(String.format("PGenderConvert.processImp@role has team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }), new Object[0]);
/*  57 */       GenderConvertManager.sendFailedResult(this.roleid, -2);
/*     */       
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     boolean bool2 = MarriageInterface.isMarried(this.roleid);
/*  63 */     if (bool2)
/*     */     {
/*  65 */       GenderConvertManager.logError(String.format("PGenderConvert.processImp@role is not single|roleid=%d", new Object[] { Long.valueOf(this.roleid) }), new Object[0]);
/*  66 */       GenderConvertManager.sendFailedResult(this.roleid, -3);
/*     */       
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     MultiGender localMultiGender = GenderConvertManager.getAndCreateXMultiGender(this.roleid, i);
/*  72 */     long l = DateTimeUtils.getCurrTimeInMillis();
/*  73 */     if (l < localMultiGender.getSwitch_time() + TimeUnit.HOURS.toMillis(24L))
/*     */     {
/*  75 */       GenderConvertManager.sendFailedResult(this.roleid, -4);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 66, true)) {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     TLogArg localTLogArg = new TLogArg(LogReason.MULTI_OCCUP_ACTIVE, (int)this.roleid);
/*  84 */     int m = QingfuInterface.costYuanbao(str, this.roleid, 8000, CostType.COST_BIND_FIRST_PARTNER_ACTIVE, localTLogArg) == CostResult.Success ? 1 : 0;
/*  85 */     if (m == 0)
/*     */     {
/*  87 */       GenderConvertManager.logError("PGenderConvert.processImp@cost yuanbao error|roleid=%d|need_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(8000) });
/*  88 */       GenderConvertManager.sendFailedResult(this.roleid, -5);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     LinkedList localLinkedList = GenderConvertHandlerManager.getHandlers();
/*  94 */     for (Object localObject = localLinkedList.iterator(); ((Iterator)localObject).hasNext();) { GenderConvertHandler localGenderConvertHandler = (GenderConvertHandler)((Iterator)localObject).next();
/*  95 */       if (!localGenderConvertHandler.onActivateGenderConvert(this.roleid, j, i))
/*     */       {
/*  97 */         GenderConvertManager.logError("PGenderConvert.processImp@handle failed|roleid=%d|current_gender=%d|new_gender=%d|class=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(i), Integer.valueOf(j), localGenderConvertHandler.getClass().toString() });
/*     */         
/*  99 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 103 */     if (!GenderConvertManager.hasGender(localMultiGender, j))
/*     */     {
/* 105 */       localMultiGender.getGenders().add(Integer.valueOf(j));
/*     */     }
/* 107 */     localMultiGender.setSwitch_time(l);
/*     */     
/* 109 */     RoleInterface.setGender(this.roleid, j);
/* 110 */     GenderConvertManager.notifyActiveGenderConvert(this.roleid);
/* 111 */     RoleInterface.removeRoleOutFightObj(this.roleid);
/*     */     
/* 113 */     localObject = new ActivateGenderConvertArg(this.roleid, j, i);
/* 114 */     TriggerEventsManger.getInstance().triggerEvent(new ActivateGenderConvert(), localObject);
/*     */     
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\main\PGenderConvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */