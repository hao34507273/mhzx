/*    */ package mzm.gsp.qmhw;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class QMHWInfo implements Marshal, Comparable<QMHWInfo>
/*    */ {
/*    */   public int score;
/*    */   public int wincount;
/*    */   public int losecount;
/*    */   public int continuewincount;
/*    */   
/*    */   public QMHWInfo() {}
/*    */   
/*    */   public QMHWInfo(int _score_, int _wincount_, int _losecount_, int _continuewincount_)
/*    */   {
/* 18 */     this.score = _score_;
/* 19 */     this.wincount = _wincount_;
/* 20 */     this.losecount = _losecount_;
/* 21 */     this.continuewincount = _continuewincount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.score);
/* 30 */     _os_.marshal(this.wincount);
/* 31 */     _os_.marshal(this.losecount);
/* 32 */     _os_.marshal(this.continuewincount);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.score = _os_.unmarshal_int();
/* 38 */     this.wincount = _os_.unmarshal_int();
/* 39 */     this.losecount = _os_.unmarshal_int();
/* 40 */     this.continuewincount = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof QMHWInfo)) {
/* 47 */       QMHWInfo _o_ = (QMHWInfo)_o1_;
/* 48 */       if (this.score != _o_.score) return false;
/* 49 */       if (this.wincount != _o_.wincount) return false;
/* 50 */       if (this.losecount != _o_.losecount) return false;
/* 51 */       if (this.continuewincount != _o_.continuewincount) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.score;
/* 60 */     _h_ += this.wincount;
/* 61 */     _h_ += this.losecount;
/* 62 */     _h_ += this.continuewincount;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.score).append(",");
/* 70 */     _sb_.append(this.wincount).append(",");
/* 71 */     _sb_.append(this.losecount).append(",");
/* 72 */     _sb_.append(this.continuewincount).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(QMHWInfo _o_) {
/* 78 */     if (_o_ == this) return 0;
/* 79 */     int _c_ = 0;
/* 80 */     _c_ = this.score - _o_.score;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.wincount - _o_.wincount;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.losecount - _o_.losecount;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.continuewincount - _o_.continuewincount;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\QMHWInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */