/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class PetSoulInfo implements Marshal, Comparable<PetSoulInfo>
/*    */ {
/*    */   public int pos;
/*    */   public int level;
/*    */   public int exp;
/*    */   public int propindex;
/*    */   
/*    */   public PetSoulInfo() {}
/*    */   
/*    */   public PetSoulInfo(int _pos_, int _level_, int _exp_, int _propindex_)
/*    */   {
/* 18 */     this.pos = _pos_;
/* 19 */     this.level = _level_;
/* 20 */     this.exp = _exp_;
/* 21 */     this.propindex = _propindex_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.pos);
/* 30 */     _os_.marshal(this.level);
/* 31 */     _os_.marshal(this.exp);
/* 32 */     _os_.marshal(this.propindex);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.pos = _os_.unmarshal_int();
/* 38 */     this.level = _os_.unmarshal_int();
/* 39 */     this.exp = _os_.unmarshal_int();
/* 40 */     this.propindex = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof PetSoulInfo)) {
/* 47 */       PetSoulInfo _o_ = (PetSoulInfo)_o1_;
/* 48 */       if (this.pos != _o_.pos) return false;
/* 49 */       if (this.level != _o_.level) return false;
/* 50 */       if (this.exp != _o_.exp) return false;
/* 51 */       if (this.propindex != _o_.propindex) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.pos;
/* 60 */     _h_ += this.level;
/* 61 */     _h_ += this.exp;
/* 62 */     _h_ += this.propindex;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.pos).append(",");
/* 70 */     _sb_.append(this.level).append(",");
/* 71 */     _sb_.append(this.exp).append(",");
/* 72 */     _sb_.append(this.propindex).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PetSoulInfo _o_) {
/* 78 */     if (_o_ == this) return 0;
/* 79 */     int _c_ = 0;
/* 80 */     _c_ = this.pos - _o_.pos;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.level - _o_.level;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.exp - _o_.exp;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.propindex - _o_.propindex;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\PetSoulInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */