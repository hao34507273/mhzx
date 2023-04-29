/*    */ package mzm.gsp.activitycompensate;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ActivityCompensate implements Marshal, Comparable<ActivityCompensate>
/*    */ {
/*    */   public int activityid;
/*    */   public int times;
/*    */   public int free_exp;
/*    */   public int gold_exp;
/*    */   public int yuanbao_exp;
/*    */   
/*    */   public ActivityCompensate() {}
/*    */   
/*    */   public ActivityCompensate(int _activityid_, int _times_, int _free_exp_, int _gold_exp_, int _yuanbao_exp_)
/*    */   {
/* 19 */     this.activityid = _activityid_;
/* 20 */     this.times = _times_;
/* 21 */     this.free_exp = _free_exp_;
/* 22 */     this.gold_exp = _gold_exp_;
/* 23 */     this.yuanbao_exp = _yuanbao_exp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.activityid);
/* 32 */     _os_.marshal(this.times);
/* 33 */     _os_.marshal(this.free_exp);
/* 34 */     _os_.marshal(this.gold_exp);
/* 35 */     _os_.marshal(this.yuanbao_exp);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.activityid = _os_.unmarshal_int();
/* 41 */     this.times = _os_.unmarshal_int();
/* 42 */     this.free_exp = _os_.unmarshal_int();
/* 43 */     this.gold_exp = _os_.unmarshal_int();
/* 44 */     this.yuanbao_exp = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof ActivityCompensate)) {
/* 51 */       ActivityCompensate _o_ = (ActivityCompensate)_o1_;
/* 52 */       if (this.activityid != _o_.activityid) return false;
/* 53 */       if (this.times != _o_.times) return false;
/* 54 */       if (this.free_exp != _o_.free_exp) return false;
/* 55 */       if (this.gold_exp != _o_.gold_exp) return false;
/* 56 */       if (this.yuanbao_exp != _o_.yuanbao_exp) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.activityid;
/* 65 */     _h_ += this.times;
/* 66 */     _h_ += this.free_exp;
/* 67 */     _h_ += this.gold_exp;
/* 68 */     _h_ += this.yuanbao_exp;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.activityid).append(",");
/* 76 */     _sb_.append(this.times).append(",");
/* 77 */     _sb_.append(this.free_exp).append(",");
/* 78 */     _sb_.append(this.gold_exp).append(",");
/* 79 */     _sb_.append(this.yuanbao_exp).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ActivityCompensate _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.activityid - _o_.activityid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = this.times - _o_.times;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.free_exp - _o_.free_exp;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.gold_exp - _o_.gold_exp;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.yuanbao_exp - _o_.yuanbao_exp;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\ActivityCompensate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */