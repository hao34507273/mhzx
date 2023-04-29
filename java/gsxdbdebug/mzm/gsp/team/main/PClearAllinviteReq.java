/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ public class PClearAllinviteReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final List<Long> inviters;
/*    */   
/*    */   public PClearAllinviteReq(long roleId, List<Long> inviters)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.inviters = inviters;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     for (Iterator i$ = this.inviters.iterator(); i$.hasNext();) { final long inviter = ((Long)i$.next()).longValue();
/*    */       
/* 26 */       xdb.Procedure.execute(new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 31 */           Long teamid = Role2team.select(Long.valueOf(inviter));
/* 32 */           if (teamid == null)
/*    */           {
/* 34 */             return false;
/*    */           }
/* 36 */           lock(Basic.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(PClearAllinviteReq.this.roleId), Long.valueOf(inviter) }));
/* 37 */           xbean.Team xTeam = xtable.Team.get(teamid);
/*    */           
/* 39 */           TeamManager.refuseInvite(PClearAllinviteReq.this.roleId, inviter, xTeam);
/* 40 */           return true;
/*    */         }
/*    */       });
/*    */     }
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PClearAllinviteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */