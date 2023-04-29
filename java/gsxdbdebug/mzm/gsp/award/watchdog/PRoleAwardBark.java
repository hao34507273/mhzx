/*    */ package mzm.gsp.award.watchdog;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRoleAwardBark
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final AwardBarkEventArg arg;
/*    */   private long roleId;
/*    */   
/*    */   public PRoleAwardBark(AwardBarkEventArg arg)
/*    */   {
/* 23 */     this.arg = arg;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (this.arg == null)
/*    */     {
/* 31 */       GameServer.logger().error(String.format("[awardBark]PRoleAwardBark.processImp@ arg is null!", new Object[0]));
/* 32 */       return false;
/*    */     }
/* 34 */     GameServer.logger().info(String.format("[awardBark]PRoleAwardBark.processImp@ do awardBark!|arg=%s", new Object[] { this.arg.toString() }));
/*    */     
/*    */ 
/* 37 */     this.roleId = this.arg.getRoleId();
/*    */     
/* 39 */     String userId = RoleInterface.getUserId(this.roleId);
/* 40 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 42 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 44 */     awardBark(this.arg);
/*    */     
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean awardBark(AwardBarkEventArg arg)
/*    */   {
/* 52 */     AwardBarkPro pro = getBarkPro(arg.getType());
/* 53 */     if (pro == null)
/*    */     {
/* 55 */       GameServer.logger().error(String.format("[awardBark]PRoleAwardBark.awardBark@ AwardBarkPro is null!|arg=%s", new Object[] { arg.toString() }));
/*    */       
/* 57 */       return false;
/*    */     }
/* 59 */     pro.doActionWhenBark(arg);
/* 60 */     return true;
/*    */   }
/*    */   
/*    */   private AwardBarkPro getBarkPro(AwardWatchType type)
/*    */   {
/* 65 */     AwardBarkPro pro = null;
/* 66 */     switch (type)
/*    */     {
/*    */     case ROLE_EXP: 
/* 69 */       pro = new RoleExpBarkHandler();
/* 70 */       break;
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 75 */     return pro;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\watchdog\PRoleAwardBark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */