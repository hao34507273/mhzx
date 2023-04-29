/*     */ package mzm.gsp.apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.apollo.main.PCApolloEnterLargeRoomReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CApolloEnterLargeRoomReq
/*     */   extends __CApolloEnterLargeRoomReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602628;
/*     */   public int room_type;
/*     */   public long room_context_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid == -1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleid, new PCApolloEnterLargeRoomReq(roleid, this.room_type, this.room_context_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12602628;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CApolloEnterLargeRoomReq()
/*     */   {
/*  39 */     this.room_type = 1;
/*  40 */     this.room_context_id = 0L;
/*     */   }
/*     */   
/*     */   public CApolloEnterLargeRoomReq(int _room_type_, long _room_context_id_) {
/*  44 */     this.room_type = _room_type_;
/*  45 */     this.room_context_id = _room_context_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.room_type);
/*  54 */     _os_.marshal(this.room_context_id);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.room_type = _os_.unmarshal_int();
/*  60 */     this.room_context_id = _os_.unmarshal_long();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CApolloEnterLargeRoomReq)) {
/*  70 */       CApolloEnterLargeRoomReq _o_ = (CApolloEnterLargeRoomReq)_o1_;
/*  71 */       if (this.room_type != _o_.room_type) return false;
/*  72 */       if (this.room_context_id != _o_.room_context_id) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.room_type;
/*  81 */     _h_ += (int)this.room_context_id;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.room_type).append(",");
/*  89 */     _sb_.append(this.room_context_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CApolloEnterLargeRoomReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.room_type - _o_.room_type;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.room_context_id - _o_.room_context_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\CApolloEnterLargeRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */