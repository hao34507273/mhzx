/*     */ package mzm.gsp.flowerparade.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeOcpCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.flowerparade.SFlowerParadeRoleDoneFollow;
/*     */ import mzm.gsp.flowerparade.SFlowerParadeRoleJoinFollow;
/*     */ import mzm.gsp.flowerparade.SFlowerParadeRoleLeaveFollow;
/*     */ import mzm.gsp.flowerparade.SSynFlowerParadeAward;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FlowerParade;
/*     */ import xbean.RoleFlowerParadeRecord;
/*     */ import xtable.Flowerparade;
/*     */ import xtable.Role2flowerparaderecord;
/*     */ 
/*     */ public class FlowerParadeObserverUpdateFollower extends Observer
/*     */ {
/*     */   private final int activityId;
/*     */   
/*     */   public FlowerParadeObserverUpdateFollower(long intervalSeconds, int activityId)
/*     */   {
/*  39 */     super(intervalSeconds);
/*  40 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  46 */     xdb.Procedure.execute(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  52 */         if (!ActivityInterface.isActivityOpen(FlowerParadeObserverUpdateFollower.this.activityId))
/*     */         {
/*  54 */           return false;
/*     */         }
/*  56 */         if (!FlowerParadeManager.isOpen(0L))
/*     */         {
/*  58 */           return false;
/*     */         }
/*  60 */         long localid = GameServerInfoManager.getLocalId();
/*     */         
/*  62 */         FlowerParade xFlowerParade = Flowerparade.get(Long.valueOf(localid));
/*  63 */         if (xFlowerParade == null)
/*     */         {
/*  65 */           return false;
/*     */         }
/*  67 */         FlowerParadeObserverUpdateFollower.FlowerParadeInfo parade = new FlowerParadeObserverUpdateFollower.FlowerParadeInfo(null);
/*  68 */         parade.instanceId = xFlowerParade.getFlowerinstanceid();
/*     */         
/*     */ 
/*  71 */         Map<Long, Long> lastFollowers = new HashMap();
/*  72 */         lastFollowers.putAll(xFlowerParade.getFollowtimestart());
/*     */         
/*     */ 
/*  75 */         SFlowerParadeCfg cfg = SFlowerParadeCfg.get(FlowerParadeObserverUpdateFollower.this.activityId);
/*  76 */         SFlowerParadeOcpGroupCfg ocpCfg = SFlowerParadeOcpGroupCfg.get(cfg.ocpGroupId);
/*  77 */         int radius = ((SFlowerParadeOcpCfg)ocpCfg.ocpPradCfg.get(Integer.valueOf(xFlowerParade.getOcpid()))).radius;
/*  78 */         Collection<Long> currentRoleIdCollection = MapInterface.getRoleListNearbyMapEntity(mzm.gsp.map.main.scene.object.MapEntityType.MET_FLOAT_PARADE, xFlowerParade.getFlowerinstanceid(), radius);
/*     */         
/*  80 */         if (currentRoleIdCollection == null)
/*     */         {
/*  82 */           currentRoleIdCollection = new HashSet();
/*     */         }
/*  84 */         Collection<Long> doneRoles = new HashSet();
/*  85 */         doneRoles.addAll(xFlowerParade.getFlowerroleiddoneset());
/*     */         
/*  87 */         xdb.Xdb.executor().execute(new FlowerParadeObserverUpdateFollower.RUpdateRoles(FlowerParadeObserverUpdateFollower.this.activityId, lastFollowers, currentRoleIdCollection, doneRoles, parade));
/*     */         
/*     */ 
/*  90 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  94 */     });
/*  95 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class FlowerParadeInfo
/*     */   {
/*     */     public long instanceId;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RUpdateRoles
/*     */     extends mzm.gsp.util.LogicRunnable
/*     */   {
/*     */     private final Map<Long, Long> preFollowers;
/*     */     
/*     */     private final Collection<Long> currentFollowers;
/*     */     
/*     */     private final Collection<Long> doneRoles;
/*     */     
/*     */     private final int activityId;
/*     */     
/*     */     private final FlowerParadeObserverUpdateFollower.FlowerParadeInfo parade;
/*     */     
/*     */     public RUpdateRoles(int activityId, Map<Long, Long> preFollowers, Collection<Long> currentFollowers, Collection<Long> doneRoles, FlowerParadeObserverUpdateFollower.FlowerParadeInfo parade)
/*     */     {
/* 120 */       this.activityId = activityId;
/* 121 */       this.preFollowers = preFollowers;
/* 122 */       this.currentFollowers = currentFollowers;
/* 123 */       this.doneRoles = doneRoles;
/* 124 */       this.parade = parade;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 130 */       GameServer.logger().info(String.format("[flowerparade]FlowerParadeObserverUpdateFollower.RUpdateRoles.processImp@update roles start|activityid=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/*     */ 
/* 134 */       Set<Long> rolesNeedCheck = new HashSet();
/* 135 */       rolesNeedCheck.addAll(this.preFollowers.keySet());
/* 136 */       rolesNeedCheck.addAll(this.currentFollowers);
/* 137 */       for (Iterator i$ = rolesNeedCheck.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 139 */         new FlowerParadeObserverUpdateFollower.PUpdateRole(this.activityId, roleId, this.preFollowers, this.currentFollowers, this.doneRoles, this.parade).call();
/*     */       }
/*     */       
/* 142 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 147 */           long localid = GameServerInfoManager.getLocalId();
/* 148 */           FlowerParade xFlowerParade = Flowerparade.get(Long.valueOf(localid));
/* 149 */           if (xFlowerParade == null)
/*     */           {
/* 151 */             return false;
/*     */           }
/* 153 */           xFlowerParade.getFollowtimestart().clear();
/* 154 */           xFlowerParade.getFollowtimestart().putAll(FlowerParadeObserverUpdateFollower.RUpdateRoles.this.preFollowers);
/*     */           
/* 156 */           xFlowerParade.getFlowerroleiddoneset().clear();
/* 157 */           xFlowerParade.getFlowerroleiddoneset().addAll(FlowerParadeObserverUpdateFollower.RUpdateRoles.this.doneRoles);
/* 158 */           return true;
/*     */         }
/*     */         
/* 161 */       }.call();
/* 162 */       GameServer.logger().info(String.format("[flowerparade]FlowerParadeObserverUpdateFollower.RUpdateRoles.processImp@update roles end|activityid=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class PUpdateRole
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityId;
/*     */     
/*     */ 
/*     */ 
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */     private final Map<Long, Long> preFollowers;
/*     */     
/*     */ 
/*     */     private final Collection<Long> currentFollowers;
/*     */     
/*     */ 
/*     */     private final Collection<Long> doneRoles;
/*     */     
/*     */ 
/*     */     private final FlowerParadeObserverUpdateFollower.FlowerParadeInfo parade;
/*     */     
/*     */ 
/*     */ 
/*     */     public PUpdateRole(int activityId, long roleId, Map<Long, Long> preFollowers, Collection<Long> currentFollowers, Collection<Long> doneRoles, FlowerParadeObserverUpdateFollower.FlowerParadeInfo parade)
/*     */     {
/* 194 */       this.activityId = activityId;
/* 195 */       this.roleId = roleId;
/* 196 */       this.preFollowers = preFollowers;
/* 197 */       this.currentFollowers = currentFollowers;
/* 198 */       this.doneRoles = doneRoles;
/* 199 */       this.parade = parade;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 206 */       if (!ActivityInterface.isActivityOpen(this.activityId))
/*     */       {
/* 208 */         return false;
/*     */       }
/* 210 */       if (!FlowerParadeManager.isOpen(this.roleId))
/*     */       {
/* 212 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 216 */       if (this.doneRoles.contains(Long.valueOf(this.roleId)))
/*     */       {
/* 218 */         return false;
/*     */       }
/*     */       
/* 221 */       Map<Long, String> roleId2Userid = new HashMap();
/* 222 */       roleId2Userid.put(Long.valueOf(this.roleId), RoleInterface.getUserId(this.roleId));
/* 223 */       Set<Long> roles = new HashSet();
/* 224 */       roles.add(Long.valueOf(this.roleId));
/* 225 */       lock(xtable.User.getTable(), roleId2Userid.values());
/* 226 */       lock(xtable.Basic.getTable(), roles);
/*     */       
/*     */ 
/* 229 */       ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(RoleInterface.getUserId(this.roleId), this.roleId, this.activityId);
/*     */       
/* 231 */       if (!joinResult.isCanJoin())
/*     */       {
/* 233 */         return false;
/*     */       }
/* 235 */       SFlowerParadeCfg cfg = SFlowerParadeCfg.get(this.activityId);
/* 236 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 237 */       long followTimeMin = cfg.followParadeTime * 1000;
/*     */       
/*     */ 
/* 240 */       RoleFlowerParadeRecord xRecord = Role2flowerparaderecord.get(Long.valueOf(this.roleId));
/* 241 */       if ((cfg.followAwardCount > 0) && (xRecord != null) && (xRecord.getFollowawardcount() >= cfg.followAwardCount))
/*     */       {
/* 243 */         return false;
/*     */       }
/*     */       
/* 246 */       boolean inPre = this.preFollowers.keySet().contains(Long.valueOf(this.roleId));
/*     */       
/* 248 */       boolean inCurrent = this.currentFollowers.contains(Long.valueOf(this.roleId));
/* 249 */       if (inPre)
/*     */       {
/* 251 */         if (inCurrent)
/*     */         {
/*     */ 
/* 254 */           long followTimeStart = ((Long)this.preFollowers.get(Long.valueOf(this.roleId))).longValue();
/* 255 */           if (now - followTimeStart >= followTimeMin)
/*     */           {
/*     */ 
/* 258 */             this.preFollowers.remove(Long.valueOf(this.roleId));
/* 259 */             this.doneRoles.add(Long.valueOf(this.roleId));
/* 260 */             if (xRecord == null)
/*     */             {
/* 262 */               xRecord = xbean.Pod.newRoleFlowerParadeRecord();
/* 263 */               Role2flowerparaderecord.add(Long.valueOf(this.roleId), xRecord);
/*     */             }
/* 265 */             xRecord.setFollowawardcount(xRecord.getFollowawardcount() + 1);
/*     */             
/* 267 */             int awardId = cfg.followAwardId;
/* 268 */             String userid = (String)roleId2Userid.get(Long.valueOf(this.roleId));
/* 269 */             AwardReason awardReason = new AwardReason(mzm.gsp.tlog.LogReason.FLOWER_PARADE, awardId);
/*     */             
/* 271 */             mzm.gsp.award.main.AwardModel award = AwardInterface.awardFixAward(awardId, userid, this.roleId, false, false, awardReason);
/*     */             
/* 273 */             if (award == null)
/*     */             {
/* 275 */               GameServer.logger().error(String.format("[flowerparade]FlowerParadeObserverUpdateFollower.PUpdateRole.processImp@finish follow award failed|paradeinstance=%d|activityid=%d|roleid=%d|donecount=%d|awardid=%d", new Object[] { Long.valueOf(this.parade.instanceId), Integer.valueOf(this.activityId), Long.valueOf(this.roleId), Integer.valueOf(xRecord.getFollowawardcount()), Integer.valueOf(awardId) }));
/*     */             }
/*     */             
/*     */ 
/*     */ 
/* 280 */             SSynFlowerParadeAward notify = new SSynFlowerParadeAward();
/* 281 */             notify.awardtype = 1;
/* 282 */             AwardInterface.fillAwardBean(notify.award, award);
/* 283 */             OnlineManager.getInstance().send(this.roleId, notify);
/*     */             
/* 285 */             FlowerParadeManager.tLogFollowAward(this.roleId, this.parade.instanceId, awardId);
/*     */             
/* 287 */             SFlowerParadeRoleDoneFollow protocol = new SFlowerParadeRoleDoneFollow(this.activityId, xRecord.getFollowawardcount());
/*     */             
/* 289 */             OnlineManager.getInstance().send(this.roleId, protocol);
/* 290 */             GameServer.logger().info(String.format("[flowerparade]FlowerParadeObserverUpdateFollower.PUpdateRole.processImp@finish follow|paradeinstance=%d|activityid=%d|roleid=%d|donecount=%d|awardid=%d", new Object[] { Long.valueOf(this.parade.instanceId), Integer.valueOf(this.activityId), Long.valueOf(this.roleId), Integer.valueOf(xRecord.getFollowawardcount()), Integer.valueOf(awardId) }));
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 299 */           this.preFollowers.remove(Long.valueOf(this.roleId));
/* 300 */           SFlowerParadeRoleLeaveFollow protocol = new SFlowerParadeRoleLeaveFollow(this.activityId);
/* 301 */           OnlineManager.getInstance().send(this.roleId, protocol);
/* 302 */           GameServer.logger().info(String.format("[flowerparade]FlowerParadeObserverUpdateFollower.PUpdateRole.processImp@leave follow|paradeinstance=%d|activityid=%d|roleid=%d", new Object[] { Long.valueOf(this.parade.instanceId), Integer.valueOf(this.activityId), Long.valueOf(this.roleId) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */       }
/* 310 */       else if (inCurrent)
/*     */       {
/*     */ 
/* 313 */         this.preFollowers.put(Long.valueOf(this.roleId), Long.valueOf(now));
/* 314 */         SFlowerParadeRoleJoinFollow protocol = new SFlowerParadeRoleJoinFollow(this.activityId);
/* 315 */         OnlineManager.getInstance().send(this.roleId, protocol);
/* 316 */         GameServer.logger().info(String.format("[flowerparade]FlowerParadeObserverUpdateFollower.PUpdateRole.processImp@start follow|paradeinstance=%d|activityid=%d|roleid=%d", new Object[] { Long.valueOf(this.parade.instanceId), Integer.valueOf(this.activityId), Long.valueOf(this.roleId) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 326 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeObserverUpdateFollower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */