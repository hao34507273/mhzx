/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.magicmark.SMagicMarkExpired;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MagicMarkInfo;
/*    */ import xbean.MagicMarkSys;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PMagicMarkOutOfDate
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int magicMarkType;
/*    */   private final long exprieTime;
/*    */   
/*    */   public PMagicMarkOutOfDate(long roleid, int magicMarkType, long expireTime)
/*    */   {
/* 39 */     this.roleid = roleid;
/* 40 */     this.magicMarkType = magicMarkType;
/* 41 */     this.exprieTime = expireTime;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 46 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(this.roleid, true);
/* 47 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(this.magicMarkType));
/* 48 */     if (xMagicMarkInfo == null) {
/* 49 */       return false;
/*    */     }
/* 51 */     long storeExpiredTime = xMagicMarkInfo.getExpiredtime();
/* 52 */     if (this.exprieTime != storeExpiredTime) {
/* 53 */       GameServer.logger().warn(String.format("[MagicMark]PMagicMarkOutOfDate.processImp@expired time is not equail|exprieTime=%d|storeExpiredTime=%d|roleid=%d|magicMarkType=%d", new Object[] { Long.valueOf(this.exprieTime), Long.valueOf(storeExpiredTime), Long.valueOf(this.roleid), Integer.valueOf(this.magicMarkType) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     xMagicMarkSys.getMagicmarkinfos().remove(Integer.valueOf(this.magicMarkType));
/* 62 */     MagicMarkManager.onMagicMarkOutOfDate(this.roleid, xMagicMarkSys, this.magicMarkType, storeExpiredTime);
/*    */     
/* 64 */     SMagicMarkExpired magicMarkExpired = new SMagicMarkExpired();
/* 65 */     magicMarkExpired.magicmarktype = this.magicMarkType;
/* 66 */     OnlineManager.getInstance().send(this.roleid, magicMarkExpired);
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\PMagicMarkOutOfDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */