/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class AutoFightInfo implements Marshal
/*     */ {
/*     */   public int auto_state;
/*     */   public int role_default_skill;
/*     */   public HashMap<Long, Integer> pet_default_skills;
/*     */   public HashMap<Long, Integer> child_default_skills;
/*     */   
/*     */   public AutoFightInfo()
/*     */   {
/*  17 */     this.auto_state = 0;
/*  18 */     this.role_default_skill = 0;
/*  19 */     this.pet_default_skills = new HashMap();
/*  20 */     this.child_default_skills = new HashMap();
/*     */   }
/*     */   
/*     */   public AutoFightInfo(int _auto_state_, int _role_default_skill_, HashMap<Long, Integer> _pet_default_skills_, HashMap<Long, Integer> _child_default_skills_) {
/*  24 */     this.auto_state = _auto_state_;
/*  25 */     this.role_default_skill = _role_default_skill_;
/*  26 */     this.pet_default_skills = _pet_default_skills_;
/*  27 */     this.child_default_skills = _child_default_skills_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  31 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  35 */     _os_.marshal(this.auto_state);
/*  36 */     _os_.marshal(this.role_default_skill);
/*  37 */     _os_.compact_uint32(this.pet_default_skills.size());
/*  38 */     for (Map.Entry<Long, Integer> _e_ : this.pet_default_skills.entrySet()) {
/*  39 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  40 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  42 */     _os_.compact_uint32(this.child_default_skills.size());
/*  43 */     for (Map.Entry<Long, Integer> _e_ : this.child_default_skills.entrySet()) {
/*  44 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  45 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  47 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  51 */     this.auto_state = _os_.unmarshal_int();
/*  52 */     this.role_default_skill = _os_.unmarshal_int();
/*  53 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  55 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  57 */       int _v_ = _os_.unmarshal_int();
/*  58 */       this.pet_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  62 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  64 */       int _v_ = _os_.unmarshal_int();
/*  65 */       this.child_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof AutoFightInfo)) {
/*  73 */       AutoFightInfo _o_ = (AutoFightInfo)_o1_;
/*  74 */       if (this.auto_state != _o_.auto_state) return false;
/*  75 */       if (this.role_default_skill != _o_.role_default_skill) return false;
/*  76 */       if (!this.pet_default_skills.equals(_o_.pet_default_skills)) return false;
/*  77 */       if (!this.child_default_skills.equals(_o_.child_default_skills)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.auto_state;
/*  86 */     _h_ += this.role_default_skill;
/*  87 */     _h_ += this.pet_default_skills.hashCode();
/*  88 */     _h_ += this.child_default_skills.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.auto_state).append(",");
/*  96 */     _sb_.append(this.role_default_skill).append(",");
/*  97 */     _sb_.append(this.pet_default_skills).append(",");
/*  98 */     _sb_.append(this.child_default_skills).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\AutoFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */