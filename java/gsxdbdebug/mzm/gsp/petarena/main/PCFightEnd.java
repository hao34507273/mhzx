/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.petarena.SFightEndFailed;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCFightEnd extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCFightEnd(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!PetArenaManager.canDoAction(this.roleid, 2119))
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     if (!PetArenaManager.getPetArenaAward(this.roleid))
/*    */     {
/* 36 */       onFailed(-1);
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     GameServer.logger().info(String.format("[petarena]PCFightEnd.processImp@get award success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode)
/*    */   {
/* 46 */     onFailed(retcode, null);
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*    */   {
/* 51 */     SFightEndFailed rsp = new SFightEndFailed();
/* 52 */     rsp.retcode = retcode;
/* 53 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*    */     
/* 55 */     StringBuilder logBuilder = new StringBuilder();
/* 56 */     logBuilder.append("[petarena]PCFightEnd.onFailed@failed");
/* 57 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 58 */     logBuilder.append('|').append("retcode=").append(retcode);
/*    */     
/* 60 */     if (extraParams != null)
/*    */     {
/* 62 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*    */       {
/* 64 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/*    */     
/* 68 */     GameServer.logger().error(logBuilder.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */