/*    */ package mzm.gsp.crossfield;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SGetCrossFieldRankSuccess
/*    */   extends __SGetCrossFieldRankSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619531;
/*    */   public int rank_type;
/*    */   public ArrayList<CrossFieldRankData> rank_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619531;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetCrossFieldRankSuccess()
/*    */   {
/* 34 */     this.rank_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetCrossFieldRankSuccess(int _rank_type_, ArrayList<CrossFieldRankData> _rank_list_) {
/* 38 */     this.rank_type = _rank_type_;
/* 39 */     this.rank_list = _rank_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (CrossFieldRankData _v_ : this.rank_list)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.rank_type);
/* 50 */     _os_.compact_uint32(this.rank_list.size());
/* 51 */     for (CrossFieldRankData _v_ : this.rank_list) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.rank_type = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       CrossFieldRankData _v_ = new CrossFieldRankData();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.rank_list.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SGetCrossFieldRankSuccess)) {
/* 73 */       SGetCrossFieldRankSuccess _o_ = (SGetCrossFieldRankSuccess)_o1_;
/* 74 */       if (this.rank_type != _o_.rank_type) return false;
/* 75 */       if (!this.rank_list.equals(_o_.rank_list)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.rank_type;
/* 84 */     _h_ += this.rank_list.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.rank_type).append(",");
/* 92 */     _sb_.append(this.rank_list).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\SGetCrossFieldRankSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */