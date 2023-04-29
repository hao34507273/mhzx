/*     */ package mzm.gsp.npc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.npc.main.PBuyItemReq;
/*     */ 
/*     */ 
/*     */ public class CBuyItemReq
/*     */   extends __CBuyItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586757;
/*     */   public int npcid;
/*     */   public int serviceid;
/*     */   public int itemid;
/*     */   public int itemcount;
/*     */   public long clientgold;
/*     */   public long clientsilver;
/*     */   
/*     */   protected void process()
/*     */   {
/*  22 */     long roleid = Role.getRoleId(this);
/*  23 */     Role.addRoleProcedure(roleid, new PBuyItemReq(roleid, this));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12586757;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyItemReq(int _npcid_, int _serviceid_, int _itemid_, int _itemcount_, long _clientgold_, long _clientsilver_)
/*     */   {
/*  45 */     this.npcid = _npcid_;
/*  46 */     this.serviceid = _serviceid_;
/*  47 */     this.itemid = _itemid_;
/*  48 */     this.itemcount = _itemcount_;
/*  49 */     this.clientgold = _clientgold_;
/*  50 */     this.clientsilver = _clientsilver_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     if (this.itemcount < 1) return false;
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.npcid);
/*  60 */     _os_.marshal(this.serviceid);
/*  61 */     _os_.marshal(this.itemid);
/*  62 */     _os_.marshal(this.itemcount);
/*  63 */     _os_.marshal(this.clientgold);
/*  64 */     _os_.marshal(this.clientsilver);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.npcid = _os_.unmarshal_int();
/*  70 */     this.serviceid = _os_.unmarshal_int();
/*  71 */     this.itemid = _os_.unmarshal_int();
/*  72 */     this.itemcount = _os_.unmarshal_int();
/*  73 */     this.clientgold = _os_.unmarshal_long();
/*  74 */     this.clientsilver = _os_.unmarshal_long();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof CBuyItemReq)) {
/*  84 */       CBuyItemReq _o_ = (CBuyItemReq)_o1_;
/*  85 */       if (this.npcid != _o_.npcid) return false;
/*  86 */       if (this.serviceid != _o_.serviceid) return false;
/*  87 */       if (this.itemid != _o_.itemid) return false;
/*  88 */       if (this.itemcount != _o_.itemcount) return false;
/*  89 */       if (this.clientgold != _o_.clientgold) return false;
/*  90 */       if (this.clientsilver != _o_.clientsilver) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.npcid;
/*  99 */     _h_ += this.serviceid;
/* 100 */     _h_ += this.itemid;
/* 101 */     _h_ += this.itemcount;
/* 102 */     _h_ += (int)this.clientgold;
/* 103 */     _h_ += (int)this.clientsilver;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.npcid).append(",");
/* 111 */     _sb_.append(this.serviceid).append(",");
/* 112 */     _sb_.append(this.itemid).append(",");
/* 113 */     _sb_.append(this.itemcount).append(",");
/* 114 */     _sb_.append(this.clientgold).append(",");
/* 115 */     _sb_.append(this.clientsilver).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyItemReq _o_) {
/* 121 */     if (_o_ == this) return 0;
/* 122 */     int _c_ = 0;
/* 123 */     _c_ = this.npcid - _o_.npcid;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = this.serviceid - _o_.serviceid;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     _c_ = this.itemid - _o_.itemid;
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     _c_ = this.itemcount - _o_.itemcount;
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     _c_ = Long.signum(this.clientgold - _o_.clientgold);
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     _c_ = Long.signum(this.clientsilver - _o_.clientsilver);
/* 134 */     if (0 != _c_) return _c_;
/* 135 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\CBuyItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */