/*    */ package mzm.gsp.xiaohuikuaipao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class OuterInfo
/*    */   implements Marshal, Comparable<OuterInfo>
/*    */ {
/*    */   public int index;
/*    */   public int accumulateturncount;
/*    */   public int ticketcount;
/*    */   
/*    */   public OuterInfo() {}
/*    */   
/*    */   public OuterInfo(int _index_, int _accumulateturncount_, int _ticketcount_)
/*    */   {
/* 19 */     this.index = _index_;
/* 20 */     this.accumulateturncount = _accumulateturncount_;
/* 21 */     this.ticketcount = _ticketcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.index);
/* 30 */     _os_.marshal(this.accumulateturncount);
/* 31 */     _os_.marshal(this.ticketcount);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.index = _os_.unmarshal_int();
/* 37 */     this.accumulateturncount = _os_.unmarshal_int();
/* 38 */     this.ticketcount = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof OuterInfo)) {
/* 45 */       OuterInfo _o_ = (OuterInfo)_o1_;
/* 46 */       if (this.index != _o_.index) return false;
/* 47 */       if (this.accumulateturncount != _o_.accumulateturncount) return false;
/* 48 */       if (this.ticketcount != _o_.ticketcount) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.index;
/* 57 */     _h_ += this.accumulateturncount;
/* 58 */     _h_ += this.ticketcount;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.index).append(",");
/* 66 */     _sb_.append(this.accumulateturncount).append(",");
/* 67 */     _sb_.append(this.ticketcount).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(OuterInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.index - _o_.index;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.accumulateturncount - _o_.accumulateturncount;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.ticketcount - _o_.ticketcount;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\OuterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */