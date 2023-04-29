/*    */ package mzm.gsp.qmhw;
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
/*    */ 
/*    */ public class SBrocastContinueWin
/*    */   extends __SBrocastContinueWin__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601872;
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   public int count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601872;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBrocastContinueWin()
/*    */   {
/* 35 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public SBrocastContinueWin(long _roleid_, String _rolename_, int _count_) {
/* 39 */     this.roleid = _roleid_;
/* 40 */     this.rolename = _rolename_;
/* 41 */     this.count = _count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.roleid);
/* 50 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 51 */     _os_.marshal(this.count);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.roleid = _os_.unmarshal_long();
/* 57 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 58 */     this.count = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SBrocastContinueWin)) {
/* 68 */       SBrocastContinueWin _o_ = (SBrocastContinueWin)_o1_;
/* 69 */       if (this.roleid != _o_.roleid) return false;
/* 70 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 71 */       if (this.count != _o_.count) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.roleid;
/* 80 */     _h_ += this.rolename.hashCode();
/* 81 */     _h_ += this.count;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.roleid).append(",");
/* 89 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 90 */     _sb_.append(this.count).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\SBrocastContinueWin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */