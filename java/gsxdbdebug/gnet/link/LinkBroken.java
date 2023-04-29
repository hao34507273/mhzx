/*    */ package gnet.link;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ 
/*    */ public class LinkBroken extends __LinkBroken__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 1048586;
/*    */   public static final int REASON_PEERCLOSE = 0;
/*    */   public Octets userid;
/*    */   public int linksid;
/*    */   public int reason;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     String userid = this.userid.getString("UTF-8");
/* 18 */     LoginManager.getInstance().addLogicRunnable(userid, new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 22 */         Onlines.getInstance().process(LinkBroken.this);
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 1048586;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public LinkBroken()
/*    */   {
/* 42 */     this.userid = new Octets();
/*    */   }
/*    */   
/*    */   public LinkBroken(Octets _userid_, int _linksid_, int _reason_) {
/* 46 */     this.userid = _userid_;
/* 47 */     this.linksid = _linksid_;
/* 48 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 56 */     _os_.marshal(this.userid);
/* 57 */     _os_.marshal(this.linksid);
/* 58 */     _os_.marshal(this.reason);
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 63 */     this.userid = _os_.unmarshal_Octets();
/* 64 */     this.linksid = _os_.unmarshal_int();
/* 65 */     this.reason = _os_.unmarshal_int();
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof LinkBroken)) {
/* 75 */       LinkBroken _o_ = (LinkBroken)_o1_;
/* 76 */       if (!this.userid.equals(_o_.userid)) return false;
/* 77 */       if (this.linksid != _o_.linksid) return false;
/* 78 */       if (this.reason != _o_.reason) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.userid.hashCode();
/* 87 */     _h_ += this.linksid;
/* 88 */     _h_ += this.reason;
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 96 */     _sb_.append(this.linksid).append(",");
/* 97 */     _sb_.append(this.reason).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\LinkBroken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */