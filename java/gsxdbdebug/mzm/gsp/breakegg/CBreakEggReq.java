/*     */ package mzm.gsp.breakegg;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.breakegg.main.PCBreakEggReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CBreakEggReq
/*     */   extends __CBreakEggReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623369;
/*     */   public int activity_id;
/*     */   public long inviter_id;
/*     */   public int index;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCBreakEggReq(roleId, this.activity_id, this.inviter_id, this.index));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12623369;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CBreakEggReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBreakEggReq(int _activity_id_, long _inviter_id_, int _index_)
/*     */   {
/*  44 */     this.activity_id = _activity_id_;
/*  45 */     this.inviter_id = _inviter_id_;
/*  46 */     this.index = _index_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_id);
/*  55 */     _os_.marshal(this.inviter_id);
/*  56 */     _os_.marshal(this.index);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_id = _os_.unmarshal_int();
/*  62 */     this.inviter_id = _os_.unmarshal_long();
/*  63 */     this.index = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CBreakEggReq)) {
/*  73 */       CBreakEggReq _o_ = (CBreakEggReq)_o1_;
/*  74 */       if (this.activity_id != _o_.activity_id) return false;
/*  75 */       if (this.inviter_id != _o_.inviter_id) return false;
/*  76 */       if (this.index != _o_.index) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.activity_id;
/*  85 */     _h_ += (int)this.inviter_id;
/*  86 */     _h_ += this.index;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_id).append(",");
/*  94 */     _sb_.append(this.inviter_id).append(",");
/*  95 */     _sb_.append(this.index).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBreakEggReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.activity_id - _o_.activity_id;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = Long.signum(this.inviter_id - _o_.inviter_id);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.index - _o_.index;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\CBreakEggReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */