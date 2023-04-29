/*    */ package mzm.gsp.task.enterFight;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.SSynMemberJoinFightState;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.TaskConfBean;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2taskconf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InviteJoinFightSession
/*    */   extends Session
/*    */ {
/*    */   private final long leaderId;
/*    */   
/*    */   public InviteJoinFightSession(long interval, long roleId)
/*    */   {
/* 26 */     super(interval, roleId);
/* 27 */     this.leaderId = roleId;
/*    */   }
/*    */   
/*    */   public long getLeaderId()
/*    */   {
/* 32 */     return this.leaderId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 38 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/*    */ 
/* 45 */         TaskConfBean xTaskConfBean = Role2taskconf.select(Long.valueOf(InviteJoinFightSession.this.leaderId));
/* 46 */         if (xTaskConfBean == null)
/*    */         {
/* 48 */           return false;
/*    */         }
/* 50 */         List<Long> sayNoMembers = xTaskConfBean.getAllroles();
/* 51 */         sayNoMembers.removeAll(xTaskConfBean.getAcceptroles());
/* 52 */         List<Long> allTeamMember = new ArrayList(xTaskConfBean.getAllroles());
/* 53 */         allTeamMember.add(Long.valueOf(InviteJoinFightSession.this.leaderId));
/* 54 */         Iterator i$; if (sayNoMembers.size() != 0)
/*    */         {
/* 56 */           for (i$ = sayNoMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */             
/* 58 */             String name = RoleInterface.getName(roleId);
/* 59 */             SSynMemberJoinFightState pro = new SSynMemberJoinFightState();
/* 60 */             pro.represult = 0;
/* 61 */             pro.rolename = name;
/* 62 */             pro.roleid = roleId;
/* 63 */             OnlineManager.getInstance().sendMulti(pro, allTeamMember);
/*    */           }
/*    */         }
/* 66 */         Role2taskconf.remove(Long.valueOf(InviteJoinFightSession.this.leaderId));
/* 67 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\enterFight\InviteJoinFightSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */