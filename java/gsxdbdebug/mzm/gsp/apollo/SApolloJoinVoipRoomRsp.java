/*     */ package mzm.gsp.apollo;
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
/*     */ public class SApolloJoinVoipRoomRsp
/*     */   extends __SApolloJoinVoipRoomRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602627;
/*     */   public int retcode;
/*     */   public int voip_room_type;
/*     */   public long room_id;
/*     */   public VoipRoomUserAccess user_access;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12602627;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SApolloJoinVoipRoomRsp()
/*     */   {
/*  36 */     this.retcode = 9;
/*  37 */     this.voip_room_type = 1;
/*  38 */     this.room_id = 0L;
/*  39 */     this.user_access = new VoipRoomUserAccess();
/*     */   }
/*     */   
/*     */   public SApolloJoinVoipRoomRsp(int _retcode_, int _voip_room_type_, long _room_id_, VoipRoomUserAccess _user_access_) {
/*  43 */     this.retcode = _retcode_;
/*  44 */     this.voip_room_type = _voip_room_type_;
/*  45 */     this.room_id = _room_id_;
/*  46 */     this.user_access = _user_access_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     if (!this.user_access._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.retcode);
/*  56 */     _os_.marshal(this.voip_room_type);
/*  57 */     _os_.marshal(this.room_id);
/*  58 */     _os_.marshal(this.user_access);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.retcode = _os_.unmarshal_int();
/*  64 */     this.voip_room_type = _os_.unmarshal_int();
/*  65 */     this.room_id = _os_.unmarshal_long();
/*  66 */     this.user_access.unmarshal(_os_);
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SApolloJoinVoipRoomRsp)) {
/*  76 */       SApolloJoinVoipRoomRsp _o_ = (SApolloJoinVoipRoomRsp)_o1_;
/*  77 */       if (this.retcode != _o_.retcode) return false;
/*  78 */       if (this.voip_room_type != _o_.voip_room_type) return false;
/*  79 */       if (this.room_id != _o_.room_id) return false;
/*  80 */       if (!this.user_access.equals(_o_.user_access)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.retcode;
/*  89 */     _h_ += this.voip_room_type;
/*  90 */     _h_ += (int)this.room_id;
/*  91 */     _h_ += this.user_access.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.retcode).append(",");
/*  99 */     _sb_.append(this.voip_room_type).append(",");
/* 100 */     _sb_.append(this.room_id).append(",");
/* 101 */     _sb_.append(this.user_access).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\SApolloJoinVoipRoomRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */