/*    */ package mzm.gsp.shanggong.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.shanggong.SStartShangGong;
/*    */ import mzm.gsp.shanggong.confbean.SShangGongCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PStartShangGong
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int shanggongid;
/*    */   
/*    */   public PStartShangGong(long roleid, int shanggongid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.shanggongid = shanggongid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     SShangGongCfg cfg = SShangGongCfg.get(this.shanggongid);
/* 30 */     if (cfg == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!ShangGongManager.isShangGongSwitchOpenForRole(this.roleid, this.shanggongid))
/*    */     {
/*    */ 
/* 38 */       onFail(-1, null);
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     SStartShangGong protocol = new SStartShangGong();
/* 43 */     protocol.shanggong_id = this.shanggongid;
/* 44 */     protocol.sessionid = new ShangGongVaildSession(ShangGongManager.SHANG_GONG_VAILD_INTERVAL, this.roleid, this.shanggongid).getSessionId();
/*    */     
/* 46 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     
/* 48 */     StringBuilder sb = new StringBuilder();
/* 49 */     sb.append(String.format("[shanggong]PStartShangGong.processImp@start shang gong success|roleid=%d|shanggongid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shanggongid) }));
/*    */     
/* 51 */     ShangGongManager.logger.info(sb.toString());
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 57 */     StringBuilder sb = new StringBuilder();
/* 58 */     sb.append(String.format("[shanggong]PStartShangGong.processImp@start shang gong fail|roleid=%d|shanggongid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shanggongid), Integer.valueOf(res) }));
/*    */     
/* 60 */     if (extraInfo != null)
/*    */     {
/* 62 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 64 */         sb.append("|").append((String)entry.getKey());
/* 65 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 68 */     ShangGongManager.logger.info(sb.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanggong\main\PStartShangGong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */