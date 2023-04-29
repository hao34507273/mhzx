/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fabao.SLongjingPropertyTransferRes;
/*     */ import mzm.gsp.fabao.confbean.SFabaoConstants;
/*     */ import mzm.gsp.item.confbean.SLongJingItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.RoleItemBag;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.ModMoneyResult.ErrorResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ 
/*     */ public class PLongjingPropertyTransferReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long totransferitemuuid;
/*     */   private final int targetProperty;
/*     */   private final int targetItemid;
/*     */   
/*     */   public PLongjingPropertyTransferReq(long roleid, long totransferitemuuid, int targetProperty, int targetItemid)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.totransferitemuuid = totransferitemuuid;
/*  40 */     this.targetProperty = targetProperty;
/*  41 */     this.targetItemid = targetItemid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     SLongJingItem sTargetItem = SLongJingItem.get(this.targetItemid);
/*  48 */     if (sTargetItem == null)
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (sTargetItem.lv < SFabaoConstants.getInstance().MIN_LEVEL_FOR_TRANSFER)
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     if (!LongjingTransferInterface.isRoleStateCanTransferLongjing(this.roleid))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     float targetBasePrice = LongjingTransferInterface.getLongJingItemBasePrice(sTargetItem.id);
/*  62 */     if (targetBasePrice <= 0.0F)
/*     */     {
/*  64 */       String log = String.format("[fabao]PLongjingPropertyTransferReq.processImp@targetBasePrice error|roleid=%d|target_itemid=%d|level=%d|target_base_price=%f", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(sTargetItem.id), Integer.valueOf(sTargetItem.lv), Float.valueOf(targetBasePrice) });
/*     */       
/*     */ 
/*  67 */       GameServer.logger().error(log);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!sTargetItem.attrMap.containsKey(Integer.valueOf(this.targetProperty)))
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(SFabaoConstants.getInstance().LONG_JING_TRANSFER_NPC, SFabaoConstants.getInstance().LONG_JING_TRANSFER_NPC_SERVICE, this.roleid))
/*     */     {
/*     */ 
/*  78 */       String log = String.format("[fabao]PLongjingPropertyTransferReq.processImp@npc service check error|roleid=%d|target_itemid=%d|uuid=%d|target_property=%d|npc=%d|npcservice=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.targetItemid), Long.valueOf(this.totransferitemuuid), Integer.valueOf(this.targetProperty), Integer.valueOf(SFabaoConstants.getInstance().LONG_JING_TRANSFER_NPC), Integer.valueOf(SFabaoConstants.getInstance().LONG_JING_TRANSFER_NPC_SERVICE) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  83 */       GameServer.logger().error(log);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (!LongjingTransferInterface.isLongjingTransferSwitchOpenForRole(this.roleid))
/*     */     {
/*  89 */       return false;
/*     */     }
/*  91 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(this.roleid, true);
/*  92 */     if (xRoleFabaoSysInfo == null)
/*     */     {
/*  94 */       LongjingTransferInterface.sendErrorCode(this.roleid, 0);
/*  95 */       return false;
/*     */     }
/*  97 */     if (xRoleFabaoSysInfo.getTransfercount() < 0)
/*     */     {
/*  99 */       return false;
/*     */     }
/* 101 */     int maxTransferCount = LongjingTransferInterface.getMaxLongjingTransferCount();
/* 102 */     if (xRoleFabaoSysInfo.getTransfercount() >= maxTransferCount)
/*     */     {
/* 104 */       LongjingTransferInterface.sendErrorCode(this.roleid, 1);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     RoleItemBag roleItemBag = ItemInterface.getRoleItemBag(this.roleid);
/*     */     
/* 110 */     BasicItem basicItem = roleItemBag.getItemByUuid(this.totransferitemuuid);
/*     */     
/* 112 */     if (basicItem == null)
/*     */     {
/* 114 */       return false;
/*     */     }
/* 116 */     SLongJingItem sToTransferItem = SLongJingItem.get(basicItem.getCfgId());
/* 117 */     if (sToTransferItem == null)
/*     */     {
/* 119 */       return false;
/*     */     }
/* 121 */     if (sToTransferItem.lv < SFabaoConstants.getInstance().MIN_LEVEL_FOR_TRANSFER)
/*     */     {
/* 123 */       return false;
/*     */     }
/* 125 */     if (sTargetItem.lv != sToTransferItem.lv)
/*     */     {
/* 127 */       LongjingTransferInterface.sendErrorCode(this.roleid, 6);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     if (sTargetItem.id == sToTransferItem.id)
/*     */     {
/* 133 */       String log = String.format("[fabao]PLongjingPropertyTransferReq.processImp@src itemid is same as target itemid|roleid=%d|src_itemid=%d|level=%d|target_itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(sToTransferItem.id), Integer.valueOf(sTargetItem.lv), Integer.valueOf(sTargetItem.id) });
/*     */       
/*     */ 
/* 136 */       GameServer.logger().error(log);
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     if (basicItem.getNumber() > 1)
/*     */     {
/* 142 */       if (!ItemInterface.isGridEnough(this.roleid, 340600000, sTargetItem.id, 1))
/*     */       {
/* 144 */         ItemInterface.sendSpecificBagFull(this.roleid, 340600000);
/* 145 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 150 */     float srcBasePrice = LongjingTransferInterface.getLongJingItemBasePrice(basicItem.getCfgId());
/* 151 */     if (srcBasePrice <= 0.0F)
/*     */     {
/* 153 */       String log = String.format("[fabao]PLongjingPropertyTransferReq.processImp@srcBasePrice error|roleid=%d|src_itemid=%d|level=%d|src_base_price=%f", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(sTargetItem.id), Integer.valueOf(sTargetItem.lv), Float.valueOf(srcBasePrice) });
/*     */       
/*     */ 
/* 156 */       GameServer.logger().error(log);
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     TLogArg tLogArg = new TLogArg(LogReason.FABAO_LONGJING_TRANSFER_PROPERTY, sToTransferItem.id);
/* 161 */     float targetTotal = (float)(Math.pow(2.0D, sTargetItem.lv - 1) * targetBasePrice);
/* 162 */     float srcTotal = (float)(Math.pow(2.0D, sToTransferItem.lv - 1) * srcBasePrice);
/*     */     
/* 164 */     int money = (int)(targetTotal - srcTotal);
/* 165 */     if (money != 0)
/*     */     {
/* 167 */       if (money < 0)
/*     */       {
/* 169 */         ModMoneyResult modRes = RoleInterface.addGoldWithinMax(this.roleid, Math.abs(money), tLogArg);
/*     */         
/* 171 */         if (!modRes.isSucceed())
/*     */         {
/* 173 */           if (modRes.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT)
/*     */           {
/* 175 */             LongjingTransferInterface.sendErrorCode(this.roleid, 4);
/*     */           }
/* 177 */           return false;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 182 */         boolean ret = RoleInterface.cutGold(this.roleid, money, tLogArg);
/* 183 */         if (!ret)
/*     */         {
/* 185 */           LongjingTransferInterface.sendErrorCode(this.roleid, 5);
/* 186 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 192 */     xRoleFabaoSysInfo.setTransfercount(xRoleFabaoSysInfo.getTransfercount() + 1);
/*     */     
/* 194 */     SLongjingPropertyTransferRes res = new SLongjingPropertyTransferRes();
/*     */     
/* 196 */     long targetuuid = 0L;
/* 197 */     if (basicItem.getNumber() == 1)
/*     */     {
/* 199 */       basicItem.getItem().setCfgid(sTargetItem.id);
/* 200 */       targetuuid = basicItem.getTlogUuid();
/* 201 */       ItemInterface.fillInItemInfoBean(res.targetiteminfo, basicItem.getItem());
/*     */     }
/*     */     else
/*     */     {
/* 205 */       Item xItem = basicItem.separateItem(1);
/* 206 */       if (xItem == null)
/*     */       {
/* 208 */         return false;
/*     */       }
/* 210 */       xItem.setCfgid(sTargetItem.id);
/* 211 */       ItemInterface.fillInItemInfoBean(res.targetiteminfo, xItem);
/* 212 */       if (xItem.getUuid().isEmpty())
/*     */       {
/* 214 */         return false;
/*     */       }
/* 216 */       targetuuid = ((Long)xItem.getUuid().iterator().next()).longValue();
/*     */       
/* 218 */       ItemOperateResult result = roleItemBag.addItem(xItem, false, true);
/* 219 */       if (!result.success())
/*     */       {
/* 221 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 225 */     int beforeproperty = 0;
/* 226 */     if (!sToTransferItem.attrMap.isEmpty())
/*     */     {
/* 228 */       beforeproperty = ((Integer)sToTransferItem.attrMap.keySet().iterator().next()).intValue();
/*     */     }
/*     */     
/* 231 */     res.totransferitemuuid = this.totransferitemuuid;
/* 232 */     res.beforeitemid = sToTransferItem.id;
/* 233 */     res.moneynum = money;
/* 234 */     res.resttransfercount = (maxTransferCount - xRoleFabaoSysInfo.getTransfercount());
/* 235 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 237 */     String log = String.format("[fabao]PLongjingPropertyTransferReq.processImp@role transfer longjing item success|roleid=%d|itemid=%d|uuid=%d|level=%d|target_itemid=%d|target_item_uuid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(basicItem.getCfgId()), Long.valueOf(basicItem.getTlogUuid()), Integer.valueOf(sTargetItem.lv), Integer.valueOf(sTargetItem.id), Long.valueOf(targetuuid) });
/*     */     
/*     */ 
/* 240 */     GameServer.logger().info(log);
/*     */     
/* 242 */     tlogLongjingitemtransfer(targetuuid, sToTransferItem.lv, res.beforeitemid, sTargetItem.id, beforeproperty, this.targetProperty, money, (int)srcBasePrice, (int)srcTotal, (int)targetBasePrice, (int)targetTotal, xRoleFabaoSysInfo.getTransfercount());
/*     */     
/*     */ 
/*     */ 
/* 246 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tlogLongjingitemtransfer(long uuid, int itemlevel, int beforeitemid, int afteritemid, int beforeproperty, int afterproperty, int changemoney, int srcbaseprice, int totalSrcPrice, int targetbaseprice, int totalTargetPrice, int transfercount)
/*     */   {
/* 253 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 254 */     String userid = RoleInterface.getUserId(this.roleid);
/* 255 */     int rolelevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 257 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleid), Integer.valueOf(rolelevel), Long.valueOf(uuid), Integer.valueOf(itemlevel), Integer.valueOf(beforeitemid), Integer.valueOf(afteritemid), Integer.valueOf(beforeproperty), Integer.valueOf(afterproperty), Integer.valueOf(changemoney), Integer.valueOf(srcbaseprice), Integer.valueOf(totalSrcPrice), Integer.valueOf(targetbaseprice), Integer.valueOf(totalTargetPrice), Integer.valueOf(transfercount) };
/*     */     
/*     */ 
/* 260 */     TLogManager.getInstance().addLog(this.roleid, "Longjingitemtransfer", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PLongjingPropertyTransferReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */