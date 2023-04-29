/*    */ package mzm.gsp.award;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class LostExpInfo implements Marshal, Comparable<LostExpInfo>
/*    */ {
/*    */   public int totalvalue;
/*    */   public int alreadygetvalue;
/*    */   public int cangetvalue;
/*    */   public int alreadygetexp;
/*    */   
/*    */   public LostExpInfo() {}
/*    */   
/*    */   public LostExpInfo(int _totalvalue_, int _alreadygetvalue_, int _cangetvalue_, int _alreadygetexp_)
/*    */   {
/* 18 */     this.totalvalue = _totalvalue_;
/* 19 */     this.alreadygetvalue = _alreadygetvalue_;
/* 20 */     this.cangetvalue = _cangetvalue_;
/* 21 */     this.alreadygetexp = _alreadygetexp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.totalvalue);
/* 30 */     _os_.marshal(this.alreadygetvalue);
/* 31 */     _os_.marshal(this.cangetvalue);
/* 32 */     _os_.marshal(this.alreadygetexp);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.totalvalue = _os_.unmarshal_int();
/* 38 */     this.alreadygetvalue = _os_.unmarshal_int();
/* 39 */     this.cangetvalue = _os_.unmarshal_int();
/* 40 */     this.alreadygetexp = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof LostExpInfo)) {
/* 47 */       LostExpInfo _o_ = (LostExpInfo)_o1_;
/* 48 */       if (this.totalvalue != _o_.totalvalue) return false;
/* 49 */       if (this.alreadygetvalue != _o_.alreadygetvalue) return false;
/* 50 */       if (this.cangetvalue != _o_.cangetvalue) return false;
/* 51 */       if (this.alreadygetexp != _o_.alreadygetexp) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.totalvalue;
/* 60 */     _h_ += this.alreadygetvalue;
/* 61 */     _h_ += this.cangetvalue;
/* 62 */     _h_ += this.alreadygetexp;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.totalvalue).append(",");
/* 70 */     _sb_.append(this.alreadygetvalue).append(",");
/* 71 */     _sb_.append(this.cangetvalue).append(",");
/* 72 */     _sb_.append(this.alreadygetexp).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(LostExpInfo _o_) {
/* 78 */     if (_o_ == this) return 0;
/* 79 */     int _c_ = 0;
/* 80 */     _c_ = this.totalvalue - _o_.totalvalue;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.alreadygetvalue - _o_.alreadygetvalue;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.cangetvalue - _o_.cangetvalue;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.alreadygetexp - _o_.alreadygetexp;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\LostExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */