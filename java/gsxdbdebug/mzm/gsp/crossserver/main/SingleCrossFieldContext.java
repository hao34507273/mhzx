/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossfield.main.CrossFieldInterface;
/*     */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFail;
/*     */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFailArg;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingleCrossFieldContext
/*     */   implements RoamContext
/*     */ {
/*     */   private final long contextid;
/*     */   private final long roleid;
/*     */   private final SingleCrossFieldRoamRoleInfo roleInfo;
/*     */   private final int activityCfgid;
/*     */   private final long createTime;
/*  29 */   private volatile long matcherServerContextid = 0L;
/*  30 */   private volatile int roamZoneid = 0;
/*  31 */   private volatile long roamRoomInstanceid = 0L;
/*  32 */   private volatile boolean waitNextRundMatch = false;
/*  33 */   private volatile boolean isCanceling = false;
/*     */   private volatile Observer observer;
/*     */   
/*     */   public SingleCrossFieldContext(int contextid, SingleCrossFieldRoamRoleInfo roleInfo, int activityCfgid)
/*     */   {
/*  38 */     this.contextid = GameServerInfoManager.toGlobalId(contextid);
/*  39 */     this.roleid = roleInfo.getRoleid();
/*  40 */     this.roleInfo = roleInfo;
/*  41 */     this.activityCfgid = activityCfgid;
/*  42 */     this.createTime = DateTimeUtils.getCurrTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */   public RoamType getRoamType()
/*     */   {
/*  48 */     return RoamType.SINGLE_CROSS_FIELD;
/*     */   }
/*     */   
/*     */   public long getContextid()
/*     */   {
/*  53 */     return this.contextid;
/*     */   }
/*     */   
/*     */   public long getRoleid()
/*     */   {
/*  58 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public boolean setProcess(byte process)
/*     */   {
/*  63 */     return this.roleInfo.setProcess(process);
/*     */   }
/*     */   
/*     */   public byte getProcess()
/*     */   {
/*  68 */     return this.roleInfo.getProcess();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addToken(long roleid, Octets token)
/*     */   {
/*  74 */     if ((this.roleid != roleid) || (this.roleInfo.getRoleid() != roleid))
/*     */     {
/*  76 */       return false;
/*     */     }
/*  78 */     return this.roleInfo.setToken(token);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isGenTokenDone()
/*     */   {
/*  84 */     if (this.roleInfo.getToken() == null)
/*     */     {
/*  86 */       return false;
/*     */     }
/*  88 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isRoamDone()
/*     */   {
/*  94 */     if (!this.roleInfo.isRoam())
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean setRoamed(long roleid)
/*     */   {
/* 104 */     if ((this.roleid != roleid) || (this.roleInfo.getRoleid() != roleid))
/*     */     {
/* 106 */       return false;
/*     */     }
/* 108 */     return this.roleInfo.setRoamed();
/*     */   }
/*     */   
/*     */   public SingleCrossFieldRoamRoleInfo getCrossFieldRoamRoleInfo()
/*     */   {
/* 113 */     return this.roleInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<RoamRoleInfo> getRoamRoleInfos()
/*     */   {
/* 119 */     List<RoamRoleInfo> roleInfos = new ArrayList();
/* 120 */     roleInfos.add(this.roleInfo);
/* 121 */     return roleInfos;
/*     */   }
/*     */   
/*     */   public int getActivityCfgid()
/*     */   {
/* 126 */     return this.activityCfgid;
/*     */   }
/*     */   
/*     */   public int getFieldRoleNum()
/*     */   {
/* 131 */     return CrossFieldInterface.getFieldRoleNum(this.activityCfgid);
/*     */   }
/*     */   
/*     */   public long getCreateTime()
/*     */   {
/* 136 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setMatcherServerContextid(long matcherServerContextid)
/*     */   {
/* 141 */     this.matcherServerContextid = matcherServerContextid;
/*     */   }
/*     */   
/*     */   public long getMatcherServerContextid()
/*     */   {
/* 146 */     return this.matcherServerContextid;
/*     */   }
/*     */   
/*     */   public void setRoamZoneid(int roamZoneid)
/*     */   {
/* 151 */     this.roamZoneid = roamZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRoamZoneid()
/*     */   {
/* 157 */     return this.roamZoneid;
/*     */   }
/*     */   
/*     */   public void setRoamRoomInstanceid(long roamRoomInstanceid)
/*     */   {
/* 162 */     this.roamRoomInstanceid = roamRoomInstanceid;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getRoamRoomInstanceid()
/*     */   {
/* 168 */     return this.roamRoomInstanceid;
/*     */   }
/*     */   
/*     */   public void setWaitNextRoundMatch(boolean waitNextRoundMatch)
/*     */   {
/* 173 */     this.waitNextRundMatch = waitNextRoundMatch;
/*     */   }
/*     */   
/*     */   public boolean isWaitNextRoundMatch()
/*     */   {
/* 178 */     return this.waitNextRundMatch;
/*     */   }
/*     */   
/*     */   public void setIsCanceling(boolean isCanceling)
/*     */   {
/* 183 */     this.isCanceling = isCanceling;
/*     */   }
/*     */   
/*     */   public boolean isCanceling()
/*     */   {
/* 188 */     return this.isCanceling;
/*     */   }
/*     */   
/*     */   public void startWatchDog()
/*     */   {
/* 193 */     if (this.observer == null)
/*     */     {
/* 195 */       this.observer = new WatchDog(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void stopWatchDog()
/*     */   {
/* 201 */     if (this.observer != null)
/*     */     {
/* 203 */       this.observer.stopTimer();
/*     */       
/* 205 */       this.observer = null;
/*     */     }
/*     */   }
/*     */   
/*     */   class WatchDog extends Observer
/*     */   {
/*     */     private final SingleCrossFieldContext context;
/*     */     
/*     */     public WatchDog(SingleCrossFieldContext context)
/*     */     {
/* 215 */       super();
/* 216 */       this.context = context;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 222 */       if (this.context.isWaitNextRoundMatch())
/*     */       {
/* 224 */         GameServer.logger().info(String.format("[crossserver]SingleCrossFieldContext.WatchDog.update@wait next round match|context=%s", new Object[] { this.context }));
/*     */         
/*     */ 
/* 227 */         this.context.setWaitNextRoundMatch(false);
/* 228 */         return true;
/*     */       }
/* 230 */       GameServer.logger().info(String.format("[crossserver]SingleCrossFieldContext.WatchDog.update@time out|context=%s", new Object[] { this.context }));
/*     */       
/* 232 */       TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldMatchFail(), new SingleCrossFieldMatchFailArg(this.context));
/*     */       
/* 234 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 241 */     StringBuffer sb = new StringBuffer();
/* 242 */     sb.append("{");
/* 243 */     sb.append("contextid=").append(this.contextid).append(",");
/* 244 */     sb.append("roleid=").append(this.roleid).append(",");
/* 245 */     sb.append("role_info").append(this.roleInfo).append(",");
/* 246 */     sb.append("activity_cfg_id=").append(this.activityCfgid).append(",");
/* 247 */     sb.append("create_time=").append(this.createTime).append(",");
/* 248 */     sb.append("matcher_server_contextid=").append(this.matcherServerContextid).append(",");
/* 249 */     sb.append("roam_zoneid=").append(this.roamZoneid).append(",");
/* 250 */     sb.append("roam_room_instanceid=").append(this.roamRoomInstanceid).append(",");
/* 251 */     sb.append("wait_next_rund_match=").append(this.waitNextRundMatch).append(",");
/* 252 */     sb.append("is_canceling=").append(this.isCanceling);
/* 253 */     sb.append("}");
/* 254 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\SingleCrossFieldContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */