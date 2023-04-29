/*    */ package mzm.gsp.corps;
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
/*    */ 
/*    */ 
/*    */ public class SSynCreateCorpsConfirmBro
/*    */   extends __SSynCreateCorpsConfirmBro__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617507;
/*    */   public long memberid;
/*    */   public int reply;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617507;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynCreateCorpsConfirmBro() {}
/*    */   
/*    */ 
/*    */   public SSynCreateCorpsConfirmBro(long _memberid_, int _reply_)
/*    */   {
/* 37 */     this.memberid = _memberid_;
/* 38 */     this.reply = _reply_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.memberid);
/* 47 */     _os_.marshal(this.reply);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.memberid = _os_.unmarshal_long();
/* 53 */     this.reply = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynCreateCorpsConfirmBro)) {
/* 63 */       SSynCreateCorpsConfirmBro _o_ = (SSynCreateCorpsConfirmBro)_o1_;
/* 64 */       if (this.memberid != _o_.memberid) return false;
/* 65 */       if (this.reply != _o_.reply) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.memberid;
/* 74 */     _h_ += this.reply;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.memberid).append(",");
/* 82 */     _sb_.append(this.reply).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynCreateCorpsConfirmBro _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.memberid - _o_.memberid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.reply - _o_.reply;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SSynCreateCorpsConfirmBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */