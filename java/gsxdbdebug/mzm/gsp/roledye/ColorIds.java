/*    */ package mzm.gsp.roledye;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ColorIds implements Marshal, Comparable<ColorIds>
/*    */ {
/*    */   public int colorid;
/*    */   public int hairid;
/*    */   public int clothid;
/*    */   public int fashiondresscfgid;
/*    */   
/*    */   public ColorIds() {}
/*    */   
/*    */   public ColorIds(int _colorid_, int _hairid_, int _clothid_, int _fashiondresscfgid_)
/*    */   {
/* 18 */     this.colorid = _colorid_;
/* 19 */     this.hairid = _hairid_;
/* 20 */     this.clothid = _clothid_;
/* 21 */     this.fashiondresscfgid = _fashiondresscfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.colorid);
/* 30 */     _os_.marshal(this.hairid);
/* 31 */     _os_.marshal(this.clothid);
/* 32 */     _os_.marshal(this.fashiondresscfgid);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.colorid = _os_.unmarshal_int();
/* 38 */     this.hairid = _os_.unmarshal_int();
/* 39 */     this.clothid = _os_.unmarshal_int();
/* 40 */     this.fashiondresscfgid = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof ColorIds)) {
/* 47 */       ColorIds _o_ = (ColorIds)_o1_;
/* 48 */       if (this.colorid != _o_.colorid) return false;
/* 49 */       if (this.hairid != _o_.hairid) return false;
/* 50 */       if (this.clothid != _o_.clothid) return false;
/* 51 */       if (this.fashiondresscfgid != _o_.fashiondresscfgid) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.colorid;
/* 60 */     _h_ += this.hairid;
/* 61 */     _h_ += this.clothid;
/* 62 */     _h_ += this.fashiondresscfgid;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.colorid).append(",");
/* 70 */     _sb_.append(this.hairid).append(",");
/* 71 */     _sb_.append(this.clothid).append(",");
/* 72 */     _sb_.append(this.fashiondresscfgid).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ColorIds _o_) {
/* 78 */     if (_o_ == this) return 0;
/* 79 */     int _c_ = 0;
/* 80 */     _c_ = this.colorid - _o_.colorid;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.hairid - _o_.hairid;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.clothid - _o_.clothid;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.fashiondresscfgid - _o_.fashiondresscfgid;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\ColorIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */