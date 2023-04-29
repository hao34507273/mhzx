/*     */ package mzm.gsp.bless.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.bless.confbean.SBlessCfg;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Bless;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2bless;
/*     */ 
/*     */ public class BlessManager
/*     */ {
/*     */   static void init()
/*     */   {
/*  25 */     ActivityInterface.registerActivityByLogicType(92, new BlessActivityHandler(), false);
/*     */   }
/*     */   
/*     */   static boolean canDoAction(long roleid, int action)
/*     */   {
/*  30 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*     */   }
/*     */   
/*     */   static boolean isFunOpen()
/*     */   {
/*  35 */     if (!OpenInterface.getOpenStatus(329))
/*     */     {
/*  37 */       GameServer.logger().error("[bless]BlessManager.isFunOpen@fun not open");
/*  38 */       return false;
/*     */     }
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isFunOpen(long roleid)
/*     */   {
/*  45 */     if (!OpenInterface.getOpenStatus(329))
/*     */     {
/*  47 */       GameServer.logger().error("[bless]BlessManager.isFunOpen@fun not open");
/*  48 */       return false;
/*     */     }
/*  50 */     if (OpenInterface.isBanPlay(roleid, 329))
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[bless]BlessManager.isFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*  53 */       OpenInterface.sendBanPlayMsg(roleid, 329);
/*  54 */       return false;
/*     */     }
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   static void initData(String userid, long roleid, int activityCfgid)
/*     */   {
/*  61 */     Bless xBless = Role2bless.get(Long.valueOf(roleid));
/*  62 */     if (xBless == null)
/*     */     {
/*  64 */       xBless = Pod.newBless();
/*  65 */       Role2bless.insert(Long.valueOf(roleid), xBless);
/*     */     }
/*     */     
/*  68 */     xbean.BlessInfo xBlessInfo = (xbean.BlessInfo)xBless.getBless_infos().get(Integer.valueOf(activityCfgid));
/*  69 */     if (xBlessInfo == null)
/*     */     {
/*  71 */       xBlessInfo = Pod.newBlessInfo();
/*  72 */       xBless.getBless_infos().put(Integer.valueOf(activityCfgid), xBlessInfo);
/*     */     }
/*     */     
/*  75 */     GameServer.logger().info(String.format("[bless]BlessManager.initData@init data success|userid=%s|roleid=%d|activity_cfgid=%d|num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(xBlessInfo.getNum()) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static xbean.BlessInfo getBlessInfo(long roleid, int activityCfgid)
/*     */   {
/*  82 */     Bless xBless = Role2bless.get(Long.valueOf(roleid));
/*  83 */     if (xBless == null)
/*     */     {
/*  85 */       return null;
/*     */     }
/*  87 */     return (xbean.BlessInfo)xBless.getBless_infos().get(Integer.valueOf(activityCfgid));
/*     */   }
/*     */   
/*     */   static void checkBlessTime(xbean.BlessInfo xBlessInfo, long time)
/*     */   {
/*  92 */     if (DateTimeUtils.needDailyReset(xBlessInfo.getLast_time(), time, 0, 0))
/*     */     {
/*  94 */       xBlessInfo.setNum(0);
/*  95 */       xBlessInfo.setLast_time(time);
/*     */     }
/*     */   }
/*     */   
/*     */   static void fillBlessInfo(mzm.gsp.bless.BlessInfo blessInfo, xbean.BlessInfo xBlessInfo)
/*     */   {
/* 101 */     blessInfo.num = xBlessInfo.getNum();
/* 102 */     blessInfo.last_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xBlessInfo.getLast_time()));
/*     */   }
/*     */   
/*     */   static void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 107 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 108 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 109 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 111 */     StringBuilder logStr = new StringBuilder();
/* 112 */     logStr.append(vGameIp);
/* 113 */     logStr.append("|").append(userid);
/* 114 */     logStr.append("|").append(roleid);
/* 115 */     logStr.append("|").append(roleLevel);
/*     */     
/* 117 */     for (Object colum : logColumns)
/*     */     {
/* 119 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 122 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */   
/*     */   static int getNpcController(int activityCfgid)
/*     */   {
/* 127 */     SBlessCfg blessCfg = SBlessCfg.get(activityCfgid);
/* 128 */     if (blessCfg == null)
/*     */     {
/* 130 */       GameServer.logger().error(String.format("[bless]BlessManager.getNpcController@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*     */       
/* 132 */       return -1;
/*     */     }
/* 134 */     SNpc npc = NpcInterface.getNpc(blessCfg.npcCfgid);
/* 135 */     if (npc == null)
/*     */     {
/* 137 */       GameServer.logger().error(String.format("[bless]BlessManager.getNpcController@npc cfg is null|activity_cfgid=%d|npc_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(blessCfg.npcCfgid) }));
/*     */       
/*     */ 
/* 140 */       return -1;
/*     */     }
/* 142 */     return npc.controllerId;
/*     */   }
/*     */   
/*     */   static void onOpenChange(int activityCfgid, boolean open)
/*     */   {
/* 147 */     if (!ActivityInterface.isActivityOpen(activityCfgid))
/*     */     {
/* 149 */       return;
/*     */     }
/*     */     
/* 152 */     int controller = getNpcController(activityCfgid);
/* 153 */     if (controller <= 0)
/*     */     {
/* 155 */       return;
/*     */     }
/*     */     
/* 158 */     if (open)
/*     */     {
/* 160 */       ControllerInterface.triggerController(controller);
/*     */     }
/*     */     else
/*     */     {
/* 164 */       ControllerInterface.collectController(controller);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bless\main\BlessManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */