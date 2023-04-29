/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public abstract class ExchangeDataHandler<ContextBean extends Marshal>
/*    */ {
/*    */   public abstract ContextBean makeContextBean();
/*    */   
/*    */   boolean boxData(String userid, long roleid, OctetsStream os)
/*    */   {
/* 13 */     ContextBean bean = makeContextBean();
/* 14 */     if (!onBoxData(userid, roleid, bean))
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     bean.marshal(os);
/*    */     
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   boolean unboxData(String userid, long roleid, Octets octets)
/*    */   {
/* 26 */     OctetsStream os = new OctetsStream(octets);
/* 27 */     ContextBean bean = makeContextBean();
/*    */     try
/*    */     {
/* 30 */       bean.unmarshal(os);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (!onUnboxData(userid, roleid, bean))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   protected abstract boolean onBoxData(String paramString, long paramLong, ContextBean paramContextBean);
/*    */   
/*    */   protected abstract boolean onUnboxData(String paramString, long paramLong, ContextBean paramContextBean);
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\ExchangeDataHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */