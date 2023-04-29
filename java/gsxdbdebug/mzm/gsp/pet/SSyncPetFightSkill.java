/*    */ package mzm.gsp.pet;
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
/*    */ 
/*    */ public class SSyncPetFightSkill
/*    */   extends __SSyncPetFightSkill__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590704;
/*    */   public HashMap<Long, Integer> pet2skill;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590704;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncPetFightSkill()
/*    */   {
/* 33 */     this.pet2skill = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncPetFightSkill(HashMap<Long, Integer> _pet2skill_) {
/* 37 */     this.pet2skill = _pet2skill_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.pet2skill.size());
/* 46 */     for (Map.Entry<Long, Integer> _e_ : this.pet2skill.entrySet()) {
/* 47 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 48 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       long _k_ = _os_.unmarshal_long();
/*    */       
/* 58 */       int _v_ = _os_.unmarshal_int();
/* 59 */       this.pet2skill.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SSyncPetFightSkill)) {
/* 70 */       SSyncPetFightSkill _o_ = (SSyncPetFightSkill)_o1_;
/* 71 */       if (!this.pet2skill.equals(_o_.pet2skill)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.pet2skill.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.pet2skill).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSyncPetFightSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */