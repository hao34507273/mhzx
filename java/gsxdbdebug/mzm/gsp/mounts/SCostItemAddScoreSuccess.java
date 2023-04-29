/*    */ package mzm.gsp.mounts;
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
/*    */ public class SCostItemAddScoreSuccess
/*    */   extends __SCostItemAddScoreSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12606240;
/*    */   public long add_score_mounts_id;
/*    */   public int now_score;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12606240;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SCostItemAddScoreSuccess() {}
/*    */   
/*    */ 
/*    */   public SCostItemAddScoreSuccess(long _add_score_mounts_id_, int _now_score_)
/*    */   {
/* 37 */     this.add_score_mounts_id = _add_score_mounts_id_;
/* 38 */     this.now_score = _now_score_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.add_score_mounts_id);
/* 47 */     _os_.marshal(this.now_score);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.add_score_mounts_id = _os_.unmarshal_long();
/* 53 */     this.now_score = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SCostItemAddScoreSuccess)) {
/* 63 */       SCostItemAddScoreSuccess _o_ = (SCostItemAddScoreSuccess)_o1_;
/* 64 */       if (this.add_score_mounts_id != _o_.add_score_mounts_id) return false;
/* 65 */       if (this.now_score != _o_.now_score) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.add_score_mounts_id;
/* 74 */     _h_ += this.now_score;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.add_score_mounts_id).append(",");
/* 82 */     _sb_.append(this.now_score).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SCostItemAddScoreSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.add_score_mounts_id - _o_.add_score_mounts_id);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.now_score - _o_.now_score;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SCostItemAddScoreSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */