/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.cat.FeedInfo;
/*     */ import mzm.gsp.cat.SQueryFeedCatsFailed;
/*     */ import mzm.gsp.cat.SQueryFeedCatsSuccess;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.CatInfo;
/*     */ import xbean.RoleFeedInfo;
/*     */ 
/*     */ public class PCQueryFeedCats extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetRoleid;
/*     */   private final long catid;
/*     */   
/*     */   public PCQueryFeedCats(long roleid, long targetRoleid, long catid)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.targetRoleid = targetRoleid;
/*  30 */     this.catid = catid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if ((this.targetRoleid <= 0L) || (this.catid <= 0L))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!CatManager.isFunOpen(this.roleid))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     if (!CatManager.checkRoleStatus(this.roleid))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     if (!HomelandInterface.hasHome(this.targetRoleid))
/*     */     {
/*  55 */       onFailed(6);
/*  56 */       return false;
/*     */     }
/*  58 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.targetRoleid, false);
/*  59 */     if (worldid < 0L)
/*     */     {
/*  61 */       onFailed(11);
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     CatInfo xTargetCatInfo = CatManager.getHomelandCat(this.targetRoleid, true);
/*  67 */     if (xTargetCatInfo == null)
/*     */     {
/*  69 */       onFailed(4);
/*  70 */       return false;
/*     */     }
/*  72 */     if (xTargetCatInfo.getId() != this.catid)
/*     */     {
/*  74 */       Map<String, Object> extras = new HashMap();
/*  75 */       extras.put("target_catid", Long.valueOf(xTargetCatInfo.getId()));
/*  76 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/*  77 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/*     */       
/*  79 */       onFailed(2, extras);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     if (!CatManager.checkNpcService(this.roleid, xTargetCatInfo))
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     if (!CatManager.checkState(xTargetCatInfo))
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (xTargetCatInfo.getState() == 2)
/*     */     {
/*  97 */       Map<String, Object> extras = new HashMap();
/*  98 */       extras.put("current_state", Integer.valueOf(xTargetCatInfo.getState()));
/*  99 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 100 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/*     */       
/* 102 */       onFailed(5, extras);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     SQueryFeedCatsSuccess resp = new SQueryFeedCatsSuccess();
/* 107 */     resp.catid = this.catid;
/* 108 */     resp.target_roleid = this.targetRoleid;
/* 109 */     resp.feeds = fillFeedInfos(xTargetCatInfo.getRecords());
/* 110 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 112 */     return true;
/*     */   }
/*     */   
/*     */   private ArrayList<FeedInfo> fillFeedInfos(List<RoleFeedInfo> xList)
/*     */   {
/* 117 */     if (xList.isEmpty())
/*     */     {
/* 119 */       return new ArrayList();
/*     */     }
/*     */     
/* 122 */     ArrayList<FeedInfo> result = new ArrayList(xList.size());
/* 123 */     ListIterator<RoleFeedInfo> xListIterator = xList.listIterator(xList.size());
/* 124 */     while (xListIterator.hasPrevious())
/*     */     {
/* 126 */       RoleFeedInfo xRoleFeedInfo = (RoleFeedInfo)xListIterator.previous();
/* 127 */       FeedInfo feedInfo = new FeedInfo();
/* 128 */       feedInfo.feed_timestamp = ((int)(xRoleFeedInfo.getFeed_timestamp() / 1000L));
/* 129 */       feedInfo.roleid = xRoleFeedInfo.getRoleid();
/*     */       try
/*     */       {
/* 132 */         feedInfo.role_name.setString(xRoleFeedInfo.getRole_name(), "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {}
/*     */       
/*     */ 
/*     */ 
/* 138 */       result.add(feedInfo);
/*     */     }
/*     */     
/* 141 */     return result;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 146 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 151 */     if (retcode < 0)
/*     */     {
/* 153 */       SQueryFeedCatsFailed resp = new SQueryFeedCatsFailed();
/* 154 */       resp.target_roleid = this.targetRoleid;
/* 155 */       resp.catid = this.catid;
/* 156 */       resp.retcode = retcode;
/* 157 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 160 */     StringBuffer logBuilder = new StringBuffer();
/* 161 */     logBuilder.append("[cat]PCQueryFeedCats.onFailed@query feed cats failed");
/* 162 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 163 */     logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 164 */     logBuilder.append('|').append("catid=").append(this.catid);
/* 165 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 167 */     if (extraParams != null)
/*     */     {
/* 169 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 171 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 175 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PCQueryFeedCats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */