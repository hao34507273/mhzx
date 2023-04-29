/*    */ package mzm.gsp.skill;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class MenPaiSkillBagInfo
/*    */   implements Marshal, Comparable<MenPaiSkillBagInfo>
/*    */ {
/*    */   public int skillbagid;
/*    */   public int level;
/*    */   
/*    */   public MenPaiSkillBagInfo() {}
/*    */   
/*    */   public MenPaiSkillBagInfo(int _skillbagid_, int _level_)
/*    */   {
/* 18 */     this.skillbagid = _skillbagid_;
/* 19 */     this.level = _level_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.skillbagid);
/* 28 */     _os_.marshal(this.level);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.skillbagid = _os_.unmarshal_int();
/* 34 */     this.level = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof MenPaiSkillBagInfo)) {
/* 41 */       MenPaiSkillBagInfo _o_ = (MenPaiSkillBagInfo)_o1_;
/* 42 */       if (this.skillbagid != _o_.skillbagid) return false;
/* 43 */       if (this.level != _o_.level) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.skillbagid;
/* 52 */     _h_ += this.level;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.skillbagid).append(",");
/* 60 */     _sb_.append(this.level).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MenPaiSkillBagInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.skillbagid - _o_.skillbagid;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.level - _o_.level;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\MenPaiSkillBagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */