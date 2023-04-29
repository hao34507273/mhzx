/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GrcRecallInfo implements Marshal, Comparable<GrcRecallInfo>
/*    */ {
/*    */   public long udpate_time;
/*    */   public int recall_num;
/*    */   
/*    */   public GrcRecallInfo() {}
/*    */   
/*    */   public GrcRecallInfo(long _udpate_time_, int _recall_num_)
/*    */   {
/* 16 */     this.udpate_time = _udpate_time_;
/* 17 */     this.recall_num = _recall_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.udpate_time);
/* 26 */     _os_.marshal(this.recall_num);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.udpate_time = _os_.unmarshal_long();
/* 32 */     this.recall_num = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof GrcRecallInfo)) {
/* 39 */       GrcRecallInfo _o_ = (GrcRecallInfo)_o1_;
/* 40 */       if (this.udpate_time != _o_.udpate_time) return false;
/* 41 */       if (this.recall_num != _o_.recall_num) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += (int)this.udpate_time;
/* 50 */     _h_ += this.recall_num;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.udpate_time).append(",");
/* 58 */     _sb_.append(this.recall_num).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GrcRecallInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = Long.signum(this.udpate_time - _o_.udpate_time);
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.recall_num - _o_.recall_num;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcRecallInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */