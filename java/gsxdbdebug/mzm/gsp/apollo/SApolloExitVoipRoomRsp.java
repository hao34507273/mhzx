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
/*     */ public class SApolloExitVoipRoomRsp
/*     */   extends __SApolloExitVoipRoomRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602630;
/*     */   public int retcode;
/*     */   public int voip_room_type;
/*     */   public long room_id;
/*     */   public int member_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12602630;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SApolloExitVoipRoomRsp()
/*     */   {
/*  36 */     this.retcode = 9;
/*  37 */     this.voip_room_type = 1;
/*  38 */     this.room_id = 0L;
/*  39 */     this.member_id = 0;
/*     */   }
/*     */   
/*     */   public SApolloExitVoipRoomRsp(int _retcode_, int _voip_room_type_, long _room_id_, int _member_id_) {
/*  43 */     this.retcode = _retcode_;
/*  44 */     this.voip_room_type = _voip_room_type_;
/*  45 */     this.room_id = _room_id_;
/*  46 */     this.member_id = _member_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.retcode);
/*  55 */     _os_.marshal(this.voip_room_type);
/*  56 */     _os_.marshal(this.room_id);
/*  57 */     _os_.marshal(this.member_id);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.retcode = _os_.unmarshal_int();
/*  63 */     this.voip_room_type = _os_.unmarshal_int();
/*  64 */     this.room_id = _os_.unmarshal_long();
/*  65 */     this.member_id = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SApolloExitVoipRoomRsp)) {
/*  75 */       SApolloExitVoipRoomRsp _o_ = (SApolloExitVoipRoomRsp)_o1_;
/*  76 */       if (this.retcode != _o_.retcode) return false;
/*  77 */       if (this.voip_room_type != _o_.voip_room_type) return false;
/*  78 */       if (this.room_id != _o_.room_id) return false;
/*  79 */       if (this.member_id != _o_.member_id) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.retcode;
/*  88 */     _h_ += this.voip_room_type;
/*  89 */     _h_ += (int)this.room_id;
/*  90 */     _h_ += this.member_id;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.retcode).append(",");
/*  98 */     _sb_.append(this.voip_room_type).append(",");
/*  99 */     _sb_.append(this.room_id).append(",");
/* 100 */     _sb_.append(this.member_id).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SApolloExitVoipRoomRsp _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.retcode - _o_.retcode;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.voip_room_type - _o_.voip_room_type;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = Long.signum(this.room_id - _o_.room_id);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.member_id - _o_.member_id;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\SApolloExitVoipRoomRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */