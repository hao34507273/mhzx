/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.cat.main.CatInterface;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.item.SUseCatItemSuccess;
/*     */ import mzm.gsp.item.confbean.SCatItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PCUseCatItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long uuid;
/*     */   
/*     */   public PCUseCatItem(long roleid, long uuid)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!CatInterface.isFunOpen(this.roleid))
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 75, true))
/*     */     {
/*  40 */       GameServer.logger().info(String.format("[item]PCUseCatItem.checkRoleStatus@status check failed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  42 */       return false;
/*     */     }
/*  44 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  46 */       ItemManager.sendWrongInfo(this.roleid, 1154, new String[0]);
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  53 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/*  54 */     if (item == null)
/*     */     {
/*  56 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  57 */       return false;
/*     */     }
/*  59 */     if (!item.canUse(this.roleid))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     SItemCfg itemCfg = SItemCfg.get(item.getCfgId());
/*  65 */     if ((itemCfg == null) || (itemCfg.type != 84))
/*     */     {
/*  67 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     SCatItemCfg catItemCfg = SCatItemCfg.get(itemCfg.id);
/*  73 */     if (catItemCfg == null)
/*     */     {
/*  75 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     int retcode = CatInterface.useCatItem(this.roleid, this.uuid, item);
/*  81 */     if (retcode != 0)
/*     */     {
/*  83 */       ItemManager.sendWrongInfo(this.roleid, 1153, new String[0]);
/*  84 */       GameServer.logger().error(String.format("[item]PCUseCatItem.processImp@use cat item failed|roleid=%d|uuid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(retcode) }));
/*     */       
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_CAT);
/*  91 */     boolean result = ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/*  92 */     if (!result)
/*     */     {
/*  94 */       GameServer.logger().error(String.format("[item]PCUseCatItem.processImp@remove cat item failed|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid) }));
/*     */       
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     SUseCatItemSuccess resp = new SUseCatItemSuccess();
/* 101 */     resp.uuid = this.uuid;
/* 102 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 104 */     GameServer.logger().info(String.format("[item]PCUseCatItem.processImp@use cat item success|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid) }));
/*     */     
/*     */ 
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCUseCatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */