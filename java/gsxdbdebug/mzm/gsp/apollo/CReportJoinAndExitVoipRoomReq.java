/*     */ package mzm.gsp.apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.apollo.main.PCReportJoinAndExitVoipRoomReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CReportJoinAndExitVoipRoomReq
/*     */   extends __CReportJoinAndExitVoipRoomReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602642;
/*     */   public int voip_room_type;
/*     */   public int action;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleid, new PCReportJoinAndExitVoipRoomReq(roleid, this.voip_room_type, this.action));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12602642;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CReportJoinAndExitVoipRoomReq()
/*     */   {
/*  40 */     this.action = 1;
/*     */   }
/*     */   
/*     */   public CReportJoinAndExitVoipRoomReq(int _voip_room_type_, int _action_) {
/*  44 */     this.voip_room_type = _voip_room_type_;
/*  45 */     this.action = _action_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.voip_room_type);
/*  54 */     _os_.marshal(this.action);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.voip_room_type = _os_.unmarshal_int();
/*  60 */     this.action = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CReportJoinAndExitVoipRoomReq)) {
/*  70 */       CReportJoinAndExitVoipRoomReq _o_ = (CReportJoinAndExitVoipRoomReq)_o1_;
/*  71 */       if (this.voip_room_type != _o_.voip_room_type) return false;
/*  72 */       if (this.action != _o_.action) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.voip_room_type;
/*  81 */     _h_ += this.action;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.voip_room_type).append(",");
/*  89 */     _sb_.append(this.action).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReportJoinAndExitVoipRoomReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.voip_room_type - _o_.voip_room_type;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.action - _o_.action;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\CReportJoinAndExitVoipRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */