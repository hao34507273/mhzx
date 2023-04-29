/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.instance.SInstanceNormalResult;
/*     */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.InstanceBean;
/*     */ 
/*     */ class InstanceManager
/*     */ {
/*     */   static final int ENTER = 2;
/*     */   static final int FINISH = 3;
/*     */   static final int LEAVE = 4;
/*     */   static final int FAIL = 5;
/*     */   static final int MODE_SINGLE = 1;
/*     */   static final int MODE_MULTI = 2;
/*     */   
/*     */   static void init()
/*     */   {
/*  24 */     SingleInstance.init();
/*  25 */     TeamInstance.init();
/*     */   }
/*     */   
/*     */   static void postInit() {
/*     */     try {
/*  30 */       SingleInstance.postinit();
/*  31 */       TeamInstance.postinit();
/*     */     } catch (Exception e) {
/*  33 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static EnterInstanceResult canEnterInstance(List<Long> roleids, int instancecfgid)
/*     */   {
/*  48 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instancecfgid);
/*  49 */     if (instanceCfg == null) {
/*  50 */       if (GameServer.logger().isDebugEnabled())
/*  51 */         GameServer.logger().debug("副本配置信息不存在!!!");
/*  52 */       EnterInstanceResult enterInstanceResult = new EnterInstanceResult(false);
/*  53 */       enterInstanceResult.setReason(EnterInstanceResult.Reason.UNKNOW);
/*  54 */       return enterInstanceResult;
/*     */     }
/*  56 */     int count = roleids.size();
/*     */     
/*  58 */     if (instanceCfg.memberCount > count) {
/*  59 */       EnterInstanceResult enterInstanceResult = new EnterInstanceResult(false);
/*  60 */       enterInstanceResult.setReason(EnterInstanceResult.Reason.PersonCount);
/*  61 */       return enterInstanceResult;
/*     */     }
/*     */     
/*  64 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  65 */       int level = RoleInterface.getLevel(roleid);
/*  66 */       if (level < instanceCfg.level) {
/*  67 */         EnterInstanceResult enterInstanceResult = new EnterInstanceResult(false);
/*  68 */         enterInstanceResult.setReason(EnterInstanceResult.Reason.RoleLevel);
/*  69 */         enterInstanceResult.setRoleid(roleid);
/*  70 */         return enterInstanceResult;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  82 */     if (instanceCfg.itemid > 0) {
/*  83 */       int num = mzm.gsp.item.main.ItemInterface.getItemNumberById(((Long)roleids.get(0)).longValue(), 340600000, instanceCfg.itemid, false);
/*  84 */       if (num <= 0) {
/*  85 */         EnterInstanceResult enterInstanceResult = new EnterInstanceResult(false);
/*  86 */         enterInstanceResult.setReason(EnterInstanceResult.Reason.ItemNotEnough);
/*  87 */         return enterInstanceResult;
/*     */       }
/*     */     }
/*  90 */     return new EnterInstanceResult(true);
/*     */   }
/*     */   
/*     */   static void sendNormalRet(List<Long> roleids, int ret, String... args) {
/*  94 */     SInstanceNormalResult instanceNormalResult = new SInstanceNormalResult();
/*  95 */     instanceNormalResult.result = ret;
/*  96 */     for (String arg : args) {
/*  97 */       instanceNormalResult.args.add(arg);
/*     */     }
/*  99 */     OnlineManager.getInstance().sendMultiAtOnce(instanceNormalResult, roleids);
/*     */   }
/*     */   
/*     */   static void sendNormalRet(long roleid, int ret, String... args) {
/* 103 */     sendNormalRet(java.util.Arrays.asList(new Long[] { Long.valueOf(roleid) }), ret, args);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initInstanceBean(InstanceBean xInstanceBean, long time) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void logInstance(long roleid, long instanceUUid, int instanceCfgid, int status, long passtime, int processid, int mode)
/*     */   {
/* 129 */     int platform = RoleInterface.getPlatform(roleid);
/* 130 */     String channel = RoleInterface.getChannel(roleid);
/* 131 */     String mac = RoleInterface.getMac(roleid);
/*     */     
/* 133 */     String userid = RoleInterface.getUserId(roleid);
/* 134 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/*     */ 
/*     */ 
/* 138 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%s|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(platform), channel, mac, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Long.valueOf(instanceUUid), Integer.valueOf(instanceCfgid), Integer.valueOf(status), Long.valueOf(passtime), Integer.valueOf(processid), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(mode) });
/*     */     
/*     */ 
/* 141 */     mzm.gsp.util.LogManager.getInstance().addLog("instance", logStr);
/*     */   }
/*     */   
/*     */   static void tlogInstance(long roleid, long instanceUUid, int instanceCfgid, int status, long passtime, int processid)
/*     */   {
/* 146 */     String userid = RoleInterface.getUserId(roleid);
/* 147 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/*     */ 
/* 150 */     String logStr = String.format("%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Long.valueOf(instanceUUid), Integer.valueOf(instanceCfgid), Integer.valueOf(status), Long.valueOf(passtime), Integer.valueOf(processid) });
/*     */     
/* 152 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleid, "Instance", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\InstanceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */