/*    */ package mzm.gsp.mail;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MailConsts
/*    */   implements Marshal, Comparable<MailConsts>
/*    */ {
/*    */   public static final int MAIL_DATA_STATE_NOT_READ = 0;
/*    */   public static final int MAIL_DATA_STATE_READED = 1;
/*    */   public static final int MAIL_DATA_NO_THING = 0;
/*    */   public static final int MAIL_DATA_HAS_THING = 1;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 23 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 31 */     if (_o1_ == this) return true;
/* 32 */     if ((_o1_ instanceof MailConsts)) {
/* 33 */       return true;
/*    */     }
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 39 */     int _h_ = 0;
/* 40 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 44 */     StringBuilder _sb_ = new StringBuilder();
/* 45 */     _sb_.append("(");
/* 46 */     _sb_.append(")");
/* 47 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MailConsts _o_) {
/* 51 */     if (_o_ == this) return 0;
/* 52 */     int _c_ = 0;
/* 53 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\MailConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */