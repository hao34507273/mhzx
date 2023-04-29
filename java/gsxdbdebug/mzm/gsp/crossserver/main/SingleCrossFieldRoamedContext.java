/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import hub.SingleCrossFieldRoleMatchInfo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossfield.main.CrossFieldInterface;
/*     */ import mzm.gsp.crossserver.event.SingleCrossFieldAllRoamedRoleReady;
/*     */ import mzm.gsp.crossserver.event.SingleCrossFieldAllRoamedRoleReadyArg;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.singlebattle.main.CreateSingleBattleInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleContext;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class SingleCrossFieldRoamedContext implements SingleBattleContext
/*     */ {
/*     */   private final long roamedRoomInstanceid;
/*     */   private final int activityCfgid;
/*  35 */   private final List<SingleCrossFieldRoamedRoleInfo> roleInfos = new ArrayList();
/*  36 */   private final Map<Long, SingleCrossFieldRoamedRoleInfo> roleInfoMap = new HashMap();
/*  37 */   private Observer observer = null;
/*  38 */   private CreateSingleBattleInfo singleBattleInfo = null;
/*     */   
/*     */ 
/*     */   public SingleCrossFieldRoamedContext(long roamedRoomInstanceid, int activityCfgid, List<SingleCrossFieldRoleMatchInfo> roleMatchInfos)
/*     */   {
/*  43 */     this.roamedRoomInstanceid = roamedRoomInstanceid;
/*  44 */     this.activityCfgid = activityCfgid;
/*  45 */     for (SingleCrossFieldRoleMatchInfo roleMatchInfo : roleMatchInfos)
/*     */     {
/*  47 */       SingleCrossFieldRoamedRoleInfo roleInfo = new SingleCrossFieldRoamedRoleInfo(roleMatchInfo);
/*  48 */       this.roleInfos.add(roleInfo);
/*  49 */       this.roleInfoMap.put(Long.valueOf(roleInfo.getRoleid()), roleInfo);
/*     */     }
/*  51 */     Collections.sort(this.roleInfos, new Comparator()
/*     */     {
/*     */ 
/*     */       public int compare(SingleCrossFieldRoamedRoleInfo o1, SingleCrossFieldRoamedRoleInfo o2)
/*     */       {
/*  56 */         if (o1.getStarNum() != o2.getStarNum())
/*     */         {
/*  58 */           return o2.getStarNum() - o1.getStarNum();
/*     */         }
/*  60 */         if (o1.getLevel() != o2.getLevel())
/*     */         {
/*  62 */           return o2.getLevel() - o1.getLevel();
/*     */         }
/*  64 */         if (o1.getFightValue() != o2.getFightValue())
/*     */         {
/*  66 */           return o2.getFightValue() - o1.getFightValue();
/*     */         }
/*  68 */         return o1.getRoleid() - o2.getRoleid() > 0L ? 1 : -1;
/*     */       }
/*  70 */     });
/*  71 */     this.observer = new TimeoutObserver(this);
/*     */   }
/*     */   
/*     */   public long getRoamedRoomInstanceid()
/*     */   {
/*  76 */     return this.roamedRoomInstanceid;
/*     */   }
/*     */   
/*     */   public int getActivityCfgid()
/*     */   {
/*  81 */     return this.activityCfgid;
/*     */   }
/*     */   
/*     */   public int getFieldRoleNum()
/*     */   {
/*  86 */     return this.roleInfos.size();
/*     */   }
/*     */   
/*     */   public List<SingleCrossFieldRoamedRoleInfo> getRoleInfos()
/*     */   {
/*  91 */     return this.roleInfos;
/*     */   }
/*     */   
/*     */   public SingleCrossFieldRoamedRoleInfo getRoleInfo(long roleid)
/*     */   {
/*  96 */     return (SingleCrossFieldRoamedRoleInfo)this.roleInfoMap.get(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   public List<Long> getRoleids()
/*     */   {
/* 101 */     List<Long> roleids = new ArrayList();
/* 102 */     for (SingleCrossFieldRoamedRoleInfo roleInfo : this.roleInfos)
/*     */     {
/* 104 */       roleids.add(Long.valueOf(roleInfo.getRoleid()));
/*     */     }
/* 106 */     return roleids;
/*     */   }
/*     */   
/*     */   public boolean setDataPrepared(long roleid)
/*     */   {
/* 111 */     for (SingleCrossFieldRoamedRoleInfo roleInfo : this.roleInfos)
/*     */     {
/* 113 */       if (roleInfo.getRoleid() == roleid)
/*     */       {
/* 115 */         return roleInfo.setDataPrepared();
/*     */       }
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isAllDataPrepared()
/*     */   {
/* 123 */     for (SingleCrossFieldRoamedRoleInfo roleInfo : this.roleInfos)
/*     */     {
/* 125 */       if (!roleInfo.isDataPrepared())
/*     */       {
/* 127 */         return false;
/*     */       }
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   public boolean setLogined(long roleid)
/*     */   {
/* 135 */     for (SingleCrossFieldRoamedRoleInfo roleInfo : this.roleInfos)
/*     */     {
/* 137 */       if (roleInfo.getRoleid() == roleid)
/*     */       {
/* 139 */         return roleInfo.setLogined();
/*     */       }
/*     */     }
/* 142 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isAllLogined()
/*     */   {
/* 147 */     for (SingleCrossFieldRoamedRoleInfo roleInfo : this.roleInfos)
/*     */     {
/* 149 */       if (!roleInfo.isLogined())
/*     */       {
/* 151 */         return false;
/*     */       }
/*     */     }
/* 154 */     return true;
/*     */   }
/*     */   
/*     */   public void stopTimeoutObserver()
/*     */   {
/* 159 */     if (this.observer != null)
/*     */     {
/* 161 */       this.observer.stopTimer();
/* 162 */       this.observer = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void onAllRoleLogined()
/*     */   {
/* 168 */     if (SingleCrossFieldRoamedContextManager.getInstance().removeContext(this.roamedRoomInstanceid) == null)
/*     */     {
/* 170 */       return;
/*     */     }
/* 172 */     new ROnAllRoleLogined(this).execute();
/*     */   }
/*     */   
/*     */   public void onAllRoleReady()
/*     */   {
/*     */     try
/*     */     {
/* 179 */       for (SingleCrossFieldRoamedRoleInfo roleInfo : this.roleInfos)
/*     */       {
/* 181 */         String userid = roleInfo.getUserid();
/* 182 */         long roleid = roleInfo.getRoleid();
/* 183 */         new POnAllRoleReady(this.roamedRoomInstanceid, userid, roleid).call();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 188 */       TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldAllRoamedRoleReady(), new SingleCrossFieldAllRoamedRoleReadyArg(this));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean startSingleBattle()
/*     */   {
/* 195 */     if (this.singleBattleInfo != null)
/*     */     {
/* 197 */       return false;
/*     */     }
/* 199 */     int singleBattleCfgid = CrossFieldInterface.getSingleBattleCfgid(this.activityCfgid);
/* 200 */     if ((singleBattleCfgid < 0) || (getFieldRoleNum() < 0))
/*     */     {
/* 202 */       return false;
/*     */     }
/* 204 */     Set<Long> roleIds_1 = new HashSet();
/* 205 */     Set<Long> roleIds_2 = new HashSet();
/* 206 */     boolean reverse = false;
/* 207 */     for (int index = 1; index <= this.roleInfos.size(); index++)
/*     */     {
/* 209 */       if (((index % 2 != 0) && (!reverse)) || ((index % 2 == 0) && (reverse)))
/*     */       {
/* 211 */         roleIds_1.add(Long.valueOf(((SingleCrossFieldRoamedRoleInfo)this.roleInfos.get(index - 1)).getRoleid()));
/*     */       }
/*     */       else
/*     */       {
/* 215 */         roleIds_2.add(Long.valueOf(((SingleCrossFieldRoamedRoleInfo)this.roleInfos.get(index - 1)).getRoleid()));
/*     */       }
/* 217 */       if (index % 2 == 0)
/*     */       {
/* 219 */         reverse = !reverse;
/*     */       }
/*     */     }
/* 222 */     CreateSingleBattleInfo singleBattleInfo = SingleBattleInterface.startSingleBattle(singleBattleCfgid, roleIds_1, roleIds_2, this);
/*     */     
/* 224 */     if (!singleBattleInfo.isCreateSuc())
/*     */     {
/* 226 */       return false;
/*     */     }
/* 228 */     this.singleBattleInfo = singleBattleInfo;
/* 229 */     return true;
/*     */   }
/*     */   
/*     */   public long getSingleBattleid()
/*     */   {
/* 234 */     if (this.singleBattleInfo == null)
/*     */     {
/* 236 */       return -1L;
/*     */     }
/* 238 */     return this.singleBattleInfo.get_battleId();
/*     */   }
/*     */   
/*     */   class TimeoutObserver extends Observer
/*     */   {
/*     */     private final SingleCrossFieldRoamedContext context;
/*     */     
/*     */     public TimeoutObserver(SingleCrossFieldRoamedContext context)
/*     */     {
/* 247 */       super();
/* 248 */       this.context = context;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 254 */       Xdb.executor().execute(new SingleCrossFieldRoamedContext.ROnTimeout(SingleCrossFieldRoamedContext.this, this.context));
/* 255 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   class ROnTimeout extends LogicRunnable
/*     */   {
/*     */     private final SingleCrossFieldRoamedContext context;
/*     */     
/*     */     public ROnTimeout(SingleCrossFieldRoamedContext context)
/*     */     {
/* 265 */       this.context = context;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 271 */       if (!this.context.isAllDataPrepared())
/*     */       {
/* 273 */         for (SingleCrossFieldRoamedRoleInfo roleInfo : this.context.getRoleInfos())
/*     */         {
/* 275 */           new SingleCrossFieldRoamedContext.PReturnOriginalServer(SingleCrossFieldRoamedContext.this, this.context.roamedRoomInstanceid, roleInfo.getUserid(), roleInfo.getRoleid()).call();
/*     */         }
/* 277 */         GameServer.logger().info(String.format("[crossserver]SingleCrossFieldContextManager.ROnTimeout.process@not all data prepared|context_id=%d", new Object[] { Long.valueOf(this.context.getRoamedRoomInstanceid()) }));
/*     */         
/*     */ 
/*     */ 
/* 281 */         return;
/*     */       }
/* 283 */       this.context.onAllRoleReady();
/* 284 */       GameServer.logger().info(String.format("[crossserver]SingleCrossFieldContextManager.ROnTimeout.process@all data prepared|context_id=%d", new Object[] { Long.valueOf(this.context.getRoamedRoomInstanceid()) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   class PReturnOriginalServer
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roamedRoomInstanceid;
/*     */     
/*     */     private final String userid;
/*     */     private final long roleid;
/*     */     
/*     */     PReturnOriginalServer(long roamedRoomInstanceid, String userid, long roleid)
/*     */     {
/* 299 */       this.roamedRoomInstanceid = roamedRoomInstanceid;
/* 300 */       this.userid = userid;
/* 301 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 307 */       lock(Lockeys.get(User.getTable(), this.userid));
/* 308 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */       
/* 310 */       if (!CrossServerManager.removeUserRoamedInfo(this.userid, RoamType.CROSS_BATTLE_SELECTION_FINAL, this.roamedRoomInstanceid))
/*     */       {
/*     */ 
/* 313 */         return false;
/*     */       }
/* 315 */       LoginManager.getInstance().onReturnOrigianServer(this.userid, this.roleid);
/* 316 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class ROnAllRoleLogined extends LogicRunnable
/*     */   {
/*     */     final SingleCrossFieldRoamedContext context;
/*     */     
/*     */     ROnAllRoleLogined(SingleCrossFieldRoamedContext context)
/*     */     {
/* 326 */       this.context = context;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 332 */       this.context.stopTimeoutObserver();
/* 333 */       this.context.onAllRoleReady();
/* 334 */       GameServer.logger().info(String.format("[crossserver]SingleCrossFieldContextManager.ROnAllRoleLogined.process@all role logined|context_id=%d", new Object[] { Long.valueOf(this.context.getRoamedRoomInstanceid()) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   class POnAllRoleReady
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roamedRoomInstanceid;
/*     */     
/*     */     private final String userid;
/*     */     private final long roleid;
/*     */     
/*     */     POnAllRoleReady(long roamedRoomInstanceid, String userid, long roleid)
/*     */     {
/* 349 */       this.roamedRoomInstanceid = roamedRoomInstanceid;
/* 350 */       this.userid = userid;
/* 351 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 357 */       lock(Lockeys.get(User.getTable(), this.userid));
/* 358 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/* 359 */       return CrossServerManager.removeUserRoamedInfo(this.userid, RoamType.SINGLE_CROSS_FIELD, this.roamedRoomInstanceid);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\SingleCrossFieldRoamedContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */