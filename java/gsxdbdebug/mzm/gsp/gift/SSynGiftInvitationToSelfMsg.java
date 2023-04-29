/*     */ package mzm.gsp.gift;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynGiftInvitationToSelfMsg
/*     */   extends __SSynGiftInvitationToSelfMsg__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12611073;
/*     */   public RoleInfo roleinfo;
/*     */   public long invitationuuid;
/*     */   public int gifttype;
/*     */   public LinkedList<String> msgargs;
/*     */   public int invitesecs;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12611073;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynGiftInvitationToSelfMsg()
/*     */   {
/*  37 */     this.roleinfo = new RoleInfo();
/*  38 */     this.msgargs = new LinkedList();
/*     */   }
/*     */   
/*     */   public SSynGiftInvitationToSelfMsg(RoleInfo _roleinfo_, long _invitationuuid_, int _gifttype_, LinkedList<String> _msgargs_, int _invitesecs_) {
/*  42 */     this.roleinfo = _roleinfo_;
/*  43 */     this.invitationuuid = _invitationuuid_;
/*  44 */     this.gifttype = _gifttype_;
/*  45 */     this.msgargs = _msgargs_;
/*  46 */     this.invitesecs = _invitesecs_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     if (!this.roleinfo._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.roleinfo);
/*  56 */     _os_.marshal(this.invitationuuid);
/*  57 */     _os_.marshal(this.gifttype);
/*  58 */     _os_.compact_uint32(this.msgargs.size());
/*  59 */     for (String _v_ : this.msgargs) {
/*  60 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  62 */     _os_.marshal(this.invitesecs);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.roleinfo.unmarshal(_os_);
/*  68 */     this.invitationuuid = _os_.unmarshal_long();
/*  69 */     this.gifttype = _os_.unmarshal_int();
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  72 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  73 */       this.msgargs.add(_v_);
/*     */     }
/*  75 */     this.invitesecs = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SSynGiftInvitationToSelfMsg)) {
/*  85 */       SSynGiftInvitationToSelfMsg _o_ = (SSynGiftInvitationToSelfMsg)_o1_;
/*  86 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/*  87 */       if (this.invitationuuid != _o_.invitationuuid) return false;
/*  88 */       if (this.gifttype != _o_.gifttype) return false;
/*  89 */       if (!this.msgargs.equals(_o_.msgargs)) return false;
/*  90 */       if (this.invitesecs != _o_.invitesecs) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.roleinfo.hashCode();
/*  99 */     _h_ += (int)this.invitationuuid;
/* 100 */     _h_ += this.gifttype;
/* 101 */     _h_ += this.msgargs.hashCode();
/* 102 */     _h_ += this.invitesecs;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.roleinfo).append(",");
/* 110 */     _sb_.append(this.invitationuuid).append(",");
/* 111 */     _sb_.append(this.gifttype).append(",");
/* 112 */     _sb_.append(this.msgargs).append(",");
/* 113 */     _sb_.append(this.invitesecs).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\SSynGiftInvitationToSelfMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */