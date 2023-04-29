/*    */ package mzm.gsp.crossfield;
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
/*    */ public class SGetRoleCrossFieldRankSuccess
/*    */   extends __SGetRoleCrossFieldRankSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619536;
/*    */   public int rank_type;
/*    */   public int rank;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619536;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetRoleCrossFieldRankSuccess() {}
/*    */   
/*    */ 
/*    */   public SGetRoleCrossFieldRankSuccess(int _rank_type_, int _rank_)
/*    */   {
/* 37 */     this.rank_type = _rank_type_;
/* 38 */     this.rank = _rank_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.rank_type);
/* 47 */     _os_.marshal(this.rank);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.rank_type = _os_.unmarshal_int();
/* 53 */     this.rank = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SGetRoleCrossFieldRankSuccess)) {
/* 63 */       SGetRoleCrossFieldRankSuccess _o_ = (SGetRoleCrossFieldRankSuccess)_o1_;
/* 64 */       if (this.rank_type != _o_.rank_type) return false;
/* 65 */       if (this.rank != _o_.rank) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.rank_type;
/* 74 */     _h_ += this.rank;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.rank_type).append(",");
/* 82 */     _sb_.append(this.rank).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetRoleCrossFieldRankSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.rank_type - _o_.rank_type;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.rank - _o_.rank;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\SGetRoleCrossFieldRankSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */