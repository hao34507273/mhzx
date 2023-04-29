/*    */ package mzm.gsp.arena;
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
/*    */ public class SSelfRankRes
/*    */   extends __SSelfRankRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596746;
/*    */   public int score;
/*    */   public int rank;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12596746;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSelfRankRes()
/*    */   {
/* 32 */     this.score = -1;
/*    */   }
/*    */   
/*    */   public SSelfRankRes(int _score_, int _rank_) {
/* 36 */     this.score = _score_;
/* 37 */     this.rank = _rank_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.score);
/* 46 */     _os_.marshal(this.rank);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.score = _os_.unmarshal_int();
/* 52 */     this.rank = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof SSelfRankRes)) {
/* 62 */       SSelfRankRes _o_ = (SSelfRankRes)_o1_;
/* 63 */       if (this.score != _o_.score) return false;
/* 64 */       if (this.rank != _o_.rank) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.score;
/* 73 */     _h_ += this.rank;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.score).append(",");
/* 81 */     _sb_.append(this.rank).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSelfRankRes _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.score - _o_.score;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.rank - _o_.rank;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\SSelfRankRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */