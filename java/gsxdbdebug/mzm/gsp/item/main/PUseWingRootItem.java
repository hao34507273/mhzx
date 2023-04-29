/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wing.confbean.WingCfgConsts;
/*     */ import mzm.gsp.wing.main2.WingInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseWingRootItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long uuid;
/*     */   
/*     */   public PUseWingRootItem(long roleid, long uuid)
/*     */   {
/*  33 */     this.uuid = uuid;
/*  34 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  42 */       String logStr = String.format("[item]PUseWingRootItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  43 */       ItemManager.logger.info(logStr);
/*  44 */       return false;
/*     */     }
/*  46 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 285, true))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     String userid = RoleInterface.getUserId(this.roleid);
/*  52 */     lock(Lockeys.get(User.getTable(), userid));
/*  53 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  55 */     if (RoleInterface.getLevel(this.roleid) < WingInterface.getMinRoleLvForWing())
/*     */     {
/*  57 */       ItemManager.sendWrongInfo(this.roleid, 851, new String[0]);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (!checkItemValid())
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!WingInterface.openNewWingPlan(this.roleid))
/*     */     {
/*  68 */       GameServer.logger().error(String.format("[wing]PUseWingRootItem.processImp@ open wing plan error!|uuid=%d|roleId=%d", new Object[] { Long.valueOf(this.uuid), Long.valueOf(this.roleid) }));
/*     */       
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (!ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, new TLogArg(LogReason.ITEM_USE_WINGROOT_REM)))
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[wing]PUseWingRootItem.processImp@ rm item error!|uuid=%d|roleId=%d", new Object[] { Long.valueOf(this.uuid), Long.valueOf(this.roleid) }));
/*     */       
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkItemValid()
/*     */   {
/*  85 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/*  86 */     if (basicItem == null)
/*     */     {
/*  88 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  89 */       return false;
/*     */     }
/*  91 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  92 */     if ((itemCfg == null) || (itemCfg.type != 59))
/*     */     {
/*  94 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/*  95 */       return false;
/*     */     }
/*  97 */     if (itemCfg.id != WingCfgConsts.getInstance().WING_ROOT_ITEM_ID)
/*     */     {
/*  99 */       GameServer.logger().error(String.format("[wing]PUseWingRootItem.checkItemValid@ item is illegal!|uuid=%d|roleId=%d|itemId=%d|needItemId=%d|", new Object[] { Long.valueOf(this.uuid), Long.valueOf(this.roleid), Integer.valueOf(itemCfg.id), Integer.valueOf(WingCfgConsts.getInstance().WING_ROOT_ITEM_ID) }));
/*     */       
/*     */ 
/*     */ 
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseWingRootItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */