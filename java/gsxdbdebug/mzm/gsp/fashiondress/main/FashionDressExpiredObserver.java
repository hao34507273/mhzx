/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.SFashionDressExpired;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FashionDressInfo;
/*     */ import xbean.Role2FashionDressInfo;
/*     */ import xbean.Role2FashionDressObserverInfo;
/*     */ import xdb.Lockeys;
/*     */ import xio.Protocol;
/*     */ import xtable.Role2fashiondress;
/*     */ import xtable.Role2fashiondressobserver;
/*     */ import xtable.User;
/*     */ 
/*     */ public class FashionDressExpiredObserver
/*     */   extends MilliObserver
/*     */ {
/*     */   private final int fashionDressCfgId;
/*     */   private final long roleId;
/*     */   
/*     */   public boolean update()
/*     */   {
/*  32 */     PFashionDressExpired localPFashionDressExpired = new PFashionDressExpired(this.roleId, this.fashionDressCfgId);
/*  33 */     localPFashionDressExpired.execute();
/*  34 */     return false;
/*     */   }
/*     */   
/*     */   public FashionDressExpiredObserver(long paramLong1, long paramLong2, int paramInt)
/*     */   {
/*  39 */     super(paramLong1);
/*  40 */     this.roleId = paramLong2;
/*  41 */     this.fashionDressCfgId = paramInt;
/*     */   }
/*     */   
/*     */   private static class PFashionDressExpired
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int fashionDressCfgId;
/*     */     
/*     */     public PFashionDressExpired(long paramLong, int paramInt)
/*     */     {
/*  52 */       this.roleId = paramLong;
/*  53 */       this.fashionDressCfgId = paramInt;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  59 */       String str = RoleInterface.getUserId(this.roleId);
/*  60 */       lock(Lockeys.get(User.getTable(), str));
/*     */       
/*  62 */       Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(this.roleId));
/*  63 */       if (localRole2FashionDressInfo == null)
/*     */       {
/*  65 */         GameServer.logger().error(String.format("[fashiondress]FashionDressExpiredObserver.PFashionDressExpired.processImp@role fashion dress info is null|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */         
/*  67 */         return false;
/*     */       }
/*  69 */       Map localMap1 = localRole2FashionDressInfo.getFashion_dress_map();
/*  70 */       FashionDressInfo localFashionDressInfo = (FashionDressInfo)localMap1.get(Integer.valueOf(this.fashionDressCfgId));
/*  71 */       if (localFashionDressInfo == null)
/*     */       {
/*  73 */         GameServer.logger().warn(String.format("[fashiondress]FashionDressExpiredObserver.PFashionDressExpired.processImp@not contains the fashion dress,may be aleardy expired|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */         
/*  75 */         return false;
/*     */       }
/*  77 */       SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(this.fashionDressCfgId);
/*  78 */       if (localSFashionDressCfg == null)
/*     */       {
/*  80 */         GameServer.logger().warn(String.format("[fashiondress]FashionDressExpiredObserver.PFashionDressExpired.processImp@fashion dress cfg not exist|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */         
/*  82 */         return false;
/*     */       }
/*  84 */       long l1 = localSFashionDressCfg.effectTime * 3600L + localFashionDressInfo.getExtend_time();
/*     */       
/*  86 */       long l2 = DateTimeUtils.getCurrTimeInMillis() / 1000L - localFashionDressInfo.getStart_time();
/*  87 */       long l3 = l1 - l2;
/*  88 */       if (l3 > 0L)
/*     */       {
/*  90 */         GameServer.logger().info(String.format("[fashiondress]FashionDressExpiredObserver.PFashionDressExpired.processImp@fashion dress may be extend time|role_id=%d|fashion_dress_cfg_id=%d|service_time=%d|elpased_time=%d|left_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) }));
/*     */         
/*  92 */         return false;
/*     */       }
/*  94 */       Role2FashionDressObserverInfo localRole2FashionDressObserverInfo = Role2fashiondressobserver.get(Long.valueOf(this.roleId));
/*     */       Map localMap2;
/*     */       int i;
/*  97 */       if (localRole2FashionDressObserverInfo != null)
/*     */       {
/*  99 */         localMap2 = localRole2FashionDressObserverInfo.getObserver_map();
/* 100 */         localMap2.remove(Integer.valueOf(this.fashionDressCfgId));
/*     */         
/* 102 */         localObject = localRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 103 */         if (!((Map)localObject).isEmpty())
/*     */         {
/* 105 */           i = RoleInterface.getGender(this.roleId);
/* 106 */           for (Map.Entry localEntry : ((Map)localObject).entrySet())
/*     */           {
/* 108 */             int j = ((Integer)localEntry.getKey()).intValue();
/* 109 */             if (j > 100)
/*     */             {
/* 111 */               i = j % 100;
/* 112 */               j /= 100;
/*     */             }
/* 114 */             int k = FashionDressManager.getNewOccupationFashionDress(this.fashionDressCfgId, j, i);
/* 115 */             if (localMap2.containsKey(Integer.valueOf(k))) {
/* 116 */               localMap2.remove(Integer.valueOf(k));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 121 */       localMap1.remove(Integer.valueOf(this.fashionDressCfgId));
/* 122 */       localRole2FashionDressInfo.getActivate_property_set().remove(Integer.valueOf(this.fashionDressCfgId));
/*     */       
/* 124 */       FashionDressManager.checkWearFashionDressExpired(this.roleId, localRole2FashionDressInfo, this.fashionDressCfgId);
/*     */       
/* 126 */       FashionDressManager.sendFashionDressExpiredMail(this.roleId, localSFashionDressCfg);
/*     */       
/* 128 */       FashionDressManager.clearTransferOccupationFashionDress(this.roleId, this.fashionDressCfgId, localRole2FashionDressInfo);
/*     */       
/* 130 */       Object localObject = new SFashionDressExpired();
/* 131 */       ((SFashionDressExpired)localObject).fashiondresscfgid = this.fashionDressCfgId;
/* 132 */       OnlineManager.getInstance().send(this.roleId, (Protocol)localObject);
/*     */       
/* 134 */       FashionDressManager.tlogFashionDressOperator(str, this.roleId, this.fashionDressCfgId, FashionDressTLogEnum.EXPIRED);
/*     */       
/* 136 */       FashionDressManager.onFashionDressExpired(str, this.roleId, localRole2FashionDressInfo, this.fashionDressCfgId);
/*     */       
/* 138 */       GameServer.logger().info(String.format("[fashiondress]FashionDressExpiredObserver.PFashionDressExpired.processImp@handle fashion dress expired success|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/* 140 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\FashionDressExpiredObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */