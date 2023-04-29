/*    */ package mzm.gsp.foolsday.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.foolsday.SGetChestMakerNameFail;
/*    */ import mzm.gsp.foolsday.SGetChestMakerNameSuccess;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class PCGetChestMakerName
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long makerid;
/*    */   
/*    */   public PCGetChestMakerName(long roleid, long makerid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.makerid = makerid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (this.makerid < 0L)
/*    */     {
/*    */ 
/* 32 */       onFail(-3, null);
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     String makerName = RoleInterface.getName(this.makerid);
/* 37 */     if ((makerName == null) || (makerName.isEmpty()))
/*    */     {
/*    */ 
/* 40 */       onFail(1, null);
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     SGetChestMakerNameSuccess protocol = new SGetChestMakerNameSuccess();
/* 45 */     protocol.name.setString(makerName, "UTF-8");
/* 46 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     
/* 48 */     StringBuilder sb = new StringBuilder();
/* 49 */     sb.append(String.format("[foolsday]PCGetChestMakerName.processImp@get chest maker name success|roleid=%d|makerid=%d|maker_name=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.makerid), makerName }));
/*    */     
/*    */ 
/* 52 */     FoolsDayManager.logger.info(sb.toString());
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 58 */     StringBuilder sb = new StringBuilder();
/* 59 */     sb.append(String.format("[foolsday]PCGetChestMakerName.processImp@get chest maker name fail|roleid=%d|makerid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.makerid), Integer.valueOf(res) }));
/*    */     
/*    */ 
/* 62 */     if (extraInfo != null)
/*    */     {
/* 64 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 66 */         sb.append("|").append((String)entry.getKey());
/* 67 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 70 */     FoolsDayManager.logger.info(sb.toString());
/* 71 */     if (res > 0)
/*    */     {
/* 73 */       SGetChestMakerNameFail protocol = new SGetChestMakerNameFail();
/* 74 */       protocol.res = res;
/* 75 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\PCGetChestMakerName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */