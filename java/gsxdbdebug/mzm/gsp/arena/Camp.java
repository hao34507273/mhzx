/*    */ package mzm.gsp.arena;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class Camp implements Marshal, Comparable<Camp>
/*    */ {
/*    */   public int camp;
/*    */   public int score;
/*    */   
/*    */   public Camp() {}
/*    */   
/*    */   public Camp(int _camp_, int _score_)
/*    */   {
/* 16 */     this.camp = _camp_;
/* 17 */     this.score = _score_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.camp);
/* 26 */     _os_.marshal(this.score);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.camp = _os_.unmarshal_int();
/* 32 */     this.score = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof Camp)) {
/* 39 */       Camp _o_ = (Camp)_o1_;
/* 40 */       if (this.camp != _o_.camp) return false;
/* 41 */       if (this.score != _o_.score) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.camp;
/* 50 */     _h_ += this.score;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.camp).append(",");
/* 58 */     _sb_.append(this.score).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(Camp _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.camp - _o_.camp;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.score - _o_.score;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\Camp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */