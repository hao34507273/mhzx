/*    */ package mzm.gsp.superequipment;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WuShiInfo
/*    */   implements Marshal, Comparable<WuShiInfo>
/*    */ {
/*    */   public static final int ON = 1;
/*    */   public static final int OFF = 2;
/*    */   public static final int ACTIVATE = 3;
/*    */   public static final int NOT_ACTIVATE = 4;
/*    */   public int wushicfgid;
/*    */   public int ison;
/*    */   public int isactivate;
/*    */   public int fragmentcount;
/*    */   
/*    */   public WuShiInfo() {}
/*    */   
/*    */   public WuShiInfo(int _wushicfgid_, int _ison_, int _isactivate_, int _fragmentcount_)
/*    */   {
/* 25 */     this.wushicfgid = _wushicfgid_;
/* 26 */     this.ison = _ison_;
/* 27 */     this.isactivate = _isactivate_;
/* 28 */     this.fragmentcount = _fragmentcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.wushicfgid);
/* 37 */     _os_.marshal(this.ison);
/* 38 */     _os_.marshal(this.isactivate);
/* 39 */     _os_.marshal(this.fragmentcount);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     this.wushicfgid = _os_.unmarshal_int();
/* 45 */     this.ison = _os_.unmarshal_int();
/* 46 */     this.isactivate = _os_.unmarshal_int();
/* 47 */     this.fragmentcount = _os_.unmarshal_int();
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof WuShiInfo)) {
/* 54 */       WuShiInfo _o_ = (WuShiInfo)_o1_;
/* 55 */       if (this.wushicfgid != _o_.wushicfgid) return false;
/* 56 */       if (this.ison != _o_.ison) return false;
/* 57 */       if (this.isactivate != _o_.isactivate) return false;
/* 58 */       if (this.fragmentcount != _o_.fragmentcount) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.wushicfgid;
/* 67 */     _h_ += this.ison;
/* 68 */     _h_ += this.isactivate;
/* 69 */     _h_ += this.fragmentcount;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.wushicfgid).append(",");
/* 77 */     _sb_.append(this.ison).append(",");
/* 78 */     _sb_.append(this.isactivate).append(",");
/* 79 */     _sb_.append(this.fragmentcount).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(WuShiInfo _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.wushicfgid - _o_.wushicfgid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = this.ison - _o_.ison;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.isactivate - _o_.isactivate;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.fragmentcount - _o_.fragmentcount;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\WuShiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */