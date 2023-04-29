/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CatBag;
/*     */ import xbean.CatInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Catexploreobservers;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  22 */     if (mzm.gsp.GameServerInfoManager.isRoamServer())
/*     */     {
/*  24 */       return false;
/*     */     }
/*     */     
/*  27 */     long roleid = ((Long)this.arg).longValue();
/*     */     
/*  29 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*  30 */     if (userid == null)
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  36 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/*  37 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*     */     
/*  39 */     CatBag xCatBag = xtable.Role2catbag.get(Long.valueOf(roleid));
/*  40 */     if (xCatBag == null)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     Iterator<Map.Entry<Long, CatInfo>> xIterator = xCatBag.getCats().entrySet().iterator();
/*  47 */     while (xIterator.hasNext())
/*     */     {
/*  49 */       Map.Entry<Long, CatInfo> xEntry = (Map.Entry)xIterator.next();
/*  50 */       long xCatid = ((Long)xEntry.getKey()).longValue();
/*  51 */       if ((!xCatBag.getItems().containsKey(Long.valueOf(xCatid))) && 
/*     */       
/*     */ 
/*     */ 
/*  55 */         (ItemInterface.getItemByUuid(roleid, 340600000, xCatid, true) == null) && 
/*     */         
/*     */ 
/*     */ 
/*  59 */         (ItemInterface.getItemByUuidFromStorage(roleid, xCatid, true) == null))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  64 */         CatInfo xCatInfo = (CatInfo)xEntry.getValue();
/*     */         
/*  66 */         GameServer.logger().info(String.format("[cat]POnRemoveItem.processImp@remove cat item|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|total_explore_num=%d|vigor=%d|state=%d|partner_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(xCatid), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getTotal_explore_num()), Integer.valueOf(xCatInfo.getVigor()), Integer.valueOf(xCatInfo.getState()), Integer.valueOf(xCatInfo.getPartner_cfgid()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  73 */         CatManager.addSystemRecoveryCatItemTlog(roleid, xCatid, xCatInfo.getCat_level_cfgid(), xCatInfo.getItem_cfgid(), xCatInfo.getTotal_explore_num(), xCatInfo.getVigor(), xCatInfo.getState(), xCatInfo.getPartner_cfgid());
/*     */         
/*     */ 
/*  76 */         xIterator.remove();
/*     */       }
/*     */     }
/*     */     
/*  80 */     CatInfo xCatInfo = CatManager.getHomelandCat(roleid, true);
/*  81 */     if (xCatInfo == null)
/*     */     {
/*  83 */       return true;
/*     */     }
/*  85 */     long catid = xCatInfo.getId();
/*     */     
/*     */ 
/*  88 */     lock(Lockeys.get(Catexploreobservers.getTable(), Long.valueOf(catid)));
/*     */     
/*  90 */     if (!mzm.gsp.homeland.main.HomelandInterface.hasHome(roleid))
/*     */     {
/*     */ 
/*  93 */       CatManager.onHomelandNone(userid, roleid, xCatInfo);
/*     */     }
/*     */     else
/*     */     {
/*  97 */       if (xCatInfo.getState() != 2)
/*     */       {
/*  99 */         return true;
/*     */       }
/* 101 */       if (Catexploreobservers.get(Long.valueOf(catid)) != null)
/*     */       {
/* 103 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 107 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 108 */       long exploreEndTime = xCatInfo.getExplore_endtime();
/* 109 */       if (exploreEndTime > now)
/*     */       {
/*     */ 
/* 112 */         long delaySeconds = TimeUnit.MILLISECONDS.toSeconds(exploreEndTime - now);
/* 113 */         CatManager.exploreObserver(roleid, catid, delaySeconds);
/*     */ 
/*     */ 
/*     */       }
/* 117 */       else if (!CatManager.restStateAndSendMail(roleid, xCatInfo))
/*     */       {
/* 119 */         GameServer.logger().error(String.format("[cat]POnRoleLogin.processImp@rest state and send mail failed|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|state=%d|mail_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getState()), Integer.valueOf(SCatCfgConsts.getInstance().CAT_EXPLORE_END_MAIL_CFG_ID) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 124 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 129 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */