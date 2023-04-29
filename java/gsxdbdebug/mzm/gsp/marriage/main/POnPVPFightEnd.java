/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.marriage.SBrocastRobMarriageParadeFail;
/*     */ import mzm.gsp.marriage.SBrocastRobMarriageParadeWin;
/*     */ import mzm.gsp.marriage.confbean.SMarriageParadeRobConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MarriageParade;
/*     */ import xbean.MarriageParades;
/*     */ import xdb.Procedure;
/*     */ import xtable.Marriageparade;
/*     */ 
/*     */ public class POnPVPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  25 */     if ((((PVPFightEndArg)this.arg).context instanceof RobMarrageFightContext)) {
/*  26 */       RobMarrageFightContext context = (RobMarrageFightContext)((PVPFightEndArg)this.arg).context;
/*  27 */       Set<Long> allRoles = ((PVPFightEndArg)this.arg).getAllRoles();
/*  28 */       Map<Long, String> roleidToUseid = new HashMap();
/*  29 */       List<Long> awardRoles = ((PVPFightEndArg)this.arg).getActiveNotEscapeList();
/*  30 */       List<String> awardUsers = new ArrayList();
/*  31 */       for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  32 */         String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*  33 */         roleidToUseid.put(Long.valueOf(roleid), userid);
/*     */       }
/*  35 */       for (Iterator i$ = awardRoles.iterator(); i$.hasNext();) { long awardRoleid = ((Long)i$.next()).longValue();
/*  36 */         awardUsers.add(roleidToUseid.get(Long.valueOf(awardRoleid)));
/*     */       }
/*     */       
/*  39 */       lock(xtable.User.getTable(), roleidToUseid.values());
/*     */       
/*  41 */       lock(xtable.Role2marriage.getTable(), ((PVPFightEndArg)this.arg).getAllRoles());
/*     */       
/*     */ 
/*  44 */       int awardid = SMarriageParadeRobConsts.getInstance().robSucAwardid;
/*  45 */       if (!((PVPFightEndArg)this.arg).isActiveWin) {
/*  46 */         awardid = SMarriageParadeRobConsts.getInstance().robFailAwardid;
/*     */       }
/*     */       
/*  49 */       for (Iterator i$ = awardRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  50 */         mzm.gsp.award.main.AwardInterface.awardFixAward(awardid, (String)roleidToUseid.get(Long.valueOf(roleid)), roleid, false, true, new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.MARRIAGE_PARADE_ROB_AWARD));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  59 */       MarriageParades xMarriageParades = Marriageparade.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*  60 */       MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/*  61 */       long roleid = context.roleid;
/*  62 */       long roleid1 = xMarriageParade.getRoleid1();
/*  63 */       final long roleid2 = xMarriageParade.getRoleid2();
/*     */       
/*  65 */       if ((roleid1 != roleid) && (roleid2 != roleid)) {
/*  66 */         GameServer.logger().info(String.format("POnPVPFightStart.processImp@pvp战斗玩家id错误!!|roleid=%d|roleid1=%d|roleid2=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(roleid1), Long.valueOf(roleid2) }));
/*     */         
/*     */ 
/*  69 */         return true;
/*     */       }
/*  71 */       if (context.brideFight) {
/*  72 */         int totalState = MarriageManager.setFightStatus(2, xMarriageParade.getBridefightstatus());
/*     */         
/*  74 */         xMarriageParade.setBridefightstatus(totalState);
/*     */       } else {
/*  76 */         int totalState = MarriageManager.setFightStatus(2, xMarriageParade.getGroomfightstatus());
/*     */         
/*  78 */         xMarriageParade.setGroomfightstatus(totalState);
/*     */       }
/*     */       
/*  81 */       MarriageManager.paradeCheckAndMoveOn(xMarriageParades, xMarriageParade);
/*     */       
/*     */ 
/*     */ 
/*  85 */       final long robLeader = ((Long)((PVPFightEndArg)this.arg).activeRoleList.get(0)).longValue();
/*  86 */       if (((PVPFightEndArg)this.arg).isActiveWin) {
/*  87 */         Procedure.execute(new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp() throws Exception
/*     */           {
/*  91 */             SBrocastRobMarriageParadeWin sBrocastRobMarriageParadeWin = new SBrocastRobMarriageParadeWin();
/*  92 */             MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParadeWin.winattacker, robLeader);
/*  93 */             MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParadeWin.role1info, roleid2);
/*  94 */             MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParadeWin.role2info, this.val$roleid2);
/*  95 */             OnlineManager.getInstance().sendAll(sBrocastRobMarriageParadeWin);
/*  96 */             return true;
/*     */           }
/*     */           
/*     */         });
/*     */       } else {
/* 101 */         Procedure.execute(new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp() throws Exception
/*     */           {
/* 105 */             SBrocastRobMarriageParadeFail sBrocastRobMarriageParadeFail = new SBrocastRobMarriageParadeFail();
/* 106 */             MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParadeFail.failattacker, robLeader);
/* 107 */             MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParadeFail.role1info, roleid2);
/* 108 */             MarriageManager.fillInParadeRoleInfo(sBrocastRobMarriageParadeFail.role2info, this.val$roleid2);
/* 109 */             OnlineManager.getInstance().sendAll(sBrocastRobMarriageParadeFail);
/* 110 */             return true;
/*     */           }
/*     */         });
/*     */       }
/*     */     }
/*     */     
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */