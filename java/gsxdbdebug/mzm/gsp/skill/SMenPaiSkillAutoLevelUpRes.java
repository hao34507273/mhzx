/*    */ package mzm.gsp.skill;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMenPaiSkillAutoLevelUpRes
/*    */   extends __SMenPaiSkillAutoLevelUpRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591629;
/*    */   public HashMap<Integer, Integer> skillmap;
/*    */   public int usesilver;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591629;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMenPaiSkillAutoLevelUpRes()
/*    */   {
/* 34 */     this.skillmap = new HashMap();
/*    */   }
/*    */   
/*    */   public SMenPaiSkillAutoLevelUpRes(HashMap<Integer, Integer> _skillmap_, int _usesilver_) {
/* 38 */     this.skillmap = _skillmap_;
/* 39 */     this.usesilver = _usesilver_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.skillmap.size());
/* 48 */     for (Map.Entry<Integer, Integer> _e_ : this.skillmap.entrySet()) {
/* 49 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 50 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 52 */     _os_.marshal(this.usesilver);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 59 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 61 */       int _v_ = _os_.unmarshal_int();
/* 62 */       this.skillmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 64 */     this.usesilver = _os_.unmarshal_int();
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SMenPaiSkillAutoLevelUpRes)) {
/* 74 */       SMenPaiSkillAutoLevelUpRes _o_ = (SMenPaiSkillAutoLevelUpRes)_o1_;
/* 75 */       if (!this.skillmap.equals(_o_.skillmap)) return false;
/* 76 */       if (this.usesilver != _o_.usesilver) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.skillmap.hashCode();
/* 85 */     _h_ += this.usesilver;
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.skillmap).append(",");
/* 93 */     _sb_.append(this.usesilver).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\SMenPaiSkillAutoLevelUpRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */