/*     */ package mzm.gsp.children.fashion;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.SRenewalFashionError;
/*     */ import mzm.gsp.children.SRenewalFashionRsp;
/*     */ import mzm.gsp.children.confbean.SFashionCfg;
/*     */ import mzm.gsp.children.confbean.TFashionTypeId2CfgIds;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ChildFashionInfo;
/*     */ import xbean.FashionInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xtable.Role2children;
/*     */ 
/*     */ public class PCRenewalFashionReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int bagId;
/*     */   final int grid;
/*     */   final int fashionCfgId;
/*     */   
/*     */   public PCRenewalFashionReq(long roleId, int bagId, int grid, int fashionCfgId)
/*     */   {
/*  35 */     this.roleId = roleId;
/*  36 */     this.bagId = bagId;
/*  37 */     this.grid = grid;
/*  38 */     this.fashionCfgId = fashionCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!OpenInterface.getOpenStatus(466))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 803, true))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     SRenewalFashionError renewalFashionError = new SRenewalFashionError();
/*     */     
/*     */ 
/*  59 */     BasicItem itemToCostInBag = ItemInterface.getItem(this.roleId, this.bagId, this.grid);
/*  60 */     if (itemToCostInBag == null)
/*     */     {
/*  62 */       renewalFashionError.errorcode = 1;
/*  63 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renewalFashionError);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     SFashionCfg fashionCfgToRenewal = SFashionCfg.get(this.fashionCfgId);
/*  69 */     if (fashionCfgToRenewal == null)
/*     */     {
/*  71 */       renewalFashionError.errorcode = 2;
/*  72 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renewalFashionError);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (fashionCfgToRenewal.duration == 0)
/*     */     {
/*  78 */       renewalFashionError.errorcode = 4;
/*  79 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renewalFashionError);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     TFashionTypeId2CfgIds tFashionTypeId2CfgIds = TFashionTypeId2CfgIds.get(fashionCfgToRenewal.typeId);
/*  85 */     if (tFashionTypeId2CfgIds == null)
/*     */     {
/*  87 */       renewalFashionError.errorcode = 2;
/*  88 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renewalFashionError);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     int bagItemFashionCfgId = 0;
/*  93 */     SFashionCfg fashionCfgToCost = null;
/*  94 */     for (Iterator i$ = tFashionTypeId2CfgIds.cfgIds.iterator(); i$.hasNext();) { int cfgId = ((Integer)i$.next()).intValue();
/*     */       
/*  96 */       fashionCfgToCost = SFashionCfg.get(cfgId);
/*  97 */       if (fashionCfgToCost == null)
/*     */       {
/*  99 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 103 */       if ((fashionCfgToRenewal.gender == fashionCfgToCost.gender) && 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 109 */         (fashionCfgToRenewal.phase == fashionCfgToCost.phase))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 114 */         if (fashionCfgToCost.itemCfgid == itemToCostInBag.getCfgId())
/*     */         {
/* 116 */           bagItemFashionCfgId = cfgId;
/* 117 */           break;
/*     */         } }
/*     */     }
/* 120 */     if (bagItemFashionCfgId == 0)
/*     */     {
/* 122 */       renewalFashionError.errorcode = 3;
/* 123 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renewalFashionError);
/* 124 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 128 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleId));
/* 129 */     if (xRole2ChildrenInfo == null)
/*     */     {
/* 131 */       renewalFashionError.errorcode = 2;
/* 132 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renewalFashionError);
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     Map<Integer, FashionInfo> xFashionInfoMap = xRole2ChildrenInfo.getFashion_info().getFashions();
/* 137 */     if (!xFashionInfoMap.containsKey(Integer.valueOf(this.fashionCfgId)))
/*     */     {
/* 139 */       renewalFashionError.errorcode = 2;
/* 140 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renewalFashionError);
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     FashionInfo xFashionInfo = (FashionInfo)xFashionInfoMap.get(Integer.valueOf(this.fashionCfgId));
/* 145 */     if (xFashionInfo.getStart_time() == 0L)
/*     */     {
/* 147 */       renewalFashionError.errorcode = 4;
/* 148 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renewalFashionError);
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     SRenewalFashionRsp renewalFashionRsp = new SRenewalFashionRsp();
/* 153 */     renewalFashionRsp.fashioncfgid = this.fashionCfgId;
/*     */     
/*     */ 
/* 156 */     FashionManager.removeFashionObserver(this.roleId, this.fashionCfgId);
/* 157 */     long oldExpireTimeStampInMs = xFashionInfo.getStart_time() + TimeUnit.HOURS.toMillis(fashionCfgToRenewal.duration);
/*     */     long newExpireTimeStampInMs;
/*     */     long newExpireTimeStampInMs;
/* 160 */     if (fashionCfgToCost.duration == 0)
/*     */     {
/* 162 */       xFashionInfo.setStart_time(0L);
/* 163 */       newExpireTimeStampInMs = 0L;
/*     */     }
/*     */     else
/*     */     {
/* 167 */       xFashionInfo.setStart_time(xFashionInfo.getStart_time() + TimeUnit.HOURS.toMillis(fashionCfgToCost.duration));
/* 168 */       newExpireTimeStampInMs = xFashionInfo.getStart_time() + TimeUnit.HOURS.toMillis(fashionCfgToRenewal.duration);
/*     */       
/* 170 */       FashionManager.startFashionObserver(this.roleId, this.fashionCfgId, TimeUnit.MILLISECONDS.toSeconds(newExpireTimeStampInMs - DateTimeUtils.getCurrTimeInMillis()));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 175 */     boolean ret = ItemInterface.removeItemByGrid(this.roleId, this.bagId, this.grid, 1, new TLogArg(mzm.gsp.tlog.LogReason.CHILDREN_FASHION_RENEWAL));
/*     */     
/* 177 */     if (!ret)
/*     */     {
/* 179 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 183 */     tLogChildrenFashionRenewalLog(itemToCostInBag.getTlogUuid(), this.fashionCfgId, oldExpireTimeStampInMs, newExpireTimeStampInMs);
/*     */     
/*     */ 
/*     */ 
/* 187 */     renewalFashionRsp.fashioninfo.start_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xFashionInfo.getStart_time()));
/* 188 */     OnlineManager.getInstance().send(this.roleId, renewalFashionRsp);
/* 189 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tLogChildrenFashionRenewalLog(long uuid, int fashionCfgId, long oldExpireTimeStampInMs, long newExpireTimeStampInMs)
/*     */   {
/* 195 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 196 */     String userId = RoleInterface.getUserId(this.roleId);
/* 197 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 198 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 200 */     TLogManager.getInstance().addLog(userId, "ChildrenFashionRenewalLog", new Object[] { vGameIp, userId, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Long.valueOf(uuid), Integer.valueOf(fashionCfgId), simpleDateFormat.format(Long.valueOf(oldExpireTimeStampInMs)), simpleDateFormat.format(Long.valueOf(newExpireTimeStampInMs)) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\PCRenewalFashionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */