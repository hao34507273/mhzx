/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.logs.Listener;
/*    */ import xdb.logs.Note;
/*    */ 
/*    */ 
/*    */ class JifenChangedListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object key)
/*    */   {
/* 13 */     Long roleId = (Long)key;
/* 14 */     new SynJifenPro(roleId.longValue()).execute();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onRemoved(Object key) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onChanged(Object key, String fullVarName, Note note)
/*    */   {
/* 27 */     Long roleId = (Long)key;
/* 28 */     new SynJifenPro(roleId.longValue()).execute();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class SynJifenPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private long roleid;
/*    */     
/*    */     public SynJifenPro(long roleid)
/*    */     {
/* 39 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 46 */       MallManager.synJifen(this.roleid);
/* 47 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\JifenChangedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */