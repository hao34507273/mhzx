/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class ReportRoleCrossBattleBetRankInfoContext
/*    */   implements Marshal, Comparable<ReportRoleCrossBattleBetRankInfoContext>
/*    */ {
/*    */   public byte count;
/*    */   
/*    */   public ReportRoleCrossBattleBetRankInfoContext() {}
/*    */   
/*    */   public ReportRoleCrossBattleBetRankInfoContext(byte _count_)
/*    */   {
/* 17 */     this.count = _count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.count);
/* 26 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 30 */     this.count = _os_.unmarshal_byte();
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 35 */     if (_o1_ == this) return true;
/* 36 */     if ((_o1_ instanceof ReportRoleCrossBattleBetRankInfoContext)) {
/* 37 */       ReportRoleCrossBattleBetRankInfoContext _o_ = (ReportRoleCrossBattleBetRankInfoContext)_o1_;
/* 38 */       if (this.count != _o_.count) return false;
/* 39 */       return true;
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 45 */     int _h_ = 0;
/* 46 */     _h_ += this.count;
/* 47 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 51 */     StringBuilder _sb_ = new StringBuilder();
/* 52 */     _sb_.append("(");
/* 53 */     _sb_.append(this.count).append(",");
/* 54 */     _sb_.append(")");
/* 55 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ReportRoleCrossBattleBetRankInfoContext _o_) {
/* 59 */     if (_o_ == this) return 0;
/* 60 */     int _c_ = 0;
/* 61 */     _c_ = this.count - _o_.count;
/* 62 */     if (0 != _c_) return _c_;
/* 63 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\ReportRoleCrossBattleBetRankInfoContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */