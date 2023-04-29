/*    */ package mzm.gsp.ladder;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GetLadderRankRange_SendRankAward implements Marshal, Comparable<GetLadderRankRange_SendRankAward>
/*    */ {
/*    */   public int chart_type;
/*    */   
/*    */   public GetLadderRankRange_SendRankAward() {}
/*    */   
/*    */   public GetLadderRankRange_SendRankAward(int _chart_type_)
/*    */   {
/* 15 */     this.chart_type = _chart_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 23 */     _os_.marshal(this.chart_type);
/* 24 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 28 */     this.chart_type = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 33 */     if (_o1_ == this) return true;
/* 34 */     if ((_o1_ instanceof GetLadderRankRange_SendRankAward)) {
/* 35 */       GetLadderRankRange_SendRankAward _o_ = (GetLadderRankRange_SendRankAward)_o1_;
/* 36 */       if (this.chart_type != _o_.chart_type) return false;
/* 37 */       return true;
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 43 */     int _h_ = 0;
/* 44 */     _h_ += this.chart_type;
/* 45 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 49 */     StringBuilder _sb_ = new StringBuilder();
/* 50 */     _sb_.append("(");
/* 51 */     _sb_.append(this.chart_type).append(",");
/* 52 */     _sb_.append(")");
/* 53 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetLadderRankRange_SendRankAward _o_) {
/* 57 */     if (_o_ == this) return 0;
/* 58 */     int _c_ = 0;
/* 59 */     _c_ = this.chart_type - _o_.chart_type;
/* 60 */     if (0 != _c_) return _c_;
/* 61 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\GetLadderRankRange_SendRankAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */