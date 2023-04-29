/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.baitan.MyShoppingItem;
/*     */ import mzm.gsp.baitan.SSyncMyShopingItem;
/*     */ import mzm.gsp.baitan.confbean.BaiTanConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.Item;
/*     */ import xbean.RoleGrid;
/*     */ import xbean.ShoppingInfo;
/*     */ import xtable.Roleshoppinginfo;
/*     */ 
/*     */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  18 */     if (!BaiTanManager.isOpenForLevel(mzm.gsp.role.main.RoleInterface.getLevel(((Long)this.arg).longValue())))
/*     */     {
/*  20 */       return false;
/*     */     }
/*  22 */     RoleGrid roleGrid = xtable.Role2grid.get((Long)this.arg);
/*  23 */     if (roleGrid == null)
/*     */     {
/*  25 */       roleGrid = xbean.Pod.newRoleGrid();
/*  26 */       roleGrid.setMaxgridnum(BaiTanConsts.getInstance().DEFAULT_POS_NUM);
/*     */       
/*  28 */       xtable.Role2grid.add((Long)this.arg, roleGrid);
/*     */     }
/*  30 */     SSyncMyShopingItem my = new SSyncMyShopingItem();
/*  31 */     my.shopgridsize = roleGrid.getMaxgridnum();
/*     */     
/*  33 */     Set<Long> shoppis = roleGrid.getShoppingid2channelid().keySet();
/*  34 */     long now; xbean.Shoppoingid2Sessionid shoppoingid2Sessionid; Iterator i$; if (shoppis.size() > 0)
/*     */     {
/*  36 */       xdb.Lockeys.lock(Roleshoppinginfo.getTable(), shoppis);
/*  37 */       now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */       
/*  39 */       shoppoingid2Sessionid = xtable.Role2shoppingsession.get((Long)this.arg);
/*  40 */       if (shoppoingid2Sessionid == null)
/*     */       {
/*  42 */         shoppoingid2Sessionid = xbean.Pod.newShoppoingid2Sessionid();
/*  43 */         xtable.Role2shoppingsession.insert((Long)this.arg, shoppoingid2Sessionid);
/*     */       }
/*  45 */       for (i$ = shoppis.iterator(); i$.hasNext();) { long shoppingid = ((Long)i$.next()).longValue();
/*     */         
/*  47 */         ShoppingInfo shoppingInfo = Roleshoppinginfo.get(Long.valueOf(shoppingid));
/*     */         
/*  49 */         long expire = shoppingInfo.getExpire();
/*     */         
/*  51 */         MyShoppingItem myShoppingItem = new MyShoppingItem();
/*  52 */         int sellnum = shoppingInfo.getItem().getNumber();
/*  53 */         if (expire <= now)
/*     */         {
/*     */ 
/*  56 */           if ((roleGrid.getNeedrecycleshoppingids().contains(Long.valueOf(shoppingid))) && (sellnum > 0))
/*     */           {
/*     */ 
/*     */ 
/*  60 */             shoppingInfo.getItem().setNumber(0);
/*  61 */             BaiTanManager.fillMyShoppingItem(myShoppingItem, false, shoppingInfo, shoppingid);
/*     */             
/*  63 */             String logStr = String.format("[baitan]POnRoleLogin.processImp@recycle role baitan item success|roleid=%d|itemid=%d|shoppingid=%d|price=%d|num=%d", new Object[] { this.arg, Integer.valueOf(shoppingInfo.getItem().getCfgid()), Long.valueOf(shoppingid), Integer.valueOf(shoppingInfo.getPrice()), Integer.valueOf(sellnum) });
/*     */             
/*     */ 
/*  66 */             BaiTanManager.logger.info(logStr);
/*  67 */             BaiTanManager.tlogBaitanBuy(((Long)this.arg).longValue(), shoppingInfo.getItem().getCfgid(), sellnum, shoppingInfo.getPrice(), shoppingInfo.getRoleid());
/*     */             
/*  69 */             BaiTanManager.tlogBaitanBuyForIdip(0L, shoppingInfo.getRoleid(), shoppingInfo.getItem().getCfgid(), sellnum, shoppingInfo.getPrice(), shoppingInfo.getItem().getUuidAsData(), shoppingid);
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/*  75 */             BaiTanManager.fillMyShoppingItem(myShoppingItem, true, shoppingInfo, shoppingid);
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/*  81 */           if (sellnum > 0)
/*     */           {
/*  83 */             if (roleGrid.getNeedrecycleshoppingids().contains(Long.valueOf(shoppingid)))
/*     */             {
/*  85 */               BaiTanManager.startRecycleObserver(shoppoingid2Sessionid, ((Long)this.arg).longValue(), shoppingid, shoppingInfo.getExpire() - now);
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*  90 */               BaiTanManager.startObserver(shoppoingid2Sessionid, ((Long)this.arg).longValue(), shoppingid, shoppingInfo.getExpire() - now);
/*     */             }
/*     */           }
/*     */           
/*  94 */           BaiTanManager.fillMyShoppingItem(myShoppingItem, false, shoppingInfo, shoppingid);
/*     */         }
/*     */         
/*  97 */         my.myshoppingitemlist.add(myShoppingItem);
/*     */       }
/*     */     }
/* 100 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), my);
/*     */     
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */