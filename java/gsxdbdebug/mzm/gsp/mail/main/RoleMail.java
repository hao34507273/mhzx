/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ import xbean.MailMapBean;
/*    */ 
/*    */ class RoleMail
/*    */ {
/*    */   private MailMapBean xMailMapBean;
/*    */   private long roleid;
/*    */   
/*    */   RoleMail(long roleId, boolean retainLock)
/*    */   {
/* 12 */     this.roleid = roleId;
/* 13 */     if (retainLock) {
/* 14 */       this.xMailMapBean = xtable.Role2mail.get(Long.valueOf(roleId));
/*    */     } else {
/* 16 */       this.xMailMapBean = xtable.Role2mail.select(Long.valueOf(roleId));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean hasMail(int mailIndex)
/*    */   {
/* 27 */     if (this.xMailMapBean == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     return this.xMailMapBean.getMailinfomap().containsKey(Integer.valueOf(mailIndex));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   int getNextIndex()
/*    */   {
/* 39 */     int nextid = this.xMailMapBean.getNextid();
/* 40 */     this.xMailMapBean.setNextid(++nextid);
/* 41 */     return nextid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   long getRoleid()
/*    */   {
/* 50 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   java.util.Map<Integer, xbean.MailInfo> getMailMap()
/*    */   {
/* 59 */     if (this.xMailMapBean == null) {
/* 60 */       return new java.util.HashMap();
/*    */     }
/* 62 */     return this.xMailMapBean.getMailinfomap();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void setMailMapBean(MailMapBean xMailMapBean)
/*    */   {
/* 72 */     this.xMailMapBean = xMailMapBean;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean isNull()
/*    */   {
/* 81 */     return this.xMailMapBean == null;
/*    */   }
/*    */   
/*    */   int size() {
/* 85 */     if (this.xMailMapBean == null) {
/* 86 */       return 0;
/*    */     }
/* 88 */     return this.xMailMapBean.getMailinfomap().size();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void add(int mailIndex, xbean.MailInfo xMailInfo)
/*    */   {
/* 98 */     this.xMailMapBean.getMailinfomap().put(Integer.valueOf(mailIndex), xMailInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\RoleMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */