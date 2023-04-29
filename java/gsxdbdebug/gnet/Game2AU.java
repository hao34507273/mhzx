/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Game2AU
/*    */   extends __Game2AU__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 8039;
/*    */   public Octets userid;
/*    */   public int qtype;
/*    */   public Octets info;
/*    */   public int reserved;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 8039;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Game2AU()
/*    */   {
/* 34 */     this.userid = new Octets();
/* 35 */     this.info = new Octets();
/*    */   }
/*    */   
/*    */   public Game2AU(Octets _userid_, int _qtype_, Octets _info_, int _reserved_) {
/* 39 */     this.userid = _userid_;
/* 40 */     this.qtype = _qtype_;
/* 41 */     this.info = _info_;
/* 42 */     this.reserved = _reserved_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.userid);
/* 51 */     _os_.marshal(this.qtype);
/* 52 */     _os_.marshal(this.info);
/* 53 */     _os_.marshal(this.reserved);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.userid = _os_.unmarshal_Octets();
/* 59 */     this.qtype = _os_.unmarshal_int();
/* 60 */     this.info = _os_.unmarshal_Octets();
/* 61 */     this.reserved = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof Game2AU)) {
/* 71 */       Game2AU _o_ = (Game2AU)_o1_;
/* 72 */       if (!this.userid.equals(_o_.userid)) return false;
/* 73 */       if (this.qtype != _o_.qtype) return false;
/* 74 */       if (!this.info.equals(_o_.info)) return false;
/* 75 */       if (this.reserved != _o_.reserved) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.userid.hashCode();
/* 84 */     _h_ += this.qtype;
/* 85 */     _h_ += this.info.hashCode();
/* 86 */     _h_ += this.reserved;
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 94 */     _sb_.append(this.qtype).append(",");
/* 95 */     _sb_.append("B").append(this.info.size()).append(",");
/* 96 */     _sb_.append(this.reserved).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\Game2AU.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */