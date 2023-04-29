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
/*    */ public class SFightEndRes
/*    */   extends __SFightEndRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608771;
/*    */   public int seq;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12608771;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFightEndRes() {}
/*    */   
/*    */ 
/*    */   public SFightEndRes(int _seq_, int _result_)
/*    */   {
/* 35 */     this.seq = _seq_;
/* 36 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.seq);
/* 45 */     _os_.marshal(this.result);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.seq = _os_.unmarshal_int();
/* 51 */     this.result = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SFightEndRes)) {
/* 61 */       SFightEndRes _o_ = (SFightEndRes)_o1_;
/* 62 */       if (this.seq != _o_.seq) return false;
/* 63 */       if (this.result != _o_.result) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.seq;
/* 72 */     _h_ += this.result;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.seq).append(",");
/* 80 */     _sb_.append(this.result).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFightEndRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.seq - _o_.seq;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.result - _o_.result;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\SFightEndRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */