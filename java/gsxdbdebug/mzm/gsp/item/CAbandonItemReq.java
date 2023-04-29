/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PAbandonItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CAbandonItemReq
/*     */   extends __CAbandonItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584761;
/*     */   public int bagid;
/*     */   public long uuid;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleId, new PAbandonItem(roleId, this.bagid, this.uuid, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12584761;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAbandonItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAbandonItemReq(int _bagid_, long _uuid_, int _num_)
/*     */   {
/*  41 */     this.bagid = _bagid_;
/*  42 */     this.uuid = _uuid_;
/*  43 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.bagid);
/*  52 */     _os_.marshal(this.uuid);
/*  53 */     _os_.marshal(this.num);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.bagid = _os_.unmarshal_int();
/*  59 */     this.uuid = _os_.unmarshal_long();
/*  60 */     this.num = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CAbandonItemReq)) {
/*  70 */       CAbandonItemReq _o_ = (CAbandonItemReq)_o1_;
/*  71 */       if (this.bagid != _o_.bagid) return false;
/*  72 */       if (this.uuid != _o_.uuid) return false;
/*  73 */       if (this.num != _o_.num) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.bagid;
/*  82 */     _h_ += (int)this.uuid;
/*  83 */     _h_ += this.num;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.bagid).append(",");
/*  91 */     _sb_.append(this.uuid).append(",");
/*  92 */     _sb_.append(this.num).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAbandonItemReq _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.bagid - _o_.bagid;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.num - _o_.num;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CAbandonItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */