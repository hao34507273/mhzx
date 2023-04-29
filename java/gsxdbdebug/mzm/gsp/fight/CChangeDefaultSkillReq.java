/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.fight.main.PChangeDefaultSkillReq;
/*     */ 
/*     */ 
/*     */ public class CChangeDefaultSkillReq
/*     */   extends __CChangeDefaultSkillReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594178;
/*     */   public long roleid;
/*     */   public long uuid;
/*     */   public int skill;
/*     */   public int fighter_type;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PChangeDefaultSkillReq(roleid, this.uuid, this.skill, this.fighter_type));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12594178;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChangeDefaultSkillReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CChangeDefaultSkillReq(long _roleid_, long _uuid_, int _skill_, int _fighter_type_)
/*     */   {
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.uuid = _uuid_;
/*  43 */     this.skill = _skill_;
/*  44 */     this.fighter_type = _fighter_type_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.uuid);
/*  54 */     _os_.marshal(this.skill);
/*  55 */     _os_.marshal(this.fighter_type);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.roleid = _os_.unmarshal_long();
/*  61 */     this.uuid = _os_.unmarshal_long();
/*  62 */     this.skill = _os_.unmarshal_int();
/*  63 */     this.fighter_type = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CChangeDefaultSkillReq)) {
/*  73 */       CChangeDefaultSkillReq _o_ = (CChangeDefaultSkillReq)_o1_;
/*  74 */       if (this.roleid != _o_.roleid) return false;
/*  75 */       if (this.uuid != _o_.uuid) return false;
/*  76 */       if (this.skill != _o_.skill) return false;
/*  77 */       if (this.fighter_type != _o_.fighter_type) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.roleid;
/*  86 */     _h_ += (int)this.uuid;
/*  87 */     _h_ += this.skill;
/*  88 */     _h_ += this.fighter_type;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.roleid).append(",");
/*  96 */     _sb_.append(this.uuid).append(",");
/*  97 */     _sb_.append(this.skill).append(",");
/*  98 */     _sb_.append(this.fighter_type).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChangeDefaultSkillReq _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.skill - _o_.skill;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.fighter_type - _o_.fighter_type;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\CChangeDefaultSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */