/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.idip.SItemSwitchChanged;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.HideItemInfo;
/*     */ import xbean.IdipConfigInfo;
/*     */ import xtable.Idipconfig;
/*     */ 
/*     */ public class ItemHideManager
/*     */ {
/*     */   static void init()
/*     */   {
/*  17 */     new PItemHideInit(null).call();
/*     */   }
/*     */   
/*     */   private static class PItemHideInit
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  25 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  26 */       if (xIdipConfigInfo == null)
/*     */       {
/*  28 */         return false;
/*     */       }
/*     */       
/*  31 */       Map<Integer, HideItemInfo> xHideItems = xIdipConfigInfo.getHide_items();
/*  32 */       if (xHideItems.isEmpty())
/*     */       {
/*  34 */         return false;
/*     */       }
/*     */       
/*  37 */       for (java.util.Map.Entry<Integer, HideItemInfo> xEntry : xHideItems.entrySet())
/*     */       {
/*  39 */         itemType = ((Integer)xEntry.getKey()).intValue();
/*  40 */         for (i$ = ((HideItemInfo)xEntry.getValue()).getItems().iterator(); i$.hasNext();) { int cfgid = ((Integer)i$.next()).intValue();
/*     */           
/*  42 */           ItemHideCache.getInstance().put(itemType, cfgid);
/*     */         } }
/*     */       int itemType;
/*     */       Iterator i$;
/*  46 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean itemHide(int itemType, int cfgid, boolean hide)
/*     */   {
/*  52 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  53 */     if (xIdipConfigInfo == null)
/*     */     {
/*  55 */       xIdipConfigInfo = xbean.Pod.newIdipConfigInfo();
/*  56 */       Idipconfig.add(Long.valueOf(GameServerInfoManager.getLocalId()), xIdipConfigInfo);
/*     */     }
/*     */     
/*  59 */     HideItemInfo xHideItemInfo = (HideItemInfo)xIdipConfigInfo.getHide_items().get(Integer.valueOf(itemType));
/*  60 */     if (xHideItemInfo == null)
/*     */     {
/*  62 */       xHideItemInfo = xbean.Pod.newHideItemInfo();
/*  63 */       xIdipConfigInfo.getHide_items().put(Integer.valueOf(itemType), xHideItemInfo);
/*     */     }
/*     */     
/*  66 */     boolean result = false;
/*  67 */     if (hide)
/*     */     {
/*  69 */       xHideItemInfo.getItems().add(Integer.valueOf(cfgid));
/*  70 */       result = ItemHideCache.getInstance().put(itemType, cfgid);
/*     */     }
/*     */     else
/*     */     {
/*  74 */       xHideItemInfo.getItems().remove(Integer.valueOf(cfgid));
/*  75 */       result = ItemHideCache.getInstance().remove(itemType, cfgid);
/*     */     }
/*     */     
/*  78 */     if (result)
/*     */     {
/*     */ 
/*     */ 
/*  82 */       SItemSwitchChanged msg = new SItemSwitchChanged();
/*  83 */       msg.info.item_type = itemType;
/*  84 */       msg.info.cfgid = cfgid;
/*  85 */       msg.info.isopen = ((byte)(hide ? 0 : 1));
/*  86 */       OnlineManager.getInstance().sendAll(msg);
/*     */     }
/*     */     
/*  89 */     mzm.gsp.GameServer.logger().info(String.format("[idip]ItemHideManager.itemHide@item hide|item_type=%d|cfgid=%d|hide=%b|result=%b", new Object[] { Integer.valueOf(itemType), Integer.valueOf(cfgid), Boolean.valueOf(hide), Boolean.valueOf(result) }));
/*     */     
/*     */ 
/*  92 */     return result;
/*     */   }
/*     */   
/*     */   static boolean isHide(int itemType, int cfgid)
/*     */   {
/*  97 */     return ItemHideCache.getInstance().isHide(itemType, cfgid);
/*     */   }
/*     */   
/*     */   static void onRoleLogin(long roleid)
/*     */   {
/* 102 */     mzm.gsp.idip.SyncItemSwitches msg = new mzm.gsp.idip.SyncItemSwitches();
/* 103 */     ItemHideCache.getInstance().fillInfos(msg);
/* 104 */     OnlineManager.getInstance().send(roleid, msg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\ItemHideManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */