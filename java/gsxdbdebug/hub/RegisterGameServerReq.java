/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RegisterGameServerReq
/*     */   extends __RegisterGameServerReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 14004;
/*     */   public int serverid;
/*     */   public ArrayList<Integer> serverids;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 14004;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RegisterGameServerReq()
/*     */   {
/*  36 */     this.serverids = new ArrayList();
/*  37 */     this.reserved1 = 0;
/*  38 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public RegisterGameServerReq(int _serverid_, ArrayList<Integer> _serverids_, int _reserved1_, int _reserved2_) {
/*  42 */     this.serverid = _serverid_;
/*  43 */     this.serverids = _serverids_;
/*  44 */     this.reserved1 = _reserved1_;
/*  45 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.serverid);
/*  54 */     _os_.compact_uint32(this.serverids.size());
/*  55 */     for (Integer _v_ : this.serverids) {
/*  56 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  58 */     _os_.marshal(this.reserved1);
/*  59 */     _os_.marshal(this.reserved2);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.serverid = _os_.unmarshal_int();
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.serverids.add(Integer.valueOf(_v_));
/*     */     }
/*  70 */     this.reserved1 = _os_.unmarshal_int();
/*  71 */     this.reserved2 = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof RegisterGameServerReq)) {
/*  81 */       RegisterGameServerReq _o_ = (RegisterGameServerReq)_o1_;
/*  82 */       if (this.serverid != _o_.serverid) return false;
/*  83 */       if (!this.serverids.equals(_o_.serverids)) return false;
/*  84 */       if (this.reserved1 != _o_.reserved1) return false;
/*  85 */       if (this.reserved2 != _o_.reserved2) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.serverid;
/*  94 */     _h_ += this.serverids.hashCode();
/*  95 */     _h_ += this.reserved1;
/*  96 */     _h_ += this.reserved2;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.serverid).append(",");
/* 104 */     _sb_.append(this.serverids).append(",");
/* 105 */     _sb_.append(this.reserved1).append(",");
/* 106 */     _sb_.append(this.reserved2).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RegisterGameServerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */