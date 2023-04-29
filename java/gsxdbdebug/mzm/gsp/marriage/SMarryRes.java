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
/*    */ public class SMarryRes
/*    */   extends __SMarryRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599823;
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   public int level;
/*    */   public long sessionid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599823;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMarryRes()
/*    */   {
/* 36 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public SMarryRes(long _roleid_, String _rolename_, int _level_, long _sessionid_) {
/* 40 */     this.roleid = _roleid_;
/* 41 */     this.rolename = _rolename_;
/* 42 */     this.level = _level_;
/* 43 */     this.sessionid = _sessionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.roleid);
/* 52 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 53 */     _os_.marshal(this.level);
/* 54 */     _os_.marshal(this.sessionid);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.roleid = _os_.unmarshal_long();
/* 60 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 61 */     this.level = _os_.unmarshal_int();
/* 62 */     this.sessionid = _os_.unmarshal_long();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SMarryRes)) {
/* 72 */       SMarryRes _o_ = (SMarryRes)_o1_;
/* 73 */       if (this.roleid != _o_.roleid) return false;
/* 74 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 75 */       if (this.level != _o_.level) return false;
/* 76 */       if (this.sessionid != _o_.sessionid) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.roleid;
/* 85 */     _h_ += this.rolename.hashCode();
/* 86 */     _h_ += this.level;
/* 87 */     _h_ += (int)this.sessionid;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.roleid).append(",");
/* 95 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 96 */     _sb_.append(this.level).append(",");
/* 97 */     _sb_.append(this.sessionid).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SMarryRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */