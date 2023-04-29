/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.idip.NoticeInfo;
/*     */ import mzm.gsp.idip.SSyncNotices;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IdipNTimesAwardInfo;
/*     */ import xbean.Role2NTimesAwardInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2ntimesaward;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public POnRoleLogin(long roleId)
/*     */   {
/*  30 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     new PCheckZeroProfit(this.roleId).execute();
/*     */     
/*  44 */     new PSendNotices(this.roleId).execute();
/*     */     
/*  46 */     if (!OpenInterface.getOpenStatus(55))
/*     */     {
/*  48 */       GameServer.logger().info(String.format("[ntimesaward]POnRoleLogin.processImp@n times award system switch closed|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (OpenInterface.isBanPlay(this.roleId, 55))
/*     */     {
/*  56 */       GameServer.logger().info(String.format("[ntimesaward]POnRoleLogin.processImp@n times award is ban play|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  63 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  65 */     Role2NTimesAwardInfo xRole2nTimesAwardInfo = Role2ntimesaward.get(Long.valueOf(this.roleId));
/*  66 */     if (xRole2nTimesAwardInfo != null)
/*     */     {
/*     */ 
/*  69 */       Iterator<Map.Entry<Integer, IdipNTimesAwardInfo>> iterator = xRole2nTimesAwardInfo.getN_times_award_role_map().entrySet().iterator();
/*  70 */       while (iterator.hasNext())
/*     */       {
/*  72 */         Map.Entry<Integer, IdipNTimesAwardInfo> entry = (Map.Entry)iterator.next();
/*  73 */         long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  74 */         IdipNTimesAwardInfo xIdipNTimesAwardInfo = (IdipNTimesAwardInfo)entry.getValue();
/*     */         
/*  76 */         long startTime = xIdipNTimesAwardInfo.getStart_time();
/*  77 */         long expireTime = xIdipNTimesAwardInfo.getExpire_time();
/*  78 */         int buffId = ((Integer)entry.getKey()).intValue();
/*  79 */         int nTimes = xIdipNTimesAwardInfo.getN_times();
/*     */         
/*  81 */         if (expireTime <= currentTimeMillis)
/*     */         {
/*  83 */           iterator.remove();
/*  84 */           GameServer.logger().info(String.format("[ntimesaward]POnRoleLogin.processImp@role buff remove from xdb,time expire|role_id=%d|buff_id=%d|start_time=%d|end_time=%d|n_times=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(buffId), Long.valueOf(startTime), Long.valueOf(expireTime), Integer.valueOf(nTimes) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*  90 */           long startInterval = startTime - currentTimeMillis;
/*     */           
/*     */ 
/*  93 */           NTimesAwardRoleMillObserver roleStartObserver = new NTimesAwardRoleMillObserver(startInterval < 0L ? 0L : startInterval, this.roleId, buffId, new NTimesAwardInfo(nTimes, startTime, expireTime), 1);
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
/* 104 */           NTimesAwardRoleMillObserver roleEndObserver = new NTimesAwardRoleMillObserver(expireTime - currentTimeMillis, this.roleId, buffId, null, 0);
/*     */           
/*     */ 
/* 107 */           NTimesAwardManager.addRoleObserver(this.roleId, buffId, roleStartObserver, roleEndObserver);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 112 */     NTimesAwardManager.globalNTimesAwardInstallLogin(this.roleId);
/*     */     
/* 114 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private class PCheckZeroProfit
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */ 
/*     */     public PCheckZeroProfit(long roleId)
/*     */     {
/* 129 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 136 */       IdipManager.checkZeroProfitLogin(this.roleId);
/* 137 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private class PSendNotices
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */ 
/*     */     public PSendNotices(long roleId)
/*     */     {
/* 153 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 159 */       List<NoticeDataInfo> notices = NoticeManager.getCurrentNotices(DateTimeUtils.getCurrTimeInMillis());
/* 160 */       ArrayList<NoticeInfo> result = new ArrayList(notices.size());
/* 161 */       int size = notices.size(); for (int i = 0; i < size; i++)
/*     */       {
/* 163 */         result.add(NoticeManager.transToNoticeInfo((NoticeDataInfo)notices.get(i)));
/*     */       }
/* 165 */       SSyncNotices msg = new SSyncNotices();
/* 166 */       msg.notices = result;
/* 167 */       OnlineManager.getInstance().send(this.roleId, msg);
/* 168 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */