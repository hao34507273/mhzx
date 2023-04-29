/*     */ package mzm.gsp.cookiecake;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.cookiecake.main.PCCreateItemReq;
/*     */ 
/*     */ 
/*     */ public class CCreateItemReq
/*     */   extends __CCreateItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623874;
/*     */   public static final int CREATE_ONE = 1;
/*     */   public static final int CREATE_ALL = 2;
/*     */   public int activity_id;
/*     */   public int create_item_id;
/*     */   public int action_type;
/*     */   
/*     */   protected void process()
/*     */   {
/*  21 */     long roleId = Role.getRoleId(this);
/*  22 */     if (roleId < 1L)
/*     */     {
/*  24 */       return;
/*     */     }
/*  26 */     Role.addRoleProcedure(roleId, new PCCreateItemReq(roleId, this.activity_id, this.create_item_id, this.action_type));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  36 */     return 12623874;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CCreateItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CCreateItemReq(int _activity_id_, int _create_item_id_, int _action_type_)
/*     */   {
/*  50 */     this.activity_id = _activity_id_;
/*  51 */     this.create_item_id = _create_item_id_;
/*  52 */     this.action_type = _action_type_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.activity_id);
/*  61 */     _os_.marshal(this.create_item_id);
/*  62 */     _os_.marshal(this.action_type);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.activity_id = _os_.unmarshal_int();
/*  68 */     this.create_item_id = _os_.unmarshal_int();
/*  69 */     this.action_type = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CCreateItemReq)) {
/*  79 */       CCreateItemReq _o_ = (CCreateItemReq)_o1_;
/*  80 */       if (this.activity_id != _o_.activity_id) return false;
/*  81 */       if (this.create_item_id != _o_.create_item_id) return false;
/*  82 */       if (this.action_type != _o_.action_type) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.activity_id;
/*  91 */     _h_ += this.create_item_id;
/*  92 */     _h_ += this.action_type;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.activity_id).append(",");
/* 100 */     _sb_.append(this.create_item_id).append(",");
/* 101 */     _sb_.append(this.action_type).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CCreateItemReq _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.activity_id - _o_.activity_id;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.create_item_id - _o_.create_item_id;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.action_type - _o_.action_type;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cookiecake\CCreateItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */