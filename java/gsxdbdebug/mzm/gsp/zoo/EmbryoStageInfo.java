/*    */ package mzm.gsp.zoo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class EmbryoStageInfo
/*    */   implements Marshal, Comparable<EmbryoStageInfo>
/*    */ {
/*    */   public int embryo_cfgid;
/*    */   public int last_time;
/*    */   public int hatch_days;
/*    */   
/*    */   public EmbryoStageInfo() {}
/*    */   
/*    */   public EmbryoStageInfo(int _embryo_cfgid_, int _last_time_, int _hatch_days_)
/*    */   {
/* 19 */     this.embryo_cfgid = _embryo_cfgid_;
/* 20 */     this.last_time = _last_time_;
/* 21 */     this.hatch_days = _hatch_days_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.embryo_cfgid);
/* 30 */     _os_.marshal(this.last_time);
/* 31 */     _os_.marshal(this.hatch_days);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.embryo_cfgid = _os_.unmarshal_int();
/* 37 */     this.last_time = _os_.unmarshal_int();
/* 38 */     this.hatch_days = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof EmbryoStageInfo)) {
/* 45 */       EmbryoStageInfo _o_ = (EmbryoStageInfo)_o1_;
/* 46 */       if (this.embryo_cfgid != _o_.embryo_cfgid) return false;
/* 47 */       if (this.last_time != _o_.last_time) return false;
/* 48 */       if (this.hatch_days != _o_.hatch_days) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.embryo_cfgid;
/* 57 */     _h_ += this.last_time;
/* 58 */     _h_ += this.hatch_days;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.embryo_cfgid).append(",");
/* 66 */     _sb_.append(this.last_time).append(",");
/* 67 */     _sb_.append(this.hatch_days).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(EmbryoStageInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.embryo_cfgid - _o_.embryo_cfgid;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.last_time - _o_.last_time;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.hatch_days - _o_.hatch_days;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\EmbryoStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */