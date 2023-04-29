/*     */ package mzm.gsp.mourn.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity2.confbean.MournConsts;
/*     */ import mzm.gsp.activity2.confbean.SMournCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mourn.MTaskInfo;
/*     */ import mzm.gsp.mourn.SSynLastMourn;
/*     */ import mzm.gsp.mourn.SSynSingleMournInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.XMTaskInfo;
/*     */ import xbean.XMournInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2mourn;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnTaskChanged
/*     */   extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     long roleId = ((TaskEventArg)this.arg).roleId;
/*  38 */     if (MournManager.isMGraph(((TaskEventArg)this.arg).graphId))
/*     */     {
/*  40 */       SMournCfg cfg = MournManager.getSMournCfg(((TaskEventArg)this.arg).graphId);
/*  41 */       if (cfg == null)
/*     */       {
/*  43 */         GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ STMournCfg is null!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId) }));
/*     */         
/*     */ 
/*  46 */         return false;
/*     */       }
/*  48 */       if (((TaskEventArg)this.arg).taskState == 8)
/*     */       {
/*     */ 
/*  51 */         String userId = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/*  52 */         lock(Lockeys.get(User.getTable(), userId));
/*     */         
/*  54 */         lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((TaskEventArg)this.arg).roleId) }));
/*     */         
/*     */ 
/*  57 */         ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, MournConsts.getInstance().activityId);
/*     */         
/*  59 */         if (!res.isCanJoin())
/*     */         {
/*  61 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ activity is forbid!|roleId=%d|mournId=%d|reason=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(cfg.id), Integer.valueOf(res.getReasonValue()) }));
/*     */           
/*     */ 
/*     */ 
/*  65 */           return false;
/*     */         }
/*     */         
/*  68 */         XMournInfo xMournInfo = Role2mourn.get(Long.valueOf(roleId));
/*  69 */         if (xMournInfo == null)
/*     */         {
/*  71 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ xMournInfo is null!|roleId=%d|graphId=%d|taskId=%d|mournId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(cfg.id) }));
/*     */           
/*     */ 
/*     */ 
/*  75 */           return false;
/*     */         }
/*  77 */         XMTaskInfo xmTaskInfo = (XMTaskInfo)xMournInfo.getMourndatas().get(Integer.valueOf(cfg.id));
/*  78 */         if (xmTaskInfo == null)
/*     */         {
/*  80 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ xmTaskInfo is null!|roleId=%d|graphId=%d|taskId=%d|mournId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(cfg.id) }));
/*     */           
/*     */ 
/*     */ 
/*  84 */           return false;
/*     */         }
/*  86 */         if (xmTaskInfo.getState() != 2)
/*     */         {
/*  88 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ xmTask not the accept state!|roleId=%d|graphId=%d|taskId=%d|mournId=%d|state=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(cfg.id), Integer.valueOf(xmTaskInfo.getState()) }));
/*     */           
/*     */ 
/*     */ 
/*  92 */           return false;
/*     */         }
/*  94 */         AwardReason awardReason = new AwardReason(LogReason.MOURN_AWAED, ((TaskEventArg)this.arg).graphId);
/*  95 */         AwardModel awardModel = AwardInterface.award(cfg.awardId, userId, ((TaskEventArg)this.arg).roleId, false, true, awardReason);
/*  96 */         if (awardModel == null)
/*     */         {
/*  98 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ do award err!|roleId=%d|graphId=%d|taskId=%d|mournId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(cfg.id) }));
/*     */           
/*     */ 
/*     */ 
/* 102 */           return false;
/*     */         }
/* 104 */         long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 105 */         if (curTime > ActivityInterface.getActivityEndTime(MournConsts.getInstance().activityId))
/*     */         {
/*     */ 
/* 108 */           new LogicProcedure()
/*     */           {
/*     */ 
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/* 114 */               TaskInterface.closeActivityGraphWithoutEvent(((TaskEventArg)POnTaskChanged.this.arg).roleId, ((TaskEventArg)POnTaskChanged.this.arg).graphId);
/* 115 */               return true;
/*     */             }
/* 117 */           }.execute();
/* 118 */           GameServer.logger().info(String.format("[mourn]POnTaskChanged.processImp@ activityEnd!|roleId=%d|graphId=%d|taskId=%d|mournId=%d|curTime=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(cfg.id), Long.valueOf(curTime) }));
/*     */           
/*     */ 
/*     */ 
/* 122 */           return false;
/*     */         }
/*     */         
/* 125 */         if (((TaskEventArg)this.arg).isToEnd)
/*     */         {
/*     */ 
/* 128 */           changeMTaskState(userId, roleId, cfg.id, xmTaskInfo, 3);
/*     */           
/* 130 */           ActivityInterface.addActivityCount(userId, roleId, MournConsts.getInstance().activityId);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 135 */           if (!MournManager.isMournOpen())
/*     */           {
/* 137 */             new LogicProcedure()
/*     */             {
/*     */ 
/*     */               protected boolean processImp()
/*     */                 throws Exception
/*     */               {
/* 143 */                 TaskInterface.closeActivityGraphWithoutEvent(((TaskEventArg)POnTaskChanged.this.arg).roleId, ((TaskEventArg)POnTaskChanged.this.arg).graphId);
/* 144 */                 return true;
/*     */               }
/* 146 */             }.execute();
/* 147 */             return true;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 152 */           TaskInterface.goNextTask(roleId, ((TaskEventArg)this.arg).graphId);
/*     */         }
/*     */         
/* 155 */         return true;
/*     */       }
/* 157 */       if (((TaskEventArg)this.arg).taskState == 2)
/*     */       {
/*     */ 
/* 160 */         String userId = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/* 161 */         lock(Lockeys.get(User.getTable(), userId));
/*     */         
/* 163 */         lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((TaskEventArg)this.arg).roleId) }));
/* 164 */         if (MournManager.hasMoreThanXMGraph(roleId, 1))
/*     */         {
/* 166 */           TaskInterface.closeActivityGraphWithoutEvent(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId);
/* 167 */           return true;
/*     */         }
/* 169 */         XMournInfo xMournInfo = Role2mourn.get(Long.valueOf(roleId));
/* 170 */         if (xMournInfo == null)
/*     */         {
/* 172 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ xMournInfo is null!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId) }));
/*     */           
/*     */ 
/*     */ 
/* 176 */           return false;
/*     */         }
/* 178 */         XMTaskInfo xmTaskInfo = (XMTaskInfo)xMournInfo.getMourndatas().get(Integer.valueOf(cfg.id));
/* 179 */         if (xmTaskInfo == null)
/*     */         {
/* 181 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ xmTaskInfo is null!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId) }));
/*     */           
/*     */ 
/*     */ 
/* 185 */           return false;
/*     */         }
/* 187 */         if (xmTaskInfo.getState() != 1)
/*     */         {
/* 189 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ xmTaskInfo is not UN_ACCEPTED!|roleId=%d|graphId=%d|taskId=%d|state=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(xmTaskInfo.getState()) }));
/*     */           
/*     */ 
/*     */ 
/* 193 */           return false;
/*     */         }
/* 195 */         changeMTaskState(userId, roleId, cfg.id, xmTaskInfo, 2);
/*     */         
/* 197 */         return true;
/*     */       }
/*     */     }
/* 200 */     if (((TaskEventArg)this.arg).graphId == MournConsts.getInstance().questionGraphId)
/*     */     {
/* 202 */       if (((TaskEventArg)this.arg).taskState == 8)
/*     */       {
/* 204 */         if (!((TaskEventArg)this.arg).isToEnd)
/*     */         {
/* 206 */           return false;
/*     */         }
/*     */         
/* 209 */         String userId = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/* 210 */         lock(Lockeys.get(User.getTable(), userId));
/*     */         
/* 212 */         lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((TaskEventArg)this.arg).roleId) }));
/* 213 */         XMournInfo xMournInfo = Role2mourn.get(Long.valueOf(roleId));
/* 214 */         if (xMournInfo == null)
/*     */         {
/* 216 */           GameServer.logger().info(String.format("[mourn]POnTaskChanged.processImp@ xMournInfo is null!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId) }));
/*     */           
/*     */ 
/*     */ 
/* 220 */           return false;
/*     */         }
/*     */         
/* 223 */         ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, MournConsts.getInstance().activityId);
/*     */         
/* 225 */         if (!res.isCanJoin())
/*     */         {
/* 227 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ activity is forbid!|roleId=%d|reason=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(res.getReasonValue()) }));
/*     */           
/*     */ 
/* 230 */           return false;
/*     */         }
/* 232 */         if (xMournInfo.getLastmourndata().getState() == 3)
/*     */         {
/*     */ 
/* 235 */           GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ already questioned!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 242 */           long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 243 */           if (curTime < ActivityInterface.getActivityEndTime(MournConsts.getInstance().activityId))
/*     */           {
/* 245 */             if (!MournManager.canGetLastTaskAward(roleId, xMournInfo))
/*     */             {
/* 247 */               GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@can not get award!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId) }));
/*     */               
/*     */ 
/*     */ 
/* 251 */               return false;
/*     */             }
/* 253 */             AwardReason awardReason = new AwardReason(LogReason.MOURN_QUESTION_AWAED, ((TaskEventArg)this.arg).graphId);
/* 254 */             AwardModel awardModel = AwardInterface.awardFixAward(MournConsts.getInstance().questionAwardId, userId, roleId, false, true, awardReason);
/*     */             
/* 256 */             if (awardModel == null)
/*     */             {
/* 258 */               GameServer.logger().error(String.format("[mourn]POnTaskChanged.processImp@ do question award err!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId) }));
/*     */               
/*     */ 
/*     */ 
/* 262 */               return false;
/*     */             }
/*     */             
/* 265 */             xMournInfo.getLastmourndata().setState(3);
/*     */             
/* 267 */             OnlineManager.getInstance().send(roleId, new SSynLastMourn(3));
/*     */             
/* 269 */             ActivityInterface.addActivityCount(userId, roleId, MournConsts.getInstance().activityId);
/*     */             
/* 271 */             MournManager.tlogMourn(userId, roleId, 0, 3L);
/*     */           }
/*     */         }
/* 274 */         return true;
/*     */       }
/*     */       
/* 277 */       if (((TaskEventArg)this.arg).taskState == 2)
/*     */       {
/*     */ 
/* 280 */         String userId = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/* 281 */         lock(Lockeys.get(User.getTable(), userId));
/*     */         
/* 283 */         lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((TaskEventArg)this.arg).roleId) }));
/* 284 */         XMournInfo xMournInfo = Role2mourn.get(Long.valueOf(roleId));
/* 285 */         if (xMournInfo == null)
/*     */         {
/* 287 */           GameServer.logger().info(String.format("[mourn]POnTaskChanged.processImp@ xMournInfo is null!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId) }));
/*     */           
/*     */ 
/*     */ 
/* 291 */           return false;
/*     */         }
/* 293 */         if (xMournInfo.getLastmourndata().getState() != 1)
/*     */         {
/* 295 */           return false;
/*     */         }
/* 297 */         xMournInfo.getLastmourndata().setState(2);
/* 298 */         OnlineManager.getInstance().send(roleId, new SSynLastMourn(2));
/*     */         
/* 300 */         MournManager.tlogMourn(userId, roleId, 0, 2L);
/* 301 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 305 */     return false;
/*     */   }
/*     */   
/*     */   private void changeMTaskState(String userId, long roleId, int mournId, XMTaskInfo xmTaskInfo, int state)
/*     */   {
/* 310 */     xmTaskInfo.setState(state);
/*     */     
/* 312 */     SSynSingleMournInfo pro = new SSynSingleMournInfo();
/* 313 */     pro.mournid = mournId;
/* 314 */     pro.mourninfo = new MTaskInfo(state);
/* 315 */     OnlineManager.getInstance().send(roleId, pro);
/*     */     
/* 317 */     MournManager.tlogMourn(userId, roleId, mournId, state);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\main\POnTaskChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */