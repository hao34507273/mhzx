/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.marriage.confbean.SMarriageParadeRobConsts;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.MarriageParade;
/*     */ import xbean.MarriageParades;
/*     */ import xbean.RoleLessCold1;
/*     */ import xtable.Marriageparade;
/*     */ import xtable.Role2lesscold1;
/*     */ 
/*     */ public class PParadeAttackGroom extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PParadeAttackGroom(long roleid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     Set<Long> allRoles = new java.util.HashSet();
/*  31 */     List<Long> normalList = TeamInterface.getNormalRoleList(this.roleid);
/*  32 */     if (!normalList.contains(Long.valueOf(this.roleid))) {
/*  33 */       normalList.clear();
/*  34 */       normalList.add(Long.valueOf(this.roleid));
/*     */     }
/*  36 */     if (((Long)normalList.get(0)).longValue() != this.roleid) {
/*  37 */       return false;
/*     */     }
/*  39 */     allRoles.addAll(normalList);
/*     */     
/*  41 */     long localId = mzm.gsp.GameServerInfoManager.getLocalId();
/*  42 */     MarriageParades xSelectMarriageParades = Marriageparade.select(Long.valueOf(localId));
/*  43 */     if ((xSelectMarriageParades == null) || (xSelectMarriageParades.getMarriageparades().size() <= 0)) {
/*  44 */       MarriageManager.sendAttackParadeError(this.roleid, 102, new String[0]);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     MarriageParade xSelectMarriageParade = (MarriageParade)xSelectMarriageParades.getMarriageparades().get(0);
/*  49 */     long roleid1 = xSelectMarriageParade.getRoleid1();
/*  50 */     long roleid2 = xSelectMarriageParade.getRoleid2();
/*  51 */     allRoles.add(Long.valueOf(roleid1));
/*  52 */     allRoles.add(Long.valueOf(roleid2));
/*     */     
/*  54 */     lock(xtable.Role2marriage.getTable(), allRoles);
/*     */     
/*  56 */     MarriageParades xMarriageParades = Marriageparade.get(Long.valueOf(localId));
/*  57 */     MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/*  58 */     if (xMarriageParade.getRoleid1() != roleid1) {
/*  59 */       return false;
/*     */     }
/*  61 */     if (!xMarriageParade.getCanrob()) {
/*  62 */       MarriageManager.sendAttackParadeError(this.roleid, 102, new String[0]);
/*  63 */       return false;
/*     */     }
/*  65 */     if (xMarriageParade.getGroomfightstatus() != 0) {
/*  66 */       MarriageManager.sendAttackParadeError(this.roleid, 22, new String[0]);
/*     */       
/*  68 */       return false;
/*     */     }
/*  70 */     long groomRoleid = roleid1;
/*  71 */     if (RoleInterface.getGender(groomRoleid) == 2) {
/*  72 */       groomRoleid = roleid2;
/*     */     }
/*  74 */     if ((normalList.contains(Long.valueOf(roleid1))) || (normalList.contains(Long.valueOf(roleid2)))) {
/*  75 */       GameServer.logger().info(String.format("[RobMarriage]PAttackGroom.processImp@attcker wrong,canot be themself|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  83 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long normalRoleid = ((Long)i$.next()).longValue();
/*  84 */       if ((!OpenInterface.getOpenStatus(129)) || (OpenInterface.isBanPlay(normalRoleid, 129)))
/*     */       {
/*  86 */         OpenInterface.sendBanPlayMsg(this.roleid, normalRoleid, RoleInterface.getName(normalRoleid), 129);
/*     */         
/*  88 */         return false;
/*     */       }
/*  90 */       RoleLessCold1 xRoleLessCold1 = Role2lesscold1.get(Long.valueOf(normalRoleid));
/*  91 */       if (xRoleLessCold1 != null)
/*     */       {
/*     */ 
/*  94 */         if (!DateTimeUtils.isInSameDay(curTime, xRoleLessCold1.getRobparadetime())) {
/*  95 */           xRoleLessCold1.setRobparadetime(curTime);
/*  96 */           xRoleLessCold1.setRobparadecount(0);
/*     */         }
/*  98 */         if (xRoleLessCold1.getRobparadecount() >= SMarriageParadeRobConsts.getInstance().robParadeMaxPerDay) {
/*  99 */           for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long tempRoleid = ((Long)i$.next()).longValue();
/* 100 */             String name = RoleInterface.getName(normalRoleid);
/* 101 */             if (tempRoleid == normalRoleid) {
/* 102 */               MarriageManager.sendAttackParadeError(tempRoleid, 103, new String[0]);
/*     */             }
/*     */             else {
/* 105 */               MarriageManager.sendAttackParadeError(tempRoleid, 100, new String[] { name });
/*     */             }
/*     */           }
/*     */           
/* 109 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 115 */     mzm.gsp.fight.main.FightInterface.startPVPFight(this.roleid, groomRoleid, new RobMarrageFightContext(false, groomRoleid), 13, FightReason.ROB_MARRIAGE);
/*     */     
/* 117 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PParadeAttackGroom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */