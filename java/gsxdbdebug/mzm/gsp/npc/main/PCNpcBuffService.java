/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.npc.confbean.SNPCBuffCfg;
/*    */ import mzm.gsp.npc.event.GetNpcBuffArg;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xtable.Role2buff;
/*    */ 
/*    */ public class PCNpcBuffService extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int npcid;
/*    */   private int serviceid;
/*    */   private long roleid;
/*    */   
/*    */   public PCNpcBuffService(long roleid, int npcid, int serviceid)
/*    */   {
/* 21 */     this.npcid = npcid;
/* 22 */     this.serviceid = serviceid;
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!NpcServiceManager.checkNpcService(this.npcid, this.serviceid, this.roleid)) {
/* 30 */       return false;
/*    */     }
/* 32 */     SNPCBuffCfg npcBuffCfg = NpcServiceManager.getServiceBuff(this.serviceid);
/* 33 */     List<Long> roleids = new ArrayList();
/* 34 */     if (npcBuffCfg.isTeamAll) {
/* 35 */       List<Long> normalRole = TeamInterface.getNormalRoleList(this.roleid);
/* 36 */       if ((normalRole.size() > 0) && (normalRole.contains(Long.valueOf(this.roleid)))) {
/* 37 */         roleids.addAll(normalRole);
/*    */       } else {
/* 39 */         roleids.add(Long.valueOf(this.roleid));
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 44 */       roleids.add(Long.valueOf(this.roleid));
/*    */     }
/*    */     
/* 47 */     lock(Role2buff.getTable(), roleids);
/*    */     
/*    */ 
/* 50 */     if (BuffInterface.isContainBuff(this.roleid, npcBuffCfg.buffs)) {
/* 51 */       NpcManager.sendNormalResult(roleids, 1, new String[0]);
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { roleid = ((Long)i$.next()).longValue();
/*    */       
/* 57 */       for (i$ = npcBuffCfg.buffs.iterator(); i$.hasNext();) { int buffid = ((Integer)i$.next()).intValue();
/* 58 */         BuffInterface.installBuff(roleid, buffid);
/*    */       } }
/*    */     long roleid;
/*    */     Iterator i$;
/* 62 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.npc.event.GetNpcBuffEvent(), new GetNpcBuffArg(roleids, this.npcid, npcBuffCfg.buffs));
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\PCNpcBuffService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */