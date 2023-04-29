/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.cat.SCatRecoveryToItemFailed;
/*     */ import mzm.gsp.cat.SRecoveryCatToItemSuccess;
/*     */ import mzm.gsp.cat.event.CatRecoveryToItem;
/*     */ import mzm.gsp.cat.event.CatRecoveryToItemArg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.item.main.CatItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CatBag;
/*     */ import xbean.CatInfo;
/*     */ import xbean.Item;
/*     */ import xtable.Role2catbag;
/*     */ 
/*     */ public class PCRecoveryCatToItem extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private long catid;
/*     */   
/*     */   public PCRecoveryCatToItem(long roleid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!CatManager.isFunOpen(this.roleid))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     if (!CatManager.checkRoleStatus(this.roleid))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  51 */       onFailed(6);
/*  52 */       return false;
/*     */     }
/*  54 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  55 */     if (worldid < 0L)
/*     */     {
/*  57 */       onFailed(11);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     CatInfo xCatInfo = CatManager.getHomelandCat(this.roleid, true);
/*  63 */     if (xCatInfo == null)
/*     */     {
/*  65 */       onFailed(4);
/*  66 */       return false;
/*     */     }
/*  68 */     this.catid = xCatInfo.getId();
/*     */     
/*     */ 
/*  71 */     if (!CatManager.checkNpcService(this.roleid, xCatInfo))
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     if (!CatManager.checkState(xCatInfo))
/*     */     {
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     if (xCatInfo.getState() == 2)
/*     */     {
/*  85 */       Map<String, Object> extras = new HashMap();
/*  86 */       extras.put("current_state", Integer.valueOf(xCatInfo.getState()));
/*  87 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/*  88 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/*     */       
/*  90 */       onFailed(-1, extras);
/*  91 */       return false;
/*     */     }
/*  93 */     if (xCatInfo.getState() == 3)
/*     */     {
/*  95 */       Map<String, Object> extras = new HashMap();
/*  96 */       extras.put("current_state", Integer.valueOf(xCatInfo.getState()));
/*  97 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/*  98 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/*     */       
/* 100 */       onFailed(-2, extras);
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     if ((xCatInfo.getExplored_level() != 0) || (xCatInfo.getExplored_partner_cfgid() != 0))
/*     */     {
/* 107 */       Map<String, Object> extras = new HashMap();
/* 108 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 109 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/* 110 */       extras.put("explored_level", Integer.valueOf(xCatInfo.getExplored_level()));
/* 111 */       extras.put("explored_partner_cfgid", Integer.valueOf(xCatInfo.getExplored_partner_cfgid()));
/*     */       
/* 113 */       onFailed(-3, extras);
/* 114 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 118 */     if (ItemInterface.isBagFull(this.roleid, 340600000, true))
/*     */     {
/* 120 */       Map<String, Object> extras = new HashMap();
/* 121 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 122 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/*     */       
/* 124 */       onFailed(-4, extras);
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     CatBag xCatBag = Role2catbag.get(Long.valueOf(this.roleid));
/* 129 */     Item xItem = (Item)xCatBag.getItems().remove(Long.valueOf(this.catid));
/*     */     
/* 131 */     Item xNewItem = xItem.toBean();
/* 132 */     CatItem catItem = new CatItem(xNewItem);
/* 133 */     int curLevel = CatManager.getCatLevel(xCatInfo);
/* 134 */     if (curLevel < 0)
/*     */     {
/* 136 */       return false;
/*     */     }
/* 138 */     catItem.setLevel(curLevel);
/*     */     
/* 140 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.ITEM_CAT_RECOVERY);
/* 141 */     if (!ItemInterface.addItem(this.roleid, xNewItem, logArg))
/*     */     {
/* 143 */       Map<String, Object> extras = new HashMap();
/* 144 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 145 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/*     */       
/* 147 */       onFailed(8, extras);
/* 148 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 152 */     CatManager.addRecoveryCatToItemTLog(this.roleid, this.catid, xCatInfo.getCat_level_cfgid(), xCatInfo.getItem_cfgid(), xCatInfo.getTotal_explore_num(), xCatInfo.getVigor(), xCatInfo.getState(), true, 0, 0, 2);
/*     */     
/*     */ 
/*     */ 
/* 156 */     CatRecoveryToItem catRecoveryToItemEvent = new CatRecoveryToItem();
/* 157 */     TriggerEventsManger.getInstance().triggerEvent(catRecoveryToItemEvent, new CatRecoveryToItemArg(this.roleid, this.catid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/* 161 */     SRecoveryCatToItemSuccess resp = new SRecoveryCatToItemSuccess();
/* 162 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 164 */     GameServer.logger().info(String.format("[cat]PCRecoveryCatToItem.processImp@recovery cat to item success|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()) }));
/*     */     
/*     */ 
/*     */ 
/* 168 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 173 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 178 */     if (retcode < 0)
/*     */     {
/* 180 */       SCatRecoveryToItemFailed resp = new SCatRecoveryToItemFailed();
/* 181 */       resp.retcode = retcode;
/* 182 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 185 */     StringBuffer logBuilder = new StringBuffer();
/* 186 */     logBuilder.append("[cat]PCRecoveryCatToItem.onFailed@recovery cat to item failed");
/* 187 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 188 */     logBuilder.append('|').append("catid=").append(this.catid);
/* 189 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 191 */     if (extraParams != null)
/*     */     {
/* 193 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 195 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 199 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PCRecoveryCatToItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */