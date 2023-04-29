/*     */ package mzm.gsp.drawcarnival;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalConsts;
/*     */ import mzm.gsp.drawcarnival.main.DrawCarnivalOneByOneManager;
/*     */ import mzm.gsp.drawcarnival.main.PCDrawReq;
/*     */ 
/*     */ public class CDrawReq extends __CDrawReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12630017;
/*     */   public int pass_type_id;
/*     */   public int pass_count;
/*     */   public byte is_use_yuan_bao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     DrawCarnivalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID), new PCDrawReq(roleId, this.pass_type_id, this.pass_count, this.is_use_yuan_bao, true));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  35 */     return 12630017;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CDrawReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CDrawReq(int _pass_type_id_, int _pass_count_, byte _is_use_yuan_bao_)
/*     */   {
/*  46 */     this.pass_type_id = _pass_type_id_;
/*  47 */     this.pass_count = _pass_count_;
/*  48 */     this.is_use_yuan_bao = _is_use_yuan_bao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.pass_type_id);
/*  57 */     _os_.marshal(this.pass_count);
/*  58 */     _os_.marshal(this.is_use_yuan_bao);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.pass_type_id = _os_.unmarshal_int();
/*  64 */     this.pass_count = _os_.unmarshal_int();
/*  65 */     this.is_use_yuan_bao = _os_.unmarshal_byte();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CDrawReq)) {
/*  75 */       CDrawReq _o_ = (CDrawReq)_o1_;
/*  76 */       if (this.pass_type_id != _o_.pass_type_id) return false;
/*  77 */       if (this.pass_count != _o_.pass_count) return false;
/*  78 */       if (this.is_use_yuan_bao != _o_.is_use_yuan_bao) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.pass_type_id;
/*  87 */     _h_ += this.pass_count;
/*  88 */     _h_ += this.is_use_yuan_bao;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.pass_type_id).append(",");
/*  96 */     _sb_.append(this.pass_count).append(",");
/*  97 */     _sb_.append(this.is_use_yuan_bao).append(",");
/*  98 */     _sb_.append(")");
/*  99 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CDrawReq _o_) {
/* 103 */     if (_o_ == this) return 0;
/* 104 */     int _c_ = 0;
/* 105 */     _c_ = this.pass_type_id - _o_.pass_type_id;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.pass_count - _o_.pass_count;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.is_use_yuan_bao - _o_.is_use_yuan_bao;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\CDrawReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */