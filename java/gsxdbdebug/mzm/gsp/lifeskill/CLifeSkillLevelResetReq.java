/*     */ package mzm.gsp.lifeskill;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.lifeskill.main.PCLifeSkillLevelResetReq;
/*     */ 
/*     */ 
/*     */ public class CLifeSkillLevelResetReq
/*     */   extends __CLifeSkillLevelResetReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589068;
/*     */   public int skill_bag_id;
/*     */   public long return_silver;
/*     */   public long return_banggong;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCLifeSkillLevelResetReq(roleId, this.skill_bag_id, this.return_silver, this.return_banggong));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12589068;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CLifeSkillLevelResetReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CLifeSkillLevelResetReq(int _skill_bag_id_, long _return_silver_, long _return_banggong_)
/*     */   {
/*  42 */     this.skill_bag_id = _skill_bag_id_;
/*  43 */     this.return_silver = _return_silver_;
/*  44 */     this.return_banggong = _return_banggong_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.skill_bag_id);
/*  53 */     _os_.marshal(this.return_silver);
/*  54 */     _os_.marshal(this.return_banggong);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.skill_bag_id = _os_.unmarshal_int();
/*  60 */     this.return_silver = _os_.unmarshal_long();
/*  61 */     this.return_banggong = _os_.unmarshal_long();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CLifeSkillLevelResetReq)) {
/*  71 */       CLifeSkillLevelResetReq _o_ = (CLifeSkillLevelResetReq)_o1_;
/*  72 */       if (this.skill_bag_id != _o_.skill_bag_id) return false;
/*  73 */       if (this.return_silver != _o_.return_silver) return false;
/*  74 */       if (this.return_banggong != _o_.return_banggong) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.skill_bag_id;
/*  83 */     _h_ += (int)this.return_silver;
/*  84 */     _h_ += (int)this.return_banggong;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.skill_bag_id).append(",");
/*  92 */     _sb_.append(this.return_silver).append(",");
/*  93 */     _sb_.append(this.return_banggong).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CLifeSkillLevelResetReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.skill_bag_id - _o_.skill_bag_id;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = Long.signum(this.return_silver - _o_.return_silver);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = Long.signum(this.return_banggong - _o_.return_banggong);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\CLifeSkillLevelResetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */