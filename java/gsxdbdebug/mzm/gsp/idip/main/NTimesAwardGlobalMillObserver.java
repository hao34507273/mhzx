/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IdipConfigInfo;
/*     */ import xbean.IdipNTimesAwardInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Idipconfig;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class NTimesAwardGlobalMillObserver
/*     */   extends MilliObserver
/*     */ {
/*     */   private final int buffId;
/*     */   private final int idipNTimesOperator;
/*     */   private final NTimesAwardInfo nTimesAwardInfo;
/*     */   
/*     */   public NTimesAwardGlobalMillObserver(long intervalMilliSeconds, int buffId, NTimesAwardInfo nTimesAwardInfo, int idipNTimesOperator)
/*     */   {
/*  36 */     super(intervalMilliSeconds);
/*  37 */     this.buffId = buffId;
/*  38 */     this.idipNTimesOperator = idipNTimesOperator;
/*  39 */     this.nTimesAwardInfo = nTimesAwardInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  45 */     if (!OpenInterface.getOpenStatus(55))
/*     */     {
/*  47 */       GameServer.logger().info(String.format("[ntimesaward]NTimesAwardGlobalMillObserver.update@n times award system switch closed|buff_id=%d|n_times_operator=%d|n_times=%d|start_time=%d|expire_time=%d", new Object[] { Integer.valueOf(this.buffId), Integer.valueOf(this.idipNTimesOperator), Integer.valueOf(this.nTimesAwardInfo.getNTimes()), Long.valueOf(this.nTimesAwardInfo.getStartTime()), Long.valueOf(this.nTimesAwardInfo.getExpireTime()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (this.idipNTimesOperator == 1)
/*     */     {
/*     */ 
/*  59 */       new PInstallGlobalNTimeAwardBuff(this.buffId, this.nTimesAwardInfo).execute();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  64 */       new PUnInstallGlobalNTimesAwardBuff(this.buffId, this.nTimesAwardInfo).execute();
/*     */     }
/*     */     
/*  67 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static class PInstallGlobalNTimeAwardBuff
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int buffId;
/*     */     
/*     */     private final NTimesAwardInfo nTimesAwardInfo;
/*     */     
/*     */     public PInstallGlobalNTimeAwardBuff(int buffId, NTimesAwardInfo nTimesAwardInfo)
/*     */     {
/*  80 */       this.buffId = buffId;
/*  81 */       this.nTimesAwardInfo = nTimesAwardInfo;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  87 */       if (!OpenInterface.getOpenStatus(55))
/*     */       {
/*  89 */         GameServer.logger().info(String.format("[ntimesaward]PInstallGlobalNTimeAwardBuff.processImp@n times award system switch closed|buff_id=%d|n_times=%d|start_time=%d|expire_time=%d", new Object[] { Integer.valueOf(this.buffId), Integer.valueOf(this.nTimesAwardInfo.getNTimes()), Long.valueOf(this.nTimesAwardInfo.getStartTime()), Long.valueOf(this.nTimesAwardInfo.getExpireTime()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  99 */       NTimesAwardManager.addCurrentGlobalNTimesAwardInfo(this.buffId, this.nTimesAwardInfo);
/*     */       
/* 101 */       List<Long> roles = OnlineManager.getInstance().getAllRolesInWorld();
/* 102 */       for (Iterator i$ = roles.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 104 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */         {
/*     */ 
/*     */ 
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/*     */ 
/* 112 */             if (OpenInterface.isBanPlay(roleId, 55))
/*     */             {
/* 114 */               GameServer.logger().info(String.format("[ntimesaward]PInstallGlobalNTimeAwardBuff.processImp@n times award is ban play|buff_id=%d|n_times=%d|start_time=%d|expire_time=%d", new Object[] { Integer.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.buffId), Integer.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getNTimes()), Long.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getStartTime()), Long.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getExpireTime()) }));
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */               return false;
/*     */             }
/*     */             
/*     */ 
/* 124 */             String userId = RoleInterface.getUserId(roleId);
/* 125 */             lock(Lockeys.get(User.getTable(), userId));
/*     */             
/*     */ 
/* 128 */             if (!OnlineManager.getInstance().isOnline(roleId))
/*     */             {
/* 130 */               GameServer.logger().info(String.format("[ntimesaward]PInstallGlobalNTimeAwardBuff.processImp@role offline during none real time task|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.buffId), Integer.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getNTimes()), Long.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getStartTime()), Long.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getExpireTime()) }));
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 135 */               return true;
/*     */             }
/*     */             
/* 138 */             long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/* 139 */             if (currTimeInMillis >= NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getExpireTime())
/*     */             {
/* 141 */               GameServer.logger().info(String.format("[ntimesaward]PInstallGlobalNTimeAwardBuff.processImp@n times award expire during task|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.buffId), Integer.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getNTimes()), Long.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getStartTime()), Long.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getExpireTime()) }));
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 146 */               return true;
/*     */             }
/*     */             
/* 149 */             if (CrossBattleKnockoutInterface.isFinalServerAwardBuff(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.buffId))
/*     */             {
/* 151 */               int roleZoneId = GameServerInfoManager.getZoneidFromRoleid(roleId);
/* 152 */               if (!NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getValidedZoneIdSet().contains(Integer.valueOf(roleZoneId)))
/*     */               {
/* 154 */                 return false;
/*     */               }
/*     */               
/* 157 */               if (!CrossBattleKnockoutInterface.isCrossBattleServerBuffSwitchOpen(roleId))
/*     */               {
/* 159 */                 return false;
/*     */               }
/*     */             }
/*     */             
/* 163 */             BuffInterface.installIDIPBuff(roleId, NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.buffId, NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getNTimes(), NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getExpireTime());
/*     */             
/*     */ 
/* 166 */             GameServer.logger().info(String.format("[ntimesaward]PInstallGlobalNTimeAwardBuff.processImp@global install n_times buff success|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.buffId), Integer.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getNTimes()), Long.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getStartTime()), Long.valueOf(NTimesAwardGlobalMillObserver.PInstallGlobalNTimeAwardBuff.this.nTimesAwardInfo.getExpireTime()) }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 172 */             return true;
/*     */           }
/*     */         });
/*     */       }
/* 176 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static class PUnInstallGlobalNTimesAwardBuff
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int buffId;
/*     */     
/*     */     private final NTimesAwardInfo nTimesAwardInfo;
/*     */     
/*     */     public PUnInstallGlobalNTimesAwardBuff(int buffId, NTimesAwardInfo nTimesAwardInfo)
/*     */     {
/* 190 */       this.buffId = buffId;
/* 191 */       this.nTimesAwardInfo = nTimesAwardInfo;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 197 */       lock(Idipconfig.getTable(), Arrays.asList(new Long[] { Long.valueOf(GameServerInfoManager.getLocalId()) }));
/*     */       
/* 199 */       NTimesAwardManager.removeCurrentGlobalNTimesAwardInfo(this.buffId);
/*     */       
/* 201 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 202 */       if (xIdipConfigInfo == null)
/*     */       {
/* 204 */         return false;
/*     */       }
/* 206 */       Map<Integer, IdipNTimesAwardInfo> xIdipNTimeAwardMap = xIdipConfigInfo.getN_times_award();
/* 207 */       xIdipNTimeAwardMap.remove(Integer.valueOf(this.buffId));
/*     */       
/* 209 */       List<Long> roles = OnlineManager.getInstance().getAllRolesInWorld();
/* 210 */       for (Iterator i$ = roles.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 212 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */         {
/*     */ 
/*     */ 
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/*     */ 
/*     */ 
/* 221 */             String userId = RoleInterface.getUserId(roleId);
/* 222 */             lock(Lockeys.get(User.getTable(), userId));
/*     */             
/* 224 */             BuffInterface.uninstallBuf(roleId, NTimesAwardGlobalMillObserver.PUnInstallGlobalNTimesAwardBuff.this.buffId);
/*     */             
/* 226 */             GameServer.logger().info(String.format("[ntimesaward]PUnInstallGlobalNTimesAwardBuff.processImp@global uninstall n_times buff success|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(NTimesAwardGlobalMillObserver.PUnInstallGlobalNTimesAwardBuff.this.buffId), Integer.valueOf(NTimesAwardGlobalMillObserver.PUnInstallGlobalNTimesAwardBuff.this.nTimesAwardInfo.getNTimes()), Long.valueOf(NTimesAwardGlobalMillObserver.PUnInstallGlobalNTimesAwardBuff.this.nTimesAwardInfo.getStartTime()), Long.valueOf(NTimesAwardGlobalMillObserver.PUnInstallGlobalNTimesAwardBuff.this.nTimesAwardInfo.getExpireTime()) }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 232 */             return true;
/*     */           }
/*     */         });
/*     */       }
/* 236 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\NTimesAwardGlobalMillObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */