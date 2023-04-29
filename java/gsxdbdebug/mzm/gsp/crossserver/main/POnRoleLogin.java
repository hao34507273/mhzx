/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.point.PointRaceManager;
/*     */ import mzm.gsp.crossbattle.point.PointRaceZoneManager;
/*     */ import mzm.gsp.crosscompete.roam.RoamEnterContext;
/*     */ import mzm.gsp.crosscompete.roam.RoamEnterContextManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ public class POnRoleLogin extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*  15 */   private RoamType roamType = null;
/*  16 */   private RoamedMatchContext roamedMatchContext = null;
/*  17 */   private RoamEnterContext crossCompeteContext = null;
/*  18 */   private RoamedPointRaceContext roamedPointRaceContext = null;
/*  19 */   private RoamedKnockOutContext roamedSelectionFinalContext = null;
/*  20 */   private SingleCrossFieldRoamedContext singleCrossFieldRoamedContext = null;
/*     */   
/*     */   public POnRoleLogin(long roleid)
/*     */   {
/*  24 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   RoamType getRoamType()
/*     */   {
/*  29 */     return this.roamType;
/*     */   }
/*     */   
/*     */   RoamedMatchContext getRoamedMatchContext()
/*     */   {
/*  34 */     return this.roamedMatchContext;
/*     */   }
/*     */   
/*     */   RoamEnterContext getCrossCompeteContext()
/*     */   {
/*  39 */     return this.crossCompeteContext;
/*     */   }
/*     */   
/*     */   RoamedPointRaceContext getRoamedPointRaceContext()
/*     */   {
/*  44 */     return this.roamedPointRaceContext;
/*     */   }
/*     */   
/*     */   RoamedKnockOutContext getRoamedSelectionFinalContext()
/*     */   {
/*  49 */     return this.roamedSelectionFinalContext;
/*     */   }
/*     */   
/*     */   SingleCrossFieldRoamedContext getSingleCrossFieldRoamedContext()
/*     */   {
/*  54 */     return this.singleCrossFieldRoamedContext;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  60 */     if (!GameServerInfoManager.isRoamServer())
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     String userid = RoleInterface.getUserId(this.roleid);
/*  66 */     if (userid == null)
/*     */     {
/*  68 */       kickout(this.roleid);
/*  69 */       return true;
/*     */     }
/*     */     
/*  72 */     Long roamedRoomInstanceid = CrossServerManager.getRoamedRoomInstanceid(userid);
/*  73 */     if (roamedRoomInstanceid == null)
/*     */     {
/*  75 */       return true;
/*     */     }
/*     */     
/*  78 */     RoamType roamType = CrossServerManager.getRoamType(userid);
/*  79 */     if (roamType == null)
/*     */     {
/*  81 */       return true;
/*     */     }
/*     */     
/*  84 */     this.roamType = roamType;
/*     */     
/*  86 */     switch (roamType)
/*     */     {
/*     */     case LADDER: 
/*  89 */       this.roamedMatchContext = RoamedMatchContextManager.getInstance().getRoamedMathContext(roamedRoomInstanceid.longValue());
/*  90 */       if (this.roamedMatchContext == null)
/*     */       {
/*  92 */         kickout(this.roleid);
/*  93 */         return true;
/*     */       }
/*     */       break;
/*     */     case CROSS_COMPETE: 
/*  97 */       this.crossCompeteContext = RoamEnterContextManager.getInstance().getContext(roamedRoomInstanceid.longValue());
/*  98 */       if (this.crossCompeteContext == null) {
/*  99 */         kickout(this.roleid);
/* 100 */         return true;
/*     */       }
/*     */       
/*     */       break;
/*     */     case CROSS_BATTLE_POINT: 
/* 105 */       PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(roamedRoomInstanceid.longValue());
/* 106 */       if (zoneManager == null)
/*     */       {
/* 108 */         kickout(this.roleid);
/* 109 */         return true;
/*     */       }
/* 111 */       this.roamedPointRaceContext = zoneManager.getRoamedContextByRoleid(this.roleid);
/* 112 */       if (this.roamedPointRaceContext == null)
/*     */       {
/* 114 */         if (!zoneManager.isReLogin(this.roleid))
/*     */         {
/* 116 */           kickout(this.roleid);
/* 117 */           return true;
/*     */         }
/*     */       }
/*     */       
/* 121 */       break;
/*     */     case CROSS_BATTLE_SELECTION_FINAL: 
/* 123 */       this.roamedSelectionFinalContext = RoamedKnockOutContextManager.getInstance().getRoamedMathContext(roamedRoomInstanceid.longValue());
/*     */       
/* 125 */       if (this.roamedSelectionFinalContext == null)
/*     */       {
/* 127 */         kickout(this.roleid);
/* 128 */         return true;
/*     */       }
/*     */       break;
/*     */     case SINGLE_CROSS_FIELD: 
/* 132 */       this.singleCrossFieldRoamedContext = SingleCrossFieldRoamedContextManager.getInstance().getContext(roamedRoomInstanceid.longValue());
/*     */       
/* 134 */       if (this.singleCrossFieldRoamedContext == null)
/*     */       {
/* 136 */         kickout(this.roleid);
/* 137 */         return true;
/*     */       }
/*     */       
/*     */       break;
/*     */     }
/*     */     
/*     */     
/* 144 */     return true;
/*     */   }
/*     */   
/*     */   private void kickout(long roleid)
/*     */   {
/* 149 */     Onlines.getInstance().kick(Long.valueOf(roleid), 2057);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */