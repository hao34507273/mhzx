/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class RebateInfo
/*    */   implements Marshal, Comparable<RebateInfo>
/*    */ {
/*    */   public int total_num;
/*    */   public int receive_time;
/*    */   public int receive_num;
/*    */   
/*    */   public RebateInfo() {}
/*    */   
/*    */   public RebateInfo(int _total_num_, int _receive_time_, int _receive_num_)
/*    */   {
/* 19 */     this.total_num = _total_num_;
/* 20 */     this.receive_time = _receive_time_;
/* 21 */     this.receive_num = _receive_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.total_num);
/* 30 */     _os_.marshal(this.receive_time);
/* 31 */     _os_.marshal(this.receive_num);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.total_num = _os_.unmarshal_int();
/* 37 */     this.receive_time = _os_.unmarshal_int();
/* 38 */     this.receive_num = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof RebateInfo)) {
/* 45 */       RebateInfo _o_ = (RebateInfo)_o1_;
/* 46 */       if (this.total_num != _o_.total_num) return false;
/* 47 */       if (this.receive_time != _o_.receive_time) return false;
/* 48 */       if (this.receive_num != _o_.receive_num) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.total_num;
/* 57 */     _h_ += this.receive_time;
/* 58 */     _h_ += this.receive_num;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.total_num).append(",");
/* 66 */     _sb_.append(this.receive_time).append(",");
/* 67 */     _sb_.append(this.receive_num).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RebateInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.total_num - _o_.total_num;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.receive_time - _o_.receive_time;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.receive_num - _o_.receive_num;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\RebateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */