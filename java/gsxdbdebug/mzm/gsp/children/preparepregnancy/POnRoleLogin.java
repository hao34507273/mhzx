/*    */ package mzm.gsp.children.preparepregnancy;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.bubblegame.event.BubbleGameContext;
/*    */ import mzm.gsp.bubblegame.main.BubbleGameInterface;
/*    */ import mzm.gsp.children.confbean.PreparePregnancyConsts;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 24 */     long partnerid = MarriageInterface.getMarriedRoleid(roleid, false);
/* 25 */     if (partnerid < 0L)
/*    */     {
/* 27 */       StringBuilder sb = new StringBuilder();
/* 28 */       sb.append(String.format("[prepare_pregnancy]POnRoleLogin.processImp@role not married|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 29 */       PreparePregnancyManager.logger.info(sb.toString());
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     String userid = RoleInterface.getUserId(roleid);
/* 34 */     String partnerUserid = RoleInterface.getUserId(partnerid);
/*    */     
/* 36 */     lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*    */     
/* 38 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(partnerid) }));
/*    */     
/* 40 */     BubbleGameContext context = BubbleGameInterface.getRoleLastBubbleGameContext(roleid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID);
/*    */     
/*    */ 
/* 43 */     PreparePregnancyBubbleGameContext preparePregnancyBubbleGameContext = null;
/* 44 */     if ((context != null) && ((context instanceof PreparePregnancyBubbleGameContext)))
/*    */     {
/* 46 */       preparePregnancyBubbleGameContext = (PreparePregnancyBubbleGameContext)context;
/*    */     }
/* 48 */     if ((preparePregnancyBubbleGameContext == null) || (preparePregnancyBubbleGameContext.partnerid != partnerid) || (preparePregnancyBubbleGameContext.marriageid != MarriageInterface.getMarriedId(roleid, false)))
/*    */     {
/*    */ 
/*    */ 
/* 52 */       StringBuilder sb = new StringBuilder();
/* 53 */       sb.append(String.format("[prepare_pregnancy]POnRoleLogin.processImp@context not match|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 54 */       PreparePregnancyManager.logger.info(sb.toString());
/* 55 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 59 */     int currentPoint = ChildrenInterface.isCanCouplePreparePregnant(roleid, partnerid, true);
/* 60 */     if (currentPoint < 0)
/*    */     {
/*    */ 
/* 63 */       StringBuilder sb = new StringBuilder();
/* 64 */       sb.append(String.format("[prepare_pregnancy]POnRoleLogin.processImp@breed state error|roleid=%d|current_point=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(currentPoint) }));
/*    */       
/* 66 */       PreparePregnancyManager.logger.info(sb.toString());
/* 67 */       return false;
/*    */     }
/* 69 */     if (currentPoint >= BubbleGameInterface.getBubbleGamePointUpperLimit(PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID))
/*    */     {
/*    */ 
/* 72 */       StringBuilder sb = new StringBuilder();
/* 73 */       sb.append(String.format("[prepare_pregnancy]POnRoleLogin.processImp@point to upper limit|roleid=%d|current_point=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(currentPoint) }));
/*    */       
/*    */ 
/* 76 */       PreparePregnancyManager.logger.info(sb.toString());
/* 77 */       return false;
/*    */     }
/* 79 */     BubbleGameInterface.resumeBubbleGame(roleid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID, currentPoint);
/* 80 */     StringBuilder sb = new StringBuilder();
/* 81 */     sb.append(String.format("[prepare_pregnancy]POnRoleLogin.processImp@login check success|roleid=%d|current_point=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(currentPoint) }));
/*    */     
/* 83 */     PreparePregnancyManager.logger.info(sb.toString());
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */