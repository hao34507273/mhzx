/*    */ package mzm.gsp.xiulian;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
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
/*    */ public class SSyncXiuLainSkillBagInfo
/*    */   extends __SSyncXiuLainSkillBagInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589569;
/*    */   public LinkedList<SkillBagInfo> skillbaglist;
/*    */   public int defaultskill;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589569;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncXiuLainSkillBagInfo()
/*    */   {
/* 34 */     this.skillbaglist = new LinkedList();
/*    */   }
/*    */   
/*    */   public SSyncXiuLainSkillBagInfo(LinkedList<SkillBagInfo> _skillbaglist_, int _defaultskill_) {
/* 38 */     this.skillbaglist = _skillbaglist_;
/* 39 */     this.defaultskill = _defaultskill_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (SkillBagInfo _v_ : this.skillbaglist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.skillbaglist.size());
/* 50 */     for (SkillBagInfo _v_ : this.skillbaglist) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     _os_.marshal(this.defaultskill);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 59 */       SkillBagInfo _v_ = new SkillBagInfo();
/* 60 */       _v_.unmarshal(_os_);
/* 61 */       this.skillbaglist.add(_v_);
/*    */     }
/* 63 */     this.defaultskill = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SSyncXiuLainSkillBagInfo)) {
/* 73 */       SSyncXiuLainSkillBagInfo _o_ = (SSyncXiuLainSkillBagInfo)_o1_;
/* 74 */       if (!this.skillbaglist.equals(_o_.skillbaglist)) return false;
/* 75 */       if (this.defaultskill != _o_.defaultskill) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.skillbaglist.hashCode();
/* 84 */     _h_ += this.defaultskill;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.skillbaglist).append(",");
/* 92 */     _sb_.append(this.defaultskill).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\SSyncXiuLainSkillBagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */