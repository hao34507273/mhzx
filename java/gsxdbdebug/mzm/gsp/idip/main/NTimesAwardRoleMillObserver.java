/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2NTimesAwardInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2ntimesaward;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NTimesAwardRoleMillObserver
/*     */   extends MilliObserver
/*     */ {
/*     */   private final long roleId;
/*     */   private final int buffId;
/*     */   private final NTimesAwardInfo nTimesAwardInfo;
/*     */   private final int idipNTimesOperator;
/*     */   
/*     */   public NTimesAwardRoleMillObserver(long interval, long roleId, int buffId, NTimesAwardInfo nTimesAwardInfo, int idipNTimesOperator)
/*     */   {
/*  31 */     super(interval);
/*  32 */     this.roleId = roleId;
/*  33 */     this.buffId = buffId;
/*  34 */     this.nTimesAwardInfo = nTimesAwardInfo;
/*  35 */     this.idipNTimesOperator = idipNTimesOperator;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  41 */     if (!OpenInterface.getOpenStatus(55))
/*     */     {
/*  43 */       GameServer.logger().info(String.format("[ntimesaward]NTimesAwardRoleMillObserver.update@n times award system switch closed|buff_id=%d|n_times_operator=%d|n_times=%d|start_time=%d|expire_time=%d", new Object[] { Integer.valueOf(this.buffId), Integer.valueOf(this.idipNTimesOperator), Integer.valueOf(this.nTimesAwardInfo.getNTimes()), Long.valueOf(this.nTimesAwardInfo.getStartTime()), Long.valueOf(this.nTimesAwardInfo.getExpireTime()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (OpenInterface.isBanPlay(this.roleId, 55))
/*     */     {
/*  54 */       GameServer.logger().info(String.format("[ntimesaward]NTimesAwardRoleMillObserver.update@n times award is ban play|buff_id=%d|n_times_operator=%d|n_times=%d|start_time=%d|expire_time=%d", new Object[] { Integer.valueOf(this.buffId), Integer.valueOf(this.idipNTimesOperator), Integer.valueOf(this.nTimesAwardInfo.getNTimes()), Long.valueOf(this.nTimesAwardInfo.getStartTime()), Long.valueOf(this.nTimesAwardInfo.getExpireTime()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     if (this.idipNTimesOperator == 1)
/*     */     {
/*  66 */       new PInstallRoleNTimesAwardBuff(this.roleId, this.buffId, this.nTimesAwardInfo).execute();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  71 */       new PUninstallRoleNTimesAwardBuff(this.roleId, this.buffId, this.nTimesAwardInfo).execute();
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static class PInstallRoleNTimesAwardBuff
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     private final int buffId;
/*     */     private final NTimesAwardInfo nTimesAwardInfo;
/*     */     
/*     */     public PInstallRoleNTimesAwardBuff(long roleId, int buffId, NTimesAwardInfo nTimesAwardInfo)
/*     */     {
/*  87 */       this.roleId = roleId;
/*  88 */       this.buffId = buffId;
/*  89 */       this.nTimesAwardInfo = nTimesAwardInfo;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  95 */       if (!OpenInterface.getOpenStatus(55))
/*     */       {
/*  97 */         GameServer.logger().info(String.format("[ntimesaward]PInstallRoleNTimesAwardBuff.processImp@n times award system switch closed|buff_id=%d|n_times=%d|start_time=%d|expire_time=%d", new Object[] { Integer.valueOf(this.buffId), Integer.valueOf(this.nTimesAwardInfo.getNTimes()), Long.valueOf(this.nTimesAwardInfo.getStartTime()), Long.valueOf(this.nTimesAwardInfo.getExpireTime()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 103 */         return false;
/*     */       }
/*     */       
/* 106 */       if (OpenInterface.isBanPlay(this.roleId, 55))
/*     */       {
/* 108 */         GameServer.logger().info(String.format("[ntimesaward]PInstallRoleNTimesAwardBuff.processImp@n times award system switch closed|buff_id=%d|n_times=%d|start_time=%d|expire_time=%d", new Object[] { Integer.valueOf(this.buffId), Integer.valueOf(this.nTimesAwardInfo.getNTimes()), Long.valueOf(this.nTimesAwardInfo.getStartTime()), Long.valueOf(this.nTimesAwardInfo.getExpireTime()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */         return false;
/*     */       }
/*     */       
/* 117 */       String userId = RoleInterface.getUserId(this.roleId);
/* 118 */       lock(Lockeys.get(User.getTable(), userId));
/*     */       
/* 120 */       if (DateTimeUtils.getCurrTimeInMillis() >= this.nTimesAwardInfo.getExpireTime())
/*     */       {
/* 122 */         GameServer.logger().info(String.format("[ntimesaward]PInstallRoleNTimesAwardBuff.processImp@n times award expired during task|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|expire_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.buffId), Integer.valueOf(this.nTimesAwardInfo.getNTimes()), Long.valueOf(this.nTimesAwardInfo.getStartTime()), Long.valueOf(this.nTimesAwardInfo.getExpireTime()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 127 */         return false;
/*     */       }
/*     */       
/* 130 */       BuffInterface.installIDIPBuff(this.roleId, this.buffId, this.nTimesAwardInfo.getNTimes(), this.nTimesAwardInfo.getExpireTime());
/*     */       
/* 132 */       GameServer.logger().info(String.format("[ntimesaward]PInstallRoleNTimesAwardBuff.processImp@role install n_times buff success|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.buffId), Integer.valueOf(this.nTimesAwardInfo.getNTimes()), Long.valueOf(this.nTimesAwardInfo.getStartTime()), Long.valueOf(this.nTimesAwardInfo.getExpireTime()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 138 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static class PUninstallRoleNTimesAwardBuff
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     private final int buffId;
/*     */     
/*     */     private final NTimesAwardInfo nTimesAwardInfo;
/*     */     
/*     */ 
/*     */     public PUninstallRoleNTimesAwardBuff(long roleId, int buffId, NTimesAwardInfo nTimesAwardInfo)
/*     */     {
/* 155 */       this.roleId = roleId;
/* 156 */       this.buffId = buffId;
/* 157 */       this.nTimesAwardInfo = nTimesAwardInfo;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 164 */       String userId = RoleInterface.getUserId(this.roleId);
/* 165 */       lock(User.getTable(), Arrays.asList(new String[] { userId }));
/* 166 */       lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 169 */       NTimesAwardManager.removeRoleNTimesAwardMapInfo(this.roleId, this.buffId);
/*     */       
/* 171 */       Role2NTimesAwardInfo xRole2nTimesAwardInfo = Role2ntimesaward.get(Long.valueOf(this.roleId));
/* 172 */       if (xRole2nTimesAwardInfo == null)
/*     */       {
/* 174 */         return false;
/*     */       }
/* 176 */       xRole2nTimesAwardInfo.getN_times_award_role_map().remove(Integer.valueOf(this.buffId));
/*     */       
/* 178 */       GameServer.logger().info(String.format("[ntimesaward]PUninstallRoleNTimesAwardBuff.processImp@role uninstall n_times buff success|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.buffId), Integer.valueOf(this.nTimesAwardInfo.getNTimes()), Long.valueOf(this.nTimesAwardInfo.getStartTime()), Long.valueOf(this.nTimesAwardInfo.getExpireTime()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 184 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\NTimesAwardRoleMillObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */