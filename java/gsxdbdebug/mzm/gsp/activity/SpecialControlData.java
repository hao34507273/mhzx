/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class SpecialControlData
/*    */   implements Marshal, Comparable<SpecialControlData>
/*    */ {
/*    */   public int actvityid;
/*    */   public int openstate;
/*    */   public long endtime;
/*    */   
/*    */   public SpecialControlData() {}
/*    */   
/*    */   public SpecialControlData(int _actvityid_, int _openstate_, long _endtime_)
/*    */   {
/* 19 */     this.actvityid = _actvityid_;
/* 20 */     this.openstate = _openstate_;
/* 21 */     this.endtime = _endtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.actvityid);
/* 30 */     _os_.marshal(this.openstate);
/* 31 */     _os_.marshal(this.endtime);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.actvityid = _os_.unmarshal_int();
/* 37 */     this.openstate = _os_.unmarshal_int();
/* 38 */     this.endtime = _os_.unmarshal_long();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof SpecialControlData)) {
/* 45 */       SpecialControlData _o_ = (SpecialControlData)_o1_;
/* 46 */       if (this.actvityid != _o_.actvityid) return false;
/* 47 */       if (this.openstate != _o_.openstate) return false;
/* 48 */       if (this.endtime != _o_.endtime) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.actvityid;
/* 57 */     _h_ += this.openstate;
/* 58 */     _h_ += (int)this.endtime;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.actvityid).append(",");
/* 66 */     _sb_.append(this.openstate).append(",");
/* 67 */     _sb_.append(this.endtime).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SpecialControlData _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.actvityid - _o_.actvityid;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.openstate - _o_.openstate;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = Long.signum(this.endtime - _o_.endtime);
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SpecialControlData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */