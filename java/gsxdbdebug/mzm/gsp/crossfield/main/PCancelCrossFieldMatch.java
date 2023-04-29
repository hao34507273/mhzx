/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.crossfield.SCancelCrossFieldMatchFail;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCancelCrossFieldMatch
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCancelCrossFieldMatch(long roleid)
/*    */   {
/* 24 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1585, true))
/*    */     {
/*    */ 
/* 33 */       onFail(-2, null);
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 39 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 41 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 43 */     int res = CrossFieldManager.cancelMatch(this.roleid);
/* 44 */     if (res != 0)
/*    */     {
/* 46 */       onFail(res, null);
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     CrossFieldManager.logger.info(String.format("[crossfield]PCancelCrossFieldMatch.processImp@cancel cross field match excute|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */     
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 57 */     StringBuilder sb = new StringBuilder();
/* 58 */     sb.append(String.format("[crossfield]PCancelCrossFieldMatch.processImp@cancel cross field match fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*    */     
/* 60 */     if (extraInfo != null)
/*    */     {
/* 62 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 64 */         sb.append("|").append((String)entry.getKey());
/* 65 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 68 */     CrossFieldManager.logger.info(sb.toString());
/* 69 */     if (res > 0)
/*    */     {
/* 71 */       SCancelCrossFieldMatchFail protocol = new SCancelCrossFieldMatchFail();
/* 72 */       protocol.res = res;
/* 73 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\PCancelCrossFieldMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */