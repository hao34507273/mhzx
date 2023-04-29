/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SChangeSwornNameVoteRes
/*    */   extends __SChangeSwornNameVoteRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597816;
/*    */   public static final int SUCCESS = 0;
/*    */   public static final int ERROR_UNKNOWN = 1;
/*    */   public static final int ERROR_OVERLAP_VOTE = 2;
/*    */   public static final int ERROR_VOTE_NOT_EXIST = 3;
/*    */   public int resultcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12597816;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChangeSwornNameVoteRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChangeSwornNameVoteRes(int _resultcode_)
/*    */   {
/* 39 */     this.resultcode = _resultcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.resultcode);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.resultcode = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof SChangeSwornNameVoteRes)) {
/* 62 */       SChangeSwornNameVoteRes _o_ = (SChangeSwornNameVoteRes)_o1_;
/* 63 */       if (this.resultcode != _o_.resultcode) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.resultcode;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.resultcode).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SChangeSwornNameVoteRes _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.resultcode - _o_.resultcode;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SChangeSwornNameVoteRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */