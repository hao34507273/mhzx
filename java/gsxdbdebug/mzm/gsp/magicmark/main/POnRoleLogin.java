/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.magicmark.SSyncMagicMarkInfo;
/*    */ import xbean.MagicMarkInfo;
/*    */ import xbean.MagicMarkSys;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(((Long)this.arg).longValue(), true);
/* 14 */     if (xMagicMarkSys == null) {
/* 15 */       return false;
/*    */     }
/* 17 */     SSyncMagicMarkInfo syncMagicMarkInfo = new SSyncMagicMarkInfo();
/* 18 */     Iterator<Map.Entry<Integer, MagicMarkInfo>> iterator = xMagicMarkSys.getMagicmarkinfos().entrySet().iterator();
/*    */     
/* 20 */     while (iterator.hasNext()) {
/* 21 */       Map.Entry<Integer, MagicMarkInfo> entry = (Map.Entry)iterator.next();
/* 22 */       int magicMarkType = ((Integer)entry.getKey()).intValue();
/* 23 */       long expiredTime = ((MagicMarkInfo)entry.getValue()).getExpiredtime();
/* 24 */       if (MagicMarkManager.isMargicMarkAvailable((MagicMarkInfo)entry.getValue())) {
/* 25 */         syncMagicMarkInfo.magicmarkinfomap.put(Integer.valueOf(magicMarkType), Long.valueOf(expiredTime));
/* 26 */         if (expiredTime > 0L)
/*    */         {
/* 28 */           MagicMarkSessionManager.addRoleSession(((Long)this.arg).longValue(), magicMarkType, expiredTime);
/*    */         }
/*    */       } else {
/* 31 */         iterator.remove();
/* 32 */         MagicMarkManager.onMagicMarkOutOfDate(((Long)this.arg).longValue(), xMagicMarkSys, magicMarkType, expiredTime);
/*    */       }
/*    */     }
/* 35 */     syncMagicMarkInfo.dressedmagicmarktype = xMagicMarkSys.getEuqipedmagicmarktype();
/* 36 */     syncMagicMarkInfo.effectpropmagictype = xMagicMarkSys.getPropmagicmarktype();
/* 37 */     mzm.gsp.online.main.OnlineManager.getInstance().send(((Long)this.arg).longValue(), syncMagicMarkInfo);
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */