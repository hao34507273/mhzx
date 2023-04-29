/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ActivityData
/*    */   implements Marshal, Comparable<ActivityData>
/*    */ {
/*    */   public static final int not_take = 0;
/*    */   public static final int token = 1;
/*    */   public int actvityid;
/*    */   public int count;
/*    */   public int awarded;
/*    */   public long cleartime;
/*    */   
/*    */   public ActivityData() {}
/*    */   
/*    */   public ActivityData(int _actvityid_, int _count_, int _awarded_, long _cleartime_)
/*    */   {
/* 21 */     this.actvityid = _actvityid_;
/* 22 */     this.count = _count_;
/* 23 */     this.awarded = _awarded_;
/* 24 */     this.cleartime = _cleartime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.actvityid);
/* 33 */     _os_.marshal(this.count);
/* 34 */     _os_.marshal(this.awarded);
/* 35 */     _os_.marshal(this.cleartime);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.actvityid = _os_.unmarshal_int();
/* 41 */     this.count = _os_.unmarshal_int();
/* 42 */     this.awarded = _os_.unmarshal_int();
/* 43 */     this.cleartime = _os_.unmarshal_long();
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof ActivityData)) {
/* 50 */       ActivityData _o_ = (ActivityData)_o1_;
/* 51 */       if (this.actvityid != _o_.actvityid) return false;
/* 52 */       if (this.count != _o_.count) return false;
/* 53 */       if (this.awarded != _o_.awarded) return false;
/* 54 */       if (this.cleartime != _o_.cleartime) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += this.actvityid;
/* 63 */     _h_ += this.count;
/* 64 */     _h_ += this.awarded;
/* 65 */     _h_ += (int)this.cleartime;
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append(this.actvityid).append(",");
/* 73 */     _sb_.append(this.count).append(",");
/* 74 */     _sb_.append(this.awarded).append(",");
/* 75 */     _sb_.append(this.cleartime).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ActivityData _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = this.actvityid - _o_.actvityid;
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     _c_ = this.count - _o_.count;
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     _c_ = this.awarded - _o_.awarded;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = Long.signum(this.cleartime - _o_.cleartime);
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\ActivityData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */