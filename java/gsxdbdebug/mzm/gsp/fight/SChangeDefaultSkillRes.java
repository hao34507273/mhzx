/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SChangeDefaultSkillRes
/*     */   extends __SChangeDefaultSkillRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594191;
/*     */   public long roleid;
/*     */   public long uuid;
/*     */   public int skill;
/*     */   public int fighter_type;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594191;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChangeDefaultSkillRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SChangeDefaultSkillRes(long _roleid_, long _uuid_, int _skill_, int _fighter_type_)
/*     */   {
/*  39 */     this.roleid = _roleid_;
/*  40 */     this.uuid = _uuid_;
/*  41 */     this.skill = _skill_;
/*  42 */     this.fighter_type = _fighter_type_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.roleid);
/*  51 */     _os_.marshal(this.uuid);
/*  52 */     _os_.marshal(this.skill);
/*  53 */     _os_.marshal(this.fighter_type);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.roleid = _os_.unmarshal_long();
/*  59 */     this.uuid = _os_.unmarshal_long();
/*  60 */     this.skill = _os_.unmarshal_int();
/*  61 */     this.fighter_type = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SChangeDefaultSkillRes)) {
/*  71 */       SChangeDefaultSkillRes _o_ = (SChangeDefaultSkillRes)_o1_;
/*  72 */       if (this.roleid != _o_.roleid) return false;
/*  73 */       if (this.uuid != _o_.uuid) return false;
/*  74 */       if (this.skill != _o_.skill) return false;
/*  75 */       if (this.fighter_type != _o_.fighter_type) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.roleid;
/*  84 */     _h_ += (int)this.uuid;
/*  85 */     _h_ += this.skill;
/*  86 */     _h_ += this.fighter_type;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.roleid).append(",");
/*  94 */     _sb_.append(this.uuid).append(",");
/*  95 */     _sb_.append(this.skill).append(",");
/*  96 */     _sb_.append(this.fighter_type).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChangeDefaultSkillRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.skill - _o_.skill;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.fighter_type - _o_.fighter_type;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SChangeDefaultSkillRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */