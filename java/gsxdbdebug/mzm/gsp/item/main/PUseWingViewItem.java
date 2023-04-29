/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.SUseWingViewItemRes;
/*     */ import mzm.gsp.item.confbean.SWingViewItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
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
/*     */ public class PUseWingViewItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long uuid;
/*     */   
/*     */   public PUseWingViewItem(long roleid, long uuid)
/*     */   {
/*  34 */     this.uuid = uuid;
/*  35 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  43 */       String logStr = String.format("[item]PUseWingViewItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  44 */       ItemManager.logger.info(logStr);
/*  45 */       return false;
/*     */     }
/*  47 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 285, true))
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     String userid = RoleInterface.getUserId(this.roleid);
/*  52 */     lock(Lockeys.get(User.getTable(), userid));
/*  53 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  55 */     int wingId = getItemWingId();
/*  56 */     if (wingId <= 0)
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[wing]PUseWingViewItem.processImp@ no wingId!|uuid=%d|roleId=%d", new Object[] { Long.valueOf(this.uuid), Long.valueOf(this.roleid) }));
/*     */       
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!WingInterface.addNewWing(this.roleid, wingId))
/*     */     {
/*  65 */       GameServer.logger().error(String.format("[wing]PUseWingViewItem.processImp@ add wing error!|uuid=%d|roleId=%d|wingId=%d", new Object[] { Long.valueOf(this.uuid), Long.valueOf(this.roleid), Integer.valueOf(wingId) }));
/*     */       
/*     */ 
/*  68 */       return false;
/*     */     }
/*  70 */     if (!rmWingItem(wingId))
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[wing]PUseWingViewItem.processImp@ rm item error!|uuid=%d|roleId=%d|wingId=%d", new Object[] { Long.valueOf(this.uuid), Long.valueOf(this.roleid), Integer.valueOf(wingId) }));
/*     */       
/*     */ 
/*  75 */       return false;
/*     */     }
/*  77 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean rmWingItem(int wingId)
/*     */   {
/*  88 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_WINGVIEW_REM);
/*  89 */     if (!ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg))
/*     */     {
/*  91 */       GameServer.logger().error(String.format("[wing]PUseWingViewItem.rmWingItem@ rm item error!|uuid=%d|roleId=%d|wingId=%d", new Object[] { Long.valueOf(this.uuid), Long.valueOf(this.roleid), Integer.valueOf(wingId) }));
/*     */       
/*     */ 
/*  94 */       return false;
/*     */     }
/*  96 */     SUseWingViewItemRes res = new SUseWingViewItemRes();
/*  97 */     res.modelid = wingId;
/*  98 */     OnlineManager.getInstance().send(this.roleid, res);
/*  99 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getItemWingId()
/*     */   {
/* 109 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/* 110 */     if (basicItem == null)
/*     */     {
/* 112 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 113 */       return -1;
/*     */     }
/* 115 */     SWingViewItem wingItem = SWingViewItem.get(basicItem.getCfgId());
/* 116 */     if ((wingItem == null) || (wingItem.type != 60))
/*     */     {
/* 118 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/* 119 */       return -1;
/*     */     }
/* 121 */     return wingItem.wingId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseWingViewItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */