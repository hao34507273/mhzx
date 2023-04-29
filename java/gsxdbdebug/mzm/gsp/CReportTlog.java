/*    */ package mzm.gsp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.online.main.PReportTlog;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CReportTlog
/*    */   extends __CReportTlog__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590100;
/*    */   public Octets tlog_name;
/*    */   public Octets tlog_content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 1L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PReportTlog(roleId, this.tlog_name, this.tlog_content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12590100;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CReportTlog()
/*    */   {
/* 39 */     this.tlog_name = new Octets();
/* 40 */     this.tlog_content = new Octets();
/*    */   }
/*    */   
/*    */   public CReportTlog(Octets _tlog_name_, Octets _tlog_content_) {
/* 44 */     this.tlog_name = _tlog_name_;
/* 45 */     this.tlog_content = _tlog_content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.tlog_name);
/* 54 */     _os_.marshal(this.tlog_content);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.tlog_name = _os_.unmarshal_Octets();
/* 60 */     this.tlog_content = _os_.unmarshal_Octets();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof CReportTlog)) {
/* 70 */       CReportTlog _o_ = (CReportTlog)_o1_;
/* 71 */       if (!this.tlog_name.equals(_o_.tlog_name)) return false;
/* 72 */       if (!this.tlog_content.equals(_o_.tlog_content)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.tlog_name.hashCode();
/* 81 */     _h_ += this.tlog_content.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("B").append(this.tlog_name.size()).append(",");
/* 89 */     _sb_.append("B").append(this.tlog_content.size()).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\CReportTlog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */