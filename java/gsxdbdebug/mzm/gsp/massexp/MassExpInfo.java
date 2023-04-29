/*    */ package mzm.gsp.massexp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MassExpInfo
/*    */   implements Marshal, Comparable<MassExpInfo>
/*    */ {
/*    */   public static final int STATUS_INIT = 0;
/*    */   public static final int STATUS_ACCEPTED = 1;
/*    */   public static final int STATUS_END = 2;
/*    */   public int status;
/*    */   public int cur_index;
/*    */   public int start_timestamp;
/*    */   public int end_time;
/*    */   
/*    */   public MassExpInfo() {}
/*    */   
/*    */   public MassExpInfo(int _status_, int _cur_index_, int _start_timestamp_, int _end_time_)
/*    */   {
/* 24 */     this.status = _status_;
/* 25 */     this.cur_index = _cur_index_;
/* 26 */     this.start_timestamp = _start_timestamp_;
/* 27 */     this.end_time = _end_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.status);
/* 36 */     _os_.marshal(this.cur_index);
/* 37 */     _os_.marshal(this.start_timestamp);
/* 38 */     _os_.marshal(this.end_time);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     this.status = _os_.unmarshal_int();
/* 44 */     this.cur_index = _os_.unmarshal_int();
/* 45 */     this.start_timestamp = _os_.unmarshal_int();
/* 46 */     this.end_time = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof MassExpInfo)) {
/* 53 */       MassExpInfo _o_ = (MassExpInfo)_o1_;
/* 54 */       if (this.status != _o_.status) return false;
/* 55 */       if (this.cur_index != _o_.cur_index) return false;
/* 56 */       if (this.start_timestamp != _o_.start_timestamp) return false;
/* 57 */       if (this.end_time != _o_.end_time) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.status;
/* 66 */     _h_ += this.cur_index;
/* 67 */     _h_ += this.start_timestamp;
/* 68 */     _h_ += this.end_time;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.status).append(",");
/* 76 */     _sb_.append(this.cur_index).append(",");
/* 77 */     _sb_.append(this.start_timestamp).append(",");
/* 78 */     _sb_.append(this.end_time).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MassExpInfo _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.status - _o_.status;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.cur_index - _o_.cur_index;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.start_timestamp - _o_.start_timestamp;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.end_time - _o_.end_time;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\MassExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */