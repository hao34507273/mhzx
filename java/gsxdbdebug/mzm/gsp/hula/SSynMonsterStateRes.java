/*    */ package mzm.gsp.hula;
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
/*    */ public class SSynMonsterStateRes
/*    */   extends __SSynMonsterStateRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608782;
/*    */   public int state;
/*    */   public int seq;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12608782;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynMonsterStateRes() {}
/*    */   
/*    */ 
/*    */   public SSynMonsterStateRes(int _state_, int _seq_)
/*    */   {
/* 35 */     this.state = _state_;
/* 36 */     this.seq = _seq_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.state);
/* 45 */     _os_.marshal(this.seq);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.state = _os_.unmarshal_int();
/* 51 */     this.seq = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SSynMonsterStateRes)) {
/* 61 */       SSynMonsterStateRes _o_ = (SSynMonsterStateRes)_o1_;
/* 62 */       if (this.state != _o_.state) return false;
/* 63 */       if (this.seq != _o_.seq) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.state;
/* 72 */     _h_ += this.seq;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.state).append(",");
/* 80 */     _sb_.append(this.seq).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynMonsterStateRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.state - _o_.state;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.seq - _o_.seq;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\SSynMonsterStateRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */