/*    */ package mzm.gsp.marriage;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSendMarriageMsgSucceed
/*    */   extends __SSendMarriageMsgSucceed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599822;
/*    */   public long roleid;
/*    */   public String roleidname;
/*    */   public int level;
/*    */   public int timesec;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599822;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSendMarriageMsgSucceed()
/*    */   {
/* 36 */     this.roleidname = "";
/*    */   }
/*    */   
/*    */   public SSendMarriageMsgSucceed(long _roleid_, String _roleidname_, int _level_, int _timesec_) {
/* 40 */     this.roleid = _roleid_;
/* 41 */     this.roleidname = _roleidname_;
/* 42 */     this.level = _level_;
/* 43 */     this.timesec = _timesec_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.roleid);
/* 52 */     _os_.marshal(this.roleidname, "UTF-16LE");
/* 53 */     _os_.marshal(this.level);
/* 54 */     _os_.marshal(this.timesec);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.roleid = _os_.unmarshal_long();
/* 60 */     this.roleidname = _os_.unmarshal_String("UTF-16LE");
/* 61 */     this.level = _os_.unmarshal_int();
/* 62 */     this.timesec = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SSendMarriageMsgSucceed)) {
/* 72 */       SSendMarriageMsgSucceed _o_ = (SSendMarriageMsgSucceed)_o1_;
/* 73 */       if (this.roleid != _o_.roleid) return false;
/* 74 */       if (!this.roleidname.equals(_o_.roleidname)) return false;
/* 75 */       if (this.level != _o_.level) return false;
/* 76 */       if (this.timesec != _o_.timesec) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.roleid;
/* 85 */     _h_ += this.roleidname.hashCode();
/* 86 */     _h_ += this.level;
/* 87 */     _h_ += this.timesec;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.roleid).append(",");
/* 95 */     _sb_.append("T").append(this.roleidname.length()).append(",");
/* 96 */     _sb_.append(this.level).append(",");
/* 97 */     _sb_.append(this.timesec).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SSendMarriageMsgSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */