/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.cat.SGetAwardFailed;
/*     */ import mzm.gsp.cat.SGetAwardSuccess;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CatBag;
/*     */ import xbean.CatInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2catbag;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private String userid;
/*     */   private long catid;
/*     */   
/*     */   public PCGetAward(long roleid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!CatManager.isFunOpen(this.roleid))
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     if (!CatManager.checkRoleStatus(this.roleid))
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     this.userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  45 */     if (this.userid == null)
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  53 */       onFailed(6);
/*  54 */       return false;
/*     */     }
/*  56 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  57 */     if (worldid < 0L)
/*     */     {
/*  59 */       onFailed(11);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     lock(Lockeys.get(User.getTable(), this.userid));
/*  65 */     CatBag xCatBag = Role2catbag.get(Long.valueOf(this.roleid));
/*  66 */     if (xCatBag == null)
/*     */     {
/*  68 */       onFailed(4);
/*  69 */       return false;
/*     */     }
/*  71 */     CatInfo xCatInfo = CatManager.getHomelandCat(this.roleid, true);
/*  72 */     if (xCatInfo == null)
/*     */     {
/*  74 */       onFailed(4);
/*  75 */       return false;
/*     */     }
/*  77 */     this.catid = xCatInfo.getId();
/*     */     
/*     */ 
/*  80 */     if (!CatManager.checkNpcService(this.roleid, xCatInfo))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     if (!CatManager.checkState(xCatInfo))
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (xCatInfo.getState() == 2)
/*     */     {
/*     */ 
/*  94 */       Map<String, Object> extras = new HashMap();
/*  95 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/*  96 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/*  97 */       extras.put("current_state", Integer.valueOf(xCatInfo.getState()));
/*     */       
/*  99 */       onFailed(5, extras);
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     int exploredLevel = xCatInfo.getExplored_level();
/* 105 */     int exploredPartnerCfgid = xCatInfo.getExplored_partner_cfgid();
/* 106 */     if ((exploredLevel == 0) && (exploredPartnerCfgid == 0))
/*     */     {
/*     */ 
/* 109 */       Map<String, Object> extras = new HashMap();
/* 110 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 111 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/* 112 */       extras.put("explored_level", Integer.valueOf(exploredLevel));
/* 113 */       extras.put("explored_partner_cfgid", Integer.valueOf(exploredPartnerCfgid));
/*     */       
/* 115 */       onFailed(-1, extras);
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     if (ItemInterface.isBagFull(this.roleid, 340600000, true))
/*     */     {
/* 122 */       onFailed(-2);
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     Map<Integer, Integer> items = CatManager.sendExploreAward(this.userid, this.roleid, this.catid, exploredLevel, exploredPartnerCfgid, true);
/*     */     
/* 129 */     if (items == null)
/*     */     {
/* 131 */       Map<String, Object> extras = new HashMap();
/* 132 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 133 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/* 134 */       extras.put("explored_level", Integer.valueOf(exploredLevel));
/* 135 */       extras.put("explored_partner_cfgid", Integer.valueOf(exploredPartnerCfgid));
/*     */       
/* 137 */       onFailed(7, extras);
/* 138 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 142 */     xCatInfo.setExplored_level(0);
/* 143 */     xCatInfo.setExplored_partner_cfgid(0);
/*     */     
/*     */ 
/* 146 */     CatManager.recordAwardItem(this.roleid, this.catid, xCatBag, items);
/*     */     
/* 148 */     SGetAwardSuccess resp = new SGetAwardSuccess();
/* 149 */     resp.item2num = new HashMap(items);
/* 150 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 152 */     GameServer.logger().info(String.format("[cat]PCGetAward.processImp@get award success|roleid=%d|catid=%d|explored_level=%d|explored_partner_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid), Integer.valueOf(exploredLevel), Integer.valueOf(exploredPartnerCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 156 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 161 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 166 */     if (retcode < 0)
/*     */     {
/* 168 */       SGetAwardFailed resp = new SGetAwardFailed();
/* 169 */       resp.retcode = retcode;
/* 170 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 173 */     StringBuffer logBuilder = new StringBuffer();
/* 174 */     logBuilder.append("[cat]PCGetAward.onFailed@get award failed");
/* 175 */     logBuilder.append('|').append("userid=").append(this.userid);
/* 176 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 177 */     logBuilder.append('|').append("catid=").append(this.catid);
/* 178 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 180 */     if (extraParams != null)
/*     */     {
/* 182 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 184 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 188 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PCGetAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */