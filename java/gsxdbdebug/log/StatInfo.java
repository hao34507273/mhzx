/*    */ package log;
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
/*    */ public class StatInfo
/*    */   extends __StatInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 60;
/*    */   public int priority;
/*    */   public Octets msg;
/*    */   public Octets hostname;
/*    */   public Octets servicename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 60;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public StatInfo()
/*    */   {
/* 34 */     this.msg = new Octets();
/* 35 */     this.hostname = new Octets();
/* 36 */     this.servicename = new Octets();
/*    */   }
/*    */   
/*    */   public StatInfo(int _priority_, Octets _msg_, Octets _hostname_, Octets _servicename_) {
/* 40 */     this.priority = _priority_;
/* 41 */     this.msg = _msg_;
/* 42 */     this.hostname = _hostname_;
/* 43 */     this.servicename = _servicename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.priority);
/* 52 */     _os_.marshal(this.msg);
/* 53 */     _os_.marshal(this.hostname);
/* 54 */     _os_.marshal(this.servicename);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.priority = _os_.unmarshal_int();
/* 60 */     this.msg = _os_.unmarshal_Octets();
/* 61 */     this.hostname = _os_.unmarshal_Octets();
/* 62 */     this.servicename = _os_.unmarshal_Octets();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof StatInfo)) {
/* 72 */       StatInfo _o_ = (StatInfo)_o1_;
/* 73 */       if (this.priority != _o_.priority) return false;
/* 74 */       if (!this.msg.equals(_o_.msg)) return false;
/* 75 */       if (!this.hostname.equals(_o_.hostname)) return false;
/* 76 */       if (!this.servicename.equals(_o_.servicename)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.priority;
/* 85 */     _h_ += this.msg.hashCode();
/* 86 */     _h_ += this.hostname.hashCode();
/* 87 */     _h_ += this.servicename.hashCode();
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.priority).append(",");
/* 95 */     _sb_.append("B").append(this.msg.size()).append(",");
/* 96 */     _sb_.append("B").append(this.hostname.size()).append(",");
/* 97 */     _sb_.append("B").append(this.servicename.size()).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\log\StatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */