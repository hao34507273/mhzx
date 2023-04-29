/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.BasicPropertiesSystem;
/*     */ import xbean.Properties;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PResetRolePropReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long yuanBao;
/*     */   private final int bpsys;
/*     */   private final boolean isUseYuanBao;
/*     */   
/*     */   public PResetRolePropReq(long roleId, long yuanBao, int bpsys, boolean isUseYuanBao)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.yuanBao = yuanBao;
/*  33 */     this.bpsys = bpsys;
/*  34 */     this.isUseYuanBao = isUseYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 218, true))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     String userid = RoleInterface.getUserId(this.roleId);
/*  46 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  48 */     long curYuanBao = QingfuInterface.getBalance(userid, true);
/*  49 */     if (this.yuanBao != curYuanBao)
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     if (!ItemInterface.removeItemsByType(this.roleId, 10, 1, new TLogArg(LogReason.ROLE_RESET_PROP_REM)))
/*     */     {
/*  55 */       int price = ItemInterface.getItemYuanBaoPrice(OccupationManager.getInstance().getResetPointItem());
/*  56 */       if ((!this.isUseYuanBao) || (QingfuInterface.costYuanbao(userid, this.roleId, price, CostType.COST_BIND_FIRST_ROLE_RESET_PROP, new TLogArg(LogReason.ROLE_RESET_PROP_REM)) != CostResult.Success))
/*     */       {
/*     */ 
/*     */ 
/*  60 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  64 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(this.roleId);
/*     */     
/*  66 */     int oldMp = role.getFinalMaxMP();
/*     */     
/*  68 */     int oldHp = role.getFinalMaxHP();
/*  69 */     BasicPropertiesSystem xBPSys = (BasicPropertiesSystem)Role2properties.get(Long.valueOf(this.roleId)).getPropertysysmap().get(Integer.valueOf(this.bpsys));
/*  70 */     if (xBPSys == null)
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     Map<Integer, Integer> propMap = xBPSys.getBasicpropertymap();
/*  75 */     Iterator<Integer> propIt = propMap.keySet().iterator();
/*  76 */     int totalPoint = xBPSys.getPotentialpoint();
/*  77 */     while (propIt.hasNext())
/*     */     {
/*  79 */       int propType = ((Integer)propIt.next()).intValue();
/*  80 */       Integer propValue = (Integer)propMap.get(Integer.valueOf(propType));
/*  81 */       if (propValue != null)
/*     */       {
/*  83 */         totalPoint += propValue.intValue();
/*     */       }
/*     */     }
/*  86 */     propMap.clear();
/*  87 */     xBPSys.setPotentialpoint(totalPoint);
/*  88 */     xBPSys.setIsautospecialpoint(false);
/*  89 */     xBPSys.getAutoassignpointpref().clear();
/*     */     
/*  91 */     int finalMaxMp = role.getFinalMaxMP();
/*  92 */     int finalMaxHp = role.getFinalMaxHP();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  97 */     role.setMP(finalMaxMp);
/*  98 */     role.setHP(finalMaxHp);
/*  99 */     role.syncClientRoleProperty();
/*     */     
/* 101 */     LogRolePropertySystemManager.tlogRolePropertySystem(RoleInterface.getUserId(this.roleId), this.roleId, Role2properties.get(Long.valueOf(this.roleId)), 5, this.bpsys);
/*     */     
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PResetRolePropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */