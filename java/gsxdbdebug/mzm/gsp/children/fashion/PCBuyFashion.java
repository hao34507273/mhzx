/*     */ package mzm.gsp.children.fashion;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.SBuyFashionFailed;
/*     */ import mzm.gsp.children.SBuyFashionSuccess;
/*     */ import mzm.gsp.children.confbean.SFashionCfg;
/*     */ import mzm.gsp.children.main.ChildrenManager;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildFashionInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBuyFashion extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int fashionCfgid;
/*     */   
/*     */   public PCBuyFashion(long roleid, int fashionCfgid)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.fashionCfgid = fashionCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (this.fashionCfgid <= 0)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!FashionManager.isFunOpen(this.roleid))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!ChildrenManager.canDoAction(this.roleid, 800))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     SFashionCfg fashionCfg = SFashionCfg.get(this.fashionCfgid);
/*  56 */     if (fashionCfg == null)
/*     */     {
/*  58 */       onFailed(2);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     String userid = RoleInterface.getUserId(this.roleid);
/*  63 */     if (userid == null)
/*     */     {
/*  65 */       onFailed(4);
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     lock(Lockeys.get(User.getTable(), userid));
/*  71 */     Role2ChildrenInfo xRole2ChildrenInfo = ChildrenManager.initAndGetChildrenInfo(this.roleid);
/*  72 */     if (xRole2ChildrenInfo == null)
/*     */     {
/*  74 */       onFailed(1);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     ChildFashionInfo xChildFashionInfo = xRole2ChildrenInfo.getFashion_info();
/*  79 */     xbean.FashionInfo xFashionInfo = (xbean.FashionInfo)xChildFashionInfo.getFashions().get(Integer.valueOf(this.fashionCfgid));
/*  80 */     if (xFashionInfo != null)
/*     */     {
/*  82 */       xChildFashionInfo.getFashions().get(Integer.valueOf(this.fashionCfgid));
/*  83 */       Map<String, Object> extras = new HashMap();
/*  84 */       extras.put("start_time", Long.valueOf(xFashionInfo.getStart_time()));
/*  85 */       onFailed(3);
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     TLogArg tLogArg = new TLogArg(LogReason.CHILD_FASHION_BUY);
/*  91 */     if (!ItemInterface.removeItemById(this.roleid, fashionCfg.itemCfgid, fashionCfg.itemNum, tLogArg))
/*     */     {
/*  93 */       onFailed(-1);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  99 */     xFashionInfo = xbean.Pod.newFashionInfo();
/* 100 */     xFashionInfo.setStart_time(now);
/* 101 */     xChildFashionInfo.getFashions().put(Integer.valueOf(this.fashionCfgid), xFashionInfo);
/*     */     
/*     */ 
/* 104 */     int duration = fashionCfg.duration;
/* 105 */     if (duration > 0)
/*     */     {
/* 107 */       FashionManager.startFashionObserver(this.roleid, this.fashionCfgid, TimeUnit.HOURS.toSeconds(duration));
/*     */     }
/*     */     
/*     */ 
/* 111 */     addTlog(userid, fashionCfg.itemCfgid, fashionCfg.itemNum, duration);
/*     */     
/* 113 */     SBuyFashionSuccess resp = new SBuyFashionSuccess();
/* 114 */     resp.fashion_cfgid = this.fashionCfgid;
/* 115 */     resp.fashion_info = new mzm.gsp.children.FashionInfo((int)TimeUnit.MILLISECONDS.toSeconds(now));
/* 116 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 118 */     GameServer.logger().info(String.format("[childfashion]PCBuyFashion.processImp@buy fashion success|roleid=%d|fashion_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.fashionCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 127 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 132 */     if (retcode < 0)
/*     */     {
/* 134 */       SBuyFashionFailed resp = new SBuyFashionFailed();
/* 135 */       resp.retcode = retcode;
/* 136 */       resp.fashion_cfgid = this.fashionCfgid;
/* 137 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 140 */     StringBuffer logBuilder = new StringBuffer();
/* 141 */     logBuilder.append("[childfashion]PCBuyFashion.onFailed@buy fashion failed");
/* 142 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 143 */     logBuilder.append('|').append("fashion_cfgid=").append(this.fashionCfgid);
/* 144 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 146 */     if (extraParams != null)
/*     */     {
/* 148 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 150 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 154 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */   private void addTlog(String userid, int itemCfgid, int itemNum, int duration)
/*     */   {
/* 159 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 160 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 162 */     TLogManager.getInstance().addLog(userid, "ChildBuyFashionForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(this.fashionCfgid), Integer.valueOf(duration) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\PCBuyFashion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */