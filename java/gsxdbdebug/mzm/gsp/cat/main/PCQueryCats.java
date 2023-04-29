/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.cat.SQueryCatsFailed;
/*     */ import mzm.gsp.cat.SQueryCatsSuccess;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PCQueryCats extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetRoleid;
/*     */   private final long catid;
/*     */   
/*     */   public PCQueryCats(long roleid, long targetRoleid, long catid)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.targetRoleid = targetRoleid;
/*  26 */     this.catid = catid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if ((this.targetRoleid <= 0L) || (this.catid <= 0L))
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
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
/*  49 */     if (!HomelandInterface.hasHome(this.targetRoleid))
/*     */     {
/*  51 */       onFailed(6);
/*  52 */       return false;
/*     */     }
/*  54 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.targetRoleid, false);
/*  55 */     if (worldid < 0L)
/*     */     {
/*  57 */       onFailed(11);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     
/*     */ 
/*  64 */     xbean.CatInfo xTargetCatInfo = CatManager.getHomelandCat(this.targetRoleid, true);
/*  65 */     if (xTargetCatInfo == null)
/*     */     {
/*  67 */       onFailed(-1);
/*  68 */       return false;
/*     */     }
/*  70 */     if (xTargetCatInfo.getId() != this.catid)
/*     */     {
/*  72 */       Map<String, Object> extras = new HashMap();
/*  73 */       extras.put("target_catid", Long.valueOf(xTargetCatInfo.getId()));
/*  74 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/*  75 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/*     */       
/*  77 */       onFailed(2, extras);
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     if (!CatManager.checkNpcService(this.roleid, xTargetCatInfo))
/*     */     {
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     if (!CatManager.checkState(xTargetCatInfo))
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     CatManager.checkDailyExploreNum(xTargetCatInfo);
/*     */     
/*  95 */     mzm.gsp.cat.CatInfo targetCatInfo = CatManager.fillCatInfo(xTargetCatInfo);
/*     */     
/*     */ 
/*  98 */     int num = CatManager.queryFeedNum(this.roleid, this.targetRoleid);
/*     */     
/* 100 */     SQueryCatsSuccess resp = new SQueryCatsSuccess();
/* 101 */     resp.target_roleid = this.targetRoleid;
/* 102 */     resp.cat_info = targetCatInfo;
/* 103 */     resp.feed_num = num;
/* 104 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 106 */     GameServer.logger().info(String.format("[cat]PCQueryCats.processImp@query cat success|roleid=%d|target_roleid=%d|catid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid), Long.valueOf(this.catid) }));
/*     */     
/*     */ 
/*     */ 
/* 110 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 115 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 120 */     if (retcode < 0)
/*     */     {
/* 122 */       SQueryCatsFailed resp = new SQueryCatsFailed();
/* 123 */       resp.target_roleid = this.targetRoleid;
/* 124 */       resp.catid = this.catid;
/* 125 */       resp.retcode = retcode;
/* 126 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 129 */     StringBuffer logBuilder = new StringBuffer();
/* 130 */     logBuilder.append("[cat]PCQueryCats.onFailed@query cat failed");
/* 131 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 132 */     logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 133 */     logBuilder.append('|').append("catid=").append(this.catid);
/* 134 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 136 */     if (extraParams != null)
/*     */     {
/* 138 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 140 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 144 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PCQueryCats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */