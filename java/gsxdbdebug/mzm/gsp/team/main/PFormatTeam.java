/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PFormatTeam
/*     */ {
/*  22 */   private static PFormatTeam instance = new PFormatTeam();
/*  23 */   public PFormatTeam() { this.mutex = new ReentrantLock();
/*  24 */     this.bussinessLocks = new HashMap();
/*     */   }
/*     */   
/*     */   public static PFormatTeam getInstance() {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Lock getLock(long bussinessId)
/*     */   {
/*  40 */     this.mutex.lock();
/*     */     try
/*     */     {
/*  43 */       Pair<Lock, Integer> lockInfo = (Pair)this.bussinessLocks.get(Long.valueOf(bussinessId));
/*  44 */       Object localObject1; if (lockInfo == null)
/*     */       {
/*  46 */         lockInfo = new Pair(new ReentrantLock(), Integer.valueOf(1));
/*  47 */         this.bussinessLocks.put(Long.valueOf(bussinessId), lockInfo);
/*     */       }
/*     */       else
/*     */       {
/*  51 */         localObject1 = lockInfo;(((Pair)localObject1).second = Integer.valueOf(((Integer)((Pair)localObject1).second).intValue() + 1));
/*     */       }
/*     */       
/*  54 */       return (Lock)lockInfo.first;
/*     */     }
/*     */     finally
/*     */     {
/*  58 */       this.mutex.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void returnLock(long bussinessId)
/*     */   {
/*  70 */     this.mutex.lock();
/*     */     try
/*     */     {
/*  73 */       Pair<Lock, Integer> lockInfo = (Pair)this.bussinessLocks.get(Long.valueOf(bussinessId));
/*  74 */       if (lockInfo == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/*  79 */       if ((lockInfo.second = Integer.valueOf(((Integer)lockInfo.second).intValue() - 1)).intValue() > 0) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/*  84 */       this.bussinessLocks.remove(Long.valueOf(bussinessId));
/*     */     }
/*     */     finally
/*     */     {
/*  88 */       this.mutex.unlock();
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
/*     */   void formatCreateTeamAsTmpLeave(long bussinessId, List<Long> templetMembers)
/*     */   {
/* 103 */     formatCreateTeam(bussinessId, templetMembers, JoinTeamType.JOIN_TEAM__FORMAT_AS_TMP_LEAVE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private final Lock mutex;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void formatCreateTeamInCondition(long bussinessId, List<Long> templetMembers)
/*     */   {
/* 119 */     formatCreateTeam(bussinessId, templetMembers, JoinTeamType.JOIN_TEAM__FORMAT_IN_CONDITION);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private final Map<Long, Pair<Lock, Integer>> bussinessLocks;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void formatCreateTeam(long bussinessId, final List<Long> templetMembers, final JoinTeamType joinTeamType)
/*     */   {
/* 137 */     Lock lock = getLock(bussinessId);
/* 138 */     lock.lock();
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 143 */       if ((templetMembers == null) || (templetMembers.size() == 0))
/*     */       {
/* 145 */         GameServer.logger().error(String.format("[team]PFormatTeam.formatCreateTeam@tempMembers illegal(null or size is 0)!", new Object[0]));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 150 */         for (int i = 0; i < 3; i++)
/*     */         {
/* 152 */           final int tryCount = i;
/* 153 */           final Pair<Boolean, Long> pair = new Pair(Boolean.valueOf(false), null);
/* 154 */           new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/* 159 */               GameServer.logger().info(String.format("[team]PFormatTeam.formatCreateTeam@try create team info|tempMembers=%s|tryCount=%d", new Object[] { templetMembers.toString(), Integer.valueOf(tryCount) }));
/*     */               
/*     */ 
/*     */ 
/* 163 */               lock(Basic.getTable(), templetMembers);
/* 164 */               PFormatTeam.fillTeamState(templetMembers, pair);
/*     */               
/* 166 */               if (((Boolean)pair.first).booleanValue())
/*     */               {
/* 168 */                 return false;
/*     */               }
/*     */               
/* 171 */               if (pair.second == null)
/*     */               {
/* 173 */                 PFormatTeam.CreateFormatTeam p = new PFormatTeam.CreateFormatTeam(PFormatTeam.this, templetMembers, joinTeamType);
/* 174 */                 if (!p.call())
/*     */                 {
/* 176 */                   GameServer.logger().error(String.format("[team]PFormatTeam.formatCreateTeam@CreateFormatTeam fail!|tempMembers=%s|tryCount=%d", new Object[] { templetMembers.toString(), Integer.valueOf(tryCount) }));
/*     */                   
/*     */ 
/*     */ 
/* 180 */                   return false;
/*     */                 }
/* 182 */                 pair.second = Long.valueOf(p.getTeamId());
/*     */               }
/* 184 */               return true;
/*     */             }
/*     */           }.call();
/*     */           
/* 188 */           if ((pair.second != null) && (((Long)pair.second).longValue() > 0L)) {
/*     */             return;
/*     */           }
/*     */           
/*     */ 
/* 193 */           if (((Boolean)pair.first).booleanValue())
/*     */           {
/* 195 */             GameServer.logger().info(String.format("[team]PFormatTeam.formatCreateTeam@need dismis team!|tempMembers=%s", new Object[] { templetMembers.toString() }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 200 */             Map<Long, Long> errRoleId2teamId = clearMembersTeamData(templetMembers);
/* 201 */             if (errRoleId2teamId.size() > 0)
/*     */             {
/* 203 */               GameServer.logger().error(String.format("[team]PFormatTeam.formatCreateTeam@clear members' team data fail!|tempMembers=%s|errRoleId2teamId=%s", new Object[] { templetMembers.toString(), errRoleId2teamId.toString() }));
/*     */             }
/*     */             
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 213 */       lock.unlock();
/*     */       
/* 215 */       returnLock(bussinessId);
/*     */     }
/*     */   }
/*     */   
/*     */   static void fillTeamState(List<Long> members, Pair<Boolean, Long> pair)
/*     */   {
/* 221 */     long leaderId = ((Long)members.get(0)).longValue();
/* 222 */     Long teamid = Role2team.get(Long.valueOf(leaderId));
/* 223 */     for (int i = members.size() - 1; i > 0; i--)
/*     */     {
/* 225 */       long roleId = ((Long)members.get(i)).longValue();
/* 226 */       Long teamId_temp = Role2team.get(Long.valueOf(roleId));
/*     */       
/*     */ 
/* 229 */       if (((teamId_temp != null) || (teamid != null)) && ((teamId_temp == null) || (teamid == null) || (!teamid.equals(teamId_temp))))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 234 */         pair.first = Boolean.valueOf(true);
/* 235 */         pair.second = null;
/*     */         
/* 237 */         GameServer.logger().info(String.format("[team]PFormatTeam.fillTeamState@ need dismis team!|members=%s|teamId=%s|teamId_temp=%s|leaderId=%d|roleId=%d", new Object[] { members.toString(), teamid, teamId_temp, Long.valueOf(leaderId), Long.valueOf(roleId) }));
/*     */         
/*     */ 
/*     */ 
/* 241 */         return;
/*     */       }
/*     */     }
/* 244 */     pair.first = Boolean.valueOf(false);
/* 245 */     pair.second = teamid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Long, Long> clearMembersTeamData(List<Long> roleIds)
/*     */   {
/* 255 */     Map<Long, Long> errRoleId2teamId = new HashMap();
/* 256 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 258 */       new PForceLeaveTeam(roleId).call();
/* 259 */       Long teamId = Role2team.select(Long.valueOf(roleId));
/* 260 */       if (teamId != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 265 */         long teamId_0 = reLeaveTeam(roleId);
/* 266 */         if (teamId_0 > 0L)
/*     */         {
/*     */ 
/*     */ 
/* 270 */           errRoleId2teamId.put(Long.valueOf(roleId), Long.valueOf(teamId_0)); }
/*     */       } }
/* 272 */     return errRoleId2teamId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long reLeaveTeam(long roleId)
/*     */   {
/* 283 */     GameServer.logger().info(String.format("[team]PFormatTeam.reLeaveTeam@ last leave team failed! try again!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */     
/* 285 */     new PForceLeaveTeam(roleId).call();
/* 286 */     Long teamId = Role2team.select(Long.valueOf(roleId));
/* 287 */     if (teamId == null)
/*     */     {
/* 289 */       return -1L;
/*     */     }
/* 291 */     GameServer.logger().info(String.format("[team]PFormatTeam.reLeaveTeam@ try again and failed again! try again!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(teamId.longValue()) }));
/*     */     
/*     */ 
/* 294 */     return teamId.longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class CreateFormatTeam
/*     */     extends LogicProcedure
/*     */   {
/* 305 */     private long teamId = -1L;
/*     */     private final List<Long> tempMembers;
/*     */     private final JoinTeamType joinTeamType;
/*     */     
/*     */     CreateFormatTeam(JoinTeamType tempMembers)
/*     */     {
/* 311 */       this.tempMembers = tempMembers;
/* 312 */       this.joinTeamType = joinTeamType;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 319 */       if ((this.tempMembers == null) || (this.tempMembers.size() == 0))
/*     */       {
/* 321 */         GameServer.logger().error(String.format(String.format("[team]PFormatTeam.process@tempMembers illegal(null or size is 0)!", new Object[0]), new Object[0]));
/*     */         
/* 323 */         return false;
/*     */       }
/*     */       
/* 326 */       lock(Basic.getTable(), this.tempMembers);
/* 327 */       long leaderId = getLeaderId(this.tempMembers);
/* 328 */       if (leaderId <= 0L)
/*     */       {
/* 330 */         GameServer.logger().error(String.format("[team]PFormatTeam.CreateFormatTeam.processImp@ leader not online!|tempMembers=%s", new Object[] { this.tempMembers.toString() }));
/*     */         
/*     */ 
/* 333 */         return false;
/*     */       }
/*     */       
/* 336 */       if (!TeamInterface.createTeam(leaderId))
/*     */       {
/* 338 */         GameServer.logger().error(String.format("[team]PFormatTeam.CreateFormatTeam.processImp@ create team fail!|tempMembers=%s", new Object[] { this.tempMembers.toString() }));
/*     */         
/*     */ 
/* 341 */         return false;
/*     */       }
/* 343 */       Pair<Boolean, Long> pair = joinTeamFormating(this.tempMembers, this.joinTeamType);
/* 344 */       if (!((Boolean)pair.first).booleanValue())
/*     */       {
/* 346 */         GameServer.logger().error(String.format("[team]PFormatTeam.CreateFormatTeam.processImp@ joinTeamFormating fail!|tempMembers=%s", new Object[] { this.tempMembers.toString() }));
/*     */         
/*     */ 
/* 349 */         return false;
/*     */       }
/* 351 */       this.teamId = ((Long)pair.second).longValue();
/* 352 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private long getLeaderId(List<Long> tempMembers)
/*     */     {
/* 362 */       long leaderId = ((Long)tempMembers.get(0)).longValue();
/* 363 */       if (!OnlineManager.getInstance().isOnline(leaderId))
/*     */       {
/* 365 */         GameServer.logger().error(String.format("[team]PFormatTeam.CreateFormatTeam.getLeaderId@ leader not online!|tempMembers=%s", new Object[] { tempMembers.toString() }));
/*     */         
/*     */ 
/* 368 */         return -1L;
/*     */       }
/* 370 */       return leaderId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private Pair<Boolean, Long> joinTeamFormating(List<Long> tempMembers, JoinTeamType joinTeamType)
/*     */     {
/* 381 */       Pair<Boolean, Long> pair = new Pair(Boolean.valueOf(false), Long.valueOf(-1L));
/* 382 */       Long teamId = Role2team.get((Long)tempMembers.get(0));
/* 383 */       if (teamId == null)
/*     */       {
/* 385 */         GameServer.logger().error(String.format("[team]PFormatTeam.CreateFormatTeam.joinTeamFormating@ no teamId!|tempMembers=%s", new Object[] { tempMembers.toString() }));
/*     */         
/*     */ 
/* 388 */         return pair;
/*     */       }
/* 390 */       if (tempMembers.size() > 1)
/*     */       {
/*     */ 
/* 393 */         for (int index = 1; index < tempMembers.size(); index++)
/*     */         {
/* 395 */           long roleId = ((Long)tempMembers.get(index)).longValue();
/*     */           
/* 397 */           if (!TeamManagerForInterSerVice.joinTeamByTeamId(teamId.longValue(), roleId, joinTeamType))
/*     */           {
/* 399 */             GameServer.logger().error(String.format("[team]PFormatTeam.CreateFormatTeam.joinTeamFormating@ join team fail!|tempMembers=%s|teamId=%d|roleId=%d", new Object[] { tempMembers.toString(), Long.valueOf(teamId.longValue()), Long.valueOf(roleId) }));
/*     */             
/*     */ 
/*     */ 
/* 403 */             return pair;
/*     */           }
/*     */         }
/*     */       }
/* 407 */       pair.first = Boolean.valueOf(true);
/* 408 */       pair.second = teamId;
/* 409 */       return pair;
/*     */     }
/*     */     
/*     */     public long getTeamId()
/*     */     {
/* 414 */       return this.teamId;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PFormatTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */