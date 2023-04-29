/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerOfflineRunnable;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class ROnRoleLogoff
/*    */   extends PlayerOfflineRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 20 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 26 */     new PTryCancelMatch(roleid).call();
/*    */     
/* 28 */     new PRefreshRank(roleid).call();
/*    */   }
/*    */   
/*    */   class PTryCancelMatch extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     
/*    */     PTryCancelMatch(long roleid)
/*    */     {
/* 37 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 43 */       String userid = RoleInterface.getUserId(this.roleid);
/*    */       
/* 45 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */       
/* 47 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */       
/* 49 */       int res = CrossFieldManager.cancelMatch(this.roleid);
/* 50 */       if (res != 0)
/*    */       {
/* 52 */         onFail(res, null);
/* 53 */         return false;
/*    */       }
/*    */       
/* 56 */       CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogoff.PTryCancelMatch.processImp@cancel cross field match excute|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 59 */       return true;
/*    */     }
/*    */     
/*    */     private void onFail(int res, Map<String, Object> extraInfo)
/*    */     {
/* 64 */       StringBuilder sb = new StringBuilder();
/* 65 */       sb.append(String.format("[crossfield]ROnRoleLogoff.PTryCancelMatch.processImp@cancel cross field match fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*    */       
/*    */ 
/* 68 */       if (extraInfo != null)
/*    */       {
/* 70 */         for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */         {
/* 72 */           sb.append("|").append((String)entry.getKey());
/* 73 */           sb.append("=").append(entry.getValue().toString());
/*    */         }
/*    */       }
/* 76 */       CrossFieldManager.logger.info(sb.toString());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\ROnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */