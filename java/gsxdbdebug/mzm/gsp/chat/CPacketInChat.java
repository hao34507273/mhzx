/*     */ package mzm.gsp.chat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.chat.main.PCPacketInChat;
/*     */ 
/*     */ 
/*     */ public class CPacketInChat
/*     */   extends __CPacketInChat__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585226;
/*     */   public long checkedroleid;
/*     */   public int packettype;
/*     */   public PacketInfo packetinfo;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCPacketInChat(roleId, this.checkedroleid, this.packettype, this.packetinfo));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12585226;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CPacketInChat()
/*     */   {
/*  39 */     this.packetinfo = new PacketInfo();
/*     */   }
/*     */   
/*     */   public CPacketInChat(long _checkedroleid_, int _packettype_, PacketInfo _packetinfo_) {
/*  43 */     this.checkedroleid = _checkedroleid_;
/*  44 */     this.packettype = _packettype_;
/*  45 */     this.packetinfo = _packetinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     if (!this.packetinfo._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.checkedroleid);
/*  55 */     _os_.marshal(this.packettype);
/*  56 */     _os_.marshal(this.packetinfo);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.checkedroleid = _os_.unmarshal_long();
/*  62 */     this.packettype = _os_.unmarshal_int();
/*  63 */     this.packetinfo.unmarshal(_os_);
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CPacketInChat)) {
/*  73 */       CPacketInChat _o_ = (CPacketInChat)_o1_;
/*  74 */       if (this.checkedroleid != _o_.checkedroleid) return false;
/*  75 */       if (this.packettype != _o_.packettype) return false;
/*  76 */       if (!this.packetinfo.equals(_o_.packetinfo)) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += (int)this.checkedroleid;
/*  85 */     _h_ += this.packettype;
/*  86 */     _h_ += this.packetinfo.hashCode();
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.checkedroleid).append(",");
/*  94 */     _sb_.append(this.packettype).append(",");
/*  95 */     _sb_.append(this.packetinfo).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPacketInChat _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = Long.signum(this.checkedroleid - _o_.checkedroleid);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.packettype - _o_.packettype;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.packetinfo.compareTo(_o_.packetinfo);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CPacketInChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */