/*    */ package mzm.gsp.xiulian;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class SkillBagInfo
/*    */   implements Marshal, Comparable<SkillBagInfo>
/*    */ {
/*    */   public int skillbagid;
/*    */   public int skilllevel;
/*    */   public int exp;
/*    */   
/*    */   public SkillBagInfo() {}
/*    */   
/*    */   public SkillBagInfo(int _skillbagid_, int _skilllevel_, int _exp_)
/*    */   {
/* 19 */     this.skillbagid = _skillbagid_;
/* 20 */     this.skilllevel = _skilllevel_;
/* 21 */     this.exp = _exp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.skillbagid);
/* 30 */     _os_.marshal(this.skilllevel);
/* 31 */     _os_.marshal(this.exp);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.skillbagid = _os_.unmarshal_int();
/* 37 */     this.skilllevel = _os_.unmarshal_int();
/* 38 */     this.exp = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof SkillBagInfo)) {
/* 45 */       SkillBagInfo _o_ = (SkillBagInfo)_o1_;
/* 46 */       if (this.skillbagid != _o_.skillbagid) return false;
/* 47 */       if (this.skilllevel != _o_.skilllevel) return false;
/* 48 */       if (this.exp != _o_.exp) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.skillbagid;
/* 57 */     _h_ += this.skilllevel;
/* 58 */     _h_ += this.exp;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.skillbagid).append(",");
/* 66 */     _sb_.append(this.skilllevel).append(",");
/* 67 */     _sb_.append(this.exp).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SkillBagInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.skillbagid - _o_.skillbagid;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.skilllevel - _o_.skilllevel;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.exp - _o_.exp;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\SkillBagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */