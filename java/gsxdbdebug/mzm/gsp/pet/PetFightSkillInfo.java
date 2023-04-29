/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class PetFightSkillInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public HashSet<Integer> skills;
/*    */   public HashMap<Long, Integer> pet2skill;
/*    */   
/*    */   public PetFightSkillInfo()
/*    */   {
/* 15 */     this.skills = new HashSet();
/* 16 */     this.pet2skill = new HashMap();
/*    */   }
/*    */   
/*    */   public PetFightSkillInfo(HashSet<Integer> _skills_, HashMap<Long, Integer> _pet2skill_) {
/* 20 */     this.skills = _skills_;
/* 21 */     this.pet2skill = _pet2skill_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.compact_uint32(this.skills.size());
/* 30 */     for (Integer _v_ : this.skills) {
/* 31 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 33 */     _os_.compact_uint32(this.pet2skill.size());
/* 34 */     for (Map.Entry<Long, Integer> _e_ : this.pet2skill.entrySet()) {
/* 35 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 36 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 42 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 44 */       int _v_ = _os_.unmarshal_int();
/* 45 */       this.skills.add(Integer.valueOf(_v_));
/*    */     }
/* 47 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 49 */       long _k_ = _os_.unmarshal_long();
/*    */       
/* 51 */       int _v_ = _os_.unmarshal_int();
/* 52 */       this.pet2skill.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof PetFightSkillInfo)) {
/* 60 */       PetFightSkillInfo _o_ = (PetFightSkillInfo)_o1_;
/* 61 */       if (!this.skills.equals(_o_.skills)) return false;
/* 62 */       if (!this.pet2skill.equals(_o_.pet2skill)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.skills.hashCode();
/* 71 */     _h_ += this.pet2skill.hashCode();
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.skills).append(",");
/* 79 */     _sb_.append(this.pet2skill).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\PetFightSkillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */