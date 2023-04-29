/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SysSendMail2_Re
/*    */   extends __SysSendMail2_Re__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 4217;
/*    */   public int retcode;
/*    */   public int tid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 4217;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SysSendMail2_Re() {}
/*    */   
/*    */ 
/*    */   public SysSendMail2_Re(int _retcode_, int _tid_)
/*    */   {
/* 35 */     this.retcode = _retcode_;
/* 36 */     this.tid = _tid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.retcode);
/* 45 */     _os_.marshal(this.tid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.retcode = _os_.unmarshal_int();
/* 51 */     this.tid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SysSendMail2_Re)) {
/* 61 */       SysSendMail2_Re _o_ = (SysSendMail2_Re)_o1_;
/* 62 */       if (this.retcode != _o_.retcode) return false;
/* 63 */       if (this.tid != _o_.tid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.retcode;
/* 72 */     _h_ += this.tid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.retcode).append(",");
/* 80 */     _sb_.append(this.tid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SysSendMail2_Re _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.retcode - _o_.retcode;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.tid - _o_.tid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\SysSendMail2_Re.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */