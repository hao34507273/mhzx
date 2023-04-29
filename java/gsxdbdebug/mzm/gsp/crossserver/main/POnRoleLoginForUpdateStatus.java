/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.crossbattle.SyncPointRaceCorpsid;
/*     */ import mzm.gsp.crossbattle.point.PointRaceManager;
/*     */ import mzm.gsp.crossbattle.point.PointRaceZoneManager;
/*     */ import mzm.gsp.crosscompete.roam.RoamEnterContext;
/*     */ import mzm.gsp.crosscompete.roam.RoamEnterContextManager;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLoginForUpdateStatus extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     if (!GameServerInfoManager.isRoamServer())
/*     */     {
/*  26 */       return false;
/*     */     }
/*     */     
/*  29 */     long roleid = ((Long)this.arg).longValue();
/*  30 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/*  32 */     if (userid == null)
/*     */     {
/*  34 */       kickout(roleid);
/*  35 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  39 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  41 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*     */     
/*  43 */     Long roamedRoomInstanceid = CrossServerManager.getRoamedRoomInstanceid(userid);
/*  44 */     if (roamedRoomInstanceid == null)
/*     */     {
/*  46 */       return true;
/*     */     }
/*     */     
/*  49 */     RoamType roamType = CrossServerManager.getRoamType(userid);
/*  50 */     if (roamType == null)
/*     */     {
/*  52 */       return true;
/*     */     }
/*     */     
/*  55 */     switch (roamType)
/*     */     {
/*     */     case LADDER: 
/*  58 */       RoamedMatchContext roamedMatchContext = RoamedMatchContextManager.getInstance().getRoamedMathContext(roamedRoomInstanceid.longValue());
/*     */       
/*  60 */       if (roamedMatchContext == null)
/*     */       {
/*  62 */         kickout(roleid);
/*  63 */         return true;
/*     */       }
/*     */       
/*  66 */       roamedMatchContext.setLogined(roleid);
/*  67 */       break;
/*     */     case CROSS_COMPETE: 
/*  69 */       RoamEnterContext competeContext = RoamEnterContextManager.getInstance().getContext(roamedRoomInstanceid.longValue());
/*  70 */       if (competeContext == null)
/*     */       {
/*  72 */         kickout(roleid);
/*  73 */         return true;
/*     */       }
/*     */       
/*  76 */       if (!competeContext.setLogin(roleid))
/*     */       {
/*  78 */         kickout(roleid);
/*  79 */         return true;
/*     */       }
/*     */       break;
/*     */     case CROSS_BATTLE_POINT: 
/*  83 */       PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(roamedRoomInstanceid.longValue());
/*  84 */       if (zoneManager == null)
/*     */       {
/*  86 */         kickout(roleid);
/*  87 */         return true;
/*     */       }
/*  89 */       RoamedPointRaceContext roamedPointRaceContext = zoneManager.getRoamedContextByRoleid(roleid);
/*  90 */       if (roamedPointRaceContext == null)
/*     */       {
/*  92 */         Long corpsid = zoneManager.getCorpsManager().getCorpsid(roleid);
/*  93 */         if (corpsid == null)
/*     */         {
/*  95 */           kickout(roleid);
/*  96 */           return true;
/*     */         }
/*     */         
/*     */ 
/* 100 */         SyncPointRaceCorpsid msg = new SyncPointRaceCorpsid();
/* 101 */         msg.corps_id = corpsid.longValue();
/* 102 */         OnlineManager.getInstance().send(roleid, msg);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 107 */         roamedPointRaceContext.setLogined(roleid);
/* 108 */         SyncPointRaceCorpsid msg = new SyncPointRaceCorpsid();
/* 109 */         msg.corps_id = roamedPointRaceContext.corpsid;
/* 110 */         OnlineManager.getInstance().send(roleid, msg);
/*     */       }
/* 112 */       break;
/*     */     case CROSS_BATTLE_SELECTION_FINAL: 
/* 114 */       RoamedKnockOutContext roamedSelectionFinalContext = RoamedKnockOutContextManager.getInstance().getRoamedMathContext(roamedRoomInstanceid.longValue());
/*     */       
/* 116 */       if (roamedSelectionFinalContext == null)
/*     */       {
/* 118 */         kickout(roleid);
/* 119 */         return true;
/*     */       }
/*     */       
/* 122 */       roamedSelectionFinalContext.setLogined(roleid);
/* 123 */       break;
/*     */     case SINGLE_CROSS_FIELD: 
/* 125 */       SingleCrossFieldRoamedContext singleCrossFieldRoamedContext = SingleCrossFieldRoamedContextManager.getInstance().getContext(roamedRoomInstanceid.longValue());
/*     */       
/* 127 */       if (singleCrossFieldRoamedContext == null)
/*     */       {
/* 129 */         kickout(roleid);
/* 130 */         return true;
/*     */       }
/* 132 */       singleCrossFieldRoamedContext.setLogined(roleid);
/* 133 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 138 */     BuffInterface.uninstallBuffs(roleid);
/*     */     
/* 140 */     boolean roleOutFightObjRemoved = RoleInterface.removeRoleOutFightObj(roleid);
/* 141 */     boolean childrenOutFightObjRemoved = ChildrenInterface.removeRoleCacheChildOutfightObj(roleid);
/* 142 */     boolean partnerOutFightObjsRemoved = mzm.gsp.partner.main.PartnerInterface.removeRoleCachePartnerOutfightObjs(roleid);
/* 143 */     boolean petOutFightObjsRemoved = mzm.gsp.pet.main.PetInterface.removeRoleCachePetOutfightObjs(roleid);
/*     */     
/*     */ 
/* 146 */     GameServer.logger().info(String.format("[crossserver]POnRoleLoginForUpdateStatus.processImp@remove role out fight obj done|userid=%s|roleid=%d|role_out_fight_obj_removed=%b|children_out_fight_obj_removed=%b|partner_out_fight_objs_removed=%b|pet_out_fight_objs_removed=%b", new Object[] { userid, Long.valueOf(roleid), Boolean.valueOf(roleOutFightObjRemoved), Boolean.valueOf(childrenOutFightObjRemoved), Boolean.valueOf(partnerOutFightObjsRemoved), Boolean.valueOf(petOutFightObjsRemoved) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 152 */     return true;
/*     */   }
/*     */   
/*     */   private void kickout(long roleid)
/*     */   {
/* 157 */     Onlines.getInstance().kick(Long.valueOf(roleid), 2057);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnRoleLoginForUpdateStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */