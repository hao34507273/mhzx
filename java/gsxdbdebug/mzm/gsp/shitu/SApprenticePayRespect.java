/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SApprenticePayRespect
/*    */   extends __SApprenticePayRespect__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601626;
/*    */   public Octets pay_respect_str;
/*    */   public long apprentice_role_id;
/*    */   public long session_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601626;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SApprenticePayRespect()
/*    */   {
/* 35 */     this.pay_respect_str = new Octets();
/*    */   }
/*    */   
/*    */   public SApprenticePayRespect(Octets _pay_respect_str_, long _apprentice_role_id_, long _session_id_) {
/* 39 */     this.pay_respect_str = _pay_respect_str_;
/* 40 */     this.apprentice_role_id = _apprentice_role_id_;
/* 41 */     this.session_id = _session_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.pay_respect_str);
/* 50 */     _os_.marshal(this.apprentice_role_id);
/* 51 */     _os_.marshal(this.session_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.pay_respect_str = _os_.unmarshal_Octets();
/* 57 */     this.apprentice_role_id = _os_.unmarshal_long();
/* 58 */     this.session_id = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SApprenticePayRespect)) {
/* 68 */       SApprenticePayRespect _o_ = (SApprenticePayRespect)_o1_;
/* 69 */       if (!this.pay_respect_str.equals(_o_.pay_respect_str)) return false;
/* 70 */       if (this.apprentice_role_id != _o_.apprentice_role_id) return false;
/* 71 */       if (this.session_id != _o_.session_id) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.pay_respect_str.hashCode();
/* 80 */     _h_ += (int)this.apprentice_role_id;
/* 81 */     _h_ += (int)this.session_id;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("B").append(this.pay_respect_str.size()).append(",");
/* 89 */     _sb_.append(this.apprentice_role_id).append(",");
/* 90 */     _sb_.append(this.session_id).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SApprenticePayRespect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */