/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GrcRebateInfo implements Marshal, Comparable<GrcRebateInfo>
/*    */ {
/*    */   public int total_num;
/*    */   public long receive_time;
/*    */   public int receive_num;
/*    */   
/*    */   public GrcRebateInfo() {}
/*    */   
/*    */   public GrcRebateInfo(int _total_num_, long _receive_time_, int _receive_num_)
/*    */   {
/* 17 */     this.total_num = _total_num_;
/* 18 */     this.receive_time = _receive_time_;
/* 19 */     this.receive_num = _receive_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.total_num);
/* 28 */     _os_.marshal(this.receive_time);
/* 29 */     _os_.marshal(this.receive_num);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.total_num = _os_.unmarshal_int();
/* 35 */     this.receive_time = _os_.unmarshal_long();
/* 36 */     this.receive_num = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof GrcRebateInfo)) {
/* 43 */       GrcRebateInfo _o_ = (GrcRebateInfo)_o1_;
/* 44 */       if (this.total_num != _o_.total_num) return false;
/* 45 */       if (this.receive_time != _o_.receive_time) return false;
/* 46 */       if (this.receive_num != _o_.receive_num) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.total_num;
/* 55 */     _h_ += (int)this.receive_time;
/* 56 */     _h_ += this.receive_num;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.total_num).append(",");
/* 64 */     _sb_.append(this.receive_time).append(",");
/* 65 */     _sb_.append(this.receive_num).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GrcRebateInfo _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.total_num - _o_.total_num;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = Long.signum(this.receive_time - _o_.receive_time);
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.receive_num - _o_.receive_num;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcRebateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */