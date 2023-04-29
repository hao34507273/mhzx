/*    */ package mzm.gsp.skill;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMenPaiLevelUpRes
/*    */   extends __SMenPaiLevelUpRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591620;
/*    */   public MenPaiSkillBagInfo skillbaginfo;
/*    */   public int usesilver;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591620;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMenPaiLevelUpRes()
/*    */   {
/* 34 */     this.skillbaginfo = new MenPaiSkillBagInfo();
/*    */   }
/*    */   
/*    */   public SMenPaiLevelUpRes(MenPaiSkillBagInfo _skillbaginfo_, int _usesilver_) {
/* 38 */     this.skillbaginfo = _skillbaginfo_;
/* 39 */     this.usesilver = _usesilver_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.skillbaginfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.skillbaginfo);
/* 49 */     _os_.marshal(this.usesilver);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.skillbaginfo.unmarshal(_os_);
/* 55 */     this.usesilver = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SMenPaiLevelUpRes)) {
/* 65 */       SMenPaiLevelUpRes _o_ = (SMenPaiLevelUpRes)_o1_;
/* 66 */       if (!this.skillbaginfo.equals(_o_.skillbaginfo)) return false;
/* 67 */       if (this.usesilver != _o_.usesilver) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.skillbaginfo.hashCode();
/* 76 */     _h_ += this.usesilver;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.skillbaginfo).append(",");
/* 84 */     _sb_.append(this.usesilver).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMenPaiLevelUpRes _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.skillbaginfo.compareTo(_o_.skillbaginfo);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.usesilver - _o_.usesilver;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\SMenPaiLevelUpRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */