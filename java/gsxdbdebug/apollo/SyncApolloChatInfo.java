/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.apollo.main.ApolloInterface;
/*     */ 
/*     */ public class SyncApolloChatInfo extends __SyncApolloChatInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12008;
/*     */   public int room_type;
/*     */   public int from_zone_id;
/*     */   public Octets content;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     ApolloInterface.onSyncApolloChatInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12008;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SyncApolloChatInfo()
/*     */   {
/*  37 */     this.content = new Octets();
/*  38 */     this.reserved1 = 0;
/*  39 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public SyncApolloChatInfo(int _room_type_, int _from_zone_id_, Octets _content_, int _reserved1_, int _reserved2_) {
/*  43 */     this.room_type = _room_type_;
/*  44 */     this.from_zone_id = _from_zone_id_;
/*  45 */     this.content = _content_;
/*  46 */     this.reserved1 = _reserved1_;
/*  47 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.room_type);
/*  56 */     _os_.marshal(this.from_zone_id);
/*  57 */     _os_.marshal(this.content);
/*  58 */     _os_.marshal(this.reserved1);
/*  59 */     _os_.marshal(this.reserved2);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.room_type = _os_.unmarshal_int();
/*  65 */     this.from_zone_id = _os_.unmarshal_int();
/*  66 */     this.content = _os_.unmarshal_Octets();
/*  67 */     this.reserved1 = _os_.unmarshal_int();
/*  68 */     this.reserved2 = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SyncApolloChatInfo)) {
/*  78 */       SyncApolloChatInfo _o_ = (SyncApolloChatInfo)_o1_;
/*  79 */       if (this.room_type != _o_.room_type) return false;
/*  80 */       if (this.from_zone_id != _o_.from_zone_id) return false;
/*  81 */       if (!this.content.equals(_o_.content)) return false;
/*  82 */       if (this.reserved1 != _o_.reserved1) return false;
/*  83 */       if (this.reserved2 != _o_.reserved2) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.room_type;
/*  92 */     _h_ += this.from_zone_id;
/*  93 */     _h_ += this.content.hashCode();
/*  94 */     _h_ += this.reserved1;
/*  95 */     _h_ += this.reserved2;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.room_type).append(",");
/* 103 */     _sb_.append(this.from_zone_id).append(",");
/* 104 */     _sb_.append("B").append(this.content.size()).append(",");
/* 105 */     _sb_.append(this.reserved1).append(",");
/* 106 */     _sb_.append(this.reserved2).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\SyncApolloChatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */