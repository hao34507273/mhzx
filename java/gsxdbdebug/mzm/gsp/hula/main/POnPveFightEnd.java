/*     */ package mzm.gsp.hula.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.main.FightContext;
/*     */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HulaInfo;
/*     */ import xbean.HulaMonsterInfo;
/*     */ import xbean.HulaWorldInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Hulaworld;
/*     */ 
/*     */ public class POnPveFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     FightContext fightContext = ((PVEFightEndArg)this.arg).context;
/*  25 */     if (!(fightContext instanceof HulaFightContext))
/*     */     {
/*  27 */       return false;
/*     */     }
/*  29 */     if (((PVEFightEndArg)this.arg).roleList.isEmpty())
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     int stage = mzm.gsp.activity.main.ActivityInterface.getActivityStage(SHulaCfgConsts.getInstance().ACTIVITY_ID);
/*  35 */     boolean isDoudoucomeOutPhase = true;
/*  36 */     if (!HulaManager.isThisStage(stage, 1))
/*     */     {
/*  38 */       String log = String.format("[hula]POnPveFightEnd.processImp@not doudou comeout stage|stage=%d|roleid=%s", new Object[] { Integer.valueOf(stage), ((PVEFightEndArg)this.arg).roleList });
/*     */       
/*  40 */       HulaManager.logger.info(log);
/*  41 */       isDoudoucomeOutPhase = false;
/*     */     }
/*     */     
/*  44 */     HulaFightContext hulaFightContext = (HulaFightContext)fightContext;
/*  45 */     long roleId = hulaFightContext.getRoleid();
/*  46 */     long worldid = hulaFightContext.getWorldid();
/*  47 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(worldid);
/*  48 */     Set<Long> roles = Hulaworld.selectRoleids(Long.valueOf(key));
/*  49 */     if ((roles == null) || (roles.isEmpty()))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     Map<Long, String> roleid2userids = new HashMap();
/*  55 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  57 */       roleid2userids.put(Long.valueOf(roleid), RoleInterface.getUserId(roleid));
/*     */     }
/*  59 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  61 */       if (!roles.contains(Long.valueOf(roleid)))
/*     */       {
/*     */ 
/*     */ 
/*  65 */         roleid2userids.put(Long.valueOf(roleid), RoleInterface.getUserId(roleid)); }
/*     */     }
/*  67 */     Lockeys.lock(xtable.User.getTable(), roleid2userids.values());
/*  68 */     Lockeys.lock(xtable.Role2properties.getTable(), roleid2userids.keySet());
/*  69 */     HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/*  70 */     if (xHulaWorldInfo == null)
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     int k = -1;
/*  76 */     for (int i = 0; i < xHulaWorldInfo.getMonsters().size(); i++)
/*     */     {
/*  78 */       HulaMonsterInfo xHulaMonsterInfo = (HulaMonsterInfo)xHulaWorldInfo.getMonsters().get(i);
/*  79 */       if (xHulaMonsterInfo.getSeq() == hulaFightContext.getSeq())
/*     */       {
/*  81 */         k = i;
/*  82 */         break;
/*     */       }
/*     */     }
/*     */     
/*  86 */     if (!roles.contains(Long.valueOf(roleId)))
/*     */     {
/*     */ 
/*  89 */       String log = String.format("[hula]POnPveFightEnd.processImp@the roleid already leaved team with stage|stage=%d|roleid=%s", new Object[] { Integer.valueOf(stage), Long.valueOf(roleId) });
/*     */       
/*     */ 
/*  92 */       HulaManager.logger.info(log);
/*  93 */       if (k != -1)
/*     */       {
/*  95 */         HulaMonsterInfo xHulaMonsterInfo = (HulaMonsterInfo)xHulaWorldInfo.getMonsters().get(k);
/*  96 */         if (xHulaMonsterInfo != null)
/*     */         {
/*  98 */           xHulaMonsterInfo.setState(1);
/*  99 */           HulaManager.synSSynMonsterStateRes(hulaFightContext.getSeq(), 1, MapInterface.getRoleList(hulaFightContext.getWorldid()));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 104 */       new PLeaveHulaWorld(roleId).execute();
/*     */       
/* 106 */       return true;
/*     */     }
/*     */     
/* 109 */     Map<Long, HulaInfo> role2XHulaInfo = HulaManager.getXRoleid2HulaInfo(roles);
/* 110 */     int killresult = 0;
/* 111 */     if ((k != -1) && (((PVEFightEndArg)this.arg).isPlayerWin) && (isDoudoucomeOutPhase))
/*     */     {
/* 113 */       HulaMonsterInfo xHulaMonsterInfo = (HulaMonsterInfo)xHulaWorldInfo.getMonsters().get(k);
/* 114 */       if (xHulaMonsterInfo != null)
/*     */       {
/*     */ 
/* 117 */         HulaManager.addPoint(role2XHulaInfo, SHulaCfgConsts.getInstance().KILL_POINT, xHulaMonsterInfo.getMonsterid(), null, null, false);
/*     */         
/*     */ 
/* 120 */         xHulaMonsterInfo.setState(2);
/* 121 */         killresult = 1;
/* 122 */         HulaManager.synSSynMonsterStateRes(hulaFightContext.getSeq(), 2, MapInterface.getRoleList(hulaFightContext.getWorldid()));
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 128 */     else if (k != -1)
/*     */     {
/* 130 */       HulaMonsterInfo xHulaMonsterInfo = (HulaMonsterInfo)xHulaWorldInfo.getMonsters().get(k);
/* 131 */       if (xHulaMonsterInfo != null)
/*     */       {
/* 133 */         xHulaMonsterInfo.setState(1);
/* 134 */         HulaManager.synSSynMonsterStateRes(hulaFightContext.getSeq(), 1, MapInterface.getRoleList(hulaFightContext.getWorldid()));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 141 */     HulaFightManager.getInstance().removeFightId(((PVEFightEndArg)this.arg).fightid);
/* 142 */     if (roles.contains(Long.valueOf(roleId)))
/*     */     {
/* 144 */       HulaInfo xHulaInfo = (HulaInfo)role2XHulaInfo.get(Long.valueOf(roleId));
/* 145 */       if (xHulaInfo != null)
/*     */       {
/* 147 */         int point = ((HulaInfo)role2XHulaInfo.get(Long.valueOf(roleId))).getPoint();
/* 148 */         HulaManager.tlogHulafight(roleId, HulaManager.getTurn(stage), xHulaWorldInfo, point, hulaFightContext.getModelId(), hulaFightContext.getSeq(), killresult);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 153 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\POnPveFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */