/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.item.SExchangeUseItemRes;
/*     */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.NeedItemId2Num;
/*     */ import mzm.gsp.item.confbean.SExchangeItemCfg;
/*     */ import mzm.gsp.item.confbean.SFivePreciousItem;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ExchangeUseItemInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleExchangeUseItemInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role_exchange_use_item_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PExchangeItem extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int exchangecfgid;
/*     */   private final int exchangecount;
/*     */   private final long clientNeedYuanbao;
/*     */   
/*     */   public PExchangeItem(long roleid, int exchangecfgid, int exchangecount, long clientNeedYuanbao)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.exchangecfgid = exchangecfgid;
/*  40 */     this.exchangecount = exchangecount;
/*  41 */     this.clientNeedYuanbao = clientNeedYuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if ((this.exchangecfgid <= 0) || (this.exchangecount <= 0) || (this.clientNeedYuanbao < 0L))
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     if (this.exchangecount > ItemCfgConsts.getInstance().MAX_EXCHANGE_COUNT)
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     if (!ItemModuleSwitchInterface.isItemExchangeSwitchOpenForRole(this.roleid))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  61 */       String logStr = String.format("[item]PExchangeItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  62 */       ItemManager.logger.info(logStr);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     String userid = RoleInterface.getUserId(this.roleid);
/*  67 */     lock(Lockeys.get(User.getTable(), userid));
/*  68 */     lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  70 */     TLogArg logArg = new TLogArg(LogReason.ITEM_EXCHANGE, this.exchangecfgid);
/*     */     
/*     */ 
/*  73 */     SExchangeItemCfg exchangeItemCfg = SExchangeItemCfg.get(this.exchangecfgid);
/*  74 */     if ((exchangeItemCfg == null) || (exchangeItemCfg.needItemList.isEmpty()))
/*     */     {
/*  76 */       ItemManager.sendWrongInfo(this.roleid, 780, new String[0]);
/*  77 */       return false;
/*     */     }
/*  79 */     long beginTimestamp = TimeCommonUtil.getLimitTimeBegin(exchangeItemCfg.time_limit_cfg_id);
/*  80 */     long endTimestamp = TimeCommonUtil.getLimitTimeEnd(exchangeItemCfg.time_limit_cfg_id);
/*  81 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  82 */     if ((now < beginTimestamp) || (now > endTimestamp))
/*     */     {
/*  84 */       ItemManager.sendWrongInfo(this.roleid, 783, new String[0]);
/*  85 */       return false;
/*     */     }
/*  87 */     if ((exchangeItemCfg.exchange_times_limit > 0) && (getExchangeTimes() + this.exchangecount > exchangeItemCfg.exchange_times_limit))
/*     */     {
/*     */ 
/*  90 */       ItemManager.sendWrongInfo(this.roleid, 784, new String[0]);
/*  91 */       return false;
/*     */     }
/*  93 */     if ((exchangeItemCfg.daily_exchange_times_limit > 0) && (getDailyExchangeTimes(now) + this.exchangecount > exchangeItemCfg.daily_exchange_times_limit))
/*     */     {
/*     */ 
/*  96 */       ItemManager.sendWrongInfo(this.roleid, 785, new String[0]);
/*  97 */       return false;
/*     */     }
/*  99 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(this.roleid);
/* 100 */     if (itemBag == null)
/*     */     {
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     int needItemid = ((NeedItemId2Num)exchangeItemCfg.needItemList.get(0)).itemId;
/* 106 */     SFivePreciousItem sFivePreciousItem = SFivePreciousItem.get(needItemid);
/* 107 */     if (sFivePreciousItem == null)
/*     */     {
/* 109 */       String logString = String.format("[item]PExchangeItem.processImp@SFivePreciousItem is null|roleid=%d|exchangecfgid=%d|needitemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.exchangecfgid), Integer.valueOf(needItemid) });
/*     */       
/*     */ 
/* 112 */       ItemManager.logger.error(logString);
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     boolean isNearNpc = NpcInterface.checkNpcService(sFivePreciousItem.npcid, sFivePreciousItem.npcservice, this.roleid);
/* 117 */     if (!isNearNpc)
/*     */     {
/* 119 */       String logString = String.format("[item]PExchangeItem.processImp@role is not near npc|roleid=%d|exchangecfgid=%d|needitemid=%d|npc=%d|npcservice=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.exchangecfgid), Integer.valueOf(needItemid), Integer.valueOf(sFivePreciousItem.npcid), Integer.valueOf(sFivePreciousItem.npcservice) });
/*     */       
/*     */ 
/* 122 */       ItemManager.logger.error(logString);
/* 123 */       return false;
/*     */     }
/* 125 */     int yuanbao = 0;
/* 126 */     for (NeedItemId2Num needItemId2Num : exchangeItemCfg.needItemList)
/*     */     {
/* 128 */       if (needItemId2Num.itemNum > 0)
/*     */       {
/*     */ 
/*     */ 
/* 132 */         int needNum = needItemId2Num.itemNum * this.exchangecount;
/*     */         
/* 134 */         int hasNum = itemBag.getItemNumberBycfgId(needItemId2Num.itemId);
/* 135 */         int toremovenum = 0;
/* 136 */         if (hasNum < needNum)
/*     */         {
/* 138 */           if (!sFivePreciousItem.isuseyuanbao)
/*     */           {
/* 140 */             String logString = String.format("[item]PExchangeItem.processImp@item not enough,not use yuanbao|roleid=%d|exchangecfgid=%d|needitemid=%d|neednum=%d|hasnum=%d|exchangecount=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.exchangecfgid), Integer.valueOf(needItemId2Num.itemId), Integer.valueOf(needNum), Integer.valueOf(hasNum), Integer.valueOf(this.exchangecount) });
/*     */             
/*     */ 
/* 143 */             ItemManager.logger.error(logString);
/* 144 */             return false;
/*     */           }
/*     */           
/*     */ 
/* 148 */           yuanbao += ItemInterface.getItemYuanBaoPrice(needItemId2Num.itemId) * (needNum - hasNum);
/* 149 */           toremovenum = hasNum;
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 155 */           toremovenum = needNum;
/*     */         }
/* 157 */         if (toremovenum > 0)
/*     */         {
/* 159 */           ItemOperateResult res = ItemInterface.removeItemsWithBindFirst(this.roleid, needItemId2Num.itemId, toremovenum, logArg);
/*     */           
/* 161 */           if (!res.success())
/*     */           {
/* 163 */             ItemManager.sendWrongInfo(this.roleid, 782, new String[0]);
/* 164 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 169 */     if (yuanbao != this.clientNeedYuanbao)
/*     */     {
/* 171 */       ItemManager.sendWrongInfo(this.roleid, 1156, new String[0]);
/* 172 */       String logString = String.format("[item]PExchangeItem.processImp@client need yuanbao not same as server |roleid=%d|exchangecfgid=%d|clientNeedYuanbao=%d|serveryuanbao=%d|exchangecount=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.exchangecfgid), Long.valueOf(this.clientNeedYuanbao), Integer.valueOf(yuanbao), Integer.valueOf(this.exchangecount) });
/*     */       
/*     */ 
/* 175 */       ItemManager.logger.error(logString);
/* 176 */       return false;
/*     */     }
/* 178 */     if (yuanbao > 0)
/*     */     {
/* 180 */       boolean ret = costYuanbao(userid, yuanbao, logArg);
/*     */       
/* 182 */       if (!ret)
/*     */       {
/* 184 */         String logString = String.format("[item]PExchangeItem.processImp@cost yuanbao error |roleid=%d|exchangecfgid=%d|clientNeedYuanbao=%d|serveryuanbao=%d|exchangecount=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.exchangecfgid), Long.valueOf(this.clientNeedYuanbao), Integer.valueOf(yuanbao), Integer.valueOf(this.exchangecount) });
/*     */         
/*     */ 
/* 187 */         ItemManager.logger.error(logString);
/* 188 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 192 */     addExchangeTimes(now, exchangeItemCfg.exchange_times_limit > 0, exchangeItemCfg.daily_exchange_times_limit > 0);
/*     */     
/* 194 */     return addItemAndSendResult(exchangeItemCfg, logArg);
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean addItemAndSendResult(SExchangeItemCfg exchangeItemCfg, TLogArg logArg)
/*     */   {
/* 200 */     int count = exchangeItemCfg.itemNum * this.exchangecount;
/* 201 */     if (count <= 0)
/*     */     {
/* 203 */       return false;
/*     */     }
/* 205 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, exchangeItemCfg.itemId, count, logArg);
/* 206 */     if (!result.success())
/*     */     {
/* 208 */       ItemInterface.sendSpecificBagFull(this.roleid, result.getFullBagId());
/* 209 */       return false;
/*     */     }
/*     */     
/* 212 */     SExchangeUseItemRes exchangeUseItemRes = new SExchangeUseItemRes();
/* 213 */     exchangeUseItemRes.exchangecfgid = this.exchangecfgid;
/* 214 */     exchangeUseItemRes.exchangecount = this.exchangecount;
/* 215 */     exchangeUseItemRes.itemid = exchangeItemCfg.itemId;
/* 216 */     exchangeUseItemRes.num = count;
/* 217 */     OnlineManager.getInstance().send(this.roleid, exchangeUseItemRes);
/* 218 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean costYuanbao(String userid, int yuanbaoNum, TLogArg logArg)
/*     */   {
/* 224 */     boolean ret = QingfuInterface.costYuanbao(userid, this.roleid, yuanbaoNum, CostType.COST_BIND_FIRST_ITEM_EXCHANGE_ITEM, logArg) == CostResult.Success;
/*     */     
/* 226 */     if (!ret)
/*     */     {
/* 228 */       ItemManager.sendWrongInfo(this.roleid, 781, new String[0]);
/* 229 */       return false;
/*     */     }
/* 231 */     return true;
/*     */   }
/*     */   
/*     */   private int getExchangeTimes()
/*     */   {
/* 236 */     RoleExchangeUseItemInfo xRoleExchangeUseItemInfo = Role_exchange_use_item_infos.get(Long.valueOf(this.roleid));
/* 237 */     if (xRoleExchangeUseItemInfo == null)
/*     */     {
/* 239 */       return 0;
/*     */     }
/* 241 */     ExchangeUseItemInfo xExchangeUseItemInfo = (ExchangeUseItemInfo)xRoleExchangeUseItemInfo.getExchange_use_item_infos().get(Integer.valueOf(this.exchangecfgid));
/*     */     
/* 243 */     if (xExchangeUseItemInfo == null)
/*     */     {
/* 245 */       return 0;
/*     */     }
/* 247 */     return xExchangeUseItemInfo.getExchange_times();
/*     */   }
/*     */   
/*     */   private int getDailyExchangeTimes(long now)
/*     */   {
/* 252 */     RoleExchangeUseItemInfo xRoleExchangeUseItemInfo = Role_exchange_use_item_infos.get(Long.valueOf(this.roleid));
/* 253 */     if (xRoleExchangeUseItemInfo == null)
/*     */     {
/* 255 */       return 0;
/*     */     }
/* 257 */     ExchangeUseItemInfo xExchangeUseItemInfo = (ExchangeUseItemInfo)xRoleExchangeUseItemInfo.getExchange_use_item_infos().get(Integer.valueOf(this.exchangecfgid));
/*     */     
/* 259 */     if (xExchangeUseItemInfo == null)
/*     */     {
/* 261 */       return 0;
/*     */     }
/* 263 */     if (DateTimeUtils.needDailyReset(xExchangeUseItemInfo.getTimestamp(), now, 0))
/*     */     {
/* 265 */       xExchangeUseItemInfo.setDaily_exchange_times(0);
/* 266 */       xExchangeUseItemInfo.setTimestamp(now);
/*     */     }
/* 268 */     return xExchangeUseItemInfo.getDaily_exchange_times();
/*     */   }
/*     */   
/*     */   private void addExchangeTimes(long now, boolean isExchangeTimesLimit, boolean isDailyExchangeTimesLimit)
/*     */   {
/* 273 */     if ((!isExchangeTimesLimit) && (!isDailyExchangeTimesLimit))
/*     */     {
/* 275 */       return;
/*     */     }
/* 277 */     RoleExchangeUseItemInfo xRoleExchangeUseItemInfo = Role_exchange_use_item_infos.get(Long.valueOf(this.roleid));
/* 278 */     if (xRoleExchangeUseItemInfo == null)
/*     */     {
/* 280 */       xRoleExchangeUseItemInfo = Pod.newRoleExchangeUseItemInfo();
/* 281 */       Role_exchange_use_item_infos.insert(Long.valueOf(this.roleid), xRoleExchangeUseItemInfo);
/*     */     }
/* 283 */     ExchangeUseItemInfo xExchangeUseItemInfo = (ExchangeUseItemInfo)xRoleExchangeUseItemInfo.getExchange_use_item_infos().get(Integer.valueOf(this.exchangecfgid));
/*     */     
/* 285 */     if (xExchangeUseItemInfo == null)
/*     */     {
/* 287 */       xExchangeUseItemInfo = Pod.newExchangeUseItemInfo();
/* 288 */       xExchangeUseItemInfo.setTimestamp(now);
/* 289 */       xRoleExchangeUseItemInfo.getExchange_use_item_infos().put(Integer.valueOf(this.exchangecfgid), xExchangeUseItemInfo);
/*     */     }
/* 291 */     if (DateTimeUtils.needDailyReset(xExchangeUseItemInfo.getTimestamp(), now, 0))
/*     */     {
/* 293 */       xExchangeUseItemInfo.setDaily_exchange_times(0);
/* 294 */       xExchangeUseItemInfo.setTimestamp(now);
/*     */     }
/* 296 */     if (isExchangeTimesLimit)
/*     */     {
/* 298 */       xExchangeUseItemInfo.setExchange_times(xExchangeUseItemInfo.getExchange_times() + this.exchangecount);
/*     */     }
/* 300 */     if (isDailyExchangeTimesLimit)
/*     */     {
/* 302 */       xExchangeUseItemInfo.setDaily_exchange_times(xExchangeUseItemInfo.getDaily_exchange_times() + this.exchangecount);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PExchangeItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */